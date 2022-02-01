package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.app.Activity;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class PublicAccountDetailActivityImpl$25
  implements ShareActionSheet.OnItemClickListener
{
  PublicAccountDetailActivityImpl$25(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, Activity paramActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    Object localObject = null;
    int i = paramActionSheetItem.action;
    ShareActionSheet.Detail localDetail = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.getShareDetail();
    String str1 = localDetail.a();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.getAccountType();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.getShareUrl();
    switch (i)
    {
    default: 
      paramActionSheetItem = localObject;
    }
    for (;;)
    {
      paramShareActionSheet.dismiss();
      PublicAccountDetailActivityImpl.access$1800(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, paramActionSheetItem, localDetail);
      return;
      paramActionSheetItem = PublicAccountDetailActivityImpl.access$1400(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, paramActionSheetItem, localDetail, str1, j, str2, this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = PublicAccountDetailActivityImpl.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, localDetail, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = PublicAccountDetailActivityImpl.access$1600(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, localDetail, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = PublicAccountDetailActivityImpl.access$1700(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, i, localDetail, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.25
 * JD-Core Version:    0.7.0.1
 */