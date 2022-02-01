package com.tencent.imcore.message.facade.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import com.tencent.imcore.message.facade.MsgManagerProvider;
import com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverProvider;
import com.tencent.imcore.message.facade.add.inner.AddMultiMsgProcessorProvider;
import com.tencent.imcore.message.facade.add.inner.end.AddMultiMessagesInnerFinishProcessorProvider;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.imcore.message.facade.msg.LastMsgGetterProvider;
import com.tencent.imcore.message.facade.msg.summary.MsgSummaryProvider;
import com.tencent.imcore.message.facade.notify.MessageNotifyProcessorProvider;
import com.tencent.imcore.message.facade.send.MessageRealSendProcessorProvider;
import com.tencent.imcore.message.facade.send.sender.MsgSenderProvider;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyMsgCodec;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class MessageFacadeServiceImpl
  implements IMessageFacadeService
{
  private static final String TAG = "MessageFacadeServiceImpl";
  private final Provider<Map<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>>> lastMsgGetterProvider = new LastMsgGetterProvider();
  private final Provider<Map<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>>> msgAddCompleteObserverProvider = new OnMessageAddCompleteObserverProvider();
  private final Provider<List<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>>> msgAddEndProcessorProvider = new AddMultiMessagesInnerFinishProcessorProvider();
  private final Provider<List<IMessageNotifyProcessor<QQAppInterface>>> msgNotifyProcessProvider = new MessageNotifyProcessorProvider();
  private final Provider<List<IMessageSender<QQAppInterface>>> msgSenderProvider = new MsgSenderProvider();
  private final Provider<Map<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>>> msgSummaryProvider = new MsgSummaryProvider();
  private final Provider<List<IAddMultiMessagesInnerProcessor>> processorProvider = new AddMultiMsgProcessorProvider();
  private final Provider<List<IMessageSendProcessor<QQAppInterface>>> realSendProcessorProvider = new MessageRealSendProcessorProvider();
  
  public Provider<List<IAddMultiMessagesInnerProcessor>> getAddMultiMsgInnerProcessorProvider()
  {
    return this.processorProvider;
  }
  
  public ConversationFacade getConversationFacade(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getConversationFacade();
  }
  
  public ConversationProxy getConversationProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getProxyManager().a();
  }
  
  public Provider<Map<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>>> getLastMsgGetterProvider()
  {
    return this.lastMsgGetterProvider;
  }
  
  public BaseQQMessageFacade getMessageFacade(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade();
  }
  
  public BaseMsgProxy getMessageProxy(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageProxy(paramInt);
  }
  
  public Provider<Map<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>>> getMsgAddCompleteObserverProvider()
  {
    return this.msgAddCompleteObserverProvider;
  }
  
  public Provider<List<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>>> getMsgAddEndProcessorProvider()
  {
    return this.msgAddEndProcessorProvider;
  }
  
  public MessageCache getMsgHandlerMsgCache(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMsgHandler().a();
  }
  
  public Provider<Map<Integer, BaseMessageManager>> getMsgManagerProvider(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    return new MsgManagerProvider(paramAppRuntime, paramMsgPool);
  }
  
  public Provider<List<IMessageNotifyProcessor<QQAppInterface>>> getMsgNotifyProcessProvider()
  {
    return this.msgNotifyProcessProvider;
  }
  
  public Provider<List<IMessageSender<QQAppInterface>>> getMsgSenderProvider()
  {
    return this.msgSenderProvider;
  }
  
  public <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> MsgSummary getMsgSummaryForTroop(AT paramAT, FT paramFT, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    try
    {
      if ((paramFT.a(localMessage.istroop) instanceof TroopMessageManager))
      {
        if (TextUtils.isEmpty(ContactUtils.b(paramAT, localMessage.frienduin, localMessage.senderuin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageFacadeServiceImpl", 2, "getMsgSummaryStrForTroop nickname is null");
          }
          localMessage.isFromLS = true;
          paramFT.a(localMessage);
          localMessage.isFromLS = false;
          ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(paramAT, ((QQLSActivity)paramContext).a, localMessage.senderuin, localMessage.frienduin));
        }
        else
        {
          paramFT.a(localMessage);
        }
      }
      else {
        paramFT.a(localMessage);
      }
    }
    catch (Throwable paramFT)
    {
      paramFT.printStackTrace();
    }
    paramFT = new MsgSummary();
    MsgUtils.a(paramContext, paramAT, localMessage, localMessage.istroop, paramFT, localMessage.nickName, false, paramBoolean);
    return paramFT;
  }
  
  public Provider<Map<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>>> getMsgSummaryProvider()
  {
    return this.msgSummaryProvider;
  }
  
  public Provider<List<IMessageSendProcessor<QQAppInterface>>> getRealSendProcessorProvider()
  {
    return this.realSendProcessorProvider;
  }
  
  public String getUinByPhoneNum(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.b(paramAppInterface, paramString);
  }
  
  public boolean isBelongServiceAccountFolder(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ServiceAccountFolderManager.b((QQAppInterface)paramBaseQQAppInterface, paramString);
  }
  
  public boolean isTroopMark(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopMark(paramAppRuntime, paramString, paramInt);
  }
  
  public void reportMsgBoxRead(AppInterface paramAppInterface, int paramInt, BusinessObserver paramBusinessObserver)
  {
    MsgBoxProtocol.a(paramAppInterface, paramInt, null);
  }
  
  public void setReadedForHCTopic(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(paramBaseQQAppInterface, paramString);
  }
  
  public void setSubaccountAssistantReaded(BaseQQAppInterface paramBaseQQAppInterface, StringBuilder paramStringBuilder, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramConversationInfo.uin)) {
      return;
    }
    paramBaseQQAppInterface = (ISubAccountService)paramBaseQQAppInterface.getRuntimeService(ISubAccountService.class, "");
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface.setAllMessageReaded(paramConversationInfo.uin);
      paramBaseQQAppInterface = paramBaseQQAppInterface.getCookie(paramConversationInfo.uin);
      if (paramBaseQQAppInterface != null)
      {
        paramConversationInfo = new msg_svc.PbBindUinMsgReadedConfirmReq();
        paramConversationInfo.sync_cookie.set(ByteStringMicro.copyFrom(paramBaseQQAppInterface));
        paramPbMsgReadedReportReq.bind_uin_read_report.set(paramConversationInfo);
        paramStringBuilder.append("{SUBUIN}");
      }
    }
  }
  
  public msg_svc.PbC2CReadedReportReq setTempGameMsgReaded(BaseQQAppInterface paramBaseQQAppInterface, BaseQQMessageFacade paramBaseQQMessageFacade, boolean paramBoolean, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    Object localObject = paramPbC2CReadedReportReq;
    if (paramBoolean)
    {
      paramBaseQQMessageFacade.a(paramConversationInfo.uin, paramConversationInfo.type, true, paramBoolean);
      long l = paramBaseQQMessageFacade.a(paramConversationInfo.uin, paramConversationInfo.type);
      paramBaseQQMessageFacade = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        paramBaseQQMessageFacade = new msg_svc.PbC2CReadedReportReq();
      }
      TinyMsgCodec.a(paramBaseQQAppInterface, paramBaseQQMessageFacade, l, paramConversationInfo);
      paramBaseQQAppInterface = (IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      localObject = paramBaseQQMessageFacade;
      if (paramBaseQQAppInterface.isInited())
      {
        paramBaseQQAppInterface.setUnshowedUnreadCnt(0);
        localObject = paramBaseQQMessageFacade;
      }
    }
    return localObject;
  }
  
  public String trimName(String paramString, float paramFloat)
  {
    return MsgUtils.a(paramString, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.api.impl.MessageFacadeServiceImpl
 * JD-Core Version:    0.7.0.1
 */