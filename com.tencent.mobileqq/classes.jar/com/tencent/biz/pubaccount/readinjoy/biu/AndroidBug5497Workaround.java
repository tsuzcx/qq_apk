package com.tencent.biz.pubaccount.readinjoy.biu;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

public class AndroidBug5497Workaround
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    int j;
    int k;
    if (i != this.jdField_a_of_type_Int)
    {
      j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      k = j - i;
      if (k <= j / 4) {
        break label58;
      }
    }
    label58:
    for (this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = (j - k);; this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = j)
    {
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.AndroidBug5497Workaround
 * JD-Core Version:    0.7.0.1
 */