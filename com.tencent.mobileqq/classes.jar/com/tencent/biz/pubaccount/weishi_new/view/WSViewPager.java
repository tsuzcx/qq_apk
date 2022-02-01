package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ViewPagerCompat;

public class WSViewPager
  extends ViewPagerCompat
{
  private boolean a = true;
  
  public WSViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.a) {
      return super.canScrollHorizontally(paramInt);
    }
    return false;
  }
  
  public void setCanScrollHorizontally(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSViewPager
 * JD-Core Version:    0.7.0.1
 */