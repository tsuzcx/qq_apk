package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qidian.QidianManager;

class PublicAccountDetailActivityImpl$29
  implements AdapterView.OnItemClickListener
{
  PublicAccountDetailActivityImpl$29(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (this.a.mShareDialogBuilder.isShowing()) {
      this.a.mShareDialogBuilder.dismiss();
    }
    int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).c.action;
    paramInt = 0;
    int i = PublicAccountDetailImpl.getReportAccountType(this.a.app, this.a.uin, this.a.accountDetail);
    if (j != 2)
    {
      if (j != 3)
      {
        if (j != 19)
        {
          switch (j)
          {
          default: 
            switch (j)
            {
            default: 
              break;
            case 32: 
              paramInt = 8;
              this.a.showUnFollowActionSheet();
              break;
            case 31: 
              paramInt = 6;
              this.a.gotoMoreInfoActivity();
              break;
            case 30: 
              paramInt = 5;
              this.a.gotoChatActivity();
            }
            break;
          case 11: 
            paramInt = 7;
            this.a.report();
            break;
          case 10: 
            paramInt = 4;
            paramAdapterView = this.a;
            ShareActionSheet.a(paramAdapterView, paramAdapterView.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl(), j);
            break;
          case 9: 
            paramAdapterView = this.a;
            ShareActionSheet.a(paramAdapterView, paramAdapterView.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl(), j);
            paramInt = 3;
            break;
          }
        }
        else
        {
          paramAdapterView = this.a;
          paramView = paramAdapterView.accountDetail.name;
          str = this.a.accountDetail.summary;
          localObject = this.a.shareUrl;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
          localStringBuilder.append(this.a.accountDetail.uin);
          QidianManager.a(paramAdapterView, 6, paramView, str, (String)localObject, localStringBuilder.toString(), this.a.accountDetail.uin, i, true);
        }
      }
      else
      {
        paramAdapterView = this.a;
        ShareActionSheet.a(paramAdapterView, paramAdapterView.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl());
        paramInt = 2;
      }
    }
    else
    {
      paramInt = 1;
      paramAdapterView = this.a;
      ShareActionSheet.b(paramAdapterView, paramAdapterView.getShareDetail(), this.a.getAccountType(), this.a.getShareUrl());
    }
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = this.a.uin;
    if (this.a.needShowUnFollowBtnInActionSheet()) {
      paramAdapterView = "02";
    } else {
      paramAdapterView = "01";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    paramView.publicAccountReportClickEvent(null, str, "0X8007CA6", "0X8007CA6", 0, 0, paramAdapterView, (String)localObject, localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.29
 * JD-Core Version:    0.7.0.1
 */