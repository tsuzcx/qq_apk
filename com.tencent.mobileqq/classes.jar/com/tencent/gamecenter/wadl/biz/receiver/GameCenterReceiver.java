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
    if (jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver == null) {
          jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver = new GameCenterReceiver();
        }
      }
    }
    return jdField_a_of_type_ComTencentGamecenterWadlBizReceiverGameCenterReceiver;
  }
  
  public static void a()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("registerReceiver processId=");
      ((StringBuilder)localObject1).append(MobileQQ.sProcessId);
      ((StringBuilder)localObject1).append(",mIsRegistered=");
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)localObject1).toString());
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
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
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
          catch (Throwable localThrowable)
          {
            b();
            QLog.e("Wadl_GameCenterReceiver", 1, "registerReceiver exception", localThrowable);
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
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addListener listener=");
    ((StringBuilder)???).append(paramGameCenterListener);
    QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)???).toString());
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
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */