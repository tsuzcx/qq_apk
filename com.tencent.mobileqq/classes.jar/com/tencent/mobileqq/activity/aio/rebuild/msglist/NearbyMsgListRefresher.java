package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class NearbyMsgListRefresher
  extends MsgListRefresher
{
  public NearbyMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private void a(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if ((AppConstants.SYSTEM_MSG_UIN.equalsIgnoreCase(paramMessageRecord.frienduin)) && (!paramMessageRecord.isread))
    {
      this.a.a().a(paramMessageRecord, this.a.a().getMessageFacade().a());
      return;
    }
    if (this.a.a())
    {
      paramMessageRecord = this.a.a().a();
      paramMessageRecord.a(true);
      paramMessageRecord.b();
      paramChatMessage.mMsgAnimFlag = true;
      a(196608);
    }
    this.a.a(true);
  }
  
  protected void a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (this.a.a().jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin)) && (UinTypeUtil.b(this.a.a().jdField_a_of_type_Int)))
    {
      a((ChatMessage)paramObject, paramMessageRecord);
      return;
    }
    super.a(paramObject, paramMessageRecord);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.a.a().jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.a.a().jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.a.a().jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.NearbyMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */