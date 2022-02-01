package com.tencent.biz.qqcircle.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class AnimationTools
{
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    try
    {
      paramDrawable.setCallback(null);
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
        if ((paramDrawable != null) && (!paramDrawable.isRecycled()))
        {
          paramDrawable.recycle();
          return;
        }
      }
    }
    catch (Exception paramDrawable)
    {
      if (QLog.isDevelopLevel()) {
        paramDrawable.printStackTrace();
      }
    }
  }
  
  public static void a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, new AnimationTools.1());
  }
  
  /* Error */
  public static Drawable[] a(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 62	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 65
    //   19: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload_0
    //   26: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 71
    //   32: iconst_2
    //   33: aload 6
    //   35: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: new 81	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 87	java/io/File:exists	()Z
    //   54: ifne +19 -> 73
    //   57: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +11 -> 71
    //   63: ldc 71
    //   65: iconst_2
    //   66: ldc 89
    //   68: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aconst_null
    //   72: areturn
    //   73: aload_0
    //   74: invokevirtual 96	java/io/File:listFiles	()[Ljava/io/File;
    //   77: astore 8
    //   79: aload 8
    //   81: ifnull +514 -> 595
    //   84: aload 8
    //   86: arraylength
    //   87: ifgt +6 -> 93
    //   90: goto +505 -> 595
    //   93: aload 8
    //   95: invokestatic 98	com/tencent/biz/qqcircle/utils/AnimationTools:a	([Ljava/io/File;)V
    //   98: aload 8
    //   100: arraylength
    //   101: anewarray 15	android/graphics/drawable/Drawable
    //   104: astore 9
    //   106: iconst_0
    //   107: istore 4
    //   109: iconst_0
    //   110: istore_1
    //   111: iconst_0
    //   112: istore_2
    //   113: aload 8
    //   115: arraylength
    //   116: istore_3
    //   117: iconst_1
    //   118: istore 5
    //   120: iload_1
    //   121: iload_3
    //   122: if_icmpge +411 -> 533
    //   125: iload_2
    //   126: istore_3
    //   127: aload 8
    //   129: iload_1
    //   130: aaload
    //   131: ifnull +393 -> 524
    //   134: iload_2
    //   135: istore_3
    //   136: aload 8
    //   138: iload_1
    //   139: aaload
    //   140: invokevirtual 101	java/io/File:isFile	()Z
    //   143: ifeq +381 -> 524
    //   146: iload_2
    //   147: istore_3
    //   148: aload 8
    //   150: iload_1
    //   151: aaload
    //   152: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: invokestatic 109	com/tencent/biz/qqcircle/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   158: ifeq +366 -> 524
    //   161: new 111	java/io/BufferedInputStream
    //   164: dup
    //   165: new 113	java/io/FileInputStream
    //   168: dup
    //   169: aload 8
    //   171: iload_1
    //   172: aaload
    //   173: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   179: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore 6
    //   184: aload 6
    //   186: astore_0
    //   187: aload 9
    //   189: iload_1
    //   190: new 21	android/graphics/drawable/BitmapDrawable
    //   193: dup
    //   194: aload 6
    //   196: invokespecial 118	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   199: aastore
    //   200: aload 6
    //   202: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   205: goto +169 -> 374
    //   208: astore_0
    //   209: iload 5
    //   211: istore_2
    //   212: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +159 -> 374
    //   218: new 62	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   225: astore 6
    //   227: aload 6
    //   229: ldc 123
    //   231: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: aload_0
    //   238: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc 71
    //   244: iconst_2
    //   245: aload 6
    //   247: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: iload 5
    //   255: istore_2
    //   256: goto +118 -> 374
    //   259: astore 7
    //   261: goto +15 -> 276
    //   264: astore 6
    //   266: aconst_null
    //   267: astore_0
    //   268: goto +200 -> 468
    //   271: astore 7
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 6
    //   278: astore_0
    //   279: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +51 -> 333
    //   285: aload 6
    //   287: astore_0
    //   288: new 62	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   295: astore 10
    //   297: aload 6
    //   299: astore_0
    //   300: aload 10
    //   302: ldc 128
    //   304: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: astore_0
    //   311: aload 10
    //   313: aload 7
    //   315: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: astore_0
    //   322: ldc 71
    //   324: iconst_2
    //   325: aload 10
    //   327: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: iload 5
    //   335: istore_2
    //   336: aload 6
    //   338: ifnull +36 -> 374
    //   341: aload 6
    //   343: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   346: iload 5
    //   348: istore_2
    //   349: goto +25 -> 374
    //   352: astore_0
    //   353: iload 5
    //   355: istore_2
    //   356: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +15 -> 374
    //   362: new 62	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   369: astore 6
    //   371: goto -144 -> 227
    //   374: iload_2
    //   375: ifne +24 -> 399
    //   378: aload 9
    //   380: iload_1
    //   381: aaload
    //   382: checkcast 21	android/graphics/drawable/BitmapDrawable
    //   385: invokevirtual 25	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   388: ifnonnull +6 -> 394
    //   391: goto +8 -> 399
    //   394: iload_2
    //   395: istore_3
    //   396: goto +128 -> 524
    //   399: iload_1
    //   400: istore_2
    //   401: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +42 -> 446
    //   407: new 62	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   414: astore_0
    //   415: aload_0
    //   416: ldc 130
    //   418: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_0
    //   423: aload 8
    //   425: iload_1
    //   426: aaload
    //   427: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   430: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 71
    //   436: iconst_2
    //   437: aload_0
    //   438: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: iload_1
    //   445: istore_2
    //   446: iload_2
    //   447: iflt +17 -> 464
    //   450: aload 9
    //   452: iload_2
    //   453: aaload
    //   454: invokestatic 132	com/tencent/biz/qqcircle/utils/AnimationTools:a	(Landroid/graphics/drawable/Drawable;)V
    //   457: iload_2
    //   458: iconst_1
    //   459: isub
    //   460: istore_2
    //   461: goto -15 -> 446
    //   464: aconst_null
    //   465: areturn
    //   466: astore 6
    //   468: aload_0
    //   469: ifnull +52 -> 521
    //   472: aload_0
    //   473: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   476: goto +45 -> 521
    //   479: astore_0
    //   480: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +38 -> 521
    //   486: new 62	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   493: astore 7
    //   495: aload 7
    //   497: ldc 123
    //   499: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 7
    //   505: aload_0
    //   506: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 71
    //   512: iconst_2
    //   513: aload 7
    //   515: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload 6
    //   523: athrow
    //   524: iload_1
    //   525: iconst_1
    //   526: iadd
    //   527: istore_1
    //   528: iload_3
    //   529: istore_2
    //   530: goto -417 -> 113
    //   533: aload 9
    //   535: arraylength
    //   536: istore 5
    //   538: iconst_0
    //   539: istore_2
    //   540: iload 4
    //   542: istore_1
    //   543: iload_1
    //   544: iload 5
    //   546: if_icmpge +25 -> 571
    //   549: iload_2
    //   550: istore_3
    //   551: aload 9
    //   553: iload_1
    //   554: aaload
    //   555: ifnull +7 -> 562
    //   558: iload_2
    //   559: iconst_1
    //   560: iadd
    //   561: istore_3
    //   562: iload_1
    //   563: iconst_1
    //   564: iadd
    //   565: istore_1
    //   566: iload_3
    //   567: istore_2
    //   568: goto -25 -> 543
    //   571: iload_2
    //   572: iconst_1
    //   573: if_icmpge +19 -> 592
    //   576: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +11 -> 590
    //   582: ldc 71
    //   584: iconst_2
    //   585: ldc 134
    //   587: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aconst_null
    //   591: areturn
    //   592: aload 9
    //   594: areturn
    //   595: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   598: ifeq +11 -> 609
    //   601: ldc 71
    //   603: iconst_2
    //   604: ldc 136
    //   606: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aconst_null
    //   610: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	paramString	java.lang.String
    //   110	456	1	i	int
    //   112	462	2	j	int
    //   116	451	3	k	int
    //   107	434	4	m	int
    //   118	429	5	n	int
    //   13	233	6	localObject1	Object
    //   264	1	6	localObject2	Object
    //   274	96	6	localStringBuilder1	java.lang.StringBuilder
    //   466	56	6	localObject3	Object
    //   259	1	7	localThrowable1	java.lang.Throwable
    //   271	43	7	localThrowable2	java.lang.Throwable
    //   493	21	7	localStringBuilder2	java.lang.StringBuilder
    //   77	347	8	arrayOfFile	File[]
    //   104	489	9	arrayOfDrawable	Drawable[]
    //   295	31	10	localStringBuilder3	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	205	208	java/io/IOException
    //   187	200	259	java/lang/Throwable
    //   161	184	264	finally
    //   161	184	271	java/lang/Throwable
    //   341	346	352	java/io/IOException
    //   187	200	466	finally
    //   279	285	466	finally
    //   288	297	466	finally
    //   300	308	466	finally
    //   311	319	466	finally
    //   322	333	466	finally
    //   472	476	479	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.AnimationTools
 * JD-Core Version:    0.7.0.1
 */