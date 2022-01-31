package com.tencent.TMG.ptt;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileTransfer
{
  public static final String TAG = "FileTransfer";
  private static FileTransfer s_instance = null;
  
  public static FileTransfer getInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new FileTransfer();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
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
  
  private File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("FileTransfer", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("FileTransfer", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  public void applyMessageKey(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.i("FileTransfer", String.format("applyMessageKey| appid=%s, bucket=%s, region=%s, sign=%s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
  }
  
  public void downloadFile(final String paramString1, final String paramString2, final String paramString3, final PttListener.DownloadFileListener paramDownloadFileListener)
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
        //   22: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   25: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   28: ifeq +75 -> 103
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
        //   78: getfield 31	com/tencent/TMG/ptt/FileTransfer$2:val$monitor	Lcom/tencent/TMG/ptt/PttListener$DownloadFileListener;
        //   81: ifnull +21 -> 102
        //   84: aload_0
        //   85: getfield 31	com/tencent/TMG/ptt/FileTransfer$2:val$monitor	Lcom/tencent/TMG/ptt/PttListener$DownloadFileListener;
        //   88: iload_1
        //   89: aload_0
        //   90: getfield 27	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
        //   93: aload_0
        //   94: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   97: invokeinterface 77 4 0
        //   102: return
        //   103: aload_0
        //   104: getfield 27	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
        //   107: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   110: ifeq +24 -> 134
        //   113: ldc 50
        //   115: ldc 79
        //   117: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   120: pop
        //   121: sipush 12289
        //   124: istore_1
        //   125: aconst_null
        //   126: astore 4
        //   128: aconst_null
        //   129: astore 5
        //   131: goto -84 -> 47
        //   134: new 81	java/net/URL
        //   137: dup
        //   138: aload_0
        //   139: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   142: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
        //   145: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   148: checkcast 68	java/net/HttpURLConnection
        //   151: astore 4
        //   153: aload 4
        //   155: ldc 90
        //   157: invokevirtual 93	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   160: aload 4
        //   162: ldc 95
        //   164: aload_0
        //   165: getfield 29	com/tencent/TMG/ptt/FileTransfer$2:val$sign	Ljava/lang/String;
        //   168: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   171: aload 4
        //   173: ldc 101
        //   175: ldc 103
        //   177: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   180: aload 4
        //   182: ldc 105
        //   184: ldc 107
        //   186: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   189: aload 4
        //   191: invokevirtual 111	java/net/HttpURLConnection:getResponseCode	()I
        //   194: istore_3
        //   195: iload_3
        //   196: sipush 200
        //   199: if_icmpne +251 -> 450
        //   202: new 113	java/io/File
        //   205: dup
        //   206: aload_0
        //   207: getfield 27	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
        //   210: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
        //   213: astore 5
        //   215: aload 5
        //   217: invokevirtual 118	java/io/File:exists	()Z
        //   220: ifne +9 -> 229
        //   223: aload 5
        //   225: invokevirtual 121	java/io/File:createNewFile	()Z
        //   228: pop
        //   229: new 60	java/io/FileOutputStream
        //   232: dup
        //   233: aload 5
        //   235: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   238: astore 5
        //   240: aload 4
        //   242: invokevirtual 128	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   245: astore 6
        //   247: aload 6
        //   249: astore 7
        //   251: aload 6
        //   253: astore 8
        //   255: aload 6
        //   257: astore 9
        //   259: aload 4
        //   261: invokevirtual 128	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   264: astore 6
        //   266: aload 6
        //   268: astore 7
        //   270: aload 6
        //   272: astore 8
        //   274: aload 6
        //   276: astore 9
        //   278: sipush 1024
        //   281: newarray byte
        //   283: astore 10
        //   285: aload 6
        //   287: astore 7
        //   289: aload 6
        //   291: astore 8
        //   293: aload 6
        //   295: astore 9
        //   297: aload 6
        //   299: aload 10
        //   301: invokevirtual 132	java/io/InputStream:read	([B)I
        //   304: istore_3
        //   305: iload_3
        //   306: iconst_m1
        //   307: if_icmpeq +112 -> 419
        //   310: aload 6
        //   312: astore 7
        //   314: aload 6
        //   316: astore 8
        //   318: aload 6
        //   320: astore 9
        //   322: aload 5
        //   324: aload 10
        //   326: iconst_0
        //   327: iload_3
        //   328: invokevirtual 136	java/io/FileOutputStream:write	([BII)V
        //   331: goto -46 -> 285
        //   334: astore 8
        //   336: aload 4
        //   338: astore 6
        //   340: aload 7
        //   342: astore 4
        //   344: aload 8
        //   346: astore 7
        //   348: ldc 50
        //   350: new 138	java/lang/StringBuilder
        //   353: dup
        //   354: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   357: ldc 141
        //   359: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   362: aload_0
        //   363: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   366: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   372: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   375: pop
        //   376: aload 7
        //   378: invokevirtual 152	java/net/MalformedURLException:printStackTrace	()V
        //   381: iload_2
        //   382: istore_1
        //   383: goto -336 -> 47
        //   386: astore 6
        //   388: ldc 50
        //   390: ldc 154
        //   392: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   395: pop
        //   396: aload 6
        //   398: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   401: sipush 12291
        //   404: istore_1
        //   405: aconst_null
        //   406: astore 7
        //   408: aload 4
        //   410: astore 6
        //   412: aload 7
        //   414: astore 4
        //   416: goto -369 -> 47
        //   419: aload 6
        //   421: astore 7
        //   423: aload 5
        //   425: astore 6
        //   427: aload 7
        //   429: astore 5
        //   431: aload 6
        //   433: astore 7
        //   435: aload 4
        //   437: astore 6
        //   439: aload 5
        //   441: astore 4
        //   443: aload 7
        //   445: astore 5
        //   447: goto -400 -> 47
        //   450: iload_3
        //   451: sipush 404
        //   454: if_icmpne +45 -> 499
        //   457: ldc 50
        //   459: new 138	java/lang/StringBuilder
        //   462: dup
        //   463: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   466: ldc 141
        //   468: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   471: aload_0
        //   472: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   475: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   478: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   481: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   484: pop
        //   485: sipush 12292
        //   488: istore_1
        //   489: aconst_null
        //   490: astore 5
        //   492: aload 9
        //   494: astore 6
        //   496: goto -65 -> 431
        //   499: ldc 50
        //   501: new 138	java/lang/StringBuilder
        //   504: dup
        //   505: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   508: ldc 157
        //   510: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   513: aload_0
        //   514: getfield 25	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
        //   517: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   520: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   523: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   526: pop
        //   527: sipush 12291
        //   530: istore_1
        //   531: aconst_null
        //   532: astore 5
        //   534: aload 9
        //   536: astore 6
        //   538: goto -107 -> 431
        //   541: astore 8
        //   543: aconst_null
        //   544: astore 4
        //   546: aconst_null
        //   547: astore 5
        //   549: aload 7
        //   551: astore 6
        //   553: aload 8
        //   555: astore 7
        //   557: ldc 50
        //   559: ldc 159
        //   561: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   564: pop
        //   565: aload 7
        //   567: invokevirtual 160	java/net/UnknownHostException:printStackTrace	()V
        //   570: sipush 12291
        //   573: istore_1
        //   574: goto -527 -> 47
        //   577: astore 7
        //   579: aconst_null
        //   580: astore 4
        //   582: aconst_null
        //   583: astore 5
        //   585: aload 8
        //   587: astore 6
        //   589: ldc 50
        //   591: new 138	java/lang/StringBuilder
        //   594: dup
        //   595: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   598: ldc 162
        //   600: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   603: aload_0
        //   604: getfield 27	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
        //   607: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   610: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   613: invokestatic 58	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   616: pop
        //   617: aload 7
        //   619: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   622: sipush 12289
        //   625: istore_1
        //   626: goto -579 -> 47
        //   629: astore 5
        //   631: aload 5
        //   633: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   636: goto -579 -> 57
        //   639: astore 4
        //   641: aload 4
        //   643: invokevirtual 155	java/io/IOException:printStackTrace	()V
        //   646: goto -579 -> 67
        //   649: astore 7
        //   651: aconst_null
        //   652: astore 5
        //   654: aconst_null
        //   655: astore 8
        //   657: aload 4
        //   659: astore 6
        //   661: aload 8
        //   663: astore 4
        //   665: goto -76 -> 589
        //   668: astore 7
        //   670: aconst_null
        //   671: astore 8
        //   673: aload 4
        //   675: astore 6
        //   677: aload 8
        //   679: astore 4
        //   681: goto -92 -> 589
        //   684: astore 7
        //   686: aload 4
        //   688: astore 6
        //   690: aload 8
        //   692: astore 4
        //   694: goto -105 -> 589
        //   697: astore 7
        //   699: aconst_null
        //   700: astore 5
        //   702: aconst_null
        //   703: astore 8
        //   705: aload 4
        //   707: astore 6
        //   709: aload 8
        //   711: astore 4
        //   713: goto -156 -> 557
        //   716: astore 7
        //   718: aconst_null
        //   719: astore 8
        //   721: aload 4
        //   723: astore 6
        //   725: aload 8
        //   727: astore 4
        //   729: goto -172 -> 557
        //   732: astore 7
        //   734: aload 4
        //   736: astore 6
        //   738: aload 9
        //   740: astore 4
        //   742: goto -185 -> 557
        //   745: astore 7
        //   747: aconst_null
        //   748: astore 4
        //   750: aconst_null
        //   751: astore 8
        //   753: aload 5
        //   755: astore 6
        //   757: aload 8
        //   759: astore 5
        //   761: goto -413 -> 348
        //   764: astore 7
        //   766: aconst_null
        //   767: astore 5
        //   769: aconst_null
        //   770: astore 8
        //   772: aload 4
        //   774: astore 6
        //   776: aload 8
        //   778: astore 4
        //   780: goto -432 -> 348
        //   783: astore 7
        //   785: aconst_null
        //   786: astore 8
        //   788: aload 4
        //   790: astore 6
        //   792: aload 8
        //   794: astore 4
        //   796: goto -448 -> 348
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	799	0	this	2
        //   1	625	1	i	int
        //   20	362	2	j	int
        //   194	261	3	k	int
        //   40	541	4	localObject1	Object
        //   639	19	4	localIOException1	java.io.IOException
        //   663	132	4	localObject2	Object
        //   3	581	5	localObject3	Object
        //   629	3	5	localIOException2	java.io.IOException
        //   652	116	5	localObject4	Object
        //   15	324	6	localObject5	Object
        //   386	11	6	localIOException3	java.io.IOException
        //   410	381	6	localObject6	Object
        //   9	557	7	localObject7	Object
        //   577	41	7	localIOException4	java.io.IOException
        //   649	1	7	localIOException5	java.io.IOException
        //   668	1	7	localIOException6	java.io.IOException
        //   684	1	7	localIOException7	java.io.IOException
        //   697	1	7	localUnknownHostException1	java.net.UnknownHostException
        //   716	1	7	localUnknownHostException2	java.net.UnknownHostException
        //   732	1	7	localUnknownHostException3	java.net.UnknownHostException
        //   745	1	7	localMalformedURLException1	java.net.MalformedURLException
        //   764	1	7	localMalformedURLException2	java.net.MalformedURLException
        //   783	1	7	localMalformedURLException3	java.net.MalformedURLException
        //   12	305	8	localObject8	Object
        //   334	11	8	localMalformedURLException4	java.net.MalformedURLException
        //   541	45	8	localUnknownHostException4	java.net.UnknownHostException
        //   655	138	8	localObject9	Object
        //   6	733	9	localObject10	Object
        //   283	42	10	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   259	266	334	java/net/MalformedURLException
        //   278	285	334	java/net/MalformedURLException
        //   297	305	334	java/net/MalformedURLException
        //   322	331	334	java/net/MalformedURLException
        //   240	247	386	java/io/IOException
        //   134	153	541	java/net/UnknownHostException
        //   134	153	577	java/io/IOException
        //   52	57	629	java/io/IOException
        //   62	67	639	java/io/IOException
        //   153	195	649	java/io/IOException
        //   202	229	649	java/io/IOException
        //   229	240	649	java/io/IOException
        //   457	485	649	java/io/IOException
        //   499	527	649	java/io/IOException
        //   388	401	668	java/io/IOException
        //   259	266	684	java/io/IOException
        //   278	285	684	java/io/IOException
        //   297	305	684	java/io/IOException
        //   322	331	684	java/io/IOException
        //   153	195	697	java/net/UnknownHostException
        //   202	229	697	java/net/UnknownHostException
        //   229	240	697	java/net/UnknownHostException
        //   457	485	697	java/net/UnknownHostException
        //   499	527	697	java/net/UnknownHostException
        //   240	247	716	java/net/UnknownHostException
        //   388	401	716	java/net/UnknownHostException
        //   259	266	732	java/net/UnknownHostException
        //   278	285	732	java/net/UnknownHostException
        //   297	305	732	java/net/UnknownHostException
        //   322	331	732	java/net/UnknownHostException
        //   134	153	745	java/net/MalformedURLException
        //   153	195	764	java/net/MalformedURLException
        //   202	229	764	java/net/MalformedURLException
        //   229	240	764	java/net/MalformedURLException
        //   457	485	764	java/net/MalformedURLException
        //   499	527	764	java/net/MalformedURLException
        //   240	247	783	java/net/MalformedURLException
        //   388	401	783	java/net/MalformedURLException
      }
    }).start();
  }
  
  public void uploadFile(final String paramString1, final String paramString2, final String paramString3, final int paramInt, final PttListener.UploadFileListener paramUploadFileListener)
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
        //   20: getfield 25	com/tencent/TMG/ptt/FileTransfer$1:this$0	Lcom/tencent/TMG/ptt/FileTransfer;
        //   23: aload_0
        //   24: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   27: invokestatic 52	com/tencent/TMG/ptt/FileTransfer:access$000	(Lcom/tencent/TMG/ptt/FileTransfer;Ljava/lang/String;)Ljava/io/File;
        //   30: astore 4
        //   32: aload 4
        //   34: ifnonnull +87 -> 121
        //   37: sipush 8193
        //   40: istore_1
        //   41: aconst_null
        //   42: astore 6
        //   44: aconst_null
        //   45: astore 7
        //   47: aconst_null
        //   48: astore 4
        //   50: aconst_null
        //   51: astore 5
        //   53: aload 11
        //   55: astore 8
        //   57: aload 5
        //   59: ifnull +8 -> 67
        //   62: aload 5
        //   64: invokevirtual 57	java/io/FileInputStream:close	()V
        //   67: aload 7
        //   69: ifnull +8 -> 77
        //   72: aload 7
        //   74: invokevirtual 60	java/io/OutputStream:close	()V
        //   77: aload 6
        //   79: ifnull +8 -> 87
        //   82: aload 6
        //   84: invokevirtual 63	java/io/BufferedReader:close	()V
        //   87: aload 4
        //   89: ifnull +8 -> 97
        //   92: aload 4
        //   94: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
        //   97: aload_0
        //   98: getfield 35	com/tencent/TMG/ptt/FileTransfer$1:val$monitor	Lcom/tencent/TMG/ptt/PttListener$UploadFileListener;
        //   101: ifnull +19 -> 120
        //   104: aload_0
        //   105: getfield 35	com/tencent/TMG/ptt/FileTransfer$1:val$monitor	Lcom/tencent/TMG/ptt/PttListener$UploadFileListener;
        //   108: iload_1
        //   109: aload_0
        //   110: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   113: aload 8
        //   115: invokeinterface 74 4 0
        //   120: return
        //   121: aload_0
        //   122: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   125: invokestatic 80	com/tencent/TMG/ptt/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
        //   128: astore 10
        //   130: new 54	java/io/FileInputStream
        //   133: dup
        //   134: aload 4
        //   136: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   139: astore 5
        //   141: aload 5
        //   143: invokevirtual 87	java/io/FileInputStream:available	()I
        //   146: istore_3
        //   147: iload_3
        //   148: ifle +11 -> 159
        //   151: iload_3
        //   152: aload_0
        //   153: getfield 29	com/tencent/TMG/ptt/FileTransfer$1:val$maxSize	I
        //   156: if_icmple +60 -> 216
        //   159: ldc 89
        //   161: new 91	java/lang/StringBuilder
        //   164: dup
        //   165: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   168: ldc 94
        //   170: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: aload_0
        //   174: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   177: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: ldc 100
        //   182: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: iload_3
        //   186: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   189: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   192: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   195: pop
        //   196: sipush 8193
        //   199: istore_1
        //   200: aconst_null
        //   201: astore 6
        //   203: aconst_null
        //   204: astore 7
        //   206: aconst_null
        //   207: astore 4
        //   209: aload 11
        //   211: astore 8
        //   213: goto -156 -> 57
        //   216: new 115	java/net/URL
        //   219: dup
        //   220: aload_0
        //   221: getfield 31	com/tencent/TMG/ptt/FileTransfer$1:val$strUrl	Ljava/lang/String;
        //   224: invokespecial 118	java/net/URL:<init>	(Ljava/lang/String;)V
        //   227: invokevirtual 122	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   230: checkcast 65	java/net/HttpURLConnection
        //   233: astore 4
        //   235: aload 4
        //   237: sipush 5000
        //   240: invokevirtual 126	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   243: aload 4
        //   245: sipush 30000
        //   248: invokevirtual 129	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   251: aload 4
        //   253: iconst_1
        //   254: invokevirtual 133	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   257: aload 4
        //   259: iconst_1
        //   260: invokevirtual 136	java/net/HttpURLConnection:setDoInput	(Z)V
        //   263: aload 4
        //   265: iconst_0
        //   266: invokevirtual 139	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   269: aload 4
        //   271: ldc 141
        //   273: invokevirtual 144	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   276: aload 4
        //   278: ldc 146
        //   280: ldc 148
        //   282: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   285: aload 4
        //   287: ldc 154
        //   289: aload_0
        //   290: getfield 33	com/tencent/TMG/ptt/FileTransfer$1:val$sign	Ljava/lang/String;
        //   293: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   296: aload 4
        //   298: ldc 156
        //   300: new 91	java/lang/StringBuilder
        //   303: dup
        //   304: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   307: ldc 158
        //   309: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   312: ldc 160
        //   314: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   320: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   323: new 162	java/io/DataOutputStream
        //   326: dup
        //   327: aload 4
        //   329: invokevirtual 166	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   332: invokespecial 169	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   335: astore 7
        //   337: new 171	java/util/HashMap
        //   340: dup
        //   341: iconst_3
        //   342: invokespecial 173	java/util/HashMap:<init>	(I)V
        //   345: astore 12
        //   347: aload 12
        //   349: ldc 175
        //   351: ldc 177
        //   353: invokeinterface 183 3 0
        //   358: pop
        //   359: aload 12
        //   361: ldc 185
        //   363: aload 10
        //   365: invokeinterface 183 3 0
        //   370: pop
        //   371: aload 12
        //   373: ldc 187
        //   375: ldc 48
        //   377: invokeinterface 183 3 0
        //   382: pop
        //   383: aload_0
        //   384: getfield 25	com/tencent/TMG/ptt/FileTransfer$1:this$0	Lcom/tencent/TMG/ptt/FileTransfer;
        //   387: aload 12
        //   389: ldc 160
        //   391: invokestatic 191	com/tencent/TMG/ptt/FileTransfer:access$100	(Lcom/tencent/TMG/ptt/FileTransfer;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
        //   394: astore 10
        //   396: new 91	java/lang/StringBuilder
        //   399: dup
        //   400: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   403: aload 10
        //   405: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   408: ldc 193
        //   410: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   413: ldc 160
        //   415: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   418: ldc 195
        //   420: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   423: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   426: astore 10
        //   428: new 91	java/lang/StringBuilder
        //   431: dup
        //   432: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   435: aload 10
        //   437: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   440: ldc 197
        //   442: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   445: aload_0
        //   446: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   449: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   452: ldc 199
        //   454: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   457: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   460: astore 10
        //   462: aload 7
        //   464: new 91	java/lang/StringBuilder
        //   467: dup
        //   468: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   471: aload 10
        //   473: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   476: ldc 201
        //   478: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   481: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   484: invokevirtual 207	java/lang/String:getBytes	()[B
        //   487: invokevirtual 211	java/io/OutputStream:write	([B)V
        //   490: sipush 1024
        //   493: newarray byte
        //   495: astore 10
        //   497: aload 5
        //   499: aload 10
        //   501: invokevirtual 215	java/io/FileInputStream:read	([B)I
        //   504: istore_3
        //   505: iload_3
        //   506: iconst_m1
        //   507: if_icmpeq +70 -> 577
        //   510: aload 7
        //   512: aload 10
        //   514: iconst_0
        //   515: iload_3
        //   516: invokevirtual 218	java/io/OutputStream:write	([BII)V
        //   519: goto -22 -> 497
        //   522: astore 9
        //   524: aconst_null
        //   525: astore 6
        //   527: aload 7
        //   529: astore 8
        //   531: aload 4
        //   533: astore 7
        //   535: aload 8
        //   537: astore 4
        //   539: aload 9
        //   541: astore 8
        //   543: ldc 89
        //   545: ldc 220
        //   547: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   550: pop
        //   551: aload 8
        //   553: invokevirtual 223	java/net/UnknownHostException:printStackTrace	()V
        //   556: aload 7
        //   558: astore 8
        //   560: aload 4
        //   562: astore 7
        //   564: aload 8
        //   566: astore 4
        //   568: aload 11
        //   570: astore 8
        //   572: iload_2
        //   573: istore_1
        //   574: goto -517 -> 57
        //   577: aload 7
        //   579: new 91	java/lang/StringBuilder
        //   582: dup
        //   583: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   586: ldc 225
        //   588: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   591: ldc 160
        //   593: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   596: ldc 227
        //   598: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   601: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   604: invokevirtual 207	java/lang/String:getBytes	()[B
        //   607: invokevirtual 211	java/io/OutputStream:write	([B)V
        //   610: aload 7
        //   612: invokevirtual 230	java/io/OutputStream:flush	()V
        //   615: aload 4
        //   617: invokevirtual 233	java/net/HttpURLConnection:getResponseCode	()I
        //   620: istore_3
        //   621: ldc 89
        //   623: new 91	java/lang/StringBuilder
        //   626: dup
        //   627: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   630: ldc 235
        //   632: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   635: iload_3
        //   636: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   639: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   642: invokestatic 238	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   645: pop
        //   646: iload_3
        //   647: sipush 200
        //   650: if_icmpne +196 -> 846
        //   653: new 62	java/io/BufferedReader
        //   656: dup
        //   657: new 240	java/io/InputStreamReader
        //   660: dup
        //   661: aload 4
        //   663: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   666: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   669: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   672: astore 6
        //   674: aload 6
        //   676: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   679: astore 10
        //   681: aload 10
        //   683: ifnull +32 -> 715
        //   686: new 91	java/lang/StringBuilder
        //   689: dup
        //   690: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   693: aload 8
        //   695: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   698: aload 10
        //   700: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   703: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   706: astore 10
        //   708: aload 10
        //   710: astore 8
        //   712: goto -38 -> 674
        //   715: ldc 89
        //   717: new 91	java/lang/StringBuilder
        //   720: dup
        //   721: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   724: ldc 255
        //   726: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   729: aload 8
        //   731: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   734: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   737: invokestatic 258	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   740: pop
        //   741: new 260	org/json/JSONObject
        //   744: dup
        //   745: aload 8
        //   747: invokespecial 261	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   750: astore 10
        //   752: aload 10
        //   754: ldc_w 263
        //   757: invokevirtual 267	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   760: istore_3
        //   761: iload_3
        //   762: ifne +26 -> 788
        //   765: aload 10
        //   767: ldc_w 269
        //   770: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   773: ldc_w 275
        //   776: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   779: astore 9
        //   781: aload 9
        //   783: astore 8
        //   785: goto +452 -> 1237
        //   788: aload 10
        //   790: ldc_w 280
        //   793: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   796: astore 10
        //   798: ldc 89
        //   800: new 91	java/lang/StringBuilder
        //   803: dup
        //   804: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   807: ldc_w 282
        //   810: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   813: iload_3
        //   814: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   817: ldc_w 284
        //   820: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   823: aload 10
        //   825: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   828: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   831: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   834: pop
        //   835: sipush 8195
        //   838: istore_1
        //   839: aload 9
        //   841: astore 8
        //   843: goto +394 -> 1237
        //   846: ldc 89
        //   848: new 91	java/lang/StringBuilder
        //   851: dup
        //   852: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   855: ldc_w 286
        //   858: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   861: iload_3
        //   862: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   865: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   868: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   871: pop
        //   872: sipush 8195
        //   875: istore_1
        //   876: aconst_null
        //   877: astore 9
        //   879: goto +366 -> 1245
        //   882: astore 8
        //   884: aconst_null
        //   885: astore 6
        //   887: aconst_null
        //   888: astore 7
        //   890: aconst_null
        //   891: astore 4
        //   893: aconst_null
        //   894: astore 5
        //   896: ldc 89
        //   898: new 91	java/lang/StringBuilder
        //   901: dup
        //   902: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   905: ldc_w 288
        //   908: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   911: aload_0
        //   912: getfield 27	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
        //   915: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   918: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   921: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   924: pop
        //   925: aload 8
        //   927: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   930: sipush 8193
        //   933: istore_1
        //   934: aload 11
        //   936: astore 8
        //   938: goto -881 -> 57
        //   941: astore 8
        //   943: ldc 48
        //   945: astore 9
        //   947: aconst_null
        //   948: astore 5
        //   950: aconst_null
        //   951: astore 7
        //   953: aconst_null
        //   954: astore 4
        //   956: aconst_null
        //   957: astore 6
        //   959: ldc 89
        //   961: new 91	java/lang/StringBuilder
        //   964: dup
        //   965: invokespecial 92	java/lang/StringBuilder:<init>	()V
        //   968: ldc_w 291
        //   971: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   974: aload 9
        //   976: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   979: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   982: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   985: pop
        //   986: aload 8
        //   988: invokevirtual 292	org/json/JSONException:printStackTrace	()V
        //   991: aload 6
        //   993: astore 9
        //   995: aload 11
        //   997: astore 8
        //   999: iload_2
        //   1000: istore_1
        //   1001: aload 5
        //   1003: astore 6
        //   1005: aload 9
        //   1007: astore 5
        //   1009: goto -952 -> 57
        //   1012: astore 5
        //   1014: aload 5
        //   1016: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1019: goto -952 -> 67
        //   1022: astore 5
        //   1024: aload 5
        //   1026: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1029: goto -952 -> 77
        //   1032: astore 5
        //   1034: aload 5
        //   1036: invokevirtual 289	java/io/IOException:printStackTrace	()V
        //   1039: goto -952 -> 87
        //   1042: astore 8
        //   1044: ldc 48
        //   1046: astore 9
        //   1048: aconst_null
        //   1049: astore 10
        //   1051: aconst_null
        //   1052: astore 7
        //   1054: aload 5
        //   1056: astore 6
        //   1058: aconst_null
        //   1059: astore 4
        //   1061: aload 10
        //   1063: astore 5
        //   1065: goto -106 -> 959
        //   1068: astore 8
        //   1070: aconst_null
        //   1071: astore 10
        //   1073: aconst_null
        //   1074: astore 7
        //   1076: ldc 48
        //   1078: astore 9
        //   1080: aload 5
        //   1082: astore 6
        //   1084: aload 10
        //   1086: astore 5
        //   1088: goto -129 -> 959
        //   1091: astore 8
        //   1093: aconst_null
        //   1094: astore 10
        //   1096: aload 5
        //   1098: astore 6
        //   1100: ldc 48
        //   1102: astore 9
        //   1104: aload 10
        //   1106: astore 5
        //   1108: goto -149 -> 959
        //   1111: astore 12
        //   1113: aload 8
        //   1115: astore 9
        //   1117: aload 5
        //   1119: astore 10
        //   1121: aload 12
        //   1123: astore 8
        //   1125: aload 6
        //   1127: astore 5
        //   1129: aload 10
        //   1131: astore 6
        //   1133: goto -174 -> 959
        //   1136: astore 8
        //   1138: aconst_null
        //   1139: astore 6
        //   1141: aconst_null
        //   1142: astore 7
        //   1144: aconst_null
        //   1145: astore 4
        //   1147: goto -251 -> 896
        //   1150: astore 8
        //   1152: aconst_null
        //   1153: astore 6
        //   1155: aconst_null
        //   1156: astore 7
        //   1158: goto -262 -> 896
        //   1161: astore 8
        //   1163: aconst_null
        //   1164: astore 6
        //   1166: goto -270 -> 896
        //   1169: astore 8
        //   1171: goto -275 -> 896
        //   1174: astore 8
        //   1176: aconst_null
        //   1177: astore 6
        //   1179: aconst_null
        //   1180: astore 4
        //   1182: aconst_null
        //   1183: astore 7
        //   1185: aconst_null
        //   1186: astore 5
        //   1188: goto -645 -> 543
        //   1191: astore 8
        //   1193: aconst_null
        //   1194: astore 6
        //   1196: aconst_null
        //   1197: astore 4
        //   1199: aconst_null
        //   1200: astore 7
        //   1202: goto -659 -> 543
        //   1205: astore 8
        //   1207: aconst_null
        //   1208: astore 6
        //   1210: aload 4
        //   1212: astore 7
        //   1214: aconst_null
        //   1215: astore 4
        //   1217: goto -674 -> 543
        //   1220: astore 8
        //   1222: aload 7
        //   1224: astore 9
        //   1226: aload 4
        //   1228: astore 7
        //   1230: aload 9
        //   1232: astore 4
        //   1234: goto -691 -> 543
        //   1237: aload 6
        //   1239: astore 9
        //   1241: aload 8
        //   1243: astore 6
        //   1245: aload 6
        //   1247: astore 8
        //   1249: aload 9
        //   1251: astore 6
        //   1253: goto -1196 -> 57
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1256	0	this	1
        //   1	1000	1	i	int
        //   5	995	2	j	int
        //   146	716	3	k	int
        //   30	1203	4	localObject1	Object
        //   51	957	5	localObject2	Object
        //   1012	3	5	localIOException1	java.io.IOException
        //   1022	3	5	localIOException2	java.io.IOException
        //   1032	23	5	localIOException3	java.io.IOException
        //   1063	124	5	localObject3	Object
        //   10	1242	6	localObject4	Object
        //   45	1184	7	localObject5	Object
        //   17	825	8	localObject6	Object
        //   882	44	8	localIOException4	java.io.IOException
        //   936	1	8	localObject7	Object
        //   941	46	8	localJSONException1	org.json.JSONException
        //   997	1	8	localObject8	Object
        //   1042	1	8	localJSONException2	org.json.JSONException
        //   1068	1	8	localJSONException3	org.json.JSONException
        //   1091	23	8	localJSONException4	org.json.JSONException
        //   1123	1	8	localObject9	Object
        //   1136	1	8	localIOException5	java.io.IOException
        //   1150	1	8	localIOException6	java.io.IOException
        //   1161	1	8	localIOException7	java.io.IOException
        //   1169	1	8	localIOException8	java.io.IOException
        //   1174	1	8	localUnknownHostException1	java.net.UnknownHostException
        //   1191	1	8	localUnknownHostException2	java.net.UnknownHostException
        //   1205	1	8	localUnknownHostException3	java.net.UnknownHostException
        //   1220	22	8	localUnknownHostException4	java.net.UnknownHostException
        //   1247	1	8	localObject10	Object
        //   7	1	9	localObject11	Object
        //   522	18	9	localUnknownHostException5	java.net.UnknownHostException
        //   779	471	9	localObject12	Object
        //   128	1002	10	localObject13	Object
        //   13	983	11	localObject14	Object
        //   345	43	12	localHashMap	java.util.HashMap
        //   1111	11	12	localJSONException5	org.json.JSONException
        // Exception table:
        //   from	to	target	type
        //   337	497	522	java/net/UnknownHostException
        //   497	505	522	java/net/UnknownHostException
        //   510	519	522	java/net/UnknownHostException
        //   577	646	522	java/net/UnknownHostException
        //   653	674	522	java/net/UnknownHostException
        //   846	872	522	java/net/UnknownHostException
        //   130	141	882	java/io/IOException
        //   130	141	941	org/json/JSONException
        //   62	67	1012	java/io/IOException
        //   72	77	1022	java/io/IOException
        //   82	87	1032	java/io/IOException
        //   141	147	1042	org/json/JSONException
        //   151	159	1042	org/json/JSONException
        //   159	196	1042	org/json/JSONException
        //   216	235	1042	org/json/JSONException
        //   235	337	1068	org/json/JSONException
        //   337	497	1091	org/json/JSONException
        //   497	505	1091	org/json/JSONException
        //   510	519	1091	org/json/JSONException
        //   577	646	1091	org/json/JSONException
        //   653	674	1091	org/json/JSONException
        //   846	872	1091	org/json/JSONException
        //   674	681	1111	org/json/JSONException
        //   686	708	1111	org/json/JSONException
        //   715	761	1111	org/json/JSONException
        //   765	781	1111	org/json/JSONException
        //   788	835	1111	org/json/JSONException
        //   141	147	1136	java/io/IOException
        //   151	159	1136	java/io/IOException
        //   159	196	1136	java/io/IOException
        //   216	235	1136	java/io/IOException
        //   235	337	1150	java/io/IOException
        //   337	497	1161	java/io/IOException
        //   497	505	1161	java/io/IOException
        //   510	519	1161	java/io/IOException
        //   577	646	1161	java/io/IOException
        //   653	674	1161	java/io/IOException
        //   846	872	1161	java/io/IOException
        //   674	681	1169	java/io/IOException
        //   686	708	1169	java/io/IOException
        //   715	761	1169	java/io/IOException
        //   765	781	1169	java/io/IOException
        //   788	835	1169	java/io/IOException
        //   130	141	1174	java/net/UnknownHostException
        //   141	147	1191	java/net/UnknownHostException
        //   151	159	1191	java/net/UnknownHostException
        //   159	196	1191	java/net/UnknownHostException
        //   216	235	1191	java/net/UnknownHostException
        //   235	337	1205	java/net/UnknownHostException
        //   674	681	1220	java/net/UnknownHostException
        //   686	708	1220	java/net/UnknownHostException
        //   715	761	1220	java/net/UnknownHostException
        //   765	781	1220	java/net/UnknownHostException
        //   788	835	1220	java/net/UnknownHostException
      }
    }).start();
  }
  
  public static abstract interface GetSignListener
  {
    public abstract void onGetSignCompleted(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer
 * JD-Core Version:    0.7.0.1
 */