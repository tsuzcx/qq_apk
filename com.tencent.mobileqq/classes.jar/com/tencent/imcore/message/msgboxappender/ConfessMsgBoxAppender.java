package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;

public class ConfessMsgBoxAppender
  implements IMsgBoxAppender
{
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (UinTypeUtil.e(paramMessageRecord.istroop) == 1032)
    {
      if (ConfessMsgUtil.c(paramMessageRecord)) {
        ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.CONFESS_UIN, paramMessageRecord.frienduin);
      }
      return new Object[] { Boolean.valueOf(true), AppConstants.CONFESS_UIN, Integer.valueOf(1032), Long.valueOf(paramMessageRecord.time) };
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.ConfessMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */