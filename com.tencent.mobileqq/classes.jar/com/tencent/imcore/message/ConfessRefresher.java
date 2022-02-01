package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ConfessRefresher
  implements IMessageRefresher
{
  private final C2CMessageManager a;
  
  public ConfessRefresher(C2CMessageManager paramC2CMessageManager)
  {
    this.a = paramC2CMessageManager;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.e = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("doRefreshMessageListHead_Confess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.w) }));
    }
    Object localObject = this.a.a(paramInt1).g(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if (((MessageRecord)((List)localObject).get(i)).getConfessTopicId() != paramRefreshMessageContext.w) {
          ((List)localObject).remove(i);
        }
        i -= 1;
      }
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.a.b.dumpmsgs("current Aio", ((List)localObject).subList(0, Math.min(paramInt2, ((List)localObject).size())));
    }
    long l;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
    } else {
      l = 0L;
    }
    localObject = new ArrayList();
    a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
    this.a.a((List)localObject);
    this.a.a(paramInt1).b(paramString, paramInt1, (List)localObject);
    paramRefreshMessageContext.b = ((List)localObject);
    this.a.b.setChangeAndNotify(paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessRefresher", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.w) }));
    }
    IMessageFacade localIMessageFacade = this.a.b;
    Object localObject3 = (QQAppInterface)this.a.a;
    String str = UinTypeUtil.a(paramString, paramInt1, paramRefreshMessageContext.w);
    Object localObject2 = "";
    if (paramLong > 0L)
    {
      localObject1 = ((QQAppInterface)localObject3).getMessageProxy(paramInt1).b(paramString, paramInt1, paramLong);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("loadFromLocal uniseq=");
      ((StringBuilder)localObject4).append(paramLong);
      ((StringBuilder)localObject4).append(",count=");
      ((StringBuilder)localObject4).append(paramInt2);
      ((StringBuilder)localObject4).append(", fromtime=");
      if (localObject1 == null) {
        paramLong = -1L;
      } else {
        paramLong = ((MessageRecord)localObject1).time;
      }
      ((StringBuilder)localObject4).append(paramLong);
      localIMessageFacade.qLogColor(((StringBuilder)localObject4).toString(), "");
      if (localObject1 != null)
      {
        l1 = ((MessageRecord)localObject1).time;
        paramLong = ((MessageRecord)localObject1).getId();
        localObject4 = localObject1;
        break label230;
      }
    }
    else
    {
      localObject1 = null;
    }
    long l1 = 9223372036854775807L;
    paramLong = l1;
    Object localObject4 = localObject1;
    label230:
    Object localObject1 = ((QQAppInterface)localObject3).getMessageProxy(paramInt1).c(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = localObject3;
      while (localIterator.hasNext())
      {
        localObject3 = (MessageRecord)localIterator.next();
        if (TextUtils.equals(str, UinTypeUtil.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).getConfessTopicId()))) {
          while ((((MessageRecord)localObject3).time <= l1) && ((localObject4 == null) || (!MsgProxyUtils.a((MessageRecord)localObject4, (MessageRecord)localObject3, true)))) {
            localArrayList.add(localObject3);
          }
        }
      }
      localIMessageFacade.dumpmsgs("loadFromLocal load from Cache", localArrayList);
      localObject3 = localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = "";
    }
    if ((paramArrayList.size() < paramInt2) && (localArrayList.size() > 0))
    {
      paramArrayList.addAll(0, localArrayList.subList(Math.max(localArrayList.size() - (paramInt2 - paramArrayList.size()), 0), localArrayList.size()));
      if (paramArrayList.size() > 0)
      {
        l1 = Math.min(l1, ((MessageRecord)paramArrayList.get(0)).time);
        l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
        paramLong = l1;
        l1 = l2;
        l2 = l1;
        break label520;
      }
    }
    long l2 = paramLong;
    paramLong = l1;
    label520:
    if (paramArrayList.size() < paramInt2)
    {
      int i = ConfessMsgUtil.a(paramInt1, paramRefreshMessageContext.w) << 3;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(String.format(" and (extLong & 4194296)=%d", new Object[] { Integer.valueOf(i) }));
      ((StringBuilder)localObject2).append(String.format(" or (time=%d and _id<%d and (extLong & 4194296)=%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Integer.valueOf(i) }));
      localObject2 = ((QQAppInterface)localObject3).getMessageProxy(paramInt1).a(paramString, paramInt1, l2, 3, paramLong, paramInt2, ((StringBuilder)localObject2).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queryTimedMessageDBUnion list size");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      ((StringBuilder)localObject3).append(", getID=");
      ((StringBuilder)localObject3).append(l2);
      localIMessageFacade.qLogColor(((StringBuilder)localObject3).toString(), (String)localObject1);
      if (((List)localObject2).isEmpty())
      {
        paramRefreshMessageContext.c = true;
      }
      else
      {
        if (((List)localObject2).size() < paramInt2) {
          paramRefreshMessageContext.c = true;
        }
        localIMessageFacade.dumpmsgs("loadFromLocal load from DB", (Collection)localObject2);
        paramArrayList.addAll(0, (Collection)localObject2);
      }
    }
    paramRefreshMessageContext.e = true;
    if (QLog.isColorLevel()) {
      QLog.i("ConfessRefresher", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d findCount:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.w), Integer.valueOf(paramArrayList.size()) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ConfessRefresher
 * JD-Core Version:    0.7.0.1
 */