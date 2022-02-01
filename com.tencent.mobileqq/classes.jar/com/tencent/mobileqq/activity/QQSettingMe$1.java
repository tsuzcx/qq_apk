package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

class QQSettingMe$1
  implements Runnable
{
  QQSettingMe$1(QQSettingMe paramQQSettingMe, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.a(Boolean.valueOf(this.a));
    QQSettingMe.a(this.this$0).setImageResource(2130846061);
    QQSettingMe.b(this.this$0).setImageResource(2130846077);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166445));
    if (this.this$0.b != null) {
      this.this$0.b.setTextColor(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166445));
    }
    TextView localTextView = (TextView)this.this$0.e.findViewById(2131376629);
    localTextView.setTextColor(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166443));
    ((ImageView)this.this$0.e.findViewById(2131368229)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.1
 * JD-Core Version:    0.7.0.1
 */