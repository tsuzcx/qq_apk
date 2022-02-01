package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class FolderRecommendTabFragment$3
  implements View.OnClickListener
{
  FolderRecommendTabFragment$3(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(FolderRecommendTabFragment.m))
    {
      MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "find_page", "bottom_button", 102, 1, System.currentTimeMillis(), "");
      Intent localIntent = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", FolderRecommendTabFragment.m);
      this.a.getBaseActivity().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.3
 * JD-Core Version:    0.7.0.1
 */