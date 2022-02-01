package com.tencent.imcore.message;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
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
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
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
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      long l = a(paramAppRuntime).a(paramString, paramInt1, paramInt2);
      a(paramAppRuntime).a(paramString, paramInt1, paramInt2, paramLong, 0);
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
    return ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).onGetUnreadCount(paramConversationInfo);
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
    if (paramAppRuntime.isLogin()) {
      ((IAppBadgeService)paramAppRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      NearbyManagerHelper.a((QQAppInterface)paramAppRuntime).a(paramInt);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      if (paramInt != 1033)
      {
        if (paramInt != 1038)
        {
          if (paramInt != 1044)
          {
            if (paramInt != 10008) {
              return;
            }
            QCircleChatBoxHelper.getInstance().insertUnReadMessage(paramMessageRecord.frienduin);
            QCircleUtils.a().updateRedPoint();
          }
        }
        else
        {
          paramAppRuntime = (AppletsHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
          if (paramAppRuntime == null) {
            return;
          }
          paramAppRuntime.b(paramList);
        }
      }
      else
      {
        paramList = (QQAppInterface)paramAppRuntime;
        a(paramList).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), 1);
        ConfessMsgUtil.a(paramList, false, true);
      }
      ((IExpandHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ConversationFacade paramConversationFacade, String paramString, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      Object localObject2 = a(paramAppRuntime, paramInt).a(paramString, paramInt);
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      int i;
      int j;
      if (!ConfessMsgUtil.a(localQQAppInterface, true))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((MessageRecord)localObject2).isSelfConfessor()) {
            j = 1033;
          } else {
            j = 1034;
          }
          UinTypeUtil.a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId());
          i += paramConversationFacade.a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId());
        }
        j = i;
        if (((ConfessManager)paramAppRuntime.getManager(QQManagerFactory.CONFESS_MANAGER)).a() != null)
        {
          j = i;
          if (ConfessConfig.a(localQQAppInterface, "redpoint_box_show"))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.unread.Facade", 2, "calcConfessBoxUnreadCount box redpoint show +1");
            }
            j = i + 1;
          }
        }
        i = j;
      }
      else
      {
        i = 0;
      }
      if (paramConversationFacade.f(paramString, paramInt) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((paramConversationFacade.a(paramString, paramInt) == i) && (paramConversationFacade.e(paramString, paramInt) == 0) && (j == 0)) {
        break label351;
      }
      Object localObject1 = a(paramAppRuntime).a(paramString, paramInt);
      localObject2 = a(paramAppRuntime);
      long l;
      if (localObject1 == null) {
        l = 0L;
      } else {
        l = ((ConversationInfo)localObject1).lastread;
      }
      ((ConversationProxy)localObject2).a(paramString, paramInt, l, i, 0, 0);
      if ((UinTypeUtil.j(paramInt)) && (j != 0)) {
        paramConversationFacade.a(a(paramAppRuntime).a(paramString, paramInt), "");
      }
      label351:
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("calcConfessBoxUnreadCount boxUin=");
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(", unread=");
        paramAppRuntime.append(i);
        paramAppRuntime.append(", giftCount=");
        paramAppRuntime.append(0);
        paramAppRuntime.append(", redPacketCount=");
        paramAppRuntime.append(0);
        QLog.d("Q.unread.Facade", 2, paramAppRuntime.toString());
        return;
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ConversationInfo paramConversationInfo, int paramInt)
  {
    if (paramConversationInfo != null) {
      try
      {
        if ((("2747277822".equals(paramConversationInfo.uin)) || (10007 == paramConversationInfo.type)) && (paramAppRuntime != null))
        {
          paramAppRuntime = (IGameMsgManagerService)paramAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
          if (paramAppRuntime != null)
          {
            paramAppRuntime.setUnshowedUnreadCnt(0);
            return;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        CaughtExceptionReport.a(paramAppRuntime);
      }
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
    return UniteGrayTipMsgUtil.a(paramMessageRecord);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacadeCallback
 * JD-Core Version:    0.7.0.1
 */