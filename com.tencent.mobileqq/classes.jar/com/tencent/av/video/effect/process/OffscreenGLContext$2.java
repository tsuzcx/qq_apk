package com.tencent.av.video.effect.process;

import android.os.Handler;
import android.os.Looper;

class OffscreenGLContext$2
  implements Runnable
{
  OffscreenGLContext$2(OffscreenGLContext paramOffscreenGLContext) {}
  
  public void run()
  {
    OffscreenGLContext.access$000(this.this$0).release();
    OffscreenGLContext.access$100(this.this$0).getLooper().quit();
    OffscreenGLContext.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.process.OffscreenGLContext.2
 * JD-Core Version:    0.7.0.1
 */