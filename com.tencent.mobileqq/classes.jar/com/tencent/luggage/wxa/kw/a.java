package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.pw.f;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends com.tencent.luggage.wxa.jx.a<u>
{
  protected final String a(int paramInt)
  {
    com.tencent.luggage.wxa.id.a locala = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandJsInput@");
    localStringBuilder.append(paramInt);
    return locala.a(localStringBuilder.toString(), true).b("passing_data", "");
  }
  
  protected final void a(int paramInt, u paramu)
  {
    if (paramu == null) {
      return;
    }
    com.tencent.luggage.wxa.id.a locala = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandJsInput@");
    localStringBuilder.append(paramInt);
    locala.a(localStringBuilder.toString(), true).a("webview_reference", new WeakReference(paramu));
  }
  
  protected final void a(int paramInt, String paramString)
  {
    com.tencent.luggage.wxa.id.a locala = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandJsInput@");
    localStringBuilder.append(paramInt);
    locala.a(localStringBuilder.toString(), true).a("passing_data", paramString);
  }
  
  /* Error */
  @androidx.annotation.CallSuper
  protected boolean a(P paramP, org.json.JSONObject paramJSONObject, u paramu, int paramInt)
  {
    // Byte code:
    //   0: new 69	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: ldc 71
    //   7: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 78	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload_1
    //   16: aload 5
    //   18: ldc 80
    //   20: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 97	com/tencent/luggage/wxa/pw/f:j	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 99
    //   34: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 102	com/tencent/luggage/wxa/pw/f:k	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 104
    //   48: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 107	com/tencent/luggage/wxa/pw/f:l	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 109
    //   62: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 112	com/tencent/luggage/wxa/pw/f:m	Ljava/lang/Integer;
    //   71: goto +53 -> 124
    //   74: astore 6
    //   76: goto +8 -> 84
    //   79: astore 6
    //   81: aconst_null
    //   82: astore 5
    //   84: aload_0
    //   85: invokevirtual 116	com/tencent/luggage/wxa/kw/a:c	()Z
    //   88: ifne +36 -> 124
    //   91: ldc 118
    //   93: ldc 120
    //   95: iconst_1
    //   96: anewarray 122	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload 6
    //   103: invokestatic 127	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 132	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: iload 4
    //   113: aload_0
    //   114: ldc 134
    //   116: invokevirtual 136	com/tencent/luggage/wxa/kw/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual 140	com/tencent/mm/plugin/appbrand/page/u:a	(ILjava/lang/String;)V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload 5
    //   126: ifnonnull +31 -> 157
    //   129: aload_0
    //   130: invokevirtual 116	com/tencent/luggage/wxa/kw/a:c	()Z
    //   133: ifne +225 -> 358
    //   136: ldc 118
    //   138: ldc 142
    //   140: invokestatic 145	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_3
    //   144: iload 4
    //   146: aload_0
    //   147: ldc 134
    //   149: invokevirtual 136	com/tencent/luggage/wxa/kw/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokevirtual 140	com/tencent/mm/plugin/appbrand/page/u:a	(ILjava/lang/String;)V
    //   155: iconst_0
    //   156: ireturn
    //   157: aload_1
    //   158: aload 5
    //   160: ldc 147
    //   162: aconst_null
    //   163: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: putfield 154	com/tencent/luggage/wxa/pw/f:u	Ljava/lang/String;
    //   169: aload_1
    //   170: aload 5
    //   172: ldc 156
    //   174: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   177: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: putfield 159	com/tencent/luggage/wxa/pw/f:n	Ljava/lang/Integer;
    //   183: aload_1
    //   184: aload 5
    //   186: ldc 161
    //   188: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   191: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: putfield 164	com/tencent/luggage/wxa/pw/f:o	Ljava/lang/Integer;
    //   197: aload_1
    //   198: aload 5
    //   200: ldc 166
    //   202: aconst_null
    //   203: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: putfield 169	com/tencent/luggage/wxa/pw/f:p	Ljava/lang/String;
    //   209: aload_1
    //   210: aload 5
    //   212: ldc 171
    //   214: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   217: ldc 172
    //   219: invokestatic 175	com/tencent/luggage/wxa/pc/g:a	(Ljava/lang/String;I)I
    //   222: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: putfield 178	com/tencent/luggage/wxa/pw/f:r	Ljava/lang/Integer;
    //   228: aload_1
    //   229: aload 5
    //   231: ldc 180
    //   233: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: iconst_0
    //   237: invokestatic 175	com/tencent/luggage/wxa/pc/g:a	(Ljava/lang/String;I)I
    //   240: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: putfield 183	com/tencent/luggage/wxa/pw/f:q	Ljava/lang/Integer;
    //   246: aload_1
    //   247: aload 5
    //   249: ldc 185
    //   251: invokestatic 188	com/tencent/luggage/wxa/pc/g:c	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   254: invokestatic 193	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   257: putfield 197	com/tencent/luggage/wxa/pw/f:s	Ljava/lang/Float;
    //   260: aload_1
    //   261: aload 5
    //   263: ldc 199
    //   265: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   268: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: putfield 202	com/tencent/luggage/wxa/pw/f:G	Ljava/lang/Integer;
    //   274: goto +8 -> 282
    //   277: aload_1
    //   278: aconst_null
    //   279: putfield 202	com/tencent/luggage/wxa/pw/f:G	Ljava/lang/Integer;
    //   282: aload_1
    //   283: aload 5
    //   285: ldc 204
    //   287: invokevirtual 208	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   290: invokestatic 213	com/tencent/luggage/wxa/pw/d:a	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   293: putfield 216	com/tencent/luggage/wxa/pw/f:K	Ljava/lang/Integer;
    //   296: aload_1
    //   297: getfield 216	com/tencent/luggage/wxa/pw/f:K	Ljava/lang/Integer;
    //   300: ifnull +20 -> 320
    //   303: aload_1
    //   304: aload_1
    //   305: getfield 216	com/tencent/luggage/wxa/pw/f:K	Ljava/lang/Integer;
    //   308: invokevirtual 220	java/lang/Integer:intValue	()I
    //   311: invokestatic 223	com/tencent/luggage/wxa/pc/g:c	(I)I
    //   314: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: putfield 216	com/tencent/luggage/wxa/pw/f:K	Ljava/lang/Integer;
    //   320: aload_1
    //   321: aload 5
    //   323: ldc 225
    //   325: invokevirtual 208	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   328: invokestatic 213	com/tencent/luggage/wxa/pw/d:a	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   331: putfield 228	com/tencent/luggage/wxa/pw/f:L	Ljava/lang/Integer;
    //   334: aload_1
    //   335: getfield 228	com/tencent/luggage/wxa/pw/f:L	Ljava/lang/Integer;
    //   338: ifnull +20 -> 358
    //   341: aload_1
    //   342: aload_1
    //   343: getfield 228	com/tencent/luggage/wxa/pw/f:L	Ljava/lang/Integer;
    //   346: invokevirtual 220	java/lang/Integer:intValue	()I
    //   349: invokestatic 223	com/tencent/luggage/wxa/pc/g:c	(I)I
    //   352: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: putfield 228	com/tencent/luggage/wxa/pw/f:L	Ljava/lang/Integer;
    //   358: aload_1
    //   359: aload_2
    //   360: ldc 230
    //   362: invokevirtual 234	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   365: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   368: putfield 243	com/tencent/luggage/wxa/pw/f:E	Ljava/lang/Boolean;
    //   371: aload_1
    //   372: aload_2
    //   373: ldc 245
    //   375: aload_2
    //   376: ldc 247
    //   378: aconst_null
    //   379: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   382: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   385: putfield 250	com/tencent/luggage/wxa/pw/f:i	Ljava/lang/String;
    //   388: aload_1
    //   389: aload_2
    //   390: ldc 252
    //   392: invokevirtual 256	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   395: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: putfield 259	com/tencent/luggage/wxa/pw/f:v	Ljava/lang/Integer;
    //   401: aload_2
    //   402: ldc_w 261
    //   405: invokevirtual 264	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   408: ifeq +18 -> 426
    //   411: aload_1
    //   412: aload_2
    //   413: ldc_w 261
    //   416: aconst_null
    //   417: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   420: putfield 267	com/tencent/luggage/wxa/pw/f:w	Ljava/lang/String;
    //   423: goto +8 -> 431
    //   426: aload_1
    //   427: aconst_null
    //   428: putfield 267	com/tencent/luggage/wxa/pw/f:w	Ljava/lang/String;
    //   431: getstatic 272	com/tencent/luggage/util/k:a	Lcom/tencent/luggage/util/k;
    //   434: invokevirtual 274	com/tencent/luggage/util/k:a	()Z
    //   437: ifeq +21 -> 458
    //   440: new 69	org/json/JSONObject
    //   443: dup
    //   444: aload_2
    //   445: ldc_w 276
    //   448: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: invokespecial 78	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   454: astore_3
    //   455: goto +18 -> 473
    //   458: new 69	org/json/JSONObject
    //   461: dup
    //   462: aload_2
    //   463: ldc_w 278
    //   466: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: invokespecial 78	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   472: astore_3
    //   473: aload_1
    //   474: aload_3
    //   475: ldc 171
    //   477: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   480: invokestatic 280	com/tencent/luggage/wxa/pc/g:b	(Ljava/lang/String;)I
    //   483: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   486: putfield 283	com/tencent/luggage/wxa/pw/f:z	Ljava/lang/Integer;
    //   489: aload_1
    //   490: aload_3
    //   491: ldc 185
    //   493: invokestatic 85	com/tencent/luggage/wxa/pc/g:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   496: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: putfield 286	com/tencent/luggage/wxa/pw/f:y	Ljava/lang/Integer;
    //   502: aload_1
    //   503: aload_3
    //   504: ldc 147
    //   506: ldc_w 288
    //   509: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 291	com/tencent/luggage/wxa/pw/f:x	Ljava/lang/String;
    //   515: aload_1
    //   516: aload_2
    //   517: ldc_w 293
    //   520: invokevirtual 234	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   523: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   526: putfield 296	com/tencent/luggage/wxa/pw/f:B	Ljava/lang/Boolean;
    //   529: goto +8 -> 537
    //   532: aload_1
    //   533: aconst_null
    //   534: putfield 296	com/tencent/luggage/wxa/pw/f:B	Ljava/lang/Boolean;
    //   537: aload_1
    //   538: aload_2
    //   539: ldc_w 298
    //   542: invokevirtual 234	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   545: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   548: putfield 301	com/tencent/luggage/wxa/pw/f:A	Ljava/lang/Boolean;
    //   551: goto +8 -> 559
    //   554: aload_1
    //   555: aconst_null
    //   556: putfield 301	com/tencent/luggage/wxa/pw/f:A	Ljava/lang/Boolean;
    //   559: aload_1
    //   560: aload_2
    //   561: ldc_w 303
    //   564: invokevirtual 234	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   567: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   570: putfield 306	com/tencent/luggage/wxa/pw/f:F	Ljava/lang/Boolean;
    //   573: goto +8 -> 581
    //   576: aload_1
    //   577: aconst_null
    //   578: putfield 306	com/tencent/luggage/wxa/pw/f:F	Ljava/lang/Boolean;
    //   581: aload_1
    //   582: aload_2
    //   583: ldc_w 308
    //   586: invokevirtual 310	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 315	com/tencent/luggage/wxa/pw/b:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/pw/b;
    //   592: putfield 319	com/tencent/luggage/wxa/pw/f:H	Lcom/tencent/luggage/wxa/pw/b;
    //   595: aload_1
    //   596: aload_2
    //   597: ldc_w 321
    //   600: invokevirtual 234	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   603: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   606: putfield 324	com/tencent/luggage/wxa/pw/f:I	Ljava/lang/Boolean;
    //   609: goto +8 -> 617
    //   612: aload_1
    //   613: aconst_null
    //   614: putfield 324	com/tencent/luggage/wxa/pw/f:I	Ljava/lang/Boolean;
    //   617: aload_1
    //   618: aload_2
    //   619: ldc_w 326
    //   622: invokevirtual 208	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   625: invokestatic 331	com/tencent/luggage/util/g:a	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   628: putfield 334	com/tencent/luggage/wxa/pw/f:J	Ljava/lang/Boolean;
    //   631: iconst_1
    //   632: ireturn
    //   633: astore 6
    //   635: goto -592 -> 43
    //   638: astore_3
    //   639: goto -456 -> 183
    //   642: astore_3
    //   643: goto -446 -> 197
    //   646: astore_3
    //   647: goto -419 -> 228
    //   650: astore_3
    //   651: goto -405 -> 246
    //   654: astore_3
    //   655: goto -395 -> 260
    //   658: astore_3
    //   659: goto -382 -> 277
    //   662: astore_3
    //   663: goto -292 -> 371
    //   666: astore_3
    //   667: goto -266 -> 401
    //   670: astore_3
    //   671: goto -156 -> 515
    //   674: astore_3
    //   675: goto -143 -> 532
    //   678: astore_3
    //   679: goto -125 -> 554
    //   682: astore_3
    //   683: goto -107 -> 576
    //   686: astore_3
    //   687: goto -75 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	a
    //   0	690	1	paramP	P
    //   0	690	2	paramJSONObject	org.json.JSONObject
    //   0	690	3	paramu	u
    //   0	690	4	paramInt	int
    //   13	309	5	localJSONObject	org.json.JSONObject
    //   74	1	6	localException1	java.lang.Exception
    //   79	23	6	localException2	java.lang.Exception
    //   633	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	29	74	java/lang/Exception
    //   43	71	74	java/lang/Exception
    //   0	15	79	java/lang/Exception
    //   29	43	633	java/lang/Exception
    //   169	183	638	java/lang/Exception
    //   183	197	642	java/lang/Exception
    //   209	228	646	java/lang/Exception
    //   228	246	650	java/lang/Exception
    //   246	260	654	java/lang/Exception
    //   260	274	658	java/lang/Exception
    //   358	371	662	java/lang/Exception
    //   388	401	666	java/lang/Exception
    //   431	455	670	java/lang/Exception
    //   458	473	670	java/lang/Exception
    //   473	515	670	java/lang/Exception
    //   515	529	674	org/json/JSONException
    //   537	551	678	java/lang/Exception
    //   559	573	682	java/lang/Exception
    //   595	609	686	java/lang/Exception
  }
  
  protected final u b(int paramInt)
  {
    Object localObject = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandJsInput@");
    localStringBuilder.append(paramInt);
    localObject = ((com.tencent.luggage.wxa.id.a)localObject).a(localStringBuilder.toString());
    if (localObject == null) {
      return null;
    }
    localObject = (WeakReference)((a.b)localObject).b("webview_reference", null);
    if (localObject == null) {
      return null;
    }
    return (u)((WeakReference)localObject).get();
  }
  
  protected boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.a
 * JD-Core Version:    0.7.0.1
 */