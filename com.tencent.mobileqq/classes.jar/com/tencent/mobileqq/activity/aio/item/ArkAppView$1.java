package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkAppView$1
  implements View.OnClickListener
{
  ArkAppView$1(ArkAppView paramArkAppView, ArkViewModel paramArkViewModel) {}
  
  public void onClick(View paramView)
  {
    ArkViewModel localArkViewModel = this.a;
    if (localArkViewModel != null) {
      localArkViewModel.reinitArkContainer();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppView.1
 * JD-Core Version:    0.7.0.1
 */