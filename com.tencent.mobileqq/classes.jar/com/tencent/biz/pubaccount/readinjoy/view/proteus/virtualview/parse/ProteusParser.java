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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusParser
{
  public static final String DYNAMIC_VALUE = "-1";
  public static final String DYNAMIC_VALUE_PRE = "$";
  private static final String PLATFORM = "android";
  private static final String TAG = "ProteusParser";
  private static AtomicInteger defalutId = new AtomicInteger(1);
  private Set<String> aladdinKey = new HashSet();
  private Map<String, Map<String, String>> dynamicValueKeyMap = new ArrayMap();
  private String version;
  
  private boolean check$ValueItem(ValueBean paramValueBean, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      String str = paramObject.toString();
      if (paramObject.toString().startsWith("$"))
      {
        paramValueBean.putDynamicValue(str.substring("$".length(), str.length()), paramString);
        return true;
      }
    }
    else
    {
      return deal$AttrValue(paramValueBean, paramString, paramObject);
    }
    return false;
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
    int i = 0;
    boolean bool1;
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= paramObject.length()) {
          break label155;
        }
        try
        {
          bool2 = check$ValueItem(paramValueBean, paramString, paramObject.get(i));
          bool1 |= bool2;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
        i += 1;
      }
    }
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      Iterator localIterator = paramObject.keys();
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break label155;
        }
        String str = (String)localIterator.next();
        try
        {
          bool2 = check$ValueItem(paramValueBean, paramString, paramObject.get(str));
          bool1 = bool2 | bool1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
    }
    boolean bool2 = false;
    label155:
    return bool2;
  }
  
  private void dealStyleMapArray(ValueBean paramValueBean, String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.get(i);
      if ((localObject instanceof String)) {
        paramValueBean.putDynamicValue((String)localObject, paramString1);
      }
      for (;;)
      {
        i += 1;
        break;
        dealStyleMapArray(paramValueBean, paramString1, paramString2, (JSONArray)localObject);
      }
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
        if (((String)localObject).equals("relative")) {
          paramObject.valueType = 1003;
        }
      }
      else
      {
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
      return paramObject;
    }
    return getParamValue(paramObject);
  }
  
  private int getPriority(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramString1)) {
      j = 10;
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
    j = i;
    if (!TextUtils.isEmpty(paramString4)) {
      j = i + 1000;
    }
    return j;
  }
  
  private String getStyleId(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject))
        {
          boolean bool = ((JSONObject)localObject).has("view_type");
          if (bool) {
            return str;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtil.QLog.d("readinjoy.proteus", 2, "getStyleId : " + paramJSONObject);
      }
    }
    return null;
  }
  
  public static TemplateBean getTemplateBean(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramBaseTemplateFactory == null)) {
      return null;
    }
    String str = paramJSONObject.getString("style_ID");
    paramBaseTemplateFactory = paramBaseTemplateFactory.getTemplate(str);
    if (paramBaseTemplateFactory == null)
    {
      LogUtil.QLog.e("readinjoy.proteus", 2, "proteus error : there is not Template: " + str);
      return null;
    }
    paramBaseTemplateFactory.setData(paramJSONObject);
    paramBaseTemplateFactory.getViewBean().bindData(paramJSONObject, paramBaseTemplateFactory.getViewDataBinding());
    return paramBaseTemplateFactory;
  }
  
  private static List<Integer> getVersionArr(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split("\\.");
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {
        try
        {
          localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtil.QLog.d("readinjoy.proteus", 2, "", localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private boolean isAlladinValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.aladdinKey.contains(paramString)) {
      return true;
    }
    return false;
  }
  
  private boolean isPlatformValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("android".equalsIgnoreCase(paramString)) {
      return true;
    }
    return false;
  }
  
  private boolean isStyleValid(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
  {
    boolean bool = true;
    String str1 = paramJSONObject.optString("platform");
    String str2 = paramJSONObject.optString("min_version");
    String str3 = paramJSONObject.optString("max_version");
    String str4 = paramJSONObject.optString("aladdin_key");
    if (!isPlatformValid(str1)) {}
    do
    {
      do
      {
        return false;
      } while (!isVersionValid(str2, str3));
      if (!TextUtils.isEmpty(str4)) {
        return isAlladinValid(str4);
      }
      paramJSONObject = getStyleId(paramJSONObject);
    } while (paramJSONObject == null);
    int i = getPriority(str1, str2, str3, str4);
    paramBaseTemplateFactory = paramBaseTemplateFactory.getParseData(paramJSONObject);
    if (paramBaseTemplateFactory == null) {
      return true;
    }
    if (i > paramBaseTemplateFactory.priority) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean isVersionValid(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(this.version)) {}
    List localList;
    do
    {
      return true;
      localList = getVersionArr(this.version);
      paramString1 = getVersionArr(paramString1);
      paramString2 = getVersionArr(paramString2);
      if ((!paramString1.isEmpty()) && (compare(localList, paramString1) < 0)) {
        return false;
      }
    } while ((paramString2.isEmpty()) || (compare(localList, paramString2) <= 0));
    return false;
  }
  
  private void logStyleConfig(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = getStyleId(paramJSONObject);
    localStringBuilder.append("" + str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramJSONObject.optString("min_version"));
    localStringBuilder.append(":");
    localStringBuilder.append(paramJSONObject.optString("max_version"));
    localStringBuilder.append(":");
    localStringBuilder.append(paramJSONObject.optString("aladdin_key"));
    localStringBuilder.append(":");
    localStringBuilder.append(paramJSONObject.optString("platform"));
    LogUtil.QLog.w("readinjoy.proteus", 1, "logStyleConfig: " + localStringBuilder.toString());
  }
  
  private JSONObject maybeIncludeComponent(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject.has("$includeComponet"))
    {
      if (paramComplementFileStringLoader == null) {
        break label47;
      }
      paramJSONObject = paramComplementFileStringLoader.loadFileAsString(paramJSONObject.getString("$includeComponet"));
      if (paramJSONObject != null) {
        localJSONObject = new JSONObject(paramJSONObject);
      }
    }
    else
    {
      return localJSONObject;
    }
    return null;
    label47:
    return null;
  }
  
  private void parseAttr(JSONObject paramJSONObject, ViewBean paramViewBean)
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
      dealMethod(paramViewBean.valueBean, (String)localObject1, localObject2, new ProteusParser.1(this, paramViewBean, (String)localObject1, localObject2));
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
  
  private void parseDataAttrSetRemoteData(JSONObject paramJSONObject, ViewBean paramViewBean)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      dealMethod(paramViewBean.valueBean, str, localObject, new ProteusParser.3(this, paramViewBean, str, localObject));
    }
  }
  
  private ViewBean parseItemView(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    ViewBean localViewBean = new ViewBean();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      if (paramJSONObject.has("view_id")) {
        localViewBean.viewId = paramJSONObject.getString("view_id");
      }
      if (((String)localObject1).equals("view_type"))
      {
        localObject1 = paramJSONObject.getString("view_type");
        if ((TextUtils.equals((CharSequence)localObject1, "cell")) || (TextUtils.equals((CharSequence)localObject1, "container")))
        {
          if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type"))) {
            localViewBean.viewType = "RelativeLayout";
          } else {
            localViewBean.viewType = "LinearLayout";
          }
        }
        else if (TextUtils.equals((CharSequence)localObject1, "UIView"))
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
      else if (!((String)localObject1).equals("view_id"))
      {
        if (((String)localObject1).equals("subviews"))
        {
          localObject1 = paramJSONObject.getJSONArray((String)localObject1);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject = maybeIncludeComponent(((JSONArray)localObject1).getJSONObject(i), paramComplementFileStringLoader);
            if (localJSONObject != null) {
              ((List)localObject2).add(parseItemView(localJSONObject, paramComplementFileStringLoader));
            }
            i += 1;
          }
          localViewBean.children = new ViewBean[((List)localObject2).size()];
          ((List)localObject2).toArray(localViewBean.children);
        }
        else if (((String)localObject1).equals("attributes"))
        {
          parseAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean);
        }
        else if (((String)localObject1).equals("data_attributes"))
        {
          parseDataAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean);
        }
        else
        {
          parseLayoutParams((String)localObject1, localObject2, localViewBean.valueBean);
        }
      }
    }
    dataCheck(localViewBean);
    return localViewBean;
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
      paramBaseTemplateFactory.createTemplate(i, str, parseItemView(paramJSONObject.getJSONObject(str), paramComplementFileStringLoader));
      return;
    }
    catch (IllegalArgumentException paramBaseTemplateFactory)
    {
      throw new IllegalArgumentException("问题源:" + str + paramBaseTemplateFactory.getMessage());
    }
  }
  
  void dataCheck(ViewBean paramViewBean)
  {
    if ((paramViewBean.viewId == null) && (paramViewBean.viewType != "RelativeLayout") && (paramViewBean.viewType != "LinearLayout")) {
      throw new IllegalArgumentException(" 问题原因:含未设置view_id的view");
    }
  }
  
  void dealMethod(ValueBean paramValueBean, String paramString, Object paramObject, ProteusParser.HasDynamicDataCallback paramHasDynamicDataCallback)
  {
    String str = null;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    if ((paramObject == null) || ("-1".equals(paramObject))) {
      return;
    }
    if ((str != null) && (str.startsWith("$")))
    {
      paramHasDynamicDataCallback.onCallBack(true);
      paramValueBean.putDynamicValue(str.substring("$".length(), str.length()), paramString);
      return;
    }
    paramHasDynamicDataCallback.onCallBack(deal$AttrValue(paramValueBean, paramString, paramObject));
  }
  
  Map<String, String> getKeyValue(JSONObject paramJSONObject)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramJSONObject.keys();
    label76:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = getParamValue(paramJSONObject.get(str));
      if (localObject != null) {}
      for (localObject = localObject.toString();; localObject = null)
      {
        if (localObject == null) {
          break label76;
        }
        localArrayMap.put(str, localObject);
        break;
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
    Object localObject1;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      if (paramObject.has("value")) {
        localObject1 = paramObject.getString("value");
      }
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        if (paramObject.has("type")) {
          return paramObject.getString("type");
        }
        localObject1 = paramObject.keys();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        return paramObject.getString((String)((Iterator)localObject1).next());
        if ((paramObject instanceof String)) {
          return (String)paramObject;
        }
        if (!(paramObject instanceof JSONArray)) {
          break;
        }
        localObject1 = paramObject;
      } while (!paramBoolean);
      localObject2 = ((JSONArray)paramObject).get(0);
      if ((localObject2 instanceof String)) {
        return (String)localObject2;
      }
      localObject1 = paramObject;
    } while ((localObject2 instanceof JSONArray));
    return null;
  }
  
  void parseDataAttr(JSONObject paramJSONObject, ViewBean paramViewBean)
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
        if ((localObject instanceof JSONObject))
        {
          parseDataAttrSetRemoteData((JSONObject)localObject, paramViewBean);
        }
        else if (((localObject instanceof String)) && (((String)localObject).startsWith("$")))
        {
          str = (String)localObject;
          dealMethod(paramViewBean.valueBean, "$setRemoteInfo:", localObject, new ProteusParser.2(this, paramViewBean, localObject));
        }
      }
    }
  }
  
  public void parseDataMap(String paramString)
  {
    paramString = new JSONObject(paramString);
    if (paramString.has("version"))
    {
      localObject = paramString.getString("version");
      LogUtil.QLog.d("readinjoy.proteus", 2, "proteus version : " + (String)localObject);
    }
    paramString = paramString.getJSONObject("data_map");
    Object localObject = paramString.keys();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      JSONObject localJSONObject = paramString.getJSONObject(str);
      this.dynamicValueKeyMap.put(str, getKeyValue(localJSONObject));
    }
  }
  
  void parseLayoutParams(String paramString, Object paramObject, ValueBean paramValueBean)
  {
    paramValueBean.putNomalValue(paramString, getLayoutParamValue(paramObject));
  }
  
  void putStyleMapValueKey(ValueBean paramValueBean, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (paramString2.contains("[")) {
          localJSONArray = new JSONArray(paramString2);
        }
      }
      catch (Exception localException1) {}
      try
      {
        dealStyleMapArray(paramValueBean, paramString1, paramString2, (JSONArray)localJSONArray);
        paramString2 = localJSONArray;
        paramValueBean.putAttributeDynamicValue(paramString1, paramString2);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramString2 = localJSONArray;
        }
      }
      paramValueBean.putDynamicValue(paramString2, paramString1);
      continue;
      LogUtil.QLog.e("readinjoy.proteus", 1, "style_map只支持Json字符串/数组,用$都支持:", localException1);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
 * JD-Core Version:    0.7.0.1
 */