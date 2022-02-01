package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseHeader
  implements ResponseErrorCode, IMessageEntity
{
  private static final String TAG = "ResponseHeader";
  @Packed
  private String api_name;
  @Packed
  private String app_id = "";
  @Packed
  private int error_code;
  @Packed
  private String error_reason;
  private Parcelable parcelable;
  @Packed
  private String pkg_name;
  @Packed
  private String resolution;
  @Packed
  private String session_id;
  @Packed
  private String srv_name;
  @Packed
  private int status_code;
  @Packed
  private String transaction_id;
  
  public ResponseHeader() {}
  
  public ResponseHeader(int paramInt1, int paramInt2, String paramString)
  {
    this.status_code = paramInt1;
    this.error_code = paramInt2;
    this.error_reason = paramString;
  }
  
  public boolean fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.status_code = JsonUtil.getIntValue(paramString, "status_code");
      this.error_code = JsonUtil.getIntValue(paramString, "error_code");
      this.error_reason = JsonUtil.getStringValue(paramString, "error_reason");
      this.srv_name = JsonUtil.getStringValue(paramString, "srv_name");
      this.api_name = JsonUtil.getStringValue(paramString, "api_name");
      this.app_id = JsonUtil.getStringValue(paramString, "app_id");
      this.pkg_name = JsonUtil.getStringValue(paramString, "pkg_name");
      this.session_id = JsonUtil.getStringValue(paramString, "session_id");
      this.transaction_id = JsonUtil.getStringValue(paramString, "transaction_id");
      this.resolution = JsonUtil.getStringValue(paramString, "resolution");
      return true;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromJson failed: ");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("ResponseHeader", localStringBuilder.toString());
    }
    return false;
  }
  
  public String getActualAppID()
  {
    if (TextUtils.isEmpty(this.app_id)) {
      return "";
    }
    String[] arrayOfString = this.app_id.split("\\|");
    if (arrayOfString.length == 0) {
      return "";
    }
    if (arrayOfString.length == 1) {
      return arrayOfString[0];
    }
    return arrayOfString[1];
  }
  
  public String getApiName()
  {
    return this.api_name;
  }
  
  public String getAppID()
  {
    return this.app_id;
  }
  
  public int getErrorCode()
  {
    return this.error_code;
  }
  
  public String getErrorReason()
  {
    return this.error_reason;
  }
  
  public Parcelable getParcelable()
  {
    return this.parcelable;
  }
  
  public String getPkgName()
  {
    return this.pkg_name;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public String getSessionId()
  {
    return this.session_id;
  }
  
  public String getSrvName()
  {
    return this.srv_name;
  }
  
  public int getStatusCode()
  {
    return this.status_code;
  }
  
  public String getTransactionId()
  {
    return this.transaction_id;
  }
  
  public boolean hasResolution()
  {
    return this.parcelable != null;
  }
  
  public boolean isSuccess()
  {
    return this.status_code == 0;
  }
  
  public void setApiName(String paramString)
  {
    this.api_name = paramString;
  }
  
  public void setAppID(String paramString)
  {
    this.app_id = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setErrorReason(String paramString)
  {
    this.error_reason = paramString;
  }
  
  public void setParcelable(Parcelable paramParcelable)
  {
    this.parcelable = paramParcelable;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkg_name = paramString;
  }
  
  public void setResolution(String paramString)
  {
    this.resolution = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.session_id = paramString;
  }
  
  public void setSrvName(String paramString)
  {
    this.srv_name = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.status_code = paramInt;
  }
  
  public void setTransactionId(String paramString)
  {
    this.transaction_id = paramString;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status_code", this.status_code);
      localJSONObject.put("error_code", this.error_code);
      localJSONObject.put("error_reason", this.error_reason);
      localJSONObject.put("srv_name", this.srv_name);
      localJSONObject.put("api_name", this.api_name);
      localJSONObject.put("app_id", this.app_id);
      localJSONObject.put("pkg_name", this.pkg_name);
      boolean bool = TextUtils.isEmpty(this.session_id);
      if (!bool) {
        localJSONObject.put("session_id", this.session_id);
      }
      localJSONObject.put("transaction_id", this.transaction_id);
      localJSONObject.put("resolution", this.resolution);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJson failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      HMSLog.e("ResponseHeader", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("status_code:");
    localStringBuilder.append(this.status_code);
    localStringBuilder.append(", error_code");
    localStringBuilder.append(this.error_code);
    localStringBuilder.append(", api_name:");
    localStringBuilder.append(this.api_name);
    localStringBuilder.append(", app_id:");
    localStringBuilder.append(this.app_id);
    localStringBuilder.append(", pkg_name:");
    localStringBuilder.append(this.pkg_name);
    localStringBuilder.append(", session_id:*, transaction_id:");
    localStringBuilder.append(this.transaction_id);
    localStringBuilder.append(", resolution:");
    localStringBuilder.append(this.resolution);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.ResponseHeader
 * JD-Core Version:    0.7.0.1
 */