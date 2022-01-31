public class bbqm
{
  public static int a(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  /* Error */
  public static long a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, long paramLong1, java.io.RandomAccessFile paramRandomAccessFile, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 27	bbqq
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: lload_3
    //   12: lload 6
    //   14: iload 8
    //   16: i2l
    //   17: lconst_0
    //   18: lconst_0
    //   19: invokespecial 31	bbqq:<init>	([B[BJJJJJ)V
    //   22: astore_0
    //   23: new 33	bbqp
    //   26: dup
    //   27: iload 8
    //   29: sipush 348
    //   32: iadd
    //   33: i2l
    //   34: invokespecial 36	bbqp:<init>	(J)V
    //   37: astore_1
    //   38: iload 8
    //   40: sipush 364
    //   43: iadd
    //   44: invokestatic 42	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   47: astore 12
    //   49: aload_1
    //   50: aload 12
    //   52: invokevirtual 45	bbqp:a	(Ljava/nio/ByteBuffer;)V
    //   55: aload_0
    //   56: aload 12
    //   58: invokevirtual 46	bbqq:a	(Ljava/nio/ByteBuffer;)V
    //   61: aload 5
    //   63: lload 6
    //   65: invokevirtual 51	java/io/RandomAccessFile:seek	(J)V
    //   68: iload 8
    //   70: newarray byte
    //   72: astore_0
    //   73: aload 5
    //   75: aload_0
    //   76: invokevirtual 55	java/io/RandomAccessFile:read	([B)I
    //   79: pop
    //   80: aload 12
    //   82: aload_0
    //   83: invokevirtual 59	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   86: pop
    //   87: new 61	java/net/URL
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 64	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: invokevirtual 68	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 70	java/net/HttpURLConnection
    //   101: astore_0
    //   102: aload_0
    //   103: ldc 72
    //   105: invokevirtual 75	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: iconst_1
    //   110: invokevirtual 79	java/net/HttpURLConnection:setDoInput	(Z)V
    //   113: aload_0
    //   114: iconst_1
    //   115: invokevirtual 82	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   118: aload_0
    //   119: invokevirtual 86	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   122: astore_1
    //   123: aload_1
    //   124: aload 12
    //   126: invokevirtual 90	java/nio/ByteBuffer:array	()[B
    //   129: invokevirtual 96	java/io/OutputStream:write	([B)V
    //   132: aload_1
    //   133: invokevirtual 100	java/io/OutputStream:flush	()V
    //   136: aload_0
    //   137: invokevirtual 103	java/net/HttpURLConnection:connect	()V
    //   140: aload_0
    //   141: invokevirtual 107	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   144: astore_2
    //   145: new 109	java/io/ByteArrayOutputStream
    //   148: dup
    //   149: invokespecial 111	java/io/ByteArrayOutputStream:<init>	()V
    //   152: astore 13
    //   154: bipush 25
    //   156: newarray byte
    //   158: astore 5
    //   160: aload_2
    //   161: aload 5
    //   163: invokevirtual 114	java/io/InputStream:read	([B)I
    //   166: istore 9
    //   168: iload 9
    //   170: iconst_m1
    //   171: if_icmpeq +77 -> 248
    //   174: aload 13
    //   176: aload 5
    //   178: iconst_0
    //   179: iload 9
    //   181: invokevirtual 117	java/io/ByteArrayOutputStream:write	([BII)V
    //   184: goto -24 -> 160
    //   187: astore 5
    //   189: aload_0
    //   190: astore 12
    //   192: aload 5
    //   194: astore_0
    //   195: aload_1
    //   196: astore 5
    //   198: aload 13
    //   200: astore_1
    //   201: aload 5
    //   203: ifnull +13 -> 216
    //   206: aload 5
    //   208: invokevirtual 100	java/io/OutputStream:flush	()V
    //   211: aload 5
    //   213: invokevirtual 120	java/io/OutputStream:close	()V
    //   216: aload_1
    //   217: ifnull +11 -> 228
    //   220: aload_1
    //   221: invokevirtual 121	java/io/ByteArrayOutputStream:flush	()V
    //   224: aload_1
    //   225: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 123	java/io/InputStream:close	()V
    //   236: aload 12
    //   238: ifnull +8 -> 246
    //   241: aload 12
    //   243: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   246: aload_0
    //   247: athrow
    //   248: aload 13
    //   250: invokevirtual 129	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   253: invokestatic 132	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   256: astore 12
    //   258: new 33	bbqp
    //   261: dup
    //   262: aload 12
    //   264: invokespecial 134	bbqp:<init>	(Ljava/nio/ByteBuffer;)V
    //   267: astore 5
    //   269: new 136	bbqr
    //   272: dup
    //   273: aload 12
    //   275: invokespecial 137	bbqr:<init>	(Ljava/nio/ByteBuffer;)V
    //   278: astore 12
    //   280: aload 5
    //   282: getfield 141	bbqp:b	J
    //   285: lconst_0
    //   286: lcmp
    //   287: ifne +189 -> 476
    //   290: aload 12
    //   292: getfield 144	bbqr:jdField_a_of_type_Int	I
    //   295: istore 9
    //   297: iload 9
    //   299: iconst_1
    //   300: if_icmpne +103 -> 403
    //   303: aload_1
    //   304: ifnull +11 -> 315
    //   307: aload_1
    //   308: invokevirtual 100	java/io/OutputStream:flush	()V
    //   311: aload_1
    //   312: invokevirtual 120	java/io/OutputStream:close	()V
    //   315: aload 13
    //   317: ifnull +13 -> 330
    //   320: aload 13
    //   322: invokevirtual 121	java/io/ByteArrayOutputStream:flush	()V
    //   325: aload 13
    //   327: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   330: aload_2
    //   331: ifnull +7 -> 338
    //   334: aload_2
    //   335: invokevirtual 123	java/io/InputStream:close	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   346: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +52 -> 401
    //   352: ldc 152
    //   354: iconst_2
    //   355: new 154	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   362: ldc 157
    //   364: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   370: lload 10
    //   372: lsub
    //   373: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: ldc 166
    //   378: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: lload_3
    //   382: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc 168
    //   387: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 8
    //   392: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: lload_3
    //   402: lreturn
    //   403: aload 12
    //   405: getfield 181	bbqr:jdField_a_of_type_Long	J
    //   408: lstore_3
    //   409: goto -106 -> 303
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_2
    //   417: aconst_null
    //   418: astore 5
    //   420: aconst_null
    //   421: astore 12
    //   423: goto -222 -> 201
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_2
    //   429: aconst_null
    //   430: astore 5
    //   432: aload_0
    //   433: astore 12
    //   435: aload_1
    //   436: astore_0
    //   437: aconst_null
    //   438: astore_1
    //   439: goto -238 -> 201
    //   442: astore 13
    //   444: aconst_null
    //   445: astore_2
    //   446: aload_1
    //   447: astore 5
    //   449: aload_0
    //   450: astore 12
    //   452: aload 13
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -256 -> 201
    //   460: astore 13
    //   462: aload_1
    //   463: astore 5
    //   465: aload_0
    //   466: astore 12
    //   468: aload 13
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_1
    //   473: goto -272 -> 201
    //   476: ldc2_w 182
    //   479: lstore_3
    //   480: goto -177 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramArrayOfByte1	byte[]
    //   0	483	1	paramArrayOfByte2	byte[]
    //   0	483	2	paramString	String
    //   0	483	3	paramLong1	long
    //   0	483	5	paramRandomAccessFile	java.io.RandomAccessFile
    //   0	483	6	paramLong2	long
    //   0	483	8	paramInt	int
    //   166	135	9	i	int
    //   3	368	10	l	long
    //   47	420	12	localObject1	Object
    //   152	174	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   442	11	13	localObject2	Object
    //   460	9	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   154	160	187	finally
    //   160	168	187	finally
    //   174	184	187	finally
    //   248	297	187	finally
    //   403	409	187	finally
    //   5	102	412	finally
    //   102	123	426	finally
    //   123	145	442	finally
    //   145	154	460	finally
  }
  
  /* Error */
  public static bbqn a(android.os.Bundle paramBundle, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: ldc 190
    //   8: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 198
    //   16: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 200
    //   24: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 11
    //   29: aload_0
    //   30: ldc 202
    //   32: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 14
    //   37: aload_0
    //   38: ldc 204
    //   40: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_0
    //   46: ldc 206
    //   48: iconst_1
    //   49: invokevirtual 210	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   52: istore_3
    //   53: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +72 -> 128
    //   59: ldc 152
    //   61: iconst_2
    //   62: new 154	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   69: ldc 212
    //   71: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 9
    //   76: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 214
    //   81: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 10
    //   86: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 216
    //   91: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 11
    //   96: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 218
    //   101: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 14
    //   106: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 220
    //   111: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 14
    //   116: invokestatic 225	bdhb:a	(Ljava/lang/String;)J
    //   119: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 14
    //   130: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +11 -> 144
    //   136: aload 14
    //   138: invokestatic 234	bdhb:a	(Ljava/lang/String;)Z
    //   141: ifne +39 -> 180
    //   144: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +29 -> 176
    //   150: ldc 152
    //   152: iconst_2
    //   153: new 154	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   160: ldc 236
    //   162: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 14
    //   167: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: areturn
    //   180: new 241	org/apache/http/client/methods/HttpPost
    //   183: dup
    //   184: ldc 243
    //   186: invokespecial 244	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   189: astore 12
    //   191: aload 12
    //   193: ldc 246
    //   195: ldc 248
    //   197: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 12
    //   202: ldc 254
    //   204: ldc_w 256
    //   207: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 12
    //   212: ldc_w 258
    //   215: ldc_w 260
    //   218: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 12
    //   223: ldc_w 262
    //   226: ldc_w 264
    //   229: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 12
    //   234: ldc_w 266
    //   237: ldc_w 268
    //   240: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 12
    //   245: ldc_w 270
    //   248: new 154	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 272
    //   258: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 274
    //   268: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 276
    //   278: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 12
    //   293: ldc_w 278
    //   296: ldc_w 280
    //   299: invokevirtual 252	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: new 282	java/util/ArrayList
    //   305: dup
    //   306: invokespecial 283	java/util/ArrayList:<init>	()V
    //   309: astore 13
    //   311: iload_3
    //   312: iconst_1
    //   313: if_icmpne +469 -> 782
    //   316: ldc_w 285
    //   319: astore_0
    //   320: aload 13
    //   322: new 287	org/apache/http/message/BasicNameValuePair
    //   325: dup
    //   326: ldc_w 289
    //   329: aload_0
    //   330: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: invokeinterface 297 2 0
    //   338: pop
    //   339: aload 13
    //   341: new 287	org/apache/http/message/BasicNameValuePair
    //   344: dup
    //   345: ldc 190
    //   347: aload 9
    //   349: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: invokeinterface 297 2 0
    //   357: pop
    //   358: aload 13
    //   360: new 287	org/apache/http/message/BasicNameValuePair
    //   363: dup
    //   364: ldc 198
    //   366: aload 10
    //   368: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: invokeinterface 297 2 0
    //   376: pop
    //   377: aload 13
    //   379: new 287	org/apache/http/message/BasicNameValuePair
    //   382: dup
    //   383: ldc 200
    //   385: aload 11
    //   387: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: invokeinterface 297 2 0
    //   395: pop
    //   396: aload 13
    //   398: new 287	org/apache/http/message/BasicNameValuePair
    //   401: dup
    //   402: ldc_w 299
    //   405: aload 14
    //   407: invokestatic 225	bdhb:a	(Ljava/lang/String;)J
    //   410: invokestatic 303	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   413: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: invokeinterface 297 2 0
    //   421: pop
    //   422: aload 13
    //   424: new 287	org/apache/http/message/BasicNameValuePair
    //   427: dup
    //   428: ldc_w 305
    //   431: aload 14
    //   433: invokestatic 310	arrr:a	(Ljava/lang/String;)[B
    //   436: invokestatic 315	bdhe:a	([B)Ljava/lang/String;
    //   439: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: invokeinterface 297 2 0
    //   447: pop
    //   448: aload 13
    //   450: new 287	org/apache/http/message/BasicNameValuePair
    //   453: dup
    //   454: ldc_w 317
    //   457: aload 14
    //   459: invokestatic 319	arrr:d	(Ljava/lang/String;)[B
    //   462: invokestatic 315	bdhe:a	([B)Ljava/lang/String;
    //   465: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: invokeinterface 297 2 0
    //   473: pop
    //   474: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +34 -> 511
    //   480: ldc 152
    //   482: iconst_2
    //   483: new 154	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 321
    //   493: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   499: lload 6
    //   501: lsub
    //   502: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload 13
    //   513: new 287	org/apache/http/message/BasicNameValuePair
    //   516: dup
    //   517: ldc_w 323
    //   520: ldc_w 325
    //   523: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: invokeinterface 297 2 0
    //   531: pop
    //   532: aload 13
    //   534: new 287	org/apache/http/message/BasicNameValuePair
    //   537: dup
    //   538: ldc_w 327
    //   541: aload_2
    //   542: invokestatic 329	bbqm:a	(Ljava/lang/String;)I
    //   545: invokestatic 332	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: invokeinterface 297 2 0
    //   556: pop
    //   557: aload 13
    //   559: new 287	org/apache/http/message/BasicNameValuePair
    //   562: dup
    //   563: ldc_w 334
    //   566: ldc_w 336
    //   569: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: invokeinterface 297 2 0
    //   577: pop
    //   578: aload 15
    //   580: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +43 -> 626
    //   586: aload 13
    //   588: new 287	org/apache/http/message/BasicNameValuePair
    //   591: dup
    //   592: ldc 204
    //   594: aload 15
    //   596: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: invokeinterface 297 2 0
    //   604: pop
    //   605: aload 13
    //   607: new 287	org/apache/http/message/BasicNameValuePair
    //   610: dup
    //   611: ldc_w 338
    //   614: ldc_w 340
    //   617: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: invokeinterface 297 2 0
    //   625: pop
    //   626: aconst_null
    //   627: astore 10
    //   629: aconst_null
    //   630: astore 11
    //   632: aconst_null
    //   633: astore 9
    //   635: aconst_null
    //   636: astore_0
    //   637: aload 10
    //   639: astore_2
    //   640: aload 11
    //   642: astore_1
    //   643: aload 12
    //   645: new 342	org/apache/http/client/entity/UrlEncodedFormEntity
    //   648: dup
    //   649: aload 13
    //   651: ldc_w 344
    //   654: invokespecial 347	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   657: invokevirtual 351	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   660: aload 10
    //   662: astore_2
    //   663: aload 11
    //   665: astore_1
    //   666: new 353	org/apache/http/impl/client/DefaultHttpClient
    //   669: dup
    //   670: invokespecial 354	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   673: aload 12
    //   675: invokevirtual 358	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   678: astore 12
    //   680: aload 10
    //   682: astore_2
    //   683: aload 11
    //   685: astore_1
    //   686: aload 12
    //   688: invokeinterface 364 1 0
    //   693: invokeinterface 369 1 0
    //   698: sipush 200
    //   701: if_icmpne +385 -> 1086
    //   704: aload 10
    //   706: astore_2
    //   707: aload 11
    //   709: astore_1
    //   710: aload 12
    //   712: ldc_w 371
    //   715: invokeinterface 375 2 0
    //   720: astore 9
    //   722: aload 10
    //   724: astore_2
    //   725: aload 11
    //   727: astore_1
    //   728: aload 9
    //   730: arraylength
    //   731: istore 5
    //   733: iconst_0
    //   734: istore 4
    //   736: iconst_0
    //   737: istore_3
    //   738: iload_3
    //   739: iload 5
    //   741: if_icmpge +48 -> 789
    //   744: aload 10
    //   746: astore_2
    //   747: aload 11
    //   749: astore_1
    //   750: aload 9
    //   752: iload_3
    //   753: aaload
    //   754: invokeinterface 380 1 0
    //   759: ldc_w 382
    //   762: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   765: istore 8
    //   767: iload 8
    //   769: ifeq +6 -> 775
    //   772: iconst_1
    //   773: istore 4
    //   775: iload_3
    //   776: iconst_1
    //   777: iadd
    //   778: istore_3
    //   779: goto -41 -> 738
    //   782: ldc_w 387
    //   785: astore_0
    //   786: goto -466 -> 320
    //   789: aload 10
    //   791: astore_2
    //   792: aload 11
    //   794: astore_1
    //   795: aload 12
    //   797: invokeinterface 391 1 0
    //   802: astore 9
    //   804: iload 4
    //   806: ifeq +187 -> 993
    //   809: aload 10
    //   811: astore_2
    //   812: aload 11
    //   814: astore_1
    //   815: new 393	java/util/zip/GZIPInputStream
    //   818: dup
    //   819: aload 9
    //   821: invokeinterface 398 1 0
    //   826: invokespecial 401	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   829: astore_0
    //   830: aload_0
    //   831: invokestatic 406	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   834: astore 9
    //   836: aload_0
    //   837: astore_2
    //   838: aload_0
    //   839: astore_1
    //   840: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +34 -> 877
    //   846: aload_0
    //   847: astore_2
    //   848: aload_0
    //   849: astore_1
    //   850: ldc 152
    //   852: iconst_2
    //   853: new 154	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 408
    //   863: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 9
    //   868: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   877: aload_0
    //   878: astore_2
    //   879: aload_0
    //   880: astore_1
    //   881: new 410	org/json/JSONObject
    //   884: dup
    //   885: aload 9
    //   887: invokespecial 411	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   890: astore 10
    //   892: aload_0
    //   893: astore_2
    //   894: aload_0
    //   895: astore_1
    //   896: aload_0
    //   897: astore 9
    //   899: aload 10
    //   901: ldc_w 413
    //   904: iconst_m1
    //   905: invokevirtual 416	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   908: ifne +178 -> 1086
    //   911: aload_0
    //   912: astore_2
    //   913: aload_0
    //   914: astore_1
    //   915: new 418	bbqn
    //   918: dup
    //   919: aload 10
    //   921: ldc_w 420
    //   924: invokevirtual 424	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   927: invokespecial 427	bbqn:<init>	(Lorg/json/JSONObject;)V
    //   930: astore 10
    //   932: aload_0
    //   933: astore 9
    //   935: aload 10
    //   937: astore_1
    //   938: aload_1
    //   939: astore_0
    //   940: aload 9
    //   942: ifnull +10 -> 952
    //   945: aload 9
    //   947: invokevirtual 428	java/util/zip/GZIPInputStream:close	()V
    //   950: aload_1
    //   951: astore_0
    //   952: aload_0
    //   953: astore_1
    //   954: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   957: ifeq -779 -> 178
    //   960: ldc 152
    //   962: iconst_2
    //   963: new 154	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   970: ldc_w 430
    //   973: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   979: lload 6
    //   981: lsub
    //   982: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: aload_0
    //   992: areturn
    //   993: aload 10
    //   995: astore_2
    //   996: aload 11
    //   998: astore_1
    //   999: aload 9
    //   1001: invokestatic 435	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1004: astore 9
    //   1006: goto -170 -> 836
    //   1009: astore_0
    //   1010: aload_2
    //   1011: astore_1
    //   1012: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1015: ifeq +15 -> 1030
    //   1018: aload_2
    //   1019: astore_1
    //   1020: ldc 152
    //   1022: iconst_2
    //   1023: aload_0
    //   1024: invokestatic 439	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1027: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: aload_2
    //   1031: ifnull +7 -> 1038
    //   1034: aload_2
    //   1035: invokevirtual 428	java/util/zip/GZIPInputStream:close	()V
    //   1038: aconst_null
    //   1039: astore_0
    //   1040: goto -88 -> 952
    //   1043: astore_0
    //   1044: aconst_null
    //   1045: astore_0
    //   1046: goto -94 -> 952
    //   1049: astore_0
    //   1050: aload_1
    //   1051: ifnull +7 -> 1058
    //   1054: aload_1
    //   1055: invokevirtual 428	java/util/zip/GZIPInputStream:close	()V
    //   1058: aload_0
    //   1059: athrow
    //   1060: astore_0
    //   1061: aload_1
    //   1062: astore_0
    //   1063: goto -111 -> 952
    //   1066: astore_1
    //   1067: goto -9 -> 1058
    //   1070: astore_2
    //   1071: aload_0
    //   1072: astore_1
    //   1073: aload_2
    //   1074: astore_0
    //   1075: goto -25 -> 1050
    //   1078: astore_1
    //   1079: aload_0
    //   1080: astore_2
    //   1081: aload_1
    //   1082: astore_0
    //   1083: goto -73 -> 1010
    //   1086: aconst_null
    //   1087: astore_1
    //   1088: goto -150 -> 938
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	paramBundle	android.os.Bundle
    //   0	1091	1	paramString1	String
    //   0	1091	2	paramString2	String
    //   52	727	3	i	int
    //   734	71	4	j	int
    //   731	11	5	k	int
    //   3	977	6	l	long
    //   765	3	8	bool	boolean
    //   11	994	9	localObject1	Object
    //   19	975	10	localObject2	Object
    //   27	970	11	str1	String
    //   189	607	12	localObject3	Object
    //   309	341	13	localArrayList	java.util.ArrayList
    //   35	423	14	str2	String
    //   43	552	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   643	660	1009	java/lang/Exception
    //   666	680	1009	java/lang/Exception
    //   686	704	1009	java/lang/Exception
    //   710	722	1009	java/lang/Exception
    //   728	733	1009	java/lang/Exception
    //   750	767	1009	java/lang/Exception
    //   795	804	1009	java/lang/Exception
    //   815	830	1009	java/lang/Exception
    //   840	846	1009	java/lang/Exception
    //   850	877	1009	java/lang/Exception
    //   881	892	1009	java/lang/Exception
    //   899	911	1009	java/lang/Exception
    //   915	932	1009	java/lang/Exception
    //   999	1006	1009	java/lang/Exception
    //   1034	1038	1043	java/io/IOException
    //   643	660	1049	finally
    //   666	680	1049	finally
    //   686	704	1049	finally
    //   710	722	1049	finally
    //   728	733	1049	finally
    //   750	767	1049	finally
    //   795	804	1049	finally
    //   815	830	1049	finally
    //   840	846	1049	finally
    //   850	877	1049	finally
    //   881	892	1049	finally
    //   899	911	1049	finally
    //   915	932	1049	finally
    //   999	1006	1049	finally
    //   1012	1018	1049	finally
    //   1020	1030	1049	finally
    //   945	950	1060	java/io/IOException
    //   1054	1058	1066	java/io/IOException
    //   830	836	1070	finally
    //   830	836	1078	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqm
 * JD-Core Version:    0.7.0.1
 */