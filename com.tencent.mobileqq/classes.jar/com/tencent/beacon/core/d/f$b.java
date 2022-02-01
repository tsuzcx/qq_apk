package com.tencent.beacon.core.d;

import android.content.Context;
import com.tencent.beacon.core.e.e;
import com.tencent.beacon.core.protocol.common.SocketRequestPackage;
import com.tencent.beacon.core.strategy.g;
import com.tencent.beacon.core.wup.b;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class f$b
  extends f
{
  protected Context b;
  
  public f$b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private Map<String, String> a(a parama)
  {
    HashMap localHashMap = new HashMap();
    String str = parama.d();
    if ((str != null) && (!"".equals(str))) {
      localHashMap.put("rid", parama.d());
    }
    parama = g.b(this.b).b();
    if ((parama != null) && (!"".equals(parama))) {
      localHashMap.put("sid", parama);
    }
    localHashMap.put("wup_version", "3.0");
    localHashMap.put("TYPE_COMPRESS", String.valueOf(2));
    localHashMap.put("encr_type", "rsapost");
    parama = g.b(this.b);
    if (parama != null) {
      localHashMap.put("bea_key", parama.c());
    }
    return localHashMap;
  }
  
  private void a(d paramd, long paramLong, int paramInt)
  {
    long l = new Date().getTime();
    if (paramd != null) {
      paramd.a(paramInt, l - paramLong);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    paramString1 = paramString2 + ", url: " + paramString1 + ", tryTime: " + paramInt;
    i.a(this.b).a(paramString3, paramString1, paramThrowable);
  }
  
  private void a(String paramString, d paramd, int paramInt, long paramLong)
  {
    if (paramd != null) {
      paramd.a(paramString, paramLong, e.b(this.b), paramInt);
    }
  }
  
  private void a(byte[] paramArrayOfByte, Socket paramSocket, a parama)
  {
    String str = parama.d();
    com.tencent.beacon.core.e.d.a("[net] %s:%d send data[%d] to server.  rid:%s", new Object[] { paramSocket.getLocalAddress().getHostName(), Integer.valueOf(paramSocket.getLocalPort()), Integer.valueOf(paramArrayOfByte.length), str });
    SocketRequestPackage localSocketRequestPackage = new SocketRequestPackage(a(parama), paramArrayOfByte);
    parama = new b();
    localSocketRequestPackage.writeTo(parama);
    paramSocket = paramSocket.getOutputStream();
    parama = parama.b();
    int i = parama.length;
    com.tencent.beacon.core.e.d.a("[net] send header + data[%d] = %d   rid:%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i), str });
    paramSocket.write(a(parama, i));
    paramSocket.flush();
  }
  
  private byte[] a(Socket paramSocket, String paramString)
  {
    com.tencent.beacon.core.e.d.a("[net] begin waiting server response.  rid:%s", new Object[] { paramString });
    paramSocket = paramSocket.getInputStream();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = paramSocket.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    com.tencent.beacon.core.e.d.a("[net] server response length: %d [need >= 4]   rid: %s", new Object[] { Integer.valueOf(arrayOfByte.length), paramString });
    paramString = ByteBuffer.allocate(arrayOfByte.length - 4);
    paramString.put(arrayOfByte, 2, arrayOfByte.length - 4);
    paramString = paramString.array();
    localByteArrayOutputStream.close();
    paramSocket.close();
    return paramString;
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putShort((short)(i & 0xFFFF));
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.put((byte)13);
    localByteBuffer.put((byte)10);
    if (paramInt >= 65532) {
      com.tencent.beacon.core.e.d.b("[Error] send bytes exceed 64kB will failure!", new Object[0]);
    }
    return localByteBuffer.array();
  }
  
  public boolean a()
  {
    return true;
  }
  
  /* Error */
  public byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: iload_2
    //   5: ifgt +15 -> 20
    //   8: ldc_w 263
    //   11: iconst_0
    //   12: anewarray 124	java/lang/Object
    //   15: invokestatic 251	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload 4
    //   22: invokevirtual 25	com/tencent/beacon/core/d/a:d	()Ljava/lang/String;
    //   25: astore 16
    //   27: ldc_w 265
    //   30: iconst_4
    //   31: anewarray 124	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload 4
    //   38: getfield 268	com/tencent/beacon/core/d/a:a	I
    //   41: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload 4
    //   49: getfield 270	com/tencent/beacon/core/d/a:b	I
    //   52: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: aload 4
    //   60: getfield 273	com/tencent/beacon/core/d/a:e	I
    //   63: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: aload 16
    //   71: aastore
    //   72: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: new 87	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   82: astore 17
    //   84: iconst_0
    //   85: istore 6
    //   87: iload 6
    //   89: iconst_1
    //   90: iadd
    //   91: istore 7
    //   93: iload 6
    //   95: iconst_3
    //   96: if_icmpgt +543 -> 639
    //   99: ldc_w 275
    //   102: iconst_2
    //   103: anewarray 124	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload 7
    //   110: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 16
    //   118: aastore
    //   119: invokestatic 278	com/tencent/beacon/core/e/d:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iload 7
    //   124: iconst_1
    //   125: if_icmple +10 -> 135
    //   128: aload_0
    //   129: ldc2_w 279
    //   132: invokevirtual 283	com/tencent/beacon/core/d/f:a	(J)V
    //   135: aload_3
    //   136: arraylength
    //   137: i2l
    //   138: lstore 8
    //   140: new 87	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   147: aload_1
    //   148: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 285
    //   154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload_2
    //   158: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 18
    //   166: aload_0
    //   167: aload 18
    //   169: aload 5
    //   171: iload 7
    //   173: lload 8
    //   175: invokespecial 287	com/tencent/beacon/core/d/f$b:a	(Ljava/lang/String;Lcom/tencent/beacon/core/d/d;IJ)V
    //   178: new 74	java/util/Date
    //   181: dup
    //   182: invokespecial 75	java/util/Date:<init>	()V
    //   185: invokevirtual 79	java/util/Date:getTime	()J
    //   188: lstore 8
    //   190: aload_1
    //   191: invokestatic 291	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   194: astore 11
    //   196: ldc_w 293
    //   199: iconst_3
    //   200: anewarray 124	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload 11
    //   207: invokevirtual 296	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: iload_2
    //   214: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: dup
    //   219: iconst_2
    //   220: aload 16
    //   222: aastore
    //   223: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aconst_null
    //   227: astore 13
    //   229: aconst_null
    //   230: astore 14
    //   232: aconst_null
    //   233: astore 15
    //   235: aconst_null
    //   236: astore 12
    //   238: new 126	java/net/Socket
    //   241: dup
    //   242: aload 11
    //   244: invokevirtual 296	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   247: iload_2
    //   248: invokespecial 299	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   251: astore 11
    //   253: aload 11
    //   255: sipush 30000
    //   258: invokevirtual 303	java/net/Socket:setSoTimeout	(I)V
    //   261: aload_0
    //   262: aload_3
    //   263: aload 11
    //   265: aload 4
    //   267: invokespecial 305	com/tencent/beacon/core/d/f$b:a	([BLjava/net/Socket;Lcom/tencent/beacon/core/d/a;)V
    //   270: aload_0
    //   271: aload 11
    //   273: aload 16
    //   275: invokespecial 307	com/tencent/beacon/core/d/f$b:a	(Ljava/net/Socket;Ljava/lang/String;)[B
    //   278: astore 12
    //   280: ldc_w 309
    //   283: iconst_1
    //   284: anewarray 124	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload 16
    //   291: aastore
    //   292: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload 11
    //   297: invokevirtual 310	java/net/Socket:close	()V
    //   300: aload 12
    //   302: ifnonnull +329 -> 631
    //   305: iconst_0
    //   306: istore 6
    //   308: aload_0
    //   309: aload 5
    //   311: lload 8
    //   313: iload 6
    //   315: invokespecial 312	com/tencent/beacon/core/d/f$b:a	(Lcom/tencent/beacon/core/d/d;JI)V
    //   318: aload 12
    //   320: ifnull +367 -> 687
    //   323: aload 12
    //   325: areturn
    //   326: astore 13
    //   328: aload 11
    //   330: astore 12
    //   332: aload 12
    //   334: astore 11
    //   336: aload 13
    //   338: instanceof 261
    //   341: istore 10
    //   343: iload 10
    //   345: ifeq +226 -> 571
    //   348: aload 12
    //   350: astore 11
    //   352: aload_0
    //   353: aload 18
    //   355: iload 7
    //   357: ldc_w 314
    //   360: ldc_w 316
    //   363: aload 13
    //   365: invokespecial 318	com/tencent/beacon/core/d/f$b:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: aload 12
    //   370: astore 11
    //   372: aload 17
    //   374: ldc_w 285
    //   377: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 13
    //   382: invokevirtual 321	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: ldc_w 309
    //   392: iconst_1
    //   393: anewarray 124	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: aload 16
    //   400: aastore
    //   401: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload 12
    //   406: ifnull +8 -> 414
    //   409: aload 12
    //   411: invokevirtual 310	java/net/Socket:close	()V
    //   414: aconst_null
    //   415: astore 12
    //   417: goto -117 -> 300
    //   420: astore 12
    //   422: aload 11
    //   424: astore 12
    //   426: aload 12
    //   428: astore 11
    //   430: aload 17
    //   432: iload 7
    //   434: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: astore 13
    //   439: aload 12
    //   441: astore 11
    //   443: aload 13
    //   445: ldc_w 323
    //   448: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc_w 309
    //   455: iconst_1
    //   456: anewarray 124	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 16
    //   463: aastore
    //   464: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload 12
    //   469: ifnull -55 -> 414
    //   472: goto -63 -> 409
    //   475: astore 13
    //   477: aload 11
    //   479: astore 12
    //   481: aload 5
    //   483: ifnull +14 -> 497
    //   486: aload 12
    //   488: astore 11
    //   490: aload 5
    //   492: invokeinterface 325 1 0
    //   497: aload 12
    //   499: astore 11
    //   501: aload_0
    //   502: aload 18
    //   504: iload 7
    //   506: ldc_w 327
    //   509: ldc_w 329
    //   512: aload 13
    //   514: invokespecial 318	com/tencent/beacon/core/d/f$b:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload 12
    //   519: astore 11
    //   521: aload 17
    //   523: iload 7
    //   525: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: astore 13
    //   530: aload 12
    //   532: astore 11
    //   534: aload 13
    //   536: ldc_w 331
    //   539: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: ldc_w 309
    //   546: iconst_1
    //   547: anewarray 124	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: aload 16
    //   554: aastore
    //   555: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   558: aload 12
    //   560: ifnull -146 -> 414
    //   563: goto -154 -> 409
    //   566: astore 13
    //   568: goto -236 -> 332
    //   571: aload 12
    //   573: astore 11
    //   575: aload_0
    //   576: aload 18
    //   578: iload 7
    //   580: ldc_w 333
    //   583: ldc_w 335
    //   586: aload 13
    //   588: invokespecial 318	com/tencent/beacon/core/d/f$b:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   591: goto -223 -> 368
    //   594: astore_1
    //   595: ldc_w 309
    //   598: iconst_1
    //   599: anewarray 124	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload 16
    //   606: aastore
    //   607: invokestatic 149	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload 11
    //   612: ifnull +8 -> 620
    //   615: aload 11
    //   617: invokevirtual 310	java/net/Socket:close	()V
    //   620: aload_1
    //   621: athrow
    //   622: astore 13
    //   624: aload 14
    //   626: astore 12
    //   628: goto -147 -> 481
    //   631: aload 12
    //   633: arraylength
    //   634: istore 6
    //   636: goto -328 -> 308
    //   639: new 257	java/net/ConnectException
    //   642: dup
    //   643: aload 17
    //   645: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokespecial 338	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   651: athrow
    //   652: astore 11
    //   654: goto -354 -> 300
    //   657: astore 11
    //   659: goto -245 -> 414
    //   662: astore_3
    //   663: goto -43 -> 620
    //   666: astore_1
    //   667: goto -72 -> 595
    //   670: astore 11
    //   672: aload 13
    //   674: astore 12
    //   676: goto -250 -> 426
    //   679: astore_1
    //   680: aload 15
    //   682: astore 11
    //   684: goto -89 -> 595
    //   687: iload 7
    //   689: istore 6
    //   691: goto -604 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	this	b
    //   0	694	1	paramString	String
    //   0	694	2	paramInt	int
    //   0	694	3	paramArrayOfByte	byte[]
    //   0	694	4	parama	a
    //   0	694	5	paramd	d
    //   85	605	6	i	int
    //   91	597	7	j	int
    //   138	174	8	l	long
    //   341	3	10	bool	boolean
    //   194	422	11	localObject1	Object
    //   652	1	11	localIOException1	java.io.IOException
    //   657	1	11	localIOException2	java.io.IOException
    //   670	1	11	localConnectException1	java.net.ConnectException
    //   682	1	11	localObject2	Object
    //   236	180	12	localObject3	Object
    //   420	1	12	localConnectException2	java.net.ConnectException
    //   424	251	12	localObject4	Object
    //   227	1	13	localObject5	Object
    //   326	55	13	localException1	java.lang.Exception
    //   437	7	13	localStringBuilder1	java.lang.StringBuilder
    //   475	38	13	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   528	7	13	localStringBuilder2	java.lang.StringBuilder
    //   566	21	13	localException2	java.lang.Exception
    //   622	51	13	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   230	395	14	localObject6	Object
    //   233	448	15	localObject7	Object
    //   25	580	16	str1	String
    //   82	562	17	localStringBuilder3	java.lang.StringBuilder
    //   164	413	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   253	280	326	java/lang/Exception
    //   253	280	420	java/net/ConnectException
    //   253	280	475	java/net/SocketTimeoutException
    //   238	253	566	java/lang/Exception
    //   336	343	594	finally
    //   352	368	594	finally
    //   372	389	594	finally
    //   430	439	594	finally
    //   443	452	594	finally
    //   490	497	594	finally
    //   501	517	594	finally
    //   521	530	594	finally
    //   534	543	594	finally
    //   575	591	594	finally
    //   238	253	622	java/net/SocketTimeoutException
    //   295	300	652	java/io/IOException
    //   409	414	657	java/io/IOException
    //   615	620	662	java/io/IOException
    //   253	280	666	finally
    //   238	253	670	java/net/ConnectException
    //   238	253	679	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.f.b
 * JD-Core Version:    0.7.0.1
 */