package com.tencent.mobileqq.ark.api;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkEnvDelegate
  extends QRouteApi
{
  public abstract String getAppConfigForCurrentTheme();
  
  public abstract float getDisplayDensity();
  
  public abstract DisplayMetrics getDisplayMetrics();
  
  public abstract String getLibJSCPath();
  
  public abstract boolean shouldCheckURLDomain();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkEnvDelegate
 * JD-Core Version:    0.7.0.1
 */