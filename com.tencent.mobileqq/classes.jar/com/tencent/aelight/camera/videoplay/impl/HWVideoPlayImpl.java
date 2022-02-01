package com.tencent.aelight.camera.videoplay.impl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.aelight.camera.videoplay.IHWVideoPlay;

public class HWVideoPlayImpl
  implements IHWVideoPlay
{
  public GLSurfaceView getHWVideoPlayView(Context paramContext)
  {
    return new HWVideoPlayView(paramContext);
  }
  
  public void setFilePath(GLSurfaceView paramGLSurfaceView, String paramString1, String paramString2)
  {
    if (paramGLSurfaceView != null) {
      ((HWVideoPlayView)paramGLSurfaceView).setFilePath(paramString1, paramString2);
    }
  }
  
  public void setRepeat(GLSurfaceView paramGLSurfaceView, boolean paramBoolean)
  {
    if (paramGLSurfaceView != null) {
      ((HWVideoPlayView)paramGLSurfaceView).setRepeat(paramBoolean);
    }
  }
  
  public void startPlay(GLSurfaceView paramGLSurfaceView)
  {
    if (paramGLSurfaceView != null) {
      ((HWVideoPlayView)paramGLSurfaceView).b();
    }
  }
  
  public void stopPlay(GLSurfaceView paramGLSurfaceView)
  {
    if (paramGLSurfaceView != null) {
      ((HWVideoPlayView)paramGLSurfaceView).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.videoplay.impl.HWVideoPlayImpl
 * JD-Core Version:    0.7.0.1
 */