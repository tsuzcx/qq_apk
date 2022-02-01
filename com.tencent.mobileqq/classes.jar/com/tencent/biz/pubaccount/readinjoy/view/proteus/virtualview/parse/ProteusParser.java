package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusParser
{
  public static final String DYNAMIC_VALUE = "-1";
  public static final String DYNAMIC_VALUE_PRE = "$";
  private static final String PLATFORM = "android";
  private static final String TAG = "ProteusParser";
  public static AtomicInteger defaultId = new AtomicInteger(1);
  private Set<String> aladdinKey = new HashSet();
  private Map<String, Map<String, String>> dynamicValueKeyMap = new ArrayMap();
  ArrayMap<String, Map<String, Object>> globalVarFileMapping = new ArrayMap();
  private Map<String, Object> globalVariable = new ArrayMap();
  private String version;
  
  private boolean check$ValueItem(ValueBean paramValueBean, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = paramObject.toString();
      if (paramObject.startsWith("$"))
      {
        paramValueBean.putDynamicValue(paramObject.substring(1, paramObject.length()), paramString);
        return true;
      }
      paramObject = parse$Value(paramObject);
      if (!paramObject.isEmpty())
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext()) {
          paramValueBean.putDynamicValue((String)paramObject.next(), paramString);
        }
        return true;
      }
      return false;
    }
    return deal$AttrValue(paramValueBean, paramString, paramObject);
  }
  
  private static int compare(List<Integer> paramList1, List<Integer> paramList2)
  {
    int j = Math.min(paramList1.size(), paramList2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)paramList1.get(i)).intValue() > ((Integer)paramList2.get(i)).intValue()) {
        return 1;
      }
      if (((Integer)paramList1.get(i)).intValue() < ((Integer)paramList2.get(i)).intValue()) {
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  private boolean deal$AttrValue(ValueBean paramValueBean, String paramString, Object paramObject)
  {
    boolean bool3 = paramObject instanceof JSONArray;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    if (bool3)
    {
      paramObject = (JSONArray)paramObject;
      bool1 = false;
      while (i < paramObject.length())
      {
        try
        {
          bool2 = check$ValueItem(paramValueBean, paramString, paramObject.get(i));
          bool1 |= bool2;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        i += 1;
      }
      return bool1;
    }
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      Iterator localIterator = paramObject.keys();
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        String str = (String)localIterator.next();
        try
        {
          bool2 = check$ValueItem(paramValueBean, paramString, paramObject.get(str));
          bool1 |= bool2;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    return bool2;
  }
  
  private void dealStyleMapArray(ValueBean paramValueBean, String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.get(i);
      if ((localObject instanceof String)) {
        paramValueBean.putDynamicValue((String)localObject, paramString1);
      } else {
        dealStyleMapArray(paramValueBean, paramString1, paramString2, (JSONArray)localObject);
      }
      i += 1;
    }
  }
  
  private Object getLayoutParamValue(Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      Object localObject = (JSONObject)paramObject;
      paramObject = new SizeValue();
      if (((JSONObject)localObject).has("value")) {
        paramObject.value = Double.valueOf(((JSONObject)localObject).getString("value")).doubleValue();
      }
      if (((JSONObject)localObject).has("type"))
      {
        localObject = ((JSONObject)localObject).getString("type");
        if (((String)localObject).equals("relative"))
        {
          paramObject.valueType = 1003;
          return paramObject;
        }
        if (((String)localObject).equals("absolutely"))
        {
          paramObject.valueType = 1004;
          return paramObject;
        }
        if (((String)localObject).equals("match_parent"))
        {
          paramObject.valueType = 1001;
          return paramObject;
        }
        paramObject.valueType = 1002;
      }
      return paramObject;
    }
    return getParamValue(paramObject);
  }
  
  private int getPriority(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      j = 10;
    } else {
      j = 0;
    }
    int i;
    if (TextUtils.isEmpty(paramString2))
    {
      i = j;
      if (TextUtils.isEmpty(paramString3)) {}
    }
    else
    {
      i = j + 100;
    }
    int j = i;
    if (!TextUtils.isEmpty(paramString4)) {
      j = i + 1000;
    }
    return j;
  }
  
  private int getPriority(JSONObject paramJSONObject)
  {
    return getPriority(paramJSONObject.optString("platform"), paramJSONObject.optString("min_version"), paramJSONObject.optString("max_version"), paramJSONObject.optString("aladdin_key"));
  }
  
  public static TemplateBean getTemplateBean(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramBaseTemplateFactory == null) {
        return null;
      }
      String str = paramJSONObject.getString("style_ID");
      paramBaseTemplateFactory = paramBaseTemplateFactory.getTemplate(str);
      if (paramBaseTemplateFactory == null)
      {
        paramBaseTemplateFactory = new StringBuilder();
        paramBaseTemplateFactory.append("proteus error : there is not Template: ");
        paramBaseTemplateFactory.append(str);
        LogUtil.QLog.e("readinjoy.proteus", 2, paramBaseTemplateFactory.toString());
        return null;
      }
      paramBaseTemplateFactory.bindData(paramJSONObject);
      return paramBaseTemplateFactory;
    }
    return null;
  }
  
  private static List<Integer> getVersionArr(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split("\\.");
    int i = 0;
    while (i < paramString.length)
    {
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
      }
      catch (Exception localException)
      {
        LogUtil.QLog.d("readinjoy.proteus", 2, "", localException);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean isAlladinValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return this.aladdinKey.contains(paramString);
  }
  
  private boolean isPlatformValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return "android".equalsIgnoreCase(paramString);
  }
  
  private boolean isStyleValid(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("platform");
    String str2 = paramJSONObject.optString("min_version");
    String str3 = paramJSONObject.optString("max_version");
    String str4 = paramJSONObject.optString("aladdin_key");
    if (!isPlatformValid(str1)) {
      return false;
    }
    if (!isVersionValid(str2, str3)) {
      return false;
    }
    if (!TextUtils.isEmpty(str4)) {
      return isAlladinValid(str4);
    }
    paramJSONObject = getStyleId(paramJSONObject);
    if (paramJSONObject == null) {
      return false;
    }
    int i = getPriority(str1, str2, str3, str4);
    paramBaseTemplateFactory = paramBaseTemplateFactory.getParseData(paramJSONObject);
    if (paramBaseTemplateFactory == null) {
      return true;
    }
    return i > paramBaseTemplateFactory.priority;
  }
  
  private boolean isVersionValid(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(this.version)) {
      return true;
    }
    List localList = getVersionArr(this.version);
    paramString1 = getVersionArr(paramString1);
    paramString2 = getVersionArr(paramString2);
    if ((!paramString1.isEmpty()) && (compare(localList, paramString1) < 0)) {
      return false;
    }
    return (paramString2.isEmpty()) || (compare(localList, paramString2) <= 0);
  }
  
  private void logStyleConfig(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = getStyleId(paramJSONObject);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("");
    localStringBuilder2.append(str);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(":");
    localStringBuilder1.append(paramJSONObject.optString("min_version"));
    localStringBuilder1.append(":");
    localStringBuilder1.append(paramJSONObject.optString("max_version"));
    localStringBuilder1.append(":");
    localStringBuilder1.append(paramJSONObject.optString("aladdin_key"));
    localStringBuilder1.append(":");
    localStringBuilder1.append(paramJSONObject.optString("platform"));
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("logStyleConfig: ");
    paramJSONObject.append(localStringBuilder1.toString());
    LogUtil.QLog.w("readinjoy.proteus", 1, paramJSONObject.toString());
  }
  
  private JSONObject maybeIncludeComponent(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    if (paramJSONObject.has("$includeComponet"))
    {
      if (paramComplementFileStringLoader != null)
      {
        paramJSONObject = paramComplementFileStringLoader.loadFileAsString(paramJSONObject.getString("$includeComponet"));
        if (paramJSONObject != null) {
          return new JSONObject(paramJSONObject);
        }
      }
      return null;
    }
    return paramJSONObject;
  }
  
  private ArrayList<String> parse$Value(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    trim$String(paramString, localArrayList);
    return localArrayList;
  }
  
  private void parseAttr(JSONObject paramJSONObject, ViewBean paramViewBean, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramJSONObject.keys();
    Object localObject1 = (Map)this.dynamicValueKeyMap.get(paramViewBean.viewId);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        putStyleMapValueKey(paramViewBean.valueBean, (String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      localObject2 = paramJSONObject.get((String)localObject1);
      dealMethod(paramViewBean.valueBean, (String)localObject1, localObject2, new ProteusParser.1(this, paramViewBean, (String)localObject1, localObject2, paramArrayList));
    }
  }
  
  private void parseDataAttrSetLocalData(JSONObject paramJSONObject, ViewBean paramViewBean)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      paramViewBean.valueBean.putDataAttributeLocalData(str, localObject);
    }
  }
  
  private void parseDataAttrSetRemoteData(JSONObject paramJSONObject, ViewBean paramViewBean, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      dealMethod(paramViewBean.valueBean, str, localObject, new ProteusParser.3(this, paramViewBean, str, localObject, paramArrayList));
    }
  }
  
  private ViewBean parseItemView(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    ViewBean localViewBean = new ViewBean();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      Object localObject3;
      if (paramJSONObject.has("view_id"))
      {
        localViewBean.viewId = paramJSONObject.getString("view_id");
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("$default_view_id");
        ((StringBuilder)localObject3).append(defaultId.getAndIncrement());
        localViewBean.viewId = ((StringBuilder)localObject3).toString();
      }
      if (((String)localObject1).equals("view_type"))
      {
        localObject1 = paramJSONObject.getString("view_type");
        if ((!TextUtils.equals((CharSequence)localObject1, "cell")) && (!TextUtils.equals((CharSequence)localObject1, "container")))
        {
          if (TextUtils.equals((CharSequence)localObject1, "UIView"))
          {
            if (paramJSONObject.optJSONArray("subviews") != null)
            {
              if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type"))) {
                localViewBean.viewType = "NativeRelativeLayout";
              } else {
                localViewBean.viewType = "NativeLinearLayout";
              }
            }
            else {
              localViewBean.viewType = "NativeLinearLayout";
            }
          }
          else {
            localViewBean.viewType = ((String)localObject1);
          }
        }
        else if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type"))) {
          localViewBean.viewType = "RelativeLayout";
        } else {
          localViewBean.viewType = "LinearLayout";
        }
      }
      else if (!((String)localObject1).equals("view_id"))
      {
        if (((String)localObject1).equals("subviews"))
        {
          localObject1 = paramJSONObject.getJSONArray((String)localObject1);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject3 = maybeIncludeComponent(((JSONArray)localObject1).getJSONObject(i), paramComplementFileStringLoader);
            if (localObject3 != null) {
              ((List)localObject2).add(parseItemView((JSONObject)localObject3, paramComplementFileStringLoader, paramArrayList1, paramArrayList2));
            }
            i += 1;
          }
          localViewBean.children = new ViewBean[((List)localObject2).size()];
          ((List)localObject2).toArray(localViewBean.children);
        }
        else if (((String)localObject1).equals("attributes"))
        {
          parseAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramArrayList2);
        }
        else if (((String)localObject1).equals("data_attributes"))
        {
          parseDataAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramArrayList2);
        }
        else if (((String)localObject1).equals("$includeGlobalVariable"))
        {
          parseIncludeGlobalFile(localObject2, paramComplementFileStringLoader, paramArrayList1);
        }
        else
        {
          parseLayoutParams((String)localObject1, localObject2, localViewBean.valueBean);
        }
      }
    }
    return localViewBean;
  }
  
  private void recordPriority(BaseTemplateFactory paramBaseTemplateFactory, String paramString, JSONObject paramJSONObject)
  {
    if ((paramBaseTemplateFactory != null) && (paramJSONObject != null)) {
      paramBaseTemplateFactory.getParseData(paramString).priority = getPriority(paramJSONObject);
    }
  }
  
  private void trim$String(String paramString, ArrayList<String> paramArrayList)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = Pattern.compile("\\$\\{\\w+\\}").matcher(paramString);
        while (paramString.find())
        {
          String str = paramString.group();
          paramArrayList.add(str.substring(str.indexOf('{') + 1, str.indexOf('}')));
        }
        return;
      }
      catch (Exception paramString)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("trim$String error! msg=");
        paramArrayList.append(paramString);
        LogUtil.QLog.e("readinjoy.proteus", 1, paramArrayList.toString());
      }
    }
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, String paramString, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    createViewTemplate(paramBaseTemplateFactory, new JSONObject(paramString), paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    if (!isStyleValid(paramBaseTemplateFactory, paramJSONObject))
    {
      logStyleConfig(paramJSONObject);
      return;
    }
    int i = paramBaseTemplateFactory.getTemplateId();
    String str = getStyleId(paramJSONObject);
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramBaseTemplateFactory.createTemplate(i, str, parseItemView(localJSONObject, paramComplementFileStringLoader, localArrayList2, localArrayList1), getTemplateGloabalVar(localArrayList2, localArrayList1));
      recordPriority(paramBaseTemplateFactory, str, paramJSONObject);
      return;
    }
    catch (IllegalArgumentException paramBaseTemplateFactory)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("问题源:");
      paramJSONObject.append(str);
      paramJSONObject.append(paramBaseTemplateFactory.getMessage());
      throw new IllegalArgumentException(paramJSONObject.toString());
    }
  }
  
  void dataCheck(ViewBean paramViewBean) {}
  
  void dealMethod(ValueBean paramValueBean, String paramString, Object paramObject, ProteusParser.HasDynamicDataCallback paramHasDynamicDataCallback)
  {
    String str;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    } else {
      str = null;
    }
    if (paramObject != null)
    {
      if ("-1".equals(paramObject)) {
        return;
      }
      if ((str != null) && (str.startsWith("$")))
      {
        paramHasDynamicDataCallback.onCallBack(true);
        paramValueBean.putDynamicValue(str.substring(1, str.length()), paramString);
        return;
      }
      paramHasDynamicDataCallback.onCallBack(deal$AttrValue(paramValueBean, paramString, paramObject));
    }
  }
  
  protected List<String> getDollarName(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramObject instanceof String))
    {
      localObject = (String)paramObject;
      if (((String)localObject).startsWith("$"))
      {
        localArrayList.add(((String)localObject).substring(1));
        return localArrayList;
      }
    }
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = paramObject.keys();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.addAll(getDollarName(paramObject.opt((String)((Iterator)localObject).next())));
      }
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int i = 0;
      while (i < paramObject.length())
      {
        localArrayList.addAll(getDollarName(paramObject.opt(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  Map<String, String> getKeyValue(JSONObject paramJSONObject)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = getParamValue(paramJSONObject.get(str));
      if (localObject != null) {
        localObject = localObject.toString();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        localArrayMap.put(str, localObject);
      }
    }
    return localArrayMap;
  }
  
  Object getParamValue(Object paramObject)
  {
    return getParamValue(paramObject, false);
  }
  
  protected Object getParamValue(Object paramObject, boolean paramBoolean)
  {
    Object localObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      if (paramObject.has("value")) {
        return paramObject.getString("value");
      }
      if (paramObject.has("type")) {
        return paramObject.getString("type");
      }
      localObject = paramObject.keys();
      if (((Iterator)localObject).hasNext()) {
        return paramObject.getString((String)((Iterator)localObject).next());
      }
    }
    else
    {
      if ((paramObject instanceof String)) {
        return (String)paramObject;
      }
      if ((paramObject instanceof JSONArray))
      {
        if (!paramBoolean) {
          return paramObject;
        }
        localObject = ((JSONArray)paramObject).get(0);
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        if ((localObject instanceof JSONArray)) {
          return paramObject;
        }
      }
    }
    return null;
  }
  
  protected String getStyleId(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Object localObject1 = (String)localIterator.next();
      try
      {
        Object localObject2 = paramJSONObject.get((String)localObject1);
        if (!(localObject2 instanceof JSONObject)) {
          continue;
        }
        boolean bool = ((JSONObject)localObject2).has("view_type");
        if (!bool) {
          continue;
        }
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        label64:
        break label64;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getStyleId : ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      LogUtil.QLog.d("readinjoy.proteus", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  protected ArrayMap<String, Object> getTemplateGloabalVar(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    int j = 0;
    int i = 0;
    String str;
    while (i < paramArrayList1.size())
    {
      str = (String)paramArrayList1.get(i);
      if (this.globalVarFileMapping.containsKey(str)) {
        localArrayMap.putAll((Map)this.globalVarFileMapping.get(str));
      }
      i += 1;
    }
    paramArrayList1 = new ArrayMap();
    i = j;
    while (i < paramArrayList2.size())
    {
      str = (String)paramArrayList2.get(i);
      if (localArrayMap.containsKey(str)) {
        paramArrayList1.put(str, localArrayMap.get(str));
      }
      i += 1;
    }
    return paramArrayList1;
  }
  
  void parseDataAttr(JSONObject paramJSONObject, ViewBean paramViewBean, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if ("setLocalInfo:".equals(str))
      {
        if ((localObject instanceof JSONObject)) {
          parseDataAttrSetLocalData((JSONObject)localObject, paramViewBean);
        }
      }
      else if ("setRemoteInfo:".equals(str)) {
        if ((localObject instanceof JSONObject)) {
          parseDataAttrSetRemoteData((JSONObject)localObject, paramViewBean, paramArrayList);
        } else if (((localObject instanceof String)) && (((String)localObject).startsWith("$"))) {
          dealMethod(paramViewBean.valueBean, "$setRemoteInfo:", localObject, new ProteusParser.2(this, paramViewBean, localObject, paramArrayList));
        }
      }
    }
  }
  
  public void parseDataMap(String paramString)
  {
    paramString = new JSONObject(paramString);
    Object localObject2;
    if (paramString.has("version"))
    {
      localObject1 = paramString.getString("version");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("proteus version : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtil.QLog.d("readinjoy.proteus", 2, ((StringBuilder)localObject2).toString());
    }
    paramString = paramString.getJSONObject("data_map");
    Object localObject1 = paramString.keys();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      JSONObject localJSONObject = paramString.getJSONObject((String)localObject2);
      this.dynamicValueKeyMap.put(localObject2, getKeyValue(localJSONObject));
    }
  }
  
  protected Map<String, Object> parseGlobalVariable(String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramString2 = new JSONObject(paramString2);
    Iterator localIterator = paramString2.keys();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("globaleVariable[");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("] : ");
    paramString1 = new StringBuilder(((StringBuilder)localObject1).toString());
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      Object localObject2 = paramString2.get((String)localObject1);
      if (localObject2 != null)
      {
        paramString1.append("key : ");
        paramString1.append((String)localObject1);
        paramString1.append(", value : ");
        paramString1.append(localObject2);
        paramString1.append(";");
        localArrayMap.put(localObject1, localObject2);
      }
    }
    LogUtil.QLog.d("ProteusParser", 1, paramString1.toString());
    return localArrayMap;
  }
  
  protected void parseIncludeGlobalFile(Object paramObject, ComplementFileStringLoader paramComplementFileStringLoader, ArrayList<String> paramArrayList)
  {
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (!this.globalVarFileMapping.containsKey(paramObject))
      {
        paramComplementFileStringLoader = paramComplementFileStringLoader.loadFileAsString(paramObject);
        if (!TextUtils.isEmpty(paramComplementFileStringLoader))
        {
          this.globalVarFileMapping.put(paramObject, parseGlobalVariable(paramObject, paramComplementFileStringLoader));
          paramArrayList.add(paramObject);
        }
      }
    }
  }
  
  void parseLayoutParams(String paramString, Object paramObject, ValueBean paramValueBean)
  {
    paramValueBean.putNomalValue(paramString, getLayoutParamValue(paramObject));
  }
  
  void putStyleMapValueKey(ValueBean paramValueBean, String paramString1, String paramString2)
  {
    try
    {
      if (paramString2.contains("["))
      {
        JSONArray localJSONArray = new JSONArray(paramString2);
        try
        {
          dealStyleMapArray(paramValueBean, paramString1, paramString2, (JSONArray)localJSONArray);
          paramString2 = localJSONArray;
        }
        catch (Exception paramString2)
        {
          String str = paramString2;
          paramString2 = localJSONArray;
          break label59;
        }
      }
      else
      {
        paramValueBean.putDynamicValue(paramString2, paramString1);
      }
    }
    catch (Exception localException)
    {
      label59:
      LogUtil.QLog.e("readinjoy.proteus", 1, "style_map只支持Json字符串/数组,用$都支持:", localException);
    }
    paramValueBean.putAttributeDynamicValue(paramString1, paramString2);
  }
  
  public void setAladdinKey(Set<String> paramSet)
  {
    this.aladdinKey = paramSet;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
 * JD-Core Version:    0.7.0.1
 */