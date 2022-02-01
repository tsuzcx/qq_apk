package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$40
  implements DialogInterface.OnClickListener
{
  PublicAccountChatPie$40(PublicAccountChatPie paramPublicAccountChatPie, PublicAccountInfo paramPublicAccountInfo, IPublicAccountDataManager paramIPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.mIsAgreeSyncLbs = false;
    paramDialogInterface.mIsSyncLbsSelected = true;
    this.b.savePublicAccountInfo(paramDialogInterface);
    this.c.a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.40
 * JD-Core Version:    0.7.0.1
 */