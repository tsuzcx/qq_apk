package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;

class ForwardTroopListFragment$8
  implements ContactSearchResultPresenter.OnActionListener
{
  ForwardTroopListFragment$8(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onAction(View paramView)
  {
    paramView = (IContactSearchModel)paramView.getTag(2131380884);
    if (paramView == null) {
      return;
    }
    String str1 = paramView.a();
    String str2 = paramView.b().toString();
    boolean bool = paramView instanceof ContactSearchModelDiscussionMember;
    int i = 1;
    if (bool)
    {
      paramView = ((ContactSearchModelDiscussionMember)paramView).e();
      i = 3000;
    }
    else if ((paramView instanceof ContactSearchModelNewTroop))
    {
      paramView = ((ContactSearchModelNewTroop)paramView).a;
    }
    else if ((paramView instanceof ContactSearchModelTroop))
    {
      paramView = ((ContactSearchModelTroop)paramView).a().troopuin;
    }
    else if ((paramView instanceof ContactSearchModelFriend))
    {
      paramView = "-1";
      i = 0;
    }
    else
    {
      paramView = "-1";
      i = -1;
    }
    if ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, "")))) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.8
 * JD-Core Version:    0.7.0.1
 */