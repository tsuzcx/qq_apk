package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VerifyCodeActivity$2
  implements View.OnClickListener
{
  VerifyCodeActivity$2(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.cancelVerifyDialog();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */