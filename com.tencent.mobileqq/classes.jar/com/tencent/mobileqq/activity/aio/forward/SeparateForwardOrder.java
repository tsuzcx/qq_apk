package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class SeparateForwardOrder
  extends ForwardOrder
{
  private void c(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq newSeq -> " + paramLong1 + ", originSeq -> " + paramLong2 + ", forwardID -> " + this.jdField_a_of_type_Int);
    }
    if ((this.b != null) && (!this.b.isEmpty()) && (a(paramLong2, this.b)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq map do put, forwardID -> " + this.jdField_a_of_type_Int);
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
  
  /* Error */
  boolean a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +131 -> 134
    //   6: aload_0
    //   7: getfield 54	com/tencent/mobileqq/activity/aio/forward/SeparateForwardOrder:b	Ljava/util/Set;
    //   10: astore 8
    //   12: aload 8
    //   14: ifnull +129 -> 143
    //   17: aload 8
    //   19: invokeinterface 107 1 0
    //   24: ifle +119 -> 143
    //   27: aload 8
    //   29: invokeinterface 132 1 0
    //   34: astore 8
    //   36: aload 8
    //   38: invokeinterface 137 1 0
    //   43: ifeq +100 -> 143
    //   46: aload 8
    //   48: invokeinterface 141 1 0
    //   53: checkcast 67	java/lang/Long
    //   56: invokevirtual 99	java/lang/Long:longValue	()J
    //   59: lstore 4
    //   61: aload_0
    //   62: getfield 65	com/tencent/mobileqq/activity/aio/forward/SeparateForwardOrder:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: ifnull -29 -> 36
    //   68: aload_0
    //   69: getfield 65	com/tencent/mobileqq/activity/aio/forward/SeparateForwardOrder:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   72: lload_1
    //   73: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 95	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: ifnull -43 -> 36
    //   82: aload_0
    //   83: getfield 65	com/tencent/mobileqq/activity/aio/forward/SeparateForwardOrder:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   86: lload_1
    //   87: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: invokevirtual 95	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 67	java/lang/Long
    //   96: astore 9
    //   98: aload 9
    //   100: ifnull -64 -> 36
    //   103: aload 9
    //   105: invokevirtual 99	java/lang/Long:longValue	()J
    //   108: lconst_0
    //   109: lcmp
    //   110: ifle -74 -> 36
    //   113: aload 9
    //   115: invokevirtual 99	java/lang/Long:longValue	()J
    //   118: lstore 6
    //   120: lload 6
    //   122: lload 4
    //   124: lcmp
    //   125: ifne -89 -> 36
    //   128: iconst_1
    //   129: istore_3
    //   130: aload_0
    //   131: monitorexit
    //   132: iload_3
    //   133: ireturn
    //   134: aload_0
    //   135: getfield 143	com/tencent/mobileqq/activity/aio/forward/SeparateForwardOrder:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   138: astore 8
    //   140: goto -128 -> 12
    //   143: iconst_0
    //   144: istore_3
    //   145: goto -15 -> 130
    //   148: astore 8
    //   150: aload_0
    //   151: monitorexit
    //   152: aload 8
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	SeparateForwardOrder
    //   0	155	1	paramLong	long
    //   0	155	3	paramBoolean	boolean
    //   59	64	4	l1	long
    //   118	3	6	l2	long
    //   10	129	8	localObject1	Object
    //   148	5	8	localObject2	Object
    //   96	18	9	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   6	12	148	finally
    //   17	36	148	finally
    //   36	98	148	finally
    //   103	120	148	finally
    //   134	140	148	finally
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
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult mChatMsgListAfter remove originUniSeq " + localObject + "， mChatMsgListAfter.size() -> " + this.jdField_a_of_type_JavaUtilSet.size() + ", forwardID -> " + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_JavaUtilSet.size() <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Long > 0L))
          {
            localObject = paramQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult query msg and send, newSeq -> " + paramLong + ", forwardID -> " + this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.SeparateForwardOrder
 * JD-Core Version:    0.7.0.1
 */