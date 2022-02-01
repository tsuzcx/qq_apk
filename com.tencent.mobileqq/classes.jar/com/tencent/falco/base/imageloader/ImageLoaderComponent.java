package com.tencent.falco.base.imageloader;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoadingListener;
import com.tencent.falco.base.libapi.imageloader.ImageOnLoadingLogListener;
import java.io.File;

public class ImageLoaderComponent
  implements ImageLoaderInterface
{
  private String cachePath;
  private Context context;
  private ImageOnLoadingLogListener imageOnLoadingLogListener;
  
  private com.nostra13.universalimageloader.core.DisplayImageOptions convertDisplayImageOptions(com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions)
  {
    if ((paramDisplayImageOptions == null) || (this.context == null)) {
      return null;
    }
    DisplayImageOptions.Builder localBuilder = new DisplayImageOptions.Builder().showImageOnLoading(paramDisplayImageOptions.getImageOnLoading()).showImageForEmptyUri(paramDisplayImageOptions.getImageForEmptyUri()).showImageOnFail(paramDisplayImageOptions.getImageOnFail()).showImageOnLoading(paramDisplayImageOptions.getImageOnLoading(this.context.getResources())).showImageForEmptyUri(paramDisplayImageOptions.getImageForEmptyUri(this.context.getResources())).showImageOnFail(paramDisplayImageOptions.getImageOnFail(this.context.getResources())).cacheInMemory(paramDisplayImageOptions.isCacheInMemory()).cacheOnDisk(paramDisplayImageOptions.isCacheOnDisk()).considerExifParams(paramDisplayImageOptions.isConsiderExifParams()).decodingOptions(paramDisplayImageOptions.getDecodingOptions()).postProcessor(new ImageLoaderComponent.1(this, paramDisplayImageOptions));
    if (getBitmapDisplayer(paramDisplayImageOptions) != null) {
      localBuilder.displayer(getBitmapDisplayer(paramDisplayImageOptions));
    }
    return localBuilder.build();
  }
  
  private BitmapDisplayer getBitmapDisplayer(com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions)
  {
    if ((paramDisplayImageOptions != null) && (paramDisplayImageOptions.getBitmapDisplayer() != null)) {
      return new ImageLoaderComponent.2(this, paramDisplayImageOptions);
    }
    return null;
  }
  
  private boolean isLargeHeap(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x100000) != 0;
  }
  
  public void cancel(ImageView paramImageView)
  {
    ImageLoader.getInstance().cancelDisplayTask(paramImageView);
  }
  
  public void clearEventOutput() {}
  
  public void clearMemoryCache()
  {
    ImageLoader.getInstance().clearMemoryCache();
  }
  
  public void displayImage(String paramString, ImageView paramImageView)
  {
    ImageLoader.getInstance().displayImage(paramString, paramImageView);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    ImageLoader.getInstance().displayImage(paramString, paramImageView, new ImageSize(paramInt1, paramInt2));
  }
  
  public void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().displayImage(paramString, new ImageViewAware(paramImageView), convertDisplayImageOptions(paramDisplayImageOptions), new ImageSize(paramInt1, paramInt2), new ImageLoadingListenerWrapper(paramImageLoadingListener), null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().displayImage(paramString, new ImageViewAware(paramImageView), null, new ImageSize(paramInt1, paramInt2), new ImageLoadingListenerWrapper(paramImageLoadingListener), null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions)
  {
    ImageLoader.getInstance().displayImage(paramString, paramImageView, convertDisplayImageOptions(paramDisplayImageOptions));
  }
  
  public void displayImage(String paramString, ImageView paramImageView, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().displayImage(paramString, paramImageView, convertDisplayImageOptions(paramDisplayImageOptions), new ImageLoadingListenerWrapper(paramImageLoadingListener));
  }
  
  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().displayImage(paramString, paramImageView, new ImageLoadingListenerWrapper(paramImageLoadingListener));
  }
  
  public File getDiskCache(String paramString)
  {
    return ImageLoader.getInstance().getDiskCache().get(paramString);
  }
  
  public Bitmap getMemoryCache(String paramString)
  {
    return ImageLoader.getInstance().getMemoryCache().get(paramString);
  }
  
  public void init(String paramString, ImageOnLoadingLogListener paramImageOnLoadingLogListener)
  {
    this.cachePath = paramString;
    this.imageOnLoadingLogListener = paramImageOnLoadingLogListener;
  }
  
  public void loadImage(String paramString, int paramInt1, int paramInt2, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().loadImage(paramString, new ImageSize(paramInt1, paramInt2), convertDisplayImageOptions(paramDisplayImageOptions), new ImageLoadingListenerWrapper(paramImageLoadingListener), null);
  }
  
  public void loadImage(String paramString, int paramInt1, int paramInt2, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().loadImage(paramString, new ImageSize(paramInt1, paramInt2), new ImageLoadingListenerWrapper(paramImageLoadingListener));
  }
  
  public void loadImage(String paramString, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().loadImage(paramString, convertDisplayImageOptions(paramDisplayImageOptions), new ImageLoadingListenerWrapper(paramImageLoadingListener));
  }
  
  public void loadImage(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    ImageLoader.getInstance().loadImage(paramString, new ImageLoadingListenerWrapper(paramImageLoadingListener));
  }
  
  public Bitmap loadImageSync(String paramString, com.tencent.falco.base.libapi.imageloader.DisplayImageOptions paramDisplayImageOptions)
  {
    return ImageLoader.getInstance().loadImageSync(paramString, convertDisplayImageOptions(paramDisplayImageOptions));
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    int i = ((ActivityManager)localObject).getMemoryClass();
    if (isLargeHeap(paramContext)) {
      i = ((ActivityManager)localObject).getLargeMemoryClass();
    }
    for (;;)
    {
      i = i * 1048576 / 8;
      localObject = null;
      if (!TextUtils.isEmpty(this.cachePath)) {
        localObject = new UnlimitedDiskCache(new File(this.cachePath));
      }
      ImageLoaderComponent.3 local3 = new ImageLoaderComponent.3(this, paramContext);
      paramContext = new ImageLoaderConfiguration.Builder(paramContext).memoryCacheExtraOptions(800, 800).threadPoolSize(3).threadPriority(3).tasksProcessingOrder(QueueProcessingType.LIFO).diskCache((DiskCache)localObject).imageDownloader(local3).defaultDisplayImageOptions(com.nostra13.universalimageloader.core.DisplayImageOptions.createSimple()).memoryCache(new CustomizedLRUCache(i)).build();
      ImageLoader.getInstance().init(paramContext);
      ImageLoader.getInstance().setOnLoadingLogListener(new ImageLoaderComponent.4(this));
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void removeDiskCache(String paramString)
  {
    ImageLoader.getInstance().getDiskCache().remove(paramString);
  }
  
  public Bitmap removeMemoryCache(String paramString)
  {
    return ImageLoader.getInstance().getMemoryCache().remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoaderComponent
 * JD-Core Version:    0.7.0.1
 */