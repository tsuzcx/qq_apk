package com.tencent.aelight.camera.videoplay;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHWVideoPlay
  extends QRouteApi
{
  public abstract GLSurfaceView getHWVideoPlayView(Context paramContext);
  
  public abstract void setFilePath(GLSurfaceView paramGLSurfaceView, String paramString1, String paramString2);
  
  public abstract void setRepeat(GLSurfaceView paramGLSurfaceView, boolean paramBoolean);
  
  public abstract void startPlay(GLSurfaceView paramGLSurfaceView);
  
  public abstract void stopPlay(GLSurfaceView paramGLSurfaceView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.videoplay.IHWVideoPlay
 * JD-Core Version:    0.7.0.1
 */