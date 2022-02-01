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
    paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionNormalDialog.gotoSetting, seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
    UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.5
 * JD-Core Version:    0.7.0.1
 */