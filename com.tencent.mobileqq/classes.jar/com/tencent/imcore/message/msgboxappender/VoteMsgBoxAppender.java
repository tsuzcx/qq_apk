package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VoteMsgBoxAppender
  implements IMsgBoxAppender
{
  public Object[] a(IMessageManager arg1, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (AppConstants.VOTE_MSG_UIN.equals(paramMessageRecord.frienduin)) {
      synchronized ((C2CMessageManager)???)
      {
        paramMessageRecord = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
        if (paramMessageRecord != null)
        {
          paramMessageRecord = paramMessageRecord.iterator();
          while (paramMessageRecord.hasNext()) {
            paramEntityManager.remove((MessageRecord)paramMessageRecord.next());
          }
        }
        return new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
      }
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.VoteMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */