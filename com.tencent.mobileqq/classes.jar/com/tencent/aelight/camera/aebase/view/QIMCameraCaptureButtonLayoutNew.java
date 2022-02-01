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
  protected float a;
  protected int a;
  protected long a;
  protected ValueAnimator a;
  protected GLSurfaceView a;
  protected Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new QIMCameraCaptureButtonLayoutNew.5(this);
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AnimationQIMCircleProgress a;
  protected IAECaptureButton.CountDownDelegate a;
  protected QIMCameraCaptureButtonLayoutNew.CaptureButtonListener a;
  protected QIMCameraCaptureButtonLayoutNew.CaptureButtonProgressInterceptor a;
  protected QIMCameraCountTimeLayout a;
  protected AtomicBoolean a;
  protected boolean a;
  private int b;
  protected ValueAnimator b;
  public View b;
  protected AtomicBoolean b;
  protected boolean b;
  private int c;
  protected View c;
  protected boolean c;
  protected View d;
  protected boolean d;
  protected boolean e = true;
  private boolean f = true;
  private boolean g = true;
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = AIOUtils.b(53.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.b(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new QIMCameraCaptureButtonLayoutNew.6(this, Looper.getMainLooper());
    a();
  }
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = AIOUtils.b(53.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.b(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new QIMCameraCaptureButtonLayoutNew.6(this, Looper.getMainLooper());
    a();
  }
  
  private void p()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != 1) && (i != 2) && (i != 3))
    {
      if (i != 4) {
        return;
      }
      if (!AEResUtil.a())
      {
        QQToast.a(getContext(), 1, getContext().getString(2064515266), 1).a();
        return;
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        m();
        return;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          j();
          return;
        }
        n();
      }
    }
    else
    {
      n();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2064318679, this, true);
    this.jdField_c_of_type_AndroidViewView = findViewById(2064122026);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2064122074));
    this.jdField_b_of_type_AndroidViewView = findViewById(2064122218);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2064122219);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setBackgroundResource(2064056660);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setCenterView();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2064122027));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122169));
    this.jdField_d_of_type_AndroidViewView = findViewById(2064122075);
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_Int;
    localLayoutParams.width = ((int)(i * paramFloat));
    localLayoutParams.height = ((int)(i * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getLayoutParams();
    i = this.jdField_c_of_type_Int;
    localLayoutParams.width = ((int)(i * paramFloat));
    localLayoutParams.height = ((int)(i * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setLayoutParams(localLayoutParams);
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
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 9) {
      switch (i)
      {
      default: 
        return;
      case 6: 
        h();
        break;
      case 5: 
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        i();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
        return;
      case 4: 
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
        if (paramMessage != null) {
          paramMessage.a();
        }
        g();
        return;
      case 3: 
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
        if (paramMessage != null) {
          paramMessage.C();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        g();
        return;
      case 2: 
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
        if (paramMessage == null) {
          return;
        }
        paramMessage.E();
        return;
      case 1: 
        c();
        return;
      }
    }
    paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
    if (paramMessage != null) {
      paramMessage.D();
    }
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    if ((paramCaptureListener instanceof QIMCameraCaptureButtonLayoutNew.CaptureButtonListener))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener = ((QIMCameraCaptureButtonLayoutNew.CaptureButtonListener)paramCaptureListener);
      return;
    }
    throw new IllegalArgumentException("listener should be instance of SegmentCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localObject != null) {
      ((AnimationQIMCircleProgress)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout;
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
  
  public void a(boolean paramBoolean, AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    super.a(paramBoolean, paramAECircleCaptureStyle);
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewIAECaptureButton$CountDownDelegate = paramCountDownDelegate;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getMode() != 0;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("touch action:");
      paramView.append(paramMotionEvent.getAction() & 0xFF);
      paramView.append(", shortVideoShot:");
      paramView.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      paramView.append(", actionUp:");
      paramView.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      paramView.append(", isOver:");
      paramView.append(this.jdField_a_of_type_Boolean);
      paramView.append(", mTouchEnable:");
      paramView.append(this.f);
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, paramView.toString());
    }
    b();
    if (!this.f) {
      return false;
    }
    if (this.g) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    }
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.e)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener.c();
      }
      return false;
    }
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
    {
      o();
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
        paramView = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
        if (paramView != null) {
          paramView.b();
        }
        return false;
      }
      m();
      return true;
    }
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    p();
    return true;
  }
  
  public void b()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraCaptureButtonLayoutNew.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new QIMCameraCaptureButtonLayoutNew.3(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QIMCameraCaptureButtonLayoutNew.4(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(158.0F, this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void e() {}
  
  @TargetApi(11)
  protected void f()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected void g()
  {
    a(1.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void h()
  {
    g();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonProgressInterceptor == null)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      float f1 = (float)l;
      boolean bool;
      if (f1 >= this.jdField_a_of_type_Float) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = QIMCircleProgress.MAX_PROGRESS;
      } else {
        i = (int)(f1 / this.jdField_a_of_type_Float * QIMCircleProgress.MAX_PROGRESS);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)l / 1000);
      ((StringBuilder)localObject).append("秒");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setText((String)localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setProgress(i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateProgress percent:");
        localStringBuilder.append(i);
        localStringBuilder.append(", time:");
        localStringBuilder.append((String)localObject);
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
  }
  
  public void j()
  {
    IAECaptureButton.CountDownDelegate localCountDownDelegate = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewIAECaptureButton$CountDownDelegate;
    if (localCountDownDelegate != null) {
      localCountDownDelegate.a();
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    h();
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = true;
    m();
  }
  
  public void m()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "stop failed because is not start");
      }
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            return;
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
          f();
          AEBaseReportParam.a().d(System.currentTimeMillis() - a());
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    f();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      else if (i == 3)
      {
        QIMCameraCaptureButtonLayoutNew.CaptureButtonListener localCaptureButtonListener = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCaptureButtonLayoutNew$CaptureButtonListener;
        if (localCaptureButtonListener != null) {
          localCaptureButtonListener.G();
        }
      }
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
  }
  
  public void n()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "start fail because is started");
      }
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if ((i == 3) || (i == 1) || (i == 4)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int == 2) {
      m();
    }
  }
  
  public void o()
  {
    c(false);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.e == paramBoolean) {
      return;
    }
    this.e = paramBoolean;
    if (this.e)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setIsFollowCaptureTips()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin += ScreenUtil.dip2px(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
 * JD-Core Version:    0.7.0.1
 */