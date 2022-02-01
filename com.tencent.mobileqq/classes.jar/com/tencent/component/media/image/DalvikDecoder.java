package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class DalvikDecoder
  implements IDecoder
{
  private static final String TAG = "DalvikDecoder";
  public static volatile boolean loadSoSucess = true;
  ByteArrayPool mByteArrayPool;
  
  static
  {
    try
    {
      System.loadLibrary("nativeBitmap");
      return;
    }
    catch (Throwable localThrowable)
    {
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadLibrary failed ");
      localStringBuilder.append(Log.getStackTraceString(localThrowable));
      localILog.w("DalvikDecoder", new Object[] { localStringBuilder.toString() });
      loadSoSucess = false;
    }
  }
  
  public DalvikDecoder(ByteArrayPool paramByteArrayPool)
  {
    this.mByteArrayPool = paramByteArrayPool;
  }
  
  /* Error */
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 77	com/tencent/component/media/image/DalvikDecoder:setBitmapOptions	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore 4
    //   7: aload_1
    //   8: iload_2
    //   9: iload_3
    //   10: aload 4
    //   12: invokestatic 81	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +24 -> 41
    //   20: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   23: ldc 10
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc 83
    //   33: aastore
    //   34: invokeinterface 60 3 0
    //   39: aconst_null
    //   40: areturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 87	com/tencent/component/media/image/DalvikDecoder:pinBitmap	(Landroid/graphics/Bitmap;)I
    //   46: pop
    //   47: aload_1
    //   48: areturn
    //   49: astore 4
    //   51: goto +21 -> 72
    //   54: astore 4
    //   56: goto +40 -> 96
    //   59: astore 4
    //   61: goto +59 -> 120
    //   64: astore_1
    //   65: goto +79 -> 144
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_1
    //   72: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   75: ldc 10
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload 4
    //   85: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: aastore
    //   89: invokeinterface 60 3 0
    //   94: aload_1
    //   95: areturn
    //   96: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   99: ldc 10
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload 4
    //   109: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   112: aastore
    //   113: invokeinterface 60 3 0
    //   118: aload_1
    //   119: areturn
    //   120: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   123: ldc 10
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload 4
    //   133: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   136: aastore
    //   137: invokeinterface 60 3 0
    //   142: aload_1
    //   143: areturn
    //   144: aload_1
    //   145: athrow
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -54 -> 96
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -37 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	DalvikDecoder
    //   0	160	1	paramArrayOfByte	byte[]
    //   0	160	2	paramInt1	int
    //   0	160	3	paramInt2	int
    //   0	160	4	paramOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   20	39	49	java/lang/Throwable
    //   41	47	49	java/lang/Throwable
    //   20	39	54	java/lang/OutOfMemoryError
    //   41	47	54	java/lang/OutOfMemoryError
    //   20	39	59	java/lang/Exception
    //   41	47	59	java/lang/Exception
    //   7	16	64	finally
    //   20	39	64	finally
    //   41	47	64	finally
    //   72	94	64	finally
    //   96	118	64	finally
    //   120	142	64	finally
    //   7	16	68	java/lang/Throwable
    //   7	16	146	java/lang/OutOfMemoryError
    //   7	16	153	java/lang/Exception
  }
  
  private static BitmapFactory.Options setBitmapOptions(BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    localOptions.inDither = true;
    localOptions.inPurgeable = true;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    return localOptions;
  }
  
  /* Error */
  public Bitmap decodeBitmap(java.io.File paramFile, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +787 -> 788
    //   4: aload_1
    //   5: invokevirtual 117	java/io/File:exists	()Z
    //   8: ifeq +780 -> 788
    //   11: aload_1
    //   12: invokevirtual 120	java/io/File:isFile	()Z
    //   15: ifeq +773 -> 788
    //   18: aload_1
    //   19: invokevirtual 123	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 89	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 90	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: iconst_1
    //   39: putfield 126	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: new 128	java/io/BufferedInputStream
    //   45: dup
    //   46: new 130	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: sipush 8096
    //   57: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   60: astore 6
    //   62: aload 6
    //   64: astore 4
    //   66: aload 6
    //   68: aconst_null
    //   69: aload 8
    //   71: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   80: goto +176 -> 256
    //   83: astore 4
    //   85: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   88: ldc 10
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload 4
    //   98: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   101: aastore
    //   102: invokeinterface 146 3 0
    //   107: goto +149 -> 256
    //   110: astore 7
    //   112: goto +20 -> 132
    //   115: astore 7
    //   117: goto +81 -> 198
    //   120: astore_1
    //   121: aconst_null
    //   122: astore 4
    //   124: goto +630 -> 754
    //   127: astore 7
    //   129: aconst_null
    //   130: astore 6
    //   132: aload 6
    //   134: astore 4
    //   136: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   139: ldc 10
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload 7
    //   149: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   152: aastore
    //   153: invokeinterface 146 3 0
    //   158: aload 6
    //   160: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   163: goto +93 -> 256
    //   166: astore 4
    //   168: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   171: ldc 10
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 4
    //   181: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: aastore
    //   185: invokeinterface 146 3 0
    //   190: goto +66 -> 256
    //   193: astore 7
    //   195: aconst_null
    //   196: astore 6
    //   198: aload 6
    //   200: astore 4
    //   202: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   205: ldc 10
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 7
    //   215: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   218: aastore
    //   219: invokeinterface 146 3 0
    //   224: aload 6
    //   226: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   229: goto +27 -> 256
    //   232: astore 4
    //   234: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   237: ldc 10
    //   239: iconst_1
    //   240: anewarray 4	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload 4
    //   247: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   250: aastore
    //   251: invokeinterface 146 3 0
    //   256: aload 8
    //   258: iconst_0
    //   259: putfield 126	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   262: new 148	com/tencent/component/media/image/ImageLoader$Options
    //   265: dup
    //   266: invokespecial 149	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   269: astore 4
    //   271: aload 4
    //   273: iload_3
    //   274: putfield 152	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   277: aload 4
    //   279: iload_2
    //   280: putfield 155	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   283: iload_3
    //   284: ifle +27 -> 311
    //   287: iload_2
    //   288: ifle +23 -> 311
    //   291: aload 8
    //   293: aload 4
    //   295: aload 8
    //   297: getfield 158	android/graphics/BitmapFactory$Options:outWidth	I
    //   300: aload 8
    //   302: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   305: invokestatic 167	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   308: putfield 170	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   311: aload_1
    //   312: invokevirtual 174	java/io/File:length	()J
    //   315: l2i
    //   316: istore_3
    //   317: aload_0
    //   318: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   321: iload_3
    //   322: invokevirtual 180	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   325: checkcast 182	[B
    //   328: astore 7
    //   330: new 128	java/io/BufferedInputStream
    //   333: dup
    //   334: new 130	java/io/FileInputStream
    //   337: dup
    //   338: aload_1
    //   339: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   342: sipush 8192
    //   345: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   348: astore 4
    //   350: aload 4
    //   352: astore_1
    //   353: sipush 4096
    //   356: newarray byte
    //   358: astore 6
    //   360: iconst_0
    //   361: istore_2
    //   362: aload 4
    //   364: astore_1
    //   365: aload 4
    //   367: aload 6
    //   369: invokevirtual 188	java/io/InputStream:read	([B)I
    //   372: istore 5
    //   374: iload 5
    //   376: iconst_m1
    //   377: if_icmpeq +25 -> 402
    //   380: aload 4
    //   382: astore_1
    //   383: aload 6
    //   385: iconst_0
    //   386: aload 7
    //   388: iload_2
    //   389: iload 5
    //   391: invokestatic 192	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   394: iload_2
    //   395: iload 5
    //   397: iadd
    //   398: istore_2
    //   399: goto -37 -> 362
    //   402: aload 4
    //   404: astore_1
    //   405: aload_0
    //   406: aload 7
    //   408: iconst_0
    //   409: iload_3
    //   410: aload 8
    //   412: invokespecial 193	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   415: astore 6
    //   417: aload_0
    //   418: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   421: aload 7
    //   423: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   426: aload 4
    //   428: invokevirtual 198	java/io/InputStream:close	()V
    //   431: aload 6
    //   433: areturn
    //   434: astore_1
    //   435: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   438: ldc 10
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: aload_1
    //   447: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   450: aastore
    //   451: invokeinterface 60 3 0
    //   456: aload 6
    //   458: areturn
    //   459: astore 6
    //   461: goto +25 -> 486
    //   464: astore 6
    //   466: goto +95 -> 561
    //   469: astore 6
    //   471: goto +165 -> 636
    //   474: astore 4
    //   476: aconst_null
    //   477: astore_1
    //   478: goto +230 -> 708
    //   481: astore 6
    //   483: aconst_null
    //   484: astore 4
    //   486: aload 4
    //   488: astore_1
    //   489: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   492: ldc 10
    //   494: iconst_1
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload 6
    //   502: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   505: aastore
    //   506: invokeinterface 146 3 0
    //   511: aload_0
    //   512: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   515: aload 7
    //   517: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   520: aload 4
    //   522: ifnull +182 -> 704
    //   525: aload 4
    //   527: invokevirtual 198	java/io/InputStream:close	()V
    //   530: aconst_null
    //   531: areturn
    //   532: astore_1
    //   533: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   536: ldc 10
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   548: aastore
    //   549: invokeinterface 60 3 0
    //   554: aconst_null
    //   555: areturn
    //   556: astore 6
    //   558: aconst_null
    //   559: astore 4
    //   561: aload 4
    //   563: astore_1
    //   564: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   567: ldc 10
    //   569: iconst_1
    //   570: anewarray 4	java/lang/Object
    //   573: dup
    //   574: iconst_0
    //   575: aload 6
    //   577: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   580: aastore
    //   581: invokeinterface 60 3 0
    //   586: aload_0
    //   587: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   590: aload 7
    //   592: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   595: aload 4
    //   597: ifnull +107 -> 704
    //   600: aload 4
    //   602: invokevirtual 198	java/io/InputStream:close	()V
    //   605: aconst_null
    //   606: areturn
    //   607: astore_1
    //   608: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   611: ldc 10
    //   613: iconst_1
    //   614: anewarray 4	java/lang/Object
    //   617: dup
    //   618: iconst_0
    //   619: aload_1
    //   620: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   623: aastore
    //   624: invokeinterface 60 3 0
    //   629: aconst_null
    //   630: areturn
    //   631: astore 6
    //   633: aconst_null
    //   634: astore 4
    //   636: aload 4
    //   638: astore_1
    //   639: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   642: ldc 10
    //   644: iconst_1
    //   645: anewarray 4	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: aload 6
    //   652: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   655: aastore
    //   656: invokeinterface 60 3 0
    //   661: aload_0
    //   662: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   665: aload 7
    //   667: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   670: aload 4
    //   672: ifnull +32 -> 704
    //   675: aload 4
    //   677: invokevirtual 198	java/io/InputStream:close	()V
    //   680: aconst_null
    //   681: areturn
    //   682: astore_1
    //   683: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   686: ldc 10
    //   688: iconst_1
    //   689: anewarray 4	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: aload_1
    //   695: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   698: aastore
    //   699: invokeinterface 60 3 0
    //   704: aconst_null
    //   705: areturn
    //   706: astore 4
    //   708: aload_0
    //   709: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   712: aload 7
    //   714: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   717: aload_1
    //   718: ifnull +32 -> 750
    //   721: aload_1
    //   722: invokevirtual 198	java/io/InputStream:close	()V
    //   725: goto +25 -> 750
    //   728: astore_1
    //   729: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   732: ldc 10
    //   734: iconst_1
    //   735: anewarray 4	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload_1
    //   741: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   744: aastore
    //   745: invokeinterface 60 3 0
    //   750: aload 4
    //   752: athrow
    //   753: astore_1
    //   754: aload 4
    //   756: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   759: goto +27 -> 786
    //   762: astore 4
    //   764: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   767: ldc 10
    //   769: iconst_1
    //   770: anewarray 4	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: aload 4
    //   777: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   780: aastore
    //   781: invokeinterface 146 3 0
    //   786: aload_1
    //   787: athrow
    //   788: aconst_null
    //   789: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	DalvikDecoder
    //   0	790	1	paramFile	java.io.File
    //   0	790	2	paramInt1	int
    //   0	790	3	paramInt2	int
    //   0	790	4	paramBitmap	Bitmap
    //   372	26	5	i	int
    //   60	397	6	localObject	Object
    //   459	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   464	1	6	localIOException1	java.io.IOException
    //   469	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   481	20	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   556	20	6	localIOException2	java.io.IOException
    //   631	20	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   110	1	7	localThrowable1	Throwable
    //   115	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   127	21	7	localThrowable2	Throwable
    //   193	21	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   328	385	7	arrayOfByte	byte[]
    //   34	377	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   75	80	83	java/io/IOException
    //   66	75	110	java/lang/Throwable
    //   66	75	115	java/io/FileNotFoundException
    //   42	62	120	finally
    //   42	62	127	java/lang/Throwable
    //   158	163	166	java/io/IOException
    //   42	62	193	java/io/FileNotFoundException
    //   224	229	232	java/io/IOException
    //   426	431	434	java/lang/Exception
    //   353	360	459	java/lang/OutOfMemoryError
    //   365	374	459	java/lang/OutOfMemoryError
    //   383	394	459	java/lang/OutOfMemoryError
    //   405	417	459	java/lang/OutOfMemoryError
    //   353	360	464	java/io/IOException
    //   365	374	464	java/io/IOException
    //   383	394	464	java/io/IOException
    //   405	417	464	java/io/IOException
    //   353	360	469	java/io/FileNotFoundException
    //   365	374	469	java/io/FileNotFoundException
    //   383	394	469	java/io/FileNotFoundException
    //   405	417	469	java/io/FileNotFoundException
    //   330	350	474	finally
    //   330	350	481	java/lang/OutOfMemoryError
    //   525	530	532	java/lang/Exception
    //   330	350	556	java/io/IOException
    //   600	605	607	java/lang/Exception
    //   330	350	631	java/io/FileNotFoundException
    //   675	680	682	java/lang/Exception
    //   353	360	706	finally
    //   365	374	706	finally
    //   383	394	706	finally
    //   405	417	706	finally
    //   489	511	706	finally
    //   564	586	706	finally
    //   639	661	706	finally
    //   721	725	728	java/lang/Exception
    //   66	75	753	finally
    //   136	158	753	finally
    //   202	224	753	finally
    //   754	759	762	java/io/IOException
  }
  
  /* Error */
  public Bitmap decodeFile(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 174	java/io/File:length	()J
    //   4: l2i
    //   5: istore 4
    //   7: aload_0
    //   8: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   11: iload 4
    //   13: invokevirtual 180	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   16: checkcast 182	[B
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 7
    //   24: new 128	java/io/BufferedInputStream
    //   27: dup
    //   28: new 130	java/io/FileInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: sipush 8192
    //   39: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   42: astore 6
    //   44: aload 6
    //   46: astore_1
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore 9
    //   54: iconst_0
    //   55: istore_3
    //   56: aload 6
    //   58: astore_1
    //   59: aload 6
    //   61: aload 9
    //   63: invokevirtual 188	java/io/InputStream:read	([B)I
    //   66: istore 5
    //   68: iload 5
    //   70: iconst_m1
    //   71: if_icmpeq +25 -> 96
    //   74: aload 6
    //   76: astore_1
    //   77: aload 9
    //   79: iconst_0
    //   80: aload 8
    //   82: iload_3
    //   83: iload 5
    //   85: invokestatic 192	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   88: iload_3
    //   89: iload 5
    //   91: iadd
    //   92: istore_3
    //   93: goto -37 -> 56
    //   96: aload 6
    //   98: astore_1
    //   99: aload_0
    //   100: aload 8
    //   102: iconst_0
    //   103: iload 4
    //   105: aload_2
    //   106: invokespecial 193	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   109: astore_2
    //   110: aload_0
    //   111: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   114: aload 8
    //   116: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   119: aload_2
    //   120: astore_1
    //   121: aload 6
    //   123: invokevirtual 198	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: areturn
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   133: aload_1
    //   134: areturn
    //   135: astore_2
    //   136: goto +17 -> 153
    //   139: astore_2
    //   140: goto +65 -> 205
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: goto +108 -> 254
    //   149: astore_2
    //   150: aconst_null
    //   151: astore 6
    //   153: aload 6
    //   155: astore_1
    //   156: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   159: ldc 10
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_2
    //   168: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   171: aastore
    //   172: invokeinterface 60 3 0
    //   177: aload_0
    //   178: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   181: aload 8
    //   183: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   186: aload 6
    //   188: ifnull +63 -> 251
    //   191: aload 7
    //   193: astore_1
    //   194: aload 6
    //   196: invokevirtual 198	java/io/InputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_2
    //   202: aconst_null
    //   203: astore 6
    //   205: aload 6
    //   207: astore_1
    //   208: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   211: ldc 10
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_2
    //   220: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   223: aastore
    //   224: invokeinterface 60 3 0
    //   229: aload_0
    //   230: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   233: aload 8
    //   235: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   238: aload 6
    //   240: ifnull +11 -> 251
    //   243: aload 7
    //   245: astore_1
    //   246: aload 6
    //   248: invokevirtual 198	java/io/InputStream:close	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_2
    //   254: aload_0
    //   255: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   258: aload 8
    //   260: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   263: aload_1
    //   264: ifnull +15 -> 279
    //   267: aload_1
    //   268: invokevirtual 198	java/io/InputStream:close	()V
    //   271: goto +8 -> 279
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   279: goto +5 -> 284
    //   282: aload_2
    //   283: athrow
    //   284: goto -2 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	DalvikDecoder
    //   0	287	1	paramFile	java.io.File
    //   0	287	2	paramOptions	BitmapFactory.Options
    //   55	38	3	i	int
    //   5	99	4	j	int
    //   66	26	5	k	int
    //   42	205	6	localBufferedInputStream	java.io.BufferedInputStream
    //   22	222	7	localObject	Object
    //   19	240	8	arrayOfByte1	byte[]
    //   52	26	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/lang/Exception
    //   194	199	128	java/lang/Exception
    //   246	251	128	java/lang/Exception
    //   47	54	135	java/io/IOException
    //   59	68	135	java/io/IOException
    //   77	88	135	java/io/IOException
    //   99	110	135	java/io/IOException
    //   47	54	139	java/io/FileNotFoundException
    //   59	68	139	java/io/FileNotFoundException
    //   77	88	139	java/io/FileNotFoundException
    //   99	110	139	java/io/FileNotFoundException
    //   24	44	143	finally
    //   24	44	149	java/io/IOException
    //   24	44	201	java/io/FileNotFoundException
    //   47	54	253	finally
    //   59	68	253	finally
    //   77	88	253	finally
    //   99	110	253	finally
    //   156	177	253	finally
    //   208	229	253	finally
    //   267	271	274	java/lang/Exception
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 174	java/io/File:length	()J
    //   4: l2i
    //   5: istore 4
    //   7: aload_0
    //   8: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   11: iload 4
    //   13: invokevirtual 180	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   16: checkcast 182	[B
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 7
    //   24: aconst_null
    //   25: astore 8
    //   27: new 128	java/io/BufferedInputStream
    //   30: dup
    //   31: new 130	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: sipush 8192
    //   42: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore_1
    //   50: sipush 4096
    //   53: newarray byte
    //   55: astore 10
    //   57: iconst_0
    //   58: istore_3
    //   59: aload 6
    //   61: astore_1
    //   62: aload 6
    //   64: aload 10
    //   66: invokevirtual 188	java/io/InputStream:read	([B)I
    //   69: istore 5
    //   71: iload 5
    //   73: iconst_m1
    //   74: if_icmpeq +25 -> 99
    //   77: aload 6
    //   79: astore_1
    //   80: aload 10
    //   82: iconst_0
    //   83: aload 9
    //   85: iload_3
    //   86: iload 5
    //   88: invokestatic 192	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   91: iload_3
    //   92: iload 5
    //   94: iadd
    //   95: istore_3
    //   96: goto -37 -> 59
    //   99: aload 6
    //   101: astore_1
    //   102: aload_0
    //   103: aload 9
    //   105: iconst_0
    //   106: iload 4
    //   108: aload_2
    //   109: invokespecial 193	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   112: astore_2
    //   113: aload_0
    //   114: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   117: aload 9
    //   119: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   122: aload_2
    //   123: astore_1
    //   124: aload 6
    //   126: invokevirtual 198	java/io/InputStream:close	()V
    //   129: aload_2
    //   130: astore_1
    //   131: goto +140 -> 271
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   139: goto +132 -> 271
    //   142: astore_2
    //   143: goto +17 -> 160
    //   146: astore_2
    //   147: goto +72 -> 219
    //   150: astore_2
    //   151: aconst_null
    //   152: astore_1
    //   153: goto +124 -> 277
    //   156: astore_2
    //   157: aconst_null
    //   158: astore 6
    //   160: aload 6
    //   162: astore_1
    //   163: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   166: ldc 10
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_2
    //   175: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   178: aastore
    //   179: invokeinterface 60 3 0
    //   184: aload_0
    //   185: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   188: aload 9
    //   190: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   193: aload 7
    //   195: astore_1
    //   196: aload 6
    //   198: ifnull +73 -> 271
    //   201: aload 8
    //   203: astore_1
    //   204: aload 6
    //   206: invokevirtual 198	java/io/InputStream:close	()V
    //   209: aload 7
    //   211: astore_1
    //   212: goto +59 -> 271
    //   215: astore_2
    //   216: aconst_null
    //   217: astore 6
    //   219: aload 6
    //   221: astore_1
    //   222: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   225: ldc 10
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_2
    //   234: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   237: aastore
    //   238: invokeinterface 60 3 0
    //   243: aload_0
    //   244: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   247: aload 9
    //   249: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   252: aload 7
    //   254: astore_1
    //   255: aload 6
    //   257: ifnull +14 -> 271
    //   260: aload 8
    //   262: astore_1
    //   263: aload 6
    //   265: invokevirtual 198	java/io/InputStream:close	()V
    //   268: aload 7
    //   270: astore_1
    //   271: aload_1
    //   272: invokestatic 211	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   275: areturn
    //   276: astore_2
    //   277: aload_0
    //   278: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   281: aload 9
    //   283: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   286: aload_1
    //   287: ifnull +15 -> 302
    //   290: aload_1
    //   291: invokevirtual 198	java/io/InputStream:close	()V
    //   294: goto +8 -> 302
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   302: goto +5 -> 307
    //   305: aload_2
    //   306: athrow
    //   307: goto -2 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	DalvikDecoder
    //   0	310	1	paramFile	java.io.File
    //   0	310	2	paramOptions	BitmapFactory.Options
    //   58	38	3	i	int
    //   5	102	4	j	int
    //   69	26	5	k	int
    //   45	219	6	localBufferedInputStream	java.io.BufferedInputStream
    //   22	247	7	localObject1	Object
    //   25	236	8	localObject2	Object
    //   19	263	9	arrayOfByte1	byte[]
    //   55	26	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   124	129	134	java/lang/Exception
    //   204	209	134	java/lang/Exception
    //   263	268	134	java/lang/Exception
    //   50	57	142	java/io/IOException
    //   62	71	142	java/io/IOException
    //   80	91	142	java/io/IOException
    //   102	113	142	java/io/IOException
    //   50	57	146	java/io/FileNotFoundException
    //   62	71	146	java/io/FileNotFoundException
    //   80	91	146	java/io/FileNotFoundException
    //   102	113	146	java/io/FileNotFoundException
    //   27	47	150	finally
    //   27	47	156	java/io/IOException
    //   27	47	215	java/io/FileNotFoundException
    //   50	57	276	finally
    //   62	71	276	finally
    //   80	91	276	finally
    //   102	113	276	finally
    //   163	184	276	finally
    //   222	243	276	finally
    //   290	294	297	java/lang/Exception
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_1
    //   13: invokevirtual 216	java/io/FileInputStream:available	()I
    //   16: istore 4
    //   18: aload_0
    //   19: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   22: iload 4
    //   24: invokevirtual 180	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   27: checkcast 182	[B
    //   30: astore 6
    //   32: new 128	java/io/BufferedInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 219	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore 8
    //   42: aload 6
    //   44: astore_1
    //   45: aload 8
    //   47: astore 7
    //   49: sipush 4096
    //   52: newarray byte
    //   54: astore 11
    //   56: iconst_0
    //   57: istore_3
    //   58: aload 6
    //   60: astore_1
    //   61: aload 8
    //   63: astore 7
    //   65: aload 8
    //   67: aload 11
    //   69: invokevirtual 188	java/io/InputStream:read	([B)I
    //   72: istore 5
    //   74: iload 5
    //   76: iconst_m1
    //   77: if_icmpeq +29 -> 106
    //   80: aload 6
    //   82: astore_1
    //   83: aload 8
    //   85: astore 7
    //   87: aload 11
    //   89: iconst_0
    //   90: aload 6
    //   92: iload_3
    //   93: iload 5
    //   95: invokestatic 192	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   98: iload_3
    //   99: iload 5
    //   101: iadd
    //   102: istore_3
    //   103: goto -45 -> 58
    //   106: aload 6
    //   108: astore_1
    //   109: aload 8
    //   111: astore 7
    //   113: aload_0
    //   114: aload 6
    //   116: iconst_0
    //   117: iload 4
    //   119: aload_2
    //   120: invokespecial 193	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: astore_2
    //   124: aload_0
    //   125: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   128: aload 6
    //   130: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   133: aload_2
    //   134: astore_1
    //   135: aload 8
    //   137: invokevirtual 198	java/io/InputStream:close	()V
    //   140: aload_2
    //   141: astore_1
    //   142: goto +261 -> 403
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   150: goto +253 -> 403
    //   153: astore_2
    //   154: goto +59 -> 213
    //   157: astore_2
    //   158: goto +122 -> 280
    //   161: astore_2
    //   162: goto +185 -> 347
    //   165: astore_2
    //   166: aconst_null
    //   167: astore 7
    //   169: aload 6
    //   171: astore_1
    //   172: goto +237 -> 409
    //   175: astore_2
    //   176: aconst_null
    //   177: astore 8
    //   179: goto +34 -> 213
    //   182: astore_2
    //   183: aconst_null
    //   184: astore 8
    //   186: goto +94 -> 280
    //   189: astore_2
    //   190: aconst_null
    //   191: astore 8
    //   193: goto +154 -> 347
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: astore 7
    //   202: goto +207 -> 409
    //   205: astore_2
    //   206: aconst_null
    //   207: astore 6
    //   209: aload 6
    //   211: astore 8
    //   213: aload 6
    //   215: astore_1
    //   216: aload 8
    //   218: astore 7
    //   220: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   223: ldc 10
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_2
    //   232: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   235: aastore
    //   236: invokeinterface 60 3 0
    //   241: aload_0
    //   242: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   245: aload 6
    //   247: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   250: aload 9
    //   252: astore_1
    //   253: aload 8
    //   255: ifnull +148 -> 403
    //   258: aload 10
    //   260: astore_1
    //   261: aload 8
    //   263: invokevirtual 198	java/io/InputStream:close	()V
    //   266: aload 9
    //   268: astore_1
    //   269: goto +134 -> 403
    //   272: astore_2
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 6
    //   278: astore 8
    //   280: aload 6
    //   282: astore_1
    //   283: aload 8
    //   285: astore 7
    //   287: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   290: ldc 10
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_2
    //   299: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: aastore
    //   303: invokeinterface 60 3 0
    //   308: aload_0
    //   309: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   312: aload 6
    //   314: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   317: aload 9
    //   319: astore_1
    //   320: aload 8
    //   322: ifnull +81 -> 403
    //   325: aload 10
    //   327: astore_1
    //   328: aload 8
    //   330: invokevirtual 198	java/io/InputStream:close	()V
    //   333: aload 9
    //   335: astore_1
    //   336: goto +67 -> 403
    //   339: astore_2
    //   340: aconst_null
    //   341: astore 6
    //   343: aload 6
    //   345: astore 8
    //   347: aload 6
    //   349: astore_1
    //   350: aload 8
    //   352: astore 7
    //   354: invokestatic 33	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   357: ldc 10
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload_2
    //   366: invokestatic 50	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   369: aastore
    //   370: invokeinterface 60 3 0
    //   375: aload_0
    //   376: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   379: aload 6
    //   381: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   384: aload 9
    //   386: astore_1
    //   387: aload 8
    //   389: ifnull +14 -> 403
    //   392: aload 10
    //   394: astore_1
    //   395: aload 8
    //   397: invokevirtual 198	java/io/InputStream:close	()V
    //   400: aload 9
    //   402: astore_1
    //   403: aload_1
    //   404: invokestatic 211	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   407: areturn
    //   408: astore_2
    //   409: aload_0
    //   410: getfield 67	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   413: aload_1
    //   414: invokevirtual 197	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   417: aload 7
    //   419: ifnull +16 -> 435
    //   422: aload 7
    //   424: invokevirtual 198	java/io/InputStream:close	()V
    //   427: goto +8 -> 435
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   435: goto +5 -> 440
    //   438: aload_2
    //   439: athrow
    //   440: goto -2 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	DalvikDecoder
    //   0	443	1	paramFileInputStream	java.io.FileInputStream
    //   0	443	2	paramOptions	BitmapFactory.Options
    //   57	46	3	i	int
    //   16	102	4	j	int
    //   72	30	5	k	int
    //   30	350	6	arrayOfByte1	byte[]
    //   47	376	7	localObject1	Object
    //   40	356	8	localObject2	Object
    //   1	400	9	localObject3	Object
    //   4	389	10	localObject4	Object
    //   54	34	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   135	140	145	java/lang/Exception
    //   261	266	145	java/lang/Exception
    //   328	333	145	java/lang/Exception
    //   395	400	145	java/lang/Exception
    //   49	56	153	java/lang/Throwable
    //   65	74	153	java/lang/Throwable
    //   87	98	153	java/lang/Throwable
    //   113	124	153	java/lang/Throwable
    //   49	56	157	java/io/IOException
    //   65	74	157	java/io/IOException
    //   87	98	157	java/io/IOException
    //   113	124	157	java/io/IOException
    //   49	56	161	java/io/FileNotFoundException
    //   65	74	161	java/io/FileNotFoundException
    //   87	98	161	java/io/FileNotFoundException
    //   113	124	161	java/io/FileNotFoundException
    //   32	42	165	finally
    //   32	42	175	java/lang/Throwable
    //   32	42	182	java/io/IOException
    //   32	42	189	java/io/FileNotFoundException
    //   12	32	196	finally
    //   12	32	205	java/lang/Throwable
    //   12	32	272	java/io/IOException
    //   12	32	339	java/io/FileNotFoundException
    //   49	56	408	finally
    //   65	74	408	finally
    //   87	98	408	finally
    //   113	124	408	finally
    //   220	241	408	finally
    //   287	308	408	finally
    //   354	375	408	finally
    //   422	427	430	java/lang/Exception
  }
  
  public BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    try
    {
      paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramOptions = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeImage error ");
      localStringBuilder.append(Log.getStackTraceString(paramArrayOfByte));
      paramOptions.w("DalvikDecoder", new Object[] { localStringBuilder.toString() });
      paramArrayOfByte = null;
    }
    return BitmapReference.getBitmapReference(paramArrayOfByte);
  }
  
  public native int pinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.DalvikDecoder
 * JD-Core Version:    0.7.0.1
 */