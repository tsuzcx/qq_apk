package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.utils.QQTheme;

public class RFThemeUtil
{
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(67108864);
      paramActivity.getDecorView().setSystemUiVisibility(1280);
      paramActivity.addFlags(-2147483648);
      paramActivity.setStatusBarColor(paramInt);
      paramActivity.setNavigationBarColor(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  public static boolean a()
  {
    return QQTheme.isNowThemeIsNight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.RFThemeUtil
 * JD-Core Version:    0.7.0.1
 */