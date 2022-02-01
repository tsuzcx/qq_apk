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
    VideoGIFCreator.a(this.this$0).a();
    if (VideoGIFCreator.a(this.this$0) != null) {
      VideoGIFCreator.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = VideoGIFCreator.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (VideoGIFCreator.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = VideoGIFCreator.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    VideoGIFCreator.a(this.this$0).clearGLSLSelf();
    VideoGIFCreator.b(this.this$0).clearGLSLSelf();
    VideoGIFCreator.c(this.this$0).clearGLSLSelf();
    VideoGIFCreator.a(this.this$0).b();
    VideoGIFCreator.a(this.this$0).clear();
    VideoGIFCreator.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */