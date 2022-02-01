package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;

class ForwardTroopListFragment$7
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  ForwardTroopListFragment$7(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardTroopListFragment.e(this.a).setVisibility(8);
    } else {
      ForwardTroopListFragment.e(this.a).setVisibility(0);
    }
    if (ForwardTroopListFragment.c(this.a) != null) {
      ForwardTroopListFragment.c(this.a).a(paramEditable);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardTroopListFragment.b(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    this.a.a.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardTroopListFragment.c(this.a) == null))
    {
      Object localObject = this.a;
      ForwardTroopListFragment.a((ForwardTroopListFragment)localObject, ContactSearchFragment.a(8, 2097176, null, null, ForwardTroopListFragment.d((ForwardTroopListFragment)localObject)));
      localObject = this.a.getBaseActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131444724, ForwardTroopListFragment.c(this.a));
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.7
 * JD-Core Version:    0.7.0.1
 */