package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FrameworkHandler$3
  implements View.OnClickListener
{
  FrameworkHandler$3(FrameworkHandler paramFrameworkHandler) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.3
 * JD-Core Version:    0.7.0.1
 */