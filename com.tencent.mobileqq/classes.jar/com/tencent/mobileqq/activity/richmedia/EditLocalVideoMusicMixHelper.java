package com.tencent.mobileqq.activity.richmedia;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class EditLocalVideoMusicMixHelper
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EditLocalVideoActivity.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("silent.m4a");
    a = localStringBuilder.toString();
  }
  
  private static String a(long paramLong)
  {
    return String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf((float)paramLong / 1000.0F) });
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(EditLocalVideoActivity.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("clipped.");
      ((StringBuilder)localObject).append(a(paramString, "m4a"));
      localObject = ((StringBuilder)localObject).toString();
      int i = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-y", "-i", paramString, "-ss", a(paramLong1), "-t", a(paramLong2), "-c", "copy", localObject });
      if (i != 0)
      {
        paramString = new StringBuilder();
        paramString.append("ffmpegClipAudio: FFmpeg run failed with ");
        paramString.append(i);
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { paramString.toString() });
        return null;
      }
      return localObject;
    }
    return paramString;
  }
  
  /* Error */
  public static String a(long paramLong1, String paramString, long paramLong2)
  {
    // Byte code:
    //   0: new 10	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   14: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: ldc 124
    //   31: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 9
    //   42: lload_0
    //   43: lload_3
    //   44: ldiv
    //   45: lconst_1
    //   46: ladd
    //   47: l2i
    //   48: istore 6
    //   50: new 126	java/io/BufferedWriter
    //   53: dup
    //   54: new 128	java/io/OutputStreamWriter
    //   57: dup
    //   58: new 130	java/io/FileOutputStream
    //   61: dup
    //   62: aload 9
    //   64: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: invokespecial 134	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   70: invokespecial 137	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   73: astore 8
    //   75: iconst_0
    //   76: istore 5
    //   78: iload 5
    //   80: iload 6
    //   82: if_icmpge +93 -> 175
    //   85: aload 8
    //   87: astore 7
    //   89: new 10	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   96: astore 10
    //   98: aload 8
    //   100: astore 7
    //   102: aload 10
    //   104: ldc 139
    //   106: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 8
    //   112: astore 7
    //   114: aload 10
    //   116: new 23	java/io/File
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 8
    //   133: astore 7
    //   135: aload 10
    //   137: ldc 144
    //   139: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 8
    //   145: astore 7
    //   147: aload 8
    //   149: aload 10
    //   151: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 147	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   157: aload 8
    //   159: astore 7
    //   161: aload 8
    //   163: invokevirtual 150	java/io/BufferedWriter:newLine	()V
    //   166: iload 5
    //   168: iconst_1
    //   169: iadd
    //   170: istore 5
    //   172: goto -94 -> 78
    //   175: aload 8
    //   177: astore 7
    //   179: aload 8
    //   181: invokevirtual 153	java/io/BufferedWriter:flush	()V
    //   184: aload 8
    //   186: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   189: goto +79 -> 268
    //   192: astore_2
    //   193: ldc 111
    //   195: iconst_2
    //   196: aload_2
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   204: goto +64 -> 268
    //   207: astore 7
    //   209: aload 8
    //   211: astore_2
    //   212: aload 7
    //   214: astore 8
    //   216: goto +14 -> 230
    //   219: astore_2
    //   220: aconst_null
    //   221: astore 7
    //   223: goto +232 -> 455
    //   226: astore 8
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: astore 7
    //   233: ldc 111
    //   235: iconst_2
    //   236: aload 8
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   245: aload_2
    //   246: ifnull +22 -> 268
    //   249: aload_2
    //   250: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   253: goto +15 -> 268
    //   256: astore_2
    //   257: ldc 111
    //   259: iconst_2
    //   260: aload_2
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   268: ldc 80
    //   270: invokestatic 86	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   273: checkcast 80	com/tencent/qzonehub/api/utils/IQzoneVideoHelper
    //   276: bipush 12
    //   278: anewarray 53	java/lang/String
    //   281: dup
    //   282: iconst_0
    //   283: ldc 88
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: ldc 161
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: ldc 163
    //   295: aastore
    //   296: dup
    //   297: iconst_3
    //   298: ldc 165
    //   300: aastore
    //   301: dup
    //   302: iconst_4
    //   303: ldc 167
    //   305: aastore
    //   306: dup
    //   307: iconst_5
    //   308: ldc 90
    //   310: aastore
    //   311: dup
    //   312: bipush 6
    //   314: aload 9
    //   316: aastore
    //   317: dup
    //   318: bipush 7
    //   320: ldc 96
    //   322: aastore
    //   323: dup
    //   324: bipush 8
    //   326: lload_0
    //   327: invokestatic 94	com/tencent/mobileqq/activity/richmedia/EditLocalVideoMusicMixHelper:a	(J)Ljava/lang/String;
    //   330: aastore
    //   331: dup
    //   332: bipush 9
    //   334: ldc 98
    //   336: aastore
    //   337: dup
    //   338: bipush 10
    //   340: ldc 100
    //   342: aastore
    //   343: dup
    //   344: bipush 11
    //   346: getstatic 33	com/tencent/mobileqq/activity/richmedia/EditLocalVideoMusicMixHelper:a	Ljava/lang/String;
    //   349: aastore
    //   350: invokeinterface 104 2 0
    //   355: istore 5
    //   357: new 23	java/io/File
    //   360: dup
    //   361: aload 9
    //   363: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   366: invokevirtual 170	java/io/File:delete	()Z
    //   369: ifeq +35 -> 404
    //   372: new 10	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   379: astore_2
    //   380: aload_2
    //   381: ldc 172
    //   383: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_2
    //   388: aload 9
    //   390: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: ldc 111
    //   396: iconst_2
    //   397: aload_2
    //   398: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 176	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: iload 5
    //   406: ifeq +44 -> 450
    //   409: new 10	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   416: astore_2
    //   417: aload_2
    //   418: ldc 178
    //   420: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_2
    //   425: iload 5
    //   427: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: ldc 111
    //   433: iconst_2
    //   434: iconst_1
    //   435: anewarray 4	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: aload_2
    //   441: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: aastore
    //   445: invokestatic 117	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   448: aconst_null
    //   449: areturn
    //   450: getstatic 33	com/tencent/mobileqq/activity/richmedia/EditLocalVideoMusicMixHelper:a	Ljava/lang/String;
    //   453: areturn
    //   454: astore_2
    //   455: aload 7
    //   457: ifnull +25 -> 482
    //   460: aload 7
    //   462: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   465: goto +17 -> 482
    //   468: astore 7
    //   470: ldc 111
    //   472: iconst_2
    //   473: aload 7
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   482: goto +5 -> 487
    //   485: aload_2
    //   486: athrow
    //   487: goto -2 -> 485
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramLong1	long
    //   0	490	2	paramString	String
    //   0	490	3	paramLong2	long
    //   76	350	5	i	int
    //   48	35	6	j	int
    //   7	171	7	localObject1	Object
    //   207	6	7	localException1	java.lang.Exception
    //   221	240	7	str1	String
    //   468	6	7	localIOException	java.io.IOException
    //   73	142	8	localObject2	Object
    //   226	11	8	localException2	java.lang.Exception
    //   40	349	9	str2	String
    //   96	54	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   184	189	192	java/io/IOException
    //   89	98	207	java/lang/Exception
    //   102	110	207	java/lang/Exception
    //   114	131	207	java/lang/Exception
    //   135	143	207	java/lang/Exception
    //   147	157	207	java/lang/Exception
    //   161	166	207	java/lang/Exception
    //   179	184	207	java/lang/Exception
    //   50	75	219	finally
    //   50	75	226	java/lang/Exception
    //   249	253	256	java/io/IOException
    //   89	98	454	finally
    //   102	110	454	finally
    //   114	131	454	finally
    //   135	143	454	finally
    //   147	157	454	finally
    //   161	166	454	finally
    //   179	184	454	finally
    //   233	245	454	finally
    //   460	465	468	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(EditLocalVideoActivity.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(UUID.randomUUID().toString());
      ((StringBuilder)localObject).append("_an.");
      ((StringBuilder)localObject).append(a(paramString, "mp4"));
      localObject = ((StringBuilder)localObject).toString();
      int i = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-y", "-i", paramString, "-an", "-c", "copy", localObject });
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ffmpegRemoveAudioTrack: FFmpeg run failed with code ");
        ((StringBuilder)localObject).append(i);
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { ((StringBuilder)localObject).toString() });
        return paramString;
      }
      return localObject;
    }
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt >= 2)
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < paramInt)
      {
        ((List)localObject).add(paramString);
        i += 1;
      }
      localObject = a((List)localObject);
    }
    return localObject;
  }
  
  @NonNull
  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf('.');
    if (i > 0) {
      paramString2 = paramString1.substring(i + 1);
    }
    return paramString2;
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(EditLocalVideoActivity.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("merged_");
      ((StringBuilder)localObject).append(UUID.randomUUID().toString());
      ((StringBuilder)localObject).append(".mp4");
      localObject = ((StringBuilder)localObject).toString();
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "-y";
      arrayOfString[1] = "-i";
      arrayOfString[2] = paramString1;
      arrayOfString[3] = "-i";
      arrayOfString[4] = paramString2;
      arrayOfString[5] = "-t";
      arrayOfString[6] = a(paramLong);
      arrayOfString[7] = "-codec";
      arrayOfString[8] = "copy";
      arrayOfString[9] = "-map";
      arrayOfString[10] = "0:v:0";
      arrayOfString[11] = "-map";
      arrayOfString[12] = "1:a";
      arrayOfString[13] = localObject;
      paramString1 = new StringBuilder();
      paramString1.append("ffmpegMergeVideoAndAudio: ");
      paramString1.append(Arrays.toString(arrayOfString));
      QZLog.d("EditLocalVideoMusicMixH", 2, paramString1.toString());
      int i = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(arrayOfString);
      if (i != 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append("ffmpegMergeVideoAndAudio: FFmpeg run failed with code ");
        paramString1.append(i);
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { paramString1.toString() });
        return null;
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ffmpegMergeVideoAndAudio: input video/audio is empty ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { ((StringBuilder)localObject).toString() });
    return null;
  }
  
  /* Error */
  public static String a(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +484 -> 485
    //   4: aload_0
    //   5: invokeinterface 247 1 0
    //   10: iconst_1
    //   11: if_icmpne +14 -> 25
    //   14: aload_0
    //   15: iconst_0
    //   16: invokeinterface 251 2 0
    //   21: checkcast 53	java/lang/String
    //   24: areturn
    //   25: new 10	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   37: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   45: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc 253
    //   52: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 4
    //   62: new 126	java/io/BufferedWriter
    //   65: dup
    //   66: new 128	java/io/OutputStreamWriter
    //   69: dup
    //   70: new 130	java/io/FileOutputStream
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: invokespecial 134	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   82: invokespecial 137	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: aload_0
    //   89: invokeinterface 257 1 0
    //   94: astore_0
    //   95: aload_3
    //   96: astore_2
    //   97: aload_0
    //   98: invokeinterface 262 1 0
    //   103: ifeq +87 -> 190
    //   106: aload_3
    //   107: astore_2
    //   108: aload_0
    //   109: invokeinterface 266 1 0
    //   114: checkcast 53	java/lang/String
    //   117: astore 5
    //   119: aload_3
    //   120: astore_2
    //   121: new 10	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   128: astore 6
    //   130: aload_3
    //   131: astore_2
    //   132: aload 6
    //   134: ldc 139
    //   136: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: astore_2
    //   142: aload 6
    //   144: new 23	java/io/File
    //   147: dup
    //   148: aload 5
    //   150: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: astore_2
    //   162: aload 6
    //   164: ldc 144
    //   166: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: astore_2
    //   172: aload_3
    //   173: aload 6
    //   175: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 147	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   181: aload_3
    //   182: astore_2
    //   183: aload_3
    //   184: invokevirtual 150	java/io/BufferedWriter:newLine	()V
    //   187: goto -92 -> 95
    //   190: aload_3
    //   191: astore_2
    //   192: aload_3
    //   193: invokevirtual 153	java/io/BufferedWriter:flush	()V
    //   196: aload_3
    //   197: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   200: goto +71 -> 271
    //   203: astore_0
    //   204: ldc 111
    //   206: iconst_2
    //   207: aload_0
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   215: goto +56 -> 271
    //   218: astore_2
    //   219: aload_3
    //   220: astore_0
    //   221: aload_2
    //   222: astore_3
    //   223: goto +12 -> 235
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_2
    //   229: goto +231 -> 460
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: astore_2
    //   237: ldc 111
    //   239: iconst_2
    //   240: aload_3
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   248: aload_0
    //   249: ifnull +22 -> 271
    //   252: aload_0
    //   253: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   256: goto +15 -> 271
    //   259: astore_0
    //   260: ldc 111
    //   262: iconst_2
    //   263: aload_0
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   271: new 10	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   278: astore_0
    //   279: aload_0
    //   280: getstatic 17	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Ljava/lang/String;
    //   283: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_0
    //   288: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   291: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_0
    //   296: invokestatic 185	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   299: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_0
    //   304: ldc_w 271
    //   307: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_0
    //   312: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore_0
    //   316: ldc 80
    //   318: invokestatic 86	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   321: checkcast 80	com/tencent/qzonehub/api/utils/IQzoneVideoHelper
    //   324: bipush 10
    //   326: anewarray 53	java/lang/String
    //   329: dup
    //   330: iconst_0
    //   331: ldc 88
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: ldc 161
    //   338: aastore
    //   339: dup
    //   340: iconst_2
    //   341: ldc 163
    //   343: aastore
    //   344: dup
    //   345: iconst_3
    //   346: ldc 165
    //   348: aastore
    //   349: dup
    //   350: iconst_4
    //   351: ldc 167
    //   353: aastore
    //   354: dup
    //   355: iconst_5
    //   356: ldc 90
    //   358: aastore
    //   359: dup
    //   360: bipush 6
    //   362: aload 4
    //   364: aastore
    //   365: dup
    //   366: bipush 7
    //   368: ldc 98
    //   370: aastore
    //   371: dup
    //   372: bipush 8
    //   374: ldc 100
    //   376: aastore
    //   377: dup
    //   378: bipush 9
    //   380: aload_0
    //   381: aastore
    //   382: invokeinterface 104 2 0
    //   387: istore_1
    //   388: new 23	java/io/File
    //   391: dup
    //   392: aload 4
    //   394: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: invokevirtual 170	java/io/File:delete	()Z
    //   400: ifeq +12 -> 412
    //   403: ldc 111
    //   405: ldc_w 273
    //   408: invokestatic 278	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: iload_1
    //   413: ifeq +44 -> 457
    //   416: new 10	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   423: astore_0
    //   424: aload_0
    //   425: ldc_w 280
    //   428: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_0
    //   433: iload_1
    //   434: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: ldc 111
    //   440: iconst_2
    //   441: iconst_1
    //   442: anewarray 4	java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: aload_0
    //   448: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: aastore
    //   452: invokestatic 117	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   455: aconst_null
    //   456: areturn
    //   457: aload_0
    //   458: areturn
    //   459: astore_0
    //   460: aload_2
    //   461: ifnull +22 -> 483
    //   464: aload_2
    //   465: invokevirtual 156	java/io/BufferedWriter:close	()V
    //   468: goto +15 -> 483
    //   471: astore_2
    //   472: ldc 111
    //   474: iconst_2
    //   475: aload_2
    //   476: iconst_0
    //   477: anewarray 4	java/lang/Object
    //   480: invokestatic 159	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   483: aload_0
    //   484: athrow
    //   485: aconst_null
    //   486: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramList	List<String>
    //   387	47	1	i	int
    //   32	160	2	localObject1	Object
    //   218	4	2	localException1	java.lang.Exception
    //   228	237	2	localList	List<String>
    //   471	5	2	localIOException	java.io.IOException
    //   85	138	3	localObject2	Object
    //   232	9	3	localException2	java.lang.Exception
    //   60	333	4	str1	String
    //   117	32	5	str2	String
    //   128	46	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   196	200	203	java/io/IOException
    //   88	95	218	java/lang/Exception
    //   97	106	218	java/lang/Exception
    //   108	119	218	java/lang/Exception
    //   121	130	218	java/lang/Exception
    //   132	140	218	java/lang/Exception
    //   142	160	218	java/lang/Exception
    //   162	170	218	java/lang/Exception
    //   172	181	218	java/lang/Exception
    //   183	187	218	java/lang/Exception
    //   192	196	218	java/lang/Exception
    //   62	86	226	finally
    //   62	86	232	java/lang/Exception
    //   252	256	259	java/io/IOException
    //   88	95	459	finally
    //   97	106	459	finally
    //   108	119	459	finally
    //   121	130	459	finally
    //   132	140	459	finally
    //   142	160	459	finally
    //   162	170	459	finally
    //   172	181	459	finally
    //   183	187	459	finally
    //   192	196	459	finally
    //   237	248	459	finally
    //   464	468	471	java/io/IOException
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (new File(paramString).exists()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(EditLocalVideoActivity.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("converted_no_video.");
      ((StringBuilder)localObject).append(a(paramString, "m4a"));
      localObject = ((StringBuilder)localObject).toString();
      int i = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-y", "-i", paramString, "-vn", "-c", "copy", "-map", "0:a:0", localObject });
      if (i != 0)
      {
        paramString = new StringBuilder();
        paramString.append("ffmpegRemoveVideoTrack: FFmpeg run failed with ");
        paramString.append(i);
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { paramString.toString() });
        return null;
      }
      return localObject;
    }
    return paramString;
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (new File(paramString).exists()))
    {
      if (paramString.endsWith("m4a")) {
        return paramString;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(EditLocalVideoActivity.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("converted.m4a");
      localObject = ((StringBuilder)localObject).toString();
      int i = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-y", "-i", paramString, "-c:a", "aac", localObject });
      if (i != 0)
      {
        paramString = new StringBuilder();
        paramString.append("ffmpegConvert2AAC: FFmpeg run failed with ");
        paramString.append(i);
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { paramString.toString() });
        return null;
      }
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixHelper
 * JD-Core Version:    0.7.0.1
 */