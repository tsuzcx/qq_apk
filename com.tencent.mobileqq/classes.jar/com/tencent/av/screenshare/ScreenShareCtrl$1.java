package com.tencent.av.screenshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class ScreenShareCtrl$1
  implements DialogInterface.OnClickListener
{
  ScreenShareCtrl$1(ScreenShareCtrl paramScreenShareCtrl, AVActivity paramAVActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AVShare", 2, "startOrStopScreenShare, onClick");
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(2);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiAVActivity.a())
    {
      if (paramDialogInterface != null) {
        paramDialogInterface.a(1);
      }
      ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).a.a(new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      paramDialogInterface = ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).a();
      TraeHelper.a().b(this.jdField_a_of_type_Long);
      paramDialogInterface.f = false;
      paramDialogInterface.z = 1;
      paramDialogInterface.t = true;
      String str = paramDialogInterface.d;
      ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).l();
      ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).a(str, 237);
      ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).b(237);
      ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).b(str, paramDialogInterface.z);
      paramDialogInterface.a("onClick_HangeUP", false);
      paramDialogInterface.b("onClick_HangeUP", 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.1
 * JD-Core Version:    0.7.0.1
 */