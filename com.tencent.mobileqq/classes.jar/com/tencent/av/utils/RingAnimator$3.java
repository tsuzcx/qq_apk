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
    if ((!this.a.a) && (10 != paramMessage.what)) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 9)
          {
            if (i != 10) {
              return;
            }
            removeMessages(1);
            removeMessages(2);
            removeMessages(3);
            return;
          }
          sendEmptyMessage(1);
          return;
        }
        if (!this.a.a) {
          return;
        }
        this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_c_of_type_AndroidViewAnimationAnimation);
        sendEmptyMessageDelayed(1, 3300L);
        return;
      }
      if (!this.a.a) {
        return;
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
    sendEmptyMessageDelayed(3, 1300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.RingAnimator.3
 * JD-Core Version:    0.7.0.1
 */