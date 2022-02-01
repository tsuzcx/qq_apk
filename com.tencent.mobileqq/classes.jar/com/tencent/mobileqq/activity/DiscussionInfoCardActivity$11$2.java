package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;

class DiscussionInfoCardActivity$11$2
  implements DialogInterface.OnClickListener
{
  DiscussionInfoCardActivity$11$2(DiscussionInfoCardActivity.11 param11, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$11.a).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$11.a.app.getProxyManager().a();
    paramDialogInterface.a(paramDialogInterface.a(this.jdField_a_of_type_JavaLangString, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$11.a.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$11.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.11.2
 * JD-Core Version:    0.7.0.1
 */