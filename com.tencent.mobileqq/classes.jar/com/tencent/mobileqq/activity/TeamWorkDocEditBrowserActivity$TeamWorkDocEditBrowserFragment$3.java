package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.teamwork.TenDocMiniAIOHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$3
  implements SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$3(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public Object a(int paramInt)
  {
    if (paramInt != 256) {
      return null;
    }
    return new TenDocMiniAIOHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.3
 * JD-Core Version:    0.7.0.1
 */