package com.tencent.avgame.videorecord;

import bkdp;
import nis;

public class GuessVideoGameRecordCtrl$3
  implements Runnable
{
  public GuessVideoGameRecordCtrl$3(nis paramnis) {}
  
  public void run()
  {
    bkdp.a(this.this$0.a, "onEncodeError man call check");
    if (nis.a(this.this$0))
    {
      bkdp.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nis.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */