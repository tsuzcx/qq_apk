package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess;
import com.tencent.filter.BaseFilter;

class PngsCreator$5
  implements Runnable
{
  PngsCreator$5(PngsCreator paramPngsCreator) {}
  
  public void run()
  {
    PngsCreator.e(this.this$0).c();
    if (PngsCreator.d(this.this$0) != null) {
      PngsCreator.d(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = PngsCreator.a(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    PngsCreator.b(this.this$0).clearGLSLSelf();
    PngsCreator.c(this.this$0).b();
    PngsCreator.f(this.this$0).clear();
    PngsCreator.g(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreator.5
 * JD-Core Version:    0.7.0.1
 */