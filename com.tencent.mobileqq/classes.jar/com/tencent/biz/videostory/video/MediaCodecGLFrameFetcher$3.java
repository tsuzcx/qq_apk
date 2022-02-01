package com.tencent.biz.videostory.video;

import aaxh;
import aaxi;
import aaxm;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(aaxi paramaaxi) {}
  
  public void run()
  {
    if (aaxi.a(this.this$0) == null) {
      return;
    }
    aaxi.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, aaxi.a(this.this$0), aaxi.b(this.this$0));
    aaxi.a(this.this$0).a(aaxi.a(this.this$0), aaxi.c(this.this$0));
    if ((aaxi.a(this.this$0) != null) && (!aaxi.a(this.this$0).isRecycled())) {
      aaxi.a(this.this$0).recycle();
    }
    aaxi.a(this.this$0, aaxh.a(aaxi.c(this.this$0), aaxi.a(this.this$0), aaxi.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */