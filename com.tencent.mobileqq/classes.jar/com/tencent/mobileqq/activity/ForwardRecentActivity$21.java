package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentActivity$21
  implements ContactSearchResultPresenter.OnActionListener
{
  ForwardRecentActivity$21(ForwardRecentActivity paramForwardRecentActivity) {}
  
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
    if (bool) {}
    for (paramView = ((ContactSearchModelDiscussionMember)paramView).e();; paramView = ((ContactSearchModelDiscussion)paramView).a())
    {
      i = 3000;
      break label135;
      if (!(paramView instanceof ContactSearchModelDiscussion)) {
        break;
      }
    }
    if ((paramView instanceof ContactSearchModelNewTroop)) {
      paramView = ((ContactSearchModelNewTroop)paramView).a;
    }
    for (;;)
    {
      break;
      if ((paramView instanceof ContactSearchModelTroop))
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
    }
    label135:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAction, uin = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", displayName = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", troopUin = ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(i);
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, localStringBuilder.toString());
    }
    if ((i != -1) && (ForwardRecentActivity.access$700(this.a, new ResultRecord(str1, str2, i, paramView, "")))) {
      ForwardRecentActivity.access$2500(this.a).notifyDataSetChanged();
    }
    ForwardRecentActivity.access$2800(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.21
 * JD-Core Version:    0.7.0.1
 */