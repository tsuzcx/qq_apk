package com.tencent.avgame.gameroom.video;

import android.content.Context;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.ui.GLVideoView;
import com.tencent.avgame.app.AVGameAppInterface;

public class AVGameVideoView
  extends GLVideoView
{
  private final boolean r;
  private boolean s = false;
  
  public AVGameVideoView(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public AVGameVideoView(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext, null, paramString, paramLong, paramBoolean);
    this.r = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if (g() == 2) {
      return false;
    }
    return super.a(paramInt);
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (this.r) {
      super.b(paramGLCanvas);
    }
  }
  
  public void d(GLCanvas paramGLCanvas)
  {
    this.s = true;
    super.d(paramGLCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameVideoView
 * JD-Core Version:    0.7.0.1
 */