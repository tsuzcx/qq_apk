package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.animation.interpolator.BezierInterpolator;

public class QCircleProgressLoadingView
  extends QCircleBaseWidgetView
{
  private AnimatorSet a;
  private ValueAnimator b;
  private ValueAnimator c;
  private ValueAnimator d;
  private AnimatorSet e;
  private View f;
  private QCircleProgressLoadingView.CycleAnimationListener g;
  private boolean h = false;
  private int i = 16;
  private Runnable j = new QCircleProgressLoadingView.1(this);
  
  public QCircleProgressLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    View localView = this.f;
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.a = getLoadingAnimation();
    if (!this.h)
    {
      getMainHandler().removeCallbacks(this.j);
      getMainHandler().postDelayed(this.j, 300L);
      this.h = true;
    }
  }
  
  public void b()
  {
    this.h = false;
    if (this.j != null) {
      getMainHandler().removeCallbacks(this.j);
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      ((View)localObject).getLayoutParams().width = 0;
      localObject = this.f;
      ((View)localObject).setLayoutParams(((View)localObject).getLayoutParams());
      this.f.setVisibility(8);
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.b.cancel();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.c.cancel();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.d.cancel();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).removeAllListeners();
      this.e.cancel();
      this.e = null;
    }
    localObject = this.a;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning()))
    {
      this.a.removeAllListeners();
      this.a.cancel();
      this.a = null;
      this.g = null;
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public AnimatorSet getLoadingAnimation()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    if (this.f == null) {
      return null;
    }
    int k;
    if (this.i == 16) {
      k = DisplayUtil.d();
    } else {
      k = DisplayUtil.e();
    }
    this.d = ValueAnimator.ofInt(new int[] { 0, k / 2 });
    this.d.setDuration(800L);
    localObject = new BezierInterpolator(0.0F, 0.0F, 0.25F, 1.0F);
    this.d.setInterpolator((TimeInterpolator)localObject);
    this.d.addUpdateListener(new QCircleProgressLoadingView.ScaleXAnimationListener(this, this.i));
    this.b = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.b.setDuration(600L);
    this.c = ValueAnimator.ofInt(new int[] { 255, 0 });
    this.c.setDuration(200L);
    this.e = new AnimatorSet();
    QCircleProgressLoadingView.OpacityAnimationListener localOpacityAnimationListener = new QCircleProgressLoadingView.OpacityAnimationListener(this);
    this.c.addUpdateListener(localOpacityAnimationListener);
    this.e.setInterpolator((TimeInterpolator)localObject);
    this.e.playSequentially(new Animator[] { this.b, this.c });
    this.a = new AnimatorSet();
    this.a.playTogether(new Animator[] { this.d, this.e });
    this.a.setStartDelay(200L);
    this.g = new QCircleProgressLoadingView.CycleAnimationListener(null);
    return this.a;
  }
  
  public View getLoadingView()
  {
    View localView = this.f;
    if (localView != null) {
      return localView;
    }
    return null;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    b();
    super.onDetachedFromWindow();
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void setLoadingView(View paramView)
  {
    this.f = paramView;
  }
  
  public void setReportBean(Object paramObject) {}
  
  public void setScreenOrientation(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView
 * JD-Core Version:    0.7.0.1
 */