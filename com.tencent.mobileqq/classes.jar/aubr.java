import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class aubr
{
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    File localFile1 = new File(ajsd.aW, "ocr");
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
    //   3: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +75 -> 81
    //   9: aload_0
    //   10: ifnull +77 -> 87
    //   13: aload_0
    //   14: arraylength
    //   15: i2l
    //   16: lstore 5
    //   18: ldc 41
    //   20: iconst_2
    //   21: new 101	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   28: ldc 165
    //   30: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload 5
    //   35: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 167
    //   40: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 172
    //   49: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc 174
    //   58: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_3
    //   62: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 176
    //   67: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 4
    //   72: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: ifnonnull +11 -> 93
    //   85: aconst_null
    //   86: areturn
    //   87: lconst_0
    //   88: lstore 5
    //   90: goto -72 -> 18
    //   93: invokestatic 178	aubr:a	()Ljava/lang/String;
    //   96: iconst_1
    //   97: invokestatic 180	aubr:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   125: ldc 182
    //   127: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: aload 9
    //   134: new 184	android/graphics/YuvImage
    //   137: dup
    //   138: aload_0
    //   139: iload_3
    //   140: iload_1
    //   141: iload_2
    //   142: aconst_null
    //   143: invokespecial 187	android/graphics/YuvImage:<init>	([BIII[I)V
    //   146: bipush 100
    //   148: invokestatic 190	aubr:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   151: ifne +13 -> 164
    //   154: ldc 41
    //   156: iconst_1
    //   157: ldc 192
    //   159: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 9
    //   166: invokestatic 195	aubr:a	(Ljava/lang/String;)[B
    //   169: astore_0
    //   170: aload_0
    //   171: ifnonnull +14 -> 185
    //   174: ldc 41
    //   176: iconst_1
    //   177: ldc 197
    //   179: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 9
    //   184: areturn
    //   185: aload_0
    //   186: new 199	android/graphics/Rect
    //   189: dup
    //   190: iconst_0
    //   191: iconst_0
    //   192: getstatic 203	axlk:a	I
    //   195: getstatic 205	axlk:b	I
    //   198: invokespecial 208	android/graphics/Rect:<init>	(IIII)V
    //   201: iconst_0
    //   202: iconst_0
    //   203: invokestatic 213	amfv:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   206: astore 8
    //   208: aload 8
    //   210: ifnonnull +43 -> 253
    //   213: ldc 41
    //   215: iconst_1
    //   216: ldc 215
    //   218: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: new 15	java/io/File
    //   224: dup
    //   225: aload 9
    //   227: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 36	java/io/File:exists	()Z
    //   233: ifeq +17 -> 250
    //   236: iconst_0
    //   237: ifeq +13 -> 250
    //   240: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: aload 9
    //   245: aconst_null
    //   246: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload 9
    //   252: areturn
    //   253: aload 8
    //   255: iload 4
    //   257: iconst_1
    //   258: invokestatic 230	amfv:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   261: astore_0
    //   262: aload_0
    //   263: astore 7
    //   265: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +32 -> 300
    //   271: aload_0
    //   272: astore 7
    //   274: ldc 41
    //   276: iconst_2
    //   277: new 101	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   284: ldc 232
    //   286: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 4
    //   291: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: ifnonnull +81 -> 382
    //   304: aload_0
    //   305: astore 7
    //   307: aload 8
    //   309: bipush 100
    //   311: new 15	java/io/File
    //   314: dup
    //   315: aload 9
    //   317: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: invokestatic 237	bbef:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   323: pop
    //   324: aload_0
    //   325: astore 7
    //   327: ldc 41
    //   329: iconst_1
    //   330: ldc 239
    //   332: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: new 15	java/io/File
    //   338: dup
    //   339: aload 9
    //   341: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: invokevirtual 36	java/io/File:exists	()Z
    //   347: ifeq +17 -> 364
    //   350: aload_0
    //   351: ifnull +13 -> 364
    //   354: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   357: aload 9
    //   359: aload_0
    //   360: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: new 15	java/io/File
    //   367: dup
    //   368: aload 9
    //   370: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   373: invokevirtual 36	java/io/File:exists	()Z
    //   376: ifeq -291 -> 85
    //   379: aload 9
    //   381: areturn
    //   382: aload_0
    //   383: astore 7
    //   385: aload_0
    //   386: bipush 100
    //   388: new 15	java/io/File
    //   391: dup
    //   392: aload 9
    //   394: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: invokestatic 237	bbef:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   400: pop
    //   401: goto -66 -> 335
    //   404: astore 7
    //   406: aload_0
    //   407: astore 7
    //   409: ldc 41
    //   411: iconst_1
    //   412: ldc 241
    //   414: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: astore 7
    //   420: aload_0
    //   421: invokestatic 247	amfv:a	(Landroid/graphics/Bitmap;)Z
    //   424: pop
    //   425: new 15	java/io/File
    //   428: dup
    //   429: aload 9
    //   431: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   434: invokevirtual 36	java/io/File:exists	()Z
    //   437: ifeq -73 -> 364
    //   440: aload_0
    //   441: ifnull -77 -> 364
    //   444: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   447: aload 9
    //   449: aload_0
    //   450: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: goto -90 -> 364
    //   457: astore 7
    //   459: aconst_null
    //   460: astore_0
    //   461: aload 7
    //   463: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   466: aload_0
    //   467: invokestatic 247	amfv:a	(Landroid/graphics/Bitmap;)Z
    //   470: pop
    //   471: new 15	java/io/File
    //   474: dup
    //   475: aload 9
    //   477: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: invokevirtual 36	java/io/File:exists	()Z
    //   483: ifeq -119 -> 364
    //   486: aload_0
    //   487: ifnull -123 -> 364
    //   490: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   493: aload 9
    //   495: aload_0
    //   496: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: goto -136 -> 364
    //   503: astore_0
    //   504: new 15	java/io/File
    //   507: dup
    //   508: aload 9
    //   510: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: invokevirtual 36	java/io/File:exists	()Z
    //   516: ifeq +19 -> 535
    //   519: aload 7
    //   521: ifnull +14 -> 535
    //   524: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   527: aload 9
    //   529: aload 7
    //   531: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: pop
    //   535: aload_0
    //   536: athrow
    //   537: astore_0
    //   538: goto -34 -> 504
    //   541: astore 8
    //   543: aload_0
    //   544: astore 7
    //   546: aload 8
    //   548: astore_0
    //   549: goto -45 -> 504
    //   552: astore 7
    //   554: goto -93 -> 461
    //   557: astore_0
    //   558: aconst_null
    //   559: astore_0
    //   560: goto -154 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	paramArrayOfByte	byte[]
    //   0	563	1	paramInt1	int
    //   0	563	2	paramInt2	int
    //   0	563	3	paramInt3	int
    //   0	563	4	paramInt4	int
    //   16	73	5	l	long
    //   1	383	7	arrayOfByte1	byte[]
    //   404	1	7	localOutOfMemoryError	OutOfMemoryError
    //   407	12	7	arrayOfByte2	byte[]
    //   457	73	7	localIOException1	java.io.IOException
    //   544	1	7	arrayOfByte3	byte[]
    //   552	1	7	localIOException2	java.io.IOException
    //   206	102	8	localBitmap	Bitmap
    //   541	6	8	localObject	Object
    //   100	428	9	str	String
    // Exception table:
    //   from	to	target	type
    //   265	271	404	java/lang/OutOfMemoryError
    //   274	300	404	java/lang/OutOfMemoryError
    //   307	324	404	java/lang/OutOfMemoryError
    //   327	335	404	java/lang/OutOfMemoryError
    //   385	401	404	java/lang/OutOfMemoryError
    //   185	208	457	java/io/IOException
    //   213	221	457	java/io/IOException
    //   253	262	457	java/io/IOException
    //   185	208	503	finally
    //   213	221	503	finally
    //   253	262	503	finally
    //   265	271	537	finally
    //   274	300	537	finally
    //   307	324	537	finally
    //   327	335	537	finally
    //   385	401	537	finally
    //   409	417	537	finally
    //   420	425	537	finally
    //   461	471	541	finally
    //   265	271	552	java/io/IOException
    //   274	300	552	java/io/IOException
    //   307	324	552	java/io/IOException
    //   327	335	552	java/io/IOException
    //   385	401	552	java/io/IOException
    //   185	208	557	java/lang/OutOfMemoryError
    //   213	221	557	java/lang/OutOfMemoryError
    //   253	262	557	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +87 -> 90
    //   6: aload_0
    //   7: ifnull +89 -> 96
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 41
    //   17: iconst_2
    //   18: new 101	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   25: ldc 165
    //   27: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 167
    //   37: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 172
    //   46: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 174
    //   55: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 256
    //   65: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 5
    //   70: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 258
    //   76: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: ifnonnull +11 -> 102
    //   94: aconst_null
    //   95: areturn
    //   96: lconst_0
    //   97: lstore 9
    //   99: goto -84 -> 15
    //   102: invokestatic 178	aubr:a	()Ljava/lang/String;
    //   105: iconst_1
    //   106: invokestatic 180	aubr:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   109: astore 13
    //   111: iload 7
    //   113: ifeq +22 -> 135
    //   116: aload_0
    //   117: astore 11
    //   119: aload 11
    //   121: ifnonnull +86 -> 207
    //   124: ldc 41
    //   126: iconst_1
    //   127: ldc 197
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
    //   158: ldc 182
    //   160: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 13
    //   167: new 184	android/graphics/YuvImage
    //   170: dup
    //   171: aload_0
    //   172: iload_3
    //   173: iload_1
    //   174: iload_2
    //   175: aconst_null
    //   176: invokespecial 187	android/graphics/YuvImage:<init>	([BIII[I)V
    //   179: bipush 100
    //   181: invokestatic 190	aubr:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   184: ifne +13 -> 197
    //   187: ldc 41
    //   189: iconst_1
    //   190: ldc 192
    //   192: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aconst_null
    //   196: areturn
    //   197: aload 13
    //   199: invokestatic 195	aubr:a	(Ljava/lang/String;)[B
    //   202: astore 11
    //   204: goto -85 -> 119
    //   207: aconst_null
    //   208: astore 12
    //   210: aload 12
    //   212: astore_0
    //   213: aload 11
    //   215: new 199	android/graphics/Rect
    //   218: dup
    //   219: iconst_0
    //   220: iconst_0
    //   221: getstatic 203	axlk:a	I
    //   224: getstatic 205	axlk:b	I
    //   227: invokespecial 208	android/graphics/Rect:<init>	(IIII)V
    //   230: iconst_0
    //   231: iconst_0
    //   232: invokestatic 213	amfv:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   235: astore 14
    //   237: aload 14
    //   239: ifnonnull +46 -> 285
    //   242: aload 12
    //   244: astore_0
    //   245: ldc 41
    //   247: iconst_1
    //   248: ldc 215
    //   250: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: new 15	java/io/File
    //   256: dup
    //   257: aload 13
    //   259: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: invokevirtual 36	java/io/File:exists	()Z
    //   265: ifeq +17 -> 282
    //   268: iconst_0
    //   269: ifeq +13 -> 282
    //   272: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   275: aload 13
    //   277: aconst_null
    //   278: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload 13
    //   284: areturn
    //   285: aload 12
    //   287: astore_0
    //   288: invokestatic 266	amez:a	()Lamez;
    //   291: iload 4
    //   293: iload 5
    //   295: invokestatic 269	amfv:a	(Lamez;II)I
    //   298: istore_3
    //   299: aload 12
    //   301: astore_0
    //   302: aload 14
    //   304: iload_3
    //   305: iconst_1
    //   306: invokestatic 230	amfv:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   309: astore 11
    //   311: aload 11
    //   313: astore_0
    //   314: aload_0
    //   315: astore 11
    //   317: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +31 -> 351
    //   323: aload_0
    //   324: astore 11
    //   326: ldc 41
    //   328: iconst_2
    //   329: new 101	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   336: ldc 232
    //   338: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_3
    //   342: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 6
    //   353: ifnull +393 -> 746
    //   356: aload_0
    //   357: ifnull +389 -> 746
    //   360: iload_1
    //   361: istore 4
    //   363: iload_2
    //   364: istore_3
    //   365: iload_1
    //   366: iload_2
    //   367: if_icmple +27 -> 394
    //   370: iload_1
    //   371: istore 4
    //   373: iload_2
    //   374: istore_3
    //   375: aload_0
    //   376: astore 11
    //   378: aload_0
    //   379: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   382: aload_0
    //   383: invokevirtual 277	android/graphics/Bitmap:getHeight	()I
    //   386: if_icmpge +8 -> 394
    //   389: iload_1
    //   390: istore_3
    //   391: iload_2
    //   392: istore 4
    //   394: aload_0
    //   395: astore 11
    //   397: aload 6
    //   399: getfield 283	android/graphics/RectF:left	F
    //   402: iload 4
    //   404: i2f
    //   405: fmul
    //   406: ldc_w 284
    //   409: fadd
    //   410: iload 4
    //   412: aload_0
    //   413: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   416: isub
    //   417: iconst_2
    //   418: idiv
    //   419: i2f
    //   420: fsub
    //   421: f2i
    //   422: istore_1
    //   423: aload_0
    //   424: astore 11
    //   426: aload 6
    //   428: getfield 287	android/graphics/RectF:top	F
    //   431: iload_3
    //   432: i2f
    //   433: fmul
    //   434: ldc_w 284
    //   437: fadd
    //   438: iload_3
    //   439: aload_0
    //   440: invokevirtual 277	android/graphics/Bitmap:getHeight	()I
    //   443: isub
    //   444: iconst_2
    //   445: idiv
    //   446: i2f
    //   447: fsub
    //   448: f2i
    //   449: istore 5
    //   451: iload_1
    //   452: ifgt +210 -> 662
    //   455: aload_0
    //   456: astore 11
    //   458: aload_0
    //   459: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   462: istore_2
    //   463: iconst_0
    //   464: istore_1
    //   465: iload 5
    //   467: ifgt +216 -> 683
    //   470: iconst_0
    //   471: istore_3
    //   472: aload_0
    //   473: astore 11
    //   475: aload_0
    //   476: invokevirtual 277	android/graphics/Bitmap:getHeight	()I
    //   479: istore 4
    //   481: aload_0
    //   482: astore 11
    //   484: aload_0
    //   485: iload_1
    //   486: iload_3
    //   487: iload_2
    //   488: iload 4
    //   490: invokestatic 291	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   493: astore 12
    //   495: aload 12
    //   497: astore 6
    //   499: aload_0
    //   500: astore 11
    //   502: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +64 -> 569
    //   508: aload_0
    //   509: astore 11
    //   511: ldc 41
    //   513: iconst_2
    //   514: iconst_3
    //   515: anewarray 4	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: new 101	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   527: ldc_w 293
    //   530: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 12
    //   535: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   538: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: aastore
    //   545: dup
    //   546: iconst_1
    //   547: ldc_w 295
    //   550: aastore
    //   551: dup
    //   552: iconst_2
    //   553: aload 12
    //   555: invokevirtual 277	android/graphics/Bitmap:getHeight	()I
    //   558: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   561: aastore
    //   562: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   565: aload 12
    //   567: astore 6
    //   569: aload 6
    //   571: ifnonnull +181 -> 752
    //   574: aload 6
    //   576: astore_0
    //   577: aload 6
    //   579: astore 11
    //   581: aload 14
    //   583: bipush 100
    //   585: new 15	java/io/File
    //   588: dup
    //   589: aload 13
    //   591: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   594: invokestatic 237	bbef:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   597: pop
    //   598: aload 6
    //   600: astore_0
    //   601: aload 6
    //   603: astore 11
    //   605: ldc 41
    //   607: iconst_1
    //   608: ldc 239
    //   610: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: new 15	java/io/File
    //   616: dup
    //   617: aload 13
    //   619: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   622: invokevirtual 36	java/io/File:exists	()Z
    //   625: ifeq +19 -> 644
    //   628: aload 6
    //   630: ifnull +14 -> 644
    //   633: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   636: aload 13
    //   638: aload 6
    //   640: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: pop
    //   644: new 15	java/io/File
    //   647: dup
    //   648: aload 13
    //   650: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   653: invokevirtual 36	java/io/File:exists	()Z
    //   656: ifeq +265 -> 921
    //   659: aload 13
    //   661: areturn
    //   662: aload_0
    //   663: astore 11
    //   665: aload 6
    //   667: invokevirtual 308	android/graphics/RectF:width	()F
    //   670: iload 4
    //   672: i2f
    //   673: fmul
    //   674: ldc_w 284
    //   677: fadd
    //   678: f2i
    //   679: istore_2
    //   680: goto -215 -> 465
    //   683: aload_0
    //   684: astore 11
    //   686: aload 6
    //   688: invokevirtual 311	android/graphics/RectF:height	()F
    //   691: fstore 8
    //   693: fload 8
    //   695: iload_3
    //   696: i2f
    //   697: fmul
    //   698: ldc_w 284
    //   701: fadd
    //   702: f2i
    //   703: istore 4
    //   705: iload 5
    //   707: istore_3
    //   708: goto -227 -> 481
    //   711: astore 6
    //   713: aload_0
    //   714: astore 11
    //   716: ldc 41
    //   718: iconst_1
    //   719: new 101	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 313
    //   729: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 6
    //   734: invokevirtual 316	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   737: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_0
    //   747: astore 6
    //   749: goto -180 -> 569
    //   752: aload 6
    //   754: astore_0
    //   755: aload 6
    //   757: astore 11
    //   759: aload 6
    //   761: bipush 100
    //   763: new 15	java/io/File
    //   766: dup
    //   767: aload 13
    //   769: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   772: invokestatic 237	bbef:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   775: pop
    //   776: goto -163 -> 613
    //   779: astore 6
    //   781: aload_0
    //   782: astore 11
    //   784: ldc 41
    //   786: iconst_1
    //   787: ldc 241
    //   789: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   792: aload_0
    //   793: astore 11
    //   795: aload_0
    //   796: invokestatic 247	amfv:a	(Landroid/graphics/Bitmap;)Z
    //   799: pop
    //   800: new 15	java/io/File
    //   803: dup
    //   804: aload 13
    //   806: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   809: invokevirtual 36	java/io/File:exists	()Z
    //   812: ifeq -168 -> 644
    //   815: aload_0
    //   816: ifnull -172 -> 644
    //   819: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   822: aload 13
    //   824: aload_0
    //   825: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   828: pop
    //   829: goto -185 -> 644
    //   832: astore 6
    //   834: aconst_null
    //   835: astore_0
    //   836: aload_0
    //   837: astore 11
    //   839: aload 6
    //   841: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   844: aload_0
    //   845: astore 11
    //   847: aload_0
    //   848: invokestatic 247	amfv:a	(Landroid/graphics/Bitmap;)Z
    //   851: pop
    //   852: new 15	java/io/File
    //   855: dup
    //   856: aload 13
    //   858: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   861: invokevirtual 36	java/io/File:exists	()Z
    //   864: ifeq -220 -> 644
    //   867: aload_0
    //   868: ifnull -224 -> 644
    //   871: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   874: aload 13
    //   876: aload_0
    //   877: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   880: pop
    //   881: goto -237 -> 644
    //   884: astore_0
    //   885: aconst_null
    //   886: astore 11
    //   888: new 15	java/io/File
    //   891: dup
    //   892: aload 13
    //   894: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   897: invokevirtual 36	java/io/File:exists	()Z
    //   900: ifeq +19 -> 919
    //   903: aload 11
    //   905: ifnull +14 -> 919
    //   908: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   911: aload 13
    //   913: aload 11
    //   915: invokevirtual 227	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   918: pop
    //   919: aload_0
    //   920: athrow
    //   921: aconst_null
    //   922: areturn
    //   923: astore_0
    //   924: goto -36 -> 888
    //   927: astore_0
    //   928: goto -40 -> 888
    //   931: astore 6
    //   933: goto -97 -> 836
    //   936: astore 11
    //   938: aload 6
    //   940: astore_0
    //   941: aload 11
    //   943: astore 6
    //   945: goto -109 -> 836
    //   948: astore 6
    //   950: goto -169 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	953	0	paramArrayOfByte	byte[]
    //   0	953	1	paramInt1	int
    //   0	953	2	paramInt2	int
    //   0	953	3	paramInt3	int
    //   0	953	4	paramInt4	int
    //   0	953	5	paramInt5	int
    //   0	953	6	paramRectF	android.graphics.RectF
    //   0	953	7	paramBoolean	boolean
    //   691	3	8	f	float
    //   13	85	9	l	long
    //   117	797	11	localObject	Object
    //   936	6	11	localIOException	java.io.IOException
    //   208	358	12	localBitmap1	Bitmap
    //   109	803	13	str	String
    //   235	347	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   378	389	711	java/lang/Throwable
    //   397	423	711	java/lang/Throwable
    //   426	451	711	java/lang/Throwable
    //   458	463	711	java/lang/Throwable
    //   475	481	711	java/lang/Throwable
    //   484	495	711	java/lang/Throwable
    //   502	508	711	java/lang/Throwable
    //   511	565	711	java/lang/Throwable
    //   665	680	711	java/lang/Throwable
    //   686	693	711	java/lang/Throwable
    //   213	237	779	java/lang/OutOfMemoryError
    //   245	253	779	java/lang/OutOfMemoryError
    //   288	299	779	java/lang/OutOfMemoryError
    //   302	311	779	java/lang/OutOfMemoryError
    //   581	598	779	java/lang/OutOfMemoryError
    //   605	613	779	java/lang/OutOfMemoryError
    //   759	776	779	java/lang/OutOfMemoryError
    //   213	237	832	java/io/IOException
    //   245	253	832	java/io/IOException
    //   288	299	832	java/io/IOException
    //   302	311	832	java/io/IOException
    //   213	237	884	finally
    //   245	253	884	finally
    //   288	299	884	finally
    //   302	311	884	finally
    //   317	323	923	finally
    //   326	351	923	finally
    //   378	389	923	finally
    //   397	423	923	finally
    //   426	451	923	finally
    //   458	463	923	finally
    //   475	481	923	finally
    //   484	495	923	finally
    //   502	508	923	finally
    //   511	565	923	finally
    //   665	680	923	finally
    //   686	693	923	finally
    //   716	746	923	finally
    //   839	844	923	finally
    //   847	852	923	finally
    //   581	598	927	finally
    //   605	613	927	finally
    //   759	776	927	finally
    //   784	792	927	finally
    //   795	800	927	finally
    //   317	323	931	java/io/IOException
    //   326	351	931	java/io/IOException
    //   378	389	931	java/io/IOException
    //   397	423	931	java/io/IOException
    //   426	451	931	java/io/IOException
    //   458	463	931	java/io/IOException
    //   475	481	931	java/io/IOException
    //   484	495	931	java/io/IOException
    //   502	508	931	java/io/IOException
    //   511	565	931	java/io/IOException
    //   665	680	931	java/io/IOException
    //   686	693	931	java/io/IOException
    //   716	746	931	java/io/IOException
    //   581	598	936	java/io/IOException
    //   605	613	936	java/io/IOException
    //   759	776	936	java/io/IOException
    //   317	323	948	java/lang/OutOfMemoryError
    //   326	351	948	java/lang/OutOfMemoryError
    //   378	389	948	java/lang/OutOfMemoryError
    //   397	423	948	java/lang/OutOfMemoryError
    //   426	451	948	java/lang/OutOfMemoryError
    //   458	463	948	java/lang/OutOfMemoryError
    //   475	481	948	java/lang/OutOfMemoryError
    //   484	495	948	java/lang/OutOfMemoryError
    //   502	508	948	java/lang/OutOfMemoryError
    //   511	565	948	java/lang/OutOfMemoryError
    //   665	680	948	java/lang/OutOfMemoryError
    //   686	693	948	java/lang/OutOfMemoryError
    //   716	746	948	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 319	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 321	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 327	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 331	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 334	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 337	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +99 -> 190
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 15	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 36	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 15	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 342	java/io/File:length	()J
    //   122: ldc2_w 343
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 41
    //   130: iconst_2
    //   131: new 101	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 346
    //   141: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 174
    //   150: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc_w 348
    //   160: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 350
    //   170: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 6
    //   175: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 352
    //   181: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 4
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 248	java/io/IOException:printStackTrace	()V
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
    //   219: ldc_w 354
    //   222: aload_0
    //   223: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 8
    //   232: ifnull -144 -> 88
    //   235: aload 8
    //   237: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -156 -> 88
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 248	java/io/IOException:printStackTrace	()V
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
    //   272: ldc_w 359
    //   275: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload 5
    //   280: istore 4
    //   282: aload_0
    //   283: ifnull -195 -> 88
    //   286: aload_0
    //   287: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   290: iload 5
    //   292: istore 4
    //   294: goto -206 -> 88
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -218 -> 88
    //   309: astore_0
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 248	java/io/IOException:printStackTrace	()V
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
    //   2: new 321	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 199	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 383	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 384	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 208	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 388	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 389	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 248	java/io/IOException:printStackTrace	()V
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
    if (auci.a() != null) {
      if (auci.a().c < 400)
      {
        i = 400;
        if (auci.a().b >= 10) {
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
            i = auci.a().c;
            break;
            j = auci.a().b;
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
    //   5: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 342	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 453	java/io/BufferedInputStream
    //   20: dup
    //   21: new 455	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 456	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 459	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 463	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 464	java/io/BufferedInputStream:close	()V
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
    //   70: ldc_w 466
    //   73: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 467	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 119	java/lang/Exception:printStackTrace	()V
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
 * Qualified Name:     aubr
 * JD-Core Version:    0.7.0.1
 */