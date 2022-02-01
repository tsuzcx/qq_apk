package com.tencent.av.random;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class RandomController$10
  implements DialogInterface.OnClickListener
{
  RandomController$10(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 1) {
      ReportController.b(null, "CliOper", "", "", "0X80053B4", "0X80053B4", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      RandomController.d(this.a, false);
      return;
      if (RandomController.a(this.a) == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80053C0", "0X80053C0", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomController.10
 * JD-Core Version:    0.7.0.1
 */