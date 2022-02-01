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
  private volatile int a = 0;
  private View b;
  private ARVideoRecordButtonView c;
  private TextView d;
  private TextView e;
  private View f;
  private View g;
  private ARVideoRecordViewPresenter.onMonitorUserOperationListener h;
  private final String i = HardCodeUtil.a(2131899005);
  private final String j = "0.00M";
  private boolean k = false;
  private final int l = 5000;
  private Handler m;
  private Runnable n = new ARVideoRecordViewProxy.1(this);
  
  public ARVideoRecordViewProxy(View paramView)
  {
    this.b = paramView;
    this.b.setVisibility(8);
    this.c = ((ARVideoRecordButtonView)paramView.findViewById(2131437818));
    this.g = paramView.findViewById(2131430315);
    this.f = paramView.findViewById(2131428697);
    this.k = ARRecordUtils.a();
    if (this.k) {
      this.f.setVisibility(8);
    }
    this.g.setOnClickListener(null);
    this.g.setOnTouchListener(new ARVideoRecordViewProxy.2(this));
    this.d = ((TextView)paramView.findViewById(2131428699));
    this.e = ((TextView)paramView.findViewById(2131428698));
    this.m = new Handler();
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "init self");
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    paramInt1 /= 2;
    long l1 = paramInt1;
    localTranslateAnimation1.setDuration(l1);
    int i1 = paramInt1 + 0;
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation2.setDuration(l1);
    localTranslateAnimation2.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation2.setStartOffset(i1);
    i1 += paramInt1;
    paramInt2 = paramInt2 * 2 / 3;
    TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation3.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation3.setDuration(l1);
    localTranslateAnimation3.setStartOffset(i1);
    TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation4.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation4.setDuration(l1);
    localTranslateAnimation4.setStartOffset(i1 + paramInt1);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    localAnimationSet.addAnimation(localTranslateAnimation3);
    localAnimationSet.addAnimation(localTranslateAnimation4);
    if (paramView != null) {
      paramView.startAnimation(localAnimationSet);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "resetToInnerTipsStatus");
    }
    this.c.setShowState(2);
    this.c.setVisibility(0);
    this.d.setText(this.i);
    this.e.setText("0.00M");
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.a = 0;
    if (this.k)
    {
      this.f.setVisibility(8);
      this.f.clearAnimation();
      return;
    }
    this.f.setVisibility(0);
    a(this.f, 600, -40);
    ARRecordUtils.a(true);
    this.k = true;
    this.m.postDelayed(this.n, 5000L);
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus start animation");
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "show");
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.b.setVisibility(0);
      e();
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
    if (this.a == paramInt)
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
    if (this.a == 1) {
      this.c.setProgress(paramInt1, 60000L);
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.5(this, paramInt1, paramInt2));
  }
  
  public void a(ARVideoRecordViewPresenter.onMonitorUserOperationListener paramonMonitorUserOperationListener)
  {
    this.h = paramonMonitorUserOperationListener;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "hide");
    }
    if (this.b == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.b.setVisibility(8);
    } else {
      ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.4(this));
    }
    this.m.removeCallbacks(this.n);
  }
  
  public int c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    View localView = this.b;
    return (localView != null) && (localView.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy
 * JD-Core Version:    0.7.0.1
 */