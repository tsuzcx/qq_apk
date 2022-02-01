package com.tencent.mobileqq.ark.api.impl;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.util.SOPreLoader;

public class ArkEnvDelegateImpl
  implements IArkEnvDelegate
{
  public String getAppConfigForCurrentTheme()
  {
    return ArkAppCenterUtil.a();
  }
  
  public float getDisplayDensity()
  {
    return ArkAppCenterUtil.a();
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return ArkAppCenterUtil.a;
  }
  
  public String getLibJSCPath()
  {
    return SOPreLoader.b();
  }
  
  public boolean shouldCheckURLDomain()
  {
    return ArkAppCenterUtil.a() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkEnvDelegateImpl
 * JD-Core Version:    0.7.0.1
 */