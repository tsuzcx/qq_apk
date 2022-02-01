package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.LruCache;
import java.util.concurrent.ConcurrentHashMap;

public class ImageTaskTracer
{
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed = 8;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding = 4;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending = 3;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download = 2;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed = 10;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle = 9;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode = 6;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted = 5;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull = 7;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest = 1;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize = 14;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll = 15;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_NO_CODE = 12;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch = 13;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other = 11;
  private static int MM_REPORT_GET_IMAGE_SUCCESS_CODE;
  public static boolean OPEN_GET_IMAGE_SUCCESS_RECORDER;
  private static Object PLACEHOLDER = new Object();
  private static LruCache<Integer, Object> mImageDecodeFailedRecorder = new LruCache(150);
  private static ConcurrentHashMap<Integer, Object> mImageDecodeThreadDecodingRecorder;
  private static ConcurrentHashMap<Integer, Object> mImageDecodeThreadPendingRecorder;
  private static LruCache<String, Object> mImageDownloadFailedRecorder = new LruCache(150);
  private static ConcurrentHashMap<String, Object> mImageDownloadRecorder;
  private static LruCache<Integer, Object> mImageLruCacheEvictedRecorder;
  private static ConcurrentHashMap<Integer, Object> mImageMsgGetNullRecorder;
  private static ConcurrentHashMap<Integer, Object> mImagePreDecodeRequestRecorder;
  private static ConcurrentHashMap<String, Integer> mImagePreDecodeRequest_DecodeOptions = new ConcurrentHashMap();
  private static ConcurrentHashMap<Integer, Object> mImagePreDecodeRequest_ExceedMemorySize = new ConcurrentHashMap();
  private static ConcurrentHashMap<Integer, Object> mImageTaskLifeCycleRecorder;
  private static ConcurrentHashMap<String, Object> mhasImagePreDecodeRequestIntrinsic = new ConcurrentHashMap();
  
  static
  {
    OPEN_GET_IMAGE_SUCCESS_RECORDER = ImageManagerEnv.g().isOpenGetImageSuccessRecorder();
    mImagePreDecodeRequestRecorder = new ConcurrentHashMap();
    mImageDecodeThreadPendingRecorder = new ConcurrentHashMap();
    mImageDecodeThreadDecodingRecorder = new ConcurrentHashMap();
    mImageLruCacheEvictedRecorder = new LruCache(250);
    mImageDownloadRecorder = new ConcurrentHashMap();
    mImageMsgGetNullRecorder = new ConcurrentHashMap();
    mImageTaskLifeCycleRecorder = new ConcurrentHashMap();
  }
  
