package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoyTabFrame$12
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366383) {
      KandianSubscribeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), 2);
    }
    for (int i = 1;; i = 2)
    {
      ReadinjoyTabFrame.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame).setAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), 2130772340));
      ReadinjoyTabFrame.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame).setVisibility(8);
      SharedPreUtils.A(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a().getCurrentAccountUin());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), "", "0X80093FE", "0X80093FE", 0, 0, "" + i, "", "", this.jdField_a_of_type_JavaLangString, false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.12
 * JD-Core Version:    0.7.0.1
 */