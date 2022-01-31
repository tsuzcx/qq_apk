package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.LruCache;
import java.util.concurrent.ConcurrentHashMap;

public class ImageTaskTracer
{
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_NO_CODE;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch;
  private static int MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other;
  private static int MM_REPORT_GET_IMAGE_SUCCESS_CODE = 0;
  public static boolean OPEN_GET_IMAGE_SUCCESS_RECORDER;
  private static Object PLACEHOLDER;
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
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest = 1;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Download = 2;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadPending = 3;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeThreadDecoding = 4;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_LruCacheEvicted = 5;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ListScrollWaitDecode = 6;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_MsgGetNull = 7;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DecodeFailed = 8;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_ImageTaskLifeCycle = 9;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_DownloadFailed = 10;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_Other = 11;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_NO_CODE = 12;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_OptionNotMatch = 13;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ExceedMemorySize = 14;
    MM_REPORT_GET_IMAGE_FAILED_ERROR_CODE_NonPreDecodeRequest_ListView_Sroll = 15;
    PLACEHOLDER = new Object();
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
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeFailedRecorder != null)) {
      mImageDecodeFailedRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadDecodingRecorder != null)) {
      mImageDecodeThreadDecodingRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadPendingRecorder != null)) {
      mImageDecodeThreadPendingRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addImageDownloadFailedRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDownloadFailedRecorder != null)) {
      mImageDownloadFailedRecorder.put(paramString, PLACEHOLDER);
    }
  }
  
  public static void addImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDownloadRecorder != null)) {
      mImageDownloadRecorder.put(paramString, PLACEHOLDER);
    }
  }
  
  public static void addImageLruCacheEvictedRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageLruCacheEvictedRecorder != null)) {
      mImageLruCacheEvictedRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageMsgGetNullRecorder != null)) {
      mImageMsgGetNullRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addImagePreDecodeOptionsRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequest_DecodeOptions != null)) {
      mImagePreDecodeRequest_DecodeOptions.put(paramString, Integer.valueOf(getHashCodeEx(paramString, paramOptions)));
    }
  }
  
  public static void addImagePreDecodeRequestRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequestRecorder != null)) {
      mImagePreDecodeRequestRecorder.put(Integer.valueOf(getHashCodeEx(paramString, paramOptions)), PLACEHOLDER);
    }
  }
  
  public static void addImagePreExceedMemorySizeRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequest_ExceedMemorySize != null)) {
      mImagePreDecodeRequest_ExceedMemorySize.put(Integer.valueOf(getHashCodeEx(paramString, paramOptions)), PLACEHOLDER);
    }
  }
  
  public static void addImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageTaskLifeCycleRecorder != null)) {
      mImageTaskLifeCycleRecorder.put(Integer.valueOf(paramInt), PLACEHOLDER);
    }
  }
  
  public static void addhasImagePreDecodeRequestIntrinsicRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mhasImagePreDecodeRequestIntrinsic != null)) {
      mhasImagePreDecodeRequestIntrinsic.put(paramString, PLACEHOLDER);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      bool1 = bool2;
      if (mImageDecodeFailedRecorder != null)
      {
        bool1 = bool2;
        if (mImageDecodeFailedRecorder.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadDecodingRecorder != null)) {
      return mImageDecodeThreadDecodingRecorder.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadPendingRecorder != null)) {
      return mImageDecodeThreadPendingRecorder.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImageDownloadFailedRecord(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      bool1 = bool2;
      if (mImageDownloadFailedRecorder != null)
      {
        bool1 = bool2;
        if (mImageDownloadFailedRecorder.get(paramString) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDownloadRecorder != null)) {
      return mImageDownloadRecorder.containsKey(paramString);
    }
    return false;
  }
  
  public static boolean hasImageLruCacheEvictedRecord(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      bool1 = bool2;
      if (mImageLruCacheEvictedRecorder != null)
      {
        bool1 = bool2;
        if (mImageLruCacheEvictedRecorder.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageMsgGetNullRecorder != null)) {
      return mImageMsgGetNullRecorder.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeOptionsRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequest_DecodeOptions != null)) {
      return mImagePreDecodeRequest_DecodeOptions.containsKey(paramString);
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestIntrinsicRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mhasImagePreDecodeRequestIntrinsic != null)) {
      return mhasImagePreDecodeRequestIntrinsic.containsKey(paramString);
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequestRecorder != null)) {
      return mImagePreDecodeRequestRecorder.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImagePreExceedMemorySizeRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImagePreDecodeRequest_ExceedMemorySize != null)) {
      return mImagePreDecodeRequest_ExceedMemorySize.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageTaskLifeCycleRecorder != null)) {
      return mImageTaskLifeCycleRecorder.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static void removeImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadDecodingRecorder != null)) {
      mImageDecodeThreadDecodingRecorder.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDecodeThreadPendingRecorder != null)) {
      mImageDecodeThreadPendingRecorder.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageDownloadRecorder != null)) {
      mImageDownloadRecorder.remove(paramString);
    }
  }
  
  public static void removeImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageMsgGetNullRecorder != null)) {
      mImageMsgGetNullRecorder.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (mImageTaskLifeCycleRecorder != null)) {
      mImageTaskLifeCycleRecorder.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void traceImageGet(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      if (!paramBoolean) {
        break label20;
      }
      ImageManagerEnv.g().reportGetImageCacheToMM(MM_REPORT_GET_IMAGE_SUCCESS_CODE);
    }
    label20:
    do
    {
      return;
      if (hasImagePreDecodeRequestRecord(paramImageKey.hashCodeEx())) {
        break;
      }
    } while (!hasImagePreDecodeRequestIntrinsicRecord(paramImageKey.url));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskTracer
 * JD-Core Version:    0.7.0.1
 */