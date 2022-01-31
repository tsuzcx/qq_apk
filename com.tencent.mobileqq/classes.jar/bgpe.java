import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bgpe
{
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    double d3 = 1.0D;
    if ((i <= paramInt1) && (j <= paramInt2)) {
      return d3;
    }
    double d1;
    if (i > j) {
      d1 = i / paramInt1;
    }
    for (double d2 = j / paramInt2;; d2 = i / paramInt2)
    {
      d3 = d1;
      if (d1 > d2) {
        break;
      }
      return d2;
      d1 = j / paramInt1;
    }
  }
  
  public static int a(BitmapFactory.Options paramOptions, float paramFloat1, float paramFloat2)
  {
    int i = 1;
    int j = 1;
    if (paramOptions == null) {}
    int k;
    int m;
    do
    {
      return j;
      k = paramOptions.outHeight;
      m = paramOptions.outWidth;
    } while ((k <= paramFloat2) && (m <= paramFloat1));
    float f1 = k / 2;
    float f2 = m / 2;
    for (;;)
    {
      j = i;
      if (f1 / i < paramFloat2) {
        break;
      }
      j = i;
      if (f2 / i < paramFloat1) {
        break;
      }
      i *= 2;
    }
  }
  
  public static int a(String paramString)
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
        paramString = null;
      }
      return 90;
    }
    return 180;
    return 270;
  }
  
  public static Bitmap a(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        float f3 = paramFloat1 / f1;
        float f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          j = (int)paramFloat1;
          i = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(j / f1, i / f2);
          localMatrix.postTranslate((paramFloat1 - j) / 2.0F, 0.0F);
          Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_4444);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          paramBitmap = localBitmap;
          return paramBitmap;
        }
        int j = (int)(f1 * f4);
        int i = (int)paramFloat2;
        continue;
        paramBitmap = null;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        return null;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +20 -> 24
    //   7: aload_0
    //   8: astore 4
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: getstatic 105	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   17: aload_1
    //   18: if_acmpne +9 -> 27
    //   21: aload_0
    //   22: astore 4
    //   24: aload 4
    //   26: areturn
    //   27: bipush 100
    //   29: istore_3
    //   30: ldc 106
    //   32: aload_0
    //   33: invokevirtual 59	android/graphics/Bitmap:getWidth	()I
    //   36: i2f
    //   37: fdiv
    //   38: ldc 107
    //   40: aload_0
    //   41: invokevirtual 62	android/graphics/Bitmap:getHeight	()I
    //   44: i2f
    //   45: fdiv
    //   46: invokestatic 113	java/lang/Math:min	(FF)F
    //   49: fstore_2
    //   50: fload_2
    //   51: fconst_1
    //   52: fcmpg
    //   53: ifge +10 -> 63
    //   56: bipush 100
    //   58: i2f
    //   59: fload_2
    //   60: fmul
    //   61: f2i
    //   62: istore_3
    //   63: new 115	java/io/ByteArrayOutputStream
    //   66: dup
    //   67: invokespecial 116	java/io/ByteArrayOutputStream:<init>	()V
    //   70: astore 5
    //   72: aload 5
    //   74: astore 4
    //   76: aload_0
    //   77: aload_1
    //   78: iload_3
    //   79: aload 5
    //   81: invokevirtual 120	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   84: pop
    //   85: aload 5
    //   87: astore 4
    //   89: aload 5
    //   91: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_1
    //   95: aload 5
    //   97: astore 4
    //   99: aload_1
    //   100: iconst_0
    //   101: aload_1
    //   102: arraylength
    //   103: invokestatic 128	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: aload_0
    //   110: astore 4
    //   112: aload 5
    //   114: ifnull -90 -> 24
    //   117: aload 5
    //   119: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   122: aload_0
    //   123: areturn
    //   124: astore_1
    //   125: aload_0
    //   126: areturn
    //   127: astore 6
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore 4
    //   134: ldc 133
    //   136: new 135	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   143: ldc 138
    //   145: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 155	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: astore 4
    //   162: aload_1
    //   163: ifnull -139 -> 24
    //   166: aload_1
    //   167: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: areturn
    //   172: astore_1
    //   173: aload_0
    //   174: areturn
    //   175: astore_0
    //   176: aconst_null
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: astore_1
    //   192: goto -3 -> 189
    //   195: astore_0
    //   196: goto -17 -> 179
    //   199: astore 6
    //   201: aload 5
    //   203: astore_1
    //   204: goto -73 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramBitmap	Bitmap
    //   0	207	1	paramCompressFormat	Bitmap.CompressFormat
    //   49	11	2	f	float
    //   29	50	3	i	int
    //   1	184	4	localObject	Object
    //   70	132	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   127	22	6	localThrowable1	Throwable
    //   199	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   117	122	124	java/lang/Exception
    //   63	72	127	java/lang/Throwable
    //   166	170	172	java/lang/Exception
    //   63	72	175	finally
    //   184	189	191	java/lang/Exception
    //   76	85	195	finally
    //   89	95	195	finally
    //   99	107	195	finally
    //   134	159	195	finally
    //   76	85	199	java/lang/Throwable
    //   89	95	199	java/lang/Throwable
    //   99	107	199	java/lang/Throwable
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 191	bgpv:a	(Ljava/lang/String;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: new 193	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: new 196	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_0
    //   27: sipush 8192
    //   30: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 202	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 203	java/io/FileInputStream:close	()V
    //   49: aload_2
    //   50: astore_0
    //   51: aload_1
    //   52: ifnull -41 -> 11
    //   55: aload_1
    //   56: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 203	java/io/FileInputStream:close	()V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_1
    //   84: ifnull -73 -> 11
    //   87: aload_1
    //   88: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 203	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull -105 -> 11
    //   119: aload_1
    //   120: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 203	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -29 -> 137
    //   169: astore_2
    //   170: goto -33 -> 137
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_1
    //   176: goto -71 -> 105
    //   179: astore_3
    //   180: goto -75 -> 105
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -113 -> 73
    //   189: astore_3
    //   190: goto -117 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString	String
    //   33	133	1	localBufferedInputStream	BufferedInputStream
    //   173	1	1	localFileNotFoundException1	FileNotFoundException
    //   175	1	1	localObject1	Object
    //   183	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   185	1	1	localObject2	Object
    //   1	113	2	localObject3	Object
    //   132	22	2	localObject4	Object
    //   163	1	2	localObject5	Object
    //   169	1	2	localObject6	Object
    //   38	2	3	localBitmap	Bitmap
    //   179	1	3	localFileNotFoundException2	FileNotFoundException
    //   189	1	3	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   45	49	61	java/io/IOException
    //   55	59	61	java/io/IOException
    //   13	22	68	java/lang/OutOfMemoryError
    //   77	81	93	java/io/IOException
    //   87	91	93	java/io/IOException
    //   13	22	100	java/io/FileNotFoundException
    //   109	113	125	java/io/IOException
    //   119	123	125	java/io/IOException
    //   13	22	132	finally
    //   141	145	155	java/io/IOException
    //   149	153	155	java/io/IOException
    //   22	34	163	finally
    //   34	39	169	finally
    //   22	34	173	java/io/FileNotFoundException
    //   34	39	179	java/io/FileNotFoundException
    //   22	34	183	java/lang/OutOfMemoryError
    //   34	39	189	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    if ((bgpv.a(paramString)) || (paramOptions == null)) {
      paramOptions = null;
    }
    Bitmap localBitmap;
    do
    {
      return paramOptions;
      try
      {
        if (b(paramString)) {}
        for (paramOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;; paramOptions.inPreferredConfig = Bitmap.Config.RGB_565)
        {
          localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
          if (!a(paramString)) {
            break;
          }
          return a(localBitmap, Bitmap.CompressFormat.JPEG);
        }
        paramOptions = localBitmap;
      }
      catch (Throwable paramString)
      {
        QMLog.e("ImageUtil", "getLocalBitmap error! " + paramString);
        return null;
      }
    } while (!c(paramString));
    paramString = a(localBitmap, Bitmap.CompressFormat.WEBP);
    return paramString;
  }
  
  public static BitmapFactory.Options a(File paramFile, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    double d = a(localFileInputStream, paramInt1, paramInt2);
    localFileInputStream.close();
    localOptions.inSampleSize = ((int)d);
    localOptions.inJustDecodeBounds = true;
    localFileInputStream = new FileInputStream(paramFile);
    BitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    localFileInputStream.close();
    paramInt2 = 0;
    for (;;)
    {
      if (localOptions.outWidth > paramInt1)
      {
        localOptions.inSampleSize += 1;
        localFileInputStream = new FileInputStream(paramFile);
        BitmapFactory.decodeStream(localFileInputStream, null, localOptions);
        localFileInputStream.close();
        if (paramInt2 <= 3) {}
      }
      else
      {
        localOptions.inJustDecodeBounds = false;
        return localOptions;
      }
      paramInt2 += 1;
    }
  }
  
  /* Error */
  public static ByteArrayInputStream a(String paramString)
  {
    // Byte code:
    //   0: new 249	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 254	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 193	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: new 196	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: sipush 8192
    //   35: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: astore_3
    //   39: new 115	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 116	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore_0
    //   47: aload_3
    //   48: astore 6
    //   50: aload_0
    //   51: astore 5
    //   53: aload_2
    //   54: astore 4
    //   56: sipush 1024
    //   59: newarray byte
    //   61: astore 7
    //   63: aload_3
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_2
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: invokevirtual 258	java/io/BufferedInputStream:read	([B)I
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_m1
    //   81: if_icmpeq +72 -> 153
    //   84: aload_3
    //   85: astore 6
    //   87: aload_0
    //   88: astore 5
    //   90: aload_2
    //   91: astore 4
    //   93: aload_0
    //   94: aload 7
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 262	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -38 -> 63
    //   104: astore 7
    //   106: aload_3
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload_2
    //   113: astore 4
    //   115: aload 7
    //   117: invokevirtual 263	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   136: aload_2
    //   137: ifnull -121 -> 16
    //   140: aload_2
    //   141: invokevirtual 203	java/io/FileInputStream:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: aload_3
    //   154: astore 6
    //   156: aload_0
    //   157: astore 5
    //   159: aload_2
    //   160: astore 4
    //   162: new 265	java/io/ByteArrayInputStream
    //   165: dup
    //   166: aload_0
    //   167: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   170: invokespecial 268	java/io/ByteArrayInputStream:<init>	([B)V
    //   173: astore 7
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 203	java/io/FileInputStream:close	()V
    //   199: aload 7
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   207: goto -8 -> 199
    //   210: astore 7
    //   212: aconst_null
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_3
    //   219: astore 6
    //   221: aload_0
    //   222: astore 5
    //   224: aload_2
    //   225: astore 4
    //   227: aload 7
    //   229: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   248: aload_2
    //   249: ifnull -233 -> 16
    //   252: aload_2
    //   253: invokevirtual 203	java/io/FileInputStream:close	()V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_3
    //   268: aconst_null
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_2
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 203	java/io/FileInputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   306: goto -7 -> 299
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_3
    //   312: aconst_null
    //   313: astore 5
    //   315: goto -42 -> 273
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 5
    //   322: goto -49 -> 273
    //   325: astore_0
    //   326: aload 6
    //   328: astore_3
    //   329: aload 4
    //   331: astore_2
    //   332: goto -59 -> 273
    //   335: astore 7
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -123 -> 218
    //   344: astore 7
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -130 -> 218
    //   351: astore 7
    //   353: goto -135 -> 218
    //   356: astore 7
    //   358: aconst_null
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -258 -> 106
    //   367: astore 7
    //   369: aconst_null
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_0
    //   373: goto -267 -> 106
    //   376: astore 7
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -274 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramString	String
    //   78	20	1	i	int
    //   26	270	2	localFileInputStream1	FileInputStream
    //   301	2	2	localIOException1	IOException
    //   331	33	2	localObject1	Object
    //   38	333	3	localObject2	Object
    //   54	276	4	localFileInputStream2	FileInputStream
    //   51	270	5	str	String
    //   48	279	6	localObject3	Object
    //   61	34	7	arrayOfByte	byte[]
    //   104	12	7	localFileNotFoundException1	FileNotFoundException
    //   173	27	7	localByteArrayInputStream	ByteArrayInputStream
    //   210	18	7	localIOException2	IOException
    //   335	1	7	localIOException3	IOException
    //   344	1	7	localIOException4	IOException
    //   351	1	7	localIOException5	IOException
    //   356	1	7	localFileNotFoundException2	FileNotFoundException
    //   367	1	7	localFileNotFoundException3	FileNotFoundException
    //   376	1	7	localFileNotFoundException4	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   56	63	104	java/io/FileNotFoundException
    //   72	79	104	java/io/FileNotFoundException
    //   93	101	104	java/io/FileNotFoundException
    //   162	175	104	java/io/FileNotFoundException
    //   124	128	146	java/io/IOException
    //   132	136	146	java/io/IOException
    //   140	144	146	java/io/IOException
    //   179	183	202	java/io/IOException
    //   187	191	202	java/io/IOException
    //   195	199	202	java/io/IOException
    //   18	27	210	java/io/IOException
    //   236	240	258	java/io/IOException
    //   244	248	258	java/io/IOException
    //   252	256	258	java/io/IOException
    //   18	27	265	finally
    //   278	283	301	java/io/IOException
    //   287	291	301	java/io/IOException
    //   295	299	301	java/io/IOException
    //   27	39	309	finally
    //   39	47	318	finally
    //   56	63	325	finally
    //   72	79	325	finally
    //   93	101	325	finally
    //   115	120	325	finally
    //   162	175	325	finally
    //   227	232	325	finally
    //   27	39	335	java/io/IOException
    //   39	47	344	java/io/IOException
    //   56	63	351	java/io/IOException
    //   72	79	351	java/io/IOException
    //   93	101	351	java/io/IOException
    //   162	175	351	java/io/IOException
    //   18	27	356	java/io/FileNotFoundException
    //   27	39	367	java/io/FileNotFoundException
    //   39	47	376	java/io/FileNotFoundException
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
  }
  
  public static InputStream a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int k = a(paramString);
    int j = Math.max(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight);
    int i = 1;
    while (j > 4000)
    {
      j /= 2;
      i *= 2;
    }
    Object localObject3;
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject2;
    if (i > 1)
    {
      QMLog.w("ImageUtil", "getLocalImageStream: start to crop image");
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject1).inSampleSize = i;
      localObject3 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (k != 0) {}
        try
        {
          localObject1 = a(k, (Bitmap)localObject3);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          if (paramBoolean)
          {
            localObject3 = Bitmap.CompressFormat.PNG;
            if (!((Bitmap)localObject1).compress((Bitmap.CompressFormat)localObject3, 80, localByteArrayOutputStream)) {
              break label195;
            }
            paramString = localByteArrayOutputStream.toByteArray();
            ((Bitmap)localObject1).recycle();
            return new ByteArrayInputStream(paramString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.w("ImageUtil", "getLocalImageStream: failed to rotate bitmap");
            localObject2 = localObject3;
            continue;
            localObject3 = Bitmap.CompressFormat.JPEG;
          }
          label195:
          ((Bitmap)localObject2).recycle();
        }
      }
      QMLog.e("ImageUtil", "getLocalImageStream: failed to compress bitmap");
    }
    if ((i == 1) && (k != 0))
    {
      for (;;)
      {
        try
        {
          localObject3 = a(k, BitmapFactory.decodeFile(paramString, null));
          localByteArrayOutputStream = new ByteArrayOutputStream();
          if (paramBoolean)
          {
            localObject2 = Bitmap.CompressFormat.PNG;
            if (!((Bitmap)localObject3).compress((Bitmap.CompressFormat)localObject2, 100, localByteArrayOutputStream)) {
              break;
            }
            paramString = localByteArrayOutputStream.toByteArray();
            ((Bitmap)localObject3).recycle();
            paramString = new ByteArrayInputStream(paramString);
            return paramString;
          }
        }
        catch (FileNotFoundException paramString)
        {
          QMLog.e("ImageUtil", "getLocalImageStream: failed to read file", paramString);
          return null;
        }
        localObject2 = Bitmap.CompressFormat.JPEG;
      }
      ((Bitmap)localObject3).recycle();
    }
    paramString = new BufferedInputStream(new FileInputStream(paramString));
    return paramString;
  }
  
  public static String a(Activity paramActivity, Bitmap paramBitmap)
  {
    int j;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getResources().getDisplayMetrics();
      j = paramActivity.widthPixels;
    }
    for (int i = (int)(paramActivity.widthPixels * 0.8D);; i = (int)(DeviceInfoUtil.getHeight() * 0.8D))
    {
      paramActivity = a(Bitmap.createBitmap(paramBitmap), j, i);
      paramBitmap = a(paramActivity, 1044480);
      File localFile = new File(bgnt.a().b("png"));
      boolean bool = a(paramBitmap, localFile);
      if ((paramActivity != null) && (!paramActivity.isRecycled())) {
        paramActivity.recycle();
      }
      if (!bool) {
        break;
      }
      return localFile.getAbsolutePath();
      j = (int)DeviceInfoUtil.getWidth();
    }
    return null;
  }
  
  public static String a(BitmapFactory.Options paramOptions)
  {
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null) {
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("jpeg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0) {
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0) {
      return "gif";
    }
    return "unknown";
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 22	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 398	com/tencent/qqmini/sdk/log/QMLog:isColorLevel	()Z
    //   16: ifeq +44 -> 60
    //   19: ldc 133
    //   21: new 135	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 400
    //   31: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 59	android/graphics/Bitmap:getWidth	()I
    //   38: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 405
    //   44: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: invokevirtual 62	android/graphics/Bitmap:getHeight	()I
    //   51: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 408	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_2
    //   61: invokestatic 410	bgpe:a	(Ljava/lang/String;)Ljava/io/File;
    //   64: astore_1
    //   65: new 412	java/io/FileOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_1
    //   74: aload_0
    //   75: getstatic 221	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   78: bipush 100
    //   80: iload_3
    //   81: invokestatic 415	java/lang/Math:min	(II)I
    //   84: aload_1
    //   85: invokevirtual 120	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   88: pop
    //   89: aload_2
    //   90: astore_0
    //   91: aload_1
    //   92: ifnull +9 -> 101
    //   95: aload_1
    //   96: invokevirtual 418	java/io/OutputStream:close	()V
    //   99: aload_2
    //   100: astore_0
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +49 -> 156
    //   110: aload_1
    //   111: invokevirtual 418	java/io/OutputStream:close	()V
    //   114: aconst_null
    //   115: astore_0
    //   116: goto -15 -> 101
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_0
    //   122: goto -21 -> 101
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 418	java/io/OutputStream:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: astore_0
    //   139: aload_2
    //   140: astore_0
    //   141: goto -40 -> 101
    //   144: astore_1
    //   145: goto -9 -> 136
    //   148: astore_0
    //   149: goto -21 -> 128
    //   152: astore_0
    //   153: goto -47 -> 106
    //   156: aconst_null
    //   157: astore_0
    //   158: goto -57 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramInputStream	InputStream
    //   0	161	1	paramOptions	BitmapFactory.Options
    //   0	161	2	paramString	String
    //   0	161	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   65	74	103	java/lang/Exception
    //   110	114	119	java/io/IOException
    //   65	74	125	finally
    //   95	99	138	java/io/IOException
    //   132	136	144	java/io/IOException
    //   74	89	148	finally
    //   74	89	152	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 249	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_2
    //   14: iload_3
    //   15: invokestatic 423	bgpe:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   18: astore 6
    //   20: new 193	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload 6
    //   32: aload_1
    //   33: bipush 100
    //   35: iload 4
    //   37: invokestatic 415	java/lang/Math:min	(II)I
    //   40: invokestatic 425	bgpe:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload 5
    //   49: astore_1
    //   50: aload_0
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: invokevirtual 243	java/io/InputStream:close	()V
    //   58: aload 5
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull -9 -> 61
    //   73: aload_0
    //   74: invokevirtual 243	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload 5
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -28 -> 61
    //   92: aload_0
    //   93: invokevirtual 243	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 243	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: goto -7 -> 112
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: astore_1
    //   131: goto -65 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   0	134	2	paramInt1	int
    //   0	134	3	paramInt2	int
    //   0	134	4	paramInt3	int
    //   1	115	5	str	String
    //   18	13	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   3	29	63	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   3	29	82	java/lang/Error
    //   92	96	98	java/io/IOException
    //   3	29	101	finally
    //   54	58	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   29	44	122	finally
    //   29	44	126	java/lang/Error
    //   29	44	130	java/lang/Exception
  }
  
  /* Error */
  public static void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 249	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 429	java/io/File:getParent	()Ljava/lang/String;
    //   17: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 254	java/io/File:exists	()Z
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokevirtual 432	java/io/File:isDirectory	()Z
    //   32: ifne +8 -> 40
    //   35: aload_2
    //   36: invokevirtual 285	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 254	java/io/File:exists	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_1
    //   48: invokevirtual 435	java/io/File:isFile	()Z
    //   51: ifne +8 -> 59
    //   54: aload_1
    //   55: invokevirtual 288	java/io/File:createNewFile	()Z
    //   58: pop
    //   59: aconst_null
    //   60: astore_2
    //   61: new 437	java/io/BufferedOutputStream
    //   64: dup
    //   65: new 412	java/io/FileOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: invokespecial 440	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore_1
    //   77: aload_0
    //   78: getstatic 105	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_1
    //   84: invokevirtual 120	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_1
    //   89: invokevirtual 443	java/io/BufferedOutputStream:flush	()V
    //   92: aload_1
    //   93: ifnull -85 -> 8
    //   96: aload_1
    //   97: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   100: return
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull -97 -> 8
    //   108: aload_1
    //   109: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   112: return
    //   113: astore_0
    //   114: aload_2
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 444	java/io/BufferedOutputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_0
    //   127: goto -11 -> 116
    //   130: astore_0
    //   131: goto -27 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramBitmap	Bitmap
    //   0	134	1	paramFile	File
    //   20	95	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   61	77	101	java/io/IOException
    //   61	77	113	finally
    //   77	92	126	finally
    //   77	92	130	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("jpg")) && (!paramString.endsWith("jpeg")) && (!paramString.endsWith("JPG")) && (!paramString.endsWith("JPEG"))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +13 -> 16
    //   6: aload_0
    //   7: arraylength
    //   8: iconst_1
    //   9: if_icmplt +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +7 -> 20
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_2
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 4
    //   26: aload 5
    //   28: astore_3
    //   29: new 249	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual 429	java/io/File:getParent	()Ljava/lang/String;
    //   37: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 6
    //   42: aload 5
    //   44: astore_3
    //   45: aload 6
    //   47: invokevirtual 254	java/io/File:exists	()Z
    //   50: ifeq +14 -> 64
    //   53: aload 5
    //   55: astore_3
    //   56: aload 6
    //   58: invokevirtual 432	java/io/File:isDirectory	()Z
    //   61: ifne +12 -> 73
    //   64: aload 5
    //   66: astore_3
    //   67: aload 6
    //   69: invokevirtual 285	java/io/File:mkdirs	()Z
    //   72: pop
    //   73: aload 5
    //   75: astore_3
    //   76: aload_1
    //   77: invokevirtual 254	java/io/File:exists	()Z
    //   80: ifeq +13 -> 93
    //   83: aload 5
    //   85: astore_3
    //   86: aload_1
    //   87: invokevirtual 435	java/io/File:isFile	()Z
    //   90: ifne +11 -> 101
    //   93: aload 5
    //   95: astore_3
    //   96: aload_1
    //   97: invokevirtual 288	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: aload 5
    //   103: astore_3
    //   104: new 412	java/io/FileOutputStream
    //   107: dup
    //   108: aload_1
    //   109: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: astore_1
    //   113: aload_1
    //   114: aload_0
    //   115: invokevirtual 458	java/io/FileOutputStream:write	([B)V
    //   118: aload_1
    //   119: invokevirtual 459	java/io/FileOutputStream:flush	()V
    //   122: aload_1
    //   123: ifnull -105 -> 18
    //   126: aload_1
    //   127: invokevirtual 460	java/io/FileOutputStream:close	()V
    //   130: iconst_1
    //   131: ireturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_1
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: astore_3
    //   145: aload_1
    //   146: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 460	java/io/FileOutputStream:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   164: goto -7 -> 157
    //   167: astore_0
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 460	java/io/FileOutputStream:close	()V
    //   176: aload_0
    //   177: athrow
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: astore_0
    //   187: aload_1
    //   188: astore_3
    //   189: goto -21 -> 168
    //   192: astore_3
    //   193: aload_1
    //   194: astore_0
    //   195: aload_3
    //   196: astore_1
    //   197: goto -54 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramArrayOfByte	byte[]
    //   0	200	1	paramFile	File
    //   1	18	2	bool	boolean
    //   28	161	3	localObject1	Object
    //   192	4	3	localIOException	IOException
    //   24	117	4	localObject2	Object
    //   21	81	5	localObject3	Object
    //   40	28	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   126	130	132	java/lang/Exception
    //   29	42	139	java/io/IOException
    //   45	53	139	java/io/IOException
    //   56	64	139	java/io/IOException
    //   67	73	139	java/io/IOException
    //   76	83	139	java/io/IOException
    //   86	93	139	java/io/IOException
    //   96	101	139	java/io/IOException
    //   104	113	139	java/io/IOException
    //   153	157	159	java/lang/Exception
    //   29	42	167	finally
    //   45	53	167	finally
    //   56	64	167	finally
    //   67	73	167	finally
    //   76	83	167	finally
    //   86	93	167	finally
    //   96	101	167	finally
    //   104	113	167	finally
    //   145	149	167	finally
    //   172	176	178	java/lang/Exception
    //   113	122	186	finally
    //   113	122	192	java/io/IOException
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    return a(paramBitmap, paramInt, true);
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBitmap == null) || (paramInt < 1)) {
      localObject = null;
    }
    byte[] arrayOfByte;
    do
    {
      return localObject;
      int i = 100;
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      for (arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray(); (i > 70) && (arrayOfByte.length / 1024 > paramInt); arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray())
      {
        ((ByteArrayOutputStream)localObject).reset();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, i, (OutputStream)localObject);
        i -= 5;
      }
      localObject = arrayOfByte;
    } while (!paramBoolean);
    paramBitmap.recycle();
    return arrayOfByte;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("png")) && (!paramString.endsWith("PNG"))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("webp")) && (!paramString.endsWith("WEBP"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpe
 * JD-Core Version:    0.7.0.1
 */