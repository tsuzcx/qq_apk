package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;

class VideoBroadcastReceiver$2
  implements DialogInterface.OnClickListener
{
  VideoBroadcastReceiver$2(VideoBroadcastReceiver paramVideoBroadcastReceiver, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataReport.e(false, false);
    paramInt = this.a;
    if (paramInt == 3000)
    {
      VideoMsgTools.a(this.b, paramInt, this.c, false, this.d, this.e, false, null, true, new Object[0]);
      VideoBroadcastReceiver.a(this.h, 3, this.a, this.d, this.f, this.g);
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    DataReport.d(this.b.isBackgroundPause);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver.2
 * JD-Core Version:    0.7.0.1
 */