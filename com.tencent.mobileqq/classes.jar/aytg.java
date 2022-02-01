import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class aytg
{
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    File localFile1 = new File(AppConstants.SDCARD_PATH, "ocr");
    jdField_a_of_type_JavaLangString = localFile1.getAbsolutePath();
    if ((!localFile1.exists()) && (!localFile1.mkdir()))
    {
      jdField_a_of_type_Boolean = false;
      QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
    }
    if (localFile1.exists())
    {
      File localFile2 = new File(jdField_a_of_type_JavaLangString, "preview");
      b = localFile2.getAbsolutePath();
      if ((!localFile2.exists()) && (!localFile2.mkdir())) {
        QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
      }
    }
    if (localFile1.exists())
    {
      localFile1 = new File(jdField_a_of_type_JavaLangString, "cache");
      c = localFile1.getAbsolutePath();
      if ((!localFile1.exists()) && (!localFile1.mkdir())) {
        QLog.d("Q.ocr.image", 1, "mkdir cache dir failed!");
      }
    }
  }
  
  public static float a(int paramInt1, int paramInt2, String paramString, Paint paramPaint)
  {
    float f2 = paramPaint.getTextSize();
    float f3 = paramPaint.measureText(paramString);
    if (f3 > paramInt1) {
      for (;;)
      {
        f1 = f2;
        if (f3 <= paramInt1) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
    }
    float f1 = f2;
    if (f3 < paramInt1 * 0.97F)
    {
      while (f3 < paramInt1 * 0.97F)
      {
        f2 += 1.0F;
        paramPaint.setTextSize(f2);
        f3 = paramPaint.measureText(paramString);
      }
      f1 = f2;
      if (f3 > paramInt1) {
        f1 = f2 - 1.0F;
      }
    }
    paramString = paramPaint.getFontMetrics();
    f2 = paramString.descent;
    f3 = paramString.ascent;
    f3 = f2 - f3;
    f2 = f1;
    for (f1 = f3; f1 > paramInt2; f1 = paramString.descent - paramString.ascent)
    {
      f2 -= 1.0F;
      paramPaint.setTextSize(f2);
      paramString = paramPaint.getFontMetrics();
    }
    return f2;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize += 1;
    }
    return localObject;
    return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    double d2 = paramPoint2.x - paramPoint1.x;
    double d1 = paramPoint3.x - paramPoint4.x;
    double d3 = paramPoint2.y - paramPoint1.y;
    double d7 = paramPoint3.y - paramPoint4.y;
    double d4 = paramPoint3.x - paramPoint1.x;
    double d5 = paramPoint3.y - paramPoint1.y;
    double d6 = d2 * d7 - d1 * d3;
    if (Math.abs(d6) < 0.001D) {
      return null;
    }
    d1 = (d7 * d4 - d1 * d5) / d6;
    d2 = (d2 * d5 + -d3 * d4) / d6;
    d2 = paramPoint1.x;
    d2 = (paramPoint2.x - paramPoint1.x) * d1 + d2;
    d3 = paramPoint1.y;
    d1 = d1 * (paramPoint2.y - paramPoint1.y) + d3;
    if ((Math.abs(d2 - paramPoint4.x) < 5.0D) && (Math.abs(d1 - paramPoint4.y) < 5.0D)) {
      return new Point(paramPoint4);
    }
    return new Point((int)d2, (int)d1);
  }
  
  private static String a()
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyyMMddHHmmss");
      Date localDate = new Date(System.currentTimeMillis());
      localObject = ((SimpleDateFormat)localObject).format(localDate) + ".jpg";
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str3 = new File(paramString).getName();
      int i = str3.lastIndexOf('.');
      str1 = str3;
      if (i > -1)
      {
        str1 = str3;
        if (i < str3.length()) {
          str1 = str3.substring(0, i);
        }
      }
      str1 = str1 + "_" + System.currentTimeMillis() + ".tmp";
      str1 = new File(c, str1).getAbsolutePath();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        localException.printStackTrace();
        String str2 = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, String.format("getCachePath oldPath: %s, newPath: %s", new Object[] { paramString, str1 }));
    }
    return str1;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      File localFile = new File(b);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr dir failed!");
      }
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr preview dir failed!");
      }
      if (paramBoolean) {}
      for (localObject = b;; localObject = jdField_a_of_type_JavaLangString) {
        return new File((String)localObject, paramString).getAbsolutePath();
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(List<avav> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      avav localavav = (avav)paramList.next();
      if ((localavav != null) && (localavav.jdField_a_of_type_JavaLangString != null)) {
        localStringBuilder.append(localavav.jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString().replace(" ", "");
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +76 -> 82
    //   9: aload_0
    //   10: ifnull +78 -> 88
    //   13: aload_0
    //   14: arraylength
    //   15: i2l
    //   16: lstore 5
    //   18: ldc 41
    //   20: iconst_2
    //   21: new 155	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   28: ldc 246
    //   30: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload 5
    //   35: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 248
    //   40: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 253
    //   49: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc 255
    //   58: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_3
    //   62: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 257
    //   68: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload 4
    //   73: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: ifnonnull +11 -> 94
    //   86: aconst_null
    //   87: areturn
    //   88: lconst_0
    //   89: lstore 5
    //   91: goto -73 -> 18
    //   94: invokestatic 259	aytg:a	()Ljava/lang/String;
    //   97: iconst_1
    //   98: invokestatic 261	aytg:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   101: astore 9
    //   103: iload_2
    //   104: ifle +19 -> 123
    //   107: iload_1
    //   108: ifle +15 -> 123
    //   111: iload_3
    //   112: bipush 17
    //   114: if_icmpeq +20 -> 134
    //   117: iload_3
    //   118: bipush 20
    //   120: if_icmpeq +14 -> 134
    //   123: ldc 41
    //   125: iconst_1
    //   126: ldc_w 263
    //   129: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aconst_null
    //   133: areturn
    //   134: aload 9
    //   136: new 265	android/graphics/YuvImage
    //   139: dup
    //   140: aload_0
    //   141: iload_3
    //   142: iload_1
    //   143: iload_2
    //   144: aconst_null
    //   145: invokespecial 268	android/graphics/YuvImage:<init>	([BIII[I)V
    //   148: bipush 100
    //   150: invokestatic 271	aytg:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   153: ifne +14 -> 167
    //   156: ldc 41
    //   158: iconst_1
    //   159: ldc_w 273
    //   162: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload 9
    //   169: invokestatic 276	aytg:a	(Ljava/lang/String;)[B
    //   172: astore_0
    //   173: aload_0
    //   174: ifnonnull +15 -> 189
    //   177: ldc 41
    //   179: iconst_1
    //   180: ldc_w 278
    //   183: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload 9
    //   188: areturn
    //   189: aload_0
    //   190: new 280	android/graphics/Rect
    //   193: dup
    //   194: iconst_0
    //   195: iconst_0
    //   196: getstatic 285	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   199: getstatic 288	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   202: invokespecial 291	android/graphics/Rect:<init>	(IIII)V
    //   205: iconst_0
    //   206: iconst_0
    //   207: invokestatic 296	aqmy:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   210: astore 8
    //   212: aload 8
    //   214: ifnonnull +44 -> 258
    //   217: ldc 41
    //   219: iconst_1
    //   220: ldc_w 298
    //   223: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: new 15	java/io/File
    //   229: dup
    //   230: aload 9
    //   232: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: invokevirtual 36	java/io/File:exists	()Z
    //   238: ifeq +17 -> 255
    //   241: iconst_0
    //   242: ifeq +13 -> 255
    //   245: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   248: aload 9
    //   250: aconst_null
    //   251: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: aload 9
    //   257: areturn
    //   258: aload 8
    //   260: iload 4
    //   262: iconst_1
    //   263: invokestatic 313	aqmy:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   266: astore_0
    //   267: aload_0
    //   268: astore 7
    //   270: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +33 -> 306
    //   276: aload_0
    //   277: astore 7
    //   279: ldc 41
    //   281: iconst_2
    //   282: new 155	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 315
    //   292: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 4
    //   297: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_0
    //   307: ifnonnull +82 -> 389
    //   310: aload_0
    //   311: astore 7
    //   313: aload 8
    //   315: bipush 100
    //   317: new 15	java/io/File
    //   320: dup
    //   321: aload 9
    //   323: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: invokestatic 320	bheg:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   329: pop
    //   330: aload_0
    //   331: astore 7
    //   333: ldc 41
    //   335: iconst_1
    //   336: ldc_w 322
    //   339: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: new 15	java/io/File
    //   345: dup
    //   346: aload 9
    //   348: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   351: invokevirtual 36	java/io/File:exists	()Z
    //   354: ifeq +17 -> 371
    //   357: aload_0
    //   358: ifnull +13 -> 371
    //   361: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   364: aload 9
    //   366: aload_0
    //   367: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   370: pop
    //   371: new 15	java/io/File
    //   374: dup
    //   375: aload 9
    //   377: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: invokevirtual 36	java/io/File:exists	()Z
    //   383: ifeq -297 -> 86
    //   386: aload 9
    //   388: areturn
    //   389: aload_0
    //   390: astore 7
    //   392: aload_0
    //   393: bipush 100
    //   395: new 15	java/io/File
    //   398: dup
    //   399: aload 9
    //   401: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   404: invokestatic 320	bheg:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   407: pop
    //   408: goto -66 -> 342
    //   411: astore 7
    //   413: aload_0
    //   414: astore 7
    //   416: ldc 41
    //   418: iconst_1
    //   419: ldc_w 324
    //   422: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload_0
    //   426: astore 7
    //   428: aload_0
    //   429: invokestatic 330	aqmy:a	(Landroid/graphics/Bitmap;)Z
    //   432: pop
    //   433: new 15	java/io/File
    //   436: dup
    //   437: aload 9
    //   439: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: invokevirtual 36	java/io/File:exists	()Z
    //   445: ifeq -74 -> 371
    //   448: aload_0
    //   449: ifnull -78 -> 371
    //   452: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   455: aload 9
    //   457: aload_0
    //   458: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: goto -91 -> 371
    //   465: astore 7
    //   467: aconst_null
    //   468: astore_0
    //   469: aload 7
    //   471: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   474: aload_0
    //   475: invokestatic 330	aqmy:a	(Landroid/graphics/Bitmap;)Z
    //   478: pop
    //   479: new 15	java/io/File
    //   482: dup
    //   483: aload 9
    //   485: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   488: invokevirtual 36	java/io/File:exists	()Z
    //   491: ifeq -120 -> 371
    //   494: aload_0
    //   495: ifnull -124 -> 371
    //   498: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   501: aload 9
    //   503: aload_0
    //   504: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: goto -137 -> 371
    //   511: astore_0
    //   512: new 15	java/io/File
    //   515: dup
    //   516: aload 9
    //   518: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   521: invokevirtual 36	java/io/File:exists	()Z
    //   524: ifeq +19 -> 543
    //   527: aload 7
    //   529: ifnull +14 -> 543
    //   532: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   535: aload 9
    //   537: aload 7
    //   539: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: pop
    //   543: aload_0
    //   544: athrow
    //   545: astore_0
    //   546: goto -34 -> 512
    //   549: astore 8
    //   551: aload_0
    //   552: astore 7
    //   554: aload 8
    //   556: astore_0
    //   557: goto -45 -> 512
    //   560: astore 7
    //   562: goto -93 -> 469
    //   565: astore_0
    //   566: aconst_null
    //   567: astore_0
    //   568: goto -155 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	paramArrayOfByte	byte[]
    //   0	571	1	paramInt1	int
    //   0	571	2	paramInt2	int
    //   0	571	3	paramInt3	int
    //   0	571	4	paramInt4	int
    //   16	74	5	l	long
    //   1	390	7	arrayOfByte1	byte[]
    //   411	1	7	localOutOfMemoryError	OutOfMemoryError
    //   414	13	7	arrayOfByte2	byte[]
    //   465	73	7	localIOException1	java.io.IOException
    //   552	1	7	arrayOfByte3	byte[]
    //   560	1	7	localIOException2	java.io.IOException
    //   210	104	8	localBitmap	Bitmap
    //   549	6	8	localObject	Object
    //   101	435	9	str	String
    // Exception table:
    //   from	to	target	type
    //   270	276	411	java/lang/OutOfMemoryError
    //   279	306	411	java/lang/OutOfMemoryError
    //   313	330	411	java/lang/OutOfMemoryError
    //   333	342	411	java/lang/OutOfMemoryError
    //   392	408	411	java/lang/OutOfMemoryError
    //   189	212	465	java/io/IOException
    //   217	226	465	java/io/IOException
    //   258	267	465	java/io/IOException
    //   189	212	511	finally
    //   217	226	511	finally
    //   258	267	511	finally
    //   270	276	545	finally
    //   279	306	545	finally
    //   313	330	545	finally
    //   333	342	545	finally
    //   392	408	545	finally
    //   416	425	545	finally
    //   428	433	545	finally
    //   469	479	549	finally
    //   270	276	560	java/io/IOException
    //   279	306	560	java/io/IOException
    //   313	330	560	java/io/IOException
    //   333	342	560	java/io/IOException
    //   392	408	560	java/io/IOException
    //   189	212	565	java/lang/OutOfMemoryError
    //   217	226	565	java/lang/OutOfMemoryError
    //   258	267	565	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +87 -> 90
    //   6: aload_0
    //   7: ifnull +89 -> 96
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 41
    //   17: iconst_2
    //   18: new 155	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   25: ldc 246
    //   27: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 248
    //   37: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 253
    //   46: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 255
    //   55: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 339
    //   65: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 5
    //   70: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 341
    //   76: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: ifnonnull +11 -> 102
    //   94: aconst_null
    //   95: areturn
    //   96: lconst_0
    //   97: lstore 9
    //   99: goto -84 -> 15
    //   102: invokestatic 259	aytg:a	()Ljava/lang/String;
    //   105: iconst_1
    //   106: invokestatic 261	aytg:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   109: astore 13
    //   111: iload 7
    //   113: ifeq +23 -> 136
    //   116: aload_0
    //   117: astore 11
    //   119: aload 11
    //   121: ifnonnull +89 -> 210
    //   124: ldc 41
    //   126: iconst_1
    //   127: ldc_w 278
    //   130: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 13
    //   135: areturn
    //   136: iload_2
    //   137: ifle +19 -> 156
    //   140: iload_1
    //   141: ifle +15 -> 156
    //   144: iload_3
    //   145: bipush 17
    //   147: if_icmpeq +20 -> 167
    //   150: iload_3
    //   151: bipush 20
    //   153: if_icmpeq +14 -> 167
    //   156: ldc 41
    //   158: iconst_1
    //   159: ldc_w 263
    //   162: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload 13
    //   169: new 265	android/graphics/YuvImage
    //   172: dup
    //   173: aload_0
    //   174: iload_3
    //   175: iload_1
    //   176: iload_2
    //   177: aconst_null
    //   178: invokespecial 268	android/graphics/YuvImage:<init>	([BIII[I)V
    //   181: bipush 100
    //   183: invokestatic 271	aytg:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   186: ifne +14 -> 200
    //   189: ldc 41
    //   191: iconst_1
    //   192: ldc_w 273
    //   195: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aconst_null
    //   199: areturn
    //   200: aload 13
    //   202: invokestatic 276	aytg:a	(Ljava/lang/String;)[B
    //   205: astore 11
    //   207: goto -88 -> 119
    //   210: aconst_null
    //   211: astore 12
    //   213: aload 12
    //   215: astore_0
    //   216: aload 11
    //   218: new 280	android/graphics/Rect
    //   221: dup
    //   222: iconst_0
    //   223: iconst_0
    //   224: getstatic 285	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   227: getstatic 288	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   230: invokespecial 291	android/graphics/Rect:<init>	(IIII)V
    //   233: iconst_0
    //   234: iconst_0
    //   235: invokestatic 296	aqmy:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   238: astore 14
    //   240: aload 14
    //   242: ifnonnull +47 -> 289
    //   245: aload 12
    //   247: astore_0
    //   248: ldc 41
    //   250: iconst_1
    //   251: ldc_w 298
    //   254: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: new 15	java/io/File
    //   260: dup
    //   261: aload 13
    //   263: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: invokevirtual 36	java/io/File:exists	()Z
    //   269: ifeq +17 -> 286
    //   272: iconst_0
    //   273: ifeq +13 -> 286
    //   276: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   279: aload 13
    //   281: aconst_null
    //   282: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload 13
    //   288: areturn
    //   289: aload 12
    //   291: astore_0
    //   292: invokestatic 349	aqmc:a	()Laqmc;
    //   295: iload 4
    //   297: iload 5
    //   299: invokestatic 352	aqmy:a	(Laqmc;II)I
    //   302: istore_3
    //   303: aload 12
    //   305: astore_0
    //   306: aload 14
    //   308: iload_3
    //   309: iconst_1
    //   310: invokestatic 313	aqmy:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   313: astore 11
    //   315: aload 11
    //   317: astore_0
    //   318: aload_0
    //   319: astore 11
    //   321: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +32 -> 356
    //   327: aload_0
    //   328: astore 11
    //   330: ldc 41
    //   332: iconst_2
    //   333: new 155	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 315
    //   343: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_3
    //   347: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload 6
    //   358: ifnull +394 -> 752
    //   361: aload_0
    //   362: ifnull +390 -> 752
    //   365: iload_1
    //   366: istore 4
    //   368: iload_2
    //   369: istore_3
    //   370: iload_1
    //   371: iload_2
    //   372: if_icmple +27 -> 399
    //   375: iload_1
    //   376: istore 4
    //   378: iload_2
    //   379: istore_3
    //   380: aload_0
    //   381: astore 11
    //   383: aload_0
    //   384: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   387: aload_0
    //   388: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   391: if_icmpge +8 -> 399
    //   394: iload_1
    //   395: istore_3
    //   396: iload_2
    //   397: istore 4
    //   399: aload_0
    //   400: astore 11
    //   402: aload 6
    //   404: getfield 365	android/graphics/RectF:left	F
    //   407: iload 4
    //   409: i2f
    //   410: fmul
    //   411: ldc_w 366
    //   414: fadd
    //   415: iload 4
    //   417: aload_0
    //   418: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   421: isub
    //   422: iconst_2
    //   423: idiv
    //   424: i2f
    //   425: fsub
    //   426: f2i
    //   427: istore_1
    //   428: aload_0
    //   429: astore 11
    //   431: aload 6
    //   433: getfield 369	android/graphics/RectF:top	F
    //   436: iload_3
    //   437: i2f
    //   438: fmul
    //   439: ldc_w 366
    //   442: fadd
    //   443: iload_3
    //   444: aload_0
    //   445: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   448: isub
    //   449: iconst_2
    //   450: idiv
    //   451: i2f
    //   452: fsub
    //   453: f2i
    //   454: istore 5
    //   456: iload_1
    //   457: ifgt +211 -> 668
    //   460: aload_0
    //   461: astore 11
    //   463: aload_0
    //   464: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   467: istore_2
    //   468: iconst_0
    //   469: istore_1
    //   470: iload 5
    //   472: ifgt +217 -> 689
    //   475: iconst_0
    //   476: istore_3
    //   477: aload_0
    //   478: astore 11
    //   480: aload_0
    //   481: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   484: istore 4
    //   486: aload_0
    //   487: astore 11
    //   489: aload_0
    //   490: iload_1
    //   491: iload_3
    //   492: iload_2
    //   493: iload 4
    //   495: invokestatic 373	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   498: astore 12
    //   500: aload 12
    //   502: astore 6
    //   504: aload_0
    //   505: astore 11
    //   507: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +64 -> 574
    //   513: aload_0
    //   514: astore 11
    //   516: ldc 41
    //   518: iconst_2
    //   519: iconst_3
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: new 155	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 375
    //   535: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 12
    //   540: invokevirtual 357	android/graphics/Bitmap:getWidth	()I
    //   543: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: ldc_w 377
    //   555: aastore
    //   556: dup
    //   557: iconst_2
    //   558: aload 12
    //   560: invokevirtual 360	android/graphics/Bitmap:getHeight	()I
    //   563: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: aastore
    //   567: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   570: aload 12
    //   572: astore 6
    //   574: aload 6
    //   576: ifnonnull +182 -> 758
    //   579: aload 6
    //   581: astore_0
    //   582: aload 6
    //   584: astore 11
    //   586: aload 14
    //   588: bipush 100
    //   590: new 15	java/io/File
    //   593: dup
    //   594: aload 13
    //   596: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   599: invokestatic 320	bheg:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   602: pop
    //   603: aload 6
    //   605: astore_0
    //   606: aload 6
    //   608: astore 11
    //   610: ldc 41
    //   612: iconst_1
    //   613: ldc_w 322
    //   616: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: new 15	java/io/File
    //   622: dup
    //   623: aload 13
    //   625: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   628: invokevirtual 36	java/io/File:exists	()Z
    //   631: ifeq +19 -> 650
    //   634: aload 6
    //   636: ifnull +14 -> 650
    //   639: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   642: aload 13
    //   644: aload 6
    //   646: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   649: pop
    //   650: new 15	java/io/File
    //   653: dup
    //   654: aload 13
    //   656: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   659: invokevirtual 36	java/io/File:exists	()Z
    //   662: ifeq +266 -> 928
    //   665: aload 13
    //   667: areturn
    //   668: aload_0
    //   669: astore 11
    //   671: aload 6
    //   673: invokevirtual 389	android/graphics/RectF:width	()F
    //   676: iload 4
    //   678: i2f
    //   679: fmul
    //   680: ldc_w 366
    //   683: fadd
    //   684: f2i
    //   685: istore_2
    //   686: goto -216 -> 470
    //   689: aload_0
    //   690: astore 11
    //   692: aload 6
    //   694: invokevirtual 392	android/graphics/RectF:height	()F
    //   697: fstore 8
    //   699: fload 8
    //   701: iload_3
    //   702: i2f
    //   703: fmul
    //   704: ldc_w 366
    //   707: fadd
    //   708: f2i
    //   709: istore 4
    //   711: iload 5
    //   713: istore_3
    //   714: goto -228 -> 486
    //   717: astore 6
    //   719: aload_0
    //   720: astore 11
    //   722: ldc 41
    //   724: iconst_1
    //   725: new 155	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   732: ldc_w 394
    //   735: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 6
    //   740: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   743: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload_0
    //   753: astore 6
    //   755: goto -181 -> 574
    //   758: aload 6
    //   760: astore_0
    //   761: aload 6
    //   763: astore 11
    //   765: aload 6
    //   767: bipush 100
    //   769: new 15	java/io/File
    //   772: dup
    //   773: aload 13
    //   775: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   778: invokestatic 320	bheg:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   781: pop
    //   782: goto -163 -> 619
    //   785: astore 6
    //   787: aload_0
    //   788: astore 11
    //   790: ldc 41
    //   792: iconst_1
    //   793: ldc_w 324
    //   796: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   799: aload_0
    //   800: astore 11
    //   802: aload_0
    //   803: invokestatic 330	aqmy:a	(Landroid/graphics/Bitmap;)Z
    //   806: pop
    //   807: new 15	java/io/File
    //   810: dup
    //   811: aload 13
    //   813: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   816: invokevirtual 36	java/io/File:exists	()Z
    //   819: ifeq -169 -> 650
    //   822: aload_0
    //   823: ifnull -173 -> 650
    //   826: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   829: aload 13
    //   831: aload_0
    //   832: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   835: pop
    //   836: goto -186 -> 650
    //   839: astore 6
    //   841: aconst_null
    //   842: astore_0
    //   843: aload_0
    //   844: astore 11
    //   846: aload 6
    //   848: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   851: aload_0
    //   852: astore 11
    //   854: aload_0
    //   855: invokestatic 330	aqmy:a	(Landroid/graphics/Bitmap;)Z
    //   858: pop
    //   859: new 15	java/io/File
    //   862: dup
    //   863: aload 13
    //   865: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   868: invokevirtual 36	java/io/File:exists	()Z
    //   871: ifeq -221 -> 650
    //   874: aload_0
    //   875: ifnull -225 -> 650
    //   878: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   881: aload 13
    //   883: aload_0
    //   884: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   887: pop
    //   888: goto -238 -> 650
    //   891: astore_0
    //   892: aconst_null
    //   893: astore 11
    //   895: new 15	java/io/File
    //   898: dup
    //   899: aload 13
    //   901: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   904: invokevirtual 36	java/io/File:exists	()Z
    //   907: ifeq +19 -> 926
    //   910: aload 11
    //   912: ifnull +14 -> 926
    //   915: getstatic 304	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   918: aload 13
    //   920: aload 11
    //   922: invokevirtual 310	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   925: pop
    //   926: aload_0
    //   927: athrow
    //   928: aconst_null
    //   929: areturn
    //   930: astore_0
    //   931: goto -36 -> 895
    //   934: astore_0
    //   935: goto -40 -> 895
    //   938: astore 6
    //   940: goto -97 -> 843
    //   943: astore 11
    //   945: aload 6
    //   947: astore_0
    //   948: aload 11
    //   950: astore 6
    //   952: goto -109 -> 843
    //   955: astore 6
    //   957: goto -170 -> 787
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	960	0	paramArrayOfByte	byte[]
    //   0	960	1	paramInt1	int
    //   0	960	2	paramInt2	int
    //   0	960	3	paramInt3	int
    //   0	960	4	paramInt4	int
    //   0	960	5	paramInt5	int
    //   0	960	6	paramRectF	android.graphics.RectF
    //   0	960	7	paramBoolean	boolean
    //   697	3	8	f	float
    //   13	85	9	l	long
    //   117	804	11	localObject	Object
    //   943	6	11	localIOException	java.io.IOException
    //   211	360	12	localBitmap1	Bitmap
    //   109	810	13	str	String
    //   238	349	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   383	394	717	java/lang/Throwable
    //   402	428	717	java/lang/Throwable
    //   431	456	717	java/lang/Throwable
    //   463	468	717	java/lang/Throwable
    //   480	486	717	java/lang/Throwable
    //   489	500	717	java/lang/Throwable
    //   507	513	717	java/lang/Throwable
    //   516	570	717	java/lang/Throwable
    //   671	686	717	java/lang/Throwable
    //   692	699	717	java/lang/Throwable
    //   216	240	785	java/lang/OutOfMemoryError
    //   248	257	785	java/lang/OutOfMemoryError
    //   292	303	785	java/lang/OutOfMemoryError
    //   306	315	785	java/lang/OutOfMemoryError
    //   586	603	785	java/lang/OutOfMemoryError
    //   610	619	785	java/lang/OutOfMemoryError
    //   765	782	785	java/lang/OutOfMemoryError
    //   216	240	839	java/io/IOException
    //   248	257	839	java/io/IOException
    //   292	303	839	java/io/IOException
    //   306	315	839	java/io/IOException
    //   216	240	891	finally
    //   248	257	891	finally
    //   292	303	891	finally
    //   306	315	891	finally
    //   321	327	930	finally
    //   330	356	930	finally
    //   383	394	930	finally
    //   402	428	930	finally
    //   431	456	930	finally
    //   463	468	930	finally
    //   480	486	930	finally
    //   489	500	930	finally
    //   507	513	930	finally
    //   516	570	930	finally
    //   671	686	930	finally
    //   692	699	930	finally
    //   722	752	930	finally
    //   846	851	930	finally
    //   854	859	930	finally
    //   586	603	934	finally
    //   610	619	934	finally
    //   765	782	934	finally
    //   790	799	934	finally
    //   802	807	934	finally
    //   321	327	938	java/io/IOException
    //   330	356	938	java/io/IOException
    //   383	394	938	java/io/IOException
    //   402	428	938	java/io/IOException
    //   431	456	938	java/io/IOException
    //   463	468	938	java/io/IOException
    //   480	486	938	java/io/IOException
    //   489	500	938	java/io/IOException
    //   507	513	938	java/io/IOException
    //   516	570	938	java/io/IOException
    //   671	686	938	java/io/IOException
    //   692	699	938	java/io/IOException
    //   722	752	938	java/io/IOException
    //   586	603	943	java/io/IOException
    //   610	619	943	java/io/IOException
    //   765	782	943	java/io/IOException
    //   321	327	955	java/lang/OutOfMemoryError
    //   330	356	955	java/lang/OutOfMemoryError
    //   383	394	955	java/lang/OutOfMemoryError
    //   402	428	955	java/lang/OutOfMemoryError
    //   431	456	955	java/lang/OutOfMemoryError
    //   463	468	955	java/lang/OutOfMemoryError
    //   480	486	955	java/lang/OutOfMemoryError
    //   489	500	955	java/lang/OutOfMemoryError
    //   507	513	955	java/lang/OutOfMemoryError
    //   516	570	955	java/lang/OutOfMemoryError
    //   671	686	955	java/lang/OutOfMemoryError
    //   692	699	955	java/lang/OutOfMemoryError
    //   722	752	955	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 400	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 402	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 408	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 412	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 415	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 418	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +99 -> 190
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 15	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 36	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 15	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 423	java/io/File:length	()J
    //   122: ldc2_w 424
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 41
    //   130: iconst_2
    //   131: new 155	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 427
    //   141: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 255
    //   150: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc_w 429
    //   160: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 431
    //   170: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 6
    //   175: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 433
    //   181: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 4
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   198: iload 5
    //   200: istore 4
    //   202: goto -114 -> 88
    //   205: astore_0
    //   206: aconst_null
    //   207: astore 8
    //   209: iconst_0
    //   210: istore 5
    //   212: aload 8
    //   214: astore 9
    //   216: ldc 41
    //   218: iconst_1
    //   219: ldc_w 435
    //   222: aload_0
    //   223: invokestatic 438	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 8
    //   232: ifnull -144 -> 88
    //   235: aload 8
    //   237: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -156 -> 88
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   252: iload 5
    //   254: istore 4
    //   256: goto -168 -> 88
    //   259: astore_0
    //   260: iconst_0
    //   261: istore 5
    //   263: aload 10
    //   265: astore_0
    //   266: aload_0
    //   267: astore 9
    //   269: ldc 41
    //   271: iconst_1
    //   272: ldc_w 440
    //   275: invokestatic 327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload 5
    //   280: istore 4
    //   282: aload_0
    //   283: ifnull -195 -> 88
    //   286: aload_0
    //   287: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   290: iload 5
    //   292: istore 4
    //   294: goto -206 -> 88
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -218 -> 88
    //   309: astore_0
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 421	java/io/BufferedOutputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   327: goto -7 -> 320
    //   330: astore_0
    //   331: goto -21 -> 310
    //   334: astore_0
    //   335: aload 8
    //   337: astore_0
    //   338: iconst_0
    //   339: istore 5
    //   341: goto -75 -> 266
    //   344: astore_0
    //   345: aload 8
    //   347: astore_0
    //   348: goto -82 -> 266
    //   351: astore_0
    //   352: iconst_0
    //   353: istore 5
    //   355: goto -143 -> 212
    //   358: astore_0
    //   359: goto -147 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramBitmap	Bitmap
    //   0	362	1	paramString	String
    //   0	362	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	362	3	paramInt	int
    //   0	362	4	paramBoolean	boolean
    //   46	308	5	bool	boolean
    //   95	79	6	l	long
    //   8	338	8	localObject1	Object
    //   11	305	9	localObject2	Object
    //   14	250	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	84	193	java/io/IOException
    //   16	34	205	java/lang/Exception
    //   235	240	247	java/io/IOException
    //   16	34	259	java/lang/OutOfMemoryError
    //   286	290	297	java/io/IOException
    //   16	34	309	finally
    //   269	278	309	finally
    //   315	320	322	java/io/IOException
    //   38	48	330	finally
    //   52	57	330	finally
    //   66	70	330	finally
    //   216	226	330	finally
    //   38	48	334	java/lang/OutOfMemoryError
    //   52	57	344	java/lang/OutOfMemoryError
    //   66	70	344	java/lang/OutOfMemoryError
    //   38	48	351	java/lang/Exception
    //   52	57	358	java/lang/Exception
    //   66	70	358	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    paramString = PhotoUtils.getImageMimeType(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, "checkImageFormat format:" + paramString);
    }
    return (!TextUtils.isEmpty(paramString)) || ("image/bmp".equalsIgnoreCase(paramString)) || ("image/jpeg".equalsIgnoreCase(paramString)) || ("image/png".equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public static boolean a(String paramString, android.graphics.YuvImage paramYuvImage, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 402	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 280	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 465	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 466	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 291	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 470	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 471	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore 6
    //   135: aload 5
    //   137: astore_1
    //   138: goto -54 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramYuvImage	android.graphics.YuvImage
    //   0	141	2	paramInt	int
    //   1	71	3	bool1	boolean
    //   53	16	4	bool2	boolean
    //   10	126	5	localFileOutputStream	java.io.FileOutputStream
    //   80	7	6	localException1	Exception
    //   133	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   63	68	73	java/io/IOException
    //   2	12	80	java/lang/Exception
    //   95	99	101	java/io/IOException
    //   2	12	108	finally
    //   115	119	121	java/io/IOException
    //   19	44	129	finally
    //   47	52	129	finally
    //   86	91	129	finally
    //   19	44	133	java/lang/Exception
    //   47	52	133	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    int j = 10;
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("Q.ocr.image", 1, "compressImage, newImagePath is empty");
      return false;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
    int n = ((BitmapFactory.Options)localObject).outHeight;
    int m = ((BitmapFactory.Options)localObject).outWidth;
    int i;
    label91:
    int k;
    if (aytx.a() != null) {
      if (aytx.a().c < 400)
      {
        i = 400;
        if (aytx.a().b >= 10) {
          break label392;
        }
        k = i;
        i = j;
      }
    }
    for (;;)
    {
      float f;
      if ((m > n) && (n > k)) {
        f = k * 1.0F / n;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.image", 2, "compressImage radio:" + f + ",source file size:" + new File(paramString1).length() + ",shortSide:" + k + ",picQuality:" + i);
        }
        j = (int)(n * f);
        k = (int)(m * f);
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f, f);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = a(paramString1, (BitmapFactory.Options)localObject, 1, 2);
        if (localObject != null)
        {
          if (((Bitmap)localObject).getHeight() <= j)
          {
            paramString1 = (String)localObject;
            if (((Bitmap)localObject).getWidth() <= k) {
              break label309;
            }
          }
          try
          {
            paramString1 = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, false);
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
              paramString1 = (String)localObject;
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              label309:
              paramString1.printStackTrace();
              label392:
              paramString1 = (String)localObject;
            }
          }
          if (paramString1 != null)
          {
            j = paramString1.getRowBytes();
            k = paramString1.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("Q.ocr.image", 2, "compressImage target bmp size:" + j * k / 1024 + "KB");
            }
            return a(paramString1, paramString2, Bitmap.CompressFormat.JPEG, i, true);
            i = aytx.a().c;
            break;
            j = aytx.a().b;
            break label91;
            if ((m >= n) || (m <= k)) {
              break label454;
            }
            f = k * 1.0F / m;
            continue;
          }
        }
        return false;
        label454:
        f = 1.0F;
      }
      i = 70;
      k = 800;
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 423	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 536	java/io/BufferedInputStream
    //   20: dup
    //   21: new 538	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 539	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 542	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 546	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   54: aload_2
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +10 -> 67
    //   60: aload_0
    //   61: astore_1
    //   62: aload_0
    //   63: arraylength
    //   64: ifne +14 -> 78
    //   67: ldc 41
    //   69: iconst_1
    //   70: ldc_w 549
    //   73: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 550	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 547	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_1
    //   164: goto -15 -> 149
    //   167: astore_2
    //   168: goto -47 -> 121
    //   171: astore_2
    //   172: goto -79 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString	String
    //   32	96	1	localObject1	Object
    //   146	8	1	localObject2	Object
    //   163	1	1	localObject3	Object
    //   16	70	2	arrayOfByte	byte[]
    //   90	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   118	6	2	localIOException1	java.io.IOException
    //   167	1	2	localIOException2	java.io.IOException
    //   171	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   50	54	80	java/lang/Exception
    //   17	33	90	java/io/FileNotFoundException
    //   99	103	108	java/lang/Exception
    //   17	33	118	java/io/IOException
    //   127	131	136	java/lang/Exception
    //   17	33	146	finally
    //   149	153	155	java/lang/Exception
    //   35	44	163	finally
    //   46	50	163	finally
    //   95	99	163	finally
    //   123	127	163	finally
    //   35	44	167	java/io/IOException
    //   46	50	167	java/io/IOException
    //   35	44	171	java/io/FileNotFoundException
    //   46	50	171	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytg
 * JD-Core Version:    0.7.0.1
 */