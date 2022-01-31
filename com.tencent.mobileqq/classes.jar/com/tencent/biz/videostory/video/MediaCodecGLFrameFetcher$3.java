package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import ywa;
import ywb;
import ywf;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(ywb paramywb) {}
  
  public void run()
  {
    if (ywb.a(this.this$0) == null) {
      return;
    }
    ywb.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, ywb.a(this.this$0), ywb.b(this.this$0));
    ywb.a(this.this$0).a(ywb.a(this.this$0), ywb.c(this.this$0));
    if ((ywb.a(this.this$0) != null) && (!ywb.a(this.this$0).isRecycled())) {
      ywb.a(this.this$0).recycle();
    }
    ywb.a(this.this$0, ywa.a(ywb.c(this.this$0), ywb.a(this.this$0), ywb.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */