package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MergeForwardOrder
  extends ForwardOrder
{
  void a(long paramLong1, long paramLong2)
  {
    try
    {
      if (this.b == null) {
        this.b = new HashSet();
      } else {
        this.b.clear();
      }
      this.b.add(Long.valueOf(paramLong1));
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
      } else {
        this.jdField_a_of_type_JavaUtilSet.clear();
      }
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong1));
      return;
    }
    finally {}
  }
  
  void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.b != null) && (this.b.size() > 0) && (a(this.jdField_a_of_type_JavaUtilSet) == paramMessageRecord.uniseq) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      paramQQAppInterface = ChatActivityFacade.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = "";
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        this.jdField_a_of_type_Long = paramQQAppInterface[0];
      }
    }
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
          long l = ((Long)((Iterator)localObject1).next()).longValue();
          if (l == paramLong) {
            return true;
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
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.size() > 0) && (a(this.jdField_a_of_type_JavaUtilSet) == paramLong) && (a(this.jdField_a_of_type_JavaUtilSet) == paramLong) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Long > 0L))
    {
      MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (localMessageRecord != null) {
        paramQQAppInterface.getMessageFacade().b(localMessageRecord, null, false);
      }
      this.jdField_a_of_type_Long = 0L;
      a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardOrder
 * JD-Core Version:    0.7.0.1
 */