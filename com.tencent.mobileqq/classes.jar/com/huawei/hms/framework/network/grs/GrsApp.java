package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;

public class GrsApp
{
  private static GrsApp instance = new GrsApp();
  private String appConfigName;
  
  public static GrsApp getInstance()
  {
    return instance;
  }
  
  public String getAppConfigName()
  {
    return this.appConfigName;
  }
  
  public String getIssueCountryCode(Context paramContext)
  {
    return a.a(paramContext, false).getCountryCode();
  }
  
  public void setAppConfigName(String paramString)
  {
    this.appConfigName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsApp
 * JD-Core Version:    0.7.0.1
 */