package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseActivity$3
  implements View.OnClickListener
{
  BaseActivity$3(BaseActivity paramBaseActivity, BaseActivity.b paramb) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = this.b;
    BaseActivity.a(localBaseActivity, BaseActivity.a(localBaseActivity), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.3
 * JD-Core Version:    0.7.0.1
 */