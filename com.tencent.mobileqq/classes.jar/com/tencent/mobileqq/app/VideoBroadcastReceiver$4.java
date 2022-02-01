package com.tencent.mobileqq.app;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;

class VideoBroadcastReceiver$4
  implements INetEngineListener
{
  VideoBroadcastReceiver$4(VideoBroadcastReceiver paramVideoBroadcastReceiver) {}
  
  /* Error */
  public void onResp(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: ifnonnull +8 -> 14
    //   9: aconst_null
    //   10: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   13: return
    //   14: aload_3
    //   15: astore_2
    //   16: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +122 -> 141
    //   22: aload_3
    //   23: astore_2
    //   24: getstatic 37	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Ljava/lang/String;
    //   27: astore 5
    //   29: aload_3
    //   30: astore_2
    //   31: new 39	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   38: astore 6
    //   40: aload_3
    //   41: astore_2
    //   42: aload 6
    //   44: ldc 42
    //   46: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: astore_2
    //   52: aload 6
    //   54: aload_1
    //   55: getfield 52	com/tencent/mobileqq/transfile/NetResp:mHttpCode	I
    //   58: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: astore_2
    //   64: aload 6
    //   66: ldc 57
    //   68: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: astore_2
    //   74: aload 6
    //   76: aload_1
    //   77: getfield 60	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   80: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: astore_2
    //   86: aload 6
    //   88: ldc 62
    //   90: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: astore_2
    //   96: aload 6
    //   98: aload_1
    //   99: getfield 65	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   102: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_3
    //   107: astore_2
    //   108: aload 6
    //   110: ldc 67
    //   112: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: astore_2
    //   118: aload 6
    //   120: aload_1
    //   121: getfield 70	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   124: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: astore_2
    //   130: aload 5
    //   132: iconst_2
    //   133: aload 6
    //   135: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_3
    //   142: astore_2
    //   143: aload_1
    //   144: getfield 82	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   147: getfield 88	com/tencent/mobileqq/transfile/NetReq:mOutStream	Ljava/io/OutputStream;
    //   150: instanceof 90
    //   153: ifeq +81 -> 234
    //   156: aload_3
    //   157: astore_2
    //   158: aload_1
    //   159: getfield 82	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   162: getfield 88	com/tencent/mobileqq/transfile/NetReq:mOutStream	Ljava/io/OutputStream;
    //   165: checkcast 90	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream
    //   168: astore_1
    //   169: aload_1
    //   170: ifnonnull +8 -> 178
    //   173: aload_1
    //   174: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   177: return
    //   178: aload_1
    //   179: invokevirtual 91	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream:toString	()Ljava/lang/String;
    //   182: astore_2
    //   183: getstatic 37	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Ljava/lang/String;
    //   186: astore_3
    //   187: new 39	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   194: astore 4
    //   196: aload 4
    //   198: ldc 93
    //   200: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: aload_2
    //   207: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: iconst_2
    //   213: aload 4
    //   215: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto +15 -> 236
    //   224: astore_3
    //   225: aload_1
    //   226: astore_2
    //   227: goto +33 -> 260
    //   230: astore_3
    //   231: goto +18 -> 249
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   240: return
    //   241: astore_3
    //   242: goto +18 -> 260
    //   245: astore_3
    //   246: aload 4
    //   248: astore_1
    //   249: aload_1
    //   250: astore_2
    //   251: aload_3
    //   252: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   255: aload_1
    //   256: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   259: return
    //   260: aload_2
    //   261: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   264: aload_3
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	4
    //   0	266	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   15	246	2	localObject1	Object
    //   4	208	3	str1	java.lang.String
    //   224	1	3	localObject2	Object
    //   230	1	3	localException1	java.lang.Exception
    //   241	1	3	localObject3	Object
    //   245	20	3	localException2	java.lang.Exception
    //   1	246	4	localStringBuilder1	java.lang.StringBuilder
    //   27	104	5	str2	java.lang.String
    //   38	96	6	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   178	221	224	finally
    //   178	221	230	java/lang/Exception
    //   16	22	241	finally
    //   24	29	241	finally
    //   31	40	241	finally
    //   42	50	241	finally
    //   52	62	241	finally
    //   64	72	241	finally
    //   74	84	241	finally
    //   86	94	241	finally
    //   96	106	241	finally
    //   108	116	241	finally
    //   118	128	241	finally
    //   130	141	241	finally
    //   143	156	241	finally
    //   158	169	241	finally
    //   251	255	241	finally
    //   16	22	245	java/lang/Exception
    //   24	29	245	java/lang/Exception
    //   31	40	245	java/lang/Exception
    //   42	50	245	java/lang/Exception
    //   52	62	245	java/lang/Exception
    //   64	72	245	java/lang/Exception
    //   74	84	245	java/lang/Exception
    //   86	94	245	java/lang/Exception
    //   96	106	245	java/lang/Exception
    //   108	116	245	java/lang/Exception
    //   118	128	245	java/lang/Exception
    //   130	141	245	java/lang/Exception
    //   143	156	245	java/lang/Exception
    //   158	169	245	java/lang/Exception
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver.4
 * JD-Core Version:    0.7.0.1
 */