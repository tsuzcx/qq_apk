package com.tencent.mobileqq.activity.qqsettingme.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IThemeUtilApi
  extends QRouteApi
{
  public abstract Bundle getCurrentThemeInfo();
  
  public abstract boolean isDartStatusBar(Context paramContext, int paramInt);
  
  public abstract boolean isGoldenTheme();
  
  public abstract boolean isInNightMode(AppRuntime paramAppRuntime);
  
  public abstract boolean isNowThemeIsDefault(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString);
  
  public abstract boolean isNowThemeIsNight(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
 * JD-Core Version:    0.7.0.1
 */