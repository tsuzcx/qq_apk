package com.tencent.gdtad.basics.motivevideo.elements;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.GdtUIUtils;

final class GdtMvAnimation585HNew
{
  private Context a;
  
  protected GdtMvAnimation585HNew(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(View paramView1, ViewGroup paramViewGroup, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
  {
    paramView1.setVisibility(8);
    paramView1 = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramView1.height = GdtUIUtils.b(750, 750, GdtUIUtils.d(this.a));
    paramView1.width = GdtUIUtils.b(1334, 1334, GdtUIUtils.d(this.a));
    paramView1 = (RelativeLayout.LayoutParams)paramView3.getLayoutParams();
    paramView1.width = GdtUIUtils.b(172, 750, GdtUIUtils.e(this.a));
    paramView1.height = paramView1.width;
    paramView1.topMargin = 0;
    ((RelativeLayout.LayoutParams)paramView4.getLayoutParams()).topMargin = GdtUIUtils.b(14, 750, GdtUIUtils.e(this.a));
    paramView1 = (RelativeLayout.LayoutParams)paramView5.getLayoutParams();
    paramView1.topMargin = GdtUIUtils.b(18, 750, GdtUIUtils.e(this.a));
    paramView1.leftMargin = GdtUIUtils.b(392, 1334, GdtUIUtils.d(this.a));
    paramView1.rightMargin = GdtUIUtils.b(392, 1334, GdtUIUtils.d(this.a));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    paramView1.height = GdtUIUtils.b(80, 1334, GdtUIUtils.d(this.a));
    paramView1.width = GdtUIUtils.b(440, 1334, GdtUIUtils.d(this.a));
    paramView1.topMargin = GdtUIUtils.b(76, 750, GdtUIUtils.e(this.a));
    paramView1 = (RelativeLayout.LayoutParams)paramView6.getLayoutParams();
    paramView1.width = -2;
    paramView1.height = -2;
    paramViewGroup.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation585HNew
 * JD-Core Version:    0.7.0.1
 */