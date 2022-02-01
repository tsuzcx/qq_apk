package com.tencent.crossengine.offscreen;

import android.view.Surface;

class CEOffscreenEGLRender$3
  implements Runnable
{
  CEOffscreenEGLRender$3(CEOffscreenEGLRender paramCEOffscreenEGLRender, Surface paramSurface, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    CEOffscreenEGLRender localCEOffscreenEGLRender = this.this$0;
    CEOffscreenEGLRender.a(localCEOffscreenEGLRender, CEOffscreenEGLRender.b(localCEOffscreenEGLRender), this.a, this.b, this.c);
    CEOffscreenEGLRender.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenEGLRender.3
 * JD-Core Version:    0.7.0.1
 */