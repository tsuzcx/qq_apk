package com.tencent.mobileqq.activity;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import java.util.List;
import mqq.os.MqqHandler;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$13
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$13(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, int paramInt, List paramList) {}
  
  public void run()
  {
    List localList3 = null;
    int i = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0).a().jdField_a_of_type_Int;
    String str1 = this.this$0.browserApp.getCurrentAccountUin();
    String str2 = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.this$0).a().i;
    String str3 = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.this$0).a().h;
    boolean bool;
    List localList1;
    if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.d(this.this$0).a().b == 3)
    {
      bool = true;
      if (this.jdField_a_of_type_Int != 0) {
        break label164;
      }
      localList1 = this.jdField_a_of_type_JavaUtilList;
      label90:
      if (this.jdField_a_of_type_Int != 1) {
        break label169;
      }
    }
    label164:
    label169:
    for (List localList2 = this.jdField_a_of_type_JavaUtilList;; localList2 = null)
    {
      if (this.jdField_a_of_type_Int == 3000) {
        localList3 = this.jdField_a_of_type_JavaUtilList;
      }
      bool = TeamWorkHandler.a(str1, str2, str3, bool, false, 1, localList1, localList2, localList3);
      ThreadManager.getUIHandler().postDelayed(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13.1(this, i, bool), 3000L);
      return;
      bool = false;
      break;
      localList1 = null;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13
 * JD-Core Version:    0.7.0.1
 */