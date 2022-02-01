package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$5
  implements DialogInterface.OnClickListener
{
  VideoControlUI$5(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.5
 * JD-Core Version:    0.7.0.1
 */