package com.tencent.biz.troopgift;

import aasj;
import android.os.Handler;
import bglf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class TroopGiftPanel$8
  implements Runnable
{
  TroopGiftPanel$8(TroopGiftPanel paramTroopGiftPanel, AppInterface paramAppInterface, String paramString1, String paramString2, Handler paramHandler) {}
  
  public void run()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString, this.b) != null)
    {
      String str = bglf.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopGiftPanel.8.1(this, str));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "last receiver is not in troop, troopUin=" + this.jdField_a_of_type_JavaLangString + ", memberUin=" + this.b);
    }
    aasj.b(this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.8
 * JD-Core Version:    0.7.0.1
 */