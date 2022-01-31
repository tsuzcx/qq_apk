package com.tencent.mobileqq.activity.aio;

public class AIOConfigManager
{
  public static int a;
  public static boolean a;
  
  /* Error */
  public static void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 25
    //   13: iconst_2
    //   14: ldc 27
    //   16: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   23: astore_0
    //   24: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: new 45	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   34: aload_0
    //   35: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 52
    //   40: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 54
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: iconst_0
    //   52: invokevirtual 61	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   55: astore_0
    //   56: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +11 -> 70
    //   62: ldc 25
    //   64: iconst_2
    //   65: ldc 63
    //   67: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: ldc 65
    //   73: iconst_0
    //   74: invokeinterface 71 3 0
    //   79: iconst_1
    //   80: if_icmpne +107 -> 187
    //   83: iload_1
    //   84: putstatic 73	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Boolean	Z
    //   87: aload_0
    //   88: ldc 75
    //   90: bipush 10
    //   92: invokeinterface 71 3 0
    //   97: putstatic 77	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Int	I
    //   100: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +80 -> 183
    //   106: new 45	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   113: astore_0
    //   114: aload_0
    //   115: ldc 79
    //   117: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: new 45	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   129: ldc 81
    //   131: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: getstatic 73	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Boolean	Z
    //   137: invokevirtual 84	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_0
    //   148: new 45	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   155: ldc 86
    //   157: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: getstatic 77	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Int	I
    //   163: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 25
    //   175: iconst_2
    //   176: aload_0
    //   177: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: ldc 2
    //   185: monitorexit
    //   186: return
    //   187: iconst_0
    //   188: istore_1
    //   189: goto -106 -> 83
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   197: goto -14 -> 183
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 93	java/lang/Error:printStackTrace	()V
    //   211: goto -28 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1	188	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	19	192	java/lang/Exception
    //   19	70	192	java/lang/Exception
    //   70	83	192	java/lang/Exception
    //   83	183	192	java/lang/Exception
    //   5	19	200	finally
    //   19	70	200	finally
    //   70	83	200	finally
    //   83	183	200	finally
    //   193	197	200	finally
    //   207	211	200	finally
    //   5	19	206	java/lang/Error
    //   19	70	206	java/lang/Error
    //   70	83	206	java/lang/Error
    //   83	183	206	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOConfigManager
 * JD-Core Version:    0.7.0.1
 */