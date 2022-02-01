package com.tencent.mobileqq.activity.contacts.friend;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BuddyListAdapter$2
  implements ActionSheet.OnButtonClickListener
{
  BuddyListAdapter$2(BuddyListAdapter paramBuddyListAdapter, boolean paramBoolean, Friends paramFriends, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.d.a))
    {
      QQToast.makeText(this.d.a, 1, 2131889169, 0).show();
    }
    else
    {
      paramView = (FriendListHandler)BuddyListAdapter.e(this.d).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.a)
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.b.uin }, new boolean[] { false });
        ReportController.b(BuddyListAdapter.e(this.d), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.b.uin }, new boolean[] { true });
        ReportController.b(BuddyListAdapter.e(this.d), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.2
 * JD-Core Version:    0.7.0.1
 */