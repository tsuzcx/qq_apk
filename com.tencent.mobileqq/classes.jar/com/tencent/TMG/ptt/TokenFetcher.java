package com.tencent.TMG.ptt;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenFetcher
{
  static final String CMD_DOWNLOAD_TOKEN = "get_voice_download_token";
  static final String CMD_UPLOAD_TOKEN = "get_voice_upload_url";
  static final String CMD_VOICE2TEXT_TOKEN = "convert_voice_to_text";
  static final String PARAMS = "sdkappid=%s&accounttype=%s&accesstoken=%s&apn=1&identifier=%s&appidat3rd=%s&contenttype=json";
  public static final String TAG = "TokenFetcher";
  static final String URL_HOST = "https://yun.tim.qq.com/v4/group_open_http_svc/";
  private static TokenFetcher s_instance;
  private TokenFetcher.AppInfo mAppInfo = null;
  private TokenFetcher.HttpRequestListener mDownloadTokenListener = new TokenFetcher.2(this);
  private TokenFetcher.HttpRequestListener mUploadTokenListener = new TokenFetcher.1(this);
  private TokenFetcher.HttpRequestListener mVoiceToTextListener = new TokenFetcher.3(this);
  
  private TokenFetcher()
  {
    TokenFetcher.AppInfo localAppInfo = this.mAppInfo;
    localAppInfo.sdk_appid = "1400029763";
    localAppInfo.appidat3rd = "1400029763";
    localAppInfo.accounttype = "12346";
    localAppInfo.accesstoken = "eJx10EFPgzAcBfA7n6LhOqN-KK1g4sFMjXMjMtnmbgRogboBHXRjzvjdt*ESe-Fd3y95yfs2EELmbBJex2labysVqS-JTXSHTMvGDjWv-oCUgkWxinDDfoEDALZ3S7Gm*F6KhkdxpnjTK5eemSYE45USmbj0mDjE9TxwNdKyVdTP-b-Tirwv-af5cDR99Luks4L5O*X7RN7gtyALV7Gv4HVd1JvPF7b2k4J4dEOSfJQPgcnBtm2DWVmMu4AtF*HDgbkDIOl0WVF3whal9fwxPuzye21SifLyDAHAlGDP0dodb1pRVz2wwSKn**Ac0-gxjgLrX78_";
    localAppInfo.identifier = "354589908";
  }
  
  public static TokenFetcher getInstance()
  {
    if (s_instance == null) {
      try
      {
        if (s_instance == null) {
          s_instance = new TokenFetcher();
        }
      }
      finally {}
    }
    return s_instance;
  }
  
  private String getUrl(String paramString)
  {
    Object localObject = this.mAppInfo;
    if (localObject == null) {
      return null;
    }
    localObject = String.format("sdkappid=%s&accounttype=%s&accesstoken=%s&apn=1&identifier=%s&appidat3rd=%s&contenttype=json", new Object[] { ((TokenFetcher.AppInfo)localObject).sdk_appid, this.mAppInfo.accounttype, this.mAppInfo.accesstoken, this.mAppInfo.identifier, this.mAppInfo.appidat3rd });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://yun.tim.qq.com/v4/group_open_http_svc/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("?");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public TokenFetcher.AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public void getDownloadToken(String paramString, TokenFetcher.GetDownloadTokenListener paramGetDownloadTokenListener)
  {
    Object localObject = this.mAppInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TokenFetcher.AppInfo)localObject).accesstoken))) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("voice_url", paramString);
        httpRequest(getUrl("get_voice_download_token"), ((JSONObject)localObject).toString(), this.mDownloadTokenListener, paramGetDownloadTokenListener);
        return;
      }
      catch (JSONException paramString)
      {
        if (paramGetDownloadTokenListener != null) {
          paramGetDownloadTokenListener.onCompleted(1, "params is invalid.", null);
        }
        paramString.printStackTrace();
        return;
      }
    }
    if (paramGetDownloadTokenListener != null) {
      paramGetDownloadTokenListener.onCompleted(12297, "getDownloadToken|appinfo is invalid.", null);
    }
  }
  
  public void getUploadToken(String paramString, TokenFetcher.GetUploadTokenListener paramGetUploadTokenListener)
  {
    Object localObject = this.mAppInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TokenFetcher.AppInfo)localObject).accesstoken))) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("voice_filename", paramString);
        httpRequest(getUrl("get_voice_upload_url"), ((JSONObject)localObject).toString(), this.mUploadTokenListener, paramGetUploadTokenListener);
        return;
      }
      catch (JSONException paramString)
      {
        if (paramGetUploadTokenListener != null) {
          paramGetUploadTokenListener.onCompleted(1, "params is invalid.", null);
        }
        paramString.printStackTrace();
        return;
      }
    }
    if (paramGetUploadTokenListener != null) {
      paramGetUploadTokenListener.onCompleted(8200, "getUploadToken|appinfo is invalid.", null);
    }
  }
  
  public void httpRequest(String paramString1, String paramString2, TokenFetcher.HttpRequestListener paramHttpRequestListener, Object paramObject)
  {
    new Thread(new TokenFetcher.4(this, paramString1, paramString2, paramHttpRequestListener, paramObject)).start();
  }
  
  public void setAppInfo(TokenFetcher.AppInfo paramAppInfo)
  {
    this.mAppInfo = paramAppInfo;
  }
  
  public void voice2Text(String paramString, TokenFetcher.Voice2TextListener paramVoice2TextListener)
  {
    Object localObject = this.mAppInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TokenFetcher.AppInfo)localObject).accesstoken))) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("voice_url", paramString);
        ((JSONObject)localObject).put("samples_per_sec", 16000);
        ((JSONObject)localObject).put("compress_type", "silk");
        ((JSONObject)localObject).put("file_type", "raw");
        httpRequest(getUrl("convert_voice_to_text"), ((JSONObject)localObject).toString(), this.mVoiceToTextListener, paramVoice2TextListener);
        return;
      }
      catch (JSONException paramString)
      {
        if (paramVoice2TextListener != null) {
          paramVoice2TextListener.onCompleted(32769, "params is invalid.", null);
        }
        paramString.printStackTrace();
        return;
      }
    }
    if (paramVoice2TextListener != null) {
      paramVoice2TextListener.onCompleted(32774, "voice2Text|appinfo is invalid.", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher
 * JD-Core Version:    0.7.0.1
 */