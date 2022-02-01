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
  private static GameCenterReceiver jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver = null;
  private static volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List<GameCenterListener> jdField_a_of_type_JavaUtilList = null;
  
  public static GameCenterReceiver a()
  {
    if (jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver == null) {
        jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver = new GameCenterReceiver();
      }
      return jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver;
    }
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterReceiver", 2, "registerReceiver processId=" + MobileQQ.sProcessId + ",mIsRegistered=" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      GameCenterReceiver localGameCenterReceiver;
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localGameCenterReceiver = a();
        if (localGameCenterReceiver == null) {}
      }
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
        MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(localGameCenterReceiver, localIntentFilter2);
        MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(localGameCenterReceiver, localIntentFilter1);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          b();
          if (QLog.isColorLevel()) {
            QLog.e("GameCenterReceiver", 2, "registerReceiver exception", localThrowable);
          }
        }
      }
      return;
    }
    finally {}
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
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "addListener listener=" + paramGameCenterListener);
    }
    if (paramGameCenterListener == null) {
      return;
    }
    GameCenterReceiver localGameCenterReceiver = a();
    synchronized (localGameCenterReceiver.jdField_a_of_type_JavaUtilList)
    {
      if (!localGameCenterReceiver.jdField_a_of_type_JavaUtilList.contains(paramGameCenterListener)) {
        localGameCenterReceiver.jdField_a_of_type_JavaUtilList.add(paramGameCenterListener);
      }
      return;
    }
  }
  
  private void a(String paramString, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "receiveSystemInstallAction intentPkgNameString=" + paramIntent);
    }
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains(":"))) {}
    do
    {
      return;
      paramIntent = paramIntent.split(":");
    } while (paramIntent.length < 2);
    ThreadManagerV2.excute(new GameCenterReceiver.1(this, paramString, paramIntent[1]), 16, null, true);
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 44
    //   11: iconst_2
    //   12: ldc 184
    //   14: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: invokestatic 80	com/tencent/gamecenter/wadl/biz/receiver/GameCenterReceiver:a	()Lcom/tencent/gamecenter/wadl/biz/receiver/GameCenterReceiver;
    //   20: astore_0
    //   21: getstatic 104	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   24: invokevirtual 108	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   27: aload_0
    //   28: invokevirtual 188	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   31: getstatic 24	com/tencent/gamecenter/wadl/biz/receiver/GameCenterReceiver:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 117	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: ldc 2
    //   40: monitorexit
    //   41: return
    //   42: astore_0
    //   43: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq -15 -> 31
    //   49: ldc 44
    //   51: iconst_2
    //   52: ldc 190
    //   54: aload_0
    //   55: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -27 -> 31
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	8	0	localGameCenterReceiver	GameCenterReceiver
    //   42	13	0	localThrowable	Throwable
    //   61	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	31	42	java/lang/Throwable
    //   3	17	61	finally
    //   17	21	61	finally
    //   21	31	61	finally
    //   31	38	61	finally
    //   43	58	61	finally
  }
  
  public static void b(GameCenterListener paramGameCenterListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "removeListener listener=" + paramGameCenterListener);
    }
    if (paramGameCenterListener == null) {
      return;
    }
    GameCenterReceiver localGameCenterReceiver = a();
    synchronized (localGameCenterReceiver.jdField_a_of_type_JavaUtilList)
    {
      if (localGameCenterReceiver.jdField_a_of_type_JavaUtilList.contains(paramGameCenterListener)) {
        localGameCenterReceiver.jdField_a_of_type_JavaUtilList.remove(paramGameCenterListener);
      }
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterReceiver", 2, "onReceive action=" + paramContext);
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
        return;
      }
      if (("android.intent.action.PACKAGE_ADDED".equals(paramContext)) || ("android.intent.action.PACKAGE_REMOVED".equals(paramContext)))
      {
        a(paramContext, paramIntent);
        return;
      }
    } while (!"com.tencent.gamecenter.action".equals(paramContext));
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */