package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.mobileqq.activity.contact.troop.TroopSusSystemMsgHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;

public class TroopSuspiciousMsgBoxAppender
  implements IMsgBoxAppender
{
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (AppConstants.TROOP_SUSPICIOUS_MSG_UIN.equals(paramMessageRecord.frienduin))
    {
      paramIMessageManager = (C2CMessageManager)paramIMessageManager;
      TroopSusSystemMsgHelper.a(paramIMessageManager, paramMessageRecord, paramIMessageManager.b, (QQAppInterface)paramIMessageManager.a);
      return new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Long.valueOf(paramMessageRecord.time) };
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.TroopSuspiciousMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */