package com.tencent.avgame.ui;

import nje;

class AvGameLoadingActivity$8
  implements Runnable
{
  AvGameLoadingActivity$8(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void run()
  {
    if (AvGameLoadingActivity.a(this.this$0))
    {
      AvGameLoadingActivity.b(this.this$0);
      return;
    }
    nje.a().a("param_StepRoomProto");
    if (AvGameLoadingActivity.f(this.this$0))
    {
      AvGameLoadingActivity.a(this.this$0, AvGameLoadingActivity.a(this.this$0), AvGameLoadingActivity.c(this.this$0));
      return;
    }
    AvGameLoadingActivity.a(this.this$0, AvGameLoadingActivity.a(this.this$0), AvGameLoadingActivity.d(this.this$0), AvGameLoadingActivity.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.8
 * JD-Core Version:    0.7.0.1
 */