package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import bfvo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import psn;
import psp;
import psq;
import syg;
import syk;
import sym;
import syn;
import syo;
import syt;
import syv;
import uet;

public class RunningJob
  implements Runnable
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  DiskCache jdField_a_of_type_ComTencentMobileqqTransfileDiskCache;
  File jdField_a_of_type_JavaIoFile;
  Set<WeakReference<sym>> jdField_a_of_type_JavaUtilSet = new HashSet();
  syg jdField_a_of_type_Syg;
  syn jdField_a_of_type_Syn;
  public syo a;
  uet jdField_a_of_type_Uet;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + RunningJob.class.getSimpleName();
  }
  
  public RunningJob(syn paramsyn, syo paramsyo)
  {
    this.jdField_a_of_type_Syn = paramsyn;
    this.jdField_a_of_type_Syo = paramsyo;
    this.jdField_a_of_type_Syg = paramsyn.jdField_a_of_type_Syg;
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = new DiskCache(URLDrawableHelper.diskCachePath);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label66:
    do
    {
      do
      {
        return m;
        j = Math.min(paramOptions.outHeight, 2048);
        k = Math.min(paramOptions.outWidth, 2048);
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label66;
      n = m;
    }
  }
  
  /* Error */
  private Bitmap a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   6: instanceof 121
    //   9: ifeq +63 -> 72
    //   12: new 123	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   20: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   23: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getBytes	()[B
    //   26: invokespecial 130	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore 4
    //   31: new 123	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_0
    //   36: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   39: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   42: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getBytes	()[B
    //   45: invokespecial 130	java/io/ByteArrayInputStream:<init>	([B)V
    //   48: astore 5
    //   50: aload_0
    //   51: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   54: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   57: invokevirtual 133	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getLength	()J
    //   60: lstore_2
    //   61: aload_0
    //   62: aload 4
    //   64: aload 5
    //   66: lload_2
    //   67: iload_1
    //   68: invokevirtual 136	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;Ljava/io/InputStream;JZ)Landroid/graphics/Bitmap;
    //   71: areturn
    //   72: new 138	java/io/FileInputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   80: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: astore 4
    //   85: new 138	java/io/FileInputStream
    //   88: dup
    //   89: aload_0
    //   90: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   93: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore 5
    //   98: aload_0
    //   99: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   102: invokevirtual 144	java/io/File:length	()J
    //   105: lstore_2
    //   106: aload_0
    //   107: invokevirtual 147	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()Z
    //   110: istore_1
    //   111: goto -50 -> 61
    //   114: astore 4
    //   116: new 149	java/lang/RuntimeException
    //   119: dup
    //   120: new 23	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   127: ldc 151
    //   129: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 4
    //   134: invokevirtual 152	java/lang/Exception:toString	()Ljava/lang/String;
    //   137: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	RunningJob
    //   1	110	1	bool	boolean
    //   60	46	2	l	long
    //   29	55	4	localObject1	Object
    //   114	19	4	localException	Exception
    //   48	49	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	61	114	java/lang/Exception
    //   61	72	114	java/lang/Exception
    //   72	111	114	java/lang/Exception
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.jdField_a_of_type_Syo.jdField_c_of_type_Int == 1) {
      localBitmap = bfvo.c(paramBitmap, this.jdField_a_of_type_Syo.jdField_a_of_type_Int, this.jdField_a_of_type_Syo.jdField_b_of_type_Int);
    }
    return localBitmap;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  private Bitmap a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 4
    //   8: astore 5
    //   10: iload_1
    //   11: ifeq +299 -> 310
    //   14: aload 4
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   22: ifnull +288 -> 310
    //   25: aload 4
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syo	Lsyo;
    //   33: ifnull +277 -> 310
    //   36: aload 4
    //   38: astore 5
    //   40: getstatic 179	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 19
    //   45: if_icmplt +265 -> 310
    //   48: getstatic 184	psq:a	Lpsq;
    //   51: aload_0
    //   52: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokevirtual 187	java/io/File:getPath	()Ljava/lang/String;
    //   58: invokevirtual 190	psq:a	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   61: astore 5
    //   63: aload 6
    //   65: astore 4
    //   67: aload 5
    //   69: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: iconst_m1
    //   73: if_icmpeq +215 -> 288
    //   76: aload 6
    //   78: astore 4
    //   80: aload 5
    //   82: getfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: iconst_m1
    //   86: if_icmpeq +202 -> 288
    //   89: aload 5
    //   91: aload_0
    //   92: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syo	Lsyo;
    //   95: getfield 162	syo:jdField_a_of_type_Int	I
    //   98: aload_0
    //   99: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syo	Lsyo;
    //   102: getfield 165	syo:jdField_b_of_type_Int	I
    //   105: invokestatic 192	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   108: istore_3
    //   109: aload 5
    //   111: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   114: iload_3
    //   115: idiv
    //   116: istore_2
    //   117: aload 5
    //   119: getfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   122: iload_3
    //   123: idiv
    //   124: istore_3
    //   125: aload 5
    //   127: iload_2
    //   128: putfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   131: aload 5
    //   133: iload_3
    //   134: putfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   137: aload 5
    //   139: iconst_1
    //   140: putfield 195	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   143: aload 5
    //   145: iconst_1
    //   146: putfield 199	android/graphics/BitmapFactory$Options:inMutable	Z
    //   149: aload_0
    //   150: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   153: aload 5
    //   155: invokevirtual 204	syg:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +74 -> 236
    //   165: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: iconst_2
    //   169: new 23	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   176: ldc 206
    //   178: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 6
    //   183: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   186: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc 217
    //   191: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 6
    //   196: invokevirtual 220	android/graphics/Bitmap:getHeight	()I
    //   199: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 222
    //   204: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_2
    //   208: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 217
    //   213: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_3
    //   217: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload 6
    //   228: iload_2
    //   229: iload_3
    //   230: getstatic 234	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   233: invokevirtual 238	android/graphics/Bitmap:reconfigure	(IILandroid/graphics/Bitmap$Config;)V
    //   236: getstatic 184	psq:a	Lpsq;
    //   239: aload_0
    //   240: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   243: invokevirtual 187	java/io/File:getPath	()Ljava/lang/String;
    //   246: iload_2
    //   247: iload_3
    //   248: aload 6
    //   250: invokevirtual 241	psq:a	(Ljava/lang/String;IILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   253: astore 5
    //   255: aload 5
    //   257: astore 4
    //   259: aload 6
    //   261: ifnull +27 -> 288
    //   264: aload 5
    //   266: astore 4
    //   268: aload 5
    //   270: aload 6
    //   272: if_acmpeq +16 -> 288
    //   275: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   278: iconst_2
    //   279: ldc 243
    //   281: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 5
    //   286: astore 4
    //   288: aload 4
    //   290: astore 5
    //   292: aload 4
    //   294: ifnonnull +16 -> 310
    //   297: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   300: iconst_1
    //   301: ldc 245
    //   303: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 4
    //   308: astore 5
    //   310: aload 5
    //   312: areturn
    //   313: astore 5
    //   315: aconst_null
    //   316: astore 4
    //   318: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: iconst_1
    //   322: aload 5
    //   324: invokevirtual 248	java/lang/Error:getMessage	()Ljava/lang/String;
    //   327: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto -42 -> 288
    //   333: astore 6
    //   335: aload 5
    //   337: astore 4
    //   339: aload 6
    //   341: astore 5
    //   343: goto -25 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	RunningJob
    //   0	346	1	paramBoolean	boolean
    //   116	131	2	i	int
    //   108	140	3	j	int
    //   1	337	4	localObject1	Object
    //   8	303	5	localObject2	Object
    //   313	23	5	localError1	java.lang.Error
    //   341	1	5	localError2	java.lang.Error
    //   4	267	6	localBitmap	Bitmap
    //   333	7	6	localError3	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   48	63	313	java/lang/Error
    //   67	76	313	java/lang/Error
    //   80	160	313	java/lang/Error
    //   165	236	313	java/lang/Error
    //   236	255	313	java/lang/Error
    //   275	284	333	java/lang/Error
  }
  
  @TargetApi(11)
  private BitmapFactory.Options a(InputStream paramInputStream)
  {
    byte[] arrayOfByte1 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      if (this.jdField_a_of_type_Syg.jdField_a_of_type_JavaUtilList.size() > 0) {
        arrayOfByte1 = (byte[])this.jdField_a_of_type_Syg.jdField_a_of_type_JavaUtilList.remove(0);
      }
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte1 = new byte[16384];
        arrayOfByte2 = arrayOfByte1;
        if (QLog.isColorLevel())
        {
          syv.a(jdField_a_of_type_JavaLangString, "allocate temp storage");
          arrayOfByte2 = arrayOfByte1;
        }
      }
      localOptions.inTempStorage = arrayOfByte2;
      localOptions.inJustDecodeBounds = true;
      localOptions.inJustDecodeBounds = false;
    }
    finally
    {
      try
      {
        BitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, localOptions);
        if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
          break label184;
        }
        throw new IllegalArgumentException("decode bounds fail");
      }
      catch (OutOfMemoryError paramInputStream)
      {
        this.jdField_a_of_type_Syg.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      catch (Exception paramInputStream)
      {
        this.jdField_a_of_type_Syg.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      paramInputStream = finally;
    }
    label184:
    localOptions.inDither = true;
    localOptions.inPreferredConfig = this.jdField_a_of_type_Syo.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_Syo.jdField_a_of_type_Int, this.jdField_a_of_type_Syo.jdField_b_of_type_Int);
    return localOptions;
  }
  
  private Rect a(BitmapFactory.Options paramOptions)
  {
    int i = Math.min(paramOptions.outWidth, 2048);
    int j = Math.min(paramOptions.outHeight, 2048);
    int k = (paramOptions.outWidth - i) / 2;
    int m = (paramOptions.outHeight - j) / 2;
    return new Rect(k, m, i + k, j + m);
  }
  
  @NotNull
  private DownloadParams a()
  {
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL;
    localDownloadParams.urlStr = this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL.toString();
    localDownloadParams.retryCount = this.jdField_a_of_type_Syo.jdField_f_of_type_Int;
    return localDownloadParams;
  }
  
  private File a(DownloadParams paramDownloadParams, StringBuilder paramStringBuilder)
  {
    return this.jdField_a_of_type_Uet.loadImageFile(paramDownloadParams, new syt(this, paramStringBuilder));
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Syo != null) {
      this.jdField_a_of_type_Syo.jdField_e_of_type_Long = paramLong;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Syn.a(this.jdField_a_of_type_Syo);
    paramBitmap = new syk(a(paramBitmap), this.jdField_a_of_type_Syg.jdField_a_of_type_Sys);
    this.jdField_a_of_type_Syg.a(this.jdField_a_of_type_Syo, paramBitmap);
    if (this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean)
    {
      psp.a(6, this.jdField_a_of_type_Syo);
      psp.a(this.jdField_a_of_type_Syo, false, "cancelled");
      paramBitmap.a();
      return;
    }
    psp.a(5, this.jdField_a_of_type_Syo);
    if (psn.a.c())
    {
      this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new RunningJob.2(this, paramBitmap));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.3(this, paramBitmap));
  }
  
  private void a(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Syo != null)
    {
      this.jdField_a_of_type_Syo.jdField_f_of_type_Long = paramLong2;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[decode success](" + paramLong2 + ") total(" + (paramLong1 - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_Syo + "; size =" + paramBitmap.getByteCount());
    }
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramBitmap);
      return;
    }
    d(new RuntimeException("bitmap null"));
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (c(paramThrowable))
      {
        a(paramThrowable, -3);
        return;
      }
      if (b(paramThrowable))
      {
        c(paramThrowable);
        return;
      }
    }
    catch (Exception paramThrowable)
    {
      d(paramThrowable);
      return;
    }
    if (a(paramThrowable))
    {
      b(paramThrowable);
      return;
    }
    d(paramThrowable);
  }
  
  private void a(Throwable paramThrowable, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "[job fail] failCode:" + paramInt + this.jdField_a_of_type_Syo + " " + paramThrowable + " retryCount:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Syo.jdField_e_of_type_Int == -2) {
      this.jdField_a_of_type_Syo.jdField_e_of_type_Int = paramInt;
    }
    this.jdField_a_of_type_Syn.a(this.jdField_a_of_type_Syo);
    if (this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean)
    {
      psp.a(6, this.jdField_a_of_type_Syo);
      psp.a(this.jdField_a_of_type_Syo, false, "cancelled");
    }
    for (;;)
    {
      return;
      Object localObject2;
      if (this.jdField_a_of_type_Syo.jdField_f_of_type_Int == syo.g)
      {
        localObject2 = this.jdField_a_of_type_Syo;
        if (paramThrowable == null) {
          break label166;
        }
      }
      label166:
      for (Object localObject1 = paramThrowable.getMessage();; localObject1 = "")
      {
        psp.a((syo)localObject2, false, (String)localObject1);
        if (!e()) {
          break;
        }
        e(paramThrowable);
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (((WeakReference)localObject2).get() != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.4(this, (WeakReference)localObject2, paramThrowable));
        }
      }
    }
  }
  
  private void a(syk paramsyk)
  {
    if (this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean)
    {
      psp.a(6, this.jdField_a_of_type_Syo);
      psp.a(this.jdField_a_of_type_Syo, false, "cancelled");
      paramsyk.a();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((sym)localWeakReference.get()).a(this.jdField_a_of_type_Syo, paramsyk.a());
      }
    }
    paramsyk.a();
  }
  
  private static void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("showUseTime", Long.toString(paramLong));
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("cached", str);
      if (!paramBoolean2) {
        break label96;
      }
    }
    label96:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("success", str);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
      return;
      str = "2";
      break;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Bitmap localBitmap = a();
    long l = System.currentTimeMillis();
    paramLong1 = l - paramLong1;
    a(localBitmap, l, paramLong1);
    boolean bool;
    if (localBitmap != null)
    {
      bool = true;
      if ((!bool) || (localBitmap == null)) {
        break label77;
      }
    }
    label77:
    for (int i = localBitmap.getByteCount();; i = 0)
    {
      a(paramBoolean, paramLong1 + paramLong2, i, bool);
      a(localBitmap, bool);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    return (paramThrowable.getMessage() != null) && ((((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage().contains("decode fail"))) || (((paramThrowable instanceof IOException)) && (paramThrowable.getMessage().contains("write 0 length file or null File"))));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean) {
      throw new RuntimeException("cancel");
    }
  }
  
  private void b(Throwable paramThrowable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, paramThrowable.getMessage() + " " + this.jdField_a_of_type_Syo + " retryCount:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_JavaIoFile != null) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      run();
      return;
    }
    a(paramThrowable, -3);
  }
  
  private boolean b()
  {
    for (;;)
    {
      try
      {
        if (d()) {
          return true;
        }
        this.jdField_a_of_type_Uet = new uet(BaseApplicationImpl.getApplication());
        Object localObject = a();
        boolean bool = this.jdField_a_of_type_Uet.hasDiskFile((DownloadParams)localObject);
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_JavaIoFile = a((DownloadParams)localObject, new StringBuilder());
        c();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        a(l3);
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("[download success](").append(l3).append(")").append(this.jdField_a_of_type_Syo).append(" fileSize:");
        if (this.jdField_a_of_type_JavaIoFile == null) {
          continue;
        }
        l1 = this.jdField_a_of_type_JavaIoFile.length();
        QLog.d((String)localObject, 2, l1);
        b();
        if (c()) {
          break label193;
        }
        a(bool, l2, l3);
      }
      catch (Throwable localThrowable)
      {
        long l1;
        a(localThrowable);
        continue;
      }
      return false;
      l1 = 0L;
    }
    label193:
    return true;
  }
  
  private boolean b(Throwable paramThrowable)
  {
    return (((paramThrowable instanceof RuntimeException)) || ((paramThrowable instanceof IOException))) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("cancel"));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaIoFile == null) {
      throw new IOException("downloader fail");
    }
  }
  
  private void c(Throwable paramThrowable)
  {
    psp.a(6, this.jdField_a_of_type_Syo);
    psp.a(this.jdField_a_of_type_Syo, false, paramThrowable.getMessage());
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_Syo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      this.jdField_a_of_type_Syn.a(this.jdField_a_of_type_Syo);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[preload request]" + this.jdField_a_of_type_Syo + " no callback, give up decode");
      syn.a().c(this.jdField_a_of_type_Syo);
      return true;
    }
    return false;
  }
  
  private boolean c(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Syo.d == 0) {
      psp.b(2, this.jdField_a_of_type_Syo);
    }
  }
  
  private void d(Throwable paramThrowable)
  {
    a(paramThrowable, -1);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean)
    {
      psp.a(6, this.jdField_a_of_type_Syo);
      syn.a().c(this.jdField_a_of_type_Syo);
      return true;
    }
    return false;
  }
  
  private void e(Throwable paramThrowable)
  {
    syo localsyo = this.jdField_a_of_type_Syo;
    localsyo.jdField_f_of_type_Int += 1;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "try count: " + this.jdField_a_of_type_Syo.jdField_f_of_type_Int + " " + this.jdField_a_of_type_Syo);
    if (((paramThrowable != null) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"))) || (this.jdField_a_of_type_Syo.jdField_e_of_type_Int == 400)) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "before convert: " + this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL);
    }
    try
    {
      this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL = new URL(psq.a.b(this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL.toString(), this.jdField_a_of_type_Syo.jdField_c_of_type_JavaLangString));
      QLog.d(jdField_a_of_type_JavaLangString, 1, "after convert: " + this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL);
      ThreadManager.getUIHandler().post(new RunningJob.5(this));
      return;
    }
    catch (Exception paramThrowable)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramThrowable.getMessage());
      }
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_Syo.jdField_f_of_type_Int < syo.g;
  }
  
  public Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    if (syv.a()) {
      return b(paramInputStream1, paramInputStream2, paramLong);
    }
    return c(paramInputStream1, paramInputStream2, paramLong);
  }
  
  protected Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong, boolean paramBoolean)
  {
    Bitmap localBitmap2 = a(paramBoolean);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = a(paramInputStream1, paramInputStream2, paramLong);
    }
    return localBitmap1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      syv.a(jdField_a_of_type_JavaLangString, "[cancel request]" + this.jdField_a_of_type_Syo);
    }
    this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Uet != null) {
      this.jdField_a_of_type_Uet.cancel();
    }
  }
  
  public void a(sym paramsym)
  {
    if (paramsym != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramsym));
      return;
    }
    finally
    {
      paramsym = finally;
      throw paramsym;
    }
  }
  
  protected boolean a()
  {
    try
    {
      if ((AVSoUtils.a()) && (psn.a.g()))
      {
        psq localpsq = psq.a;
        if (this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL != null) {}
        for (String str = this.jdField_a_of_type_Syo.jdField_a_of_type_JavaNetURL.toString(); (localpsq.a(str)) && (SharpPUtil.isSharpPFile(this.jdField_a_of_type_JavaIoFile)); str = "") {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
    return false;
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 705	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_2
    //   6: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +45 -> 54
    //   12: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: new 23	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 707
    //   25: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syo	Lsyo;
    //   32: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc_w 709
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: getfield 195	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 280	syv:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   58: aload_2
    //   59: invokevirtual 204	syg:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnull +121 -> 187
    //   69: aload_2
    //   70: aload 6
    //   72: putfield 713	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   75: iconst_1
    //   76: istore 5
    //   78: new 288	java/io/BufferedInputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_1
    //   87: aload_2
    //   88: invokestatic 716	syv:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   91: ifeq +58 -> 149
    //   94: aload_1
    //   95: iconst_0
    //   96: invokestatic 722	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 724	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   104: aload_2
    //   105: invokevirtual 728	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   113: getfield 259	syg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   116: aload_2
    //   117: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   120: invokeinterface 306 2 0
    //   125: pop
    //   126: iload 5
    //   128: ifeq +57 -> 185
    //   131: aload 6
    //   133: aload_1
    //   134: if_acmpeq +51 -> 185
    //   137: aload_1
    //   138: invokevirtual 731	android/graphics/Bitmap:recycle	()V
    //   141: new 733	java/lang/IllegalStateException
    //   144: dup
    //   145: invokespecial 734	java/lang/IllegalStateException:<init>	()V
    //   148: athrow
    //   149: aload_1
    //   150: aconst_null
    //   151: aload_2
    //   152: invokestatic 297	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   155: astore_1
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   167: getfield 259	syg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   170: aload_2
    //   171: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   174: invokeinterface 306 2 0
    //   179: pop
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: athrow
    //   185: aload_1
    //   186: areturn
    //   187: iconst_0
    //   188: istore 5
    //   190: goto -112 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	RunningJob
    //   0	193	1	paramInputStream1	InputStream
    //   0	193	2	paramInputStream2	InputStream
    //   0	193	3	paramLong	long
    //   76	113	5	i	int
    //   62	70	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   78	109	159	java/lang/OutOfMemoryError
    //   149	156	159	java/lang/OutOfMemoryError
    //   78	109	162	finally
    //   149	156	162	finally
    //   160	162	162	finally
    //   183	185	162	finally
    //   78	109	182	java/lang/RuntimeException
    //   149	156	182	java/lang/RuntimeException
  }
  
  /* Error */
  public Bitmap c(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 9
    //   18: aload_0
    //   19: aload_2
    //   20: invokespecial 705	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   23: astore 13
    //   25: aload 13
    //   27: getstatic 737	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   30: putfield 740	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   33: lload_3
    //   34: l2i
    //   35: istore 5
    //   37: new 288	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 12
    //   52: astore_1
    //   53: aload 11
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   61: getfield 743	syg:jdField_a_of_type_Syi	Lsyi;
    //   64: iload 5
    //   66: invokevirtual 748	syi:a	(I)[B
    //   69: astore 9
    //   71: aload 6
    //   73: astore_2
    //   74: aload 9
    //   76: astore_1
    //   77: aload 9
    //   79: astore 7
    //   81: aload 9
    //   83: astore 8
    //   85: aload 6
    //   87: aload 9
    //   89: iconst_0
    //   90: iload 5
    //   92: invokevirtual 754	java/io/InputStream:read	([BII)I
    //   95: pop
    //   96: aload 6
    //   98: astore_2
    //   99: aload 9
    //   101: astore_1
    //   102: aload 9
    //   104: astore 7
    //   106: aload 9
    //   108: astore 8
    //   110: aload 13
    //   112: invokestatic 716	syv:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   115: ifeq +126 -> 241
    //   118: aload 6
    //   120: astore_2
    //   121: aload 9
    //   123: astore_1
    //   124: aload 9
    //   126: astore 7
    //   128: aload 9
    //   130: astore 8
    //   132: aload 9
    //   134: iconst_0
    //   135: iload 5
    //   137: iconst_0
    //   138: invokestatic 757	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   141: aload_0
    //   142: aload 13
    //   144: invokespecial 724	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   147: aload 13
    //   149: invokevirtual 728	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore 10
    //   154: aload 6
    //   156: astore_2
    //   157: aload 9
    //   159: astore_1
    //   160: aload 9
    //   162: astore 7
    //   164: aload 9
    //   166: astore 8
    //   168: getstatic 737	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   171: ifeq +22 -> 193
    //   174: aload 6
    //   176: astore_2
    //   177: aload 9
    //   179: astore_1
    //   180: aload 9
    //   182: astore 7
    //   184: aload 9
    //   186: astore 8
    //   188: aload 10
    //   190: invokestatic 760	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   193: aload 9
    //   195: ifnull +15 -> 210
    //   198: aload_0
    //   199: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   202: getfield 743	syg:jdField_a_of_type_Syi	Lsyi;
    //   205: aload 9
    //   207: invokevirtual 762	syi:a	([B)V
    //   210: aload_0
    //   211: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   214: getfield 259	syg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   217: aload 13
    //   219: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   222: invokeinterface 306 2 0
    //   227: pop
    //   228: aload 6
    //   230: ifnull +8 -> 238
    //   233: aload 6
    //   235: invokevirtual 765	java/io/InputStream:close	()V
    //   238: aload 10
    //   240: areturn
    //   241: aload 6
    //   243: astore_2
    //   244: aload 9
    //   246: astore_1
    //   247: aload 9
    //   249: astore 7
    //   251: aload 9
    //   253: astore 8
    //   255: aload 9
    //   257: iconst_0
    //   258: iload 5
    //   260: aload 13
    //   262: invokestatic 769	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   265: astore 10
    //   267: goto -113 -> 154
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 772	java/io/IOException:printStackTrace	()V
    //   275: aload 10
    //   277: areturn
    //   278: astore 7
    //   280: aconst_null
    //   281: astore_2
    //   282: aload 9
    //   284: astore_1
    //   285: aload 7
    //   287: athrow
    //   288: astore 7
    //   290: aload_1
    //   291: astore 6
    //   293: aload 7
    //   295: astore_1
    //   296: aload 6
    //   298: ifnull +15 -> 313
    //   301: aload_0
    //   302: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   305: getfield 743	syg:jdField_a_of_type_Syi	Lsyi;
    //   308: aload 6
    //   310: invokevirtual 762	syi:a	([B)V
    //   313: aload_0
    //   314: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Syg	Lsyg;
    //   317: getfield 259	syg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   320: aload 13
    //   322: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   325: invokeinterface 306 2 0
    //   330: pop
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 765	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: athrow
    //   341: astore 8
    //   343: aconst_null
    //   344: astore_2
    //   345: aload 10
    //   347: astore_1
    //   348: aload 8
    //   350: athrow
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 772	java/io/IOException:printStackTrace	()V
    //   356: goto -17 -> 339
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_2
    //   362: aload 7
    //   364: astore 6
    //   366: goto -70 -> 296
    //   369: astore 8
    //   371: aload 6
    //   373: astore_2
    //   374: aload 7
    //   376: astore_1
    //   377: goto -29 -> 348
    //   380: astore 7
    //   382: aload 6
    //   384: astore_2
    //   385: aload 8
    //   387: astore_1
    //   388: goto -103 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	RunningJob
    //   0	391	1	paramInputStream1	InputStream
    //   0	391	2	paramInputStream2	InputStream
    //   0	391	3	paramLong	long
    //   35	224	5	i	int
    //   45	338	6	localObject1	Object
    //   4	246	7	localObject2	Object
    //   278	8	7	localOutOfMemoryError1	OutOfMemoryError
    //   288	87	7	localObject3	Object
    //   380	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   13	241	8	localObject4	Object
    //   341	8	8	localException1	Exception
    //   369	17	8	localException2	Exception
    //   16	267	9	arrayOfByte	byte[]
    //   7	339	10	localBitmap	Bitmap
    //   10	44	11	localObject5	Object
    //   1	50	12	localObject6	Object
    //   23	298	13	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   233	238	270	java/io/IOException
    //   37	47	278	java/lang/OutOfMemoryError
    //   57	71	288	finally
    //   85	96	288	finally
    //   110	118	288	finally
    //   132	154	288	finally
    //   168	174	288	finally
    //   188	193	288	finally
    //   255	267	288	finally
    //   285	288	288	finally
    //   348	351	288	finally
    //   37	47	341	java/lang/Exception
    //   335	339	351	java/io/IOException
    //   37	47	359	finally
    //   57	71	369	java/lang/Exception
    //   85	96	369	java/lang/Exception
    //   110	118	369	java/lang/Exception
    //   132	154	369	java/lang/Exception
    //   168	174	369	java/lang/Exception
    //   188	193	369	java/lang/Exception
    //   255	267	369	java/lang/Exception
    //   57	71	380	java/lang/OutOfMemoryError
    //   85	96	380	java/lang/OutOfMemoryError
    //   110	118	380	java/lang/OutOfMemoryError
    //   132	154	380	java/lang/OutOfMemoryError
    //   168	174	380	java/lang/OutOfMemoryError
    //   188	193	380	java/lang/OutOfMemoryError
    //   255	267	380	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public void run()
  {
    psp.a(4, this.jdField_a_of_type_Syo);
    syn.a().b(this.jdField_a_of_type_Syo);
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[start request](" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_Syo + " createTs:" + this.jdField_a_of_type_Long);
    if (b()) {
      return;
    }
    syn.a().c(this.jdField_a_of_type_Syo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob
 * JD-Core Version:    0.7.0.1
 */