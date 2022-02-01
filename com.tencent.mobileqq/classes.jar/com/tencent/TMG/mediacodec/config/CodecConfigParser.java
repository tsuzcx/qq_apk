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
  public static String key_async_codec;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_root);
    localStringBuilder.append("avc_decoder/");
    key_avc_decocoder = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_root);
    localStringBuilder.append("avc_encoder/");
    key_avc_encocoder = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_root);
    localStringBuilder.append("async/");
    key_async = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_root);
    localStringBuilder.append("test/");
    key_test = localStringBuilder.toString();
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
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_test);
    localStringBuilder.append(str_min_sdk);
    key_test_min_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_test);
    localStringBuilder.append(str_disable_sdk);
    key_test_disable_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_test);
    localStringBuilder.append(str_codec);
    key_test_codec = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_test);
    localStringBuilder.append(str_test_async_min_sdk);
    key_test_async_min_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_white_list);
    localStringBuilder.append(str_min_sdk);
    key_avcdec_wl_min_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_white_list);
    localStringBuilder.append(str_min_version);
    key_avcdec_wl_min_version = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_model);
    key_avcdec_bl_model = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_product);
    key_avcdec_bl_product = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_fingerprint);
    key_avcdec_bl_fingerprint = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_sdk);
    key_avcdec_bl_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_decocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_version);
    key_avcdec_bl_version = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_white_list);
    localStringBuilder.append(str_min_sdk);
    key_avcenc_wl_min_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_white_list);
    localStringBuilder.append(str_min_version);
    key_avcenc_wl_min_version = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_model);
    key_avcenc_bl_model = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_product);
    key_avcenc_bl_product = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_fingerprint);
    key_avcenc_bl_fingerprint = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_sdk);
    key_avcenc_bl_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_avc_encocoder);
    localStringBuilder.append(str_black_list);
    localStringBuilder.append(str_version);
    key_avcenc_bl_version = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_async);
    localStringBuilder.append(str_min_sdk);
    key_async_min_sdk = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(key_async);
    localStringBuilder.append(str_codec);
    key_async_codec = localStringBuilder.toString();
  }
  
  public CodecConfigParser() {}
  
  public CodecConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public boolean getAVCDecoderAbility()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = getIntValues(key_avcdec_wl_min_sdk);
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT < localObject1[0]) {
            return false;
          }
          localObject1 = AVContext.getVersion();
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sdk version: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("CodecConfigParser", 0, ((StringBuilder)localObject2).toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (((String)localObject1).compareTo(getStringValue(key_avcdec_wl_min_version, "")) < 0) {
              return false;
            }
            localObject2 = getStringValues(key_avcdec_bl_version);
            if ((localObject2 != null) && (ArrayUtils.contains((Object[])localObject2, localObject1))) {
              return false;
            }
          }
          localObject1 = getIntValues(key_avcdec_bl_sdk);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (Build.VERSION.SDK_INT != localObject1[i]) {
                break label281;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcdec_bl_model);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (!Build.MODEL.equalsIgnoreCase(localObject1[i])) {
                break label288;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcdec_bl_product);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (!Build.PRODUCT.equalsIgnoreCase(localObject1[i])) {
                break label295;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcdec_bl_fingerprint);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject1[i]);
              if (bool) {
                return false;
              }
              i += 1;
              continue;
            }
          }
          return true;
        }
        else
        {
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      label281:
      i += 1;
      continue;
      label288:
      i += 1;
      continue;
      label295:
      i += 1;
    }
  }
  
  public int getAVCDecoderTestFlag()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAVCDecoderTestFlag sdk: ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.d("CodecConfigParser", 0, ((StringBuilder)localObject).toString());
    }
    if (Build.VERSION.SDK_INT < 16) {
      return 0;
    }
    try
    {
      localObject = getIntValues(key_test_codec);
      if (localObject != null)
      {
        if ((localObject[0] & 0x1) != 1) {
          return 0;
        }
        localObject = getIntValues(key_test_min_sdk);
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT < localObject[0]) {
            return 0;
          }
          if (ArrayUtils.contains(getIntValues(key_test_disable_sdk), Build.VERSION.SDK_INT)) {
            return 0;
          }
          localObject = getIntValues(key_test_async_min_sdk);
          if ((Build.VERSION.SDK_INT >= 21) && (localObject != null))
          {
            int i = Build.VERSION.SDK_INT;
            int j = localObject[0];
            if (i >= j) {
              return 2;
            }
          }
          return 1;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public boolean getAVCEncoderAbility()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = getIntValues(key_avcenc_wl_min_sdk);
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT < localObject1[0]) {
            return false;
          }
          localObject1 = AVContext.getVersion();
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sdk version: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("CodecConfigParser", 0, ((StringBuilder)localObject2).toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (((String)localObject1).compareTo(getStringValue(key_avcenc_wl_min_version, "")) < 0) {
              return false;
            }
            localObject2 = getStringValues(key_avcenc_bl_version);
            if ((localObject2 != null) && (ArrayUtils.contains((Object[])localObject2, localObject1))) {
              return false;
            }
          }
          localObject1 = getIntValues(key_avcenc_bl_sdk);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (Build.VERSION.SDK_INT != localObject1[i]) {
                break label281;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcenc_bl_model);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (!Build.MODEL.equalsIgnoreCase(localObject1[i])) {
                break label288;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcenc_bl_product);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if (!Build.PRODUCT.equalsIgnoreCase(localObject1[i])) {
                break label295;
              }
              return false;
            }
          }
          localObject1 = getStringValues(key_avcenc_bl_fingerprint);
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject1[i]);
              if (bool) {
                return false;
              }
              i += 1;
              continue;
            }
          }
          return true;
        }
        else
        {
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      label281:
      i += 1;
      continue;
      label288:
      i += 1;
      continue;
      label295:
      i += 1;
    }
  }
  
  public int getAVCEncoderTestFlag()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAVCEncoderTestFlag sdk: ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.d("CodecConfigParser", 0, ((StringBuilder)localObject).toString());
    }
    if (Build.VERSION.SDK_INT < 16) {
      return 0;
    }
    try
    {
      localObject = getIntValues(key_test_codec);
      if (localObject != null)
      {
        if ((localObject[0] & 0x2) != 2) {
          return 0;
        }
        localObject = getIntValues(key_test_min_sdk);
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT < localObject[0]) {
            return 0;
          }
          if (ArrayUtils.contains(getIntValues(key_test_disable_sdk), Build.VERSION.SDK_INT)) {
            return 0;
          }
          localObject = getIntValues(key_test_async_min_sdk);
          if ((Build.VERSION.SDK_INT >= 21) && (localObject != null))
          {
            int i = Build.VERSION.SDK_INT;
            int j = localObject[0];
            if (i >= j) {
              return 2;
            }
          }
          return 1;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
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
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (Build.VERSION.SDK_INT < arrayOfInt[0]) {
          return false;
        }
        arrayOfInt = getIntValues(key_async_codec);
        if (arrayOfInt != null)
        {
          boolean bool = ArrayUtils.contains(arrayOfInt, paramInt);
          return bool;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.config.CodecConfigParser
 * JD-Core Version:    0.7.0.1
 */