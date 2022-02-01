package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ApolloDiyTextFragment$AndroidBug5497Workaround
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  
  private ApolloDiyTextFragment$AndroidBug5497Workaround(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewView = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ApolloDiyTextFragment.AndroidBug5497Workaround.1(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams());
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    if (i != this.jdField_a_of_type_Int)
    {
      int j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      int k = j - i;
      if (k > j / 4) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = (j - k);
      } else {
        this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = j;
      }
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_Int = i;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    new AndroidBug5497Workaround(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment.AndroidBug5497Workaround
 * JD-Core Version:    0.7.0.1
 */