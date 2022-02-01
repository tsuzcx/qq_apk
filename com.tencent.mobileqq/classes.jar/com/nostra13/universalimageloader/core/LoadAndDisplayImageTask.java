package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListenerWrapper;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

final class LoadAndDisplayImageTask
  implements IoUtils.CopyListener, Runnable
{
  private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
  private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
  private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
  private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
  private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
  private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
  private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
  private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
  private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
  private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
  private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
  private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
  private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
  private final ImageLoaderConfiguration configuration;
  private final ImageDecoder decoder;
  private final ImageDownloader downloader;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  final ImageAware imageAware;
  private final ImageLoadingInfo imageLoadingInfo;
  final ImageLoadingListenerWrapper listener;
  private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
  private final String memoryCacheKey;
  private final ImageDownloader networkDeniedDownloader;
  final DisplayImageOptions options;
  final ImageLoadingProgressListener progressListener;
  private final ImageDownloader slowNetworkDownloader;
  private final boolean syncLoading;
  private final ImageSize targetSize;
  final String uri;
  
  public LoadAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
    this.configuration = paramImageLoaderEngine.configuration;
    this.downloader = this.configuration.downloader;
    this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
    this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
    this.decoder = this.configuration.decoder;
    this.uri = paramImageLoadingInfo.uri;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.imageAware = paramImageLoadingInfo.imageAware;
    this.targetSize = paramImageLoadingInfo.targetSize;
    this.options = paramImageLoadingInfo.options;
    this.listener = paramImageLoadingInfo.listener;
    this.progressListener = paramImageLoadingInfo.progressListener;
    this.syncLoading = this.options.isSyncLoading();
  }
  
  private void checkTaskInterrupted()
  {
    if (isTaskInterrupted()) {
      throw new LoadAndDisplayImageTask.TaskCancelledException(this);
    }
  }
  
  private void checkTaskNotActual()
  {
    checkViewCollected();
    checkViewReused();
  }
  
  private void checkViewCollected()
  {
    if (isViewCollected()) {
      throw new LoadAndDisplayImageTask.TaskCancelledException(this);
    }
  }
  
  private void checkViewReused()
  {
    if (isViewReused()) {
      throw new LoadAndDisplayImageTask.TaskCancelledException(this);
    }
  }
  
  private Bitmap decodeImage(String paramString)
  {
    ViewScaleType localViewScaleType = this.imageAware.getScaleType();
    paramString = new ImageDecodingInfo(this.memoryCacheKey, paramString, this.uri, this.targetSize, localViewScaleType, getDownloader(), this.options);
    return this.decoder.decode(paramString);
  }
  
  private boolean delayIfNeed()
  {
    if (this.options.shouldDelayBeforeLoading())
    {
      L.d("Delay %d ms before loading...  [%s]", new Object[] { Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey });
      try
      {
        Thread.sleep(this.options.getDelayBeforeLoading());
        return isTaskNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        L.e("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
        return true;
      }
    }
    return false;
  }
  
  private boolean downloadImage()
  {
    InputStream localInputStream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
    if (localInputStream == null)
    {
      L.e("No stream for image [%s]", new Object[] { this.memoryCacheKey });
      return false;
    }
    try
    {
      boolean bool = this.configuration.diskCache.save(this.uri, localInputStream, this);
      return bool;
    }
    finally
    {
      IoUtils.closeSilently(localInputStream);
    }
  }
  
  private void fireCancelEvent()
  {
    if ((this.syncLoading) || (isTaskInterrupted())) {
      return;
    }
    runTask(new LoadAndDisplayImageTask.3(this), false, this.handler, this.engine);
  }
  
  private void fireFailEvent(FailReason.FailType paramFailType, Throwable paramThrowable)
  {
    if ((this.syncLoading) || (isTaskInterrupted()) || (isTaskNotActual())) {
      return;
    }
    runTask(new LoadAndDisplayImageTask.2(this, paramFailType, paramThrowable), false, this.handler, this.engine);
  }
  
  private boolean fireProgressEvent(int paramInt1, int paramInt2)
  {
    if ((isTaskInterrupted()) || (isTaskNotActual())) {
      return false;
    }
    if (this.progressListener != null) {
      runTask(new LoadAndDisplayImageTask.1(this, paramInt1, paramInt2), false, this.handler, this.engine);
    }
    return true;
  }
  
  private ImageDownloader getDownloader()
  {
    if (this.engine.isNetworkDenied()) {
      return this.networkDeniedDownloader;
    }
    if (this.engine.isSlowNetwork()) {
      return this.slowNetworkDownloader;
    }
    return this.downloader;
  }
  
  private boolean isTaskInterrupted()
  {
    if (Thread.interrupted())
    {
      L.d("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
      return true;
    }
    return false;
  }
  
  private boolean isTaskNotActual()
  {
    return (isViewCollected()) || (isViewReused());
  }
  
  private boolean isViewCollected()
  {
    if (this.imageAware.isCollected())
    {
      L.d("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] { this.memoryCacheKey });
      return true;
    }
    return false;
  }
  
  private boolean isViewReused()
  {
    String str = this.engine.getLoadingUriForView(this.imageAware);
    if (!this.memoryCacheKey.equals(str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      L.d("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { this.memoryCacheKey });
      return true;
    }
    return false;
  }
  
  private boolean resizeAndSaveImage(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.configuration.diskCache.get(this.uri);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      Object localObject2 = new ImageSize(paramInt1, paramInt2);
      DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
      localObject1 = new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(((File)localObject1).getAbsolutePath()), this.uri, (ImageSize)localObject2, ViewScaleType.FIT_INSIDE, getDownloader(), localDisplayImageOptions);
      localObject2 = this.decoder.decode((ImageDecodingInfo)localObject1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (this.configuration.processorForDiskCache != null)
        {
          L.d("Process image before cache on disk [%s]", new Object[] { this.memoryCacheKey });
          localObject2 = this.configuration.processorForDiskCache.process((Bitmap)localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            L.e("Bitmap processor for disk cache returned null [%s]", new Object[] { this.memoryCacheKey });
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null)
      {
        boolean bool = this.configuration.diskCache.save(this.uri, (Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
        return bool;
      }
    }
    return false;
  }
  
  static void runTask(Runnable paramRunnable, boolean paramBoolean, Handler paramHandler, ImageLoaderEngine paramImageLoaderEngine)
  {
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    if (paramHandler == null)
    {
      paramImageLoaderEngine.fireCallback(paramRunnable);
      return;
    }
    paramHandler.post(paramRunnable);
  }
  
  private boolean tryCacheImageOnDisk()
  {
    L.d("Cache image on disk [%s]", new Object[] { this.memoryCacheKey });
    try
    {
      boolean bool = downloadImage();
      if (bool)
      {
        int i = this.configuration.maxImageWidthForDiskCache;
        int j = this.configuration.maxImageHeightForDiskCache;
        if ((i > 0) || (j > 0))
        {
          L.d("Resize image in disk cache [%s]", new Object[] { this.memoryCacheKey });
          resizeAndSaveImage(i, j);
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
    }
    return false;
  }
  
  private Bitmap tryLoadBitmap()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.configuration.diskCache.get(this.uri);
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
        {
          L.d("Load image from disk cache [%s]", new Object[] { this.memoryCacheKey });
          this.loadedFrom = LoadedFrom.DISC_CACHE;
          checkTaskNotActual();
          localObject1 = decodeImage(ImageDownloader.Scheme.FILE.wrap(((File)localObject1).getAbsolutePath()));
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
          }
        }
        Object localObject7;
        String str;
        File localFile;
        Object localObject2 = null;
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        try
        {
          if (((Bitmap)localObject1).getWidth() > 0)
          {
            localObject7 = localObject1;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (((Bitmap)localObject1).getHeight() > 0) {}
          }
          else
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            L.d("Load image from network [%s]", new Object[] { this.memoryCacheKey });
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            this.loadedFrom = LoadedFrom.NETWORK;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            str = this.uri;
            localObject7 = str;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (this.options.isCacheOnDisk())
            {
              localObject7 = str;
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (tryCacheImageOnDisk())
              {
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                localFile = this.configuration.diskCache.get(this.uri);
                localObject7 = str;
                if (localFile != null)
                {
                  localObject3 = localObject1;
                  localObject4 = localObject1;
                  localObject5 = localObject1;
                  localObject6 = localObject1;
                  localObject7 = ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath());
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            checkTaskNotActual();
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            localObject1 = decodeImage((String)localObject7);
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (((Bitmap)localObject1).getWidth() > 0)
              {
                localObject7 = localObject1;
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                if (((Bitmap)localObject1).getHeight() > 0) {
                  continue;
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
            localObject7 = localObject1;
          }
          return localObject7;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          continue;
        }
        localIllegalStateException1 = localIllegalStateException1;
        localObject6 = null;
        fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
        return localObject6;
      }
      catch (LoadAndDisplayImageTask.TaskCancelledException localTaskCancelledException)
      {
        throw localTaskCancelledException;
      }
      catch (IOException localIOException1)
      {
        localObject5 = null;
        L.e(localIOException1);
        fireFailEvent(FailReason.FailType.IO_ERROR, localIOException1);
        return localObject5;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject4 = null;
        L.e(localOutOfMemoryError1);
        fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, localOutOfMemoryError1);
        return localObject4;
      }
      catch (Throwable localThrowable1)
      {
        localObject3 = null;
        L.e(localThrowable1);
        fireFailEvent(FailReason.FailType.UNKNOWN, localThrowable1);
        return localObject3;
      }
    }
  }
  
  private boolean waitIfPaused()
  {
    AtomicBoolean localAtomicBoolean = this.engine.getPause();
    if (localAtomicBoolean.get()) {}
    synchronized (this.engine.getPauseLock())
    {
      if (localAtomicBoolean.get()) {
        L.d("ImageLoader is paused. Waiting...  [%s]", new Object[] { this.memoryCacheKey });
      }
      try
      {
        this.engine.getPauseLock().wait();
        L.d(".. Resume loading [%s]", new Object[] { this.memoryCacheKey });
        return isTaskNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        L.e("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
        return true;
      }
    }
  }
  
  String getLoadingUri()
  {
    return this.uri;
  }
  
  public boolean onBytesCopied(int paramInt1, int paramInt2)
  {
    return (this.syncLoading) || (fireProgressEvent(paramInt1, paramInt2));
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 500	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:waitIfPaused	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 502	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:delayIfNeed	()Z
    //   12: ifne -5 -> 7
    //   15: aload_0
    //   16: getfield 118	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   19: getfield 506	com/nostra13/universalimageloader/core/ImageLoadingInfo:loadFromUriLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: astore_3
    //   23: ldc 57
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_3
    //   40: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   43: ifeq +19 -> 62
    //   46: ldc 69
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   58: aastore
    //   59: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aload_3
    //   63: invokevirtual 514	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   70: aload_0
    //   71: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   74: getfield 518	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCache;
    //   77: aload_0
    //   78: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   81: invokeinterface 522 2 0
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +10 -> 98
    //   91: aload_2
    //   92: invokevirtual 525	android/graphics/Bitmap:isRecycled	()Z
    //   95: ifeq +265 -> 360
    //   98: aload_0
    //   99: invokespecial 527	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:tryLoadBitmap	()Landroid/graphics/Bitmap;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnonnull +8 -> 112
    //   107: aload_3
    //   108: invokevirtual 530	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   111: return
    //   112: aload_0
    //   113: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   116: aload_0
    //   117: invokespecial 532	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskInterrupted	()V
    //   120: aload_2
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   126: invokevirtual 535	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPreProcess	()Z
    //   129: ifeq +57 -> 186
    //   132: ldc 45
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   152: invokevirtual 539	com/nostra13/universalimageloader/core/DisplayImageOptions:getPreProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   155: aload_2
    //   156: invokeinterface 391 2 0
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: aload_2
    //   165: ifnonnull +21 -> 186
    //   168: ldc 18
    //   170: iconst_1
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   180: aastore
    //   181: invokestatic 254	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: aload_1
    //   189: ifnull +51 -> 240
    //   192: aload_1
    //   193: astore_2
    //   194: aload_0
    //   195: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   198: invokevirtual 542	com/nostra13/universalimageloader/core/DisplayImageOptions:isCacheInMemory	()Z
    //   201: ifeq +39 -> 240
    //   204: ldc 24
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_0
    //   213: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_0
    //   221: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   224: getfield 518	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCache;
    //   227: aload_0
    //   228: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   231: aload_1
    //   232: invokeinterface 545 3 0
    //   237: pop
    //   238: aload_1
    //   239: astore_2
    //   240: aload_2
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +69 -> 312
    //   246: aload_2
    //   247: astore_1
    //   248: aload_0
    //   249: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   252: invokevirtual 548	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPostProcess	()Z
    //   255: ifeq +57 -> 312
    //   258: ldc 42
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   270: aastore
    //   271: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_0
    //   275: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   278: invokevirtual 551	com/nostra13/universalimageloader/core/DisplayImageOptions:getPostProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   281: aload_2
    //   282: invokeinterface 391 2 0
    //   287: astore_2
    //   288: aload_2
    //   289: astore_1
    //   290: aload_2
    //   291: ifnonnull +21 -> 312
    //   294: ldc 15
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_0
    //   303: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 254	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload_2
    //   311: astore_1
    //   312: aload_0
    //   313: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   316: aload_0
    //   317: invokespecial 532	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskInterrupted	()V
    //   320: aload_3
    //   321: invokevirtual 530	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   324: new 553	com/nostra13/universalimageloader/core/DisplayBitmapTask
    //   327: dup
    //   328: aload_1
    //   329: aload_0
    //   330: getfield 118	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   333: aload_0
    //   334: getfield 116	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   337: aload_0
    //   338: getfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   341: invokespecial 556	com/nostra13/universalimageloader/core/DisplayBitmapTask:<init>	(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;)V
    //   344: aload_0
    //   345: getfield 170	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:syncLoading	Z
    //   348: aload_0
    //   349: getfield 120	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:handler	Landroid/os/Handler;
    //   352: aload_0
    //   353: getfield 116	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   356: invokestatic 289	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:runTask	(Ljava/lang/Runnable;ZLandroid/os/Handler;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;)V
    //   359: return
    //   360: aload_0
    //   361: getstatic 559	com/nostra13/universalimageloader/core/assist/LoadedFrom:MEMORY_CACHE	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   364: putfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   367: ldc 33
    //   369: iconst_1
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload_0
    //   376: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   379: aastore
    //   380: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: goto -143 -> 240
    //   386: astore_1
    //   387: aload_0
    //   388: invokespecial 561	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireCancelEvent	()V
    //   391: aload_3
    //   392: invokevirtual 530	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   395: return
    //   396: astore_1
    //   397: aload_3
    //   398: invokevirtual 530	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   401: aload_1
    //   402: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	LoadAndDisplayImageTask
    //   121	208	1	localObject1	Object
    //   386	1	1	localTaskCancelledException	LoadAndDisplayImageTask.TaskCancelledException
    //   396	6	1	localObject2	Object
    //   86	225	2	localObject3	Object
    //   22	376	3	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   66	87	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   91	98	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   98	103	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   112	120	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   122	162	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   168	184	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   194	238	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   248	288	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   294	310	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   312	320	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   360	383	386	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   66	87	396	finally
    //   91	98	396	finally
    //   98	103	396	finally
    //   112	120	396	finally
    //   122	162	396	finally
    //   168	184	396	finally
    //   194	238	396	finally
    //   248	288	396	finally
    //   294	310	396	finally
    //   312	320	396	finally
    //   360	383	396	finally
    //   387	391	396	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
 * JD-Core Version:    0.7.0.1
 */