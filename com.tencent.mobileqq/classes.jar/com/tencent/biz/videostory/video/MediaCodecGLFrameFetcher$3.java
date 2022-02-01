package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;

class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  MediaCodecGLFrameFetcher$3(MediaCodecGLFrameFetcher paramMediaCodecGLFrameFetcher) {}
  
  public void run()
  {
    if (MediaCodecGLFrameFetcher.c(this.this$0) == null) {
      return;
    }
    MediaCodecGLFrameFetcher.c(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, MediaCodecGLFrameFetcher.d(this.this$0), MediaCodecGLFrameFetcher.e(this.this$0));
    MediaCodecGLFrameFetcher.g(this.this$0).a(MediaCodecGLFrameFetcher.c(this.this$0), MediaCodecGLFrameFetcher.f(this.this$0));
    if ((MediaCodecGLFrameFetcher.h(this.this$0) != null) && (!MediaCodecGLFrameFetcher.h(this.this$0).isRecycled())) {
      MediaCodecGLFrameFetcher.h(this.this$0).recycle();
    }
    MediaCodecGLFrameFetcher localMediaCodecGLFrameFetcher = this.this$0;
    MediaCodecGLFrameFetcher.a(localMediaCodecGLFrameFetcher, GlUtil.a(MediaCodecGLFrameFetcher.f(localMediaCodecGLFrameFetcher), MediaCodecGLFrameFetcher.d(this.this$0), MediaCodecGLFrameFetcher.e(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */