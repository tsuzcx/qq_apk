package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1
  implements Runnable
{
  HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1(HWEditLocalVideoPlayer.ConvertIFramesRunnable.1 param1) {}
  
  public void run()
  {
    HWEditLocalVideoPlayer.a(this.a.b.this$0, null);
    if (!HWEditLocalVideoPlayer.e(this.a.b.this$0))
    {
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
      return;
    }
    if ((this.a.b.this$0.t.P != null) && (this.a.b.this$0.t.P.k() == 3) && (this.a.b.c == this.a.b.this$0.d)) {
      HWEditLocalVideoPlayer.a(this.a.b.this$0, this.a.a);
    }
    HWEditLocalVideoPlayer.f(this.a.b.this$0);
    HWEditLocalVideoPlayer.a(this.a.b.this$0, this.a.b.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1
 * JD-Core Version:    0.7.0.1
 */