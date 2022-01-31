package com.tencent.component.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;
import com.tencent.component.media.utils.BitmapUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.Executor;

public abstract class ImageManagerEnv
{
  public static final int DECODING_FAILURE_CODE_BITMAP_EXCEPTION = 3;
  public static final int DECODING_FAILURE_CODE_BITMAP_NULL = 1;
  public static final int DECODING_FAILURE_CODE_BITMAP_OOM = 2;
  public static final int DECODING_FAILURE_CODE_BITMAP_THROWABLE = 4;
  public static final int DECODING_FAILURE_CODE_DELETE_SHARPP_CACHE = 5;
  public static final int DECODING_FAILURE_CODE_FAILED = 51000;
  public static final int DECODING_FAILURE_CODE_SUCCESS = 0;
  public static final String MTA_EVENT_KEY_IMAGE_DECODE = "qzone_image_decode";
  public static final String MTA_EVENT_KEY_SUPER_RESOLUTION = "qzone_super_resolution";
  public static final String MTA_EVENT_KEY_SUPER_RESOLUTION_EX = "qzone_super_resolution_ex";
  public static final String MTA_SUB_KEY_BENCHMARK = "benchmark";
  public static final String MTA_SUB_KEY_CPU_BENCHMARK = "cpu_benchmark";
  public static final String MTA_SUB_KEY_GPU_BENCHMARK = "gpu_benchmark";
  public static final String MTA_SUB_KEY_GPU_RATIO = "gpuRatio";
  public static final String MTA_SUB_KEY_IMAGE_TIME_COST = "image_time_cost";
  public static final String MTA_SUB_KEY_IS_HIGH_SCALE = "isHighScale";
  public static final String MTA_SUB_KEY_MIX_BENCHMARK = "mix_benchmark";
  public static final String MTA_SUB_KEY_MODEL_ID = "modelId";
  public static final String MTA_SUB_KEY_PHONE_TYPE = "PhoneType";
  public static final String MTA_SUB_KEY_SDK = "sdk";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_BENCHMARK = "super_resolution_benchmark";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_DECODE_AFTER_SHOW = "decode_after_show";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_DECODE_AFTER_SHOW_DELAY = "decode_after_show_delay";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_DECODE_BEFORE_SHOW = "decode_before_show";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_END_AFTER_SHOW = "sr_after_show";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_END_AFTER_SHOW_DELAY = "sr_after_show_delay";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_END_BEFORE_SHOW = "sr_before_show";
  public static final String MTA_SUB_KEY_SUPER_RESOLUTION_TIME_COST = "super_resolution_time_cost";
  public static final String MTA_SUB_KEY_TIME_COST = "timeCost";
  public static final String MTA_VALUE_BENCHMARK = "benchmark";
  public static final String MTA_VALUE_CPU_BENCHMARK = "cpu_benchmark";
  public static final String MTA_VALUE_DECODE_TIME = "decode_time";
  public static final String MTA_VALUE_DECODE_TIME_NONE_SR = "decode_time_none_sr";
  public static final String MTA_VALUE_DOWNLOAD_TIME = "download_time";
  public static final String MTA_VALUE_DOWNLOAD_TIME_NONE_SR = "download_time_none_sr";
  public static final String MTA_VALUE_GPU_BENCHMARK = "gpu_benchmark";
  public static final String MTA_VALUE_GPU_RATIO = "gpu_ratio";
  public static final String MTA_VALUE_MIX_BENCHMARK = "mix_benchmark";
  public static final String MTA_VALUE_POST_PROCESS_AFTER_SUPER_RESOLUTION = "post_process_after_super_resolution";
  public static final String MTA_VALUE_POST_PROCESS_AFTER_SUPER_RESOLUTION_HIGH_SCALE = "post_process_after_super_resolution_high_scale";
  public static final String MTA_VALUE_SUPER_RESOLUTION_CONVERT_CONFIG = "convert_config";
  public static final String MTA_VALUE_SUPER_RESOLUTION_DECODE_AFTER_SHOW = "sr_decode_after_show";
  public static final String MTA_VALUE_SUPER_RESOLUTION_DECODE_BEFORE_SHOW = "sr_decode_before_show";
  public static final String MTA_VALUE_SUPER_RESOLUTION_END_AFTER_SHOW = "sr_end_after_show";
  public static final String MTA_VALUE_SUPER_RESOLUTION_END_BEFORE_SHOW = "sr_end_before_show";
  public static final String MTA_VALUE_SUPER_RESOLUTION_LIB_CREATE = "lib_create";
  public static final String MTA_VALUE_SUPER_RESOLUTION_LIB_DESTROY = "lib_destroy";
  public static final String MTA_VALUE_SUPER_RESOLUTION_NATIVE_METHOD = "native_method";
  public static final String MTA_VALUE_SUPER_RESOLUTION_QUEUE_TIME = "queue_time";
  public static final String MTA_VALUE_SUPER_RESOLUTION_TOTAL_PROCEDURE = "super_resolution_total_procedure";
  public static final String MTA_VALUE_SUPER_RESOLUTION_TOTAL_PROCEDURE_HIGH_SCALE = "super_resolution_total_procedure_high_scale";
  public static final String QZONE_GIF_PLAYING_FAIL_COUNT_REPORT = "gifPlayingFailCountReport";
  public static final String QZONE_GIF_PLAYING_REPORT = "gifPlayingReportNew";
  public static final int TASK_TYPE_PARALLEL_RENDER_TASK = 2;
  public static final int TASK_TYPE_SERIAL_RENDER_TASK = 1;
  private static volatile Context appContext;
  static HandlerThread sHandlerThread = null;
  private static volatile ImageManagerEnv sInstance = null;
  private static volatile ILog sLogger;
  
