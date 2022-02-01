package com.tencent.aelight.camera.ae.gif.preview;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.filter.ComposeFilter;

public class VideoFilterProcess
{
  private int a = 0;
  private int b = 0;
  private ComposeFilter c = new ComposeFilter();
  private Frame d = new Frame();
  private boolean e = true;
  private VideoFilterProcess.FrameRenderCallback f;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.e)
    {
      this.c.a(paramFrame, paramInt1, paramInt2, this.d);
      localFrame = this.d;
    }
    paramFrame = this.f;
    if (paramFrame != null) {
      paramFrame.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.c.apply();
    VideoFilterProcess.FrameRenderCallback localFrameRenderCallback = this.f;
    if (localFrameRenderCallback != null) {
      localFrameRenderCallback.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    this.f = paramFrameRenderCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    this.c.clearGLSL();
    this.d.clear();
    VideoFilterProcess.FrameRenderCallback localFrameRenderCallback = this.f;
    if (localFrameRenderCallback != null) {
      localFrameRenderCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.preview.VideoFilterProcess
 * JD-Core Version:    0.7.0.1
 */