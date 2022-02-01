package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;

class b$c
  extends b.a
{
  private b$c(b paramb) {}
  
  public void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    if (paramImageView != null)
    {
      paramImageView.setImageResource(2130838652);
      paramImageView.setColorFilter(this.a.h, PorterDuff.Mode.SRC_ATOP);
      paramView2 = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
      paramView2.width = this.a.getContext().getResources().getDimensionPixelSize(2131296749);
      paramView2.height = this.a.getContext().getResources().getDimensionPixelSize(2131296748);
      paramView2.leftMargin = this.a.getContext().getResources().getDimensionPixelSize(b());
      paramView2.rightMargin = this.a.getContext().getResources().getDimensionPixelSize(2131296759);
      paramImageView.setLayoutParams(paramView2);
    }
    if (paramView1 != null)
    {
      paramImageView = (ViewGroup.MarginLayoutParams)paramView1.getLayoutParams();
      paramImageView.leftMargin = 0;
      paramImageView.rightMargin = 0;
      paramView1.setLayoutParams(paramImageView);
    }
  }
  
  public int b()
  {
    return 2131296757;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.c
 * JD-Core Version:    0.7.0.1
 */