package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import mqq.app.AppRuntime;

public class VasApngUtilApiImpl
  implements IVasApngUtilApi
{
  public String getAnimatePathByTag(int paramInt)
  {
    return ThemeUtil.getAnimatePathByTag(paramInt);
  }
  
  public URLDrawable getApngDrawable(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return VasApngUtil.getApngDrawable(paramAppRuntime, paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, paramBundle);
  }
  
  public URLDrawable getApngURLDrawable(String paramString, Drawable paramDrawable, Bundle paramBundle, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    return VasApngUtil.getApngURLDrawable(paramString, new int[] { 1 }, paramDrawable, paramBundle, paramURLDrawableListener);
  }
  
  public boolean isNowThemeIsAnimate()
  {
    return ThemeUtil.isNowThemeIsAnimate();
  }
  
  public boolean isSoundEffectsEnable(AppRuntime paramAppRuntime, Context paramContext)
  {
    paramAppRuntime = ThemeUtil.getThemeInfo(paramContext, ThemeUtil.getUserCurrentThemeId(paramAppRuntime));
    return (paramAppRuntime == null) || (!paramAppRuntime.status.equals("5")) || (!paramAppRuntime.isVoiceTheme);
  }
  
  public boolean updateIsDefaultTheme()
  {
    String str = ThemeUtil.getCurrentThemeId();
    return ("1000".equals(str)) || ("999".equals(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.VasApngUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */