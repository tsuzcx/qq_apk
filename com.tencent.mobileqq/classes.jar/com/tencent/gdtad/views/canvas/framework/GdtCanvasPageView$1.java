package com.tencent.gdtad.views.canvas.framework;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class GdtCanvasPageView$1
  implements Runnable
{
  GdtCanvasPageView$1(GdtCanvasPageView paramGdtCanvasPageView, View paramView, FrameLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(new GdtCanvasPageView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView.1
 * JD-Core Version:    0.7.0.1
 */