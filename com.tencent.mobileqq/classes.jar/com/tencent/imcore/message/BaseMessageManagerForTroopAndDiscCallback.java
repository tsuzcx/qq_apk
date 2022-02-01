package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopMessageProcessorCallback;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class BaseMessageManagerForTroopAndDiscCallback
  implements BaseMessageManagerForTroopAndDisc.Callback
{
  public Object a(AppRuntime paramAppRuntime, String paramString, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return TroopAioMsgNavigateUpdateMsgInfoUtil.a((QQAppInterface)paramAppRuntime, paramString, paramMessageInfo, paramObject, paramMessageRecord, paramBoolean);
  }
  
  public List<MessageRecord> a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForLongMsg)) {
      return ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList;
    }
    return null;
  }
  
  public void a(AppRuntime paramAppRuntime, IConversationFacade paramIConversationFacade, IMessageFacade paramIMessageFacade, String paramString, int paramInt, long paramLong, RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    if (paramRecentUser != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      if (RecentUserAppearLogic.a(localQQAppInterface, paramRecentUser.msgType))
      {
        Object localObject = paramRecentUser.msg;
        if (((localObject instanceof AbstructRecentUserMsg)) && (((AbstructRecentUserMsg)localObject).a.a <= paramLong))
        {
          if ((paramInt == 1) && ((localObject instanceof TroopNotificationMsg)))
          {
            localObject = TroopNotificationHelper.a(localQQAppInterface, paramString);
            int i;
            if ((localObject != null) && (((TroopNotificationFlagMsg)localObject).a == 1)) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              if (!TroopAssistantManager.a().a(localQQAppInterface, paramString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, cleanMsgAndMsgData");
                }
                paramRecentUser.cleanMsgAndMsgData(paramRecentUser.msgType);
                paramRecentUserProxy.b(paramRecentUser);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, delRecentUser");
                }
                paramRecentUserProxy.a(paramRecentUser, false);
              }
            }
          }
          else
          {
            paramRecentUser.cleanMsgAndMsgData(paramRecentUser.msgType);
            paramRecentUserProxy.b(paramRecentUser);
          }
          ((TroopAioNavigateBarManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramString, paramInt, 0);
          if (QLog.isColorLevel())
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("cleanBizTypeMark TYPE_ALL_MSG type = ");
            paramAppRuntime.append(paramInt);
            paramAppRuntime.append(", seqFrom = ");
            paramAppRuntime.append(paramLong);
            QLog.d("Q.msg.BaseMessageManager", 2, paramAppRuntime.toString());
          }
          if (paramInt == 1)
          {
            paramInt = paramIConversationFacade.getTroopMask(paramString);
            if ((paramInt != 1) && (paramInt != 4))
            {
              paramAppRuntime = RecentDataListManager.a();
              paramIConversationFacade = new StringBuilder();
              paramIConversationFacade.append(paramRecentUser.uin);
              paramIConversationFacade.append("-");
              paramIConversationFacade.append(paramRecentUser.getType());
              paramAppRuntime.a(paramIConversationFacade.toString());
              paramIMessageFacade.removeRecentUser(paramRecentUser);
            }
          }
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ArrayList<MessageRecord> paramArrayList)
  {
    paramAppRuntime = (ITroopBatchAddFriendService)paramAppRuntime.getRuntimeService(ITroopBatchAddFriendService.class, "");
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.getTroopBatchAddFriendMgr();
      if (paramAppRuntime != null) {
        paramAppRuntime.a(paramArrayList);
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle)
  {
    return ((QQAppInterface)paramAppRuntime).getMsgHandler().a(paramLong1, paramLong2, paramLong3, paramBoolean, paramBundle);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return (!AnonymousChatHelper.a(paramMessageRecord)) && (TroopUtils.a((QQAppInterface)paramAppRuntime, "atMeOrReplyMe"));
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong, RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (RecentUserAppearLogic.a((QQAppInterface)paramAppRuntime, paramRecentUser.msgType)))
    {
      paramAppRuntime = (TroopAioNavigateBarManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      Object localObject = paramRecentUser.msg;
      int i;
      if (((localObject instanceof AbstructRecentUserMsg)) && (((AbstructRecentUserMsg)localObject).a.a == paramLong)) {
        i = NavConstants.b(paramRecentUser.msgType);
      } else {
        i = -1;
      }
      if (i == -1) {
        return false;
      }
      paramRecentUser.cleanMsgAndMsgData(paramRecentUser.msgType);
      paramRecentUserProxy.b(paramRecentUser);
      paramAppRuntime.a(paramString, paramInt, i);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    return ((QQAppInterface)paramAppRuntime).getMsgHandler().a(paramString, paramLong1, paramLong2, paramBoolean, paramBundle, paramInt);
  }
  
  public byte[] a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return TroopMessageProcessorCallback.a(paramMessageRecord1, paramMessageRecord2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDiscCallback
 * JD-Core Version:    0.7.0.1
 */