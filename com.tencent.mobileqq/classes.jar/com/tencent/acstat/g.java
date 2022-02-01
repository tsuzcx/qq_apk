package com.tencent.acstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import java.util.Arrays;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

class g
{
  private static StatLogger d = ;
  private static g e = null;
  private static Context f = null;
  DefaultHttpClient a = null;
  Handler b = null;
  StringBuilder c = new StringBuilder(4096);
  private long g = 0L;
  
  private g(Context paramContext)
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatDispatcher");
      localHandlerThread.start();
      this.b = new Handler(localHandlerThread.getLooper());
      f = paramContext.getApplicationContext();
      this.g = (System.currentTimeMillis() / 1000L);
      paramContext = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(paramContext, false);
      HttpConnectionParams.setConnectionTimeout(paramContext, 10000);
      HttpConnectionParams.setSoTimeout(paramContext, 10000);
      this.a = new DefaultHttpClient(paramContext);
      this.a.setKeepAliveStrategy(new h(this));
      return;
    }
    catch (Throwable paramContext)
    {
      d.e(paramContext);
    }
  }
  
  static Context a()
  {
    return f;
  }
  
  static void a(Context paramContext)
  {
    f = paramContext.getApplicationContext();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.optString("mid");
      if (com.tencent.acstat.a.a.i.c((String)localObject))
      {
        if (StatConfig.isDebugEnable()) {
          d.i("update mid:" + (String)localObject);
        }
        com.tencent.acstat.a.a.d locald = new com.tencent.acstat.a.a.d();
        locald.a = af.a(f).b(f).getImei();
        locald.b = af.a(f).b(f).getMac();
        locald.d = System.currentTimeMillis();
        locald.c = ((String)localObject);
        com.tencent.acstat.a.a.h.a(f).a(locald);
      }
      if (!paramJSONObject.isNull("cfg"))
      {
        localObject = paramJSONObject.getJSONObject("cfg");
        StatConfig.a(f, (JSONObject)localObject);
      }
      if (!paramJSONObject.isNull("ncts"))
      {
        int i = paramJSONObject.getInt("ncts");
        int j = (int)(i - System.currentTimeMillis() / 1000L);
        if (StatConfig.isDebugEnable()) {
          d.i("server time:" + i + ", diff time:" + j);
        }
        StatCommonHelper.updateCheckTime(f);
        StatCommonHelper.writeDiffTimeFromServer(f, j);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.w(paramJSONObject);
    }
  }
  
  static g b(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new g(paramContext);
      }
      return e;
    }
    finally {}
  }
  
  void a(com.tencent.acstat.event.d paramd, StatDispatchCallback paramStatDispatchCallback)
  {
    b(Arrays.asList(new String[] { paramd.g() }), paramStatDispatchCallback);
  }
  
  /* Error */
  void a(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokeinterface 250 1 0
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokeinterface 254 1 0
    //   23: istore 5
    //   25: aload_0
    //   26: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   34: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   37: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   45: ldc_w 263
    //   48: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_3
    //   55: iload 5
    //   57: if_icmpge +43 -> 100
    //   60: aload_0
    //   61: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: iload_3
    //   66: invokeinterface 267 2 0
    //   71: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   74: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: iload_3
    //   79: iload 5
    //   81: iconst_1
    //   82: isub
    //   83: if_icmpeq +1079 -> 1162
    //   86: aload_0
    //   87: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   90: ldc_w 270
    //   93: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: goto +1065 -> 1162
    //   100: aload_0
    //   101: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   104: ldc_w 272
    //   107: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   115: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 273	java/lang/String:length	()I
    //   123: istore 6
    //   125: new 45	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   132: invokestatic 277	com/tencent/acstat/StatConfig:getStatReportUrl	()Ljava/lang/String;
    //   135: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 279
    //   141: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 52	com/tencent/acstat/g:g	J
    //   148: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 9
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 52	com/tencent/acstat/g:g	J
    //   161: lconst_1
    //   162: ladd
    //   163: putfield 52	com/tencent/acstat/g:g	J
    //   166: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   169: ifeq +48 -> 217
    //   172: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   175: new 45	java/lang/StringBuilder
    //   178: dup
    //   179: ldc_w 263
    //   182: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload 9
    //   187: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 284
    //   193: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 286
    //   204: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   217: new 288	org/apache/http/client/methods/HttpPost
    //   220: dup
    //   221: aload 9
    //   223: invokespecial 289	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   226: astore 11
    //   228: aload 11
    //   230: ldc_w 291
    //   233: ldc_w 293
    //   236: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 11
    //   241: ldc_w 299
    //   244: ldc_w 301
    //   247: invokevirtual 304	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 11
    //   252: ldc_w 306
    //   255: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   258: getstatic 32	com/tencent/acstat/g:f	Landroid/content/Context;
    //   261: invokestatic 315	com/tencent/acstat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/acstat/NetworkManager;
    //   264: invokevirtual 319	com/tencent/acstat/NetworkManager:getHttpProxy	()Lorg/apache/http/HttpHost;
    //   267: astore 12
    //   269: aload 11
    //   271: ldc_w 321
    //   274: ldc_w 323
    //   277: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload 12
    //   282: ifnonnull +417 -> 699
    //   285: aload_0
    //   286: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   289: invokevirtual 327	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   292: ldc_w 329
    //   295: invokeinterface 334 2 0
    //   300: pop
    //   301: new 336	java/io/ByteArrayOutputStream
    //   304: dup
    //   305: iload 6
    //   307: invokespecial 337	java/io/ByteArrayOutputStream:<init>	(I)V
    //   310: astore 10
    //   312: aload_1
    //   313: ldc_w 339
    //   316: invokevirtual 343	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   319: astore 9
    //   321: aload 9
    //   323: arraylength
    //   324: istore 5
    //   326: iload 4
    //   328: istore_3
    //   329: iload 6
    //   331: getstatic 347	com/tencent/acstat/StatConfig:o	I
    //   334: if_icmple +5 -> 339
    //   337: iconst_1
    //   338: istore_3
    //   339: aload 9
    //   341: astore_1
    //   342: iload_3
    //   343: ifeq +167 -> 510
    //   346: aload 11
    //   348: ldc_w 321
    //   351: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   354: new 45	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 323
    //   364: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 349
    //   370: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: astore_1
    //   377: aload 11
    //   379: ldc_w 321
    //   382: aload_1
    //   383: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 12
    //   388: ifnull +20 -> 408
    //   391: aload 11
    //   393: ldc_w 351
    //   396: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   399: aload 11
    //   401: ldc_w 351
    //   404: aload_1
    //   405: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 10
    //   410: iconst_4
    //   411: newarray byte
    //   413: invokevirtual 355	java/io/ByteArrayOutputStream:write	([B)V
    //   416: new 357	java/util/zip/GZIPOutputStream
    //   419: dup
    //   420: aload 10
    //   422: invokespecial 360	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   425: astore_1
    //   426: aload_1
    //   427: aload 9
    //   429: invokevirtual 361	java/util/zip/GZIPOutputStream:write	([B)V
    //   432: aload_1
    //   433: invokevirtual 364	java/util/zip/GZIPOutputStream:close	()V
    //   436: aload 10
    //   438: invokevirtual 368	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   441: astore 9
    //   443: aload 9
    //   445: iconst_0
    //   446: iconst_4
    //   447: invokestatic 374	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   450: iload 5
    //   452: invokevirtual 378	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   455: pop
    //   456: aload 9
    //   458: astore_1
    //   459: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   462: ifeq +48 -> 510
    //   465: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   468: new 45	java/lang/StringBuilder
    //   471: dup
    //   472: ldc_w 380
    //   475: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: iload 5
    //   480: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 382
    //   486: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 9
    //   491: arraylength
    //   492: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 384
    //   498: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 386	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   507: aload 9
    //   509: astore_1
    //   510: aload 11
    //   512: new 388	org/apache/http/entity/ByteArrayEntity
    //   515: dup
    //   516: aload_1
    //   517: invokestatic 393	com/tencent/acstat/common/d:a	([B)[B
    //   520: invokespecial 395	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   523: invokevirtual 399	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   526: aload_0
    //   527: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   530: aload 11
    //   532: invokevirtual 403	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   535: astore_1
    //   536: aload_1
    //   537: invokeinterface 409 1 0
    //   542: astore 9
    //   544: aload_1
    //   545: invokeinterface 413 1 0
    //   550: invokeinterface 418 1 0
    //   555: istore_3
    //   556: aload 9
    //   558: invokeinterface 423 1 0
    //   563: lstore 7
    //   565: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   568: ifeq +37 -> 605
    //   571: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   574: new 45	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 425
    //   581: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: iload_3
    //   585: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: ldc_w 427
    //   591: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: lload 7
    //   596: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   605: lload 7
    //   607: lconst_0
    //   608: lcmp
    //   609: ifgt +191 -> 800
    //   612: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   615: ldc_w 429
    //   618: invokevirtual 431	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   621: aload_2
    //   622: ifnull +9 -> 631
    //   625: aload_2
    //   626: invokeinterface 436 1 0
    //   631: aload 9
    //   633: invokestatic 441	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   636: pop
    //   637: return
    //   638: astore_1
    //   639: aload_1
    //   640: ifnull -624 -> 16
    //   643: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   646: aload_1
    //   647: invokevirtual 444	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   650: aload_2
    //   651: ifnull +9 -> 660
    //   654: aload_2
    //   655: invokeinterface 436 1 0
    //   660: aload_1
    //   661: instanceof 446
    //   664: ifeq +25 -> 689
    //   667: invokestatic 449	java/lang/System:gc	()V
    //   670: aload_0
    //   671: aconst_null
    //   672: putfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   675: aload_0
    //   676: new 45	java/lang/StringBuilder
    //   679: dup
    //   680: sipush 2048
    //   683: invokespecial 48	java/lang/StringBuilder:<init>	(I)V
    //   686: putfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   689: getstatic 32	com/tencent/acstat/g:f	Landroid/content/Context;
    //   692: invokestatic 315	com/tencent/acstat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/acstat/NetworkManager;
    //   695: invokevirtual 452	com/tencent/acstat/NetworkManager:onDispatchFailed	()V
    //   698: return
    //   699: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   702: ifeq +30 -> 732
    //   705: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   708: new 45	java/lang/StringBuilder
    //   711: dup
    //   712: ldc_w 454
    //   715: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   718: aload 12
    //   720: invokevirtual 459	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   723: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 386	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   732: aload 11
    //   734: ldc_w 351
    //   737: ldc_w 323
    //   740: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload_0
    //   744: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   747: invokevirtual 327	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   750: ldc_w 329
    //   753: aload 12
    //   755: invokeinterface 463 3 0
    //   760: pop
    //   761: aload 11
    //   763: ldc_w 465
    //   766: getstatic 468	com/tencent/acstat/StatConfig:k	Ljava/lang/String;
    //   769: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 11
    //   774: ldc_w 470
    //   777: ldc_w 472
    //   780: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 11
    //   785: ldc_w 474
    //   788: ldc_w 476
    //   791: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: goto -493 -> 301
    //   797: astore_1
    //   798: aload_1
    //   799: athrow
    //   800: aload 9
    //   802: invokeinterface 480 1 0
    //   807: astore 11
    //   809: new 482	java/io/DataInputStream
    //   812: dup
    //   813: aload 11
    //   815: invokespecial 485	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   818: astore 12
    //   820: aload 9
    //   822: invokeinterface 423 1 0
    //   827: l2i
    //   828: newarray byte
    //   830: astore 9
    //   832: aload 12
    //   834: aload 9
    //   836: invokevirtual 488	java/io/DataInputStream:readFully	([B)V
    //   839: aload 11
    //   841: invokevirtual 491	java/io/InputStream:close	()V
    //   844: aload 12
    //   846: invokevirtual 492	java/io/DataInputStream:close	()V
    //   849: aload_1
    //   850: ldc_w 321
    //   853: invokeinterface 496 2 0
    //   858: astore 12
    //   860: aload 9
    //   862: astore_1
    //   863: aload 12
    //   865: ifnull +28 -> 893
    //   868: aload 12
    //   870: invokeinterface 501 1 0
    //   875: ldc_w 503
    //   878: invokevirtual 506	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   881: ifeq +115 -> 996
    //   884: aload 9
    //   886: invokestatic 509	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   889: invokestatic 511	com/tencent/acstat/common/d:b	([B)[B
    //   892: astore_1
    //   893: new 232	java/lang/String
    //   896: dup
    //   897: aload_1
    //   898: ldc_w 339
    //   901: invokespecial 514	java/lang/String:<init>	([BLjava/lang/String;)V
    //   904: astore 9
    //   906: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   909: ifeq +27 -> 936
    //   912: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   915: new 45	java/lang/StringBuilder
    //   918: dup
    //   919: ldc_w 516
    //   922: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   925: aload 9
    //   927: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   936: new 125	org/json/JSONObject
    //   939: dup
    //   940: aload 9
    //   942: invokespecial 517	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   945: astore 9
    //   947: iload_3
    //   948: sipush 200
    //   951: if_icmpne +144 -> 1095
    //   954: aload_0
    //   955: aload 9
    //   957: invokespecial 519	com/tencent/acstat/g:a	(Lorg/json/JSONObject;)V
    //   960: aload_2
    //   961: ifnull +20 -> 981
    //   964: aload 9
    //   966: ldc_w 521
    //   969: invokevirtual 524	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   972: ifne +105 -> 1077
    //   975: aload_2
    //   976: invokeinterface 527 1 0
    //   981: aload 11
    //   983: invokevirtual 491	java/io/InputStream:close	()V
    //   986: aload 10
    //   988: invokevirtual 528	java/io/ByteArrayOutputStream:close	()V
    //   991: aconst_null
    //   992: astore_1
    //   993: goto -354 -> 639
    //   996: aload 12
    //   998: invokeinterface 501 1 0
    //   1003: ldc_w 530
    //   1006: invokevirtual 506	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1009: ifeq +15 -> 1024
    //   1012: aload 9
    //   1014: invokestatic 511	com/tencent/acstat/common/d:b	([B)[B
    //   1017: invokestatic 509	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   1020: astore_1
    //   1021: goto -128 -> 893
    //   1024: aload 12
    //   1026: invokeinterface 501 1 0
    //   1031: ldc_w 293
    //   1034: invokevirtual 506	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1037: ifeq +12 -> 1049
    //   1040: aload 9
    //   1042: invokestatic 509	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   1045: astore_1
    //   1046: goto -153 -> 893
    //   1049: aload 9
    //   1051: astore_1
    //   1052: aload 12
    //   1054: invokeinterface 501 1 0
    //   1059: ldc_w 323
    //   1062: invokevirtual 506	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1065: ifeq -172 -> 893
    //   1068: aload 9
    //   1070: invokestatic 511	com/tencent/acstat/common/d:b	([B)[B
    //   1073: astore_1
    //   1074: goto -181 -> 893
    //   1077: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1080: ldc_w 532
    //   1083: invokevirtual 534	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1086: aload_2
    //   1087: invokeinterface 436 1 0
    //   1092: goto -111 -> 981
    //   1095: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1098: new 45	java/lang/StringBuilder
    //   1101: dup
    //   1102: ldc_w 536
    //   1105: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1108: iload_3
    //   1109: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: ldc_w 538
    //   1115: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: new 232	java/lang/String
    //   1121: dup
    //   1122: aload_1
    //   1123: ldc_w 339
    //   1126: invokespecial 514	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1129: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokevirtual 534	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1138: aload_2
    //   1139: ifnull -158 -> 981
    //   1142: aload_2
    //   1143: invokeinterface 436 1 0
    //   1148: goto -167 -> 981
    //   1151: astore_2
    //   1152: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1155: aload_2
    //   1156: invokevirtual 120	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1159: goto -499 -> 660
    //   1162: iload_3
    //   1163: iconst_1
    //   1164: iadd
    //   1165: istore_3
    //   1166: goto -1112 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	this	g
    //   0	1169	1	paramList	List<?>
    //   0	1169	2	paramStatDispatchCallback	StatDispatchCallback
    //   53	1113	3	i	int
    //   1	326	4	j	int
    //   23	456	5	k	int
    //   123	212	6	m	int
    //   563	43	7	l	long
    //   154	915	9	localObject1	Object
    //   310	677	10	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   226	756	11	localObject2	Object
    //   267	786	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	52	638	java/lang/Throwable
    //   60	78	638	java/lang/Throwable
    //   86	97	638	java/lang/Throwable
    //   100	217	638	java/lang/Throwable
    //   217	280	638	java/lang/Throwable
    //   285	301	638	java/lang/Throwable
    //   301	326	638	java/lang/Throwable
    //   329	337	638	java/lang/Throwable
    //   346	386	638	java/lang/Throwable
    //   391	408	638	java/lang/Throwable
    //   408	456	638	java/lang/Throwable
    //   459	507	638	java/lang/Throwable
    //   510	605	638	java/lang/Throwable
    //   612	621	638	java/lang/Throwable
    //   625	631	638	java/lang/Throwable
    //   631	637	638	java/lang/Throwable
    //   699	732	638	java/lang/Throwable
    //   732	794	638	java/lang/Throwable
    //   800	860	638	java/lang/Throwable
    //   868	893	638	java/lang/Throwable
    //   893	936	638	java/lang/Throwable
    //   936	947	638	java/lang/Throwable
    //   954	960	638	java/lang/Throwable
    //   964	981	638	java/lang/Throwable
    //   981	991	638	java/lang/Throwable
    //   996	1021	638	java/lang/Throwable
    //   1024	1046	638	java/lang/Throwable
    //   1052	1074	638	java/lang/Throwable
    //   1077	1092	638	java/lang/Throwable
    //   1095	1138	638	java/lang/Throwable
    //   1142	1148	638	java/lang/Throwable
    //   25	52	797	finally
    //   60	78	797	finally
    //   86	97	797	finally
    //   100	217	797	finally
    //   217	280	797	finally
    //   285	301	797	finally
    //   301	326	797	finally
    //   329	337	797	finally
    //   346	386	797	finally
    //   391	408	797	finally
    //   408	456	797	finally
    //   459	507	797	finally
    //   510	605	797	finally
    //   612	621	797	finally
    //   625	631	797	finally
    //   631	637	797	finally
    //   699	732	797	finally
    //   732	794	797	finally
    //   800	860	797	finally
    //   868	893	797	finally
    //   893	936	797	finally
    //   936	947	797	finally
    //   954	960	797	finally
    //   964	981	797	finally
    //   981	991	797	finally
    //   996	1021	797	finally
    //   1024	1046	797	finally
    //   1052	1074	797	finally
    //   1077	1092	797	finally
    //   1095	1138	797	finally
    //   1142	1148	797	finally
    //   654	660	1151	java/lang/Throwable
  }
  
  void b(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    if (this.b != null) {
      this.b.post(new i(this, paramList, paramStatDispatchCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.g
 * JD-Core Version:    0.7.0.1
 */