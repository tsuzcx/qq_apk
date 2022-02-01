package com.tencent.mobileqq.activity.aio.roam;

import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class C2CRoamMsgFetcher$2
  extends WtloginObserver
{
  C2CRoamMsgFetcher$2(C2CRoamMsgFetcher paramC2CRoamMsgFetcher, long paramLong, int[] paramArrayOfInt, DevlockInfo[] paramArrayOfDevlockInfo) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("CheckDevLockStatus ret: ");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo.append(", has devinfo: ");
      boolean bool;
      if (paramDevlockInfo == null) {
        bool = true;
      } else {
        bool = false;
      }
      paramWUserSigInfo.append(bool);
      paramWUserSigInfo.append(", cost: ");
      paramWUserSigInfo.append(l - this.jdField_a_of_type_Long);
      paramWUserSigInfo.append("ms");
      QLog.d("C2CMsgRoamProxy", 2, paramWUserSigInfo.toString());
    }
    this.jdField_a_of_type_ArrayOfInt[0] = paramInt;
    this.jdField_a_of_type_ArrayOfOicqWlogin_sdkDevicelockDevlockInfo[0] = paramDevlockInfo;
    C2CRoamMsgFetcher.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher.2
 * JD-Core Version:    0.7.0.1
 */