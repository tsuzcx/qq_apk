package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$6
  implements DialogInterface.OnClickListener
{
  VideoControlUI$6(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionNormalDialog.Cancel, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.6
 * JD-Core Version:    0.7.0.1
 */