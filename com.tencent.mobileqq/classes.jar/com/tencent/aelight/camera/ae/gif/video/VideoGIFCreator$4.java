package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.preview.VideoFilterProcess;
import com.tencent.filter.BaseFilter;

class VideoGIFCreator$4
  implements Runnable
{
  VideoGIFCreator$4(VideoGIFCreator paramVideoGIFCreator) {}
  
  public void run()
  {
    VideoGIFCreator.k(this.this$0).b();
    if (VideoGIFCreator.m(this.this$0) != null) {
      VideoGIFCreator.m(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = VideoGIFCreator.d(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (VideoGIFCreator.j(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = VideoGIFCreator.j(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    VideoGIFCreator.e(this.this$0).clearGLSLSelf();
    VideoGIFCreator.f(this.this$0).clearGLSLSelf();
    VideoGIFCreator.g(this.this$0).clearGLSLSelf();
    VideoGIFCreator.h(this.this$0).b();
    VideoGIFCreator.i(this.this$0).clear();
    VideoGIFCreator.n(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */