package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRequestActivity$3
  implements View.OnClickListener
{
  TroopRequestActivity$3(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.d;
    TroopNoticeJsHandler.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.3
 * JD-Core Version:    0.7.0.1
 */