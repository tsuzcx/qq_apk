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
  public static final String RES_ID_AVGAME_VOICE_RECOG_MODEL = "AVGameVoiceRecogModel";
  public static final String RES_ID_AVGAME_VOICE_RECOG_SO = "AVGameVoiceRecogSo";
  public static final String RES_ID_AV_VOICE_RECOG_MODEL = "AVVoiceRecogModel";
  public static final String RES_ID_AV_VOICE_RECOG_SO = "AVVoiceRecogSo";
  public static final String RES_TYPE_MODEL = "model";
  public static final String RES_TYPE_SO = "so";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_MODEL = "QQ8.4.8";
  public static final String RES_VERSION_AVGAME_VOICE_RECOG_SO = "QQ8.4.8";
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
    return "";
  }
  
  public static ArrayList<ResInfo> parseConfig(JSONObject paramJSONObject)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      ResInfo localResInfo;
      try
      {
        localArrayList = new ArrayList();
        if (!paramJSONObject.has("resList")) {
          break label397;
        }
        paramJSONObject = paramJSONObject.getJSONArray("resList");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label397;
        }
        localResInfo = new ResInfo();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if (localJSONObject.has("resId")) {
          localResInfo.resId = localJSONObject.getString("resId");
        }
        if (localJSONObject.has("resType")) {
          localResInfo.resType = localJSONObject.getString("resType");
        }
        if (localJSONObject.has("resVersion")) {
          localResInfo.resVersion = localJSONObject.getString("resVersion");
        }
        if (localJSONObject.has("resFileName")) {
          localResInfo.resFileName = localJSONObject.getString("resFileName");
        }
        if (localJSONObject.has("resMd5")) {
          localResInfo.resMd5 = localJSONObject.getString("resMd5");
        }
        if (localJSONObject.has("resZipUrl")) {
          localResInfo.resZipUrl = localJSONObject.getString("resZipUrl");
        }
        if (localJSONObject.has("resZipMd5")) {
          localResInfo.resZipMd5 = localJSONObject.getString("resZipMd5");
        }
        if (localJSONObject.has("isAutoDownload")) {
          localResInfo.isAutoDownload = localJSONObject.getBoolean("isAutoDownload");
        }
        if ((TextUtils.isEmpty(localResInfo.resId)) || (TextUtils.isEmpty(localResInfo.resType)) || (TextUtils.isEmpty(localResInfo.resVersion)) || (TextUtils.isEmpty(localResInfo.resZipUrl)) || (TextUtils.isEmpty(localResInfo.resZipMd5)) || (TextUtils.isEmpty(localResInfo.resFileName)) || (TextUtils.isEmpty(localResInfo.resMd5))) {
          QLog.i("ResMgr", 1, "parseJson. discard res. fileds are empty. " + localResInfo);
        } else if (!getResVersion(localResInfo.resId).equalsIgnoreCase(localResInfo.resVersion)) {
          QLog.i("ResMgr", 1, "parseJson. discard res. version is not match. " + localResInfo);
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ResMgr", 1, "parseJson failed. err: " + paramJSONObject);
        return null;
      }
      localArrayList.add(localResInfo);
      break label407;
      label397:
      QLog.i("ResMgr", 1, "parseJson successfully.");
      return localArrayList;
      label407:
      i += 1;
    }
  }
  
  public boolean parse(JSONObject paramJSONObject)
  {
    return parseConfig(paramJSONObject) != null;
  }
  
  public String toString()
  {
    return "ResInfo{resId = " + this.resId + ", resType = " + this.resType + ", resVersion = " + this.resVersion + ", resFileName = " + this.resFileName + ", resMd5 = " + this.resMd5 + ", resZipUrl = " + this.resZipUrl + ", resZipMd5 = " + this.resZipMd5 + ", isAutoDownload = " + this.isAutoDownload + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.so.ResInfo
 * JD-Core Version:    0.7.0.1
 */