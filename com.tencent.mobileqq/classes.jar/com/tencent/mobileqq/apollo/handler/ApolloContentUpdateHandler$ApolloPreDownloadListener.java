package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.vip.DownloadListener;

public class ApolloContentUpdateHandler$ApolloPreDownloadListener
  extends DownloadListener
{
  /* Error */
  public void onDone(com.tencent.mobileqq.vip.DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 17	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   5: iconst_3
    //   6: aload_1
    //   7: invokevirtual 23	com/tencent/mobileqq/vip/DownloadTask:e	()I
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 27	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/util/List;
    //   18: invokeinterface 32 1 0
    //   23: iconst_1
    //   24: if_icmpeq +47 -> 71
    //   27: new 34	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: aload 4
    //   38: ldc 37
    //   40: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_1
    //   47: getfield 27	com/tencent/mobileqq/vip/DownloadTask:f	Ljava/util/List;
    //   50: invokeinterface 32 1 0
    //   55: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 46
    //   61: iconst_1
    //   62: aload 4
    //   64: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: return
    //   71: aload_1
    //   72: getfield 59	com/tencent/mobileqq/vip/DownloadTask:g	Ljava/util/Map;
    //   75: aload_1
    //   76: getfield 63	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   79: invokeinterface 69 2 0
    //   84: checkcast 71	java/io/File
    //   87: astore 4
    //   89: aload 4
    //   91: invokevirtual 75	java/io/File:exists	()Z
    //   94: ifne +4 -> 98
    //   97: return
    //   98: new 34	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: aload 4
    //   111: invokevirtual 78	java/io/File:getParent	()Ljava/lang/String;
    //   114: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 5
    //   120: getstatic 81	java/io/File:separator	Ljava/lang/String;
    //   123: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: aload 5
    //   131: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 87	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   137: aload_1
    //   138: invokevirtual 90	com/tencent/mobileqq/vip/DownloadTask:b	()Landroid/os/Bundle;
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +20 -> 163
    //   146: aload_1
    //   147: ldc 92
    //   149: invokevirtual 98	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   152: lstore_2
    //   153: lconst_0
    //   154: lload_2
    //   155: lcmp
    //   156: ifeq +7 -> 163
    //   159: lload_2
    //   160: invokestatic 104	com/tencent/mobileqq/apollo/handler/ApolloContentUpdateHandler:a	(J)V
    //   163: aload 4
    //   165: invokevirtual 107	java/io/File:delete	()Z
    //   168: pop
    //   169: return
    //   170: astore 4
    //   172: new 34	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   179: astore_1
    //   180: aload_1
    //   181: ldc 109
    //   183: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: aload 4
    //   190: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 46
    //   199: iconst_1
    //   200: aload_1
    //   201: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: return
    //   208: astore_1
    //   209: goto +121 -> 330
    //   212: astore_1
    //   213: new 34	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   220: astore 5
    //   222: aload 5
    //   224: ldc 114
    //   226: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 5
    //   232: aload_1
    //   233: invokevirtual 115	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 46
    //   242: iconst_1
    //   243: aload 5
    //   245: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload 4
    //   253: invokevirtual 107	java/io/File:delete	()Z
    //   256: pop
    //   257: return
    //   258: astore 4
    //   260: new 34	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   267: astore_1
    //   268: goto -88 -> 180
    //   271: astore_1
    //   272: new 34	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   279: astore 5
    //   281: aload 5
    //   283: ldc 117
    //   285: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 5
    //   291: aload_1
    //   292: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 46
    //   301: iconst_1
    //   302: aload 5
    //   304: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload 4
    //   312: invokevirtual 107	java/io/File:delete	()Z
    //   315: pop
    //   316: return
    //   317: astore 4
    //   319: new 34	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   326: astore_1
    //   327: goto -147 -> 180
    //   330: aload 4
    //   332: invokevirtual 107	java/io/File:delete	()Z
    //   335: pop
    //   336: goto +44 -> 380
    //   339: astore 4
    //   341: new 34	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   348: astore 5
    //   350: aload 5
    //   352: ldc 109
    //   354: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: aload 4
    //   362: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: ldc 46
    //   371: iconst_1
    //   372: aload 5
    //   374: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto +5 -> 385
    //   383: aload_1
    //   384: athrow
    //   385: goto -2 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	ApolloPreDownloadListener
    //   0	388	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   152	8	2	l	long
    //   34	130	4	localObject	java.lang.Object
    //   170	82	4	localException1	java.lang.Exception
    //   258	53	4	localException2	java.lang.Exception
    //   317	14	4	localException3	java.lang.Exception
    //   339	22	4	localException4	java.lang.Exception
    //   105	268	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   163	169	170	java/lang/Exception
    //   98	142	208	finally
    //   146	153	208	finally
    //   159	163	208	finally
    //   213	251	208	finally
    //   272	310	208	finally
    //   98	142	212	java/lang/OutOfMemoryError
    //   146	153	212	java/lang/OutOfMemoryError
    //   159	163	212	java/lang/OutOfMemoryError
    //   251	257	258	java/lang/Exception
    //   98	142	271	java/lang/Exception
    //   146	153	271	java/lang/Exception
    //   159	163	271	java/lang/Exception
    //   310	316	317	java/lang/Exception
    //   330	336	339	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloPreDownloadListener
 * JD-Core Version:    0.7.0.1
 */