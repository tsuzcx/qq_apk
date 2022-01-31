import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aobd
{
  private static Point jdField_a_of_type_AndroidGraphicsPoint = new Point(-1, -1);
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  public static Point a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_AndroidGraphicsPoint.x == -1) || (jdField_a_of_type_AndroidGraphicsPoint.y == -1))
    {
      paramQQAppInterface = bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.c());
      int j = paramQQAppInterface.getInt("colornote_windows_x", -1);
      int k = paramQQAppInterface.getInt("colornote_windows_y", -1);
      int i;
      if (j != -1)
      {
        i = k;
        if (k != -1) {}
      }
      else
      {
        j = bdkf.a() - bdkf.a(25.0F);
        i = bdkf.b() / 2 + bdkf.a(25.0F);
      }
      jdField_a_of_type_AndroidGraphicsPoint.x = j;
      jdField_a_of_type_AndroidGraphicsPoint.y = i;
    }
    return jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
    jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent;
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
    }
    try
    {
      paramContext.startService(localIntent);
      a(paramContext, 3, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + localException);
        }
        jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 1, "sendUpdateSmallScreenStateBroadcast sHasServiceExit = " + jdField_a_of_type_Boolean + ", from = " + paramInt + ", shouldShow = " + paramBoolean);
    }
    Intent localIntent1 = new Intent("action_update_cn_smallscreen_state");
    localIntent1.setPackage(paramContext.getPackageName());
    localIntent1.putExtra("param_from", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramContext.sendBroadcast(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "sendUpdateSmallScreenStateBroadcast:" + paramBoolean);
      }
      return;
      localIntent1.putExtra("param_not_in_colornote_list", paramBoolean);
      continue;
      localIntent1.putExtra("param_shoule_show_smallscreen", paramBoolean);
      continue;
      Intent localIntent2;
      if (paramBoolean) {
        localIntent2 = new Intent(paramContext, ColorNoteSmallScreenService.class);
      }
      try
      {
        paramContext.startService(localIntent2);
        localIntent1.putExtra("param_is_app_foreground", paramBoolean);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + localException);
          }
        }
      }
      localIntent1.putExtra("param_custom_night_mode", paramBoolean);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
      localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
      localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
      paramContext.startService(localIntent);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenUtil", 1, "showColorNoteSmallScreen , idAdd = " + paramBoolean1 + ", sHasServiceExit = " + jdField_a_of_type_Boolean + ", force = " + paramBoolean2);
        }
        if ((!aoar.a(paramContext)) && (paramBoolean1)) {
          c(paramContext);
        }
        if ((!jdField_a_of_type_Boolean) || (paramBoolean2))
        {
          jdField_a_of_type_Boolean = true;
          Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
          try
          {
            paramContext.startService(localIntent);
            return;
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + paramContext);
            }
            jdField_a_of_type_Boolean = false;
            continue;
          }
        }
        a(paramContext, 3, true);
      }
      finally {}
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (b(BaseApplicationImpl.getContext())) {
        bool = true;
      }
    }
    if ((bool) && (b))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (((localAppRuntime instanceof QQAppInterface)) && (localAppRuntime.isLogin()) && (((QQAppInterface)localAppRuntime).a().a().a() > 0)) {
        a(((QQAppInterface)localAppRuntime).getApp(), false, true);
      }
    }
  }
  
  public static boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 2, "isAfterSyncMsg() " + b);
    }
    return b;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label259;
        }
        if (!QLog.isDevelopLevel()) {
          break label264;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label259:
      boolean bool1 = false;
      continue;
      label264:
      bool1 = true;
    }
  }
  
  /* Error */
  public static void b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +31 -> 37
    //   9: ldc 92
    //   11: iconst_1
    //   12: new 94	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 291
    //   22: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 68	aobd:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: new 70	android/content/Intent
    //   40: dup
    //   41: aload_0
    //   42: ldc 72
    //   44: invokespecial 75	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   47: astore_1
    //   48: iconst_0
    //   49: putstatic 68	aobd:jdField_a_of_type_Boolean	Z
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 295	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   57: pop
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: astore_0
    //   63: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -8 -> 58
    //   69: ldc 92
    //   71: iconst_2
    //   72: new 94	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 297
    //   82: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -37 -> 58
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramContext	Context
    //   47	7	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   48	58	62	java/lang/Exception
    //   3	37	98	finally
    //   37	48	98	finally
    //   48	58	98	finally
    //   63	95	98	finally
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      if (QLog.isDevelopLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "setAfterSyncMsg " + b);
      }
      Intent localIntent = new Intent("key_after_sync_msg");
      localIntent.putExtra("extra_after_sync_msg", b);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      return;
    }
    finally {}
  }
  
  private static boolean b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (!((List)localObject).isEmpty())
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (QLog.isDevelopLevel()) {
        QLog.d("FSReceiver", 4, new Object[] { "currTopPkg:", ((ComponentName)localObject).getPackageName() });
      }
      if (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) {
        return true;
      }
    }
    return false;
  }
  
  private static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenUtil", 2, "showPermissionDialog in");
    }
    paramContext = new Intent();
    paramContext.putExtra("public_fragment_window_feature", 1);
    if (!ColorNoteSmallScreenPermissionDialogFragment.jdField_a_of_type_Boolean) {
      adky.a(paramContext, PublicTransFragmentActivity.class, ColorNoteSmallScreenPermissionDialogFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobd
 * JD-Core Version:    0.7.0.1
 */