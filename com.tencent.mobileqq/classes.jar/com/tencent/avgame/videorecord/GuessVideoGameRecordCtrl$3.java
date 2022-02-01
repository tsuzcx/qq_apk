package com.tencent.avgame.videorecord;

import bija;
import nkh;

public class GuessVideoGameRecordCtrl$3
  implements Runnable
{
  public GuessVideoGameRecordCtrl$3(nkh paramnkh) {}
  
  public void run()
  {
    bija.a(this.this$0.a, "onEncodeError man call check");
    if (nkh.a(this.this$0))
    {
      bija.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nkh.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */