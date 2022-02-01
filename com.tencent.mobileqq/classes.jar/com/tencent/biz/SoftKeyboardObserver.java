package com.tencent.biz;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class SoftKeyboardObserver
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private SoftKeyboardObserver.OnSoftKeyboardToggledListener jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener)
  {
    this(paramView, paramOnSoftKeyboardToggledListener, UIUtils.a(paramView.getContext(), 160.0F));
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
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("SoftKeyboardObserver", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onGlobalLayout()
  {
    boolean bool = true;
    Rect localRect = new Rect();
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
        int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
        int j = localRect.bottom;
        int k = localRect.top;
        if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener != null)
        {
          if (i - (j - k) < this.jdField_a_of_type_Int) {
            break label113;
          }
          if (bool != this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver$OnSoftKeyboardToggledListener.a(bool, localRect.right, localRect.bottom);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("SoftKeyboardObserver", 1, "getWindowVisibleDisplayFrame error", localNullPointerException);
        return;
      }
      label113:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.SoftKeyboardObserver
 * JD-Core Version:    0.7.0.1
 */