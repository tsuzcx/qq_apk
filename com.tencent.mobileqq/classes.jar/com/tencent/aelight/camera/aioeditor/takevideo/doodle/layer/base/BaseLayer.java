package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class BaseLayer
  implements Layer, LifeCycle
{
  private static String a = "BaseLayer";
  protected Paint A;
  public Rect B;
  protected Paint C;
  protected int D;
  protected int E;
  protected int F;
  protected int G;
  protected boolean H;
  protected int I = 0;
  protected float J;
  protected BaseLayer.OnLayerTouchListener K;
  protected Matrix L = new Matrix();
  public Context y;
  protected DoodleView z;
  
  public BaseLayer(DoodleView paramDoodleView)
  {
    if (paramDoodleView != null)
    {
      this.y = paramDoodleView.getContext();
      this.z = paramDoodleView;
      d();
      return;
    }
    throw new IllegalStateException("DoodleView can not be null.");
  }
  
  private void d()
  {
    this.B = new Rect();
    this.A = new Paint();
    this.A.setAntiAlias(true);
    this.C = new Paint();
    this.C.setAntiAlias(true);
    this.C.setStyle(Paint.Style.STROKE);
    this.C.setStrokeWidth(5.0F);
    this.C.setColor(-16776961);
    this.H = false;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("layer size,width=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",height=");
      ((StringBuilder)localObject).append(paramInt2);
      SLog.b("BaseLayer", ((StringBuilder)localObject).toString());
      localObject = this.B;
      ((Rect)localObject).left = 0;
      ((Rect)localObject).right = paramInt1;
      ((Rect)localObject).top = 0;
      ((Rect)localObject).bottom = paramInt2;
      this.F = ((Rect)localObject).left;
      this.G = this.B.right;
      this.D = this.B.top;
      this.E = this.B.bottom;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("illegal width or height, width=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",height=");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    b(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    a(paramCanvas, paramFloat);
  }
  
  public void a(Matrix paramMatrix)
  {
    this.L.set(paramMatrix);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.I = paramBundle.getInt("BaseLayer:TopLevelWeight");
  }
  
  public void a(BaseLayer.OnLayerTouchListener paramOnLayerTouchListener)
  {
    this.K = paramOnLayerTouchListener;
  }
  
  public abstract boolean a(long paramLong);
  
  protected abstract boolean a(MotionEvent paramMotionEvent);
  
  public void aw_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onPause.");
    SLog.b("BaseLayer", localStringBuilder.toString());
    this.H = false;
  }
  
  public void b(float paramFloat)
  {
    this.J = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.I = (paramInt + 1);
  }
  
  public final void d(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.z.setActiveLayer(this);
    } else {
      this.z.a(this);
    }
    u();
  }
  
  public final boolean d(MotionEvent paramMotionEvent)
  {
    BaseLayer.OnLayerTouchListener localOnLayerTouchListener = this.K;
    if (localOnLayerTouchListener != null) {
      localOnLayerTouchListener.a(this, paramMotionEvent);
    }
    u();
    return a(paramMotionEvent);
  }
  
  public int e()
  {
    return this.I;
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onDestroy.");
    SLog.b("BaseLayer", localStringBuilder.toString());
  }
  
  public int s()
  {
    return this.B.width();
  }
  
  public int t()
  {
    return this.B.height();
  }
  
  public void u()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.z.invalidate();
      return;
    }
    this.z.postInvalidate();
  }
  
  public void v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onResume.");
    SLog.b("BaseLayer", localStringBuilder.toString());
    this.H = true;
  }
  
  public float w()
  {
    return this.J;
  }
  
  public void x()
  {
    this.z.setTopLevelLayer(this);
  }
  
  public Matrix y()
  {
    return this.L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer
 * JD-Core Version:    0.7.0.1
 */