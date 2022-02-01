package com.tencent.mobileqq.activity.aio.doodle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.statistics.ReportController;

class DoodlePanel$7
  implements DialogInterface.OnClickListener
{
  DoodlePanel$7(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ReportController.b(this.a.b, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 1, "", "", "", "");
      DoodlePanel.c(this.a).b(1);
      return;
    }
    ReportController.b(this.a.b, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.7
 * JD-Core Version:    0.7.0.1
 */