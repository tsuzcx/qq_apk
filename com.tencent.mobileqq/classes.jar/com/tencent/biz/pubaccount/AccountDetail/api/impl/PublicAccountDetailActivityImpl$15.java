package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
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
    paramView = this.a;
    paramView.unFollowActionSheetHasClick = true;
    if (paramInt == 0)
    {
      paramView.mIsChangedFromOutSide = false;
      paramView.unfollow();
      if (((EcShopAssistantManager)this.a.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.a.uin)) {
        ((EcshopReportHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.a.uin, null, null, null, 2L, false);
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.o = false;
      if ("2290230341".equals(this.a.uin)) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
      } else if (TextUtils.equals(String.valueOf(2062433139L), this.a.uin)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null), false);
      }
      if (this.a.accountDetail != null) {
        paramView = this.a.accountDetail.name;
      } else {
        paramView = "";
      }
      if (this.a.accountDetail != null) {
        RecentPubAccHelper.a(this.a.app, this.a.uin, paramView);
      }
    }
    this.a.unFollowActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.15
 * JD-Core Version:    0.7.0.1
 */