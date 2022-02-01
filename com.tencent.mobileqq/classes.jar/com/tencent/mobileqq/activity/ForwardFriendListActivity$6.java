package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

class ForwardFriendListActivity$6
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  ForwardFriendListActivity$6(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardFriendListActivity.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardFriendListActivity.a(this.a) != null) {
        ForwardFriendListActivity.a(this.a).a(paramEditable);
      }
      return;
      ForwardFriendListActivity.a(this.a).setVisibility(0);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardFriendListActivity.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardFriendListActivity.a(this.a) == null))
    {
      ForwardFriendListActivity.a(this.a, ContactSearchFragment.a(6, 1, null, null, ForwardFriendListActivity.a(this.a)));
      FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131376997, ForwardFriendListActivity.a(this.a));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.6
 * JD-Core Version:    0.7.0.1
 */