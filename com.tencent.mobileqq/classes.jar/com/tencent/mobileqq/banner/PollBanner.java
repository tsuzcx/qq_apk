package com.tencent.mobileqq.banner;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PollBanner
  implements Animation.AnimationListener
{
  public Handler a;
  private List<Banner> b;
  private BannerFrameLayout c;
  private Animation d;
  private Animation e;
  private int f;
  
  public void a()
  {
    int i = this.b.size();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAnim mBannerList = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", size = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("PollBanner", 2, ((StringBuilder)localObject).toString());
    }
    if (i <= 1) {
      return;
    }
    Object localObject = (Banner)this.b.get(this.f % i);
    Banner localBanner = (Banner)this.b.get((this.f + 1) % i);
    if (this.c.indexOfChild(((Banner)localObject).c) == -1)
    {
      this.c.addView(((Banner)localObject).c);
      ((Banner)localObject).c.setVisibility(0);
    }
    if (this.c.indexOfChild(localBanner.c) == -1)
    {
      this.c.addView(localBanner.c);
      localBanner.c.setVisibility(8);
    }
    ((Banner)localObject).c.startAnimation(this.e);
    localBanner.c.startAnimation(this.d);
    int j = this.f + 1;
    this.f = j;
    this.f = (j % i);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationEnd");
    }
    this.c.setAnimEnd(true);
    int i = this.b.size();
    if (i > 2)
    {
      paramAnimation = ((Banner)this.b.get((this.f + 1) % i)).c;
      int j = this.f;
      if (j == 0) {
        this.c.removeViewAt(i - 1);
      } else {
        this.c.removeViewAt(j - 1);
      }
      this.c.addView(paramAnimation);
      paramAnimation.setVisibility(8);
      ((Banner)this.b.get(this.f)).c.setVisibility(0);
    }
    else if (i > 0)
    {
      paramAnimation = ((Banner)this.b.get((this.f + 1) % i)).c;
      ((Banner)this.b.get(this.f)).c.setVisibility(0);
      paramAnimation.setVisibility(8);
    }
    if (i > 0) {
      this.a.sendEmptyMessageDelayed(1, 3000L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationStart");
    }
    this.c.setAnimEnd(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.PollBanner
 * JD-Core Version:    0.7.0.1
 */