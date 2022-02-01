package com.tencent.avgame.gameroom.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUI$3
  implements DialogInterface.OnClickListener
{
  AVGameControlUI$3(AVGameControlUI paramAVGameControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionNormalDialog.Cancel, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI.3
 * JD-Core Version:    0.7.0.1
 */