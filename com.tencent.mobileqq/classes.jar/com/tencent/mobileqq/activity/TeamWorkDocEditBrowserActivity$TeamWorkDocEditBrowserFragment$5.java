package com.tencent.mobileqq.activity;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$5
  extends WebTitleBarProxy
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$5(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    super(paramWebTitleBarInterface);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.a.getUIStyle().F = true;
    super.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramAPICallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.5
 * JD-Core Version:    0.7.0.1
 */