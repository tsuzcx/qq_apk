package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;

class PublicAccountDetailActivityImpl$10
  implements DialogInterface.OnClickListener
{
  PublicAccountDetailActivityImpl$10(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl.gotoChatActivity();
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl;
    paramDialogInterface.mShouldNotStayAtThisApp = true;
    paramDialogInterface.doOnBackPressed();
    ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl.mProfileParams.a()).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.10
 * JD-Core Version:    0.7.0.1
 */