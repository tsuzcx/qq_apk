package com.tencent.biz.videostory.video;

import aanh;
import aani;
import aanm;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(aani paramaani) {}
  
  public void run()
  {
    if (aani.a(this.this$0) == null) {
      return;
    }
    aani.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, aani.a(this.this$0), aani.b(this.this$0));
    aani.a(this.this$0).a(aani.a(this.this$0), aani.c(this.this$0));
    if ((aani.a(this.this$0) != null) && (!aani.a(this.this$0).isRecycled())) {
      aani.a(this.this$0).recycle();
    }
    aani.a(this.this$0, aanh.a(aani.c(this.this$0), aani.a(this.this$0), aani.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */