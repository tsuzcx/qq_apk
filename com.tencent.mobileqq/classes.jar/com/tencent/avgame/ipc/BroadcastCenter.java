package com.tencent.avgame.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class BroadcastCenter
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private AccountReceiver jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = null;
  private ExitReceiver jdField_a_of_type_ComTencentAvgameIpcExitReceiver = null;
  private final WeakReference<AppRuntime> jdField_a_of_type_MqqUtilWeakReference;
  
  public BroadcastCenter(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
  }
  
  private void a(AccountReceiver.AccountListener paramAccountListener, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = new AccountReceiver(paramAccountListener, paramString);
    paramAccountListener = new IntentFilter();
    Object localObject = this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver.a();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramAccountListener.addAction(localCharSequence);
      }
      i += 1;
    }
    try
    {
      paramAccountListener = MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver, paramAccountListener, "com.tencent.msg.permission.pushnotify", null);
      if (paramAccountListener == null) {
        this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("registerAccountReceiver, packageName[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], intent[");
        ((StringBuilder)localObject).append(paramAccountListener);
        ((StringBuilder)localObject).append("]");
        QLog.i("BroadcastCenter", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramAccountListener)
    {
      QLog.i("BroadcastCenter", 1, "register2", paramAccountListener);
    }
  }
  
  public void a()
  {
    Object localObject2 = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    Object localObject3 = new AVGameBroadcastReceiver((AppRuntime)localObject2);
    String[] arrayOfString = ((AVGameBroadcastReceiver)localObject3).a();
    int j = 0;
    IntentFilter localIntentFilter;
    int k;
    int i;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localIntentFilter = new IntentFilter();
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          localIntentFilter.addAction(str);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = ((BroadcastReceiver)localObject3);
    }
    else
    {
      localIntentFilter = null;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (localIntentFilter != null))
    {
      try
      {
        localObject3 = MobileQQ.sMobileQQ;
        MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
      catch (Throwable localThrowable1)
      {
        QLog.i("BroadcastCenter", 1, "register", localThrowable1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(100);
        ((StringBuilder)localObject1).append("register, actions[");
        k = arrayOfString.length;
        i = j;
        while (i < k)
        {
          ((StringBuilder)localObject1).append(arrayOfString[i]);
          ((StringBuilder)localObject1).append(",");
          i += 1;
        }
        ((StringBuilder)localObject1).append("]");
        QLog.i("BroadcastCenter", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if ((localObject2 instanceof BaseAVGameAppInterface))
    {
      localObject1 = (BaseAVGameAppInterface)localObject2;
      a((AccountReceiver.AccountListener)localObject1, ((BaseAVGameAppInterface)localObject1).getApp().getPackageName());
    }
    if ((this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver == null) && ((localObject2 instanceof AppInterface)))
    {
      this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver = new ExitReceiver((AppInterface)localObject2);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.process.exit");
      try
      {
        localObject2 = MobileQQ.sMobileQQ;
        MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver, (IntentFilter)localObject1);
        return;
      }
      catch (Throwable localThrowable2)
      {
        QLog.i("BroadcastCenter", 1, "register", localThrowable2);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      try
      {
        MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
        MobileQQ.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      catch (Throwable localThrowable1)
      {
        QLog.i("BroadcastCenter", 1, "unregister", localThrowable1);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver != null) {
      try
      {
        MobileQQ.sMobileQQ.getApplicationContext().unregisterReceiver(this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver);
        this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = null;
      }
      catch (Throwable localThrowable2)
      {
        QLog.i("BroadcastCenter", 1, "unregister2", localThrowable2);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver != null) {
      try
      {
        MobileQQ.sMobileQQ.getApplicationContext().unregisterReceiver(this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver);
        this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver = null;
        return;
      }
      catch (Throwable localThrowable3)
      {
        QLog.i("BroadcastCenter", 1, "unregister2", localThrowable3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.BroadcastCenter
 * JD-Core Version:    0.7.0.1
 */