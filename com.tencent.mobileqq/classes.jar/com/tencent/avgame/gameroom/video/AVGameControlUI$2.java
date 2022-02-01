package com.tencent.avgame.gameroom.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUI$2
  implements DialogInterface.OnClickListener
{
  AVGameControlUI$2(AVGameControlUI paramAVGameControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.b.d()) {
      return;
    }
    paramDialogInterface = this.b.a();
    String str = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionNormalDialog.gotoSetting, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], activity[");
    localStringBuilder.append(paramDialogInterface);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramDialogInterface != null) {
      AVGameUtil.a(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI.2
 * JD-Core Version:    0.7.0.1
 */