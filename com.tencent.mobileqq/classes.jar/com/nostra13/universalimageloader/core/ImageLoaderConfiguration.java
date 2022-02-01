package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration
{
  final boolean customExecutor;
  final boolean customExecutorForCachedImages;
  final ImageDecoder decoder;
  final DisplayImageOptions defaultDisplayImageOptions;
  final DiskCache diskCache;
  final ImageDownloader downloader;
  final int maxImageHeightForDiskCache;
  final int maxImageHeightForMemoryCache;
  final int maxImageWidthForDiskCache;
  final int maxImageWidthForMemoryCache;
  final MemoryCache memoryCache;
  final ImageDownloader networkDeniedDownloader;
  final BitmapProcessor processorForDiskCache;
  final Resources resources;
  final ImageDownloader slowNetworkDownloader;
  final Executor taskExecutor;
  final Executor taskExecutorForCachedImages;
  final QueueProcessingType tasksProcessingType;
  final int threadPoolSize;
  final int threadPriority;
  
  private ImageLoaderConfiguration(ImageLoaderConfiguration.Builder paramBuilder)
  {
    this.resources = ImageLoaderConfiguration.Builder.access$000(paramBuilder).getResources();
    this.maxImageWidthForMemoryCache = ImageLoaderConfiguration.Builder.access$100(paramBuilder);
    this.maxImageHeightForMemoryCache = ImageLoaderConfiguration.Builder.access$200(paramBuilder);
    this.maxImageWidthForDiskCache = ImageLoaderConfiguration.Builder.access$300(paramBuilder);
    this.maxImageHeightForDiskCache = ImageLoaderConfiguration.Builder.access$400(paramBuilder);
    this.processorForDiskCache = ImageLoaderConfiguration.Builder.access$500(paramBuilder);
    this.taskExecutor = ImageLoaderConfiguration.Builder.access$600(paramBuilder);
    this.taskExecutorForCachedImages = ImageLoaderConfiguration.Builder.access$700(paramBuilder);
    this.threadPoolSize = ImageLoaderConfiguration.Builder.access$800(paramBuilder);
    this.threadPriority = ImageLoaderConfiguration.Builder.access$900(paramBuilder);
    this.tasksProcessingType = ImageLoaderConfiguration.Builder.access$1000(paramBuilder);
    this.diskCache = ImageLoaderConfiguration.Builder.access$1100(paramBuilder);
    this.memoryCache = ImageLoaderConfiguration.Builder.access$1200(paramBuilder);
    this.defaultDisplayImageOptions = ImageLoaderConfiguration.Builder.access$1300(paramBuilder);
    this.downloader = ImageLoaderConfiguration.Builder.access$1400(paramBuilder);
    this.decoder = ImageLoaderConfiguration.Builder.access$1500(paramBuilder);
    this.customExecutor = ImageLoaderConfiguration.Builder.access$1600(paramBuilder);
    this.customExecutorForCachedImages = ImageLoaderConfiguration.Builder.access$1700(paramBuilder);
    this.networkDeniedDownloader = new ImageLoaderConfiguration.NetworkDeniedImageDownloader(this.downloader);
    this.slowNetworkDownloader = new ImageLoaderConfiguration.SlowNetworkImageDownloader(this.downloader);
    L.writeDebugLogs(ImageLoaderConfiguration.Builder.access$1800(paramBuilder));
  }
  
  public static ImageLoaderConfiguration createDefault(Context paramContext)
  {
    return new ImageLoaderConfiguration.Builder(paramContext).build();
  }
  
  ImageSize getMaxImageSize()
  {
    DisplayMetrics localDisplayMetrics = this.resources.getDisplayMetrics();
    int j = this.maxImageWidthForMemoryCache;
    int i = j;
    if (j <= 0) {
      i = localDisplayMetrics.widthPixels;
    }
    int k = this.maxImageHeightForMemoryCache;
    j = k;
    if (k <= 0) {
      j = localDisplayMetrics.heightPixels;
    }
    return new ImageSize(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration
 * JD-Core Version:    0.7.0.1
 */