package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.AppRuntime;

public class ThemeUtilApiImpl
  implements IThemeUtilApi
{
  public Bundle getCurrentThemeInfo()
  {
    return ThemeUtil.getCurrentThemeInfo();
  }
  
  public boolean isDartStatusBar(Context paramContext, int paramInt)
  {
    return ThemeUtil.isDartStatusBar(paramContext, paramInt);
  }
  
  public boolean isGoldenTheme()
  {
    return ThemeUtil.isGoldenTheme();
  }
  
  public boolean isInNightMode(AppRuntime paramAppRuntime)
  {
    return ThemeUtil.isInNightMode(paramAppRuntime);
  }
  
  public boolean isNowThemeIsDefault(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    return ThemeUtil.isNowThemeIsDefault(paramAppRuntime, paramBoolean, paramString);
  }
  
  public boolean isNowThemeIsNight(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    return ThemeUtil.isNowThemeIsNight(paramAppRuntime, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.ThemeUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */