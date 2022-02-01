package com.huawei.hms.push;

import android.annotation.TargetApi;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;

public class p
{
  private static int a(Context paramContext)
  {
    int j = paramContext.getApplicationInfo().icon;
    int i = j;
    if (j == 0)
    {
      j = paramContext.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
      HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
      i = j;
      if (j == 0)
      {
        i = 17301651;
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
      }
    }
    return i;
  }
  
  public static Bitmap a(Context paramContext, o paramo)
  {
    if ((paramContext == null) || (paramo == null)) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11)
        {
          HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
          return null;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("PushSelfShowLog", "" + paramContext.toString(), paramContext);
        return null;
        if (!"com.huawei.android.pushagent".equals(paramo.i()))
        {
          HMSLog.i("PushSelfShowLog", "get left bitmap from " + paramo.i());
          paramContext = ((BitmapDrawable)paramContext.getPackageManager().getApplicationIcon(paramo.i())).getBitmap();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        HMSLog.e("PushSelfShowLog", "" + paramContext.toString(), paramContext);
        return null;
      }
      paramContext = null;
    }
  }
  
  @TargetApi(23)
  public static void a(Context paramContext, Notification.Builder paramBuilder, o paramo)
  {
    if ((paramContext == null) || (paramBuilder == null) || (paramo == null))
    {
      HMSLog.e("PushSelfShowLog", "msg is null");
      return;
    }
    paramBuilder.setSmallIcon(b(paramContext, paramo));
  }
  
  private static int b(Context paramContext, o paramo)
  {
    int j = 0;
    int i = 0;
    if ((paramContext == null) || (paramo == null)) {
      HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
    }
    do
    {
      return i;
      i = j;
      if (!TextUtils.isEmpty(paramo.x()))
      {
        paramo = paramo.x().split("/");
        i = j;
        if (paramo.length == 3) {
          i = v.a(paramContext, paramo[1], paramo[2]);
        }
      }
      j = i;
      if (i == 0) {
        j = v.a(paramContext, "com.huawei.messaging.default_notification_icon");
      }
      i = j;
    } while (j != 0);
    return a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.p
 * JD-Core Version:    0.7.0.1
 */