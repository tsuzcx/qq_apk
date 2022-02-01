package com.tencent.av.so;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResInfo
  extends ConfigInfo
{
  public static final String[] ALL_RES_ID_LIST = { "AVVoiceRecogSo", "AVVoiceRecogModel", "AVGameVoiceRecogSo", "AVGameVoiceRecogModel", "AVGameVoiceRecogAILabSo", "AVGameVoiceRecogAILabModel", "AVTraeSo", "AVAINSMediaLabModel", "AVSDKSo" };
  private static final String FIELD_FOR_ARM64 = "ForArm64";
  private static final String FIELD_RES_FILE_NAME = "resFileName";
  private static final String FIELD_RES_ID = "resId";
  private static final String FIELD_RES_IS_AUTO_DOWNLOAD = "isAutoDownload";
  private static final String FIELD_RES_LIST = "resList";
  private static final String FIELD_RES_MD5 = "resMd5";
  private static final String FIELD_RES_TYPE = "resType";
  private static final String FIELD_RES_VERSION = "resVersion";
  private static final String FIELD_RES_ZIP_MD5 = "resZipMd5";
  private static final String FIELD_RES_ZIP_URL = "resZipUrl";
  public static final String RES_ID_AVGAME_VOICE_RECOG_AILAB_MODEL = "AVGameVoiceRecogAILabModel";
  public static final String RES_ID_AVGAME_VOICE_RECOG_AILAB_SO = "AVGameVoiceRecogAILabSo";
  public static final String RES_ID_AVGAME_VOICE_RECOG_MODEL = "AVGameVoiceRecogModel";
  public static final String RES_ID_AVGAME_VOICE_RECOG_SO = "AVGameVoiceRecogSo";
  public static final String RES_ID_AV_AI_NS_MEDIALAB_MODEL = "AVAINSMediaLabModel";
  public static final String RES_ID_AV_SDK_SO = "AVSDKSo";
  public static final String RES_ID_AV_TRAE_SO = "AVTraeSo";
  public static final String RES_ID_AV_VOICE_RECOG_MODEL = "AVVoiceRecogModel";
  public static final String RES_ID_AV_VOICE_RECOG_SO = "AVVoiceRecogSo";
  public static final String RES_TYPE_MODEL = "model";
  public static final String RES_TYPE_SO = "so";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_AILAB_MODEL = "QQ8.4.17";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_AILAB_SO = "QQ8.4.17";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_MODEL = "QQ8.4.8";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_SO = "QQ8.4.8";
  public static final String RES_VERSION_AV_AI_NS_MEDIALAB_MODEL = "QQ8.5.8";
  public static final String RES_VERSION_AV_SDK_SO = "QQ8.6.0";
  public static final String RES_VERSION_AV_TRAE_SO = "QQ8.6.5";
  public static final String RES_VERSION_AV_VOICE_RECOG_MODEL = "QQ8.4.8";
  public static final String RES_VERSION_AV_VOICE_RECOG_SO = "QQ8.4.8";
  public boolean isAutoDownload = true;
  public String resFileName = "";
  public String resId = "";
  public String resMd5 = "";
  public String resType = "";
  public String resVersion = "";
  public String resZipMd5 = "";
  public String resZipUrl = "";
  
  public static String getResType(String paramString)
  {
    if ("AVVoiceRecogSo".equalsIgnoreCase(paramString)) {
      return "so";
    }
    if ("AVVoiceRecogModel".equalsIgnoreCase(paramString)) {
      return "model";
    }
    if ("AVGameVoiceRecogSo".equalsIgnoreCase(paramString)) {
      return "so";
    }
    if ("AVGameVoiceRecogModel".equalsIgnoreCase(paramString)) {
      return "model";
    }
    if ("AVGameVoiceRecogAILabSo".equalsIgnoreCase(paramString)) {
      return "so";
    }
    if ("AVGameVoiceRecogAILabModel".equalsIgnoreCase(paramString)) {
      return "model";
    }
    if ("AVTraeSo".equalsIgnoreCase(paramString)) {
      return "so";
    }
    if ("AVAINSMediaLabModel".equalsIgnoreCase(paramString)) {
      return "model";
    }
    if ("AVSDKSo".equalsIgnoreCase(paramString)) {
      return "so";
    }
    return "";
  }
  
  public static String getResVersion(String paramString)
  {
    if ("AVVoiceRecogSo".equalsIgnoreCase(paramString)) {
      return "QQ8.4.8";
    }
    if ("AVVoiceRecogModel".equalsIgnoreCase(paramString)) {
      return "QQ8.4.8";
    }
    if ("AVGameVoiceRecogSo".equalsIgnoreCase(paramString)) {
      return "QQ8.4.8";
    }
    if ("AVGameVoiceRecogModel".equalsIgnoreCase(paramString)) {
      return "QQ8.4.8";
    }
    if ("AVGameVoiceRecogAILabSo".equalsIgnoreCase(paramString)) {
      return "QQ8.4.17";
    }
    if ("AVGameVoiceRecogAILabModel".equalsIgnoreCase(paramString)) {
      return "QQ8.4.17";
    }
    if ("AVTraeSo".equalsIgnoreCase(paramString)) {
      return "QQ8.6.5";
    }
    if ("AVAINSMediaLabModel".equalsIgnoreCase(paramString)) {
      return "QQ8.5.8";
    }
    if ("AVSDKSo".equalsIgnoreCase(paramString)) {
      return "QQ8.6.0";
    }
    return "";
  }
  
  public static ArrayList<ResInfo> parseConfig(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new ArrayList();
        if (paramJSONObject.has("resList"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("resList");
          i = 0;
          if (i < paramJSONObject.length())
          {
            ResInfo localResInfo = new ResInfo();
            Object localObject2 = paramJSONObject.getJSONObject(i);
            if (((JSONObject)localObject2).has("resId")) {
              localResInfo.resId = ((JSONObject)localObject2).getString("resId");
            }
            if (((JSONObject)localObject2).has("resType")) {
              localResInfo.resType = ((JSONObject)localObject2).getString("resType");
            }
            if (((JSONObject)localObject2).has("resVersion")) {
              localResInfo.resVersion = ((JSONObject)localObject2).getString("resVersion");
            }
            if (((JSONObject)localObject2).has("resFileName")) {
              localResInfo.resFileName = ((JSONObject)localObject2).getString("resFileName");
            }
            setCPUBitRelatedResInfo(localResInfo, (JSONObject)localObject2);
            if (((JSONObject)localObject2).has("isAutoDownload")) {
              localResInfo.isAutoDownload = ((JSONObject)localObject2).getBoolean("isAutoDownload");
            }
            if ((!TextUtils.isEmpty(localResInfo.resId)) && (!TextUtils.isEmpty(localResInfo.resType)) && (!TextUtils.isEmpty(localResInfo.resVersion)) && (!TextUtils.isEmpty(localResInfo.resZipUrl)) && (!TextUtils.isEmpty(localResInfo.resZipMd5)) && (!TextUtils.isEmpty(localResInfo.resFileName)) && (!TextUtils.isEmpty(localResInfo.resMd5)))
            {
              if (!getResVersion(localResInfo.resId).equalsIgnoreCase(localResInfo.resVersion))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("parseJson. discard res. version is not match. ");
                ((StringBuilder)localObject2).append(localResInfo);
                QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
                break label379;
              }
              ((ArrayList)localObject1).add(localResInfo);
              break label379;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parseJson. discard res. fileds are empty. ");
            ((StringBuilder)localObject2).append(localResInfo);
            QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
            break label379;
          }
        }
        QLog.i("AVResMgr", 1, "parseJson successfully.");
        return localObject1;
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseJson failed. err: ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        QLog.e("AVResMgr", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      label379:
      i += 1;
    }
  }
  
  private static void setCPUBitRelatedResInfo(ResInfo paramResInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("resMd5")) {
      paramResInfo.resMd5 = paramJSONObject.getString("resMd5");
    }
    if (paramJSONObject.has("resZipUrl")) {
      paramResInfo.resZipUrl = paramJSONObject.getString("resZipUrl");
    }
    if (paramJSONObject.has("resZipMd5")) {
      paramResInfo.resZipMd5 = paramJSONObject.getString("resZipMd5");
    }
  }
  
  protected boolean parse(JSONObject paramJSONObject)
  {
    return parseConfig(paramJSONObject) != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResInfo{resId = ");
    localStringBuilder.append(this.resId);
    localStringBuilder.append(", resType = ");
    localStringBuilder.append(this.resType);
    localStringBuilder.append(", resVersion = ");
    localStringBuilder.append(this.resVersion);
    localStringBuilder.append(", resFileName = ");
    localStringBuilder.append(this.resFileName);
    localStringBuilder.append(", resMd5 = ");
    localStringBuilder.append(this.resMd5);
    localStringBuilder.append(", resZipUrl = ");
    localStringBuilder.append(this.resZipUrl);
    localStringBuilder.append(", resZipMd5 = ");
    localStringBuilder.append(this.resZipMd5);
    localStringBuilder.append(", isAutoDownload = ");
    localStringBuilder.append(this.isAutoDownload);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResInfo
 * JD-Core Version:    0.7.0.1
 */