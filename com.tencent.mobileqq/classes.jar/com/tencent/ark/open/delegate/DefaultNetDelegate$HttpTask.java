package com.tencent.ark.open.delegate;

import android.os.AsyncTask;

class DefaultNetDelegate$HttpTask
  extends AsyncTask<DefaultNetDelegate.HttpParam, Void, Void>
{
  /* Error */
  static void httpRequest(DefaultNetDelegate.HttpParam paramHttpParam)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 18	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: getfield 24	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:url	Ljava/lang/String;
    //   10: invokespecial 27	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 31	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 33	java/net/HttpURLConnection
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 37	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:headers	Ljava/util/Map;
    //   24: ifnull +68 -> 92
    //   27: aload_0
    //   28: getfield 37	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:headers	Ljava/util/Map;
    //   31: invokeinterface 43 1 0
    //   36: invokeinterface 49 1 0
    //   41: astore 4
    //   43: aload 4
    //   45: invokeinterface 55 1 0
    //   50: ifeq +42 -> 92
    //   53: aload 4
    //   55: invokeinterface 59 1 0
    //   60: checkcast 61	java/util/Map$Entry
    //   63: astore 5
    //   65: aload_2
    //   66: aload 5
    //   68: invokeinterface 64 1 0
    //   73: checkcast 66	java/lang/String
    //   76: aload 5
    //   78: invokeinterface 69 1 0
    //   83: checkcast 66	java/lang/String
    //   86: invokevirtual 73	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: goto -46 -> 43
    //   92: aload_0
    //   93: getfield 77	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:postData	[B
    //   96: ifnull +20 -> 116
    //   99: aload_2
    //   100: ldc 79
    //   102: invokevirtual 82	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: invokevirtual 86	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   109: aload_0
    //   110: getfield 77	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:postData	[B
    //   113: invokevirtual 92	java/io/OutputStream:write	([B)V
    //   116: aload_2
    //   117: invokevirtual 96	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   120: astore_2
    //   121: new 98	java/io/ByteArrayOutputStream
    //   124: dup
    //   125: invokespecial 99	java/io/ByteArrayOutputStream:<init>	()V
    //   128: astore_3
    //   129: ldc 100
    //   131: newarray byte
    //   133: astore 4
    //   135: aload_2
    //   136: aload 4
    //   138: invokevirtual 106	java/io/InputStream:read	([B)I
    //   141: istore_1
    //   142: iload_1
    //   143: iconst_m1
    //   144: if_icmpeq +14 -> 158
    //   147: aload_3
    //   148: aload 4
    //   150: iconst_0
    //   151: iload_1
    //   152: invokevirtual 109	java/io/ByteArrayOutputStream:write	([BII)V
    //   155: goto -20 -> 135
    //   158: aload_0
    //   159: getfield 113	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:callback	Lcom/tencent/ark/open/delegate/IArkDelegateHTTPCallback;
    //   162: iconst_0
    //   163: aload_3
    //   164: invokevirtual 117	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   167: invokeinterface 123 3 0
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 126	java/io/InputStream:close	()V
    //   180: aload_3
    //   181: invokevirtual 127	java/io/ByteArrayOutputStream:close	()V
    //   184: return
    //   185: astore 4
    //   187: aload_2
    //   188: astore_0
    //   189: aload_3
    //   190: astore_2
    //   191: aload 4
    //   193: astore_3
    //   194: goto +124 -> 318
    //   197: astore 4
    //   199: aload_3
    //   200: astore 5
    //   202: aload_2
    //   203: astore_3
    //   204: aload 5
    //   206: astore_2
    //   207: goto +46 -> 253
    //   210: astore_3
    //   211: aconst_null
    //   212: astore 4
    //   214: aload_2
    //   215: astore_0
    //   216: aload 4
    //   218: astore_2
    //   219: goto +99 -> 318
    //   222: astore 4
    //   224: aconst_null
    //   225: astore 5
    //   227: aload_2
    //   228: astore_3
    //   229: aload 5
    //   231: astore_2
    //   232: goto +21 -> 253
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_3
    //   240: astore_0
    //   241: aload 4
    //   243: astore_3
    //   244: goto +74 -> 318
    //   247: astore 4
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_3
    //   252: astore_2
    //   253: ldc 129
    //   255: ldc 131
    //   257: iconst_2
    //   258: anewarray 133	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_0
    //   264: getfield 24	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:url	Ljava/lang/String;
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: aastore
    //   276: invokestatic 141	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokestatic 147	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   282: pop
    //   283: aload_0
    //   284: getfield 113	com/tencent/ark/open/delegate/DefaultNetDelegate$HttpParam:callback	Lcom/tencent/ark/open/delegate/IArkDelegateHTTPCallback;
    //   287: iconst_1
    //   288: aconst_null
    //   289: invokeinterface 123 3 0
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 126	java/io/InputStream:close	()V
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 127	java/io/ByteArrayOutputStream:close	()V
    //   310: return
    //   311: astore 4
    //   313: aload_3
    //   314: astore_0
    //   315: aload 4
    //   317: astore_3
    //   318: aload_0
    //   319: ifnull +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 126	java/io/InputStream:close	()V
    //   326: aload_2
    //   327: ifnull +7 -> 334
    //   330: aload_2
    //   331: invokevirtual 127	java/io/ByteArrayOutputStream:close	()V
    //   334: goto +5 -> 339
    //   337: aload_3
    //   338: athrow
    //   339: goto -2 -> 337
    //   342: astore_0
    //   343: goto -163 -> 180
    //   346: astore_0
    //   347: return
    //   348: astore_0
    //   349: goto -47 -> 302
    //   352: astore_0
    //   353: goto -27 -> 326
    //   356: astore_0
    //   357: goto -23 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramHttpParam	DefaultNetDelegate.HttpParam
    //   141	11	1	i	int
    //   19	312	2	localObject1	java.lang.Object
    //   1	203	3	localObject2	java.lang.Object
    //   210	1	3	localObject3	java.lang.Object
    //   228	110	3	localObject4	java.lang.Object
    //   41	108	4	localObject5	java.lang.Object
    //   185	7	4	localObject6	java.lang.Object
    //   197	1	4	localException1	java.lang.Exception
    //   212	5	4	localObject7	java.lang.Object
    //   222	1	4	localException2	java.lang.Exception
    //   235	7	4	localObject8	java.lang.Object
    //   247	24	4	localException3	java.lang.Exception
    //   311	5	4	localObject9	java.lang.Object
    //   63	167	5	localObject10	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   129	135	185	finally
    //   135	142	185	finally
    //   147	155	185	finally
    //   158	172	185	finally
    //   129	135	197	java/lang/Exception
    //   135	142	197	java/lang/Exception
    //   147	155	197	java/lang/Exception
    //   158	172	197	java/lang/Exception
    //   121	129	210	finally
    //   121	129	222	java/lang/Exception
    //   2	43	235	finally
    //   43	89	235	finally
    //   92	116	235	finally
    //   116	121	235	finally
    //   2	43	247	java/lang/Exception
    //   43	89	247	java/lang/Exception
    //   92	116	247	java/lang/Exception
    //   116	121	247	java/lang/Exception
    //   253	294	311	finally
    //   176	180	342	java/io/IOException
    //   180	184	346	java/io/IOException
    //   306	310	346	java/io/IOException
    //   298	302	348	java/io/IOException
    //   322	326	352	java/io/IOException
    //   330	334	356	java/io/IOException
  }
  
  protected Void doInBackground(DefaultNetDelegate.HttpParam... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return null;
    }
    httpRequest(paramVarArgs[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.DefaultNetDelegate.HttpTask
 * JD-Core Version:    0.7.0.1
 */