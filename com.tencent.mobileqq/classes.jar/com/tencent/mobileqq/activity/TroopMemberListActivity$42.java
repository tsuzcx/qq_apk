package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$42
  implements View.OnClickListener
{
  TroopMemberListActivity$42(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42
 * JD-Core Version:    0.7.0.1
 */