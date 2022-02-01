package com.tencent.biz.pubaccount;

import ahcf;
import amfb;
import android.text.TextUtils;
import ayoq;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$6$1
  implements Runnable
{
  AccountDetailActivity$6$1(AccountDetailActivity.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.k();
    if (TextUtils.equals(AppConstants.WEISHI_UIN, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.e)) {
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0);
    }
    do
    {
      return;
      if (MiniGamePublicAccountHelper.shouldOpenWebFragment(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.e))
      {
        AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0);
        return;
      }
      if (TextUtils.equals(ayoq.a, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.e))
      {
        AccountDetailActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0);
        return;
      }
      if ((ahcf.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.e)) && (amfb.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        QLog.i("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "updateFollowInfo startNewWeatherWebPageActivity");
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.l));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.e, 1008, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$6.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.6.1
 * JD-Core Version:    0.7.0.1
 */