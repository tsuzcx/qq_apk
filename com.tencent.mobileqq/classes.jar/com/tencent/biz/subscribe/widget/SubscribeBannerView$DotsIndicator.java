package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class SubscribeBannerView$DotsIndicator
  extends LinearLayout
{
  public int a = 2130839195;
  public int b;
  public int c;
  public int d;
  
  public SubscribeBannerView$DotsIndicator(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.b = AIOUtils.b(10.0F, getResources());
    this.c = AIOUtils.b(7.0F, getResources());
    this.d = AIOUtils.b(7.0F, getResources());
    setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 1)
    {
      int i = 0;
      while (i < paramInt)
      {
        View localView = new View(getContext());
        localView.setBackgroundResource(this.a);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.d);
        localLayoutParams.setMargins(this.b, 0, 0, 0);
        localView.setLayoutParams(localLayoutParams);
        addView(localView);
        i += 1;
      }
    }
  }
  
  public void setDotsSelected(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= getChildCount()) {
        return;
      }
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (i == paramInt) {
          localView.setSelected(true);
        } else {
          localView.setSelected(false);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView.DotsIndicator
 * JD-Core Version:    0.7.0.1
 */