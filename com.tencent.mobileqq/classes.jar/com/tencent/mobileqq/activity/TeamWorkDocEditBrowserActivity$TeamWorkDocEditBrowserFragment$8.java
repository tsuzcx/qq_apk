package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$8
  implements View.OnClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$8(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    int i = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.k(this.a).getIntExtra("key_team_work_edit_type", -1);
    if ((i != 1) && (i != 2)) {
      i = this.a.a;
    }
    String str1 = this.a.getShareUrl();
    String str2 = ((Share)this.a.getShare()).d();
    Intent localIntent = new Intent(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.l(this.a), TeamWorkAuthorizeSettingFragment.class);
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("team_work_name", str2);
    }
    localIntent.putExtra("team_work_pad_url", str1);
    localIntent.putExtra("team_work_pad_list_type", this.a.t);
    PublicFragmentActivity.a(this.a.getQBaseActivity(), localIntent, TeamWorkAuthorizeSettingFragment.class);
    this.a.a(14);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8
 * JD-Core Version:    0.7.0.1
 */