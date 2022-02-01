package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

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
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.mShouldNotStayAtThisApp = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.doOnBackPressed();
      ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.mProfileParams.a()).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.gotoChatActivity();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.10
 * JD-Core Version:    0.7.0.1
 */