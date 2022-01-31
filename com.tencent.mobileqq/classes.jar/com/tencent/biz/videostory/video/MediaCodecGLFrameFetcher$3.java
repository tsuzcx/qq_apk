package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import xhk;
import xhl;
import xhp;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(xhl paramxhl) {}
  
  public void run()
  {
    if (xhl.a(this.this$0) == null) {
      return;
    }
    xhl.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, xhl.a(this.this$0), xhl.b(this.this$0));
    xhl.a(this.this$0).a(xhl.a(this.this$0), xhl.c(this.this$0));
    if ((xhl.a(this.this$0) != null) && (!xhl.a(this.this$0).isRecycled())) {
      xhl.a(this.this$0).recycle();
    }
    xhl.a(this.this$0, xhk.a(xhl.c(this.this$0), xhl.a(this.this$0), xhl.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */