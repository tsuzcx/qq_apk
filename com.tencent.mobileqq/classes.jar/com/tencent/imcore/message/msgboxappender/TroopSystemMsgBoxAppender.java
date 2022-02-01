package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopSystemMsgBoxAppender
  implements IMsgBoxAppender
{
  private Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, String paramString, int paramInt, long paramLong)
  {
    if ((paramMessageRecord instanceof MessageForSystemMsg))
    {
      localObject = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      if (localObject != null) {
        paramMessageRecord.time = ((structmsg.StructMsg)localObject).msg_time.get();
      }
      paramLong = paramMessageRecord.time;
    }
    Object localObject = (C2CMessageManager)paramIMessageManager;
    Message localMessage = ((C2CMessageManager)localObject).b.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    int j = GroupSystemMsgController.a().b(((C2CMessageManager)localObject).a);
    if (j > 0)
    {
      int i;
      if ((!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.time < localMessage.time)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
        localMessage.msgData = paramMessageRecord.msgData;
        ((C2CMessageManager)localObject).b.setIncomingMsg(localMessage);
        try
        {
          ((C2CMessageManager)paramIMessageManager).a(localMessage);
        }
        catch (Throwable paramIMessageManager)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", paramIMessageManager);
          }
        }
        ((C2CMessageManager)localObject).b.getIncomingMsg().unReadNum = j;
      }
    }
    else
    {
      ((C2CMessageManager)localObject).b.setIncomingMsg(null);
    }
    return new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
  
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(paramMessageRecord.frienduin)) {
      return a(paramIMessageManager, paramMessageRecord, paramString, paramInt, paramLong);
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.TroopSystemMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */