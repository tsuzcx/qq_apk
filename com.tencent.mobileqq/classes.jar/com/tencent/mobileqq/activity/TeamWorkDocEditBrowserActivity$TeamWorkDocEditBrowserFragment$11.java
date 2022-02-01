package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$11
  implements View.OnClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$11(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getSwiftTitleUI() != null)
    {
      this.a.getSwiftTitleUI().b.k = false;
      this.a.getSwiftTitleUI().b.o = Boolean.valueOf(true);
      if (this.a.getUIStyleHandler() != null) {
        this.a.getUIStyleHandler().k();
      }
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment localTeamWorkDocEditBrowserFragment = this.a;
    localTeamWorkDocEditBrowserFragment.onClick(localTeamWorkDocEditBrowserFragment.getSwiftTitleUI().h);
    this.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11
 * JD-Core Version:    0.7.0.1
 */