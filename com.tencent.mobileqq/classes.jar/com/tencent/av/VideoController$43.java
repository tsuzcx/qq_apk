package com.tencent.av;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;

class VideoController$43
  implements DialogInterface.OnClickListener
{
  VideoController$43(VideoController paramVideoController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a)
    {
      paramInt = this.c.D();
      paramDialogInterface = this.c;
      paramDialogInterface.a("onHowling_click", paramDialogInterface.k, true, false, -1);
      paramDialogInterface = this.c;
      paramDialogInterface.a(-1L, paramInt, paramDialogInterface.D());
      if (this.c.e != null) {
        this.c.e.a(new Object[] { Integer.valueOf(108) });
      }
    }
    if (this.b) {
      this.c.v.g();
    }
    ReportController.b(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.43
 * JD-Core Version:    0.7.0.1
 */