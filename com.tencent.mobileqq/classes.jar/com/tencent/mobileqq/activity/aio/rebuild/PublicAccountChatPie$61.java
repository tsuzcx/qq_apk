package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$61
  implements View.OnClickListener
{
  PublicAccountChatPie$61(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mQidianClickListener ... mQidianKefu = ");
      localStringBuilder.append(this.a.Z);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.l(2131695275);
    this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.requestQidiKefu(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.h, this.a.i, this.a.j, new PublicAccountChatPie.61.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.61
 * JD-Core Version:    0.7.0.1
 */