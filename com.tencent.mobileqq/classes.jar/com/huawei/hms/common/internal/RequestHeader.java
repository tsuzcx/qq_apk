package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestHeader
  implements IMessageEntity
{
  private static final String TAG = "RequestHeader";
  @Packed
  private int apiLevel;
  @Packed
  private String api_name;
  @Packed
  private String app_id = "";
  @Packed
  private int kitSdkVersion;
  private Parcelable parcelable;
  @Packed
  private String pkg_name;
  @Packed
  private int sdk_version = 50200300;
  @Packed
  private String session_id;
  @Packed
  private String srv_name;
  @Packed
  private String transaction_id;
  @Packed
  private String version = "4.0";
  
  public boolean fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.version = JsonUtil.getStringValue(paramString, "version");
      this.srv_name = JsonUtil.getStringValue(paramString, "srv_name");
      this.api_name = JsonUtil.getStringValue(paramString, "api_name");
      this.app_id = JsonUtil.getStringValue(paramString, "app_id");
      this.pkg_name = JsonUtil.getStringValue(paramString, "pkg_name");
      this.sdk_version = JsonUtil.getIntValue(paramString, "sdk_version");
      this.kitSdkVersion = JsonUtil.getIntValue(paramString, "kitSdkVersion");
      this.apiLevel = JsonUtil.getIntValue(paramString, "apiLevel");
      this.session_id = JsonUtil.getStringValue(paramString, "session_id");
      this.transaction_id = JsonUtil.getStringValue(paramString, "transaction_id");
      return true;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromJson failed: ");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("RequestHeader", localStringBuilder.toString());
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
  
  public int getApiLevel()
  {
    return this.apiLevel;
  }
  
  public String getApiName()
  {
    return this.api_name;
  }
  
  public String getAppID()
  {
    return this.app_id;
  }
  
  public int getKitSdkVersion()
  {
    return this.kitSdkVersion;
  }
  
  public Parcelable getParcelable()
  {
    return this.parcelable;
  }
  
  public String getPkgName()
  {
    return this.pkg_name;
  }
  
  public int getSdkVersion()
  {
    return this.sdk_version;
  }
  
  public String getSessionId()
  {
    return this.session_id;
  }
  
  public String getSrvName()
  {
    return this.srv_name;
  }
  
  public String getTransactionId()
  {
    return this.transaction_id;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setApiLevel(int paramInt)
  {
    this.apiLevel = paramInt;
  }
  
  public void setApiName(String paramString)
  {
    this.api_name = paramString;
  }
  
  public void setAppID(String paramString)
  {
    this.app_id = paramString;
  }
  
  public void setKitSdkVersion(int paramInt)
  {
    this.kitSdkVersion = paramInt;
  }
  
  public void setParcelable(Parcelable paramParcelable)
  {
    this.parcelable = paramParcelable;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkg_name = paramString;
  }
  
  public void setSdkVersion(int paramInt)
  {
    this.sdk_version = paramInt;
  }
  
  public void setSessionId(String paramString)
  {
    this.session_id = paramString;
  }
  
  public void setSrvName(String paramString)
  {
    this.srv_name = paramString;
  }
  
  public void setTransactionId(String paramString)
  {
    this.transaction_id = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.version);
      localJSONObject.put("srv_name", this.srv_name);
      localJSONObject.put("api_name", this.api_name);
      localJSONObject.put("app_id", this.app_id);
      localJSONObject.put("pkg_name", this.pkg_name);
      localJSONObject.put("sdk_version", this.sdk_version);
      localJSONObject.put("kitSdkVersion", this.kitSdkVersion);
      localJSONObject.put("apiLevel", this.apiLevel);
      boolean bool = TextUtils.isEmpty(this.session_id);
      if (!bool) {
        localJSONObject.put("session_id", this.session_id);
      }
      localJSONObject.put("transaction_id", this.transaction_id);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJson failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      HMSLog.e("RequestHeader", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api_name:");
    localStringBuilder.append(this.api_name);
    localStringBuilder.append(", app_id:");
    localStringBuilder.append(this.app_id);
    localStringBuilder.append(", pkg_name:");
    localStringBuilder.append(this.pkg_name);
    localStringBuilder.append(", sdk_version:");
    localStringBuilder.append(this.sdk_version);
    localStringBuilder.append(", session_id:*, transaction_id:");
    localStringBuilder.append(this.transaction_id);
    localStringBuilder.append(", kitSdkVersion:");
    localStringBuilder.append(this.kitSdkVersion);
    localStringBuilder.append(", apiLevel:");
    localStringBuilder.append(this.apiLevel);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.RequestHeader
 * JD-Core Version:    0.7.0.1
 */