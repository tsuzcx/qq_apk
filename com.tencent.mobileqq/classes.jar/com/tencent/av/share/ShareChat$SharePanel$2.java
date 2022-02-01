package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ShareChat$SharePanel$2
  implements DialogInterface.OnDismissListener
{
  ShareChat$SharePanel$2(ShareChat.SharePanel paramSharePanel) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("ShareActionSheetBuilder.onDismiss, mChoosedChannel[");
      paramDialogInterface.append(this.a.jdField_a_of_type_Int);
      paramDialogInterface.append("], mIHandle[");
      paramDialogInterface.append(this.a.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle);
      paramDialogInterface.append("]");
      QLog.w("ShareChat", 1, paramDialogInterface.toString());
    }
    if ((this.a.jdField_a_of_type_Int == -1) && (this.a.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle != null))
    {
      paramDialogInterface = this.a;
      paramDialogInterface.a(paramDialogInterface.jdField_a_of_type_Int, this.a.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.2
 * JD-Core Version:    0.7.0.1
 */