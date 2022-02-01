package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$8
  implements DialogInterface.OnClickListener
{
  VideoControlUI$8(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a != null) {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionDialog.Cancel, seq[" + this.jdField_a_of_type_Long + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.8
 * JD-Core Version:    0.7.0.1
 */