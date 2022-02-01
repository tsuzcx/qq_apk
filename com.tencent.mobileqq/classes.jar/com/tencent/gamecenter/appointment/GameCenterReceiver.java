package com.tencent.gamecenter.appointment;

import aceg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import bmxq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameCenterReceiver
  extends BroadcastReceiver
{
  private static GameCenterReceiver jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver;
  private static volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List<aceg> jdField_a_of_type_JavaUtilList = null;
  
  public static GameCenterReceiver a()
  {
    if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver == null) {
        jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver = new GameCenterReceiver();
      }
      return jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterReceiver;
    }
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterReceiver", 2, "registerReceiver processId=" + BaseApplicationImpl.sProcessId + ",mIsRegistered=" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
        if (BaseApplicationImpl.sProcessId == 1) {
          localIntentFilter1.addAction("android.intent.action.SCREEN_OFF");
        }
        localIntentFilter1.addAction("com.tencent.gamecenter.action");
        IntentFilter localIntentFilter2 = new IntentFilter();
        localIntentFilter2.addDataScheme("package");
        localIntentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        localIntentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
        BaseApplicationImpl.getContext().registerReceiver(localGameCenterReceiver, localIntentFilter2);
        BaseApplicationImpl.getContext().registerReceiver(localGameCenterReceiver, localIntentFilter1);
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
  
  public static void a(aceg paramaceg)
  {
    if (paramaceg == null) {
      return;
    }
    GameCenterReceiver localGameCenterReceiver = a();
    synchronized (localGameCenterReceiver.jdField_a_of_type_JavaUtilList)
    {
      if (!localGameCenterReceiver.jdField_a_of_type_JavaUtilList.contains(paramaceg)) {
        localGameCenterReceiver.jdField_a_of_type_JavaUtilList.add(paramaceg);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ThreadManagerV2.excute(new GameCenterReceiver.2(this, paramIntent), 16, null, true);
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
    ThreadManagerV2.excute(new GameCenterReceiver.1(this, paramIntent[1], paramString), 16, null, true);
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
    //   12: ldc 175
    //   14: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: invokestatic 80	com/tencent/gamecenter/appointment/GameCenterReceiver:a	()Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   20: astore_0
    //   21: invokestatic 104	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: aload_0
    //   25: invokevirtual 179	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   28: getstatic 22	com/tencent/gamecenter/appointment/GameCenterReceiver:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_0
    //   32: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: astore_0
    //   40: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq -15 -> 28
    //   46: ldc 44
    //   48: iconst_2
    //   49: ldc 181
    //   51: aload_0
    //   52: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: goto -27 -> 28
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	5	0	localGameCenterReceiver	GameCenterReceiver
    //   39	13	0	localThrowable	Throwable
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	28	39	java/lang/Throwable
    //   3	17	58	finally
    //   17	21	58	finally
    //   21	28	58	finally
    //   28	35	58	finally
    //   40	55	58	finally
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
        bmxq.a().a(false, -1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */