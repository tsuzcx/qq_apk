package com.tencent.avgame.gameroom.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUI$2
  implements DialogInterface.OnClickListener
{
  AVGameControlUI$2(AVGameControlUI paramAVGameControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a()) {}
    do
    {
      return;
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a();
      QLog.w(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "], activity[" + paramDialogInterface + "]");
    } while (paramDialogInterface == null);
    AVGameUtils.a(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI.2
 * JD-Core Version:    0.7.0.1
 */