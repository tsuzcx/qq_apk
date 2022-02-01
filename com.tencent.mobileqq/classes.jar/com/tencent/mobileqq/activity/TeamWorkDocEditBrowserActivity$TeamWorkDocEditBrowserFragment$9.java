package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$9
  implements View.OnClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$9(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mSwiftTitleUI != null)
    {
      this.a.mSwiftTitleUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d = false;
      this.a.mSwiftTitleUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.a = Boolean.valueOf(true);
      if (this.a.mUIStyleHandler != null) {
        this.a.mUIStyleHandler.l();
      }
    }
    this.a.onClick(this.a.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.9
 * JD-Core Version:    0.7.0.1
 */