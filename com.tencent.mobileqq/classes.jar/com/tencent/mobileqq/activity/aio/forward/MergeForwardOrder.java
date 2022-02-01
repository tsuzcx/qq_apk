package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashSet;
import java.util.Set;

class MergeForwardOrder
  extends ForwardOrder
{
  void a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        if (this.b == null)
        {
          this.b = new HashSet();
          this.b.add(Long.valueOf(paramLong1));
          if (this.jdField_a_of_type_JavaUtilSet == null)
          {
            this.jdField_a_of_type_JavaUtilSet = new HashSet();
            this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong1));
          }
        }
        else
        {
          this.b.clear();
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.clear();
      }
      finally {}
    }
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
  
  /* Error */
  boolean a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +71 -> 74
    //   6: aload_0
    //   7: getfield 15	com/tencent/mobileqq/activity/aio/forward/MergeForwardOrder:b	Ljava/util/Set;
    //   10: astore 6
    //   12: aload 6
    //   14: ifnull +69 -> 83
    //   17: aload 6
    //   19: invokeinterface 40 1 0
    //   24: ifle +59 -> 83
    //   27: aload 6
    //   29: invokeinterface 75 1 0
    //   34: astore 6
    //   36: aload 6
    //   38: invokeinterface 81 1 0
    //   43: ifeq +40 -> 83
    //   46: aload 6
    //   48: invokeinterface 85 1 0
    //   53: checkcast 20	java/lang/Long
    //   56: invokevirtual 89	java/lang/Long:longValue	()J
    //   59: lstore 4
    //   61: lload 4
    //   63: lload_1
    //   64: lcmp
    //   65: ifne -29 -> 36
    //   68: iconst_1
    //   69: istore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_3
    //   73: ireturn
    //   74: aload_0
    //   75: getfield 32	com/tencent/mobileqq/activity/aio/forward/MergeForwardOrder:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   78: astore 6
    //   80: goto -68 -> 12
    //   83: iconst_0
    //   84: istore_3
    //   85: goto -15 -> 70
    //   88: astore 6
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 6
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	MergeForwardOrder
    //   0	95	1	paramLong	long
    //   0	95	3	paramBoolean	boolean
    //   59	3	4	l	long
    //   10	69	6	localObject1	Object
    //   88	5	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	88	finally
    //   17	36	88	finally
    //   36	61	88	finally
    //   74	80	88	finally
  }
  
  boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
      {
        bool1 = bool2;
        if (a(this.jdField_a_of_type_JavaUtilSet) == paramLong)
        {
          bool1 = bool2;
          if (a(this.jdField_a_of_type_JavaUtilSet) == paramLong)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_Long > 0L)
              {
                MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
                if (localMessageRecord != null) {
                  paramQQAppInterface.getMessageFacade().b(localMessageRecord, null, false);
                }
                this.jdField_a_of_type_Long = 0L;
                a();
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardOrder
 * JD-Core Version:    0.7.0.1
 */