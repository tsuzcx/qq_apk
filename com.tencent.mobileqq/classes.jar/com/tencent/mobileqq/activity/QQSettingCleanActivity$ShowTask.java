package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

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
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              localObject3 = this.this$0.jdField_b_of_type_AndroidWidgetTextView;
              long l = this.this$0.jdField_c_of_type_Long;
              localObject2 = "0M";
              if (l <= 0L)
              {
                localObject1 = "0M";
              }
              else
              {
                localObject1 = this.this$0;
                localObject1 = QQSettingCleanActivity.a((QQSettingCleanActivity)localObject1, ((QQSettingCleanActivity)localObject1).jdField_c_of_type_Long);
              }
              ((TextView)localObject3).setText((CharSequence)localObject1);
              localObject3 = this.this$0.jdField_c_of_type_AndroidWidgetTextView;
              if (this.this$0.jdField_d_of_type_Long <= 0L)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = this.this$0;
                localObject1 = QQSettingCleanActivity.a((QQSettingCleanActivity)localObject1, ((QQSettingCleanActivity)localObject1).jdField_d_of_type_Long);
              }
              ((TextView)localObject3).setText((CharSequence)localObject1);
              localObject1 = this.this$0.jdField_d_of_type_AndroidWidgetTextView;
              localObject2 = this.this$0;
              ((TextView)localObject1).setText(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject2, ((QQSettingCleanActivity)localObject2).jdField_b_of_type_Long - this.this$0.jdField_c_of_type_Long - this.this$0.jdField_e_of_type_Long));
              localObject1 = this.this$0.jdField_e_of_type_AndroidWidgetTextView;
              localObject2 = this.this$0;
              ((TextView)localObject1).setText(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject2, ((QQSettingCleanActivity)localObject2).jdField_e_of_type_Long));
              this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
              this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
              this.this$0.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
              this.this$0.jdField_b_of_type_AndroidWidgetButton.setTextColor(this.this$0.getResources().getColor(2131167089));
              return;
            }
            this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
            this.this$0.jdField_b_of_type_AndroidWidgetButton.setText(this.this$0.getString(2131719186));
            return;
          }
          FMToastUtil.a(2131694475);
          return;
        }
        this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        this.this$0.jdField_b_of_type_AndroidWidgetButton.setText(this.this$0.getString(2131719187));
        return;
      }
      localObject1 = this.this$0.jdField_f_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.this$0.getString(2131719195));
      localObject3 = this.this$0;
      ((StringBuilder)localObject2).append(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject3, ((QQSettingCleanActivity)localObject3).jdField_c_of_type_Long - this.this$0.jdField_f_of_type_Long));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.this$0.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.this$0.getString(2131719191));
    ((StringBuilder)localObject2).append("(");
    Object localObject3 = this.this$0;
    ((StringBuilder)localObject2).append(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject3, ((QQSettingCleanActivity)localObject3).jdField_a_of_type_Long));
    ((StringBuilder)localObject2).append(")");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ShowTask
 * JD-Core Version:    0.7.0.1
 */