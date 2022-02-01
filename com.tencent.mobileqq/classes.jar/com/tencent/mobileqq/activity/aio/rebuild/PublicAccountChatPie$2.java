package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;

class PublicAccountChatPie$2
  implements DialogInterface.OnClickListener
{
  PublicAccountChatPie$2(PublicAccountChatPie paramPublicAccountChatPie, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.bo.sendLocRequest(4, 0, 0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.2
 * JD-Core Version:    0.7.0.1
 */