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
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return;
    }
    paramTroopInfo = paramTroopInfo.troopuin;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramTroopInfo)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver) {
      this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = null;
    }
    paramTroopInfo = new StringBuilder();
    paramTroopInfo.append("onGetSimpleTroopInfoResult, isSuc[");
    paramTroopInfo.append(paramBoolean);
    paramTroopInfo.append("]");
    QLog.w("ShareChat", 1, paramTroopInfo.toString());
    this.jdField_a_of_type_ComTencentAvShareShareChat.a();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateTroopList, isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */