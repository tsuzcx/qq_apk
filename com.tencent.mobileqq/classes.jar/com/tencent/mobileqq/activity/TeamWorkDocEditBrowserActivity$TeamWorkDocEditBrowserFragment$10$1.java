package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import becb;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10$1
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10$1(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10 param10, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10.this$0.getActivity(), QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "https://docs.qq.com/desktop/m/index.html?_from=1")
    {
      str = becb.b(str, "s_qq_myfile");
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10.this$0.startActivity(localIntent.putExtra("url", str));
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10.this$0.getActivity().overridePendingTransition(2130771988, 2130771989);
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10.this$0.getActivity().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10.1
 * JD-Core Version:    0.7.0.1
 */