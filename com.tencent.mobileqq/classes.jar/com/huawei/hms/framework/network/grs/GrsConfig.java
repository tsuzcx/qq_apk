package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.PackageUtils;
import com.huawei.hms.framework.common.StringUtils;

public class GrsConfig
{
  private String appName;
  private String countrySource;
  private String issueCountry;
  private String regCountry;
  private String serCountry;
  private String userId;
  private String versionName;
  
  public boolean equal(GrsConfig paramGrsConfig)
  {
    return (paramGrsConfig != null) && (StringUtils.strEquals(this.appName, paramGrsConfig.getAppName())) && (StringUtils.strEquals(this.serCountry, paramGrsConfig.getSerCountry())) && (StringUtils.strEquals(this.regCountry, paramGrsConfig.getRegCountry())) && (StringUtils.strEquals(this.issueCountry, paramGrsConfig.getIssueCountry())) && (StringUtils.strEquals(this.userId, paramGrsConfig.getuserId())) && (StringUtils.strEquals(this.versionName, paramGrsConfig.getVersionName())) && (StringUtils.strEquals(this.countrySource, paramGrsConfig.getCountrySource()));
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public String getCountrySource()
  {
    return this.countrySource;
  }
  
  public GrsBaseInfo getGrsBaseInfo(Context paramContext)
  {
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setSerCountry(this.serCountry);
    if (TextUtils.isEmpty(this.versionName)) {}
    for (paramContext = PackageUtils.getVersionName(paramContext);; paramContext = this.versionName)
    {
      localGrsBaseInfo.setVersionName(paramContext);
      localGrsBaseInfo.setAppName(this.appName);
      localGrsBaseInfo.setUid(this.userId);
      localGrsBaseInfo.setRegCountry(this.regCountry);
      localGrsBaseInfo.setIssueCountry(this.issueCountry);
      localGrsBaseInfo.setCountrySource(this.countrySource);
      return localGrsBaseInfo;
    }
  }
  
  public String getIssueCountry()
  {
    return this.issueCountry;
  }
  
  public String getRegCountry()
  {
    return this.regCountry;
  }
  
  public String getSerCountry()
  {
    return this.serCountry;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public String getuserId()
  {
    return this.userId;
  }
  
  public void setAppName(String paramString)
  {
    this.appName = paramString;
  }
  
  public void setCountrySource(String paramString)
  {
    this.countrySource = paramString;
  }
  
  public void setIssueCountry(String paramString)
  {
    this.issueCountry = paramString;
  }
  
  public void setRegCountry(String paramString)
  {
    this.regCountry = paramString;
  }
  
  public void setSerCountry(String paramString)
  {
    this.serCountry = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsConfig
 * JD-Core Version:    0.7.0.1
 */