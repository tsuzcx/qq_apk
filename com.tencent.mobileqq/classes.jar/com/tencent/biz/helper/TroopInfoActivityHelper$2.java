package com.tencent.biz.helper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class TroopInfoActivityHelper$2
  implements BusinessObserver
{
  TroopInfoActivityHelper$2(QQAppInterface paramQQAppInterface, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.a("");
      return;
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.helper.TroopInfoActivityHelper.2
 * JD-Core Version:    0.7.0.1
 */