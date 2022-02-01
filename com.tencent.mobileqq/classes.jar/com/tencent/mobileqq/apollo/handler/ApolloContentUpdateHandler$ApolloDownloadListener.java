package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.vip.DownloadListener;

public class ApolloContentUpdateHandler$ApolloDownloadListener
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
    //   160: invokestatic 103	com/tencent/mobileqq/apollo/handler/ApolloContentUpdateHandler:b	(J)V
    //   163: ldc 105
    //   165: invokestatic 111	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   168: checkcast 105	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   171: invokeinterface 115 1 0
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +20 -> 198
    //   181: aload_1
    //   182: ldc 117
    //   184: ldc 119
    //   186: invokevirtual 125	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   189: checkcast 117	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   192: iconst_1
    //   193: invokeinterface 129 2 0
    //   198: aload 4
    //   200: invokevirtual 132	java/io/File:delete	()Z
    //   203: pop
    //   204: return
    //   205: astore 4
    //   207: new 34	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   214: astore_1
    //   215: goto +122 -> 337
    //   218: astore_1
    //   219: goto +146 -> 365
    //   222: astore_1
    //   223: new 34	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   230: astore 5
    //   232: aload 5
    //   234: ldc 134
    //   236: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 5
    //   242: aload_1
    //   243: invokevirtual 137	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 46
    //   252: iconst_1
    //   253: aload 5
    //   255: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 4
    //   263: invokevirtual 132	java/io/File:delete	()Z
    //   266: pop
    //   267: return
    //   268: astore 4
    //   270: new 34	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   277: astore_1
    //   278: goto +59 -> 337
    //   281: astore_1
    //   282: new 34	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   289: astore 5
    //   291: aload 5
    //   293: ldc 139
    //   295: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 5
    //   301: aload_1
    //   302: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 46
    //   311: iconst_1
    //   312: aload 5
    //   314: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 4
    //   322: invokevirtual 132	java/io/File:delete	()Z
    //   325: pop
    //   326: return
    //   327: astore 4
    //   329: new 34	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   336: astore_1
    //   337: aload_1
    //   338: ldc 142
    //   340: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: aload 4
    //   347: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 46
    //   356: iconst_1
    //   357: aload_1
    //   358: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: return
    //   365: aload 4
    //   367: invokevirtual 132	java/io/File:delete	()Z
    //   370: pop
    //   371: goto +44 -> 415
    //   374: astore 4
    //   376: new 34	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   383: astore 5
    //   385: aload 5
    //   387: ldc 142
    //   389: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 5
    //   395: aload 4
    //   397: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc 46
    //   406: iconst_1
    //   407: aload 5
    //   409: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_1
    //   416: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	ApolloDownloadListener
    //   0	417	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   152	8	2	l	long
    //   34	165	4	localObject	java.lang.Object
    //   205	57	4	localException1	java.lang.Exception
    //   268	53	4	localException2	java.lang.Exception
    //   327	39	4	localException3	java.lang.Exception
    //   374	22	4	localException4	java.lang.Exception
    //   105	303	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	204	205	java/lang/Exception
    //   98	142	218	finally
    //   146	153	218	finally
    //   159	163	218	finally
    //   163	177	218	finally
    //   181	198	218	finally
    //   223	261	218	finally
    //   282	320	218	finally
    //   98	142	222	java/lang/OutOfMemoryError
    //   146	153	222	java/lang/OutOfMemoryError
    //   159	163	222	java/lang/OutOfMemoryError
    //   163	177	222	java/lang/OutOfMemoryError
    //   181	198	222	java/lang/OutOfMemoryError
    //   261	267	268	java/lang/Exception
    //   98	142	281	java/lang/Exception
    //   146	153	281	java/lang/Exception
    //   159	163	281	java/lang/Exception
    //   163	177	281	java/lang/Exception
    //   181	198	281	java/lang/Exception
    //   320	326	327	java/lang/Exception
    //   365	371	374	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener
 * JD-Core Version:    0.7.0.1
 */