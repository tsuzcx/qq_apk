package com.tencent.TMG.utils;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CosFileTransfer
{
  public static final String TAG = "CosFileTransfer";
  
  public static void downloadFile(String paramString1, final String paramString2, final String paramString3, final Object paramObject, final DownloadCosFileListener paramDownloadCosFileListener)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: aconst_null
        //   3: astore 5
        //   5: aconst_null
        //   6: astore 9
        //   8: aconst_null
        //   9: astore 7
        //   11: aconst_null
        //   12: astore 8
        //   14: aconst_null
        //   15: astore 6
        //   17: sipush 12292
        //   20: istore_2
        //   21: aload_0
        //   22: getfield 23	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   25: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   28: ifeq +71 -> 99
        //   31: ldc 50
        //   33: ldc 52
        //   35: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   38: pop
        //   39: aconst_null
        //   40: astore 4
        //   42: aconst_null
        //   43: astore 5
        //   45: iload_2
        //   46: istore_1
        //   47: aload 5
        //   49: ifnull +8 -> 57
        //   52: aload 5
        //   54: invokevirtual 63	java/io/FileOutputStream:close	()V
        //   57: aload 4
        //   59: ifnull +8 -> 67
        //   62: aload 4
        //   64: invokevirtual 66	java/io/InputStream:close	()V
        //   67: aload 6
        //   69: ifnull +8 -> 77
        //   72: aload 6
        //   74: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
        //   77: aload_0
        //   78: getfield 29	com/tencent/TMG/utils/CosFileTransfer$2:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$DownloadCosFileListener;
        //   81: ifnull +17 -> 98
        //   84: aload_0
        //   85: getfield 29	com/tencent/TMG/utils/CosFileTransfer$2:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$DownloadCosFileListener;
        //   88: iload_1
        //   89: aload_0
        //   90: getfield 31	com/tencent/TMG/utils/CosFileTransfer$2:val$param	Ljava/lang/Object;
        //   93: invokeinterface 77 3 0
        //   98: return
        //   99: aload_0
        //   100: getfield 25	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
        //   103: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   106: ifeq +24 -> 130
        //   109: ldc 50
        //   111: ldc 79
        //   113: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   116: pop
        //   117: sipush 12289
        //   120: istore_1
        //   121: aconst_null
        //   122: astore 4
        //   124: aconst_null
        //   125: astore 5
        //   127: goto -80 -> 47
        //   130: new 81	java/net/URL
        //   133: dup
        //   134: aload_0
        //   135: getfield 23	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   138: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
        //   141: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   144: checkcast 68	java/net/HttpURLConnection
        //   147: astore 4
        //   149: aload 4
        //   151: ldc 90
        //   153: invokevirtual 93	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   156: aload 4
        //   158: ldc 95
        //   160: aload_0
        //   161: getfield 27	com/tencent/TMG/utils/CosFileTransfer$2:val$sign	Ljava/lang/String;
        //   164: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: aload 4
        //   169: ldc 101
        //   171: ldc 103
        //   173: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   176: aload 4
        //   178: ldc 105
        //   180: ldc 107
        //   182: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   185: aload 4
        //   187: invokevirtual 111	java/net/HttpURLConnection:getResponseCode	()I
        //   190: istore_3
        //   191: iload_3
        //   192: sipush 200
        //   195: if_icmpne +251 -> 446
        //   198: new 113	java/io/File
        //   201: dup
        //   202: aload_0
        //   203: getfield 25	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
        //   206: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
        //   209: astore 5
        //   211: aload 5
        //   213: invokevirtual 118	java/io/File:exists	()Z
        //   216: ifne +9 -> 225
        //   219: aload 5
        //   221: invokevirtual 121	java/io/File:createNewFile	()Z
        //   224: pop
        //   225: new 60	java/io/FileOutputStream
        //   228: dup
        //   229: aload 5
        //   231: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   234: astore 5
        //   236: aload 4
        //   238: invokevirtual 128	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   241: astore 6
        //   243: aload 6
        //   245: astore 7
        //   247: aload 6
        //   249: astore 8
        //   251: aload 6
        //   253: astore 9
        //   255: aload 4
        //   257: invokevirtual 128	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   260: astore 6
        //   262: aload 6
        //   264: astore 7
        //   266: aload 6
        //   268: astore 8
        //   270: aload 6
        //   272: astore 9
        //   274: sipush 1024
        //   277: newarray byte
        //   279: astore 10
        //   281: aload 6
        //   283: astore 7
        //   285: aload 6
        //   287: astore 8
        //   289: aload 6
        //   291: astore 9
        //   293: aload 6
        //   295: aload 10
        //   297: invokevirtual 132	java/io/InputStream:read	([B)I
        //   300: istore_3
        //   301: iload_3
        //   302: iconst_m1
        //   303: if_icmpeq +112 -> 415
        //   306: aload 6
        //   308: astore 7
        //   310: aload 6
        //   312: astore 8
        //   314: aload 6
        //   316: astore 9
        //   318: aload 5
        //   320: aload 10
        //   322: iconst_0
        //   323: iload_3
        //   324: invokevirtual 136	java/io/FileOutputStream:write	([BII)V
        //   327: goto -46 -> 281
        //   330: astore 8
        //   332: aload 4
        //   334: astore 6
        //   336: aload 7
        //   338: astore 4
        //   340: aload 8
        //   342: astore 7
        //   344: ldc 50
        //   346: new 138	java/lang/StringBuilder
        //   349: dup
        //   350: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   353: ldc 141
        //   355: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   358: aload_0
        //   359: getfield 23	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   362: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   365: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   368: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   371: pop
        //   372: aload 7
        //   374: invokevirtual 152	java/net/MalformedURLException:printStackTrace	()V
        //   377: iload_2
        //   378: istore_1
        //   379: goto -332 -> 47
        //   382: astore 6
        //   384: ldc 50
        //   386: ldc 154
        //   388: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   391: pop
        //   392: aload 6
        //   394: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   397: sipush 12291
        //   400: istore_1
        //   401: aconst_null
        //   402: astore 7
        //   404: aload 4
        //   406: astore 6
        //   408: aload 7
        //   410: astore 4
        //   412: goto -365 -> 47
        //   415: aload 6
        //   417: astore 7
        //   419: aload 5
        //   421: astore 6
        //   423: aload 7
        //   425: astore 5
        //   427: aload 6
        //   429: astore 7
        //   431: aload 4
        //   433: astore 6
        //   435: aload 5
        //   437: astore 4
        //   439: aload 7
        //   441: astore 5
        //   443: goto -396 -> 47
        //   446: iload_3
        //   447: sipush 404
        //   450: if_icmpne +45 -> 495
        //   453: ldc 50
        //   455: new 138	java/lang/StringBuilder
        //   458: dup
        //   459: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   462: ldc 141
        //   464: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   467: aload_0
        //   468: getfield 23	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   471: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   474: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   477: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   480: pop
        //   481: sipush 12292
        //   484: istore_1
        //   485: aconst_null
        //   486: astore 5
        //   488: aload 9
        //   490: astore 6
        //   492: goto -65 -> 427
        //   495: ldc 50
        //   497: new 138	java/lang/StringBuilder
        //   500: dup
        //   501: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   504: ldc 157
        //   506: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   509: aload_0
        //   510: getfield 23	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   513: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   516: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   519: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   522: pop
        //   523: sipush 12291
        //   526: istore_1
        //   527: aconst_null
        //   528: astore 5
        //   530: aload 9
        //   532: astore 6
        //   534: goto -107 -> 427
        //   537: astore 8
        //   539: aconst_null
        //   540: astore 4
        //   542: aconst_null
        //   543: astore 5
        //   545: aload 7
        //   547: astore 6
        //   549: aload 8
        //   551: astore 7
        //   553: ldc 50
        //   555: ldc 159
        //   557: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   560: pop
        //   561: aload 7
        //   563: invokevirtual 160	java/net/UnknownHostException:printStackTrace	()V
        //   566: sipush 12291
        //   569: istore_1
        //   570: goto -523 -> 47
        //   573: astore 7
        //   575: aconst_null
        //   576: astore 4
        //   578: aconst_null
        //   579: astore 5
        //   581: aload 8
        //   583: astore 6
        //   585: ldc 50
        //   587: new 138	java/lang/StringBuilder
        //   590: dup
        //   591: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   594: ldc 162
        //   596: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   599: aload_0
        //   600: getfield 25	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
        //   603: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   606: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   609: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   612: pop
        //   613: aload 7
        //   615: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   618: sipush 12289
        //   621: istore_1
        //   622: goto -575 -> 47
        //   625: astore 5
        //   627: aload 5
        //   629: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   632: goto -575 -> 57
        //   635: astore 4
        //   637: aload 4
        //   639: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   642: goto -575 -> 67
        //   645: astore 7
        //   647: aconst_null
        //   648: astore 5
        //   650: aconst_null
        //   651: astore 8
        //   653: aload 4
        //   655: astore 6
        //   657: aload 8
        //   659: astore 4
        //   661: goto -76 -> 585
        //   664: astore 7
        //   666: aconst_null
        //   667: astore 8
        //   669: aload 4
        //   671: astore 6
        //   673: aload 8
        //   675: astore 4
        //   677: goto -92 -> 585
        //   680: astore 7
        //   682: aload 4
        //   684: astore 6
        //   686: aload 8
        //   688: astore 4
        //   690: goto -105 -> 585
        //   693: astore 7
        //   695: aconst_null
        //   696: astore 5
        //   698: aconst_null
        //   699: astore 8
        //   701: aload 4
        //   703: astore 6
        //   705: aload 8
        //   707: astore 4
        //   709: goto -156 -> 553
        //   712: astore 7
        //   714: aconst_null
        //   715: astore 8
        //   717: aload 4
        //   719: astore 6
        //   721: aload 8
        //   723: astore 4
        //   725: goto -172 -> 553
        //   728: astore 7
        //   730: aload 4
        //   732: astore 6
        //   734: aload 9
        //   736: astore 4
        //   738: goto -185 -> 553
        //   741: astore 7
        //   743: aconst_null
        //   744: astore 4
        //   746: aconst_null
        //   747: astore 8
        //   749: aload 5
        //   751: astore 6
        //   753: aload 8
        //   755: astore 5
        //   757: goto -413 -> 344
        //   760: astore 7
        //   762: aconst_null
        //   763: astore 5
        //   765: aconst_null
        //   766: astore 8
        //   768: aload 4
        //   770: astore 6
        //   772: aload 8
        //   774: astore 4
        //   776: goto -432 -> 344
        //   779: astore 7
        //   781: aconst_null
        //   782: astore 8
        //   784: aload 4
        //   786: astore 6
        //   788: aload 8
        //   790: astore 4
        //   792: goto -448 -> 344
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	795	0	this	2
        //   1	621	1	i	int
        //   20	358	2	j	int
        //   190	261	3	k	int
        //   40	537	4	localObject1	Object
        //   635	19	4	localIOException1	java.io.IOException
        //   659	132	4	localObject2	Object
        //   3	577	5	localObject3	Object
        //   625	3	5	localIOException2	java.io.IOException
        //   648	116	5	localObject4	Object
        //   15	320	6	localObject5	Object
        //   382	11	6	localIOException3	java.io.IOException
        //   406	381	6	localObject6	Object
        //   9	553	7	localObject7	Object
        //   573	41	7	localIOException4	java.io.IOException
        //   645	1	7	localIOException5	java.io.IOException
        //   664	1	7	localIOException6	java.io.IOException
        //   680	1	7	localIOException7	java.io.IOException
        //   693	1	7	localUnknownHostException1	java.net.UnknownHostException
        //   712	1	7	localUnknownHostException2	java.net.UnknownHostException
        //   728	1	7	localUnknownHostException3	java.net.UnknownHostException
        //   741	1	7	localMalformedURLException1	java.net.MalformedURLException
        //   760	1	7	localMalformedURLException2	java.net.MalformedURLException
        //   779	1	7	localMalformedURLException3	java.net.MalformedURLException
        //   12	301	8	localObject8	Object
        //   330	11	8	localMalformedURLException4	java.net.MalformedURLException
        //   537	45	8	localUnknownHostException4	java.net.UnknownHostException
        //   651	138	8	localObject9	Object
        //   6	729	9	localObject10	Object
        //   279	42	10	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   255	262	330	java/net/MalformedURLException
        //   274	281	330	java/net/MalformedURLException
        //   293	301	330	java/net/MalformedURLException
        //   318	327	330	java/net/MalformedURLException
        //   236	243	382	java/io/IOException
        //   130	149	537	java/net/UnknownHostException
        //   130	149	573	java/io/IOException
        //   52	57	625	java/io/IOException
        //   62	67	635	java/io/IOException
        //   149	191	645	java/io/IOException
        //   198	225	645	java/io/IOException
        //   225	236	645	java/io/IOException
        //   453	481	645	java/io/IOException
        //   495	523	645	java/io/IOException
        //   384	397	664	java/io/IOException
        //   255	262	680	java/io/IOException
        //   274	281	680	java/io/IOException
        //   293	301	680	java/io/IOException
        //   318	327	680	java/io/IOException
        //   149	191	693	java/net/UnknownHostException
        //   198	225	693	java/net/UnknownHostException
        //   225	236	693	java/net/UnknownHostException
        //   453	481	693	java/net/UnknownHostException
        //   495	523	693	java/net/UnknownHostException
        //   236	243	712	java/net/UnknownHostException
        //   384	397	712	java/net/UnknownHostException
        //   255	262	728	java/net/UnknownHostException
        //   274	281	728	java/net/UnknownHostException
        //   293	301	728	java/net/UnknownHostException
        //   318	327	728	java/net/UnknownHostException
        //   130	149	741	java/net/MalformedURLException
        //   149	191	760	java/net/MalformedURLException
        //   198	225	760	java/net/MalformedURLException
        //   225	236	760	java/net/MalformedURLException
        //   453	481	760	java/net/MalformedURLException
        //   495	523	760	java/net/MalformedURLException
        //   236	243	779	java/net/MalformedURLException
        //   384	397	779	java/net/MalformedURLException
      }
    }).start();
  }
  
  private static String getParamString(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = "";; paramMap = paramMap + (String)((Map.Entry)localObject).getValue() + "\r\n")
      {
        localObject = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramMap = paramMap + "--" + paramString + "\r\n";
        paramMap = paramMap + "Content-Disposition: form-data; name=\"" + (String)((Map.Entry)localObject).getKey() + "\"\r\n\r\n";
      }
    }
    Object localObject = "";
    return localObject;
  }
  
  private static File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("CosFileTransfer", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("CosFileTransfer", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  public static void uploadFile(String paramString1, final String paramString2, final String paramString3, final int paramInt, final Object paramObject, final UploadCosFileListener paramUploadCosFileListener)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: sipush 8195
        //   5: istore_2
        //   6: aconst_null
        //   7: astore 9
        //   9: aconst_null
        //   10: astore 6
        //   12: aconst_null
        //   13: astore 11
        //   15: ldc 48
        //   17: astore 8
        //   19: aload_0
        //   20: getfield 25	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
        //   23: invokestatic 52	com/tencent/TMG/utils/CosFileTransfer:access$000	(Ljava/lang/String;)Ljava/io/File;
        //   26: astore 4
        //   28: aload 4
        //   30: ifnonnull +87 -> 117
        //   33: sipush 8193
        //   36: istore_1
        //   37: aconst_null
        //   38: astore 6
        //   40: aconst_null
        //   41: astore 7
        //   43: aconst_null
        //   44: astore 4
        //   46: aconst_null
        //   47: astore 5
        //   49: aload 11
        //   51: astore 8
        //   53: aload 5
        //   55: ifnull +8 -> 63
        //   58: aload 5
        //   60: invokevirtual 57	java/io/FileInputStream:close	()V
        //   63: aload 7
        //   65: ifnull +8 -> 73
        //   68: aload 7
        //   70: invokevirtual 60	java/io/OutputStream:close	()V
        //   73: aload 6
        //   75: ifnull +8 -> 83
        //   78: aload 6
        //   80: invokevirtual 63	java/io/BufferedReader:close	()V
        //   83: aload 4
        //   85: ifnull +8 -> 93
        //   88: aload 4
        //   90: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
        //   93: aload_0
        //   94: getfield 33	com/tencent/TMG/utils/CosFileTransfer$1:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$UploadCosFileListener;
        //   97: ifnull +19 -> 116
        //   100: aload_0
        //   101: getfield 33	com/tencent/TMG/utils/CosFileTransfer$1:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$UploadCosFileListener;
        //   104: iload_1
        //   105: aload 8
        //   107: aload_0
        //   108: getfield 35	com/tencent/TMG/utils/CosFileTransfer$1:val$param	Ljava/lang/Object;
        //   111: invokeinterface 74 4 0
        //   116: return
        //   117: aload_0
        //   118: getfield 25	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
        //   121: invokestatic 80	com/tencent/TMG/ptt/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
        //   124: astore 10
        //   126: new 54	java/io/FileInputStream
        //   129: dup
        //   130: aload 4
        //   132: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   135: astore 5
        //   137: aload 5
        //   139: invokevirtual 87	java/io/FileInputStream:available	()I
        //   142: istore_3
        //   143: iload_3
        //   144: ifle +11 -> 155
        //   147: iload_3
        //   148: aload_0
        //   149: getfield 27	com/tencent/TMG/utils/CosFileTransfer$1:val$maxSize	I
        //   152: if_icmple +60 -> 212
        //   155: ldc 89
        //   157: new 91	java/lang/StringBuilder
        //   160: dup
        //   161: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   164: ldc 94
        //   166: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: aload_0
        //   170: getfield 25	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
        //   173: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: ldc 100
        //   178: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   181: iload_3
        //   182: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   185: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   188: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   191: pop
        //   192: sipush 8193
        //   195: istore_1
        //   196: aconst_null
        //   197: astore 6
        //   199: aconst_null
        //   200: astore 7
        //   202: aconst_null
        //   203: astore 4
        //   205: aload 11
        //   207: astore 8
        //   209: goto -156 -> 53
        //   212: new 115	java/net/URL
        //   215: dup
        //   216: aload_0
        //   217: getfield 29	com/tencent/TMG/utils/CosFileTransfer$1:val$strUrl	Ljava/lang/String;
        //   220: invokespecial 118	java/net/URL:<init>	(Ljava/lang/String;)V
        //   223: invokevirtual 122	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   226: checkcast 65	java/net/HttpURLConnection
        //   229: astore 4
        //   231: aload 4
        //   233: sipush 5000
        //   236: invokevirtual 126	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   239: aload 4
        //   241: sipush 30000
        //   244: invokevirtual 129	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   247: aload 4
        //   249: iconst_1
        //   250: invokevirtual 133	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   253: aload 4
        //   255: iconst_1
        //   256: invokevirtual 136	java/net/HttpURLConnection:setDoInput	(Z)V
        //   259: aload 4
        //   261: iconst_0
        //   262: invokevirtual 139	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   265: aload 4
        //   267: ldc 141
        //   269: invokevirtual 144	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   272: aload 4
        //   274: ldc 146
        //   276: ldc 148
        //   278: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   281: aload 4
        //   283: ldc 154
        //   285: aload_0
        //   286: getfield 31	com/tencent/TMG/utils/CosFileTransfer$1:val$sign	Ljava/lang/String;
        //   289: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   292: aload 4
        //   294: ldc 156
        //   296: new 91	java/lang/StringBuilder
        //   299: dup
        //   300: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   303: ldc 158
        //   305: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   308: ldc 160
        //   310: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   313: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   316: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   319: new 162	java/io/DataOutputStream
        //   322: dup
        //   323: aload 4
        //   325: invokevirtual 166	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   328: invokespecial 169	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   331: astore 7
        //   333: new 171	java/util/HashMap
        //   336: dup
        //   337: iconst_3
        //   338: invokespecial 173	java/util/HashMap:<init>	(I)V
        //   341: astore 12
        //   343: aload 12
        //   345: ldc 175
        //   347: ldc 177
        //   349: invokeinterface 183 3 0
        //   354: pop
        //   355: aload 12
        //   357: ldc 185
        //   359: aload 10
        //   361: invokeinterface 183 3 0
        //   366: pop
        //   367: aload 12
        //   369: ldc 187
        //   371: ldc 48
        //   373: invokeinterface 183 3 0
        //   378: pop
        //   379: aload 12
        //   381: ldc 160
        //   383: invokestatic 191	com/tencent/TMG/utils/CosFileTransfer:access$100	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
        //   386: astore 10
        //   388: new 91	java/lang/StringBuilder
        //   391: dup
        //   392: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   395: aload 10
        //   397: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   400: ldc 193
        //   402: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   405: ldc 160
        //   407: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: ldc 195
        //   412: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   415: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   418: astore 10
        //   420: new 91	java/lang/StringBuilder
        //   423: dup
        //   424: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   427: aload 10
        //   429: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   432: ldc 197
        //   434: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   437: aload_0
        //   438: getfield 25	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
        //   441: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   444: ldc 199
        //   446: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   449: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   452: astore 10
        //   454: aload 7
        //   456: new 91	java/lang/StringBuilder
        //   459: dup
        //   460: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   463: aload 10
        //   465: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   468: ldc 201
        //   470: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   473: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   476: invokevirtual 207	java/lang/String:getBytes	()[B
        //   479: invokevirtual 211	java/io/OutputStream:write	([B)V
        //   482: sipush 1024
        //   485: newarray byte
        //   487: astore 10
        //   489: aload 5
        //   491: aload 10
        //   493: invokevirtual 215	java/io/FileInputStream:read	([B)I
        //   496: istore_3
        //   497: iload_3
        //   498: iconst_m1
        //   499: if_icmpeq +70 -> 569
        //   502: aload 7
        //   504: aload 10
        //   506: iconst_0
        //   507: iload_3
        //   508: invokevirtual 218	java/io/OutputStream:write	([BII)V
        //   511: goto -22 -> 489
        //   514: astore 9
        //   516: aconst_null
        //   517: astore 6
        //   519: aload 7
        //   521: astore 8
        //   523: aload 4
        //   525: astore 7
        //   527: aload 8
        //   529: astore 4
        //   531: aload 9
        //   533: astore 8
        //   535: ldc 89
        //   537: ldc 220
        //   539: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   542: pop
        //   543: aload 8
        //   545: invokevirtual 223	java/net/UnknownHostException:printStackTrace	()V
        //   548: aload 7
        //   550: astore 8
        //   552: aload 4
        //   554: astore 7
        //   556: aload 8
        //   558: astore 4
        //   560: aload 11
        //   562: astore 8
        //   564: iload_2
        //   565: istore_1
        //   566: goto -513 -> 53
        //   569: aload 7
        //   571: new 91	java/lang/StringBuilder
        //   574: dup
        //   575: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   578: ldc 225
        //   580: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   583: ldc 160
        //   585: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   588: ldc 227
        //   590: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   593: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   596: invokevirtual 207	java/lang/String:getBytes	()[B
        //   599: invokevirtual 211	java/io/OutputStream:write	([B)V
        //   602: aload 7
        //   604: invokevirtual 230	java/io/OutputStream:flush	()V
        //   607: aload 4
        //   609: invokevirtual 233	java/net/HttpURLConnection:getResponseCode	()I
        //   612: istore_3
        //   613: ldc 89
        //   615: new 91	java/lang/StringBuilder
        //   618: dup
        //   619: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   622: ldc 235
        //   624: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   627: iload_3
        //   628: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   631: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   634: invokestatic 238	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   637: pop
        //   638: iload_3
        //   639: sipush 200
        //   642: if_icmpne +196 -> 838
        //   645: new 62	java/io/BufferedReader
        //   648: dup
        //   649: new 240	java/io/InputStreamReader
        //   652: dup
        //   653: aload 4
        //   655: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   658: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   661: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   664: astore 6
        //   666: aload 6
        //   668: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   671: astore 10
        //   673: aload 10
        //   675: ifnull +32 -> 707
        //   678: new 91	java/lang/StringBuilder
        //   681: dup
        //   682: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   685: aload 8
        //   687: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   690: aload 10
        //   692: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   695: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   698: astore 10
        //   700: aload 10
        //   702: astore 8
        //   704: goto -38 -> 666
        //   707: ldc 89
        //   709: new 91	java/lang/StringBuilder
        //   712: dup
        //   713: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   716: ldc 255
        //   718: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   721: aload 8
        //   723: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   726: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   729: invokestatic 258	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   732: pop
        //   733: new 260	org/json/JSONObject
        //   736: dup
        //   737: aload 8
        //   739: invokespecial 261	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   742: astore 10
        //   744: aload 10
        //   746: ldc_w 263
        //   749: invokevirtual 267	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   752: istore_3
        //   753: iload_3
        //   754: ifne +26 -> 780
        //   757: aload 10
        //   759: ldc_w 269
        //   762: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   765: ldc_w 275
        //   768: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   771: astore 9
        //   773: aload 9
        //   775: astore 8
        //   777: goto +452 -> 1229
        //   780: aload 10
        //   782: ldc_w 280
        //   785: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   788: astore 10
        //   790: ldc 89
        //   792: new 91	java/lang/StringBuilder
        //   795: dup
        //   796: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   799: ldc_w 282
        //   802: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   805: iload_3
        //   806: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   809: ldc_w 284
        //   812: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   815: aload 10
        //   817: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   820: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   823: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   826: pop
        //   827: sipush 8195
        //   830: istore_1
        //   831: aload 9
        //   833: astore 8
        //   835: goto +394 -> 1229
        //   838: ldc 89
        //   840: new 91	java/lang/StringBuilder
        //   843: dup
        //   844: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   847: ldc_w 286
        //   850: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   853: iload_3
        //   854: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   857: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   860: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   863: pop
        //   864: sipush 8195
        //   867: istore_1
        //   868: aconst_null
        //   869: astore 9
        //   871: goto +366 -> 1237
        //   874: astore 8
        //   876: aconst_null
        //   877: astore 6
        //   879: aconst_null
        //   880: astore 7
        //   882: aconst_null
        //   883: astore 4
        //   885: aconst_null
        //   886: astore 5
        //   888: ldc 89
        //   890: new 91	java/lang/StringBuilder
        //   893: dup
        //   894: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   897: ldc_w 288
        //   900: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   903: aload_0
        //   904: getfield 25	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
        //   907: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   910: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   913: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   916: pop
        //   917: aload 8
        //   919: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   922: sipush 8193
        //   925: istore_1
        //   926: aload 11
        //   928: astore 8
        //   930: goto -877 -> 53
        //   933: astore 8
        //   935: ldc 48
        //   937: astore 9
        //   939: aconst_null
        //   940: astore 5
        //   942: aconst_null
        //   943: astore 7
        //   945: aconst_null
        //   946: astore 4
        //   948: aconst_null
        //   949: astore 6
        //   951: ldc 89
        //   953: new 91	java/lang/StringBuilder
        //   956: dup
        //   957: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   960: ldc_w 291
        //   963: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   966: aload 9
        //   968: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   971: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   974: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   977: pop
        //   978: aload 8
        //   980: invokevirtual 292	org/json/JSONException:printStackTrace	()V
        //   983: aload 6
        //   985: astore 9
        //   987: aload 11
        //   989: astore 8
        //   991: iload_2
        //   992: istore_1
        //   993: aload 5
        //   995: astore 6
        //   997: aload 9
        //   999: astore 5
        //   1001: goto -948 -> 53
        //   1004: astore 5
        //   1006: aload 5
        //   1008: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1011: goto -948 -> 63
        //   1014: astore 5
        //   1016: aload 5
        //   1018: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1021: goto -948 -> 73
        //   1024: astore 5
        //   1026: aload 5
        //   1028: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1031: goto -948 -> 83
        //   1034: astore 8
        //   1036: ldc 48
        //   1038: astore 9
        //   1040: aconst_null
        //   1041: astore 10
        //   1043: aconst_null
        //   1044: astore 7
        //   1046: aload 5
        //   1048: astore 6
        //   1050: aconst_null
        //   1051: astore 4
        //   1053: aload 10
        //   1055: astore 5
        //   1057: goto -106 -> 951
        //   1060: astore 8
        //   1062: aconst_null
        //   1063: astore 10
        //   1065: aconst_null
        //   1066: astore 7
        //   1068: ldc 48
        //   1070: astore 9
        //   1072: aload 5
        //   1074: astore 6
        //   1076: aload 10
        //   1078: astore 5
        //   1080: goto -129 -> 951
        //   1083: astore 8
        //   1085: aconst_null
        //   1086: astore 10
        //   1088: aload 5
        //   1090: astore 6
        //   1092: ldc 48
        //   1094: astore 9
        //   1096: aload 10
        //   1098: astore 5
        //   1100: goto -149 -> 951
        //   1103: astore 12
        //   1105: aload 8
        //   1107: astore 9
        //   1109: aload 5
        //   1111: astore 10
        //   1113: aload 12
        //   1115: astore 8
        //   1117: aload 6
        //   1119: astore 5
        //   1121: aload 10
        //   1123: astore 6
        //   1125: goto -174 -> 951
        //   1128: astore 8
        //   1130: aconst_null
        //   1131: astore 6
        //   1133: aconst_null
        //   1134: astore 7
        //   1136: aconst_null
        //   1137: astore 4
        //   1139: goto -251 -> 888
        //   1142: astore 8
        //   1144: aconst_null
        //   1145: astore 6
        //   1147: aconst_null
        //   1148: astore 7
        //   1150: goto -262 -> 888
        //   1153: astore 8
        //   1155: aconst_null
        //   1156: astore 6
        //   1158: goto -270 -> 888
        //   1161: astore 8
        //   1163: goto -275 -> 888
        //   1166: astore 8
        //   1168: aconst_null
        //   1169: astore 6
        //   1171: aconst_null
        //   1172: astore 4
        //   1174: aconst_null
        //   1175: astore 7
        //   1177: aconst_null
        //   1178: astore 5
        //   1180: goto -645 -> 535
        //   1183: astore 8
        //   1185: aconst_null
        //   1186: astore 6
        //   1188: aconst_null
        //   1189: astore 4
        //   1191: aconst_null
        //   1192: astore 7
        //   1194: goto -659 -> 535
        //   1197: astore 8
        //   1199: aconst_null
        //   1200: astore 6
        //   1202: aload 4
        //   1204: astore 7
        //   1206: aconst_null
        //   1207: astore 4
        //   1209: goto -674 -> 535
        //   1212: astore 8
        //   1214: aload 7
        //   1216: astore 9
        //   1218: aload 4
        //   1220: astore 7
        //   1222: aload 9
        //   1224: astore 4
        //   1226: goto -691 -> 535
        //   1229: aload 6
        //   1231: astore 9
        //   1233: aload 8
        //   1235: astore 6
        //   1237: aload 6
        //   1239: astore 8
        //   1241: aload 9
        //   1243: astore 6
        //   1245: goto -1192 -> 53
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1248	0	this	1
        //   1	992	1	i	int
        //   5	987	2	j	int
        //   142	712	3	k	int
        //   26	1199	4	localObject1	Object
        //   47	953	5	localObject2	Object
        //   1004	3	5	localIOException1	java.io.IOException
        //   1014	3	5	localIOException2	java.io.IOException
        //   1024	23	5	localIOException3	java.io.IOException
        //   1055	124	5	localObject3	Object
        //   10	1234	6	localObject4	Object
        //   41	1180	7	localObject5	Object
        //   17	817	8	localObject6	Object
        //   874	44	8	localIOException4	java.io.IOException
        //   928	1	8	localObject7	Object
        //   933	46	8	localJSONException1	org.json.JSONException
        //   989	1	8	localObject8	Object
        //   1034	1	8	localJSONException2	org.json.JSONException
        //   1060	1	8	localJSONException3	org.json.JSONException
        //   1083	23	8	localJSONException4	org.json.JSONException
        //   1115	1	8	localObject9	Object
        //   1128	1	8	localIOException5	java.io.IOException
        //   1142	1	8	localIOException6	java.io.IOException
        //   1153	1	8	localIOException7	java.io.IOException
        //   1161	1	8	localIOException8	java.io.IOException
        //   1166	1	8	localUnknownHostException1	java.net.UnknownHostException
        //   1183	1	8	localUnknownHostException2	java.net.UnknownHostException
        //   1197	1	8	localUnknownHostException3	java.net.UnknownHostException
        //   1212	22	8	localUnknownHostException4	java.net.UnknownHostException
        //   1239	1	8	localObject10	Object
        //   7	1	9	localObject11	Object
        //   514	18	9	localUnknownHostException5	java.net.UnknownHostException
        //   771	471	9	localObject12	Object
        //   124	998	10	localObject13	Object
        //   13	975	11	localObject14	Object
        //   341	39	12	localHashMap	java.util.HashMap
        //   1103	11	12	localJSONException5	org.json.JSONException
        // Exception table:
        //   from	to	target	type
        //   333	489	514	java/net/UnknownHostException
        //   489	497	514	java/net/UnknownHostException
        //   502	511	514	java/net/UnknownHostException
        //   569	638	514	java/net/UnknownHostException
        //   645	666	514	java/net/UnknownHostException
        //   838	864	514	java/net/UnknownHostException
        //   126	137	874	java/io/IOException
        //   126	137	933	org/json/JSONException
        //   58	63	1004	java/io/IOException
        //   68	73	1014	java/io/IOException
        //   78	83	1024	java/io/IOException
        //   137	143	1034	org/json/JSONException
        //   147	155	1034	org/json/JSONException
        //   155	192	1034	org/json/JSONException
        //   212	231	1034	org/json/JSONException
        //   231	333	1060	org/json/JSONException
        //   333	489	1083	org/json/JSONException
        //   489	497	1083	org/json/JSONException
        //   502	511	1083	org/json/JSONException
        //   569	638	1083	org/json/JSONException
        //   645	666	1083	org/json/JSONException
        //   838	864	1083	org/json/JSONException
        //   666	673	1103	org/json/JSONException
        //   678	700	1103	org/json/JSONException
        //   707	753	1103	org/json/JSONException
        //   757	773	1103	org/json/JSONException
        //   780	827	1103	org/json/JSONException
        //   137	143	1128	java/io/IOException
        //   147	155	1128	java/io/IOException
        //   155	192	1128	java/io/IOException
        //   212	231	1128	java/io/IOException
        //   231	333	1142	java/io/IOException
        //   333	489	1153	java/io/IOException
        //   489	497	1153	java/io/IOException
        //   502	511	1153	java/io/IOException
        //   569	638	1153	java/io/IOException
        //   645	666	1153	java/io/IOException
        //   838	864	1153	java/io/IOException
        //   666	673	1161	java/io/IOException
        //   678	700	1161	java/io/IOException
        //   707	753	1161	java/io/IOException
        //   757	773	1161	java/io/IOException
        //   780	827	1161	java/io/IOException
        //   126	137	1166	java/net/UnknownHostException
        //   137	143	1183	java/net/UnknownHostException
        //   147	155	1183	java/net/UnknownHostException
        //   155	192	1183	java/net/UnknownHostException
        //   212	231	1183	java/net/UnknownHostException
        //   231	333	1197	java/net/UnknownHostException
        //   666	673	1212	java/net/UnknownHostException
        //   678	700	1212	java/net/UnknownHostException
        //   707	753	1212	java/net/UnknownHostException
        //   757	773	1212	java/net/UnknownHostException
        //   780	827	1212	java/net/UnknownHostException
      }
    }).start();
  }
  
  public static abstract interface DownloadCosFileListener
  {
    public abstract void onCompleted(int paramInt, Object paramObject);
  }
  
  public static abstract interface UploadCosFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer
 * JD-Core Version:    0.7.0.1
 */