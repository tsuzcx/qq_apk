package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraCaptureButtonLayoutNew
  extends AbsAECaptureButton
{
  private boolean A = true;
  private boolean B = true;
  private View.OnTouchListener C = new QIMCameraCaptureButtonLayoutNew.5(this);
  protected AtomicBoolean a = new AtomicBoolean(false);
  protected AtomicBoolean b = new AtomicBoolean(false);
  protected float c = 20000.0F;
  public View d;
  public View e;
  protected View f;
  protected GLSurfaceView g;
  protected AnimationQIMCircleProgress h;
  protected QIMCameraCountTimeLayout i;
  protected QIMCameraCaptureButtonLayoutNew.CaptureButtonListener j;
  protected long k = 0L;
  protected ValueAnimator l = null;
  protected ValueAnimator m = null;
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = false;
  protected boolean q = false;
  protected IAECaptureButton.CountDownDelegate r;
  protected int s = 1;
  protected QIMCameraCaptureButtonLayoutNew.CaptureButtonProgressInterceptor t;
  protected View u;
  protected boolean v = true;
  protected Handler w = new QIMCameraCaptureButtonLayoutNew.6(this, Looper.getMainLooper());
  private int x = AIOUtils.b(53.0F, getResources());
  private int y = AIOUtils.b(80.0F, getResources());
  private TextView z;
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void q()
  {
    int i1 = this.s;
    if ((i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4) {
        return;
      }
      if (!AEResUtil.e())
      {
        QQToast.makeText(getContext(), 1, getContext().getString(2064187616), 1).show();
        return;
      }
      if ((this.p) && (this.a.get()))
      {
        o();
        return;
      }
      if (!this.p)
      {
        if (this.q)
        {
          n();
          return;
        }
        k();
      }
    }
    else
    {
      k();
    }
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2064056509, this, true);
    this.f = findViewById(2063990960);
    this.h = ((AnimationQIMCircleProgress)findViewById(2063990988));
    this.e = findViewById(2063991100);
    this.e.setOnTouchListener(this.C);
    this.e.setEnabled(true);
    this.d = findViewById(2063991101);
    this.d.setOnTouchListener(this.C);
    this.h.setBackgroundResource(2063925625);
    this.h.setCenterView();
    this.h.setVisibility(0);
    this.h.changeMode(0);
    this.i = ((QIMCameraCountTimeLayout)findViewById(2063990961));
    this.z = ((TextView)findViewById(2063991054));
    this.u = findViewById(2063990989);
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    int i1 = this.x;
    localLayoutParams.width = ((int)(i1 * paramFloat));
    localLayoutParams.height = ((int)(i1 * paramFloat));
    localLayoutParams.addRule(13);
    this.e.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    i1 = this.y;
    localLayoutParams.width = ((int)(i1 * paramFloat));
    localLayoutParams.height = ((int)(i1 * paramFloat));
    localLayoutParams.addRule(13);
    this.h.setLayoutParams(localLayoutParams);
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
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, localStringBuilder.toString());
    }
    int i1 = paramMessage.what;
    if (i1 != 9) {
      switch (i1)
      {
      default: 
        return;
      case 6: 
        l();
        break;
      case 5: 
        if (!this.a.get()) {
          return;
        }
        m();
        this.w.sendEmptyMessageDelayed(5, 50L);
        return;
      case 4: 
        paramMessage = this.j;
        if (paramMessage != null) {
          paramMessage.b();
        }
        f();
        return;
      case 3: 
        if (!this.a.get()) {
          return;
        }
        paramMessage = this.j;
        if (paramMessage != null) {
          paramMessage.aa();
        }
        this.a.set(false);
        f();
        return;
      case 2: 
        paramMessage = this.j;
        if (paramMessage == null) {
          return;
        }
        paramMessage.ad();
        return;
      case 1: 
        c();
        return;
      }
    }
    paramMessage = this.j;
    if (paramMessage != null) {
      paramMessage.ac();
    }
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.g = paramGLSurfaceView;
    if ((paramCaptureListener instanceof QIMCameraCaptureButtonLayoutNew.CaptureButtonListener))
    {
      this.j = ((QIMCameraCaptureButtonLayoutNew.CaptureButtonListener)paramCaptureListener);
      return;
    }
    throw new IllegalArgumentException("listener should be instance of SegmentCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((AnimationQIMCircleProgress)localObject).a(paramBoolean);
    }
    localObject = this.i;
    if (localObject != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = -16777216;
      } else {
        i1 = -1;
      }
      ((QIMCameraCountTimeLayout)localObject).setTextColor(i1);
    }
  }
  
  public void a(boolean paramBoolean, AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    super.a(paramBoolean, paramAECircleCaptureStyle);
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.q = paramBoolean;
    this.r = paramCountDownDelegate;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("touch action:");
      paramView.append(paramMotionEvent.getAction() & 0xFF);
      paramView.append(", shortVideoShot:");
      paramView.append(this.a.get());
      paramView.append(", actionUp:");
      paramView.append(this.b.get());
      paramView.append(", isOver:");
      paramView.append(this.n);
      paramView.append(", mTouchEnable:");
      paramView.append(this.A);
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, paramView.toString());
    }
    b();
    if (!this.A) {
      return false;
    }
    if (this.B) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.e, this.g);
    }
    if (this.n) {
      return false;
    }
    if (!this.v)
    {
      if ((this.j != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.j.c();
      }
      return false;
    }
    if (this.u.getVisibility() == 0)
    {
      p();
      return false;
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 3))
      {
        if (i1 != 5) {
          return false;
        }
        paramView = this.j;
        if (paramView != null) {
          paramView.a();
        }
        return false;
      }
      o();
      return true;
    }
    if (this.o) {
      return false;
    }
    q();
    return true;
  }
  
  public void b()
  {
    TextView localTextView = this.z;
    if ((localTextView != null) && (localTextView.getVisibility() == 0))
    {
      this.z.clearAnimation();
      this.z.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.u.setVisibility(0);
      return;
    }
    this.u.setVisibility(8);
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.l = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.l.setDuration(400L);
    this.l.addUpdateListener(new QIMCameraCaptureButtonLayoutNew.2(this));
    this.l.addListener(new QIMCameraCaptureButtonLayoutNew.3(this));
    this.l.start();
    this.h.changeMode(1);
    this.m = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.m.setDuration(400L);
    this.h.setStrokeWidth(3.0F);
    this.m.addUpdateListener(new QIMCameraCaptureButtonLayoutNew.4(this));
    this.m.start();
  }
  
  protected void d() {}
  
  @TargetApi(11)
  protected void e()
  {
    ValueAnimator localValueAnimator = this.l;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.m;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected void f()
  {
    a(1.0F);
    this.h.setProgress(0.0F);
    this.h.setCenterScaleValue(1.0F);
    this.i.setText("0秒");
    this.i.setVisibility(8);
    this.e.setEnabled(true);
    this.e.setVisibility(0);
  }
  
  public boolean g()
  {
    return this.h.getMode() != 0;
  }
  
  public View getCaptureBtn()
  {
    return this.e;
  }
  
  public long getCaptureVideoStartTimeStamp()
  {
    return this.k;
  }
  
  public float getMaxDuration()
  {
    return this.c;
  }
  
  public AnimationQIMCircleProgress getProgressView()
  {
    return this.h;
  }
  
  public void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(158.0F, this.i.getResources());
    this.i.setLayoutParams(localLayoutParams);
  }
  
  public void i()
  {
    this.o = false;
    l();
  }
  
  public void j()
  {
    this.o = true;
    o();
  }
  
  public void k()
  {
    if (this.p)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "start fail because is started");
      }
      return;
    }
    int i1 = this.s;
    if ((i1 == 3) || (i1 == 1) || (i1 == 4)) {
      this.w.sendEmptyMessageDelayed(1, 100L);
    }
    this.p = true;
    if (this.s == 2) {
      o();
    }
  }
  
  public void l()
  {
    f();
    this.b.set(false);
    this.a.set(false);
    this.k = 0L;
    this.n = false;
  }
  
  protected void m()
  {
    if (this.t == null)
    {
      long l1 = System.currentTimeMillis() - this.k;
      float f1 = (float)l1;
      boolean bool;
      if (f1 >= this.c) {
        bool = true;
      } else {
        bool = false;
      }
      this.n = bool;
      int i1;
      if (this.n) {
        i1 = QIMCircleProgress.MAX_PROGRESS;
      } else {
        i1 = (int)(f1 / this.c * QIMCircleProgress.MAX_PROGRESS);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)l1 / 1000);
      ((StringBuilder)localObject).append("秒");
      localObject = ((StringBuilder)localObject).toString();
      this.i.setText((String)localObject);
      this.h.setProgress(i1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateProgress percent:");
        localStringBuilder.append(i1);
        localStringBuilder.append(", time:");
        localStringBuilder.append((String)localObject);
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, localStringBuilder.toString());
      }
    }
    if (this.n) {
      o();
    }
  }
  
  public void n()
  {
    IAECaptureButton.CountDownDelegate localCountDownDelegate = this.r;
    if (localCountDownDelegate != null) {
      localCountDownDelegate.a();
    }
  }
  
  public void o()
  {
    if (!this.p)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "stop failed because is not start");
      }
      return;
    }
    int i1 = this.s;
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return;
          }
          if (!this.a.get()) {
            return;
          }
          this.b.set(true);
          this.w.removeMessages(5);
          e();
          AEBaseReportParam.a().h(System.currentTimeMillis() - getCaptureVideoStartTimeStamp());
          this.w.sendEmptyMessage(3);
          this.p = false;
          this.h.changeMode(0);
        }
      }
      else
      {
        this.w.sendEmptyMessage(4);
        this.p = false;
        this.h.changeMode(0);
        return;
      }
    }
    this.b.set(true);
    this.w.removeMessages(5);
    e();
    if (this.a.get())
    {
      this.w.sendEmptyMessage(3);
    }
    else
    {
      this.w.removeMessages(1);
      i1 = this.s;
      if (i1 == 1)
      {
        this.w.sendEmptyMessage(4);
      }
      else if (i1 == 3)
      {
        QIMCameraCaptureButtonLayoutNew.CaptureButtonListener localCaptureButtonListener = this.j;
        if (localCaptureButtonListener != null) {
          localCaptureButtonListener.af();
        }
      }
    }
    this.p = false;
    this.h.changeMode(0);
  }
  
  public void p()
  {
    b(false);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.v == paramBoolean) {
      return;
    }
    this.v = paramBoolean;
    if (this.v)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.h.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setIsFollowCaptureTips()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.z.getLayoutParams();
    localLayoutParams.topMargin += ScreenUtil.dip2px(10.0F);
    this.z.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.z.setText(paramString);
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
 * JD-Core Version:    0.7.0.1
 */