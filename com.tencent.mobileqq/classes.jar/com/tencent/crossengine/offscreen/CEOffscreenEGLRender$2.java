package com.tencent.crossengine.offscreen;

import android.os.Handler;
import java.util.concurrent.Executor;

class CEOffscreenEGLRender$2
  implements Executor
{
  CEOffscreenEGLRender$2(CEOffscreenEGLRender paramCEOffscreenEGLRender) {}
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    CEOffscreenEGLRender.a(this.a).post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenEGLRender.2
 * JD-Core Version:    0.7.0.1
 */