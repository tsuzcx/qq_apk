package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountDetailActivityImpl$27
  implements View.OnClickListener
{
  PublicAccountDetailActivityImpl$27(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.27
 * JD-Core Version:    0.7.0.1
 */