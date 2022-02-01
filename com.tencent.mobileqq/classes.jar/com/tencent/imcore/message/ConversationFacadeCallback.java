package com.tencent.imcore.message;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleHandler;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class ConversationFacadeCallback
  implements ConversationFacade.Callback
{
  public static int a(ConfessConvInfo paramConfessConvInfo)
  {
    if (paramConfessConvInfo == null) {
      return 0;
    }
    return paramConfessConvInfo.unreadCount;
  }
  
  private ConfessProxy a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getProxyManager().a();
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getInterFollowMgr().getInterFollowMsgBoxUnreadCount();
    }
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return a(a((QQAppInterface)paramAppRuntime).a(paramString, paramInt1, paramInt2));
    }
    return 0;
  }
  
  public long a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return a((QQAppInterface)paramAppRuntime).a(paramString, paramInt1, paramInt2);
    }
    return 0L;
  }
  
  public long a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      long l = a((QQAppInterface)paramAppRuntime).a(paramString, paramInt1, paramInt2);
      a((QQAppInterface)paramAppRuntime).a(paramString, paramInt1, paramInt2, paramLong, 0);
      return l;
    }
    return 0L;
  }
  
  public BaseMsgProxy a(AppRuntime paramAppRuntime, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMessageProxy(paramInt);
    }
    return null;
  }
  
  public ConversationFacade a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getConversationFacade();
    }
    return null;
  }
  
  public ConversationProxy a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getProxyManager().a();
    }
    return null;
  }
  
  public Message a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramString, paramInt1, paramInt2);
    }
    return null;
  }
  
  public RecentUserProxy a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getProxyManager().a();
    }
    return null;
  }
  
  public ConversationInfo a(ConversationInfo paramConversationInfo)
  {
    return TempMsgBoxUtil.a(paramConversationInfo);
  }
  
  public BaseApplication a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getApp();
    }
    return null;
  }
  
  public String a()
  {
    return "sp_key_say_hello_msg_clean_unread_time";
  }
  
  public List<MessageRecord> a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramMessageRecord.senderuin, paramMessageRecord.istroop, paramInt);
    }
    return null;
  }
  
  public void a(MessageRecord paramMessageRecord, ConversationFacade paramConversationFacade)
  {
    MessageForInteractAndFollow localMessageForInteractAndFollow = (MessageForInteractAndFollow)paramMessageRecord;
    paramConversationFacade.c(paramMessageRecord.senderuin, paramMessageRecord.istroop, localMessageForInteractAndFollow.unReadCount);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    OpenApiManager.getInstance().onMessageReaded(paramString, paramInt, paramBoolean, paramLong);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).refreshAppBadge();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).getNearbyProxy().b(paramInt);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      a((QQAppInterface)paramAppRuntime).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), 1);
      ConfessMsgUtil.a((QQAppInterface)paramAppRuntime, false, true);
      ((ExtendFriendHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a();
      return;
      QCircleChatBoxHelper.getInstance().insertUnReadMessage(paramMessageRecord.frienduin);
      ((QCircleHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.QCIRCLE_HANDLER)).b();
      return;
      paramAppRuntime = (AppletsHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    } while (paramAppRuntime == null);
    paramAppRuntime.b(paramList);
  }
  
  public void a(AppRuntime paramAppRuntime, ConversationFacade paramConversationFacade, String paramString, int paramInt)
  {
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      localObject1 = a(paramAppRuntime, paramInt).a(paramString, paramInt);
      if (ConfessMsgUtil.a((QQAppInterface)paramAppRuntime, true)) {
        break label393;
      }
      if (localObject1 != null) {
        break label390;
      }
      localObject1 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageRecord)localObject2).isSelfConfessor()) {}
        for (j = 1033;; j = 1034)
        {
          UinTypeUtil.a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId());
          i = paramConversationFacade.a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId()) + i;
          break;
        }
      }
      if ((((ConfessManager)paramAppRuntime.getManager(QQManagerFactory.CONFESS_MANAGER)).a() == null) || (!ConfessConfig.a((QQAppInterface)paramAppRuntime, "redpoint_box_show"))) {
        break label387;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.unread.Facade", 2, "calcConfessBoxUnreadCount box redpoint show +1");
      }
      i += 1;
    }
    for (;;)
    {
      if (paramConversationFacade.f(paramString, paramInt) != 0)
      {
        j = 1;
        if ((paramConversationFacade.a(paramString, paramInt) != i) || (paramConversationFacade.e(paramString, paramInt) != 0) || (j != 0))
        {
          localObject1 = a(paramAppRuntime).a(paramString, paramInt);
          localObject2 = a(paramAppRuntime);
          if (localObject1 != null) {
            break label377;
          }
        }
      }
      label377:
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l, i, 0, 0);
        if ((UinTypeUtil.j(paramInt)) && (j != 0)) {
          paramConversationFacade.a(a(paramAppRuntime).a(paramString, paramInt), "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "calcConfessBoxUnreadCount boxUin=" + paramString + ", unread=" + i + ", giftCount=" + 0 + ", redPacketCount=" + 0);
        }
        return;
        j = 0;
        break;
      }
      label387:
      continue;
      label390:
      break;
      label393:
      i = 0;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ConversationInfo paramConversationInfo, int paramInt)
  {
    if (paramConversationInfo != null) {}
    try
    {
      if ((("2747277822".equals(paramConversationInfo.uin)) || (10007 == paramConversationInfo.type)) && (paramAppRuntime != null))
      {
        paramAppRuntime = (GameMsgManager)paramAppRuntime.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        if (paramAppRuntime != null) {
          paramAppRuntime.c(0);
        }
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      CaughtExceptionReport.a(paramAppRuntime);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ServiceAccountFolderManager.a().a((QQAppInterface)paramAppRuntime, paramString);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, Object paramObject)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).getMsgHandler().notifyUI(8023, paramBoolean, paramObject);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2, ConversationFacade paramConversationFacade)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      if (paramBoolean1)
      {
        paramAppRuntime = a((QQAppInterface)paramAppRuntime).a().iterator();
        while (paramAppRuntime.hasNext())
        {
          ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)paramAppRuntime.next();
          if (a(localConfessConvInfo) > 0) {
            paramConversationFacade.a(localConfessConvInfo.uin, localConfessConvInfo.type, localConfessConvInfo.topicId, paramBoolean2);
          }
        }
      }
      a((QQAppInterface)paramAppRuntime).b();
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return "1".equals(paramMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag"));
  }
  
  public boolean a(String paramString)
  {
    return QFileAssistantUtils.a(paramString);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMsgCache().a(paramMessageRecord);
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, RecentUser paramRecentUser)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return QFileAssistantUtils.a((QQAppInterface)paramAppRuntime, paramRecentUser);
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ServiceAccountFolderManager.b((QQAppInterface)paramAppRuntime, paramString);
    }
    return false;
  }
  
  public String b()
  {
    return "sp_key_nearby_clean_unread_time";
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramAppRuntime).a();
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return UniteGrayTipUtil.a(paramMessageRecord);
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return TroopBarAssistantManager.a().a((QQAppInterface)paramAppRuntime, paramString);
    }
    return false;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForFoldMsg;
  }
  
  public boolean c(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return TroopAssistantManager.a().a((QQAppInterface)paramAppRuntime, paramString);
    }
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    return ((MessageForNearbyLiveTip)paramMessageRecord).isLiving;
  }
  
  public boolean e(MessageRecord paramMessageRecord)
  {
    return MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord);
  }
  
  public boolean f(MessageRecord paramMessageRecord)
  {
    return MsgProxyUtils.c(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacadeCallback
 * JD-Core Version:    0.7.0.1
 */