package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailBaseAdapter$3
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$3(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    ((PublicAccountDetailActivityImpl)this.a.jdField_a_of_type_AndroidAppActivity).gotoMoreInfoActivity();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
    for (String str1 = "02";; str1 = "01")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007CA4", "0X8007CA4", 0, 0, str1, String.valueOf(AccountDetailBaseAdapter.a(this.a)), "", "", false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.3
 * JD-Core Version:    0.7.0.1
 */