package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsQueryRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class QQNotifyIPCModule$QQNotifyObserver
  implements EIPCResultCallback, BusinessObserver
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private WeakReference<QQNotifyUtils.QQNotifyListener> jdField_a_of_type_MqqUtilWeakReference;
  
  public QQNotifyIPCModule$QQNotifyObserver(QQNotifyUtils.QQNotifyListener paramQQNotifyListener, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQNotifyListener);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QQNotifyUtils.QQNotifyListener localQQNotifyListener = (QQNotifyUtils.QQNotifyListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQNotifyListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " onCallback mRef is empty");
      }
      return;
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {
      paramEIPCResult = paramEIPCResult.data;
    } else {
      paramEIPCResult = QQNotifyUtils.a(-100, "client_unknown_error");
    }
    localQQNotifyListener.queryHasSetNotify(paramEIPCResult, this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQNotifyObserver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQNotifyUtils.QQNotifyListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " mRef is empty");
      }
      return;
    }
    paramInt = -100;
    int i = -1;
    paramBundle = paramBundle.getSerializable("rsp");
    if ((paramBundle instanceof AcsQueryRsp))
    {
      AcsQueryRsp localAcsQueryRsp = (AcsQueryRsp)paramBundle;
      paramBundle = localAcsQueryRsp.err_str;
      paramInt = localAcsQueryRsp.ret_code;
      i = localAcsQueryRsp.subscribed;
    }
    else
    {
      paramBundle = "client_unknown_error";
    }
    ((QQNotifyUtils.QQNotifyListener)localObject).queryHasSetNotify(QQNotifyUtils.a(paramInt, paramBundle, i), this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyIPCModule.QQNotifyObserver
 * JD-Core Version:    0.7.0.1
 */