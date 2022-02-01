package com.tencent.mobileqq.ark.API;

import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

class TroopArkHelper$1
  implements TroopPluginManager.TroopPluginCallback
{
  TroopArkHelper$1(TroopArkHelper paramTroopArkHelper, QQAppInterface paramQQAppInterface) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArkAPITroopArkHelper.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqArkAPITroopArkHelper.jdField_a_of_type_JavaLangString), true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.TroopArkHelper.1
 * JD-Core Version:    0.7.0.1
 */