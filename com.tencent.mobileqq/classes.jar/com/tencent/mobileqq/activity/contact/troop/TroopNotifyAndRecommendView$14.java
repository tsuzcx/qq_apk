package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotifyAndRecommendView$14
  extends TroopBindPubAccountProtocol.FollowPublicAccountObserver
{
  TroopNotifyAndRecommendView$14(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
        localStructMsg.mergeFrom(paramBundle);
        TroopNotifyAndRecommendView.a(this.a, 1, localStructMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopNotifyAndRecommendView", 2, "structMsg merge error");
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697365), 0).b(this.a.a());
        return;
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697365), 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.14
 * JD-Core Version:    0.7.0.1
 */