package com.tencent.mobileqq.activity.selectmember;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$9
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  SelectMemberActivity$9(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(paramEditable);
      }
      return;
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    String str = paramResultRecord.uin;
    if (this.a.b(str))
    {
      this.a.e(str);
      this.a.a(paramResultRecord, false);
      this.a.k();
      int i = this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
      if ((i == 6) || (i == 7) || (i == 5) || (i == 4) || (i == 1) || (i == 0) || (i == 8) || (i == 9)) {
        ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
      }
      SelectMemberActivity.a(this.a, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.a.j == 6) || (this.a.j == 7) || (this.a.j != this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())))
    {
      ContactSearchFragment localContactSearchFragment = ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (localContactSearchFragment != null)
      {
        localContactSearchFragment.d(this.a.w);
        localContactSearchFragment.a(this.a.a(), this.a.jdField_b_of_type_JavaUtilArrayList);
        FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131376997, localContactSearchFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = localContactSearchFragment;
      }
      if (this.a.jdField_b_of_type_Int == 0) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.9
 * JD-Core Version:    0.7.0.1
 */