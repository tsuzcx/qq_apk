package com.tencent.imcore.message.msgboxappender;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.Map;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class SystemMsgBoxAppender
  implements IMsgBoxAppender
{
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramMessageRecord.frienduin))
    {
      if ((paramMessageRecord instanceof MessageForSystemMsg))
      {
        paramIMessageManager = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (paramIMessageManager != null) {
          paramMessageRecord.time = paramIMessageManager.msg_time.get();
        }
        paramLong = paramMessageRecord.time;
      }
      return new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.SystemMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */