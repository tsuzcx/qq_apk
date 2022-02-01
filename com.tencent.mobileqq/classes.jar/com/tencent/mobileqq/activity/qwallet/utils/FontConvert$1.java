package com.tencent.mobileqq.activity.qwallet.utils;

import akwp;

public class FontConvert$1
  implements Runnable
{
  public FontConvert$1(akwp paramakwp) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   6: invokevirtual 27	akwp:a	()Ljava/lang/String;
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 33	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +24 -> 44
    //   23: iconst_0
    //   24: ifeq +11 -> 35
    //   27: new 35	java/lang/NullPointerException
    //   30: dup
    //   31: invokespecial 36	java/lang/NullPointerException:<init>	()V
    //   34: athrow
    //   35: return
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   43: return
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   48: iconst_1
    //   49: invokestatic 42	akwp:a	(Lakwp;Z)Z
    //   52: pop
    //   53: new 44	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   60: aload 5
    //   62: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: getstatic 55	java/io/File:separator	Ljava/lang/String;
    //   68: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 5
    //   76: new 60	java/io/BufferedReader
    //   79: dup
    //   80: new 62	java/io/FileReader
    //   83: dup
    //   84: new 51	java/io/File
    //   87: dup
    //   88: new 44	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   95: aload 5
    //   97: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 64
    //   102: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 70	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   114: invokespecial 73	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   117: astore 6
    //   119: aload 6
    //   121: astore 5
    //   123: new 44	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   130: astore 8
    //   132: aload 6
    //   134: astore 5
    //   136: new 44	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   143: astore 7
    //   145: aload 6
    //   147: astore 5
    //   149: aload 6
    //   151: invokevirtual 77	java/io/BufferedReader:read	()I
    //   154: istore_3
    //   155: iload_3
    //   156: iconst_m1
    //   157: if_icmpeq +106 -> 263
    //   160: iload_3
    //   161: i2c
    //   162: istore_1
    //   163: iload_1
    //   164: bipush 13
    //   166: if_icmpeq +256 -> 422
    //   169: iload_1
    //   170: bipush 10
    //   172: if_icmpne +6 -> 178
    //   175: goto +247 -> 422
    //   178: iload_2
    //   179: ifeq +47 -> 226
    //   182: aload 6
    //   184: astore 5
    //   186: aload 8
    //   188: iload_1
    //   189: invokevirtual 80	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: goto -48 -> 145
    //   196: astore 7
    //   198: aload 6
    //   200: astore 5
    //   202: aload 7
    //   204: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   207: aload 6
    //   209: ifnull -174 -> 35
    //   212: aload 6
    //   214: invokevirtual 84	java/io/BufferedReader:close	()V
    //   217: return
    //   218: astore 5
    //   220: aload 5
    //   222: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   225: return
    //   226: aload 6
    //   228: astore 5
    //   230: aload 7
    //   232: iload_1
    //   233: invokevirtual 80	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: goto -92 -> 145
    //   240: astore 7
    //   242: aload 5
    //   244: astore 6
    //   246: aload 7
    //   248: astore 5
    //   250: aload 6
    //   252: ifnull +8 -> 260
    //   255: aload 6
    //   257: invokevirtual 84	java/io/BufferedReader:close	()V
    //   260: aload 5
    //   262: athrow
    //   263: aload 6
    //   265: astore 5
    //   267: aload_0
    //   268: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   271: aload 8
    //   273: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 87	akwp:a	(Lakwp;Ljava/lang/String;)Ljava/lang/String;
    //   279: pop
    //   280: aload 6
    //   282: astore 5
    //   284: aload_0
    //   285: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   288: aload 7
    //   290: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 90	akwp:b	(Lakwp;Ljava/lang/String;)Ljava/lang/String;
    //   296: pop
    //   297: aload 6
    //   299: astore 5
    //   301: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +73 -> 377
    //   307: aload 6
    //   309: astore 5
    //   311: ldc 98
    //   313: iconst_2
    //   314: new 44	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   321: ldc 100
    //   323: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_0
    //   327: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   330: invokestatic 103	akwp:a	(Lakwp;)Ljava/lang/String;
    //   333: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload 6
    //   344: astore 5
    //   346: ldc 98
    //   348: iconst_2
    //   349: new 44	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   356: ldc 109
    //   358: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: getfield 12	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:this$0	Lakwp;
    //   365: invokestatic 111	akwp:b	(Lakwp;)Ljava/lang/String;
    //   368: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 6
    //   379: ifnull -344 -> 35
    //   382: aload 6
    //   384: invokevirtual 84	java/io/BufferedReader:close	()V
    //   387: return
    //   388: astore 5
    //   390: aload 5
    //   392: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   395: return
    //   396: astore 6
    //   398: aload 6
    //   400: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   403: goto -143 -> 260
    //   406: astore 5
    //   408: aconst_null
    //   409: astore 6
    //   411: goto -161 -> 250
    //   414: astore 7
    //   416: aconst_null
    //   417: astore 6
    //   419: goto -221 -> 198
    //   422: iconst_0
    //   423: istore_2
    //   424: goto -279 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	1
    //   162	71	1	c	char
    //   1	423	2	i	int
    //   154	7	3	j	int
    //   16	3	4	bool	boolean
    //   9	3	5	str	java.lang.String
    //   36	25	5	localException1	java.lang.Exception
    //   74	127	5	localObject1	Object
    //   218	3	5	localException2	java.lang.Exception
    //   228	117	5	localObject2	Object
    //   388	3	5	localException3	java.lang.Exception
    //   406	1	5	localObject3	Object
    //   117	266	6	localObject4	Object
    //   396	3	6	localException4	java.lang.Exception
    //   409	9	6	localObject5	Object
    //   143	1	7	localStringBuilder1	java.lang.StringBuilder
    //   196	35	7	localThrowable1	java.lang.Throwable
    //   240	49	7	localObject6	Object
    //   414	1	7	localThrowable2	java.lang.Throwable
    //   130	142	8	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	35	36	java/lang/Exception
    //   123	132	196	java/lang/Throwable
    //   136	145	196	java/lang/Throwable
    //   149	155	196	java/lang/Throwable
    //   186	193	196	java/lang/Throwable
    //   230	237	196	java/lang/Throwable
    //   267	280	196	java/lang/Throwable
    //   284	297	196	java/lang/Throwable
    //   301	307	196	java/lang/Throwable
    //   311	342	196	java/lang/Throwable
    //   346	377	196	java/lang/Throwable
    //   212	217	218	java/lang/Exception
    //   123	132	240	finally
    //   136	145	240	finally
    //   149	155	240	finally
    //   186	193	240	finally
    //   202	207	240	finally
    //   230	237	240	finally
    //   267	280	240	finally
    //   284	297	240	finally
    //   301	307	240	finally
    //   311	342	240	finally
    //   346	377	240	finally
    //   382	387	388	java/lang/Exception
    //   255	260	396	java/lang/Exception
    //   2	18	406	finally
    //   44	119	406	finally
    //   2	18	414	java/lang/Throwable
    //   44	119	414	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.FontConvert.1
 * JD-Core Version:    0.7.0.1
 */