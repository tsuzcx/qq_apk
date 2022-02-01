package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$5
  implements View.OnClickListener
{
  TroopMemberListActivity$5(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    localTroopMemberListActivity.setResult(0, localTroopMemberListActivity.getIntent());
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.5
 * JD-Core Version:    0.7.0.1
 */