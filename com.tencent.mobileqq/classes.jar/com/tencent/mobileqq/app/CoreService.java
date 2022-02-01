package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class CoreService
  extends Service
{
  public static final String KEY_START_MODE = "k_start_mode";
  static final int NOTIFICATION_ID = ;
  private static final String S_VIVO_FILE_PATH;
  private static final String TAG = "GuardManager";
  static CoreService sCore = null;
  static boolean sDisableForeground;
  private static boolean sEnableKernerServiceInVivo = new File(S_VIVO_FILE_PATH).exists();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("enableKernelServiceInVivo");
    S_VIVO_FILE_PATH = localStringBuilder.toString();
  }
  
  public static Notification fakeNotification(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new Notification();
      ((Notification)localObject).icon = 2130840405;
      ((Notification)localObject).contentView = new RemoteViews(MobileQQ.getMobileQQ().getPackageName(), 2131559649);
      return localObject;
    }
    Object localObject = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
    ((Intent)localObject).addFlags(67108864);
    localObject = PendingIntent.getActivity(MobileQQ.getMobileQQ(), 0, (Intent)localObject, 402653184);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(MobileQQ.getMobileQQ());
    localBuilder.setContentTitle("QQ").setContentText("QQ正在后台运行").setWhen(System.currentTimeMillis()).setSmallIcon(2130840405);
    localBuilder.setContentIntent((PendingIntent)localObject);
    return localBuilder.build();
  }
  
  private static boolean isVivoPhoneAndSDK22()
  {
    int i;
    if (Build.VERSION.SDK_INT == 22) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) && (!sEnableKernerServiceInVivo);
  }
  
  public static void startCoreService(boolean paramBoolean)
  {
    try
    {
      MobileQQ localMobileQQ = MobileQQ.getMobileQQ();
      Intent localIntent = new Intent(localMobileQQ, CoreService.class);
      sDisableForeground = paramBoolean;
      try
      {
        localMobileQQ.startService(localIntent);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "", localThrowable);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void startTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    if (isVivoPhoneAndSDK22()) {
      return;
    }
    Intent localIntent = new Intent(MobileQQ.getMobileQQ(), CoreService.KernelService.class);
    try
    {
      MobileQQ.getContext().startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "", localThrowable);
      }
    }
  }
  
  public static void stopCoreService()
  {
    try
    {
      Intent localIntent = new Intent(MobileQQ.getMobileQQ(), CoreService.class);
      try
      {
        MobileQQ.getContext().stopService(localIntent);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "", localThrowable);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void stopTempService()
  {
    if (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    if (isVivoPhoneAndSDK22()) {
      return;
    }
    Intent localIntent = new Intent(MobileQQ.getMobileQQ(), CoreService.KernelService.class);
    try
    {
      BaseApplication.getContext().stopService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "", localThrowable);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    sCore = this;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CoreService.onCreate ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.d("GuardManager", 2, localStringBuilder.toString());
    }
    super.onCreate();
    MobileQQ.getMobileQQ().onActivityCreate(this, null);
    stopTempService();
    if (!sDisableForeground)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        super.startForeground(NOTIFICATION_ID, new Notification());
        return;
      }
      if (Build.VERSION.SDK_INT < 25) {
        startTempService();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "CoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    } else {
      stopTempService();
    }
    super.onDestroy();
    sCore = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("crashcontrol", 0);
    if (localSharedPreferences.getBoolean("crashFrequentLast", false))
    {
      QLog.d("GuardManager", 1, "crashFrequentLast,return START_NOT_STICKY");
      localSharedPreferences.edit().putBoolean("crashFrequentLast", false).commit();
      return 2;
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService
 * JD-Core Version:    0.7.0.1
 */