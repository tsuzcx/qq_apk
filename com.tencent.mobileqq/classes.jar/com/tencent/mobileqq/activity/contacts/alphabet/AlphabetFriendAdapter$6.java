package com.tencent.mobileqq.activity.contacts.alphabet;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AlphabetFriendAdapter$6
  implements ActionSheet.OnButtonClickListener
{
  AlphabetFriendAdapter$6(AlphabetFriendAdapter paramAlphabetFriendAdapter, boolean paramBoolean, Friends paramFriends, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(AlphabetFriendAdapter.d(this.d)))
    {
      QQToast.makeText(AlphabetFriendAdapter.d(this.d), 1, 2131889169, 0).show();
    }
    else
    {
      paramView = (FriendListHandler)AlphabetFriendAdapter.e(this.d).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.a) {
        paramView.setSpecialCareSwitch(1, new String[] { this.b.uin }, new boolean[] { false });
      } else {
        paramView.setSpecialCareSwitch(1, new String[] { this.b.uin }, new boolean[] { true });
      }
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.6
 * JD-Core Version:    0.7.0.1
 */