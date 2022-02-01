package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class FolderFollowTabFragment$2
  implements View.OnClickListener
{
  FolderFollowTabFragment$2(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(FolderFollowTabFragment.d))
    {
      Intent localIntent = new Intent(FolderFollowTabFragment.a(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", FolderFollowTabFragment.d);
      FolderFollowTabFragment.a(this.a).startActivity(localIntent);
      MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "tab_page", "bottom_button", 102, 1, System.currentTimeMillis(), "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.2
 * JD-Core Version:    0.7.0.1
 */