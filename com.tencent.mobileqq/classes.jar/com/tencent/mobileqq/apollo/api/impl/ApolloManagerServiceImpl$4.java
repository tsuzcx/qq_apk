package com.tencent.mobileqq.apollo.api.impl;

class ApolloManagerServiceImpl$4
  implements Runnable
{
  ApolloManagerServiceImpl$4(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$4:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   4: getfield 31	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloResVersionInfo	Lorg/json/JSONObject;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$4:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   15: invokestatic 35	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$200	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Lcom/tencent/common/app/AppInterface;
    //   18: astore_1
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore_2
    //   30: aload_1
    //   31: ifnull +11 -> 42
    //   34: aload_1
    //   35: invokevirtual 41	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: astore_1
    //   39: goto +5 -> 44
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnonnull +4 -> 49
    //   48: return
    //   49: new 43	java/io/File
    //   52: dup
    //   53: ldc 45
    //   55: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 52	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: new 43	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: ldc 54
    //   71: invokespecial 57	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 8
    //   76: aload 8
    //   78: invokevirtual 60	java/io/File:exists	()Z
    //   81: ifeq +9 -> 90
    //   84: aload 8
    //   86: invokevirtual 63	java/io/File:delete	()Z
    //   89: pop
    //   90: aload_2
    //   91: astore_1
    //   92: aload_0
    //   93: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$4:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   96: getfield 31	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloResVersionInfo	Lorg/json/JSONObject;
    //   99: astore_3
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$4:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   108: getfield 31	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloResVersionInfo	Lorg/json/JSONObject;
    //   111: invokevirtual 69	org/json/JSONObject:toString	()Ljava/lang/String;
    //   114: astore 7
    //   116: aload_3
    //   117: monitorexit
    //   118: aload_2
    //   119: astore_1
    //   120: aload 7
    //   122: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +4 -> 129
    //   128: return
    //   129: aload_2
    //   130: astore_1
    //   131: new 77	java/io/FileOutputStream
    //   134: dup
    //   135: aload 8
    //   137: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   140: astore_2
    //   141: aload_2
    //   142: aload 7
    //   144: invokevirtual 86	java/lang/String:getBytes	()[B
    //   147: invokevirtual 90	java/io/FileOutputStream:write	([B)V
    //   150: aload_2
    //   151: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   154: aload_2
    //   155: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_1
    //   160: goto +137 -> 297
    //   163: astore_1
    //   164: aload_1
    //   165: astore_3
    //   166: goto +36 -> 202
    //   169: astore_1
    //   170: aload_1
    //   171: astore_3
    //   172: goto +59 -> 231
    //   175: astore_1
    //   176: aload_1
    //   177: astore_3
    //   178: goto +82 -> 260
    //   181: astore 7
    //   183: aload_3
    //   184: monitorexit
    //   185: aload_2
    //   186: astore_1
    //   187: aload 7
    //   189: athrow
    //   190: astore_3
    //   191: aload_1
    //   192: astore_2
    //   193: aload_3
    //   194: astore_1
    //   195: goto +102 -> 297
    //   198: astore_3
    //   199: aload 4
    //   201: astore_2
    //   202: aload_2
    //   203: astore_1
    //   204: ldc 98
    //   206: iconst_1
    //   207: aload_3
    //   208: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_2
    //   215: ifnull +81 -> 296
    //   218: aload_2
    //   219: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   222: aload_2
    //   223: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   226: return
    //   227: astore_3
    //   228: aload 5
    //   230: astore_2
    //   231: aload_2
    //   232: astore_1
    //   233: ldc 98
    //   235: iconst_1
    //   236: aload_3
    //   237: invokevirtual 108	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   240: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +52 -> 296
    //   247: aload_2
    //   248: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   251: aload_2
    //   252: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   255: return
    //   256: astore_3
    //   257: aload 6
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: ldc 98
    //   264: iconst_1
    //   265: aload_3
    //   266: invokevirtual 109	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   269: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_2
    //   273: ifnull +23 -> 296
    //   276: aload_2
    //   277: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   280: aload_2
    //   281: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   284: return
    //   285: astore_1
    //   286: ldc 98
    //   288: iconst_1
    //   289: aload_1
    //   290: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   293: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: return
    //   297: aload_2
    //   298: ifnull +25 -> 323
    //   301: aload_2
    //   302: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   305: aload_2
    //   306: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   309: goto +14 -> 323
    //   312: astore_2
    //   313: ldc 98
    //   315: iconst_1
    //   316: aload_2
    //   317: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   320: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	4
    //   18	113	1	localObject1	Object
    //   159	1	1	localObject2	Object
    //   163	2	1	localException1	java.lang.Exception
    //   169	2	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   175	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   186	76	1	localObject3	Object
    //   285	39	1	localIOException1	java.io.IOException
    //   29	277	2	localObject4	Object
    //   312	5	2	localIOException2	java.io.IOException
    //   99	85	3	localObject5	Object
    //   190	4	3	localObject6	Object
    //   198	10	3	localException2	java.lang.Exception
    //   227	10	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   256	10	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   20	180	4	localObject7	Object
    //   23	206	5	localObject8	Object
    //   26	232	6	localObject9	Object
    //   114	29	7	str	java.lang.String
    //   181	7	7	localObject10	Object
    //   74	62	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   141	150	159	finally
    //   141	150	163	java/lang/Exception
    //   141	150	169	java/lang/OutOfMemoryError
    //   141	150	175	java/io/FileNotFoundException
    //   104	118	181	finally
    //   183	185	181	finally
    //   92	100	190	finally
    //   102	104	190	finally
    //   120	128	190	finally
    //   131	141	190	finally
    //   187	190	190	finally
    //   204	214	190	finally
    //   233	243	190	finally
    //   262	272	190	finally
    //   92	100	198	java/lang/Exception
    //   102	104	198	java/lang/Exception
    //   120	128	198	java/lang/Exception
    //   131	141	198	java/lang/Exception
    //   187	190	198	java/lang/Exception
    //   92	100	227	java/lang/OutOfMemoryError
    //   102	104	227	java/lang/OutOfMemoryError
    //   120	128	227	java/lang/OutOfMemoryError
    //   131	141	227	java/lang/OutOfMemoryError
    //   187	190	227	java/lang/OutOfMemoryError
    //   92	100	256	java/io/FileNotFoundException
    //   102	104	256	java/io/FileNotFoundException
    //   120	128	256	java/io/FileNotFoundException
    //   131	141	256	java/io/FileNotFoundException
    //   187	190	256	java/io/FileNotFoundException
    //   150	158	285	java/io/IOException
    //   218	226	285	java/io/IOException
    //   247	255	285	java/io/IOException
    //   276	284	285	java/io/IOException
    //   301	309	312	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */