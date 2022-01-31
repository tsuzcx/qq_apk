package com.tencent.TMG.mediacodec.config;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.TMG.config.ConfigBaseParser;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.utils.ArrayUtils;
import com.tencent.TMG.utils.QLog;

public class CodecConfigParser
  extends ConfigBaseParser
{
  static final String TAG = "CodecConfigParser";
  public static final int TEST_DISABLE = 0;
  public static final int TEST_USE_ASYNC_API = 2;
  public static final int TEST_USE_SYNC_API = 1;
  public static String key_async;
  public static String key_async_codec = key_async + str_codec;
  public static String key_async_min_sdk;
  public static String key_avc_decocoder;
  public static String key_avc_encocoder;
  public static String key_avcdec_bl_fingerprint;
  public static String key_avcdec_bl_model;
  public static String key_avcdec_bl_product;
  public static String key_avcdec_bl_sdk;
  public static String key_avcdec_bl_version;
  public static String key_avcdec_wl_min_sdk;
  public static String key_avcdec_wl_min_version;
  public static String key_avcenc_bl_fingerprint;
  public static String key_avcenc_bl_model;
  public static String key_avcenc_bl_product;
  public static String key_avcenc_bl_sdk;
  public static String key_avcenc_bl_version;
  public static String key_avcenc_wl_min_sdk;
  public static String key_avcenc_wl_min_version;
  public static String key_root = "sharp/hwcodec_new/";
  public static String key_test;
  public static String key_test_async_min_sdk;
  public static String key_test_codec;
  public static String key_test_disable_sdk;
  public static String key_test_min_sdk;
  public static String str_black_list;
  public static String str_codec;
  public static String str_disable_sdk;
  public static String str_fingerprint;
  public static String str_min_sdk;
  public static String str_min_version;
  public static String str_model;
  public static String str_product;
  public static String str_sdk;
  public static String str_test_async_min_sdk;
  public static String str_version;
  public static String str_white_list;
  
  static
  {
    key_avc_decocoder = key_root + "avc_decoder/";
    key_avc_encocoder = key_root + "avc_encoder/";
    key_async = key_root + "async/";
    key_test = key_root + "test/";
    str_white_list = "white_list/";
    str_black_list = "black_list/";
    str_min_sdk = "min_sdk";
    str_min_version = "min_version";
    str_model = "model";
    str_product = "product";
    str_fingerprint = "fingerprint";
    str_sdk = "sdk";
    str_version = "version";
    str_codec = "codec";
    str_disable_sdk = "disable_sdk";
    str_test_async_min_sdk = "async_min_sdk";
    key_test_min_sdk = null;
    key_test_disable_sdk = null;
    key_test_codec = null;
    key_test_async_min_sdk = null;
    key_avcdec_wl_min_sdk = null;
    key_avcdec_wl_min_version = null;
    key_avcdec_bl_model = null;
    key_avcdec_bl_product = null;
    key_avcdec_bl_fingerprint = null;
    key_avcdec_bl_sdk = null;
    key_avcdec_bl_version = null;
    key_avcenc_wl_min_sdk = null;
    key_avcenc_wl_min_version = null;
    key_avcenc_bl_model = null;
    key_avcenc_bl_product = null;
    key_avcenc_bl_fingerprint = null;
    key_avcenc_bl_sdk = null;
    key_avcenc_bl_version = null;
    key_async_min_sdk = null;
    key_async_codec = null;
    key_test_min_sdk = key_test + str_min_sdk;
    key_test_disable_sdk = key_test + str_disable_sdk;
    key_test_codec = key_test + str_codec;
    key_test_async_min_sdk = key_test + str_test_async_min_sdk;
    key_avcdec_wl_min_sdk = key_avc_decocoder + str_white_list + str_min_sdk;
    key_avcdec_wl_min_version = key_avc_decocoder + str_white_list + str_min_version;
    key_avcdec_bl_model = key_avc_decocoder + str_black_list + str_model;
    key_avcdec_bl_product = key_avc_decocoder + str_black_list + str_product;
    key_avcdec_bl_fingerprint = key_avc_decocoder + str_black_list + str_fingerprint;
    key_avcdec_bl_sdk = key_avc_decocoder + str_black_list + str_sdk;
    key_avcdec_bl_version = key_avc_decocoder + str_black_list + str_version;
    key_avcenc_wl_min_sdk = key_avc_encocoder + str_white_list + str_min_sdk;
    key_avcenc_wl_min_version = key_avc_encocoder + str_white_list + str_min_version;
    key_avcenc_bl_model = key_avc_encocoder + str_black_list + str_model;
    key_avcenc_bl_product = key_avc_encocoder + str_black_list + str_product;
    key_avcenc_bl_fingerprint = key_avc_encocoder + str_black_list + str_fingerprint;
    key_avcenc_bl_sdk = key_avc_encocoder + str_black_list + str_sdk;
    key_avcenc_bl_version = key_avc_encocoder + str_black_list + str_version;
    key_async_min_sdk = key_async + str_min_sdk;
  }
  
  public CodecConfigParser() {}
  
  public CodecConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public boolean getAVCDecoderAbility()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(key_avcdec_wl_min_sdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = AVContext.getVersion();
        if (QLog.isColorLevel()) {
          QLog.d("CodecConfigParser", 0, "sdk version: " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).compareTo(getStringValue(key_avcdec_wl_min_version, "")) < 0) {
            continue;
          }
          String[] arrayOfString = getStringValues(key_avcdec_bl_version);
          if ((arrayOfString != null) && (ArrayUtils.contains(arrayOfString, localObject))) {
            continue;
          }
        }
        localObject = getIntValues(key_avcdec_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label148;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label148:
        localObject = getStringValues(key_avcdec_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label187;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label187:
        localObject = getStringValues(key_avcdec_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label226;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label226:
        localObject = getStringValues(key_avcdec_bl_fingerprint);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label274;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
  
  public int getAVCDecoderTestFlag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 0, "getAVCDecoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = getIntValues(key_test_codec);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x1) == 1))
        {
          arrayOfInt = getIntValues(key_test_min_sdk);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.contains(getIntValues(key_test_disable_sdk), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = getIntValues(key_test_async_min_sdk);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i = Build.VERSION.SDK_INT;
              int j = arrayOfInt[0];
              if (i >= j) {
                return 2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 0;
      }
    }
    return 1;
  }
  
  public boolean getAVCEncoderAbility()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(key_avcenc_wl_min_sdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = AVContext.getVersion();
        if (QLog.isColorLevel()) {
          QLog.d("CodecConfigParser", 0, "sdk version: " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).compareTo(getStringValue(key_avcenc_wl_min_version, "")) < 0) {
            continue;
          }
          String[] arrayOfString = getStringValues(key_avcenc_bl_version);
          if ((arrayOfString != null) && (ArrayUtils.contains(arrayOfString, localObject))) {
            continue;
          }
        }
        localObject = getIntValues(key_avcenc_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label148;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label148:
        localObject = getStringValues(key_avcenc_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label187;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label187:
        localObject = getStringValues(key_avcenc_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label226;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label226:
        localObject = getStringValues(key_avcenc_bl_fingerprint);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label274;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
  
  public int getAVCEncoderTestFlag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 0, "getAVCEncoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = getIntValues(key_test_codec);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x2) == 2))
        {
          arrayOfInt = getIntValues(key_test_min_sdk);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.contains(getIntValues(key_test_disable_sdk), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = getIntValues(key_test_async_min_sdk);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i = Build.VERSION.SDK_INT;
              int j = arrayOfInt[0];
              if (i >= j) {
                return 2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 0;
      }
    }
    return 1;
  }
  
  public int[] getIntValues(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.getIntValues(paramString);
  }
  
  public String[] getStringValues(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.getStringValues(paramString);
  }
  
  public boolean isEnableAsyncApi(int paramInt)
  {
    try
    {
      int[] arrayOfInt = getIntValues(key_async_min_sdk);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        arrayOfInt = getIntValues(key_async_codec);
        if (arrayOfInt != null)
        {
          boolean bool = ArrayUtils.contains(arrayOfInt, paramInt);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.config.CodecConfigParser
 * JD-Core Version:    0.7.0.1
 */