package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;

public class WSParentViewPager
  extends ViewPagerCompat
{
  private boolean a = true;
  
  public WSParentViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSParentViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.a) {
      return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
    }
    if ((paramView != this) && ((paramView instanceof ViewPager)))
    {
      paramInt2 = ((ViewPager)paramView).getCurrentItem();
      return ((paramInt2 != ((ViewPager)paramView).getAdapter().getCount() - 1) || (paramInt1 >= 0)) && ((paramInt2 != 0) || (paramInt1 <= 0));
    }
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public void setChildCanScroll(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSParentViewPager
 * JD-Core Version:    0.7.0.1
 */