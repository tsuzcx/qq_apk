package com.dataline.activities;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.XEditTextEx;

class LiteActivity$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  LiteActivity$10(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (!LiteActivity.a(this.a)) && (!SimpleUIUtil.a()))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.10
 * JD-Core Version:    0.7.0.1
 */