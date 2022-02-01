package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ShareChat$SharePanel$3
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b + "], mIHandle[" + this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b == -1) && (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle != null)) {
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.3
 * JD-Core Version:    0.7.0.1
 */