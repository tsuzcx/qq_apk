package com.tencent.mobileqq.apollo.res.api.impl;

final class ApolloSoLoaderImpl$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: invokestatic 26	com/tencent/mobileqq/apollo/utils/ProcessUtil:a	()Z
    //   7: invokestatic 32	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$002	(Z)Z
    //   10: pop
    //   11: invokestatic 35	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$000	()Z
    //   14: istore 5
    //   16: iload 5
    //   18: ifeq +410 -> 428
    //   21: invokestatic 41	com/tencent/mobileqq/apollo/utils/api/impl/ApolloUtilImpl:getQQApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +400 -> 428
    //   31: aload 6
    //   33: ldc 43
    //   35: ldc 45
    //   37: invokevirtual 51	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   40: checkcast 43	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   43: invokestatic 57	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   46: invokeinterface 61 2 0
    //   51: istore 5
    //   53: goto +18 -> 71
    //   56: astore 6
    //   58: ldc 63
    //   60: iconst_1
    //   61: ldc 65
    //   63: aload 6
    //   65: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: goto +360 -> 428
    //   71: iload 5
    //   73: invokestatic 74	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$102	(Z)Z
    //   76: pop
    //   77: invokestatic 77	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$100	()Z
    //   80: ifeq +25 -> 105
    //   83: getstatic 81	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:sIsBeginTrace	Z
    //   86: ifeq +19 -> 105
    //   89: bipush 10
    //   91: invokestatic 86	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:a	(I)V
    //   94: bipush 10
    //   96: bipush 100
    //   98: invokestatic 89	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:a	(II)V
    //   101: iconst_0
    //   102: putstatic 81	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:sIsBeginTrace	Z
    //   105: invokestatic 92	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$200	()Z
    //   108: ifne +66 -> 174
    //   111: ldc 63
    //   113: iconst_1
    //   114: ldc 94
    //   116: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: invokestatic 101	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$300	()Z
    //   122: ifeq +44 -> 166
    //   125: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   128: lstore_3
    //   129: new 103	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   136: astore 6
    //   138: aload 6
    //   140: ldc 106
    //   142: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: lload_3
    //   149: lload_1
    //   150: lsub
    //   151: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 63
    //   157: iconst_1
    //   158: aload 6
    //   160: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: invokestatic 124	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$600	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   169: iconst_0
    //   170: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   173: return
    //   174: invokestatic 77	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$100	()Z
    //   177: ifeq +28 -> 205
    //   180: bipush 10
    //   182: bipush 100
    //   184: iconst_0
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: ldc 132
    //   193: aastore
    //   194: invokestatic 135	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:a	(III[Ljava/lang/Object;)V
    //   197: bipush 10
    //   199: sipush 300
    //   202: invokestatic 89	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:a	(II)V
    //   205: iconst_1
    //   206: invokestatic 138	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$302	(Z)Z
    //   209: pop
    //   210: iconst_0
    //   211: invokestatic 141	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:notifyResult	(I)V
    //   214: invokestatic 144	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$400	()V
    //   217: invokestatic 147	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$500	()V
    //   220: invokestatic 77	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$100	()Z
    //   223: ifeq +14 -> 237
    //   226: bipush 10
    //   228: invokestatic 150	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:b	(I)V
    //   231: bipush 10
    //   233: iconst_0
    //   234: invokestatic 153	com/tencent/mobileqq/apollo/statistics/trace/TraceReportUtil:a	(IZ)V
    //   237: ldc 63
    //   239: iconst_1
    //   240: ldc 155
    //   242: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: invokestatic 101	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$300	()Z
    //   248: ifeq +115 -> 363
    //   251: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   254: lload_1
    //   255: lsub
    //   256: lstore_1
    //   257: new 103	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   264: astore 6
    //   266: goto +71 -> 337
    //   269: astore 6
    //   271: goto +100 -> 371
    //   274: astore 6
    //   276: new 103	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   283: astore 7
    //   285: aload 7
    //   287: ldc 157
    //   289: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 7
    //   295: aload 6
    //   297: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 63
    //   303: iconst_1
    //   304: aload 7
    //   306: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iconst_1
    //   313: invokestatic 141	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:notifyResult	(I)V
    //   316: invokestatic 101	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$300	()Z
    //   319: ifeq +44 -> 363
    //   322: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   325: lload_1
    //   326: lsub
    //   327: lstore_1
    //   328: new 103	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   335: astore 6
    //   337: aload 6
    //   339: ldc 106
    //   341: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 6
    //   347: lload_1
    //   348: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 63
    //   354: iconst_1
    //   355: aload 6
    //   357: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: invokestatic 124	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$600	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   366: iconst_0
    //   367: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   370: return
    //   371: invokestatic 101	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$300	()Z
    //   374: ifeq +44 -> 418
    //   377: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   380: lstore_3
    //   381: new 103	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   388: astore 7
    //   390: aload 7
    //   392: ldc 106
    //   394: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 7
    //   400: lload_3
    //   401: lload_1
    //   402: lsub
    //   403: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 63
    //   409: iconst_1
    //   410: aload 7
    //   412: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: invokestatic 124	com/tencent/mobileqq/apollo/res/api/impl/ApolloSoLoaderImpl:access$600	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   421: iconst_0
    //   422: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   425: aload 6
    //   427: athrow
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -360 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	1
    //   3	399	1	l1	long
    //   128	273	3	l2	long
    //   14	416	5	bool	boolean
    //   24	8	6	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   56	8	6	localThrowable1	java.lang.Throwable
    //   136	129	6	localStringBuilder1	java.lang.StringBuilder
    //   269	1	6	localObject	Object
    //   274	22	6	localThrowable2	java.lang.Throwable
    //   335	91	6	localStringBuilder2	java.lang.StringBuilder
    //   283	128	7	localStringBuilder3	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	26	56	java/lang/Throwable
    //   31	53	56	java/lang/Throwable
    //   4	16	269	finally
    //   21	26	269	finally
    //   31	53	269	finally
    //   58	68	269	finally
    //   71	105	269	finally
    //   105	119	269	finally
    //   174	205	269	finally
    //   205	237	269	finally
    //   237	245	269	finally
    //   276	316	269	finally
    //   4	16	274	java/lang/Throwable
    //   58	68	274	java/lang/Throwable
    //   71	105	274	java/lang/Throwable
    //   105	119	274	java/lang/Throwable
    //   174	205	274	java/lang/Throwable
    //   205	237	274	java/lang/Throwable
    //   237	245	274	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl.1
 * JD-Core Version:    0.7.0.1
 */