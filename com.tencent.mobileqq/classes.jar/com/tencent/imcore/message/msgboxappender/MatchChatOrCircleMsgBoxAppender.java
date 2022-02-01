package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;

public class MatchChatOrCircleMsgBoxAppender
  implements IMsgBoxAppender
{
  private Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, IConversationFacade paramIConversationFacade, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    if (((paramIConversationFacade.isUinInRecentNotSubAccount(paramMessageRecord.senderuin)) || (paramMap.containsKey(UinTypeUtil.a(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) && (!RecentUtil.a((QQAppInterface)((C2CMessageManager)paramIMessageManager).a, paramMessageRecord.senderuin))) {
      paramRecentUserProxy.a(paramMessageRecord.senderuin);
    }
    ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, paramString2, paramMessageRecord.frienduin);
    return new Object[] { Boolean.valueOf(true), paramString2, Integer.valueOf(paramInt2), Long.valueOf(paramMessageRecord.time) };
  }
  
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 1044) {
      return a(paramIMessageManager, paramMessageRecord, paramIConversationFacade, paramMap, paramRecentUserProxy, paramString, paramInt, paramLong, AppConstants.MATCH_CHAT_UIN, 1044);
    }
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 10008) {
      return a(paramIMessageManager, paramMessageRecord, paramIConversationFacade, paramMap, paramRecentUserProxy, paramString, paramInt, paramLong, AppConstants.QCIRCLE_CHAT_UIN, 10008);
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.MatchChatOrCircleMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */