package com.tencent.gdtad.api.motivevideo;

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
  protected Context a;
  protected Handler a;
  protected GdtMvAniDataAbs a;
  
  protected GdtMvViewAnimationAbs(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void a(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(8);
  }
  
  private void a(GdtMvAniDataAbs paramGdtMvAniDataAbs)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtMvAniDataAbs.h.getLayoutParams();
    localLayoutParams.height = paramGdtMvAniDataAbs.n;
    localLayoutParams.width = paramGdtMvAniDataAbs.o;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramGdtMvAniDataAbs.h.setLayoutParams(localLayoutParams);
    paramGdtMvAniDataAbs.h.postInvalidate();
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
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs.g == null)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs.g);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.2(this, localLayoutParams, i, paramInt1, j, paramInt2, paramInt3, k, paramView), 200L);
  }
  
  protected void a(GdtMvAniDataAbs paramGdtMvAniDataAbs, View paramView)
  {
    paramGdtMvAniDataAbs.h = paramView;
    paramGdtMvAniDataAbs.o = GdtUIUtils.a(470, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    paramGdtMvAniDataAbs.n = GdtUIUtils.a(470, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs
 * JD-Core Version:    0.7.0.1
 */