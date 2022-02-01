package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rr.g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/device/WxaDeviceLogic;", "", "()V", "TAG", "", "activateDevice", "Lcom/tencent/luggage/login/device/IActivateDevice;", "deviceId", "getDeviceId", "()Ljava/lang/String;", "deviceInfo", "Lcom/tencent/luggage/login/device/WxaDeviceInfo;", "hostAppId", "getHostAppId", "productId", "", "getProductId", "()I", "token", "getToken", "username", "getUsername", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "", "force", "activateDeviceImpl", "checkDeviceTokenSync", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "extraData", "checkTokenValid", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "doCheckToken", "hasActivateDevice", "hasIlinkInit", "initActivateDevice", "", "isActivate", "isDeviceAlive", "isExpired", "notifyActivateDevice", "callback", "Lkotlin/Function0;", "refreshDevice", "refreshDeviceSync", "releaseDevice", "reset", "saveDeviceInfo", "syncTime", "expireTime", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class d
{
  public static final d a = new d();
  private static c b = new c();
  private static b c;
  
  static
  {
    b localb = b.b;
    Intrinsics.checkExpressionValueIsNotNull(localb, "IActivateDevice.DUMMY");
    c = localb;
  }
  
  /* Error */
  private final com.tencent.luggage.wxa.rr.c<Boolean, Long> a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: invokestatic 109	com/tencent/luggage/wxa/dc/w:a	()Z
    //   3: istore 8
    //   5: iconst_1
    //   6: istore 7
    //   8: iload 8
    //   10: ifeq +25 -> 35
    //   13: iconst_1
    //   14: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   17: ldc 116
    //   19: i2l
    //   20: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: invokestatic 126	com/tencent/luggage/wxa/rr/c:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   26: astore_1
    //   27: aload_1
    //   28: ldc 128
    //   30: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   33: aload_1
    //   34: areturn
    //   35: ldc 130
    //   37: invokestatic 136	okhttp3/HttpUrl:parse	(Ljava/lang/String;)Lokhttp3/HttpUrl;
    //   40: astore 6
    //   42: aload 6
    //   44: ifnonnull +6 -> 50
    //   47: invokestatic 139	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   50: aload 6
    //   52: invokevirtual 143	okhttp3/HttpUrl:newBuilder	()Lokhttp3/HttpUrl$Builder;
    //   55: astore 6
    //   57: aload 6
    //   59: ldc 144
    //   61: aload_2
    //   62: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   65: pop
    //   66: aload 6
    //   68: ldc 151
    //   70: aload_1
    //   71: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   74: pop
    //   75: aload 6
    //   77: ldc 153
    //   79: iload_3
    //   80: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   86: pop
    //   87: aload 6
    //   89: ldc 160
    //   91: aload 4
    //   93: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   96: pop
    //   97: aload 6
    //   99: ldc 162
    //   101: ldc 164
    //   103: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   106: pop
    //   107: aload 6
    //   109: ldc 166
    //   111: aload 5
    //   113: invokevirtual 150	okhttp3/HttpUrl$Builder:addQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
    //   116: pop
    //   117: aload 6
    //   119: invokevirtual 170	okhttp3/HttpUrl$Builder:build	()Lokhttp3/HttpUrl;
    //   122: invokevirtual 173	okhttp3/HttpUrl:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: aload 6
    //   129: ldc 175
    //   131: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   134: new 177	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   141: astore_1
    //   142: aload_1
    //   143: ldc 180
    //   145: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: aload 6
    //   152: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 186
    //   158: aload_1
    //   159: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 193	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: new 195	okhttp3/Request$Builder
    //   168: dup
    //   169: invokespecial 196	okhttp3/Request$Builder:<init>	()V
    //   172: aload 6
    //   174: invokevirtual 200	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   177: invokevirtual 203	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   180: astore_1
    //   181: invokestatic 209	com/tencent/luggage/wxa/dc/g:get	()Lokhttp3/OkHttpClient;
    //   184: aload_1
    //   185: invokevirtual 215	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   188: invokeinterface 221 1 0
    //   193: checkcast 223	java/io/Closeable
    //   196: astore 5
    //   198: aconst_null
    //   199: astore_2
    //   200: aconst_null
    //   201: checkcast 102	java/lang/Throwable
    //   204: astore 4
    //   206: aload 4
    //   208: astore_1
    //   209: aload 5
    //   211: checkcast 225	okhttp3/Response
    //   214: astore 11
    //   216: aload 4
    //   218: astore_1
    //   219: aload 11
    //   221: invokevirtual 229	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   224: astore 12
    //   226: aload 12
    //   228: ifnonnull +46 -> 274
    //   231: aload 4
    //   233: astore_1
    //   234: ldc 186
    //   236: ldc 231
    //   238: invokestatic 233	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 4
    //   243: astore_1
    //   244: iconst_0
    //   245: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   248: lconst_0
    //   249: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   252: invokestatic 126	com/tencent/luggage/wxa/rr/c:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   255: astore_2
    //   256: aload 4
    //   258: astore_1
    //   259: aload_2
    //   260: ldc 235
    //   262: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   265: aload 5
    //   267: aload 4
    //   269: invokestatic 241	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   272: aload_2
    //   273: areturn
    //   274: aload 4
    //   276: astore_1
    //   277: aload 11
    //   279: invokevirtual 229	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   282: astore 11
    //   284: aload 11
    //   286: ifnull +12 -> 298
    //   289: aload 4
    //   291: astore_1
    //   292: aload 11
    //   294: invokevirtual 246	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   297: astore_2
    //   298: aload 4
    //   300: astore_1
    //   301: new 248	org/json/JSONObject
    //   304: dup
    //   305: aload_2
    //   306: invokespecial 251	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   309: astore 11
    //   311: aload 4
    //   313: astore_1
    //   314: new 177	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   321: astore 12
    //   323: aload 4
    //   325: astore_1
    //   326: aload 12
    //   328: ldc 253
    //   330: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 4
    //   336: astore_1
    //   337: aload 12
    //   339: aload_2
    //   340: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 4
    //   346: astore_1
    //   347: ldc 186
    //   349: aload 12
    //   351: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 193	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 4
    //   359: astore_1
    //   360: aload 11
    //   362: ldc 255
    //   364: iconst_m1
    //   365: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: ifne +305 -> 673
    //   371: goto +3 -> 374
    //   374: aload 4
    //   376: astore_1
    //   377: aload 11
    //   379: ldc_w 261
    //   382: lconst_0
    //   383: invokevirtual 265	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   386: lstore 9
    //   388: lload 9
    //   390: lconst_0
    //   391: lcmp
    //   392: ifgt +144 -> 536
    //   395: aload 4
    //   397: astore_1
    //   398: new 177	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   405: astore 11
    //   407: aload 4
    //   409: astore_1
    //   410: aload 11
    //   412: ldc_w 267
    //   415: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: astore_1
    //   422: aload 11
    //   424: aload 6
    //   426: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 4
    //   432: astore_1
    //   433: aload 11
    //   435: ldc_w 269
    //   438: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 4
    //   444: astore_1
    //   445: aload 11
    //   447: lload 9
    //   449: invokevirtual 272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 4
    //   455: astore_1
    //   456: aload 11
    //   458: ldc_w 274
    //   461: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 4
    //   467: astore_1
    //   468: aload 11
    //   470: aload_2
    //   471: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 4
    //   477: astore_1
    //   478: aload 11
    //   480: ldc_w 276
    //   483: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 4
    //   489: astore_1
    //   490: ldc 186
    //   492: aload 11
    //   494: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 233	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload 4
    //   502: astore_1
    //   503: iconst_0
    //   504: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   507: ldc2_w 277
    //   510: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: invokestatic 126	com/tencent/luggage/wxa/rr/c:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   516: astore_2
    //   517: aload 4
    //   519: astore_1
    //   520: aload_2
    //   521: ldc_w 280
    //   524: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   527: aload 5
    //   529: aload 4
    //   531: invokestatic 241	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   534: aload_2
    //   535: areturn
    //   536: aload 4
    //   538: astore_1
    //   539: iload 7
    //   541: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   544: lload 9
    //   546: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   549: invokestatic 126	com/tencent/luggage/wxa/rr/c:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   552: astore_2
    //   553: aload 4
    //   555: astore_1
    //   556: aload_2
    //   557: ldc_w 282
    //   560: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   563: aload 5
    //   565: aload 4
    //   567: invokestatic 241	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   570: aload_2
    //   571: areturn
    //   572: astore_2
    //   573: aload 4
    //   575: astore_1
    //   576: new 177	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   583: astore 6
    //   585: aload 4
    //   587: astore_1
    //   588: aload 6
    //   590: ldc_w 284
    //   593: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 4
    //   599: astore_1
    //   600: aload 6
    //   602: aload_2
    //   603: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   606: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 4
    //   612: astore_1
    //   613: ldc 186
    //   615: aload 6
    //   617: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 233	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 4
    //   625: astore_1
    //   626: iconst_0
    //   627: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   630: lconst_0
    //   631: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   634: invokestatic 126	com/tencent/luggage/wxa/rr/c:a	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/rr/c;
    //   637: astore_2
    //   638: aload 4
    //   640: astore_1
    //   641: aload_2
    //   642: ldc 235
    //   644: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   647: aload 5
    //   649: aload 4
    //   651: invokestatic 241	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   654: aload_2
    //   655: areturn
    //   656: astore_2
    //   657: goto +8 -> 665
    //   660: astore_2
    //   661: aload_2
    //   662: astore_1
    //   663: aload_2
    //   664: athrow
    //   665: aload 5
    //   667: aload_1
    //   668: invokestatic 241	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   671: aload_2
    //   672: athrow
    //   673: iconst_0
    //   674: istore 7
    //   676: goto -302 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	d
    //   0	679	1	paramString1	String
    //   0	679	2	paramString2	String
    //   0	679	3	paramInt	int
    //   0	679	4	paramString3	String
    //   0	679	5	paramString4	String
    //   0	679	6	paramString5	String
    //   6	669	7	bool1	boolean
    //   3	6	8	bool2	boolean
    //   386	159	9	l	long
    //   214	279	11	localObject1	Object
    //   224	126	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   277	284	572	java/lang/Exception
    //   292	298	572	java/lang/Exception
    //   301	311	572	java/lang/Exception
    //   314	323	572	java/lang/Exception
    //   326	334	572	java/lang/Exception
    //   337	344	572	java/lang/Exception
    //   347	357	572	java/lang/Exception
    //   360	371	572	java/lang/Exception
    //   377	388	572	java/lang/Exception
    //   398	407	572	java/lang/Exception
    //   410	419	572	java/lang/Exception
    //   422	430	572	java/lang/Exception
    //   433	442	572	java/lang/Exception
    //   445	453	572	java/lang/Exception
    //   456	465	572	java/lang/Exception
    //   468	475	572	java/lang/Exception
    //   478	487	572	java/lang/Exception
    //   490	500	572	java/lang/Exception
    //   503	517	572	java/lang/Exception
    //   520	527	572	java/lang/Exception
    //   527	534	572	java/lang/Exception
    //   539	553	572	java/lang/Exception
    //   556	563	572	java/lang/Exception
    //   563	570	572	java/lang/Exception
    //   209	216	656	finally
    //   219	226	656	finally
    //   234	241	656	finally
    //   244	256	656	finally
    //   259	265	656	finally
    //   277	284	656	finally
    //   292	298	656	finally
    //   301	311	656	finally
    //   314	323	656	finally
    //   326	334	656	finally
    //   337	344	656	finally
    //   347	357	656	finally
    //   360	371	656	finally
    //   377	388	656	finally
    //   398	407	656	finally
    //   410	419	656	finally
    //   422	430	656	finally
    //   433	442	656	finally
    //   445	453	656	finally
    //   456	465	656	finally
    //   468	475	656	finally
    //   478	487	656	finally
    //   490	500	656	finally
    //   503	517	656	finally
    //   520	527	656	finally
    //   539	553	656	finally
    //   556	563	656	finally
    //   576	585	656	finally
    //   588	597	656	finally
    //   600	610	656	finally
    //   613	623	656	finally
    //   626	638	656	finally
    //   641	647	656	finally
    //   663	665	656	finally
    //   209	216	660	java/lang/Throwable
    //   219	226	660	java/lang/Throwable
    //   234	241	660	java/lang/Throwable
    //   244	256	660	java/lang/Throwable
    //   259	265	660	java/lang/Throwable
    //   277	284	660	java/lang/Throwable
    //   292	298	660	java/lang/Throwable
    //   301	311	660	java/lang/Throwable
    //   314	323	660	java/lang/Throwable
    //   326	334	660	java/lang/Throwable
    //   337	344	660	java/lang/Throwable
    //   347	357	660	java/lang/Throwable
    //   360	371	660	java/lang/Throwable
    //   377	388	660	java/lang/Throwable
    //   398	407	660	java/lang/Throwable
    //   410	419	660	java/lang/Throwable
    //   422	430	660	java/lang/Throwable
    //   433	442	660	java/lang/Throwable
    //   445	453	660	java/lang/Throwable
    //   456	465	660	java/lang/Throwable
    //   468	475	660	java/lang/Throwable
    //   478	487	660	java/lang/Throwable
    //   490	500	660	java/lang/Throwable
    //   503	517	660	java/lang/Throwable
    //   520	527	660	java/lang/Throwable
    //   539	553	660	java/lang/Throwable
    //   556	563	660	java/lang/Throwable
    //   576	585	660	java/lang/Throwable
    //   588	597	660	java/lang/Throwable
    //   600	610	660	java/lang/Throwable
    //   613	623	660	java/lang/Throwable
    //   626	638	660	java/lang/Throwable
    //   641	647	660	java/lang/Throwable
  }
  
  private final void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String paramString5)
  {
    b.a(paramInt, paramString1, paramString2, paramString3, System.currentTimeMillis(), paramLong2, paramString4, paramString5);
  }
  
  private final boolean a(Integer paramInteger, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInteger == null) || (paramInteger.intValue() != -1))
    {
      int i;
      if ((paramString1 != null) && (((CharSequence)paramString1).length() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((paramString2 != null) && (((CharSequence)paramString2).length() > 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((paramString3 != null) && (((CharSequence)paramString3).length() > 0)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private final com.tencent.luggage.wxa.ro.d<Boolean> m()
  {
    com.tencent.luggage.wxa.ro.d locald = h.a().b((com.tencent.luggage.wxa.rl.b)d.a.a).b((com.tencent.luggage.wxa.rl.b)d.b.a);
    Intrinsics.checkExpressionValueIsNotNull(locald, "pipeline()\n             …raData)\n                }");
    return locald;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.ro.d<Boolean> a(boolean paramBoolean)
  {
    if ((!l()) && (!paramBoolean))
    {
      com.tencent.luggage.wxa.ro.d locald = h.a(Boolean.valueOf(true));
      Intrinsics.checkExpressionValueIsNotNull(locald, "pipeline(true)");
      return locald;
    }
    return m();
  }
  
  @NotNull
  public final String a()
  {
    return b.a();
  }
  
  public final boolean a(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "deviceId");
    Intrinsics.checkParameterIsNotNull(paramString2, "username");
    Intrinsics.checkParameterIsNotNull(paramString3, "token");
    Intrinsics.checkParameterIsNotNull(paramString4, "hostAppId");
    Intrinsics.checkParameterIsNotNull(paramString5, "extraData");
    Object localObject = (com.tencent.luggage.wxa.rr.c)null;
    try
    {
      com.tencent.luggage.wxa.rr.c localc = a(paramString2, paramString3, paramInt, paramString1, paramString4, paramString5);
      localObject = localc;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDeviceTokenSync fail ");
      localStringBuilder.append(localException);
      o.b("WxaDeviceLogic", localStringBuilder.toString());
    }
    if (localObject != null)
    {
      Boolean localBoolean = (Boolean)((com.tencent.luggage.wxa.rr.c)localObject).b();
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        break label135;
      }
    }
    boolean bool = false;
    label135:
    if (localObject != null)
    {
      localObject = (Long)((com.tencent.luggage.wxa.rr.c)localObject).c();
      if (localObject != null)
      {
        l = ((Long)localObject).longValue();
        break label168;
      }
    }
    long l = 0L;
    label168:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkDeviceTokenSync ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(l);
    o.d("WxaDeviceLogic", ((StringBuilder)localObject).toString());
    if (bool)
    {
      a(paramInt, paramString1, paramString3, paramString2, System.currentTimeMillis(), l, paramString4, paramString5);
      return bool;
    }
    j();
    return bool;
  }
  
  @NotNull
  public final String b()
  {
    return b.c();
  }
  
  @NotNull
  public final String c()
  {
    return b.b();
  }
  
  @NotNull
  public final String d()
  {
    return b.d();
  }
  
  public final void e()
  {
    b localb = (b)e.a(b.class);
    if (localb == null)
    {
      localb = b.b;
      Intrinsics.checkExpressionValueIsNotNull(localb, "IActivateDevice.DUMMY");
    }
    c = localb;
    c.d();
  }
  
  public final boolean f()
  {
    return c.e();
  }
  
  public final boolean g()
  {
    int i;
    if (((CharSequence)d()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((CharSequence)a()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (k())) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.ro.d<Boolean> h()
  {
    o.d("WxaDeviceLogic", "refresh token");
    com.tencent.luggage.wxa.ro.d locald = h.a().a((com.tencent.luggage.wxa.rl.b)d.c.a);
    Intrinsics.checkExpressionValueIsNotNull(locald, "pipeline()\n             …   true\n                }");
    return locald;
  }
  
  public final boolean i()
  {
    Object localObject1 = new AtomicReference();
    Object localObject2 = new CountDownLatch(1);
    c.a((b.a)new d.d((CountDownLatch)localObject2, (AtomicReference)localObject1));
    try
    {
      ((CountDownLatch)localObject2).await();
      localObject2 = (Integer)((g)((AtomicReference)localObject1).get()).b();
      String str1 = (String)((g)((AtomicReference)localObject1).get()).c();
      String str2 = (String)((g)((AtomicReference)localObject1).get()).d();
      String str3 = (String)((g)((AtomicReference)localObject1).get()).e();
      String str4 = (String)((g)((AtomicReference)localObject1).get()).f();
      localObject1 = (String)((g)((AtomicReference)localObject1).get()).g();
      if (af.c(str3)) {
        return false;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "productId");
      int i = ((Integer)localObject2).intValue();
      Intrinsics.checkExpressionValueIsNotNull(str1, "deviceId");
      Intrinsics.checkExpressionValueIsNotNull(str2, "username");
      Intrinsics.checkExpressionValueIsNotNull(str3, "token");
      Intrinsics.checkExpressionValueIsNotNull(str4, "hostAppId");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "extraData");
      return a(i, str1, str2, str3, str4, (String)localObject1);
    }
    catch (InterruptedException localInterruptedException)
    {
      o.a("WxaDeviceLogic", (Throwable)localInterruptedException, "latch await exp ", new Object[0]);
    }
    return false;
  }
  
  public final void j()
  {
    o.d("WxaDeviceLogic", "reset");
    b.i();
    i.a.b();
  }
  
  public final boolean k()
  {
    if (c.c()) {
      return b.g();
    }
    return true;
  }
  
  public final boolean l()
  {
    boolean bool3 = c.c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!b.h()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.d
 * JD-Core Version:    0.7.0.1
 */