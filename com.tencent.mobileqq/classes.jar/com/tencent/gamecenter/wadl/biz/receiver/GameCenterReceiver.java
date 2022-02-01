package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.biz.listener.GameCenterListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class GameCenterReceiver
  extends BroadcastReceiver
{
  static byte[] a = new byte[0];
  private static GameCenterReceiver c = null;
  private static volatile AtomicBoolean d = new AtomicBoolean(false);
  List<GameCenterListener> b = null;
  
  public static GameCenterReceiver a()
  {
    if (c == null) {
      synchronized (a)
      {
        if (c == null) {
          c = new GameCenterReceiver();
        }
      }
    }
    return c;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ThreadManagerV2.excute(new GameCenterReceiver.2(this, paramIntent), 16, null, true);
  }
  
  public static void a(GameCenterListener paramGameCenterListener)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addListener listener=");
    ((StringBuilder)???).append(paramGameCenterListener);
    QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)???).toString());
    if (paramGameCenterListener == null) {
      return;
    }
    GameCenterReceiver localGameCenterReceiver = a();
    synchronized (localGameCenterReceiver.b)
    {
      if (!localGameCenterReceiver.b.contains(paramGameCenterListener)) {
        localGameCenterReceiver.b.add(paramGameCenterListener);
      }
      return;
    }
  }
  
  private void a(String paramString, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveSystemInstallAction intentPkgNameString=");
    localStringBuilder.append(paramIntent);
    QLog.d("Wadl_GameCenterReceiver", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramIntent))
    {
      if (!paramIntent.contains(":")) {
        return;
      }
      paramIntent = paramIntent.split(":");
      if (paramIntent.length < 2) {
        return;
      }
      ThreadManagerV2.excute(new GameCenterReceiver.1(this, paramString, paramIntent[1]), 16, null, true);
    }
  }
  
  public static void b()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("registerReceiver processId=");
      ((StringBuilder)localObject1).append(MobileQQ.sProcessId);
      ((StringBuilder)localObject1).append(",mIsRegistered=");
      ((StringBuilder)localObject1).append(d.get());
      QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)localObject1).toString());
      if (!d.get())
      {
        localObject1 = a();
        if (localObject1 != null) {
          try
          {
            IntentFilter localIntentFilter1 = new IntentFilter();
            if (MobileQQ.sProcessId == 1) {
              localIntentFilter1.addAction("android.intent.action.SCREEN_OFF");
            }
            localIntentFilter1.addAction("com.tencent.gamecenter.action");
            IntentFilter localIntentFilter2 = new IntentFilter();
            localIntentFilter2.addDataScheme("package");
            localIntentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            localIntentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
            MobileQQ.sMobileQQ.getApplicationContext().registerReceiver((BroadcastReceiver)localObject1, localIntentFilter2);
            MobileQQ.sMobileQQ.getApplicationContext().registerReceiver((BroadcastReceiver)localObject1, localIntentFilter1);
            d.set(true);
          }
          catch (Throwable localThrowable)
          {
            c();
            QLog.e("Wadl_GameCenterReceiver", 1, "registerReceiver exception", localThrowable);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void b(GameCenterListener paramGameCenterListener)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeListener listener=");
    ((StringBuilder)???).append(paramGameCenterListener);
    QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)???).toString());
    if (paramGameCenterListener == null) {
      return;
    }
    GameCenterReceiver localGameCenterReceiver = a();
    synchronized (localGameCenterReceiver.b)
    {
      if (localGameCenterReceiver.b.contains(paramGameCenterListener)) {
        localGameCenterReceiver.b.remove(paramGameCenterListener);
      }
      return;
    }
  }
  
  public static void c()
  {
    try
    {
      QLog.d("Wadl_GameCenterReceiver", 1, "unRegisterReceiver");
      GameCenterReceiver localGameCenterReceiver = a();
      try
      {
        MobileQQ.sMobileQQ.getApplicationContext().unregisterReceiver(localGameCenterReceiver);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_GameCenterReceiver", 1, "unRegisterReceiver exception", localThrowable);
      }
      d.set(false);
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive action=");
    localStringBuilder.append(paramContext);
    QLog.d("Wadl_GameCenterReceiver", 1, localStringBuilder.toString());
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
      return;
    }
    if ((!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) && (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext)))
    {
      if ("com.tencent.gamecenter.action".equals(paramContext)) {
        a(paramIntent);
      }
    }
    else {
      a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */