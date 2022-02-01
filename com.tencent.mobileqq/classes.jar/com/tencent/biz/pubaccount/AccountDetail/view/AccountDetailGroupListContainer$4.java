package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$4
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$4(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a.get(), ScannerActivity.class);
    localIntent.putExtra("from", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a.getClass().getName());
    localIntent.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a.get()).startActivity(localIntent);
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.4
 * JD-Core Version:    0.7.0.1
 */