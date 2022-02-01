package com.tencent.av.ui;

import android.widget.ImageButton;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class VideoInviteActivity$2
  implements ActionSheet.OnDismissListener
{
  VideoInviteActivity$2(VideoInviteActivity paramVideoInviteActivity, boolean paramBoolean) {}
  
  public void onDismiss()
  {
    String str;
    if (this.a)
    {
      if (this.b.g) {
        str = "0X80043A4";
      } else {
        str = "0X80043B6";
      }
    }
    else if (this.b.g) {
      str = "0X80043AA";
    } else {
      str = "0X80043B0";
    }
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, Integer.toString(this.b.i), Integer.toString(this.b.K), "", "");
    if ((this.b.B != null) && (this.b.C != null))
    {
      this.b.B.setEnabled(true);
      this.b.C.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.2
 * JD-Core Version:    0.7.0.1
 */