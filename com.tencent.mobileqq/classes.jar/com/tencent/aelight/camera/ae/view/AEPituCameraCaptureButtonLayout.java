package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.CaptureListener;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;
import com.tencent.aelight.camera.aebase.view.IAECaptureButton.CountDownDelegate;
import com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout;
import com.tencent.aelight.camera.impl.R.styleable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class AEPituCameraCaptureButtonLayout
  extends AbsAECaptureButton
{
  protected AECameraGLSurfaceView A;
  protected AnimationQIMCircleProgress B;
  protected ImageView C;
  protected AECircleCaptureProgressView D;
  protected QIMCameraCountTimeLayout E;
  protected View F;
  ScaleAnimation G = null;
  ScaleAnimation H = null;
  protected AEPituCameraCaptureButtonLayout.PituCaptureButtonListener I;
  protected long J = 0L;
  protected ValueAnimator K = null;
  protected ValueAnimator L = null;
  protected boolean M = false;
  protected boolean N = false;
  protected boolean O = false;
  protected boolean P = false;
  protected IAECaptureButton.CountDownDelegate Q;
  protected int R = 1;
  protected AEPituCameraCaptureButtonLayout.CaptureButtonProgressInterceptor S;
  protected View T;
  protected BubbleTextView U;
  protected Runnable V;
  protected boolean W = true;
  protected Handler Z = new AEPituCameraCaptureButtonLayout.8(this, Looper.getMainLooper());
  private int a;
  private int b;
  private boolean c = true;
  private boolean d;
  private Runnable e;
  private boolean f = true;
  private boolean g = true;
  private View.OnTouchListener h = new AEPituCameraCaptureButtonLayout.6(this);
  protected AtomicBoolean t = new AtomicBoolean(false);
  protected AtomicBoolean u = new AtomicBoolean(false);
  protected float v = 20000.0F;
  protected int w = 20;
  public View x;
  public View y;
  protected View z;
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.e == null) {
            this.e = new AEPituCameraCaptureButtonLayout.7(this, paramView, paramMotionEvent);
          }
          ThreadManager.getUIHandler().postDelayed(this.e, 100L);
          return true;
        }
        if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() >= 100L) {
          d(paramView, paramMotionEvent);
        }
        return true;
      }
      boolean bool = c(paramView, paramMotionEvent);
      return bool;
    }
    finally {}
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    d(paramView, paramMotionEvent);
    return a(paramView, paramMotionEvent);
  }
  
  private void d()
  {
    AEQLog.a("CameraCaptureLayout", "makeForegroundBtnGoneAnimation");
    ImageView localImageView = this.C;
    if (localImageView != null)
    {
      this.G = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, localImageView.getWidth() / 2.0F, this.C.getHeight() / 2.0F + 50.0F);
      this.G.setDuration(400L);
      this.G.setFillAfter(true);
      this.G.setAnimationListener(new AEPituCameraCaptureButtonLayout.2(this));
      this.C.startAnimation(this.G);
    }
  }
  
  private void d(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.O)
    {
      a(paramView, paramMotionEvent);
      return;
    }
    if (this.e != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.e);
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(0);
      a(paramView, paramMotionEvent);
      paramMotionEvent.recycle();
    }
    this.e = null;
  }
  
  private void s()
  {
    AEQLog.a("CameraCaptureLayout", "recoverImageAnimation");
    if (this.C == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = this.H;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    localScaleAnimation = this.G;
    if (localScaleAnimation != null) {
      localScaleAnimation.cancel();
    }
    this.C.bringToFront();
    this.C.setVisibility(0);
    this.H = new ScaleAnimation(1.0F, 1.0F, 1.0F, 1.0F, this.C.getWidth() / 2.0F + 17.0F, this.C.getHeight() / 2.0F + 17.0F);
    this.H.setFillAfter(true);
    this.C.startAnimation(this.H);
  }
  
  private void t()
  {
    int i = this.R;
    if ((i != 1) && (i != 2) && (i != 3))
    {
      if (i != 4) {
        return;
      }
      if (!AEResUtil.e())
      {
        QQToast.makeText(getContext(), 1, getContext().getString(2064187616), 1).show();
        return;
      }
      if ((this.O) && (this.t.get()))
      {
        l();
        return;
      }
      if (!this.O)
      {
        if ((this.f) && (this.P))
        {
          f();
          return;
        }
        k();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkStartCapture: isStarting = ");
      localStringBuilder.append(this.O);
      localStringBuilder.append(" | shortVideoShot = ");
      localStringBuilder.append(this.t.get());
      localStringBuilder.append(" | countDownEnable = ");
      localStringBuilder.append(this.P);
      AEQLog.a("CameraCaptureLayout", localStringBuilder.toString());
      if ((this.O) && (this.t.get()))
      {
        l();
        return;
      }
      if (!this.O)
      {
        if (((this.f) || (w())) && (this.P))
        {
          f();
          return;
        }
        k();
      }
    }
  }
  
  private boolean u()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntryManager.o(((Activity)getContext()).getIntent()));
  }
  
  private boolean v()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntryManager.q(((Activity)getContext()).getIntent()));
  }
  
  private boolean w()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntryManager.p(((Activity)getContext()).getIntent()));
  }
  
  protected void a()
  {
    if (!this.d)
    {
      LayoutInflater.from(getContext()).inflate(2064056509, this, true);
      this.a = AIOUtils.b(53.0F, getResources());
      this.b = AIOUtils.b(80.0F, getResources());
      this.B = ((AnimationQIMCircleProgress)findViewById(2063990988));
      this.B.setBackgroundResource(2063925625);
      this.B.setCenterView();
      this.B.setVisibility(0);
      this.B.changeMode(0);
      this.C = ((ImageView)findViewById(2063990929));
      this.C.setVisibility(0);
      this.C.bringToFront();
      this.C.setImageResource(2063925319);
    }
    else
    {
      LayoutInflater.from(getContext()).inflate(2064056331, this, true);
      this.a = AIOUtils.b(98.0F, getResources());
      this.b = AIOUtils.b(98.0F, getResources());
      this.D = ((AECircleCaptureProgressView)findViewById(2063990988));
      this.F = findViewById(2063991157);
      this.D.setCenterView();
      this.D.setVisibility(0);
      this.D.a(0);
      this.U = ((BubbleTextView)findViewById(2063990934));
    }
    this.z = findViewById(2063990960);
    this.y = findViewById(2063991100);
    this.y.setOnTouchListener(this.h);
    this.y.setEnabled(true);
    this.x = findViewById(2063991101);
    this.x.setOnTouchListener(this.h);
    AECameraDaTongHelper.a.a(this.y, "em_ae_photo_btn");
    VideoReport.setElementParam(this.y, "test_p", "test_v");
    this.E = ((QIMCameraCountTimeLayout)findViewById(2063990961));
    this.E.setIsCircleStyle(this.d);
    this.T = findViewById(2063990989);
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
    int i = this.a;
    localLayoutParams.width = ((int)(i * paramFloat));
    localLayoutParams.height = ((int)(i * paramFloat));
    localLayoutParams.addRule(13);
    if (!this.d)
    {
      this.y.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.B.getLayoutParams();
      i = this.b;
      localLayoutParams.width = ((int)(i * paramFloat));
      localLayoutParams.height = ((int)(i * paramFloat));
      localLayoutParams.addRule(13);
      this.B.setLayoutParams(localLayoutParams);
      return;
    }
    this.D.a(paramFloat);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.f);
    if (paramContext == null) {
      return;
    }
    this.d = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  protected void a(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage what:");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(", shortVideoShot:");
    ((StringBuilder)localObject).append(this.t.get());
    AEQLog.b("CameraCaptureLayout", ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 9) {
      switch (i)
      {
      default: 
        return;
      case 6: 
        n();
        break;
      case 5: 
        if (!this.t.get()) {
          return;
        }
        c();
        this.Z.sendEmptyMessageDelayed(5, 50L);
        return;
      case 4: 
        paramMessage = this.I;
        if (paramMessage != null) {
          paramMessage.b();
        }
        b();
        if (v()) {
          AEBaseDataReporter.a().l();
        }
        if (!u()) {
          return;
        }
        paramMessage = new HashMap();
        paramMessage.put("ext6", String.valueOf(AEBeautyProviderView.getBeautyFeature()));
        paramMessage.put("ext7", String.valueOf(AEBeautyProviderView.getSharpFaceFeature()));
        if (AEMaterialManager.n() != null) {
          paramMessage.put("ext15", AEMaterialManager.n().m);
        }
        if (AEMaterialManager.o() != null) {
          paramMessage.put("ext16", AEMaterialManager.o().m);
        }
        localObject = (AEMaterialManager)AEQIMManager.a(1);
        if (localObject != null) {
          paramMessage.put("ext17", ((AEMaterialManager)localObject).b());
        }
        AEReportUtils.b(14, paramMessage);
        return;
      case 3: 
        if (!this.t.get()) {
          return;
        }
        paramMessage = this.I;
        if (paramMessage != null) {
          paramMessage.aa();
        }
        this.t.set(false);
        this.u.set(false);
        b();
        setVisibility(8);
        return;
      case 2: 
        this.E.setVisibility(0);
        paramMessage = this.I;
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
    paramMessage = this.I;
    if (paramMessage != null) {
      paramMessage.ac();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    BubbleTextView localBubbleTextView = this.U;
    if (localBubbleTextView == null) {
      return;
    }
    if (!AECommonUtil.a(localBubbleTextView, paramMotionEvent)) {
      o();
    }
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.A = ((AECameraGLSurfaceView)paramGLSurfaceView);
    if ((paramCaptureListener instanceof AEPituCameraCaptureButtonLayout.PituCaptureButtonListener))
    {
      this.I = ((AEPituCameraCaptureButtonLayout.PituCaptureButtonListener)paramCaptureListener);
      return;
    }
    throw new IllegalArgumentException("arg listener must be instance of PituCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d)
    {
      localObject = this.B;
      if (localObject != null) {
        ((AnimationQIMCircleProgress)localObject).a(paramBoolean);
      }
    }
    else
    {
      localObject = this.D;
      if (localObject != null) {
        ((AECircleCaptureProgressView)localObject).a(paramBoolean);
      }
    }
    Object localObject = this.E;
    if (localObject != null)
    {
      int i;
      if (paramBoolean) {
        i = -16777216;
      } else {
        i = -1;
      }
      ((QIMCameraCountTimeLayout)localObject).setTextColor(i);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.d)
    {
      localObject = this.B;
      if (localObject != null) {
        ((AnimationQIMCircleProgress)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      }
    }
    else
    {
      localObject = this.D;
      if (localObject != null) {
        ((AECircleCaptureProgressView)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      }
      if (this.F != null)
      {
        int i = paramAECircleCaptureStyle.m;
        this.F.setBackgroundResource(i);
      }
    }
    Object localObject = this.E;
    if ((localObject != null) && (paramBoolean))
    {
      ((QIMCameraCountTimeLayout)localObject).setTextColor(paramAECircleCaptureStyle.r);
      this.E.setTextShadow(paramAECircleCaptureStyle.s);
      this.E.setDotView(paramAECircleCaptureStyle.q);
    }
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.P = paramBoolean;
    this.Q = paramCountDownDelegate;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.isDevelopLevel();
    if (!this.c) {
      return false;
    }
    if ((this.g) && (paramMotionEvent.getAction() != 1)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.y, this.A);
    }
    if (this.M) {
      return false;
    }
    if (!this.W) {
      return false;
    }
    if ((this.I != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
      this.I.ae();
    }
    if (this.T.getVisibility() == 0)
    {
      r();
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return i == 5;
        }
        if (!this.d)
        {
          l();
          return true;
        }
        this.O = false;
        this.Z.removeMessages(1);
        return true;
      }
      l();
      return true;
    }
    o();
    if (this.N) {
      return false;
    }
    t();
    return true;
  }
  
  protected void b()
  {
    a(1.0F);
    s();
    if (!this.d)
    {
      this.B.setProgressOffset(-10.0F);
      this.B.setProgress(0.0F);
      this.B.setCenterScaleValue(1.0F);
    }
    else
    {
      this.D.setProgress(0.0F);
      this.D.setCenterScaleValue(1.0F);
    }
    if (!this.d) {
      this.E.setText("0秒");
    } else {
      this.E.setText("00:00");
    }
    this.E.setVisibility(8);
    this.y.setEnabled(true);
    this.y.setVisibility(0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.T.setVisibility(0);
      return;
    }
    this.T.setVisibility(8);
  }
  
  protected void c()
  {
    if (this.S == null)
    {
      long l = System.currentTimeMillis() - this.J;
      float f1 = (float)l;
      boolean bool;
      if (f1 >= this.v) {
        bool = true;
      } else {
        bool = false;
      }
      this.M = bool;
      int i;
      if (this.M) {
        i = QIMCircleProgress.MAX_PROGRESS;
      } else {
        i = (int)(f1 / this.v * QIMCircleProgress.MAX_PROGRESS);
      }
      Object localObject;
      if (!this.d)
      {
        int j = (int)l / 1000;
        if (j < 10)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("00:");
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(j);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("00:");
          ((StringBuilder)localObject).append(j);
          localObject = ((StringBuilder)localObject).toString();
        }
        this.E.setText((String)localObject);
        this.B.setProgress(i);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((int)l / 1000);
        ((StringBuilder)localObject).append("秒");
        localObject = ((StringBuilder)localObject).toString();
        this.E.setText((String)localObject);
        this.D.setProgress(i);
      }
      QLog.isDevelopLevel();
    }
    if (this.M) {
      l();
    }
  }
  
  @TargetApi(11)
  protected void e()
  {
    if (!this.d)
    {
      d();
      this.K = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    }
    else
    {
      this.K = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1735F });
    }
    if (!this.d) {
      this.K.setDuration(400L);
    } else {
      this.K.setDuration(300L);
    }
    this.K.addUpdateListener(new AEPituCameraCaptureButtonLayout.3(this));
    this.K.addListener(new AEPituCameraCaptureButtonLayout.4(this));
    this.K.start();
    if (!this.d) {
      this.B.changeMode(1);
    } else {
      this.D.a(1);
    }
    if (!this.d)
    {
      this.L = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      this.B.setStrokeWidth(6.0F);
    }
    else
    {
      this.L = ValueAnimator.ofFloat(new float[] { 1.0F, 0.6F });
      this.D.setStrokeWidth(5.0F);
    }
    if (!this.d) {
      this.L.setDuration(400L);
    } else {
      this.L.setDuration(300L);
    }
    this.L.addUpdateListener(new AEPituCameraCaptureButtonLayout.5(this));
    this.L.start();
  }
  
  public void f()
  {
    IAECaptureButton.CountDownDelegate localCountDownDelegate = this.Q;
    if (localCountDownDelegate != null) {
      localCountDownDelegate.a();
    }
  }
  
  public boolean g()
  {
    if (!this.d) {
      return this.B.getMode() != 0;
    }
    return this.D.getMode() != 0;
  }
  
  public View getCaptureBtn()
  {
    return this.y;
  }
  
  public long getCaptureVideoStartTimeStamp()
  {
    return this.J;
  }
  
  public float getMaxDuration()
  {
    return this.v;
  }
  
  public View getProgressView()
  {
    if (u()) {
      return this.D;
    }
    return this.B;
  }
  
  public void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(158.0F, this.E.getResources());
    this.E.setLayoutParams(localLayoutParams);
  }
  
  public void i()
  {
    this.N = false;
    this.O = false;
    p();
    n();
  }
  
  public void j()
  {
    this.N = true;
    l();
  }
  
  public void k()
  {
    this.u.set(false);
    AEQLog.a("CameraCaptureLayout", "startCapture: 开始拍摄");
    if (this.O)
    {
      AEQLog.b("CameraCaptureLayout", "start fail because is started");
      return;
    }
    int i = this.R;
    if ((i == 3) || (i == 1) || (i == 4)) {
      this.Z.sendEmptyMessageDelayed(1, 100L);
    }
    this.O = true;
    if (this.R == 2) {
      l();
    }
  }
  
  public void l()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopCapture: 结束拍摄 | shortVideoShot = ");
    ((StringBuilder)localObject).append(this.t.get());
    ((StringBuilder)localObject).append(" | mActionUpAnimator = ");
    ((StringBuilder)localObject).append(this.u.get());
    AEQLog.a("CameraCaptureLayout", ((StringBuilder)localObject).toString());
    if (!this.O)
    {
      AEQLog.b("CameraCaptureLayout", "stop failed because is not start");
      return;
    }
    int i = this.R;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (this.t.get())
          {
            AEQLog.a("CameraCaptureLayout", "in stop capture 1");
            this.u.set(true);
            this.Z.removeMessages(5);
            m();
            AEBaseReportParam.a().h(System.currentTimeMillis() - getCaptureVideoStartTimeStamp());
            this.Z.sendEmptyMessage(3);
            this.O = false;
            if (!this.d)
            {
              this.B.changeMode(0);
              return;
            }
            this.D.a(0);
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("in stop capture 2 ");
          ((StringBuilder)localObject).append(this.O);
          AEQLog.a("CameraCaptureLayout", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.Z.sendEmptyMessage(4);
        this.O = false;
        if (!this.d)
        {
          this.B.changeMode(0);
          return;
        }
        this.D.a(0);
        return;
      }
    }
    this.u.set(true);
    this.Z.removeMessages(5);
    m();
    if (this.t.get())
    {
      this.Z.sendEmptyMessage(3);
    }
    else
    {
      this.Z.removeMessages(1);
      i = this.R;
      if (i == 1)
      {
        this.Z.sendEmptyMessage(4);
      }
      else if (i == 3)
      {
        this.Z.sendEmptyMessage(3);
        localObject = this.I;
        if (localObject != null) {
          ((AEPituCameraCaptureButtonLayout.PituCaptureButtonListener)localObject).af();
        }
      }
    }
    this.O = false;
    if (!this.d)
    {
      this.B.changeMode(0);
      return;
    }
    this.D.a(0);
  }
  
  @TargetApi(11)
  protected void m()
  {
    ValueAnimator localValueAnimator = this.K;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.L;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  public void n()
  {
    b();
    this.u.set(false);
    this.t.set(false);
    this.J = 0L;
    this.M = false;
  }
  
  public void o()
  {
    BubbleTextView localBubbleTextView = this.U;
    if (localBubbleTextView == null) {
      return;
    }
    localBubbleTextView.setVisibility(8);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BubbleTextView localBubbleTextView = this.U;
    if (localBubbleTextView != null)
    {
      localBubbleTextView.removeCallbacks(this.V);
      o();
    }
  }
  
  public void p()
  {
    BubbleTextView localBubbleTextView = this.U;
    if (localBubbleTextView == null) {
      return;
    }
    if (localBubbleTextView.getVisibility() != 0)
    {
      if (AECameraPrefsUtil.a().b("sp_key_ae_photo_photo_video_take_tips", false, 0)) {
        return;
      }
      AECameraPrefsUtil.a().a("sp_key_ae_photo_photo_video_take_tips", true, 0);
      int i = UIUtils.a(getContext(), 8.0F);
      int j = UIUtils.a(getContext(), 6.0F);
      this.U.setPadding(i, j, i, j);
      this.U.setIncludeFontPadding(false);
      this.U.setTextSize(1, 14.0F);
      this.U.e = Color.parseColor("#252525");
      this.U.setTextColor(-1);
      this.U.b = UIUtils.a(getContext(), 6.0F);
      this.U.setText(getContext().getString(2064187429));
      this.U.a();
      this.U.setVisibility(0);
      this.V = new AEPituCameraCaptureButtonLayout.1(this);
      this.U.postDelayed(this.V, 5000L);
    }
  }
  
  protected void q() {}
  
  public void r()
  {
    b(false);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.W == paramBoolean) {
      return;
    }
    this.W = paramBoolean;
    if (this.W)
    {
      this.x.setVisibility(8);
      this.y.setVisibility(0);
      if (this.d)
      {
        this.B.setVisibility(0);
        return;
      }
      this.D.setVisibility(0);
      return;
    }
    this.x.setVisibility(0);
    this.y.setVisibility(8);
    if (this.d)
    {
      this.B.setVisibility(8);
      return;
    }
    this.D.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    if (paramInt != -1) {
      this.R = paramInt;
    }
  }
  
  public void setGifMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.v = paramFloat;
    this.w = ((int)(this.v / 1000.0F));
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */