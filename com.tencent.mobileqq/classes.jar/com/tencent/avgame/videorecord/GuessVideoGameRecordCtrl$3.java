package com.tencent.avgame.videorecord;

import com.tencent.qav.log.AVLog;

class GuessVideoGameRecordCtrl$3
  implements Runnable
{
  GuessVideoGameRecordCtrl$3(GuessVideoGameRecordCtrl paramGuessVideoGameRecordCtrl) {}
  
  public void run()
  {
    AVLog.a(this.this$0.a, "onEncodeError man call check");
    if (GuessVideoGameRecordCtrl.a(this.this$0))
    {
      AVLog.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(GuessVideoGameRecordCtrl.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */