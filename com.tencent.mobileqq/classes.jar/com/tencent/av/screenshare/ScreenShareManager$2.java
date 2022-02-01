package com.tencent.av.screenshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class ScreenShareManager$2
  implements DialogInterface.OnClickListener
{
  ScreenShareManager$2(ScreenShareManager paramScreenShareManager, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.a(false);
    ReportController.b(null, "dc00898", "", "", "0X800B8AA", "0X800B8AA", 0, 0, this.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareManager.2
 * JD-Core Version:    0.7.0.1
 */