package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ARVideoRecordViewProxy
  implements ARVideoRecordViewPresenter
{
  private volatile int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARVideoRecordButtonView jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView;
  private ARVideoRecordViewPresenter.onMonitorUserOperationListener jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter$onMonitorUserOperationListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ARVideoRecordViewProxy.1(this);
  private final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700983);
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 5000;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = "0.00M";
  private View c;
  
  public ARVideoRecordViewProxy(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView = ((ARVideoRecordButtonView)paramView.findViewById(2131370545));
    this.c = paramView.findViewById(2131364295);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362899);
    this.jdField_a_of_type_Boolean = ARRecordUtils.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.c.setOnClickListener(null);
    this.c.setOnTouchListener(new ARVideoRecordViewProxy.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362901));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362900));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "init self");
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    paramInt1 /= 2;
    long l = paramInt1;
    localTranslateAnimation1.setDuration(l);
    int i = paramInt1 + 0;
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation2.setDuration(l);
    localTranslateAnimation2.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation2.setStartOffset(i);
    i += paramInt1;
    paramInt2 = paramInt2 * 2 / 3;
    TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation3.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation3.setDuration(l);
    localTranslateAnimation3.setStartOffset(i);
    TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation4.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation4.setDuration(l);
    localTranslateAnimation4.setStartOffset(i + paramInt1);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    localAnimationSet.addAnimation(localTranslateAnimation3);
    localAnimationSet.addAnimation(localTranslateAnimation4);
    if (paramView != null) {
      paramView.startAnimation(localAnimationSet);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "resetToInnerTipsStatus");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setShowState(2);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("0.00M");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_b_of_type_AndroidViewView, 600, -40);
    ARRecordUtils.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus start animation");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "show");
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      c();
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.3(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchUIdisplayMode");
      localStringBuilder.append(paramInt);
      QLog.i("ARVideoRecordViewProxy", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode mCurrentUIDisplayMode equal");
      }
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.6(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setProgress(paramInt1, 60000L);
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.5(this, paramInt1, paramInt2));
  }
  
  public void a(ARVideoRecordViewPresenter.onMonitorUserOperationListener paramonMonitorUserOperationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter$onMonitorUserOperationListener = paramonMonitorUserOperationListener;
  }
  
  public boolean a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "hide");
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } else {
      ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.4(this));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy
 * JD-Core Version:    0.7.0.1
 */