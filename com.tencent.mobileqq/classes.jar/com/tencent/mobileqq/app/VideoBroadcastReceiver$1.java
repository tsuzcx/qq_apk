package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;

class VideoBroadcastReceiver$1
  implements DialogInterface.OnClickListener
{
  VideoBroadcastReceiver$1(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoMsgTools.a(this.a, this.b, this.c, this.d ^ true, this.e, this.f, this.g, null, true, new Object[0]);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    DataReport.b(this.a.isBackgroundPause, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */