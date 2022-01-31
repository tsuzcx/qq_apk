package com.tencent.mobileqq.activity;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class TeamWorkDocsListActivity$TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void b()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      Share localShare = b();
      if ((localShare != null) && (TeamWorkUtils.a(localShare.a()))) {
        localSwiftBrowserShareMenuHandler.a = new TeamWorkShareActionSheetBuilder(a());
      }
      localSwiftBrowserShareMenuHandler.a(localShare, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocsListActivity.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */