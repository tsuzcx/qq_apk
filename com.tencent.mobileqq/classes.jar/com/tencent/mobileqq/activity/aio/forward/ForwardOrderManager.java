package com.tencent.mobileqq.activity.aio.forward;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardOrderManager
{
  private static ForwardOrderManager jdField_a_of_type_ComTencentMobileqqActivityAioForwardForwardOrderManager;
  private SparseArray<ForwardOrder> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private ForwardOrder a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size() - 1;
    while (i >= 0)
    {
      ForwardOrder localForwardOrder = (ForwardOrder)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localForwardOrder != null) && (localForwardOrder.a(paramLong, paramBoolean))) {
        return localForwardOrder;
      }
      i -= 1;
    }
    return null;
  }
  
  public static ForwardOrderManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioForwardForwardOrderManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioForwardForwardOrderManager == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioForwardForwardOrderManager = new ForwardOrderManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioForwardForwardOrderManager;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mapUniSeqId:: newSeq -> ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", originSeq -> ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", id -> ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ForwardOrderManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ForwardOrder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((ForwardOrder)localObject).a(paramLong1, paramLong2);
    }
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    a(paramSessionInfo, paramString, new ArrayList(), 1, paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        localArrayList.add(Long.valueOf(localMessageRecord.uniseq));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPreForward :: mr.uniseq -> ");
          localStringBuilder.append(localMessageRecord.uniseq);
          localStringBuilder.append(", forwardID -> ");
          localStringBuilder.append(paramInt2);
          QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
        }
      }
    }
    if (paramInt1 == 1) {
      paramList = new SeparateForwardOrder();
    } else {
      paramList = new MergeForwardOrder();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, paramList.a(paramSessionInfo, paramString, localArrayList, paramInt2));
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendResult newSeq -> ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", mForwardEntities.size() => ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidUtilSparseArray.size());
      QLog.d("ForwardOrderManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((ForwardOrder)localObject).a(paramQQAppInterface, paramLong))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(((ForwardOrder)localObject).a);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    ForwardOrder localForwardOrder = (ForwardOrder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localForwardOrder != null) {
      localForwardOrder.a(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      ForwardOrder localForwardOrder = a(paramMessageRecord.uniseq, true);
      if (localForwardOrder != null) {
        localForwardOrder.a(paramQQAppInterface, paramMessageRecord);
      }
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a(paramQQAppInterface, (MessageRecord)paramList.next());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, int paramInt)
  {
    try
    {
      ((ForwardOrder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager
 * JD-Core Version:    0.7.0.1
 */