package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomeing;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomingAnimator;
import com.tencent.biz.qqstory.support.report.VideoEditReport;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private CropNewImage a = new CropNewImage();
  private GestureDetector b;
  private ScaleGestureDetector c;
  private CropHomingAnimator d;
  private int e = 0;
  private CropNewView.CropListener f;
  private boolean g = false;
  private boolean h = false;
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = new GestureDetector(paramContext, new CropNewView.MoveAdapter(this, null));
    this.c = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.a.b();
    paramCanvas.rotate(this.a.h(), localRectF.centerX(), localRectF.centerY());
    this.a.a(paramCanvas);
    this.a.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.a.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(CropHomeing paramCropHomeing)
  {
    this.a.c(paramCropHomeing.c);
    this.a.b(paramCropHomeing.d);
    if (!a(Math.round(paramCropHomeing.a), Math.round(paramCropHomeing.b))) {
      invalidate();
    }
  }
  
  private void a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    if (this.d == null)
    {
      this.d = new CropHomingAnimator();
      this.d.addUpdateListener(this);
      this.d.addListener(this);
    }
    this.d.a(paramCropHomeing1, paramCropHomeing2);
    this.d.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = this.a.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localCropHomeing != null)
    {
      CropNewView.CropListener localCropListener = this.f;
      if ((localCropListener != null) && (!this.h))
      {
        localCropListener.d();
        setCrop(true);
      }
      a(localCropHomeing);
      return true;
    }
    return a(getScrollX() + Math.round(paramFloat1), getScrollY() + Math.round(paramFloat2));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((getScrollX() == paramInt1) && (getScrollY() == paramInt2)) {
      return false;
    }
    scrollTo(paramInt1, paramInt2);
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return this.b.onTouchEvent(paramMotionEvent);
  }
  
  private void i()
  {
    invalidate();
    j();
    CropHomeing localCropHomeing1 = this.a.b(getScrollX(), getScrollY());
    CropHomeing localCropHomeing2 = this.a.c(getScrollX(), getScrollY());
    if (this.g)
    {
      setResetHome(false);
      localCropHomeing2.a = 0.0F;
      localCropHomeing2.b = 0.0F;
    }
    a(localCropHomeing1, localCropHomeing2);
  }
  
  private void j()
  {
    CropHomingAnimator localCropHomingAnimator = this.d;
    if (localCropHomingAnimator != null) {
      localCropHomingAnimator.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    CropNewView.CropListener localCropListener = this.f;
    if (localCropListener != null) {
      localCropListener.a(paramInt);
    }
  }
  
  boolean a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSteady: isHoming=");
      ((StringBuilder)localObject).append(b());
      QLog.i("CropNewView", 0, ((StringBuilder)localObject).toString());
    }
    if (!b())
    {
      this.a.g(getScrollX(), getScrollY());
      i();
      localObject = this.f;
      if (localObject != null) {
        ((CropNewView.CropListener)localObject).d();
      }
      return true;
    }
    return false;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    if (b()) {
      return false;
    }
    this.e = paramMotionEvent.getPointerCount();
    boolean bool = this.c.onTouchEvent(paramMotionEvent) | b(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      this.a.f(getScrollX(), getScrollY());
      a(2);
      i();
      return bool;
    }
    this.a.e(paramMotionEvent.getX(), paramMotionEvent.getY());
    a(1);
    return bool;
  }
  
  boolean b()
  {
    CropHomingAnimator localCropHomingAnimator = this.d;
    return (localCropHomingAnimator != null) && (localCropHomingAnimator.isRunning());
  }
  
  public void c()
  {
    this.a.d();
    i();
    setCrop(false);
  }
  
  public void d()
  {
    if (!b())
    {
      this.a.a(-90);
      i();
    }
  }
  
  public boolean e()
  {
    this.a.a(getScrollX(), getScrollY());
    this.a.b(true);
    setResetHome(true);
    i();
    return true;
  }
  
  public void f()
  {
    this.a.c();
    this.a.b(true);
    setResetHome(true);
    i();
  }
  
  public Bitmap g()
  {
    float f1 = 1.0F / this.a.i();
    RectF localRectF = new RectF(this.a.b());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.a.h(), localRectF.centerX(), localRectF.centerY());
    ((Matrix)localObject).mapRect(localRectF);
    ((Matrix)localObject).setScale(f1, f1, localRectF.left, localRectF.top);
    ((Matrix)localObject).mapRect(localRectF);
    int i = Math.round(localRectF.width());
    int j = Math.round(localRectF.height());
    if ((i > 0) && (j > 0))
    {
      localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.translate(-localRectF.left, -localRectF.top);
      localCanvas.scale(f1, f1, localRectF.left, localRectF.top);
      a(localCanvas, false);
      return localObject;
    }
    return null;
  }
  
  public void h()
  {
    this.a.a();
    i();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.a.c(this.d.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.a.a(getScrollX(), getScrollY(), this.d.a())) {
      a(this.a.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.a.a(this.d.a());
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d(paramValueAnimator.getAnimatedFraction());
    a((CropHomeing)paramValueAnimator.getAnimatedValue());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas, true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      this.a.d(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.e > 1)
    {
      this.a.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.e > 1)
    {
      this.a.f();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.j();
    VideoEditReport.b("0X800A9AB");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        postDelayed(this, 1000L);
      }
    }
    else {
      removeCallbacks(this);
    }
    return a(paramMotionEvent);
  }
  
  public void run()
  {
    if (!a()) {
      postDelayed(this, 400L);
    }
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setCropListener(CropNewView.CropListener paramCropListener)
  {
    this.f = paramCropListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.a(this);
    this.a.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */