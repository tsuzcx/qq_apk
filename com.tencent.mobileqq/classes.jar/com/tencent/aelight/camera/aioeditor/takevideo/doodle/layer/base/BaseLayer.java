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
  protected float a;
  public Context a;
  protected Matrix a;
  public Rect a;
  protected BaseLayer.OnLayerTouchListener a;
  protected DoodleView a;
  protected boolean b;
  protected Paint h;
  protected Paint i;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t = 0;
  
  public BaseLayer(DoodleView paramDoodleView)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    if (paramDoodleView != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
      d();
      return;
    }
    throw new IllegalStateException("DoodleView can not be null.");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(5.0F);
    this.i.setColor(-16776961);
    this.b = false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.t;
  }
  
  public Matrix a()
  {
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
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
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left = 0;
      ((Rect)localObject).right = paramInt1;
      ((Rect)localObject).top = 0;
      ((Rect)localObject).bottom = paramInt2;
      this.r = ((Rect)localObject).left;
      this.s = this.jdField_a_of_type_AndroidGraphicsRect.right;
      this.p = this.jdField_a_of_type_AndroidGraphicsRect.top;
      this.q = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
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
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.t = paramBundle.getInt("BaseLayer:TopLevelWeight");
  }
  
  public void a(BaseLayer.OnLayerTouchListener paramOnLayerTouchListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener = paramOnLayerTouchListener;
  }
  
  public abstract boolean a(long paramLong);
  
  protected abstract boolean a(MotionEvent paramMotionEvent);
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onDestroy.");
    SLog.b("BaseLayer", localStringBuilder.toString());
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.width();
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onPause.");
    SLog.b("BaseLayer", localStringBuilder.toString());
    this.b = false;
  }
  
  public void c(int paramInt)
  {
    this.t = (paramInt + 1);
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.height();
  }
  
  public final void d(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setActiveLayer(this);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(this);
    }
    k();
  }
  
  public final boolean d(MotionEvent paramMotionEvent)
  {
    BaseLayer.OnLayerTouchListener localOnLayerTouchListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener;
    if (localOnLayerTouchListener != null) {
      localOnLayerTouchListener.a(this, paramMotionEvent);
    }
    k();
    return a(paramMotionEvent);
  }
  
  public void k()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.postInvalidate();
  }
  
  public void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" onResume.");
    SLog.b("BaseLayer", localStringBuilder.toString());
    this.b = true;
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer
 * JD-Core Version:    0.7.0.1
 */