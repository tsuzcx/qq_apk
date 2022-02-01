package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class BaseChatItemLayout$1
  implements Runnable
{
  BaseChatItemLayout$1(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout.LayoutParams paramLayoutParams, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(15, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (this.this$0.b.getTop() + (this.this$0.b.getHeight() - BaseChatItemLayout.V) / 2);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout.1
 * JD-Core Version:    0.7.0.1
 */