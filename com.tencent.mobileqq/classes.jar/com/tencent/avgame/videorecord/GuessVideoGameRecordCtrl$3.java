package com.tencent.avgame.videorecord;

import bjcq;
import ngx;

public class GuessVideoGameRecordCtrl$3
  implements Runnable
{
  public GuessVideoGameRecordCtrl$3(ngx paramngx) {}
  
  public void run()
  {
    bjcq.a(this.this$0.a, "onEncodeError man call check");
    if (ngx.a(this.this$0))
    {
      bjcq.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(ngx.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */