package com.tencent.avgame.ui;

import com.tencent.avgame.util.AVGamePerfReporter;

class AvGameLoadingActivity$9
  implements Runnable
{
  AvGameLoadingActivity$9(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void run()
  {
    if (AvGameLoadingActivity.a(this.this$0))
    {
      AvGameLoadingActivity.b(this.this$0);
      return;
    }
    if (AvGameLoadingActivity.i(this.this$0))
    {
      AvGameLoadingActivity.c(this.this$0);
      return;
    }
    if (AvGameLoadingActivity.d(this.this$0))
    {
      AvGameLoadingActivity.d(this.this$0);
      return;
    }
    AVGamePerfReporter.a().a("param_StepRoomProto");
    if (AvGameLoadingActivity.j(this.this$0))
    {
      AvGameLoadingActivity.a(this.this$0, AvGameLoadingActivity.a(this.this$0), AvGameLoadingActivity.c(this.this$0));
      return;
    }
    AvGameLoadingActivity.a(this.this$0, AvGameLoadingActivity.a(this.this$0), AvGameLoadingActivity.d(this.this$0), AvGameLoadingActivity.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.9
 * JD-Core Version:    0.7.0.1
 */