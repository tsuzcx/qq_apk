package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GrsBaseInfo
  implements Cloneable
{
  private static final String TAG = "GrsBaseInfo";
  private String androidVersion;
  private String appName;
  private String countrySource;
  private String deviceModel;
  private String issueCountry;
  private String regCountry;
  private String romVersion;
  private String serCountry;
  private String uid;
  private String versionName;
  
  public GrsBaseInfo() {}
  
  public GrsBaseInfo(Context paramContext)
  {
    this.issueCountry = GrsApp.getInstance().getIssueCountryCode(paramContext);
  }
  
  private StringBuffer getStringBuffer(StringBuffer paramStringBuffer, boolean paramBoolean, Context paramContext)
  {
    String str = getAndroidVersion();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("android_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    str = getRomVersion();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("rom_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    str = getDeviceModel();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("device_model");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    paramContext = new c(paramContext, "share_pre_grs_conf_").b();
    if ((!TextUtils.isEmpty(paramContext)) && (!paramBoolean)) {
      try
      {
        paramContext = URLEncoder.encode(paramContext, "UTF-8");
        if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
          paramStringBuffer.append("&");
        }
        paramStringBuffer.append("cp");
        paramStringBuffer.append("=");
        paramStringBuffer.append(paramContext);
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Logger.e(TAG, "cp UnsupportedEncodingException.", paramContext);
      }
    }
    paramContext = getCountrySource();
    if (!TextUtils.isEmpty(paramContext))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("country_source");
      paramStringBuffer.append("=");
      paramStringBuffer.append(paramContext);
    }
    return paramStringBuffer;
  }
  
  private boolean isEqual(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      if (paramString1.equals(paramString2)) {
        return true;
      }
    }
    return false;
  }
  
  public GrsBaseInfo clone()
  {
    return (GrsBaseInfo)super.clone();
  }
  
  public boolean compare(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (GrsBaseInfo.class != paramObject.getClass()) {
        return false;
      }
      if ((paramObject instanceof GrsBaseInfo))
      {
        paramObject = (GrsBaseInfo)paramObject;
        return (isEqual(this.serCountry, paramObject.serCountry)) && (isEqual(this.versionName, paramObject.versionName)) && (isEqual(this.appName, paramObject.appName)) && (isEqual(this.uid, paramObject.uid)) && (isEqual(this.regCountry, paramObject.regCountry)) && (isEqual(this.issueCountry, paramObject.issueCountry)) && (isEqual(this.androidVersion, paramObject.androidVersion)) && (isEqual(this.romVersion, paramObject.romVersion)) && (isEqual(this.deviceModel, paramObject.deviceModel)) && (isEqual(this.countrySource, paramObject.countrySource));
      }
    }
    return false;
  }
  
  public GrsBaseInfo copy()
  {
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setAppName(this.appName);
    localGrsBaseInfo.setSerCountry(this.serCountry);
    localGrsBaseInfo.setRegCountry(this.regCountry);
    localGrsBaseInfo.setIssueCountry(this.issueCountry);
    localGrsBaseInfo.setCountrySource(this.countrySource);
    localGrsBaseInfo.setAndroidVersion(this.androidVersion);
    localGrsBaseInfo.setDeviceModel(this.deviceModel);
    localGrsBaseInfo.setRomVersion(this.romVersion);
    localGrsBaseInfo.setUid(this.uid);
    localGrsBaseInfo.setVersionName(this.versionName);
    return localGrsBaseInfo;
  }
  
  public String getAndroidVersion()
  {
    return this.androidVersion;
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public String getCountrySource()
  {
    return this.countrySource;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getGrsParasKey(boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = com.huawei.hms.framework.network.grs.b.b.a(paramContext.getPackageName(), this);
    if (localObject != null) {
      localObject = ((com.huawei.hms.framework.network.grs.b.b)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((a)localObject).b();
    } else {
      localObject = "";
    }
    String str = getAppName();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      localStringBuffer.append("app_name");
      localStringBuffer.append("=");
      localStringBuffer.append(str);
    }
    paramContext = getGrsReqParamJoint(paramBoolean1, paramBoolean2, (String)localObject, paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append(paramContext);
    }
    return localStringBuffer.toString();
  }
  
  public String getGrsParasTag(boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    return getGrsParasKey(paramBoolean1, paramBoolean2, paramContext);
  }
  
  public String getGrsReqParamJoint(boolean paramBoolean1, boolean paramBoolean2, String paramString, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ("1.0".equals(paramString))
    {
      Logger.v(TAG, "1.0 interface has no query param appname");
    }
    else
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localStringBuffer.append("app_name");
        localStringBuffer.append("=");
      }
      for (;;)
      {
        localStringBuffer.append(paramString);
        break;
        if (TextUtils.isEmpty(getAppName())) {
          break;
        }
        localStringBuffer.append("app_name");
        localStringBuffer.append("=");
        paramString = getAppName();
      }
    }
    paramString = getVersionName();
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append("app_version");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString);
    }
    paramString = getUid();
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append("uid");
      localStringBuffer.append("=");
      if (paramBoolean1) {}
      for (paramString = com.huawei.hms.framework.network.grs.d.b.b(paramString);; paramString = com.huawei.hms.framework.network.grs.d.b.a(paramString))
      {
        localStringBuffer.append(paramString);
        break label235;
        if (!paramBoolean2) {
          break;
        }
      }
      localStringBuffer.append(paramString);
    }
    label235:
    paramString = getRegCountry();
    if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append("reg_country");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString);
    }
    paramString = getSerCountry();
    if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append("ser_country");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString);
    }
    paramString = getIssueCountry();
    if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append("issue_country");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString);
    }
    return getStringBuffer(localStringBuffer, paramBoolean2, paramContext).toString();
  }
  
  public String getIssueCountry()
  {
    return this.issueCountry;
  }
  
  public String getRegCountry()
  {
    return this.regCountry;
  }
  
  public String getRomVersion()
  {
    return this.romVersion;
  }
  
  public String getSerCountry()
  {
    return this.serCountry;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setAndroidVersion(String paramString)
  {
    this.androidVersion = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.appName = paramString;
  }
  
  public void setCountrySource(String paramString)
  {
    this.countrySource = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  @Deprecated
  public void setIssueCountry(String paramString)
  {
    this.issueCountry = paramString;
  }
  
  public void setRegCountry(String paramString)
  {
    this.regCountry = paramString;
  }
  
  public void setRomVersion(String paramString)
  {
    this.romVersion = paramString;
  }
  
  public void setSerCountry(String paramString)
  {
    this.serCountry = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
  
  public int uniqueCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.appName);
    localStringBuilder.append("#");
    localStringBuilder.append(this.serCountry);
    localStringBuilder.append("#");
    localStringBuilder.append(this.regCountry);
    localStringBuilder.append("#");
    localStringBuilder.append(this.issueCountry);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsBaseInfo
 * JD-Core Version:    0.7.0.1
 */