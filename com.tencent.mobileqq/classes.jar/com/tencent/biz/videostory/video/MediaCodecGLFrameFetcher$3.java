package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import xhh;
import xhi;
import xhm;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(xhi paramxhi) {}
  
  public void run()
  {
    if (xhi.a(this.this$0) == null) {
      return;
    }
    xhi.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, xhi.a(this.this$0), xhi.b(this.this$0));
    xhi.a(this.this$0).a(xhi.a(this.this$0), xhi.c(this.this$0));
    if ((xhi.a(this.this$0) != null) && (!xhi.a(this.this$0).isRecycled())) {
      xhi.a(this.this$0).recycle();
    }
    xhi.a(this.this$0, xhh.a(xhi.c(this.this$0), xhi.a(this.this$0), xhi.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */