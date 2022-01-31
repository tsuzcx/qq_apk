package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.LruCache;
import java.util.concurrent.ConcurrentHashMap;
import pma;

public class ImageTaskTracer
{
  public static boolean OPEN_GET_IMAGE_SUCCESS_RECORDER;
  private static int jdField_a_of_type_Int = 0;
  private static LruCache jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_b_of_type_Int = 1;
  private static LruCache jdField_b_of_type_ComTencentComponentMediaUtilsLruCache = new LruCache(150);
  private static ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_c_of_type_Int = 2;
  private static LruCache jdField_c_of_type_ComTencentComponentMediaUtilsLruCache = new LruCache(150);
  private static ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_d_of_type_Int = 3;
  private static ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_e_of_type_Int = 4;
  private static ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_f_of_type_Int = 5;
  private static ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_g_of_type_Int = 6;
  private static ConcurrentHashMap jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static int jdField_h_of_type_Int = 7;
  private static ConcurrentHashMap jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static int jdField_i_of_type_Int = 8;
  private static ConcurrentHashMap jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static int j = 9;
  private static int k = 10;
  private static int l = 11;
  private static int m = 12;
  private static int n = 13;
  private static int o = 14;
  private static int p = 15;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    OPEN_GET_IMAGE_SUCCESS_RECORDER = ImageManagerEnv.g().isOpenGetImageSuccessRecorder();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new LruCache(250);
    jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static int a(String paramString, ImageLoader.Options paramOptions)
  {
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    return localImageKey.hashCodeEx();
  }
  
  public static void addImageDecodeFailedRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_b_of_type_ComTencentComponentMediaUtilsLruCache != null)) {
      jdField_b_of_type_ComTencentComponentMediaUtilsLruCache.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageDownloadFailedRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_c_of_type_ComTencentComponentMediaUtilsLruCache != null)) {
      jdField_c_of_type_ComTencentComponentMediaUtilsLruCache.put(paramString, jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageLruCacheEvictedRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_a_of_type_ComTencentComponentMediaUtilsLruCache != null)) {
      jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImagePreDecodeOptionsRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(a(paramString, paramOptions)));
    }
  }
  
  public static void addImagePreDecodeRequestRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a(paramString, paramOptions)), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImagePreExceedMemorySizeRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a(paramString, paramOptions)), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static void addhasImagePreDecodeRequestIntrinsicRecord(String paramString, ImageLoader.Options paramOptions)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, jdField_a_of_type_JavaLangObject);
    }
  }
  
  public static boolean hasImageDecodeFailedRecord(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      bool1 = bool2;
      if (jdField_b_of_type_ComTencentComponentMediaUtilsLruCache != null)
      {
        bool1 = bool2;
        if (jdField_b_of_type_ComTencentComponentMediaUtilsLruCache.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
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
      if (jdField_c_of_type_ComTencentComponentMediaUtilsLruCache != null)
      {
        bool1 = bool2;
        if (jdField_c_of_type_ComTencentComponentMediaUtilsLruCache.get(paramString) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
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
      if (jdField_a_of_type_ComTencentComponentMediaUtilsLruCache != null)
      {
        bool1 = bool2;
        if (jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.get(Integer.valueOf(paramInt)) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean hasImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeOptionsRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestIntrinsicRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
  
  public static boolean hasImagePreDecodeRequestRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImagePreExceedMemorySizeRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean hasImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static void removeImageDecodeThreadDecodingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageDecodeThreadPendingRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageDownloadRecord(String paramString)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public static void removeImageMsgGetNullRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void removeImageTaskLifeCycleRecord(int paramInt)
  {
    if ((OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void traceImageGet(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      if (paramBoolean) {
        ImageManagerEnv.g().reportGetImageCacheToMM(jdField_a_of_type_Int);
      }
    }
    else {
      return;
    }
    if (!hasImagePreDecodeRequestRecord(paramImageKey.hashCodeEx()))
    {
      if (!hasImagePreDecodeRequestIntrinsicRecord(paramImageKey.url))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(m);
        return;
      }
      if (hasImagePreDecodeOptionsRecord(paramImageKey.url))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(n);
        return;
      }
      if (hasImagePreExceedMemorySizeRecord(paramImageKey.hashCodeEx()))
      {
        ImageManagerEnv.g().reportGetImageCacheToMM(o);
        return;
      }
      ImageManagerEnv.g().reportGetImageCacheToMM(p);
      return;
    }
    if (hasImageDownloadRecord(paramImageKey.urlKey))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_c_of_type_Int);
      return;
    }
    if (hasImageDecodeThreadPendingRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_d_of_type_Int);
      return;
    }
    if (hasImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_e_of_type_Int);
      return;
    }
    if (hasImageLruCacheEvictedRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_f_of_type_Int);
      return;
    }
    if (pma.a().a(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_g_of_type_Int);
      return;
    }
    if (hasImageMsgGetNullRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_h_of_type_Int);
      return;
    }
    if (hasImageDecodeFailedRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(jdField_i_of_type_Int);
      return;
    }
    if (hasImageTaskLifeCycleRecord(paramImageKey.hashCodeEx()))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(j);
      return;
    }
    if (hasImageDownloadFailedRecord(paramImageKey.urlKey))
    {
      ImageManagerEnv.g().reportGetImageCacheToMM(k);
      return;
    }
    ImageManagerEnv.g().reportGetImageCacheToMM(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskTracer
 * JD-Core Version:    0.7.0.1
 */