package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CommonHbFragment$FixedSpeedScroller
  extends Scroller
{
  private int jdField_a_of_type_Int = 300;
  
  public CommonHbFragment$FixedSpeedScroller(CommonHbFragment paramCommonHbFragment, Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment.FixedSpeedScroller
 * JD-Core Version:    0.7.0.1
 */