package com.tencent.biz.subscribe.widget;

import aciy;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class SubscribeBannerView$DotsIndicator
  extends LinearLayout
{
  public int a = 2130838710;
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
    this.b = aciy.a(10.0F, getResources());
    this.c = aciy.a(7.0F, getResources());
    this.d = aciy.a(7.0F, getResources());
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
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      return;
    }
    int i = 0;
    label15:
    View localView;
    if (i < getChildCount())
    {
      localView = getChildAt(i);
      if (i != paramInt) {
        break label46;
      }
      localView.setSelected(true);
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label46:
      localView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView.DotsIndicator
 * JD-Core Version:    0.7.0.1
 */