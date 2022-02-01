package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class GdtMvViewAnimationAbs$2
  implements Runnable
{
  GdtMvViewAnimationAbs$2(GdtMvViewAnimationAbs paramGdtMvViewAnimationAbs, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    ((RelativeLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_Int + (int)(this.b * 1.0F));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = (this.c + (int)(this.d * 1.0F));
    int i = this.e;
    if (i == -1)
    {
      i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    }
    else
    {
      int j = this.f;
      i = (int)(i * 1.0F) + j;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    }
    GdtMvViewAnimationAbs.b(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvViewAnimationAbs.2
 * JD-Core Version:    0.7.0.1
 */