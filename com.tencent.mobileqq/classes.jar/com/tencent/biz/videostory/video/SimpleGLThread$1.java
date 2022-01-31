package com.tencent.biz.videostory.video;

import android.opengl.EGLContext;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import wyq;

public class SimpleGLThread$1
  implements Runnable
{
  public SimpleGLThread$1(wyq paramwyq, EGLContext paramEGLContext) {}
  
  public void run()
  {
    wyq.a(this.this$0, new EglCore(this.a, 0));
    wyq.a(this.this$0, new OffscreenSurface(wyq.a(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    wyq.a(this.this$0).makeCurrent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.1
 * JD-Core Version:    0.7.0.1
 */