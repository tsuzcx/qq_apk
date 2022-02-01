package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkMsgReplyConfigMgr
  implements IArkMsgReplyMgr
{
  public static final int ARK_REPLY_FROM_TYPE_MAP = 14;
  public static final String ARK_REPLY_FROM_TYPE_MAP_STRING = "LocationShare";
  public static final int ARK_REPLY_FROM_TYPE_MUSIC = 13;
  public static final String ARK_REPLY_FROM_TYPE_MUSIC_STRING = "music";
  public static final int ARK_REPLY_FROM_TYPE_NEWS = 11;
  public static final String ARK_REPLY_FROM_TYPE_NEWS_STRING = "news";
  public static final int ARK_REPLY_FROM_TYPE_UNKNOWN = 10;
  public static final int ARK_REPLY_FROM_TYPE_VIDEO = 12;
  public static final String ARK_REPLY_FROM_TYPE_VIDEO_STRING = "video";
  private static final String ARK_REPLY_MAP = "com.tencent.map";
  private static final String ARK_REPLY_STRUCTMSG = "com.tencent.structmsg";
  public static final String ARK_REPLY_TVALUE_MENU_CLICK = "0X800AA84";
  public static final String ARK_REPLY_TVALUE_QUOTE_CLICK = "0X800AA86";
  public static final String ARK_REPLY_TVALUE_SENDBTN_CLICK = "0X800AA85";
  public static final String JSON_PATH_SCHEME = "jsonpath:";
  public static final String TAG = "ArkMsgReplyConfigMgr";
  public static final String kArkMsgReplyConfig = "kArkMsgReplyConfig";
  private static volatile ArkMsgReplyConfigMgr sInstance;
  private LinkedHashMap<String, ArkMsgReplyConfig> mConfigs;
  
  private ArkMsgReplyConfig getConfigByAppView(String paramString1, String paramString2)
  {
    ArkMsgReplyConfig localArkMsgReplyConfig = new ArkMsgReplyConfig();
    localArkMsgReplyConfig.a = paramString1;
    localArkMsgReplyConfig.b = paramString2;
    if (!localArkMsgReplyConfig.b()) {
      return null;
    }
    return (ArkMsgReplyConfig)this.mConfigs.get(localArkMsgReplyConfig.a());
  }
  
  private String getContentByPath(JSONObject paramJSONObject, String paramString)
  {
    String str = paramString;
    try
    {
      if (isJSONPathString(paramString)) {
        str = paramString.substring(9);
      }
      paramJSONObject = new ArkJSONPath(str).a(transformJsonObjectToMap(paramJSONObject));
      if (paramJSONObject == null)
      {
        QLog.i("ArkMsgReplyConfigMgr", 1, "getContentByPath error: object == null");
        return "";
      }
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      label55:
      break label55;
    }
    QLog.i("ArkMsgReplyConfigMgr", 1, "getContentByPath exception");
    return "";
  }
  
  public static ArkMsgReplyConfigMgr getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null)
        {
          sInstance = new ArkMsgReplyConfigMgr();
          sInstance.mConfigs = new LinkedHashMap();
          sInstance.parseConfig(sInstance.loadConfig());
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private boolean isJSONPathString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("jsonpath:");
  }
  
  private JSONObject loadConfig()
  {
    Object localObject = SharePreferenceUtils.a(BaseApplication.getContext(), "kArkMsgReplyConfig");
    try
    {
      localObject = new JSONObject((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    QLog.i("ArkMsgReplyConfigMgr", 1, "loadConfig exception");
    return null;
  }
  
  private void parseConfig(JSONObject paramJSONObject)
  {
    this.mConfigs.clear();
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("messageReplyConfig");
    Object localObject = new StringBuilder("ArkMsgReplyConfigMgr=");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.i("ArkMsgReplyConfigMgr", 1, ((StringBuilder)localObject).toString());
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.optJSONObject(i);
        ArkMsgReplyConfig localArkMsgReplyConfig = new ArkMsgReplyConfig();
        localArkMsgReplyConfig.a = ((JSONObject)localObject).optString("app", "");
        localArkMsgReplyConfig.b = ((JSONObject)localObject).optString("view", "");
        localArkMsgReplyConfig.c = ((JSONObject)localObject).optString("title", "");
        localArkMsgReplyConfig.d = ((JSONObject)localObject).optString("tag", "");
        localArkMsgReplyConfig.e = ((JSONObject)localObject).optString("icon", "");
        localArkMsgReplyConfig.f = ((JSONObject)localObject).optString("action", "");
        localArkMsgReplyConfig.g = ((JSONObject)localObject).optString("jumpURL", "");
        if (!localArkMsgReplyConfig.b()) {
          QLog.i("ArkMsgReplyConfigMgr", 1, "parseConfig, item is invalid");
        } else {
          this.mConfigs.put(localArkMsgReplyConfig.a(), localArkMsgReplyConfig);
        }
        i += 1;
      }
    }
  }
  
  private void saveConfig(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    SharePreferenceUtils.a(BaseApplication.getContext(), "kArkMsgReplyConfig", paramJSONObject);
  }
  
  public static ArrayList<Object> transformJsonArrayToList(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if (localObject != null) {
          if (localObject.getClass() == JSONObject.class) {
            localArrayList.add(transformJsonObjectToMap((JSONObject)localObject));
          } else if (localObject.getClass() == JSONArray.class) {
            localArrayList.add(transformJsonArrayToList((JSONArray)localObject));
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static Map<String, Object> transformJsonObjectToMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localIterator.next());
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      if (localObject2 != null) {
        if (localObject2.getClass() == JSONObject.class) {
          localLinkedHashMap.put(localObject1, transformJsonObjectToMap((JSONObject)localObject2));
        } else if (localObject2.getClass() == JSONArray.class) {
          localLinkedHashMap.put(localObject1, transformJsonArrayToList((JSONArray)localObject2));
        } else {
          localLinkedHashMap.put(localObject1, localObject2);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public boolean canReply(String paramString1, String paramString2)
  {
    return getConfigByAppView(paramString1, paramString2) != null;
  }
  
  public Map<String, String> getReplyConfigFromMsg(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    ArkMsgReplyConfig localArkMsgReplyConfig = getConfigByAppView(str1, str2);
    if (localArkMsgReplyConfig == null)
    {
      QLog.i("ArkMsgReplyConfigMgr", 1, "getReplyConfigFromMsg: config is null, return empty map");
      return new LinkedHashMap();
    }
    if (isJSONPathString(localArkMsgReplyConfig.c)) {
      localObject1 = getContentByPath(paramJSONObject, localArkMsgReplyConfig.c);
    } else {
      localObject1 = localArkMsgReplyConfig.c;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramJSONObject.optString("prompt", "");
    }
    Object localObject1 = new LinkedHashMap();
    ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
    ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
    ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
    ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localArkMsgReplyConfig.d);
    ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localArkMsgReplyConfig.e);
    ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localArkMsgReplyConfig.f);
    if (isJSONPathString(localArkMsgReplyConfig.g)) {
      paramJSONObject = getContentByPath(paramJSONObject, localArkMsgReplyConfig.g);
    } else {
      paramJSONObject = localArkMsgReplyConfig.g;
    }
    ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
    return localObject1;
  }
  
  public int msgReplyFromType(String paramString1, String paramString2)
  {
    if (("com.tencent.structmsg".equals(paramString1)) && ("news".equals(paramString2))) {
      return 11;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("video".equals(paramString2))) {
      return 12;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("music".equals(paramString2))) {
      return 13;
    }
    if (("com.tencent.map".equals(paramString1)) && ("LocationShare".equals(paramString2))) {
      return 14;
    }
    return 10;
  }
  
  public void updateConfig(JSONObject paramJSONObject)
  {
    parseConfig(paramJSONObject);
    saveConfig(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr
 * JD-Core Version:    0.7.0.1
 */