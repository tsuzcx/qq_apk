package com.tencent.biz.videostory.video;

import abbk;
import abbl;
import abbp;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(abbl paramabbl) {}
  
  public void run()
  {
    if (abbl.a(this.this$0) == null) {
      return;
    }
    abbl.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, abbl.a(this.this$0), abbl.b(this.this$0));
    abbl.a(this.this$0).a(abbl.a(this.this$0), abbl.c(this.this$0));
    if ((abbl.a(this.this$0) != null) && (!abbl.a(this.this$0).isRecycled())) {
      abbl.a(this.this$0).recycle();
    }
    abbl.a(this.this$0, abbk.a(abbl.c(this.this$0), abbl.a(this.this$0), abbl.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */