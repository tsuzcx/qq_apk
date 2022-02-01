package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class PhoneUnityBindInfoActivity$4
  extends WtloginObserver
{
  PhoneUnityBindInfoActivity$4(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, WeakReference paramWeakReference) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    super.onCheckDevLockStatus(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
    paramWUserSigInfo = (PhoneUnityBindInfoActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramWUserSigInfo == null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, activity destroyed");
      return;
    }
    PhoneUnityBindInfoActivity.access$1400(paramWUserSigInfo, paramDevlockInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.4
 * JD-Core Version:    0.7.0.1
 */