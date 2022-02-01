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
  private MySurfaceView.MySurfaceViewThread a;
  public long b = 0L;
  
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
  
  protected void finalize()
  {
    try
    {
      setRunning(false);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public boolean getRunning()
  {
    MySurfaceView.MySurfaceViewThread localMySurfaceViewThread = this.a;
    if (localMySurfaceViewThread != null) {
      return MySurfaceView.MySurfaceViewThread.a(localMySurfaceViewThread);
    }
    return false;
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
      setRunning(false);
    }
  }
  
  protected void setRunning(boolean paramBoolean)
  {
    Object localObject = this.a;
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
      if (this.a != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], mThread.mRunning[");
      MySurfaceView.MySurfaceViewThread localMySurfaceViewThread = this.a;
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
      localObject = this.a;
      if ((localObject == null) || (!MySurfaceView.MySurfaceViewThread.a((MySurfaceView.MySurfaceViewThread)localObject)))
      {
        this.a = new MySurfaceView.MySurfaceViewThread(this);
        this.a.a(true);
        this.a.start();
      }
    }
    else
    {
      localObject = this.a;
      if ((localObject != null) && (MySurfaceView.MySurfaceViewThread.a((MySurfaceView.MySurfaceViewThread)localObject)))
      {
        this.a.a(false);
        if (this.a != Thread.currentThread()) {
          while (i != 0) {
            try
            {
              this.a.join();
              i = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              label263:
              break label263;
            }
          }
        }
        this.a = null;
      }
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.b = SystemClock.elapsedRealtime();
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
      setRunning(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView
 * JD-Core Version:    0.7.0.1
 */