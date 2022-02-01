package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.util.WeakReference;

public class AVUtil
{
  public static int a()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.d == 3) {
        return 3;
      }
      if (localSessionInfo.d == 4) {
        return 4;
      }
      if (localSessionInfo.d == 1) {
        return 1;
      }
      int i = localSessionInfo.d;
    }
    return 2;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 3000) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 0) {
      return 3;
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (NumberFormatException paramString)
    {
      paramString.fillInStackTrace();
    }
    return 0L;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
      return;
    }
    ThreadManager.excute(new AVUtil.1(new WeakReference(paramActivity)), 16, null, true);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    int i = 0;
    arrayOfString[0] = "mCurRootView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    int j = arrayOfString.length;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        localObject2 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject2 != null) && ((localObject2 instanceof View)))
        {
          if (((View)localObject2).getContext() != paramContext) {
            break;
          }
          ((Field)localObject1).set(localInputMethodManager, null);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("fixInputMethodMemoryLeak, exception [");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          ((StringBuilder)localObject2).append("]");
          QLog.i("AVUtil", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
  }
  
  public static void a(Intent paramIntent) {}
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, a(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramString4 != null) && (paramString4.length() > 128)) {
      paramString4 = "";
    }
    if ((paramString5 != null) && (paramString5.length() > 128)) {
      paramString5 = "";
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5);
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("report tag[");
      paramString3.append(paramString1);
      paramString3.append("], from[");
      paramString3.append(paramInt1);
      paramString3.append("], r2[");
      paramString3.append(paramString2);
      paramString3.append("]");
      QLog.i("AVUtil", 2, paramString3.toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(BaseApplication.getContext(), paramString, null, "qqsetting_avcall_notify_key", paramBoolean);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("saveAllowAVNotify, isAllow[");
      paramString.append(paramBoolean);
      paramString.append("]");
      QLog.i("AVUtil", 2, paramString.toString());
    }
  }
  
  public static boolean a()
  {
    return ("asus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ASUS_Z00XSB".equalsIgnoreCase(Build.MODEL));
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != 2) {
      return paramInt == 1;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qqsetting_avcall_notify_key");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = SettingCloneUtil.getSharedPreferences().contains((String)localObject);
    boolean bool1;
    if (bool2) {
      bool1 = SettingCloneUtil.readValue(localBaseApplication, paramString, null, "qqsetting_avcall_notify_key", true);
    } else {
      bool1 = SettingCloneUtil.readValue(localBaseApplication, null, null, "qqsetting_avcall_notify_key", true);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isAVNotifyEnable, av_enable[");
      paramString.append(bool1);
      paramString.append("], isNewKeyExist[");
      paramString.append(bool2);
      paramString.append("]");
      QLog.i("AVUtil", 2, paramString.toString());
    }
    return bool1;
  }
  
  public static int b(int paramInt)
  {
    int i = 0;
    if (paramInt == 3000) {
      return 1004;
    }
    if (paramInt == 1) {
      i = 1000;
    }
    return i;
  }
  
  public static boolean b()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT > 28) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUseCompatMode [");
      localStringBuilder.append(bool);
      localStringBuilder.append("], SDK_INT[");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("]");
      QLog.i("CompatModeTag", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt != 1) {
      return paramInt == 3000;
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(localBaseApplication);
    if (bool) {
      return a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVUtil", 2, "isAllowAVNotify, system_enable[false]");
    }
    return bool;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 2) {
      return 1004;
    }
    return 1000;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVUtil
 * JD-Core Version:    0.7.0.1
 */