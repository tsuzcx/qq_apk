package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.QQToast;

class ReplyTextItemBuilder$7
  implements DialogInterface.OnClickListener
{
  ReplyTextItemBuilder$7(ReplyTextItemBuilder paramReplyTextItemBuilder, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.b.f.a == 1) && (((TroopGagMgr)this.b.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.b.f.b, true).b) && ((this.b.e instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.b.e;
      QQToast.makeText(this.b.d.getApp(), 2131895180, 0).show(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.b.d.getMessageFacade().b(this.a, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */