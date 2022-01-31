package com.tencent.biz.qqstory.takevideo2;

import android.content.Context;
import com.tribe.async.reactive.StreamFunction;

public class GetFirstMediaThumbnailFunction
  extends StreamFunction
{
  private Context a;
  
  public GetFirstMediaThumbnailFunction(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context should not be null");
    }
    this.a = paramContext;
  }
  
  /* Error */
  public android.graphics.Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: getfield 20	com/tencent/biz/qqstory/takevideo2/GetFirstMediaThumbnailFunction:a	Landroid/content/Context;
    //   7: invokevirtual 30	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 13
    //   12: aload 13
    //   14: getstatic 36	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore 10
    //   26: aload 10
    //   28: astore 9
    //   30: aload 9
    //   32: ifnull +569 -> 601
    //   35: aload 9
    //   37: invokeinterface 48 1 0
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq +557 -> 601
    //   47: lconst_0
    //   48: lstore_3
    //   49: aconst_null
    //   50: astore 12
    //   52: lload_3
    //   53: lstore 7
    //   55: aload 12
    //   57: astore 11
    //   59: aload 9
    //   61: aload 9
    //   63: ldc 50
    //   65: invokeinterface 54 2 0
    //   70: invokeinterface 58 2 0
    //   75: istore_1
    //   76: lload_3
    //   77: lstore 7
    //   79: aload 12
    //   81: astore 11
    //   83: aload 9
    //   85: aload 9
    //   87: ldc 60
    //   89: invokeinterface 54 2 0
    //   94: invokeinterface 64 2 0
    //   99: aload 9
    //   101: aload 9
    //   103: ldc 66
    //   105: invokeinterface 54 2 0
    //   110: invokeinterface 64 2 0
    //   115: invokestatic 72	java/lang/Math:max	(JJ)J
    //   118: lstore 5
    //   120: lload 5
    //   122: lstore 7
    //   124: aload 12
    //   126: astore 11
    //   128: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +36 -> 167
    //   134: lload 5
    //   136: lstore 7
    //   138: aload 12
    //   140: astore 11
    //   142: ldc 79
    //   144: iconst_2
    //   145: new 81	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   152: ldc 84
    //   154: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload_1
    //   158: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: lload 5
    //   169: lstore 7
    //   171: aload 12
    //   173: astore 11
    //   175: aload 13
    //   177: iload_1
    //   178: i2l
    //   179: iconst_3
    //   180: aconst_null
    //   181: invokestatic 105	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   184: astore 10
    //   186: aload 10
    //   188: ifnull +202 -> 390
    //   191: lload 5
    //   193: lstore_3
    //   194: aload 9
    //   196: ifnull +402 -> 598
    //   199: aload 9
    //   201: invokeinterface 108 1 0
    //   206: aload 13
    //   208: getstatic 111	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   211: aconst_null
    //   212: aconst_null
    //   213: aconst_null
    //   214: aconst_null
    //   215: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   218: astore 11
    //   220: aload 11
    //   222: astore 9
    //   224: aload 9
    //   226: ifnull +265 -> 491
    //   229: aload 9
    //   231: astore 11
    //   233: aload 9
    //   235: invokeinterface 48 1 0
    //   240: ifeq +251 -> 491
    //   243: aload 9
    //   245: astore 11
    //   247: aload 9
    //   249: aload 9
    //   251: ldc 50
    //   253: invokeinterface 54 2 0
    //   258: invokeinterface 58 2 0
    //   263: istore_1
    //   264: aload 9
    //   266: astore 11
    //   268: aload 9
    //   270: aload 9
    //   272: ldc 60
    //   274: invokeinterface 54 2 0
    //   279: invokeinterface 64 2 0
    //   284: aload 9
    //   286: aload 9
    //   288: ldc 66
    //   290: invokeinterface 54 2 0
    //   295: invokeinterface 64 2 0
    //   300: invokestatic 72	java/lang/Math:max	(JJ)J
    //   303: lstore 5
    //   305: aload 9
    //   307: astore 11
    //   309: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +32 -> 344
    //   315: aload 9
    //   317: astore 11
    //   319: ldc 79
    //   321: iconst_2
    //   322: new 81	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   329: ldc 113
    //   331: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: iload_1
    //   335: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 9
    //   346: astore 11
    //   348: aload 13
    //   350: iload_1
    //   351: i2l
    //   352: iconst_3
    //   353: aconst_null
    //   354: invokestatic 116	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   357: astore 12
    //   359: aload 12
    //   361: ifnull +114 -> 475
    //   364: lload 5
    //   366: lload_3
    //   367: lcmp
    //   368: ifle +123 -> 491
    //   371: aload 12
    //   373: astore 10
    //   375: aload 9
    //   377: ifnull +10 -> 387
    //   380: aload 9
    //   382: invokeinterface 108 1 0
    //   387: aload 10
    //   389: areturn
    //   390: lload 5
    //   392: lstore 7
    //   394: aload 10
    //   396: astore 11
    //   398: aload 9
    //   400: invokeinterface 119 1 0
    //   405: istore_2
    //   406: lload 5
    //   408: lstore_3
    //   409: aload 10
    //   411: astore 12
    //   413: iload_2
    //   414: ifne -362 -> 52
    //   417: lload 5
    //   419: lstore_3
    //   420: goto -226 -> 194
    //   423: astore 12
    //   425: lconst_0
    //   426: lstore_3
    //   427: aconst_null
    //   428: astore 10
    //   430: ldc 79
    //   432: iconst_2
    //   433: ldc 121
    //   435: aload 12
    //   437: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   440: aload 9
    //   442: ifnull +153 -> 595
    //   445: aload 9
    //   447: invokeinterface 108 1 0
    //   452: goto -246 -> 206
    //   455: astore 10
    //   457: aconst_null
    //   458: astore 9
    //   460: aload 9
    //   462: ifnull +10 -> 472
    //   465: aload 9
    //   467: invokeinterface 108 1 0
    //   472: aload 10
    //   474: athrow
    //   475: aload 9
    //   477: astore 11
    //   479: aload 9
    //   481: invokeinterface 119 1 0
    //   486: istore_2
    //   487: iload_2
    //   488: ifne -245 -> 243
    //   491: goto -116 -> 375
    //   494: astore 12
    //   496: aload 9
    //   498: astore 11
    //   500: ldc 79
    //   502: iconst_2
    //   503: ldc 127
    //   505: aload 12
    //   507: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 9
    //   512: ifnull +80 -> 592
    //   515: aload 9
    //   517: invokeinterface 108 1 0
    //   522: aload 10
    //   524: areturn
    //   525: astore 10
    //   527: aload 9
    //   529: astore 11
    //   531: aload 10
    //   533: astore 9
    //   535: aload 11
    //   537: ifnull +10 -> 547
    //   540: aload 11
    //   542: invokeinterface 108 1 0
    //   547: aload 9
    //   549: athrow
    //   550: astore 9
    //   552: goto -17 -> 535
    //   555: astore 12
    //   557: goto -61 -> 496
    //   560: astore 10
    //   562: goto -102 -> 460
    //   565: astore 10
    //   567: goto -107 -> 460
    //   570: astore 12
    //   572: lconst_0
    //   573: lstore_3
    //   574: aconst_null
    //   575: astore 10
    //   577: goto -147 -> 430
    //   580: astore 12
    //   582: lload 7
    //   584: lstore_3
    //   585: aload 11
    //   587: astore 10
    //   589: goto -159 -> 430
    //   592: aload 10
    //   594: areturn
    //   595: goto -389 -> 206
    //   598: goto -392 -> 206
    //   601: lconst_0
    //   602: lstore_3
    //   603: aconst_null
    //   604: astore 10
    //   606: goto -412 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	GetFirstMediaThumbnailFunction
    //   75	276	1	i	int
    //   42	446	2	bool	boolean
    //   48	555	3	l1	long
    //   118	300	5	l2	long
    //   53	530	7	l3	long
    //   1	547	9	localObject1	java.lang.Object
    //   550	1	9	localObject2	java.lang.Object
    //   24	405	10	localObject3	java.lang.Object
    //   455	68	10	localBitmap	android.graphics.Bitmap
    //   525	7	10	localObject4	java.lang.Object
    //   560	1	10	localObject5	java.lang.Object
    //   565	1	10	localObject6	java.lang.Object
    //   575	30	10	localObject7	java.lang.Object
    //   57	529	11	localObject8	java.lang.Object
    //   50	362	12	localObject9	java.lang.Object
    //   423	13	12	localException1	java.lang.Exception
    //   494	12	12	localException2	java.lang.Exception
    //   555	1	12	localException3	java.lang.Exception
    //   570	1	12	localException4	java.lang.Exception
    //   580	1	12	localException5	java.lang.Exception
    //   10	339	13	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   12	26	423	java/lang/Exception
    //   12	26	455	finally
    //   206	220	494	java/lang/Exception
    //   206	220	525	finally
    //   233	243	550	finally
    //   247	264	550	finally
    //   268	305	550	finally
    //   309	315	550	finally
    //   319	344	550	finally
    //   348	359	550	finally
    //   479	487	550	finally
    //   500	510	550	finally
    //   233	243	555	java/lang/Exception
    //   247	264	555	java/lang/Exception
    //   268	305	555	java/lang/Exception
    //   309	315	555	java/lang/Exception
    //   319	344	555	java/lang/Exception
    //   348	359	555	java/lang/Exception
    //   479	487	555	java/lang/Exception
    //   35	43	560	finally
    //   59	76	560	finally
    //   83	120	560	finally
    //   128	134	560	finally
    //   142	167	560	finally
    //   175	186	560	finally
    //   398	406	560	finally
    //   430	440	565	finally
    //   35	43	570	java/lang/Exception
    //   59	76	580	java/lang/Exception
    //   83	120	580	java/lang/Exception
    //   128	134	580	java/lang/Exception
    //   142	167	580	java/lang/Exception
    //   175	186	580	java/lang/Exception
    //   398	406	580	java/lang/Exception
  }
  
  protected void a(Void paramVoid)
  {
    notifyResult(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.GetFirstMediaThumbnailFunction
 * JD-Core Version:    0.7.0.1
 */