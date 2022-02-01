package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BannerView$DotsIndicator
  extends LinearLayout
{
  public int a;
  private Context a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public BannerView$DotsIndicator(Context paramContext)
  {
    this(paramContext, 0, 81);
  }
  
  public BannerView$DotsIndicator(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    a(paramContext, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.f = paramInt1;
    this.b = AIOUtils.a(6.0F, getResources());
    this.c = AIOUtils.a(10.0F, getResources());
    this.d = AIOUtils.a(7.0F, getResources());
    this.e = AIOUtils.a(7.0F, getResources());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = this.b;
    paramContext.gravity = paramInt2;
    setLayoutParams(paramContext);
  }
  
  public void a()
  {
    if (this.f > 1)
    {
      int i = 0;
      while (i < this.f)
      {
        View localView = new View(this.jdField_a_of_type_AndroidContentContext);
        localView.setBackgroundResource(this.jdField_a_of_type_Int);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.d, this.e);
        localLayoutParams.setMargins(this.c, 0, 0, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerView.DotsIndicator
 * JD-Core Version:    0.7.0.1
 */