package com.google.android.exoplayer2.ext.vp9;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class VpxVideoSurfaceView
  extends GLSurfaceView
  implements VpxOutputBufferRenderer
{
  private final VpxRenderer renderer = new VpxRenderer();
  
  public VpxVideoSurfaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VpxVideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPreserveEGLContextOnPause(true);
    setEGLContextClientVersion(2);
    setRenderer(this.renderer);
    setRenderMode(0);
  }
  
  public void setOutputBuffer(VpxOutputBuffer paramVpxOutputBuffer)
  {
    this.renderer.setFrame(paramVpxOutputBuffer);
    requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.vp9.VpxVideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */