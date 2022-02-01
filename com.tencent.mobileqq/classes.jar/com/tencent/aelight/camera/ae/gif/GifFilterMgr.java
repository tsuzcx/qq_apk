package com.tencent.aelight.camera.ae.gif;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.filter.OverlayFilter;

public class GifFilterMgr
{
  public static final Integer a = Integer.valueOf(480);
  private OverlayFilter b = new OverlayFilter();
  private Frame c = new Frame();
  private boolean d = true;
  
  public Frame a(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.d)
    {
      this.b.a(paramFrame, this.c);
      localFrame = this.c;
    }
    return localFrame;
  }
  
  public void a()
  {
    this.b.apply();
  }
  
  public void b()
  {
    this.b.clearGLSL();
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.GifFilterMgr
 * JD-Core Version:    0.7.0.1
 */