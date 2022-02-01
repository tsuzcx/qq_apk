package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qidian.QidianManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountDetailActivityImpl$29
  implements AdapterView.OnItemClickListener
{
  PublicAccountDetailActivityImpl$29(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (this.a.mShareDialogBuilder.isShowing()) {
      this.a.mShareDialogBuilder.dismiss();
    }
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action;
    int j = PublicAccountReportUtilsImpl.getReportAccountType(this.a.app, this.a.uin, this.a.accountDetail);
    label168:
    label171:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str;
    switch (i)
    {
    default: 
      i = 0;
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str = this.a.uin;
      if (!this.a.needShowUnFollowBtnInActionSheet()) {
        break;
      }
    }
    for (localObject = "02";; localObject = "01")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject, i + "", j + "", null);
      break;
      ShareActionSheet.b(this.a, this.a.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl());
      i = 1;
      break label171;
      ShareActionSheet.a(this.a, this.a.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl());
      i = 2;
      break label171;
      ShareActionSheet.a(this.a, this.a.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl(), i);
      i = 3;
      break label171;
      ShareActionSheet.a(this.a, this.a.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl(), i);
      i = 4;
      break label171;
      this.a.gotoChatActivity();
      i = 5;
      break label171;
      this.a.gotoMoreInfoActivity();
      i = 6;
      break label171;
      this.a.report();
      i = 7;
      break label171;
      this.a.showUnFollowActionSheet();
      i = 8;
      break label171;
      QidianManager.a(this.a, 6, this.a.accountDetail.name, this.a.accountDetail.summary, this.a.shareUrl, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.a.accountDetail.uin, this.a.accountDetail.uin, j, true);
      break label168;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.29
 * JD-Core Version:    0.7.0.1
 */