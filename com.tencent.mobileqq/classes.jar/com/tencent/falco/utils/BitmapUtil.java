package com.tencent.falco.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BitmapUtil
{
  public static byte[] bitmap2Bytes(Bitmap paramBitmap, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    IOUtil.close(localByteArrayOutputStream);
    return paramBitmap;
  }
  
  public static Drawable bitmap2Drawable(Resources paramResources, Bitmap paramBitmap)
  {
    return new BitmapDrawable(paramResources, paramBitmap);
  }
  
  /* Error */
  public static String bitmapToBase64(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc 54
    //   2: astore_3
    //   3: aload_0
    //   4: ifnull +125 -> 129
    //   7: new 13	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 14	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: getstatic 57	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   21: bipush 90
    //   23: aload_2
    //   24: invokevirtual 26	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   27: pop
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 60	java/io/ByteArrayOutputStream:flush	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: invokevirtual 33	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   46: iconst_0
    //   47: invokestatic 68	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   50: astore_0
    //   51: aload_0
    //   52: astore_3
    //   53: aload_2
    //   54: ifnull +9 -> 63
    //   57: aload_2
    //   58: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   61: aload_0
    //   62: astore_3
    //   63: aload_3
    //   64: areturn
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   70: aload_0
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   81: aload_2
    //   82: ifnull -19 -> 63
    //   85: aload_2
    //   86: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   89: ldc 54
    //   91: areturn
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   97: ldc 54
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_0
    //   122: goto -19 -> 103
    //   125: astore_0
    //   126: goto -51 -> 75
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_3
    //   132: astore_0
    //   133: goto -82 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramBitmap	Bitmap
    //   16	26	1	localByteArrayOutputStream1	ByteArrayOutputStream
    //   65	2	1	localIOException1	IOException
    //   76	32	1	localByteArrayOutputStream2	ByteArrayOutputStream
    //   113	2	1	localIOException2	IOException
    //   14	117	2	localByteArrayOutputStream3	ByteArrayOutputStream
    //   2	130	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	61	65	java/io/IOException
    //   7	15	72	java/lang/Exception
    //   85	89	92	java/io/IOException
    //   7	15	100	finally
    //   107	111	113	java/io/IOException
    //   17	28	121	finally
    //   30	34	121	finally
    //   36	40	121	finally
    //   42	51	121	finally
    //   77	81	121	finally
    //   17	28	125	java/lang/Exception
    //   30	34	125	java/lang/Exception
    //   36	40	125	java/lang/Exception
    //   42	51	125	java/lang/Exception
  }
  
  public static Bitmap bytes2Bitmap(byte[] paramArrayOfByte)
  {
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    return ((BitmapDrawable)paramDrawable).getBitmap();
  }
  
  /* Error */
  public static android.graphics.Point getBitmapFileSize(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 94	android/graphics/BitmapFactory$Options
    //   5: dup
    //   6: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_1
    //   12: putfield 99	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: new 101	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: aconst_null
    //   28: aload_2
    //   29: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload_1
    //   34: ifnull +7 -> 41
    //   37: aload_1
    //   38: invokevirtual 111	java/io/InputStream:close	()V
    //   41: new 113	android/graphics/Point
    //   44: dup
    //   45: invokespecial 114	android/graphics/Point:<init>	()V
    //   48: astore_0
    //   49: aload_0
    //   50: aload_2
    //   51: getfield 118	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: putfield 121	android/graphics/Point:x	I
    //   57: aload_0
    //   58: aload_2
    //   59: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   62: putfield 127	android/graphics/Point:y	I
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   72: goto -31 -> 41
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 128	java/io/FileNotFoundException:printStackTrace	()V
    //   84: aload_3
    //   85: astore_0
    //   86: aload_1
    //   87: ifnull -22 -> 65
    //   90: aload_1
    //   91: invokevirtual 111	java/io/InputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: invokevirtual 129	java/lang/OutOfMemoryError:printStackTrace	()V
    //   112: aload_3
    //   113: astore_0
    //   114: aload_1
    //   115: ifnull -50 -> 65
    //   118: aload_1
    //   119: invokevirtual 111	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 111	java/io/InputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   149: goto -7 -> 142
    //   152: astore_1
    //   153: goto -19 -> 134
    //   156: astore_2
    //   157: goto -51 -> 106
    //   160: astore_2
    //   161: goto -83 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   23	96	1	localFileInputStream	java.io.FileInputStream
    //   131	12	1	localObject1	Object
    //   152	1	1	localObject2	Object
    //   9	50	2	localOptions	android.graphics.BitmapFactory.Options
    //   75	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   103	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   156	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   160	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	112	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	67	java/io/IOException
    //   15	24	75	java/io/FileNotFoundException
    //   90	94	96	java/io/IOException
    //   15	24	103	java/lang/OutOfMemoryError
    //   118	122	124	java/io/IOException
    //   15	24	131	finally
    //   138	142	144	java/io/IOException
    //   26	33	152	finally
    //   80	84	152	finally
    //   108	112	152	finally
    //   26	33	156	java/lang/OutOfMemoryError
    //   26	33	160	java/io/FileNotFoundException
  }
  
  private static int getExifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      int i;
      if (paramString != null)
      {
        i = paramString.getAttributeInt("Orientation", -1);
        if (i == -1) {}
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return 90;
    }
    return 180;
    return 270;
  }
  
  /* Error */
  public static Bitmap getScaledBitmapSafely(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +11 -> 15
    //   7: iload_1
    //   8: ifle +7 -> 15
    //   11: iload_2
    //   12: ifgt +9 -> 21
    //   15: aconst_null
    //   16: astore 12
    //   18: aload 12
    //   20: areturn
    //   21: aload_0
    //   22: invokestatic 150	com/tencent/falco/utils/BitmapUtil:getBitmapFileSize	(Ljava/lang/String;)Landroid/graphics/Point;
    //   25: astore 12
    //   27: aload 12
    //   29: ifnonnull +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: invokestatic 152	com/tencent/falco/utils/BitmapUtil:getExifOrientation	(Ljava/lang/String;)I
    //   38: istore 5
    //   40: iload 5
    //   42: bipush 90
    //   44: if_icmpeq +16 -> 60
    //   47: iload_1
    //   48: istore 4
    //   50: iload_2
    //   51: istore_3
    //   52: iload 5
    //   54: sipush 270
    //   57: if_icmpne +8 -> 65
    //   60: iload_1
    //   61: istore_3
    //   62: iload_2
    //   63: istore 4
    //   65: iconst_1
    //   66: istore_1
    //   67: iload_1
    //   68: istore_2
    //   69: aload 12
    //   71: getfield 121	android/graphics/Point:x	I
    //   74: iload_1
    //   75: idiv
    //   76: iload 4
    //   78: if_icmple +37 -> 115
    //   81: iload_1
    //   82: istore_2
    //   83: aload 12
    //   85: getfield 127	android/graphics/Point:y	I
    //   88: iload_1
    //   89: idiv
    //   90: iload_3
    //   91: if_icmple +24 -> 115
    //   94: iload_1
    //   95: iconst_2
    //   96: imul
    //   97: istore_2
    //   98: iload_2
    //   99: istore_1
    //   100: iload_2
    //   101: i2d
    //   102: ldc2_w 153
    //   105: ldc2_w 155
    //   108: invokestatic 162	java/lang/Math:pow	(DD)D
    //   111: dcmpl
    //   112: ifle -45 -> 67
    //   115: iload 4
    //   117: aload 12
    //   119: getfield 121	android/graphics/Point:x	I
    //   122: invokestatic 166	java/lang/Math:min	(II)I
    //   125: istore_1
    //   126: iload_3
    //   127: aload 12
    //   129: getfield 127	android/graphics/Point:y	I
    //   132: invokestatic 166	java/lang/Math:min	(II)I
    //   135: istore_3
    //   136: iload_1
    //   137: i2l
    //   138: lstore 6
    //   140: iload_3
    //   141: i2l
    //   142: lstore 8
    //   144: invokestatic 172	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   147: invokevirtual 176	java/lang/Runtime:maxMemory	()J
    //   150: ldc2_w 177
    //   153: ldiv
    //   154: lstore 10
    //   156: iconst_1
    //   157: istore_1
    //   158: iload_1
    //   159: istore_3
    //   160: lload 6
    //   162: lload 8
    //   164: lmul
    //   165: ldc2_w 179
    //   168: lmul
    //   169: iload_1
    //   170: i2l
    //   171: ldiv
    //   172: lload 10
    //   174: lcmp
    //   175: iflt +24 -> 199
    //   178: iload_1
    //   179: iconst_2
    //   180: imul
    //   181: istore_3
    //   182: iload_3
    //   183: istore_1
    //   184: iload_2
    //   185: i2d
    //   186: ldc2_w 153
    //   189: ldc2_w 155
    //   192: invokestatic 162	java/lang/Math:pow	(DD)D
    //   195: dcmpl
    //   196: ifle -38 -> 158
    //   199: new 94	android/graphics/BitmapFactory$Options
    //   202: dup
    //   203: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   206: astore 15
    //   208: aload 15
    //   210: iload_2
    //   211: iload_3
    //   212: imul
    //   213: putfield 183	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   216: aload 15
    //   218: getstatic 189	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   221: putfield 192	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   224: aconst_null
    //   225: astore 14
    //   227: aconst_null
    //   228: astore 12
    //   230: aconst_null
    //   231: astore 13
    //   233: new 101	java/io/FileInputStream
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   241: astore_0
    //   242: aload_0
    //   243: astore 12
    //   245: aload_0
    //   246: aconst_null
    //   247: aload 15
    //   249: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   252: astore 13
    //   254: aload 13
    //   256: astore 12
    //   258: aload_0
    //   259: ifnull -241 -> 18
    //   262: aload_0
    //   263: invokevirtual 111	java/io/InputStream:close	()V
    //   266: aload 13
    //   268: areturn
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   274: aload 13
    //   276: areturn
    //   277: astore 13
    //   279: aconst_null
    //   280: astore_0
    //   281: aload_0
    //   282: astore 12
    //   284: aload 13
    //   286: invokevirtual 128	java/io/FileNotFoundException:printStackTrace	()V
    //   289: aload 14
    //   291: astore 12
    //   293: aload_0
    //   294: ifnull -276 -> 18
    //   297: aload_0
    //   298: invokevirtual 111	java/io/InputStream:close	()V
    //   301: aconst_null
    //   302: areturn
    //   303: astore_0
    //   304: aload_0
    //   305: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   308: aconst_null
    //   309: areturn
    //   310: astore 12
    //   312: aload 13
    //   314: astore_0
    //   315: aload 12
    //   317: astore 13
    //   319: aload_0
    //   320: astore 12
    //   322: aload 13
    //   324: invokevirtual 129	java/lang/OutOfMemoryError:printStackTrace	()V
    //   327: aload 14
    //   329: astore 12
    //   331: aload_0
    //   332: ifnull -314 -> 18
    //   335: aload_0
    //   336: invokevirtual 111	java/io/InputStream:close	()V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   346: aconst_null
    //   347: areturn
    //   348: astore_0
    //   349: aload 12
    //   351: ifnull +8 -> 359
    //   354: aload 12
    //   356: invokevirtual 111	java/io/InputStream:close	()V
    //   359: aload_0
    //   360: athrow
    //   361: astore 12
    //   363: aload 12
    //   365: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   368: goto -9 -> 359
    //   371: astore_0
    //   372: goto -23 -> 349
    //   375: astore 13
    //   377: goto -58 -> 319
    //   380: astore 13
    //   382: goto -101 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   0	385	1	paramInt1	int
    //   0	385	2	paramInt2	int
    //   51	162	3	i	int
    //   48	68	4	j	int
    //   38	20	5	k	int
    //   138	23	6	l1	long
    //   142	21	8	l2	long
    //   154	19	10	l3	long
    //   16	276	12	localObject1	Object
    //   310	6	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   320	35	12	localObject2	Object
    //   361	3	12	localIOException	IOException
    //   231	44	13	localBitmap	Bitmap
    //   277	36	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   317	6	13	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   375	1	13	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   380	1	13	localFileNotFoundException2	java.io.FileNotFoundException
    //   225	103	14	localObject3	Object
    //   206	42	15	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   262	266	269	java/io/IOException
    //   233	242	277	java/io/FileNotFoundException
    //   297	301	303	java/io/IOException
    //   233	242	310	java/lang/OutOfMemoryError
    //   335	339	341	java/io/IOException
    //   233	242	348	finally
    //   322	327	348	finally
    //   354	359	361	java/io/IOException
    //   245	254	371	finally
    //   284	289	371	finally
    //   245	254	375	java/lang/OutOfMemoryError
    //   245	254	380	java/io/FileNotFoundException
  }
  
  public static Bitmap getScaledBitmapSafelyWithOrientation(String paramString, int paramInt1, int paramInt2)
  {
    int m = -1;
    int k = 0;
    int j = 1;
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    Bitmap localBitmap = getScaledBitmapSafely(paramString, paramInt1, paramInt2);
    if (localBitmap == null) {
      return null;
    }
    int i = j;
    paramInt1 = m;
    paramInt2 = k;
    for (;;)
    {
      try
      {
        switch (new ExifInterface(paramString).getAttributeInt("Orientation", 1))
        {
        case 2: 
          paramString = new Matrix();
          paramString.postRotate(paramInt2);
          paramString.postScale(paramInt1, i);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);
          return paramString;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramInt2 = 90;
      paramInt1 = 1;
      i = j;
      continue;
      paramInt2 = 180;
      paramInt1 = 1;
      i = j;
      continue;
      paramInt2 = 270;
      paramInt1 = 1;
      i = j;
      continue;
      paramInt1 = 1;
      i = -1;
      paramInt2 = k;
      continue;
      paramInt1 = 1;
      i = j;
      paramInt2 = k;
    }
  }
  
  public static Bitmap imageView2Bitmap(ImageView paramImageView)
  {
    try
    {
      localBitmap = Bitmap.createBitmap(paramImageView.getDrawingCache());
      paramImageView.printStackTrace();
    }
    catch (Exception paramImageView)
    {
      try
      {
        paramImageView.setDrawingCacheEnabled(false);
        return localBitmap;
      }
      catch (Exception paramImageView)
      {
        Bitmap localBitmap;
        break label18;
      }
      paramImageView = paramImageView;
      localBitmap = null;
    }
    label18:
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */