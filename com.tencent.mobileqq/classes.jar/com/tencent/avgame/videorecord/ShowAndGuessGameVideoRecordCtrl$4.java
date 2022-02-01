package com.tencent.avgame.videorecord;

import bjcq;
import nha;

public class ShowAndGuessGameVideoRecordCtrl$4
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$4(nha paramnha) {}
  
  public void run()
  {
    bjcq.a(this.this$0.a, "onEncodeError man call check");
    if (nha.a(this.this$0))
    {
      bjcq.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nha.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */