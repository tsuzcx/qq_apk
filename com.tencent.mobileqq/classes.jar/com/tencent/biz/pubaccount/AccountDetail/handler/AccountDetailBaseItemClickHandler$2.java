package com.tencent.biz.pubaccount.AccountDetail.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailBaseItemClickHandler$2
  implements View.OnClickListener
{
  AccountDetailBaseItemClickHandler$2(AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    AccountDetailBaseItemClickHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailHandlerAccountDetailBaseItemClickHandler).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler.2
 * JD-Core Version:    0.7.0.1
 */