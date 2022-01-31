package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mub;
import muj;
import muk;
import mul;

public class RunningJob
  implements Runnable
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  ImageManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager;
  public ImageRequest a;
  PubAccountHttpDownloader jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader;
  DiskCache jdField_a_of_type_ComTencentMobileqqTransfileDiskCache;
  File jdField_a_of_type_JavaIoFile;
  public Set a;
  mub jdField_a_of_type_Mub;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + RunningJob.class.getSimpleName();
  }
  
  public RunningJob(ImageManager paramImageManager, ImageRequest paramImageRequest)
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager = paramImageManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = paramImageRequest;
    this.jdField_a_of_type_Mub = paramImageManager.jdField_a_of_type_Mub;
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = new DiskCache(URLDrawableHelper.jdField_a_of_type_JavaIoFile);
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
  
  @TargetApi(11)
  private BitmapFactory.Options a(File paramFile)
  {
    byte[] arrayOfByte1 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      if (this.jdField_a_of_type_Mub.jdField_a_of_type_JavaUtilList.size() > 0) {
        arrayOfByte1 = (byte[])this.jdField_a_of_type_Mub.jdField_a_of_type_JavaUtilList.remove(0);
      }
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte1 = new byte[16384];
        arrayOfByte2 = arrayOfByte1;
        if (QLog.isColorLevel())
        {
          Utils.a(jdField_a_of_type_JavaLangString, "allocate temp storage");
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
        BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramFile)), null, localOptions);
        if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
          break label189;
        }
        throw new IllegalArgumentException("decode bounds fail");
      }
      catch (OutOfMemoryError paramFile)
      {
        this.jdField_a_of_type_Mub.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramFile;
      }
      catch (Exception paramFile)
      {
        this.jdField_a_of_type_Mub.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramFile;
      }
      paramFile = finally;
    }
    label189:
    localOptions.inDither = true;
    localOptions.inPreferredConfig = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.b);
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
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    paramBitmap = new CloseableBitmap(paramBitmap, this.jdField_a_of_type_Mub.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser);
    this.jdField_a_of_type_Mub.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, paramBitmap);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new muk(this, paramBitmap));
  }
  
  private void a(Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new mul(this, localWeakReference, paramThrowable));
        }
      }
    }
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
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
      return;
      str = "2";
      break;
    }
  }
  
  public Bitmap a(File paramFile)
  {
    if (Utils.a()) {
      return b(paramFile);
    }
    return c(paramFile);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      Utils.a(jdField_a_of_type_JavaLangString, "[cancel request]" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader.a();
    }
  }
  
  public void a(IBitmapCallback paramIBitmapCallback)
  {
    if (paramIBitmapCallback != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramIBitmapCallback));
      return;
    }
    finally
    {
      paramIBitmapCallback = finally;
      throw paramIBitmapCallback;
    }
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 342	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_3
    //   6: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +45 -> 54
    //   12: getstatic 42	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: new 22	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 344
    //   25: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 69	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;
    //   32: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc_w 346
    //   38: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: getfield 211	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 151	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   58: aload_3
    //   59: invokevirtual 352	mub:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +126 -> 192
    //   69: aload_3
    //   70: aload 4
    //   72: putfield 356	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   75: iconst_1
    //   76: istore_2
    //   77: new 160	java/io/BufferedInputStream
    //   80: dup
    //   81: new 162	java/io/FileInputStream
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore_1
    //   93: aload_3
    //   94: invokestatic 359	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   97: ifeq +57 -> 154
    //   100: aload_1
    //   101: iconst_0
    //   102: invokestatic 365	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   105: aload_0
    //   106: aload_3
    //   107: invokespecial 367	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   110: aload_3
    //   111: invokevirtual 371	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   119: getfield 126	mub:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   122: aload_3
    //   123: getfield 154	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   126: invokeinterface 183 2 0
    //   131: pop
    //   132: iload_2
    //   133: ifeq +57 -> 190
    //   136: aload 4
    //   138: aload_1
    //   139: if_acmpeq +51 -> 190
    //   142: aload_1
    //   143: invokevirtual 376	android/graphics/Bitmap:recycle	()V
    //   146: new 378	java/lang/IllegalStateException
    //   149: dup
    //   150: invokespecial 379	java/lang/IllegalStateException:<init>	()V
    //   153: athrow
    //   154: aload_1
    //   155: aconst_null
    //   156: aload_3
    //   157: invokestatic 172	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore_1
    //   161: goto -46 -> 115
    //   164: astore_1
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: aload_0
    //   169: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   172: getfield 126	mub:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   175: aload_3
    //   176: getfield 154	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   179: invokeinterface 183 2 0
    //   184: pop
    //   185: aload_1
    //   186: athrow
    //   187: astore_1
    //   188: aload_1
    //   189: athrow
    //   190: aload_1
    //   191: areturn
    //   192: iconst_0
    //   193: istore_2
    //   194: goto -117 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	RunningJob
    //   0	197	1	paramFile	File
    //   76	118	2	i	int
    //   5	171	3	localOptions	BitmapFactory.Options
    //   62	75	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   77	115	164	java/lang/OutOfMemoryError
    //   154	161	164	java/lang/OutOfMemoryError
    //   77	115	167	finally
    //   154	161	167	finally
    //   165	167	167	finally
    //   188	190	167	finally
    //   77	115	187	java/lang/RuntimeException
    //   154	161	187	java/lang/RuntimeException
  }
  
  /* Error */
  public Bitmap c(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore_3
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 342	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   22: astore 10
    //   24: aload 10
    //   26: getstatic 384	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   29: putfield 387	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   32: aload_1
    //   33: invokevirtual 392	java/io/File:length	()J
    //   36: l2i
    //   37: istore_2
    //   38: new 160	java/io/BufferedInputStream
    //   41: dup
    //   42: new 162	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore 4
    //   55: aload 4
    //   57: astore_3
    //   58: aload 9
    //   60: astore_1
    //   61: aload 8
    //   63: astore 5
    //   65: aload_0
    //   66: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   69: getfield 395	mub:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool;
    //   72: iload_2
    //   73: invokevirtual 400	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:a	(I)[B
    //   76: astore 7
    //   78: aload 4
    //   80: astore_3
    //   81: aload 7
    //   83: astore_1
    //   84: aload 7
    //   86: astore 5
    //   88: aload 7
    //   90: astore 6
    //   92: aload 4
    //   94: aload 7
    //   96: iconst_0
    //   97: iload_2
    //   98: invokevirtual 406	java/io/InputStream:read	([BII)I
    //   101: pop
    //   102: aload 4
    //   104: astore_3
    //   105: aload 7
    //   107: astore_1
    //   108: aload 7
    //   110: astore 5
    //   112: aload 7
    //   114: astore 6
    //   116: aload 10
    //   118: invokestatic 359	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   121: ifeq +125 -> 246
    //   124: aload 4
    //   126: astore_3
    //   127: aload 7
    //   129: astore_1
    //   130: aload 7
    //   132: astore 5
    //   134: aload 7
    //   136: astore 6
    //   138: aload 7
    //   140: iconst_0
    //   141: iload_2
    //   142: iconst_0
    //   143: invokestatic 409	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   146: aload_0
    //   147: aload 10
    //   149: invokespecial 367	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   152: aload 10
    //   154: invokevirtual 371	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   157: astore 8
    //   159: aload 4
    //   161: astore_3
    //   162: aload 7
    //   164: astore_1
    //   165: aload 7
    //   167: astore 5
    //   169: aload 7
    //   171: astore 6
    //   173: getstatic 384	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   176: ifeq +22 -> 198
    //   179: aload 4
    //   181: astore_3
    //   182: aload 7
    //   184: astore_1
    //   185: aload 7
    //   187: astore 5
    //   189: aload 7
    //   191: astore 6
    //   193: aload 8
    //   195: invokestatic 412	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   198: aload 7
    //   200: ifnull +15 -> 215
    //   203: aload_0
    //   204: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   207: getfield 395	mub:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool;
    //   210: aload 7
    //   212: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:a	([B)V
    //   215: aload_0
    //   216: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   219: getfield 126	mub:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   222: aload 10
    //   224: getfield 154	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   227: invokeinterface 183 2 0
    //   232: pop
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 418	java/io/InputStream:close	()V
    //   243: aload 8
    //   245: areturn
    //   246: aload 4
    //   248: astore_3
    //   249: aload 7
    //   251: astore_1
    //   252: aload 7
    //   254: astore 5
    //   256: aload 7
    //   258: astore 6
    //   260: aload 7
    //   262: iconst_0
    //   263: iload_2
    //   264: aload 10
    //   266: invokestatic 422	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   269: astore 8
    //   271: goto -112 -> 159
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   279: aload 8
    //   281: areturn
    //   282: astore 5
    //   284: aconst_null
    //   285: astore 4
    //   287: aload_3
    //   288: astore_1
    //   289: aload 4
    //   291: astore_3
    //   292: aload 5
    //   294: athrow
    //   295: astore 5
    //   297: aload_1
    //   298: astore 4
    //   300: aload 5
    //   302: astore_1
    //   303: aload 4
    //   305: ifnull +15 -> 320
    //   308: aload_0
    //   309: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   312: getfield 395	mub:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool;
    //   315: aload 4
    //   317: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:a	([B)V
    //   320: aload_0
    //   321: getfield 74	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Mub	Lmub;
    //   324: getfield 126	mub:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   327: aload 10
    //   329: getfield 154	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   332: invokeinterface 183 2 0
    //   337: pop
    //   338: aload_3
    //   339: ifnull +7 -> 346
    //   342: aload_3
    //   343: invokevirtual 418	java/io/InputStream:close	()V
    //   346: aload_1
    //   347: athrow
    //   348: astore 6
    //   350: aconst_null
    //   351: astore_3
    //   352: aload 7
    //   354: astore_1
    //   355: aload 6
    //   357: athrow
    //   358: astore_3
    //   359: aload_3
    //   360: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   363: goto -17 -> 346
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_3
    //   369: aload 5
    //   371: astore 4
    //   373: goto -70 -> 303
    //   376: astore 6
    //   378: aload 4
    //   380: astore_3
    //   381: aload 5
    //   383: astore_1
    //   384: goto -29 -> 355
    //   387: astore 5
    //   389: aload 4
    //   391: astore_3
    //   392: aload 6
    //   394: astore_1
    //   395: goto -103 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	RunningJob
    //   0	398	1	paramFile	File
    //   37	227	2	i	int
    //   16	336	3	localObject1	Object
    //   358	2	3	localIOException	IOException
    //   368	24	3	localObject2	Object
    //   53	337	4	localObject3	Object
    //   4	251	5	localObject4	Object
    //   282	11	5	localOutOfMemoryError1	OutOfMemoryError
    //   295	87	5	localObject5	Object
    //   387	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   13	246	6	arrayOfByte1	byte[]
    //   348	8	6	localException1	Exception
    //   376	17	6	localException2	Exception
    //   7	346	7	arrayOfByte2	byte[]
    //   10	270	8	localBitmap	Bitmap
    //   1	58	9	localObject6	Object
    //   22	306	10	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   238	243	274	java/io/IOException
    //   32	55	282	java/lang/OutOfMemoryError
    //   65	78	295	finally
    //   92	102	295	finally
    //   116	124	295	finally
    //   138	159	295	finally
    //   173	179	295	finally
    //   193	198	295	finally
    //   260	271	295	finally
    //   292	295	295	finally
    //   355	358	295	finally
    //   32	55	348	java/lang/Exception
    //   342	346	358	java/io/IOException
    //   32	55	366	finally
    //   65	78	376	java/lang/Exception
    //   92	102	376	java/lang/Exception
    //   116	124	376	java/lang/Exception
    //   138	159	376	java/lang/Exception
    //   173	179	376	java/lang/Exception
    //   193	198	376	java/lang/Exception
    //   260	271	376	java/lang/Exception
    //   65	78	387	java/lang/OutOfMemoryError
    //   92	102	387	java/lang/OutOfMemoryError
    //   116	124	387	java/lang/OutOfMemoryError
    //   138	159	387	java/lang/OutOfMemoryError
    //   173	179	387	java/lang/OutOfMemoryError
    //   193	198	387	java/lang/OutOfMemoryError
    //   260	271	387	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public void run()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      Utils.a(jdField_a_of_type_JavaLangString, "[start request](" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + " createTs:" + this.jdField_a_of_type_Long);
    }
    boolean bool2;
    long l1;
    long l2;
    long l3;
    Object localObject1;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean) {
        return;
      }
      PubAccountHttpDownloader localPubAccountHttpDownloader = new PubAccountHttpDownloader(BaseApplicationImpl.getApplication());
      localObject2 = new DownloadParams();
      ((DownloadParams)localObject2).url = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_JavaNetURL;
      ((DownloadParams)localObject2).urlStr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_JavaNetURL.toString();
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader = localPubAccountHttpDownloader;
      bool2 = localPubAccountHttpDownloader.hasDiskFile((DownloadParams)localObject2);
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaIoFile = localPubAccountHttpDownloader.loadImageFile((DownloadParams)localObject2, new muj(this));
      if (this.jdField_a_of_type_JavaIoFile == null) {
        throw new IOException("downloader fail");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      try
      {
        if (localThrowable.getMessage() == null) {
          break label697;
        }
        if ((((localThrowable instanceof RuntimeException)) && (localThrowable.getMessage().contains("cancel"))) || (((localThrowable instanceof IOException)) && (localThrowable.getMessage().contains("cancel")))) {
          break label762;
        }
        if (((!(localThrowable instanceof RuntimeException)) || (!localThrowable.getMessage().contains("decode fail"))) && ((!(localThrowable instanceof IOException)) || (!localThrowable.getMessage().contains("write 0 length file or null File")))) {
          break label690;
        }
        if (QLog.isColorLevel()) {
          Utils.a(jdField_a_of_type_JavaLangString, localThrowable.getMessage() + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + " retryCount:" + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label683;
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaIoFile != null) {
          this.jdField_a_of_type_JavaIoFile.delete();
        }
        run();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      l2 = System.currentTimeMillis();
      l3 = l2 - l1;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("[download success](").append(l3).append(")").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest).append(" fileSize:");
        if (this.jdField_a_of_type_JavaIoFile == null) {
          break label495;
        }
      }
      label495:
      for (l1 = this.jdField_a_of_type_JavaIoFile.length();; l1 = 0L)
      {
        Utils.a((String)localObject1, l1);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Boolean) {
          break;
        }
        throw new RuntimeException("cancel");
      }
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        localObject1 = a(this.jdField_a_of_type_JavaIoFile);
        l1 = System.currentTimeMillis();
        l2 = l1 - l2;
        if (!QLog.isColorLevel()) {
          break label763;
        }
        Utils.a(jdField_a_of_type_JavaLangString, "[decode success](" + l2 + ") total(" + (l1 - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + "; size =" + ((Bitmap)localObject1).getByteCount());
      }
      catch (Exception localException2)
      {
        throw new RuntimeException("[decode fail]" + localException2.toString());
      }
      if (bool1) {
        i = ((Bitmap)localObject1).getByteCount();
      }
      a(bool2, l3 + l2, i, bool1);
      if (bool1)
      {
        a((Bitmap)localObject1);
        return;
      }
      a(new RuntimeException("bitmap null"));
      return;
      label683:
      a(localException2);
      return;
      label690:
      a(localException2);
      return;
      label697:
      if (QLog.isColorLevel()) {
        Utils.a(jdField_a_of_type_JavaLangString, "[job fail]" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest + " " + localException2 + " retryCount:" + this.jdField_a_of_type_Int);
      }
      a(localException2);
      label762:
      return;
      label763:
      if (localException2 != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob
 * JD-Core Version:    0.7.0.1
 */