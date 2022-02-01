import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bdmk
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(c());
    localStringBuilder.append(a(20));
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 8	java/lang/StringBuilder
    //   5: dup
    //   6: iconst_5
    //   7: invokespecial 12	java/lang/StringBuilder:<init>	(I)V
    //   10: astore 9
    //   12: aload 9
    //   14: ldc 33
    //   16: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 35
    //   21: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 33
    //   26: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 37	java/util/HashMap
    //   33: dup
    //   34: invokespecial 40	java/util/HashMap:<init>	()V
    //   37: astore 8
    //   39: aconst_null
    //   40: astore 6
    //   42: new 42	java/io/BufferedReader
    //   45: dup
    //   46: new 44	java/io/FileReader
    //   49: dup
    //   50: ldc 46
    //   52: invokespecial 49	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   55: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 55	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +219 -> 288
    //   72: aload 6
    //   74: ldc 57
    //   76: invokevirtual 63	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   79: astore 11
    //   81: aload 11
    //   83: iconst_0
    //   84: aaload
    //   85: ldc 65
    //   87: invokevirtual 63	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   90: iconst_0
    //   91: aaload
    //   92: astore 10
    //   94: aload 11
    //   96: iconst_0
    //   97: aaload
    //   98: ldc 65
    //   100: invokevirtual 63	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: iconst_1
    //   104: aaload
    //   105: astore 11
    //   107: aload 6
    //   109: ldc 67
    //   111: invokevirtual 71	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   114: istore_2
    //   115: aload 6
    //   117: ldc 73
    //   119: invokevirtual 71	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   122: istore_3
    //   123: iload_2
    //   124: iconst_m1
    //   125: if_icmpeq +63 -> 188
    //   128: aload 6
    //   130: iload_2
    //   131: invokevirtual 76	java/lang/String:substring	(I)Ljava/lang/String;
    //   134: astore 6
    //   136: aload 8
    //   138: aload 6
    //   140: invokevirtual 80	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   143: ifne +61 -> 204
    //   146: aload 8
    //   148: aload 6
    //   150: aload 11
    //   152: bipush 16
    //   154: invokestatic 86	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   157: invokevirtual 90	java/lang/Long:longValue	()J
    //   160: aload 10
    //   162: bipush 16
    //   164: invokestatic 86	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   167: invokevirtual 90	java/lang/Long:longValue	()J
    //   170: lsub
    //   171: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: aload 7
    //   180: invokevirtual 55	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   183: astore 6
    //   185: goto -118 -> 67
    //   188: iload_3
    //   189: iconst_m1
    //   190: if_icmpeq +264 -> 454
    //   193: aload 6
    //   195: iload_3
    //   196: invokevirtual 76	java/lang/String:substring	(I)Ljava/lang/String;
    //   199: astore 6
    //   201: goto -65 -> 136
    //   204: aload 8
    //   206: aload 6
    //   208: invokevirtual 101	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   211: checkcast 82	java/lang/Long
    //   214: invokevirtual 90	java/lang/Long:longValue	()J
    //   217: lstore 4
    //   219: aload 8
    //   221: aload 6
    //   223: aload 11
    //   225: bipush 16
    //   227: invokestatic 86	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   230: invokevirtual 90	java/lang/Long:longValue	()J
    //   233: aload 10
    //   235: bipush 16
    //   237: invokestatic 86	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   240: invokevirtual 90	java/lang/Long:longValue	()J
    //   243: lsub
    //   244: lload 4
    //   246: ladd
    //   247: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   250: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: goto -76 -> 178
    //   257: astore 8
    //   259: aload 7
    //   261: astore 6
    //   263: aload 8
    //   265: astore 7
    //   267: aload 7
    //   269: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
    //   272: aload 6
    //   274: ifnull +8 -> 282
    //   277: aload 6
    //   279: invokevirtual 107	java/io/BufferedReader:close	()V
    //   282: aload 9
    //   284: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: areturn
    //   288: aload 8
    //   290: invokestatic 110	bdmk:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +85 -> 382
    //   300: aload 6
    //   302: invokevirtual 114	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   305: invokeinterface 120 1 0
    //   310: astore 6
    //   312: aload 6
    //   314: invokeinterface 126 1 0
    //   319: ifeq +63 -> 382
    //   322: aload 6
    //   324: invokeinterface 130 1 0
    //   329: checkcast 132	java/util/Map$Entry
    //   332: astore 8
    //   334: iload_1
    //   335: iload_0
    //   336: if_icmpge +115 -> 451
    //   339: aload 9
    //   341: aload 8
    //   343: invokeinterface 135 1 0
    //   348: checkcast 59	java/lang/String
    //   351: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc 137
    //   356: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 8
    //   361: invokeinterface 140 1 0
    //   366: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: ldc 33
    //   371: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: iload_1
    //   376: iconst_1
    //   377: iadd
    //   378: istore_1
    //   379: goto -67 -> 312
    //   382: aload 7
    //   384: ifnull -102 -> 282
    //   387: aload 7
    //   389: invokevirtual 107	java/io/BufferedReader:close	()V
    //   392: goto -110 -> 282
    //   395: astore 6
    //   397: goto -115 -> 282
    //   400: astore 6
    //   402: aconst_null
    //   403: astore 7
    //   405: aload 7
    //   407: ifnull +8 -> 415
    //   410: aload 7
    //   412: invokevirtual 107	java/io/BufferedReader:close	()V
    //   415: aload 6
    //   417: athrow
    //   418: astore 6
    //   420: goto -138 -> 282
    //   423: astore 7
    //   425: goto -10 -> 415
    //   428: astore 6
    //   430: goto -25 -> 405
    //   433: astore 8
    //   435: aload 6
    //   437: astore 7
    //   439: aload 8
    //   441: astore 6
    //   443: goto -38 -> 405
    //   446: astore 7
    //   448: goto -181 -> 267
    //   451: goto -72 -> 379
    //   454: ldc 145
    //   456: astore 6
    //   458: goto -322 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramInt	int
    //   1	378	1	i	int
    //   114	17	2	j	int
    //   122	74	3	k	int
    //   217	28	4	l	long
    //   40	283	6	localObject1	Object
    //   395	1	6	localThrowable1	Throwable
    //   400	16	6	localObject2	Object
    //   418	1	6	localThrowable2	Throwable
    //   428	8	6	localObject3	Object
    //   441	16	6	localObject4	Object
    //   58	353	7	localObject5	Object
    //   423	1	7	localThrowable3	Throwable
    //   437	1	7	localObject6	Object
    //   446	1	7	localThrowable4	Throwable
    //   37	183	8	localHashMap	HashMap
    //   257	32	8	localThrowable5	Throwable
    //   332	28	8	localEntry	Map.Entry
    //   433	7	8	localObject7	Object
    //   10	330	9	localStringBuilder	StringBuilder
    //   92	142	10	str	String
    //   79	145	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   60	67	257	java/lang/Throwable
    //   72	123	257	java/lang/Throwable
    //   128	136	257	java/lang/Throwable
    //   136	178	257	java/lang/Throwable
    //   178	185	257	java/lang/Throwable
    //   193	201	257	java/lang/Throwable
    //   204	254	257	java/lang/Throwable
    //   288	295	257	java/lang/Throwable
    //   300	312	257	java/lang/Throwable
    //   312	334	257	java/lang/Throwable
    //   339	375	257	java/lang/Throwable
    //   387	392	395	java/lang/Throwable
    //   42	60	400	finally
    //   277	282	418	java/lang/Throwable
    //   410	415	423	java/lang/Throwable
    //   60	67	428	finally
    //   72	123	428	finally
    //   128	136	428	finally
    //   136	178	428	finally
    //   178	185	428	finally
    //   193	201	428	finally
    //   204	254	428	finally
    //   288	295	428	finally
    //   300	312	428	finally
    //   312	334	428	finally
    //   339	375	428	finally
    //   267	272	433	finally
    //   42	60	446	java/lang/Throwable
  }
  
  private static HashMap<String, Long> a(HashMap<String, Long> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new bdml());
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  public static String b()
  {
    localStringBuilder = new StringBuilder(5);
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        Object localObject = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
        localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
        localStringBuilder.append("\nDebug.getMemoryInfo:\n");
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localStringBuilder.append((String)localEntry.getKey()).append(" : ").append((String)localEntry.getValue()).append("kB\n");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: new 8	java/lang/StringBuilder
    //   3: dup
    //   4: iconst_5
    //   5: invokespecial 12	java/lang/StringBuilder:<init>	(I)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_1
    //   11: new 42	java/io/BufferedReader
    //   14: dup
    //   15: new 44	java/io/FileReader
    //   18: dup
    //   19: ldc 197
    //   21: invokespecial 49	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 55	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_2
    //   34: ldc 199
    //   36: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: ifnull +54 -> 95
    //   44: aload_1
    //   45: ldc 201
    //   47: invokevirtual 205	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifne +12 -> 62
    //   53: aload_1
    //   54: ldc 207
    //   56: invokevirtual 205	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   59: ifeq +28 -> 87
    //   62: aload_1
    //   63: ldc 209
    //   65: ldc 211
    //   67: invokevirtual 215	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: pop
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   76: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: ldc 220
    //   83: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: invokevirtual 55	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: astore_1
    //   92: goto -52 -> 40
    //   95: aload_2
    //   96: ldc 33
    //   98: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 107	java/io/BufferedReader:close	()V
    //   110: aload_2
    //   111: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull -9 -> 110
    //   122: aload_0
    //   123: invokevirtual 107	java/io/BufferedReader:close	()V
    //   126: goto -16 -> 110
    //   129: astore_0
    //   130: goto -20 -> 110
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 107	java/io/BufferedReader:close	()V
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: goto -35 -> 110
    //   148: astore_1
    //   149: goto -7 -> 142
    //   152: astore_2
    //   153: aload_0
    //   154: astore_1
    //   155: aload_2
    //   156: astore_0
    //   157: goto -23 -> 134
    //   160: astore_1
    //   161: goto -43 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	80	0	localBufferedReader	java.io.BufferedReader
    //   115	1	0	localThrowable1	Throwable
    //   117	6	0	localObject1	Object
    //   129	1	0	localThrowable2	Throwable
    //   133	10	0	localObject2	Object
    //   144	10	0	localThrowable3	Throwable
    //   156	1	0	localObject3	Object
    //   10	129	1	str	String
    //   148	1	1	localThrowable4	Throwable
    //   154	1	1	localObject4	Object
    //   160	1	1	localThrowable5	Throwable
    //   8	103	2	localStringBuilder	StringBuilder
    //   152	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	28	115	java/lang/Throwable
    //   122	126	129	java/lang/Throwable
    //   11	28	133	finally
    //   106	110	144	java/lang/Throwable
    //   138	142	148	java/lang/Throwable
    //   28	40	152	finally
    //   44	62	152	finally
    //   62	87	152	finally
    //   87	92	152	finally
    //   95	102	152	finally
    //   28	40	160	java/lang/Throwable
    //   44	62	160	java/lang/Throwable
    //   62	87	160	java/lang/Throwable
    //   87	92	160	java/lang/Throwable
    //   95	102	160	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmk
 * JD-Core Version:    0.7.0.1
 */