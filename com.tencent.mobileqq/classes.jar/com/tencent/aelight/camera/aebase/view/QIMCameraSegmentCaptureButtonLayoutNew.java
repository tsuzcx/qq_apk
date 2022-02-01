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
  protected static final int x = CodecParam.SEGMENT_RECORD_MAX_TIME;
  protected ValueAnimator A = null;
  protected AtomicBoolean B = new AtomicBoolean(false);
  protected boolean C;
  private float D = this.c * 0.98F / 1000.0F;
  protected float y = 0.0F;
  protected float z = -1.0F;
  
  public QIMCameraSegmentCaptureButtonLayoutNew(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMCameraSegmentCaptureButtonLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"LongLogTag"})
  private void r()
  {
    if (this.a.get())
    {
      boolean bool2 = this.B.get();
      boolean bool1 = true;
      if (bool2)
      {
        this.B.set(false);
        this.i.setVisibility(8);
        float f1 = this.h.getCurrentProgress();
        float f2 = QIMCircleProgress.MAX_PROGRESS;
        int i = x;
        if (f1 < f2 * (float)(i - 500L) / i) {
          bool1 = false;
        }
        this.n = bool1;
        if (this.j != null)
        {
          if (this.n) {
            if ((this.j instanceof QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)) {
              ((QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)this.j).d();
            } else {
              Log.e("CameraSegmentCaptureLayout", "pauseSegmentVideo: should use instance of SegmentCaptureButtonListener to get callback");
            }
          }
          this.j.aa();
        }
        this.h.getSegmentPoints().add(Float.valueOf(this.h.getCurrentProgress()));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[segmentCapture] segmentPoints add, size = ");
          localStringBuilder.append(this.h.getSegmentPoints().size());
          QLog.d("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
        }
        this.y = this.h.getCurrentProgress();
        c(false);
        return;
      }
      c(true);
    }
  }
  
  protected void a()
  {
    super.a();
    this.h.initBlinkAnimator();
    this.c = x;
    this.C = true;
  }
  
  protected void a(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage what:");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", shortVideoShot:");
      localStringBuilder.append(this.a.get());
      localStringBuilder.append(", segmentShot:");
      localStringBuilder.append(this.B.get());
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    switch (paramMessage.what)
    {
    default: 
    case 9: 
      if (this.j != null)
      {
        this.j.ac();
        return;
      }
      break;
    case 8: 
      d(false);
      return;
    case 7: 
      r();
      return;
    case 6: 
      l();
      return;
    case 5: 
      if ((this.a.get()) && (this.B.get()) && (!this.n))
      {
        m();
        this.w.sendEmptyMessageDelayed(5, 50L);
        return;
      }
      break;
    case 4: 
      if (this.j != null) {
        this.j.b();
      }
      f();
      return;
    case 3: 
      if (this.a.get())
      {
        if (this.j != null) {
          this.j.aa();
        }
        this.a.set(false);
        f();
        return;
      }
      break;
    case 2: 
      if (this.j != null)
      {
        this.j.ad();
        return;
      }
      break;
    case 1: 
      d(true);
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
      localStringBuilder.append(this.a.get());
      localStringBuilder.append(", segmentShot:");
      localStringBuilder.append(this.B.get());
      localStringBuilder.append(", actionUp:");
      localStringBuilder.append(this.b.get());
      localStringBuilder.append(", isOver:");
      localStringBuilder.append(this.n);
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    if (!this.C) {
      return super.a(paramView, paramMotionEvent);
    }
    b();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.e, this.g);
    if (this.n) {
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
        if (this.j != null) {
          this.j.a();
        }
        return false;
      }
      o();
      return true;
    }
    if (this.o) {
      return false;
    }
    if ((this.j != null) && (this.j.ab()))
    {
      if ((this.s == 3) || (this.s == 1))
      {
        this.b.set(false);
        if (this.a.get()) {
          this.w.sendEmptyMessage(8);
        } else {
          this.w.sendEmptyMessage(1);
        }
      }
      this.p = true;
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
    }
    return false;
  }
  
  @TargetApi(11)
  protected void c(boolean paramBoolean)
  {
    if (this.z < 0.0F) {
      this.z = 1.45F;
    }
    ValueAnimator localValueAnimator = this.A;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.A.removeAllListeners();
      this.A.removeAllUpdateListeners();
      this.A.cancel();
    }
    this.A = ValueAnimator.ofFloat(new float[] { this.z, 1.0F });
    this.A.setDuration(((this.z - 1.0F) * 400.0F / 0.45F));
    this.A.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.2(this));
    float f = this.y;
    if ((!this.n) && (this.h.getSegmentPoints().size() > 0)) {
      this.A.addListener(new QIMCameraSegmentCaptureButtonLayoutNew.3(this, paramBoolean, f));
    }
    this.A.start();
    this.m = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    this.m.setDuration(400L);
    this.m.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.4(this));
    this.m.start();
    this.h.changeMode(0);
  }
  
  @TargetApi(11)
  protected void d(boolean paramBoolean)
  {
    if (this.z < 0.0F) {
      this.z = 1.0F;
    }
    ValueAnimator localValueAnimator = this.A;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.A.removeAllListeners();
      this.A.removeAllUpdateListeners();
      this.A.cancel();
    }
    this.A = ValueAnimator.ofFloat(new float[] { this.z, 1.45F });
    this.A.setDuration(((1.45F - this.z) * 400.0F / 0.45F));
    this.A.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.5(this));
    this.A.addListener(new QIMCameraSegmentCaptureButtonLayoutNew.6(this, paramBoolean));
    this.A.start();
    this.m = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.m.setDuration(400L);
    this.m.addUpdateListener(new QIMCameraSegmentCaptureButtonLayoutNew.7(this));
    this.m.start();
    this.h.changeMode(1);
    if (paramBoolean) {
      this.h.setStrokeWidth(3.0F);
    }
  }
  
  @TargetApi(11)
  protected void e()
  {
    ValueAnimator localValueAnimator = this.A;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    if (this.m != null) {
      this.m.cancel();
    }
  }
  
  public void i()
  {
    this.o = false;
    this.b.set(false);
  }
  
  public void l()
  {
    super.l();
    this.B.set(false);
    this.h.getSegmentPoints().clear();
    this.h.cancelAnimation();
    this.y = 0.0F;
  }
  
  @SuppressLint({"LongLogTag"})
  protected void m()
  {
    float f1 = (float)(System.currentTimeMillis() - this.k) / this.c * QIMCircleProgress.MAX_PROGRESS + this.y;
    boolean bool;
    if (f1 >= QIMCircleProgress.MAX_PROGRESS) {
      bool = true;
    } else {
      bool = false;
    }
    this.n = bool;
    float f2 = f1 / QIMCircleProgress.MAX_PROGRESS * (this.c / 1000.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append((int)f2);
    ((StringBuilder)localObject).append("秒");
    localObject = ((StringBuilder)localObject).toString();
    if (f2 > this.D)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)(this.c / 1000.0F));
      ((StringBuilder)localObject).append("秒");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.i.setText((String)localObject);
    this.h.setProgress(f1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProgress percent:");
      localStringBuilder.append(f1);
      localStringBuilder.append(", time:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", maxDuration:");
      localStringBuilder.append(this.c);
      QLog.i("CameraSegmentCaptureLayout", 2, localStringBuilder.toString());
    }
    if (this.n)
    {
      if ((this.j instanceof QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)) {
        ((QIMCameraSegmentCaptureButtonLayoutNew.SegmentCaptureButtonListener)this.j).d();
      } else {
        Log.e("CameraSegmentCaptureLayout", "updateProgress: should use instance of SegmentCaptureButtonListener to get callback");
      }
      o();
    }
  }
  
  public void o()
  {
    if (!this.p) {
      return;
    }
    if (!this.C)
    {
      super.o();
      return;
    }
    if ((this.s != 3) && (this.s != 1))
    {
      if (this.s == 2) {
        this.w.sendEmptyMessage(4);
      }
    }
    else
    {
      this.b.set(true);
      this.w.removeMessages(5);
      this.w.removeMessages(9);
      e();
      if (this.a.get())
      {
        if (this.B.get()) {
          this.w.sendEmptyMessage(7);
        } else {
          q();
        }
      }
      else
      {
        q();
        this.w.removeMessages(1);
      }
    }
    this.p = false;
    this.h.changeMode(0);
  }
  
  protected void q()
  {
    if (this.j != null) {
      this.j.af();
    }
    c(true);
  }
  
  public void setCurrentAnimatorValue(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    super.setMaxDuration(paramFloat);
    this.D = (this.c * 0.98F / 1000.0F);
  }
  
  public void setSegment(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew
 * JD-Core Version:    0.7.0.1
 */