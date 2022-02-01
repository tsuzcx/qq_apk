package com.tencent.avgame.ipc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class AVGameUtilService
  extends AppService
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static long b = 0L;
  private long jdField_a_of_type_Long = 0L;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtilService", 2, "startServiceForeground ");
    }
    long l = GameEngine.a().a().a();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameUtilService", 2, "startServiceForeground roomId == 0, return");
      }
      return;
    }
    Object localObject = new Intent(this, AVGameActivity.class);
    ((Intent)localObject).putExtra("key_room_be_new_enter", false);
    ((Intent)localObject).putExtra("key_room_id", String.valueOf(l));
    String str1 = getResources().getString(2131690483);
    String str2 = getResources().getString(2131690482);
    localObject = PendingIntent.getActivity(getApplication(), 0, (Intent)localObject, 134217728);
    startForeground(3000531, NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130840535).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis()).setContentTitle(str1).setContentText(str2).setContentIntent((PendingIntent)localObject).build());
  }
  
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
    long l2 = 0L;
    long l1;
    long l3;
    if (paramIntent != null)
    {
      l1 = paramIntent.getLongExtra("key_start_time", 0L);
      l3 = paramIntent.getLongExtra("key_end_time", 0L);
      if (l3 == 0L)
      {
        l3 = SystemClock.elapsedRealtime();
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameUtilService", 2, "preloadResult, cost[" + (l1 - l2) + "], ret[" + paramBoolean + "]");
      }
      return;
      l2 = l1;
      l1 = l3;
      continue;
      l1 = 0L;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "notifyEntering");
    }
    if (paramQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.avgame.q2g.entring");
      paramQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "restartProcessForPk " + paramContext + " " + paramIntent);
    }
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, AVGameActivity.class);
      if (paramIntent != null) {
        localIntent.putExtras(paramIntent);
      }
      localIntent.putExtra("key_room_be_new_enter", false);
      localIntent.putExtra("key_from_survival", true);
      localIntent.putExtra("key_pk_restart_process", true);
      ThreadManager.getUIHandler().postDelayed(new AVGameUtilService.1(paramContext, localIntent), 500L);
      paramQQAppInterface = (AvGameRoomListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.notifyUI(13, true, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, context is null.");
      }
    }
    for (;;)
    {
      return;
      if (AVGameServerIPCModule.a())
      {
        if (paramBoolean) {
          a(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, alive.");
        }
      }
      else if (jdField_a_of_type_Boolean)
      {
        if (paramBoolean) {
          a(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameUtilService", 4, "preloadAVGameProcess, is load.");
        }
      }
      else
      {
        if (!paramBoolean)
        {
          int i = AEFilterSupport.a();
          if (i < 4)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("AVGameUtilService", 2, String.format(Locale.getDefault(), "preloadAVGameProcess, level[%d] no preload this case.", new Object[] { Integer.valueOf(i) }));
            return;
          }
          if (Math.abs(SystemClock.elapsedRealtime() - b) < 10000L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("AVGameUtilService", 2, "preloadAVGameProcess, too frequency.");
            return;
          }
          float f = ProcessMonitor.a();
          if (f < 0.2F)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("AVGameUtilService", 2, "preloadAVGameProcess, useRate[" + f + "] too small.");
            return;
          }
        }
        try
        {
          long l = SystemClock.elapsedRealtime();
          Intent localIntent = new Intent(paramQQAppInterface.getApp(), AVGameUtilService.class);
          localIntent.putExtra("key_start_time", l);
          paramQQAppInterface.getApp().startService(localIntent);
          jdField_a_of_type_Boolean = false;
          b = SystemClock.elapsedRealtime();
          if (QLog.isColorLevel())
          {
            QLog.i("AVGameUtilService", 2, "preloadAVGameProcess, do load.");
            return;
          }
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.i("AVGameUtilService", 1, "preloadAVGameProcess", paramQQAppInterface);
        }
      }
    }
  }
  
  public static boolean a()
  {
    if (AVGameServerIPCModule.a()) {
      return true;
    }
    return jdField_a_of_type_Boolean;
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
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "onCreate, app[" + this.app + "]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "onDestroy, cost[" + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) + "]");
    }
    stopForeground(true);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("key_start_time", 0L);
      boolean bool1 = paramIntent.getBooleanExtra("key_start_foreground", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_stop_foreground", false);
      if (QLog.isColorLevel()) {
        QLog.d("AVGameUtilService", 2, "onStartCommand needStartForeground = " + bool1 + ",needStopForeground = " + bool2);
      }
      if (bool1)
      {
        a();
        return paramInt1;
      }
      if (bool2)
      {
        stopForeground(true);
        return paramInt1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "onStartCommand, cost[" + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) + "], start[" + this.jdField_a_of_type_Long + "]");
    }
    if ((this.app instanceof AVGameAppInterface))
    {
      paramIntent = new Intent("tencent.avgame.g2q.preload");
      paramIntent.putExtra("key_start_time", this.jdField_a_of_type_Long);
      paramIntent.putExtra("key_end_time", SystemClock.elapsedRealtime());
      ((AVGameAppInterface)this.app).getApp().sendBroadcast(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("AVGameUtilService", 2, "preload av game suc.");
      }
    }
    for (;;)
    {
      return paramInt1;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameUtilService", 2, "preload fail, app[" + this.app + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameUtilService
 * JD-Core Version:    0.7.0.1
 */