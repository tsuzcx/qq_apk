package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$24
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$24(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    ((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a.get()).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.24
 * JD-Core Version:    0.7.0.1
 */