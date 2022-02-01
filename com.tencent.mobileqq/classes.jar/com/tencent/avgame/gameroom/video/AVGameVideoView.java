package com.tencent.avgame.gameroom.video;

import android.content.Context;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.ui.GLVideoView;
import com.tencent.avgame.app.AVGameAppInterface;

public class AVGameVideoView
  extends GLVideoView
{
  private final boolean aM;
  private boolean aN = false;
  
  public AVGameVideoView(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public AVGameVideoView(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext, null, paramString, paramLong, paramBoolean);
    this.aM = paramBoolean;
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    if (this.aM) {
      super.b(paramGLCanvas);
    }
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    this.aN = true;
    super.d(paramGLCanvas);
  }
  
  protected boolean n(int paramInt)
  {
    if (S() == 2) {
      return false;
    }
    return super.n(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameVideoView
 * JD-Core Version:    0.7.0.1
 */