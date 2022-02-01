package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
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
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.c = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("doRefreshMessageListHead_Confess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f) }));
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if (((MessageRecord)((List)localObject).get(i)).getConfessTopicId() != paramRefreshMessageContext.f) {
          ((List)localObject).remove(i);
        }
        i -= 1;
      }
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(paramInt2, ((List)localObject).size())));
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    for (long l = ((MessageRecord)((List)localObject).get(0)).uniseq;; l = 0L)
    {
      localObject = new ArrayList();
      a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
      this.a.a((List)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, (List)localObject);
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject);
      this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessRefresher", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f) }));
    }
    QQMessageFacade localQQMessageFacade = this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = UinTypeUtil.a(paramString, paramInt1, paramRefreshMessageContext.f);
    Object localObject1;
    Object localObject2;
    long l1;
    if (paramLong > 0L)
    {
      localObject1 = localQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong);
      localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
      if (localObject1 == null)
      {
        paramLong = -1L;
        localQQMessageFacade.a(paramLong, "");
        if (localObject1 == null) {
          break label717;
        }
        l1 = ((MessageRecord)localObject1).time;
        paramLong = ((MessageRecord)localObject1).getId();
      }
    }
    for (;;)
    {
      Object localObject3 = localQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
      localObject2 = new ArrayList();
      label205:
      MessageRecord localMessageRecord;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          if (TextUtils.equals(str, UinTypeUtil.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId()))) {
            if ((localMessageRecord.time <= l1) && ((localObject1 == null) || (!MsgProxyUtils.a((MessageRecord)localObject1, localMessageRecord, true)))) {
              break label657;
            }
          }
        }
        localQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject2);
      }
      long l2;
      if ((paramArrayList.size() < paramInt2) && (((List)localObject2).size() > 0))
      {
        paramArrayList.addAll(0, ((List)localObject2).subList(Math.max(((List)localObject2).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject2).size()));
        if (paramArrayList.size() > 0)
        {
          l1 = Math.min(l1, ((MessageRecord)paramArrayList.get(0)).time);
          l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          paramLong = l1;
          l1 = l2;
          l2 = paramLong;
          paramLong = l1;
        }
      }
      for (;;)
      {
        if (paramArrayList.size() < paramInt2)
        {
          int i = ConfessMsgUtil.a(paramInt1, paramRefreshMessageContext.f) << 3;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.format(" and (extLong & 4194296)=%d", new Object[] { Integer.valueOf(i) }));
          ((StringBuilder)localObject1).append(String.format(" or (time=%d and _id<%d and (extLong & 4194296)=%d) ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Integer.valueOf(i) }));
          localObject1 = localQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong, 3, l2, paramInt2, ((StringBuilder)localObject1).toString());
          localQQMessageFacade.a("queryTimedMessageDBUnion list size" + ((List)localObject1).size() + ", getID=" + paramLong, "");
          if (!((List)localObject1).isEmpty()) {
            break label670;
          }
          paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          paramRefreshMessageContext.c = true;
          if (QLog.isColorLevel()) {
            QLog.i("ConfessRefresher", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d findCount:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramRefreshMessageContext.f), Integer.valueOf(paramArrayList.size()) }));
          }
          return;
          paramLong = ((MessageRecord)localObject1).time;
          break;
          label657:
          ((List)localObject2).add(localMessageRecord);
          break label205;
          label670:
          if (((List)localObject1).size() < paramInt2) {
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
          }
          localQQMessageFacade.a("loadFromLocal load from DB", (Collection)localObject1);
          paramArrayList.addAll(0, (Collection)localObject1);
        }
        l2 = l1;
      }
      label717:
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
      continue;
      localObject1 = null;
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ConfessRefresher
 * JD-Core Version:    0.7.0.1
 */