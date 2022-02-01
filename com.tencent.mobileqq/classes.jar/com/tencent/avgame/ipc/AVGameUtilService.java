package com.tencent.avgame.ipc;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class AVGameUtilService
  extends AppService
{
  private static long b = 0L;
  private static boolean c = false;
  private long a = 0L;
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtilService", 2, "turnOnAvGameLongAlive");
    }
    try
    {
      Intent localIntent = new Intent(paramContext, AVGameUtilService.class);
      localIntent.putExtra("key_start_foreground", true);
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Intent paramIntent, boolean paramBoolean)
  {
    long l1 = 0L;
    long l2;
    if (paramIntent != null)
    {
      l2 = paramIntent.getLongExtra("key_start_time", 0L);
      l1 = paramIntent.getLongExtra("key_end_time", 0L);
      if (l1 == 0L) {
        l1 = SystemClock.elapsedRealtime();
      }
    }
    else
    {
      l2 = 0L;
    }
    c = paramBoolean;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("preloadResult, cost[");
      paramIntent.append(l1 - l2);
      paramIntent.append("], ret[");
      paramIntent.append(paramBoolean);
      paramIntent.append("]");
      QLog.i("AVGameUtilService", 2, paramIntent.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("restartProcessForPk ");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("AVGameUtilService", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContext != null)
    {
      if (paramIntent == null) {
        return;
      }
      localObject = new Intent();
      if (paramIntent != null) {
        ((Intent)localObject).putExtras(paramIntent);
      }
      ((Intent)localObject).putExtra("key_room_be_new_enter", false);
      ((Intent)localObject).putExtra("key_from_survival", true);
      ((Intent)localObject).putExtra("key_pk_restart_process", true);
      ThreadManager.getUIHandler().postDelayed(new AVGameUtilService.1(paramContext, (Intent)localObject), 500L);
      paramBaseQQAppInterface = (AvGameRoomListHandler)paramBaseQQAppInterface.getBusinessHandler(AvGameRoomListHandler.a);
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.notifyUI(13, true, null);
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "notifyEntering");
    }
    if (paramAppRuntime != null)
    {
      Intent localIntent = new Intent("tencent.avgame.q2g.entring");
      paramAppRuntime.getApp().sendBroadcast(localIntent);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, context is null.");
      }
      return;
    }
    if (AVGameServerIPCModule.b())
    {
      if (paramBoolean) {
        a(paramAppRuntime);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, alive.");
      }
      return;
    }
    if (c)
    {
      if (paramBoolean) {
        a(paramAppRuntime);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, is load.");
      }
      return;
    }
    if (!paramBoolean)
    {
      int i = AEFilterSupport.a();
      if (i < 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameUtilService", 2, String.format(Locale.getDefault(), "preloadAVGameProcess, level[%d] no preload this case.", new Object[] { Integer.valueOf(i) }));
        }
        return;
      }
      if (Math.abs(SystemClock.elapsedRealtime() - b) < 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameUtilService", 2, "preloadAVGameProcess, too frequency.");
        }
        return;
      }
      float f = ProcessMonitor.e();
      if (f < 0.2F)
      {
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("preloadAVGameProcess, useRate[");
          paramAppRuntime.append(f);
          paramAppRuntime.append("] too small.");
          QLog.i("AVGameUtilService", 2, paramAppRuntime.toString());
        }
        return;
      }
    }
    try
    {
      long l = SystemClock.elapsedRealtime();
      Intent localIntent = new Intent(paramAppRuntime.getApp(), AVGameUtilService.class);
      localIntent.putExtra("key_start_time", l);
      paramAppRuntime.getApp().startService(localIntent);
      c = false;
      b = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        QLog.i("AVGameUtilService", 2, "preloadAVGameProcess, do load.");
        return;
      }
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.i("AVGameUtilService", 1, "preloadAVGameProcess", paramAppRuntime);
    }
  }
  
  public static boolean a()
  {
    if (AVGameServerIPCModule.b()) {
      return true;
    }
    return c;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtilService", 2, "startServiceForeground ");
    }
    long l = GameEngine.a().s().i();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameUtilService", 2, "startServiceForeground roomId == 0, return");
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(getApplicationContext(), "com.tencent.avgame.ui.AVGameActivity"));
    ((Intent)localObject).putExtra("key_room_be_new_enter", false);
    ((Intent)localObject).putExtra("key_room_id", String.valueOf(l));
    String str1 = getResources().getString(2131887318);
    String str2 = getResources().getString(2131887317);
    localObject = PendingIntent.getActivity(getApplication(), 0, (Intent)localObject, 134217728);
    startForeground(3000531, NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130841158).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis()).setContentTitle(str1).setContentText(str2).setContentIntent((PendingIntent)localObject).build());
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtilService", 2, "turnOffAvGameLongAlive");
    }
    try
    {
      Intent localIntent = new Intent(paramContext, AVGameUtilService.class);
      localIntent.putExtra("key_stop_foreground", true);
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void onCreate()
  {
    super.onCreate();
    ProcessMonitor.a().a("AVGameUtilService_onCreate");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, app[");
      localStringBuilder.append(this.app);
      localStringBuilder.append("]");
      QLog.i("AVGameUtilService", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, cost[");
      localStringBuilder.append(SystemClock.elapsedRealtime() - this.a);
      localStringBuilder.append("]");
      QLog.i("AVGameUtilService", 2, localStringBuilder.toString());
    }
    stopForeground(true);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (paramIntent != null)
    {
      this.a = paramIntent.getLongExtra("key_start_time", 0L);
      boolean bool1 = paramIntent.getBooleanExtra("key_start_foreground", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_stop_foreground", false);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onStartCommand needStartForeground = ");
        paramIntent.append(bool1);
        paramIntent.append(",needStopForeground = ");
        paramIntent.append(bool2);
        QLog.d("AVGameUtilService", 2, paramIntent.toString());
      }
      if (bool1)
      {
        b();
        return paramInt1;
      }
      if (bool2)
      {
        stopForeground(true);
        return paramInt1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onStartCommand, cost[");
      paramIntent.append(SystemClock.elapsedRealtime() - this.a);
      paramIntent.append("], start[");
      paramIntent.append(this.a);
      paramIntent.append("]");
      QLog.i("AVGameUtilService", 2, paramIntent.toString());
    }
    if ((this.app instanceof BaseAVGameAppInterface))
    {
      paramIntent = new Intent("tencent.avgame.g2q.preload");
      paramIntent.putExtra("key_start_time", this.a);
      paramIntent.putExtra("key_end_time", SystemClock.elapsedRealtime());
      ((BaseAVGameAppInterface)this.app).getApp().sendBroadcast(paramIntent);
      if (QLog.isColorLevel())
      {
        QLog.i("AVGameUtilService", 2, "preload av game suc.");
        return paramInt1;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("preload fail, app[");
      paramIntent.append(this.app);
      paramIntent.append("]");
      QLog.i("AVGameUtilService", 2, paramIntent.toString());
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameUtilService
 * JD-Core Version:    0.7.0.1
 */