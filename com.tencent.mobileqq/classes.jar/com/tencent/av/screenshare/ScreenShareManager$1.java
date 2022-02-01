package com.tencent.av.screenshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;

class ScreenShareManager$1
  implements DialogInterface.OnClickListener
{
  ScreenShareManager$1(ScreenShareManager paramScreenShareManager, ScreenShareCtrl paramScreenShareCtrl, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(AudioHelper.c());
    this.c.a(true);
    ReportController.b(null, "dc00898", "", "", "0X800B8A9", "0X800B8A9", 0, 0, this.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareManager.1
 * JD-Core Version:    0.7.0.1
 */