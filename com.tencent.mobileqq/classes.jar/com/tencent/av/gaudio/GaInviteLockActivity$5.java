package com.tencent.av.gaudio;

import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel.SlideAcceptListener;
import com.tencent.mobileqq.statistics.ReportController;

class GaInviteLockActivity$5
  implements QavPanel.SlideAcceptListener
{
  GaInviteLockActivity$5(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (GaInviteLockActivity.b(this.a))) {
      return;
    }
    if ((this.a.a.d) || (this.a.a.l())) {
      this.a.e();
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X800420E", "0X800420E", 0, 0, "", "", "", "");
      return;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.5
 * JD-Core Version:    0.7.0.1
 */