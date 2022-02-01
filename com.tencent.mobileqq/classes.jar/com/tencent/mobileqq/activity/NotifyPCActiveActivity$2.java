package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;

class NotifyPCActiveActivity$2
  implements DialogInterface.OnClickListener
{
  NotifyPCActiveActivity$2(NotifyPCActiveActivity paramNotifyPCActiveActivity, CardHandler paramCardHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(true);
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity.2
 * JD-Core Version:    0.7.0.1
 */