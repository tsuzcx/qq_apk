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
    String str = this.a.ed.getText().toString();
    if ((str != null) && (str.length() != 0))
    {
      if (str != null)
      {
        this.a.sendVerifyCode(str);
        this.a.tvRefresh.setEnabled(false);
        VerifyCodeActivity.access$100(this.a, false);
      }
    }
    else {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131888925), 0).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */