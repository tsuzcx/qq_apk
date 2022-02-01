package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.utils.RouteUtils;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$4
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$4(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("from", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a.getClass().getName());
    RouteUtils.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a.get(), paramView, "/qrscan/scanner");
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.4
 * JD-Core Version:    0.7.0.1
 */