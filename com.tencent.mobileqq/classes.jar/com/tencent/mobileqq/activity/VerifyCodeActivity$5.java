package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VerifyCodeActivity$5
  implements View.OnClickListener
{
  VerifyCodeActivity$5(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    QLog.d("VerifyCodeActivity", 1, new Object[] { "refreshVerifyCode isRefresh=", Boolean.valueOf(this.a.b) });
    if (!this.a.b) {
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.5
 * JD-Core Version:    0.7.0.1
 */