package com.google.android.exoplayer2.ext.hevc;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class HevcVideoSurfaceView
  extends GLSurfaceView
  implements HevcOutputBufferRenderer
{
  private final HevcRenderer renderer = new HevcRenderer();
  
  public HevcVideoSurfaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HevcVideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPreserveEGLContextOnPause(true);
    setEGLContextClientVersion(2);
    setRenderer(this.renderer);
    setRenderMode(0);
  }
  
  public void setOutputBuffer(HevcOutputBuffer paramHevcOutputBuffer)
  {
    this.renderer.setFrame(paramHevcOutputBuffer);
    requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.HevcVideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */