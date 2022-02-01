package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class QQSettingMe$7
  implements View.OnTouchListener
{
  QQSettingMe$7(QQSettingMe paramQQSettingMe, ImageView paramImageView, TextView paramTextView, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.7
 * JD-Core Version:    0.7.0.1
 */