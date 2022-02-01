import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bduh
  extends bdsh
{
  protected BaseApplicationImpl a;
  
  public bduh(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.a.getResources().getDisplayMetrics().density;
        int m = this.a.getResources().getDisplayMetrics().densityDpi;
        j = atwg.c;
        i = atwg.jdField_a_of_type_Int;
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        i1 = atwg.e;
        int i2 = atwg.f;
        if ((n >= i2) && (k >= i2)) {
          break label339;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label310;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, bdzx.b);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), localPaint);
          return new RoundRectBitmap(localBitmap, 14.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label332;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 8.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label310:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label332:
        i = k;
      }
      label339:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  /* Error */
  private Object b(DownloadParams paramDownloadParams, bdui parambdui)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_2
    //   9: getfield 148	bdui:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore 10
    //   14: aload 10
    //   16: ifnonnull +8 -> 24
    //   19: aload 7
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 150	java/io/File
    //   27: dup
    //   28: aload 10
    //   30: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 11
    //   35: aload 11
    //   37: invokestatic 159	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   40: ifeq +63 -> 103
    //   43: aload_2
    //   44: getfield 162	bdui:jdField_a_of_type_Boolean	Z
    //   47: ifeq +56 -> 103
    //   50: aload 7
    //   52: astore_2
    //   53: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -34 -> 22
    //   59: ldc 170
    //   61: iconst_2
    //   62: new 172	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   69: ldc 175
    //   71: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 11
    //   76: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 185
    //   84: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 10
    //   89: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload_1
    //   102: athrow
    //   103: new 194	android/graphics/BitmapFactory$Options
    //   106: dup
    //   107: invokespecial 195	android/graphics/BitmapFactory$Options:<init>	()V
    //   110: astore 12
    //   112: aload 12
    //   114: getstatic 197	bdzx:a	Landroid/graphics/Bitmap$Config;
    //   117: putfield 200	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: aload 12
    //   122: sipush 160
    //   125: putfield 203	android/graphics/BitmapFactory$Options:inDensity	I
    //   128: aload 12
    //   130: sipush 160
    //   133: putfield 206	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   136: aload 12
    //   138: sipush 160
    //   141: putfield 209	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   144: aload_1
    //   145: aload 10
    //   147: invokestatic 215	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   150: putfield 220	com/tencent/image/DownloadParams:outOrientation	I
    //   153: aload 12
    //   155: iconst_1
    //   156: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   159: new 225	java/io/FileInputStream
    //   162: dup
    //   163: aload 11
    //   165: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: new 228	java/io/BufferedInputStream
    //   176: dup
    //   177: aload 7
    //   179: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore_2
    //   183: iconst_2
    //   184: newarray byte
    //   186: astore 9
    //   188: aload_2
    //   189: aload 9
    //   191: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   194: pop
    //   195: aload 9
    //   197: iconst_0
    //   198: baload
    //   199: bipush 66
    //   201: if_icmpeq +77 -> 278
    //   204: aload 9
    //   206: iconst_1
    //   207: baload
    //   208: istore 4
    //   210: iload 4
    //   212: bipush 77
    //   214: if_icmpeq +64 -> 278
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 238	java/io/BufferedInputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 239	java/io/FileInputStream:close	()V
    //   235: aload 12
    //   237: iconst_1
    //   238: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   241: aload 11
    //   243: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: aload 12
    //   248: invokestatic 245	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   251: pop
    //   252: aload 12
    //   254: getfield 248	android/graphics/BitmapFactory$Options:outHeight	I
    //   257: ifeq +11 -> 268
    //   260: aload 12
    //   262: getfield 251	android/graphics/BitmapFactory$Options:outWidth	I
    //   265: ifne +171 -> 436
    //   268: new 253	java/io/IOException
    //   271: dup
    //   272: ldc 255
    //   274: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: aload_2
    //   279: iconst_4
    //   280: newarray byte
    //   282: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   285: pop
    //   286: aload_2
    //   287: ldc2_w 257
    //   290: invokevirtual 262	java/io/BufferedInputStream:skip	(J)J
    //   293: pop2
    //   294: iconst_4
    //   295: newarray byte
    //   297: astore 9
    //   299: aload_2
    //   300: aload 9
    //   302: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   305: pop
    //   306: aload_0
    //   307: aload 9
    //   309: invokevirtual 264	bduh:a	([B)I
    //   312: istore 4
    //   314: iconst_4
    //   315: newarray byte
    //   317: astore 9
    //   319: aload_2
    //   320: aload 9
    //   322: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   325: pop
    //   326: aload_0
    //   327: aload 9
    //   329: invokevirtual 264	bduh:a	([B)I
    //   332: invokestatic 268	java/lang/Math:abs	(I)I
    //   335: istore 5
    //   337: iload 4
    //   339: iflt +14 -> 353
    //   342: iload 4
    //   344: iload 5
    //   346: imul
    //   347: ldc_w 269
    //   350: if_icmple -133 -> 217
    //   353: invokestatic 273	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: invokevirtual 276	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   359: ldc_w 277
    //   362: invokevirtual 281	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   365: invokestatic 283	bduh:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   368: astore 9
    //   370: aload 9
    //   372: astore_1
    //   373: aload_2
    //   374: ifnull +7 -> 381
    //   377: aload_2
    //   378: invokevirtual 238	java/io/BufferedInputStream:close	()V
    //   381: aload_1
    //   382: astore_2
    //   383: aload 7
    //   385: ifnull -363 -> 22
    //   388: aload 7
    //   390: invokevirtual 239	java/io/FileInputStream:close	()V
    //   393: aload_1
    //   394: areturn
    //   395: aload_2
    //   396: ifnull +7 -> 403
    //   399: aload_2
    //   400: invokevirtual 238	java/io/BufferedInputStream:close	()V
    //   403: aload 7
    //   405: ifnull -170 -> 235
    //   408: aload 7
    //   410: invokevirtual 239	java/io/FileInputStream:close	()V
    //   413: goto -178 -> 235
    //   416: aload_2
    //   417: ifnull +7 -> 424
    //   420: aload_2
    //   421: invokevirtual 238	java/io/BufferedInputStream:close	()V
    //   424: aload 7
    //   426: ifnull +8 -> 434
    //   429: aload 7
    //   431: invokevirtual 239	java/io/FileInputStream:close	()V
    //   434: aload_1
    //   435: athrow
    //   436: aload 12
    //   438: aload 12
    //   440: aload_1
    //   441: getfield 286	com/tencent/image/DownloadParams:reqWidth	I
    //   444: aload_1
    //   445: getfield 289	com/tencent/image/DownloadParams:reqHeight	I
    //   448: invokestatic 294	bdsi:b	(Landroid/graphics/BitmapFactory$Options;II)I
    //   451: putfield 297	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   454: aload 12
    //   456: getfield 248	android/graphics/BitmapFactory$Options:outHeight	I
    //   459: aload 12
    //   461: getfield 251	android/graphics/BitmapFactory$Options:outWidth	I
    //   464: imul
    //   465: ldc_w 298
    //   468: if_icmple +55 -> 523
    //   471: ldc 170
    //   473: iconst_1
    //   474: new 172	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 300
    //   484: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 12
    //   489: getfield 248	android/graphics/BitmapFactory$Options:outHeight	I
    //   492: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 305
    //   498: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 12
    //   503: getfield 251	android/graphics/BitmapFactory$Options:outWidth	I
    //   506: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: ldc_w 307
    //   512: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aconst_null
    //   522: areturn
    //   523: aload 12
    //   525: getfield 251	android/graphics/BitmapFactory$Options:outWidth	I
    //   528: istore 4
    //   530: aload 12
    //   532: getfield 248	android/graphics/BitmapFactory$Options:outHeight	I
    //   535: istore 4
    //   537: aload 12
    //   539: iconst_0
    //   540: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   543: aconst_null
    //   544: astore_2
    //   545: aload 8
    //   547: astore_1
    //   548: iload_3
    //   549: iconst_3
    //   550: if_icmpgt +219 -> 769
    //   553: aload_2
    //   554: astore_1
    //   555: aload 11
    //   557: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   560: aload 12
    //   562: invokestatic 245	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   565: astore_2
    //   566: aload_2
    //   567: ifnonnull +177 -> 744
    //   570: aload_2
    //   571: astore_1
    //   572: new 64	java/lang/OutOfMemoryError
    //   575: dup
    //   576: new 172	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 312
    //   586: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 10
    //   591: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 314
    //   597: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: iload_3
    //   601: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: ldc_w 316
    //   607: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 11
    //   612: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   615: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokespecial 317	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   624: athrow
    //   625: astore_2
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 320	android/graphics/Bitmap:recycle	()V
    //   634: aload_2
    //   635: ifnull +151 -> 786
    //   638: aload_2
    //   639: invokevirtual 323	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   642: astore_2
    //   643: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +77 -> 723
    //   649: ldc 170
    //   651: iconst_2
    //   652: new 172	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 325
    //   662: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload_3
    //   666: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   669: ldc_w 327
    //   672: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload 12
    //   677: getfield 297	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   680: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   683: ldc_w 329
    //   686: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload 11
    //   691: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   694: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc 185
    //   699: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 10
    //   704: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc_w 331
    //   710: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload_2
    //   714: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: aload 12
    //   725: aload 12
    //   727: getfield 297	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   730: iconst_2
    //   731: imul
    //   732: putfield 297	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   735: iload_3
    //   736: iconst_1
    //   737: iadd
    //   738: istore_3
    //   739: aload_1
    //   740: astore_2
    //   741: goto -196 -> 545
    //   744: aload_2
    //   745: astore_1
    //   746: getstatic 336	android/os/Build$VERSION:SDK_INT	I
    //   749: bipush 11
    //   751: if_icmplt +16 -> 767
    //   754: aload_2
    //   755: astore_1
    //   756: aload_2
    //   757: invokestatic 342	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   760: istore 6
    //   762: iload 6
    //   764: ifeq +3 -> 767
    //   767: aload_2
    //   768: astore_1
    //   769: aload_1
    //   770: astore_2
    //   771: aload_1
    //   772: ifnonnull -750 -> 22
    //   775: new 253	java/io/IOException
    //   778: dup
    //   779: ldc_w 344
    //   782: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   785: athrow
    //   786: aconst_null
    //   787: astore_2
    //   788: goto -145 -> 643
    //   791: astore_1
    //   792: aconst_null
    //   793: astore_2
    //   794: goto -378 -> 416
    //   797: astore_1
    //   798: goto -382 -> 416
    //   801: astore_2
    //   802: aconst_null
    //   803: astore_2
    //   804: goto -409 -> 395
    //   807: astore 9
    //   809: goto -414 -> 395
    //   812: astore_2
    //   813: aconst_null
    //   814: astore_2
    //   815: aconst_null
    //   816: astore 7
    //   818: goto -423 -> 395
    //   821: astore_1
    //   822: aconst_null
    //   823: astore 7
    //   825: aconst_null
    //   826: astore_2
    //   827: goto -411 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	bduh
    //   0	830	1	paramDownloadParams	DownloadParams
    //   0	830	2	parambdui	bdui
    //   1	738	3	i	int
    //   208	328	4	j	int
    //   335	12	5	k	int
    //   760	3	6	bool	boolean
    //   6	818	7	localFileInputStream	java.io.FileInputStream
    //   3	543	8	localObject1	Object
    //   186	185	9	localObject2	Object
    //   807	1	9	localException	Exception
    //   12	691	10	str	String
    //   33	657	11	localFile	File
    //   110	616	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   35	50	100	java/lang/Exception
    //   53	98	100	java/lang/Exception
    //   103	159	100	java/lang/Exception
    //   221	225	100	java/lang/Exception
    //   230	235	100	java/lang/Exception
    //   235	268	100	java/lang/Exception
    //   268	278	100	java/lang/Exception
    //   377	381	100	java/lang/Exception
    //   388	393	100	java/lang/Exception
    //   399	403	100	java/lang/Exception
    //   408	413	100	java/lang/Exception
    //   420	424	100	java/lang/Exception
    //   429	434	100	java/lang/Exception
    //   434	436	100	java/lang/Exception
    //   436	521	100	java/lang/Exception
    //   523	543	100	java/lang/Exception
    //   555	566	100	java/lang/Exception
    //   572	625	100	java/lang/Exception
    //   630	634	100	java/lang/Exception
    //   638	643	100	java/lang/Exception
    //   643	723	100	java/lang/Exception
    //   723	735	100	java/lang/Exception
    //   746	754	100	java/lang/Exception
    //   756	762	100	java/lang/Exception
    //   775	786	100	java/lang/Exception
    //   555	566	625	java/lang/OutOfMemoryError
    //   572	625	625	java/lang/OutOfMemoryError
    //   746	754	625	java/lang/OutOfMemoryError
    //   756	762	625	java/lang/OutOfMemoryError
    //   173	183	791	finally
    //   183	195	797	finally
    //   278	337	797	finally
    //   353	370	797	finally
    //   173	183	801	java/lang/Exception
    //   183	195	807	java/lang/Exception
    //   278	337	807	java/lang/Exception
    //   353	370	807	java/lang/Exception
    //   159	173	812	java/lang/Exception
    //   159	173	821	finally
  }
  
  int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  public bdui a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      bdui localbdui = new bdui(this);
      localbdui.jdField_a_of_type_JavaLangString = paramURL[0];
      localbdui.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localbdui.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localbdui.jdField_a_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localbdui.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label172;
          }
          bool1 = true;
          label106:
          localbdui.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6)
        {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label177;
          }
          bool1 = true;
          label132:
          localbdui.c = bool1;
        }
        if (paramURL.length > 7) {
          if (Integer.parseInt(paramURL[7]) != 1) {
            break label182;
          }
        }
      }
      label172:
      label177:
      label182:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localbdui.d = bool1;
        return localbdui;
        bool1 = false;
        break;
        bool1 = false;
        break label106;
        bool1 = false;
        break label132;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if ((paramOutputStream == null) || (paramOutputStream.jdField_a_of_type_JavaLangString == null)) {
      return new File(anhk.aZ);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, bdui parambdui)
  {
    paramDownloadParams = parambdui.jdField_a_of_type_JavaLangString;
    if (paramDownloadParams == null) {
      paramDownloadParams = null;
    }
    for (;;)
    {
      return paramDownloadParams;
      File localFile = new File(paramDownloadParams);
      try
      {
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inPreferredConfig = bdzx.b;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramDownloadParams.inJustDecodeBounds = false;
        parambdui = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
        paramDownloadParams = parambdui;
        if (parambdui == null) {
          continue;
        }
        paramDownloadParams = a(parambdui);
        if (!parambdui.equals(paramDownloadParams.mBitmap)) {
          parambdui.recycle();
        }
        parambdui = new RoundRectBitmap(new beak(localFile.getAbsolutePath()).a(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        paramDownloadParams = parambdui;
        if (this.a == null) {
          continue;
        }
        parambdui.mDisplayWidth = this.a.getResources().getDisplayMetrics().widthPixels;
        parambdui.mDisplayHeight = this.a.getResources().getDisplayMetrics().heightPixels;
        return parambdui;
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = a(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      paramFile = null;
    }
    label107:
    do
    {
      int i;
      do
      {
        return paramFile;
        if (atvo.a(paramURLDrawableHandler.jdField_a_of_type_JavaLangString) == 2) {}
        for (i = 1;; i = 0)
        {
          if ((!paramURLDrawableHandler.jdField_a_of_type_Boolean) || (paramURLDrawableHandler.c) || (i != 0)) {
            break label107;
          }
          if (!paramURLDrawableHandler.d) {
            break;
          }
          return a(paramDownloadParams, paramURLDrawableHandler);
        }
        paramDownloadParams = (Bitmap)b(paramDownloadParams, paramURLDrawableHandler);
        paramFile = paramDownloadParams;
      } while (!paramURLDrawableHandler.jdField_b_of_type_Boolean);
      return atvo.a(this.a, paramDownloadParams, 16);
      if (paramURLDrawableHandler.c)
      {
        paramFile = atvg.a(this.a, paramURLDrawableHandler.jdField_a_of_type_JavaLangString);
        if (paramFile != null) {
          paramFile = a(paramFile);
        }
      }
      for (;;)
      {
        paramDownloadParams = paramFile;
        if (paramFile == null)
        {
          paramFile = BaseApplicationImpl.getContext();
          i = atvo.a(paramURLDrawableHandler.jdField_a_of_type_JavaLangString);
          paramDownloadParams = a(paramFile.getResources().getDrawable(atvo.a(i)));
        }
        if (paramDownloadParams != null) {
          break;
        }
        return null;
        paramFile = a(BaseApplicationImpl.getContext().getResources().getDrawable(2130844263));
        continue;
        paramFile = paramFile.getThumb(paramDownloadParams.url, new bduj(this));
      }
      paramFile = paramDownloadParams;
    } while (!paramURLDrawableHandler.jdField_b_of_type_Boolean);
    return atvo.a(this.a, paramDownloadParams, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduh
 * JD-Core Version:    0.7.0.1
 */