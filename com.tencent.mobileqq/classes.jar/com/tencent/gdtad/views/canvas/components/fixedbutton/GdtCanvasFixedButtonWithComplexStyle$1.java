package com.tencent.gdtad.views.canvas.components.fixedbutton;

import android.widget.TextView;

class GdtCanvasFixedButtonWithComplexStyle$1
  implements Runnable
{
  GdtCanvasFixedButtonWithComplexStyle$1(GdtCanvasFixedButtonWithComplexStyle paramGdtCanvasFixedButtonWithComplexStyle, TextView paramTextView1, TextView paramTextView2, float paramFloat) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    int j = this.b.getMeasuredWidth();
    if (this.jdField_a_of_type_Float > i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setWidth((int)this.jdField_a_of_type_Float);
      this.b.setWidth((int)(j - (this.jdField_a_of_type_Float - i)));
      this.b.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonWithComplexStyle.1
 * JD-Core Version:    0.7.0.1
 */