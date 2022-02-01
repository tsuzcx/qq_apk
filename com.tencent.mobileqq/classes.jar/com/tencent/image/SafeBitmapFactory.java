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
  public static AtomicBoolean sInjectHotPatch = new AtomicBoolean(false);
  public static int sNeedRegionDecode = -1;
  public static long sPxThreshold = -1L;
  public static int sRamThreshold = -1;
  public static int sThreadCount = -1;
  
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
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ILog localILog = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("解码图片文件路径：");
        localStringBuilder.append(paramObject);
        localILog.d("SafeBitmapFactory", 2, localStringBuilder.toString());
      }
      return BitmapFactory.decodeFile(paramObject, paramOptions);
    }
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
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "解码图片字节数组");
      }
      if (paramOptions != null) {
        return BitmapFactory.decodeByteArray(paramObject, 0, paramObject.length, paramOptions);
      }
      return BitmapFactory.decodeByteArray(paramObject, 0, paramObject.length);
    }
    return null;
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
      if (URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).getBoolean("sp_need_region_decode", true)) {
        sNeedRegionDecode = 1;
      } else {
        sNeedRegionDecode = 0;
      }
    }
    return sNeedRegionDecode;
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
    if (URLDrawable.depImp == null) {
      return;
    }
    if (ROOT_PATH != null) {
      return;
    }
    Object localObject = URLDrawable.depImp.mTool.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsolutePath());
    localStringBuilder.append("/urldrawable/hugeimagecache");
    ROOT_PATH = localStringBuilder.toString();
    LARGE_MAP_CACHE_PATH = ROOT_PATH;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ROOT_PATH);
    ((StringBuilder)localObject).append("/flashback.mc");
    FLASH_BACK_TEST_PATH = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ROOT_PATH);
    ((StringBuilder)localObject).append("/flashbackRegion.mc");
    FLASH_BACK_TEST_REGION_PATH = ((StringBuilder)localObject).toString();
  }
  
  public static void injectBitmapHotPatch() {}
  
  private static boolean needRegionDecode(Object paramObject, SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    initRegionCacheFilePath();
    Object localObject1 = paramSafeDecodeOption.inOptions;
    boolean bool2 = true;
    if ((localObject1 != null) && (((BitmapFactory.Options)localObject1).inJustDecodeBounds))
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "只要获取图片数据，不需要解码图片，不使用区域解码");
      }
      paramSafeDecodeOption.isInJustDecodeBounds = true;
      return false;
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
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramObject = URLDrawable.depImp.mLog;
        paramSafeDecodeOption = new StringBuilder();
        paramSafeDecodeOption.append("图片太小，小于闪退检测阈值，不用区域解码。rawWidth：");
        paramSafeDecodeOption.append(localOptions.outWidth);
        paramSafeDecodeOption.append(", rawHeight :");
        paramSafeDecodeOption.append(localOptions.outHeight);
        paramSafeDecodeOption.append(",sPxThreshold:");
        paramSafeDecodeOption.append(sPxThreshold);
        paramObject.d("SafeBitmapFactory", 2, paramSafeDecodeOption.toString());
      }
      return false;
    }
    for (;;)
    {
      try
      {
        if ((paramObject instanceof String))
        {
          localObject1 = new FileInputStream((String)paramObject);
          paramSafeDecodeOption.dataSourceType = "String";
        }
        else if ((paramObject instanceof FileDescriptor))
        {
          localObject1 = new FileInputStream((FileDescriptor)paramObject);
          paramSafeDecodeOption.dataSourceType = "FileDescriptor";
        }
        else
        {
          if (!(paramObject instanceof byte[])) {
            break label1056;
          }
          localObject1 = new ByteArrayInputStream((byte[])paramObject);
          paramSafeDecodeOption.dataSourceType = "byte[]";
        }
        Object localObject2 = new byte[29];
        ((InputStream)localObject1).read((byte[])localObject2);
        if ((localObject2[1] == 80) && (localObject2[2] == 78) && (localObject2[3] == 71) && (localObject2[28] == 1))
        {
          paramSafeDecodeOption.isPng = 1;
          ((InputStream)localObject1).close();
          paramSafeDecodeOption.pxThreshold = getPxThreshoid();
          boolean bool1;
          if (localOptions.outWidth * localOptions.outHeight < sPxThreshold)
          {
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              localObject1 = URLDrawable.depImp.mLog;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("图片小于区域解码阈值。rawWidth：");
              ((StringBuilder)localObject2).append(localOptions.outWidth);
              ((StringBuilder)localObject2).append(", rawHeight :");
              ((StringBuilder)localObject2).append(localOptions.outHeight);
              ((StringBuilder)localObject2).append(",sPxThreshold:");
              ((StringBuilder)localObject2).append(sPxThreshold);
              ((ILog)localObject1).d("SafeBitmapFactory", 2, ((StringBuilder)localObject2).toString());
            }
            bool1 = false;
          }
          else
          {
            bool1 = true;
          }
          long l;
          if ((Build.VERSION.SDK_INT >= 16) && (URLDrawable.mApplicationContext != null))
          {
            localObject1 = (ActivityManager)URLDrawable.mApplicationContext.getSystemService("activity");
            localObject2 = new ActivityManager.MemoryInfo();
            if (localObject1 != null) {
              ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
            }
            l = ((ActivityManager.MemoryInfo)localObject2).totalMem / 1024L / 1024L / 1024L;
            l += 1L;
          }
          else
          {
            try
            {
              l = Long.valueOf(new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo")).readLine().split("\\s+")[1]).longValue() / 1024L / 1024L;
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException.printStackTrace();
            }
            l = -1L;
          }
          paramSafeDecodeOption.ram = l;
          paramSafeDecodeOption.ramThreshold = getRamThreshoid();
          if (l > sRamThreshold)
          {
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              localILog = URLDrawable.depImp.mLog;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("手机内存够大。ram：");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(",sRamThreshold:");
              ((StringBuilder)localObject2).append(sRamThreshold);
              localILog.d("SafeBitmapFactory", 2, ((StringBuilder)localObject2).toString());
            }
            bool1 = false;
          }
          if ((!bool1) && (paramSafeDecodeOption.inNeedFlashBackTest) && (localOptions.outWidth * localOptions.outHeight > 10000000L) && ((paramObject instanceof String)))
          {
            int i = MmapCache.getInstance(FLASH_BACK_TEST_PATH).findOrAddItem((String)paramObject);
            if (i != -1) {
              if (i != 0)
              {
                if (i == 1)
                {
                  paramSafeDecodeOption.isBeforeFlashBackPic = 1;
                  bool1 = bool2;
                  if (URLDrawable.depImp.mLog.isColorLevel())
                  {
                    URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "闪退缓存中存在该数据，说明之前崩溃，采用区域解码。");
                    return true;
                  }
                }
              }
              else
              {
                paramSafeDecodeOption.needFlashBackTest = true;
                paramSafeDecodeOption.isBeforeFlashBackPic = 0;
              }
            }
          }
          return bool1;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "不是隔行扫描的png图片，不用区域解码");
        }
        paramSafeDecodeOption.isPng = 0;
        return false;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
        return false;
      }
      catch (FileNotFoundException paramObject)
      {
        paramObject.printStackTrace();
        return false;
      }
      label1056:
      ILog localILog = null;
    }
  }
  
  @TargetApi(10)
  private static Bitmap regionDecodeData(Object paramObject, SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    BitmapFactory.Options localOptions2 = paramSafeDecodeOption.inOptions;
    BitmapFactory.Options localOptions1;
    if (localOptions2 == null) {
      localOptions1 = new BitmapFactory.Options();
    } else {
      localOptions1 = localOptions2;
    }
    if (paramSafeDecodeOption.inNeedCache)
    {
      localObject1 = regionDecodeFromCache(paramObject, localOptions2);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    if ((paramSafeDecodeOption.inNeedFlashBackTest) && ((paramObject instanceof String)))
    {
      i = MmapCache.getInstance(FLASH_BACK_TEST_REGION_PATH).findOrAddItem((String)paramObject);
      if (i != -1) {
        if (i != 0)
        {
          if (i == 1)
          {
            paramSafeDecodeOption.isBeforeFlashBackPicRegion = 1;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.d("SafeBitmapFactory", 2, "闪退缓存中存在该数据，说明之前用区域解码崩溃过。降低线程数");
            }
          }
        }
        else {
          paramSafeDecodeOption.isBeforeFlashBackPicRegion = 0;
        }
      }
    }
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
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("当前系统剩余内存。availMem：");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("MB");
      ((ILog)localObject1).d("SafeBitmapFactory", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    decodeData(paramObject, (BitmapFactory.Options)localObject1);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    int m = ((BitmapFactory.Options)localObject1).outWidth / 4000 + 1;
    int k = ((BitmapFactory.Options)localObject1).outHeight / 4000 + 1;
    if (localOptions1.inSampleSize > 0) {
      i = ((BitmapFactory.Options)localObject1).outWidth / localOptions1.inSampleSize;
    } else {
      i = ((BitmapFactory.Options)localObject1).outWidth;
    }
    if (localOptions1.inSampleSize > 0) {
      j = ((BitmapFactory.Options)localObject1).outHeight / localOptions1.inSampleSize;
    } else {
      j = ((BitmapFactory.Options)localObject1).outHeight;
    }
    int n = i / m;
    int i1 = j / k;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject2 = URLDrawable.depImp.mLog;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("区域解码原图 宽：");
      ((StringBuilder)localObject3).append(((BitmapFactory.Options)localObject1).outWidth);
      ((StringBuilder)localObject3).append(", 高");
      ((StringBuilder)localObject3).append(((BitmapFactory.Options)localObject1).outHeight);
      ((ILog)localObject2).d("SafeBitmapFactory", 2, ((StringBuilder)localObject3).toString());
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("区域解码原图 inSampleSize：");
      ((StringBuilder)localObject2).append(localOptions1.inSampleSize);
      ((ILog)localObject1).d("SafeBitmapFactory", 2, ((StringBuilder)localObject2).toString());
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, localOptions1.inPreferredConfig);
    localObject1 = new CountDownLatch(k * m);
    if (paramSafeDecodeOption.isBeforeFlashBackPicRegion == 1) {
      i = getThreadCount() / 2 + 1;
    } else {
      i = getThreadCount();
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject2 = URLDrawable.depImp.mLog;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("threadCount：");
      ((StringBuilder)localObject3).append(i);
      ((ILog)localObject2).d("SafeBitmapFactory", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = new Semaphore(i);
    Object localObject3 = new Canvas(localBitmap);
    int i = 0;
    int j = m;
    while (i < k)
    {
      m = 0;
      while (m < j)
      {
        try
        {
          ((Semaphore)localObject2).acquire();
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
        SafeBitmapFactory.1 local1 = new SafeBitmapFactory.1(localOptions1, m, n, i, i1, paramObject, (Canvas)localObject3, (CountDownLatch)localObject1);
        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(local1, null, true);
        ((Semaphore)localObject2).release();
        m += 1;
      }
      i += 1;
    }
    try
    {
      ((CountDownLatch)localObject1).await(20L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException1)
    {
      localInterruptedException1.printStackTrace();
    }
    if (paramSafeDecodeOption.inNeedCache) {
      regionDecodeToCache(paramObject, localBitmap, localOptions2);
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
    return localBitmap;
  }
  
  private static Bitmap regionDecodeFromCache(Object paramObject, BitmapFactory.Options paramOptions)
  {
    paramObject = MD5Util.getMd5(paramObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Utils.Crc64String(paramObject));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramOptions.inSampleSize);
    paramObject = ((StringBuilder)localObject).toString();
    paramOptions = new StringBuilder();
    paramOptions.append(LARGE_MAP_CACHE_PATH);
    paramOptions.append(File.separator);
    paramOptions.append(paramObject);
    paramObject = paramOptions.toString();
    paramOptions = new File(paramObject);
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("缓存PATH:");
      localStringBuilder.append(paramObject);
      ((ILog)localObject).d("SafeBitmapFactory", 2, localStringBuilder.toString());
    }
    if (paramOptions.exists()) {
      return BitmapFactory.decodeFile(paramObject);
    }
    return null;
  }
  
  private static void regionDecodeToCache(Object paramObject, Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    paramObject = MD5Util.getMd5(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.Crc64String(paramObject));
    localStringBuilder.append("_");
    localStringBuilder.append(paramOptions.inSampleSize);
    paramObject = localStringBuilder.toString();
    paramOptions = new StringBuilder();
    paramOptions.append(LARGE_MAP_CACHE_PATH);
    paramOptions.append(File.separator);
    paramOptions.append(paramObject);
    paramObject = paramOptions.toString();
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
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    catch (FileNotFoundException paramObject)
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
    if (localSafeDecodeOption.needRegionDecode)
    {
      paramObject = regionDecodeData(paramObject, localSafeDecodeOption);
    }
    else
    {
      paramSafeDecodeOption = decodeData(paramObject, localSafeDecodeOption.inOptions);
      if (((paramObject instanceof String)) && (localSafeDecodeOption.needFlashBackTest)) {
        MmapCache.getInstance(FLASH_BACK_TEST_PATH).deleteItem((String)paramObject);
      }
      paramObject = paramSafeDecodeOption;
    }
    if (paramObject != null) {
      localSafeDecodeOption.isGetBitmap = true;
    }
    localSafeDecodeOption.runTime = (System.currentTimeMillis() - l);
    return paramObject;
  }
  
  public static void setNeedRegionDecode(boolean paramBoolean)
  {
    if (paramBoolean) {
      sNeedRegionDecode = 1;
    } else {
      sNeedRegionDecode = 0;
    }
    SharedPreferences.Editor localEditor = URLDrawable.mApplicationContext.getSharedPreferences("sp_safe_bitmap", 4).edit();
    localEditor.putBoolean("sp_need_region_decode", paramBoolean);
    localEditor.commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory
 * JD-Core Version:    0.7.0.1
 */