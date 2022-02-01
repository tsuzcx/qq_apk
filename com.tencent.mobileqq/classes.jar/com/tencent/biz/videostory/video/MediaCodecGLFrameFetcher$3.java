package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import zxv;
import zxw;
import zya;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(zxw paramzxw) {}
  
  public void run()
  {
    if (zxw.a(this.this$0) == null) {
      return;
    }
    zxw.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, zxw.a(this.this$0), zxw.b(this.this$0));
    zxw.a(this.this$0).a(zxw.a(this.this$0), zxw.c(this.this$0));
    if ((zxw.a(this.this$0) != null) && (!zxw.a(this.this$0).isRecycled())) {
      zxw.a(this.this$0).recycle();
    }
    zxw.a(this.this$0, zxv.a(zxw.c(this.this$0), zxw.a(this.this$0), zxw.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */