package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

class ForwardTroopListFragment$7
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  ForwardTroopListFragment$7(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardTroopListFragment.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardTroopListFragment.a(this.a) != null) {
        ForwardTroopListFragment.a(this.a).a(paramEditable);
      }
      return;
      ForwardTroopListFragment.a(this.a).setVisibility(0);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardTroopListFragment.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    this.a.a.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardTroopListFragment.a(this.a) == null))
    {
      ForwardTroopListFragment.a(this.a, ContactSearchFragment.a(8, 2097176, null, null, ForwardTroopListFragment.a(this.a)));
      FragmentTransaction localFragmentTransaction = this.a.getActivity().getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131376997, ForwardTroopListFragment.a(this.a));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.7
 * JD-Core Version:    0.7.0.1
 */