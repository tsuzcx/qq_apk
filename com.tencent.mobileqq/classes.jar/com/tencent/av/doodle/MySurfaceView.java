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
    this.jdField_a_of_type_Long = 0L;
    a(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    a(paramContext);
  }
  
  public MySurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Long = 0L;
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
    MySurfaceView.MySurfaceViewThread localMySurfaceViewThread = this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread;
    if (localMySurfaceViewThread != null) {
      return MySurfaceView.MySurfaceViewThread.a(localMySurfaceViewThread);
    }
    return false;
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread;
    int i = 1;
    boolean bool;
    if ((localObject != null) && (MySurfaceView.MySurfaceViewThread.a((MySurfaceView.MySurfaceViewThread)localObject))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != paramBoolean)
    {
      localObject = new Throwable("打印调用栈");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRunning, running[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mThread[");
      if (this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], mThread.mRunning[");
      MySurfaceView.MySurfaceViewThread localMySurfaceViewThread = this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread;
      if ((localMySurfaceViewThread != null) && (MySurfaceView.MySurfaceViewThread.a(localMySurfaceViewThread))) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("MySurfaceView", 1, localStringBuilder.toString(), (Throwable)localObject);
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread;
      if ((localObject == null) || (!MySurfaceView.MySurfaceViewThread.a((MySurfaceView.MySurfaceViewThread)localObject)))
      {
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread = new MySurfaceView.MySurfaceViewThread(this);
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.a(true);
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.start();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread;
      if ((localObject != null) && (MySurfaceView.MySurfaceViewThread.a((MySurfaceView.MySurfaceViewThread)localObject)))
      {
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.a(false);
        if (this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread != Thread.currentThread()) {
          while (i != 0) {
            try
            {
              this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread.join();
              i = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              label263:
              break label263;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvDoodleMySurfaceView$MySurfaceViewThread = null;
      }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG onWindowFocusChanged hasWindowFocus = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MySurfaceView", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG surfaceCreated context = ");
      localStringBuilder.append(paramSurfaceHolder.getClass().getName());
      localStringBuilder.append(", hasWindowFocus = ");
      localStringBuilder.append(bool);
      QLog.d("MySurfaceView", 2, localStringBuilder.toString());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = getContext();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG surfaceDestroyed context = ");
      localStringBuilder.append(paramSurfaceHolder.getClass().getName());
      QLog.d("MySurfaceView", 2, localStringBuilder.toString());
    }
    if (!(paramSurfaceHolder instanceof Activity)) {
      b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView
 * JD-Core Version:    0.7.0.1
 */