package com.tencent.avgame.videorecord;

import bkdp;
import niv;

public class ShowAndGuessGameVideoRecordCtrl$4
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$4(niv paramniv) {}
  
  public void run()
  {
    bkdp.a(this.this$0.a, "onEncodeError man call check");
    if (niv.a(this.this$0))
    {
      bkdp.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(niv.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */