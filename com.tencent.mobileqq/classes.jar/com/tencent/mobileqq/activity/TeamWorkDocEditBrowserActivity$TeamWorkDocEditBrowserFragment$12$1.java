package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$12$1
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$12$1(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.12 param12, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.b.this$0.getQBaseActivity(), QQBrowserActivity.class);
    ITeamWorkUtils localITeamWorkUtils = (ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class);
    if (!TextUtils.isEmpty(this.a)) {
      str = this.a;
    } else {
      str = "https://docs.qq.com/desktop/m/index.html?_from=1";
    }
    String str = localITeamWorkUtils.getTencentDocSourceAdtagStrUrl(str, "s_qq_myfile");
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    this.b.this$0.startActivity(localIntent.putExtra("url", str));
    this.b.this$0.getQBaseActivity().overridePendingTransition(2130772005, 2130772006);
    this.b.this$0.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.12.1
 * JD-Core Version:    0.7.0.1
 */