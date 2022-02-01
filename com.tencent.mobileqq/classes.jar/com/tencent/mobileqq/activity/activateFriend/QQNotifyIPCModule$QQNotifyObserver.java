package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsQueryRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
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
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {}
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = QQNotifyUtils.a(-100, "client_unknown_error"))
    {
      localQQNotifyListener.queryHasSetNotify(paramEIPCResult, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNotifyObserver", 2, "type:" + paramInt + " isSuccess:" + paramBoolean);
    }
    QQNotifyUtils.QQNotifyListener localQQNotifyListener = (QQNotifyUtils.QQNotifyListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQNotifyListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyObserver", 2, " mRef is empty");
      }
      return;
    }
    paramInt = -1;
    Serializable localSerializable = paramBundle.getSerializable("rsp");
    int i;
    if ((localSerializable instanceof AcsQueryRsp))
    {
      paramBundle = ((AcsQueryRsp)localSerializable).err_str;
      i = ((AcsQueryRsp)localSerializable).ret_code;
      paramInt = ((AcsQueryRsp)localSerializable).subscribed;
    }
    for (;;)
    {
      localQQNotifyListener.queryHasSetNotify(QQNotifyUtils.a(i, paramBundle, paramInt), this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = -100;
      paramBundle = "client_unknown_error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyIPCModule.QQNotifyObserver
 * JD-Core Version:    0.7.0.1
 */