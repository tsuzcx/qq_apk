package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import zap;
import zaq;
import zau;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(zaq paramzaq) {}
  
  public void run()
  {
    if (zaq.a(this.this$0) == null) {
      return;
    }
    zaq.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, zaq.a(this.this$0), zaq.b(this.this$0));
    zaq.a(this.this$0).a(zaq.a(this.this$0), zaq.c(this.this$0));
    if ((zaq.a(this.this$0) != null) && (!zaq.a(this.this$0).isRecycled())) {
      zaq.a(this.this$0).recycle();
    }
    zaq.a(this.this$0, zap.a(zaq.c(this.this$0), zaq.a(this.this$0), zaq.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */