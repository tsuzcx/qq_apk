package com.tencent.mobileqq.app.utils;

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
    //   10: if_icmpne +103 -> 113
    //   13: aload_1
    //   14: getfield 26	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokeinterface 31 1 0
    //   22: iconst_1
    //   23: if_icmpne +90 -> 113
    //   26: aload_1
    //   27: getfield 34	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   30: aload_1
    //   31: getfield 37	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   34: invokeinterface 43 2 0
    //   39: checkcast 45	java/io/File
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 49	java/io/File:exists	()Z
    //   49: ifeq +64 -> 113
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
    //   78: invokestatic 71	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 74	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +20 -> 107
    //   90: aload_1
    //   91: ldc 76
    //   93: invokevirtual 82	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   96: lstore_2
    //   97: lconst_0
    //   98: lload_2
    //   99: lcmp
    //   100: ifeq +7 -> 107
    //   103: lload_2
    //   104: invokestatic 87	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler:a	(J)V
    //   107: aload 4
    //   109: invokevirtual 90	java/io/File:delete	()Z
    //   112: pop
    //   113: return
    //   114: astore_1
    //   115: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +31 -> 149
    //   121: ldc 97
    //   123: iconst_2
    //   124: new 51	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   131: ldc 99
    //   133: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload 4
    //   151: invokevirtual 90	java/io/File:delete	()Z
    //   154: pop
    //   155: return
    //   156: astore_1
    //   157: return
    //   158: astore_1
    //   159: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +31 -> 193
    //   165: ldc 97
    //   167: iconst_2
    //   168: new 51	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   175: ldc 108
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 109	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 4
    //   195: invokevirtual 90	java/io/File:delete	()Z
    //   198: pop
    //   199: return
    //   200: astore_1
    //   201: return
    //   202: astore_1
    //   203: aload 4
    //   205: invokevirtual 90	java/io/File:delete	()Z
    //   208: pop
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: return
    //   213: astore 4
    //   215: goto -6 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	ApolloDownloadListener
    //   0	218	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   96	8	2	l	long
    //   42	162	4	localFile	java.io.File
    //   213	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	86	114	java/lang/Exception
    //   90	97	114	java/lang/Exception
    //   103	107	114	java/lang/Exception
    //   149	155	156	java/lang/Exception
    //   52	86	158	java/lang/OutOfMemoryError
    //   90	97	158	java/lang/OutOfMemoryError
    //   103	107	158	java/lang/OutOfMemoryError
    //   193	199	200	java/lang/Exception
    //   52	86	202	finally
    //   90	97	202	finally
    //   103	107	202	finally
    //   115	149	202	finally
    //   159	193	202	finally
    //   107	113	211	java/lang/Exception
    //   203	209	213	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler.ApolloDownloadListener
 * JD-Core Version:    0.7.0.1
 */