package com.tencent.biz.troopgift;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class TroopGiftPanel$8
  implements Runnable
{
  TroopGiftPanel$8(TroopGiftPanel paramTroopGiftPanel, AppInterface paramAppInterface, String paramString1, String paramString2, Handler paramHandler) {}
  
  public void run()
  {
    Object localObject;
    if (((TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString, this.b) != null)
    {
      localObject = ContactUtils.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopGiftPanel.8.1(this, (String)localObject));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last receiver is not in troop, troopUin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", memberUin=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject).toString());
    }
    TroopGiftAioPanelData.b(this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.8
 * JD-Core Version:    0.7.0.1
 */