import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ayzp
{
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    File localFile1 = new File(antf.ba, "ocr");
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
  
  public static float a(int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    float f2 = paramPaint.getTextSize();
    float f1 = paramPaint.measureText(paramString);
    paramInt1 = (int)(paramInt1 * 0.95D);
    paramInt2 = (int)(paramInt2 * 0.95D);
    if (f1 > paramInt1)
    {
      f2 -= 1.0F;
      for (f3 = f1;; f3 = paramPaint.measureText(paramString))
      {
        f1 = f2;
        if (f3 <= paramInt1) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
      }
    }
    f2 += 1.0F;
    for (float f3 = f1;; f3 = paramPaint.measureText(paramString))
    {
      f1 = f2;
      if (f3 >= paramInt1) {
        break;
      }
      f2 += 1.0F;
      paramPaint.setTextSize(f2);
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
    return f2 - 1.0F;
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
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +75 -> 81
    //   9: aload_0
    //   10: ifnull +77 -> 87
    //   13: aload_0
    //   14: arraylength
    //   15: i2l
    //   16: lstore 5
    //   18: ldc 41
    //   20: iconst_2
    //   21: new 131	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   28: ldc 195
    //   30: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload 5
    //   35: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 197
    //   40: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 202
    //   49: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc 204
    //   58: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_3
    //   62: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 206
    //   67: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 4
    //   72: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: ifnonnull +11 -> 93
    //   85: aconst_null
    //   86: areturn
    //   87: lconst_0
    //   88: lstore 5
    //   90: goto -72 -> 18
    //   93: invokestatic 208	ayzp:a	()Ljava/lang/String;
    //   96: iconst_1
    //   97: invokestatic 210	ayzp:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   100: astore 9
    //   102: iload_2
    //   103: ifle +19 -> 122
    //   106: iload_1
    //   107: ifle +15 -> 122
    //   110: iload_3
    //   111: bipush 17
    //   113: if_icmpeq +19 -> 132
    //   116: iload_3
    //   117: bipush 20
    //   119: if_icmpeq +13 -> 132
    //   122: ldc 41
    //   124: iconst_1
    //   125: ldc 212
    //   127: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: aload 9
    //   134: new 214	android/graphics/YuvImage
    //   137: dup
    //   138: aload_0
    //   139: iload_3
    //   140: iload_1
    //   141: iload_2
    //   142: aconst_null
    //   143: invokespecial 217	android/graphics/YuvImage:<init>	([BIII[I)V
    //   146: bipush 100
    //   148: invokestatic 220	ayzp:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   151: ifne +13 -> 164
    //   154: ldc 41
    //   156: iconst_1
    //   157: ldc 222
    //   159: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 9
    //   166: invokestatic 225	ayzp:a	(Ljava/lang/String;)[B
    //   169: astore_0
    //   170: aload_0
    //   171: ifnonnull +14 -> 185
    //   174: ldc 41
    //   176: iconst_1
    //   177: ldc 227
    //   179: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 9
    //   184: areturn
    //   185: aload_0
    //   186: new 229	android/graphics/Rect
    //   189: dup
    //   190: iconst_0
    //   191: iconst_0
    //   192: getstatic 233	bdep:a	I
    //   195: getstatic 235	bdep:b	I
    //   198: invokespecial 238	android/graphics/Rect:<init>	(IIII)V
    //   201: iconst_0
    //   202: iconst_0
    //   203: invokestatic 243	aqql:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   206: astore 8
    //   208: aload 8
    //   210: ifnonnull +43 -> 253
    //   213: ldc 41
    //   215: iconst_1
    //   216: ldc 245
    //   218: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: new 15	java/io/File
    //   224: dup
    //   225: aload 9
    //   227: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 36	java/io/File:exists	()Z
    //   233: ifeq +17 -> 250
    //   236: iconst_0
    //   237: ifeq +13 -> 250
    //   240: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: aload 9
    //   245: aconst_null
    //   246: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload 9
    //   252: areturn
    //   253: aload 8
    //   255: iload 4
    //   257: iconst_1
    //   258: invokestatic 260	aqql:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   261: astore_0
    //   262: aload_0
    //   263: astore 7
    //   265: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +33 -> 301
    //   271: aload_0
    //   272: astore 7
    //   274: ldc 41
    //   276: iconst_2
    //   277: new 131	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 262
    //   287: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload 4
    //   292: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_0
    //   302: ifnonnull +82 -> 384
    //   305: aload_0
    //   306: astore 7
    //   308: aload 8
    //   310: bipush 100
    //   312: new 15	java/io/File
    //   315: dup
    //   316: aload 9
    //   318: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: invokestatic 267	bhmq:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   324: pop
    //   325: aload_0
    //   326: astore 7
    //   328: ldc 41
    //   330: iconst_1
    //   331: ldc_w 269
    //   334: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: new 15	java/io/File
    //   340: dup
    //   341: aload 9
    //   343: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   346: invokevirtual 36	java/io/File:exists	()Z
    //   349: ifeq +17 -> 366
    //   352: aload_0
    //   353: ifnull +13 -> 366
    //   356: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   359: aload 9
    //   361: aload_0
    //   362: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: new 15	java/io/File
    //   369: dup
    //   370: aload 9
    //   372: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   375: invokevirtual 36	java/io/File:exists	()Z
    //   378: ifeq -293 -> 85
    //   381: aload 9
    //   383: areturn
    //   384: aload_0
    //   385: astore 7
    //   387: aload_0
    //   388: bipush 100
    //   390: new 15	java/io/File
    //   393: dup
    //   394: aload 9
    //   396: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   399: invokestatic 267	bhmq:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   402: pop
    //   403: goto -66 -> 337
    //   406: astore 7
    //   408: aload_0
    //   409: astore 7
    //   411: ldc 41
    //   413: iconst_1
    //   414: ldc_w 271
    //   417: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_0
    //   421: astore 7
    //   423: aload_0
    //   424: invokestatic 277	aqql:a	(Landroid/graphics/Bitmap;)Z
    //   427: pop
    //   428: new 15	java/io/File
    //   431: dup
    //   432: aload 9
    //   434: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   437: invokevirtual 36	java/io/File:exists	()Z
    //   440: ifeq -74 -> 366
    //   443: aload_0
    //   444: ifnull -78 -> 366
    //   447: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   450: aload 9
    //   452: aload_0
    //   453: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   456: pop
    //   457: goto -91 -> 366
    //   460: astore 7
    //   462: aconst_null
    //   463: astore_0
    //   464: aload 7
    //   466: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   469: aload_0
    //   470: invokestatic 277	aqql:a	(Landroid/graphics/Bitmap;)Z
    //   473: pop
    //   474: new 15	java/io/File
    //   477: dup
    //   478: aload 9
    //   480: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: invokevirtual 36	java/io/File:exists	()Z
    //   486: ifeq -120 -> 366
    //   489: aload_0
    //   490: ifnull -124 -> 366
    //   493: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   496: aload 9
    //   498: aload_0
    //   499: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: goto -137 -> 366
    //   506: astore_0
    //   507: new 15	java/io/File
    //   510: dup
    //   511: aload 9
    //   513: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: invokevirtual 36	java/io/File:exists	()Z
    //   519: ifeq +19 -> 538
    //   522: aload 7
    //   524: ifnull +14 -> 538
    //   527: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   530: aload 9
    //   532: aload 7
    //   534: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: aload_0
    //   539: athrow
    //   540: astore_0
    //   541: goto -34 -> 507
    //   544: astore 8
    //   546: aload_0
    //   547: astore 7
    //   549: aload 8
    //   551: astore_0
    //   552: goto -45 -> 507
    //   555: astore 7
    //   557: goto -93 -> 464
    //   560: astore_0
    //   561: aconst_null
    //   562: astore_0
    //   563: goto -155 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	paramArrayOfByte	byte[]
    //   0	566	1	paramInt1	int
    //   0	566	2	paramInt2	int
    //   0	566	3	paramInt3	int
    //   0	566	4	paramInt4	int
    //   16	73	5	l	long
    //   1	385	7	arrayOfByte1	byte[]
    //   406	1	7	localOutOfMemoryError	OutOfMemoryError
    //   409	13	7	arrayOfByte2	byte[]
    //   460	73	7	localIOException1	java.io.IOException
    //   547	1	7	arrayOfByte3	byte[]
    //   555	1	7	localIOException2	java.io.IOException
    //   206	103	8	localBitmap	Bitmap
    //   544	6	8	localObject	Object
    //   100	431	9	str	String
    // Exception table:
    //   from	to	target	type
    //   265	271	406	java/lang/OutOfMemoryError
    //   274	301	406	java/lang/OutOfMemoryError
    //   308	325	406	java/lang/OutOfMemoryError
    //   328	337	406	java/lang/OutOfMemoryError
    //   387	403	406	java/lang/OutOfMemoryError
    //   185	208	460	java/io/IOException
    //   213	221	460	java/io/IOException
    //   253	262	460	java/io/IOException
    //   185	208	506	finally
    //   213	221	506	finally
    //   253	262	506	finally
    //   265	271	540	finally
    //   274	301	540	finally
    //   308	325	540	finally
    //   328	337	540	finally
    //   387	403	540	finally
    //   411	420	540	finally
    //   423	428	540	finally
    //   464	474	544	finally
    //   265	271	555	java/io/IOException
    //   274	301	555	java/io/IOException
    //   308	325	555	java/io/IOException
    //   328	337	555	java/io/IOException
    //   387	403	555	java/io/IOException
    //   185	208	560	java/lang/OutOfMemoryError
    //   213	221	560	java/lang/OutOfMemoryError
    //   253	262	560	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +87 -> 90
    //   6: aload_0
    //   7: ifnull +89 -> 96
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 41
    //   17: iconst_2
    //   18: new 131	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   25: ldc 195
    //   27: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 197
    //   37: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 202
    //   46: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 204
    //   55: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 286
    //   65: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 5
    //   70: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 288
    //   76: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: ifnonnull +11 -> 102
    //   94: aconst_null
    //   95: areturn
    //   96: lconst_0
    //   97: lstore 9
    //   99: goto -84 -> 15
    //   102: invokestatic 208	ayzp:a	()Ljava/lang/String;
    //   105: iconst_1
    //   106: invokestatic 210	ayzp:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   109: astore 13
    //   111: iload 7
    //   113: ifeq +22 -> 135
    //   116: aload_0
    //   117: astore 11
    //   119: aload 11
    //   121: ifnonnull +86 -> 207
    //   124: ldc 41
    //   126: iconst_1
    //   127: ldc 227
    //   129: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 13
    //   134: areturn
    //   135: iload_2
    //   136: ifle +19 -> 155
    //   139: iload_1
    //   140: ifle +15 -> 155
    //   143: iload_3
    //   144: bipush 17
    //   146: if_icmpeq +19 -> 165
    //   149: iload_3
    //   150: bipush 20
    //   152: if_icmpeq +13 -> 165
    //   155: ldc 41
    //   157: iconst_1
    //   158: ldc 212
    //   160: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 13
    //   167: new 214	android/graphics/YuvImage
    //   170: dup
    //   171: aload_0
    //   172: iload_3
    //   173: iload_1
    //   174: iload_2
    //   175: aconst_null
    //   176: invokespecial 217	android/graphics/YuvImage:<init>	([BIII[I)V
    //   179: bipush 100
    //   181: invokestatic 220	ayzp:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   184: ifne +13 -> 197
    //   187: ldc 41
    //   189: iconst_1
    //   190: ldc 222
    //   192: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aconst_null
    //   196: areturn
    //   197: aload 13
    //   199: invokestatic 225	ayzp:a	(Ljava/lang/String;)[B
    //   202: astore 11
    //   204: goto -85 -> 119
    //   207: aconst_null
    //   208: astore 12
    //   210: aload 12
    //   212: astore_0
    //   213: aload 11
    //   215: new 229	android/graphics/Rect
    //   218: dup
    //   219: iconst_0
    //   220: iconst_0
    //   221: getstatic 233	bdep:a	I
    //   224: getstatic 235	bdep:b	I
    //   227: invokespecial 238	android/graphics/Rect:<init>	(IIII)V
    //   230: iconst_0
    //   231: iconst_0
    //   232: invokestatic 243	aqql:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   235: astore 14
    //   237: aload 14
    //   239: ifnonnull +46 -> 285
    //   242: aload 12
    //   244: astore_0
    //   245: ldc 41
    //   247: iconst_1
    //   248: ldc 245
    //   250: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: new 15	java/io/File
    //   256: dup
    //   257: aload 13
    //   259: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: invokevirtual 36	java/io/File:exists	()Z
    //   265: ifeq +17 -> 282
    //   268: iconst_0
    //   269: ifeq +13 -> 282
    //   272: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   275: aload 13
    //   277: aconst_null
    //   278: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload 13
    //   284: areturn
    //   285: aload 12
    //   287: astore_0
    //   288: invokestatic 296	aqpp:a	()Laqpp;
    //   291: iload 4
    //   293: iload 5
    //   295: invokestatic 299	aqql:a	(Laqpp;II)I
    //   298: istore_3
    //   299: aload 12
    //   301: astore_0
    //   302: aload 14
    //   304: iload_3
    //   305: iconst_1
    //   306: invokestatic 260	aqql:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   309: astore 11
    //   311: aload 11
    //   313: astore_0
    //   314: aload_0
    //   315: astore 11
    //   317: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +32 -> 352
    //   323: aload_0
    //   324: astore 11
    //   326: ldc 41
    //   328: iconst_2
    //   329: new 131	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 262
    //   339: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload_3
    //   343: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aload 6
    //   354: ifnull +394 -> 748
    //   357: aload_0
    //   358: ifnull +390 -> 748
    //   361: iload_1
    //   362: istore 4
    //   364: iload_2
    //   365: istore_3
    //   366: iload_1
    //   367: iload_2
    //   368: if_icmple +27 -> 395
    //   371: iload_1
    //   372: istore 4
    //   374: iload_2
    //   375: istore_3
    //   376: aload_0
    //   377: astore 11
    //   379: aload_0
    //   380: invokevirtual 304	android/graphics/Bitmap:getWidth	()I
    //   383: aload_0
    //   384: invokevirtual 307	android/graphics/Bitmap:getHeight	()I
    //   387: if_icmpge +8 -> 395
    //   390: iload_1
    //   391: istore_3
    //   392: iload_2
    //   393: istore 4
    //   395: aload_0
    //   396: astore 11
    //   398: aload 6
    //   400: getfield 312	android/graphics/RectF:left	F
    //   403: iload 4
    //   405: i2f
    //   406: fmul
    //   407: ldc_w 313
    //   410: fadd
    //   411: iload 4
    //   413: aload_0
    //   414: invokevirtual 304	android/graphics/Bitmap:getWidth	()I
    //   417: isub
    //   418: iconst_2
    //   419: idiv
    //   420: i2f
    //   421: fsub
    //   422: f2i
    //   423: istore_1
    //   424: aload_0
    //   425: astore 11
    //   427: aload 6
    //   429: getfield 316	android/graphics/RectF:top	F
    //   432: iload_3
    //   433: i2f
    //   434: fmul
    //   435: ldc_w 313
    //   438: fadd
    //   439: iload_3
    //   440: aload_0
    //   441: invokevirtual 307	android/graphics/Bitmap:getHeight	()I
    //   444: isub
    //   445: iconst_2
    //   446: idiv
    //   447: i2f
    //   448: fsub
    //   449: f2i
    //   450: istore 5
    //   452: iload_1
    //   453: ifgt +211 -> 664
    //   456: aload_0
    //   457: astore 11
    //   459: aload_0
    //   460: invokevirtual 304	android/graphics/Bitmap:getWidth	()I
    //   463: istore_2
    //   464: iconst_0
    //   465: istore_1
    //   466: iload 5
    //   468: ifgt +217 -> 685
    //   471: iconst_0
    //   472: istore_3
    //   473: aload_0
    //   474: astore 11
    //   476: aload_0
    //   477: invokevirtual 307	android/graphics/Bitmap:getHeight	()I
    //   480: istore 4
    //   482: aload_0
    //   483: astore 11
    //   485: aload_0
    //   486: iload_1
    //   487: iload_3
    //   488: iload_2
    //   489: iload 4
    //   491: invokestatic 320	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   494: astore 12
    //   496: aload 12
    //   498: astore 6
    //   500: aload_0
    //   501: astore 11
    //   503: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +64 -> 570
    //   509: aload_0
    //   510: astore 11
    //   512: ldc 41
    //   514: iconst_2
    //   515: iconst_3
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: new 131	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 322
    //   531: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 12
    //   536: invokevirtual 304	android/graphics/Bitmap:getWidth	()I
    //   539: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: ldc_w 324
    //   551: aastore
    //   552: dup
    //   553: iconst_2
    //   554: aload 12
    //   556: invokevirtual 307	android/graphics/Bitmap:getHeight	()I
    //   559: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: aastore
    //   563: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   566: aload 12
    //   568: astore 6
    //   570: aload 6
    //   572: ifnonnull +182 -> 754
    //   575: aload 6
    //   577: astore_0
    //   578: aload 6
    //   580: astore 11
    //   582: aload 14
    //   584: bipush 100
    //   586: new 15	java/io/File
    //   589: dup
    //   590: aload 13
    //   592: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   595: invokestatic 267	bhmq:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   598: pop
    //   599: aload 6
    //   601: astore_0
    //   602: aload 6
    //   604: astore 11
    //   606: ldc 41
    //   608: iconst_1
    //   609: ldc_w 269
    //   612: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: new 15	java/io/File
    //   618: dup
    //   619: aload 13
    //   621: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   624: invokevirtual 36	java/io/File:exists	()Z
    //   627: ifeq +19 -> 646
    //   630: aload 6
    //   632: ifnull +14 -> 646
    //   635: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   638: aload 13
    //   640: aload 6
    //   642: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   645: pop
    //   646: new 15	java/io/File
    //   649: dup
    //   650: aload 13
    //   652: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   655: invokevirtual 36	java/io/File:exists	()Z
    //   658: ifeq +266 -> 924
    //   661: aload 13
    //   663: areturn
    //   664: aload_0
    //   665: astore 11
    //   667: aload 6
    //   669: invokevirtual 336	android/graphics/RectF:width	()F
    //   672: iload 4
    //   674: i2f
    //   675: fmul
    //   676: ldc_w 313
    //   679: fadd
    //   680: f2i
    //   681: istore_2
    //   682: goto -216 -> 466
    //   685: aload_0
    //   686: astore 11
    //   688: aload 6
    //   690: invokevirtual 339	android/graphics/RectF:height	()F
    //   693: fstore 8
    //   695: fload 8
    //   697: iload_3
    //   698: i2f
    //   699: fmul
    //   700: ldc_w 313
    //   703: fadd
    //   704: f2i
    //   705: istore 4
    //   707: iload 5
    //   709: istore_3
    //   710: goto -228 -> 482
    //   713: astore 6
    //   715: aload_0
    //   716: astore 11
    //   718: ldc 41
    //   720: iconst_1
    //   721: new 131	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 341
    //   731: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload 6
    //   736: invokevirtual 344	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   739: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: aload_0
    //   749: astore 6
    //   751: goto -181 -> 570
    //   754: aload 6
    //   756: astore_0
    //   757: aload 6
    //   759: astore 11
    //   761: aload 6
    //   763: bipush 100
    //   765: new 15	java/io/File
    //   768: dup
    //   769: aload 13
    //   771: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   774: invokestatic 267	bhmq:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   777: pop
    //   778: goto -163 -> 615
    //   781: astore 6
    //   783: aload_0
    //   784: astore 11
    //   786: ldc 41
    //   788: iconst_1
    //   789: ldc_w 271
    //   792: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: aload_0
    //   796: astore 11
    //   798: aload_0
    //   799: invokestatic 277	aqql:a	(Landroid/graphics/Bitmap;)Z
    //   802: pop
    //   803: new 15	java/io/File
    //   806: dup
    //   807: aload 13
    //   809: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   812: invokevirtual 36	java/io/File:exists	()Z
    //   815: ifeq -169 -> 646
    //   818: aload_0
    //   819: ifnull -173 -> 646
    //   822: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   825: aload 13
    //   827: aload_0
    //   828: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   831: pop
    //   832: goto -186 -> 646
    //   835: astore 6
    //   837: aconst_null
    //   838: astore_0
    //   839: aload_0
    //   840: astore 11
    //   842: aload 6
    //   844: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   847: aload_0
    //   848: astore 11
    //   850: aload_0
    //   851: invokestatic 277	aqql:a	(Landroid/graphics/Bitmap;)Z
    //   854: pop
    //   855: new 15	java/io/File
    //   858: dup
    //   859: aload 13
    //   861: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   864: invokevirtual 36	java/io/File:exists	()Z
    //   867: ifeq -221 -> 646
    //   870: aload_0
    //   871: ifnull -225 -> 646
    //   874: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   877: aload 13
    //   879: aload_0
    //   880: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   883: pop
    //   884: goto -238 -> 646
    //   887: astore_0
    //   888: aconst_null
    //   889: astore 11
    //   891: new 15	java/io/File
    //   894: dup
    //   895: aload 13
    //   897: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   900: invokevirtual 36	java/io/File:exists	()Z
    //   903: ifeq +19 -> 922
    //   906: aload 11
    //   908: ifnull +14 -> 922
    //   911: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   914: aload 13
    //   916: aload 11
    //   918: invokevirtual 257	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   921: pop
    //   922: aload_0
    //   923: athrow
    //   924: aconst_null
    //   925: areturn
    //   926: astore_0
    //   927: goto -36 -> 891
    //   930: astore_0
    //   931: goto -40 -> 891
    //   934: astore 6
    //   936: goto -97 -> 839
    //   939: astore 11
    //   941: aload 6
    //   943: astore_0
    //   944: aload 11
    //   946: astore 6
    //   948: goto -109 -> 839
    //   951: astore 6
    //   953: goto -170 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	956	0	paramArrayOfByte	byte[]
    //   0	956	1	paramInt1	int
    //   0	956	2	paramInt2	int
    //   0	956	3	paramInt3	int
    //   0	956	4	paramInt4	int
    //   0	956	5	paramInt5	int
    //   0	956	6	paramRectF	android.graphics.RectF
    //   0	956	7	paramBoolean	boolean
    //   693	3	8	f	float
    //   13	85	9	l	long
    //   117	800	11	localObject	Object
    //   939	6	11	localIOException	java.io.IOException
    //   208	359	12	localBitmap1	Bitmap
    //   109	806	13	str	String
    //   235	348	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   379	390	713	java/lang/Throwable
    //   398	424	713	java/lang/Throwable
    //   427	452	713	java/lang/Throwable
    //   459	464	713	java/lang/Throwable
    //   476	482	713	java/lang/Throwable
    //   485	496	713	java/lang/Throwable
    //   503	509	713	java/lang/Throwable
    //   512	566	713	java/lang/Throwable
    //   667	682	713	java/lang/Throwable
    //   688	695	713	java/lang/Throwable
    //   213	237	781	java/lang/OutOfMemoryError
    //   245	253	781	java/lang/OutOfMemoryError
    //   288	299	781	java/lang/OutOfMemoryError
    //   302	311	781	java/lang/OutOfMemoryError
    //   582	599	781	java/lang/OutOfMemoryError
    //   606	615	781	java/lang/OutOfMemoryError
    //   761	778	781	java/lang/OutOfMemoryError
    //   213	237	835	java/io/IOException
    //   245	253	835	java/io/IOException
    //   288	299	835	java/io/IOException
    //   302	311	835	java/io/IOException
    //   213	237	887	finally
    //   245	253	887	finally
    //   288	299	887	finally
    //   302	311	887	finally
    //   317	323	926	finally
    //   326	352	926	finally
    //   379	390	926	finally
    //   398	424	926	finally
    //   427	452	926	finally
    //   459	464	926	finally
    //   476	482	926	finally
    //   485	496	926	finally
    //   503	509	926	finally
    //   512	566	926	finally
    //   667	682	926	finally
    //   688	695	926	finally
    //   718	748	926	finally
    //   842	847	926	finally
    //   850	855	926	finally
    //   582	599	930	finally
    //   606	615	930	finally
    //   761	778	930	finally
    //   786	795	930	finally
    //   798	803	930	finally
    //   317	323	934	java/io/IOException
    //   326	352	934	java/io/IOException
    //   379	390	934	java/io/IOException
    //   398	424	934	java/io/IOException
    //   427	452	934	java/io/IOException
    //   459	464	934	java/io/IOException
    //   476	482	934	java/io/IOException
    //   485	496	934	java/io/IOException
    //   503	509	934	java/io/IOException
    //   512	566	934	java/io/IOException
    //   667	682	934	java/io/IOException
    //   688	695	934	java/io/IOException
    //   718	748	934	java/io/IOException
    //   582	599	939	java/io/IOException
    //   606	615	939	java/io/IOException
    //   761	778	939	java/io/IOException
    //   317	323	951	java/lang/OutOfMemoryError
    //   326	352	951	java/lang/OutOfMemoryError
    //   379	390	951	java/lang/OutOfMemoryError
    //   398	424	951	java/lang/OutOfMemoryError
    //   427	452	951	java/lang/OutOfMemoryError
    //   459	464	951	java/lang/OutOfMemoryError
    //   476	482	951	java/lang/OutOfMemoryError
    //   485	496	951	java/lang/OutOfMemoryError
    //   503	509	951	java/lang/OutOfMemoryError
    //   512	566	951	java/lang/OutOfMemoryError
    //   667	682	951	java/lang/OutOfMemoryError
    //   688	695	951	java/lang/OutOfMemoryError
    //   718	748	951	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 347	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 349	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 352	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 355	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 359	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 362	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 365	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +99 -> 190
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 15	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 36	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 15	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 370	java/io/File:length	()J
    //   122: ldc2_w 371
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 41
    //   130: iconst_2
    //   131: new 131	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 374
    //   141: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 204
    //   150: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc_w 376
    //   160: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 378
    //   170: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 6
    //   175: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 380
    //   181: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 4
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 278	java/io/IOException:printStackTrace	()V
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
    //   219: ldc_w 382
    //   222: aload_0
    //   223: invokestatic 385	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 8
    //   232: ifnull -144 -> 88
    //   235: aload 8
    //   237: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -156 -> 88
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 278	java/io/IOException:printStackTrace	()V
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
    //   272: ldc_w 387
    //   275: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload 5
    //   280: istore 4
    //   282: aload_0
    //   283: ifnull -195 -> 88
    //   286: aload_0
    //   287: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   290: iload 5
    //   292: istore 4
    //   294: goto -206 -> 88
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -218 -> 88
    //   309: astore_0
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 278	java/io/IOException:printStackTrace	()V
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
    paramString = PhotoUtils.a(paramString);
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
    //   2: new 349	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 410	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 229	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 411	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 412	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 238	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 416	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 417	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 418	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 418	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 418	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 278	java/io/IOException:printStackTrace	()V
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
    if (azag.a() != null) {
      if (azag.a().c < 400)
      {
        i = 400;
        if (azag.a().b >= 10) {
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
            i = azag.a().c;
            break;
            j = azag.a().b;
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
    //   5: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 370	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 481	java/io/BufferedInputStream
    //   20: dup
    //   21: new 483	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 484	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 491	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 492	java/io/BufferedInputStream:close	()V
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
    //   70: ldc_w 494
    //   73: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 495	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 149	java/lang/Exception:printStackTrace	()V
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
 * Qualified Name:     ayzp
 * JD-Core Version:    0.7.0.1
 */