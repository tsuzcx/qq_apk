package com.tencent.mobileqq.activity;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$15
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$15(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, Share paramShare, int paramInt, List paramList) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().jdField_a_of_type_Int;
    String str1 = this.this$0.getAppRuntime().getCurrentAccountUin();
    String str2 = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().i;
    String str3 = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().h;
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().b == 3) {
      bool = true;
    } else {
      bool = false;
    }
    List localList1;
    if (this.jdField_a_of_type_Int == 0) {
      localList1 = this.jdField_a_of_type_JavaUtilList;
    } else {
      localList1 = null;
    }
    List localList2;
    if (this.jdField_a_of_type_Int == 1) {
      localList2 = this.jdField_a_of_type_JavaUtilList;
    } else {
      localList2 = null;
    }
    List localList3;
    if (this.jdField_a_of_type_Int == 3000) {
      localList3 = this.jdField_a_of_type_JavaUtilList;
    } else {
      localList3 = null;
    }
    boolean bool = TeamWorkHandlerUtils.a(str1, str2, str3, bool, false, 1, localList1, localList2, localList3);
    ThreadManager.getUIHandler().postDelayed(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.15.1(this, i, bool), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.15
 * JD-Core Version:    0.7.0.1
 */