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
    QQSettingMe.a(this.this$0).setImageResource(2130846046);
    QQSettingMe.b(this.this$0).setImageResource(2130846062);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166441));
    TextView localTextView = (TextView)this.this$0.e.findViewById(2131376497);
    localTextView.setTextColor(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166439));
    ((ImageView)this.this$0.e.findViewById(2131368155)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.1
 * JD-Core Version:    0.7.0.1
 */