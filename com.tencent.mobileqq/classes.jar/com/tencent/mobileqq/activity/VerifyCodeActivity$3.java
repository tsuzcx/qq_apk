package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VerifyCodeActivity$3
  implements View.OnClickListener
{
  VerifyCodeActivity$3(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((str == null) || (str.length() == 0)) {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131692039), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (str != null)
      {
        this.a.a(str);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        VerifyCodeActivity.b(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */