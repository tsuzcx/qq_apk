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
      Object localObject1 = paramJSONObject.optString("mid");
      if (com.tencent.acstat.a.a.i.c((String)localObject1))
      {
        if (StatConfig.isDebugEnable())
        {
          localObject2 = d;
          StringBuilder localStringBuilder = new StringBuilder("update mid:");
          localStringBuilder.append((String)localObject1);
          ((StatLogger)localObject2).i(localStringBuilder.toString());
        }
        Object localObject2 = new com.tencent.acstat.a.a.d();
        ((com.tencent.acstat.a.a.d)localObject2).a = af.a(f).b(f).getImei();
        ((com.tencent.acstat.a.a.d)localObject2).b = af.a(f).b(f).getMac();
        ((com.tencent.acstat.a.a.d)localObject2).d = System.currentTimeMillis();
        ((com.tencent.acstat.a.a.d)localObject2).c = ((String)localObject1);
        com.tencent.acstat.a.a.h.a(f).a((com.tencent.acstat.a.a.d)localObject2);
      }
      if (!paramJSONObject.isNull("cfg"))
      {
        localObject1 = paramJSONObject.getJSONObject("cfg");
        StatConfig.a(f, (JSONObject)localObject1);
      }
      if (!paramJSONObject.isNull("ncts"))
      {
        int i = paramJSONObject.getInt("ncts");
        int j = (int)(i - System.currentTimeMillis() / 1000L);
        if (StatConfig.isDebugEnable())
        {
          paramJSONObject = d;
          localObject1 = new StringBuilder("server time:");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(", diff time:");
          ((StringBuilder)localObject1).append(j);
          paramJSONObject.i(((StringBuilder)localObject1).toString());
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
    if (e == null) {
      try
      {
        if (e == null) {
          e = new g(paramContext);
        }
      }
      finally {}
    }
    return e;
  }
  
  void a(com.tencent.acstat.event.d paramd, StatDispatchCallback paramStatDispatchCallback)
  {
    b(Arrays.asList(new String[] { paramd.g() }), paramStatDispatchCallback);
  }
  
  /* Error */
  void a(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +1266 -> 1267
    //   4: aload_1
    //   5: invokeinterface 250 1 0
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 254 1 0
    //   20: istore 4
    //   22: aload_0
    //   23: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   31: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   34: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   42: ldc_w 263
    //   45: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: iload 4
    //   54: if_icmpge +43 -> 97
    //   57: aload_0
    //   58: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: iload_3
    //   63: invokeinterface 267 2 0
    //   68: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   71: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: iload_3
    //   76: iload 4
    //   78: iconst_1
    //   79: isub
    //   80: if_icmpeq +1188 -> 1268
    //   83: aload_0
    //   84: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   87: ldc_w 270
    //   90: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: goto +1174 -> 1268
    //   97: aload_0
    //   98: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   101: ldc_w 272
    //   104: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_0
    //   109: getfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   112: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 273	java/lang/String:length	()I
    //   120: istore_3
    //   121: new 45	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   128: astore 7
    //   130: aload 7
    //   132: invokestatic 277	com/tencent/acstat/StatConfig:getStatReportUrl	()Ljava/lang/String;
    //   135: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 7
    //   141: ldc_w 279
    //   144: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: aload_0
    //   151: getfield 52	com/tencent/acstat/g:g	J
    //   154: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 7
    //   160: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 7
    //   165: aload_0
    //   166: aload_0
    //   167: getfield 52	com/tencent/acstat/g:g	J
    //   170: lconst_1
    //   171: ladd
    //   172: putfield 52	com/tencent/acstat/g:g	J
    //   175: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   178: ifeq +70 -> 248
    //   181: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   184: astore 8
    //   186: new 45	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 263
    //   193: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: astore 9
    //   198: aload 9
    //   200: aload 7
    //   202: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 9
    //   208: ldc_w 284
    //   211: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 9
    //   217: iload_3
    //   218: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 9
    //   224: ldc_w 286
    //   227: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 9
    //   233: aload_1
    //   234: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 8
    //   240: aload 9
    //   242: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   248: new 288	org/apache/http/client/methods/HttpPost
    //   251: dup
    //   252: aload 7
    //   254: invokespecial 289	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   257: astore 9
    //   259: aload 9
    //   261: ldc_w 291
    //   264: ldc_w 293
    //   267: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 9
    //   272: ldc_w 299
    //   275: ldc_w 301
    //   278: invokevirtual 304	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 9
    //   283: ldc_w 306
    //   286: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   289: getstatic 32	com/tencent/acstat/g:f	Landroid/content/Context;
    //   292: invokestatic 315	com/tencent/acstat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/acstat/NetworkManager;
    //   295: invokevirtual 319	com/tencent/acstat/NetworkManager:getHttpProxy	()Lorg/apache/http/HttpHost;
    //   298: astore 10
    //   300: aload 9
    //   302: ldc_w 321
    //   305: ldc_w 323
    //   308: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 10
    //   313: ifnonnull +22 -> 335
    //   316: aload_0
    //   317: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   320: invokevirtual 327	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   323: ldc_w 329
    //   326: invokeinterface 334 2 0
    //   331: pop
    //   332: goto +109 -> 441
    //   335: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   338: ifeq +41 -> 379
    //   341: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   344: astore 7
    //   346: new 45	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 336
    //   353: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: astore 8
    //   358: aload 8
    //   360: aload 10
    //   362: invokevirtual 341	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   365: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 7
    //   371: aload 8
    //   373: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 343	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   379: aload 9
    //   381: ldc_w 345
    //   384: ldc_w 323
    //   387: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload_0
    //   391: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   394: invokevirtual 327	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   397: ldc_w 329
    //   400: aload 10
    //   402: invokeinterface 349 3 0
    //   407: pop
    //   408: aload 9
    //   410: ldc_w 351
    //   413: getstatic 354	com/tencent/acstat/StatConfig:k	Ljava/lang/String;
    //   416: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 9
    //   421: ldc_w 356
    //   424: ldc_w 358
    //   427: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 9
    //   432: ldc_w 360
    //   435: ldc_w 362
    //   438: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: new 364	java/io/ByteArrayOutputStream
    //   444: dup
    //   445: iload_3
    //   446: invokespecial 365	java/io/ByteArrayOutputStream:<init>	(I)V
    //   449: astore 8
    //   451: aload_1
    //   452: ldc_w 367
    //   455: invokevirtual 371	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   458: astore 7
    //   460: aload 7
    //   462: arraylength
    //   463: istore 4
    //   465: iload_3
    //   466: getstatic 375	com/tencent/acstat/StatConfig:o	I
    //   469: if_icmple +806 -> 1275
    //   472: iconst_1
    //   473: istore_3
    //   474: goto +3 -> 477
    //   477: aload 7
    //   479: astore_1
    //   480: iload_3
    //   481: ifeq +191 -> 672
    //   484: aload 9
    //   486: ldc_w 321
    //   489: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   492: new 45	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   499: astore_1
    //   500: aload_1
    //   501: ldc_w 323
    //   504: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_1
    //   509: ldc_w 377
    //   512: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_1
    //   517: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: astore_1
    //   521: aload 9
    //   523: ldc_w 321
    //   526: aload_1
    //   527: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 10
    //   532: ifnull +20 -> 552
    //   535: aload 9
    //   537: ldc_w 345
    //   540: invokevirtual 309	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   543: aload 9
    //   545: ldc_w 345
    //   548: aload_1
    //   549: invokevirtual 297	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload 8
    //   554: iconst_4
    //   555: newarray byte
    //   557: invokevirtual 381	java/io/ByteArrayOutputStream:write	([B)V
    //   560: new 383	java/util/zip/GZIPOutputStream
    //   563: dup
    //   564: aload 8
    //   566: invokespecial 386	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   569: astore_1
    //   570: aload_1
    //   571: aload 7
    //   573: invokevirtual 387	java/util/zip/GZIPOutputStream:write	([B)V
    //   576: aload_1
    //   577: invokevirtual 390	java/util/zip/GZIPOutputStream:close	()V
    //   580: aload 8
    //   582: invokevirtual 394	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   585: astore 7
    //   587: aload 7
    //   589: iconst_0
    //   590: iconst_4
    //   591: invokestatic 400	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   594: iload 4
    //   596: invokevirtual 404	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   599: pop
    //   600: aload 7
    //   602: astore_1
    //   603: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   606: ifeq +66 -> 672
    //   609: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   612: astore_1
    //   613: new 45	java/lang/StringBuilder
    //   616: dup
    //   617: ldc_w 406
    //   620: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   623: astore 10
    //   625: aload 10
    //   627: iload 4
    //   629: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 10
    //   635: ldc_w 408
    //   638: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 10
    //   644: aload 7
    //   646: arraylength
    //   647: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 10
    //   653: ldc_w 410
    //   656: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload_1
    //   661: aload 10
    //   663: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokevirtual 343	com/tencent/acstat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   669: aload 7
    //   671: astore_1
    //   672: aload 9
    //   674: new 412	org/apache/http/entity/ByteArrayEntity
    //   677: dup
    //   678: aload_1
    //   679: invokestatic 417	com/tencent/acstat/common/d:a	([B)[B
    //   682: invokespecial 419	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   685: invokevirtual 423	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   688: aload_0
    //   689: getfield 41	com/tencent/acstat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   692: aload 9
    //   694: invokevirtual 427	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   697: astore_1
    //   698: aload_1
    //   699: invokeinterface 433 1 0
    //   704: astore 7
    //   706: aload_1
    //   707: invokeinterface 437 1 0
    //   712: invokeinterface 442 1 0
    //   717: istore_3
    //   718: aload 7
    //   720: invokeinterface 447 1 0
    //   725: lstore 5
    //   727: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   730: ifeq +54 -> 784
    //   733: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   736: astore 9
    //   738: new 45	java/lang/StringBuilder
    //   741: dup
    //   742: ldc_w 449
    //   745: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   748: astore 10
    //   750: aload 10
    //   752: iload_3
    //   753: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 10
    //   759: ldc_w 451
    //   762: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 10
    //   768: lload 5
    //   770: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 9
    //   776: aload 10
    //   778: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   784: lload 5
    //   786: lconst_0
    //   787: lcmp
    //   788: ifgt +29 -> 817
    //   791: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   794: ldc_w 453
    //   797: invokevirtual 455	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   800: aload_2
    //   801: ifnull +9 -> 810
    //   804: aload_2
    //   805: invokeinterface 460 1 0
    //   810: aload 7
    //   812: invokestatic 465	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   815: pop
    //   816: return
    //   817: aload 7
    //   819: invokeinterface 469 1 0
    //   824: astore 9
    //   826: new 471	java/io/DataInputStream
    //   829: dup
    //   830: aload 9
    //   832: invokespecial 474	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   835: astore 10
    //   837: aload 7
    //   839: invokeinterface 447 1 0
    //   844: l2i
    //   845: newarray byte
    //   847: astore 7
    //   849: aload 10
    //   851: aload 7
    //   853: invokevirtual 477	java/io/DataInputStream:readFully	([B)V
    //   856: aload 9
    //   858: invokevirtual 480	java/io/InputStream:close	()V
    //   861: aload 10
    //   863: invokevirtual 481	java/io/DataInputStream:close	()V
    //   866: aload_1
    //   867: ldc_w 321
    //   870: invokeinterface 485 2 0
    //   875: astore 10
    //   877: aload 7
    //   879: astore_1
    //   880: aload 10
    //   882: ifnull +109 -> 991
    //   885: aload 10
    //   887: invokeinterface 490 1 0
    //   892: ldc_w 492
    //   895: invokevirtual 495	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   898: ifeq +15 -> 913
    //   901: aload 7
    //   903: invokestatic 498	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   906: invokestatic 500	com/tencent/acstat/common/d:b	([B)[B
    //   909: astore_1
    //   910: goto +81 -> 991
    //   913: aload 10
    //   915: invokeinterface 490 1 0
    //   920: ldc_w 502
    //   923: invokevirtual 495	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   926: ifeq +15 -> 941
    //   929: aload 7
    //   931: invokestatic 500	com/tencent/acstat/common/d:b	([B)[B
    //   934: invokestatic 498	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   937: astore_1
    //   938: goto +53 -> 991
    //   941: aload 10
    //   943: invokeinterface 490 1 0
    //   948: ldc_w 293
    //   951: invokevirtual 495	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   954: ifeq +12 -> 966
    //   957: aload 7
    //   959: invokestatic 498	com/tencent/acstat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   962: astore_1
    //   963: goto +28 -> 991
    //   966: aload 7
    //   968: astore_1
    //   969: aload 10
    //   971: invokeinterface 490 1 0
    //   976: ldc_w 323
    //   979: invokevirtual 495	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   982: ifeq +9 -> 991
    //   985: aload 7
    //   987: invokestatic 500	com/tencent/acstat/common/d:b	([B)[B
    //   990: astore_1
    //   991: new 232	java/lang/String
    //   994: dup
    //   995: aload_1
    //   996: ldc_w 367
    //   999: invokespecial 505	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1002: astore 7
    //   1004: invokestatic 140	com/tencent/acstat/StatConfig:isDebugEnable	()Z
    //   1007: ifeq +38 -> 1045
    //   1010: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1013: astore 10
    //   1015: new 45	java/lang/StringBuilder
    //   1018: dup
    //   1019: ldc_w 507
    //   1022: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1025: astore 11
    //   1027: aload 11
    //   1029: aload 7
    //   1031: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload 10
    //   1037: aload 11
    //   1039: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokevirtual 155	com/tencent/acstat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   1045: new 125	org/json/JSONObject
    //   1048: dup
    //   1049: aload 7
    //   1051: invokespecial 508	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1054: astore 7
    //   1056: iload_3
    //   1057: sipush 200
    //   1060: if_icmpne +51 -> 1111
    //   1063: aload_0
    //   1064: aload 7
    //   1066: invokespecial 510	com/tencent/acstat/g:a	(Lorg/json/JSONObject;)V
    //   1069: aload_2
    //   1070: ifnull +108 -> 1178
    //   1073: aload 7
    //   1075: ldc_w 512
    //   1078: invokevirtual 515	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1081: ifne +12 -> 1093
    //   1084: aload_2
    //   1085: invokeinterface 518 1 0
    //   1090: goto +88 -> 1178
    //   1093: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1096: ldc_w 520
    //   1099: invokevirtual 523	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1102: aload_2
    //   1103: invokeinterface 460 1 0
    //   1108: goto +70 -> 1178
    //   1111: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1114: astore 7
    //   1116: new 45	java/lang/StringBuilder
    //   1119: dup
    //   1120: ldc_w 525
    //   1123: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1126: astore 10
    //   1128: aload 10
    //   1130: iload_3
    //   1131: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: pop
    //   1135: aload 10
    //   1137: ldc_w 527
    //   1140: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: aload 10
    //   1146: new 232	java/lang/String
    //   1149: dup
    //   1150: aload_1
    //   1151: ldc_w 367
    //   1154: invokespecial 505	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1157: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload 7
    //   1163: aload 10
    //   1165: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: invokevirtual 523	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1171: aload_2
    //   1172: ifnull +6 -> 1178
    //   1175: goto -73 -> 1102
    //   1178: aload 9
    //   1180: invokevirtual 480	java/io/InputStream:close	()V
    //   1183: aload 8
    //   1185: invokevirtual 528	java/io/ByteArrayOutputStream:close	()V
    //   1188: aconst_null
    //   1189: astore_1
    //   1190: goto +7 -> 1197
    //   1193: astore_1
    //   1194: aload_1
    //   1195: athrow
    //   1196: astore_1
    //   1197: aload_1
    //   1198: ifnull +69 -> 1267
    //   1201: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1204: aload_1
    //   1205: invokevirtual 530	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   1208: aload_2
    //   1209: ifnull +20 -> 1229
    //   1212: aload_2
    //   1213: invokeinterface 460 1 0
    //   1218: goto +11 -> 1229
    //   1221: astore_2
    //   1222: getstatic 28	com/tencent/acstat/g:d	Lcom/tencent/acstat/common/StatLogger;
    //   1225: aload_2
    //   1226: invokevirtual 120	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1229: aload_1
    //   1230: instanceof 532
    //   1233: ifeq +25 -> 1258
    //   1236: invokestatic 535	java/lang/System:gc	()V
    //   1239: aload_0
    //   1240: aconst_null
    //   1241: putfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   1244: aload_0
    //   1245: new 45	java/lang/StringBuilder
    //   1248: dup
    //   1249: sipush 2048
    //   1252: invokespecial 48	java/lang/StringBuilder:<init>	(I)V
    //   1255: putfield 50	com/tencent/acstat/g:c	Ljava/lang/StringBuilder;
    //   1258: getstatic 32	com/tencent/acstat/g:f	Landroid/content/Context;
    //   1261: invokestatic 315	com/tencent/acstat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/acstat/NetworkManager;
    //   1264: invokevirtual 538	com/tencent/acstat/NetworkManager:onDispatchFailed	()V
    //   1267: return
    //   1268: iload_3
    //   1269: iconst_1
    //   1270: iadd
    //   1271: istore_3
    //   1272: goto -1221 -> 51
    //   1275: iconst_0
    //   1276: istore_3
    //   1277: goto -800 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1280	0	this	g
    //   0	1280	1	paramList	List<?>
    //   0	1280	2	paramStatDispatchCallback	StatDispatchCallback
    //   50	1227	3	i	int
    //   20	608	4	j	int
    //   725	60	5	l	long
    //   128	1034	7	localObject1	Object
    //   184	1000	8	localObject2	Object
    //   196	983	9	localObject3	Object
    //   298	866	10	localObject4	Object
    //   1025	13	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   22	49	1193	finally
    //   57	75	1193	finally
    //   83	94	1193	finally
    //   97	248	1193	finally
    //   248	311	1193	finally
    //   316	332	1193	finally
    //   335	379	1193	finally
    //   379	441	1193	finally
    //   441	472	1193	finally
    //   484	530	1193	finally
    //   535	552	1193	finally
    //   552	600	1193	finally
    //   603	669	1193	finally
    //   672	784	1193	finally
    //   791	800	1193	finally
    //   804	810	1193	finally
    //   810	816	1193	finally
    //   817	877	1193	finally
    //   885	910	1193	finally
    //   913	938	1193	finally
    //   941	963	1193	finally
    //   969	991	1193	finally
    //   991	1045	1193	finally
    //   1045	1056	1193	finally
    //   1063	1069	1193	finally
    //   1073	1090	1193	finally
    //   1093	1102	1193	finally
    //   1102	1108	1193	finally
    //   1111	1171	1193	finally
    //   1178	1188	1193	finally
    //   22	49	1196	java/lang/Throwable
    //   57	75	1196	java/lang/Throwable
    //   83	94	1196	java/lang/Throwable
    //   97	248	1196	java/lang/Throwable
    //   248	311	1196	java/lang/Throwable
    //   316	332	1196	java/lang/Throwable
    //   335	379	1196	java/lang/Throwable
    //   379	441	1196	java/lang/Throwable
    //   441	472	1196	java/lang/Throwable
    //   484	530	1196	java/lang/Throwable
    //   535	552	1196	java/lang/Throwable
    //   552	600	1196	java/lang/Throwable
    //   603	669	1196	java/lang/Throwable
    //   672	784	1196	java/lang/Throwable
    //   791	800	1196	java/lang/Throwable
    //   804	810	1196	java/lang/Throwable
    //   810	816	1196	java/lang/Throwable
    //   817	877	1196	java/lang/Throwable
    //   885	910	1196	java/lang/Throwable
    //   913	938	1196	java/lang/Throwable
    //   941	963	1196	java/lang/Throwable
    //   969	991	1196	java/lang/Throwable
    //   991	1045	1196	java/lang/Throwable
    //   1045	1056	1196	java/lang/Throwable
    //   1063	1069	1196	java/lang/Throwable
    //   1073	1090	1196	java/lang/Throwable
    //   1093	1102	1196	java/lang/Throwable
    //   1102	1108	1196	java/lang/Throwable
    //   1111	1171	1196	java/lang/Throwable
    //   1178	1188	1196	java/lang/Throwable
    //   1212	1218	1221	java/lang/Throwable
  }
  
  void b(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.post(new i(this, paramList, paramStatDispatchCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.g
 * JD-Core Version:    0.7.0.1
 */