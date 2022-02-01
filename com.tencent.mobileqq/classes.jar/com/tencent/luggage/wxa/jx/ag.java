package com.tencent.luggage.wxa.jx;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.s;

public class ag<S extends h>
  extends a<S>
{
  public static final int CTRL_INDEX = 250;
  public static final String NAME = "captureScreen";
  
  public Bitmap a(S paramS)
  {
    paramS = paramS.v();
    if (paramS == null) {
      return null;
    }
    return (Bitmap)new ag.1(this, paramS).a(new s(Looper.getMainLooper()));
  }
  
  /* Error */
  public void a(S paramS, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: ldc 57
    //   2: ldc 59
    //   4: iconst_1
    //   5: anewarray 61	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: invokevirtual 65	com/tencent/luggage/wxa/iu/h:getAppId	()Ljava/lang/String;
    //   14: aastore
    //   15: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_1
    //   19: invokevirtual 75	com/tencent/luggage/wxa/iu/h:q	()Lcom/tencent/luggage/wxa/iu/d;
    //   22: invokevirtual 81	com/tencent/luggage/wxa/iu/d:C	()Lcom/tencent/mm/plugin/appbrand/page/o;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +523 -> 550
    //   30: aload_2
    //   31: invokevirtual 86	com/tencent/mm/plugin/appbrand/page/o:getPageView	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   34: ifnonnull +6 -> 40
    //   37: goto +513 -> 550
    //   40: aload_2
    //   41: invokevirtual 86	com/tencent/mm/plugin/appbrand/page/o:getPageView	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   44: ifnonnull +22 -> 66
    //   47: ldc 57
    //   49: ldc 88
    //   51: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_1
    //   55: iload_3
    //   56: aload_0
    //   57: ldc 94
    //   59: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   65: return
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 102	com/tencent/luggage/wxa/jx/ag:a	(Lcom/tencent/luggage/wxa/iu/h;)Landroid/graphics/Bitmap;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnonnull +22 -> 95
    //   76: ldc 57
    //   78: ldc 104
    //   80: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: iload_3
    //   85: aload_0
    //   86: ldc 106
    //   88: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   94: return
    //   95: new 108	com/tencent/luggage/wxa/pc/i
    //   98: dup
    //   99: invokespecial 109	com/tencent/luggage/wxa/pc/i:<init>	()V
    //   102: astore 4
    //   104: aload_1
    //   105: invokevirtual 113	com/tencent/luggage/wxa/iu/h:getFileSystem	()Lcom/tencent/mm/plugin/appbrand/appstorage/o;
    //   108: aload 4
    //   110: invokeinterface 118 2 0
    //   115: getstatic 123	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   118: if_acmpeq +15 -> 133
    //   121: aload_1
    //   122: iload_3
    //   123: aload_0
    //   124: ldc 125
    //   126: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   132: return
    //   133: aload 4
    //   135: getfield 128	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   138: checkcast 130	java/lang/String
    //   141: astore 4
    //   143: new 132	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   150: astore 5
    //   152: aload 5
    //   154: ldc 135
    //   156: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 5
    //   162: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   165: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: new 150	com/tencent/luggage/wxa/rt/i
    //   172: dup
    //   173: aload 4
    //   175: aload 5
    //   177: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 155	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: invokevirtual 158	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   186: astore 5
    //   188: ldc 57
    //   190: ldc 160
    //   192: iconst_1
    //   193: anewarray 61	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 5
    //   200: aastore
    //   201: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: bipush 100
    //   207: getstatic 166	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   210: aload 5
    //   212: iconst_1
    //   213: invokestatic 171	com/tencent/luggage/wxa/qz/b:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   216: new 108	com/tencent/luggage/wxa/pc/i
    //   219: dup
    //   220: invokespecial 109	com/tencent/luggage/wxa/pc/i:<init>	()V
    //   223: astore 4
    //   225: aload_1
    //   226: invokevirtual 113	com/tencent/luggage/wxa/iu/h:getFileSystem	()Lcom/tencent/mm/plugin/appbrand/appstorage/o;
    //   229: new 150	com/tencent/luggage/wxa/rt/i
    //   232: dup
    //   233: aload 5
    //   235: invokespecial 174	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   238: ldc 176
    //   240: iconst_1
    //   241: aload 4
    //   243: invokeinterface 179 5 0
    //   248: getstatic 123	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   251: if_acmpeq +61 -> 312
    //   254: ldc 57
    //   256: ldc 181
    //   258: iconst_1
    //   259: anewarray 61	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload 5
    //   266: aastore
    //   267: invokestatic 184	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_1
    //   271: iload_3
    //   272: aload_0
    //   273: ldc 125
    //   275: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   281: aload_2
    //   282: ifnull +29 -> 311
    //   285: aload_2
    //   286: invokevirtual 188	android/graphics/Bitmap:isRecycled	()Z
    //   289: ifne +22 -> 311
    //   292: ldc 57
    //   294: ldc 190
    //   296: iconst_1
    //   297: anewarray 61	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_2
    //   303: aastore
    //   304: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_2
    //   308: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   311: return
    //   312: new 195	java/util/HashMap
    //   315: dup
    //   316: invokespecial 196	java/util/HashMap:<init>	()V
    //   319: astore 5
    //   321: aload 5
    //   323: ldc 198
    //   325: aload 4
    //   327: getfield 128	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   330: invokevirtual 202	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: ldc 57
    //   336: ldc 204
    //   338: iconst_1
    //   339: anewarray 61	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: aload 4
    //   346: getfield 128	com/tencent/luggage/wxa/pc/i:a	Ljava/lang/Object;
    //   349: aastore
    //   350: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload_1
    //   354: iload_3
    //   355: aload_0
    //   356: ldc 206
    //   358: aload 5
    //   360: invokevirtual 209	com/tencent/luggage/wxa/jx/ag:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   363: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   366: aload_2
    //   367: ifnull +150 -> 517
    //   370: aload_2
    //   371: invokevirtual 188	android/graphics/Bitmap:isRecycled	()Z
    //   374: ifne +143 -> 517
    //   377: ldc 57
    //   379: ldc 190
    //   381: iconst_1
    //   382: anewarray 61	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload_2
    //   388: aastore
    //   389: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: aload_2
    //   393: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   396: return
    //   397: astore_1
    //   398: goto +120 -> 518
    //   401: astore 4
    //   403: ldc 57
    //   405: ldc 211
    //   407: iconst_1
    //   408: anewarray 61	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload 4
    //   415: aastore
    //   416: invokestatic 184	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload_1
    //   420: iload_3
    //   421: aload_0
    //   422: ldc 213
    //   424: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   427: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   430: aload_2
    //   431: ifnull +86 -> 517
    //   434: aload_2
    //   435: invokevirtual 188	android/graphics/Bitmap:isRecycled	()Z
    //   438: ifne +79 -> 517
    //   441: ldc 57
    //   443: ldc 190
    //   445: iconst_1
    //   446: anewarray 61	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload_2
    //   452: aastore
    //   453: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: goto -64 -> 392
    //   459: astore 4
    //   461: ldc 57
    //   463: ldc 211
    //   465: iconst_1
    //   466: anewarray 61	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 4
    //   473: aastore
    //   474: invokestatic 184	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: aload_1
    //   478: iload_3
    //   479: aload_0
    //   480: ldc 215
    //   482: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   485: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   488: aload_2
    //   489: ifnull +28 -> 517
    //   492: aload_2
    //   493: invokevirtual 188	android/graphics/Bitmap:isRecycled	()Z
    //   496: ifne +21 -> 517
    //   499: ldc 57
    //   501: ldc 190
    //   503: iconst_1
    //   504: anewarray 61	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload_2
    //   510: aastore
    //   511: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: goto -122 -> 392
    //   517: return
    //   518: aload_2
    //   519: ifnull +29 -> 548
    //   522: aload_2
    //   523: invokevirtual 188	android/graphics/Bitmap:isRecycled	()Z
    //   526: ifne +22 -> 548
    //   529: ldc 57
    //   531: ldc 190
    //   533: iconst_1
    //   534: anewarray 61	java/lang/Object
    //   537: dup
    //   538: iconst_0
    //   539: aload_2
    //   540: aastore
    //   541: invokestatic 71	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   544: aload_2
    //   545: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   548: aload_1
    //   549: athrow
    //   550: ldc 57
    //   552: ldc 88
    //   554: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_1
    //   558: iload_3
    //   559: aload_0
    //   560: ldc 94
    //   562: invokevirtual 97	com/tencent/luggage/wxa/jx/ag:b	(Ljava/lang/String;)Ljava/lang/String;
    //   565: invokevirtual 100	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   568: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	ag
    //   0	569	1	paramS	S
    //   0	569	2	paramJSONObject	org.json.JSONObject
    //   0	569	3	paramInt	int
    //   102	243	4	localObject1	java.lang.Object
    //   401	13	4	localException	java.lang.Exception
    //   459	13	4	localIOException	java.io.IOException
    //   150	209	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   204	281	397	finally
    //   312	366	397	finally
    //   403	430	397	finally
    //   461	488	397	finally
    //   204	281	401	java/lang/Exception
    //   312	366	401	java/lang/Exception
    //   204	281	459	java/io/IOException
    //   312	366	459	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ag
 * JD-Core Version:    0.7.0.1
 */