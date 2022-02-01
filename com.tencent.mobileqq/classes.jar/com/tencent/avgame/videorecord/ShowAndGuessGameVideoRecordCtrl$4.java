package com.tencent.avgame.videorecord;

import com.tencent.qav.log.AVLog;

class ShowAndGuessGameVideoRecordCtrl$4
  implements Runnable
{
  ShowAndGuessGameVideoRecordCtrl$4(ShowAndGuessGameVideoRecordCtrl paramShowAndGuessGameVideoRecordCtrl) {}
  
  public void run()
  {
    AVLog.a(this.this$0.a, "onEncodeError man call check");
    if (ShowAndGuessGameVideoRecordCtrl.a(this.this$0))
    {
      AVLog.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      this.this$0.a(ShowAndGuessGameVideoRecordCtrl.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */