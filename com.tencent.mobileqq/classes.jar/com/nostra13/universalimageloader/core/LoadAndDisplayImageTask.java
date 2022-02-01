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
    if (!isTaskInterrupted()) {
      return;
    }
    throw new LoadAndDisplayImageTask.TaskCancelledException(this);
  }
  
  private void checkTaskNotActual()
  {
    checkViewCollected();
    checkViewReused();
  }
  
  private void checkViewCollected()
  {
    if (!isViewCollected()) {
      return;
    }
    throw new LoadAndDisplayImageTask.TaskCancelledException(this);
  }
  
  private void checkViewReused()
  {
    if (!isViewReused()) {
      return;
    }
    throw new LoadAndDisplayImageTask.TaskCancelledException(this);
  }
  
  private Bitmap decodeImage(String paramString)
  {
    ViewScaleType localViewScaleType = this.imageAware.getScaleType();
    paramString = new ImageDecodingInfo(this.memoryCacheKey, paramString, this.uri, this.targetSize, localViewScaleType, getDownloader(), this.options);
    return this.decoder.decode(paramString);
  }
  
  private boolean delayIfNeed()
  {
    if (this.options.shouldDelayBeforeLoading()) {
      L.d("Delay %d ms before loading...  [%s]", new Object[] { Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey });
    }
    try
    {
      Thread.sleep(this.options.getDelayBeforeLoading());
      return isTaskNotActual();
    }
    catch (InterruptedException localInterruptedException)
    {
      label55:
      break label55;
    }
    L.e("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
    return true;
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
    if (!this.syncLoading)
    {
      if (isTaskInterrupted()) {
        return;
      }
      runTask(new LoadAndDisplayImageTask.3(this), false, this.handler, this.engine);
    }
  }
  
  private void fireFailEvent(FailReason.FailType paramFailType, Throwable paramThrowable)
  {
    if ((!this.syncLoading) && (!isTaskInterrupted()))
    {
      if (isTaskNotActual()) {
        return;
      }
      runTask(new LoadAndDisplayImageTask.2(this, paramFailType, paramThrowable), false, this.handler, this.engine);
    }
  }
  
  private boolean fireProgressEvent(int paramInt1, int paramInt2)
  {
    if (!isTaskInterrupted())
    {
      if (isTaskNotActual()) {
        return false;
      }
      if (this.progressListener != null) {
        runTask(new LoadAndDisplayImageTask.1(this, paramInt1, paramInt2), false, this.handler, this.engine);
      }
      return true;
    }
    return false;
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
    if ((this.memoryCacheKey.equals(str) ^ true))
    {
      L.d("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { this.memoryCacheKey });
      return true;
    }
    return false;
  }
  
  private boolean resizeAndSaveImage(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.configuration.diskCache.get(this.uri);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((File)localObject1).exists())
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
        bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = this.configuration.diskCache.save(this.uri, (Bitmap)localObject1);
          ((Bitmap)localObject1).recycle();
        }
      }
    }
    return bool1;
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
    boolean bool1;
    try
    {
      boolean bool2 = downloadImage();
      bool1 = bool2;
      if (bool2)
      {
        int i = this.configuration.maxImageWidthForDiskCache;
        int j = this.configuration.maxImageHeightForDiskCache;
        if (i <= 0)
        {
          bool1 = bool2;
          if (j <= 0) {}
        }
        else
        {
          L.d("Resize image in disk cache [%s]", new Object[] { this.memoryCacheKey });
          resizeAndSaveImage(i, j);
          return bool2;
        }
      }
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
      bool1 = false;
    }
    return bool1;
  }
  
  /* Error */
  private Bitmap tryLoadBitmap()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   4: getfield 269	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:diskCache	Lcom/nostra13/universalimageloader/cache/disc/DiskCache;
    //   7: aload_0
    //   8: getfield 144	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:uri	Ljava/lang/String;
    //   11: invokeinterface 330 2 0
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +64 -> 82
    //   21: aload_1
    //   22: invokevirtual 335	java/io/File:exists	()Z
    //   25: ifeq +57 -> 82
    //   28: aload_1
    //   29: invokevirtual 441	java/io/File:length	()J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifle +48 -> 82
    //   37: ldc 36
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   49: aastore
    //   50: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: getstatic 444	com/nostra13/universalimageloader/core/assist/LoadedFrom:DISC_CACHE	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   57: putfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   60: aload_0
    //   61: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   64: aload_0
    //   65: getstatic 367	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:FILE	Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;
    //   68: aload_1
    //   69: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 375	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:wrap	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 448	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:decodeImage	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   78: astore_1
    //   79: goto +5 -> 84
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +40 -> 125
    //   88: aload_1
    //   89: astore_2
    //   90: aload_1
    //   91: astore_3
    //   92: aload_1
    //   93: astore 4
    //   95: aload_1
    //   96: astore 5
    //   98: aload_1
    //   99: invokevirtual 451	android/graphics/Bitmap:getWidth	()I
    //   102: ifle +23 -> 125
    //   105: aload_1
    //   106: astore_2
    //   107: aload_1
    //   108: astore_3
    //   109: aload_1
    //   110: astore 4
    //   112: aload_1
    //   113: astore 6
    //   115: aload_1
    //   116: astore 5
    //   118: aload_1
    //   119: invokevirtual 454	android/graphics/Bitmap:getHeight	()I
    //   122: ifgt +342 -> 464
    //   125: aload_1
    //   126: astore_2
    //   127: aload_1
    //   128: astore_3
    //   129: aload_1
    //   130: astore 4
    //   132: aload_1
    //   133: astore 5
    //   135: ldc 39
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_1
    //   152: astore_2
    //   153: aload_1
    //   154: astore_3
    //   155: aload_1
    //   156: astore 4
    //   158: aload_1
    //   159: astore 5
    //   161: aload_0
    //   162: getstatic 112	com/nostra13/universalimageloader/core/assist/LoadedFrom:NETWORK	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   165: putfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   168: aload_1
    //   169: astore_2
    //   170: aload_1
    //   171: astore_3
    //   172: aload_1
    //   173: astore 4
    //   175: aload_1
    //   176: astore 5
    //   178: aload_0
    //   179: getfield 144	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:uri	Ljava/lang/String;
    //   182: astore 7
    //   184: aload 7
    //   186: astore 6
    //   188: aload_1
    //   189: astore_2
    //   190: aload_1
    //   191: astore_3
    //   192: aload_1
    //   193: astore 4
    //   195: aload_1
    //   196: astore 5
    //   198: aload_0
    //   199: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   202: invokevirtual 457	com/nostra13/universalimageloader/core/DisplayImageOptions:isCacheOnDisk	()Z
    //   205: ifeq +84 -> 289
    //   208: aload 7
    //   210: astore 6
    //   212: aload_1
    //   213: astore_2
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_1
    //   220: astore 5
    //   222: aload_0
    //   223: invokespecial 459	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:tryCacheImageOnDisk	()Z
    //   226: ifeq +63 -> 289
    //   229: aload_1
    //   230: astore_2
    //   231: aload_1
    //   232: astore_3
    //   233: aload_1
    //   234: astore 4
    //   236: aload_1
    //   237: astore 5
    //   239: aload_0
    //   240: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   243: getfield 269	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:diskCache	Lcom/nostra13/universalimageloader/cache/disc/DiskCache;
    //   246: aload_0
    //   247: getfield 144	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:uri	Ljava/lang/String;
    //   250: invokeinterface 330 2 0
    //   255: astore 8
    //   257: aload 7
    //   259: astore 6
    //   261: aload 8
    //   263: ifnull +26 -> 289
    //   266: aload_1
    //   267: astore_2
    //   268: aload_1
    //   269: astore_3
    //   270: aload_1
    //   271: astore 4
    //   273: aload_1
    //   274: astore 5
    //   276: getstatic 367	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:FILE	Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;
    //   279: aload 8
    //   281: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   284: invokevirtual 375	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:wrap	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 6
    //   289: aload_1
    //   290: astore_2
    //   291: aload_1
    //   292: astore_3
    //   293: aload_1
    //   294: astore 4
    //   296: aload_1
    //   297: astore 5
    //   299: aload_0
    //   300: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   303: aload_1
    //   304: astore_2
    //   305: aload_1
    //   306: astore_3
    //   307: aload_1
    //   308: astore 4
    //   310: aload_1
    //   311: astore 5
    //   313: aload_0
    //   314: aload 6
    //   316: invokespecial 448	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:decodeImage	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   319: astore_1
    //   320: aload_1
    //   321: ifnull +40 -> 361
    //   324: aload_1
    //   325: astore_2
    //   326: aload_1
    //   327: astore_3
    //   328: aload_1
    //   329: astore 4
    //   331: aload_1
    //   332: astore 5
    //   334: aload_1
    //   335: invokevirtual 451	android/graphics/Bitmap:getWidth	()I
    //   338: ifle +23 -> 361
    //   341: aload_1
    //   342: astore_2
    //   343: aload_1
    //   344: astore_3
    //   345: aload_1
    //   346: astore 4
    //   348: aload_1
    //   349: astore 6
    //   351: aload_1
    //   352: astore 5
    //   354: aload_1
    //   355: invokevirtual 454	android/graphics/Bitmap:getHeight	()I
    //   358: ifgt +106 -> 464
    //   361: aload_1
    //   362: astore_2
    //   363: aload_1
    //   364: astore_3
    //   365: aload_1
    //   366: astore 4
    //   368: aload_1
    //   369: astore 5
    //   371: aload_0
    //   372: getstatic 465	com/nostra13/universalimageloader/core/assist/FailReason$FailType:DECODING_ERROR	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   375: aconst_null
    //   376: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireFailEvent	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   379: aload_1
    //   380: areturn
    //   381: astore_1
    //   382: goto +14 -> 396
    //   385: astore_1
    //   386: goto +27 -> 413
    //   389: astore_1
    //   390: goto +41 -> 431
    //   393: astore_1
    //   394: aconst_null
    //   395: astore_2
    //   396: aload_1
    //   397: invokestatic 429	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   400: aload_0
    //   401: getstatic 470	com/nostra13/universalimageloader/core/assist/FailReason$FailType:UNKNOWN	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   404: aload_1
    //   405: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireFailEvent	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   408: aload_2
    //   409: areturn
    //   410: astore_1
    //   411: aconst_null
    //   412: astore_3
    //   413: aload_1
    //   414: invokestatic 429	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   417: aload_0
    //   418: getstatic 473	com/nostra13/universalimageloader/core/assist/FailReason$FailType:OUT_OF_MEMORY	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   421: aload_1
    //   422: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireFailEvent	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   425: aload_3
    //   426: areturn
    //   427: astore_1
    //   428: aconst_null
    //   429: astore 4
    //   431: aload_1
    //   432: invokestatic 429	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   435: aload_0
    //   436: getstatic 476	com/nostra13/universalimageloader/core/assist/FailReason$FailType:IO_ERROR	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   439: aload_1
    //   440: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireFailEvent	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   443: aload 4
    //   445: areturn
    //   446: astore_1
    //   447: aload_1
    //   448: athrow
    //   449: aconst_null
    //   450: astore 5
    //   452: aload_0
    //   453: getstatic 479	com/nostra13/universalimageloader/core/assist/FailReason$FailType:NETWORK_DENIED	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   456: aconst_null
    //   457: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireFailEvent	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   460: aload 5
    //   462: astore 6
    //   464: aload 6
    //   466: areturn
    //   467: astore_1
    //   468: goto -19 -> 449
    //   471: astore_1
    //   472: goto -20 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	LoadAndDisplayImageTask
    //   16	364	1	localObject1	Object
    //   381	1	1	localThrowable1	Throwable
    //   385	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   389	1	1	localIOException1	IOException
    //   393	12	1	localThrowable2	Throwable
    //   410	12	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   427	13	1	localIOException2	IOException
    //   446	2	1	localTaskCancelledException	LoadAndDisplayImageTask.TaskCancelledException
    //   467	1	1	localIllegalStateException1	java.lang.IllegalStateException
    //   471	1	1	localIllegalStateException2	java.lang.IllegalStateException
    //   89	320	2	localObject2	Object
    //   91	335	3	localObject3	Object
    //   93	351	4	localObject4	Object
    //   96	365	5	localObject5	Object
    //   113	352	6	localObject6	Object
    //   182	76	7	str	String
    //   255	25	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   98	105	381	java/lang/Throwable
    //   118	125	381	java/lang/Throwable
    //   135	151	381	java/lang/Throwable
    //   161	168	381	java/lang/Throwable
    //   178	184	381	java/lang/Throwable
    //   198	208	381	java/lang/Throwable
    //   222	229	381	java/lang/Throwable
    //   239	257	381	java/lang/Throwable
    //   276	289	381	java/lang/Throwable
    //   299	303	381	java/lang/Throwable
    //   313	320	381	java/lang/Throwable
    //   334	341	381	java/lang/Throwable
    //   354	361	381	java/lang/Throwable
    //   371	379	381	java/lang/Throwable
    //   98	105	385	java/lang/OutOfMemoryError
    //   118	125	385	java/lang/OutOfMemoryError
    //   135	151	385	java/lang/OutOfMemoryError
    //   161	168	385	java/lang/OutOfMemoryError
    //   178	184	385	java/lang/OutOfMemoryError
    //   198	208	385	java/lang/OutOfMemoryError
    //   222	229	385	java/lang/OutOfMemoryError
    //   239	257	385	java/lang/OutOfMemoryError
    //   276	289	385	java/lang/OutOfMemoryError
    //   299	303	385	java/lang/OutOfMemoryError
    //   313	320	385	java/lang/OutOfMemoryError
    //   334	341	385	java/lang/OutOfMemoryError
    //   354	361	385	java/lang/OutOfMemoryError
    //   371	379	385	java/lang/OutOfMemoryError
    //   98	105	389	java/io/IOException
    //   118	125	389	java/io/IOException
    //   135	151	389	java/io/IOException
    //   161	168	389	java/io/IOException
    //   178	184	389	java/io/IOException
    //   198	208	389	java/io/IOException
    //   222	229	389	java/io/IOException
    //   239	257	389	java/io/IOException
    //   276	289	389	java/io/IOException
    //   299	303	389	java/io/IOException
    //   313	320	389	java/io/IOException
    //   334	341	389	java/io/IOException
    //   354	361	389	java/io/IOException
    //   371	379	389	java/io/IOException
    //   0	17	393	java/lang/Throwable
    //   21	79	393	java/lang/Throwable
    //   0	17	410	java/lang/OutOfMemoryError
    //   21	79	410	java/lang/OutOfMemoryError
    //   0	17	427	java/io/IOException
    //   21	79	427	java/io/IOException
    //   0	17	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   21	79	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   98	105	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   118	125	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   135	151	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   161	168	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   178	184	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   198	208	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   222	229	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   239	257	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   276	289	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   299	303	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   313	320	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   334	341	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   354	361	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   371	379	446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   0	17	467	java/lang/IllegalStateException
    //   21	79	467	java/lang/IllegalStateException
    //   98	105	471	java/lang/IllegalStateException
    //   118	125	471	java/lang/IllegalStateException
    //   135	151	471	java/lang/IllegalStateException
    //   161	168	471	java/lang/IllegalStateException
    //   178	184	471	java/lang/IllegalStateException
    //   198	208	471	java/lang/IllegalStateException
    //   222	229	471	java/lang/IllegalStateException
    //   239	257	471	java/lang/IllegalStateException
    //   276	289	471	java/lang/IllegalStateException
    //   299	303	471	java/lang/IllegalStateException
    //   313	320	471	java/lang/IllegalStateException
    //   334	341	471	java/lang/IllegalStateException
    //   354	361	471	java/lang/IllegalStateException
    //   371	379	471	java/lang/IllegalStateException
  }
  
  private boolean waitIfPaused()
  {
    AtomicBoolean localAtomicBoolean = this.engine.getPause();
    if (localAtomicBoolean.get()) {
      synchronized (this.engine.getPauseLock())
      {
        if (localAtomicBoolean.get()) {
          L.d("ImageLoader is paused. Waiting...  [%s]", new Object[] { this.memoryCacheKey });
        }
        try
        {
          this.engine.getPauseLock().wait();
          L.d(".. Resume loading [%s]", new Object[] { this.memoryCacheKey });
        }
        catch (InterruptedException localInterruptedException)
        {
          label77:
          break label77;
        }
        L.e("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
        return true;
      }
    } else {
      return isTaskNotActual();
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
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 118	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   20: getfield 506	com/nostra13/universalimageloader/core/ImageLoadingInfo:loadFromUriLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   23: astore_3
    //   24: ldc 57
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_3
    //   41: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   44: ifeq +19 -> 63
    //   47: ldc 69
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_3
    //   64: invokevirtual 514	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   67: aload_0
    //   68: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   71: aload_0
    //   72: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   75: getfield 518	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCache;
    //   78: aload_0
    //   79: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   82: invokeinterface 522 2 0
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +39 -> 128
    //   92: aload_2
    //   93: invokevirtual 525	android/graphics/Bitmap:isRecycled	()Z
    //   96: ifeq +6 -> 102
    //   99: goto +29 -> 128
    //   102: aload_0
    //   103: getstatic 528	com/nostra13/universalimageloader/core/assist/LoadedFrom:MEMORY_CACHE	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   106: putfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   109: ldc 33
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_0
    //   118: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: goto +145 -> 270
    //   128: aload_0
    //   129: invokespecial 530	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:tryLoadBitmap	()Landroid/graphics/Bitmap;
    //   132: astore_2
    //   133: aload_2
    //   134: ifnonnull +8 -> 142
    //   137: aload_3
    //   138: invokevirtual 533	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   141: return
    //   142: aload_0
    //   143: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   146: aload_0
    //   147: invokespecial 535	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskInterrupted	()V
    //   150: aload_2
    //   151: astore_1
    //   152: aload_0
    //   153: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   156: invokevirtual 538	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPreProcess	()Z
    //   159: ifeq +57 -> 216
    //   162: ldc 45
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   174: aastore
    //   175: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   182: invokevirtual 542	com/nostra13/universalimageloader/core/DisplayImageOptions:getPreProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   185: aload_2
    //   186: invokeinterface 391 2 0
    //   191: astore_2
    //   192: aload_2
    //   193: astore_1
    //   194: aload_2
    //   195: ifnonnull +21 -> 216
    //   198: ldc 18
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_0
    //   207: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 254	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_2
    //   215: astore_1
    //   216: aload_1
    //   217: astore_2
    //   218: aload_1
    //   219: ifnull +51 -> 270
    //   222: aload_1
    //   223: astore_2
    //   224: aload_0
    //   225: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   228: invokevirtual 545	com/nostra13/universalimageloader/core/DisplayImageOptions:isCacheInMemory	()Z
    //   231: ifeq +39 -> 270
    //   234: ldc 24
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_0
    //   243: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_0
    //   251: getfield 125	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   254: getfield 518	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCache;
    //   257: aload_0
    //   258: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   261: aload_1
    //   262: invokeinterface 548 3 0
    //   267: pop
    //   268: aload_1
    //   269: astore_2
    //   270: aload_2
    //   271: astore_1
    //   272: aload_2
    //   273: ifnull +69 -> 342
    //   276: aload_2
    //   277: astore_1
    //   278: aload_0
    //   279: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   282: invokevirtual 551	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPostProcess	()Z
    //   285: ifeq +57 -> 342
    //   288: ldc 42
    //   290: iconst_1
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload_0
    //   297: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   300: aastore
    //   301: invokestatic 242	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload_0
    //   305: getfield 156	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   308: invokevirtual 554	com/nostra13/universalimageloader/core/DisplayImageOptions:getPostProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   311: aload_2
    //   312: invokeinterface 391 2 0
    //   317: astore_2
    //   318: aload_2
    //   319: astore_1
    //   320: aload_2
    //   321: ifnonnull +21 -> 342
    //   324: ldc 15
    //   326: iconst_1
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_0
    //   333: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 254	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload_2
    //   341: astore_1
    //   342: aload_0
    //   343: invokespecial 446	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskNotActual	()V
    //   346: aload_0
    //   347: invokespecial 535	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskInterrupted	()V
    //   350: aload_3
    //   351: invokevirtual 533	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   354: new 556	com/nostra13/universalimageloader/core/DisplayBitmapTask
    //   357: dup
    //   358: aload_1
    //   359: aload_0
    //   360: getfield 118	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   363: aload_0
    //   364: getfield 116	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   367: aload_0
    //   368: getfield 114	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loadedFrom	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   371: invokespecial 559	com/nostra13/universalimageloader/core/DisplayBitmapTask:<init>	(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;)V
    //   374: aload_0
    //   375: getfield 170	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:syncLoading	Z
    //   378: aload_0
    //   379: getfield 120	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:handler	Landroid/os/Handler;
    //   382: aload_0
    //   383: getfield 116	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   386: invokestatic 289	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:runTask	(Ljava/lang/Runnable;ZLandroid/os/Handler;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;)V
    //   389: return
    //   390: astore_1
    //   391: goto +12 -> 403
    //   394: aload_0
    //   395: invokespecial 561	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:fireCancelEvent	()V
    //   398: aload_3
    //   399: invokevirtual 533	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   402: return
    //   403: aload_3
    //   404: invokevirtual 533	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   407: aload_1
    //   408: athrow
    //   409: astore_1
    //   410: goto -16 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	LoadAndDisplayImageTask
    //   151	208	1	localObject1	Object
    //   390	18	1	localObject2	Object
    //   409	1	1	localTaskCancelledException	LoadAndDisplayImageTask.TaskCancelledException
    //   87	254	2	localObject3	Object
    //   23	381	3	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   67	88	390	finally
    //   92	99	390	finally
    //   102	125	390	finally
    //   128	133	390	finally
    //   142	150	390	finally
    //   152	192	390	finally
    //   198	214	390	finally
    //   224	268	390	finally
    //   278	318	390	finally
    //   324	340	390	finally
    //   342	350	390	finally
    //   394	398	390	finally
    //   67	88	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   92	99	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   102	125	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   128	133	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   142	150	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   152	192	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   198	214	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   224	268	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   278	318	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   324	340	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
    //   342	350	409	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask$TaskCancelledException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
 * JD-Core Version:    0.7.0.1
 */