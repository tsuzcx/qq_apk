package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CoreService
  extends Service
{
  static final int NOTIFICATION_ID = ;
  private static final String TAG = "GuardManager";
  static CoreService sCore = null;
  static boolean sDisableForeground;
  private static boolean sEnableKernerServiceInVivo = new File(sVivoFilePath).exists();
  private static final String sVivoFilePath = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "enableKernelServiceInVivo";
  
  public static Notification fakeNotification(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new Notification();
      ((Notification)localObject).icon = 2130840158;
      ((Notification)localObject).contentView = new RemoteViews(BaseApplicationImpl.sApplication.getPackageName(), 2131559517);
      return localObject;
    }
    Object localObject = new Intent(BaseApplicationImpl.sApplication, SplashActivity.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = PendingIntent.getActivity(BaseApplicationImpl.sApplication, 0, (Intent)localObject, 402653184);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(BaseApplicationImpl.sApplication);
    localBuilder.setContentTitle("QQ").setContentText("QQ正在后台运行").setWhen(System.currentTimeMillis()).setSmallIcon(2130840158);
    localBuilder.setContentIntent((PendingIntent)localObject);
    return localBuilder.build();
  }
  
  private static boolean isVivoPhoneAndSDK22()
  {
    if (Build.VERSION.SDK_INT == 22) {}
    for (int i = 1; (i != 0) && ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) && (!sEnableKernerServiceInVivo); i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public static void startCoreService(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_1
    //   7: new 104	android/content/Intent
    //   10: dup
    //   11: aload_1
    //   12: ldc 2
    //   14: invokespecial 109	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_2
    //   18: iload_0
    //   19: putstatic 194	com/tencent/mobileqq/app/CoreService:sDisableForeground	Z
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 200	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   27: pop
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -8 -> 28
    //   39: ldc 10
    //   41: iconst_2
    //   42: ldc 207
    //   44: aload_1
    //   45: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -20 -> 28
    //   51: astore_1
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramBoolean	boolean
    //   6	17	1	localBaseApplicationImpl	BaseApplicationImpl
    //   32	13	1	localThrowable	Throwable
    //   51	5	1	localObject	Object
    //   17	7	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   22	28	32	java/lang/Throwable
    //   3	22	51	finally
    //   22	28	51	finally
    //   33	48	51	finally
  }
  
  public static void startTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      do
      {
        return;
      } while (isVivoPhoneAndSDK22());
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, CoreService.KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().startService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "", localThrowable);
  }
  
  /* Error */
  public static void stopCoreService()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 104	android/content/Intent
    //   6: dup
    //   7: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 109	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 39	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: invokevirtual 222	com/tencent/qphone/base/util/BaseApplication:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -8 -> 24
    //   35: ldc 10
    //   37: iconst_2
    //   38: ldc 207
    //   40: aload_0
    //   41: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -20 -> 24
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   28	13	0	localThrowable	Throwable
    //   47	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	28	java/lang/Throwable
    //   3	16	47	finally
    //   16	24	47	finally
    //   29	44	47	finally
  }
  
  public static void stopTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      do
      {
        return;
      } while (isVivoPhoneAndSDK22());
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, CoreService.KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().stopService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "", localThrowable);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    sCore = this;
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onCreate " + Build.VERSION.SDK_INT);
    }
    super.onCreate();
    BaseApplicationImpl.sApplication.onActivityCreate(this, null);
    stopTempService();
    if (!sDisableForeground)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        break label82;
      }
      super.startForeground(NOTIFICATION_ID, new Notification());
    }
    label82:
    while (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    startTempService();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    }
    for (;;)
    {
      super.onDestroy();
      sCore = null;
      return;
      stopTempService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService
 * JD-Core Version:    0.7.0.1
 */