package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class NewAuthDevUgFragment$VerifyObserverWrapper
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  private WeakReference<VerifyDevLockManager.VerifyDevLockObserver> a;
  
  public NewAuthDevUgFragment$VerifyObserverWrapper(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    this.a = new WeakReference(paramVerifyDevLockObserver);
  }
  
  public void onReceive(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.a.get() == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onReceive mObserver.get() is null");
      return;
    }
    ((VerifyDevLockManager.VerifyDevLockObserver)this.a.get()).onReceive(paramInt1, paramInt2, paramObject);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.get() == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onVerifyClose mObserver.get() is null");
      return;
    }
    ((VerifyDevLockManager.VerifyDevLockObserver)this.a.get()).onVerifyClose(paramInt1, paramString, paramInt2, paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.VerifyObserverWrapper
 * JD-Core Version:    0.7.0.1
 */