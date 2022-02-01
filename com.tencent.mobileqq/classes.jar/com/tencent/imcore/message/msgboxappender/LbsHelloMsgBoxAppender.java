package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;
import mqq.app.AppRuntime;

public class LbsHelloMsgBoxAppender
  implements IMsgBoxAppender
{
  private Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, IConversationFacade paramIConversationFacade, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt, long paramLong)
  {
    if ((paramIConversationFacade.isUinInRecentNotSubAccount(paramMessageRecord.senderuin)) || (paramMap.containsKey(UinTypeUtil.a(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) {
      paramRecentUserProxy.b(paramMessageRecord.senderuin);
    }
    boolean bool = MsgBoxUtil.a();
    int j;
    if (UinTypeUtil.c(paramMessageRecord))
    {
      paramIMessageManager = (C2CMessageManager)paramIMessageManager;
      paramIMessageManager.a(paramMessageRecord, AppConstants.LBS_SAY_HELLO_LIST_UIN, paramMessageRecord.senderuin);
      if (!bool) {
        paramIMessageManager.a(paramMessageRecord, AppConstants.LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      }
      paramIMessageManager.a(paramMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      if (!paramMessageRecord.isread) {
        paramIConversationFacade.addNewSayHelloToSet(1001, paramMessageRecord.senderuin);
      }
      j = 0;
    }
    else
    {
      if (paramIConversationFacade.isInMsgBox(paramMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN))
      {
        paramIConversationFacade = (C2CMessageManager)paramIMessageManager;
        paramIConversationFacade.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, paramMessageRecord.senderuin, paramIConversationFacade.a.getCurrentAccountUin());
      }
      int i;
      if (MsgBoxUtil.b(paramMessageRecord))
      {
        ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.LBS_HELLO_UIN, paramMessageRecord.senderuin);
        i = 1;
      }
      else
      {
        i = 0;
      }
      j = i;
      if (!MsgBoxUtil.a(paramMessageRecord.msgtype, paramMessageRecord.senderuin))
      {
        j = i;
        if (paramMessageRecord.istroop == 1001)
        {
          ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, paramMessageRecord.senderuin);
          j = i;
        }
      }
    }
    if (j == 0) {
      paramIMessageManager = AppConstants.NEARBY_LBS_HELLO_UIN;
    } else {
      paramIMessageManager = AppConstants.LBS_HELLO_UIN;
    }
    paramMessageRecord.frienduin = paramMessageRecord.senderuin;
    return new Object[] { Boolean.valueOf(true), paramIMessageManager, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
  
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramMessageRecord.frienduin)) {
      return a(paramIMessageManager, paramMessageRecord, paramIConversationFacade, paramMap, paramRecentUserProxy, paramString, paramInt, paramLong);
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.LbsHelloMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */