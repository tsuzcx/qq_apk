package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import wyk;
import wyl;
import wyp;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(wyl paramwyl) {}
  
  public void run()
  {
    if (wyl.a(this.this$0) == null) {
      return;
    }
    wyl.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, wyl.a(this.this$0), wyl.b(this.this$0));
    wyl.a(this.this$0).a(wyl.a(this.this$0), wyl.c(this.this$0));
    if ((wyl.a(this.this$0) != null) && (!wyl.a(this.this$0).isRecycled())) {
      wyl.a(this.this$0).recycle();
    }
    wyl.a(this.this$0, wyk.a(wyl.c(this.this$0), wyl.a(this.this$0), wyl.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */