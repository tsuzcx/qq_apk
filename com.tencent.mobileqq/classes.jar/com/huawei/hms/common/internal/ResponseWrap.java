package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseWrap
{
  private static final String TAG = "ResponseWrap";
  private String body;
  private ResponseHeader responseHeader;
  
  public ResponseWrap(ResponseHeader paramResponseHeader)
  {
    this.responseHeader = paramResponseHeader;
  }
  
  public boolean fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.responseHeader.setStatusCode(JsonUtil.getIntValue(paramString, "status_code"));
      this.responseHeader.setErrorCode(JsonUtil.getIntValue(paramString, "error_code"));
      this.responseHeader.setErrorReason(JsonUtil.getStringValue(paramString, "error_reason"));
      this.responseHeader.setSrvName(JsonUtil.getStringValue(paramString, "srv_name"));
      this.responseHeader.setApiName(JsonUtil.getStringValue(paramString, "api_name"));
      this.responseHeader.setAppID(JsonUtil.getStringValue(paramString, "app_id"));
      this.responseHeader.setPkgName(JsonUtil.getStringValue(paramString, "pkg_name"));
      this.responseHeader.setSessionId(JsonUtil.getStringValue(paramString, "session_id"));
      this.responseHeader.setTransactionId(JsonUtil.getStringValue(paramString, "transaction_id"));
      this.responseHeader.setResolution(JsonUtil.getStringValue(paramString, "resolution"));
      this.body = JsonUtil.getStringValue(paramString, "body");
      return true;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromJson failed: ");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("ResponseWrap", localStringBuilder.toString());
    }
    return false;
  }
  
  public String getBody()
  {
    if (TextUtils.isEmpty(this.body)) {
      this.body = new JSONObject().toString();
    }
    return this.body;
  }
  
  public ResponseHeader getResponseHeader()
  {
    return this.responseHeader;
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setResponseHeader(ResponseHeader paramResponseHeader)
  {
    this.responseHeader = paramResponseHeader;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status_code", this.responseHeader.getStatusCode());
      localJSONObject.put("error_code", this.responseHeader.getErrorCode());
      localJSONObject.put("error_reason", this.responseHeader.getErrorReason());
      localJSONObject.put("srv_name", this.responseHeader.getSrvName());
      localJSONObject.put("api_name", this.responseHeader.getApiName());
      localJSONObject.put("app_id", this.responseHeader.getAppID());
      localJSONObject.put("pkg_name", this.responseHeader.getPkgName());
      localJSONObject.put("transaction_id", this.responseHeader.getTransactionId());
      localJSONObject.put("resolution", this.responseHeader.getResolution());
      String str = this.responseHeader.getSessionId();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("session_id", str);
      }
      boolean bool = TextUtils.isEmpty(this.body);
      if (!bool) {
        localJSONObject.put("body", this.body);
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJson failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      HMSLog.e("ResponseWrap", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResponseWrap{body='");
    localStringBuilder.append(this.body);
    localStringBuilder.append('\'');
    localStringBuilder.append(", responseHeader=");
    localStringBuilder.append(this.responseHeader);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.ResponseWrap
 * JD-Core Version:    0.7.0.1
 */