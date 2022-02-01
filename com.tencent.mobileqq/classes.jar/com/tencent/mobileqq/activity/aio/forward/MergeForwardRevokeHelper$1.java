package com.tencent.mobileqq.activity.aio.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class MergeForwardRevokeHelper$1
  implements DialogInterface.OnClickListener
{
  MergeForwardRevokeHelper$1(MergeForwardRevokeHelper paramMergeForwardRevokeHelper, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    MergeForwardRevokeHelper.a(null);
    if (MergeForwardRevokeHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper) != null) {
      MergeForwardRevokeHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper.1
 * JD-Core Version:    0.7.0.1
 */