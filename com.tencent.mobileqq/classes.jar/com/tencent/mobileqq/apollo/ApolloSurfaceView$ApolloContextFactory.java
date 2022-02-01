package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.opengl.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ApolloSurfaceView$ApolloContextFactory
  implements EGLContextFactory
{
  private ApolloSurfaceView$ApolloContextFactory(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (ApolloSurfaceView.access$700(this.a) != 0) {}
    for (int i = 2;; i = ApolloManagerServiceImpl.getOpenGLVersion())
    {
      QLog.d("ApolloSurfaceView", 1, new Object[] { "[createContext], id:" + Thread.currentThread().getId(), ",openGLVersion:", Integer.valueOf(i) });
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 12440;
      arrayOfInt[1] = i;
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext2 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
      EGLContext localEGLContext1 = localEGLContext2;
      if (localEGLContext2 == null)
      {
        localEGLContext1 = localEGLContext2;
        if (arrayOfInt[1] == 3)
        {
          QLog.e("ApolloSurfaceView", 1, "[createContext], context error, try foll back opengl 2.0");
          arrayOfInt[1] = 2;
          localEGLContext1 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
        }
      }
      this.a.mIsDestroy.set(false);
      return localEGLContext1;
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    QLog.d("ApolloSurfaceView", 1, "[destroyContext], id:" + Thread.currentThread().getId());
    if (ApolloSurfaceView.access$800(this.a))
    {
      IApolloCmdChannel localIApolloCmdChannel = ApolloUtilImpl.getCmdChannel();
      localIApolloCmdChannel.callbackDirect(this.a.isJsRuntime(), this.a.getLuaState(), 0, "sc.force_stop_game.local", "{}");
      localIApolloCmdChannel.destroyMusic();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "destroyContext, closeGame)");
      }
    }
    for (;;)
    {
      this.a.mIsDestroy.set(true);
      if (this.a.mRender != null) {
        this.a.mRender.onDestroy();
      }
      if (paramEGL10 != null) {
        paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      }
      return;
      if ((this.a.mApolloWorker != null) && (this.a.mApolloWorker.a != null)) {
        this.a.mApolloWorker.a.a("if(\"undefined\" != typeof clearSprite && clearSprite){clearSprite();}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView.ApolloContextFactory
 * JD-Core Version:    0.7.0.1
 */