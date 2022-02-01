package com.huawei.hms.utils;

import java.io.File;

public final class FileUtil$a
  implements Runnable
{
  public FileUtil$a(File paramFile, long paramLong, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/huawei/hms/utils/FileUtil$a:a	Ljava/io/File;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnonnull +11 -> 19
    //   11: ldc 29
    //   13: ldc 31
    //   15: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: return
    //   19: aload 5
    //   21: invokevirtual 43	java/io/File:getParentFile	()Ljava/io/File;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +305 -> 333
    //   31: aload 5
    //   33: invokevirtual 47	java/io/File:mkdirs	()Z
    //   36: ifne +14 -> 50
    //   39: aload 5
    //   41: invokevirtual 50	java/io/File:isDirectory	()Z
    //   44: ifne +6 -> 50
    //   47: goto +286 -> 333
    //   50: aconst_null
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 5
    //   56: aload 5
    //   58: astore 7
    //   60: aload 8
    //   62: astore 6
    //   64: aload_0
    //   65: getfield 16	com/huawei/hms/utils/FileUtil$a:a	Ljava/io/File;
    //   68: invokevirtual 54	java/io/File:length	()J
    //   71: lstore_1
    //   72: aload 5
    //   74: astore 7
    //   76: aload 8
    //   78: astore 6
    //   80: aload_0
    //   81: getfield 18	com/huawei/hms/utils/FileUtil$a:b	J
    //   84: lstore_3
    //   85: lload_1
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +84 -> 172
    //   91: aload 5
    //   93: astore 7
    //   95: aload 8
    //   97: astore 6
    //   99: aload_0
    //   100: getfield 16	com/huawei/hms/utils/FileUtil$a:a	Ljava/io/File;
    //   103: invokevirtual 58	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   106: astore 9
    //   108: aload 5
    //   110: astore 7
    //   112: aload 8
    //   114: astore 6
    //   116: aload_0
    //   117: getfield 16	com/huawei/hms/utils/FileUtil$a:a	Ljava/io/File;
    //   120: invokevirtual 61	java/io/File:delete	()Z
    //   123: ifne +18 -> 141
    //   126: aload 5
    //   128: astore 7
    //   130: aload 8
    //   132: astore 6
    //   134: ldc 29
    //   136: ldc 63
    //   138: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 5
    //   143: astore 7
    //   145: aload 8
    //   147: astore 6
    //   149: new 65	java/io/RandomAccessFile
    //   152: dup
    //   153: new 39	java/io/File
    //   156: dup
    //   157: aload 9
    //   159: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: ldc 70
    //   164: invokespecial 73	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   167: astore 5
    //   169: goto +32 -> 201
    //   172: aload 5
    //   174: astore 7
    //   176: aload 8
    //   178: astore 6
    //   180: new 65	java/io/RandomAccessFile
    //   183: dup
    //   184: aload_0
    //   185: getfield 16	com/huawei/hms/utils/FileUtil$a:a	Ljava/io/File;
    //   188: ldc 70
    //   190: invokespecial 73	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   193: astore 5
    //   195: aload 5
    //   197: lload_1
    //   198: invokevirtual 77	java/io/RandomAccessFile:seek	(J)V
    //   201: aload 5
    //   203: astore 7
    //   205: aload 5
    //   207: astore 6
    //   209: new 79	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   216: astore 8
    //   218: aload 5
    //   220: astore 7
    //   222: aload 5
    //   224: astore 6
    //   226: aload 8
    //   228: aload_0
    //   229: getfield 20	com/huawei/hms/utils/FileUtil$a:c	Ljava/lang/String;
    //   232: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 5
    //   238: astore 7
    //   240: aload 5
    //   242: astore 6
    //   244: aload 8
    //   246: ldc 86
    //   248: invokestatic 92	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 5
    //   257: astore 7
    //   259: aload 5
    //   261: astore 6
    //   263: aload 5
    //   265: aload 8
    //   267: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 98	java/io/RandomAccessFile:writeBytes	(Ljava/lang/String;)V
    //   273: goto +44 -> 317
    //   276: astore 6
    //   278: aload 7
    //   280: astore 5
    //   282: aload 6
    //   284: astore 7
    //   286: goto +18 -> 304
    //   289: astore 7
    //   291: aload 5
    //   293: astore 6
    //   295: aload 7
    //   297: astore 5
    //   299: goto +26 -> 325
    //   302: astore 7
    //   304: aload 5
    //   306: astore 6
    //   308: ldc 29
    //   310: ldc 100
    //   312: aload 7
    //   314: invokestatic 103	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: aload 5
    //   319: invokestatic 109	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   322: return
    //   323: astore 5
    //   325: aload 6
    //   327: invokestatic 109	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   330: aload 5
    //   332: athrow
    //   333: ldc 29
    //   335: ldc 111
    //   337: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	a
    //   71	127	1	l1	long
    //   84	3	3	l2	long
    //   4	314	5	localObject1	Object
    //   323	8	5	localObject2	Object
    //   62	200	6	localObject3	Object
    //   276	7	6	localIOException1	java.io.IOException
    //   293	33	6	localObject4	Object
    //   58	227	7	localObject5	Object
    //   289	7	7	localObject6	Object
    //   302	11	7	localIOException2	java.io.IOException
    //   51	215	8	localStringBuilder	java.lang.StringBuilder
    //   106	52	9	str	String
    // Exception table:
    //   from	to	target	type
    //   64	72	276	java/io/IOException
    //   80	85	276	java/io/IOException
    //   99	108	276	java/io/IOException
    //   116	126	276	java/io/IOException
    //   134	141	276	java/io/IOException
    //   149	169	276	java/io/IOException
    //   180	195	276	java/io/IOException
    //   209	218	276	java/io/IOException
    //   226	236	276	java/io/IOException
    //   244	255	276	java/io/IOException
    //   263	273	276	java/io/IOException
    //   195	201	289	finally
    //   195	201	302	java/io/IOException
    //   64	72	323	finally
    //   80	85	323	finally
    //   99	108	323	finally
    //   116	126	323	finally
    //   134	141	323	finally
    //   149	169	323	finally
    //   180	195	323	finally
    //   209	218	323	finally
    //   226	236	323	finally
    //   244	255	323	finally
    //   263	273	323	finally
    //   308	317	323	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.utils.FileUtil.a
 * JD-Core Version:    0.7.0.1
 */