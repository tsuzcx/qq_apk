package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ARTransferDoorVideoInfo
{
  private ArrayList<ARTransferDoorVideoInfo.PlayGuideShowInfo> a = new ArrayList();
  
  /* Error */
  public static ARTransferDoorVideoInfo a(String paramString)
  {
    // Byte code:
    //   0: new 26	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: pop
    //   14: aload_2
    //   15: ldc 33
    //   17: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: new 35	java/io/File
    //   24: dup
    //   25: aload_2
    //   26: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 46	java/io/File:exists	()Z
    //   37: istore_1
    //   38: aconst_null
    //   39: astore 7
    //   41: aconst_null
    //   42: astore 6
    //   44: aload 7
    //   46: astore_0
    //   47: iload_1
    //   48: ifeq +542 -> 590
    //   51: new 48	java/io/FileInputStream
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 55	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   64: astore 4
    //   66: aload 4
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: aload 4
    //   73: getstatic 61	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   76: lconst_0
    //   77: aload 4
    //   79: invokevirtual 67	java/nio/channels/FileChannel:size	()J
    //   82: invokevirtual 71	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   85: astore 5
    //   87: aload 4
    //   89: astore_2
    //   90: aload_0
    //   91: astore_3
    //   92: invokestatic 77	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   95: aload 5
    //   97: invokevirtual 81	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   100: invokevirtual 84	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   103: astore 5
    //   105: aload 4
    //   107: astore_2
    //   108: aload_0
    //   109: astore_3
    //   110: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +59 -> 172
    //   116: aload 4
    //   118: astore_2
    //   119: aload_0
    //   120: astore_3
    //   121: new 26	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   128: astore 8
    //   130: aload 4
    //   132: astore_2
    //   133: aload_0
    //   134: astore_3
    //   135: aload 8
    //   137: ldc 91
    //   139: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 4
    //   145: astore_2
    //   146: aload_0
    //   147: astore_3
    //   148: aload 8
    //   150: aload 5
    //   152: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: astore_2
    //   159: aload_0
    //   160: astore_3
    //   161: ldc 93
    //   163: iconst_2
    //   164: aload 8
    //   166: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 4
    //   174: astore_2
    //   175: aload_0
    //   176: astore_3
    //   177: aload 5
    //   179: invokestatic 100	com/tencent/mobileqq/ar/ARPromotion/ARTransferDoorVideoInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/ARPromotion/ARTransferDoorVideoInfo;
    //   182: astore 5
    //   184: aload_0
    //   185: invokevirtual 103	java/io/FileInputStream:close	()V
    //   188: aload 5
    //   190: astore_0
    //   191: aload 4
    //   193: ifnull +397 -> 590
    //   196: aload 4
    //   198: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   201: aload 5
    //   203: areturn
    //   204: astore_2
    //   205: aload 5
    //   207: astore_0
    //   208: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   211: ifeq +379 -> 590
    //   214: aload_2
    //   215: astore_0
    //   216: ldc 93
    //   218: iconst_0
    //   219: ldc 109
    //   221: aload_0
    //   222: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   225: aload 5
    //   227: areturn
    //   228: astore 5
    //   230: goto +59 -> 289
    //   233: astore 5
    //   235: goto +161 -> 396
    //   238: astore 5
    //   240: goto +234 -> 474
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_2
    //   246: goto +305 -> 551
    //   249: astore 5
    //   251: aconst_null
    //   252: astore 4
    //   254: goto +35 -> 289
    //   257: astore 5
    //   259: aconst_null
    //   260: astore 4
    //   262: goto +134 -> 396
    //   265: astore 5
    //   267: aconst_null
    //   268: astore 4
    //   270: goto +204 -> 474
    //   273: astore_3
    //   274: aconst_null
    //   275: astore_0
    //   276: aload_0
    //   277: astore_2
    //   278: goto +273 -> 551
    //   281: astore 5
    //   283: aconst_null
    //   284: astore 4
    //   286: aload 4
    //   288: astore_0
    //   289: aload 4
    //   291: astore_2
    //   292: aload_0
    //   293: astore_3
    //   294: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   297: ifeq +18 -> 315
    //   300: aload 4
    //   302: astore_2
    //   303: aload_0
    //   304: astore_3
    //   305: ldc 93
    //   307: iconst_0
    //   308: ldc 115
    //   310: aload 5
    //   312: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   315: aload 4
    //   317: astore_2
    //   318: aload_0
    //   319: astore_3
    //   320: invokestatic 118	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   323: ifeq +21 -> 344
    //   326: aload 4
    //   328: astore_2
    //   329: aload_0
    //   330: astore_3
    //   331: invokestatic 124	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   334: ldc 126
    //   336: iconst_0
    //   337: invokestatic 131	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   340: invokevirtual 134	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   343: pop
    //   344: aload_0
    //   345: ifnull +10 -> 355
    //   348: aload_0
    //   349: invokevirtual 103	java/io/FileInputStream:close	()V
    //   352: goto +3 -> 355
    //   355: aload 7
    //   357: astore_0
    //   358: aload 4
    //   360: ifnull +230 -> 590
    //   363: aload 4
    //   365: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   368: aconst_null
    //   369: areturn
    //   370: aload 7
    //   372: astore_0
    //   373: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   376: ifeq +214 -> 590
    //   379: aload_2
    //   380: astore_0
    //   381: aload 6
    //   383: astore 5
    //   385: goto -169 -> 216
    //   388: astore 5
    //   390: aconst_null
    //   391: astore 4
    //   393: aload 4
    //   395: astore_0
    //   396: aload 4
    //   398: astore_2
    //   399: aload_0
    //   400: astore_3
    //   401: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   404: ifeq +18 -> 422
    //   407: aload 4
    //   409: astore_2
    //   410: aload_0
    //   411: astore_3
    //   412: ldc 93
    //   414: iconst_0
    //   415: ldc 136
    //   417: aload 5
    //   419: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   422: aload_0
    //   423: ifnull +10 -> 433
    //   426: aload_0
    //   427: invokevirtual 103	java/io/FileInputStream:close	()V
    //   430: goto +3 -> 433
    //   433: aload 7
    //   435: astore_0
    //   436: aload 4
    //   438: ifnull +152 -> 590
    //   441: aload 4
    //   443: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   446: aconst_null
    //   447: areturn
    //   448: aload 7
    //   450: astore_0
    //   451: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   454: ifeq +136 -> 590
    //   457: aload_2
    //   458: astore_0
    //   459: aload 6
    //   461: astore 5
    //   463: goto -247 -> 216
    //   466: astore 5
    //   468: aconst_null
    //   469: astore 4
    //   471: aload 4
    //   473: astore_0
    //   474: aload 4
    //   476: astore_2
    //   477: aload_0
    //   478: astore_3
    //   479: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   482: ifeq +18 -> 500
    //   485: aload 4
    //   487: astore_2
    //   488: aload_0
    //   489: astore_3
    //   490: ldc 93
    //   492: iconst_0
    //   493: ldc 138
    //   495: aload 5
    //   497: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   500: aload_0
    //   501: ifnull +10 -> 511
    //   504: aload_0
    //   505: invokevirtual 103	java/io/FileInputStream:close	()V
    //   508: goto +3 -> 511
    //   511: aload 7
    //   513: astore_0
    //   514: aload 4
    //   516: ifnull +74 -> 590
    //   519: aload 4
    //   521: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   524: aconst_null
    //   525: areturn
    //   526: aload 7
    //   528: astore_0
    //   529: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   532: ifeq +58 -> 590
    //   535: aload_2
    //   536: astore_0
    //   537: aload 6
    //   539: astore 5
    //   541: goto -325 -> 216
    //   544: astore 4
    //   546: aload_3
    //   547: astore_0
    //   548: aload 4
    //   550: astore_3
    //   551: aload_0
    //   552: ifnull +10 -> 562
    //   555: aload_0
    //   556: invokevirtual 103	java/io/FileInputStream:close	()V
    //   559: goto +3 -> 562
    //   562: aload_2
    //   563: ifnull +25 -> 588
    //   566: aload_2
    //   567: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   570: goto +18 -> 588
    //   573: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   576: ifeq +12 -> 588
    //   579: ldc 93
    //   581: iconst_0
    //   582: ldc 109
    //   584: aload_0
    //   585: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   588: aload_3
    //   589: athrow
    //   590: aload_0
    //   591: areturn
    //   592: astore_2
    //   593: goto -223 -> 370
    //   596: astore_2
    //   597: goto -149 -> 448
    //   600: astore_2
    //   601: goto -75 -> 526
    //   604: astore_0
    //   605: goto -32 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramString	String
    //   37	11	1	bool	boolean
    //   7	168	2	localObject1	Object
    //   204	11	2	localException1	Exception
    //   245	322	2	localObject2	Object
    //   592	1	2	localException2	Exception
    //   596	1	2	localException3	Exception
    //   600	1	2	localException4	Exception
    //   70	107	3	str	String
    //   243	1	3	localObject3	Object
    //   273	1	3	localObject4	Object
    //   293	296	3	localObject5	Object
    //   64	456	4	localFileChannel	java.nio.channels.FileChannel
    //   544	5	4	localObject6	Object
    //   85	141	5	localObject7	Object
    //   228	1	5	localException5	Exception
    //   233	1	5	localIOException1	java.io.IOException
    //   238	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   249	1	5	localException6	Exception
    //   257	1	5	localIOException2	java.io.IOException
    //   265	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   281	30	5	localException7	Exception
    //   383	1	5	localObject8	Object
    //   388	30	5	localIOException3	java.io.IOException
    //   461	1	5	localObject9	Object
    //   466	30	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   539	1	5	localObject10	Object
    //   42	496	6	localObject11	Object
    //   39	488	7	localObject12	Object
    //   128	37	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   184	188	204	java/lang/Exception
    //   196	201	204	java/lang/Exception
    //   71	87	228	java/lang/Exception
    //   92	105	228	java/lang/Exception
    //   110	116	228	java/lang/Exception
    //   121	130	228	java/lang/Exception
    //   135	143	228	java/lang/Exception
    //   148	156	228	java/lang/Exception
    //   161	172	228	java/lang/Exception
    //   177	184	228	java/lang/Exception
    //   71	87	233	java/io/IOException
    //   92	105	233	java/io/IOException
    //   110	116	233	java/io/IOException
    //   121	130	233	java/io/IOException
    //   135	143	233	java/io/IOException
    //   148	156	233	java/io/IOException
    //   161	172	233	java/io/IOException
    //   177	184	233	java/io/IOException
    //   71	87	238	java/io/FileNotFoundException
    //   92	105	238	java/io/FileNotFoundException
    //   110	116	238	java/io/FileNotFoundException
    //   121	130	238	java/io/FileNotFoundException
    //   135	143	238	java/io/FileNotFoundException
    //   148	156	238	java/io/FileNotFoundException
    //   161	172	238	java/io/FileNotFoundException
    //   177	184	238	java/io/FileNotFoundException
    //   60	66	243	finally
    //   60	66	249	java/lang/Exception
    //   60	66	257	java/io/IOException
    //   60	66	265	java/io/FileNotFoundException
    //   51	60	273	finally
    //   51	60	281	java/lang/Exception
    //   51	60	388	java/io/IOException
    //   51	60	466	java/io/FileNotFoundException
    //   71	87	544	finally
    //   92	105	544	finally
    //   110	116	544	finally
    //   121	130	544	finally
    //   135	143	544	finally
    //   148	156	544	finally
    //   161	172	544	finally
    //   177	184	544	finally
    //   294	300	544	finally
    //   305	315	544	finally
    //   320	326	544	finally
    //   331	344	544	finally
    //   401	407	544	finally
    //   412	422	544	finally
    //   479	485	544	finally
    //   490	500	544	finally
    //   348	352	592	java/lang/Exception
    //   363	368	592	java/lang/Exception
    //   426	430	596	java/lang/Exception
    //   441	446	596	java/lang/Exception
    //   504	508	600	java/lang/Exception
    //   519	524	600	java/lang/Exception
    //   555	559	604	java/lang/Exception
    //   566	570	604	java/lang/Exception
  }
  
  public static ARTransferDoorVideoInfo b(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = new ARTransferDoorVideoInfo();
      JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("360senceinfo");
      if (((JSONObject)localObject1).has("360senceinfo"))
      {
        int j = localJSONArray.length();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = new ARTransferDoorVideoInfo.PlayGuideShowInfo();
            if (((JSONObject)localObject2).has("text")) {
              ((ARTransferDoorVideoInfo.PlayGuideShowInfo)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("text");
            }
            if (((JSONObject)localObject2).has("starttime")) {
              ((ARTransferDoorVideoInfo.PlayGuideShowInfo)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("starttime");
            }
            if (((JSONObject)localObject2).has("endtime")) {
              ((ARTransferDoorVideoInfo.PlayGuideShowInfo)localObject1).b = ((JSONObject)localObject2).optLong("endtime");
            }
            paramString.a.add(localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ARTransferDoorVideoInfo parseJson index: ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(",");
              ((StringBuilder)localObject2).append(((ARTransferDoorVideoInfo.PlayGuideShowInfo)localObject1).toString());
              QLog.d("ARTransferDoorVideoInfo", 2, ((StringBuilder)localObject2).toString());
            }
            i += 1;
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("ARTransferDoorVideoInfo", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  public ARTransferDoorVideoInfo.PlayGuideShowInfo a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ARTransferDoorVideoInfo.PlayGuideShowInfo localPlayGuideShowInfo = (ARTransferDoorVideoInfo.PlayGuideShowInfo)localIterator.next();
      long l = localPlayGuideShowInfo.jdField_a_of_type_Long;
      if ((paramLong < localPlayGuideShowInfo.b * 1000L) && (paramLong >= l * 1000L)) {
        return localPlayGuideShowInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorVideoInfo
 * JD-Core Version:    0.7.0.1
 */