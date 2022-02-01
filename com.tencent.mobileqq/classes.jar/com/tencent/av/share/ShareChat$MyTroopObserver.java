package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class ShareChat$MyTroopObserver
  extends TroopObserver
{
  String jdField_a_of_type_JavaLangString;
  
  private ShareChat$MyTroopObserver(ShareChat paramShareChat) {}
  
  public void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {}
    do
    {
      return;
      paramTroopInfo = paramTroopInfo.troopuin;
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramTroopInfo)));
    this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver) {
      this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = null;
    }
    QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentAvShareShareChat.a();
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */