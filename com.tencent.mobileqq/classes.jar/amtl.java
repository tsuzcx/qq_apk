import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class amtl
{
  private ArrayList<amtm> a = new ArrayList();
  
  /* Error */
  public static amtl a(String paramString)
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: new 28	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 35
    //   17: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 46	java/io/File:exists	()Z
    //   31: ifeq +448 -> 479
    //   34: new 48	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 55	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   47: astore_1
    //   48: aload_1
    //   49: getstatic 61	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   52: lconst_0
    //   53: aload_1
    //   54: invokevirtual 67	java/nio/channels/FileChannel:size	()J
    //   57: invokevirtual 71	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   60: astore_2
    //   61: invokestatic 77	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   64: aload_2
    //   65: invokevirtual 81	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   68: invokevirtual 84	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   71: astore_2
    //   72: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +28 -> 103
    //   78: ldc 91
    //   80: iconst_2
    //   81: new 28	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   88: ldc 93
    //   90: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_2
    //   104: invokestatic 100	amtl:b	(Ljava/lang/String;)Lamtl;
    //   107: astore_2
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 103	java/io/FileInputStream:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   124: aload_2
    //   125: areturn
    //   126: astore_0
    //   127: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   130: ifeq +12 -> 142
    //   133: ldc 91
    //   135: iconst_0
    //   136: ldc 109
    //   138: aload_0
    //   139: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   152: ifeq +12 -> 164
    //   155: ldc 91
    //   157: iconst_0
    //   158: ldc 115
    //   160: aload_1
    //   161: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 103	java/io/FileInputStream:close	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   186: ifeq +12 -> 198
    //   189: ldc 91
    //   191: iconst_0
    //   192: ldc 109
    //   194: aload_0
    //   195: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_1
    //   203: aconst_null
    //   204: astore 4
    //   206: aload_1
    //   207: astore_2
    //   208: aload 4
    //   210: astore_0
    //   211: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   214: ifeq +17 -> 231
    //   217: aload_1
    //   218: astore_2
    //   219: aload 4
    //   221: astore_0
    //   222: ldc 91
    //   224: iconst_0
    //   225: ldc 117
    //   227: aload_3
    //   228: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 103	java/io/FileInputStream:close	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_0
    //   252: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   255: ifeq +12 -> 267
    //   258: ldc 91
    //   260: iconst_0
    //   261: ldc 109
    //   263: aload_0
    //   264: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_3
    //   270: aconst_null
    //   271: astore_1
    //   272: aconst_null
    //   273: astore 4
    //   275: aload_1
    //   276: astore_2
    //   277: aload 4
    //   279: astore_0
    //   280: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   283: ifeq +17 -> 300
    //   286: aload_1
    //   287: astore_2
    //   288: aload 4
    //   290: astore_0
    //   291: ldc 91
    //   293: iconst_0
    //   294: ldc 119
    //   296: aload_3
    //   297: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   300: aload_1
    //   301: astore_2
    //   302: aload 4
    //   304: astore_0
    //   305: invokestatic 122	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   308: ifeq +21 -> 329
    //   311: aload_1
    //   312: astore_2
    //   313: aload 4
    //   315: astore_0
    //   316: invokestatic 128	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   319: ldc 130
    //   321: iconst_0
    //   322: invokestatic 135	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   325: invokevirtual 138	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   328: pop
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 103	java/io/FileInputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   347: aconst_null
    //   348: areturn
    //   349: astore_0
    //   350: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   353: ifeq +12 -> 365
    //   356: ldc 91
    //   358: iconst_0
    //   359: ldc 109
    //   361: aload_0
    //   362: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   365: aconst_null
    //   366: areturn
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_0
    //   372: aload_0
    //   373: ifnull +7 -> 380
    //   376: aload_0
    //   377: invokevirtual 103	java/io/FileInputStream:close	()V
    //   380: aload_2
    //   381: ifnull +7 -> 388
    //   384: aload_2
    //   385: invokevirtual 104	java/nio/channels/FileChannel:close	()V
    //   388: aload_1
    //   389: athrow
    //   390: astore_0
    //   391: invokestatic 107	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   394: ifeq -6 -> 388
    //   397: ldc 91
    //   399: iconst_0
    //   400: ldc 109
    //   402: aload_0
    //   403: invokestatic 113	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   406: goto -18 -> 388
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_2
    //   412: goto -40 -> 372
    //   415: astore_3
    //   416: aload_1
    //   417: astore_2
    //   418: aload_3
    //   419: astore_1
    //   420: goto -48 -> 372
    //   423: astore_1
    //   424: goto -52 -> 372
    //   427: astore_1
    //   428: goto -56 -> 372
    //   431: astore_3
    //   432: aconst_null
    //   433: astore_1
    //   434: aload_0
    //   435: astore 4
    //   437: goto -162 -> 275
    //   440: astore_3
    //   441: aload_0
    //   442: astore 4
    //   444: goto -169 -> 275
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_1
    //   450: aload_0
    //   451: astore 4
    //   453: goto -247 -> 206
    //   456: astore_3
    //   457: aload_0
    //   458: astore 4
    //   460: goto -254 -> 206
    //   463: astore_1
    //   464: aconst_null
    //   465: astore_2
    //   466: goto -317 -> 149
    //   469: astore_2
    //   470: aload_1
    //   471: astore_3
    //   472: aload_2
    //   473: astore_1
    //   474: aload_3
    //   475: astore_2
    //   476: goto -327 -> 149
    //   479: aconst_null
    //   480: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	paramString	String
    //   47	74	1	localFileChannel	java.nio.channels.FileChannel
    //   144	17	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   202	142	1	localObject1	Object
    //   367	22	1	localObject2	Object
    //   409	8	1	localObject3	Object
    //   419	1	1	localObject4	Object
    //   423	1	1	localObject5	Object
    //   427	1	1	localObject6	Object
    //   433	17	1	localObject7	Object
    //   463	8	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   473	1	1	localObject8	Object
    //   60	406	2	localObject9	Object
    //   469	4	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   475	1	2	localObject10	Object
    //   200	28	3	localIOException1	java.io.IOException
    //   269	28	3	localException1	Exception
    //   415	4	3	localObject11	Object
    //   431	1	3	localException2	Exception
    //   440	1	3	localException3	Exception
    //   447	1	3	localIOException2	java.io.IOException
    //   456	1	3	localIOException3	java.io.IOException
    //   471	4	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   204	255	4	str	String
    // Exception table:
    //   from	to	target	type
    //   112	116	126	java/lang/Exception
    //   120	124	126	java/lang/Exception
    //   34	43	144	java/io/FileNotFoundException
    //   168	172	182	java/lang/Exception
    //   176	180	182	java/lang/Exception
    //   34	43	200	java/io/IOException
    //   236	241	251	java/lang/Exception
    //   245	249	251	java/lang/Exception
    //   34	43	269	java/lang/Exception
    //   334	339	349	java/lang/Exception
    //   343	347	349	java/lang/Exception
    //   34	43	367	finally
    //   376	380	390	java/lang/Exception
    //   384	388	390	java/lang/Exception
    //   43	48	409	finally
    //   48	103	415	finally
    //   103	108	415	finally
    //   149	164	423	finally
    //   211	217	427	finally
    //   222	231	427	finally
    //   280	286	427	finally
    //   291	300	427	finally
    //   305	311	427	finally
    //   316	329	427	finally
    //   43	48	431	java/lang/Exception
    //   48	103	440	java/lang/Exception
    //   103	108	440	java/lang/Exception
    //   43	48	447	java/io/IOException
    //   48	103	456	java/io/IOException
    //   103	108	456	java/io/IOException
    //   43	48	463	java/io/FileNotFoundException
    //   48	103	469	java/io/FileNotFoundException
    //   103	108	469	java/io/FileNotFoundException
  }
  
  public static amtl b(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      amtl localamtl = new amtl();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("360senceinfo");
      paramString = localamtl;
      if (((JSONObject)localObject).has("360senceinfo"))
      {
        int j = localJSONArray.length();
        paramString = localamtl;
        if (j > 0)
        {
          int i = 0;
          for (;;)
          {
            paramString = localamtl;
            if (i >= j) {
              break;
            }
            paramString = localJSONArray.getJSONObject(i);
            localObject = new amtm();
            if (paramString.has("text")) {
              ((amtm)localObject).jdField_a_of_type_JavaLangString = paramString.optString("text");
            }
            if (paramString.has("starttime")) {
              ((amtm)localObject).jdField_a_of_type_Long = paramString.optLong("starttime");
            }
            if (paramString.has("endtime")) {
              ((amtm)localObject).b = paramString.optLong("endtime");
            }
            localamtl.a.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("ARTransferDoorVideoInfo", 2, "ARTransferDoorVideoInfo parseJson index: " + i + "," + ((amtm)localObject).toString());
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
      paramString = null;
    }
  }
  
  public amtm a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      amtm localamtm = (amtm)localIterator.next();
      long l = localamtm.jdField_a_of_type_Long;
      if ((paramLong < localamtm.b * 1000L) && (paramLong >= l * 1000L)) {
        return localamtm;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */