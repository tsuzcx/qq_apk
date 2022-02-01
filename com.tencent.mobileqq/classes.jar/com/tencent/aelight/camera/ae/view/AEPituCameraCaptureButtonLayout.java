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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class AEPituCameraCaptureButtonLayout
  extends AbsAECaptureButton
{
  protected float a;
  protected int a;
  protected long a;
  protected ValueAnimator a;
  protected Handler a;
  private View.OnTouchListener a;
  public View a;
  protected AECameraGLSurfaceView a;
  protected AECircleCaptureProgressView a;
  protected AEPituCameraCaptureButtonLayout.CaptureButtonProgressInterceptor a;
  protected AEPituCameraCaptureButtonLayout.PituCaptureButtonListener a;
  protected AnimationQIMCircleProgress a;
  protected IAECaptureButton.CountDownDelegate a;
  protected QIMCameraCountTimeLayout a;
  protected BubbleTextView a;
  protected Runnable a;
  protected AtomicBoolean a;
  protected boolean a;
  protected int b;
  protected ValueAnimator b;
  public View b;
  private Runnable b;
  protected AtomicBoolean b;
  protected boolean b;
  private int c;
  protected View c;
  protected boolean c;
  private int d;
  protected View d;
  protected boolean d;
  protected View e;
  protected boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h = true;
  private boolean i = true;
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AEPituCameraCaptureButtonLayout.5(this);
    this.jdField_a_of_type_AndroidOsHandler = new AEPituCameraCaptureButtonLayout.7(this, Looper.getMainLooper());
    a();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AEPituCameraCaptureButtonLayout.5(this);
    this.jdField_a_of_type_AndroidOsHandler = new AEPituCameraCaptureButtonLayout.7(this, Looper.getMainLooper());
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      a(paramView, paramMotionEvent);
      return;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(0);
      a(paramView, paramMotionEvent);
      paramMotionEvent.recycle();
    }
    this.jdField_b_of_type_JavaLangRunnable = null;
  }
  
  private boolean b()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntryManager.k(((Activity)getContext()).getIntent()));
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.jdField_b_of_type_JavaLangRunnable == null) {
            this.jdField_b_of_type_JavaLangRunnable = new AEPituCameraCaptureButtonLayout.6(this, paramView, paramMotionEvent);
          }
          ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
          return true;
        }
        if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() >= 100L) {
          a(paramView, paramMotionEvent);
        }
        return true;
      }
      boolean bool = c(paramView, paramMotionEvent);
      return bool;
    }
    finally {}
  }
  
  private boolean c()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntryManager.l(((Activity)getContext()).getIntent()));
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    a(paramView, paramMotionEvent);
    return a(paramView, paramMotionEvent);
  }
  
  private void q()
  {
    int j = this.jdField_b_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 3))
    {
      if (j != 4) {
        return;
      }
      if (!AEResUtil.a())
      {
        QQToast.a(getContext(), 1, getContext().getString(2064515266), 1).a();
        return;
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        o();
        return;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        if ((this.h) && (this.jdField_d_of_type_Boolean))
        {
          m();
          return;
        }
        n();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkStartCapture: isStarting = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(" | shortVideoShot = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(" | countDownEnable = ");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      AEQLog.a("CameraCaptureLayout", localStringBuilder.toString());
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        o();
        return;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        if ((this.h) && (this.jdField_d_of_type_Boolean))
        {
          m();
          return;
        }
        n();
      }
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
    if (!this.g)
    {
      LayoutInflater.from(getContext()).inflate(2064318679, this, true);
      this.jdField_c_of_type_Int = AIOUtils.b(53.0F, getResources());
      this.jdField_d_of_type_Int = AIOUtils.b(80.0F, getResources());
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2064122074));
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setBackgroundResource(2064056660);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setCenterView();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
    }
    else
    {
      LayoutInflater.from(getContext()).inflate(2064318471, this, true);
      this.jdField_c_of_type_Int = AIOUtils.b(98.0F, getResources());
      this.jdField_d_of_type_Int = AIOUtils.b(98.0F, getResources());
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView = ((AECircleCaptureProgressView)findViewById(2064122074));
      this.jdField_d_of_type_AndroidViewView = findViewById(2064122281);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setCenterView();
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)findViewById(2064122002));
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2064122026);
    this.jdField_b_of_type_AndroidViewView = findViewById(2064122218);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2064122219);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2064122027));
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setIsCircleStyle(this.g);
    this.jdField_e_of_type_AndroidViewView = findViewById(2064122075);
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int j = this.jdField_c_of_type_Int;
    localLayoutParams.width = ((int)(j * paramFloat));
    localLayoutParams.height = ((int)(j * paramFloat));
    localLayoutParams.addRule(13);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getLayoutParams();
      j = this.jdField_d_of_type_Int;
      localLayoutParams.width = ((int)(j * paramFloat));
      localLayoutParams.height = ((int)(j * paramFloat));
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(paramFloat);
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
    this.g = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  protected void a(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage what:");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(", shortVideoShot:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    AEQLog.b("CameraCaptureLayout", ((StringBuilder)localObject).toString());
    int j = paramMessage.what;
    if (j != 9) {
      switch (j)
      {
      default: 
        return;
      case 6: 
        i();
        break;
      case 5: 
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        j();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
        return;
      case 4: 
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener;
        if (paramMessage != null) {
          paramMessage.a();
        }
        h();
        if (c()) {
          AEBaseDataReporter.a().k();
        }
        if (!b()) {
          return;
        }
        paramMessage = new HashMap();
        paramMessage.put("ext6", String.valueOf(AEBeautyProviderView.a()));
        paramMessage.put("ext7", String.valueOf(AEBeautyProviderView.b()));
        if (AEMaterialManager.a() != null) {
          paramMessage.put("ext15", AEMaterialManager.a().k);
        }
        if (AEMaterialManager.b() != null) {
          paramMessage.put("ext16", AEMaterialManager.b().k);
        }
        localObject = (AEMaterialManager)AEQIMManager.a(1);
        if (localObject != null) {
          paramMessage.put("ext17", ((AEMaterialManager)localObject).a());
        }
        AEReportUtils.b(14, paramMessage);
        return;
      case 3: 
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener;
        if (paramMessage != null) {
          paramMessage.C();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        h();
        setVisibility(8);
        return;
      case 2: 
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(0);
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener;
        if (paramMessage == null) {
          return;
        }
        paramMessage.E();
        return;
      case 1: 
        e();
        return;
      }
    }
    paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener;
    if (paramMessage != null) {
      paramMessage.D();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView == null) {
      return;
    }
    if (!AECommonUtil.a(localBubbleTextView, paramMotionEvent)) {
      b();
    }
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)paramGLSurfaceView);
    if ((paramCaptureListener instanceof AEPituCameraCaptureButtonLayout.PituCaptureButtonListener))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener = ((AEPituCameraCaptureButtonLayout.PituCaptureButtonListener)paramCaptureListener);
      return;
    }
    throw new IllegalArgumentException("arg listener must be instance of PituCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.g)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
      if (localObject != null) {
        ((AnimationQIMCircleProgress)localObject).a(paramBoolean);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView;
      if (localObject != null) {
        ((AECircleCaptureProgressView)localObject).a(paramBoolean);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout;
    if (localObject != null)
    {
      int j;
      if (paramBoolean) {
        j = -16777216;
      } else {
        j = -1;
      }
      ((QIMCameraCountTimeLayout)localObject).setTextColor(j);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.g)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
      if (localObject != null) {
        ((AnimationQIMCircleProgress)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView;
      if (localObject != null) {
        ((AECircleCaptureProgressView)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      }
      if (this.jdField_d_of_type_AndroidViewView != null)
      {
        int j = paramAECircleCaptureStyle.e;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(j);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout;
    if ((localObject != null) && (paramBoolean))
    {
      ((QIMCameraCountTimeLayout)localObject).setTextColor(paramAECircleCaptureStyle.i);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setTextShadow(paramAECircleCaptureStyle.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setDotView(paramAECircleCaptureStyle.h);
    }
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewIAECaptureButton$CountDownDelegate = paramCountDownDelegate;
  }
  
  public boolean a()
  {
    if (!this.g) {
      return this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.getMode() != 0;
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a() != 0;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.isDevelopLevel();
    if (!this.f) {
      return false;
    }
    if ((this.i) && (paramMotionEvent.getAction() != 1)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView);
    }
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.jdField_e_of_type_Boolean) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.F();
    }
    if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)
    {
      p();
      return false;
    }
    int j = paramMotionEvent.getAction() & 0xFF;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 3) {
          return j == 5;
        }
        if (!this.g)
        {
          o();
          return true;
        }
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        return true;
      }
      o();
      return true;
    }
    b();
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    q();
    return true;
  }
  
  public void b()
  {
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView == null) {
      return;
    }
    localBubbleTextView.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (paramBoolean)
    {
      int j = this.jdField_c_of_type_AndroidViewView.getHeight();
      if (j != 0)
      {
        j = j / 2 - ViewUtils.a(86.0F);
        if (!this.g) {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setTranslationY(j);
        } else {
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setTranslationY(j);
        }
        this.jdField_b_of_type_AndroidViewView.setTranslationY(j);
        return;
      }
      if (!this.g) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setTranslationY(ViewUtils.a(17.0F));
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setTranslationY(ViewUtils.a(17.0F));
      }
      this.jdField_b_of_type_AndroidViewView.setTranslationY(ViewUtils.a(17.0F));
      return;
    }
    if (!this.g)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setTranslationY(ViewUtils.a(17.0F));
      this.jdField_b_of_type_AndroidViewView.setTranslationY(ViewUtils.a(17.0F));
    }
  }
  
  public void c()
  {
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView == null) {
      return;
    }
    if (localBubbleTextView.getVisibility() != 0)
    {
      if (AECameraPrefsUtil.a().a("sp_key_ae_photo_photo_video_take_tips", false, 0)) {
        return;
      }
      AECameraPrefsUtil.a().a("sp_key_ae_photo_photo_video_take_tips", true, 0);
      int j = UIUtils.a(getContext(), 8.0F);
      int k = UIUtils.a(getContext(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(j, k, j, k);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.a(getContext(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getContext().getString(2064515098));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
      this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraCaptureButtonLayout.1(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(158.0F, this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  protected void e()
  {
    if (!this.g) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    } else {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1735F });
    }
    if (!this.g) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    } else {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AEPituCameraCaptureButtonLayout.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new AEPituCameraCaptureButtonLayout.3(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    if (!this.g) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(1);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(1);
    }
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    }
    else
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.6F });
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setStrokeWidth(5.0F);
    }
    if (!this.g) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    } else {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AEPituCameraCaptureButtonLayout.4(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected void f() {}
  
  @TargetApi(11)
  protected void g()
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
  
  protected void h()
  {
    a(1.0F);
    if (!this.g)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setCenterScaleValue(1.0F);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void i()
  {
    h();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$CaptureButtonProgressInterceptor == null)
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
      int j;
      if (this.jdField_a_of_type_Boolean) {
        j = QIMCircleProgress.MAX_PROGRESS;
      } else {
        j = (int)(f1 / this.jdField_a_of_type_Float * QIMCircleProgress.MAX_PROGRESS);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)l / 1000);
      ((StringBuilder)localObject).append("秒");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraCountTimeLayout.setText((String)localObject);
      if (!this.g) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setProgress(j);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setProgress(j);
      }
      QLog.isDevelopLevel();
    }
    if (this.jdField_a_of_type_Boolean) {
      o();
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    c();
    i();
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = true;
    o();
  }
  
  public void m()
  {
    IAECaptureButton.CountDownDelegate localCountDownDelegate = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewIAECaptureButton$CountDownDelegate;
    if (localCountDownDelegate != null) {
      localCountDownDelegate.a();
    }
  }
  
  public void n()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    AEQLog.a("CameraCaptureLayout", "startCapture: 开始拍摄");
    if (this.jdField_c_of_type_Boolean)
    {
      AEQLog.b("CameraCaptureLayout", "start fail because is started");
      return;
    }
    int j = this.jdField_b_of_type_Int;
    if ((j == 3) || (j == 1) || (j == 4)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_b_of_type_Int == 2) {
      o();
    }
  }
  
  public void o()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopCapture: 结束拍摄 | shortVideoShot = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    ((StringBuilder)localObject).append(" | mActionUpAnimator = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    AEQLog.a("CameraCaptureLayout", ((StringBuilder)localObject).toString());
    if (!this.jdField_c_of_type_Boolean)
    {
      AEQLog.b("CameraCaptureLayout", "stop failed because is not start");
      return;
    }
    int j = this.jdField_b_of_type_Int;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            return;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            AEQLog.a("CameraCaptureLayout", "in stop capture 1");
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
            g();
            AEBaseReportParam.a().d(System.currentTimeMillis() - a());
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            this.jdField_c_of_type_Boolean = false;
            if (!this.g)
            {
              this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
              return;
            }
            this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(0);
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("in stop capture 2 ");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
          AEQLog.a("CameraCaptureLayout", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        this.jdField_c_of_type_Boolean = false;
        if (!this.g)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(0);
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    g();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      j = this.jdField_b_of_type_Int;
      if (j == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      else if (j == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener;
        if (localObject != null) {
          ((AEPituCameraCaptureButtonLayout.PituCaptureButtonListener)localObject).G();
        }
      }
    }
    this.jdField_c_of_type_Boolean = false;
    if (!this.g)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.changeMode(0);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.a(0);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView != null)
    {
      localBubbleTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      b();
    }
  }
  
  public void p()
  {
    c(false);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.g)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    if (paramInt != -1) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float / 1000.0F));
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */