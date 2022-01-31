package com.tencent.biz;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class SoftKeyboardObserver
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private SoftKeyboardObserver.OnSoftKeyboardToggledListener jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener;
  private boolean jdField_a_of_type_Boolean;
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener)
  {
    this(paramView, paramOnSoftKeyboardToggledListener, 100);
  }
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener = paramOnSoftKeyboardToggledListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener = null;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
    int j = localRect.bottom;
    int k = localRect.top;
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener != null) {
      if (i - (j - k) < this.jdField_a_of_type_Int) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener.a(bool, localRect.right, localRect.bottom);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.SoftKeyboardObserver
 * JD-Core Version:    0.7.0.1
 */