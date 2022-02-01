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
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public class RecommendMsgBoxAppender
  implements IMsgBoxAppender
{
  private Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, String paramString, int paramInt, long paramLong)
  {
    C2CMessageManager localC2CMessageManager = (C2CMessageManager)paramIMessageManager;
    Message localMessage = localC2CMessageManager.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    INewFriendService localINewFriendService = (INewFriendService)localC2CMessageManager.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "");
    localMessage.istroop = paramMessageRecord.istroop;
    localINewFriendService.loadNewFriendMsg(false);
    int j = localINewFriendService.getAllUnreadMessageCount();
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
        localC2CMessageManager.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(localMessage);
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
        localC2CMessageManager.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getIncomingMsg().unReadNum = j;
      }
    }
    else
    {
      localC2CMessageManager.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setIncomingMsg(null);
    }
    return new Object[] { Boolean.valueOf(true), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
  }
  
  public Object[] a(IMessageManager paramIMessageManager, MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    if ((!String.valueOf(AppConstants.MAYKNOW_RECOMMEND_UIN).equals(paramMessageRecord.frienduin)) && (!AppConstants.FRIEND_ANNIVER_UIN.equals(paramMessageRecord.frienduin))) {
      return new Object[] { Boolean.valueOf(false), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) };
    }
    return a(paramIMessageManager, paramMessageRecord, paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.RecommendMsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */