package com.tencent.avgame.videorecord;

import bjcq;
import ngv;

public class GuessSongGameRecordCtrl$3
  implements Runnable
{
  public GuessSongGameRecordCtrl$3(ngv paramngv) {}
  
  public void run()
  {
    bjcq.a(this.this$0.a, "onEncodeError man call check ");
    if (ngv.a(this.this$0))
    {
      bjcq.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(ngv.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */