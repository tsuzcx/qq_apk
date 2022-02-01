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
    //   2: astore_2
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_2
    //   12: astore_1
    //   13: aload_0
    //   14: ifnull +116 -> 130
    //   17: aload 5
    //   19: astore_3
    //   20: new 13	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 14	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_1
    //   28: aload_0
    //   29: getstatic 57	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   32: bipush 90
    //   34: aload_1
    //   35: invokevirtual 26	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual 60	java/io/ByteArrayOutputStream:flush	()V
    //   43: aload_1
    //   44: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: invokevirtual 33	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: iconst_0
    //   52: invokestatic 68	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   55: astore_0
    //   56: aload_1
    //   57: astore_3
    //   58: aload_0
    //   59: astore_1
    //   60: goto +70 -> 130
    //   63: astore_0
    //   64: goto +48 -> 112
    //   67: astore_3
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: astore_1
    //   72: goto +13 -> 85
    //   75: astore_0
    //   76: aload_3
    //   77: astore_1
    //   78: goto +34 -> 112
    //   81: astore_1
    //   82: aload 4
    //   84: astore_0
    //   85: aload_0
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   91: aload_2
    //   92: astore 4
    //   94: aload_0
    //   95: ifnull +51 -> 146
    //   98: aload_0
    //   99: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   102: ldc 54
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   110: aload_2
    //   111: areturn
    //   112: aload_1
    //   113: ifnull +15 -> 128
    //   116: aload_1
    //   117: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   120: goto +8 -> 128
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    //   130: aload_1
    //   131: astore 4
    //   133: aload_3
    //   134: ifnull +12 -> 146
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   143: aload_1
    //   144: astore 4
    //   146: aload 4
    //   148: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramBitmap	Bitmap
    //   12	66	1	localObject1	Object
    //   81	36	1	localException1	Exception
    //   123	21	1	localIOException	IOException
    //   2	137	2	localObject2	Object
    //   7	51	3	localObject3	Object
    //   67	10	3	localException2	Exception
    //   86	54	3	localBitmap	Bitmap
    //   4	143	4	localObject4	Object
    //   9	9	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	56	63	finally
    //   28	56	67	java/lang/Exception
    //   20	28	75	finally
    //   87	91	75	finally
    //   20	28	81	java/lang/Exception
    //   98	102	105	java/io/IOException
    //   139	143	105	java/io/IOException
    //   116	120	123	java/io/IOException
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
    //   0: new 94	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 99	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: new 101	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: aconst_null
    //   26: aload_2
    //   27: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 111	java/io/InputStream:close	()V
    //   35: goto +8 -> 43
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   43: new 113	android/graphics/Point
    //   46: dup
    //   47: invokespecial 114	android/graphics/Point:<init>	()V
    //   50: astore_0
    //   51: aload_0
    //   52: aload_2
    //   53: getfield 118	android/graphics/BitmapFactory$Options:outWidth	I
    //   56: putfield 121	android/graphics/Point:x	I
    //   59: aload_0
    //   60: aload_2
    //   61: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   64: putfield 127	android/graphics/Point:y	I
    //   67: aload_0
    //   68: areturn
    //   69: astore_2
    //   70: goto +16 -> 86
    //   73: astore_2
    //   74: goto +38 -> 112
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto +56 -> 136
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: invokevirtual 128	java/lang/OutOfMemoryError:printStackTrace	()V
    //   92: aload_1
    //   93: ifnull +14 -> 107
    //   96: aload_1
    //   97: invokevirtual 111	java/io/InputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 129	java/io/FileNotFoundException:printStackTrace	()V
    //   118: aload_1
    //   119: ifnull +14 -> 133
    //   122: aload_1
    //   123: invokevirtual 111	java/io/InputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aload_0
    //   137: ifnull +15 -> 152
    //   140: aload_0
    //   141: invokevirtual 111	java/io/InputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   21	11	1	localFileInputStream	java.io.FileInputStream
    //   77	1	1	localObject1	Object
    //   85	38	1	localObject2	Object
    //   135	18	1	localObject3	Object
    //   7	54	2	localOptions	android.graphics.BitmapFactory.Options
    //   69	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   73	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   83	6	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   109	6	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   31	35	38	java/io/IOException
    //   24	31	69	java/lang/OutOfMemoryError
    //   24	31	73	java/io/FileNotFoundException
    //   13	22	77	finally
    //   13	22	83	java/lang/OutOfMemoryError
    //   96	100	102	java/io/IOException
    //   13	22	109	java/io/FileNotFoundException
    //   122	126	128	java/io/IOException
    //   24	31	135	finally
    //   88	92	135	finally
    //   114	118	135	finally
    //   140	144	147	java/io/IOException
  }
  
  private static int getExifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString != null)
    {
      int i = paramString.getAttributeInt("Orientation", -1);
      if (i != -1) {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i == 8) {
              return 270;
            }
          }
          else {
            return 90;
          }
        }
        else {
          return 180;
        }
      }
    }
    return 0;
  }
  
  /* Error */
  public static Bitmap getScaledBitmapSafely(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 6
    //   6: aconst_null
    //   7: astore 15
    //   9: iload 6
    //   11: ifne +363 -> 374
    //   14: iload_1
    //   15: ifle +359 -> 374
    //   18: iload_2
    //   19: ifgt +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: invokestatic 150	com/tencent/falco/utils/BitmapUtil:getBitmapFileSize	(Ljava/lang/String;)Landroid/graphics/Point;
    //   28: astore 13
    //   30: aload 13
    //   32: ifnonnull +5 -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: invokestatic 152	com/tencent/falco/utils/BitmapUtil:getExifOrientation	(Ljava/lang/String;)I
    //   41: istore_3
    //   42: iload_3
    //   43: bipush 90
    //   45: if_icmpeq +21 -> 66
    //   48: iload_3
    //   49: sipush 270
    //   52: if_icmpne +6 -> 58
    //   55: goto +11 -> 66
    //   58: iload_1
    //   59: istore 4
    //   61: iload_2
    //   62: istore_3
    //   63: goto +8 -> 71
    //   66: iload_1
    //   67: istore_3
    //   68: iload_2
    //   69: istore 4
    //   71: iconst_1
    //   72: istore 5
    //   74: iconst_1
    //   75: istore_1
    //   76: iload_1
    //   77: istore_2
    //   78: aload 13
    //   80: getfield 121	android/graphics/Point:x	I
    //   83: iload_1
    //   84: idiv
    //   85: iload 4
    //   87: if_icmple +37 -> 124
    //   90: iload_1
    //   91: istore_2
    //   92: aload 13
    //   94: getfield 127	android/graphics/Point:y	I
    //   97: iload_1
    //   98: idiv
    //   99: iload_3
    //   100: if_icmple +24 -> 124
    //   103: iload_1
    //   104: iconst_2
    //   105: imul
    //   106: istore_2
    //   107: iload_2
    //   108: istore_1
    //   109: iload_2
    //   110: i2d
    //   111: ldc2_w 153
    //   114: ldc2_w 155
    //   117: invokestatic 162	java/lang/Math:pow	(DD)D
    //   120: dcmpl
    //   121: ifle -45 -> 76
    //   124: iload 4
    //   126: aload 13
    //   128: getfield 121	android/graphics/Point:x	I
    //   131: invokestatic 166	java/lang/Math:min	(II)I
    //   134: istore_1
    //   135: iload_3
    //   136: aload 13
    //   138: getfield 127	android/graphics/Point:y	I
    //   141: invokestatic 166	java/lang/Math:min	(II)I
    //   144: istore_3
    //   145: iload_1
    //   146: i2l
    //   147: lstore 7
    //   149: iload_3
    //   150: i2l
    //   151: lstore 9
    //   153: invokestatic 172	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   156: invokevirtual 176	java/lang/Runtime:maxMemory	()J
    //   159: ldc2_w 177
    //   162: ldiv
    //   163: lstore 11
    //   165: iload 5
    //   167: istore_1
    //   168: iload_1
    //   169: istore_3
    //   170: lload 7
    //   172: lload 9
    //   174: lmul
    //   175: ldc2_w 179
    //   178: lmul
    //   179: iload_1
    //   180: i2l
    //   181: ldiv
    //   182: lload 11
    //   184: lcmp
    //   185: iflt +24 -> 209
    //   188: iload_1
    //   189: iconst_2
    //   190: imul
    //   191: istore_3
    //   192: iload_3
    //   193: istore_1
    //   194: iload_2
    //   195: i2d
    //   196: ldc2_w 153
    //   199: ldc2_w 155
    //   202: invokestatic 162	java/lang/Math:pow	(DD)D
    //   205: dcmpl
    //   206: ifle -38 -> 168
    //   209: new 94	android/graphics/BitmapFactory$Options
    //   212: dup
    //   213: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   216: astore 14
    //   218: aload 14
    //   220: iload_2
    //   221: iload_3
    //   222: imul
    //   223: putfield 183	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   226: aload 14
    //   228: getstatic 189	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   231: putfield 192	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   234: new 101	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   242: astore 13
    //   244: aload 13
    //   246: astore_0
    //   247: aload 13
    //   249: aconst_null
    //   250: aload 14
    //   252: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   255: astore 14
    //   257: aload 14
    //   259: astore_0
    //   260: aload 13
    //   262: invokevirtual 111	java/io/InputStream:close	()V
    //   265: aload 14
    //   267: areturn
    //   268: astore 13
    //   270: aload 13
    //   272: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   275: aload_0
    //   276: areturn
    //   277: astore 14
    //   279: goto +20 -> 299
    //   282: astore 14
    //   284: goto +43 -> 327
    //   287: astore 13
    //   289: aconst_null
    //   290: astore_0
    //   291: goto +64 -> 355
    //   294: astore 14
    //   296: aconst_null
    //   297: astore 13
    //   299: aload 13
    //   301: astore_0
    //   302: aload 14
    //   304: invokevirtual 128	java/lang/OutOfMemoryError:printStackTrace	()V
    //   307: aload 13
    //   309: ifnull +39 -> 348
    //   312: aload 15
    //   314: astore_0
    //   315: aload 13
    //   317: invokevirtual 111	java/io/InputStream:close	()V
    //   320: aconst_null
    //   321: areturn
    //   322: astore 14
    //   324: aconst_null
    //   325: astore 13
    //   327: aload 13
    //   329: astore_0
    //   330: aload 14
    //   332: invokevirtual 129	java/io/FileNotFoundException:printStackTrace	()V
    //   335: aload 13
    //   337: ifnull +11 -> 348
    //   340: aload 15
    //   342: astore_0
    //   343: aload 13
    //   345: invokevirtual 111	java/io/InputStream:close	()V
    //   348: aconst_null
    //   349: areturn
    //   350: astore 13
    //   352: goto -61 -> 291
    //   355: aload_0
    //   356: ifnull +15 -> 371
    //   359: aload_0
    //   360: invokevirtual 111	java/io/InputStream:close	()V
    //   363: goto +8 -> 371
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   371: aload 13
    //   373: athrow
    //   374: aconst_null
    //   375: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramString	String
    //   0	376	1	paramInt1	int
    //   0	376	2	paramInt2	int
    //   41	182	3	i	int
    //   59	66	4	j	int
    //   72	94	5	k	int
    //   4	6	6	bool	boolean
    //   147	24	7	l1	long
    //   151	22	9	l2	long
    //   163	20	11	l3	long
    //   28	233	13	localObject1	Object
    //   268	3	13	localIOException	IOException
    //   287	1	13	localObject2	Object
    //   297	47	13	localObject3	Object
    //   350	22	13	localObject4	Object
    //   216	50	14	localObject5	Object
    //   277	1	14	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   282	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   294	9	14	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   322	9	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	334	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   260	265	268	java/io/IOException
    //   315	320	268	java/io/IOException
    //   343	348	268	java/io/IOException
    //   247	257	277	java/lang/OutOfMemoryError
    //   247	257	282	java/io/FileNotFoundException
    //   234	244	287	finally
    //   234	244	294	java/lang/OutOfMemoryError
    //   234	244	322	java/io/FileNotFoundException
    //   247	257	350	finally
    //   302	307	350	finally
    //   330	335	350	finally
    //   359	363	366	java/io/IOException
  }
  
  public static Bitmap getScaledBitmapSafelyWithOrientation(String paramString, int paramInt1, int paramInt2)
  {
    int j;
    int i;
    int k;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return null;
      }
      Bitmap localBitmap = getScaledBitmapSafely(paramString, paramInt1, paramInt2);
      if (localBitmap == null) {
        return null;
      }
      try
      {
        paramString = new ExifInterface(paramString);
        j = 1;
        paramInt2 = 1;
        int m = paramString.getAttributeInt("Orientation", 1);
        i = -1;
        k = 0;
        paramInt1 = 0;
        if (m == 2) {
          break label190;
        }
        if (m == 3) {
          break label180;
        }
        if (m != 4)
        {
          if (m == 6) {
            break label171;
          }
          if (m == 8) {
            break label161;
          }
          paramInt1 = k;
          paramInt2 = j;
          break label156;
        }
        paramString = new Matrix();
        paramString.postRotate(paramInt1);
        paramString.postScale(paramInt2, i);
        paramString = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    else
    {
      return null;
    }
    for (;;)
    {
      label156:
      i = 1;
      break;
      label161:
      paramInt1 = 270;
      paramInt2 = j;
      continue;
      label171:
      paramInt1 = 90;
      paramInt2 = j;
      continue;
      label180:
      paramInt1 = 180;
      paramInt2 = j;
      continue;
      label190:
      paramInt2 = -1;
      paramInt1 = k;
    }
  }
  
  public static Bitmap imageView2Bitmap(ImageView paramImageView)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramImageView.getDrawingCache());
      localObject = localBitmap;
      paramImageView.setDrawingCacheEnabled(false);
      return localBitmap;
    }
    catch (Exception paramImageView)
    {
      paramImageView.printStackTrace();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */