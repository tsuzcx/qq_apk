package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class AddContactFindTroopRTLW$1
  extends LbsManagerServiceOnLocationChangeListener
{
  AddContactFindTroopRTLW$1(AddContactFindTroopRTLW paramAddContactFindTroopRTLW, String paramString, TroopHandler paramTroopHandler, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 1, "getRecommendTroopList onLocationFinish, errorCode=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW.b, 25, this.jdField_a_of_type_Boolean, AddContactFindTroopRTLW.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopRTLW.1
 * JD-Core Version:    0.7.0.1
 */