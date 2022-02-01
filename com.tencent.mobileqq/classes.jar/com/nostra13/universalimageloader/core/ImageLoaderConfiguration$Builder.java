package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.util.concurrent.Executor;

public class ImageLoaderConfiguration$Builder
{
  public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
  public static final int DEFAULT_THREAD_POOL_SIZE = 3;
  public static final int DEFAULT_THREAD_PRIORITY = 3;
  private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
  private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
  private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
  private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
  private Context context;
  private boolean customExecutor = false;
  private boolean customExecutorForCachedImages = false;
  private ImageDecoder decoder;
  private DisplayImageOptions defaultDisplayImageOptions = null;
  private boolean denyCacheImageMultipleSizesInMemory = false;
  private DiskCache diskCache = null;
  private int diskCacheFileCount = 0;
  private FileNameGenerator diskCacheFileNameGenerator = null;
  private long diskCacheSize = 0L;
  private ImageDownloader downloader = null;
  private int maxImageHeightForDiskCache = 0;
  private int maxImageHeightForMemoryCache = 0;
  private int maxImageWidthForDiskCache = 0;
  private int maxImageWidthForMemoryCache = 0;
  private MemoryCache memoryCache = null;
  private int memoryCacheSize = 0;
  private BitmapProcessor processorForDiskCache = null;
  private Executor taskExecutor = null;
  private Executor taskExecutorForCachedImages = null;
  private QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
  private int threadPoolSize = 3;
  private int threadPriority = 3;
  private boolean writeLogs = false;
  
  public ImageLoaderConfiguration$Builder(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  private void initEmptyFieldsWithDefaultValues()
  {
    if (this.taskExecutor == null) {
      this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
    } else {
      this.customExecutor = true;
    }
    if (this.taskExecutorForCachedImages == null) {
      this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
    } else {
      this.customExecutorForCachedImages = true;
    }
    if (this.diskCache == null)
    {
      if (this.diskCacheFileNameGenerator == null) {
        this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
      }
      this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
    }
    if (this.memoryCache == null) {
      this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
    }
    if (this.denyCacheImageMultipleSizesInMemory) {
      this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
    }
    if (this.downloader == null) {
      this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
    }
    if (this.decoder == null) {
      this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
    }
    if (this.defaultDisplayImageOptions == null) {
      this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
    }
  }
  
  public ImageLoaderConfiguration build()
  {
    initEmptyFieldsWithDefaultValues();
    return new ImageLoaderConfiguration(this, null);
  }
  
  public Builder defaultDisplayImageOptions(DisplayImageOptions paramDisplayImageOptions)
  {
    this.defaultDisplayImageOptions = paramDisplayImageOptions;
    return this;
  }
  
  public Builder denyCacheImageMultipleSizesInMemory()
  {
    this.denyCacheImageMultipleSizesInMemory = true;
    return this;
  }
  
  @Deprecated
  public Builder discCache(DiskCache paramDiskCache)
  {
    return diskCache(paramDiskCache);
  }
  
  @Deprecated
  public Builder discCacheExtraOptions(int paramInt1, int paramInt2, BitmapProcessor paramBitmapProcessor)
  {
    return diskCacheExtraOptions(paramInt1, paramInt2, paramBitmapProcessor);
  }
  
  @Deprecated
  public Builder discCacheFileCount(int paramInt)
  {
    return diskCacheFileCount(paramInt);
  }
  
  @Deprecated
  public Builder discCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
  {
    return diskCacheFileNameGenerator(paramFileNameGenerator);
  }
  
  @Deprecated
  public Builder discCacheSize(int paramInt)
  {
    return diskCacheSize(paramInt);
  }
  
  public Builder diskCache(DiskCache paramDiskCache)
  {
    if ((this.diskCacheSize > 0L) || (this.diskCacheFileCount > 0)) {
      L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
    }
    if (this.diskCacheFileNameGenerator != null) {
      L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
    }
    this.diskCache = paramDiskCache;
    return this;
  }
  
  public Builder diskCacheExtraOptions(int paramInt1, int paramInt2, BitmapProcessor paramBitmapProcessor)
  {
    this.maxImageWidthForDiskCache = paramInt1;
    this.maxImageHeightForDiskCache = paramInt2;
    this.processorForDiskCache = paramBitmapProcessor;
    return this;
  }
  
  public Builder diskCacheFileCount(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.diskCache != null) {
        L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      }
      this.diskCacheFileCount = paramInt;
      return this;
    }
    throw new IllegalArgumentException("maxFileCount must be a positive number");
  }
  
  public Builder diskCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
  {
    if (this.diskCache != null) {
      L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
    }
    this.diskCacheFileNameGenerator = paramFileNameGenerator;
    return this;
  }
  
  public Builder diskCacheSize(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.diskCache != null) {
        L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      }
      this.diskCacheSize = paramInt;
      return this;
    }
    throw new IllegalArgumentException("maxCacheSize must be a positive number");
  }
  
  public Builder imageDecoder(ImageDecoder paramImageDecoder)
  {
    this.decoder = paramImageDecoder;
    return this;
  }
  
  public Builder imageDownloader(ImageDownloader paramImageDownloader)
  {
    this.downloader = paramImageDownloader;
    return this;
  }
  
  public Builder memoryCache(MemoryCache paramMemoryCache)
  {
    if (this.memoryCacheSize != 0) {
      L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
    }
    this.memoryCache = paramMemoryCache;
    return this;
  }
  
  public Builder memoryCacheExtraOptions(int paramInt1, int paramInt2)
  {
    this.maxImageWidthForMemoryCache = paramInt1;
    this.maxImageHeightForMemoryCache = paramInt2;
    return this;
  }
  
  public Builder memoryCacheSize(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.memoryCache != null) {
        L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      this.memoryCacheSize = paramInt;
      return this;
    }
    throw new IllegalArgumentException("memoryCacheSize must be a positive number");
  }
  
  public Builder memoryCacheSizePercentage(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 100))
    {
      if (this.memoryCache != null) {
        L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      this.memoryCacheSize = ((int)((float)Runtime.getRuntime().maxMemory() * (paramInt / 100.0F)));
      return this;
    }
    throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
  }
  
  public Builder taskExecutor(Executor paramExecutor)
  {
    if ((this.threadPoolSize != 3) || (this.threadPriority != 3) || (this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)) {
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    }
    this.taskExecutor = paramExecutor;
    return this;
  }
  
  public Builder taskExecutorForCachedImages(Executor paramExecutor)
  {
    if ((this.threadPoolSize != 3) || (this.threadPriority != 3) || (this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)) {
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    }
    this.taskExecutorForCachedImages = paramExecutor;
    return this;
  }
  
  public Builder tasksProcessingOrder(QueueProcessingType paramQueueProcessingType)
  {
    if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    }
    this.tasksProcessingType = paramQueueProcessingType;
    return this;
  }
  
  public Builder threadPoolSize(int paramInt)
  {
    if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    }
    this.threadPoolSize = paramInt;
    return this;
  }
  
  public Builder threadPriority(int paramInt)
  {
    if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    }
    if (paramInt < 1)
    {
      this.threadPriority = 1;
      return this;
    }
    if (paramInt > 10)
    {
      this.threadPriority = 10;
      return this;
    }
    this.threadPriority = paramInt;
    return this;
  }
  
  public Builder writeDebugLogs()
  {
    this.writeLogs = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder
 * JD-Core Version:    0.7.0.1
 */