  public static void addImageDecodeFailedRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      LruCache localLruCache = mImageDecodeFailedRecorder;
      if (localLruCache != null) {
        localLruCache.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addImageDecodeThreadDecodingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadDecodingRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addImageDecodeThreadPendingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadPendingRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addImageDownloadFailedRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      LruCache localLruCache = mImageDownloadFailedRecorder;
      if (localLruCache != null) {
        localLruCache.put(paramString, PLACEHOLDER);
      }
    }
  }
  
  public static void addImageDownloadRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDownloadRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(paramString, PLACEHOLDER);
      }
    }
  }
  
  public static void addImageLruCacheEvictedRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      LruCache localLruCache = mImageLruCacheEvictedRecorder;
      if (localLruCache != null) {
        localLruCache.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addImageMsgGetNullRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageMsgGetNullRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addImagePreDecodeOptionsRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequest_DecodeOptions;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(paramString, Integer.valueOf(getHashCodeEx(paramString, paramOptions)));
      }
    }
  }
  
  public static void addImagePreDecodeRequestRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequestRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(getHashCodeEx(paramString, paramOptions)), PLACEHOLDER);
      }
    }
  }
  
  public static void addImagePreExceedMemorySizeRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequest_ExceedMemorySize;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(getHashCodeEx(paramString, paramOptions)), PLACEHOLDER);
      }
    }
  }
  
  public static void addImageTaskLifeCycleRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageTaskLifeCycleRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Integer.valueOf(paramInt), PLACEHOLDER);
      }
    }
  }
  
  public static void addhasImagePreDecodeRequestIntrinsicRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      paramOptions = mhasImagePreDecodeRequestIntrinsic;
      if (paramOptions != null) {
        paramOptions.put(paramString, PLACEHOLDER);
      }
    }
  }
  
  private static int getHashCodeEx(String paramString, ImageLoader.Options paramOptions)
  {
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    return localImageKey.hashCodeEx();
  }
  
  public static boolean hasImageDecodeFailedRecord(int paramInt)
  {
    boolean bool3 = OPEN_GET_IMAGE_SUCCESS_RECORDER;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      LruCache localLruCache = mImageDecodeFailedRecorder;
      bool1 = bool2;
      if (localLruCache != null)
      {
        bool1 = bool2;
        if (localLruCache.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDecodeThreadDecodingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadDecodingRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean hasImageDecodeThreadPendingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadPendingRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean hasImageDownloadFailedRecord(String paramString)
  {
    boolean bool3 = OPEN_GET_IMAGE_SUCCESS_RECORDER;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      LruCache localLruCache = mImageDownloadFailedRecorder;
      bool1 = bool2;
      if (localLruCache != null)
      {
        bool1 = bool2;
        if (localLruCache.get(paramString) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDownloadRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDownloadRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(paramString);
      }
    }
    return false;
  }
  
  public static boolean hasImageLruCacheEvictedRecord(int paramInt)
  {
    boolean bool3 = OPEN_GET_IMAGE_SUCCESS_RECORDER;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      LruCache localLruCache = mImageLruCacheEvictedRecorder;
      bool1 = bool2;
      if (localLruCache != null)
      {
        bool1 = bool2;
        if (localLruCache.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageMsgGetNullRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageMsgGetNullRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeOptionsRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequest_DecodeOptions;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(paramString);
      }
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestIntrinsicRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mhasImagePreDecodeRequestIntrinsic;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(paramString);
      }
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequestRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean hasImagePreExceedMemorySizeRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImagePreDecodeRequest_ExceedMemorySize;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean hasImageTaskLifeCycleRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageTaskLifeCycleRecorder;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static void removeImageDecodeThreadDecodingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadDecodingRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public static void removeImageDecodeThreadPendingRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDecodeThreadPendingRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public static void removeImageDownloadRecord(String paramString)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageDownloadRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(paramString);
      }
    }
  }
  
  public static void removeImageMsgGetNullRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageMsgGetNullRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public static void removeImageTaskLifeCycleRecord(int paramInt)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mImageTaskLifeCycleRecorder;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public static void traceImageGet(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      if (paramBoolean)
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_SUCCESS_CODE);
        return;
      }
      if (!hasImagePreDecodeRequestRecord(paramImageKey.hashCodeEx()))
      {
        if (!hasImagePreDecodeRequestIntrinsicRecord(paramImageKey.url)) {
          return;
        }
        if (hasImagePreDecodeOptionsRecord(paramImageKey.url))
        {
          ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch);
          return;
        }
        if (hasImagePreExceedMemorySizeRecord(paramImageKey.hashCodeEx()))
        {
          ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize);
          return;
        }
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll);
        return;
      }
      if (hasImageDownloadRecord(paramImageKey.urlKey))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download);
        return;
      }
      if (hasImageDecodeThreadPendingRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending);
        return;
      }
      if (hasImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding);
        return;
      }
      if (hasImageLruCacheEvictedRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted);
        return;
      }
      if (ImageTaskManager.getInstance().hasWaitToDecodeImageTask(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode);
        return;
      }
      if (hasImageMsgGetNullRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull);
        return;
      }
      if (hasImageDecodeFailedRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed);
        return;
      }
      if (hasImageTaskLifeCycleRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle);
        return;
      }
      if (hasImageDownloadFailedRecord(paramImageKey.urlKey))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed);
        return;
      }
      ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskTracer
 * JD-Core Version:    0.7.0.1
 */