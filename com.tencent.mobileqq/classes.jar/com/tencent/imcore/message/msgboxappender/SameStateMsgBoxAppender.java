package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;

public class SameStateMsgBoxAppender
  implements IMsgBoxAppender
{
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 1009)
    {
      if ((paramIConversationFacade.isUinInRecentNotSubAccount(paramString)) || (paramMap.containsKey(UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
        paramRecentUserProxy.a(paramMessageRecord.frienduin);
      }
      ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.SAME_STATE_BOX_UIN, paramMessageRecord.frienduin);
      return new Object[] { Boolean.valueOf(true), AppConstants.SAME_STATE_BOX_UIN, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.time) };
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.SameStateMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */