package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QWalletAIOLifeCycleHelper$4
  implements View.OnClickListener
{
  QWalletAIOLifeCycleHelper$4(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.4
 * JD-Core Version:    0.7.0.1
 */