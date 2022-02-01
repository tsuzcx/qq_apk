package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class BaseMessageManagerForTroopAndDisc
  extends BaseMessageManager
{
  public static long a;
  protected static BaseMessageManagerForTroopAndDisc.Callback a;
  private MessageRecord a;
  
  static {}
  
  public BaseMessageManagerForTroopAndDisc(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  private int a(long paramLong, List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return 0;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((MessageRecord)paramList.get(i)).uniseq == paramLong) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private int a(List<MessageRecord> paramList)
  {
    int j = 0;
    int i = 0;
    while (j < paramList.size() - 1)
    {
      long l = ((MessageRecord)paramList.get(j)).shmsgseq;
      int k = j + 1;
      if (l != ((MessageRecord)paramList.get(k)).shmsgseq) {
        break;
      }
      int m = i + 1;
      j = k;
      i = m;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(m);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        j = k;
        i = m;
      }
    }
    return i;
  }
  
  private int a(List<MessageRecord> paramList, int paramInt)
  {
    int i = paramInt;
    while (paramInt < paramList.size() - 1)
    {
      long l = ((MessageRecord)paramList.get(paramInt)).shmsgseq;
      int j = paramInt + 1;
      if (l != ((MessageRecord)paramList.get(j)).shmsgseq) {
        break;
      }
      int k = i + 1;
      i = k;
      paramInt = j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(k);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        i = k;
        paramInt = j;
      }
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
          StringBuilder localStringBuilder2 = new StringBuilder();
          StringBuilder localStringBuilder1;
          if (localMessageRecord.getId() > 0L)
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("id&");
            paramLong = localMessageRecord.getId();
          }
          else
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("uniseq&");
            paramLong = localMessageRecord.uniseq;
          }
          localStringBuilder1.append(paramLong);
          localStringBuilder2.append(localStringBuilder1.toString());
          localStringBuilder2.append("&");
          localStringBuilder2.append(localMessageRecord.shmsgseq);
          localHashMap.put(localStringBuilder2.toString(), localMessageRecord);
        }
      }
      paramList.addAll(0, a(paramInt).a(paramString, paramInt, ((MessageRecord)paramList.get(0)).shmsgseq, localHashMap));
      return ((MessageRecord)paramList.get(0)).shmsgseq - 1L;
    }
    return paramLong;
  }
  
  private long a(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      boolean bool = paramList.hasNext();
      l = 0L;
      if (!bool) {
        break;
      }
      localMessageRecord = (MessageRecord)paramList.next();
    } while ((e(localMessageRecord)) || (localMessageRecord.shmsgseq <= 0L));
    long l = localMessageRecord.uniseq;
    return l;
  }
  
  private HashMap<String, MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      long l = a(paramList);
      MessageRecord localMessageRecord1 = a(paramInt).a(paramString, paramInt, l);
      if (localMessageRecord1 != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh find msg in cache id = ");
          paramString.append(localMessageRecord1.getId());
          paramString.append(", msg = ");
          paramString.append(localMessageRecord1.getLogColorContent());
          paramString.append(", uniseq = ");
          paramString.append(localMessageRecord1.uniseq);
          paramString.append(" , msgtime = ");
          paramString.append(localMessageRecord1.time);
          paramString.append(" , shMsgSeq = ");
          paramString.append(localMessageRecord1.shmsgseq);
          paramString.append(" , extra = ");
          paramString.append(localMessageRecord1.extraflag);
          QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
        }
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord2 = (MessageRecord)paramList.next();
            if (localMessageRecord2.shmsgseq == localMessageRecord1.shmsgseq)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (localMessageRecord2.getId() > 0L)
              {
                paramString = new StringBuilder();
                paramString.append("id&");
                l = localMessageRecord2.getId();
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append("uniseq&");
                l = localMessageRecord2.uniseq;
              }
              paramString.append(l);
              localStringBuilder.append(paramString.toString());
              localStringBuilder.append("&");
              localStringBuilder.append(localMessageRecord2.shmsgseq);
              localHashMap.put(localStringBuilder.toString(), localMessageRecord2);
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
    return localHashMap;
  }
  
  private void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (!MsgProxyUtils.a((MessageRecord)localObject2))
          {
            l1 = ((ChatMessage)localObject2).shmsgseq;
            break label73;
          }
        }
      }
      long l1 = 0L;
      label73:
      if ((l1 <= paramLong) && (paramLong != 0L) && (l1 != 0L))
      {
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
        localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
        localObject1 = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-4009);
        ((MessageRecord)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, -4009, paramInt, 0L);
        ((MessageRecord)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.addMessage(paramString, (String)localObject2, false, false);
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
      }
    }
  }
  
  public static void a(BaseMessageManagerForTroopAndDisc.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback = paramCallback;
  }
  
  private void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = paramMessageRecord2.isValid;
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.updateGroupMsgSeqAndTimeByUniseq(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
    if (paramMessageRecord2.msgtype == -2017)
    {
      byte[] arrayOfByte = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(paramMessageRecord2, paramMessageRecord1);
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.updateMsgContentByUniseq(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, arrayOfByte);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
    }
    if ((bool ^ true))
    {
      paramMessageRecord2.shmsgseq = paramMessageRecord1.shmsgseq;
      paramMessageRecord2.time = paramMessageRecord1.time;
      paramMessageRecord2.setExtraFlag(0);
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManager$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, null, paramMessageRecord2);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, long paramLong1, MessageRecord paramMessageRecord, int paramInt3, List<MessageRecord> paramList, long paramLong2, boolean paramBoolean)
  {
    boolean bool = paramList.isEmpty();
    long l = 0L;
    if (((bool) && (paramLong2 > 0L)) || ((!paramBoolean) && (paramList.size() < paramInt2)))
    {
      paramLong2 = a(paramString, paramInt1, paramList, paramLong2);
      BaseMsgProxy localBaseMsgProxy = a(paramInt1);
      if (paramMessageRecord == null) {
        paramLong1 = l;
      } else {
        paramLong1 = paramMessageRecord.getId();
      }
      paramString = localBaseMsgProxy.a(paramString, paramInt1, paramLong1, paramInt3, paramLong2, paramInt2 - paramList.size(), null);
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("refresh roam fail step 0 , size = ");
        paramMessageRecord.append(paramString.size());
        paramMessageRecord.append(",seq = ");
        paramMessageRecord.append(paramLong2);
        paramMessageRecord.append(" , timestamp = ");
        paramMessageRecord.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager", 2, paramMessageRecord.toString());
      }
      if (paramString.isEmpty()) {
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
      } else {
        paramList.addAll(0, paramString);
      }
      paramRefreshMessageContext.jdField_c_of_type_Boolean = true;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRefreshMessageContext = new StringBuilder();
      paramRefreshMessageContext.append("refresh roam addRoamMsgToList uniseq = ");
      paramRefreshMessageContext.append(paramLong1);
      paramRefreshMessageContext.append(" , locallist = ");
      paramRefreshMessageContext.append(paramList.size());
      paramRefreshMessageContext.append(" , timestamp = ");
      paramRefreshMessageContext.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, paramRefreshMessageContext.toString());
    }
    a(paramInt1).a(paramString, paramInt1, paramLong1, paramList);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2)
  {
    long l2 = ((MessageRecord)paramList1.get(0)).shmsgseq;
    int i = a(paramList1) + 1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh read cache and DB step 0, sameSeq = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(",itemListStartPoint = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", timestamp = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if (i > paramInt3) {
      paramList2.addAll(a(paramInt1).a(paramString, paramInt1, l2, paramHashMap));
    } else {
      paramList2.addAll(paramList1.subList(i, paramInt3));
    }
    paramInt3 = paramList2.size();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("refresh read cache and DB step 1, size = ");
      paramHashMap.append(paramList2.size());
      paramHashMap.append(", timestamp = ");
      paramHashMap.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, paramHashMap.toString());
    }
    long l1 = l2 - (paramInt2 - paramInt3);
    if (l1 < 0L) {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("getLocalListRefreshReadCacheAndDB() called with: beginSeq = [");
      paramHashMap.append(l1);
      paramHashMap.append("],endSeq=[");
      paramHashMap.append(l2);
      paramHashMap.append("]");
      QLog.d("Q.msg.BaseMessageManager", 2, paramHashMap.toString());
    }
    paramList2.addAll(0, a(paramInt1).c(paramString, paramInt1, l1, l2));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("refresh read cache and DB step 2, size = ");
      paramString.append(paramList2.size());
      paramString.append(", timestamp = ");
      paramString.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh read cache step 1, timestamp = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    int i = paramInt3 - paramInt2;
    long l = ((MessageRecord)paramList1.get(i)).shmsgseq;
    int j = b(paramList1, i);
    if (j == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh read cache step 2, timestamp = ");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      i = a(paramList1, i) + 1;
      if (i > paramInt3)
      {
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refresh read cache step 3, size = ");
          paramList1.append(paramList2.size());
          paramList1.append(", timestamp = ");
          paramList1.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, paramList1.toString());
        }
        paramList2.addAll(a(paramInt1).a(paramString, paramInt1, paramLong, paramHashMap));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 4, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
        }
      }
      else
      {
        paramList2.addAll(paramList1.subList(i, paramInt3));
        paramInt3 = paramList2.size();
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("refresh read cache step 5, size = ");
          paramHashMap.append(paramList2.size());
          paramHashMap.append(", timestamp = ");
          paramHashMap.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, paramHashMap.toString());
        }
        paramHashMap = a(paramInt1);
        paramLong = l - (paramInt2 - paramInt3);
        if (paramLong < 0L) {
          paramLong = 0L;
        }
        paramList2.addAll(0, paramHashMap.c(paramString, paramInt1, paramLong, l));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 6, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
        }
      }
    }
    else
    {
      paramList2.addAll(paramList1.subList(j, paramInt3));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refresh read cache step 7, size = ");
        paramString.append(paramList2.size());
        paramString.append(", timestamp = ");
        paramString.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
      }
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    if (paramInt == 3000)
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, Long.valueOf(paramString).longValue(), paramLong1, paramLong2, true, paramBundle);
      return;
    }
    if (paramInt == 1) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramLong1, paramLong2, true, paramBundle, 0);
    }
  }
  
  private void a(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((paramLong2 >= paramLong1) && (paramLong2 > 0L) && (paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh roam step 0 , timestamp = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(" beginSeq:");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(" endSeq:");
        ((StringBuilder)localObject).append(paramLong2);
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject).toString());
      }
      long l = paramLong2 - paramLong1;
      l /= 20L;
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("key_from_parallel_pull", true);
      ((Bundle)localObject).putBoolean("success", false);
      a(paramString, paramLong1, paramLong2, (Bundle)localObject, paramLong2);
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(false));
      b(paramList);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh roam step 4 , size = ");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(" , timestamp = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().containsKey(UinTypeUtil.a(paramString, paramInt))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().get(UinTypeUtil.a(paramString, paramInt))).booleanValue()))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
        paramList = new StringBuilder();
        paramList.append(", timestamp = ");
        paramList.append(System.currentTimeMillis());
        paramString.qLogColor("get auto pull msg when pull refresh !", paramList.toString());
      }
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
      StringBuilder localStringBuilder;
      if (localMessageRecord.shmsgseq < paramLong)
      {
        paramList2.add(localMessageRecord);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh breakpoint invalid: id = ");
          localStringBuilder.append(localMessageRecord.getId());
          localStringBuilder.append(", msg = ");
          localStringBuilder.append(localMessageRecord.getLogColorContent());
          localStringBuilder.append(" , msgtime = ");
          localStringBuilder.append(localMessageRecord.time);
          localStringBuilder.append(" , shMsgSeq = ");
          localStringBuilder.append(localMessageRecord.shmsgseq);
          localStringBuilder.append(" , extra = ");
          localStringBuilder.append(localMessageRecord.extraflag);
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh breakpoint valid: id = ");
        localStringBuilder.append(localMessageRecord.getId());
        localStringBuilder.append(", msg = ");
        localStringBuilder.append(localMessageRecord.getLogColorContent());
        localStringBuilder.append(" , msgtime = ");
        localStringBuilder.append(localMessageRecord.time);
        localStringBuilder.append(" , shMsgSeq = ");
        localStringBuilder.append(localMessageRecord.shmsgseq);
        localStringBuilder.append(" , extra = ");
        localStringBuilder.append(localMessageRecord.extraflag);
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.getId() < 0L)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("refresh insert db error ! , mr.msg = ");
        paramList.append(paramMessageRecord.getLogColorContent());
        paramList.append(" , mr.seq = ");
        paramList.append(paramMessageRecord.shmsgseq);
        paramList.append(" , mr.uniseq = ");
        paramList.append(paramMessageRecord.uniseq);
        paramList.append(" , extra = ");
        paramList.append(paramMessageRecord.extraflag);
        QLog.w("Q.msg.BaseMessageManager", 2, paramList.toString());
      }
    }
    else
    {
      MsgProxyUtils.c(paramList, paramMessageRecord, true);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("refresh roam step 3 , mr.msg = ");
        paramList.append(paramMessageRecord.getLogColorContent());
        paramList.append(" , mr.seq = ");
        paramList.append(paramMessageRecord.shmsgseq);
        paramList.append(" , mr.uniseq = ");
        paramList.append(paramMessageRecord.uniseq);
        paramList.append(" , extra = ");
        paramList.append(paramMessageRecord.extraflag);
        QLog.d("Q.msg.BaseMessageManager", 2, paramList.toString());
      }
    }
  }
  
  private void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, List<MessageRecord> paramList3)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList1.next();
      Object localObject = paramList3.iterator();
      do
      {
        boolean bool2 = ((Iterator)localObject).hasNext();
        bool1 = true;
        if (!bool2) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject).next(), localMessageRecord, false, true));
      break label78;
      boolean bool1 = false;
      label78:
      if ((!a(paramList2, paramList3, localMessageRecord, bool1)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh roam step 2 , mr.msg = ");
        ((StringBuilder)localObject).append(localMessageRecord.getLogColorContent());
        ((StringBuilder)localObject).append(" , mr.seq = ");
        ((StringBuilder)localObject).append(localMessageRecord.shmsgseq);
        ((StringBuilder)localObject).append(" , mr.msgtype = ");
        ((StringBuilder)localObject).append(localMessageRecord.msgtype);
        ((StringBuilder)localObject).append(", isExist = ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" , extra = ");
        ((StringBuilder)localObject).append(localMessageRecord.extraflag);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean a(int paramInt, RefreshMessageContext paramRefreshMessageContext, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
    a(paramRefreshMessageContext, paramInt);
    return true;
  }
  
  private boolean a(int paramInt, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean)
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
  
  private boolean a(RefreshMessageContext paramRefreshMessageContext, long paramLong, boolean paramBoolean)
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh roam msg rewrite sending msg  mr.senderuin: ");
        localStringBuilder.append(paramMessageRecord.senderuin);
        localStringBuilder.append(" mr.msgtype: ");
        localStringBuilder.append(paramMessageRecord.msgtype);
        localStringBuilder.append(" mr.frienduin: ");
        localStringBuilder.append(paramMessageRecord.frienduin);
        localStringBuilder.append(" mr.shmsgseq: ");
        localStringBuilder.append(paramMessageRecord.shmsgseq);
        localStringBuilder.append(" mr.time:");
        localStringBuilder.append(paramMessageRecord.time);
        localStringBuilder.append(" mr.msg: ");
        localStringBuilder.append(paramMessageRecord.getLogColorContent());
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_MqqAppAppRuntime.getAccount())))
      {
        paramList2 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getSendingTroopMsgItem(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramList2);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(i);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        paramInt = i;
      }
    }
    return paramInt;
  }
  
  /* Error */
  private void b(List<MessageRecord> paramList)
  {
    // Byte code:
    //   0: invokestatic 541	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokestatic 547	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6: ifeq +31 -> 37
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_1
    //   12: ldc2_w 548
    //   15: invokevirtual 555	java/lang/Object:wait	(J)V
    //   18: goto +12 -> 30
    //   21: astore_2
    //   22: goto +11 -> 33
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 558	java/lang/InterruptedException:printStackTrace	()V
    //   30: aload_1
    //   31: monitorexit
    //   32: return
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BaseMessageManagerForTroopAndDisc
    //   0	38	1	paramList	List<MessageRecord>
    //   21	1	2	localObject	Object
    //   25	11	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   11	18	21	finally
    //   26	30	21	finally
    //   30	32	21	finally
    //   33	35	21	finally
    //   11	18	25	java/lang/InterruptedException
  }
  
  private void b(List<MessageRecord> paramList1, long paramLong, List<MessageRecord> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      StringBuilder localStringBuilder;
      if (localMessageRecord.shmsgseq < paramLong)
      {
        paramList2.add(localMessageRecord);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh breakpoint invalid: id = ");
          localStringBuilder.append(localMessageRecord.getId());
          localStringBuilder.append(", msg = ");
          localStringBuilder.append(localMessageRecord.getLogColorContent());
          localStringBuilder.append(" , msgtime = ");
          localStringBuilder.append(localMessageRecord.time);
          localStringBuilder.append(" , shMsgSeq = ");
          localStringBuilder.append(localMessageRecord.shmsgseq);
          localStringBuilder.append(" , extra = ");
          localStringBuilder.append(localMessageRecord.extraflag);
          QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh breakpoint valid: id = ");
        localStringBuilder.append(localMessageRecord.getId());
        localStringBuilder.append(", msg = ");
        localStringBuilder.append(localMessageRecord.getLogColorContent());
        localStringBuilder.append(" , msgtime = ");
        localStringBuilder.append(localMessageRecord.time);
        localStringBuilder.append(" , shMsgSeq = ");
        localStringBuilder.append(localMessageRecord.shmsgseq);
        localStringBuilder.append(" , extra = ");
        localStringBuilder.append(localMessageRecord.extraflag);
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
    }
    paramList1.removeAll(paramList2);
    paramList2.clear();
    if (QLog.isColorLevel())
    {
      paramList2 = new StringBuilder();
      paramList2.append("refresh breakpoint step 1, size = ");
      paramList2.append(paramList1.size());
      paramList2.append(", timestamp = ");
      paramList2.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager", 2, paramList2.toString());
    }
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    List localList = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(paramMessageRecord);
    if ((paramMessageRecord.isLongMsg()) && (localList != null)) {
      paramMessageRecord = localList.iterator();
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
  
  private boolean e(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForUniteGrayTip;
  }
  
  public int a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearLimitCountHistory uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", needDeleteDB = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", delNum = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.clearHistory(paramString1, 1, false, false);
    Object localObject = null;
    if (1 == paramInt1) {
      localObject = String.format("shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    }
    if (paramBoolean1) {
      a(paramInt1).a(paramString1, paramInt1, paramString2, (String)localObject, null, null);
    }
    return i;
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  protected abstract String a(String paramString1, String paramString2);
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2;
    long l1;
    Object localObject4;
    Object localObject3;
    int i;
    if (paramInt2 > 0)
    {
      System.currentTimeMillis();
      localObject2 = a(paramInt1).d(paramString, paramInt1);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        l1 = a((List)localObject2);
        localObject4 = a(paramInt1).a(paramString, paramInt1, l1);
        localObject2 = a(paramString, paramInt1, (List)localObject2);
        localObject3 = a(paramInt1).b(paramString, paramInt1);
        i = a(l1, (List)localObject3);
      }
    }
    for (;;)
    {
      ArrayList localArrayList;
      long l2;
      try
      {
        localArrayList = new ArrayList();
        if (localObject4 == null) {
          l1 = 0L;
        } else {
          l1 = ((MessageRecord)localObject4).shmsgseq;
        }
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("refresh cache miss step 0, timestamp = ");
            ((StringBuilder)localObject3).append(System.currentTimeMillis());
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = a(paramInt1);
          l2 = l1 - paramInt2;
          if (l2 < 0L) {
            break label496;
          }
          break label499;
          Object localObject1;
          localArrayList.addAll(((BaseMsgProxy)localObject3).c(paramString, paramInt1, l2, localObject1));
          localArrayList.addAll(a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject2));
          if (!QLog.isColorLevel()) {
            break label524;
          }
          paramString = new StringBuilder();
          paramString.append("refresh cache miss step 1, timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, paramString.toString());
          break label524;
        }
        if (!QLog.isColorLevel()) {
          break label521;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("refresh read cache step 0, cacheIndex = ");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(" timestamp = ");
        ((StringBuilder)localObject4).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject4).toString());
        if (i >= paramInt2) {
          a(paramString, paramInt1, paramInt2, (HashMap)localObject2, (List)localObject3, i, localArrayList, l1);
        } else {
          a(paramString, paramInt1, paramInt2, (HashMap)localObject2, (List)localObject3, i, localArrayList);
        }
      }
      finally {}
      if (paramInt1 < localArrayList.size())
      {
        paramString = (MessageRecord)localArrayList.get(paramInt1);
        ((ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString.frienduin, paramString.senderuin);
        paramInt1 += 1;
      }
      else
      {
        return localArrayList;
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        return new ArrayList();
        paramString = new IllegalArgumentException("COUNT MUST > 0 !");
        for (;;)
        {
          throw paramString;
        }
        label496:
        l2 = 0L;
        label499:
        long l3 = l1 - 1L;
        if (l3 < 0L)
        {
          l3 = 0L;
          continue;
          label521:
          continue;
          label524:
          paramInt1 = 0;
        }
      }
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    List localList = a(paramInt).d(str, paramInt);
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
  
  public void a(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.post(new BaseMessageManagerForTroopAndDisc.4(this, paramMessageRecord, d(paramMessageRecord), l), 8, null, true);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    if ((!paramRefreshMessageContext.i) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(true));
    ThreadManager.executeOnNetWorkThread(new BaseMessageManagerForTroopAndDisc.5(this, paramRefreshMessageContext, paramString, paramInt, paramLong2, paramLong1, paramBoolean));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    long l4 = paramBundle.getLong("beginSeq", -1L);
    long l5 = paramBundle.getLong("endSeq", -1L);
    boolean bool2 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList;
    if ((paramInt == 1) && (bool2) && (paramList1 != null) && (!paramList1.isEmpty())) {
      localList = a(paramString, paramInt, paramList1.size());
    } else {
      localList = (List)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getPullCache().get(Integer.valueOf(paramBundle.getInt("counter")));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("refresh roam step 1 , result = ");
    int i;
    if (paramList1 == null) {
      i = -1;
    } else {
      i = paramList1.size();
    }
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" , success = ");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(" , beginSeq = ");
    ((StringBuilder)localObject2).append(l4);
    ((StringBuilder)localObject2).append(" , endSeq = ");
    ((StringBuilder)localObject2).append(l5);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" , time = [");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("]");
    ((IMessageFacade)localObject1).qLogColor((String)localObject2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getPullCache().remove(Integer.valueOf(paramBundle.getInt("counter")));
    if (localList != null)
    {
      if (paramList2 == null) {
        paramList2 = new ArrayList();
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = a(paramInt);
        long l1 = l4 - 15L;
        long l2 = 0L;
        if (l1 <= 0L) {
          l1 = 0L;
        }
        long l3 = l4 - 1L;
        if (l3 > 0L) {
          l2 = l3;
        }
        ((List)localObject1).addAll(((BaseMsgProxy)localObject2).c(paramString, paramInt, l1, l2));
        ((List)localObject1).addAll(localList);
        a(paramList1, paramList2, (List)localObject1);
      }
      paramBundle.putBoolean("success", bool1);
      if ((paramList2 != null) && (!paramList2.isEmpty())) {
        a(((MessageRecord)paramList2.get(0)).istroop).a(paramList2, null);
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        a(localList, (MessageRecord)paramList1.next());
      }
      try
      {
        localList.notify();
      }
      finally {}
    }
    if (bool2) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.clearInAioParallerPullMsgMark(paramString, l4, l5);
    }
  }
  
  public void a(String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    int j = -1;
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      MessageInfo localMessageInfo = localMessageRecord.mMessageInfo;
      if ((localMessageInfo != null) && (!localMessageRecord.isread))
      {
        boolean bool;
        if (localMessageRecord.istroop == 1) {
          bool = true;
        } else {
          bool = false;
        }
        RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser localRecentUser = localRecentUserProxy.a(paramString, localMessageRecord.istroop);
        if (localMessageInfo.a())
        {
          int k = localMessageInfo.a();
          if (MessageInfo.a(k, localRecentUser.msgType))
          {
            localRecentUser.msgType = k;
            localRecentUser.msg = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, localMessageInfo, localRecentUser.msg, localMessageRecord, bool);
            localRecentUserProxy.b(localRecentUser);
            j = localMessageRecord.istroop;
            i = 1;
          }
          if ((bool) && ((k == 24) || (k == 22)) && (jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localMessageRecord))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.getSubThreadHandler().post(new BaseMessageManagerForTroopAndDisc.2(this, localArrayList));
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("markAtOrReplyMeMsgInTroop_");
        paramArrayList.append(localArrayList.size());
        QLog.d("Q.msg.BaseMessageManager", 2, paramArrayList.toString());
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramString, j));
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cleanBizTypeMarkForMsgRevoke==>uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("|seqFrom:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Q.msg.BaseMessageManager.troop.revoked_troop_msg", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramLong >= 0L))
    {
      localObject = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).a(paramString, paramInt);
      return jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt, paramLong, (RecentUserProxy)localObject, localRecentUser);
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, List<MessageRecord> paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("refresh autopull step 0 , FAIL! , timestamp = ");
        paramString1.append(System.currentTimeMillis());
        QLog.w("Q.msg.BaseMessageManager", 2, paramString1.toString());
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().put(UinTypeUtil.a(paramString1, paramInt), Boolean.valueOf(true));
    paramString1 = a(paramInt).d(paramString1, paramInt);
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      paramList = MsgProxyUtils.a(paramList, true);
      int i;
      if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramInt = 0;
        while (paramInt < paramList.size())
        {
          if (((MessageRecord)paramList.get(paramInt)).shmsgseq > ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
            break label221;
          }
          paramInt += 1;
        }
        paramInt = 0;
        label221:
        paramList = paramList.subList(paramInt, paramList.size());
        if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq))
        {
          this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.addMessage(paramList, paramString2);
          return true;
        }
      }
      else
      {
        a(paramInt).a();
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.addMessage(paramList, paramString2);
      }
      return true;
    }
    return false;
  }
  
  protected abstract String b(String paramString1, String paramString2);
  
  public void b(Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt2 > 0)
    {
      Object localObject1 = a(paramInt1).d(paramString, paramInt1);
      if (a(paramInt1, paramRefreshMessageContext, (List)localObject1)) {
        return;
      }
      long l1 = a((List)localObject1);
      long l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (!((List)localObject1).isEmpty())
        {
          l1 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq + 1L;
          l2 = l1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doRefreshMessageListHead() called set tail headMsgUniseq = [");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append("]");
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
            l2 = l1;
          }
        }
      }
      boolean bool = a((List)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doRefreshMessageListHead() called with: uin = [");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], type = [");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("], count = [");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append("], context = [");
        ((StringBuilder)localObject1).append(paramRefreshMessageContext);
        ((StringBuilder)localObject1).append("], aio head msg headMsgUniseq = [");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("]");
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (a(paramInt1, paramRefreshMessageContext, bool)) {
        return;
      }
      Object localObject2 = a(paramInt1).a(paramString, paramInt1, l2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doRefreshMessageListHead() called with: aio head msg = [");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append("]");
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      long l3;
      if (localObject2 == null) {
        l3 = 0L;
      } else {
        l3 = ((MessageRecord)localObject2).shmsgseq;
      }
      l1 = l3;
      if (l3 == 0L) {
        l1 = l2;
      }
      int j;
      if (localObject2 == null) {
        j = 3;
      } else {
        j = ((MessageRecord)localObject2).versionCode;
      }
      localObject1 = a(paramString, paramInt1, paramInt2);
      Object localObject3;
      StringBuilder localStringBuilder;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        i = ((List)localObject1).size();
        l3 = l1;
        k = i - 1;
        i = 0;
        while (k >= 0)
        {
          localObject3 = (MessageRecord)((List)localObject1).get(k);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doRefreshMessageListHead() called with: messageRecord = [");
            localStringBuilder.append(localObject3);
            localStringBuilder.append("]");
            QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
          }
          if (!e((MessageRecord)localObject3))
          {
            if (l3 - ((MessageRecord)localObject3).shmsgseq > 1L) {
              break;
            }
            l3 = ((MessageRecord)localObject3).shmsgseq;
            i += 1;
          }
          k -= 1;
        }
      }
      else
      {
        l3 = l1;
        i = 0;
      }
      long l5 = l3 - 1L;
      int k = paramInt2 - i;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doRefreshMessageListHead() called with: localSize = [");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("], lastContinuedSeq = [");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append("], needSize = [");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append("], count = [");
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append("]");
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject3).toString());
      }
      int i = k;
      if (k < 0) {
        i = 0;
      }
      long l4 = l5 - i + 1L;
      long l6 = ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramString, paramInt1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("refresh breakpoint step 0, delSeq = ");
        ((StringBuilder)localObject3).append(l6);
        ((StringBuilder)localObject3).append(", endSeq = ");
        ((StringBuilder)localObject3).append(l5);
        ((StringBuilder)localObject3).append(",beginSeq = ");
        ((StringBuilder)localObject3).append(l4);
        ((StringBuilder)localObject3).append(",lastContinuedSeq = ");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append(",localSeqEnd = ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(", timestamp = ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject3).toString());
      }
      bool = a(paramRefreshMessageContext, l5, true);
      if (l5 <= l6)
      {
        paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        bool = false;
        l1 = l4;
      }
      else
      {
        l1 = l4;
        if (l4 <= l6) {
          l1 = l6 + 1L;
        }
      }
      if (l1 < 0L) {
        l1 = 0L;
      }
      b((List)localObject1, l1, new ArrayList());
      if ((!paramRefreshMessageContext.jdField_c_of_type_Boolean) && (l5 >= l1) && (l5 > 0L) && (bool))
      {
        localObject3 = new Bundle();
        i = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getPullCounter().addAndGet(1);
        ((Bundle)localObject3).putInt("counter", i);
        ((Bundle)localObject3).putBoolean("success", false);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getPullCache().put(Integer.valueOf(i), localObject1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh roam step 0 , timestamp = ");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
        }
        a(paramString, paramInt1, l1, l5, (Bundle)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
        b((List)localObject1);
        bool = ((Bundle)localObject3).getBoolean("success");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("refresh roam step 4 , size = ");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          ((StringBuilder)localObject3).append(" , timestamp = ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject3).toString());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().containsKey(UinTypeUtil.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getAutoPullCache().get(UinTypeUtil.a(paramString, paramInt1))).booleanValue()))
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(", timestamp = ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          paramString.qLogColor("get auto pull msg when pull refresh !", ((StringBuilder)localObject1).toString());
          paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
          a(paramRefreshMessageContext, paramInt1);
          return;
        }
      }
      else
      {
        bool = true;
      }
      a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, l2, (MessageRecord)localObject2, j, (List)localObject1, l5, bool);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("context.isLocalOnly = ");
        ((StringBuilder)localObject2).append(paramRefreshMessageContext.jdField_c_of_type_Boolean);
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, ((StringBuilder)localObject2).toString());
      }
      a((List)localObject1);
      a(paramInt1).a(paramString, paramInt1, (List)localObject1);
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refresh finish , context = ");
      ((StringBuilder)localObject2).append(paramRefreshMessageContext);
      ((StringBuilder)localObject2).append(" , size = ");
      if (localObject1 == null) {
        paramInt2 = -1;
      } else {
        paramInt2 = ((List)localObject1).size();
      }
      ((StringBuilder)localObject2).append(paramInt2);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(", timestamp = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      paramString.qLogColor((String)localObject1, ((StringBuilder)localObject2).toString());
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    paramString = new IllegalArgumentException("COUNT MUST > 0 !");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTroopUnread uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",from=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if (paramLong < 0L) {
      return;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.updateLastRead(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getLastMessage(paramString, paramInt));
  }
  
  public void c(Message paramMessage)
  {
    paramMessage.nickName = b(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pullTroopMsgParallelInSilence, start...count:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject1).toString());
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = a(1).d(paramString, 1);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if (localMessageRecord.shmsgseq > 0L)
        {
          l1 = localMessageRecord.uniseq;
          i = 1;
          break label142;
        }
      }
      long l1 = 0L;
      int i = 0;
      label142:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("aioMsgList size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject2).toString());
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        return;
      }
      localObject1 = a(1).a(paramString, 1, l1);
      if (localObject1 == null) {
        l1 = 0L;
      } else {
        l1 = ((MessageRecord)localObject1).shmsgseq;
      }
      localObject1 = a(paramString, 1, paramInt);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastContinuedSeq:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" locallist size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject2).toString());
      }
      long l3;
      if (!((List)localObject1).isEmpty())
      {
        int j = ((List)localObject1).size() - 1;
        l2 = l1;
        i = 0;
        while ((j >= 0) && (l2 - ((MessageRecord)((List)localObject1).get(j)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(j)).shmsgseq;
          i += 1;
          j -= 1;
        }
        l3 = l2;
      }
      else
      {
        l3 = l1;
        i = 0;
      }
      long l4 = l3 - 1L;
      paramInt -= i;
      if (paramInt < 0) {
        paramInt = 0;
      }
      long l2 = l4 - paramInt + 1L;
      long l5 = ((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a(paramString, 1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refresh breakpoint step 0, delSeq = ");
        ((StringBuilder)localObject2).append(l5);
        ((StringBuilder)localObject2).append(", endSeq = ");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append(",beginSeq = ");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append(",lastContinuedSeq = ");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append(",localSeqEnd = ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(", timestamp = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject2).toString());
      }
      boolean bool;
      if (l4 <= 0L) {
        bool = false;
      } else {
        bool = true;
      }
      if (l4 <= l5)
      {
        bool = false;
        l1 = l2;
      }
      else
      {
        l1 = l2;
        if (l2 <= l5) {
          l1 = l5 + 1L;
        }
      }
      l2 = 0L;
      if (l1 < 0L) {
        l1 = l2;
      }
      localObject2 = new ArrayList();
      a((List)localObject1, l1, (List)localObject2);
      ((List)localObject1).removeAll((Collection)localObject2);
      ((List)localObject2).clear();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refresh breakpoint step 1, size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append(", timestamp = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject2).toString());
      }
      a(paramString, 1, (List)localObject1, l1, l4, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
  }
  
  protected void c(String paramString, int paramInt, long paramLong)
  {
    if ((paramString != null) && (paramLong >= 0L))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
        return;
      }
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      RecentUser localRecentUser = localRecentUserProxy.a(paramString, paramInt);
      jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade, this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade, paramString, paramInt, paramLong, localRecentUserProxy, localRecentUser);
    }
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject == null) {
      return false;
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMessageManagerForTroopAndDisc$Callback.a((MessageRecord)localObject);
    if ((paramMessageRecord.isLongMsg()) && (localObject != null))
    {
      localObject = ((List)localObject).iterator();
      for (boolean bool = false; ((Iterator)localObject).hasNext(); bool = true)
      {
        label41:
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.extraflag != 0) {
          return false;
        }
        if ((!localMessageRecord.frienduin.equals(paramMessageRecord.frienduin)) || (localMessageRecord.istroop != paramMessageRecord.istroop) || (localMessageRecord.uniseq != paramMessageRecord.uniseq)) {
          break label41;
        }
      }
      return bool;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    return (localObject == paramMessageRecord) && (((MessageRecord)localObject).extraflag == 0);
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.post(new BaseMessageManagerForTroopAndDisc.3(this, paramMessageRecord, d(paramMessageRecord), l), 8, null, true);
  }
  
  public void h(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */