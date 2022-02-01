package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$39
  implements DialogInterface.OnClickListener
{
  PublicAccountChatPie$39(PublicAccountChatPie paramPublicAccountChatPie, PublicAccountInfo paramPublicAccountInfo, IPublicAccountDataManager paramIPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.mIsAgreeSyncLbs = true;
    paramDialogInterface.mIsSyncLbsSelected = true;
    this.b.savePublicAccountInfo(paramDialogInterface);
    this.c.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.39.1(this);
    this.c.d.execute(paramDialogInterface);
    PublicAccountChatPie.y(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.39
 * JD-Core Version:    0.7.0.1
 */