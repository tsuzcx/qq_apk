package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusParserWithHotReload
  extends ProteusParser
{
  private static final String BROADCAST_ACTION = "com.tencent.proteus.ReloadBroadcast";
  private static final String PROTEUS_DEBUG_FOLDER;
  private static final String SPLIT_FLAG = "^#^";
  private static final String TAG = "ProteusParserHotReload";
  private HashMap<String, ArrayList<String>> mComplementMap = new HashMap();
  private ArrayList<ProteusParserWithHotReload.IHotReloadChangedObserver> mHotReloadChangedObservers = new ArrayList();
  private HashMap<String, String> mHotReloadMap = new HashMap();
  private boolean mIsSupportHotReload = false;
  private HashMap<String, ComplementFileStringLoader> mPathMap = new HashMap();
  private HashMap<String, String> mTemplateBeanToStyleMap = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/ProteusDebug/");
    PROTEUS_DEBUG_FOLDER = localStringBuilder.toString();
  }
  
  private void createViewTemplateFromFile(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, String paramString1, ComplementFileStringLoader paramComplementFileStringLoader, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new JSONObject(paramString1);
    try
    {
      paramContext = getJsonStringFromFile(paramContext, paramString4);
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
    }
    parseAndCreateViewTemplate(paramBaseTemplateFactory, paramString1, paramComplementFileStringLoader, paramString2, paramString3, paramContext);
  }
  
  public static ProteusParserWithHotReload getInstance()
  {
    return ProteusParserWithHotReload.SingletonInstance.access$100();
  }
  
  private void initHotReloadMap()
  {
    if (!this.mIsSupportHotReload) {
      return;
    }
    File[] arrayOfFile = new File(PROTEUS_DEBUG_FOLDER).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfFile[i].getName();
        String str2 = str1.replace("^#^", "/");
        this.mHotReloadMap.put(str2, str1);
        i += 1;
      }
    }
  }
  
  private JSONObject maybeIncludeComponent(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject.has("$includeComponet")) {
      if (paramComplementFileStringLoader != null)
      {
        paramComplementFileStringLoader = paramComplementFileStringLoader.loadFileAsString(paramJSONObject.getString("$includeComponet"));
        localObject = paramComplementFileStringLoader;
        if (this.mIsSupportHotReload)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(paramJSONObject.getString("$includeComponet"));
          paramString2 = ((StringBuilder)localObject).toString();
          paramJSONObject = paramComplementFileStringLoader;
          if (!this.mHotReloadMap.containsKey(paramString2)) {}
        }
      }
    }
    try
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(PROTEUS_DEBUG_FOLDER);
      paramJSONObject.append((String)this.mHotReloadMap.get(paramString2));
      paramJSONObject = readInputStreamAsString(new FileInputStream(new File(paramJSONObject.toString())));
    }
    catch (FileNotFoundException paramJSONObject)
    {
      label156:
      break label156;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append(" proteus hot-reload file not found error: ");
    paramJSONObject.append(PROTEUS_DEBUG_FOLDER);
    paramJSONObject.append((String)this.mHotReloadMap.get(paramString2));
    LogUtil.QLog.e("readinjoy.proteus", 2, paramJSONObject.toString());
    paramJSONObject = paramComplementFileStringLoader;
    paramComplementFileStringLoader = this.mComplementMap;
    localObject = paramJSONObject;
    if (paramComplementFileStringLoader != null)
    {
      if (paramComplementFileStringLoader.get(paramString2) == null)
      {
        paramComplementFileStringLoader = new ArrayList();
        this.mComplementMap.put(paramString2, paramComplementFileStringLoader);
      }
      localObject = paramJSONObject;
      if (!((ArrayList)this.mComplementMap.get(paramString2)).contains(paramString1))
      {
        ((ArrayList)this.mComplementMap.get(paramString2)).add(paramString1);
        localObject = paramJSONObject;
      }
    }
    if (localObject != null) {
      return new JSONObject((String)localObject);
    }
    localObject = null;
    return localObject;
  }
  
  private void parseAndCreateViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3)
  {
    int i = paramBaseTemplateFactory.getTemplateId();
    String str = getStyleId(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(str);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramBaseTemplateFactory.createTemplate(i, str, parseItemView(paramJSONObject, paramComplementFileStringLoader, paramString1, paramString2, paramString3, localArrayList2, localArrayList1), getTemplateGloabalVar(localArrayList2, localArrayList1));
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
  
  private void parseAttr(JSONObject paramJSONObject, ViewBean paramViewBean, String paramString, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramJSONObject.keys();
    Object localObject = new ArrayMap();
    System.currentTimeMillis();
    parseDataMap((Map)localObject, paramString);
    paramString = (Map)((Map)localObject).get(paramViewBean.viewId);
    if (paramString != null)
    {
      paramString = paramString.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        putStyleMapValueKey(paramViewBean.valueBean, (String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      localObject = paramJSONObject.get(paramString);
      dealMethod(paramViewBean.valueBean, paramString, localObject, new ProteusParserWithHotReload.1(this, paramViewBean, paramString, localObject, paramArrayList));
    }
  }
  
  private void parseDataMap(Map<String, Map<String, String>> paramMap, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new JSONObject(paramString).getJSONObject("data_map");
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, getKeyValue(paramString.getJSONObject(str)));
    }
  }
  
  private ViewBean parseItemView(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
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
      else
      {
        if (((String)localObject1).equals("view_id")) {
          continue;
        }
      }
      for (;;)
      {
        if (((String)localObject1).equals("subviews"))
        {
          localObject1 = paramJSONObject.getJSONArray((String)localObject1);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject3 = maybeIncludeComponent(((JSONArray)localObject1).getJSONObject(i), paramComplementFileStringLoader, paramString1, paramString2);
            if (localObject3 != null) {
              ((List)localObject2).add(parseItemView((JSONObject)localObject3, paramComplementFileStringLoader, paramString1, paramString2, paramString3, paramArrayList1, paramArrayList2));
            }
            i += 1;
          }
          localViewBean.children = new ViewBean[((List)localObject2).size()];
          ((List)localObject2).toArray(localViewBean.children);
        }
        else if (((String)localObject1).equals("attributes"))
        {
          parseAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramString3, paramArrayList2);
        }
        else
        {
          if (!((String)localObject1).equals("data_attributes")) {
            break;
          }
          parseDataAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramArrayList2);
        }
      }
      if (((String)localObject1).equals("$includeGlobalVariable")) {
        parseIncludeGlobalFile(localObject2, paramComplementFileStringLoader, paramArrayList1);
      } else {
        parseLayoutParams((String)localObject1, localObject2, localViewBean.valueBean);
      }
    }
    return localViewBean;
  }
  
  private String readInputStreamAsString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      try
      {
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          localStringBuilder.append(str);
        }
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          Log.e("ProteusParserHotReload", "readInputStreamAsString: fail to close InputStream", paramInputStream);
        }
        Log.d("ProteusParserHotReload", "fail to read string from input stream");
      }
      finally
      {
        break label88;
      }
    }
    catch (IOException localIOException)
    {
      label70:
      break label70;
    }
    paramInputStream.close();
    return localObject.toString();
    try
    {
      label88:
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      Log.e("ProteusParserHotReload", "readInputStreamAsString: fail to close InputStream", paramInputStream);
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void addHotReloadChangedObserver(ProteusParserWithHotReload.IHotReloadChangedObserver paramIHotReloadChangedObserver)
  {
    this.mHotReloadChangedObservers.add(paramIHotReloadChangedObserver);
  }
  
  public void createViewTempFromAssets(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = getJsonStringFromFile(paramContext, paramString1);
      if (this.mIsSupportHotReload)
      {
        this.mPathMap.put(paramString1, paramComplementFileStringLoader);
        this.mTemplateBeanToStyleMap.put(paramString1, paramString3);
      }
      createViewTemplateFromFile(paramContext, paramBaseTemplateFactory, str, paramComplementFileStringLoader, paramString1, paramString2, paramString3);
      return;
    }
    catch (JSONException paramContext)
    {
      paramBaseTemplateFactory = new StringBuilder();
      paramBaseTemplateFactory.append("Json error: ");
      paramBaseTemplateFactory.append(paramContext.toString());
      Log.e("ProteusParserHotReload", paramBaseTemplateFactory.toString());
      return;
    }
    catch (IOException paramContext)
    {
      paramBaseTemplateFactory = new StringBuilder();
      paramBaseTemplateFactory.append("Fail to create view template from assets ");
      paramBaseTemplateFactory.append(paramString1);
      paramBaseTemplateFactory.append(" ");
      paramBaseTemplateFactory.append(paramContext.toString());
      Log.e("ProteusParserHotReload", paramBaseTemplateFactory.toString());
    }
  }
  
  @Deprecated
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, String paramString, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    super.createViewTemplate(paramBaseTemplateFactory, paramString, paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, String paramString1, ComplementFileStringLoader paramComplementFileStringLoader, String paramString2)
  {
    createViewTemplate(paramBaseTemplateFactory, new JSONObject(paramString1), paramComplementFileStringLoader, paramString2);
  }
  
  @Deprecated
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    super.createViewTemplate(paramBaseTemplateFactory, paramJSONObject, paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString)
  {
    parseAndCreateViewTemplate(paramBaseTemplateFactory, paramJSONObject, paramComplementFileStringLoader, "", "", paramString);
  }
  
  public void createViewTemplateFromFile(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, String paramString)
  {
    createViewTemplateFromFile(paramContext, paramBaseTemplateFactory, getJsonStringFromFile(paramContext, paramString), (ComplementFileStringLoader)this.mPathMap.get(paramString), paramString, paramString.substring(0, paramString.lastIndexOf("/")), (String)this.mTemplateBeanToStyleMap.get(paramString));
  }
  
  public void finishHotReload()
  {
    if (!this.mIsSupportHotReload) {
      return;
    }
    File[] arrayOfFile = new File(PROTEUS_DEBUG_FOLDER).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].deleteOnExit();
        i += 1;
      }
    }
  }
  
  public String getJsonStringFromFile(Context paramContext, String paramString)
  {
    if (!this.mIsSupportHotReload) {
      return readInputStreamAsString(paramContext.getAssets().open(paramString));
    }
    if ((paramContext != null) && (paramString != null))
    {
      HashMap localHashMap = this.mHotReloadMap;
      if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
      {
        paramContext = (String)this.mHotReloadMap.get(paramString);
        paramString = new StringBuilder();
        paramString.append(PROTEUS_DEBUG_FOLDER);
        paramString.append(paramContext);
        return readInputStreamAsString(new FileInputStream(new File(paramString.toString())));
      }
      return readInputStreamAsString(paramContext.getAssets().open(paramString));
    }
    return "";
  }
  
  public TemplateBean getTemplateBeanFromJson(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
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
  
  public void initHotReload(Context paramContext)
  {
    this.mIsSupportHotReload = true;
    ProteusParserWithHotReload.ProteusBroadCastReceiver localProteusBroadCastReceiver = new ProteusParserWithHotReload.ProteusBroadCastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.proteus.ReloadBroadcast");
    paramContext.registerReceiver(localProteusBroadCastReceiver, localIntentFilter);
    paramContext = new File(PROTEUS_DEBUG_FOLDER);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    initHotReloadMap();
  }
  
  public boolean isSupportHotReload()
  {
    return this.mIsSupportHotReload;
  }
  
  @Deprecated
  public void parseDataMap(String paramString)
  {
    super.parseDataMap(paramString);
  }
  
  public void removeHotReloadChangedObserver(ProteusParserWithHotReload.IHotReloadChangedObserver paramIHotReloadChangedObserver)
  {
    this.mHotReloadChangedObservers.remove(paramIHotReloadChangedObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload
 * JD-Core Version:    0.7.0.1
 */