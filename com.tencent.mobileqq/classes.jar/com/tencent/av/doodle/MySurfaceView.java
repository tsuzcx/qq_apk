package com.tencent.av.doodle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;

public abstract class MySurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public long a;
  private MySurfaceView.MySurfaceViewThread a;
  
  public MySurfaceView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = getHolder();
    paramContext.addCallback(this);
    setZOrderOnTop(true);
    paramContext.setFormat(-3);
  }
  
  protected abstract void a(long paramLong);
  
  protected abstract void a(Canvas paramCanvas);
  
  protected abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread != null) {
      bool = MySurfaceView.MySurfaceViewThread.a(this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread);
    }
    return bool;
  }
  
  protected void b(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread != null) && (MySurfaceView.MySurfaceViewThread.a(this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread)))
    {
      bool = true;
      if (bool != paramBoolean)
      {
        Throwable localThrowable = new Throwable("打印调用栈");
        StringBuilder localStringBuilder = new StringBuilder().append("setRunning, running[").append(paramBoolean).append("], mThread[");
        if (this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread == null) {
          break label177;
        }
        bool = true;
        label69:
        localStringBuilder = localStringBuilder.append(bool).append("], mThread.mRunning[");
        if ((this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread == null) || (!MySurfaceView.MySurfaceViewThread.a(this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread))) {
          break label182;
        }
        bool = true;
        label101:
        QLog.w("MySurfaceView", 1, bool + "]", localThrowable);
      }
      if (!paramBoolean) {
        break label187;
      }
      if ((this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread == null) || (!MySurfaceView.MySurfaceViewThread.a(this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread)))
      {
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread = new MySurfaceView.MySurfaceViewThread(this);
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.a(true);
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.start();
      }
    }
    label177:
    label182:
    label187:
    while ((this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread == null) || (!MySurfaceView.MySurfaceViewThread.a(this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread)))
    {
      return;
      bool = false;
      break;
      bool = false;
      break label69;
      bool = false;
      break label101;
    }
    this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.a(false);
    if (this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread != Thread.currentThread()) {}
    for (;;)
    {
      if (i != 0) {}
      try
      {
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.join();
        i = 0;
      }
      catch (InterruptedException localInterruptedException) {}
      this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread = null;
      return;
    }
  }
  
  protected void finalize()
  {
    try
    {
      b(false);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG onWindowFocusChanged hasWindowFocus = " + paramBoolean);
    }
    if (!paramBoolean) {
      b(false);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    paramSurfaceHolder = getContext();
    boolean bool = hasWindowFocus();
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceCreated context = " + paramSurfaceHolder.getClass().getName() + ", hasWindowFocus = " + bool);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = getContext();
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceDestroyed context = " + paramSurfaceHolder.getClass().getName());
    }
    if (!(paramSurfaceHolder instanceof Activity)) {
      b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView
 * JD-Core Version:    0.7.0.1
 */