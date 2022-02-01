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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "mQidianClickListener ... mQidianKefu = " + this.a.aj);
    }
    this.a.v(2131695271);
    this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.requestQidiKefu(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.j, this.a.k, this.a.l, new PublicAccountChatPie.61.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.61
 * JD-Core Version:    0.7.0.1
 */