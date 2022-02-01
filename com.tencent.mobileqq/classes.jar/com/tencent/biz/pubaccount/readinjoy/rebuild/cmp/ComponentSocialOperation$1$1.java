package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ComponentSocialOperation$1$1
  implements Runnable
{
  ComponentSocialOperation$1$1(ComponentSocialOperation.1 param1) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846730);
      if (this.a.a.jdField_a_of_type_Int > 0)
      {
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentSocialOperation", 2, "revert upvote to true, set num:" + ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
        }
      }
    }
    label286:
    for (;;)
    {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.a.a.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
      return;
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846733);
      this.a.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      if (this.a.a.jdField_a_of_type_Int > 0) {
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label286;
        }
        QLog.d("ComponentSocialOperation", 2, "revert upvote to false, set num:" + ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
        break;
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131718426);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation.1.1
 * JD-Core Version:    0.7.0.1
 */