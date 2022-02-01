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
      this.a.getSwiftTitleUI().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d = false;
      this.a.getSwiftTitleUI().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.a = Boolean.valueOf(true);
      if (this.a.getUIStyleHandler() != null) {
        this.a.getUIStyleHandler().k();
      }
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment localTeamWorkDocEditBrowserFragment = this.a;
    localTeamWorkDocEditBrowserFragment.onClick(localTeamWorkDocEditBrowserFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11
 * JD-Core Version:    0.7.0.1
 */