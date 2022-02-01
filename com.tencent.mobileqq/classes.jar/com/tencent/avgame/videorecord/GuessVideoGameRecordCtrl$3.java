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
      GuessVideoGameRecordCtrl localGuessVideoGameRecordCtrl = this.this$0;
      localGuessVideoGameRecordCtrl.a(GuessVideoGameRecordCtrl.b(localGuessVideoGameRecordCtrl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */