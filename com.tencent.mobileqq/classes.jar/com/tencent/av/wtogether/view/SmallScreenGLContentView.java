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
  private int jdField_a_of_type_Int = 20;
  private long jdField_a_of_type_Long = 0L;
  private WatchTogetherSurfaceLifeCallback jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SmallScreenGLContentView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
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
      if (this.jdField_b_of_type_Int > 0) {
        this.jdField_b_of_type_Int -= 1;
      }
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback != null) {
        this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback.onDrawFrame(paramGL10);
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
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
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    setRenderMode(0);
  }
  
  public void requestRender()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if ((l > 0L) && (l < this.jdField_a_of_type_Int))
    {
      try
      {
        if (this.jdField_b_of_type_Int >= 2) {
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_Int += 1;
      super.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int - l);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setVideoRender(WatchTogetherSurfaceLifeCallback paramWatchTogetherSurfaceLifeCallback)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback = paramWatchTogetherSurfaceLifeCallback;
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherSurfaceLifeCallback.a(this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    queueEvent(new SmallScreenGLContentView.3(this));
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.SmallScreenGLContentView
 * JD-Core Version:    0.7.0.1
 */