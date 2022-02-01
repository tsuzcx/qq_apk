package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.CaptureListener;
import com.tencent.aelight.camera.aebase.view.IAECaptureButton.CountDownDelegate;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;

public class AEFlashCameraCaptureButtonLayout
  extends AEPituCameraCaptureButtonLayout
{
  protected int a = 1;
  private int aa;
  private int ab;
  private View ac;
  private AnimationFlashProgress ad;
  private TextView ae;
  private AECameraGLSurfaceView af;
  private ImageView ag;
  private long ah = 0L;
  private long ai = 0L;
  private AbsAECaptureButton.CaptureListener aj;
  private AEFlashCameraCaptureButtonLayout.IStartCaptureCallBack ak;
  private View.OnTouchListener al = new AEFlashCameraCaptureButtonLayout.1(this);
  protected ValueAnimator b = null;
  protected ValueAnimator c = null;
  protected boolean d = false;
  protected boolean e = false;
  protected boolean f = false;
  protected boolean g = true;
  protected boolean h = false;
  protected IAECaptureButton.CountDownDelegate i;
  protected float j = 15000.0F;
  protected int k = 15;
  ScaleAnimation l = null;
  ScaleAnimation m = null;
  ScaleAnimation n = null;
  ScaleAnimation o = null;
  protected long p = 0L;
  protected AtomicBoolean q = new AtomicBoolean(false);
  protected AtomicBoolean r = new AtomicBoolean(false);
  protected Handler s = new AEFlashCameraCaptureButtonLayout.2(this, Looper.getMainLooper());
  
  public AEFlashCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AEFlashCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void s()
  {
    AEQLog.a("AEFlashCameraCaptureButtonLayout", "recoverImageAnimation");
    if (this.ag == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = this.o;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    localScaleAnimation = this.n;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    this.ag.bringToFront();
    this.ag.setVisibility(0);
    this.o = new ScaleAnimation(1.0F, 1.0F, 1.0F, 1.0F, this.ag.getWidth() / 2.0F + 17.0F, this.ag.getHeight() / 2.0F + 17.0F);
    this.o.setFillAfter(true);
    this.ag.startAnimation(this.o);
  }
  
  private void t()
  {
    AEQLog.a("AEFlashCameraCaptureButtonLayout", "makeForegroundBtnGoneAnimation");
    ImageView localImageView = this.ag;
    if (localImageView != null)
    {
      this.n = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, localImageView.getWidth() / 2.0F, this.ag.getHeight() / 2.0F + 50.0F);
      this.n.setDuration(400L);
      this.n.setFillAfter(true);
      this.n.setAnimationListener(new AEFlashCameraCaptureButtonLayout.7(this));
      this.ag.startAnimation(this.n);
    }
  }
  
  private void u()
  {
    int i1 = this.a;
    if ((i1 != 1) && (i1 != 2) && (i1 != 3) && (i1 != 4)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkStartCapture: isStarting = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" | shortVideoShot = ");
    localStringBuilder.append(this.q.get());
    localStringBuilder.append(" | countDownEnable = ");
    localStringBuilder.append(this.h);
    AEQLog.a("AEFlashCameraCaptureButtonLayout", localStringBuilder.toString());
    boolean bool = this.f;
    if (bool)
    {
      l();
      return;
    }
    if (!bool)
    {
      if (this.h)
      {
        f();
        return;
      }
      k();
    }
  }
  
  private void v()
  {
    ScaleAnimation localScaleAnimation = this.n;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    localScaleAnimation = this.m;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    localScaleAnimation = this.l;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    localScaleAnimation = this.o;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2064056353, this, true);
    this.aa = AIOUtils.b(53.0F, getResources());
    this.ab = AIOUtils.b(80.0F, getResources());
    this.ad = ((AnimationFlashProgress)findViewById(2063990988));
    findViewById(2063990960);
    this.ae = ((TextView)findViewById(2063990961));
    this.ac = findViewById(2063991100);
    this.ag = ((ImageView)findViewById(2063990929));
    this.ac.setOnTouchListener(this.al);
    this.ad.setCenterView();
    this.ag.setImageResource(2063925318);
    this.ag.setVisibility(0);
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ac.getLayoutParams();
    int i1 = this.aa;
    localLayoutParams.width = ((int)(i1 * paramFloat));
    localLayoutParams.height = ((int)(i1 * paramFloat));
    localLayoutParams.addRule(13);
    this.ac.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.ad.getLayoutParams();
    i1 = this.ab;
    localLayoutParams.width = ((int)(i1 * paramFloat));
    localLayoutParams.height = ((int)(i1 * paramFloat));
    localLayoutParams.addRule(13);
    this.ad.setLayoutParams(localLayoutParams);
  }
  
  protected void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(", shortVideoShot:");
    localStringBuilder.append(this.q.get());
    AEQLog.b("AEFlashCameraCaptureButtonLayout", localStringBuilder.toString());
    int i1 = paramMessage.what;
    if (i1 != 9) {
      switch (i1)
      {
      default: 
        return;
      case 6: 
        n();
        break;
      case 5: 
        if (!this.q.get()) {
          return;
        }
        c();
        this.s.sendEmptyMessageDelayed(5, 50L);
        return;
      case 4: 
        paramMessage = this.aj;
        if (paramMessage != null) {
          paramMessage.b();
        }
        b();
        return;
      case 3: 
        if (!this.q.get()) {
          return;
        }
        paramMessage = this.aj;
        if (paramMessage != null) {
          paramMessage.aa();
        }
        this.q.set(false);
        this.r.set(false);
        b();
        setVisibility(8);
        return;
      case 2: 
        this.ae.setVisibility(0);
        paramMessage = this.aj;
        if (paramMessage == null) {
          return;
        }
        paramMessage.ad();
        return;
      case 1: 
        e();
        return;
      }
    }
    paramMessage = this.aj;
    if (paramMessage != null) {
      paramMessage.ac();
    }
    this.ad.setVisibility(0);
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.af = ((AECameraGLSurfaceView)paramGLSurfaceView);
    if ((paramCaptureListener instanceof AbsAECaptureButton.CaptureListener)) {
      this.aj = paramCaptureListener;
    }
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.h = paramBoolean;
    this.i = paramCountDownDelegate;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.isDevelopLevel();
    if (paramMotionEvent.getAction() != 1) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.ac, this.af);
    }
    if (this.d) {
      return false;
    }
    if (!this.g) {
      return false;
    }
    if ((this.aj != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
      this.aj.ae();
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 3)) {
        return i1 == 5;
      }
      long l1 = System.currentTimeMillis();
      paramView = new StringBuilder();
      paramView.append("currentStamp");
      paramView.append(l1);
      paramView.append("timeStamp ");
      paramView.append(this.ah);
      AEQLog.a("AEFlashCameraCaptureButtonLayout", paramView.toString());
      if ((l1 - this.ah < 500L) && (this.a == 3)) {
        return true;
      }
      l();
      return true;
    }
    if (this.e) {
      return false;
    }
    this.ah = System.currentTimeMillis();
    if ((this.ah - this.ai < 500L) && (this.a == 3)) {
      return true;
    }
    this.ai = this.ah;
    u();
    return true;
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void b()
  {
    a(1.0F);
    s();
    this.ad.setVisibility(8);
    this.ad.setProgress(0.0F);
    this.ad.setCenterScaleValue(1.0F);
    this.ae.setText("00:00");
    this.ae.setVisibility(8);
    this.ac.setEnabled(true);
    this.ac.setVisibility(0);
    this.ad.setProgressOffset(-10.0F);
  }
  
  protected void c()
  {
    long l1 = System.currentTimeMillis() - this.p;
    float f1 = (float)l1;
    boolean bool;
    if (f1 >= this.j) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    int i1;
    if (this.d) {
      i1 = QIMCircleProgress.MAX_PROGRESS;
    } else {
      i1 = (int)(f1 / this.j * QIMCircleProgress.MAX_PROGRESS);
    }
    int i2 = (int)l1 / 1000;
    Object localObject;
    if (i2 < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00:");
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(i2);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00:");
      ((StringBuilder)localObject).append(i2);
      localObject = ((StringBuilder)localObject).toString();
    }
    this.ae.setText((CharSequence)localObject);
    this.ad.setProgress(i1);
    QLog.isDevelopLevel();
    if (this.d) {
      l();
    }
  }
  
  protected void d()
  {
    this.m = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, this.ag.getWidth() / 2.0F, this.ag.getHeight() / 2.0F);
    this.l = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, this.ag.getWidth() / 2.0F, this.ag.getHeight() / 2.0F);
    if (this.ag == null) {
      return;
    }
    this.l.setDuration(100L);
    this.l.setFillAfter(true);
    this.m.setDuration(100L);
    this.m.setFillAfter(true);
    this.ag.startAnimation(this.l);
    this.l.setAnimationListener(new AEFlashCameraCaptureButtonLayout.3(this));
  }
  
  @TargetApi(11)
  protected void e()
  {
    this.b = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.b.setDuration(400L);
    this.b.addUpdateListener(new AEFlashCameraCaptureButtonLayout.4(this));
    this.b.addListener(new AEFlashCameraCaptureButtonLayout.5(this));
    this.b.start();
    this.ad.changeMode(1);
    this.c = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.ad.setStrokeWidth(6.0F);
    this.c.setDuration(400L);
    this.c.addUpdateListener(new AEFlashCameraCaptureButtonLayout.6(this));
    this.c.start();
  }
  
  public void f()
  {
    IAECaptureButton.CountDownDelegate localCountDownDelegate = this.i;
    if (localCountDownDelegate != null) {
      localCountDownDelegate.a();
    }
  }
  
  public boolean g()
  {
    return this.ad.getMode() != 0;
  }
  
  public View getCaptureBtn()
  {
    return null;
  }
  
  public long getCaptureVideoStartTimeStamp()
  {
    return this.p;
  }
  
  public float getMaxDuration()
  {
    return 0.0F;
  }
  
  public View getProgressView()
  {
    return this.ad;
  }
  
  public void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ae.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(158.0F, this.ae.getResources());
    this.ae.setLayoutParams(localLayoutParams);
  }
  
  public void i()
  {
    this.e = false;
    this.f = false;
    n();
  }
  
  public void j()
  {
    this.e = true;
    v();
    l();
  }
  
  public void k()
  {
    this.r.set(false);
    AEQLog.a("AEFlashCameraCaptureButtonLayout", "startCapture: 开始拍摄");
    AEFlashCameraCaptureButtonLayout.IStartCaptureCallBack localIStartCaptureCallBack = this.ak;
    if (localIStartCaptureCallBack != null) {
      localIStartCaptureCallBack.a();
    }
    if (this.f)
    {
      AEQLog.b("AEFlashCameraCaptureButtonLayout", "start fail because is started");
      return;
    }
    int i1 = this.a;
    if ((i1 == 3) || (i1 == 1) || (i1 == 4)) {
      this.s.sendEmptyMessageDelayed(1, 100L);
    }
    this.f = true;
    if (this.a == 2) {
      l();
    }
  }
  
  public void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopCapture: 结束拍摄 | shortVideoShot = ");
    localStringBuilder.append(this.q.get());
    localStringBuilder.append(" | mActionUpAnimator = ");
    localStringBuilder.append(this.r.get());
    AEQLog.a("AEFlashCameraCaptureButtonLayout", localStringBuilder.toString());
    if (!this.f)
    {
      AEQLog.b("AEFlashCameraCaptureButtonLayout", "stop failed because is not start");
      return;
    }
    int i1 = this.a;
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return;
          }
          if (this.q.get())
          {
            AEQLog.a("AEFlashCameraCaptureButtonLayout", "in stop capture 1");
            this.r.set(true);
            this.s.removeMessages(5);
            m();
            AEBaseReportParam.a().h(System.currentTimeMillis() - getCaptureVideoStartTimeStamp());
            this.s.sendEmptyMessage(3);
            this.f = false;
            this.ad.changeMode(0);
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("in stop capture 2 ");
          localStringBuilder.append(this.f);
          AEQLog.a("AEFlashCameraCaptureButtonLayout", localStringBuilder.toString());
        }
      }
      else
      {
        this.s.sendEmptyMessage(4);
        this.f = false;
        this.ad.changeMode(0);
        return;
      }
    }
    this.r.set(true);
    this.s.removeMessages(5);
    m();
    this.s.removeMessages(1);
    i1 = this.a;
    if (i1 == 1) {
      this.s.sendEmptyMessage(4);
    } else if (i1 == 3) {
      this.s.sendEmptyMessage(3);
    }
    this.f = false;
    this.ad.changeMode(0);
  }
  
  @TargetApi(11)
  protected void m()
  {
    ValueAnimator localValueAnimator = this.b;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.c;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  public void n()
  {
    b();
    this.r.set(false);
    this.q.set(false);
    this.p = 0L;
    this.d = false;
  }
  
  public void setCaptureBtnStyle(AEFlashCameraCaptureButtonLayout.Style paramStyle)
  {
    if (this.ag == null) {
      return;
    }
    int i1 = AEFlashCameraCaptureButtonLayout.8.a[paramStyle.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      this.a = 3;
      this.ag.setVisibility(0);
      this.ag.setImageResource(2063925319);
      this.ad.setVisibility(8);
      d();
      invalidate();
      return;
    }
    this.a = 2;
    this.ag.setVisibility(0);
    this.ag.setImageResource(2063925318);
    this.ad.setVisibility(8);
    d();
    invalidate();
  }
  
  public void setFunctionFlag(int paramInt)
  {
    if (paramInt != -1) {
      this.a = paramInt;
    }
  }
  
  public void setMaxDuration(float paramFloat) {}
  
  public void setStartCallBack(AEFlashCameraCaptureButtonLayout.IStartCaptureCallBack paramIStartCaptureCallBack)
  {
    this.ak = paramIStartCaptureCallBack;
  }
  
  public void setTouchEnable(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */