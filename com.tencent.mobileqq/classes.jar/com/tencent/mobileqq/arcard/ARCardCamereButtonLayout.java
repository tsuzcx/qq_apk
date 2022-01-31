package com.tencent.mobileqq.arcard;

import aalq;
import aalr;
import aals;
import aalt;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ARCardCamereButtonLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 10000.0F;
  private int jdField_a_of_type_Int = AIOUtils.a(45.0F, getResources());
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new aalt(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aals(this);
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARCardCamereButtonLayout.CaptureButtonListener jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonListener;
  private ARCardCamereButtonLayout.CaptureButtonListenerInterceptor jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonListenerInterceptor;
  private ARCardCamereButtonLayout.CaptureButtonProgressInterceptor jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonProgressInterceptor;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = AIOUtils.a(70.0F, getResources());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public AtomicBoolean b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  
  public ARCardCamereButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    e();
  }
  
  public ARCardCamereButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    e();
  }
  
  private void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2130970198, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369000);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369521));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("按住录制AR祝福");
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131369008));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369007));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369522));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492969), 100, getResources().getColor(2131493307));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(4.5F);
  }
  
  @TargetApi(11)
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetImageView, 0.1F, 1.0F, 0.1F, 1.2F, 400, null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aalq(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aalr(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void g()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      Animation localAnimation = this.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  private void h()
  {
    a(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("按住录制AR祝福");
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonProgressInterceptor;
    if (localObject != null)
    {
      this.jdField_a_of_type_Boolean = ((ARCardCamereButtonLayout.CaptureButtonProgressInterceptor)localObject).a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, this.jdField_a_of_type_Long, this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    boolean bool;
    if ((float)l >= this.jdField_a_of_type_Float)
    {
      bool = true;
      label72:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label186;
      }
    }
    label186:
    for (int i = 100;; i = (int)((float)l / this.jdField_a_of_type_Float * 100.0F))
    {
      localObject = (int)l / 1000 + "秒";
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ARCardCamereButtonLayout", 2, "updateProgress percent:" + i + ", time:" + (String)localObject);
      break;
      bool = false;
      break label72;
    }
  }
  
  private void j()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      g();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        continue;
        if (this.jdField_c_of_type_Int == 2) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(ARCardCamereButtonLayout.CaptureButtonListener paramCaptureButtonListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonListener = paramCaptureButtonListener;
  }
  
  public void b()
  {
    h();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    b();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
    j();
  }
  
  public void setButtonListenerInterceptor(ARCardCamereButtonLayout.CaptureButtonListenerInterceptor paramCaptureButtonListenerInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonListenerInterceptor = paramCaptureButtonListenerInterceptor;
  }
  
  public void setCaptureButtonProgressInterceptor(ARCardCamereButtonLayout.CaptureButtonProgressInterceptor paramCaptureButtonProgressInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout$CaptureButtonProgressInterceptor = paramCaptureButtonProgressInterceptor;
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardCamereButtonLayout
 * JD-Core Version:    0.7.0.1
 */