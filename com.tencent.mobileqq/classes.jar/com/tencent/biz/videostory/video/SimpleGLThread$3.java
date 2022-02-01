package com.tencent.biz.videostory.video;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;

class SimpleGLThread$3
  implements Runnable
{
  SimpleGLThread$3(SimpleGLThread paramSimpleGLThread) {}
  
  public void run()
  {
    SimpleGLThread.a(this.this$0).release();
    SimpleGLThread.a(this.this$0).release();
    SimpleGLThread.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.3
 * JD-Core Version:    0.7.0.1
 */