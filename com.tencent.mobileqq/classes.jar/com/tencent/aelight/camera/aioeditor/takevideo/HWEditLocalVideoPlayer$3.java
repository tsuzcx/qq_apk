package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;

class HWEditLocalVideoPlayer$3
  implements Runnable
{
  HWEditLocalVideoPlayer$3(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a.p) {
      return;
    }
    this.this$0.a.a(Message.obtain(null, 13, new Long[] { Long.valueOf(this.a / 1000000L), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */