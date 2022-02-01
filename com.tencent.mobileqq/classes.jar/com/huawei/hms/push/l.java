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

public class l
{
  public static int a(Context paramContext)
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
  
  public static Bitmap a(Context paramContext, k paramk)
  {
    if (paramContext != null)
    {
      if (paramk == null) {
        return null;
      }
      try
      {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        if (i >= 11)
        {
          HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
          return null;
        }
        if (!"com.huawei.android.pushagent".equals(paramk.k()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get left bitmap from ");
          localStringBuilder.append(paramk.k());
          HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
          paramContext = ((BitmapDrawable)paramContext.getPackageManager().getApplicationIcon(paramk.k())).getBitmap();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramk = new StringBuilder();
        paramk.append("");
        paramk.append(paramContext.toString());
        HMSLog.e("PushSelfShowLog", paramk.toString(), paramContext);
        return null;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramk = new StringBuilder();
        paramk.append("");
        paramk.append(paramContext.toString());
        HMSLog.e("PushSelfShowLog", paramk.toString(), paramContext);
      }
    }
    return null;
  }
  
  @TargetApi(23)
  public static void a(Context paramContext, Notification.Builder paramBuilder, k paramk)
  {
    if ((paramContext != null) && (paramBuilder != null) && (paramk != null))
    {
      paramBuilder.setSmallIcon(b(paramContext, paramk));
      return;
    }
    HMSLog.e("PushSelfShowLog", "msg is null");
  }
  
  public static int b(Context paramContext, k paramk)
  {
    int j = 0;
    if ((paramContext != null) && (paramk != null))
    {
      int i = j;
      if (!TextUtils.isEmpty(paramk.m()))
      {
        paramk = paramk.m().split("/");
        i = j;
        if (paramk.length == 3) {
          i = r.a(paramContext, paramk[1], paramk[2]);
        }
      }
      j = i;
      if (i == 0) {
        j = r.a(paramContext, "com.huawei.messaging.default_notification_icon");
      }
      if (j != 0) {
        return j;
      }
      return a(paramContext);
    }
    HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.l
 * JD-Core Version:    0.7.0.1
 */