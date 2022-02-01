package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;

class ForwardFriendListActivity$6
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  ForwardFriendListActivity$6(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardFriendListActivity.a(this.a).setVisibility(8);
    } else {
      ForwardFriendListActivity.a(this.a).setVisibility(0);
    }
    if (ForwardFriendListActivity.a(this.a) != null) {
      ForwardFriendListActivity.a(this.a).a(paramEditable);
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
      Object localObject = this.a;
      ForwardFriendListActivity.a((ForwardFriendListActivity)localObject, ContactSearchFragment.a(6, 1, null, null, ForwardFriendListActivity.a((ForwardFriendListActivity)localObject)));
      localObject = this.a.getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376483, ForwardFriendListActivity.a(this.a));
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.6
 * JD-Core Version:    0.7.0.1
 */