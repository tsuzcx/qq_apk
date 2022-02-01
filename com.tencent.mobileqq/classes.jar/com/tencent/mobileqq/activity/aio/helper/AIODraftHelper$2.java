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
    if (paramView.getId() == 2131368874)
    {
      Object localObject1 = AIODraftHelper.a(this.a).jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373876);
      if ((localObject1 instanceof ReplyedMessageSpan))
      {
        localObject1 = (ReplyedMessageSpan)localObject1;
        if ((localObject1 != null) && (AIODraftHelper.a(this.a).a() != null))
        {
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = ");
            ((StringBuilder)localObject2).append(((ReplyedMessageSpan)localObject1).a);
            QLog.w("AIODraftHelper", 2, ((StringBuilder)localObject2).toString());
          }
          if ((AIODraftHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((AIODraftHelper.a(this.a) instanceof FriendChatPie)))
          {
            ((FriendScroller)AIODraftHelper.a(this.a).b().a().a()).a(22, ((ReplyedMessageSpan)localObject1).d, ((ReplyedMessageSpan)localObject1).c);
          }
          else if (AIODraftHelper.a(this.a).e())
          {
            localObject2 = AIODraftHelper.a(this.a).getMessageFacade().getLastMessage(AIODraftHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, AIODraftHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            AIODraftHelper.a(this.a).a().a().a(22, ((ReplyedMessageSpan)localObject1).a, (int)(((MessageRecord)localObject2).shmsgseq - ((ReplyedMessageSpan)localObject1).a));
            MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", AIODraftHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODraftHelper.2
 * JD-Core Version:    0.7.0.1
 */