  public static ImageManagerEnv g()
  {
    if (sInstance == null) {
      throw new RuntimeException("ImageManagerEnv 没有初始化！！！");
    }
    return sInstance;
  }
  
  public static Context getAppContext()
  {
    try
    {
      Context localContext = appContext;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static ILog getLogger()
  {
    return sLogger;
  }
  
  public static void init(Context paramContext, ImageManagerEnv paramImageManagerEnv, ILog paramILog)
  {
    try
    {
      appContext = paramContext;
      sInstance = paramImageManagerEnv;
      sLogger = paramILog;
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public abstract boolean canDoSuperResolution(int paramInt1, int paramInt2);
  
  public abstract boolean checkShouldRunSuperResolutionBenchmark();
  
  public abstract boolean checkSuperResolutionSo();
  
  public abstract void clearSuperResolutionBenchmark();
  
  public abstract boolean closeNativeAndinBitmap();
  
  public abstract String convertSrUrlToBigUrl(String paramString);
  
  public abstract boolean copyFiles(File paramFile1, File paramFile2);
  
  public abstract Bitmap doSuperResolution(Bitmap paramBitmap, int paramInt);
  
  public BitmapReference drawableToBitmap(Drawable paramDrawable)
  {
    BitmapReference localBitmapReference = null;
    if ((paramDrawable instanceof SpecifiedBitmapDrawable)) {
      localBitmapReference = ((SpecifiedBitmapDrawable)paramDrawable).getBitmapRef();
    }
    do
    {
      return localBitmapReference;
      if ((paramDrawable instanceof BitmapRefDrawable)) {
        return ((BitmapRefDrawable)paramDrawable).getBitmapRef();
      }
      if ((paramDrawable instanceof BitmapDrawable)) {
        return BitmapReference.getBitmapReference(((BitmapDrawable)paramDrawable).getBitmap());
      }
      if ((paramDrawable instanceof ImageDrawable)) {
        return ((ImageDrawable)paramDrawable).getBitmapRef();
      }
    } while (!(paramDrawable instanceof SpecifiedDrawable));
    return BitmapUtils.drawableToBitmapByCanvas(paramDrawable);
  }
  
  public abstract boolean enableBitmapNativeAlloc();
  
  public abstract boolean enableReportNoneSuperResolutionTime();
  
  public abstract boolean enableSocketMonitor();
  
  public abstract boolean enableSuperResolution();
  
  public abstract boolean enableSuperResolutionHighScale();
  
  public abstract float getAnimationDrawableCacheRatio();
  
  public abstract String getAvatarPath(String paramString);
  
  public abstract String getBenchmarkImagePath();
  
  public abstract float getCacheMemRatio();
  
  public abstract boolean getCurrentLoadingImgStatus();
  
  public abstract int getCurrentSuperResolutionModelId();
  
  public abstract int getDecodeThreadNum(boolean paramBoolean);
  
  public abstract int getDefaultSuperResolutionModelId();
  
  public abstract float getDesity();
  
  public abstract Looper getDispatcher();
  
  public abstract IDownloader getDownloader(ImageManagerEnv.ImageDownloaderListener paramImageDownloaderListener);
  
  public abstract Executor getExecutor();
  
  public abstract Looper getFileThreadLooper();
  
  public abstract int getHaboReportSampleRange();
  
  public abstract String getImageBigUrlSegment();
  
  public abstract String getImageCacheDir(boolean paramBoolean);
  
  public abstract String getImageCurrentUrlSegment();
  
  public abstract int getMaxGifRenderThreadNum();
  
  public abstract int getMaxNumOfDecodingFailures();
  
  public abstract int getMinMemoryClassInArt();
  
  public abstract int getModelIdFromUrl(String paramString);
  
  public abstract int getNetWorkState();
  
  public abstract long getNoCacheImageExpiredTime();
  
  public abstract Drawable getPhotoGifDefaultDrawable();
  
  public abstract String getProcessName(Context paramContext);
  
  public abstract String getQAParameterRex();
  
  public abstract MQLruCache getQQImagecache();
  
  public abstract int getRotationDegree(String paramString);
  
  public abstract String getSRParameterRex();
  
  public abstract int getScreenHeight();
  
  public abstract int getScreenWidth();
  
  public abstract String getSocketMonitorUrl(String paramString, ImageLoader.Options paramOptions);
  
  public abstract int getSuperResolutionBenchmark();
  
  public abstract String getSuperResolutionDownloadedModelList();
  
  public abstract String getSuperResolutionGpuMaxSize();
  
  public abstract float getSuperResolutionGpuPercent();
  
  public abstract Pair<Float, Float> getSuperResolutionGpuRatioBoundary();
  
  public abstract int getSuperResolutionHighScaleModelId();
  
  public abstract int getSuperResolutionLastModelId();
  
  public abstract int getSuperResolutionMemoryThreshold();
  
  public abstract float getSuperResolutionScaleByModelId(int paramInt);
  
  public abstract Drawable getWatermarkLogoDrawable();
  
  public abstract boolean hasSuperResolutionInit();
  
  public abstract boolean isBigUrl(String paramString);
  
  public abstract boolean isForceShutdownGif();
  
  public abstract boolean isGifSupport565();
  
  public abstract boolean isHighScaleUrl(String paramString);
  
  public abstract boolean isMainProcess(Context paramContext);
  
  public abstract boolean isNeedRecycle();
  
  public abstract boolean isOpenGetImageSuccessRecorder();
  
  public abstract boolean isPreferNewAnimationImp();
  
  public abstract boolean isPreferNewGifDecodeTask();
  
  public abstract boolean isQQProcess(Context paramContext);
  
  public abstract boolean isSuperResolutionEnvReady();
  
  public abstract boolean isSuperResolutionModelReady(int paramInt);
  
  public abstract boolean isSuperResolutionUrl(String paramString);
  
  public abstract boolean isSupportGifPlaying();
  
  public abstract boolean isSupportSharpp();
  
  public abstract boolean isWNSSupportPieceLoad();
  
  public abstract boolean loadLibrary(String paramString);
  
  public abstract int loadSuperResolutionLibrary();
  
  public abstract Pair<String, String> loadSuperResolutionModelFile(int paramInt);
  
  public abstract boolean needCheckAvatar();
  
  public abstract boolean needRerunSuperResolutionBenchmark(String paramString);
  
  public abstract boolean needSuperResolution(String paramString);
  
  public abstract boolean openProgressTracer();
  
  public abstract int panoramaComputeSampleSize(ImageLoader.Options paramOptions, int paramInt1, int paramInt2);
  
  public abstract void prepareSuperResolutionEnv();
  
  public abstract String removeSocketMonitorParam(String paramString);
  
  public abstract void reportAnimationDrawableSize(int paramInt);
  
  public abstract void reportEventToMTA(String paramString, Properties paramProperties);
  
  public abstract void reportException(Throwable paramThrowable);
  
  public abstract void reportGetImageCacheToMM(int paramInt);
  
  public abstract void reportGifFrameRate(int paramInt, float paramFloat1, float paramFloat2);
  
  public abstract void reportImageDecodingRes(String paramString1, String paramString2, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt);
  
  public abstract void reportImageDecodingResMTA(String paramString1, String paramString2);
  
  public abstract void reportImageDecodingTask(String paramString1, String paramString2, long paramLong1, int paramInt, String paramString3, long paramLong2);
  
  public abstract void reportImageTimeCostMTA(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void runSuperResolutionBenchmark(boolean paramBoolean);
  
  public abstract void saveSuperResolutionGpuPercent(float paramFloat);
  
  public abstract void saveSuperResolutionLastModelId(int paramInt);
  
  public abstract boolean shouldPlayAnimWebp();
  
  public abstract boolean shouldPlayPhotoGif();
  
  public abstract void showToast(int paramInt1, Context paramContext, CharSequence paramCharSequence, int paramInt2);
  
  public abstract void startSuperResolutionModelDownload(int paramInt);
  
  public abstract void statisticCollectorReport(String paramString, HashMap<String, String> paramHashMap);
  
  public abstract void tryInitSuperResolutionLibrary();
  
  public abstract void updateSuperResolutionDownloadedModel();
  
  public abstract boolean useARGB8888Config();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.ImageManagerEnv
 * JD-Core Version:    0.7.0.1
 */