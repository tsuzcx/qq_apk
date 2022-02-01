package com.tencent.TMG.utils;

final class CosFileTransfer$1
  implements Runnable
{
  CosFileTransfer$1(String paramString1, int paramInt, String paramString2, String paramString3, CosFileTransfer.UploadCosFileListener paramUploadCosFileListener, Object paramObject) {}
  
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
    //   15: ldc 43
    //   17: astore 8
    //   19: aload_0
    //   20: getfield 20	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
    //   23: invokestatic 49	com/tencent/TMG/utils/CosFileTransfer:access$000	(Ljava/lang/String;)Ljava/io/File;
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
    //   60: invokevirtual 54	java/io/FileInputStream:close	()V
    //   63: aload 7
    //   65: ifnull +8 -> 73
    //   68: aload 7
    //   70: invokevirtual 57	java/io/OutputStream:close	()V
    //   73: aload 6
    //   75: ifnull +8 -> 83
    //   78: aload 6
    //   80: invokevirtual 60	java/io/BufferedReader:close	()V
    //   83: aload 4
    //   85: ifnull +8 -> 93
    //   88: aload 4
    //   90: invokevirtual 65	java/net/HttpURLConnection:disconnect	()V
    //   93: aload_0
    //   94: getfield 28	com/tencent/TMG/utils/CosFileTransfer$1:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$UploadCosFileListener;
    //   97: ifnull +19 -> 116
    //   100: aload_0
    //   101: getfield 28	com/tencent/TMG/utils/CosFileTransfer$1:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$UploadCosFileListener;
    //   104: iload_1
    //   105: aload 8
    //   107: aload_0
    //   108: getfield 30	com/tencent/TMG/utils/CosFileTransfer$1:val$param	Ljava/lang/Object;
    //   111: invokeinterface 71 4 0
    //   116: return
    //   117: aload_0
    //   118: getfield 20	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
    //   121: invokestatic 77	com/tencent/TMG/ptt/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 10
    //   126: new 51	java/io/FileInputStream
    //   129: dup
    //   130: aload 4
    //   132: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore 5
    //   137: aload 5
    //   139: invokevirtual 84	java/io/FileInputStream:available	()I
    //   142: istore_3
    //   143: iload_3
    //   144: ifle +11 -> 155
    //   147: iload_3
    //   148: aload_0
    //   149: getfield 22	com/tencent/TMG/utils/CosFileTransfer$1:val$maxSize	I
    //   152: if_icmple +60 -> 212
    //   155: ldc 86
    //   157: new 88	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   164: ldc 91
    //   166: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: getfield 20	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
    //   173: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 97
    //   178: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_3
    //   182: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   212: new 112	java/net/URL
    //   215: dup
    //   216: aload_0
    //   217: getfield 24	com/tencent/TMG/utils/CosFileTransfer$1:val$strUrl	Ljava/lang/String;
    //   220: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   223: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   226: checkcast 62	java/net/HttpURLConnection
    //   229: astore 4
    //   231: aload 4
    //   233: sipush 5000
    //   236: invokevirtual 123	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   239: aload 4
    //   241: sipush 30000
    //   244: invokevirtual 126	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   247: aload 4
    //   249: iconst_1
    //   250: invokevirtual 130	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   253: aload 4
    //   255: iconst_1
    //   256: invokevirtual 133	java/net/HttpURLConnection:setDoInput	(Z)V
    //   259: aload 4
    //   261: iconst_0
    //   262: invokevirtual 136	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   265: aload 4
    //   267: ldc 138
    //   269: invokevirtual 141	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   272: aload 4
    //   274: ldc 143
    //   276: ldc 145
    //   278: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 4
    //   283: ldc 151
    //   285: aload_0
    //   286: getfield 26	com/tencent/TMG/utils/CosFileTransfer$1:val$sign	Ljava/lang/String;
    //   289: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload 4
    //   294: ldc 153
    //   296: new 88	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   303: ldc 155
    //   305: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 157
    //   310: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: new 159	java/io/DataOutputStream
    //   322: dup
    //   323: aload 4
    //   325: invokevirtual 163	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   328: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   331: astore 7
    //   333: new 168	java/util/HashMap
    //   336: dup
    //   337: iconst_3
    //   338: invokespecial 170	java/util/HashMap:<init>	(I)V
    //   341: astore 12
    //   343: aload 12
    //   345: ldc 172
    //   347: ldc 174
    //   349: invokeinterface 180 3 0
    //   354: pop
    //   355: aload 12
    //   357: ldc 182
    //   359: aload 10
    //   361: invokeinterface 180 3 0
    //   366: pop
    //   367: aload 12
    //   369: ldc 184
    //   371: ldc 43
    //   373: invokeinterface 180 3 0
    //   378: pop
    //   379: aload 12
    //   381: ldc 157
    //   383: invokestatic 188	com/tencent/TMG/utils/CosFileTransfer:access$100	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   386: astore 10
    //   388: new 88	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   395: aload 10
    //   397: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc 190
    //   402: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc 157
    //   407: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 192
    //   412: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: astore 10
    //   420: new 88	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   427: aload 10
    //   429: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 194
    //   434: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_0
    //   438: getfield 20	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
    //   441: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc 196
    //   446: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: astore 10
    //   454: aload 7
    //   456: new 88	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   463: aload 10
    //   465: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 198
    //   470: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 204	java/lang/String:getBytes	()[B
    //   479: invokevirtual 208	java/io/OutputStream:write	([B)V
    //   482: sipush 1024
    //   485: newarray byte
    //   487: astore 10
    //   489: aload 5
    //   491: aload 10
    //   493: invokevirtual 212	java/io/FileInputStream:read	([B)I
    //   496: istore_3
    //   497: iload_3
    //   498: iconst_m1
    //   499: if_icmpeq +70 -> 569
    //   502: aload 7
    //   504: aload 10
    //   506: iconst_0
    //   507: iload_3
    //   508: invokevirtual 215	java/io/OutputStream:write	([BII)V
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
    //   535: ldc 86
    //   537: ldc 217
    //   539: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   542: pop
    //   543: aload 8
    //   545: invokevirtual 220	java/net/UnknownHostException:printStackTrace	()V
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
    //   571: new 88	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   578: ldc 222
    //   580: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: ldc 157
    //   585: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc 224
    //   590: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokevirtual 204	java/lang/String:getBytes	()[B
    //   599: invokevirtual 208	java/io/OutputStream:write	([B)V
    //   602: aload 7
    //   604: invokevirtual 227	java/io/OutputStream:flush	()V
    //   607: aload 4
    //   609: invokevirtual 230	java/net/HttpURLConnection:getResponseCode	()I
    //   612: istore_3
    //   613: ldc 86
    //   615: new 88	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   622: ldc 232
    //   624: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: iload_3
    //   628: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 235	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   637: pop
    //   638: iload_3
    //   639: sipush 200
    //   642: if_icmpne +196 -> 838
    //   645: new 59	java/io/BufferedReader
    //   648: dup
    //   649: new 237	java/io/InputStreamReader
    //   652: dup
    //   653: aload 4
    //   655: invokevirtual 241	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   658: invokespecial 244	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   661: invokespecial 247	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   664: astore 6
    //   666: aload 6
    //   668: invokevirtual 250	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   671: astore 10
    //   673: aload 10
    //   675: ifnull +32 -> 707
    //   678: new 88	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   685: aload 8
    //   687: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload 10
    //   692: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: astore 10
    //   700: aload 10
    //   702: astore 8
    //   704: goto -38 -> 666
    //   707: ldc 86
    //   709: new 88	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   716: ldc 252
    //   718: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 8
    //   723: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 255	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   732: pop
    //   733: new 257	org/json/JSONObject
    //   736: dup
    //   737: aload 8
    //   739: invokespecial 258	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   742: astore 10
    //   744: aload 10
    //   746: ldc_w 260
    //   749: invokevirtual 264	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   752: istore_3
    //   753: iload_3
    //   754: ifne +26 -> 780
    //   757: aload 10
    //   759: ldc_w 266
    //   762: invokevirtual 270	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   765: ldc_w 272
    //   768: invokevirtual 275	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   771: astore 9
    //   773: aload 9
    //   775: astore 8
    //   777: goto +452 -> 1229
    //   780: aload 10
    //   782: ldc_w 277
    //   785: invokevirtual 275	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   788: astore 10
    //   790: ldc 86
    //   792: new 88	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   799: ldc_w 279
    //   802: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: iload_3
    //   806: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: ldc_w 281
    //   812: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 10
    //   817: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   826: pop
    //   827: sipush 8195
    //   830: istore_1
    //   831: aload 9
    //   833: astore 8
    //   835: goto +394 -> 1229
    //   838: ldc 86
    //   840: new 88	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 283
    //   850: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: iload_3
    //   854: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   857: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   888: ldc 86
    //   890: new 88	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   897: ldc_w 285
    //   900: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload_0
    //   904: getfield 20	com/tencent/TMG/utils/CosFileTransfer$1:val$srcPath	Ljava/lang/String;
    //   907: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   916: pop
    //   917: aload 8
    //   919: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   922: sipush 8193
    //   925: istore_1
    //   926: aload 11
    //   928: astore 8
    //   930: goto -877 -> 53
    //   933: astore 8
    //   935: ldc 43
    //   937: astore 9
    //   939: aconst_null
    //   940: astore 5
    //   942: aconst_null
    //   943: astore 7
    //   945: aconst_null
    //   946: astore 4
    //   948: aconst_null
    //   949: astore 6
    //   951: ldc 86
    //   953: new 88	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   960: ldc_w 288
    //   963: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload 9
    //   968: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   977: pop
    //   978: aload 8
    //   980: invokevirtual 289	org/json/JSONException:printStackTrace	()V
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
    //   1008: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1011: goto -948 -> 63
    //   1014: astore 5
    //   1016: aload 5
    //   1018: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1021: goto -948 -> 73
    //   1024: astore 5
    //   1026: aload 5
    //   1028: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1031: goto -948 -> 83
    //   1034: astore 8
    //   1036: ldc 43
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
    //   1068: ldc 43
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
    //   1092: ldc 43
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer.1
 * JD-Core Version:    0.7.0.1
 */