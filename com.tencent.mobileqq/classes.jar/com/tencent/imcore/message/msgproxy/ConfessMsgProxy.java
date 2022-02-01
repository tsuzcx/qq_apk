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
    if ((paramList == null) || (paramList.size() <= 0)) {
      return 0;
    }
    if (paramInt > 0) {
      return b(paramInt, paramList);
    }
    return paramList.size();
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    List localList = c(paramString, paramInt1, paramInt2);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (!localList.isEmpty())
      {
        if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()))
        {
          localObject1 = new StringBuilder(localList.size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList_confess, msgInfoList: ");
          localObject2 = localList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
          QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new ArrayList();
        a(localList, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess continuedList :" + ((List)localObject2).size());
    }
    a().a().put(a(paramString, paramInt1), localObject2);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      String str = UinTypeUtil.b((MessageRecord)paramList.get(i));
      if (localHashMap.containsKey(str)) {
        if (((Integer)localHashMap.get(str)).intValue() >= 15) {
          paramList.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
        continue;
        localHashMap.put(str, Integer.valueOf(1));
      }
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
    if (paramList.hasNext())
    {
      if (((MessageRecord)paramList.next()).getConfessTopicId() != paramInt) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  @Nullable
  private List<MessageRecord> c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    List localList = (List)a().a().get(a(paramString, paramInt1));
    if (a(paramInt2, localList) == 0) {
      if (paramBoolean) {
        a(paramString, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      paramString = (List)a().a().get(a(paramString, paramInt1));
      do
      {
        return paramString;
        a().a().remove(a(paramString, paramInt1));
        paramString = localList;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAIOMsgList_confess().remove");
      return localList;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess from aioPool size = " + localList.size());
      }
    }
  }
  
  @Nullable
  private List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    String str = a(paramString, paramInt1);
    List localList2 = (List)a().b().get(str);
    List localList1 = localList2;
    if (a(paramInt2, localList2) == 0)
    {
      localList1 = e(paramString, paramInt1, paramInt2);
      a().b().put(str, localList1);
    }
    if ((localList1 != null) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.MsgProxy", 2, String.format("getMsgList_confess uin:%s type:%d topicId:%d size:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localList1.size()) }));
    }
    return localList1;
  }
  
  private List<MessageRecord> e(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = new StringBuilder();
    if (a(paramString, paramInt1, false)) {
      this.proxyManager.transSaveToDatabase();
    }
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(b(paramString, paramInt1));
    ((StringBuilder)localObject2).append(" where _id in ");
    ((StringBuilder)localObject2).append("(select _id from ");
    ((StringBuilder)localObject2).append(b(paramString, paramInt1));
    int i;
    if (paramInt2 > 0)
    {
      i = ConfessMsgUtil.a(paramInt1, paramInt2);
      ((StringBuilder)localObject2).append(" where (extLong & 4194296)=");
      ((StringBuilder)localObject2).append(i << 3);
    }
    ((StringBuilder)localObject2).append(" order by time desc limit ");
    ((StringBuilder)localObject2).append(40);
    ((StringBuilder)localObject2).append(")");
    ((StringBuilder)localObject2).append(" order by time desc, _id desc");
    Object localObject1 = b(paramString, paramInt1, paramInt2);
    paramString = MsgProxy.a.a(((StringBuilder)localObject2).toString(), null, this);
    if (QLog.isColorLevel())
    {
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramString != null) {
        break label287;
      }
    }
    label287:
    for (paramInt1 = 0;; paramInt1 = paramString.size())
    {
      QLog.i("Q.msg.MsgProxy", 2, String.format("getMsgList_confess sql:%s listSize:%d", new Object[] { localObject2, Integer.valueOf(paramInt1) }));
      if (paramString == null) {
        break label338;
      }
      i = paramString.size() / 2;
      paramInt1 = paramString.size();
      paramInt2 = 0;
      paramInt1 -= 1;
      while (paramInt2 < i)
      {
        localObject2 = (MessageRecord)paramString.get(paramInt2);
        paramString.set(paramInt2, paramString.get(paramInt1));
        paramString.set(paramInt1, localObject2);
        paramInt2 += 1;
        paramInt1 -= 1;
      }
    }
    for (;;)
    {
      localObject1 = UinTypeUtil.a(paramString, (List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        MsgProxyUtils.a(paramString, (MessageRecord)((Iterator)localObject1).next(), true);
      }
      label338:
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = c(paramString, paramInt1, paramInt2);
    if (paramString == null) {
      return null;
    }
    return (List)((ArrayList)paramString).clone();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return b(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_", 2, "getAIOMsgList_confess peerUin: " + paramString + " type: " + paramInt1 + " , autoInit = " + paramBoolean + ", topicId=" + paramInt2);
    }
    Lock localLock = a().a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = c(paramString, paramInt1, paramInt2, paramBoolean);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a().a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = d(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.ConfessMsgProxy
 * JD-Core Version:    0.7.0.1
 */