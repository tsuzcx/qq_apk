package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import avsq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import vwt;
import wbe;
import wbf;
import wbg;

public class QCircleProgressLoadingView
  extends QCircleBaseWidgetView
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  
  public QCircleProgressLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(BaseApplicationImpl.getContext().getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public int a()
  {
    return 0;
  }
  
  public AnimatorSet a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return localObject;
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, vwt.a() });
    ((ValueAnimator)localObject).setDuration(800L);
    avsq localavsq = new avsq(0.0F, 0.0F, 0.25F, 1.0F);
    ((ValueAnimator)localObject).setInterpolator(localavsq);
    ((ValueAnimator)localObject).addUpdateListener(new wbg(this));
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 0, 255 });
    localValueAnimator1.setDuration(600L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator2.setDuration(200L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    wbf localwbf = new wbf(this);
    localValueAnimator1.addUpdateListener(localwbf);
    localValueAnimator2.addUpdateListener(localwbf);
    localAnimatorSet.setInterpolator(localavsq);
    localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject, localAnimatorSet });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setStartDelay(200L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new wbe(null));
    return this.jdField_a_of_type_AndroidAnimationAnimatorSet;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    return null;
  }
  
  protected String a()
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView) {}
  
  public void a(Object paramObject) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  public void setLoadingView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView
 * JD-Core Version:    0.7.0.1
 */