package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.vip.DownloadListener;
import java.io.File;

class ApolloResDownloaderImpl$3
  extends DownloadListener
{
  ApolloResDownloaderImpl$3(ApolloResDownloaderImpl paramApolloResDownloaderImpl, File paramFile) {}
  
  /* Error */
  public void onDone(com.tencent.mobileqq.vip.DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 25	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   5: iconst_3
    //   6: aload_1
    //   7: invokevirtual 30	com/tencent/mobileqq/vip/DownloadTask:a	()I
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   18: invokevirtual 36	java/io/File:exists	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   29: astore_1
    //   30: new 38	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   43: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   46: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: getstatic 51	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 60	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   70: invokevirtual 63	java/io/File:delete	()Z
    //   73: pop
    //   74: return
    //   75: astore_1
    //   76: new 38	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   83: astore_2
    //   84: aload_2
    //   85: ldc 65
    //   87: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: aload_1
    //   93: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 70
    //   102: iconst_1
    //   103: aload_2
    //   104: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    //   111: astore_1
    //   112: goto +115 -> 227
    //   115: astore_1
    //   116: new 38	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc 78
    //   127: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 79	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: ldc 70
    //   142: iconst_1
    //   143: aload_2
    //   144: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   154: invokevirtual 63	java/io/File:delete	()Z
    //   157: pop
    //   158: return
    //   159: astore_1
    //   160: new 38	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   167: astore_2
    //   168: goto -84 -> 84
    //   171: astore_1
    //   172: new 38	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: ldc 81
    //   183: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: aload_1
    //   189: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 70
    //   198: iconst_1
    //   199: aload_2
    //   200: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   210: invokevirtual 63	java/io/File:delete	()Z
    //   213: pop
    //   214: return
    //   215: astore_1
    //   216: new 38	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   223: astore_2
    //   224: goto -140 -> 84
    //   227: aload_0
    //   228: getfield 13	com/tencent/mobileqq/apollo/res/api/impl/ApolloResDownloaderImpl$3:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   231: invokevirtual 63	java/io/File:delete	()Z
    //   234: pop
    //   235: goto +38 -> 273
    //   238: astore_2
    //   239: new 38	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   246: astore_3
    //   247: aload_3
    //   248: ldc 65
    //   250: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: aload_2
    //   256: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 70
    //   265: iconst_1
    //   266: aload_3
    //   267: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto +5 -> 278
    //   276: aload_1
    //   277: athrow
    //   278: goto -2 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	3
    //   0	281	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   37	187	2	localStringBuilder1	java.lang.StringBuilder
    //   238	18	2	localException	java.lang.Exception
    //   246	21	3	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	74	75	java/lang/Exception
    //   25	66	111	finally
    //   116	150	111	finally
    //   172	206	111	finally
    //   25	66	115	java/lang/OutOfMemoryError
    //   150	158	159	java/lang/Exception
    //   25	66	171	java/lang/Exception
    //   206	214	215	java/lang/Exception
    //   227	235	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.3
 * JD-Core Version:    0.7.0.1
 */