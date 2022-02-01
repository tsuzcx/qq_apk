package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public abstract class BaseMessageManagerForTroopAndDisc
  extends BaseMessageManager
{
  private MessageRecord a;
  
  public BaseMessageManagerForTroopAndDisc(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, MsgPool paramMsgPool)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramMsgPool);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  private int a(long paramLong, List<MessageRecord> paramList)
  {
    int j;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      j = 0;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label65;
      }
      j = i;
      if (((MessageRecord)paramList.get(i)).uniseq == paramLong) {
        break;
      }
      i += 1;
    }
    label65:
    return 0;
  }
  
  private int a(List<MessageRecord> paramList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramList.size() - 1) && (((MessageRecord)paramList.get(i)).shmsgseq == ((MessageRecord)paramList.get(i + 1)).shmsgseq))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + j);
      }
      i += 1;
    }
    return j;
  }
  
  private int a(List<MessageRecord> paramList, int paramInt)
  {
    int i = paramInt;
    while ((paramInt < paramList.size() - 1) && (((MessageRecord)paramList.get(paramInt)).shmsgseq == ((MessageRecord)paramList.get(paramInt + 1)).shmsgseq))
    {
      i += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
      }
      paramInt += 1;
    }
    return i;
  }
  
  private long a(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong)
  {
    if (!paramList.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq == ((MessageRecord)paramList.get(0)).shmsgseq)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (localMessageRecord.getId() > 0L) {}
          for (String str = "id&" + localMessageRecord.getId();; str = "uniseq&" + localMessageRecord.uniseq)
          {
            localHashMap.put(str + "&" + localMessageRecord.shmsgseq, localMessageRecord);
            break;
          }
        }
      }
      paramList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, ((MessageRecord)paramList.get(0)).shmsgseq, localHashMap));
      paramLong = ((MessageRecord)paramList.get(0)).shmsgseq - 1L;
    }
    return paramLong;
  }
  
  private long a(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((!d(localMessageRecord)) && (localMessageRecord.shmsgseq > 0L)) {
        return localMessageRecord.uniseq;
      }
    }
    return 0L;
  }
  
  private HashMap<String, MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return localHashMap;
    }
    long l = a(paramList);
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, l);
    if (localMessageRecord1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + localMessageRecord1.getId() + ", msg = " + localMessageRecord1.getLogColorContent() + ", uniseq = " + localMessageRecord1.uniseq + " , msgtime = " + localMessageRecord1.time + " , shMsgSeq = " + localMessageRecord1.shmsgseq + " , extra = " + localMessageRecord1.extraflag);
      }
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        MessageRecord localMessageRecord2;
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localMessageRecord2 = (MessageRecord)paramList.next();
        } while (localMessageRecord2.shmsgseq != localMessageRecord1.shmsgseq);
        StringBuilder localStringBuilder = new StringBuilder();
        if (localMessageRecord2.getId() > 0L) {}
        for (paramString = "id&" + localMessageRecord2.getId();; paramString = "uniseq&" + localMessageRecord2.uniseq)
        {
          localHashMap.put(paramString + "&" + localMessageRecord2.shmsgseq, localMessageRecord2);
          break;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
    }
    return localHashMap;
  }
  
  private void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label323:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.a((MessageRecord)localObject2));
      }
      for (long l1 = ((ChatMessage)localObject2).shmsgseq;; l1 = 0L)
      {
        if ((l1 > paramLong) || (paramLong == 0L) || (l1 == 0L)) {
          break label323;
        }
        long l2 = MessageCache.a();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, -4009, paramInt, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject2).next());
        }
        MsgProxyUtils.a(paramString, (MessageRecord)localObject1, false);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
        break;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (!paramMessageRecord2.isValid) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
      if (paramMessageRecord2.msgtype == -2017)
      {
        byte[] arrayOfByte = TroopMessageProcessor.a(paramMessageRecord2, paramMessageRecord1);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, arrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
      }
      if (i != 0)
      {
        paramMessageRecord2.shmsgseq = paramMessageRecord1.shmsgseq;
        paramMessageRecord2.time = paramMessageRecord1.time;
        paramMessageRecord2.setExtraFlag(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramMessageRecord2);
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, long paramLong1, MessageRecord paramMessageRecord, int paramInt3, List<MessageRecord> paramList, long paramLong2, boolean paramBoolean)
  {
    if (((paramList.isEmpty()) && (paramLong2 > 0L)) || ((!paramBoolean) && (paramList.size() < paramInt2)))
    {
      paramLong2 = a(paramString, paramInt1, paramList, paramLong2);
      BaseMsgProxy localBaseMsgProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1);
      if (paramMessageRecord == null)
      {
        paramLong1 = 0L;
        paramString = localBaseMsgProxy.a(paramString, paramInt1, paramLong1, paramInt3, paramLong2, paramInt2 - paramList.size(), null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + paramString.size() + ",seq = " + paramLong2 + " , timestamp = " + System.currentTimeMillis());
        }
        if (!paramString.isEmpty()) {
          break label179;
        }
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
        return;
        paramLong1 = paramMessageRecord.getId();
        break;
        label179:
        paramList.addAll(0, paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + paramLong1 + " , locallist = " + paramList.size() + " , timestamp = " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong1, paramList);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2)
  {
    long l2 = ((MessageRecord)paramList1.get(0)).shmsgseq;
    int i = a(paramList1) + 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + l2 + ",itemListStartPoint = " + i + ", timestamp = " + System.currentTimeMillis());
    }
    long l1;
    if (i > paramInt3)
    {
      paramList2.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l2, paramHashMap));
      paramInt3 = paramList2.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
      }
      l1 = l2 - (paramInt2 - paramInt3);
      if (l1 < 0L) {
        break label339;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "getLocalListRefreshReadCacheAndDB() called with: beginSeq = [" + l1 + "],endSeq=[" + l2 + "]");
      }
      paramList2.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).c(paramString, paramInt1, l1, l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
      }
      return;
      paramList2.addAll(paramList1.subList(i, paramInt3));
      break;
      label339:
      l1 = 0L;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
    }
    int i = paramInt3 - paramInt2;
    long l = ((MessageRecord)paramList1.get(i)).shmsgseq;
    i = b(paramList1, i);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
      }
      i = a(paramList1, paramInt3 - paramInt2) + 1;
      if (i > paramInt3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
        }
        paramList2.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong, paramHashMap));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
        }
      }
    }
    do
    {
      return;
      paramList2.addAll(paramList1.subList(i, paramInt3));
      paramInt2 -= paramList2.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
      }
      paramHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1);
      if (l - paramInt2 >= 0L) {}
      for (paramLong = l - paramInt2;; paramLong = 0L)
      {
        paramList2.addAll(0, paramHashMap.c(paramString, paramInt1, paramLong, l));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
        return;
      }
      paramList2.addAll(paramList1.subList(i, paramInt3));
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + paramList2.size() + ", timestamp = " + System.currentTimeMillis());
  }
  
  private void a(String paramString, int paramInt, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    if (paramInt == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(Long.valueOf(paramString).longValue(), paramLong1, paramLong2, true, paramBundle);
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, paramLong1, paramLong2, true, paramBundle, 0);
  }
  
  private void a(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l;
    if ((paramLong2 >= paramLong1) && (paramLong2 > 0L) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis() + " beginSeq:" + paramLong1 + " endSeq:" + paramLong2);
      }
      l = (paramLong2 - paramLong1) / 20L;
      if ((paramLong2 - paramLong1) % 20L != 0L) {
        break label300;
      }
    }
    label300:
    for (int i = 0;; i = 1)
    {
      l = i;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_from_parallel_pull", true);
      localBundle.putBoolean("success", false);
      a(paramString, paramLong1, paramLong2, localBundle, paramLong2);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(false));
      b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 4 , size = " + paramList.size() + " , timestamp = " + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(UinTypeUtil.a(paramString, paramInt))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(UinTypeUtil.a(paramString, paramInt))).booleanValue())) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
      }
      return;
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2, Bundle paramBundle, long paramLong3)
  {
    int i = 0;
    while (paramLong1 < paramLong2)
    {
      ThreadManager.post(new BaseMessageManagerForTroopAndDisc.1(this, paramLong1 + 19L, paramLong3, i, paramLong1, paramString, paramBundle), 8, null, false);
      paramLong1 += 20L;
      i += 1;
    }
  }
  
  private void a(List<MessageRecord> paramList1, long paramLong, List<MessageRecord> paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList1.next();
      if (localMessageRecord.shmsgseq < paramLong)
      {
        paramList2.add(localMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint invalid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint valid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.getId() < 0L) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + paramMessageRecord.getLogColorContent() + " , mr.seq = " + paramMessageRecord.shmsgseq + " , mr.uniseq = " + paramMessageRecord.uniseq + " , extra = " + paramMessageRecord.extraflag);
      }
    }
    for (;;)
    {
      if (((paramMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)paramMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        paramList = (MessageForShortVideo)paramMessageRecord;
        VideoRedbagData.insertData(paramList.shortVideoId, paramList.uniseq, paramList.redBagStat);
      }
      return;
      MsgProxyUtils.c(paramList, paramMessageRecord, true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + paramMessageRecord.getLogColorContent() + " , mr.seq = " + paramMessageRecord.shmsgseq + " , mr.uniseq = " + paramMessageRecord.uniseq + " , extra = " + paramMessageRecord.extraflag);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, List<MessageRecord> paramList3)
  {
    paramList1 = paramList1.iterator();
    label177:
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (paramList1.hasNext())
      {
        localMessageRecord = (MessageRecord)paramList1.next();
        Iterator localIterator = paramList3.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!MsgProxyUtils.a((MessageRecord)localIterator.next(), localMessageRecord, false, true));
      }
      for (boolean bool = true;; bool = false)
      {
        if ((a(paramList2, paramList3, localMessageRecord, bool)) || (!QLog.isColorLevel())) {
          break label177;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + localMessageRecord.getLogColorContent() + " , mr.seq = " + localMessageRecord.shmsgseq + " , mr.msgtype = " + localMessageRecord.msgtype + ", isExist = " + bool + " , extra = " + localMessageRecord.extraflag);
        break;
        return;
      }
    }
  }
  
  private boolean a(int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
    }
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
    a(paramRefreshMessageContext, paramInt);
    return true;
  }
  
  private boolean a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L)
    {
      paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private boolean a(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((MessageRecord)paramList.next()).shmsgseq > 0L) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + paramMessageRecord.senderuin + " mr.msgtype: " + paramMessageRecord.msgtype + " mr.frienduin: " + paramMessageRecord.frienduin + " mr.shmsgseq: " + paramMessageRecord.shmsgseq + " mr.time:" + paramMessageRecord.time + " mr.msg: " + paramMessageRecord.getLogColorContent());
      }
      if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        paramList2 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramList2);
        if (paramList2 != null)
        {
          a(paramMessageRecord, paramList2);
          return true;
        }
      }
      paramList1.add(paramMessageRecord);
    }
    return false;
  }
  
  private int b(List<MessageRecord> paramList, int paramInt)
  {
    while ((paramInt > 0) && (((MessageRecord)paramList.get(paramInt - 1)).shmsgseq == ((MessageRecord)paramList.get(paramInt)).shmsgseq))
    {
      int i = paramInt - 1;
      paramInt = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
        paramInt = i;
      }
    }
    return paramInt;
  }
  
  private void b(List<MessageRecord> paramList)
  {
    if (NetworkUtil.g(BaseApplication.getContext())) {
      try
      {
        paramList.wait(35000L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  private void b(List<MessageRecord> paramList1, long paramLong, List<MessageRecord> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.shmsgseq < paramLong)
      {
        paramList2.add(localMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
      }
    }
    paramList1.removeAll(paramList2);
    paramList2.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + paramList1.size() + ", timestamp = " + System.currentTimeMillis());
    }
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      paramMessageRecord = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
    }
    while (paramMessageRecord.hasNext()) {
      if (((MessageRecord)paramMessageRecord.next()).extraflag != 0)
      {
        return true;
        if (paramMessageRecord.extraflag != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForUniteGrayTip;
  }
  
  public int a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearLimitCountHistory uin = " + paramString1 + ", type = " + paramInt1 + ", needDeleteDB = " + paramBoolean1 + ", delNum = " + paramInt2);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 1, false, false);
    if (1 == paramInt1) {}
    for (String str = String.format("shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString2, Integer.valueOf(paramInt2) });; str = null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString1, paramInt1, paramString2, str, null, null);
      }
      return i;
    }
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  protected abstract String a(String paramString1, String paramString2);
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
    }
    long l1 = a((List)localObject2);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1);
    HashMap localHashMap = a(paramString, paramInt1, (List)localObject2);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
    int i = a(l1, localList);
    for (;;)
    {
      long l2;
      try
      {
        localObject2 = new ArrayList();
        if (localObject3 == null)
        {
          l1 = 0L;
          if (i == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1);
            if (l1 - paramInt2 < 0L) {
              break label486;
            }
            l2 = l1 - paramInt2;
            break label468;
            Object localObject1;
            ((List)localObject2).addAll(((BaseMsgProxy)localObject3).c(paramString, paramInt1, l2, localObject1));
            ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, localHashMap));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
            }
            paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            paramInt1 = 0;
            if (paramInt1 >= ((List)localObject2).size()) {
              break label463;
            }
            localObject3 = (MessageRecord)((List)localObject2).get(paramInt1);
            paramString.b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).senderuin);
            paramInt1 += 1;
            continue;
          }
        }
        else
        {
          l1 = ((MessageRecord)localObject3).shmsgseq;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 0, cacheIndex = " + i + " timestamp = " + System.currentTimeMillis());
        }
        if (i >= paramInt2)
        {
          a(paramString, paramInt1, paramInt2, localHashMap, localList, i, (List)localObject2, l1);
          continue;
        }
        a(paramString, paramInt1, paramInt2, localHashMap, localList, i, (List)localObject2);
      }
      finally {}
      continue;
      label463:
      return localObject2;
      for (;;)
      {
        label468:
        if (l1 - 1L < 0L) {
          break label492;
        }
        l3 = l1 - 1L;
        break;
        label486:
        l2 = 0L;
      }
      label492:
      long l3 = 0L;
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).d(str, paramInt);
    if ((paramRefreshMessageContext.jdField_c_of_type_Int < 3) && (UinTypeUtil.a(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramRefreshMessageContext.jdField_c_of_type_Int += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    if ((UinTypeUtil.a(str, paramInt, localList)) && (paramRefreshMessageContext.jdField_d_of_type_Boolean) && (paramRefreshMessageContext.b < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramRefreshMessageContext.b += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    if ((!paramRefreshMessageContext.i) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.containsKey(UinTypeUtil.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new BaseMessageManagerForTroopAndDisc.4(this, paramRefreshMessageContext, paramString, paramInt, paramLong2, paramLong1, paramBoolean));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    long l3 = paramBundle.getLong("beginSeq", -1L);
    long l4 = paramBundle.getLong("endSeq", -1L);
    boolean bool2 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList;
    Object localObject1;
    Object localObject2;
    int i;
    label112:
    long l1;
    if ((paramInt == 1) && (bool2) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      localList = a(paramString, paramInt, paramList1.size());
      localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
      localObject2 = new StringBuilder().append("refresh roam step 1 , result = ");
      if (paramList1 != null) {
        break label453;
      }
      i = -1;
      ((QQMessageFacade)localObject1).a(i + " , success = " + bool1 + " , beginSeq = " + l3 + " , endSeq = " + l4, " , time = [" + System.currentTimeMillis() + "]");
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramBundle.getInt("counter")));
      if (localList == null) {
        break label487;
      }
      localObject1 = paramList2;
      if (paramList2 == null) {
        localObject1 = new ArrayList();
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        paramList2 = new ArrayList();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt);
        if (l3 - 15L <= 0L) {
          break label464;
        }
        l1 = l3 - 15L;
        label284:
        if (l3 - 1L <= 0L) {
          break label470;
        }
      }
    }
    label453:
    label464:
    label470:
    for (long l2 = l3 - 1L;; l2 = 0L)
    {
      paramList2.addAll(((BaseMsgProxy)localObject2).c(paramString, paramInt, l1, l2));
      paramList2.addAll(localList);
      a(paramList1, (List)localObject1, paramList2);
      paramBundle.putBoolean("success", bool1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)((List)localObject1).get(0)).istroop).a((List)localObject1, null);
      }
      paramList1 = ((List)localObject1).iterator();
      while (paramList1.hasNext()) {
        a(localList, (MessageRecord)paramList1.next());
      }
      localList = (List)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
      break;
      i = paramList1.size();
      break label112;
      l1 = 0L;
      break label284;
    }
    try
    {
      localList.notify();
      label487:
      if (bool2) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().b(paramString, l3, l4);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    int k = -1;
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      MessageInfo localMessageInfo = localMessageRecord.mMessageInfo;
      if ((localMessageInfo != null) && (!localMessageRecord.isread))
      {
        if (localMessageRecord.istroop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          RecentUser localRecentUser = localRecentUserProxy.a(paramString, localMessageRecord.istroop);
          if (!localMessageInfo.a()) {
            break;
          }
          int n = localMessageInfo.a();
          int m = k;
          int j = i;
          if (MessageInfo.a(n, localRecentUser.msgType))
          {
            localRecentUser.msgType = n;
            localRecentUser.msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localMessageInfo, localRecentUser.msg, localMessageRecord, bool);
            localRecentUserProxy.b(localRecentUser);
            m = localMessageRecord.istroop;
            j = 1;
          }
          k = m;
          i = j;
          if (!bool) {
            break;
          }
          if (n != 24)
          {
            k = m;
            i = j;
            if (n != 22) {
              break;
            }
          }
          k = m;
          i = j;
          if (AnonymousChatHelper.a(localMessageRecord)) {
            break;
          }
          k = m;
          i = j;
          if (!TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "atMeOrReplyMe")) {
            break;
          }
          localArrayList.add(localMessageRecord);
          k = m;
          i = j;
          break;
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.getSubThreadHandler().post(new BaseMessageManagerForTroopAndDisc.2(this, localArrayList));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "markAtOrReplyMeMsgInTroop_" + localArrayList.size());
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, k));
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.troop.revoked_troop_msg", 2, "cleanBizTypeMarkForMsgRevoke==>uin:" + paramString + "|type:" + paramInt + "|seqFrom:" + paramLong);
    }
    if ((paramString == null) || (paramLong < 0L)) {
      return false;
    }
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.a(paramString, paramInt);
    TroopAioNavigateBarManager localTroopAioNavigateBarManager;
    if ((localRecentUser != null) && (RecentUserAppearLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.msgType)))
    {
      localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      Object localObject = localRecentUser.msg;
      if ((!(localObject instanceof AbstructRecentUserMsg)) || (((AbstructRecentUserMsg)localObject).a.a != paramLong)) {
        break label204;
      }
    }
    label204:
    for (int i = NavConstants.b(localRecentUser.msgType);; i = -1)
    {
      if (i == -1) {
        return false;
      }
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localRecentUserProxy.b(localRecentUser);
      localTroopAioNavigateBarManager.a(paramString, paramInt, i);
      return true;
      return false;
    }
  }
  
  public boolean a(String paramString1, int paramInt, List<MessageRecord> paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(UinTypeUtil.a(paramString1, paramInt), Boolean.valueOf(true));
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).d(paramString1, paramInt);
    } while ((paramString1 == null) || (paramString1.isEmpty()));
    paramList = MsgProxyUtils.a(paramList, true);
    int i;
    if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L)
    {
      i = 1;
      if (i == 0) {
        break label276;
      }
      paramInt = 0;
      label151:
      if (paramInt >= paramList.size()) {
        break label300;
      }
      if (((MessageRecord)paramList.get(paramInt)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
        break label269;
      }
    }
    for (;;)
    {
      paramList = paramList.subList(paramInt, paramList.size());
      if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq)) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramList, paramString2);
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label269:
        paramInt += 1;
        break label151;
        label276:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramList, paramString2);
      }
      label300:
      paramInt = 0;
    }
  }
  
  protected abstract String b(String paramString1, String paramString2);
  
  protected void b(Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
    if (a(paramInt1, paramRefreshMessageContext, localList)) {}
    long l1;
    long l2;
    boolean bool1;
    do
    {
      return;
      l1 = a(localList);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (!localList.isEmpty())
        {
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq + 1L;
          l2 = l1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called set tail headMsgUniseq = [" + l1 + "]");
            l2 = l1;
          }
        }
      }
      bool1 = a(localList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: uin = [" + paramString + "], type = [" + paramInt1 + "], count = [" + paramInt2 + "], context = [" + paramRefreshMessageContext + "], aio head msg headMsgUniseq = [" + l2 + "]");
      }
    } while (a(paramInt1, paramRefreshMessageContext, bool1));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: aio head msg = [" + localObject1 + "]");
    }
    long l3;
    if (localObject1 == null)
    {
      l3 = 0L;
      l1 = l3;
      if (l3 == 0L) {
        l1 = l2;
      }
      if (localObject1 != null) {
        break label475;
      }
    }
    int m;
    int i;
    int k;
    long l4;
    Object localObject2;
    label475:
    for (int j = 3;; j = ((MessageRecord)localObject1).versionCode)
    {
      localList = a(paramString, paramInt1, paramInt2);
      m = 0;
      i = 0;
      if ((localList == null) || (localList.isEmpty())) {
        break label1327;
      }
      k = localList.size() - 1;
      l3 = l1;
      for (;;)
      {
        m = i;
        l4 = l3;
        if (k < 0) {
          break label506;
        }
        localObject2 = (MessageRecord)localList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: messageRecord = [" + localObject2 + "]");
        }
        if (!d((MessageRecord)localObject2)) {
          break;
        }
        k -= 1;
      }
      l3 = ((MessageRecord)localObject1).shmsgseq;
      break;
    }
    if (l3 - ((MessageRecord)localObject2).shmsgseq > 1L)
    {
      l4 = l3;
      m = i;
    }
    for (;;)
    {
      label506:
      long l5 = l4 - 1L;
      k = paramInt2 - m;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doRefreshMessageListHead() called with: localSize = [" + m + "], lastContinuedSeq = [" + l4 + "], needSize = [" + k + "], count = [" + paramInt2 + "]");
      }
      i = k;
      if (k < 0) {
        i = 0;
      }
      l3 = 1L + (l5 - i);
      long l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + l6 + ", endSeq = " + l5 + ",beginSeq = " + l3 + ",lastContinuedSeq = " + l4 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
      }
      boolean bool2 = a(paramRefreshMessageContext, l5, true);
      if (l5 <= l6)
      {
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        bool2 = false;
        l1 = l3;
      }
      for (;;)
      {
        l3 = l1;
        if (l1 < 0L) {
          l3 = 0L;
        }
        b(localList, l3, new ArrayList());
        boolean bool3 = true;
        bool1 = bool3;
        if (!paramRefreshMessageContext.jdField_c_of_type_Boolean)
        {
          bool1 = bool3;
          if (l5 >= l3)
          {
            bool1 = bool3;
            if (l5 > 0L)
            {
              bool1 = bool3;
              if (bool2)
              {
                localObject2 = new Bundle();
                i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
                ((Bundle)localObject2).putInt("counter", i);
                ((Bundle)localObject2).putBoolean("success", false);
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localList);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                }
                a(paramString, paramInt1, l3, l5, (Bundle)localObject2);
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
                b(localList);
                bool2 = ((Bundle)localObject2).getBoolean("success");
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + localList.size() + " , timestamp = " + System.currentTimeMillis());
                }
                bool1 = bool2;
                if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(UinTypeUtil.a(paramString, paramInt1)))
                {
                  bool1 = bool2;
                  if (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(UinTypeUtil.a(paramString, paramInt1))).booleanValue())
                  {
                    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
                    a(paramRefreshMessageContext, paramInt1);
                    return;
                    l3 = ((MessageRecord)localObject2).shmsgseq;
                    i += 1;
                    break;
                    if (l3 > l6) {
                      break label1320;
                    }
                    l1 = l6 + 1L;
                    continue;
                  }
                }
              }
            }
          }
        }
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, l2, (MessageRecord)localObject1, j, localList, l5, bool1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + paramRefreshMessageContext.jdField_c_of_type_Boolean);
        }
        a(localList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localList);
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = localList;
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
        if (localList == null) {}
        for (paramInt2 = -1;; paramInt2 = localList.size())
        {
          paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
          a(paramRefreshMessageContext, paramInt1);
          return;
        }
        label1320:
        l1 = l3;
      }
      label1327:
      l4 = l1;
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {}
    boolean bool;
    label44:
    MessageRecord localMessageRecord;
    do
    {
      return false;
      if ((!paramMessageRecord.isLongMsg()) || (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLongMsg))) {
        break label119;
      }
      Iterator localIterator = ((MessageForLongMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).longMsgFragmentList.iterator();
      bool = false;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)localIterator.next();
    } while (localMessageRecord.extraflag != 0);
    if ((localMessageRecord.frienduin.equals(paramMessageRecord.frienduin)) && (localMessageRecord.istroop == paramMessageRecord.istroop) && (localMessageRecord.uniseq == paramMessageRecord.uniseq)) {
      bool = true;
    }
    for (;;)
    {
      break label44;
      return bool;
      label119:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != paramMessageRecord) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag != 0)) {
        break;
      }
      return true;
    }
  }
  
  protected void c(Message paramMessage)
  {
    paramMessage.nickName = b(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.post(new BaseMessageManagerForTroopAndDisc.3(this, paramMessageRecord, c(paramMessageRecord), l), 8, null, true);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "pullTroopMsgParallelInSilence, start...count:" + paramInt);
      }
      TroopMessageManager.b = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1).d(paramString, 1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    return;
    long l1 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      if (localMessageRecord.shmsgseq > 0L) {
        l1 = localMessageRecord.uniseq;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "aioMsgList size:" + ((List)localObject1).size());
      }
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1).a(paramString, 1, l1);
      int j;
      long l2;
      if (localObject1 == null)
      {
        l1 = 0L;
        localObject1 = a(paramString, 1, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "lastContinuedSeq:" + l1 + " locallist size:" + ((List)localObject1).size());
        }
        i = 0;
        if (((List)localObject1).isEmpty()) {
          break label688;
        }
        j = ((List)localObject1).size() - 1;
        l2 = l1;
        i = 0;
        label315:
        if (j < 0) {
          break label685;
        }
        if (l2 - ((MessageRecord)((List)localObject1).get(j)).shmsgseq <= 1L) {
          break label624;
        }
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        label357:
        long l3;
        long l5;
        boolean bool;
        if (paramInt - i < 0)
        {
          paramInt = 0;
          l3 = l4 - paramInt + 1L;
          l5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, 1);
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 0, delSeq = " + l5 + ", endSeq = " + l4 + ",beginSeq = " + l3 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L) {
            bool = false;
          }
          if (l4 > l5) {
            break label661;
          }
          bool = false;
          l1 = l3;
        }
        for (;;)
        {
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localObject2 = new ArrayList();
          a((List)localObject1, l2, (List)localObject2);
          ((List)localObject1).removeAll((Collection)localObject2);
          ((List)localObject2).clear();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 1, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
          }
          a(paramString, 1, (List)localObject1, l2, l4, bool);
          return;
          l1 = ((MessageRecord)localObject1).shmsgseq;
          break;
          label624:
          l2 = ((MessageRecord)((List)localObject1).get(j)).shmsgseq;
          i += 1;
          j -= 1;
          break label315;
          paramInt -= i;
          break label357;
          label661:
          if (l3 <= l5) {
            l1 = l5 + 1L;
          } else {
            l1 = l3;
          }
        }
        label685:
        continue;
        label688:
        l2 = l1;
      }
    }
  }
  
  protected void c(String paramString, int paramInt, long paramLong)
  {
    if ((paramString == null) || (paramLong < 0L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    Object localObject;
    do
    {
      do
      {
        return;
        localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        localRecentUser = localRecentUserProxy.a(paramString, paramInt);
      } while ((localRecentUser == null) || (!RecentUserAppearLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.msgType)));
      localObject = localRecentUser.msg;
    } while ((!(localObject instanceof AbstructRecentUserMsg)) || (((AbstructRecentUserMsg)localObject).a.a > paramLong));
    int i;
    if ((paramInt == 1) && ((localObject instanceof TroopNotificationMsg)))
    {
      localObject = TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if ((localObject != null) && (((TroopNotificationFlagMsg)localObject).a == 1))
      {
        i = 1;
        label132:
        if (i == 0)
        {
          if (TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
            break label324;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, cleanMsgAndMsgData");
          }
          localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
          localRecentUserProxy.b(localRecentUser);
        }
      }
    }
    for (;;)
    {
      ((TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramString, paramInt, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "cleanBizTypeMark TYPE_ALL_MSG type = " + paramInt + ", seqFrom = " + paramLong);
      }
      if (paramInt != 1) {
        break;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramString);
      if ((paramInt == 1) || (paramInt == 4)) {
        break;
      }
      RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localRecentUser);
      return;
      i = 0;
      break label132;
      label324:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, delRecentUser");
      }
      localRecentUserProxy.a(localRecentUser, false);
      continue;
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localRecentUserProxy.b(localRecentUser);
    }
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */