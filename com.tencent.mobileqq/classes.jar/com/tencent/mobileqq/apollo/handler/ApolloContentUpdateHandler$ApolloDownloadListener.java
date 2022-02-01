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
    //   7: invokevirtual 23	com/tencent/mobileqq/vip/DownloadTask:a	()I
    //   10: if_icmpne +138 -> 148
    //   13: aload_1
    //   14: getfield 26	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokeinterface 31 1 0
    //   22: iconst_1
    //   23: if_icmpne +125 -> 148
    //   26: aload_1
    //   27: getfield 34	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   30: aload_1
    //   31: getfield 37	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   34: invokeinterface 43 2 0
    //   39: checkcast 45	java/io/File
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 49	java/io/File:exists	()Z
    //   49: ifeq +99 -> 148
    //   52: aload 4
    //   54: new 51	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   61: aload 4
    //   63: invokevirtual 56	java/io/File:getParent	()Ljava/lang/String;
    //   66: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 72	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 75	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +20 -> 107
    //   90: aload_1
    //   91: ldc 77
    //   93: invokevirtual 83	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   96: lstore_2
    //   97: lconst_0
    //   98: lload_2
    //   99: lcmp
    //   100: ifeq +7 -> 107
    //   103: lload_2
    //   104: invokestatic 89	com/tencent/mobileqq/apollo/handler/ApolloContentUpdateHandler:b	(J)V
    //   107: ldc 91
    //   109: invokestatic 97	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   112: checkcast 91	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   115: invokeinterface 101 1 0
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +20 -> 142
    //   125: aload_1
    //   126: ldc 103
    //   128: ldc 105
    //   130: invokevirtual 111	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   133: checkcast 103	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   136: iconst_1
    //   137: invokeinterface 115 2 0
    //   142: aload 4
    //   144: invokevirtual 118	java/io/File:delete	()Z
    //   147: pop
    //   148: return
    //   149: astore_1
    //   150: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +31 -> 184
    //   156: ldc 125
    //   158: iconst_2
    //   159: new 51	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   166: ldc 127
    //   168: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 4
    //   186: invokevirtual 118	java/io/File:delete	()Z
    //   189: pop
    //   190: return
    //   191: astore_1
    //   192: return
    //   193: astore_1
    //   194: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +31 -> 228
    //   200: ldc 125
    //   202: iconst_2
    //   203: new 51	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   210: ldc 136
    //   212: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 137	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload 4
    //   230: invokevirtual 118	java/io/File:delete	()Z
    //   233: pop
    //   234: return
    //   235: astore_1
    //   236: return
    //   237: astore_1
    //   238: aload 4
    //   240: invokevirtual 118	java/io/File:delete	()Z
    //   243: pop
    //   244: aload_1
    //   245: athrow
    //   246: astore_1
    //   247: return
    //   248: astore 4
    //   250: goto -6 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ApolloDownloadListener
    //   0	253	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   96	8	2	l	long
    //   42	197	4	localFile	java.io.File
    //   248	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	86	149	java/lang/Exception
    //   90	97	149	java/lang/Exception
    //   103	107	149	java/lang/Exception
    //   107	121	149	java/lang/Exception
    //   125	142	149	java/lang/Exception
    //   184	190	191	java/lang/Exception
    //   52	86	193	java/lang/OutOfMemoryError
    //   90	97	193	java/lang/OutOfMemoryError
    //   103	107	193	java/lang/OutOfMemoryError
    //   107	121	193	java/lang/OutOfMemoryError
    //   125	142	193	java/lang/OutOfMemoryError
    //   228	234	235	java/lang/Exception
    //   52	86	237	finally
    //   90	97	237	finally
    //   103	107	237	finally
    //   107	121	237	finally
    //   125	142	237	finally
    //   150	184	237	finally
    //   194	228	237	finally
    //   142	148	246	java/lang/Exception
    //   238	244	248	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener
 * JD-Core Version:    0.7.0.1
 */