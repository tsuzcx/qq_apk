package com.tencent.image;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeBitmapFactory
{
  public static String FLASH_BACK_TEST_PATH;
  public static final long FLASH_BACK_TEST_PX_THRESHOID = 10000000L;
  public static String FLASH_BACK_TEST_REGION_PATH;
  public static String LARGE_MAP_CACHE_PATH;
  public static final int PX_SLICE = 4000;
  public static final long PX_THRESHOID_DEFAULTS = 100000000L;
  public static final int RAM_THRESHOID_DEFAULTS = 8;
  public static String ROOT_PATH;
  public static final String SAFE_DECODE_FROM = "from";
  private static final String SP_NEED_REGION_DECODE = "sp_need_region_decode";
  private static final String SP_PX_THRESHOID = "sp_px_threshoid";
  private static final String SP_RAM_THRESHOID = "sp_ram_threshoid";
  private static final String SP_SAFE_BITMAP = "sp_safe_bitmap";
  private static final String SP_THREADS_COUNT = "sp_thread_count";
  private static final String TAG = "SafeBitmapFactory";
  public static final int THREADS_COUNT_DEFAULTS = 7;
  public static Object lock = new Object();
  public static AtomicBoolean sInjectHotPatch;
  public static int sNeedRegionDecode;
  public static long sPxThreshold;
  public static int sRamThreshold = -1;
  public static int sThreadCount;
  
  static
  {
    sPxThreshold = -1L;
    sThreadCount = -1;
    sNeedRegionDecode = -1;
    sInjectHotPatch = new AtomicBoolean(false);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
  }
  
  @TargetApi(10)
  private static Bitmap decodeData(Object paramObject, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "解码图片文件路径：" + paramObject);
      }
      localBitmap = BitmapFactory.decodeFile(paramObject, paramOptions);
    }
    do
    {
      return localBitmap;
      if ((paramObject instanceof InputStream))
      {
        paramObject = (InputStream)paramObject;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "解码图片文件流");
        }
        return BitmapFactory.decodeStream(paramObject, null, paramOptions);
      }
      if ((paramObject instanceof FileDescriptor))
      {
        paramObject = (FileDescriptor)paramObject;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "解码图片文件描述");
        }
        return BitmapFactory.decodeFileDescriptor(paramObject, null, paramOptions);
      }
    } while (!(paramObject instanceof byte[]));
    paramObject = (byte[])paramObject;
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "解码图片字节数组");
    }
    if (paramOptions != null) {
      return BitmapFactory.decodeByteArray(paramObject, 0, paramObject.length, paramOptions);
    }
    return BitmapFactory.decodeByteArray(paramObject, 0, paramObject.length);
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeFile(paramString);
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeFile(paramString, paramOptions);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeStream(paramInputStream);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
  }
  
  public static int getNeedRegionDecode()
  {
    if (sNeedRegionDecode == -1) {
      if (!URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).getBoolean("sp_need_region_decode", true)) {
        break label35;
      }
    }
    label35:
    for (sNeedRegionDecode = 1;; sNeedRegionDecode = 0) {
      return sNeedRegionDecode;
    }
  }
  
  public static long getPxThreshoid()
  {
    if (sPxThreshold == -1L) {
      sPxThreshold = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).getLong("sp_px_threshoid", 100000000L);
    }
    return sPxThreshold;
  }
  
  public static int getRamThreshoid()
  {
    if (sRamThreshold == -1) {
      sRamThreshold = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).getInt("sp_ram_threshoid", 8);
    }
    return sRamThreshold;
  }
  
  @TargetApi(10)
  private static BitmapRegionDecoder getRegionDecoder(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof String)) {
      return BitmapRegionDecoder.newInstance((String)paramObject, paramBoolean);
    }
    if ((paramObject instanceof FileDescriptor)) {
      return BitmapRegionDecoder.newInstance((FileDescriptor)paramObject, paramBoolean);
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      return BitmapRegionDecoder.newInstance(paramObject, 0, paramObject.length, paramBoolean);
    }
    return null;
  }
  
  public static int getThreadCount()
  {
    if (sThreadCount == -1) {
      sThreadCount = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).getInt("sp_thread_count", 7);
    }
    return sThreadCount;
  }
  
  private static void initRegionCacheFilePath()
  {
    if (URLDrawable.depImp == null) {}
    while (ROOT_PATH != null) {
      return;
    }
    Context localContext = URLDrawable.depImp.mTool.getContext();
    ROOT_PATH = localContext.getFilesDir().getAbsolutePath() + "/urldrawable/hugeimagecache";
    LARGE_MAP_CACHE_PATH = ROOT_PATH;
    FLASH_BACK_TEST_PATH = ROOT_PATH + "/flashback.mc";
    FLASH_BACK_TEST_REGION_PATH = ROOT_PATH + "/flashbackRegion.mc";
  }
  
  public static void injectBitmapHotPatch() {}
  
  private static boolean needRegionDecode(Object paramObject, SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    initRegionCacheFilePath();
    Object localObject1 = paramSafeDecodeOption.inOptions;
    boolean bool1;
    if ((localObject1 != null) && (((BitmapFactory.Options)localObject1).inJustDecodeBounds))
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "只要获取图片数据，不需要解码图片，不使用区域解码");
      }
      paramSafeDecodeOption.isInJustDecodeBounds = true;
      bool1 = false;
      return bool1;
    }
    paramSafeDecodeOption.isInJustDecodeBounds = false;
    if (getNeedRegionDecode() == 0)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "区域解码开关 needRegionDecode 关闭，不使用区域解码");
      }
      paramSafeDecodeOption.regionDecodeOpen = 0;
      return false;
    }
    paramSafeDecodeOption.regionDecodeOpen = 1;
    if ((paramObject instanceof InputStream))
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "源数据是InputStream，不使用区域解码");
      }
      paramSafeDecodeOption.dataSourceType = "InputStream";
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeData(paramObject, localOptions);
    localOptions.inJustDecodeBounds = false;
    paramSafeDecodeOption.rawWidth = localOptions.outWidth;
    paramSafeDecodeOption.rawHeight = localOptions.outHeight;
    paramSafeDecodeOption.flashTestThreshold = 10000000L;
    if (localOptions.outWidth * localOptions.outHeight < 10000000L)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "图片太小，小于闪退检测阈值，不用区域解码。rawWidth：" + localOptions.outWidth + ", rawHeight :" + localOptions.outHeight + ",sPxThreshold:" + sPxThreshold);
      }
      return false;
    }
    localObject1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((paramObject instanceof String))
        {
          localObject1 = new FileInputStream((String)paramObject);
          paramSafeDecodeOption.dataSourceType = "String";
          localObject2 = new byte[29];
          ((InputStream)localObject1).read((byte[])localObject2);
          if ((localObject2[1] != 80) || (localObject2[2] != 78) || (localObject2[3] != 71) || (localObject2[28] != 1))
          {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "不是隔行扫描的png图片，不用区域解码");
            }
            paramSafeDecodeOption.isPng = 0;
            return false;
          }
        }
        else
        {
          if ((paramObject instanceof FileDescriptor))
          {
            localObject1 = new FileInputStream((FileDescriptor)paramObject);
            paramSafeDecodeOption.dataSourceType = "FileDescriptor";
            continue;
          }
          if (!(paramObject instanceof byte[])) {
            continue;
          }
          localObject1 = new ByteArrayInputStream((byte[])paramObject);
          paramSafeDecodeOption.dataSourceType = "byte[]";
          continue;
        }
        paramSafeDecodeOption.isPng = 1;
        ((InputStream)localObject1).close();
        paramSafeDecodeOption.pxThreshold = getPxThreshoid();
        if (localOptions.outWidth * localOptions.outHeight >= sPxThreshold) {
          break label1010;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "图片小于区域解码阈值。rawWidth：" + localOptions.outWidth + ", rawHeight :" + localOptions.outHeight + ",sPxThreshold:" + sPxThreshold);
        }
        bool1 = false;
        l1 = -1L;
        if ((Build.VERSION.SDK_INT < 16) || (URLDrawable.mApplicationContext == null)) {
          break label892;
        }
        localObject1 = (ActivityManager)URLDrawable.mApplicationContext.getSystemService("activity");
        Object localObject2 = new ActivityManager.MemoryInfo();
        if (localObject1 != null) {
          ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        }
        l1 = ((ActivityManager.MemoryInfo)localObject2).totalMem / 1024L / 1024L / 1024L + 1L;
        paramSafeDecodeOption.ram = l1;
        paramSafeDecodeOption.ramThreshold = getRamThreshoid();
        if (l1 <= sRamThreshold) {
          break label1005;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "手机内存够大。ram：" + l1 + ",sRamThreshold:" + sRamThreshold);
        }
        bool2 = false;
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = bool2;
        if (!paramSafeDecodeOption.inNeedFlashBackTest) {
          break;
        }
        bool1 = bool2;
        if (localOptions.outWidth * localOptions.outHeight <= 10000000L) {
          break;
        }
        bool1 = bool2;
        if (!(paramObject instanceof String)) {
          break;
        }
        bool1 = bool2;
        switch (MmapCache.getInstance(FLASH_BACK_TEST_PATH).findOrAddItem((String)paramObject))
        {
        case -1: 
        default: 
          return bool2;
        }
      }
      catch (FileNotFoundException paramObject)
      {
        paramObject.printStackTrace();
        return false;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
        return false;
      }
      paramSafeDecodeOption.needFlashBackTest = true;
      paramSafeDecodeOption.isBeforeFlashBackPic = 0;
      return bool2;
      try
      {
        label892:
        long l2 = Long.valueOf(new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo")).readLine().split("\\s+")[1]).longValue() / 1024L / 1024L;
        l1 = l2 + 1L;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      continue;
      paramSafeDecodeOption.isBeforeFlashBackPic = 1;
      bool1 = true;
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break;
      }
      URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "闪退缓存中存在该数据，说明之前崩溃，采用区域解码。");
      return true;
      label1005:
      boolean bool2 = bool1;
      continue;
      label1010:
      bool1 = true;
    }
  }
  
  @TargetApi(10)
  private static Bitmap regionDecodeData(Object paramObject, SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    BitmapFactory.Options localOptions2 = paramSafeDecodeOption.inOptions;
    if (localOptions2 == null) {}
    Object localObject1;
    for (BitmapFactory.Options localOptions1 = new BitmapFactory.Options(); paramSafeDecodeOption.inNeedCache; localOptions1 = localOptions2)
    {
      localObject1 = regionDecodeFromCache(paramObject, localOptions2);
      if (localObject1 == null) {
        break;
      }
      return localObject1;
    }
    if ((paramSafeDecodeOption.inNeedFlashBackTest) && ((paramObject instanceof String))) {}
    Object localObject2;
    int k;
    int m;
    int i;
    label313:
    int j;
    label333:
    int n;
    int i1;
    Semaphore localSemaphore;
    Canvas localCanvas;
    switch (MmapCache.getInstance(FLASH_BACK_TEST_REGION_PATH).findOrAddItem((String)paramObject))
    {
    case -1: 
    default: 
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        long l2 = -1L;
        long l1 = l2;
        if (Build.VERSION.SDK_INT >= 16)
        {
          l1 = l2;
          if (URLDrawable.mApplicationContext != null)
          {
            localObject1 = (ActivityManager)URLDrawable.mApplicationContext.getSystemService("activity");
            localObject2 = new ActivityManager.MemoryInfo();
            if (localObject1 != null) {
              ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
            }
            l1 = ((ActivityManager.MemoryInfo)localObject2).availMem / 1024L / 1024L;
          }
        }
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 4, "当前系统剩余内存。availMem：" + l1 + "MB");
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      decodeData(paramObject, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      k = ((BitmapFactory.Options)localObject1).outWidth / 4000 + 1;
      m = ((BitmapFactory.Options)localObject1).outHeight / 4000 + 1;
      if (localOptions1.inSampleSize > 0)
      {
        i = ((BitmapFactory.Options)localObject1).outWidth / localOptions1.inSampleSize;
        if (localOptions1.inSampleSize <= 0) {
          break label686;
        }
        j = ((BitmapFactory.Options)localObject1).outHeight / localOptions1.inSampleSize;
        n = i / k;
        i1 = j / m;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "区域解码原图 宽：" + ((BitmapFactory.Options)localObject1).outWidth + ", 高" + ((BitmapFactory.Options)localObject1).outHeight);
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "区域解码原图 inSampleSize：" + localOptions1.inSampleSize);
        }
        localObject1 = Bitmap.createBitmap(i, j, localOptions1.inPreferredConfig);
        localObject2 = new CountDownLatch(m * k);
        if (paramSafeDecodeOption.isBeforeFlashBackPicRegion != 1) {
          break label695;
        }
        i = getThreadCount() / 2 + 1;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "threadCount：" + i);
        }
        localSemaphore = new Semaphore(i);
        localCanvas = new Canvas((Bitmap)localObject1);
        i = 0;
      }
      break;
    }
    for (;;)
    {
      label686:
      label695:
      for (;;)
      {
        if (i >= m) {
          break label719;
        }
        j = 0;
        label570:
        if (j < k) {
          try
          {
            localSemaphore.acquire();
            SafeBitmapFactory.1 local1 = new SafeBitmapFactory.1(localOptions1, j, n, i, i1, paramObject, localCanvas, (CountDownLatch)localObject2);
            URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(local1, null, true);
            localSemaphore.release();
            j += 1;
            break label570;
            paramSafeDecodeOption.isBeforeFlashBackPicRegion = 0;
            break;
            paramSafeDecodeOption.isBeforeFlashBackPicRegion = 1;
            if (!URLDrawable.depImp.mLog.isColorLevel()) {
              break;
            }
            URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "闪退缓存中存在该数据，说明之前用区域解码崩溃过。降低线程数");
            break;
            i = ((BitmapFactory.Options)localObject1).outWidth;
            break label313;
            j = ((BitmapFactory.Options)localObject1).outHeight;
            break label333;
            i = getThreadCount();
          }
          catch (InterruptedException localInterruptedException2)
          {
            for (;;)
            {
              localInterruptedException2.printStackTrace();
            }
          }
        }
      }
      i += 1;
    }
    try
    {
      label719:
      ((CountDownLatch)localObject2).await(20L, TimeUnit.SECONDS);
      if (paramSafeDecodeOption.inNeedCache) {
        regionDecodeToCache(paramObject, (Bitmap)localObject1, localOptions2);
      }
      if (localOptions2 != null)
      {
        localOptions2.inJustDecodeBounds = true;
        decodeData(paramObject, localOptions2);
        localOptions2.inJustDecodeBounds = false;
      }
      if (paramSafeDecodeOption.isBeforeFlashBackPicRegion == 0) {
        MmapCache.getInstance(FLASH_BACK_TEST_REGION_PATH).deleteItem((String)paramObject);
      }
      return localObject1;
    }
    catch (InterruptedException localInterruptedException1)
    {
      for (;;)
      {
        localInterruptedException1.printStackTrace();
      }
    }
  }
  
  private static Bitmap regionDecodeFromCache(Object paramObject, BitmapFactory.Options paramOptions)
  {
    Object localObject = null;
    paramObject = MD5Util.getMd5(paramObject);
    paramObject = Utils.Crc64String(paramObject) + "_" + paramOptions.inSampleSize;
    paramOptions = LARGE_MAP_CACHE_PATH + File.separator + paramObject;
    File localFile = new File(paramOptions);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "缓存PATH:" + paramOptions);
    }
    paramObject = localObject;
    if (localFile.exists()) {
      paramObject = BitmapFactory.decodeFile(paramOptions);
    }
    return paramObject;
  }
  
  private static void regionDecodeToCache(Object paramObject, Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    paramObject = MD5Util.getMd5(paramObject);
    paramObject = Utils.Crc64String(paramObject) + "_" + paramOptions.inSampleSize;
    paramObject = LARGE_MAP_CACHE_PATH + File.separator + paramObject;
    try
    {
      paramOptions = new File(LARGE_MAP_CACHE_PATH);
      if (!paramOptions.exists()) {
        paramOptions.mkdirs();
      }
      paramObject = new FileOutputStream(new File(paramObject));
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramObject);
      paramObject.flush();
      paramObject.close();
      return;
    }
    catch (FileNotFoundException paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  @Deprecated
  public static void registProxyInstance() {}
  
  public static Bitmap safeDecode(Object paramObject, BitmapFactory.Options paramOptions)
  {
    SafeBitmapFactory.SafeDecodeOption localSafeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
    localSafeDecodeOption.inOptions = paramOptions;
    return safeDecode(paramObject, localSafeDecodeOption);
  }
  
  public static Bitmap safeDecode(Object paramObject, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    SafeBitmapFactory.SafeDecodeOption localSafeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
    localSafeDecodeOption.inOptions = paramOptions;
    localSafeDecodeOption.inNeedCache = paramBoolean;
    return safeDecode(paramObject, localSafeDecodeOption);
  }
  
  public static Bitmap safeDecode(Object paramObject, SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    SafeBitmapFactory.SafeDecodeOption localSafeDecodeOption = paramSafeDecodeOption;
    if (paramSafeDecodeOption == null) {
      localSafeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
    }
    long l = System.currentTimeMillis();
    localSafeDecodeOption.needRegionDecode = needRegionDecode(paramObject, localSafeDecodeOption);
    if (localSafeDecodeOption.needRegionDecode) {
      paramSafeDecodeOption = regionDecodeData(paramObject, localSafeDecodeOption);
    }
    for (;;)
    {
      if (paramSafeDecodeOption != null) {
        localSafeDecodeOption.isGetBitmap = true;
      }
      localSafeDecodeOption.runTime = (System.currentTimeMillis() - l);
      return paramSafeDecodeOption;
      Bitmap localBitmap = decodeData(paramObject, localSafeDecodeOption.inOptions);
      paramSafeDecodeOption = localBitmap;
      if ((paramObject instanceof String))
      {
        paramSafeDecodeOption = localBitmap;
        if (localSafeDecodeOption.needFlashBackTest)
        {
          MmapCache.getInstance(FLASH_BACK_TEST_PATH).deleteItem((String)paramObject);
          paramSafeDecodeOption = localBitmap;
        }
      }
    }
  }
  
  public static void setNeedRegionDecode(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (sNeedRegionDecode = 1;; sNeedRegionDecode = 0)
    {
      SharedPreferences.Editor localEditor = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).edit();
      localEditor.putBoolean("sp_need_region_decode", paramBoolean);
      localEditor.commit();
      return;
    }
  }
  
  public static void setPxThreshoidToSp(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    sPxThreshold = paramLong;
    SharedPreferences.Editor localEditor = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).edit();
    localEditor.putLong("sp_px_threshoid", paramLong);
    localEditor.commit();
  }
  
  public static void setRamThreshoidToSp(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    sRamThreshold = paramInt;
    SharedPreferences.Editor localEditor = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).edit();
    localEditor.putInt("sp_ram_threshoid", paramInt);
    localEditor.commit();
  }
  
  public static void setThreadCountToSp(int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    sThreadCount = paramInt;
    SharedPreferences.Editor localEditor = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).edit();
    localEditor.putLong("sp_thread_count", paramInt);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory
 * JD-Core Version:    0.7.0.1
 */