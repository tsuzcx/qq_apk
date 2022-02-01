package com.tencent.biz.pubaccount.ecshopassit.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MinusViewBotomView$1
  implements View.OnClickListener
{
  MinusViewBotomView$1(MinusViewBotomView paramMinusViewBotomView, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    JumpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext(), "jumpPreview", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, "fypbtn");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext() instanceof ChatActivity)) {
      ((ChatActivity)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext()).finish();
    }
    ReportUtil.a(null, "gouwu_fypbtn_click", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    ReportUtil.b(null, "gouwu_fypbtn_click", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView.1
 * JD-Core Version:    0.7.0.1
 */