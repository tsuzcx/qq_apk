package com.tencent.av.wtogether.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.av.wtogether.callback.WatchTogetherSurfaceLifeCallback;
import com.tencent.mobileqq.app.ThreadManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class SmallScreenGLContentView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private int a = 20;
  private int b = 0;
  private long c = 0L;
  private boolean d = false;
  private volatile boolean e = false;
  private WatchTogetherSurfaceLifeCallback f;
  private Runnable g = new SmallScreenGLContentView.1(this);
  
  public SmallScreenGLContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmallScreenGLContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setBackgroundDrawable(null);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    getHolder().setFormat(-3);
    setRenderer(this);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.b > 0) {
        this.b -= 1;
      }
      this.e = false;
      WatchTogetherSurfaceLifeCallback localWatchTogetherSurfaceLifeCallback = this.f;
      if (localWatchTogetherSurfaceLifeCallback != null) {
        localWatchTogetherSurfaceLifeCallback.onDrawFrame(paramGL10);
      }
      this.c = SystemClock.elapsedRealtime();
      return;
    }
    finally {}
  }
  
  public void onPause()
  {
    queueEvent(new SmallScreenGLContentView.2(this));
    super.onPause();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    WatchTogetherSurfaceLifeCallback localWatchTogetherSurfaceLifeCallback = this.f;
    if (localWatchTogetherSurfaceLifeCallback != null) {
      localWatchTogetherSurfaceLifeCallback.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    WatchTogetherSurfaceLifeCallback localWatchTogetherSurfaceLifeCallback = this.f;
    if (localWatchTogetherSurfaceLifeCallback != null) {
      localWatchTogetherSurfaceLifeCallback.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    setRenderMode(0);
  }
  
  public void requestRender()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    long l = SystemClock.elapsedRealtime() - this.c;
    if ((l > 0L) && (l < this.a)) {
      try
      {
        if (this.b >= 2) {
          return;
        }
        this.b += 1;
        super.postDelayed(this.g, this.a - l);
        return;
      }
      finally {}
    }
    ThreadManager.getUIHandler().post(this.g);
  }
  
  public void setVideoRender(WatchTogetherSurfaceLifeCallback paramWatchTogetherSurfaceLifeCallback)
  {
    this.f = paramWatchTogetherSurfaceLifeCallback;
    this.f.a(this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    queueEvent(new SmallScreenGLContentView.3(this));
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.SmallScreenGLContentView
 * JD-Core Version:    0.7.0.1
 */