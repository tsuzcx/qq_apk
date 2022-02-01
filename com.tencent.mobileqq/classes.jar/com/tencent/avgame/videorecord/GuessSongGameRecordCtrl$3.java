package com.tencent.avgame.videorecord;

import com.tencent.qav.log.AVLog;

class GuessSongGameRecordCtrl$3
  implements Runnable
{
  GuessSongGameRecordCtrl$3(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl) {}
  
  public void run()
  {
    AVLog.a(this.this$0.a, "onEncodeError man call check ");
    if (GuessSongGameRecordCtrl.e(this.this$0))
    {
      AVLog.a(this.this$0.a, "onEncodeError man call onEncodeFinish");
      GuessSongGameRecordCtrl localGuessSongGameRecordCtrl = this.this$0;
      localGuessSongGameRecordCtrl.a(GuessSongGameRecordCtrl.c(localGuessSongGameRecordCtrl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */