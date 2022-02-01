package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

public class ExoMediaPlayerUtils
{
  public static String getLogcatContent()
  {
    return getLogcatContent(0, null, 10);
  }
  
  /* Error */
  public static String getLogcatContent(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 24	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: iload_2
    //   6: sipush 1000
    //   9: imul
    //   10: i2l
    //   11: lstore 7
    //   13: invokestatic 30	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   16: iconst_1
    //   17: invokevirtual 34	java/util/Calendar:get	(I)I
    //   20: istore 4
    //   22: new 36	java/text/SimpleDateFormat
    //   25: dup
    //   26: ldc 38
    //   28: invokestatic 44	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   31: invokespecial 47	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   34: astore 13
    //   36: aload_1
    //   37: ifnonnull +36 -> 73
    //   40: iconst_4
    //   41: anewarray 49	java/lang/String
    //   44: astore 12
    //   46: aload 12
    //   48: iconst_0
    //   49: ldc 51
    //   51: aastore
    //   52: aload 12
    //   54: iconst_1
    //   55: ldc 53
    //   57: aastore
    //   58: aload 12
    //   60: iconst_2
    //   61: ldc 55
    //   63: aastore
    //   64: aload 12
    //   66: iconst_3
    //   67: ldc 57
    //   69: aastore
    //   70: goto +45 -> 115
    //   73: bipush 6
    //   75: anewarray 49	java/lang/String
    //   78: astore 12
    //   80: aload 12
    //   82: iconst_0
    //   83: ldc 51
    //   85: aastore
    //   86: aload 12
    //   88: iconst_1
    //   89: ldc 53
    //   91: aastore
    //   92: aload 12
    //   94: iconst_2
    //   95: ldc 55
    //   97: aastore
    //   98: aload 12
    //   100: iconst_3
    //   101: ldc 57
    //   103: aastore
    //   104: aload 12
    //   106: iconst_4
    //   107: ldc 59
    //   109: aastore
    //   110: aload 12
    //   112: iconst_5
    //   113: aload_1
    //   114: aastore
    //   115: aconst_null
    //   116: astore 11
    //   118: aconst_null
    //   119: astore_1
    //   120: new 61	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   127: astore 14
    //   129: invokestatic 68	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   132: aload 12
    //   134: invokevirtual 72	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   137: astore 12
    //   139: aload 12
    //   141: astore_1
    //   142: aload 12
    //   144: astore 11
    //   146: new 74	java/io/BufferedReader
    //   149: dup
    //   150: new 76	java/io/InputStreamReader
    //   153: dup
    //   154: aload 12
    //   156: invokevirtual 82	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   159: invokespecial 85	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   162: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   165: astore 15
    //   167: iconst_0
    //   168: istore_2
    //   169: aload 12
    //   171: astore_1
    //   172: aload 12
    //   174: astore 11
    //   176: aload 15
    //   178: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   181: astore 16
    //   183: aload 16
    //   185: ifnull +247 -> 432
    //   188: aload 12
    //   190: astore_1
    //   191: aload 12
    //   193: astore 11
    //   195: aload 16
    //   197: ldc 93
    //   199: invokevirtual 97	java/lang/String:matches	(Ljava/lang/String;)Z
    //   202: ifeq +517 -> 719
    //   205: aload 12
    //   207: astore_1
    //   208: aload 12
    //   210: astore 11
    //   212: aload 16
    //   214: iconst_0
    //   215: bipush 18
    //   217: invokevirtual 101	java/lang/String:substring	(II)Ljava/lang/String;
    //   220: astore 17
    //   222: aload 12
    //   224: astore_1
    //   225: aload 12
    //   227: astore 11
    //   229: new 61	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   236: astore 18
    //   238: aload 12
    //   240: astore_1
    //   241: aload 12
    //   243: astore 11
    //   245: aload 18
    //   247: iload 4
    //   249: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 12
    //   255: astore_1
    //   256: aload 12
    //   258: astore 11
    //   260: aload 18
    //   262: ldc 107
    //   264: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 12
    //   270: astore_1
    //   271: aload 12
    //   273: astore 11
    //   275: aload 18
    //   277: aload 17
    //   279: iconst_0
    //   280: bipush 18
    //   282: invokevirtual 101	java/lang/String:substring	(II)Ljava/lang/String;
    //   285: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 12
    //   291: astore_1
    //   292: aload 12
    //   294: astore 11
    //   296: aload 13
    //   298: aload 18
    //   300: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 117	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   306: invokevirtual 122	java/util/Date:getTime	()J
    //   309: lstore 9
    //   311: lload 9
    //   313: lload 5
    //   315: lcmp
    //   316: ifle +6 -> 322
    //   319: goto +113 -> 432
    //   322: iload_2
    //   323: istore_3
    //   324: lload 9
    //   326: lload 5
    //   328: lload 7
    //   330: lsub
    //   331: lcmp
    //   332: ifle +56 -> 388
    //   335: iload_2
    //   336: istore_3
    //   337: iload_2
    //   338: ifne +20 -> 358
    //   341: aload 12
    //   343: astore_1
    //   344: aload 12
    //   346: astore 11
    //   348: aload 14
    //   350: ldc 124
    //   352: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: iconst_1
    //   357: istore_3
    //   358: aload 12
    //   360: astore_1
    //   361: aload 12
    //   363: astore 11
    //   365: aload 14
    //   367: aload 16
    //   369: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 12
    //   375: astore_1
    //   376: aload 12
    //   378: astore 11
    //   380: aload 14
    //   382: ldc 126
    //   384: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: iload_0
    //   389: ifle +325 -> 714
    //   392: aload 12
    //   394: astore_1
    //   395: aload 12
    //   397: astore 11
    //   399: aload 14
    //   401: invokevirtual 130	java/lang/StringBuilder:length	()I
    //   404: iload_0
    //   405: if_icmple +309 -> 714
    //   408: aload 12
    //   410: astore_1
    //   411: aload 12
    //   413: astore 11
    //   415: aload 14
    //   417: iconst_0
    //   418: aload 14
    //   420: invokevirtual 130	java/lang/StringBuilder:length	()I
    //   423: iload_0
    //   424: isub
    //   425: invokevirtual 134	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: goto +285 -> 714
    //   432: aload 12
    //   434: astore_1
    //   435: aload 12
    //   437: astore 11
    //   439: aload 14
    //   441: ldc 136
    //   443: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 12
    //   449: astore_1
    //   450: aload 12
    //   452: astore 11
    //   454: aload 14
    //   456: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: astore 13
    //   461: aload 12
    //   463: ifnull +51 -> 514
    //   466: aload 12
    //   468: invokevirtual 140	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   471: invokevirtual 145	java/io/OutputStream:close	()V
    //   474: goto +8 -> 482
    //   477: astore_1
    //   478: aload_1
    //   479: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   482: aload 12
    //   484: invokevirtual 82	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   487: invokevirtual 151	java/io/InputStream:close	()V
    //   490: goto +8 -> 498
    //   493: astore_1
    //   494: aload_1
    //   495: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   498: aload 12
    //   500: invokevirtual 154	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   503: invokevirtual 151	java/io/InputStream:close	()V
    //   506: aload 13
    //   508: areturn
    //   509: astore_1
    //   510: aload_1
    //   511: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   514: aload 13
    //   516: areturn
    //   517: astore 11
    //   519: goto +133 -> 652
    //   522: astore 12
    //   524: aload 11
    //   526: astore_1
    //   527: new 61	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   534: astore 13
    //   536: aload 11
    //   538: astore_1
    //   539: aload 13
    //   541: ldc 156
    //   543: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 11
    //   549: astore_1
    //   550: aload 13
    //   552: aload 12
    //   554: invokevirtual 157	java/lang/Throwable:toString	()Ljava/lang/String;
    //   557: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 11
    //   563: astore_1
    //   564: aload 13
    //   566: ldc 159
    //   568: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 11
    //   574: astore_1
    //   575: aload 14
    //   577: aload 13
    //   579: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 11
    //   588: astore_1
    //   589: aload 14
    //   591: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: astore 12
    //   596: aload 11
    //   598: ifnull +51 -> 649
    //   601: aload 11
    //   603: invokevirtual 140	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   606: invokevirtual 145	java/io/OutputStream:close	()V
    //   609: goto +8 -> 617
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   617: aload 11
    //   619: invokevirtual 82	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   622: invokevirtual 151	java/io/InputStream:close	()V
    //   625: goto +8 -> 633
    //   628: astore_1
    //   629: aload_1
    //   630: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   633: aload 11
    //   635: invokevirtual 154	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   638: invokevirtual 151	java/io/InputStream:close	()V
    //   641: aload 12
    //   643: areturn
    //   644: astore_1
    //   645: aload_1
    //   646: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   649: aload 12
    //   651: areturn
    //   652: aload_1
    //   653: ifnull +52 -> 705
    //   656: aload_1
    //   657: invokevirtual 140	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   660: invokevirtual 145	java/io/OutputStream:close	()V
    //   663: goto +10 -> 673
    //   666: astore 12
    //   668: aload 12
    //   670: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   673: aload_1
    //   674: invokevirtual 82	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   677: invokevirtual 151	java/io/InputStream:close	()V
    //   680: goto +10 -> 690
    //   683: astore 12
    //   685: aload 12
    //   687: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   690: aload_1
    //   691: invokevirtual 154	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   694: invokevirtual 151	java/io/InputStream:close	()V
    //   697: goto +8 -> 705
    //   700: astore_1
    //   701: aload_1
    //   702: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   705: goto +6 -> 711
    //   708: aload 11
    //   710: athrow
    //   711: goto -3 -> 708
    //   714: iload_3
    //   715: istore_2
    //   716: goto -547 -> 169
    //   719: goto -550 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	paramInt1	int
    //   0	722	1	paramString	String
    //   0	722	2	paramInt2	int
    //   323	392	3	i	int
    //   20	228	4	j	int
    //   3	324	5	l1	long
    //   11	318	7	l2	long
    //   309	16	9	l3	long
    //   116	337	11	localObject1	Object
    //   517	192	11	localObject2	Object
    //   44	455	12	localObject3	Object
    //   522	31	12	localThrowable	Throwable
    //   594	56	12	str1	String
    //   666	3	12	localIOException1	java.io.IOException
    //   683	3	12	localIOException2	java.io.IOException
    //   34	544	13	localObject4	Object
    //   127	463	14	localStringBuilder1	StringBuilder
    //   165	12	15	localBufferedReader	java.io.BufferedReader
    //   181	187	16	str2	String
    //   220	58	17	str3	String
    //   236	63	18	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   466	474	477	java/io/IOException
    //   482	490	493	java/io/IOException
    //   498	506	509	java/io/IOException
    //   129	139	517	finally
    //   146	167	517	finally
    //   176	183	517	finally
    //   195	205	517	finally
    //   212	222	517	finally
    //   229	238	517	finally
    //   245	253	517	finally
    //   260	268	517	finally
    //   275	289	517	finally
    //   296	311	517	finally
    //   348	356	517	finally
    //   365	373	517	finally
    //   380	388	517	finally
    //   399	408	517	finally
    //   415	429	517	finally
    //   439	447	517	finally
    //   454	461	517	finally
    //   527	536	517	finally
    //   539	547	517	finally
    //   550	561	517	finally
    //   564	572	517	finally
    //   575	586	517	finally
    //   589	596	517	finally
    //   129	139	522	java/lang/Throwable
    //   146	167	522	java/lang/Throwable
    //   176	183	522	java/lang/Throwable
    //   195	205	522	java/lang/Throwable
    //   212	222	522	java/lang/Throwable
    //   229	238	522	java/lang/Throwable
    //   245	253	522	java/lang/Throwable
    //   260	268	522	java/lang/Throwable
    //   275	289	522	java/lang/Throwable
    //   296	311	522	java/lang/Throwable
    //   348	356	522	java/lang/Throwable
    //   365	373	522	java/lang/Throwable
    //   380	388	522	java/lang/Throwable
    //   399	408	522	java/lang/Throwable
    //   415	429	522	java/lang/Throwable
    //   439	447	522	java/lang/Throwable
    //   454	461	522	java/lang/Throwable
    //   601	609	612	java/io/IOException
    //   617	625	628	java/io/IOException
    //   633	641	644	java/io/IOException
    //   656	663	666	java/io/IOException
    //   673	680	683	java/io/IOException
    //   690	697	700	java/io/IOException
  }
  
  public static String getPrintableStackTrace(Throwable paramThrowable)
  {
    return getPrintableStackTrace(paramThrowable, false);
  }
  
  private static String getPrintableStackTrace(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();
    } else {
      paramThrowable = paramThrowable.getCause();
    }
    if (paramThrowable != null)
    {
      localStringBuilder.append("caused by: ");
      localStringBuilder.append(paramThrowable.toString());
      localStringBuilder.append("\n");
      localStringBuilder.append(getPrintableStackTrace(paramThrowable, true));
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String join(Iterator<String> paramIterator, String paramString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramIterator != null) {
      for (;;)
      {
        localObject2 = localObject1;
        if (!paramIterator.hasNext()) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)paramIterator.next());
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (paramIterator.hasNext())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject2;
  }
  
  public static String join(List<String> paramList)
  {
    return join(paramList, "|");
  }
  
  public static String join(List<String> paramList, String paramString)
  {
    if (paramList != null) {
      return join(paramList.iterator(), paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayerUtils
 * JD-Core Version:    0.7.0.1
 */