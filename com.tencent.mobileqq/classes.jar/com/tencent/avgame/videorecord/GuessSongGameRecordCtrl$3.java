package com.tencent.avgame.videorecord;

import bkdp;
import niq;

public class GuessSongGameRecordCtrl$3
  implements Runnable
{
  public GuessSongGameRecordCtrl$3(niq paramniq) {}
  
  public void run()
  {
    bkdp.a(this.this$0.a, "onEncodeError man call check ");
    if (niq.a(this.this$0))
    {
      bkdp.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(niq.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */