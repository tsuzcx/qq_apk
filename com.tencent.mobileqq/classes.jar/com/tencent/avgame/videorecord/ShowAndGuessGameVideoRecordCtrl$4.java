package com.tencent.avgame.videorecord;

import bija;
import nkk;

public class ShowAndGuessGameVideoRecordCtrl$4
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$4(nkk paramnkk) {}
  
  public void run()
  {
    bija.a(this.this$0.a, "onEncodeError man call check");
    if (nkk.a(this.this$0))
    {
      bija.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(nkk.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */