package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentActivity$21
  implements ContactSearchResultPresenter.OnActionListener
{
  ForwardRecentActivity$21(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(View paramView)
  {
    int i = 3000;
    paramView = (IContactSearchModel)paramView.getTag(2131381651);
    if (paramView == null) {
      return;
    }
    String str1 = paramView.b();
    String str2 = paramView.a().toString();
    if ((paramView instanceof ContactSearchModelDiscussionMember)) {
      paramView = ((ContactSearchModelDiscussionMember)paramView).e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onAction, uin = " + str1 + ", displayName = " + str2 + ", troopUin = " + paramView + ", type = " + i);
      }
      if ((i != -1) && (ForwardRecentActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, "")))) {
        ForwardRecentActivity.a(this.a).notifyDataSetChanged();
      }
      ForwardRecentActivity.h(this.a);
      return;
      if ((paramView instanceof ContactSearchModelDiscussion))
      {
        paramView = ((ContactSearchModelDiscussion)paramView).b();
      }
      else if ((paramView instanceof ContactSearchModelNewTroop))
      {
        paramView = ((ContactSearchModelNewTroop)paramView).a;
        i = 1;
      }
      else if ((paramView instanceof ContactSearchModelTroop))
      {
        paramView = ((ContactSearchModelTroop)paramView).a().troopuin;
        i = 1;
      }
      else if ((paramView instanceof ContactSearchModelFriend))
      {
        i = 0;
        paramView = "-1";
      }
      else
      {
        i = -1;
        paramView = "-1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.21
 * JD-Core Version:    0.7.0.1
 */