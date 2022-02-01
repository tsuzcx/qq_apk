package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraSegmentCaptureButtonLayoutNew
  extends QIMCameraCaptureButtonLayoutNew
{
  protected static final int b;
  protected float b;
  protected float c;
  protected ValueAnimator c;
  protected AtomicBoolean c;
  private float d = this.jdField_a_of_type_Float * 0.98F / 1000.0F;
  protected boolean f;
  
  static
  {
    jdField_b_of_type_Int = CodecParam.SEGMENT_RECORD_MAX_TIME;
  }
  
  public QIMCameraSegmentCaptureButtonLayoutNew(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QIMCameraSegmentCaptureButtonLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  @SuppressLint({"LongLogTag"})
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      boolean bool2 = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      boolean bool1 = true;
      if (bool2)
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(8);
        float f1 = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getCurrentProgress();
        float f2 = QIMCircleProgress.MAX_PROGRESS;
        int i = jdField_b_of_type_Int;
        if (f1 < f2 * (float)(i - 500L) / i) {
          bool1 = false;
        }
        this.jdField_a_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            if ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener instanceof QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)) {
              ((QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener).d();
            } else {
              Log.e("CameraSegmentCaptureLayout", "pauseSegmentVideo: should use instance of SegmentCaptureButtonListener to get callback");
            }
          }
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.C();
        }
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getSegmentPoints().add(Float.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getCurrentProgress()));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[segmentCapture] segmentPoints add, size = ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getSegmentPoints().size());
          QLog.d("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
        }
        this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getCurrentProgress();
        d(false);
        return;
      }
      d(true);
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.initBlinkAnimator();
    this.jdField_a_of_type_Float = jdField_b_of_type_Int;
    this.f = true;
  }
  
  protected void a(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage what:");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", shortVideoShot:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", segmentShot:");
      localStringBuilder.append(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    switch (paramMessage.what)
    {
    default: 
    case 9: 
      if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.D();
        return;
      }
      break;
    case 8: 
      e(false);
      return;
    case 7: 
      q();
      return;
    case 6: 
      h();
      return;
    case 5: 
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!this.jdField_a_of_type_Boolean))
      {
        i();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
        return;
      }
      break;
    case 4: 
      if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.a();
      }
      g();
      return;
    case 3: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.C();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        g();
        return;
      }
      break;
    case 2: 
      if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.E();
        return;
      }
      break;
    case 1: 
      e(true);
    }
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch action:");
      localStringBuilder.append(paramMotionEvent.getAction() & 0xFF);
      localStringBuilder.append(", shortVideoShot:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", segmentShot:");
      localStringBuilder.append(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", actionUp:");
      localStringBuilder.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", isOver:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    if (!this.f) {
      return super.a(paramView, paramMotionEvent);
    }
    b();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if ((i != 1) && (i != 3))
      {
        if (i != 5) {
          return false;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.b();
        }
        return false;
      }
      m();
      return true;
    }
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) && (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.g()))
    {
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        } else {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
    }
    return false;
  }
  
  @TargetApi(11)
  protected void d(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Float < 0.0F) {
      this.jdField_c_of_type_Float = 1.45F;
    }
    ValueAnimator localValueAnimator = this.jdField_c_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_c_of_type_Float, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(((this.jdField_c_of_type_Float - 1.0F) * 400.0F / 0.45F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.2(this));
    float f1 = this.jdField_b_of_type_Float;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getSegmentPoints().size() > 0)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new QIMCameraSegmentCaptureButtonLayoutNew.3(this, paramBoolean, f1));
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.4(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
  }
  
  @TargetApi(11)
  protected void e(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Float < 0.0F) {
      this.jdField_c_of_type_Float = 1.0F;
    }
    ValueAnimator localValueAnimator = this.jdField_c_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_c_of_type_Float, 1.45F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(((1.45F - this.jdField_c_of_type_Float) * 400.0F / 0.45F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.5(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new QIMCameraSegmentCaptureButtonLayoutNew.6(this, paramBoolean));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.7(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(1);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    }
  }
  
  @TargetApi(11)
  protected void f()
  {
    ValueAnimator localValueAnimator = this.jdField_c_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getSegmentPoints().clear();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.cancelAnimation();
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  @SuppressLint({"LongLogTag"})
  protected void i()
  {
    float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float * QIMCircleProgress.MAX_PROGRESS + this.jdField_b_of_type_Float;
    boolean bool;
    if (f1 >= QIMCircleProgress.MAX_PROGRESS) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    float f2 = f1 / QIMCircleProgress.MAX_PROGRESS * (this.jdField_a_of_type_Float / 1000.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append((int)f2);
    ((StringBuilder)localObject).append("秒");
    localObject = ((StringBuilder)localObject).toString();
    if (f2 > this.d)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)(this.jdField_a_of_type_Float / 1000.0F));
      ((StringBuilder)localObject).append("秒");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setText((String)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setProgress(f1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProgress percent:");
      localStringBuilder.append(f1);
      localStringBuilder.append(", time:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", maxDuration:");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener instanceof QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)) {
        ((QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener).d();
      } else {
        Log.e("CameraSegmentCaptureLayout", "updateProgress: should use instance of SegmentCaptureButtonListener to get callback");
      }
      m();
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void m()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.f)
    {
      super.m();
      return;
    }
    if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    else
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      f();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        } else {
          p();
        }
      }
      else
      {
        p();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
  }
  
  protected void p()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.G();
    }
    d(true);
  }
  
  public void setCurrentAnimatorValue(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    super.setMaxDuration(paramFloat);
    this.d = (this.jdField_a_of_type_Float * 0.98F / 1000.0F);
  }
  
  public void setSegment(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew
 * JD-Core Version:    0.7.0.1
 */