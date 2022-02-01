package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SendMultiPictureHelper$3
  implements DialogInterface.OnClickListener
{
  SendMultiPictureHelper$3(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      paramDialogInterface = this.a;
      paramDialogInterface.b = true;
      SendMultiPictureHelper.a(paramDialogInterface);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.3
 * JD-Core Version:    0.7.0.1
 */