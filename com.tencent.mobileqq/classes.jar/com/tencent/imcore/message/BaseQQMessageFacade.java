package com.tencent.imcore.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.imcore.message.facade.IMessageSendProcessor;
import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import com.tencent.imcore.message.facade.add.OnMsgAddObserver;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.jetbrains.annotations.NotNull;

public abstract class BaseQQMessageFacade
  extends Observable
  implements Manager
{
  public Handler a;
  private final SparseArray<BaseMessageManager> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  protected Registry a;
  public MsgNotifyManager a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public final Map<String, Message> a;
  private final Vector<BaseQQMessageFacade.ObserverWrapper> jdField_a_of_type_JavaUtilVector = new Vector();
  public final ConcurrentHashMap<Integer, List<MessageRecord>> a;
  public final AtomicInteger a;
  public Map<String, Boolean> b;
  public final ConcurrentHashMap<String, Boolean> b;
  private Map<String, Map<String, Object>> c = new HashMap();
  
  public BaseQQMessageFacade(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1017, 0, 1200);
    this.jdField_b_of_type_JavaUtilMap = new QQConcurrentHashMap(1018, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager = new MsgNotifyManager(paramBaseQQAppInterface);
    this.jdField_a_of_type_ComTencentImcoreMessageRegistry = new Registry();
  }
  
  BaseQQMessageFacade(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1017, 0, 1200);
    this.jdField_a_of_type_ComTencentImcoreMessageRegistry = new Registry();
  }
  
  private BaseQQMessageFacade.ObserverWrapper a(Observer paramObserver)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      BaseQQMessageFacade.ObserverWrapper localObserverWrapper = (BaseQQMessageFacade.ObserverWrapper)localIterator.next();
      if ((localObserverWrapper != null) && (paramObserver.equals(BaseQQMessageFacade.ObserverWrapper.a(localObserverWrapper)))) {
        return localObserverWrapper;
      }
    }
    return null;
  }
  
  private IMessageFacadeService a()
  {
    return (IMessageFacadeService)QRoute.api(IMessageFacadeService.class);
  }
  
  private String a(Context paramContext, MessageRecord paramMessageRecord, int paramInt, boolean paramBoolean)
  {
    IMsgSummaryCreator localIMsgSummaryCreator = (IMsgSummaryCreator)((Map)a().getMsgSummaryProvider().get()).get(Integer.valueOf(paramInt));
    if (localIMsgSummaryCreator != null) {
      return localIMsgSummaryCreator.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this, paramContext, paramMessageRecord, paramBoolean);
    }
    return "";
  }
  
  private String a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  @NotNull
  private msg_svc.PbC2CReadedReportReq a(StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo, int paramInt)
  {
    msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    String str = paramConversationInfo.uin;
    if (1006 == paramConversationInfo.type) {
      str = a().getUinByPhoneNum(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramConversationInfo.uin);
    }
    if (TextUtils.isEmpty(str)) {
      return paramPbC2CReadedReportReq;
    }
    localUinPairReadInfo.peer_uin.set(Long.valueOf(str).longValue());
    paramStringBuilder.append("{C2C:");
    paramStringBuilder.append(Long.valueOf(str));
    paramStringBuilder.append(paramConversationInfo.type);
    paramStringBuilder.append("}");
    localUinPairReadInfo.last_read_time.set(paramInt);
    paramStringBuilder = paramPbC2CReadedReportReq;
    if (paramPbC2CReadedReportReq == null) {
      paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
    }
    paramStringBuilder.pair_info.add(localUinPairReadInfo);
    return paramStringBuilder;
  }
  
  private msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (1044 == paramConversationInfo.type) {
      return paramPbC2CReadedReportReq;
    }
    paramConversationInfo = a(paramConversationInfo.uin, paramConversationInfo.type);
    if (paramConversationInfo == null) {
      return paramPbC2CReadedReportReq;
    }
    int i = paramConversationInfo.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramConversationInfo.get(i);
      if (localMessageRecord != null) {
        paramPbC2CReadedReportReq = a(paramBoolean, paramStringBuilder, paramPbC2CReadedReportReq, localMessageRecord);
      }
      i -= 1;
    }
    return paramPbC2CReadedReportReq;
  }
  
  private msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (UinTypeUtil.c(paramMessageRecord.senderuin))
    {
      paramStringBuilder = a(paramMessageRecord.senderuin, paramMessageRecord.istroop);
      localObject = paramPbC2CReadedReportReq;
      if (paramStringBuilder != null)
      {
        localObject = paramPbC2CReadedReportReq;
        if (!paramStringBuilder.isEmpty())
        {
          paramMessageRecord = paramStringBuilder.iterator();
          for (;;)
          {
            localObject = paramPbC2CReadedReportReq;
            if (!paramMessageRecord.hasNext()) {
              break;
            }
            paramStringBuilder = (MessageRecord)paramMessageRecord.next();
            a(paramStringBuilder.senderuin, paramStringBuilder.istroop, true, paramBoolean);
            localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(Long.valueOf(paramStringBuilder.senderuin).longValue());
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramStringBuilder.time);
            paramStringBuilder = paramPbC2CReadedReportReq;
            if (paramPbC2CReadedReportReq == null) {
              paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
            }
            paramStringBuilder.pair_info.add((MessageMicro)localObject);
            paramPbC2CReadedReportReq = paramStringBuilder;
          }
        }
      }
    }
    else
    {
      a(paramMessageRecord.senderuin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), true, paramBoolean);
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      localUinPairReadInfo.last_read_time.set((int)paramMessageRecord.time);
      localObject = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        localObject = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject).pair_info.add(localUinPairReadInfo);
      paramStringBuilder.append("{MSGBOX:");
      paramStringBuilder.append(paramMessageRecord.frienduin);
      paramStringBuilder.append("}");
    }
    return localObject;
  }
  
  private void a(int paramInt, List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    IOnMessageAddCompleteObserver localIOnMessageAddCompleteObserver = (IOnMessageAddCompleteObserver)((Map)a().getMsgAddCompleteObserverProvider().get()).get(Integer.valueOf(paramInt));
    if (localIOnMessageAddCompleteObserver != null) {
      localIOnMessageAddCompleteObserver.a(this, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
  
  private void a(StringBuilder paramStringBuilder, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo)
  {
    a().setSubaccountAssistantReaded(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramStringBuilder, paramPbMsgReadedReportReq, paramConversationInfo);
  }
  
  private void a(List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    Iterator localIterator = ((List)a().getMsgAddEndProcessorProvider().get()).iterator();
    while (localIterator.hasNext()) {
      ((IAddMultiMessagesInnerEndProcessor)localIterator.next()).a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramList, paramAddMessageContext, paramBoolean);
    }
  }
  
  private void a(msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramPbC2CReadedReportReq != null)
    {
      byte[] arrayOfByte = a().getMsgHandlerMsgCache(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).a();
      if (arrayOfByte != null) {
        paramPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramPbMsgReadedReportReq.c2c_read_report.set(paramPbC2CReadedReportReq);
    }
  }
  
  private void a(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo, long paramLong)
  {
    if (!paramConversationInfo.uin.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramConversationInfo.uin).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    paramPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
  }
  
  private BaseMessageManager b(int paramInt)
  {
    MsgPool localMsgPool = a(paramInt).a();
    BaseMessageManager localBaseMessageManager = (BaseMessageManager)((Map)a().getMsgManagerProvider(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localMsgPool).get()).get(Integer.valueOf(paramInt));
    Object localObject = localBaseMessageManager;
    if (localBaseMessageManager == null) {
      localObject = new C2CMessageManager(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localMsgPool);
    }
    return localObject;
  }
  
  private boolean b(ConversationInfo paramConversationInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.d().iterator();
    while (localIterator.hasNext()) {
      if (((GetUnreadMsgNumCallback)localIterator.next()).a(paramConversationInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = ((List)a().getAddMultiMsgInnerProcessorProvider().get()).iterator();
    while (localIterator.hasNext()) {
      ((IAddMultiMessagesInnerProcessor)localIterator.next()).a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord);
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = ((List)a().getRealSendProcessorProvider().get()).iterator();
    while (localIterator.hasNext()) {
      ((IMessageSendProcessor)localIterator.next()).a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord);
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public long a(String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3000) && (paramInt != 1026))
    {
      if (UinTypeUtil.b(paramInt))
      {
        paramString = a(paramInt).b(paramString, paramInt);
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          paramInt = paramString.size() - 1;
          while (paramInt >= 0)
          {
            localObject = (MessageRecord)paramString.get(paramInt);
            if (!MessageRecordInfo.b(((MessageRecord)localObject).issend)) {
              return ((MessageRecord)localObject).time;
            }
            paramInt -= 1;
          }
        }
      }
      return -1L;
    }
    Object localObject = a();
    Message localMessage = ((IMessageFacadeService)localObject).getMessageFacade(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getLastMessage(paramString, paramInt);
    long l = localMessage.shmsgseq;
    if (localMessage.isLongMsg())
    {
      paramString = ((IMessageFacadeService)localObject).getMessageFacade(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).a(paramString, paramInt);
      if ((paramString != null) && (paramString.size() > 0)) {
        return Math.max(l, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
      }
    }
    return l;
  }
  
  public BaseQQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  }
  
  public BaseMessageManager a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      BaseMessageManager localBaseMessageManager2 = (BaseMessageManager)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      BaseMessageManager localBaseMessageManager1 = localBaseMessageManager2;
      if (localBaseMessageManager2 == null)
      {
        localBaseMessageManager1 = b(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localBaseMessageManager1);
      }
      return localBaseMessageManager1;
    }
  }
  
  protected BaseMsgProxy a(int paramInt)
  {
    return a().getMessageProxy(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramInt);
  }
  
  public ConversationFacade a()
  {
    return a().getConversationFacade(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
  }
  
  @Nullable
  protected Message a(long paramLong, List<MessageRecord> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.uniseq > paramLong))
      {
        paramList = new Message();
        paramList.frienduin = localMessageRecord.frienduin;
        paramList.istroop = localMessageRecord.istroop;
        paramList.time = localMessageRecord.time;
        paramList.isread = localMessageRecord.isread;
        a(paramList);
        return paramList;
      }
      i += 1;
    }
    return null;
  }
  
  public Message a(String paramString, int paramInt)
  {
    ILastMsgGetter localILastMsgGetter = (ILastMsgGetter)((Map)a().getLastMsgGetterProvider().get()).get(Integer.valueOf(2));
    if (localILastMsgGetter != null) {
      return localILastMsgGetter.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString, paramInt, 0);
    }
    return null;
  }
  
  public Message a(String paramString, int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
      i = 0;
    } else {
      i = 1;
    }
    ILastMsgGetter localILastMsgGetter = (ILastMsgGetter)((Map)a().getLastMsgGetterProvider().get()).get(Integer.valueOf(i));
    if (localILastMsgGetter != null) {
      return localILastMsgGetter.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString, paramInt1, paramInt2);
    }
    return new Message();
  }
  
  public Registry a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageRegistry;
  }
  
  public MsgSummary a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a().getMsgSummaryForTroop(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this, paramContext, paramMessageRecord, paramBoolean);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (!TextUtils.isEmpty(paramString)))
    {
      ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
      localChatHistorySearchData.mSearchData1 = a(paramInt).b(paramString, paramInt, paramList);
      return localChatHistorySearchData;
    }
    return null;
  }
  
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return a(paramInt).a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public MessageRecord a(Message paramMessage)
  {
    MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordFromDB(paramMessage.msgtype, paramMessage.msgData, paramMessage.extLong, paramMessage.extStr, paramMessage.istroop);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessage);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {
      return paramMessageRecord;
    }
    List localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    Object localObject = paramMessageRecord;
    if (localList != null)
    {
      localObject = paramMessageRecord;
      if (!localList.isEmpty())
      {
        int i = localList.size() - 1;
        for (;;)
        {
          localObject = paramMessageRecord;
          if (i < 0) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          localObject = paramMessageRecord;
          if (UinTypeUtil.a(localMessageRecord, paramMessageRecord))
          {
            if (localMessageRecord.longMsgIndex == 0) {
              return localMessageRecord;
            }
            localObject = paramMessageRecord;
            if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
              localObject = localMessageRecord;
            }
          }
          i -= 1;
          paramMessageRecord = (MessageRecord)localObject;
        }
      }
    }
    return localObject;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord, paramList);
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, 2, paramBoolean);
  }
  
  public String a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(paramString);
    String str2 = ((StringBuilder)localObject1).toString();
    int i = 0;
    localObject1 = null;
    if (paramLong1 >= 0L) {
      paramString = String.format(" time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    } else {
      paramString = null;
    }
    String str1;
    if (paramLong3 >= 0L) {
      str1 = String.format(" _id >= %d ", new Object[] { Long.valueOf(paramLong3) });
    } else {
      str1 = null;
    }
    if (paramBoolean) {
      i = -1000;
    }
    Object localObject2;
    if (i == -1000)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" msgtype = ");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = null;
    }
    if (paramString != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" where ");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (str1 != null) {
      if (localObject1 != null)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append(" and ");
        paramString.append(str1);
        paramString = paramString.toString();
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(" where ");
        paramString.append(str1);
        paramString = paramString.toString();
      }
    }
    localObject1 = paramString;
    if (localObject2 != null) {
      if (paramString != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(" where ");
        paramString.append((String)localObject2);
        localObject1 = paramString.toString();
      }
    }
    paramString = str2;
    if (localObject1 != null)
    {
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append((String)localObject1);
      paramString = paramString.toString();
    }
    localObject1 = paramString;
    if (paramInt > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" order by _id limit ");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramList);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  protected msg_svc.PbC2CReadedReportReq a(boolean paramBoolean, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    return a().setTempGameMsgReaded(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this, paramBoolean, paramPbC2CReadedReportReq, paramConversationInfo);
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (c(paramString, paramInt))
    {
      b(paramString, paramInt);
      List localList = a(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      Object localObject1;
      for (paramString = null; paramInt >= 0; paramString = (String)localObject1)
      {
        Object localObject2 = (MessageRecord)localList.get(paramInt);
        if (localObject2 == null)
        {
          localObject1 = paramString;
        }
        else
        {
          msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo;
          if (UinTypeUtil.c(((MessageRecord)localObject2).senderuin))
          {
            localObject2 = a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            localObject1 = paramString;
            if (localObject2 != null)
            {
              localObject1 = paramString;
              if (!((List)localObject2).isEmpty())
              {
                localObject2 = ((List)localObject2).iterator();
                for (;;)
                {
                  localObject1 = paramString;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
                  if (localMessageRecord != null)
                  {
                    localObject1 = paramString;
                    if (a().a(localMessageRecord.senderuin, localMessageRecord.istroop) > 0)
                    {
                      a(localMessageRecord.senderuin, localMessageRecord.istroop, false, paramBoolean);
                      localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
                      localUinPairReadInfo.peer_uin.set(Long.valueOf(localMessageRecord.senderuin).longValue());
                      localUinPairReadInfo.last_read_time.set((int)localMessageRecord.time);
                      localObject1 = paramString;
                      if (paramString == null) {
                        localObject1 = new msg_svc.PbC2CReadedReportReq();
                      }
                      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add(localUinPairReadInfo);
                    }
                    paramString = (String)localObject1;
                  }
                }
              }
            }
          }
          else if (UinTypeUtil.d(((MessageRecord)localObject2).senderuin))
          {
            if (a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
              a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            }
            localObject1 = a();
            ((IMessageFacadeService)localObject1).reportMsgBoxRead(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 1, null);
            ((IMessageFacadeService)localObject1).reportMsgBoxRead(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 2, null);
            localObject1 = paramString;
          }
          else
          {
            localObject1 = paramString;
            if (a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0)
            {
              a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
              localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
              localUinPairReadInfo.peer_uin.set(Long.valueOf(((MessageRecord)localObject2).senderuin).longValue());
              localUinPairReadInfo.last_read_time.set((int)((MessageRecord)localObject2).time);
              localObject1 = paramString;
              if (paramString == null) {
                localObject1 = new msg_svc.PbC2CReadedReportReq();
              }
              ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add(localUinPairReadInfo);
              localStringBuilder.append("{MSGBOX:");
              localStringBuilder.append(((MessageRecord)localObject2).senderuin);
              localStringBuilder.append("}");
            }
          }
        }
        paramInt -= 1;
      }
      if (paramString != null)
      {
        localObject1 = a().getMsgHandlerMsgCache(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).a();
        if (localObject1 != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("<ReadReport_LBS>setLbsFriendReaded: ");
          paramString.append(localStringBuilder.toString());
          QLog.d("Q.msg.QQMessageFacade", 2, paramString.toString());
          long l2 = System.currentTimeMillis();
          paramString = new StringBuilder();
          paramString.append("setBoxMsgReaded[cost:");
          paramString.append(l2 - l1);
          paramString.append("]");
          QLog.d("Q.msg_box", 2, paramString.toString());
        }
        return localPbMsgReadedReportReq;
      }
      return null;
    }
    return null;
  }
  
  public msg_svc.PbMsgReadedReportReq a(boolean paramBoolean)
  {
    Object localObject2 = a().getConversationProxy(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).a();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (((Set)localObject2).isEmpty()) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
        if ((ConversationFacade.a(localConversationInfo) > 0) && (a().b(localConversationInfo.uin, localConversationInfo.type)) && (!b(localConversationInfo))) {
          if (c(localConversationInfo.uin, localConversationInfo.type))
          {
            localObject1 = a(paramBoolean, localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject1, localConversationInfo);
          }
          else if (7000 == localConversationInfo.type)
          {
            a(localStringBuilder, localPbMsgReadedReportReq, localConversationInfo);
          }
          else if ((paramBoolean) || (localConversationInfo.type != 1008) || (!a(localConversationInfo)))
          {
            long l;
            if ((1006 != localConversationInfo.type) && ((!UinTypeUtil.b(localConversationInfo.type)) || (Long.valueOf(localConversationInfo.uin).longValue() <= 10000L)))
            {
              if (3000 == localConversationInfo.type)
              {
                a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
                l = a(localConversationInfo.uin, localConversationInfo.type);
                if (l == -1L) {
                  break;
                }
                msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
                localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(localConversationInfo.uin).longValue());
                localPbDiscussReadedReportReq.last_read_seq.set(l);
                localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
              }
              else if ((1 == localConversationInfo.type) && (!a().isTroopMark(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localConversationInfo.uin, localConversationInfo.type)))
              {
                a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
                a().setReadedForHCTopic(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localConversationInfo.uin);
                l = a(localConversationInfo.uin, localConversationInfo.type);
                if (l == -1L) {
                  break;
                }
                a(localPbMsgReadedReportReq, localConversationInfo, l);
              }
            }
            else if (10007 == localConversationInfo.type)
            {
              localObject1 = a(paramBoolean, (msg_svc.PbC2CReadedReportReq)localObject1, localConversationInfo);
            }
            else if (localConversationInfo.type != 1036)
            {
              a(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
              l = a(localConversationInfo.uin, localConversationInfo.type);
              if (l == -1L) {
                break;
              }
              localObject1 = a(localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject1, localConversationInfo, (int)l);
            }
          }
        }
      }
      a((msg_svc.PbC2CReadedReportReq)localObject1, localPbMsgReadedReportReq);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<ReadReport_All>setAllReaded: ");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        QLog.d("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject1).toString());
      }
      return localPbMsgReadedReportReq;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.query((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {
      try
      {
        ((Cursor)localObject1).moveToFirst();
        int i = 0;
        while (i < ((Cursor)localObject1).getCount())
        {
          a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
          ((Cursor)localObject1).moveToNext();
          i += 1;
        }
        if (localObject1 == null) {
          return;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    } else {
      ((Cursor)localObject1).close();
    }
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(AppConstants.RECOMMEND_TROOP_UIN);
    if (a().a(str, 4001) <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
      return;
    }
    Message localMessage = getLastMessage(str, 4001);
    paramInt = a(4001).a(paramInt, localMessage);
    a().d(str, 4001, -paramInt);
    if (paramInt != 0)
    {
      setChanged();
      notifyObservers(getLastMessage(str, 4001));
    }
  }
  
  public void a(Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord, MessageCache.a);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, localEntityManager, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getMsgCache()).a(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localEntityManager.close();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver)
  {
    a(paramMessageRecord, paramBusinessObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.frienduin != null))
    {
      if (paramMessageRecord.frienduin.length() < 2) {
        return;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" addAndSendMessage addSendMessage start currenttime:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, localStringBuilder.toString());
      }
      OnMsgAddObserver.a(paramMessageRecord);
      a(paramMessageRecord);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" addAndSendMessage addSendMessage end and sendMessage start currenttime:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, localStringBuilder.toString());
      }
      b(paramMessageRecord, paramBusinessObserver, paramBoolean);
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(" addAndSendMessage sendMessage end currenttime:");
        paramMessageRecord.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramMessageRecord.toString());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    a(paramMessageRecord, paramString, false, true, true, true);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      OnMsgAddObserver.a(paramMessageRecord);
      notifyObservers(paramMessageRecord);
      b(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1).a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateMsgExtraFlagByUniseq: peerUin = ");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
    ((StringBuilder)localObject).append(" type = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uniseq = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("Q.msg.QQMessageFacade", 1, ((StringBuilder)localObject).toString());
    localObject = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, (MessageRecord)localObject, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateC2CMsgTimeByUniseq: peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" time = ");
      localStringBuilder.append(paramLong2);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgContent: peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq = ");
      localStringBuilder.append(paramLong);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgFieldByUniseq: peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" fieldName = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" fieldValue = ");
      localStringBuilder.append(paramObject);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt).a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgContentByUniSeq: peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq = ");
      localStringBuilder.append(paramLong);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ContentValues paramContentValues, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgFieldsByUniseq mr=");
      localStringBuilder.append(paramMessageRecord);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    a(paramInt).a(paramString, paramInt, paramMessageRecord.uniseq, paramContentValues);
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq null == reasons");
      }
      return;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (QLog.isColorLevel())
      {
        paramContentValues = new StringBuilder();
        paramContentValues.append("updateMsgFieldsByUniseq reason=");
        paramContentValues.append(k);
        QLog.d("Q.msg.QQMessageFacade", 2, paramContentValues.toString());
      }
      a(paramInt).a(paramString, paramInt, paramMessageRecord, k);
      i += 1;
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection<MessageRecord> paramCollection)
  {
    if (paramCollection != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("------------");
      localStringBuilder.append(paramString);
      localStringBuilder.append("--------------");
      localStringBuilder.append(paramCollection.size());
      a(localStringBuilder.toString(), "");
      return;
    }
    paramCollection = new StringBuilder();
    paramCollection.append("------------");
    paramCollection.append(paramString);
    paramCollection.append("-------------- is null");
    a(paramCollection.toString(), "");
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    boolean bool;
    if (!paramBoolean) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      a(paramArrayList, paramString, paramBoolean, bool, true, true);
      paramString.close();
      if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
        a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
      }
      a(2, paramArrayList, false, false, false);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    boolean bool;
    if (!paramBoolean1) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
      paramString.close();
      if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
        a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
      }
      a(3, paramArrayList, false, paramBoolean2, false);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    boolean bool;
    if (!paramBoolean1) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
      paramString.close();
      if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
        a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
      }
      a(3, paramArrayList, false, paramBoolean2, paramBoolean3);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        a(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    b(paramList);
  }
  
  protected void a(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      a(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
    }
    BaseMessageManager.AddMessageContext localAddMessageContext = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    long l1 = paramList.size();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      c(localMessageRecord);
      if (localMessageRecord.msgtype == -2029) {
        QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(localMessageRecord.uniseq), " uin:", localMessageRecord.frienduin, " type:", Integer.valueOf(localMessageRecord.istroop) });
      }
      a(localMessageRecord.istroop).a(localMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localAddMessageContext);
    }
    a(paramList, localAddMessageContext, paramBoolean3);
    MsgAutoMonitorUtil.getInstance().addAddMsgTime(System.currentTimeMillis() - l2, l1);
  }
  
  public void a(List<MessageRecord> paramList, String paramString)
  {
    a(paramList, paramString, true);
  }
  
  public void a(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, paramBoolean);
      paramString.close();
      a(0, paramList, paramBoolean, false, false);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  protected boolean a(ConversationInfo paramConversationInfo)
  {
    return a().isBelongServiceAccountFolder(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramConversationInfo.uin);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    Message localMessage = getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (UinTypeUtil.b(paramMessageRecord.istroop))
    {
      if ((paramMessageRecord.msgUid == localMessage.msgUid) && (paramMessageRecord.shmsgseq == localMessage.shmsgseq)) {
        return true;
      }
    }
    else if (paramMessageRecord.shmsgseq == localMessage.shmsgseq) {
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("select count() as counter, 'x' as msgData from ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" where issend=0 and isValid=1 and msgtype ");
    localStringBuilder.append(UinTypeUtil.b());
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(Message.class, localStringBuilder.toString(), null);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.size() > 0)
      {
        bool1 = bool2;
        if (((Message)paramString.get(0)).counter > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool3 = UinTypeUtil.d(paramInt2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (MsgProxyUtils.b(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refresh C2C autopull step 0 , FAIL! , timestamp = ");
        paramString.append(System.currentTimeMillis());
        QLog.w("Q.msg.QQMessageFacade", 2, paramString.toString());
      }
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(paramString, paramInt), Boolean.valueOf(true));
    paramString = a(paramInt).d(paramString, paramInt);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (!paramBoolean) {
        a(paramInt).a();
      }
      paramList = new StringBuilder();
      paramList.append("refresh C2C autopull, size = ");
      paramList.append(paramString.size());
      paramString = paramList.toString();
      paramList = new StringBuilder();
      paramList.append(", timestamp = ");
      paramList.append(System.currentTimeMillis());
      a(paramString, paramList.toString());
      return true;
    }
    return false;
  }
  
  public void addObserver(Observer paramObserver)
  {
    if (paramObserver == null) {
      return;
    }
    try
    {
      if (a(paramObserver) != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addObserver() called with: o = [");
        localStringBuilder.append(paramObserver);
        localStringBuilder.append("], contains");
        QLog.d("Q.msg.QQMessageFacade", 1, localStringBuilder.toString());
        return;
      }
      paramObserver = new BaseQQMessageFacade.ObserverWrapper(paramObserver);
      super.addObserver(paramObserver);
      this.jdField_a_of_type_JavaUtilVector.addElement(paramObserver);
      return;
    }
    finally {}
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, 0, paramBoolean);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void b()
  {
    a().a(false, true);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.frienduin != null))
    {
      if (paramMessageRecord.frienduin.length() < 2) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" addAndSendMessage addSendMessage start currenttime:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, localStringBuilder.toString());
      }
      OnMsgAddObserver.a(paramMessageRecord);
      a(paramMessageRecord);
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(" addAndSendMessage addSendMessage end and sendMessage start currenttime:");
        paramMessageRecord.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramMessageRecord.toString());
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver)
  {
    b(paramMessageRecord, paramBusinessObserver, false);
  }
  
  public void b(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new BaseQQMessageFacade.1(this, paramMessageRecord, paramBusinessObserver, paramBoolean), 10, null, false);
      return;
    }
    c(paramMessageRecord, paramBusinessObserver, paramBoolean);
  }
  
  public void b(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void b(List<MessageRecord> paramList)
  {
    Iterator localIterator = ((List)a().getMsgNotifyProcessProvider().get()).iterator();
    while (localIterator.hasNext()) {
      ((IMessageNotifyProcessor)localIterator.next()).a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramList);
    }
  }
  
  public void b(List<MessageRecord> paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.close();
      a(1, paramList, false, false, false);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void b(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, false, false, true, false);
      paramString.close();
      a(0, paramList, paramBoolean, false, false);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public String c(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, 1, paramBoolean);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).b(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void c()
  {
    a().a(true, true);
  }
  
  public void c(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    d(paramMessageRecord);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMessage: mr_uinType:");
      ((StringBuilder)localObject).append(paramMessageRecord.istroop);
      ((StringBuilder)localObject).append(" mr_msgType:");
      ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
      QLog.d("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
      }
      localObject = ((List)a().getMsgSenderProvider().get()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IMessageSender localIMessageSender = (IMessageSender)((Iterator)localObject).next();
        if (localIMessageSender.a(paramMessageRecord))
        {
          localIMessageSender.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord, paramBusinessObserver, paramBoolean);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        paramBusinessObserver = new StringBuilder();
        paramBusinessObserver.append("sendMessage ERROR:");
        paramBusinessObserver.append(paramMessageRecord.getMessage());
        QLog.e("Q.msg.QQMessageFacade", 2, paramBusinessObserver.toString(), paramMessageRecord);
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    paramString = new BaseQQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  boolean c(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public String d(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    a(paramContext);
    return a().trimName(paramContext.nickName, 0.4F);
  }
  
  public void d()
  {
    try
    {
      super.setChanged();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      Object localObject = a(paramObserver);
      if (localObject != null)
      {
        super.deleteObserver((Observer)localObject);
        this.jdField_a_of_type_JavaUtilVector.removeElement(localObject);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteObserver() called with: o = [");
        ((StringBuilder)localObject).append(paramObserver);
        ((StringBuilder)localObject).append("], NOT contains");
        QLog.d("Q.msg.QQMessageFacade", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void deleteObservers()
  {
    try
    {
      super.deleteObservers();
      this.jdField_a_of_type_JavaUtilVector.removeAllElements();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).g(paramString, paramInt, paramLong);
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).f(paramString, paramInt, paramLong);
  }
  
  public Message getLastMessage(String paramString, int paramInt)
  {
    ILastMsgGetter localILastMsgGetter = (ILastMsgGetter)((Map)a().getLastMsgGetterProvider().get()).get(Integer.valueOf(0));
    if (localILastMsgGetter != null) {
      return localILastMsgGetter.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString, paramInt, 0);
    }
    return new Message();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyObservers() called with: data = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("], costTime = [");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    paramObject = MsgAutoMonitorUtil.getInstance();
    if (paramObject != null)
    {
      paramObject.addMsgObserverTime(l);
      paramObject.addMsgObserverNotifyNum();
    }
  }
  
  public void onDestroy()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.jdField_b_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a();
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseQQMessageFacade
 * JD-Core Version:    0.7.0.1
 */