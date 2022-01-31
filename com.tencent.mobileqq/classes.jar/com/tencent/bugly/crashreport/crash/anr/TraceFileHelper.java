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
      localStringBuffer.append(str + "\n");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
  {
    if ((paramBufferedReader == null) || (paramVarArgs == null)) {
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
  
  private static String b(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      localStringBuffer.append(str + "\n");
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
    x.e("first dump error %s", new Object[] { locala.a + " " + locala.c + " " + locala.b });
    return null;
  }
  
  public static TraceFileHelper.a readTargetDumpInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    TraceFileHelper.a locala;
    do
    {
      return paramString1;
      locala = new TraceFileHelper.a();
      readTraceFile(paramString2, new TraceFileHelper.1(locala, paramString1, paramBoolean));
      if ((locala.a <= 0L) || (locala.c <= 0L)) {
        break;
      }
      paramString1 = locala;
    } while (locala.b != null);
    return null;
  }
  
  /* Error */
  public static void readTraceFile(String paramString, TraceFileHelper.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
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
    //   24: ifeq -16 -> 8
    //   27: aload 7
    //   29: invokevirtual 120	java/io/File:lastModified	()J
    //   32: pop2
    //   33: aload 7
    //   35: invokevirtual 122	java/io/File:length	()J
    //   38: pop2
    //   39: aconst_null
    //   40: astore_0
    //   41: new 16	java/io/BufferedReader
    //   44: dup
    //   45: new 124	java/io/FileReader
    //   48: dup
    //   49: aload 7
    //   51: invokespecial 127	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   54: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore 7
    //   59: ldc 132
    //   61: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   64: astore_0
    //   65: ldc 138
    //   67: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   70: astore 8
    //   72: ldc 140
    //   74: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   77: astore 9
    //   79: ldc 142
    //   81: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   84: astore 10
    //   86: new 144	java/text/SimpleDateFormat
    //   89: dup
    //   90: ldc 146
    //   92: getstatic 152	java/util/Locale:US	Ljava/util/Locale;
    //   95: invokespecial 155	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   98: astore 11
    //   100: aload 7
    //   102: iconst_1
    //   103: anewarray 39	java/util/regex/Pattern
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +454 -> 571
    //   120: aload 12
    //   122: iconst_1
    //   123: aaload
    //   124: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   127: ldc 160
    //   129: invokevirtual 164	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   132: astore 12
    //   134: aload 12
    //   136: iconst_2
    //   137: aaload
    //   138: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   141: lstore_2
    //   142: aload 11
    //   144: new 22	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   151: aload 12
    //   153: iconst_4
    //   154: aaload
    //   155: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 97
    //   160: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 12
    //   165: iconst_5
    //   166: aaload
    //   167: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 174	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   176: invokevirtual 179	java/util/Date:getTime	()J
    //   179: lstore 4
    //   181: aload 7
    //   183: iconst_1
    //   184: anewarray 39	java/util/regex/Pattern
    //   187: dup
    //   188: iconst_0
    //   189: aload 9
    //   191: aastore
    //   192: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   195: astore 12
    //   197: aload 12
    //   199: ifnonnull +22 -> 221
    //   202: aload 7
    //   204: invokevirtual 182	java/io/BufferedReader:close	()V
    //   207: return
    //   208: astore_0
    //   209: aload_0
    //   210: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   213: ifne -205 -> 8
    //   216: aload_0
    //   217: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   220: return
    //   221: aload 9
    //   223: aload 12
    //   225: iconst_1
    //   226: aaload
    //   227: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   230: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   233: astore 12
    //   235: aload 12
    //   237: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   240: pop
    //   241: aload 12
    //   243: iconst_1
    //   244: invokevirtual 195	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   247: pop
    //   248: aload_1
    //   249: lload_2
    //   250: lload 4
    //   252: aload 12
    //   254: iconst_1
    //   255: invokevirtual 195	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   258: invokeinterface 200 6 0
    //   263: istore 6
    //   265: iload 6
    //   267: ifne +22 -> 289
    //   270: aload 7
    //   272: invokevirtual 182	java/io/BufferedReader:close	()V
    //   275: return
    //   276: astore_0
    //   277: aload_0
    //   278: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   281: ifne -273 -> 8
    //   284: aload_0
    //   285: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: aload 7
    //   291: iconst_2
    //   292: anewarray 39	java/util/regex/Pattern
    //   295: dup
    //   296: iconst_0
    //   297: aload 10
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: aload 8
    //   304: aastore
    //   305: invokestatic 157	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   308: astore 12
    //   310: aload 12
    //   312: ifnull -212 -> 100
    //   315: aload 12
    //   317: iconst_0
    //   318: aaload
    //   319: aload 10
    //   321: if_acmpne +201 -> 522
    //   324: aload 12
    //   326: iconst_1
    //   327: aaload
    //   328: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   331: astore 12
    //   333: ldc 202
    //   335: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   338: aload 12
    //   340: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   343: astore 13
    //   345: aload 13
    //   347: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   350: pop
    //   351: aload 13
    //   353: invokevirtual 204	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   356: astore 13
    //   358: aload 13
    //   360: iconst_1
    //   361: aload 13
    //   363: invokevirtual 59	java/lang/String:length	()I
    //   366: iconst_1
    //   367: isub
    //   368: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   371: astore 13
    //   373: aload 12
    //   375: ldc 210
    //   377: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   380: pop
    //   381: ldc 216
    //   383: invokestatic 136	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   386: aload 12
    //   388: invokevirtual 43	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   391: astore 12
    //   393: aload 12
    //   395: invokevirtual 191	java/util/regex/Matcher:find	()Z
    //   398: pop
    //   399: aload 12
    //   401: invokevirtual 204	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   404: astore 12
    //   406: aload_1
    //   407: aload 13
    //   409: aload 12
    //   411: aload 12
    //   413: ldc 218
    //   415: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   418: iconst_1
    //   419: iadd
    //   420: invokevirtual 224	java/lang/String:substring	(I)Ljava/lang/String;
    //   423: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   426: aload 7
    //   428: invokestatic 231	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   431: aload 7
    //   433: invokestatic 233	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   436: invokeinterface 236 5 0
    //   441: pop
    //   442: goto -153 -> 289
    //   445: astore_1
    //   446: aload 7
    //   448: astore_0
    //   449: aload_1
    //   450: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   453: ifne +7 -> 460
    //   456: aload_1
    //   457: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   460: ldc 239
    //   462: iconst_2
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload_1
    //   469: invokevirtual 243	java/lang/Object:getClass	()Ljava/lang/Class;
    //   472: invokevirtual 248	java/lang/Class:getName	()Ljava/lang/String;
    //   475: aastore
    //   476: dup
    //   477: iconst_1
    //   478: new 22	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   485: aload_1
    //   486: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   489: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: aastore
    //   496: invokestatic 254	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   499: pop
    //   500: aload_0
    //   501: ifnull -493 -> 8
    //   504: aload_0
    //   505: invokevirtual 182	java/io/BufferedReader:close	()V
    //   508: return
    //   509: astore_0
    //   510: aload_0
    //   511: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   514: ifne -506 -> 8
    //   517: aload_0
    //   518: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   521: return
    //   522: aload_1
    //   523: aload 12
    //   525: iconst_1
    //   526: aaload
    //   527: invokevirtual 158	java/lang/Object:toString	()Ljava/lang/String;
    //   530: ldc 160
    //   532: invokevirtual 164	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   535: iconst_2
    //   536: aaload
    //   537: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   540: invokeinterface 257 3 0
    //   545: istore 6
    //   547: iload 6
    //   549: ifne -449 -> 100
    //   552: aload 7
    //   554: invokevirtual 182	java/io/BufferedReader:close	()V
    //   557: return
    //   558: astore_0
    //   559: aload_0
    //   560: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   563: ifne -555 -> 8
    //   566: aload_0
    //   567: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   570: return
    //   571: aload 7
    //   573: invokevirtual 182	java/io/BufferedReader:close	()V
    //   576: return
    //   577: astore_0
    //   578: aload_0
    //   579: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   582: ifne -574 -> 8
    //   585: aload_0
    //   586: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   589: return
    //   590: astore_0
    //   591: aconst_null
    //   592: astore_1
    //   593: aload_1
    //   594: ifnull +7 -> 601
    //   597: aload_1
    //   598: invokevirtual 182	java/io/BufferedReader:close	()V
    //   601: aload_0
    //   602: athrow
    //   603: astore_1
    //   604: aload_1
    //   605: invokestatic 185	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   608: ifne -7 -> 601
    //   611: aload_1
    //   612: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   615: goto -14 -> 601
    //   618: astore_0
    //   619: aload 7
    //   621: astore_1
    //   622: goto -29 -> 593
    //   625: astore 7
    //   627: aload_0
    //   628: astore_1
    //   629: aload 7
    //   631: astore_0
    //   632: goto -39 -> 593
    //   635: astore_1
    //   636: goto -187 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramString	String
    //   0	639	1	paramb	TraceFileHelper.b
    //   141	109	2	l1	long
    //   179	72	4	l2	long
    //   263	285	6	bool	boolean
    //   17	603	7	localObject1	Object
    //   625	5	7	localObject2	Object
    //   70	233	8	localPattern1	Pattern
    //   77	145	9	localPattern2	Pattern
    //   84	236	10	localPattern3	Pattern
    //   98	45	11	localSimpleDateFormat	java.text.SimpleDateFormat
    //   113	411	12	localObject3	Object
    //   343	65	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   202	207	208	java/io/IOException
    //   270	275	276	java/io/IOException
    //   59	100	445	java/lang/Exception
    //   100	115	445	java/lang/Exception
    //   120	197	445	java/lang/Exception
    //   221	265	445	java/lang/Exception
    //   289	310	445	java/lang/Exception
    //   324	442	445	java/lang/Exception
    //   522	547	445	java/lang/Exception
    //   504	508	509	java/io/IOException
    //   552	557	558	java/io/IOException
    //   571	576	577	java/io/IOException
    //   41	59	590	finally
    //   597	601	603	java/io/IOException
    //   59	100	618	finally
    //   100	115	618	finally
    //   120	197	618	finally
    //   221	265	618	finally
    //   289	310	618	finally
    //   324	442	618	finally
    //   522	547	618	finally
    //   449	460	625	finally
    //   460	500	625	finally
    //   41	59	635	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.TraceFileHelper
 * JD-Core Version:    0.7.0.1
 */