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
import jjt;

public abstract class MySurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public long a;
  private jjt a;
  
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
  
  public abstract void a(long paramLong);
  
  public abstract void a(Canvas paramCanvas);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Jjt != null) {
      bool = jjt.a(this.jdField_a_of_type_Jjt);
    }
    return bool;
  }
  
  protected void b(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("WL_DEBUG setRunning running = ").append(paramBoolean).append(", mThread == null ? ");
      if (this.jdField_a_of_type_Jjt == null)
      {
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append(", mThread.mRunning ? ");
        if ((this.jdField_a_of_type_Jjt == null) || (!jjt.a(this.jdField_a_of_type_Jjt))) {
          break label141;
        }
        bool = true;
        label72:
        QLog.d("MySurfaceView", 2, bool);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label146;
      }
      if ((this.jdField_a_of_type_Jjt == null) || (!jjt.a(this.jdField_a_of_type_Jjt)))
      {
        this.jdField_a_of_type_Jjt = new jjt(this);
        this.jdField_a_of_type_Jjt.a(true);
        this.jdField_a_of_type_Jjt.start();
      }
    }
    label141:
    label146:
    while ((this.jdField_a_of_type_Jjt == null) || (!jjt.a(this.jdField_a_of_type_Jjt)))
    {
      return;
      bool = false;
      break;
      bool = false;
      break label72;
    }
    this.jdField_a_of_type_Jjt.a(false);
    if (this.jdField_a_of_type_Jjt != Thread.currentThread()) {}
    for (;;)
    {
      if (i != 0) {}
      try
      {
        this.jdField_a_of_type_Jjt.join();
        i = 0;
      }
      catch (InterruptedException localInterruptedException) {}
      this.jdField_a_of_type_Jjt = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView
 * JD-Core Version:    0.7.0.1
 */