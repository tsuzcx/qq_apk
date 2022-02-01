package com.tencent.luggage.wxa.jp;

import java.io.BufferedWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

class d$a
  implements Callable<Void>
{
  private Socket b;
  
  d$a(d paramd, Socket paramSocket)
  {
    this.b = paramSocket;
  }
  
  private void a(com.tencent.luggage.wxa.jr.d paramd, BufferedWriter paramBufferedWriter)
  {
    c.a locala = d.c(this.a);
    if ((locala != null) && (!locala.a(paramd)))
    {
      c(paramBufferedWriter);
      return;
    }
    a(paramBufferedWriter);
  }
  
  private void a(BufferedWriter paramBufferedWriter)
  {
    paramBufferedWriter.write("HTTP/1.1 200 OK\r\nContent-Length: 0\r\n\r\n");
  }
  
  private void b(BufferedWriter paramBufferedWriter)
  {
    paramBufferedWriter.write("HTTP/1.1 404 Not Found\r\nContent-Length: 0\r\n\r\n");
  }
  
  private void c(BufferedWriter paramBufferedWriter)
  {
    paramBufferedWriter.write("HTTP/1.1 500 Internal Server Error\r\nContent-Length: 0\r\n\r\n");
  }
  
  /* Error */
  public Void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   4: invokevirtual 59	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   7: astore 6
    //   9: invokestatic 64	com/tencent/luggage/wxa/jp/j:a	()Lcom/tencent/luggage/wxa/jp/j;
    //   12: astore 8
    //   14: iconst_0
    //   15: istore_2
    //   16: new 66	com/tencent/luggage/wxa/jr/d
    //   19: dup
    //   20: iconst_0
    //   21: invokespecial 69	com/tencent/luggage/wxa/jr/d:<init>	(Z)V
    //   24: astore 7
    //   26: new 71	java/io/BufferedReader
    //   29: dup
    //   30: new 73	java/io/InputStreamReader
    //   33: dup
    //   34: aload 6
    //   36: invokespecial 76	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 9
    //   44: new 81	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload 9
    //   54: invokevirtual 86	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 4
    //   59: ldc 88
    //   61: astore 5
    //   63: aload 4
    //   65: ifnull +469 -> 534
    //   68: aload 4
    //   70: invokevirtual 94	java/lang/String:length	()I
    //   73: ifne +70 -> 143
    //   76: aload_3
    //   77: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 4
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 94	java/lang/String:length	()I
    //   90: ifle +447 -> 537
    //   93: aload 7
    //   95: aload 8
    //   97: aload 4
    //   99: invokevirtual 100	com/tencent/luggage/wxa/jp/j:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/jr/b;
    //   102: putfield 103	com/tencent/luggage/wxa/jr/d:b	Lcom/tencent/luggage/wxa/jr/b;
    //   105: aload 7
    //   107: getfield 103	com/tencent/luggage/wxa/jr/d:b	Lcom/tencent/luggage/wxa/jr/b;
    //   110: ldc 105
    //   112: invokevirtual 110	com/tencent/luggage/wxa/jr/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore 10
    //   117: aload 4
    //   119: astore_3
    //   120: aload 10
    //   122: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +412 -> 537
    //   128: aload 10
    //   130: invokestatic 122	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   133: invokevirtual 125	java/lang/Integer:intValue	()I
    //   136: istore_1
    //   137: aload 4
    //   139: astore_3
    //   140: goto +20 -> 160
    //   143: aload_3
    //   144: aload 4
    //   146: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_3
    //   151: ldc 131
    //   153: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: goto -105 -> 52
    //   160: aload 5
    //   162: astore 4
    //   164: iload_1
    //   165: ifle +27 -> 192
    //   168: iload_1
    //   169: newarray char
    //   171: astore 4
    //   173: new 90	java/lang/String
    //   176: dup
    //   177: aload 4
    //   179: iconst_0
    //   180: aload 9
    //   182: aload 4
    //   184: invokevirtual 135	java/io/BufferedReader:read	([C)I
    //   187: invokespecial 138	java/lang/String:<init>	([CII)V
    //   190: astore 4
    //   192: new 81	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   199: astore 5
    //   201: aload 5
    //   203: ldc 140
    //   205: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 5
    //   211: aload_3
    //   212: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 142
    //   218: aload 5
    //   220: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 148	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   226: pop
    //   227: new 81	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   234: astore 5
    //   236: aload 5
    //   238: ldc 150
    //   240: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 5
    //   246: aload 4
    //   248: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: ldc 142
    //   254: aload 5
    //   256: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 148	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   262: pop
    //   263: aload_3
    //   264: invokevirtual 94	java/lang/String:length	()I
    //   267: ifle +14 -> 281
    //   270: aload 7
    //   272: aload 8
    //   274: aload_3
    //   275: invokevirtual 100	com/tencent/luggage/wxa/jp/j:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/jr/b;
    //   278: putfield 103	com/tencent/luggage/wxa/jr/d:b	Lcom/tencent/luggage/wxa/jr/b;
    //   281: aload 4
    //   283: invokevirtual 94	java/lang/String:length	()I
    //   286: ifle +15 -> 301
    //   289: aload 7
    //   291: aload 8
    //   293: aload 4
    //   295: invokevirtual 153	com/tencent/luggage/wxa/jp/j:b	(Ljava/lang/String;)Ljava/util/HashMap;
    //   298: putfield 156	com/tencent/luggage/wxa/jr/d:c	Ljava/util/Map;
    //   301: new 42	java/io/BufferedWriter
    //   304: dup
    //   305: new 158	java/io/OutputStreamWriter
    //   308: dup
    //   309: aload_0
    //   310: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   313: invokevirtual 162	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   316: invokespecial 165	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   319: invokespecial 168	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   322: astore_3
    //   323: aload 7
    //   325: getfield 103	com/tencent/luggage/wxa/jr/d:b	Lcom/tencent/luggage/wxa/jr/b;
    //   328: ldc 170
    //   330: invokevirtual 110	com/tencent/luggage/wxa/jr/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   333: astore 4
    //   335: aload 4
    //   337: invokevirtual 173	java/lang/String:hashCode	()I
    //   340: istore_1
    //   341: iload_1
    //   342: ldc 174
    //   344: if_icmpeq +27 -> 371
    //   347: iload_1
    //   348: ldc 175
    //   350: if_icmpeq +6 -> 356
    //   353: goto +189 -> 542
    //   356: aload 4
    //   358: ldc 177
    //   360: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   363: ifeq +179 -> 542
    //   366: iconst_1
    //   367: istore_1
    //   368: goto +18 -> 386
    //   371: aload 4
    //   373: ldc 183
    //   375: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +164 -> 542
    //   381: iload_2
    //   382: istore_1
    //   383: goto +3 -> 386
    //   386: iload_1
    //   387: ifeq +41 -> 428
    //   390: iload_1
    //   391: iconst_1
    //   392: if_icmpeq +19 -> 411
    //   395: ldc 142
    //   397: ldc 185
    //   399: invokestatic 188	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   402: pop
    //   403: aload_0
    //   404: aload_3
    //   405: invokespecial 190	com/tencent/luggage/wxa/jp/d$a:b	(Ljava/io/BufferedWriter;)V
    //   408: goto +34 -> 442
    //   411: aload 7
    //   413: ldc 192
    //   415: putfield 195	com/tencent/luggage/wxa/jr/d:a	Ljava/lang/String;
    //   418: aload_0
    //   419: aload 7
    //   421: aload_3
    //   422: invokespecial 197	com/tencent/luggage/wxa/jp/d$a:a	(Lcom/tencent/luggage/wxa/jr/d;Ljava/io/BufferedWriter;)V
    //   425: goto +17 -> 442
    //   428: aload 7
    //   430: ldc 199
    //   432: putfield 195	com/tencent/luggage/wxa/jr/d:a	Ljava/lang/String;
    //   435: aload_0
    //   436: aload 7
    //   438: aload_3
    //   439: invokespecial 197	com/tencent/luggage/wxa/jp/d$a:a	(Lcom/tencent/luggage/wxa/jr/d;Ljava/io/BufferedWriter;)V
    //   442: aload_3
    //   443: invokevirtual 202	java/io/BufferedWriter:flush	()V
    //   446: aload_3
    //   447: invokevirtual 205	java/io/BufferedWriter:close	()V
    //   450: aload 6
    //   452: invokevirtual 208	java/io/InputStream:close	()V
    //   455: aload_0
    //   456: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   459: invokevirtual 209	java/net/Socket:close	()V
    //   462: aload_0
    //   463: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   466: astore_3
    //   467: aload_3
    //   468: ifnull +31 -> 499
    //   471: aload_3
    //   472: invokevirtual 209	java/net/Socket:close	()V
    //   475: goto +24 -> 499
    //   478: astore_3
    //   479: goto +22 -> 501
    //   482: astore_3
    //   483: aload_3
    //   484: invokevirtual 212	java/io/IOException:printStackTrace	()V
    //   487: aload_0
    //   488: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +6 -> 499
    //   496: goto -25 -> 471
    //   499: aconst_null
    //   500: areturn
    //   501: aload_0
    //   502: getfield 20	com/tencent/luggage/wxa/jp/d$a:b	Ljava/net/Socket;
    //   505: astore 4
    //   507: aload 4
    //   509: ifnull +8 -> 517
    //   512: aload 4
    //   514: invokevirtual 209	java/net/Socket:close	()V
    //   517: goto +5 -> 522
    //   520: aload_3
    //   521: athrow
    //   522: goto -2 -> 520
    //   525: astore_3
    //   526: goto -27 -> 499
    //   529: astore 4
    //   531: goto -14 -> 517
    //   534: ldc 88
    //   536: astore_3
    //   537: iconst_0
    //   538: istore_1
    //   539: goto -379 -> 160
    //   542: iconst_m1
    //   543: istore_1
    //   544: goto -158 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	a
    //   136	408	1	i	int
    //   15	367	2	j	int
    //   51	421	3	localObject1	Object
    //   478	1	3	localObject2	Object
    //   482	2	3	localIOException1	java.io.IOException
    //   491	30	3	localSocket	Socket
    //   525	1	3	localIOException2	java.io.IOException
    //   536	1	3	str1	java.lang.String
    //   57	456	4	localObject3	Object
    //   529	1	4	localIOException3	java.io.IOException
    //   61	194	5	localObject4	Object
    //   7	444	6	localInputStream	java.io.InputStream
    //   24	413	7	locald	com.tencent.luggage.wxa.jr.d
    //   12	280	8	localj	j
    //   42	139	9	localBufferedReader	java.io.BufferedReader
    //   115	14	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   0	14	478	finally
    //   16	52	478	finally
    //   52	59	478	finally
    //   68	82	478	finally
    //   85	117	478	finally
    //   120	137	478	finally
    //   143	157	478	finally
    //   168	192	478	finally
    //   192	281	478	finally
    //   281	301	478	finally
    //   301	341	478	finally
    //   356	366	478	finally
    //   371	381	478	finally
    //   395	408	478	finally
    //   411	425	478	finally
    //   428	442	478	finally
    //   442	462	478	finally
    //   483	487	478	finally
    //   0	14	482	java/io/IOException
    //   16	52	482	java/io/IOException
    //   52	59	482	java/io/IOException
    //   68	82	482	java/io/IOException
    //   85	117	482	java/io/IOException
    //   120	137	482	java/io/IOException
    //   143	157	482	java/io/IOException
    //   168	192	482	java/io/IOException
    //   192	281	482	java/io/IOException
    //   281	301	482	java/io/IOException
    //   301	341	482	java/io/IOException
    //   356	366	482	java/io/IOException
    //   371	381	482	java/io/IOException
    //   395	408	482	java/io/IOException
    //   411	425	482	java/io/IOException
    //   428	442	482	java/io/IOException
    //   442	462	482	java/io/IOException
    //   471	475	525	java/io/IOException
    //   512	517	529	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.d.a
 * JD-Core Version:    0.7.0.1
 */