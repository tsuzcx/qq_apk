package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class RIJUGCTipsUtils$1
  implements View.OnClickListener
{
  RIJUGCTipsUtils$1(View paramView) {}
  
  public void onClick(View paramView)
  {
    this.a.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCTipsUtils.1
 * JD-Core Version:    0.7.0.1
 */