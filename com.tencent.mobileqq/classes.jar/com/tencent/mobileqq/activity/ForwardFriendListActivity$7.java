package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;

class ForwardFriendListActivity$7
  implements ContactSearchResultPresenter.OnActionListener
{
  ForwardFriendListActivity$7(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(View paramView)
  {
    int i = 1;
    IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramView.getTag(2131381651);
    if (localIContactSearchModel == null) {}
    for (;;)
    {
      return;
      String str1 = localIContactSearchModel.b();
      String str2 = localIContactSearchModel.a().toString();
      paramView = "-1";
      if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember))
      {
        paramView = ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localIContactSearchModel instanceof ContactSearchModelNewTroop)) {
          paramView = ((ContactSearchModelNewTroop)localIContactSearchModel).a;
        } else if ((localIContactSearchModel instanceof ContactSearchModelTroop)) {
          paramView = ((ContactSearchModelTroop)localIContactSearchModel).a().troopuin;
        } else if ((localIContactSearchModel instanceof ContactSearchModelFriend)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.7
 * JD-Core Version:    0.7.0.1
 */