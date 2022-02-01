package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class TroopMemberListActivity$39
  extends DiscussionObserver
{
  TroopMemberListActivity$39(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      }
      if (this.a.h)
      {
        this.a.b(paramLong2 + "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      QQToast.a(this.a, 1, this.a.getString(2131693579), 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.runOnUiThread(new TroopMemberListActivity.39.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  public void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.39
 * JD-Core Version:    0.7.0.1
 */