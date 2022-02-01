package com.tencent.luggage.opensdk;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.rr.c;

final class m$2
  implements com.tencent.luggage.wxa.rl.b<c<String, Bitmap>, String>
{
  m$2(com.tencent.luggage.wxa.iu.b paramb, f paramf) {}
  
  /* Error */
  public c<String, Bitmap> a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/luggage/opensdk/m$2:a	Lcom/tencent/luggage/wxa/iu/b;
    //   4: invokevirtual 32	com/tencent/luggage/wxa/iu/b:d	()Z
    //   7: ifne +22 -> 29
    //   10: invokestatic 37	com/tencent/luggage/wxa/ro/h:b	()Lcom/tencent/luggage/wxa/ro/b;
    //   13: new 39	java/lang/InterruptedException
    //   16: dup
    //   17: ldc 41
    //   19: invokespecial 44	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   22: invokeinterface 49 2 0
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: getfield 15	com/tencent/luggage/opensdk/m$2:a	Lcom/tencent/luggage/wxa/iu/b;
    //   33: ldc 51
    //   35: invokevirtual 54	com/tencent/luggage/wxa/iu/b:a	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/b;
    //   38: checkcast 51	com/tencent/luggage/wxa/kz/b
    //   41: invokestatic 59	com/tencent/luggage/wxa/kz/b$a:a	(Lcom/tencent/luggage/wxa/kz/b;)Lcom/tencent/luggage/wxa/kz/b;
    //   44: astore_2
    //   45: new 61	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 62	org/json/JSONObject:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: ldc 64
    //   56: aload_0
    //   57: getfield 15	com/tencent/luggage/opensdk/m$2:a	Lcom/tencent/luggage/wxa/iu/b;
    //   60: invokevirtual 68	com/tencent/luggage/wxa/iu/b:getAppId	()Ljava/lang/String;
    //   63: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_3
    //   68: ldc 74
    //   70: aload_1
    //   71: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: new 76	okhttp3/Request$Builder
    //   78: dup
    //   79: invokespecial 77	okhttp3/Request$Builder:<init>	()V
    //   82: ldc 79
    //   84: invokevirtual 83	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   87: getstatic 88	com/tencent/luggage/wxa/dc/g:a	Lokhttp3/MediaType;
    //   90: aload_3
    //   91: invokevirtual 91	org/json/JSONObject:toString	()Ljava/lang/String;
    //   94: invokestatic 97	okhttp3/RequestBody:create	(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;
    //   97: invokevirtual 101	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   100: invokevirtual 105	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   103: astore_3
    //   104: invokestatic 109	com/tencent/luggage/wxa/dc/g:cgiClient	()Lokhttp3/OkHttpClient;
    //   107: aload_3
    //   108: invokevirtual 115	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   111: invokeinterface 121 1 0
    //   116: astore_3
    //   117: aload_1
    //   118: aload_2
    //   119: aload_3
    //   120: invokevirtual 127	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   123: invokevirtual 133	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   126: aconst_null
    //   127: new 135	android/graphics/BitmapFactory$Options
    //   130: dup
    //   131: invokespecial 136	android/graphics/BitmapFactory$Options:<init>	()V
    //   134: invokeinterface 139 4 0
    //   139: invokestatic 144	com/tencent/luggage/wxa/rr/a:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   142: astore_1
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 147	okhttp3/Response:close	()V
    //   151: aload_1
    //   152: areturn
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: goto +7 -> 163
    //   159: astore_1
    //   160: aload_1
    //   161: athrow
    //   162: astore_2
    //   163: aload_3
    //   164: ifnull +18 -> 182
    //   167: aload_1
    //   168: ifnull +10 -> 178
    //   171: aload_3
    //   172: invokevirtual 147	okhttp3/Response:close	()V
    //   175: goto +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 147	okhttp3/Response:close	()V
    //   182: aload_2
    //   183: athrow
    //   184: astore_1
    //   185: ldc 149
    //   187: ldc 151
    //   189: iconst_3
    //   190: anewarray 5	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: getfield 17	com/tencent/luggage/opensdk/m$2:b	Lcom/tencent/luggage/opensdk/f;
    //   199: invokevirtual 155	com/tencent/luggage/opensdk/f:d	()Ljava/lang/String;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_0
    //   206: getfield 15	com/tencent/luggage/opensdk/m$2:a	Lcom/tencent/luggage/wxa/iu/b;
    //   209: invokevirtual 68	com/tencent/luggage/wxa/iu/b:getAppId	()Ljava/lang/String;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: aload_1
    //   216: aastore
    //   217: invokestatic 160	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: invokestatic 37	com/tencent/luggage/wxa/ro/h:b	()Lcom/tencent/luggage/wxa/ro/b;
    //   223: aload_1
    //   224: invokeinterface 49 2 0
    //   229: aconst_null
    //   230: areturn
    //   231: astore_1
    //   232: goto -50 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	2
    //   0	235	1	paramString	String
    //   44	75	2	localb	com.tencent.luggage.wxa.kz.b
    //   153	1	2	localObject1	Object
    //   162	21	2	localObject2	Object
    //   52	127	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   117	143	153	finally
    //   117	143	159	java/lang/Throwable
    //   160	162	162	finally
    //   45	117	184	java/lang/Exception
    //   147	151	184	java/lang/Exception
    //   171	175	184	java/lang/Exception
    //   178	182	184	java/lang/Exception
    //   182	184	184	java/lang/Exception
    //   171	175	231	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.2
 * JD-Core Version:    0.7.0.1
 */