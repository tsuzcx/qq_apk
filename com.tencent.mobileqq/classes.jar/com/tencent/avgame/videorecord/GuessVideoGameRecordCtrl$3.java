package com.tencent.avgame.videorecord;

import bjuc;
import nrh;

public class GuessVideoGameRecordCtrl$3
  implements Runnable
{
  public GuessVideoGameRecordCtrl$3(nrh paramnrh) {}
  
  public void run()
  {
    bjuc.a(this.this$0.a, "onEncodeError man call check");
    if (nrh.a(this.this$0))
    {
      bjuc.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nrh.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */