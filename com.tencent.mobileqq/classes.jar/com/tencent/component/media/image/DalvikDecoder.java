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
      ImageManagerEnv.getLogger().w("DalvikDecoder", new Object[] { "loadLibrary failed " + Log.getStackTraceString(localThrowable) });
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
    //   2: invokestatic 76	com/tencent/component/media/image/DalvikDecoder:setBitmapOptions	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore 4
    //   7: aload_1
    //   8: iload_2
    //   9: iload_3
    //   10: aload 4
    //   12: invokestatic 80	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +24 -> 41
    //   20: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   23: ldc 10
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc 82
    //   33: aastore
    //   34: invokeinterface 61 3 0
    //   39: aconst_null
    //   40: areturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 86	com/tencent/component/media/image/DalvikDecoder:pinBitmap	(Landroid/graphics/Bitmap;)I
    //   46: pop
    //   47: aload_1
    //   48: areturn
    //   49: astore 4
    //   51: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   54: ldc 10
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 4
    //   64: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   67: aastore
    //   68: invokeinterface 61 3 0
    //   73: aload_1
    //   74: areturn
    //   75: astore_1
    //   76: aload_1
    //   77: athrow
    //   78: astore 4
    //   80: aconst_null
    //   81: astore_1
    //   82: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   85: ldc 10
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload 4
    //   95: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   98: aastore
    //   99: invokeinterface 61 3 0
    //   104: aload_1
    //   105: areturn
    //   106: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   109: ldc 10
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 4
    //   119: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: aastore
    //   123: invokeinterface 61 3 0
    //   128: aload_1
    //   129: areturn
    //   130: astore 4
    //   132: goto -26 -> 106
    //   135: astore 4
    //   137: goto -55 -> 82
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -93 -> 51
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -45 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	DalvikDecoder
    //   0	154	1	paramArrayOfByte	byte[]
    //   0	154	2	paramInt1	int
    //   0	154	3	paramInt2	int
    //   0	154	4	paramOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   20	39	49	java/lang/Exception
    //   41	47	49	java/lang/Exception
    //   7	16	75	finally
    //   20	39	75	finally
    //   41	47	75	finally
    //   51	73	75	finally
    //   82	104	75	finally
    //   106	128	75	finally
    //   7	16	78	java/lang/OutOfMemoryError
    //   20	39	130	java/lang/Throwable
    //   41	47	130	java/lang/Throwable
    //   20	39	135	java/lang/OutOfMemoryError
    //   41	47	135	java/lang/OutOfMemoryError
    //   7	16	140	java/lang/Exception
    //   7	16	147	java/lang/Throwable
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
    //   1: ifnull +24 -> 25
    //   4: aload_1
    //   5: invokevirtual 116	java/io/File:exists	()Z
    //   8: ifeq +17 -> 25
    //   11: aload_1
    //   12: invokevirtual 119	java/io/File:isFile	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 122	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 88	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 89	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: iconst_1
    //   39: putfield 125	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: new 127	java/io/BufferedInputStream
    //   45: dup
    //   46: new 129	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: sipush 8096
    //   57: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   60: astore 6
    //   62: aload 6
    //   64: astore 4
    //   66: aload 6
    //   68: aconst_null
    //   69: aload 8
    //   71: invokestatic 139	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   80: aload 8
    //   82: iconst_0
    //   83: putfield 125	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   86: new 144	com/tencent/component/media/image/ImageLoader$Options
    //   89: dup
    //   90: invokespecial 145	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   93: astore 4
    //   95: aload 4
    //   97: iload_3
    //   98: putfield 148	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   101: aload 4
    //   103: iload_2
    //   104: putfield 151	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   107: iload_3
    //   108: ifle +27 -> 135
    //   111: iload_2
    //   112: ifle +23 -> 135
    //   115: aload 8
    //   117: aload 4
    //   119: aload 8
    //   121: getfield 154	android/graphics/BitmapFactory$Options:outWidth	I
    //   124: aload 8
    //   126: getfield 157	android/graphics/BitmapFactory$Options:outHeight	I
    //   129: invokestatic 163	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   132: putfield 166	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   135: aload_1
    //   136: invokevirtual 170	java/io/File:length	()J
    //   139: l2i
    //   140: istore_3
    //   141: aload_0
    //   142: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   145: iload_3
    //   146: invokevirtual 176	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   149: checkcast 178	[B
    //   152: astore 7
    //   154: new 127	java/io/BufferedInputStream
    //   157: dup
    //   158: new 129	java/io/FileInputStream
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   166: sipush 8192
    //   169: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   172: astore 4
    //   174: aload 4
    //   176: astore_1
    //   177: sipush 4096
    //   180: newarray byte
    //   182: astore 6
    //   184: iconst_0
    //   185: istore_2
    //   186: aload 4
    //   188: astore_1
    //   189: aload 4
    //   191: aload 6
    //   193: invokevirtual 184	java/io/InputStream:read	([B)I
    //   196: istore 5
    //   198: iload 5
    //   200: iconst_m1
    //   201: if_icmpeq +222 -> 423
    //   204: aload 4
    //   206: astore_1
    //   207: aload 6
    //   209: iconst_0
    //   210: aload 7
    //   212: iload_2
    //   213: iload 5
    //   215: invokestatic 188	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   218: iload_2
    //   219: iload 5
    //   221: iadd
    //   222: istore_2
    //   223: goto -37 -> 186
    //   226: astore 4
    //   228: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   231: ldc 10
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload 4
    //   241: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   244: aastore
    //   245: invokeinterface 191 3 0
    //   250: goto -170 -> 80
    //   253: astore 7
    //   255: aconst_null
    //   256: astore 6
    //   258: aload 6
    //   260: astore 4
    //   262: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   265: ldc 10
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload 7
    //   275: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   278: aastore
    //   279: invokeinterface 191 3 0
    //   284: aload 6
    //   286: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   289: goto -209 -> 80
    //   292: astore 4
    //   294: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   297: ldc 10
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload 4
    //   307: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   310: aastore
    //   311: invokeinterface 191 3 0
    //   316: goto -236 -> 80
    //   319: astore 7
    //   321: aconst_null
    //   322: astore 6
    //   324: aload 6
    //   326: astore 4
    //   328: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   331: ldc 10
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 7
    //   341: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   344: aastore
    //   345: invokeinterface 191 3 0
    //   350: aload 6
    //   352: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   355: goto -275 -> 80
    //   358: astore 4
    //   360: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   363: ldc 10
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload 4
    //   373: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   376: aastore
    //   377: invokeinterface 191 3 0
    //   382: goto -302 -> 80
    //   385: astore_1
    //   386: aconst_null
    //   387: astore 4
    //   389: aload 4
    //   391: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   394: aload_1
    //   395: athrow
    //   396: astore 4
    //   398: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   401: ldc 10
    //   403: iconst_1
    //   404: anewarray 4	java/lang/Object
    //   407: dup
    //   408: iconst_0
    //   409: aload 4
    //   411: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: aastore
    //   415: invokeinterface 191 3 0
    //   420: goto -26 -> 394
    //   423: aload 4
    //   425: astore_1
    //   426: aload_0
    //   427: aload 7
    //   429: iconst_0
    //   430: iload_3
    //   431: aload 8
    //   433: invokespecial 192	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   436: astore 6
    //   438: aload_0
    //   439: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   442: aload 7
    //   444: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   447: aload 4
    //   449: ifnull +346 -> 795
    //   452: aload 4
    //   454: invokevirtual 197	java/io/InputStream:close	()V
    //   457: aload 6
    //   459: areturn
    //   460: astore_1
    //   461: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   464: ldc 10
    //   466: iconst_1
    //   467: anewarray 4	java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload_1
    //   473: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: aastore
    //   477: invokeinterface 61 3 0
    //   482: aload 6
    //   484: areturn
    //   485: astore 6
    //   487: aconst_null
    //   488: astore 4
    //   490: aload 4
    //   492: astore_1
    //   493: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   496: ldc 10
    //   498: iconst_1
    //   499: anewarray 4	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: aload 6
    //   506: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   509: aastore
    //   510: invokeinterface 61 3 0
    //   515: aload_0
    //   516: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   519: aload 7
    //   521: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   524: aload 4
    //   526: ifnull +267 -> 793
    //   529: aload 4
    //   531: invokevirtual 197	java/io/InputStream:close	()V
    //   534: aconst_null
    //   535: areturn
    //   536: astore_1
    //   537: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   540: ldc 10
    //   542: iconst_1
    //   543: anewarray 4	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload_1
    //   549: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   552: aastore
    //   553: invokeinterface 61 3 0
    //   558: aconst_null
    //   559: areturn
    //   560: astore 6
    //   562: aconst_null
    //   563: astore 4
    //   565: aload 4
    //   567: astore_1
    //   568: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   571: ldc 10
    //   573: iconst_1
    //   574: anewarray 4	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: aload 6
    //   581: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   584: aastore
    //   585: invokeinterface 61 3 0
    //   590: aload_0
    //   591: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   594: aload 7
    //   596: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   599: aload 4
    //   601: ifnull +192 -> 793
    //   604: aload 4
    //   606: invokevirtual 197	java/io/InputStream:close	()V
    //   609: aconst_null
    //   610: areturn
    //   611: astore_1
    //   612: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   615: ldc 10
    //   617: iconst_1
    //   618: anewarray 4	java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: aload_1
    //   624: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   627: aastore
    //   628: invokeinterface 61 3 0
    //   633: aconst_null
    //   634: areturn
    //   635: astore 6
    //   637: aconst_null
    //   638: astore 4
    //   640: aload 4
    //   642: astore_1
    //   643: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   646: ldc 10
    //   648: iconst_1
    //   649: anewarray 4	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: aload 6
    //   656: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   659: aastore
    //   660: invokeinterface 191 3 0
    //   665: aload_0
    //   666: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   669: aload 7
    //   671: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   674: aload 4
    //   676: ifnull +117 -> 793
    //   679: aload 4
    //   681: invokevirtual 197	java/io/InputStream:close	()V
    //   684: aconst_null
    //   685: areturn
    //   686: astore_1
    //   687: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   690: ldc 10
    //   692: iconst_1
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: aload_1
    //   699: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   702: aastore
    //   703: invokeinterface 61 3 0
    //   708: aconst_null
    //   709: areturn
    //   710: astore 4
    //   712: aconst_null
    //   713: astore_1
    //   714: aload_0
    //   715: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   718: aload 7
    //   720: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   723: aload_1
    //   724: ifnull +7 -> 731
    //   727: aload_1
    //   728: invokevirtual 197	java/io/InputStream:close	()V
    //   731: aload 4
    //   733: athrow
    //   734: astore_1
    //   735: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   738: ldc 10
    //   740: iconst_1
    //   741: anewarray 4	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload_1
    //   747: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   750: aastore
    //   751: invokeinterface 61 3 0
    //   756: goto -25 -> 731
    //   759: astore 4
    //   761: goto -47 -> 714
    //   764: astore 6
    //   766: goto -126 -> 640
    //   769: astore 6
    //   771: goto -206 -> 565
    //   774: astore 6
    //   776: goto -286 -> 490
    //   779: astore_1
    //   780: goto -391 -> 389
    //   783: astore 7
    //   785: goto -461 -> 324
    //   788: astore 7
    //   790: goto -532 -> 258
    //   793: aconst_null
    //   794: areturn
    //   795: aload 6
    //   797: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	DalvikDecoder
    //   0	798	1	paramFile	java.io.File
    //   0	798	2	paramInt1	int
    //   0	798	3	paramInt2	int
    //   0	798	4	paramBitmap	Bitmap
    //   196	26	5	i	int
    //   60	423	6	localObject	Object
    //   485	20	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   560	20	6	localIOException1	java.io.IOException
    //   635	20	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   764	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   769	1	6	localIOException2	java.io.IOException
    //   774	22	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   152	59	7	arrayOfByte	byte[]
    //   253	21	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   319	400	7	localThrowable1	Throwable
    //   783	1	7	localThrowable2	Throwable
    //   788	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   34	398	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   75	80	226	java/io/IOException
    //   42	62	253	java/io/FileNotFoundException
    //   284	289	292	java/io/IOException
    //   42	62	319	java/lang/Throwable
    //   350	355	358	java/io/IOException
    //   42	62	385	finally
    //   389	394	396	java/io/IOException
    //   452	457	460	java/lang/Exception
    //   154	174	485	java/io/FileNotFoundException
    //   529	534	536	java/lang/Exception
    //   154	174	560	java/io/IOException
    //   604	609	611	java/lang/Exception
    //   154	174	635	java/lang/OutOfMemoryError
    //   679	684	686	java/lang/Exception
    //   154	174	710	finally
    //   727	731	734	java/lang/Exception
    //   177	184	759	finally
    //   189	198	759	finally
    //   207	218	759	finally
    //   426	438	759	finally
    //   493	515	759	finally
    //   568	590	759	finally
    //   643	665	759	finally
    //   177	184	764	java/lang/OutOfMemoryError
    //   189	198	764	java/lang/OutOfMemoryError
    //   207	218	764	java/lang/OutOfMemoryError
    //   426	438	764	java/lang/OutOfMemoryError
    //   177	184	769	java/io/IOException
    //   189	198	769	java/io/IOException
    //   207	218	769	java/io/IOException
    //   426	438	769	java/io/IOException
    //   177	184	774	java/io/FileNotFoundException
    //   189	198	774	java/io/FileNotFoundException
    //   207	218	774	java/io/FileNotFoundException
    //   426	438	774	java/io/FileNotFoundException
    //   66	75	779	finally
    //   262	284	779	finally
    //   328	350	779	finally
    //   66	75	783	java/lang/Throwable
    //   66	75	788	java/io/FileNotFoundException
  }
  
  /* Error */
  public Bitmap decodeFile(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 170	java/io/File:length	()J
    //   6: l2i
    //   7: istore 4
    //   9: aload_0
    //   10: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   13: iload 4
    //   15: invokevirtual 176	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   18: checkcast 178	[B
    //   21: astore 7
    //   23: new 127	java/io/BufferedInputStream
    //   26: dup
    //   27: new 129	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: sipush 8192
    //   38: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   41: astore 6
    //   43: aload 6
    //   45: astore_1
    //   46: sipush 4096
    //   49: newarray byte
    //   51: astore 8
    //   53: aload 6
    //   55: astore_1
    //   56: aload 6
    //   58: aload 8
    //   60: invokevirtual 184	java/io/InputStream:read	([B)I
    //   63: istore 5
    //   65: iload 5
    //   67: iconst_m1
    //   68: if_icmpeq +25 -> 93
    //   71: aload 6
    //   73: astore_1
    //   74: aload 8
    //   76: iconst_0
    //   77: aload 7
    //   79: iload_3
    //   80: iload 5
    //   82: invokestatic 188	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   85: iload_3
    //   86: iload 5
    //   88: iadd
    //   89: istore_3
    //   90: goto -37 -> 53
    //   93: aload 6
    //   95: astore_1
    //   96: aload_0
    //   97: aload 7
    //   99: iconst_0
    //   100: iload 4
    //   102: aload_2
    //   103: invokespecial 192	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore_2
    //   107: aload_0
    //   108: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   111: aload 7
    //   113: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   116: aload 6
    //   118: ifnull +173 -> 291
    //   121: aload 6
    //   123: invokevirtual 197	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   133: aload_2
    //   134: areturn
    //   135: astore_2
    //   136: aconst_null
    //   137: astore 6
    //   139: aload 6
    //   141: astore_1
    //   142: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   145: ldc 10
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_2
    //   154: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   157: aastore
    //   158: invokeinterface 61 3 0
    //   163: aload_0
    //   164: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   167: aload 7
    //   169: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   172: aload 6
    //   174: ifnull +115 -> 289
    //   177: aload 6
    //   179: invokevirtual 197	java/io/InputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_2
    //   192: aconst_null
    //   193: astore 6
    //   195: aload 6
    //   197: astore_1
    //   198: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   201: ldc 10
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_2
    //   210: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   213: aastore
    //   214: invokeinterface 61 3 0
    //   219: aload_0
    //   220: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   223: aload 7
    //   225: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   228: aload 6
    //   230: ifnull +59 -> 289
    //   233: aload 6
    //   235: invokevirtual 197	java/io/InputStream:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   254: aload 7
    //   256: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 197	java/io/InputStream:close	()V
    //   267: aload_2
    //   268: athrow
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   274: goto -7 -> 267
    //   277: astore_2
    //   278: goto -28 -> 250
    //   281: astore_2
    //   282: goto -87 -> 195
    //   285: astore_2
    //   286: goto -147 -> 139
    //   289: aconst_null
    //   290: areturn
    //   291: aload_2
    //   292: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	DalvikDecoder
    //   0	293	1	paramFile	java.io.File
    //   0	293	2	paramOptions	BitmapFactory.Options
    //   1	89	3	i	int
    //   7	94	4	j	int
    //   63	26	5	k	int
    //   41	193	6	localBufferedInputStream	java.io.BufferedInputStream
    //   21	234	7	arrayOfByte1	byte[]
    //   51	24	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/lang/Exception
    //   23	43	135	java/io/FileNotFoundException
    //   177	182	184	java/lang/Exception
    //   23	43	191	java/io/IOException
    //   233	238	240	java/lang/Exception
    //   23	43	247	finally
    //   263	267	269	java/lang/Exception
    //   46	53	277	finally
    //   56	65	277	finally
    //   74	85	277	finally
    //   96	107	277	finally
    //   142	163	277	finally
    //   198	219	277	finally
    //   46	53	281	java/io/IOException
    //   56	65	281	java/io/IOException
    //   74	85	281	java/io/IOException
    //   96	107	281	java/io/IOException
    //   46	53	285	java/io/FileNotFoundException
    //   56	65	285	java/io/FileNotFoundException
    //   74	85	285	java/io/FileNotFoundException
    //   96	107	285	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 170	java/io/File:length	()J
    //   6: l2i
    //   7: istore 4
    //   9: aload_0
    //   10: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   13: iload 4
    //   15: invokevirtual 176	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   18: checkcast 178	[B
    //   21: astore 7
    //   23: new 127	java/io/BufferedInputStream
    //   26: dup
    //   27: new 129	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: sipush 8192
    //   38: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   41: astore 6
    //   43: aload 6
    //   45: astore_1
    //   46: sipush 4096
    //   49: newarray byte
    //   51: astore 8
    //   53: aload 6
    //   55: astore_1
    //   56: aload 6
    //   58: aload 8
    //   60: invokevirtual 184	java/io/InputStream:read	([B)I
    //   63: istore 5
    //   65: iload 5
    //   67: iconst_m1
    //   68: if_icmpeq +25 -> 93
    //   71: aload 6
    //   73: astore_1
    //   74: aload 8
    //   76: iconst_0
    //   77: aload 7
    //   79: iload_3
    //   80: iload 5
    //   82: invokestatic 188	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   85: iload_3
    //   86: iload 5
    //   88: iadd
    //   89: istore_3
    //   90: goto -37 -> 53
    //   93: aload 6
    //   95: astore_1
    //   96: aload_0
    //   97: aload 7
    //   99: iconst_0
    //   100: iload 4
    //   102: aload_2
    //   103: invokespecial 192	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore_2
    //   107: aload_0
    //   108: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   111: aload 7
    //   113: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   116: aload 6
    //   118: ifnull +196 -> 314
    //   121: aload 6
    //   123: invokevirtual 197	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: astore_1
    //   128: aload_1
    //   129: invokestatic 210	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   132: areturn
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   138: aload_2
    //   139: astore_1
    //   140: goto -12 -> 128
    //   143: astore_2
    //   144: aconst_null
    //   145: astore 6
    //   147: aload 6
    //   149: astore_1
    //   150: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   153: ldc 10
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   165: aastore
    //   166: invokeinterface 61 3 0
    //   171: aload_0
    //   172: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   175: aload 7
    //   177: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   180: aload 6
    //   182: ifnull +127 -> 309
    //   185: aload 6
    //   187: invokevirtual 197	java/io/InputStream:close	()V
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -64 -> 128
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -74 -> 128
    //   205: astore_2
    //   206: aconst_null
    //   207: astore 6
    //   209: aload 6
    //   211: astore_1
    //   212: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   215: ldc 10
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload_2
    //   224: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   227: aastore
    //   228: invokeinterface 61 3 0
    //   233: aload_0
    //   234: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   237: aload 7
    //   239: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   242: aload 6
    //   244: ifnull +65 -> 309
    //   247: aload 6
    //   249: invokevirtual 197	java/io/InputStream:close	()V
    //   252: aconst_null
    //   253: astore_1
    //   254: goto -126 -> 128
    //   257: astore_1
    //   258: aload_1
    //   259: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   262: aconst_null
    //   263: astore_1
    //   264: goto -136 -> 128
    //   267: astore_2
    //   268: aconst_null
    //   269: astore_1
    //   270: aload_0
    //   271: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   274: aload 7
    //   276: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   279: aload_1
    //   280: ifnull +7 -> 287
    //   283: aload_1
    //   284: invokevirtual 197	java/io/InputStream:close	()V
    //   287: aload_2
    //   288: athrow
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   294: goto -7 -> 287
    //   297: astore_2
    //   298: goto -28 -> 270
    //   301: astore_2
    //   302: goto -93 -> 209
    //   305: astore_2
    //   306: goto -159 -> 147
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -183 -> 128
    //   314: aload_2
    //   315: astore_1
    //   316: goto -188 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	DalvikDecoder
    //   0	319	1	paramFile	java.io.File
    //   0	319	2	paramOptions	BitmapFactory.Options
    //   1	89	3	i	int
    //   7	94	4	j	int
    //   63	26	5	k	int
    //   41	207	6	localBufferedInputStream	java.io.BufferedInputStream
    //   21	254	7	arrayOfByte1	byte[]
    //   51	24	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	126	133	java/lang/Exception
    //   23	43	143	java/io/FileNotFoundException
    //   185	190	195	java/lang/Exception
    //   23	43	205	java/io/IOException
    //   247	252	257	java/lang/Exception
    //   23	43	267	finally
    //   283	287	289	java/lang/Exception
    //   46	53	297	finally
    //   56	65	297	finally
    //   74	85	297	finally
    //   96	107	297	finally
    //   150	171	297	finally
    //   212	233	297	finally
    //   46	53	301	java/io/IOException
    //   56	65	301	java/io/IOException
    //   74	85	301	java/io/IOException
    //   96	107	301	java/io/IOException
    //   46	53	305	java/io/FileNotFoundException
    //   56	65	305	java/io/FileNotFoundException
    //   74	85	305	java/io/FileNotFoundException
    //   96	107	305	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_1
    //   9: invokevirtual 215	java/io/FileInputStream:available	()I
    //   12: istore 4
    //   14: aload_0
    //   15: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   18: iload 4
    //   20: invokevirtual 176	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   23: checkcast 178	[B
    //   26: astore 6
    //   28: new 127	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 218	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_1
    //   37: sipush 4096
    //   40: newarray byte
    //   42: astore 7
    //   44: aload_1
    //   45: aload 7
    //   47: invokevirtual 184	java/io/InputStream:read	([B)I
    //   50: istore 5
    //   52: iload 5
    //   54: iconst_m1
    //   55: if_icmpeq +22 -> 77
    //   58: aload 7
    //   60: iconst_0
    //   61: aload 6
    //   63: iload_3
    //   64: iload 5
    //   66: invokestatic 188	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   69: iload_3
    //   70: iload 5
    //   72: iadd
    //   73: istore_3
    //   74: goto -30 -> 44
    //   77: aload_0
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: aload_2
    //   84: invokespecial 192	com/tencent/component/media/image/DalvikDecoder:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   87: astore_2
    //   88: aload_0
    //   89: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   92: aload 6
    //   94: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: ifnull +353 -> 451
    //   101: aload_1
    //   102: invokevirtual 197	java/io/InputStream:close	()V
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: invokestatic 210	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   117: aload_2
    //   118: astore_1
    //   119: goto -12 -> 107
    //   122: astore 8
    //   124: aconst_null
    //   125: astore 6
    //   127: aconst_null
    //   128: astore 7
    //   130: aload 6
    //   132: astore_2
    //   133: aload 7
    //   135: astore_1
    //   136: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   139: ldc 10
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload 8
    //   149: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   152: aastore
    //   153: invokeinterface 61 3 0
    //   158: aload_0
    //   159: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   162: aload 6
    //   164: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   167: aload 7
    //   169: ifnull +277 -> 446
    //   172: aload 7
    //   174: invokevirtual 197	java/io/InputStream:close	()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -72 -> 107
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -82 -> 107
    //   192: astore 8
    //   194: aconst_null
    //   195: astore 6
    //   197: aconst_null
    //   198: astore 7
    //   200: aload 6
    //   202: astore_2
    //   203: aload 7
    //   205: astore_1
    //   206: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   209: ldc 10
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload 8
    //   219: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   222: aastore
    //   223: invokeinterface 61 3 0
    //   228: aload_0
    //   229: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   232: aload 6
    //   234: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   237: aload 7
    //   239: ifnull +207 -> 446
    //   242: aload 7
    //   244: invokevirtual 197	java/io/InputStream:close	()V
    //   247: aconst_null
    //   248: astore_1
    //   249: goto -142 -> 107
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -152 -> 107
    //   262: astore 8
    //   264: aconst_null
    //   265: astore 6
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 6
    //   272: astore_2
    //   273: aload 7
    //   275: astore_1
    //   276: invokestatic 34	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   279: ldc 10
    //   281: iconst_1
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload 8
    //   289: invokestatic 51	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   292: aastore
    //   293: invokeinterface 61 3 0
    //   298: aload_0
    //   299: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   302: aload 6
    //   304: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   307: aload 7
    //   309: ifnull +137 -> 446
    //   312: aload 7
    //   314: invokevirtual 197	java/io/InputStream:close	()V
    //   317: aconst_null
    //   318: astore_1
    //   319: goto -212 -> 107
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -222 -> 107
    //   332: astore 6
    //   334: aconst_null
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_1
    //   338: aload_0
    //   339: getfield 66	com/tencent/component/media/image/DalvikDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   342: aload_2
    //   343: invokevirtual 196	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   346: aload_1
    //   347: ifnull +7 -> 354
    //   350: aload_1
    //   351: invokevirtual 197	java/io/InputStream:close	()V
    //   354: aload 6
    //   356: athrow
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   362: goto -8 -> 354
    //   365: astore_1
    //   366: aconst_null
    //   367: astore 7
    //   369: aload 6
    //   371: astore_2
    //   372: aload_1
    //   373: astore 6
    //   375: aload 7
    //   377: astore_1
    //   378: goto -40 -> 338
    //   381: astore 7
    //   383: aload 6
    //   385: astore_2
    //   386: aload 7
    //   388: astore 6
    //   390: goto -52 -> 338
    //   393: astore 6
    //   395: goto -57 -> 338
    //   398: astore 8
    //   400: aconst_null
    //   401: astore 7
    //   403: goto -133 -> 270
    //   406: astore 8
    //   408: aload_1
    //   409: astore 7
    //   411: goto -141 -> 270
    //   414: astore 8
    //   416: aconst_null
    //   417: astore 7
    //   419: goto -219 -> 200
    //   422: astore 8
    //   424: aload_1
    //   425: astore 7
    //   427: goto -227 -> 200
    //   430: astore 8
    //   432: aconst_null
    //   433: astore 7
    //   435: goto -305 -> 130
    //   438: astore 8
    //   440: aload_1
    //   441: astore 7
    //   443: goto -313 -> 130
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -341 -> 107
    //   451: aload_2
    //   452: astore_1
    //   453: goto -346 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	DalvikDecoder
    //   0	456	1	paramFileInputStream	java.io.FileInputStream
    //   0	456	2	paramOptions	BitmapFactory.Options
    //   1	73	3	i	int
    //   12	70	4	j	int
    //   50	23	5	k	int
    //   26	277	6	arrayOfByte1	byte[]
    //   332	38	6	localObject1	Object
    //   373	16	6	localObject2	Object
    //   393	1	6	localObject3	Object
    //   42	334	7	arrayOfByte2	byte[]
    //   381	6	7	localObject4	Object
    //   401	41	7	localFileInputStream	java.io.FileInputStream
    //   122	26	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   192	26	8	localIOException1	java.io.IOException
    //   262	26	8	localThrowable1	Throwable
    //   398	1	8	localThrowable2	Throwable
    //   406	1	8	localThrowable3	Throwable
    //   414	1	8	localIOException2	java.io.IOException
    //   422	1	8	localIOException3	java.io.IOException
    //   430	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   438	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   101	105	112	java/lang/Exception
    //   8	28	122	java/io/FileNotFoundException
    //   172	177	182	java/lang/Exception
    //   8	28	192	java/io/IOException
    //   242	247	252	java/lang/Exception
    //   8	28	262	java/lang/Throwable
    //   312	317	322	java/lang/Exception
    //   8	28	332	finally
    //   350	354	357	java/lang/Exception
    //   28	37	365	finally
    //   37	44	381	finally
    //   44	52	381	finally
    //   58	69	381	finally
    //   77	88	381	finally
    //   136	158	393	finally
    //   206	228	393	finally
    //   276	298	393	finally
    //   28	37	398	java/lang/Throwable
    //   37	44	406	java/lang/Throwable
    //   44	52	406	java/lang/Throwable
    //   58	69	406	java/lang/Throwable
    //   77	88	406	java/lang/Throwable
    //   28	37	414	java/io/IOException
    //   37	44	422	java/io/IOException
    //   44	52	422	java/io/IOException
    //   58	69	422	java/io/IOException
    //   77	88	422	java/io/IOException
    //   28	37	430	java/io/FileNotFoundException
    //   37	44	438	java/io/FileNotFoundException
    //   44	52	438	java/io/FileNotFoundException
    //   58	69	438	java/io/FileNotFoundException
    //   77	88	438	java/io/FileNotFoundException
  }
  
  public BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
      return BitmapReference.getBitmapReference(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        ImageManagerEnv.getLogger().w("DalvikDecoder", new Object[] { "decodeImage error " + Log.getStackTraceString(paramArrayOfByte) });
        paramArrayOfByte = localObject;
      }
    }
  }
  
  public native int pinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.DalvikDecoder
 * JD-Core Version:    0.7.0.1
 */