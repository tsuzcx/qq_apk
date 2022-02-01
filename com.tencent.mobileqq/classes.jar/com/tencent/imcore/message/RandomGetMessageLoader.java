package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

class RandomGetMessageLoader
{
  public BaseMessageManagerForTroopAndDisc a;
  
  public RandomGetMessageLoader(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc)
  {
    this.a = paramBaseMessageManagerForTroopAndDisc;
  }
  
  private int a(List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (paramInt1 < paramInt2)
    {
      long l = ((MessageRecord)paramList.get(paramInt1)).shmsgseq;
      int j = paramInt1 + 1;
      if (l != ((MessageRecord)paramList.get(j)).shmsgseq) {
        break;
      }
      int k = i + 1;
      i = k;
      paramInt1 = j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(k);
        QLog.d("RandomGetMessageLoader", 2, localStringBuilder.toString());
        i = k;
        paramInt1 = j;
      }
    }
    return i;
  }
  
  private long a(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong)
  {
    if (!paramList.isEmpty())
    {
      long l = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq == l)
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
      paramList.addAll(this.a.a(paramInt).a(paramString, paramInt, l, localHashMap));
      paramLong = l + 1L;
    }
    return paramLong;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, long paramLong1, MessageRecord paramMessageRecord, int paramInt3, List<MessageRecord> paramList, long paramLong2, boolean paramBoolean)
  {
    boolean bool = paramList.isEmpty();
    long l = 0L;
    if (((bool) && (paramLong2 > 0L)) || ((!paramBoolean) && (paramList.size() < paramInt2)))
    {
      paramLong2 = a(paramString, paramInt1, paramList, paramLong2);
      BaseMsgProxy localBaseMsgProxy = this.a.a(paramInt1);
      if (paramMessageRecord == null) {
        paramLong1 = l;
      } else {
        paramLong1 = paramMessageRecord.getId();
      }
      paramString = localBaseMsgProxy.b(paramString, paramInt1, paramLong1, paramInt3, paramLong2, paramInt2 - paramList.size(), null);
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("refresh roam fail step 0 , size = ");
        paramMessageRecord.append(paramString.size());
        paramMessageRecord.append(",seq = ");
        paramMessageRecord.append(paramLong2);
        paramMessageRecord.append(" , timestamp = ");
        paramMessageRecord.append(System.currentTimeMillis());
        QLog.d("RandomGetMessageLoader", 2, paramMessageRecord.toString());
      }
      if (paramString.isEmpty())
      {
        paramRefreshMessageContext.c = true;
        return;
      }
      paramList.addAll(paramString);
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
      QLog.d("RandomGetMessageLoader", 2, paramRefreshMessageContext.toString());
    }
    this.a.a(paramInt1).a(paramString, paramInt1, paramLong1, paramLong2, paramList);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, List<MessageRecord> paramList1, int paramInt3, int paramInt4, List<MessageRecord> paramList2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLocalListRefreshReadCache refresh read cache step 1, timestamp = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("RandomGetMessageLoader", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramInt3 + paramInt2 - 1;
    long l3 = ((MessageRecord)paramList1.get(i)).shmsgseq;
    int j = a(paramList1, i, paramInt4);
    Object localObject = this.a.a(paramInt1).g(paramString, paramInt1);
    if (j == paramInt4)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh read cache step 2, timestamp = ");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("RandomGetMessageLoader", 2, localStringBuilder.toString());
      }
      paramInt4 = b(paramList1, i, paramInt3);
      if (paramInt4 <= paramInt3)
      {
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refresh read cache step 3, size = ");
          paramList1.append(paramList2.size());
          paramList1.append(", timestamp = ");
          paramList1.append(System.currentTimeMillis());
          QLog.d("RandomGetMessageLoader", 2, paramList1.toString());
        }
        paramList1 = b(paramString, paramInt1, (List)localObject, l3);
        paramList2.addAll(this.a.a(paramInt1).a(paramString, paramInt1, l3, paramList1));
        if (l3 == paramLong - 1L)
        {
          paramList1 = b(paramString, paramInt1, (List)localObject, paramLong);
          paramList2.addAll(this.a.a(paramInt1).a(paramString, paramInt1, paramLong, paramList1));
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 4, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("RandomGetMessageLoader", 2, paramString.toString());
        }
      }
      else
      {
        paramList2.addAll(paramList1.subList(paramInt3, paramInt4));
        paramInt3 = paramList2.size();
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refresh read cache step 5, size = ");
          paramList1.append(paramList2.size());
          paramList1.append(", timestamp = ");
          paramList1.append(System.currentTimeMillis());
          QLog.d("RandomGetMessageLoader", 2, paramList1.toString());
        }
        long l2 = paramInt2 - paramInt3 + l3 - 1L;
        long l1 = l2;
        if (l2 >= paramLong) {
          l1 = paramLong - 1L;
        }
        if (l1 < 0L) {
          l1 = 0L;
        }
        if (l3 > l1) {
          return;
        }
        paramList2.addAll(this.a.a(paramInt1).c(paramString, paramInt1, l3, l1));
        if (l1 == paramLong - 1L)
        {
          paramList1 = b(paramString, paramInt1, (List)localObject, paramLong);
          paramList2.addAll(this.a.a(paramInt1).a(paramString, paramInt1, paramLong, paramList1));
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 6, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("RandomGetMessageLoader", 2, paramString.toString());
        }
      }
    }
    else
    {
      paramList2.addAll(paramList1.subList(paramInt3, j + 1));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refresh read cache step 7, size = ");
        paramString.append(paramList2.size());
        paramString.append(", timestamp = ");
        paramString.append(System.currentTimeMillis());
        QLog.d("RandomGetMessageLoader", 2, paramString.toString());
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      HashMap localHashMap = new HashMap();
      int m = paramList.size();
      Object localObject2 = "";
      Object localObject1 = localObject2;
      int j = 0;
      int k;
      for (int i = 0; j < m; i = k)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(j);
        Object localObject3;
        if (!localMessageRecord.isLongMsg())
        {
          localObject3 = localObject2;
          k = i;
        }
        else
        {
          String str1 = UinTypeUtil.a(localMessageRecord);
          if (localHashMap.containsKey(str1))
          {
            if (Math.abs(((MessageRecord)((ArrayList)localHashMap.get(str1)).get(0)).time - localMessageRecord.time) <= 480L)
            {
              ((ArrayList)localHashMap.get(str1)).add(localMessageRecord);
            }
            else
            {
              i += 1;
              String str2 = UinTypeUtil.b(str1, i);
              localHashMap.put(str2, localHashMap.get(str1));
              Object localObject4;
              if (TextUtils.equals((CharSequence)localObject2, str1))
              {
                localObject4 = str2;
                localObject3 = localObject1;
              }
              else
              {
                localObject4 = localObject2;
                localObject3 = localObject1;
                if (TextUtils.equals((CharSequence)localObject1, str1))
                {
                  localObject3 = str2;
                  localObject4 = localObject2;
                }
              }
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).add(localMessageRecord);
              localHashMap.put(str1, localObject1);
              localObject2 = localObject4;
              localObject1 = localObject3;
            }
          }
          else
          {
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(localMessageRecord);
            localHashMap.put(str1, localObject3);
          }
          if (j == 0)
          {
            localObject3 = str1;
            k = i;
          }
          else
          {
            localObject3 = localObject2;
            k = i;
            if (j == m - 1)
            {
              localObject1 = str1;
              k = i;
              localObject3 = localObject2;
            }
          }
        }
        j += 1;
        localObject2 = localObject3;
      }
      a(paramList, (ArrayList)localHashMap.get(localObject2));
      a(paramList, (ArrayList)localHashMap.get(localObject1));
    }
  }
  
  private void a(List<MessageRecord> paramList1, long paramLong, List<MessageRecord> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      StringBuilder localStringBuilder;
      if (localMessageRecord.shmsgseq > paramLong)
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
          QLog.d("RandomGetMessageLoader", 2, localStringBuilder.toString());
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
        QLog.d("RandomGetMessageLoader", 2, localStringBuilder.toString());
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
      QLog.d("RandomGetMessageLoader", 2, paramList2.toString());
    }
  }
  
  private void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    QLog.d("RandomGetMessageLoader", 1, "doRemoveIncompleteLongMsg");
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (((MessageRecord)paramArrayList.get(0)).longMsgCount > paramArrayList.size())
      {
        if (((MessageRecord)paramArrayList.get(0)).isSendFromLocal()) {
          return;
        }
        QLog.d("RandomGetMessageLoader", 1, "doRemoveIncompleteLongMsg find incomplete msg");
        paramList.removeAll(paramArrayList);
      }
    }
  }
  
  private boolean a(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    paramString = this.a.a(paramInt1).g(paramString, paramInt1);
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return false;
      }
      int m = paramString.size();
      paramInt1 = 0;
      int i = 0;
      int j = -1;
      while (paramInt1 < m)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.get(paramInt1);
        if (QLog.isColorLevel())
        {
          long l = localMessageRecord.shmsgseq;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(", msg detail: ");
          localStringBuilder.append(localMessageRecord);
          QLog.d("RandomGetMessageLoader", 2, new Object[] { "isLoadSuccess curIndex: ", Integer.valueOf(paramInt1), ", curMsg shmsgseq: ", Long.valueOf(l), localStringBuilder.toString() });
        }
        int k;
        if (MsgProxyUtils.a(localMessageRecord))
        {
          QLog.d("RandomGetMessageLoader", 1, new Object[] { "isLoadSuccess filter local troop msg: ", localMessageRecord });
          k = i;
        }
        else
        {
          if (localMessageRecord.shmsgseq == paramLong2)
          {
            QLog.d("RandomGetMessageLoader", 1, new Object[] { "isLoadSuccess loadCount: ", Integer.valueOf(i), ", lastIndex: ", Integer.valueOf(j) });
            if (i >= paramInt2) {
              return true;
            }
            return (j >= 0) && (((MessageRecord)paramString.get(j)).shmsgseq >= paramLong2 - 1L);
          }
          k = i;
          if (localMessageRecord.shmsgseq >= paramLong1)
          {
            k = i + 1;
            j = paramInt1;
          }
        }
        paramInt1 += 1;
        i = k;
      }
    }
    return false;
  }
  
  private int b(List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = i;
    while ((i >= paramInt2 + 1) && (((MessageRecord)paramList.get(i)).shmsgseq == ((MessageRecord)paramList.get(i - 1)).shmsgseq))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(paramInt1);
        QLog.d("RandomGetMessageLoader", 2, localStringBuilder.toString());
      }
      j -= 1;
      i -= 1;
    }
    return j;
  }
  
  private MessageRecord b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return (MessageRecord)paramList.get(0);
    }
    return null;
  }
  
  private HashMap<String, MessageRecord> b(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      MessageRecord localMessageRecord1 = this.a.a(paramInt).b(paramString, paramInt, paramLong);
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
          QLog.d("RandomGetMessageLoader", 2, paramString.toString());
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
                paramLong = localMessageRecord2.getId();
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append("uniseq&");
                paramLong = localMessageRecord2.uniseq;
              }
              paramString.append(paramLong);
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
        QLog.w("RandomGetMessageLoader", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.w("RandomGetMessageLoader", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
    return localHashMap;
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, List<MessageRecord> paramList1, int paramInt3, int paramInt4, List<MessageRecord> paramList2, long paramLong)
  {
    long l1 = ((MessageRecord)paramList1.get(paramInt4)).shmsgseq;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLocalListRefreshReadCacheAndDB refresh read cache and DB step 0, sameSeq = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", timestamp = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("RandomGetMessageLoader", 2, ((StringBuilder)localObject).toString());
    }
    paramList2.addAll(paramList1.subList(paramInt3, paramInt4 + 1));
    paramList1 = this.a.a(paramInt1).g(paramString, paramInt1);
    Object localObject = b(paramString, paramInt1, paramList1, l1);
    paramList2.addAll(this.a.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject));
    paramInt3 = paramList2.size();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh read cache and DB step 1, size = ");
      ((StringBuilder)localObject).append(paramList2.size());
      ((StringBuilder)localObject).append(", timestamp = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("RandomGetMessageLoader", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = l1 + 1L;
    long l3 = paramInt2 - paramInt3 + l2 - 1L;
    if (l2 < 0L) {
      l2 = 0L;
    }
    l1 = l3;
    if (l3 >= paramLong) {
      l1 = paramLong - 1L;
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    if (l2 > l1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLocalListRefreshReadCacheAndDB() called with: beginSeq = [");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("],endSeq=[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.d("RandomGetMessageLoader", 2, ((StringBuilder)localObject).toString());
    }
    paramList2.addAll(this.a.a(paramInt1).c(paramString, paramInt1, l2, l1));
    if (l1 == paramLong - 1L)
    {
      paramList1 = b(paramString, paramInt1, paramList1, paramLong);
      paramList2.addAll(this.a.a(paramInt1).a(paramString, paramInt1, paramLong, paramList1));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("refresh read cache and DB step 2, size = ");
      paramString.append(paramList2.size());
      paramString.append(", timestamp = ");
      paramString.append(System.currentTimeMillis());
      QLog.d("RandomGetMessageLoader", 2, paramString.toString());
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject;
    ArrayList localArrayList;
    long l2;
    long l1;
    if (paramInt2 > 0)
    {
      localObject = this.a.a(paramInt1).g(paramString, paramInt1);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localArrayList = new ArrayList();
        l2 = paramLong1 + paramInt2 - 1L;
        l1 = l2;
        if (l2 >= paramLong2) {
          l1 = paramLong2 - 1L;
        }
        if (paramLong1 >= 0L) {
          l2 = paramLong1;
        } else {
          l2 = 0L;
        }
        if (l1 < 0L) {
          l1 = 0L;
        }
        QLog.d("RandomGetMessageLoader", 1, new Object[] { "getLocalList startSeq:", Long.valueOf(l2), ", endSeq: ", Long.valueOf(l1) });
        if (l2 > l1) {}
      }
    }
    label676:
    label685:
    label697:
    for (;;)
    {
      int i;
      try
      {
        List localList = this.a.a(paramInt1).c(paramString, paramInt1);
        if ((localList == null) || (localList.isEmpty())) {
          break label685;
        }
        int m = localList.size();
        paramLong1 = 0L;
        i = 0;
        int j = -1;
        int k = -1;
        n = j;
        l3 = paramLong1;
        i1 = k;
        if (i < m)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if (j == -1)
          {
            if (localMessageRecord.uniseq != l2) {
              break label676;
            }
            paramLong1 = localMessageRecord.uniseq;
            j = i;
            k = j;
            break label676;
          }
          n = j;
          l3 = paramLong1;
          i1 = k;
          if (localMessageRecord.uniseq <= l1) {
            if (localMessageRecord.uniseq - paramLong1 > 1L)
            {
              n = j;
              l3 = paramLong1;
              i1 = k;
            }
            else
            {
              paramLong1 = localMessageRecord.uniseq;
              k = i;
              break label676;
            }
          }
        }
        QLog.d("RandomGetMessageLoader", 1, new Object[] { "getLocalList startCacheIndex:", Integer.valueOf(n), ", endCacheIndex: ", Integer.valueOf(i1), ", lastContinueSeq: ", Long.valueOf(l3) });
        if (n == -1)
        {
          localArrayList.addAll(this.a.a(paramInt1).c(paramString, paramInt1, l2, l1));
          if (l1 != paramLong2 - 1L) {
            break label697;
          }
          localObject = b(paramString, paramInt1, (List)localObject, paramLong2);
          localArrayList.addAll(this.a.a(paramInt1).a(paramString, paramInt1, paramLong2, (Map)localObject));
          break label697;
        }
        if (i1 - n + 1 >= paramInt2) {
          a(paramString, paramInt1, paramInt2, localList, n, i1, localArrayList, paramLong2);
        } else {
          b(paramString, paramInt1, paramInt2, localList, n, i1, localArrayList, paramLong2);
        }
      }
      finally {}
      QLog.d("RandomGetMessageLoader", 1, new Object[] { "getLocalList localList size:", Integer.valueOf(localArrayList.size()) });
      if (QLog.isColorLevel())
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          QLog.d("RandomGetMessageLoader", 2, new Object[] { "getLocalList item shmsgseq :", Long.valueOf(((MessageRecord)localObject).shmsgseq), ", item detail: ", localObject });
        }
      }
      return localArrayList;
      if (QLog.isColorLevel()) {
        QLog.w("RandomGetMessageLoader", 2, "getLocalList refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
      paramString = new IllegalArgumentException("COUNT MUST > 0 !");
      for (;;)
      {
        throw paramString;
      }
      i += 1;
      continue;
      long l3 = 0L;
      int n = -1;
      int i1 = -1;
    }
  }
  
  void a(Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    long l = paramBundle.getLong("endTime", 0L) - paramBundle.getLong("pullUpStartTime", 0L);
    paramBundle = new HashMap();
    paramBundle.put("reqDuration", String.valueOf(l));
    paramBundle.put("count", String.valueOf(paramInt));
    paramBundle.put("success", String.valueOf(paramBoolean));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration = ");
    localStringBuilder.append(l);
    localStringBuilder.append(" count = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" success = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("RandomGetMessageLoader", 1, localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRefreshTroopHeadPullUp", true, 0L, 0L, paramBundle, "");
  }
  
  void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    if ((paramRefreshMessageContext.b != null) && (paramRefreshMessageContext.b.size() > 0))
    {
      QLog.d("RandomGetMessageLoader", 1, new Object[] { "refreshHeadComplete refresh list size:", Integer.valueOf(paramRefreshMessageContext.b.size()) });
      synchronized (paramRefreshMessageContext.b)
      {
        BaseMessageManagerForTroopAndDisc.e.a(paramInt, paramRefreshMessageContext.b, this.a.a);
        if (paramRefreshMessageContext.b.size() > 0) {
          MsgProxyUtils.a(paramRefreshMessageContext.p, paramRefreshMessageContext.q, paramRefreshMessageContext.b, (MessageCache)this.a.a.getMsgCache());
        }
      }
    }
    paramRefreshMessageContext.l = 0;
    paramRefreshMessageContext.m = 0;
    if (paramRefreshMessageContext.h) {
      this.a.b.setChangeAndNotify(paramRefreshMessageContext);
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean)
  {
    QLog.d("RandomGetMessageLoader", 1, new Object[] { "doRefreshMessageListHead uin: ", paramString, ", type:", Integer.valueOf(paramInt1), ", firstSeq:", Long.valueOf(paramLong1), ", count:", Integer.valueOf(paramInt2), ", blockCStartSeq:", Long.valueOf(paramLong2) });
    if (paramInt2 > 0)
    {
      Object localObject1 = this.a.a(paramInt1).g(paramString, paramInt1);
      if (this.a.a(paramInt1, paramRefreshMessageContext, (List)localObject1)) {
        return;
      }
      localObject1 = a(paramString, paramInt1, paramInt2, paramLong1, paramLong2);
      MessageRecord localMessageRecord = b((List)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doRefreshMessageListHead() called with: aio head msg = [");
      ((StringBuilder)localObject2).append(localMessageRecord);
      ((StringBuilder)localObject2).append("]");
      QLog.d("RandomGetMessageLoader", 1, ((StringBuilder)localObject2).toString());
      long l1 = paramLong1 - 1L;
      int j;
      if (localMessageRecord == null) {
        j = 3;
      } else {
        j = localMessageRecord.versionCode;
      }
      int i;
      Object localObject3;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        int m = ((List)localObject1).size();
        l2 = l1;
        k = 0;
        i = 0;
        while (k < m)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(k);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("doRefreshMessageListHead() called with: messageRecord = [");
            ((StringBuilder)localObject3).append(localObject2);
            ((StringBuilder)localObject3).append("]");
            QLog.d("RandomGetMessageLoader", 2, ((StringBuilder)localObject3).toString());
          }
          if (!this.a.k((MessageRecord)localObject2))
          {
            if (((MessageRecord)localObject2).shmsgseq - l2 > 1L) {
              break;
            }
            l2 = ((MessageRecord)localObject2).shmsgseq;
            i += 1;
            if (QLog.isColorLevel()) {
              QLog.d("RandomGetMessageLoader", 2, new Object[] { "doRefreshMessageListHead() find continue seq:", Long.valueOf(l2), ", localSize: ", Integer.valueOf(i) });
            }
          }
          k += 1;
        }
        l3 = l1;
        l1 = l2;
        l2 = l3;
      }
      else
      {
        l3 = l1;
        i = 0;
        l2 = l1;
        l1 = l3;
      }
      int k = Math.max(paramInt2 - i, 0);
      long l4 = l1 + 1L;
      long l3 = k + l4 - 1L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doRefreshMessageListHead() called with: localSize = [");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("], lastContinuedSeq = [");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], needSize = [");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("], count = [");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("]");
      QLog.d("RandomGetMessageLoader", 1, ((StringBuilder)localObject2).toString());
      long l5 = ((MessageCache)this.a.a.getMsgCache()).b(paramString, paramInt1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refresh breakpoint step 0, delSeq = ");
      ((StringBuilder)localObject2).append(l5);
      ((StringBuilder)localObject2).append(", endSeq = ");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(",beginSeq = ");
      ((StringBuilder)localObject2).append(l4);
      ((StringBuilder)localObject2).append(",lastContinuedSeq = ");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(",localSeqEnd = ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(", timestamp = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      QLog.d("RandomGetMessageLoader", 1, ((StringBuilder)localObject2).toString());
      boolean bool2 = this.a.a(paramRefreshMessageContext, l3, true);
      boolean bool1;
      if (l3 <= l5)
      {
        paramRefreshMessageContext.c = true;
        bool1 = false;
      }
      else
      {
        bool1 = bool2;
        if (l4 <= l5)
        {
          l2 = l5 + 1L;
          bool1 = bool2;
          break label768;
        }
      }
      long l2 = l4;
      label768:
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = paramLong2 - 1L;
      if (l1 > l2)
      {
        paramLong2 = l1;
        bool1 = false;
        l1 = l3;
      }
      else
      {
        paramLong2 = Math.min(l1, l2);
        l1 = Math.min(l3, l2);
      }
      QLog.d("RandomGetMessageLoader", 1, new Object[] { "doRefreshMessageListHead roam request beginSeq:", Long.valueOf(paramLong2), ", endSeq:", Long.valueOf(l1), ", needPullMsg:", Boolean.valueOf(bool1) });
      a((List)localObject1, l1, new ArrayList());
      if ((l1 >= paramLong2) && (l1 > 0L) && (bool1))
      {
        paramRefreshMessageContext.t = true;
        Object localObject4 = new Bundle();
        i = this.a.b.getPullCounter().addAndGet(1);
        ((Bundle)localObject4).putInt("counter", i);
        ((Bundle)localObject4).putBoolean("success", false);
        ((Bundle)localObject4).putInt("load_count", paramInt2);
        ((Bundle)localObject4).putBoolean("troop_unread_jump_opt", true);
        ((Bundle)localObject4).putLong("pullUpStartTime", System.currentTimeMillis());
        this.a.b.getPullCache().put(Integer.valueOf(i), localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refresh roam step 0 , timestamp = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("RandomGetMessageLoader", 1, ((StringBuilder)localObject2).toString());
        BaseMessageManagerForTroopAndDisc localBaseMessageManagerForTroopAndDisc = this.a;
        localObject2 = paramRefreshMessageContext;
        localObject3 = localObject1;
        localBaseMessageManagerForTroopAndDisc.a(paramString, paramInt1, paramLong2, l1, (Bundle)localObject4);
        this.a.b.getAutoPullCache().put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
        this.a.b((List)localObject3);
        bool1 = ((Bundle)localObject4).getBoolean("success");
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("refresh roam step 4 , size = ");
        ((StringBuilder)localObject4).append(((List)localObject3).size());
        ((StringBuilder)localObject4).append(" , timestamp = ");
        ((StringBuilder)localObject4).append(System.currentTimeMillis());
        QLog.d("RandomGetMessageLoader", 1, ((StringBuilder)localObject4).toString());
        if ((this.a.b.getAutoPullCache().containsKey(UinTypeUtil.a(paramString, paramInt1))) && (((Boolean)this.a.b.getAutoPullCache().get(UinTypeUtil.a(paramString, paramInt1))).booleanValue()))
        {
          paramString = this.a.b;
          paramRefreshMessageContext = new StringBuilder();
          paramRefreshMessageContext.append(", timestamp = ");
          paramRefreshMessageContext.append(System.currentTimeMillis());
          paramString.qLogColor("get auto pull msg when pull refresh !", paramRefreshMessageContext.toString());
          ((RefreshMessageContext)localObject2).b = null;
          a((RefreshMessageContext)localObject2, paramInt1);
          return;
        }
      }
      else
      {
        bool1 = true;
      }
      localObject2 = localObject1;
      localObject1 = paramRefreshMessageContext;
      a((List)localObject2);
      a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramLong1, localMessageRecord, j, (List)localObject2, l1, bool1);
      QLog.d("RandomGetMessageLoader.trooptroop_pull_msg", 1, new Object[] { "context.isLocalOnly = ", Boolean.valueOf(((RefreshMessageContext)localObject1).e), ", isNeedNotify = ", Boolean.valueOf(paramBoolean) });
      this.a.a((List)localObject2);
      if (paramBoolean)
      {
        QLog.d("RandomGetMessageLoader", 1, new Object[] { "doRefreshMessageListHead add message to aio list, size: ", Integer.valueOf(((List)localObject2).size()) });
        paramRefreshMessageContext = this.a;
        paramInt2 = paramInt1;
        paramRefreshMessageContext.a(paramInt2).c(paramString, paramInt2, (List)localObject2);
      }
      ((RefreshMessageContext)localObject1).b = ((List)localObject2);
      paramString = this.a.b;
      paramRefreshMessageContext = new StringBuilder();
      paramRefreshMessageContext.append("refresh finish , context = ");
      paramRefreshMessageContext.append(localObject1);
      paramRefreshMessageContext.append(" , size = ");
      if (localObject2 == null) {
        paramInt2 = -1;
      } else {
        paramInt2 = ((List)localObject2).size();
      }
      paramRefreshMessageContext.append(paramInt2);
      paramRefreshMessageContext = paramRefreshMessageContext.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(", timestamp = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      paramString.qLogColor(paramRefreshMessageContext, ((StringBuilder)localObject2).toString());
      a((RefreshMessageContext)localObject1, paramInt1);
      return;
    }
    paramString = new IllegalArgumentException("COUNT MUST > 0 !");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, RefreshMessageContext paramRefreshMessageContext, int paramInt2, long paramLong3, boolean paramBoolean2)
  {
    String str = LogUtil.wrapLogUin(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", isNeedNotify:");
    localStringBuilder.append(paramBoolean2);
    QLog.d("RandomGetMessageLoader", 1, new Object[] { "refreshTroopUnreadMessage uin: ", str, ", type:", Integer.valueOf(paramInt1), ", beginSeq:", Long.valueOf(paramLong1), ", unreadseq:", Long.valueOf(paramLong2), ", needInsertTips:", Boolean.valueOf(paramBoolean1), ", count:", Integer.valueOf(paramInt2), ", blockCStartSeq:", Long.valueOf(paramLong3), localStringBuilder.toString() });
    paramRefreshMessageContext.h = false;
    paramRefreshMessageContext.f = true;
    paramRefreshMessageContext.p = paramString;
    paramRefreshMessageContext.q = paramInt1;
    paramRefreshMessageContext.t = false;
    if ((!paramRefreshMessageContext.s) && (this.a.b.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt1))))
    {
      if (paramBoolean2) {
        this.a.b.setChangeAndNotify(paramRefreshMessageContext);
      }
      return;
    }
    this.a.b.getRefreshActionMap().put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(true));
    ThreadManager.executeOnNetWorkThread(new RandomGetMessageLoader.1(this, paramRefreshMessageContext, paramInt2, paramString, paramInt1, paramLong1, paramLong3, paramBoolean2, paramBoolean1, paramLong2));
  }
  
  public boolean a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("troop_unread_jump_opt", false);
    QLog.d("RandomGetMessageLoader", 1, new Object[] { "handleRefreshMessageListHeadResult troopUnreadJumpOpt:", Boolean.valueOf(bool1) });
    if (!bool1) {
      return false;
    }
    bool1 = paramBundle.getBoolean("success");
    long l1 = paramBundle.getLong("beginSeq", -1L);
    long l2 = paramBundle.getLong("endSeq", -1L);
    int j = paramBundle.getInt("load_count", 15);
    a(paramBundle, paramList1.size(), bool1);
    boolean bool2 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList = (List)this.a.b.getPullCache().get(Integer.valueOf(paramBundle.getInt("counter")));
    Object localObject1 = this.a.b;
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
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(" , endSeq = ");
    ((StringBuilder)localObject2).append(l2);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" , time = [");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("]");
    ((IMessageFacade)localObject1).qLogColor((String)localObject2, localStringBuilder.toString());
    this.a.b.getPullCache().remove(Integer.valueOf(paramBundle.getInt("counter")));
    if (localList != null)
    {
      i = localList.size();
      if (paramList2 == null) {
        paramList2 = new ArrayList();
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(localList);
        ((List)localObject1).addAll(this.a.a(paramInt).c(paramString, paramInt, l2 + 1L, l2 + j));
        this.a.a(paramList1, paramList2, (List)localObject1);
        QLog.d("RandomGetMessageLoader", 1, new Object[] { "handleRefreshMessageListHeadResult roam result size:", Integer.valueOf(paramList1.size()), ", insertList size: ", Integer.valueOf(paramList2.size()) });
      }
      paramBundle.putBoolean("success", bool1);
      if (!paramList2.isEmpty()) {
        this.a.a(((MessageRecord)paramList2.get(0)).istroop).a(paramList2, null);
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (MessageRecord)paramList1.next();
        this.a.a(localList, paramList2);
      }
      QLog.d("RandomGetMessageLoader", 1, new Object[] { "handleRefreshMessageListHeadResult localList size before: ", Integer.valueOf(i), ", after insert: ", Integer.valueOf(localList.size()) });
      try
      {
        localList.notify();
      }
      finally {}
    }
    if (bool2) {
      this.a.b.clearInAioParallerPullMsgMark(paramString, l1, l2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.RandomGetMessageLoader
 * JD-Core Version:    0.7.0.1
 */