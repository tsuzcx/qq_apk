package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCircleAvatarListView$SingleIconHolder
{
  private FrameLayout a;
  private RoundCornerImageView b;
  private RoundCornerImageView c;
  
  public QCircleAvatarListView$SingleIconHolder(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this.a = new FrameLayout(paramContext);
    int i = paramInt3 * 2;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(paramInt1 + i, i + paramInt2);
    this.a.setLayoutParams(localLayoutParams);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    a(paramContext, paramInt1, paramInt2, paramInt4);
    this.a.setVisibility(8);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = new RoundCornerImageView(paramContext);
    paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2, 17);
    this.c.setLayoutParams(paramContext);
    this.c.setCorner(paramInt3);
    this.a.addView(this.c);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this.b = new RoundCornerImageView(paramContext);
    paramInt3 *= 2;
    paramContext = new FrameLayout.LayoutParams(paramInt1 + paramInt3, paramInt2 + paramInt3, 17);
    this.b.setLayoutParams(paramContext);
    if (paramBoolean)
    {
      this.b.setCorner(paramInt4);
      this.b.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(paramInt5));
    }
    else
    {
      this.b.setColorFilter(QCircleSkinHelper.getInstance().getColor(2131167059));
    }
    this.a.addView(this.b);
  }
  
  public FrameLayout a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarListView.SingleIconHolder
 * JD-Core Version:    0.7.0.1
 */