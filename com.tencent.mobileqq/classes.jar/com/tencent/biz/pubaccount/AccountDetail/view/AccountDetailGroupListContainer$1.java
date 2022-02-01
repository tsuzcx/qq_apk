package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$1
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$1(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
    paramView.putExtra("lat", this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.g);
    paramView.putExtra("lon", this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramView.putExtra("loc", this.jdField_a_of_type_JavaLangString);
    }
    ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString, "", "", "");
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.1
 * JD-Core Version:    0.7.0.1
 */