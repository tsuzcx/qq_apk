package com.tencent.gdtad.basics.motivevideo.elements;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvViewAnimationAbs
  implements GdtMvViewAnimation
{
  protected GdtMvAniDataAbs a;
  protected Context b;
  protected Handler c;
  
  protected GdtMvViewAnimationAbs(Context paramContext)
  {
    this.b = paramContext;
    this.c = new Handler(Looper.getMainLooper());
  }
  
  public static void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getVisibility() != 0) {
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      paramView.startAnimation(localAlphaAnimation);
      paramView.setVisibility(8);
    }
  }
  
  private void a(GdtMvAniDataAbs paramGdtMvAniDataAbs)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtMvAniDataAbs.y.getLayoutParams();
    localLayoutParams.height = paramGdtMvAniDataAbs.w;
    localLayoutParams.width = paramGdtMvAniDataAbs.x;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramGdtMvAniDataAbs.y.setLayoutParams(localLayoutParams);
    paramGdtMvAniDataAbs.y.postInvalidate();
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(0);
  }
  
  public void a()
  {
    GdtMvAniDataAbs localGdtMvAniDataAbs = this.a;
    if (localGdtMvAniDataAbs != null)
    {
      if (localGdtMvAniDataAbs.r == null) {
        return;
      }
      a(this.a.r);
      this.c.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    a(paramView);
    this.c.postDelayed(new GdtMvViewAnimationAbs.2(this, localLayoutParams, i, paramInt1, j, paramInt2, paramInt3, k, paramView), 200L);
  }
  
  protected void a(GdtMvAniDataAbs paramGdtMvAniDataAbs, View paramView)
  {
    paramGdtMvAniDataAbs.y = paramView;
    paramGdtMvAniDataAbs.x = GdtUIUtils.b(470, 750, GdtUIUtils.e(this.b));
    paramGdtMvAniDataAbs.w = GdtUIUtils.b(470, 1334, GdtUIUtils.d(this.b));
  }
  
  public void b()
  {
    this.c.removeCallbacksAndMessages(null);
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvViewAnimationAbs
 * JD-Core Version:    0.7.0.1
 */