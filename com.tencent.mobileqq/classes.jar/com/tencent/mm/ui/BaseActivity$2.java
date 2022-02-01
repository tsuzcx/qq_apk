package com.tencent.mm.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseActivity$2
  implements View.OnClickListener
{
  BaseActivity$2(BaseActivity paramBaseActivity, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public void onClick(View paramView)
  {
    this.a.onMenuItemClick(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.2
 * JD-Core Version:    0.7.0.1
 */