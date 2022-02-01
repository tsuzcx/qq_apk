package com.tencent.imcore.message.msgproxy;

import android.support.annotation.Nullable;
import com.tencent.imcore.message.BaseMsgProxy.Callback;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;

public class ConfessMsgProxy
  extends MsgProxyWrapper
{
  @Metadata
  public ConfessMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  private int a(int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramInt > 0) {
        return b(paramInt, paramList);
      }
      return paramList.size();
    }
    return 0;
  }
  
  private void a(List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      String str = UinTypeUtil.b((MessageRecord)paramList.get(i));
      if (localHashMap.containsKey(str))
      {
        if (((Integer)localHashMap.get(str)).intValue() >= 15) {
          paramList.remove(i);
        } else {
          localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
        }
      }
      else {
        localHashMap.put(str, Integer.valueOf(1));
      }
      i -= 1;
    }
  }
  
  private void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1.size() > 15)
    {
      a(paramList1);
      paramList2.addAll(paramList1);
      return;
    }
    paramList2.addAll(paramList1);
  }
  
  private int b(int paramInt, List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext()) {
      if (((MessageRecord)paramList.next()).getConfessTopicId() == paramInt) {
        i += 1;
      }
    }
    return i;
  }
  
  @Nullable
  private List<MessageRecord> d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    List localList = (List)a().c().get(j(paramString, paramInt1));
    if (a(paramInt2, localList) == 0)
    {
      if (paramBoolean)
      {
        e(paramString, paramInt1, paramInt2);
      }
      else
      {
        a().c().remove(j(paramString, paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAIOMsgList_confess().remove");
        }
        return localList;
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAIOMsgList_confess from aioPool size = ");
      localStringBuilder.append(localList.size());
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    return (List)a().c().get(j(paramString, paramInt1));
  }
  
  private void e(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = d(paramString, paramInt1, paramInt2);
    Object localObject1;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()))
      {
        localObject1 = new StringBuilder(((List)localObject2).size() * 48 + 28);
        ((StringBuilder)localObject1).append("getAIOMsgList_confess, msgInfoList: ");
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(localMessageRecord.time);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(localMessageRecord.shmsgseq);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(localMessageRecord.msgtype);
          ((StringBuilder)localObject1).append(") ");
        }
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new ArrayList();
      a((List)localObject2, (List)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAIOMsgList_confess continuedList :");
      ((StringBuilder)localObject1).append(((List)localObject2).size());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    a().c().put(j(paramString, paramInt1), localObject2);
  }
  
  @Nullable
  private List<MessageRecord> f(String paramString, int paramInt1, int paramInt2)
  {
    String str = j(paramString, paramInt1);
    List localList2 = (List)a().b().get(str);
    List localList1 = localList2;
    if (a(paramInt2, localList2) == 0)
    {
      localList1 = g(paramString, paramInt1, paramInt2);
      a().b().put(str, localList1);
    }
    if ((localList1 != null) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.MsgProxy", 2, String.format("getMsgList_confess uin:%s type:%d topicId:%d size:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localList1.size()) }));
    }
    return localList1;
  }
  
  private List<MessageRecord> g(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (a(paramString, paramInt1, false)) {
      this.proxyManager.transSaveToDatabase();
    }
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString, paramInt1));
    localStringBuilder.append(" where _id in ");
    localStringBuilder.append("(select _id from ");
    localStringBuilder.append(l(paramString, paramInt1));
    int j;
    if (paramInt2 > 0)
    {
      j = ConfessMsgUtil.a(paramInt1, paramInt2);
      localStringBuilder.append(" where (extLong & 4194296)=");
      localStringBuilder.append(j << 3);
    }
    localStringBuilder.append(" order by time desc limit ");
    localStringBuilder.append(40);
    localStringBuilder.append(")");
    localStringBuilder.append(" order by time desc, _id desc");
    List localList = c(paramString, paramInt1, paramInt2);
    Object localObject = MsgProxy.c.a(localStringBuilder.toString(), null, this);
    if (QLog.isColorLevel())
    {
      paramString = localStringBuilder.toString();
      if (localObject == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((List)localObject).size();
      }
      QLog.i("Q.msg.MsgProxy", 2, String.format("getMsgList_confess sql:%s listSize:%d", new Object[] { paramString, Integer.valueOf(paramInt1) }));
    }
    if (localObject != null)
    {
      j = ((List)localObject).size() / 2;
      paramInt1 = ((List)localObject).size() - 1;
      paramInt2 = i;
      for (;;)
      {
        paramString = (String)localObject;
        if (paramInt2 >= j) {
          break;
        }
        paramString = (MessageRecord)((List)localObject).get(paramInt2);
        ((List)localObject).set(paramInt2, ((List)localObject).get(paramInt1));
        ((List)localObject).set(paramInt1, paramString);
        paramInt2 += 1;
        paramInt1 -= 1;
      }
    }
    paramString = new ArrayList();
    localObject = UinTypeUtil.a(paramString, localList).iterator();
    while (((Iterator)localObject).hasNext()) {
      MsgProxyUtils.a(paramString, (MessageRecord)((Iterator)localObject).next(), true);
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = d(paramString, paramInt1, paramInt2);
    if (paramString == null) {
      return null;
    }
    return (List)((ArrayList)paramString).clone();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return c(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAIOMsgList_confess peerUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" , autoInit = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", topicId=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.msg.MsgProxy_", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a().a(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = d(paramString, paramInt1, paramInt2, paramBoolean);
      return paramString;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a().a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = f(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.ConfessMsgProxy
 * JD-Core Version:    0.7.0.1
 */