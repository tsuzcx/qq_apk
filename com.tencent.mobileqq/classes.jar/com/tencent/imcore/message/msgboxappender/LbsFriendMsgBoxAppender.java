package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.MsgProxyUtils;
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

public class LbsFriendMsgBoxAppender
  implements IMsgBoxAppender
{
  private Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if ((paramIConversationFacade.isUinInRecentNotSubAccount(paramString)) || (paramMap.containsKey(UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
      paramRecentUserProxy.b(paramMessageRecord.frienduin);
    }
    boolean bool = MsgBoxUtil.a();
    int i;
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
      i = 0;
    }
    else
    {
      if (paramIConversationFacade.isInMsgBox(paramMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN))
      {
        paramMap = (C2CMessageManager)paramIMessageManager;
        paramMap.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, paramMessageRecord.senderuin, paramMap.a.getCurrentAccountUin());
      }
      if (MsgBoxUtil.b(paramMessageRecord))
      {
        ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.LBS_HELLO_UIN, paramMessageRecord.frienduin);
        paramInt = 1;
      }
      else
      {
        paramInt = 0;
      }
      i = paramInt;
      if (!MsgBoxUtil.a(paramMessageRecord.msgtype, paramMessageRecord.senderuin))
      {
        i = paramInt;
        if (paramMessageRecord.istroop == 1001)
        {
          ((C2CMessageManager)paramIMessageManager).a(paramMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, paramMessageRecord.frienduin);
          i = paramInt;
        }
      }
    }
    if (i == 0) {
      paramIMessageManager = AppConstants.NEARBY_LBS_HELLO_UIN;
    } else {
      paramIMessageManager = AppConstants.LBS_HELLO_UIN;
    }
    return new Object[] { Boolean.valueOf(true), paramIMessageManager, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.time) };
  }
  
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if (((UinTypeUtil.e(paramMessageRecord.istroop) == 1001) && (MsgProxyUtils.a(paramMessageRecord.istroop, paramMessageRecord.msgtype))) || (UinTypeUtil.e(paramMessageRecord.istroop) == 1010)) {
      return a(paramIMessageManager, paramMessageRecord, paramMap, paramRecentUserProxy, paramIConversationFacade, paramString, paramInt, paramLong);
    }
    return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.LbsFriendMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */