package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class VideoGLView
  extends GLRootView
{
  private EGLContext h;
  
  public VideoGLView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter) {}
  
  public void onPause()
  {
    QLog.d("VideoGLView", 1, "onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.d("VideoGLView", 1, "onResume");
    super.onResume();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
  }
  
  public void setEglShareContext(EGLContext paramEGLContext)
  {
    this.h = paramEGLContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.VideoGLView
 * JD-Core Version:    0.7.0.1
 */