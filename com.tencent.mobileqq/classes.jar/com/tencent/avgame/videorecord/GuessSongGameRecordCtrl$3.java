package com.tencent.avgame.videorecord;

import bija;
import nkf;

public class GuessSongGameRecordCtrl$3
  implements Runnable
{
  public GuessSongGameRecordCtrl$3(nkf paramnkf) {}
  
  public void run()
  {
    bija.a(this.this$0.a, "onEncodeError man call check ");
    if (nkf.a(this.this$0))
    {
      bija.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nkf.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */