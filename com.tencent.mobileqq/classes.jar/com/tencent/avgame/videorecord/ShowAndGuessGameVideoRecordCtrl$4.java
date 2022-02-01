package com.tencent.avgame.videorecord;

import bjuc;
import nrk;

public class ShowAndGuessGameVideoRecordCtrl$4
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$4(nrk paramnrk) {}
  
  public void run()
  {
    bjuc.a(this.this$0.a, "onEncodeError man call check");
    if (nrk.a(this.this$0))
    {
      bjuc.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nrk.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */