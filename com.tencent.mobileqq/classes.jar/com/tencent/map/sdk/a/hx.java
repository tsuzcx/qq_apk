package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.OverSeaRequest;
import com.tencent.map.tools.net.NetResponse;
import java.lang.ref.WeakReference;

public final class hx
  extends AsyncTask<Object, Void, Boolean>
{
  private WeakReference<Context> a;
  private WeakReference<hx.a> b;
  
  public hx(Context paramContext, hx.a parama)
  {
    this.a = new WeakReference(paramContext);
    this.b = new WeakReference(parama);
  }
  
  private Boolean a()
  {
    if (this.a.get() == null) {
      return Boolean.FALSE;
    }
    Object localObject = (Context)this.a.get();
    try
    {
      NetResponse localNetResponse = ((OverSeaRequest)((nh)MapServiceManager.getService(nh.class)).c()).checkAuth(pz.a, "4.2.8", gf.a((Context)localObject).b("worldMapProtocolVersion"), fz.a(), gf.a((Context)localObject).b("worldMapFrontierVersion"));
      if ((localNetResponse != null) && (localNetResponse.available())) {
        return Boolean.valueOf(a((Context)localObject, localNetResponse.toString()));
      }
      localObject = Boolean.FALSE;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      or.a(localThrowable.getMessage(), localThrowable);
    }
    return Boolean.FALSE;
  }
  
  /* Error */
  private static boolean a(Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +704 -> 707
    //   6: aload_1
    //   7: invokevirtual 114	java/lang/String:length	()I
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: new 116	org/json/JSONObject
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc 121
    //   27: ldc 122
    //   29: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   32: istore 4
    //   34: iconst_1
    //   35: istore_2
    //   36: iload 4
    //   38: ifeq +30 -> 68
    //   41: invokestatic 131	com/tencent/map/sdk/a/jx:d	()Z
    //   44: iconst_0
    //   45: ixor
    //   46: iconst_0
    //   47: ior
    //   48: istore 8
    //   50: iconst_0
    //   51: invokestatic 134	com/tencent/map/sdk/a/jx:a	(Z)V
    //   54: aload_0
    //   55: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   58: ldc 136
    //   60: iconst_0
    //   61: invokevirtual 139	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Z)Z
    //   64: pop
    //   65: goto +27 -> 92
    //   68: invokestatic 131	com/tencent/map/sdk/a/jx:d	()Z
    //   71: iconst_1
    //   72: ixor
    //   73: iconst_0
    //   74: ior
    //   75: istore 8
    //   77: iconst_1
    //   78: invokestatic 134	com/tencent/map/sdk/a/jx:a	(Z)V
    //   81: aload_0
    //   82: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   85: ldc 136
    //   87: iconst_1
    //   88: invokevirtual 139	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Z)Z
    //   91: pop
    //   92: aload_1
    //   93: ldc 141
    //   95: invokevirtual 145	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   98: astore 13
    //   100: aload 13
    //   102: ifnonnull +6 -> 108
    //   105: iload 8
    //   107: ireturn
    //   108: aload 13
    //   110: ldc 147
    //   112: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   115: istore 7
    //   117: iload 7
    //   119: invokestatic 152	com/tencent/map/sdk/a/jx:f	()I
    //   122: if_icmpeq +6 -> 128
    //   125: goto +5 -> 130
    //   128: iconst_0
    //   129: istore_2
    //   130: iload 8
    //   132: iload_2
    //   133: ior
    //   134: istore 8
    //   136: iload 8
    //   138: ifne +6 -> 144
    //   141: iload 8
    //   143: ireturn
    //   144: aload 13
    //   146: ldc 154
    //   148: invokevirtual 145	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   151: astore_1
    //   152: aconst_null
    //   153: astore 9
    //   155: aload_1
    //   156: ifnull +167 -> 323
    //   159: aload_1
    //   160: ldc 156
    //   162: invokevirtual 160	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +156 -> 323
    //   170: aload_1
    //   171: invokevirtual 114	java/lang/String:length	()I
    //   174: ifne +6 -> 180
    //   177: goto +146 -> 323
    //   180: new 162	java/net/URL
    //   183: dup
    //   184: aload_1
    //   185: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 167	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   191: checkcast 169	java/net/HttpURLConnection
    //   194: astore_1
    //   195: aload_1
    //   196: ldc 171
    //   198: ldc 173
    //   200: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_1
    //   204: invokevirtual 180	java/net/HttpURLConnection:getResponseCode	()I
    //   207: sipush 200
    //   210: if_icmpne +107 -> 317
    //   213: aload_1
    //   214: ldc 182
    //   216: invokevirtual 185	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore 10
    //   221: aload 10
    //   223: ifnull +22 -> 245
    //   226: aload 10
    //   228: invokevirtual 114	java/lang/String:length	()I
    //   231: ifle +14 -> 245
    //   234: aload 10
    //   236: invokevirtual 188	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   239: ldc 173
    //   241: invokevirtual 192	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   244: pop
    //   245: new 194	java/util/zip/GZIPInputStream
    //   248: dup
    //   249: aload_1
    //   250: invokevirtual 198	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   253: invokespecial 201	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   256: astore_1
    //   257: new 110	java/lang/String
    //   260: dup
    //   261: aload_1
    //   262: invokestatic 206	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   265: invokespecial 209	java/lang/String:<init>	([B)V
    //   268: astore 9
    //   270: invokestatic 214	com/tencent/map/sdk/a/jv:a	()Lcom/tencent/map/sdk/a/jv;
    //   273: pop
    //   274: aload 9
    //   276: invokestatic 215	com/tencent/map/sdk/a/jv:b	(Ljava/lang/String;)I
    //   279: istore_2
    //   280: aload_0
    //   281: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   284: ldc 78
    //   286: iload_2
    //   287: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   290: pop
    //   291: invokestatic 214	com/tencent/map/sdk/a/jv:a	()Lcom/tencent/map/sdk/a/jv;
    //   294: aload 9
    //   296: invokevirtual 221	com/tencent/map/sdk/a/jv:a	(Ljava/lang/String;)Z
    //   299: pop
    //   300: goto +19 -> 319
    //   303: astore_0
    //   304: goto +7 -> 311
    //   307: astore_0
    //   308: aload 9
    //   310: astore_1
    //   311: aload_1
    //   312: invokestatic 224	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   315: aload_0
    //   316: athrow
    //   317: aconst_null
    //   318: astore_1
    //   319: aload_1
    //   320: invokestatic 224	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   323: aload 13
    //   325: ldc 226
    //   327: invokevirtual 145	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   330: astore_1
    //   331: iconst_0
    //   332: newarray int
    //   334: astore 10
    //   336: ldc 228
    //   338: astore 12
    //   340: aload_1
    //   341: ifnull +208 -> 549
    //   344: aload_1
    //   345: ldc 230
    //   347: sipush 1000
    //   350: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   353: istore 5
    //   355: aload_1
    //   356: ldc 232
    //   358: getstatic 237	com/tencent/map/sdk/a/jy:a	I
    //   361: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   364: istore 4
    //   366: aload_1
    //   367: ldc 147
    //   369: getstatic 239	com/tencent/map/sdk/a/jy:b	I
    //   372: invokevirtual 126	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   375: istore 6
    //   377: aload_1
    //   378: ldc 241
    //   380: invokevirtual 160	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 11
    //   385: aload_1
    //   386: ldc 243
    //   388: invokevirtual 247	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   391: astore 14
    //   393: aload 10
    //   395: astore 9
    //   397: aload 12
    //   399: astore_1
    //   400: aload 11
    //   402: invokestatic 250	com/tencent/map/sdk/a/nl:a	(Ljava/lang/String;)Z
    //   405: ifne +56 -> 461
    //   408: aload 10
    //   410: astore 9
    //   412: aload 12
    //   414: astore_1
    //   415: aload 14
    //   417: ifnull +44 -> 461
    //   420: aload 14
    //   422: invokevirtual 253	org/json/JSONArray:toString	()Ljava/lang/String;
    //   425: astore_1
    //   426: aload 14
    //   428: invokevirtual 254	org/json/JSONArray:length	()I
    //   431: newarray int
    //   433: astore 9
    //   435: iload_3
    //   436: istore_2
    //   437: iload_2
    //   438: aload 9
    //   440: arraylength
    //   441: if_icmpge +20 -> 461
    //   444: aload 9
    //   446: iload_2
    //   447: aload 14
    //   449: iload_2
    //   450: invokevirtual 257	org/json/JSONArray:optInt	(I)I
    //   453: iastore
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -21 -> 437
    //   461: iload 6
    //   463: invokestatic 259	com/tencent/map/sdk/a/jx:c	()I
    //   466: if_icmpne +11 -> 477
    //   469: iload 5
    //   471: invokestatic 261	com/tencent/map/sdk/a/jx:a	()I
    //   474: if_icmpeq +56 -> 530
    //   477: new 263	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   484: astore 10
    //   486: aload 10
    //   488: aload_0
    //   489: invokestatic 270	com/tencent/tencentmap/io/QStorageManager:getStorageRootPath	(Landroid/content/Context;)Ljava/lang/String;
    //   492: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 10
    //   498: getstatic 279	java/io/File:separator	Ljava/lang/String;
    //   501: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 10
    //   507: ldc_w 281
    //   510: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: new 276	java/io/File
    //   517: dup
    //   518: aload 10
    //   520: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokespecial 283	java/io/File:<init>	(Ljava/lang/String;)V
    //   526: invokestatic 288	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   529: pop
    //   530: iload 6
    //   532: istore_2
    //   533: aload 9
    //   535: astore 10
    //   537: iload 5
    //   539: istore_3
    //   540: aload_1
    //   541: astore 9
    //   543: aload 11
    //   545: astore_1
    //   546: goto +16 -> 562
    //   549: aconst_null
    //   550: astore_1
    //   551: ldc 228
    //   553: astore 9
    //   555: iconst_m1
    //   556: istore_3
    //   557: iconst_m1
    //   558: istore 4
    //   560: iconst_m1
    //   561: istore_2
    //   562: aload 13
    //   564: ldc_w 290
    //   567: invokevirtual 247	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   570: astore 11
    //   572: aload 11
    //   574: ifnull +13 -> 587
    //   577: aload 11
    //   579: invokevirtual 253	org/json/JSONArray:toString	()Ljava/lang/String;
    //   582: astore 11
    //   584: goto +8 -> 592
    //   587: ldc_w 292
    //   590: astore 11
    //   592: iload 4
    //   594: iload_3
    //   595: iload_2
    //   596: iload 7
    //   598: aload_1
    //   599: aload 10
    //   601: aload 11
    //   603: invokestatic 295	com/tencent/map/sdk/a/jx:a	(IIIILjava/lang/String;[ILjava/lang/String;)V
    //   606: aload_0
    //   607: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   610: ldc_w 297
    //   613: aload_1
    //   614: invokevirtual 300	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   617: pop
    //   618: aload_0
    //   619: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   622: ldc_w 302
    //   625: aload 9
    //   627: invokevirtual 300	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   630: pop
    //   631: aload_0
    //   632: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   635: ldc_w 304
    //   638: iload_2
    //   639: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   642: pop
    //   643: aload_0
    //   644: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   647: ldc_w 306
    //   650: iload_3
    //   651: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   654: pop
    //   655: aload_0
    //   656: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   659: ldc_w 308
    //   662: iload 4
    //   664: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   667: pop
    //   668: aload_0
    //   669: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   672: ldc_w 310
    //   675: aload 11
    //   677: invokevirtual 300	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   680: pop
    //   681: aload_0
    //   682: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   685: ldc 68
    //   687: iload 7
    //   689: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   692: pop
    //   693: iload 8
    //   695: ireturn
    //   696: aload_0
    //   697: invokestatic 66	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   700: ldc 68
    //   702: iconst_0
    //   703: invokevirtual 218	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   706: pop
    //   707: iconst_0
    //   708: ireturn
    //   709: astore_1
    //   710: goto -14 -> 696
    //   713: astore_1
    //   714: goto -397 -> 317
    //   717: astore 9
    //   719: goto -400 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	paramContext	Context
    //   0	722	1	paramString	java.lang.String
    //   35	604	2	i	int
    //   1	650	3	j	int
    //   32	631	4	k	int
    //   353	185	5	m	int
    //   375	156	6	n	int
    //   115	573	7	i1	int
    //   48	646	8	i2	int
    //   153	473	9	localObject1	Object
    //   717	1	9	localThrowable	Throwable
    //   219	381	10	localObject2	Object
    //   383	293	11	localObject3	Object
    //   338	75	12	str	java.lang.String
    //   98	465	13	localJSONObject	org.json.JSONObject
    //   391	57	14	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   257	300	303	finally
    //   180	221	307	finally
    //   226	245	307	finally
    //   245	257	307	finally
    //   15	24	709	java/lang/Exception
    //   180	221	713	java/lang/Throwable
    //   226	245	713	java/lang/Throwable
    //   245	257	713	java/lang/Throwable
    //   257	300	717	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hx
 * JD-Core Version:    0.7.0.1
 */