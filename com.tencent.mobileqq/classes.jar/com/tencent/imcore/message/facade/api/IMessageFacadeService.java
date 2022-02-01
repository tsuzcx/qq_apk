package com.tencent.imcore.message.facade.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

@QAPI(process={"all"})
public abstract interface IMessageFacadeService
  extends QRouteApi
{
  public abstract Provider<List<IAddMultiMessagesInnerProcessor>> getAddMultiMsgInnerProcessorProvider();
  
  public abstract ConversationFacade getConversationFacade(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract ConversationProxy getConversationProxy(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> Provider<Map<Integer, ILastMsgGetter<FT, AT>>> getLastMsgGetterProvider();
  
  public abstract BaseQQMessageFacade getMessageFacade(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract BaseMsgProxy getMessageProxy(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract <T extends BaseQQMessageFacade> Provider<Map<Integer, IOnMessageAddCompleteObserver<T>>> getMsgAddCompleteObserverProvider();
  
  public abstract <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> Provider<List<IAddMultiMessagesInnerEndProcessor<FT, AT>>> getMsgAddEndProcessorProvider();
  
  public abstract MessageCache getMsgHandlerMsgCache(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract Provider<Map<Integer, BaseMessageManager>> getMsgManagerProvider(AppRuntime paramAppRuntime, MsgPool paramMsgPool);
  
  public abstract <T extends BaseQQAppInterface> Provider<List<IMessageNotifyProcessor<T>>> getMsgNotifyProcessProvider();
  
  public abstract <T extends BaseQQAppInterface> Provider<List<IMessageSender<T>>> getMsgSenderProvider();
  
  public abstract <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> MsgSummary getMsgSummaryForTroop(AT paramAT, FT paramFT, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> Provider<Map<Integer, IMsgSummaryCreator<FT, AT>>> getMsgSummaryProvider();
  
  public abstract <T extends BaseQQAppInterface> Provider<List<IMessageSendProcessor<T>>> getRealSendProcessorProvider();
  
  public abstract String getUinByPhoneNum(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isBelongServiceAccountFolder(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract boolean isTroopMark(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void reportMsgBoxRead(AppInterface paramAppInterface, int paramInt, BusinessObserver paramBusinessObserver);
  
  public abstract void setReadedForHCTopic(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void setSubaccountAssistantReaded(BaseQQAppInterface paramBaseQQAppInterface, StringBuilder paramStringBuilder, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo);
  
  public abstract msg_svc.PbC2CReadedReportReq setTempGameMsgReaded(BaseQQAppInterface paramBaseQQAppInterface, BaseQQMessageFacade paramBaseQQMessageFacade, boolean paramBoolean, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo);
  
  public abstract String trimName(String paramString, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.api.IMessageFacadeService
 * JD-Core Version:    0.7.0.1
 */