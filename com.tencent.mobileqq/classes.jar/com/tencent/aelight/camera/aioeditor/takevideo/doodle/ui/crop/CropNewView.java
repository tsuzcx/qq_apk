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
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private CropHomingAnimator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator;
  private CropNewImage jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage = new CropNewImage();
  private CropNewView.CropListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView$CropListener;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new CropNewView.MoveAdapter(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a();
    paramCanvas.rotate(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(paramCanvas);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(CropHomeing paramCropHomeing)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c(paramCropHomeing.c);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(paramCropHomeing.d);
    if (!a(Math.round(paramCropHomeing.a), Math.round(paramCropHomeing.b))) {
      invalidate();
    }
  }
  
  private void a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator = new CropHomingAnimator();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.addUpdateListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.addListener(this);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.a(paramCropHomeing1, paramCropHomeing2);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localCropHomeing != null)
    {
      CropNewView.CropListener localCropListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView$CropListener;
      if ((localCropListener != null) && (!this.b))
      {
        localCropListener.b();
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
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  private void e()
  {
    invalidate();
    f();
    CropHomeing localCropHomeing1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(getScrollX(), getScrollY());
    CropHomeing localCropHomeing2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localCropHomeing2.a = 0.0F;
      localCropHomeing2.b = 0.0F;
    }
    a(localCropHomeing1, localCropHomeing2);
  }
  
  private void f()
  {
    CropHomingAnimator localCropHomingAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator;
    if (localCropHomingAnimator != null) {
      localCropHomingAnimator.cancel();
    }
  }
  
  public Bitmap a()
  {
    float f = 1.0F / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c();
    RectF localRectF = new RectF(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(), localRectF.centerX(), localRectF.centerY());
    ((Matrix)localObject).mapRect(localRectF);
    ((Matrix)localObject).setScale(f, f, localRectF.left, localRectF.top);
    ((Matrix)localObject).mapRect(localRectF);
    int i = Math.round(localRectF.width());
    int j = Math.round(localRectF.height());
    if ((i > 0) && (j > 0))
    {
      localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.translate(-localRectF.left, -localRectF.top);
      localCanvas.scale(f, f, localRectF.left, localRectF.top);
      a(localCanvas, false);
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c();
    e();
    setCrop(false);
  }
  
  public void a(int paramInt)
  {
    CropNewView.CropListener localCropListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView$CropListener;
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
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.d(getScrollX(), getScrollY());
      e();
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView$CropListener;
      if (localObject != null) {
        ((CropNewView.CropListener)localObject).b();
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
    this.jdField_a_of_type_Int = paramMotionEvent.getPointerCount();
    boolean bool = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent) | b(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c(getScrollX(), getScrollY());
      a(2);
      e();
      return bool;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(paramMotionEvent.getX(), paramMotionEvent.getY());
    a(1);
    return bool;
  }
  
  public void b()
  {
    if (!b())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(-90);
      e();
    }
  }
  
  boolean b()
  {
    CropHomingAnimator localCropHomingAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator;
    return (localCropHomingAnimator != null) && (localCropHomingAnimator.isRunning());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(true);
    setResetHome(true);
    e();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(true);
    setResetHome(true);
    e();
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.a())) {
      a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY()));
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingAnimator.a());
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.d(paramValueAnimator.getAnimatedFraction());
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
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.d();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.e();
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
    this.b = paramBoolean;
  }
  
  public void setCropListener(CropNewView.CropListener paramCropListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView$CropListener = paramCropListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewImage.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */