package com.tencent.mobileqq.activity.recent.config.cache;

import com.tencent.mobileqq.app.QQAppInterface;

class DeprecatedLogicProcessor$1
  implements Runnable
{
  DeprecatedLogicProcessor$1(DeprecatedLogicProcessor paramDeprecatedLogicProcessor, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +16 -> 19
    //   6: aload_0
    //   7: getfield 15	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor;
    //   10: invokevirtual 37	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor:a	()Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc 39
    //   16: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 17	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   26: ldc 51
    //   28: ldc 53
    //   30: iconst_1
    //   31: anewarray 55	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield 19	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:jdField_a_of_type_Long	J
    //   40: invokestatic 59	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   43: aastore
    //   44: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   47: istore_1
    //   48: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +41 -> 92
    //   54: aload_0
    //   55: getfield 15	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor;
    //   58: getfield 68	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor:a	Ljava/lang/String;
    //   61: astore_2
    //   62: new 70	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   69: astore_3
    //   70: aload_3
    //   71: ldc 73
    //   73: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: iload_1
    //   79: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: iconst_2
    //   85: aload_3
    //   86: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +53 -> 148
    //   98: goto +37 -> 135
    //   101: astore_2
    //   102: goto +47 -> 149
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   110: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +16 -> 129
    //   116: aload_0
    //   117: getfield 15	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor;
    //   120: getfield 68	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor:a	Ljava/lang/String;
    //   123: iconst_2
    //   124: ldc 88
    //   126: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +16 -> 148
    //   135: aload_0
    //   136: getfield 15	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor;
    //   139: getfield 68	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor:a	Ljava/lang/String;
    //   142: iconst_2
    //   143: ldc 90
    //   145: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: return
    //   149: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +16 -> 168
    //   155: aload_0
    //   156: getfield 15	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor;
    //   159: getfield 68	com/tencent/mobileqq/activity/recent/config/cache/DeprecatedLogicProcessor:a	Ljava/lang/String;
    //   162: iconst_2
    //   163: ldc 90
    //   165: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_2
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	1
    //   47	32	1	i	int
    //   61	23	2	str	java.lang.String
    //   101	1	2	localObject	Object
    //   105	64	2	localException	java.lang.Exception
    //   69	17	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	92	101	finally
    //   106	129	101	finally
    //   19	92	105	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.DeprecatedLogicProcessor.1
 * JD-Core Version:    0.7.0.1
 */