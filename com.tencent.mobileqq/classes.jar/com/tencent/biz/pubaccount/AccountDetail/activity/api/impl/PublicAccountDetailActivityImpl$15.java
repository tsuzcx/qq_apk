package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountDetailActivityImpl$15
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountDetailActivityImpl$15(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.unFollowActionSheetHasClick) {
      return;
    }
    this.a.unFollowActionSheetHasClick = true;
    switch (paramInt)
    {
    }
    label285:
    label289:
    for (;;)
    {
      this.a.unFollowActionSheet.dismiss();
      return;
      this.a.mIsChangedFromOutSide = false;
      this.a.unfollow();
      if (((EcShopAssistantManager)this.a.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.a.uin)) {
        ((EcshopReportHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.a.uin, null, null, null, 2L, false);
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.o = false;
      if ("2290230341".equals(this.a.uin))
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
        label179:
        if (this.a.accountDetail == null) {
          break label285;
        }
      }
      for (paramView = this.a.accountDetail.name;; paramView = "")
      {
        if (this.a.accountDetail == null) {
          break label289;
        }
        RecentPubAccHelper.a(this.a.app, this.a.uin, paramView);
        break;
        if (!TextUtils.equals(String.valueOf(2062433139L), this.a.uin)) {
          break label179;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", VideoReporter.a(null), false);
        break label179;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.15
 * JD-Core Version:    0.7.0.1
 */