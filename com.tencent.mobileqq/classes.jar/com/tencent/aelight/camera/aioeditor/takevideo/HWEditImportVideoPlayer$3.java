package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;

class HWEditImportVideoPlayer$3
  implements Runnable
{
  HWEditImportVideoPlayer$3(HWEditImportVideoPlayer paramHWEditImportVideoPlayer, long paramLong) {}
  
  public void run()
  {
    long l2 = this.a / 1000000L;
    if (l2 < HWEditImportVideoPlayer.b(this.this$0)) {}
    long l1;
    for (int i = HWEditImportVideoPlayer.b(this.this$0);; i = HWEditImportVideoPlayer.c(this.this$0))
    {
      l1 = i;
      break;
      l1 = l2;
      if (l2 <= HWEditImportVideoPlayer.c(this.this$0)) {
        break;
      }
    }
    if (this.this$0.t.E) {
      return;
    }
    this.this$0.t.a(Message.obtain(null, 13, new Long[] { Long.valueOf(l1), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */