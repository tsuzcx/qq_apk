package com.tencent.biz.videostory.video;

import android.opengl.EGLContext;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import xhq;

public class SimpleGLThread$1
  implements Runnable
{
  public SimpleGLThread$1(xhq paramxhq, EGLContext paramEGLContext) {}
  
  public void run()
  {
    xhq.a(this.this$0, new EglCore(this.a, 0));
    xhq.a(this.this$0, new OffscreenSurface(xhq.a(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    xhq.a(this.this$0).makeCurrent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.1
 * JD-Core Version:    0.7.0.1
 */