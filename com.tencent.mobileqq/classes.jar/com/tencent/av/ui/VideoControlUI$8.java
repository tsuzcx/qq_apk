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
    if (this.b.ak != null)
    {
      paramDialogInterface = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showPermissionDialog.Cancel, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.8
 * JD-Core Version:    0.7.0.1
 */