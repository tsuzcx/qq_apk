import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class amiz
  implements GLSurfaceView.EGLContextFactory
{
  private amiz(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (ApolloSurfaceView.access$700(this.a) != 0) {}
    for (int i = 2;; i = amhd.a())
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
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    QLog.d("ApolloSurfaceView", 1, "[destroyContext], id:" + Thread.currentThread().getId());
    Object localObject;
    if (ApolloSurfaceView.access$800(this.a))
    {
      localObject = ampj.a();
      if (localObject != null)
      {
        if (!(localObject instanceof QQAppInterface)) {
          break label161;
        }
        localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((ApolloCmdChannel)localObject).callbackDirect(this.a.isJsRuntime(), this.a.getLuaState(), 0, "sc.force_stop_game.local", "{}");
        ((ApolloCmdChannel)localObject).destroyMusic();
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
        label161:
        if (!(localObject instanceof CmGameAppInterface)) {
          break label226;
        }
        QLog.i("cmgame_process.", 1, "[destroyContext] in game.");
        localObject = ampj.a();
        break;
        if ((this.a.mApolloWorker != null) && (this.a.mApolloWorker.a != null)) {
          this.a.mApolloWorker.a.a("if(\"undefined\" != typeof clearSprite && clearSprite){clearSprite();}");
        }
      }
      label226:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amiz
 * JD-Core Version:    0.7.0.1
 */