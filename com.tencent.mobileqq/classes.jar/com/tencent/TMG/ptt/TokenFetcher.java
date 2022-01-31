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
  private static TokenFetcher s_instance = null;
  private TokenFetcher.AppInfo mAppInfo = null;
  private TokenFetcher.HttpRequestListener mDownloadTokenListener = new TokenFetcher.2(this);
  private TokenFetcher.HttpRequestListener mUploadTokenListener = new TokenFetcher.1(this);
  private TokenFetcher.HttpRequestListener mVoiceToTextListener = new TokenFetcher.3(this);
  
  private TokenFetcher()
  {
    this.mAppInfo.sdk_appid = "1400029763";
    this.mAppInfo.appidat3rd = "1400029763";
    this.mAppInfo.accounttype = "12346";
    this.mAppInfo.accesstoken = "eJx10EFPgzAcBfA7n6LhOqN-KK1g4sFMjXMjMtnmbgRogboBHXRjzvjdt*ESe-Fd3y95yfs2EELmbBJex2labysVqS-JTXSHTMvGDjWv-oCUgkWxinDDfoEDALZ3S7Gm*F6KhkdxpnjTK5eemSYE45USmbj0mDjE9TxwNdKyVdTP-b-Tirwv-af5cDR99Luks4L5O*X7RN7gtyALV7Gv4HVd1JvPF7b2k4J4dEOSfJQPgcnBtm2DWVmMu4AtF*HDgbkDIOl0WVF3whal9fwxPuzye21SifLyDAHAlGDP0dodb1pRVz2wwSKn**Ac0-gxjgLrX78_";
    this.mAppInfo.identifier = "354589908";
  }
  
  public static TokenFetcher getInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new TokenFetcher();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getUrl(String paramString)
  {
    if (this.mAppInfo == null) {
      return null;
    }
    String str = String.format("sdkappid=%s&accounttype=%s&accesstoken=%s&apn=1&identifier=%s&appidat3rd=%s&contenttype=json", new Object[] { this.mAppInfo.sdk_appid, this.mAppInfo.accounttype, this.mAppInfo.accesstoken, this.mAppInfo.identifier, this.mAppInfo.appidat3rd });
    return "https://yun.tim.qq.com/v4/group_open_http_svc/" + paramString + "?" + str;
  }
  
  public TokenFetcher.AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public void getDownloadToken(String paramString, TokenFetcher.GetDownloadTokenListener paramGetDownloadTokenListener)
  {
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramGetDownloadTokenListener != null) {
        paramGetDownloadTokenListener.onCompleted(12297, "getDownloadToken|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_url", paramString);
      httpRequest(getUrl("get_voice_download_token"), localJSONObject.toString(), this.mDownloadTokenListener, paramGetDownloadTokenListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramGetDownloadTokenListener != null) {
        paramGetDownloadTokenListener.onCompleted(1, "params is invalid.", null);
      }
      paramString.printStackTrace();
    }
  }
  
  public void getUploadToken(String paramString, TokenFetcher.GetUploadTokenListener paramGetUploadTokenListener)
  {
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramGetUploadTokenListener != null) {
        paramGetUploadTokenListener.onCompleted(8200, "getUploadToken|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_filename", paramString);
      httpRequest(getUrl("get_voice_upload_url"), localJSONObject.toString(), this.mUploadTokenListener, paramGetUploadTokenListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramGetUploadTokenListener != null) {
        paramGetUploadTokenListener.onCompleted(1, "params is invalid.", null);
      }
      paramString.printStackTrace();
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
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramVoice2TextListener != null) {
        paramVoice2TextListener.onCompleted(32774, "voice2Text|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_url", paramString);
      localJSONObject.put("samples_per_sec", 16000);
      localJSONObject.put("compress_type", "silk");
      localJSONObject.put("file_type", "raw");
      httpRequest(getUrl("convert_voice_to_text"), localJSONObject.toString(), this.mVoiceToTextListener, paramVoice2TextListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramVoice2TextListener != null) {
        paramVoice2TextListener.onCompleted(32769, "params is invalid.", null);
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher
 * JD-Core Version:    0.7.0.1
 */