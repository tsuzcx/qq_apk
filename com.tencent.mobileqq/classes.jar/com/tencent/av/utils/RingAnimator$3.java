package com.tencent.av.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

class RingAnimator$3
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((!this.a.a) && (10 != paramMessage.what)) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          return;
        case 1: 
          this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
          sendEmptyMessageDelayed(3, 1300L);
          return;
        }
      } while (!this.a.a);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
      return;
    } while (!this.a.a);
    this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_c_of_type_AndroidViewAnimationAnimation);
    sendEmptyMessageDelayed(1, 3300L);
    return;
    sendEmptyMessage(1);
    return;
    removeMessages(1);
    removeMessages(2);
    removeMessages(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.RingAnimator.3
 * JD-Core Version:    0.7.0.1
 */