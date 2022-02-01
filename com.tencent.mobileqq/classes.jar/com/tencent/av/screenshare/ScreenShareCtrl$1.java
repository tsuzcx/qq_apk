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
    this.c.a(2);
    paramDialogInterface = this.a;
    if (paramDialogInterface == null) {
      paramDialogInterface = null;
    } else {
      paramDialogInterface = paramDialogInterface.v();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.b(1);
    }
    ScreenShareCtrl.a(this.c).e.a(new Object[] { Integer.valueOf(106), Long.valueOf(this.b) });
    paramDialogInterface = ScreenShareCtrl.a(this.c).k();
    TraeHelper.a().b(this.b);
    paramDialogInterface.C = false;
    paramDialogInterface.ay = 1;
    paramDialogInterface.R = true;
    String str = paramDialogInterface.s;
    ScreenShareCtrl.a(this.c).G();
    ScreenShareCtrl.a(this.c).a(str, 237);
    ScreenShareCtrl.a(this.c).b(237);
    ScreenShareCtrl.a(this.c).b(str, paramDialogInterface.ay);
    paramDialogInterface.a("onClick_HangeUP", false);
    paramDialogInterface.c("onClick_HangeUP", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.1
 * JD-Core Version:    0.7.0.1
 */