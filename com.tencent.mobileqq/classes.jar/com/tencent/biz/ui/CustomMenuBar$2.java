package com.tencent.biz.ui;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class CustomMenuBar$2
  implements View.OnTouchListener
{
  CustomMenuBar$2(CustomMenuBar paramCustomMenuBar, ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843480);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.2
 * JD-Core Version:    0.7.0.1
 */