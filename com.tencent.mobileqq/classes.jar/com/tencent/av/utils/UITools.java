package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.util.Locale;

public class UITools
{
  static TraeAudioSession a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public static int a()
  {
    try
    {
      int i = Integer.valueOf(DeviceInfoUtil.d().replace(".", "")).intValue();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 660;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 3;
    case 3000: 
      return 2;
    case 1: 
      return 1;
    }
    return 7;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    String str = "00:00";
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      l1 = paramLong % 60L;
      l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    String str = "已进行通话时长,";
    String[] arrayOfString = paramString.split(":");
    int k;
    int i;
    if (arrayOfString.length == 3)
    {
      k = Integer.valueOf(arrayOfString[0]).intValue();
      j = Integer.valueOf(arrayOfString[1]).intValue();
      i = Integer.valueOf(arrayOfString[2]).intValue();
    }
    for (;;)
    {
      if ((k > 0) || (j > 0) || (i > 0))
      {
        if (k > 0) {
          str = "已进行通话时长," + k + "小时,";
        }
        paramString = str;
        if (j > 0) {
          paramString = str + j + "分,";
        }
        str = paramString;
        if (i > 0) {
          str = paramString + i + "秒";
        }
        return str;
        if (arrayOfString.length == 2)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue();
          i = Integer.valueOf(arrayOfString[1]).intValue();
          k = 0;
        }
      }
      else
      {
        return "已进行通话时长," + paramString;
      }
      i = 0;
      k = 0;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    label647:
    for (;;)
    {
      try
      {
        paramActivity.startActivity(localIntent);
        j = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException3);
        j = 1;
        bool1 = false;
        continue;
      }
      int i = j;
      boolean bool2 = bool1;
      if (!bool1)
      {
        i = j;
        bool2 = bool1;
        if (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        i = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          break label478;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException4);
        i = 2;
        bool2 = false;
        continue;
      }
      int j = i;
      boolean bool1 = bool2;
      if (!bool2)
      {
        j = i;
        bool1 = bool2;
        if (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          i = 3;
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool2 = true;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          break label521;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException5);
        bool2 = false;
        continue;
      }
      j = i;
      bool1 = bool2;
      if (!bool2) {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool1 = true;
        j = i;
      }
      catch (Exception localException6)
      {
        if (!QLog.isColorLevel()) {
          break label562;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException6);
        bool1 = false;
        j = i;
        continue;
      }
      i = j;
      bool2 = bool1;
      if (!bool1) {
        localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      }
      try
      {
        localIntent.setData(Uri.fromParts("package", (String)localObject, null));
        paramActivity.startActivity(localIntent);
        i = 4;
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break label604;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException1);
        i = 4;
        bool2 = false;
        continue;
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        i = 5;
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity((Intent)localObject);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label647;
          }
          QLog.e("UITools", 2, "openPermissionActivity e = " + localException2);
          bool1 = false;
          continue;
        }
        if (!bool1)
        {
          localObject = new Intent(paramActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, "http://view.yutu.qq.com/yutu/activity/3857.html", 524288L, (Intent)localObject, false, -1);
          i = 6;
        }
        QLog.w("UITools", 1, "请求相机权限, which[" + i + "], openSuccess[" + bool1 + "]");
        return;
      }
      label478:
      j = 0;
      label521:
      label562:
      label604:
      bool1 = false;
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("is_video", false);
    paramActivity = paramAppInterface.getCurrentAccountUin();
    SmallScreenUtils.a(paramActivity, SmallScreenUtils.a(paramActivity, bool) + 1, bool);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("qav_SP", 0);
      SharedPreferences.Editor localEditor = paramContext.edit();
      localEditor.putBoolean("qav_random_speakeron", false);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "qav_random_speakeron:" + paramContext.getBoolean("qav_random_speakeron", false));
      }
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText: " + paramString);
      }
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView.setFocusable(true);
    paramView.setContentDescription(paramString);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    if (jdField_a_of_type_Boolean)
    {
      String str = paramString;
      if (paramInt == 2) {
        str = paramString.replace("QQ电话", "群视频");
      }
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText with avtype:" + str + " avtype:" + paramInt);
      }
      paramView.setFocusable(true);
      paramView.setContentDescription(str);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.getApp().getSharedPreferences(paramVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide_for_effect_face", false);
    paramVideoAppInterface.commit();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramString);
      return;
    }
    AudioUtil.a();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(0) == 1) {
      return true;
    }
    return paramVideoAppInterface.getApp().getSharedPreferences(paramVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0).getBoolean("qav_UserGuide_for_effect_face", true);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (a(paramVideoAppInterface))
    {
      AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      return true;
    }
    return false;
  }
  
  static boolean a(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramAppInterface == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
              bool1 = bool2;
              if (paramAppInterface.getCurrentAccountUin() != null)
              {
                String str = paramAppInterface.getCurrentAccountUin();
                bool1 = bool2;
                if (str != null) {
                  bool1 = localSharedPreferences.getBoolean(paramAppInterface.getApp().getString(2131433532) + str, true);
                }
              }
              bool2 = bool1;
            } while (AudioUtil.a() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (PhoneStatusTools.a(BaseApplicationImpl.sApplication));
        bool2 = bool1;
      } while (PhoneStatusTools.c(BaseApplicationImpl.sApplication));
      bool2 = bool1;
    } while (PhoneStatusTools.d(BaseApplicationImpl.sApplication));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    String str = paramString1;
    if (paramString1.startsWith("+")) {
      str = paramString1.substring(1);
    }
    paramString1 = paramString2;
    if (paramString2.startsWith("+")) {
      paramString1 = paramString2.substring(1);
    }
    return str.equals(paramString1);
  }
  
  public static float b(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public static int b(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    default: 
      i = -1;
    case 1: 
    case 10: 
      return i;
    case 3: 
      return 0;
    case 2: 
      return 3000;
    }
    return 1011;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.UITools
 * JD-Core Version:    0.7.0.1
 */