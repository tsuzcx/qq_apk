package com.tencent.avgame.ui;

import com.tencent.avgame.report.AVGamePerfReporter;

class AvGameLoadingActivity$9
  implements Runnable
{
  AvGameLoadingActivity$9(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void run()
  {
    if (AvGameLoadingActivity.a(this.this$0))
    {
      AvGameLoadingActivity.p(this.this$0);
      return;
    }
    if (AvGameLoadingActivity.q(this.this$0))
    {
      AvGameLoadingActivity.r(this.this$0);
      return;
    }
    if (AvGameLoadingActivity.e(this.this$0))
    {
      AvGameLoadingActivity.s(this.this$0);
      return;
    }
    AVGamePerfReporter.a().a("param_StepRoomProto");
    if (AvGameLoadingActivity.t(this.this$0))
    {
      localAvGameLoadingActivity = this.this$0;
      AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), AvGameLoadingActivity.n(this.this$0));
      return;
    }
    AvGameLoadingActivity localAvGameLoadingActivity = this.this$0;
    AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), AvGameLoadingActivity.u(this.this$0), AvGameLoadingActivity.n(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.9
 * JD-Core Version:    0.7.0.1
 */