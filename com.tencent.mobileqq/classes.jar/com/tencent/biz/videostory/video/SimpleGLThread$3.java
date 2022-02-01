package com.tencent.biz.videostory.video;

import abbq;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;

public class SimpleGLThread$3
  implements Runnable
{
  public SimpleGLThread$3(abbq paramabbq) {}
  
  public void run()
  {
    abbq.a(this.this$0).release();
    abbq.a(this.this$0).release();
    abbq.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.3
 * JD-Core Version:    0.7.0.1
 */