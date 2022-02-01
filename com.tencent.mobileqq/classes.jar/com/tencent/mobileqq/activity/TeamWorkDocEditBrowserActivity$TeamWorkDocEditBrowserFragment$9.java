package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$9
  implements View.OnClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$9(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment localTeamWorkDocEditBrowserFragment = this.a;
    localTeamWorkDocEditBrowserFragment.b(localTeamWorkDocEditBrowserFragment.getShareUrl());
    paramView.setEnabled(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.9
 * JD-Core Version:    0.7.0.1
 */