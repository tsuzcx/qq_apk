package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class QQBroadcastActivity$Adapter$1$1
  implements DialogInterface.OnClickListener
{
  QQBroadcastActivity$Adapter$1$1(QQBroadcastActivity.Adapter.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getMessageFacade().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.a(), 0, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.b();
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.getCount() <= 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.a(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.changeCursor(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.getCursor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.1.1
 * JD-Core Version:    0.7.0.1
 */