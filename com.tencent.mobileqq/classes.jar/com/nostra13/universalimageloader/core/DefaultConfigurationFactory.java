package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultConfigurationFactory
{
  public static BitmapDisplayer createBitmapDisplayer()
  {
    return new SimpleBitmapDisplayer();
  }
  
  public static DiskCache createDiskCache(Context paramContext, FileNameGenerator paramFileNameGenerator, long paramLong, int paramInt)
  {
    File localFile = createReserveDiskCacheDir(paramContext);
    if ((paramLong > 0L) || (paramInt > 0))
    {
      Object localObject = StorageUtils.getIndividualCacheDirectory(paramContext);
      try
      {
        localObject = new LruDiskCache((File)localObject, localFile, paramFileNameGenerator, paramLong, paramInt);
        return localObject;
      }
      catch (IOException localIOException)
      {
        L.e(localIOException);
      }
    }
    return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(paramContext), localFile, paramFileNameGenerator);
  }
  
  public static Executor createExecutor(int paramInt1, int paramInt2, QueueProcessingType paramQueueProcessingType)
  {
    int i;
    if (paramQueueProcessingType == QueueProcessingType.LIFO)
    {
      i = 1;
      if (i == 0) {
        break label52;
      }
    }
    label52:
    for (paramQueueProcessingType = new LIFOLinkedBlockingDeque();; paramQueueProcessingType = new LinkedBlockingQueue())
    {
      paramQueueProcessingType = (BlockingQueue)paramQueueProcessingType;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, paramQueueProcessingType, createThreadFactory(paramInt2, "uil-pool-"));
      i = 0;
      break;
    }
  }
  
  public static FileNameGenerator createFileNameGenerator()
  {
    return new HashCodeFileNameGenerator();
  }
  
  public static ImageDecoder createImageDecoder(boolean paramBoolean)
  {
    return new BaseImageDecoder(paramBoolean);
  }
  
  public static ImageDownloader createImageDownloader(Context paramContext)
  {
    return new BaseImageDownloader(paramContext);
  }
  
  public static MemoryCache createMemoryCache(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      paramInt = localActivityManager.getMemoryClass();
      if ((!hasHoneycomb()) || (!isLargeHeap(paramContext))) {
        break label56;
      }
      paramInt = getLargeMemoryClass(localActivityManager);
    }
    label56:
    for (;;)
    {
      i = paramInt * 1048576 / 8;
      return new LruMemoryCache(i);
    }
  }
  
  private static File createReserveDiskCacheDir(Context paramContext)
  {
    paramContext = StorageUtils.getCacheDirectory(paramContext, false);
    File localFile = new File(paramContext, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir())) {
      paramContext = localFile;
    }
    return paramContext;
  }
  
  public static Executor createTaskDistributor()
  {
    return Executors.newFixedThreadPool(3, createThreadFactory(5, "uil-pool-d-"));
  }
  
  private static ThreadFactory createThreadFactory(int paramInt, String paramString)
  {
    return new DefaultConfigurationFactory.DefaultThreadFactory(paramInt, paramString);
  }
  
  @TargetApi(11)
  private static int getLargeMemoryClass(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
  
  private static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  @TargetApi(11)
  private static boolean isLargeHeap(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x100000) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DefaultConfigurationFactory
 * JD-Core Version:    0.7.0.1
 */