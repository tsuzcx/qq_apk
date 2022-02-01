package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$16
  implements View.OnClickListener
{
  TroopMemberListActivity$16(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    RouteUtils.a(this.a.getActivity(), localIntent, "/base/browser");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.16
 * JD-Core Version:    0.7.0.1
 */