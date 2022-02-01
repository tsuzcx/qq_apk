package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class SeparateForwardOrder
  extends ForwardOrder
{
  private void c(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForwardOrder realMapUniSeq newSeq -> ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", originSeq -> ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", forwardID -> ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
    }
    if ((this.b != null) && (!this.b.isEmpty()) && (a(paramLong2, this.b)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ForwardOrder realMapUniSeq map do put, forwardID -> ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if (a(paramLong2, this.b))
    {
      c(paramLong1, paramLong2);
      return;
    }
    a(paramLong1);
    c(paramLong1, paramLong1);
  }
  
  void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageRecord.uniseq)) != null))
      {
        paramMessageRecord = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageRecord.uniseq));
        if ((paramMessageRecord != null) && (a(paramMessageRecord.longValue(), this.b)))
        {
          this.b.remove(paramMessageRecord);
          if ((this.b.size() <= 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
          {
            paramQQAppInterface = ChatActivityFacade.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_JavaLangString = "";
            if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
              this.jdField_a_of_type_Long = paramQQAppInterface[0];
            }
          }
        }
      }
      return;
    }
    finally {}
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject1 = this.b;
      break label21;
      localObject1 = this.jdField_a_of_type_JavaUtilSet;
      label21:
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          long l1 = ((Long)((Iterator)localObject1).next()).longValue();
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null))
          {
            Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
            if ((localLong != null) && (localLong.longValue() > 0L))
            {
              long l2 = localLong.longValue();
              if (l2 == l1) {
                return true;
              }
            }
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null))
      {
        Object localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        if ((localObject != null) && (a(((Long)localObject).longValue(), this.jdField_a_of_type_JavaUtilSet)))
        {
          this.jdField_a_of_type_JavaUtilSet.remove(localObject);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("SeparateForwardOrder onSendResult mChatMsgListAfter remove originUniSeq ");
            localStringBuilder.append(localObject);
            localStringBuilder.append("， mChatMsgListAfter.size() -> ");
            localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
            localStringBuilder.append(", forwardID -> ");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
          }
          if ((this.jdField_a_of_type_JavaUtilSet.size() <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Long > 0L))
          {
            localObject = paramQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
            if (localObject != null)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("SeparateForwardOrder onSendResult query msg and send, newSeq -> ");
                localStringBuilder.append(paramLong);
                localStringBuilder.append(", forwardID -> ");
                localStringBuilder.append(this.jdField_a_of_type_Int);
                QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
              }
              paramQQAppInterface.getMessageFacade().b((MessageRecord)localObject, null, false);
              this.jdField_a_of_type_Long = 0L;
              a();
              return true;
            }
          }
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.SeparateForwardOrder
 * JD-Core Version:    0.7.0.1
 */