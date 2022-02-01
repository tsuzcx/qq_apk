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
    if (this.b.V()) {
      return;
    }
    paramDialogInterface = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionNormalDialog.gotoSetting, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
    UITools.a(this.b.U());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.5
 * JD-Core Version:    0.7.0.1
 */