package com.tencent.biz;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import mwm;

public class PoiMapActivity$4$1
  implements Runnable
{
  public PoiMapActivity$4$1(mwm parammwm) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.b = false;
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.4.1
 * JD-Core Version:    0.7.0.1
 */