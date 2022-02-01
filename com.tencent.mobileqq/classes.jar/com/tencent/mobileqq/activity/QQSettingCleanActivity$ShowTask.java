package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import audr;

class QQSettingCleanActivity$ShowTask
  implements Runnable
{
  public int a;
  
  public QQSettingCleanActivity$ShowTask(QQSettingCleanActivity paramQQSettingCleanActivity, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      return;
    case 0: 
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.getString(2131718946) + "(" + QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_a_of_type_Long) + ")");
      return;
    case 1: 
      this.this$0.jdField_f_of_type_AndroidWidgetTextView.setText(this.this$0.getString(2131718950) + QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_c_of_type_Long - this.this$0.jdField_f_of_type_Long));
      this.this$0.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 2: 
      this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setText(this.this$0.getString(2131718942));
      return;
    case 3: 
      audr.a(2131694305);
      return;
    case 4: 
      this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setText(this.this$0.getString(2131718941));
      return;
    }
    TextView localTextView = this.this$0.jdField_b_of_type_AndroidWidgetTextView;
    if (this.this$0.jdField_c_of_type_Long <= 0L)
    {
      str = "0M";
      localTextView.setText(str);
      localTextView = this.this$0.jdField_c_of_type_AndroidWidgetTextView;
      if (this.this$0.jdField_d_of_type_Long > 0L) {
        break label471;
      }
    }
    label471:
    for (String str = "0M";; str = QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_d_of_type_Long))
    {
      localTextView.setText(str);
      this.this$0.jdField_d_of_type_AndroidWidgetTextView.setText(QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_b_of_type_Long - this.this$0.jdField_c_of_type_Long - this.this$0.jdField_e_of_type_Long));
      this.this$0.jdField_e_of_type_AndroidWidgetTextView.setText(QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_e_of_type_Long));
      this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839347);
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setTextColor(this.this$0.getResources().getColor(2131167059));
      return;
      str = QQSettingCleanActivity.a(this.this$0, this.this$0.jdField_c_of_type_Long);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ShowTask
 * JD-Core Version:    0.7.0.1
 */