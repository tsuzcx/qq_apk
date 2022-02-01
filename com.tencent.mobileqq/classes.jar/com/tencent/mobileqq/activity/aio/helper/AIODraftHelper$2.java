package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class AIODraftHelper$2
  implements View.OnClickListener
{
  AIODraftHelper$2(AIODraftHelper paramAIODraftHelper) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435808)
    {
      Object localObject1 = this.a.c.Y.getTag(2131441550);
      if ((localObject1 instanceof ReplyedMessageSpan))
      {
        localObject1 = (ReplyedMessageSpan)localObject1;
        if ((localObject1 != null) && (this.a.b.O() != null))
        {
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = ");
            ((StringBuilder)localObject2).append(((ReplyedMessageSpan)localObject1).c);
            QLog.w("AIODraftHelper", 2, ((StringBuilder)localObject2).toString());
          }
          if ((this.a.c.ah.a == 0) && ((this.a.c instanceof FriendChatPie)))
          {
            ((FriendScroller)this.a.c.bv().e().d()).a(22, ((ReplyedMessageSpan)localObject1).i, ((ReplyedMessageSpan)localObject1).f);
          }
          else if (this.a.c.ab())
          {
            localObject2 = this.a.a.getMessageFacade().getLastMessage(this.a.c.ah.b, this.a.c.ah.a);
            this.a.b.e().d().a(22, ((ReplyedMessageSpan)localObject1).c, (int)(((MessageRecord)localObject2).shmsgseq - ((ReplyedMessageSpan)localObject1).c));
            MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.a.c.ah.b, null);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODraftHelper.2
 * JD-Core Version:    0.7.0.1
 */