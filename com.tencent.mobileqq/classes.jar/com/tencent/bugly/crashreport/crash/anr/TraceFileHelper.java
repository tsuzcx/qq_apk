package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceFileHelper
{
  private static String a(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 3)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
  {
    if (paramBufferedReader != null)
    {
      if (paramVarArgs == null) {
        return null;
      }
      for (;;)
      {
        String str = paramBufferedReader.readLine();
        if (str == null) {
          break;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          Pattern localPattern = paramVarArgs[i];
          if (localPattern.matcher(str).matches()) {
            return new Object[] { localPattern, str };
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static String b(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static TraceFileHelper.a readFirstDumpInfo(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      x.e("path:%s", new Object[] { paramString });
      return null;
    }
    TraceFileHelper.a locala = new TraceFileHelper.a();
    readTraceFile(paramString, new TraceFileHelper.2(locala, paramBoolean));
    if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
      return locala;
    }
    paramString = new StringBuilder();
    paramString.append(locala.a);
    paramString.append(" ");
    paramString.append(locala.c);
    paramString.append(" ");
    paramString.append(locala.b);
    x.e("first dump error %s", new Object[] { paramString.toString() });
    return null;
  }
  
  public static TraceFileHelper.a readTargetDumpInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      TraceFileHelper.a locala = new TraceFileHelper.a();
      readTraceFile(paramString2, new TraceFileHelper.1(locala, paramString1, paramBoolean));
      if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
        return locala;
      }
    }
    return null;
  }
  
  /* Error */
  public static void readTraceFile(String paramString, TraceFileHelper.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +687 -> 688
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 110	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 116	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload 7
    //   30: invokevirtual 120	java/io/File:lastModified	()J
    //   33: pop2
    //   34: aload 7
    //   36: invokevirtual 122	java/io/File:length	()J
    //   39: pop2
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore_0
    //   45: new 16	java/io/BufferedReader
    //   48: dup
    //   49: new 124	java/io/FileReader
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 127	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   58: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 7
    //   63: ldc 132
    //   65: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   68: astore 8
    //   70: ldc 138
    //   72: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   75: astore 9
    //   77: ldc 140
    //   79: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   82: astore 10
    //   84: ldc 142
    //   86: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   89: astore 11
    //   91: new 144	java/text/SimpleDateFormat
    //   94: dup
    //   95: ldc 146
    //   97: getstatic 152	java/util/Locale:US	Ljava/util/Locale;
    //   100: invokespecial 155	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   103: astore_0
    //   104: aload 7
    //   106: iconst_1
    //   107: anewarray 39	java/util/regex/Pattern
    //   110: dup
    //   111: iconst_0
    //   112: aload 8
    //   114: aastore
    //   115: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   118: astore 12
    //   120: aload 12
    //   122: ifnull +392 -> 514
    //   125: aload 12
    //   127: iconst_1
    //   128: aaload
    //   129: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   132: ldc 160
    //   134: invokevirtual 164	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   137: astore 12
    //   139: aload 12
    //   141: iconst_2
    //   142: aaload
    //   143: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   146: lstore_2
    //   147: new 22	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   154: astore 13
    //   156: aload 13
    //   158: aload 12
    //   160: iconst_4
    //   161: aaload
    //   162: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 13
    //   168: ldc 95
    //   170: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 13
    //   176: aload 12
    //   178: iconst_5
    //   179: aaload
    //   180: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: aload 13
    //   187: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 174	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   193: invokevirtual 179	java/util/Date:getTime	()J
    //   196: lstore 4
    //   198: aload 7
    //   200: iconst_1
    //   201: anewarray 39	java/util/regex/Pattern
    //   204: dup
    //   205: iconst_0
    //   206: aload 10
    //   208: aastore
    //   209: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   212: astore 12
    //   214: aload 12
    //   216: ifnonnull +22 -> 238
    //   219: aload 7
    //   221: invokevirtual 182	java/io/BufferedReader:close	()V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   230: ifne +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: aload 10
    //   240: aload 12
    //   242: iconst_1
    //   243: aaload
    //   244: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   247: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   250: astore 12
    //   252: aload 12
    //   254: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   257: pop
    //   258: aload 12
    //   260: iconst_1
    //   261: invokevirtual 195	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   264: pop
    //   265: aload_1
    //   266: lload_2
    //   267: lload 4
    //   269: aload 12
    //   271: iconst_1
    //   272: invokevirtual 195	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   275: invokeinterface 200 6 0
    //   280: istore 6
    //   282: iload 6
    //   284: ifne +22 -> 306
    //   287: aload 7
    //   289: invokevirtual 182	java/io/BufferedReader:close	()V
    //   292: return
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   298: ifne +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   305: return
    //   306: aload 7
    //   308: iconst_2
    //   309: anewarray 39	java/util/regex/Pattern
    //   312: dup
    //   313: iconst_0
    //   314: aload 11
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload 9
    //   321: aastore
    //   322: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   325: astore 12
    //   327: aload 12
    //   329: ifnull +182 -> 511
    //   332: aload 12
    //   334: iconst_0
    //   335: aaload
    //   336: aload 11
    //   338: if_acmpne +124 -> 462
    //   341: aload 12
    //   343: iconst_1
    //   344: aaload
    //   345: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   348: astore 12
    //   350: ldc 202
    //   352: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   355: aload 12
    //   357: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   360: astore 13
    //   362: aload 13
    //   364: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   367: pop
    //   368: aload 13
    //   370: invokevirtual 204	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   373: astore 13
    //   375: aload 13
    //   377: iconst_1
    //   378: aload 13
    //   380: invokevirtual 59	java/lang/String:length	()I
    //   383: iconst_1
    //   384: isub
    //   385: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   388: astore 13
    //   390: aload 12
    //   392: ldc 210
    //   394: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   397: pop
    //   398: ldc 216
    //   400: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   403: aload 12
    //   405: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   408: astore 12
    //   410: aload 12
    //   412: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   415: pop
    //   416: aload 12
    //   418: invokevirtual 204	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   421: astore 12
    //   423: aload_1
    //   424: aload 13
    //   426: aload 12
    //   428: aload 12
    //   430: ldc 218
    //   432: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   435: iconst_1
    //   436: iadd
    //   437: invokevirtual 224	java/lang/String:substring	(I)Ljava/lang/String;
    //   440: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   443: aload 7
    //   445: invokestatic 231	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   448: aload 7
    //   450: invokestatic 233	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   453: invokeinterface 236 5 0
    //   458: pop
    //   459: goto -153 -> 306
    //   462: aload_1
    //   463: aload 12
    //   465: iconst_1
    //   466: aaload
    //   467: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   470: ldc 160
    //   472: invokevirtual 164	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   475: iconst_2
    //   476: aaload
    //   477: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   480: invokeinterface 239 3 0
    //   485: istore 6
    //   487: iload 6
    //   489: ifne +22 -> 511
    //   492: aload 7
    //   494: invokevirtual 182	java/io/BufferedReader:close	()V
    //   497: return
    //   498: astore_0
    //   499: aload_0
    //   500: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   503: ifne +7 -> 510
    //   506: aload_0
    //   507: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   510: return
    //   511: goto -407 -> 104
    //   514: aload 7
    //   516: invokevirtual 182	java/io/BufferedReader:close	()V
    //   519: return
    //   520: astore_0
    //   521: aload_0
    //   522: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   525: ifne +7 -> 532
    //   528: aload_0
    //   529: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   532: return
    //   533: astore_0
    //   534: goto +127 -> 661
    //   537: astore_0
    //   538: aload 7
    //   540: astore_1
    //   541: aload_0
    //   542: astore 7
    //   544: goto +17 -> 561
    //   547: astore_1
    //   548: aload_0
    //   549: astore 7
    //   551: aload_1
    //   552: astore_0
    //   553: goto +108 -> 661
    //   556: astore 7
    //   558: aload 8
    //   560: astore_1
    //   561: aload_1
    //   562: astore_0
    //   563: aload 7
    //   565: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   568: ifne +10 -> 578
    //   571: aload_1
    //   572: astore_0
    //   573: aload 7
    //   575: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   578: aload_1
    //   579: astore_0
    //   580: aload 7
    //   582: invokevirtual 244	java/lang/Object:getClass	()Ljava/lang/Class;
    //   585: invokevirtual 249	java/lang/Class:getName	()Ljava/lang/String;
    //   588: astore 8
    //   590: aload_1
    //   591: astore_0
    //   592: new 22	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   599: astore 9
    //   601: aload_1
    //   602: astore_0
    //   603: aload 9
    //   605: aload 7
    //   607: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_1
    //   615: astore_0
    //   616: ldc 254
    //   618: iconst_2
    //   619: anewarray 4	java/lang/Object
    //   622: dup
    //   623: iconst_0
    //   624: aload 8
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: aload 9
    //   631: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: aastore
    //   635: invokestatic 257	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   638: pop
    //   639: aload_1
    //   640: ifnull +20 -> 660
    //   643: aload_1
    //   644: invokevirtual 182	java/io/BufferedReader:close	()V
    //   647: return
    //   648: astore_0
    //   649: aload_0
    //   650: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   653: ifne +7 -> 660
    //   656: aload_0
    //   657: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   660: return
    //   661: aload 7
    //   663: ifnull +23 -> 686
    //   666: aload 7
    //   668: invokevirtual 182	java/io/BufferedReader:close	()V
    //   671: goto +15 -> 686
    //   674: astore_1
    //   675: aload_1
    //   676: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   679: ifne +7 -> 686
    //   682: aload_1
    //   683: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   686: aload_0
    //   687: athrow
    //   688: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	paramString	String
    //   0	689	1	paramb	TraceFileHelper.b
    //   146	121	2	l1	long
    //   196	72	4	l2	long
    //   280	208	6	bool	boolean
    //   17	533	7	localObject1	Object
    //   556	111	7	localException	java.lang.Exception
    //   41	584	8	localObject2	Object
    //   75	555	9	localObject3	Object
    //   82	157	10	localPattern1	Pattern
    //   89	248	11	localPattern2	Pattern
    //   118	346	12	localObject4	Object
    //   154	271	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   219	224	225	java/io/IOException
    //   287	292	293	java/io/IOException
    //   492	497	498	java/io/IOException
    //   514	519	520	java/io/IOException
    //   63	104	533	finally
    //   104	120	533	finally
    //   125	214	533	finally
    //   238	282	533	finally
    //   306	327	533	finally
    //   341	459	533	finally
    //   462	487	533	finally
    //   63	104	537	java/lang/Exception
    //   104	120	537	java/lang/Exception
    //   125	214	537	java/lang/Exception
    //   238	282	537	java/lang/Exception
    //   306	327	537	java/lang/Exception
    //   341	459	537	java/lang/Exception
    //   462	487	537	java/lang/Exception
    //   45	63	547	finally
    //   563	571	547	finally
    //   573	578	547	finally
    //   580	590	547	finally
    //   592	601	547	finally
    //   603	614	547	finally
    //   616	639	547	finally
    //   45	63	556	java/lang/Exception
    //   643	647	648	java/io/IOException
    //   666	671	674	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.TraceFileHelper
 * JD-Core Version:    0.7.0.1
 */