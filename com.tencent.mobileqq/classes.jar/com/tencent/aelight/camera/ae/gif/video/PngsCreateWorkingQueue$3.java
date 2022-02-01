package com.tencent.aelight.camera.ae.gif.video;

import android.os.Handler;
import android.os.Looper;

class PngsCreateWorkingQueue$3
  implements Runnable
{
  PngsCreateWorkingQueue$3(PngsCreateWorkingQueue paramPngsCreateWorkingQueue, boolean paramBoolean) {}
  
  public void run()
  {
    PngsCreateWorkingQueue.b(this.this$0).a();
    if (this.a) {
      PngsCreateWorkingQueue.c(this.this$0);
    }
    PngsCreateWorkingQueue.d(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.3
 * JD-Core Version:    0.7.0.1
 */