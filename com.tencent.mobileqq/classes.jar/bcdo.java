import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

public class bcdo
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (paramInt1 == -1) {
      paramInt1 = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
    }
    for (;;)
    {
      if (paramInt2 == -1) {
        paramInt2 = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
      }
      for (;;)
      {
        int i = paramInt2;
        int j = paramInt1;
        if (paramInt1 != -1)
        {
          i = paramInt2;
          j = paramInt1;
          if (paramInt2 != -1)
          {
            if (paramOptions.outHeight <= paramOptions.outWidth) {
              break label123;
            }
            if (!paramBoolean) {
              break label104;
            }
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
        for (;;)
        {
          return Bitmap.createScaledBitmap(paramBitmap, j, i, true);
          label104:
          i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
          j = paramInt1;
          continue;
          label123:
          if (paramBoolean)
          {
            i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
            j = paramInt1;
          }
          else
          {
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
      }
    }
  }
  
  /* Error */
  public static Bitmap a(java.lang.String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aload 9
    //   14: astore 4
    //   16: aload_0
    //   17: ifnull +21 -> 38
    //   20: new 31	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 39	java/io/File:exists	()Z
    //   31: ifne +10 -> 41
    //   34: aload 9
    //   36: astore 4
    //   38: aload 4
    //   40: areturn
    //   41: invokestatic 42	bcdo:a	()Landroid/graphics/BitmapFactory$Options;
    //   44: astore 11
    //   46: new 44	java/io/BufferedInputStream
    //   49: dup
    //   50: new 46	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: sipush 8192
    //   61: invokespecial 50	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   64: astore 5
    //   66: aload 5
    //   68: astore_0
    //   69: aload 5
    //   71: aconst_null
    //   72: aload 11
    //   74: invokestatic 56	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: pop
    //   78: aload 10
    //   80: astore 6
    //   82: aload 5
    //   84: astore_0
    //   85: aload 11
    //   87: getfield 15	android/graphics/BitmapFactory$Options:outHeight	I
    //   90: ifle +143 -> 233
    //   93: aload 10
    //   95: astore 6
    //   97: aload 5
    //   99: astore_0
    //   100: aload 11
    //   102: getfield 12	android/graphics/BitmapFactory$Options:outWidth	I
    //   105: ifle +128 -> 233
    //   108: aload 5
    //   110: astore_0
    //   111: aload 11
    //   113: iload_1
    //   114: iload_2
    //   115: iload_3
    //   116: invokestatic 59	bcdo:a	(Landroid/graphics/BitmapFactory$Options;IIZ)Landroid/graphics/BitmapFactory$Options;
    //   119: pop
    //   120: aload 5
    //   122: astore_0
    //   123: aload 5
    //   125: aconst_null
    //   126: aload 11
    //   128: invokestatic 56	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore 4
    //   133: aload 4
    //   135: ifnonnull +54 -> 189
    //   138: aload 9
    //   140: astore 4
    //   142: aload 5
    //   144: ifnull -106 -> 38
    //   147: aload 5
    //   149: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: aload 5
    //   160: astore_0
    //   161: aload 11
    //   163: aload 11
    //   165: getfield 66	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   168: iconst_1
    //   169: isub
    //   170: putfield 66	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   173: aload 5
    //   175: astore_0
    //   176: aload 5
    //   178: aconst_null
    //   179: aload 11
    //   181: invokestatic 56	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   184: astore 4
    //   186: goto -53 -> 133
    //   189: aload 5
    //   191: astore_0
    //   192: aload 4
    //   194: invokevirtual 69	android/graphics/Bitmap:hasAlpha	()Z
    //   197: ifeq +57 -> 254
    //   200: aload 5
    //   202: astore_0
    //   203: getstatic 75	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   206: astore 6
    //   208: aload 5
    //   210: astore_0
    //   211: aload 11
    //   213: aload 6
    //   215: putfield 78	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   218: aload 5
    //   220: astore_0
    //   221: aload 4
    //   223: iload_1
    //   224: iload_2
    //   225: aload 11
    //   227: iload_3
    //   228: invokestatic 80	bcdo:a	(Landroid/graphics/Bitmap;IILandroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/Bitmap;
    //   231: astore 6
    //   233: aload 6
    //   235: astore 4
    //   237: aload 5
    //   239: ifnull -201 -> 38
    //   242: aload 5
    //   244: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   247: aload 6
    //   249: areturn
    //   250: astore_0
    //   251: aload 6
    //   253: areturn
    //   254: aload 5
    //   256: astore_0
    //   257: getstatic 83	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   260: astore 6
    //   262: goto -54 -> 208
    //   265: astore 4
    //   267: aconst_null
    //   268: astore 5
    //   270: aload 7
    //   272: astore 6
    //   274: aload 5
    //   276: astore_0
    //   277: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +17 -> 297
    //   283: aload 5
    //   285: astore_0
    //   286: ldc 90
    //   288: iconst_2
    //   289: aload 4
    //   291: invokestatic 94	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   294: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload 6
    //   299: astore 4
    //   301: aload 5
    //   303: ifnull -265 -> 38
    //   306: aload 5
    //   308: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   311: aload 6
    //   313: areturn
    //   314: astore_0
    //   315: aload 6
    //   317: areturn
    //   318: astore 4
    //   320: aconst_null
    //   321: astore 5
    //   323: aload 8
    //   325: astore 6
    //   327: aload 5
    //   329: astore_0
    //   330: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +17 -> 350
    //   336: aload 5
    //   338: astore_0
    //   339: ldc 90
    //   341: iconst_2
    //   342: aload 4
    //   344: invokestatic 94	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   347: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload 6
    //   352: astore 4
    //   354: aload 5
    //   356: ifnull -318 -> 38
    //   359: aload 5
    //   361: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   364: aload 6
    //   366: areturn
    //   367: astore_0
    //   368: aload 6
    //   370: areturn
    //   371: astore 4
    //   373: aconst_null
    //   374: astore_0
    //   375: aload_0
    //   376: ifnull +7 -> 383
    //   379: aload_0
    //   380: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   383: aload 4
    //   385: athrow
    //   386: astore_0
    //   387: goto -4 -> 383
    //   390: astore 4
    //   392: goto -17 -> 375
    //   395: astore 4
    //   397: aload 8
    //   399: astore 6
    //   401: goto -74 -> 327
    //   404: astore_0
    //   405: aload 4
    //   407: astore 6
    //   409: aload_0
    //   410: astore 4
    //   412: goto -85 -> 327
    //   415: astore 4
    //   417: aload 7
    //   419: astore 6
    //   421: goto -147 -> 274
    //   424: astore_0
    //   425: aload 4
    //   427: astore 6
    //   429: aload_0
    //   430: astore 4
    //   432: goto -158 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramString	java.lang.String
    //   0	435	1	paramInt1	int
    //   0	435	2	paramInt2	int
    //   0	435	3	paramBoolean	boolean
    //   14	222	4	localObject1	Object
    //   265	25	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   299	1	4	localObject2	Object
    //   318	25	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   352	1	4	localObject3	Object
    //   371	13	4	localObject4	Object
    //   390	1	4	localObject5	Object
    //   395	11	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   410	1	4	str1	java.lang.String
    //   415	11	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   430	1	4	str2	java.lang.String
    //   64	296	5	localBufferedInputStream	java.io.BufferedInputStream
    //   80	348	6	localObject6	Object
    //   4	414	7	localObject7	Object
    //   7	391	8	localObject8	Object
    //   10	129	9	localObject9	Object
    //   1	93	10	localObject10	Object
    //   44	182	11	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   147	152	154	java/lang/Exception
    //   123	133	157	java/lang/Exception
    //   242	247	250	java/lang/Exception
    //   41	66	265	java/lang/OutOfMemoryError
    //   306	311	314	java/lang/Exception
    //   41	66	318	java/io/FileNotFoundException
    //   359	364	367	java/lang/Exception
    //   41	66	371	finally
    //   379	383	386	java/lang/Exception
    //   69	78	390	finally
    //   85	93	390	finally
    //   100	108	390	finally
    //   111	120	390	finally
    //   123	133	390	finally
    //   161	173	390	finally
    //   176	186	390	finally
    //   192	200	390	finally
    //   203	208	390	finally
    //   211	218	390	finally
    //   221	233	390	finally
    //   257	262	390	finally
    //   277	283	390	finally
    //   286	297	390	finally
    //   330	336	390	finally
    //   339	350	390	finally
    //   69	78	395	java/io/FileNotFoundException
    //   85	93	395	java/io/FileNotFoundException
    //   100	108	395	java/io/FileNotFoundException
    //   111	120	395	java/io/FileNotFoundException
    //   123	133	395	java/io/FileNotFoundException
    //   161	173	395	java/io/FileNotFoundException
    //   176	186	395	java/io/FileNotFoundException
    //   192	200	404	java/io/FileNotFoundException
    //   203	208	404	java/io/FileNotFoundException
    //   211	218	404	java/io/FileNotFoundException
    //   221	233	404	java/io/FileNotFoundException
    //   257	262	404	java/io/FileNotFoundException
    //   69	78	415	java/lang/OutOfMemoryError
    //   85	93	415	java/lang/OutOfMemoryError
    //   100	108	415	java/lang/OutOfMemoryError
    //   111	120	415	java/lang/OutOfMemoryError
    //   123	133	415	java/lang/OutOfMemoryError
    //   161	173	415	java/lang/OutOfMemoryError
    //   176	186	415	java/lang/OutOfMemoryError
    //   192	200	424	java/lang/OutOfMemoryError
    //   203	208	424	java/lang/OutOfMemoryError
    //   211	218	424	java/lang/OutOfMemoryError
    //   221	233	424	java/lang/OutOfMemoryError
    //   257	262	424	java/lang/OutOfMemoryError
  }
  
  public static BitmapFactory.Options a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    return localOptions;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inSampleSize = 2;
    if (paramBoolean) {
      while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) || (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
        paramOptions.inSampleSize += 1;
      }
    }
    while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) && (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
      paramOptions.inSampleSize += 1;
    }
    paramOptions.inSampleSize -= 1;
    return paramOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcdo
 * JD-Core Version:    0.7.0.1
 */