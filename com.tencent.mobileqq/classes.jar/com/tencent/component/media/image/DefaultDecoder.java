package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;

public class DefaultDecoder
  implements IDecoder
{
  private static final String TAG = "DefaultDecoder";
  
  /* Error */
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 23	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 26
    //   13: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: iload 5
    //   21: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 7
    //   27: ldc 35
    //   29: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 7
    //   35: iload 6
    //   37: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 10
    //   43: aload 7
    //   45: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 45	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: aload 4
    //   54: iconst_1
    //   55: putfield 51	android/graphics/BitmapFactory$Options:inDither	Z
    //   58: aload 4
    //   60: iconst_1
    //   61: putfield 54	android/graphics/BitmapFactory$Options:inMutable	Z
    //   64: aload 4
    //   66: getstatic 60	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   69: putfield 63	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   72: aload_1
    //   73: iload_2
    //   74: iload_3
    //   75: aload 4
    //   77: invokestatic 68	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   80: astore_1
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: goto +28 -> 112
    //   87: astore_1
    //   88: ldc 10
    //   90: aload_1
    //   91: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   94: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto +13 -> 110
    //   100: astore_1
    //   101: ldc 10
    //   103: aload_1
    //   104: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   107: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aconst_null
    //   111: areturn
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	DefaultDecoder
    //   0	114	1	paramArrayOfByte	byte[]
    //   0	114	2	paramInt1	int
    //   0	114	3	paramInt2	int
    //   0	114	4	paramOptions	BitmapFactory.Options
    //   0	114	5	paramInt3	int
    //   0	114	6	paramInt4	int
    //   7	37	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	81	83	finally
    //   88	97	83	finally
    //   101	110	83	finally
    //   72	81	87	java/lang/OutOfMemoryError
    //   72	81	100	java/lang/RuntimeException
  }
  
  /* Error */
  public Bitmap decodeBitmap(File paramFile, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnull +462 -> 466
    //   7: aload_1
    //   8: invokevirtual 91	java/io/File:exists	()Z
    //   11: ifeq +455 -> 466
    //   14: aload_1
    //   15: invokevirtual 94	java/io/File:isFile	()Z
    //   18: ifeq +448 -> 466
    //   21: aload_1
    //   22: invokevirtual 97	java/io/File:canRead	()Z
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: new 47	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 98	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 9
    //   39: aload 9
    //   41: iconst_1
    //   42: putfield 101	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: new 103	java/io/BufferedInputStream
    //   48: dup
    //   49: new 105	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: sipush 8192
    //   60: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   63: astore 6
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: aconst_null
    //   72: aload 9
    //   74: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: pop
    //   78: aload 6
    //   80: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   83: goto +86 -> 169
    //   86: astore 7
    //   88: goto +20 -> 108
    //   91: astore 7
    //   93: goto +42 -> 135
    //   96: astore_1
    //   97: aconst_null
    //   98: astore 5
    //   100: goto +344 -> 444
    //   103: astore 7
    //   105: aconst_null
    //   106: astore 6
    //   108: aload 6
    //   110: astore 5
    //   112: ldc 10
    //   114: aload 7
    //   116: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   119: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 6
    //   124: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   127: goto +42 -> 169
    //   130: astore 7
    //   132: aconst_null
    //   133: astore 6
    //   135: aload 6
    //   137: astore 5
    //   139: ldc 10
    //   141: aload 7
    //   143: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   146: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload 6
    //   151: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   154: goto +15 -> 169
    //   157: astore 5
    //   159: ldc 10
    //   161: aload 5
    //   163: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 9
    //   171: iconst_0
    //   172: putfield 101	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   175: new 120	com/tencent/component/media/image/ImageLoader$Options
    //   178: dup
    //   179: invokespecial 121	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   182: astore 5
    //   184: aload 5
    //   186: iload_3
    //   187: putfield 125	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   190: aload 5
    //   192: iload_2
    //   193: putfield 128	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   196: iload_3
    //   197: ifle +27 -> 224
    //   200: iload_2
    //   201: ifle +23 -> 224
    //   204: aload 9
    //   206: aload 5
    //   208: aload 9
    //   210: getfield 131	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: aload 9
    //   215: getfield 134	android/graphics/BitmapFactory$Options:outHeight	I
    //   218: invokestatic 140	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   221: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   224: aload 9
    //   226: getfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   229: iconst_1
    //   230: if_icmpge +9 -> 239
    //   233: aload 9
    //   235: iconst_1
    //   236: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   239: new 103	java/io/BufferedInputStream
    //   242: dup
    //   243: new 105	java/io/FileInputStream
    //   246: dup
    //   247: aload_1
    //   248: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   251: sipush 8192
    //   254: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   257: astore 5
    //   259: aload 5
    //   261: astore_1
    //   262: aload 9
    //   264: aload 4
    //   266: invokestatic 149	com/tencent/component/media/utils/BitmapUtils:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;)V
    //   269: aload 5
    //   271: astore_1
    //   272: aload 5
    //   274: aconst_null
    //   275: aload 9
    //   277: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   280: astore 4
    //   282: aload 4
    //   284: astore_1
    //   285: aload 5
    //   287: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   290: aload 4
    //   292: areturn
    //   293: astore 4
    //   295: ldc 10
    //   297: aload 4
    //   299: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: areturn
    //   307: astore 4
    //   309: goto +25 -> 334
    //   312: astore 4
    //   314: goto +48 -> 362
    //   317: astore 4
    //   319: goto +71 -> 390
    //   322: astore_1
    //   323: aconst_null
    //   324: astore 4
    //   326: goto +95 -> 421
    //   329: astore 4
    //   331: aconst_null
    //   332: astore 5
    //   334: aload 5
    //   336: astore_1
    //   337: ldc 10
    //   339: aload 4
    //   341: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   344: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload 8
    //   349: astore_1
    //   350: aload 5
    //   352: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   355: aconst_null
    //   356: areturn
    //   357: astore 4
    //   359: aconst_null
    //   360: astore 5
    //   362: aload 5
    //   364: astore_1
    //   365: ldc 10
    //   367: aload 4
    //   369: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 8
    //   377: astore_1
    //   378: aload 5
    //   380: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   383: aconst_null
    //   384: areturn
    //   385: astore 4
    //   387: aconst_null
    //   388: astore 5
    //   390: aload 5
    //   392: astore_1
    //   393: ldc 10
    //   395: aload 4
    //   397: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   400: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload 8
    //   405: astore_1
    //   406: aload 5
    //   408: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   411: aconst_null
    //   412: areturn
    //   413: astore 5
    //   415: aload_1
    //   416: astore 4
    //   418: aload 5
    //   420: astore_1
    //   421: aload 4
    //   423: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   426: goto +15 -> 441
    //   429: astore 4
    //   431: ldc 10
    //   433: aload 4
    //   435: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   438: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload_1
    //   442: athrow
    //   443: astore_1
    //   444: aload 5
    //   446: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   449: goto +15 -> 464
    //   452: astore 4
    //   454: ldc 10
    //   456: aload 4
    //   458: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_1
    //   465: athrow
    //   466: aconst_null
    //   467: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	DefaultDecoder
    //   0	468	1	paramFile	File
    //   0	468	2	paramInt1	int
    //   0	468	3	paramInt2	int
    //   0	468	4	paramBitmap	Bitmap
    //   67	71	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   157	5	5	localIOException	java.io.IOException
    //   182	225	5	localObject1	Object
    //   413	32	5	localObject2	Object
    //   63	87	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   86	1	7	localThrowable1	Throwable
    //   91	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   103	12	7	localThrowable2	Throwable
    //   130	12	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	403	8	localObject3	Object
    //   37	239	9	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   69	78	86	java/lang/Throwable
    //   69	78	91	java/io/FileNotFoundException
    //   45	65	96	finally
    //   45	65	103	java/lang/Throwable
    //   45	65	130	java/io/FileNotFoundException
    //   78	83	157	java/io/IOException
    //   122	127	157	java/io/IOException
    //   149	154	157	java/io/IOException
    //   285	290	293	java/io/IOException
    //   350	355	293	java/io/IOException
    //   378	383	293	java/io/IOException
    //   406	411	293	java/io/IOException
    //   262	269	307	java/lang/Throwable
    //   272	282	307	java/lang/Throwable
    //   262	269	312	java/lang/OutOfMemoryError
    //   272	282	312	java/lang/OutOfMemoryError
    //   262	269	317	java/io/FileNotFoundException
    //   272	282	317	java/io/FileNotFoundException
    //   239	259	322	finally
    //   239	259	329	java/lang/Throwable
    //   239	259	357	java/lang/OutOfMemoryError
    //   239	259	385	java/io/FileNotFoundException
    //   262	269	413	finally
    //   272	282	413	finally
    //   337	347	413	finally
    //   365	375	413	finally
    //   393	403	413	finally
    //   421	426	429	java/io/IOException
    //   69	78	443	finally
    //   112	122	443	finally
    //   139	149	443	finally
    //   444	449	452	java/io/IOException
  }
  
  public Bitmap decodeFile(File paramFile, BitmapFactory.Options paramOptions)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
      return paramFile;
    }
    catch (OutOfMemoryError paramFile)
    {
      ImageManagerLog.e("DefaultDecoder", Log.getStackTraceString(paramFile));
    }
    return null;
  }
  
  /* Error */
  public BitmapReference decodeImage(File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 105	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_1
    //   14: aload_0
    //   15: aload_3
    //   16: aload_2
    //   17: invokevirtual 162	com/tencent/component/media/image/DefaultDecoder:decodeImage	(Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/component/media/image/BitmapReference;
    //   20: astore 5
    //   22: aload_3
    //   23: astore_2
    //   24: aload 5
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 163	java/io/FileInputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_2
    //   34: goto +138 -> 172
    //   37: astore_2
    //   38: goto +20 -> 58
    //   41: astore_1
    //   42: aload_3
    //   43: astore_2
    //   44: aload_1
    //   45: astore_3
    //   46: goto +69 -> 115
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: goto +120 -> 172
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_3
    //   58: aload_3
    //   59: astore_1
    //   60: new 23	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   67: astore 5
    //   69: aload_3
    //   70: astore_1
    //   71: aload 5
    //   73: ldc 165
    //   75: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: astore_1
    //   81: aload 5
    //   83: aload_2
    //   84: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   87: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: astore_1
    //   93: ldc 10
    //   95: aload 5
    //   97: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +66 -> 170
    //   107: aload 4
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: goto -85 -> 27
    //   115: aload_2
    //   116: astore_1
    //   117: new 23	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   124: astore 5
    //   126: aload_2
    //   127: astore_1
    //   128: aload 5
    //   130: ldc 165
    //   132: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: aload 5
    //   140: aload_3
    //   141: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   144: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: astore_1
    //   150: ldc 10
    //   152: aload 5
    //   154: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload 4
    //   166: astore_1
    //   167: goto -140 -> 27
    //   170: aconst_null
    //   171: areturn
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 163	java/io/FileInputStream:close	()V
    //   180: goto +5 -> 185
    //   183: aload_2
    //   184: athrow
    //   185: goto -2 -> 183
    //   188: astore_2
    //   189: aload_1
    //   190: areturn
    //   191: astore_1
    //   192: goto -12 -> 180
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_2
    //   198: goto -83 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	DefaultDecoder
    //   0	201	1	paramFile	File
    //   0	201	2	paramOptions	BitmapFactory.Options
    //   11	130	3	localObject1	Object
    //   195	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   1	164	4	localObject2	Object
    //   20	133	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	33	finally
    //   60	69	33	finally
    //   71	79	33	finally
    //   81	91	33	finally
    //   93	103	33	finally
    //   117	126	33	finally
    //   128	136	33	finally
    //   138	148	33	finally
    //   150	160	33	finally
    //   14	22	37	java/lang/Throwable
    //   14	22	41	java/io/FileNotFoundException
    //   3	12	49	finally
    //   3	12	55	java/lang/Throwable
    //   27	31	188	java/io/IOException
    //   176	180	191	java/io/IOException
    //   3	12	195	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 103	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_1
    //   11: sipush 8192
    //   14: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   17: astore 4
    //   19: getstatic 172	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 21
    //   24: if_icmplt +190 -> 214
    //   27: ldc 174
    //   29: getstatic 179	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   32: invokevirtual 185	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   35: ifeq +179 -> 214
    //   38: iconst_1
    //   39: istore_3
    //   40: goto +3 -> 43
    //   43: iload_3
    //   44: ifeq +73 -> 117
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore 5
    //   54: new 187	java/io/ByteArrayOutputStream
    //   57: dup
    //   58: invokespecial 188	java/io/ByteArrayOutputStream:<init>	()V
    //   61: astore_1
    //   62: aload 4
    //   64: aload 5
    //   66: iconst_0
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 192	java/io/BufferedInputStream:read	([BII)I
    //   73: istore_3
    //   74: iload_3
    //   75: iconst_m1
    //   76: if_icmpeq +14 -> 90
    //   79: aload_1
    //   80: aload 5
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 196	java/io/ByteArrayOutputStream:write	([BII)V
    //   87: goto -25 -> 62
    //   90: aload_1
    //   91: invokevirtual 200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore 4
    //   96: aload_1
    //   97: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 4
    //   102: iconst_0
    //   103: aload 4
    //   105: arraylength
    //   106: aload_2
    //   107: invokestatic 68	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   110: invokestatic 207	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   113: astore_1
    //   114: goto +14 -> 128
    //   117: aload 4
    //   119: aconst_null
    //   120: aload_2
    //   121: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   124: invokestatic 207	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   127: astore_1
    //   128: aload_1
    //   129: areturn
    //   130: astore_1
    //   131: goto +75 -> 206
    //   134: astore_1
    //   135: new 23	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   142: astore_2
    //   143: aload_2
    //   144: ldc 165
    //   146: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_2
    //   151: aload_1
    //   152: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   155: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 10
    //   161: aload_2
    //   162: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: new 23	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   178: astore_2
    //   179: aload_2
    //   180: ldc 165
    //   182: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_2
    //   187: aload_1
    //   188: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   191: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 10
    //   197: aload_2
    //   198: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aconst_null
    //   205: areturn
    //   206: goto +5 -> 211
    //   209: aload_1
    //   210: athrow
    //   211: goto -2 -> 209
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -173 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	DefaultDecoder
    //   0	219	1	paramFileInputStream	java.io.FileInputStream
    //   0	219	2	paramOptions	BitmapFactory.Options
    //   39	177	3	i	int
    //   17	101	4	localObject	Object
    //   52	29	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	38	130	finally
    //   47	62	130	finally
    //   62	74	130	finally
    //   79	87	130	finally
    //   90	114	130	finally
    //   117	128	130	finally
    //   135	168	130	finally
    //   171	204	130	finally
    //   6	38	134	java/lang/OutOfMemoryError
    //   47	62	134	java/lang/OutOfMemoryError
    //   62	74	134	java/lang/OutOfMemoryError
    //   79	87	134	java/lang/OutOfMemoryError
    //   90	114	134	java/lang/OutOfMemoryError
    //   117	128	134	java/lang/OutOfMemoryError
    //   6	38	170	java/lang/Exception
    //   47	62	170	java/lang/Exception
    //   62	74	170	java/lang/Exception
    //   79	87	170	java/lang/Exception
    //   90	114	170	java/lang/Exception
    //   117	128	170	java/lang/Exception
  }
  
  public BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    try
    {
      paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramInt3, paramInt4);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramOptions = new StringBuilder();
      paramOptions.append("decodeImage error ");
      paramOptions.append(Log.getStackTraceString(paramArrayOfByte));
      ImageManagerLog.e("DefaultDecoder", paramOptions.toString());
      paramArrayOfByte = null;
    }
    return BitmapReference.getBitmapReference(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.DefaultDecoder
 * JD-Core Version:    0.7.0.1
 */