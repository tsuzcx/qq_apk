package com.tencent.mobileqq.activity.selectmember;

import aewf;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import bdla;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

class SelectMemberActivity$9
  implements aewf
{
  SelectMemberActivity$9(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.this$0.mSearchResultLayout.setVisibility(8);
    }
    for (;;)
    {
      if (this.this$0.contactSearchFragment != null) {
        this.this$0.contactSearchFragment.a(paramEditable);
      }
      return;
      this.this$0.mSearchResultLayout.setVisibility(0);
    }
  }
  
  public void onEditTextFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.this$0.lastInerFrame == 6) || (this.this$0.lastInerFrame == 7) || (this.this$0.lastInerFrame != this.this$0.mInnerFrameManager.a())))
    {
      ContactSearchFragment localContactSearchFragment = ((SelectMemberInnerFrame)this.this$0.mInnerFrameManager.getCurrentView()).a();
      if (localContactSearchFragment != null)
      {
        localContactSearchFragment.d(this.this$0.mFilterRobot);
        localContactSearchFragment.a(this.this$0.getResultUins(), this.this$0.mUinsSelectedDefault);
        FragmentTransaction localFragmentTransaction = this.this$0.getSupportFragmentManager().beginTransaction();
        if (this.this$0.contactSearchFragment != null) {
          localFragmentTransaction.remove(this.this$0.contactSearchFragment);
        }
        localFragmentTransaction.add(2131376602, localContactSearchFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.this$0.contactSearchFragment = localContactSearchFragment;
      }
      if (this.this$0.mSubType == 0) {
        bdla.b(this.this$0.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    bdla.b(this.this$0.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
  }
  
  public void onItemDeleted(ResultRecord paramResultRecord)
  {
    String str = paramResultRecord.uin;
    if (this.this$0.isResultListContainFriend(str))
    {
      this.this$0.removeFriendFromResultList(str);
      this.this$0.updateMultiAddState(paramResultRecord, false);
      this.this$0.setupDoneBtn();
      int i = this.this$0.mInnerFrameManager.a();
      if ((i == 6) || (i == 7) || (i == 5) || (i == 4) || (i == 1) || (i == 0) || (i == 8) || (i == 9)) {
        ((SelectMemberInnerFrame)this.this$0.mInnerFrameManager.getCurrentView()).f();
      }
      SelectMemberActivity.access$100(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.9
 * JD-Core Version:    0.7.0.1
 */