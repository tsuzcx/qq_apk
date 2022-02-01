package com.tencent.crossengine.net;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class OkHttpNetworkManager$1
  implements Callback
{
  OkHttpNetworkManager$1(OkHttpNetworkManager paramOkHttpNetworkManager, NetworkManager.Callback paramCallback, long[] paramArrayOfLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback;
    if (paramCall != null) {
      paramCall.onError(paramIOException.getMessage());
    }
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager	Lcom/tencent/crossengine/net/OkHttpNetworkManager;
    //   4: aload_2
    //   5: invokestatic 43	com/tencent/crossengine/net/OkHttpNetworkManager:a	(Lcom/tencent/crossengine/net/OkHttpNetworkManager;Lokhttp3/Response;)Ljava/util/List;
    //   8: astore 11
    //   10: aload_0
    //   11: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   14: astore 10
    //   16: aload 10
    //   18: ifnull +10 -> 28
    //   21: aload 10
    //   23: aload 11
    //   25: invokevirtual 47	com/tencent/crossengine/net/NetworkManager$Callback:onHeader	(Ljava/util/List;)V
    //   28: aload_2
    //   29: invokevirtual 53	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   32: astore 10
    //   34: iconst_2
    //   35: istore 4
    //   37: aload 10
    //   39: ifnull +330 -> 369
    //   42: sipush 8192
    //   45: newarray byte
    //   47: astore 12
    //   49: aload_2
    //   50: invokevirtual 53	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   53: invokevirtual 59	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   56: astore 10
    //   58: aload_0
    //   59: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   62: iconst_2
    //   63: aload_2
    //   64: invokevirtual 53	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   67: invokevirtual 63	okhttp3/ResponseBody:contentLength	()J
    //   70: lastore
    //   71: aload 10
    //   73: aload 12
    //   75: invokevirtual 69	java/io/InputStream:read	([B)I
    //   78: istore_3
    //   79: iload_3
    //   80: ifle +128 -> 208
    //   83: aload_0
    //   84: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   87: ifnull -16 -> 71
    //   90: aload_0
    //   91: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   94: aload 12
    //   96: iload_3
    //   97: invokevirtual 73	com/tencent/crossengine/net/NetworkManager$Callback:writeResponseContent	([BI)J
    //   100: lstore 6
    //   102: iload_3
    //   103: i2l
    //   104: lstore 8
    //   106: lload 6
    //   108: lload 8
    //   110: lcmp
    //   111: iflt +54 -> 165
    //   114: aload_0
    //   115: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   118: astore 13
    //   120: aload 13
    //   122: iconst_3
    //   123: aload 13
    //   125: iconst_3
    //   126: laload
    //   127: lload 8
    //   129: ladd
    //   130: lastore
    //   131: aload_0
    //   132: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   135: aload_0
    //   136: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   139: iconst_3
    //   140: laload
    //   141: aload_0
    //   142: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   145: iconst_2
    //   146: laload
    //   147: aload_0
    //   148: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   151: iconst_1
    //   152: laload
    //   153: aload_0
    //   154: getfield 18	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ArrayOfLong	[J
    //   157: iconst_0
    //   158: laload
    //   159: invokevirtual 77	com/tencent/crossengine/net/NetworkManager$Callback:onProgress	(JJJJ)V
    //   162: goto -91 -> 71
    //   165: new 79	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   172: astore 11
    //   174: aload 11
    //   176: ldc 82
    //   178: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 11
    //   184: aload_2
    //   185: invokevirtual 90	okhttp3/Response:request	()Lokhttp3/Request;
    //   188: invokevirtual 96	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   191: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: new 26	java/io/IOException
    //   198: dup
    //   199: aload 11
    //   201: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokespecial 104	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: aload_0
    //   209: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   212: astore 12
    //   214: aload 12
    //   216: ifnull +11 -> 227
    //   219: aload 12
    //   221: aconst_null
    //   222: iconst_0
    //   223: invokevirtual 73	com/tencent/crossengine/net/NetworkManager$Callback:writeResponseContent	([BI)J
    //   226: pop2
    //   227: aload 10
    //   229: ifnull +140 -> 369
    //   232: aload 10
    //   234: invokevirtual 107	java/io/InputStream:close	()V
    //   237: goto +132 -> 369
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   247: goto +122 -> 369
    //   250: astore_2
    //   251: aload 10
    //   253: astore_1
    //   254: goto +70 -> 324
    //   257: astore 11
    //   259: aload 10
    //   261: astore_2
    //   262: aload 11
    //   264: astore 10
    //   266: goto +13 -> 279
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_2
    //   272: goto +60 -> 332
    //   275: astore 10
    //   277: aconst_null
    //   278: astore_2
    //   279: aload_0
    //   280: aload_1
    //   281: aload 10
    //   283: invokevirtual 112	com/tencent/crossengine/net/OkHttpNetworkManager$1:onFailure	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   286: aload_0
    //   287: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +10 -> 302
    //   295: aload_1
    //   296: aconst_null
    //   297: iconst_0
    //   298: invokevirtual 73	com/tencent/crossengine/net/NetworkManager$Callback:writeResponseContent	([BI)J
    //   301: pop2
    //   302: aload_2
    //   303: ifnull +13 -> 316
    //   306: aload_2
    //   307: invokevirtual 107	java/io/InputStream:close	()V
    //   310: return
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   316: return
    //   317: astore 10
    //   319: aload_2
    //   320: astore_1
    //   321: aload 10
    //   323: astore_2
    //   324: aload_2
    //   325: astore 10
    //   327: aload_1
    //   328: astore_2
    //   329: aload 10
    //   331: astore_1
    //   332: aload_0
    //   333: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   336: astore 10
    //   338: aload 10
    //   340: ifnull +11 -> 351
    //   343: aload 10
    //   345: aconst_null
    //   346: iconst_0
    //   347: invokevirtual 73	com/tencent/crossengine/net/NetworkManager$Callback:writeResponseContent	([BI)J
    //   350: pop2
    //   351: aload_2
    //   352: ifnull +15 -> 367
    //   355: aload_2
    //   356: invokevirtual 107	java/io/InputStream:close	()V
    //   359: goto +8 -> 367
    //   362: astore_2
    //   363: aload_2
    //   364: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   367: aload_1
    //   368: athrow
    //   369: aload_0
    //   370: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   373: ifnull +82 -> 455
    //   376: getstatic 117	com/tencent/crossengine/net/OkHttpNetworkManager$6:a	[I
    //   379: aload_2
    //   380: invokevirtual 121	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   383: invokevirtual 127	okhttp3/Protocol:ordinal	()I
    //   386: iaload
    //   387: istore 5
    //   389: iload 5
    //   391: iconst_1
    //   392: if_icmpeq +35 -> 427
    //   395: iload 4
    //   397: istore_3
    //   398: iload 5
    //   400: iconst_2
    //   401: if_icmpeq +28 -> 429
    //   404: iload 5
    //   406: iconst_3
    //   407: if_icmpeq +15 -> 422
    //   410: iload 5
    //   412: iconst_4
    //   413: if_icmpeq +9 -> 422
    //   416: iload 4
    //   418: istore_3
    //   419: goto +10 -> 429
    //   422: iconst_3
    //   423: istore_3
    //   424: goto +5 -> 429
    //   427: iconst_1
    //   428: istore_3
    //   429: aload_0
    //   430: getfield 16	com/tencent/crossengine/net/OkHttpNetworkManager$1:jdField_a_of_type_ComTencentCrossengineNetNetworkManager$Callback	Lcom/tencent/crossengine/net/NetworkManager$Callback;
    //   433: aload_1
    //   434: invokeinterface 130 1 0
    //   439: invokevirtual 96	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   442: invokevirtual 133	okhttp3/HttpUrl:toString	()Ljava/lang/String;
    //   445: aload_2
    //   446: invokevirtual 136	okhttp3/Response:code	()I
    //   449: aload 11
    //   451: iload_3
    //   452: invokevirtual 139	com/tencent/crossengine/net/NetworkManager$Callback:onResponse	(Ljava/lang/String;ILjava/util/List;I)V
    //   455: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	1
    //   0	456	1	paramCall	Call
    //   0	456	2	paramResponse	okhttp3.Response
    //   78	374	3	i	int
    //   35	382	4	j	int
    //   387	27	5	k	int
    //   100	7	6	l1	long
    //   104	24	8	l2	long
    //   14	219	10	localObject1	Object
    //   240	20	10	localIOException1	IOException
    //   264	1	10	localIOException2	IOException
    //   275	7	10	localIOException3	IOException
    //   317	5	10	localObject2	Object
    //   325	19	10	localObject3	Object
    //   8	192	11	localObject4	Object
    //   257	193	11	localIOException4	IOException
    //   47	173	12	localObject5	Object
    //   118	6	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   232	237	240	java/io/IOException
    //   58	71	250	finally
    //   71	79	250	finally
    //   83	102	250	finally
    //   114	120	250	finally
    //   131	162	250	finally
    //   165	208	250	finally
    //   58	71	257	java/io/IOException
    //   71	79	257	java/io/IOException
    //   83	102	257	java/io/IOException
    //   114	120	257	java/io/IOException
    //   131	162	257	java/io/IOException
    //   165	208	257	java/io/IOException
    //   49	58	269	finally
    //   49	58	275	java/io/IOException
    //   306	310	311	java/io/IOException
    //   279	286	317	finally
    //   355	359	362	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.1
 * JD-Core Version:    0.7.0.1
 */