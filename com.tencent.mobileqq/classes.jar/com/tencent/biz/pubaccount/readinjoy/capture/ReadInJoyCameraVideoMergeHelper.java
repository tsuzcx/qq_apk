package com.tencent.biz.pubaccount.readinjoy.capture;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.FileFFmpegUtils;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyCameraVideoMergeHelper
{
  /* Error */
  @android.annotation.TargetApi(9)
  public static int a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 4
    //   5: new 26	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 33
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: new 39	java/io/FileWriter
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 42	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   33: astore 9
    //   35: new 44	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 49	java/io/File:listFiles	()[Ljava/io/File;
    //   46: astore_1
    //   47: iconst_0
    //   48: istore_3
    //   49: iload_3
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpge +82 -> 134
    //   55: aload_1
    //   56: iload_3
    //   57: aaload
    //   58: astore 10
    //   60: aload 10
    //   62: invokevirtual 53	java/io/File:isFile	()Z
    //   65: ifeq +62 -> 127
    //   68: aload 10
    //   70: invokevirtual 56	java/io/File:getName	()Ljava/lang/String;
    //   73: ldc 58
    //   75: invokevirtual 64	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   78: ifeq +49 -> 127
    //   81: aload 10
    //   83: invokevirtual 56	java/io/File:getName	()Ljava/lang/String;
    //   86: ldc 66
    //   88: invokevirtual 69	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq +36 -> 127
    //   94: aload 9
    //   96: new 26	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   103: ldc 71
    //   105: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 10
    //   110: invokevirtual 56	java/io/File:getName	()Ljava/lang/String;
    //   113: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 73
    //   118: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokevirtual 76	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -82 -> 49
    //   134: aload 9
    //   136: invokevirtual 79	java/io/FileWriter:close	()V
    //   139: invokestatic 81	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:a	()Ljava/lang/String;
    //   142: astore 9
    //   144: new 44	java/io/File
    //   147: dup
    //   148: aload 9
    //   150: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 84	java/io/File:exists	()Z
    //   158: ifeq +274 -> 432
    //   161: aload_1
    //   162: iconst_1
    //   163: iconst_1
    //   164: invokevirtual 88	java/io/File:setExecutable	(ZZ)Z
    //   167: istore 8
    //   169: new 26	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   176: ldc 90
    //   178: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload 8
    //   183: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   192: new 98	java/util/ArrayList
    //   195: dup
    //   196: invokespecial 99	java/util/ArrayList:<init>	()V
    //   199: astore_1
    //   200: aload_1
    //   201: aload 9
    //   203: invokeinterface 105 2 0
    //   208: pop
    //   209: aload_1
    //   210: ldc 107
    //   212: invokeinterface 105 2 0
    //   217: pop
    //   218: aload_1
    //   219: ldc 109
    //   221: invokeinterface 105 2 0
    //   226: pop
    //   227: aload_1
    //   228: ldc 111
    //   230: invokeinterface 105 2 0
    //   235: pop
    //   236: aload_1
    //   237: aload_0
    //   238: invokeinterface 105 2 0
    //   243: pop
    //   244: aload_1
    //   245: ldc 113
    //   247: invokeinterface 105 2 0
    //   252: pop
    //   253: aload_1
    //   254: ldc 115
    //   256: invokeinterface 105 2 0
    //   261: pop
    //   262: aload_1
    //   263: aload_2
    //   264: invokeinterface 105 2 0
    //   269: pop
    //   270: aload_1
    //   271: invokestatic 117	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	()Ljava/lang/String;
    //   274: invokeinterface 105 2 0
    //   279: pop
    //   280: new 119	lhz
    //   283: dup
    //   284: aconst_null
    //   285: invokespecial 122	lhz:<init>	(Llhy;)V
    //   288: astore_0
    //   289: new 124	java/lang/ProcessBuilder
    //   292: dup
    //   293: iconst_0
    //   294: anewarray 60	java/lang/String
    //   297: invokespecial 127	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   300: astore_2
    //   301: aload_2
    //   302: iconst_1
    //   303: invokevirtual 131	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   306: pop
    //   307: aload_2
    //   308: aload_1
    //   309: invokevirtual 135	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   312: pop
    //   313: ldc 137
    //   315: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   318: aload_2
    //   319: invokevirtual 141	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   322: astore_1
    //   323: aload_0
    //   324: aload_1
    //   325: putfield 144	lhz:a	Ljava/lang/Process;
    //   328: aload_0
    //   329: invokevirtual 146	lhz:a	()V
    //   332: ldc 148
    //   334: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   337: aload_0
    //   338: invokevirtual 150	lhz:b	()V
    //   341: aload_1
    //   342: invokevirtual 155	java/lang/Process:waitFor	()I
    //   345: pop
    //   346: aload_1
    //   347: invokevirtual 158	java/lang/Process:exitValue	()I
    //   350: istore_3
    //   351: iload_3
    //   352: ifeq +25 -> 377
    //   355: new 26	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   362: ldc 160
    //   364: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload_3
    //   368: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   377: aload_1
    //   378: ifnull +7 -> 385
    //   381: aload_1
    //   382: invokevirtual 166	java/lang/Process:destroy	()V
    //   385: invokestatic 24	android/os/SystemClock:uptimeMillis	()J
    //   388: lstore 6
    //   390: new 26	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   397: ldc 168
    //   399: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload_3
    //   403: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc 170
    //   408: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: lload 6
    //   413: lload 4
    //   415: lsub
    //   416: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   419: ldc 175
    //   421: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   430: iload_3
    //   431: ireturn
    //   432: bipush 244
    //   434: ireturn
    //   435: astore_0
    //   436: new 26	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   443: ldc 177
    //   445: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: invokevirtual 180	java/io/IOException:getMessage	()Ljava/lang/String;
    //   452: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   461: bipush 245
    //   463: ireturn
    //   464: astore_0
    //   465: new 26	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   472: ldc 177
    //   474: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: invokevirtual 181	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   481: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   490: goto -144 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramContext	android.content.Context
    //   0	493	1	paramString1	String
    //   0	493	2	paramString2	String
    //   48	383	3	i	int
    //   3	411	4	l1	long
    //   388	24	6	l2	long
    //   167	15	8	bool	boolean
    //   33	169	9	localObject1	Object
    //   58	51	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   318	323	435	java/io/IOException
    //   341	346	464	java/lang/InterruptedException
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public static int a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: invokestatic 81	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:a	()Ljava/lang/String;
    //   8: astore 10
    //   10: new 44	java/io/File
    //   13: dup
    //   14: aload 10
    //   16: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 84	java/io/File:exists	()Z
    //   24: ifeq +295 -> 319
    //   27: aload_0
    //   28: iconst_1
    //   29: iconst_1
    //   30: invokevirtual 88	java/io/File:setExecutable	(ZZ)Z
    //   33: istore 9
    //   35: new 26	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   42: ldc 90
    //   44: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload 9
    //   49: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   58: new 98	java/util/ArrayList
    //   61: dup
    //   62: invokespecial 99	java/util/ArrayList:<init>	()V
    //   65: astore_0
    //   66: aload_0
    //   67: aload 10
    //   69: invokeinterface 105 2 0
    //   74: pop
    //   75: aload_0
    //   76: ldc 111
    //   78: invokeinterface 105 2 0
    //   83: pop
    //   84: aload_0
    //   85: aload_1
    //   86: invokeinterface 105 2 0
    //   91: pop
    //   92: aload_0
    //   93: ldc 111
    //   95: invokeinterface 105 2 0
    //   100: pop
    //   101: aload_0
    //   102: aload_2
    //   103: invokeinterface 105 2 0
    //   108: pop
    //   109: aload_0
    //   110: ldc 113
    //   112: invokeinterface 105 2 0
    //   117: pop
    //   118: aload_0
    //   119: ldc 115
    //   121: invokeinterface 105 2 0
    //   126: pop
    //   127: aload_0
    //   128: ldc 185
    //   130: invokeinterface 105 2 0
    //   135: pop
    //   136: aload_0
    //   137: ldc 187
    //   139: invokeinterface 105 2 0
    //   144: pop
    //   145: aload_0
    //   146: ldc 185
    //   148: invokeinterface 105 2 0
    //   153: pop
    //   154: aload_0
    //   155: ldc 189
    //   157: invokeinterface 105 2 0
    //   162: pop
    //   163: aload_0
    //   164: ldc 191
    //   166: invokeinterface 105 2 0
    //   171: pop
    //   172: aload_0
    //   173: aload_3
    //   174: invokeinterface 105 2 0
    //   179: pop
    //   180: aload_0
    //   181: invokestatic 117	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	()Ljava/lang/String;
    //   184: invokeinterface 105 2 0
    //   189: pop
    //   190: new 119	lhz
    //   193: dup
    //   194: aconst_null
    //   195: invokespecial 122	lhz:<init>	(Llhy;)V
    //   198: astore_1
    //   199: new 124	java/lang/ProcessBuilder
    //   202: dup
    //   203: iconst_0
    //   204: anewarray 60	java/lang/String
    //   207: invokespecial 127	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   210: astore_2
    //   211: aload_2
    //   212: iconst_1
    //   213: invokevirtual 131	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   216: pop
    //   217: aload_2
    //   218: aload_0
    //   219: invokevirtual 135	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   222: pop
    //   223: ldc 137
    //   225: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   228: aload_2
    //   229: invokevirtual 141	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   232: astore_0
    //   233: aload_1
    //   234: aload_0
    //   235: putfield 144	lhz:a	Ljava/lang/Process;
    //   238: aload_1
    //   239: invokevirtual 146	lhz:a	()V
    //   242: ldc 148
    //   244: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   247: aload_1
    //   248: invokevirtual 150	lhz:b	()V
    //   251: aload_0
    //   252: invokevirtual 155	java/lang/Process:waitFor	()I
    //   255: pop
    //   256: aload_0
    //   257: invokevirtual 158	java/lang/Process:exitValue	()I
    //   260: istore 4
    //   262: aload_0
    //   263: ifnull +7 -> 270
    //   266: aload_0
    //   267: invokevirtual 166	java/lang/Process:destroy	()V
    //   270: invokestatic 24	android/os/SystemClock:uptimeMillis	()J
    //   273: lstore 7
    //   275: new 26	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   282: ldc 193
    //   284: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 4
    //   289: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc 170
    //   294: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: lload 7
    //   299: lload 5
    //   301: lsub
    //   302: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc 175
    //   307: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   316: iload 4
    //   318: ireturn
    //   319: bipush 244
    //   321: ireturn
    //   322: astore_0
    //   323: new 26	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   330: ldc 177
    //   332: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: invokevirtual 180	java/io/IOException:getMessage	()Ljava/lang/String;
    //   339: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   348: bipush 245
    //   350: ireturn
    //   351: astore_1
    //   352: new 26	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   359: ldc 177
    //   361: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_1
    //   365: invokevirtual 181	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 96	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:b	(Ljava/lang/String;)V
    //   377: goto -121 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	android.content.Context
    //   0	380	1	paramString1	String
    //   0	380	2	paramString2	String
    //   0	380	3	paramString3	String
    //   260	57	4	i	int
    //   3	297	5	l1	long
    //   273	25	7	l2	long
    //   33	15	9	bool	boolean
    //   8	60	10	str	String
    // Exception table:
    //   from	to	target	type
    //   228	233	322	java/io/IOException
    //   251	256	351	java/lang/InterruptedException
  }
  
  private static String a()
  {
    return FileFFmpegUtils.a(VideoEnvironment.a());
  }
  
  private static String b()
  {
    return FileFFmpegUtils.b(VideoEnvironment.a());
  }
  
  private static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.ReadInJoyCameraVideoMergeHelper", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraVideoMergeHelper
 * JD-Core Version:    0.7.0.1
 */