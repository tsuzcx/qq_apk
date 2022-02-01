package com.tencent.gdtad.api.motivevideo;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class GdtMvViewAnimationAbs$2
  implements Runnable
{
  GdtMvViewAnimationAbs$2(GdtMvViewAnimationAbs paramGdtMvViewAnimationAbs, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (this.jdField_a_of_type_Int + (int)(this.b * 1.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.c + (int)(this.d * 1.0F));
    RelativeLayout.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    if (this.e == -1) {}
    for (int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin;; i = this.f + (int)(this.e * 1.0F))
    {
      localLayoutParams.rightMargin = i;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
      GdtMvViewAnimationAbs.b(this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2
 * JD-Core Version:    0.7.0.1
 */