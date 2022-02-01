package com.tencent.mobileqq.ar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class UniformUtils
{
  public static int a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("UniformUtils", 0).getInt(paramString, 0);
  }
  
  public static void a(Context paramContext, View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramContext = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      paramContext.topMargin = i;
      paramView.setLayoutParams(paramContext);
    }
  }
  
  public static void a(Context paramContext, View paramView, boolean paramBoolean, int paramInt)
  {
    if (ScreenUtil.checkDeviceHasNavigationBar(paramContext))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int i = paramInt;
      if (paramBoolean) {
        i = paramInt + ScreenUtil.getNavigationBarHeight(paramContext);
      }
      if (localMarginLayoutParams.bottomMargin == i) {
        return;
      }
      localMarginLayoutParams.bottomMargin = i;
      paramView.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    BaseApplication.getContext().getSharedPreferences("UniformUtils", 0).edit().putInt(paramString, paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.UniformUtils
 * JD-Core Version:    0.7.0.1
 */