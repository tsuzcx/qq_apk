package com.tencent.mobileqq.activity.qqsettingme.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IVasApngUtilApi
  extends QRouteApi
{
  public abstract String getAnimatePathByTag(int paramInt);
  
  public abstract URLDrawable getApngDrawable(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle);
  
  public abstract URLDrawable getApngURLDrawable(String paramString, Drawable paramDrawable, Bundle paramBundle, URLDrawable.URLDrawableListener paramURLDrawableListener);
  
  public abstract boolean isNowThemeIsAnimate();
  
  public abstract boolean isSoundEffectsEnable(AppRuntime paramAppRuntime, Context paramContext);
  
  public abstract boolean updateIsDefaultTheme();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
 * JD-Core Version:    0.7.0.1
 */