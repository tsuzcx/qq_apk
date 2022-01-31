package com.tencent.mobileqq.activity.aio.helper;

import adhy;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class FullScreenInputHelper$1
  implements Runnable
{
  public FullScreenInputHelper$1(adhy paramadhy) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getLineCount() > 3)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.1
 * JD-Core Version:    0.7.0.1
 */