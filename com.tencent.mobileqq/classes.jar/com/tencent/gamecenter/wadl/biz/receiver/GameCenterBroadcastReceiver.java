package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameCenterBroadcastReceiver
  implements INetEventHandler
{
  public static boolean a = false;
  public static int b = 100;
  public static boolean c = false;
  private static GameCenterBroadcastReceiver f;
  private static BroadcastReceiver g;
  boolean d = false;
  boolean e = false;
  
  public static void a()
  {
    QLog.i("GameCenterBroadcastReceiver", 1, "registerReceiver");
    if (f == null) {
      f = new GameCenterBroadcastReceiver();
    }
    if (g == null) {
      g = new GameCenterBroadcastReceiver.1();
    }
    if (!a) {
      try
      {
        AppNetConnInfo.registerNetChangeReceiver(MobileQQ.sMobileQQ, f);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        MobileQQ.sMobileQQ.registerReceiver(g, localIntentFilter);
        a = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameCenterBroadcastReceiver", 1, "registerReceiver exception", localThrowable);
      }
    }
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 33
    //   2: iconst_1
    //   3: ldc 88
    //   5: invokestatic 41	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 43	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:f	Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver;
    //   11: ifnull +14 -> 25
    //   14: getstatic 43	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:f	Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver;
    //   17: invokestatic 92	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:unregisterNetEventHandler	(Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)Z
    //   20: pop
    //   21: aconst_null
    //   22: putstatic 43	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:f	Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver;
    //   25: getstatic 46	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:g	Landroid/content/BroadcastReceiver;
    //   28: ifnull +16 -> 44
    //   31: getstatic 57	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   34: getstatic 46	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:g	Landroid/content/BroadcastReceiver;
    //   37: invokevirtual 96	mqq/app/MobileQQ:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   40: aconst_null
    //   41: putstatic 46	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:g	Landroid/content/BroadcastReceiver;
    //   44: aconst_null
    //   45: putstatic 43	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:f	Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver;
    //   48: aconst_null
    //   49: putstatic 46	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:g	Landroid/content/BroadcastReceiver;
    //   52: goto +20 -> 72
    //   55: astore_0
    //   56: goto +21 -> 77
    //   59: astore_0
    //   60: ldc 33
    //   62: iconst_1
    //   63: ldc 98
    //   65: aload_0
    //   66: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: goto -25 -> 44
    //   72: iconst_0
    //   73: putstatic 51	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:a	Z
    //   76: return
    //   77: aconst_null
    //   78: putstatic 43	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:f	Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver;
    //   81: aconst_null
    //   82: putstatic 46	com/tencent/gamecenter/wadl/biz/receiver/GameCenterBroadcastReceiver:g	Landroid/content/BroadcastReceiver;
    //   85: goto +5 -> 90
    //   88: aload_0
    //   89: athrow
    //   90: goto -2 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	1	0	localObject	Object
    //   59	30	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	25	55	finally
    //   25	44	55	finally
    //   60	69	55	finally
    //   8	25	59	java/lang/Throwable
    //   25	44	59	java/lang/Throwable
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("GameCenterBroadcastReceiver", 1, "no net");
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      if (this.e) {
        return;
      }
      QLog.i("GameCenterBroadcastReceiver", 1, "mobile connect");
    }
    else if (AppNetConnInfo.isWifiConn())
    {
      if (this.d) {
        return;
      }
      this.d = true;
      QLog.i("GameCenterBroadcastReceiver", 1, "wifi connect");
      ((IQQGameCheckService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter();
    }
    else
    {
      QLog.i("GameCenterBroadcastReceiver", 1, "no connect");
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */