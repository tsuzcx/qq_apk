package com.tencent.avgame.videorecord;

import bjuc;
import nrf;

public class GuessSongGameRecordCtrl$3
  implements Runnable
{
  public GuessSongGameRecordCtrl$3(nrf paramnrf) {}
  
  public void run()
  {
    bjuc.a(this.this$0.a, "onEncodeError man call check ");
    if (nrf.a(this.this$0))
    {
      bjuc.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nrf.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */