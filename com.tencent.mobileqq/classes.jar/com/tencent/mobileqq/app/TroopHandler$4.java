package com.tencent.mobileqq.app;

import android.os.SystemClock;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class TroopHandler$4
  extends LbsManagerServiceOnLocationChangeListener
{
  TroopHandler$4(TroopHandler paramTroopHandler, String paramString1, long paramLong, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "onLocationFinish, time=" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if (paramInt != 0) {
      QLog.i("TroopHandler", 1, "getDetailOnlineMemberList, startLocation, errorCode=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_JavaLangString, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.4
 * JD-Core Version:    0.7.0.1
 */