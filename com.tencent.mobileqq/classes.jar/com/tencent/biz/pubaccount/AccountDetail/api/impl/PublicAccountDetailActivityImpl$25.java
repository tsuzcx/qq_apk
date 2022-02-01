package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Activity;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class PublicAccountDetailActivityImpl$25
  implements ShareActionSheet.OnItemClickListener
{
  PublicAccountDetailActivityImpl$25(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, Activity paramActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    ShareActionSheet.Detail localDetail = this.b.getShareDetail();
    String str1 = localDetail.a();
    int j = this.b.getAccountType();
    String str2 = this.b.getShareUrl();
    if (i != 2) {
      if (i != 3)
      {
        if ((i != 9) && (i != 10))
        {
          if (i != 72)
          {
            if (i != 73)
            {
              paramActionSheetItem = null;
              break label178;
            }
          }
          else
          {
            paramActionSheetItem = PublicAccountDetailActivityImpl.access$1400(this.b, paramActionSheetItem, localDetail, str1, j, str2, this.a);
            break label178;
          }
        }
        else
        {
          paramActionSheetItem = PublicAccountDetailActivityImpl.access$1700(this.b, i, localDetail, str1, j, str2, (BaseActivity)this.a);
          break label178;
        }
      }
      else
      {
        paramActionSheetItem = PublicAccountDetailActivityImpl.access$1600(this.b, localDetail, str1, j, str2, (BaseActivity)this.a);
        break label178;
      }
    }
    paramActionSheetItem = PublicAccountDetailActivityImpl.access$1500(this.b, localDetail, str1, j, str2, (BaseActivity)this.a);
    label178:
    paramShareActionSheet.dismiss();
    PublicAccountDetailActivityImpl.access$1800(this.b, paramActionSheetItem, localDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.25
 * JD-Core Version:    0.7.0.1
 */