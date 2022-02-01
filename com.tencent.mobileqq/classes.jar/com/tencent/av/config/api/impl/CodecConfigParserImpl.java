package com.tencent.av.config.api.impl;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.ArrayUtils;

public class CodecConfigParserImpl
  implements ICodecConfigParser
{
  private static final String STR_ASYNC = "async/";
  private static final String STR_ASYNC_CODEC = "codec";
  private static final String STR_ASYNC_MIN_SDK = "min_sdk";
  private static final String STR_AVC_DECODER = "avc_decoder/";
  private static final String STR_AVC_ENCODER = "avc_encoder/";
  private static final String STR_BLACK_LIST = "black_list/";
  private static final String STR_CODEC = "codec";
  private static final String STR_DISABLE_SDK = "disable_sdk";
  private static final String STR_FINGERPRINT = "fingerprint";
  private static final String STR_HEVC_DECODER = "hevc_decoder/";
  private static final String STR_HEVC_ENCODER = "hevc_encoder/";
  private static final String STR_MAX_H = "max_h";
  private static final String STR_MAX_W = "max_w";
  private static final String STR_MIN_SDK = "min_sdk";
  private static final String STR_MIN_VERSION = "min_version";
  private static final String STR_MODEL = "model";
  private static final String STR_PRODUCT = "product";
  private static final String STR_ROOT1 = "sharp/hwcodec_new/";
  private static final String STR_ROOT2 = "sharp/hwcodec_new2/";
  private static final String STR_SDK = "sdk";
  private static final String STR_TEST = "test/";
  private static final String STR_TEST_ASYNC_MIN_SDK = "async_min_sdk";
  private static final String STR_VERSION = "version";
  private static final String STR_WHITE_LIST = "white_list/";
  static final String TAG = "CodecConfigParser";
  private static final String VERSION2_FLAG = "hwcodec_new2";
  private String mKeyAsyncCodec = null;
  private String mKeyAsyncMinSdk = null;
  private String mKeyAvcdecBLFingerprint = null;
  private String mKeyAvcdecBLModel = null;
  private String mKeyAvcdecBLProduct = null;
  private String mKeyAvcdecBLSdk = null;
  private String mKeyAvcdecBLVersion = null;
  private String mKeyAvcdecWLMaxH = null;
  private String mKeyAvcdecWLMaxW = null;
  private String mKeyAvcdecWLMinSdk = null;
  private String mKeyAvcdecWLMinVersion = null;
  private String mKeyAvcencBLFingerprint = null;
  private String mKeyAvcencBLModel = null;
  private String mKeyAvcencBLProduct = null;
  private String mKeyAvcencBLSdk = null;
  private String mKeyAvcencBLVersion = null;
  private String mKeyAvcencWLMaxH = null;
  private String mKeyAvcencWLMaxW = null;
  private String mKeyAvcencWLMinSdk = null;
  private String mKeyAvcencWLMinVersion = null;
  private String mKeyHevcdecBLFingerprint = null;
  private String mKeyHevcdecBLModel = null;
  private String mKeyHevcdecBLProduct = null;
  private String mKeyHevcdecBLSdk = null;
  private String mKeyHevcdecBLVersion = null;
  private String mKeyHevcdecWLMaxH = null;
  private String mKeyHevcdecWLMaxW = null;
  private String mKeyHevcdecWLMinSdk = null;
  private String mKeyHevcdecWLMinVersion = null;
  private String mKeyHevcencBLFingerprint = null;
  private String mKeyHevcencBLModel = null;
  private String mKeyHevcencBLProduct = null;
  private String mKeyHevcencBLSdk = null;
  private String mKeyHevcencBLVersion = null;
  private String mKeyHevcencWLMaxH = null;
  private String mKeyHevcencWLMaxW = null;
  private String mKeyHevcencWLMinSdk = null;
  private String mKeyHevcencWLMinVersion = null;
  private String mKeyTestAsyncMinSdk = null;
  private String mKeyTestCodec = null;
  private String mKeyTestDisableSdk = null;
  private String mKeyTestMinSdk = null;
  private String mKeyTestMinVersion = null;
  private IConfigParser mParser = null;
  private String mStrRoot = "sharp/hwcodec_new/";
  private int mVer = 1;
  
  boolean checkQQVer(IConfigParser paramIConfigParser, String paramString1, String paramString2)
  {
    if (this.mVer != 2) {
      return true;
    }
    int j = AVCoreUtil.getQQVersion();
    if (AVCoreUtil.strVersionToInt(paramIConfigParser.getStringValue(paramString1, "")) > j) {
      return false;
    }
    if (paramString2 != null)
    {
      paramIConfigParser = paramIConfigParser.getStringValues(paramString2);
      if (paramIConfigParser != null)
      {
        int k = paramIConfigParser.length;
        int i = 0;
        while (i < k)
        {
          if (AVCoreUtil.strVersionToInt(paramIConfigParser[i]) == j) {
            return false;
          }
          i += 1;
        }
      }
    }
    return true;
  }
  
  public HWCodecAbility getAVCDecoderAbility()
  {
    if (this.mParser == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    HWCodecAbility localHWCodecAbility = new HWCodecAbility(1, true);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = getIntValues(this.mParser, this.mKeyAvcdecWLMinSdk);
        if (localObject == null) {
          return null;
        }
        if (Build.VERSION.SDK_INT < localObject[0]) {
          return null;
        }
        if (!checkQQVer(this.mParser, this.mKeyAvcdecWLMinVersion, this.mKeyAvcdecBLVersion)) {
          return null;
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcdecBLSdk);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (Build.VERSION.SDK_INT != localObject[i]) {
              break label298;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcdecBLModel);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break label305;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcdecBLProduct);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label312;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcdecBLFingerprint);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label319;
            }
            return null;
          }
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcdecWLMaxW);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxW = localObject[0];
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcdecWLMaxH);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxH = localObject[0];
        }
        return localHWCodecAbility;
      }
      catch (Exception localException)
      {
        return null;
      }
      label298:
      i += 1;
      continue;
      label305:
      i += 1;
      continue;
      label312:
      i += 1;
      continue;
      label319:
      i += 1;
    }
  }
  
  public HWCodecAbility getAVCEncoderAbility()
  {
    if (this.mParser == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19) {
      return null;
    }
    HWCodecAbility localHWCodecAbility = new HWCodecAbility(2, true);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = getIntValues(this.mParser, this.mKeyAvcencWLMinSdk);
        if (localObject == null) {
          return null;
        }
        if (Build.VERSION.SDK_INT < localObject[0]) {
          return null;
        }
        if (!checkQQVer(this.mParser, this.mKeyAvcencWLMinVersion, this.mKeyAvcencBLVersion)) {
          return null;
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcencBLSdk);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (Build.VERSION.SDK_INT != localObject[i]) {
              break label298;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcencBLModel);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break label305;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcencBLProduct);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label312;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyAvcencBLFingerprint);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label319;
            }
            return null;
          }
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcencWLMaxW);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxW = localObject[0];
        }
        localObject = getIntValues(this.mParser, this.mKeyAvcencWLMaxH);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxH = localObject[0];
        }
        return localHWCodecAbility;
      }
      catch (Exception localException)
      {
        return null;
      }
      label298:
      i += 1;
      continue;
      label305:
      i += 1;
      continue;
      label312:
      i += 1;
      continue;
      label319:
      i += 1;
    }
  }
  
  public HWCodecAbility getHevcDecoderAbility()
  {
    if (this.mParser == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    HWCodecAbility localHWCodecAbility = new HWCodecAbility(4, true);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = getIntValues(this.mParser, this.mKeyHevcdecWLMinSdk);
        if (localObject == null) {
          return null;
        }
        if (Build.VERSION.SDK_INT < localObject[0]) {
          return null;
        }
        if (!checkQQVer(this.mParser, this.mKeyHevcdecWLMinVersion, this.mKeyHevcdecBLVersion)) {
          return null;
        }
        localObject = getIntValues(this.mParser, this.mKeyHevcdecBLSdk);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (Build.VERSION.SDK_INT != localObject[i]) {
              break label302;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyHevcdecBLModel);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break label309;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyHevcdecBLProduct);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label316;
            }
            return null;
          }
        }
        localObject = getStringValues(this.mParser, this.mKeyHevcdecBLFingerprint);
        if (localObject != null)
        {
          i = 0;
          if (i < localObject.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break label323;
            }
            return null;
          }
        }
        localObject = getIntValues(this.mParser, this.mKeyHevcdecWLMaxW);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxW = localObject[0];
        }
        localObject = getIntValues(this.mParser, this.mKeyHevcdecWLMaxH);
        if ((localObject != null) && (localObject[0] > 0)) {
          localHWCodecAbility.maxH = localObject[0];
        }
        return localHWCodecAbility;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label302:
      i += 1;
      continue;
      label309:
      i += 1;
      continue;
      label316:
      i += 1;
      continue;
      label323:
      i += 1;
    }
  }
  
  public HWCodecAbility getHevcEncoderAbility()
  {
    if (this.mParser == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < 19.");
      return null;
    }
    Object localObject1 = new HWCodecAbility(8, true);
    for (;;)
    {
      int i;
      try
      {
        localObject2 = getIntValues(this.mParser, this.mKeyHevcencWLMinSdk);
        if (localObject2 == null)
        {
          AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. minsdk == null.");
          return null;
        }
        if (Build.VERSION.SDK_INT < localObject2[0])
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getHevcEncoderAbility failed. Build.VERSION.SDK_INT < minsdk[0]. minsdk[0] = ");
          ((StringBuilder)localObject1).append(localObject2[0]);
          AVCoreLog.e("CodecConfigParser", ((StringBuilder)localObject1).toString());
          return null;
        }
        if (!checkQQVer(this.mParser, this.mKeyHevcencWLMinVersion, this.mKeyHevcencBLVersion))
        {
          AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. checkQQVer failed.");
          return null;
        }
        localObject2 = getIntValues(this.mParser, this.mKeyHevcencBLSdk);
        if (localObject2 != null)
        {
          i = 0;
          if (i < localObject2.length)
          {
            if (Build.VERSION.SDK_INT != localObject2[i]) {
              break label426;
            }
            AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.VERSION.SDK_INT == disablesdk[i].");
            return null;
          }
        }
        localObject2 = getStringValues(this.mParser, this.mKeyHevcencBLModel);
        if (localObject2 != null)
        {
          i = 0;
          if (i < localObject2.length)
          {
            if (!Build.MODEL.equalsIgnoreCase(localObject2[i])) {
              break label433;
            }
            AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.MODEL.equalsIgnoreCase(models[i]).");
            return null;
          }
        }
        localObject2 = getStringValues(this.mParser, this.mKeyHevcencBLProduct);
        if (localObject2 != null)
        {
          i = 0;
          if (i < localObject2.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject2[i])) {
              break label440;
            }
            AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(products[i]).");
            return null;
          }
        }
        localObject2 = getStringValues(this.mParser, this.mKeyHevcencBLFingerprint);
        if (localObject2 != null)
        {
          i = 0;
          if (i < localObject2.length)
          {
            if (!Build.PRODUCT.equalsIgnoreCase(localObject2[i])) {
              break label447;
            }
            AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(fingerprints[i].");
            return null;
          }
        }
        localObject2 = getIntValues(this.mParser, this.mKeyHevcencWLMaxW);
        if ((localObject2 != null) && (localObject2[0] > 0)) {
          ((HWCodecAbility)localObject1).maxW = localObject2[0];
        }
        localObject2 = getIntValues(this.mParser, this.mKeyHevcencWLMaxH);
        if ((localObject2 != null) && (localObject2[0] > 0)) {
          ((HWCodecAbility)localObject1).maxH = localObject2[0];
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getHevcEncoderAbility failed. err msg = ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        AVCoreLog.e("CodecConfigParser", ((StringBuilder)localObject2).toString());
        return null;
      }
      label426:
      i += 1;
      continue;
      label433:
      i += 1;
      continue;
      label440:
      i += 1;
      continue;
      label447:
      i += 1;
    }
  }
  
  int[] getIntValues(IConfigParser paramIConfigParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramIConfigParser.getIntValues(paramString);
  }
  
  String[] getStringValues(IConfigParser paramIConfigParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramIConfigParser.getStringValues(paramString);
  }
  
  public void init(IConfigParser paramIConfigParser)
  {
    if ((paramIConfigParser != null) && (!paramIConfigParser.isEmpty()) && (paramIConfigParser.getData().contains("hwcodec_new2"))) {
      this.mVer = 2;
    }
    this.mParser = paramIConfigParser;
    if (this.mVer == 2) {
      paramIConfigParser = "sharp/hwcodec_new2/";
    } else {
      paramIConfigParser = "sharp/hwcodec_new/";
    }
    this.mStrRoot = paramIConfigParser;
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append("ver = ");
    paramIConfigParser.append(this.mVer);
    paramIConfigParser.append(", root = ");
    paramIConfigParser.append(this.mStrRoot);
    AVCoreLog.e("CodecConfigParser", paramIConfigParser.toString());
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("test/");
    paramIConfigParser.append("min_sdk");
    this.mKeyTestMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("test/");
    paramIConfigParser.append("disable_sdk");
    this.mKeyTestDisableSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("test/");
    paramIConfigParser.append("codec");
    this.mKeyTestCodec = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("test/");
    paramIConfigParser.append("async_min_sdk");
    this.mKeyTestAsyncMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("test/");
    paramIConfigParser.append("min_version");
    this.mKeyTestMinVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_sdk");
    this.mKeyAvcdecWLMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_version");
    this.mKeyAvcdecWLMinVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("model");
    this.mKeyAvcdecBLModel = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("product");
    this.mKeyAvcdecBLProduct = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("fingerprint");
    this.mKeyAvcdecBLFingerprint = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("sdk");
    this.mKeyAvcdecBLSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("version");
    this.mKeyAvcdecBLVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_w");
    this.mKeyAvcdecWLMaxW = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_h");
    this.mKeyAvcdecWLMaxH = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_sdk");
    this.mKeyAvcencWLMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_version");
    this.mKeyAvcencWLMinVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("model");
    this.mKeyAvcencBLModel = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("product");
    this.mKeyAvcencBLProduct = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("fingerprint");
    this.mKeyAvcencBLFingerprint = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("sdk");
    this.mKeyAvcencBLSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("version");
    this.mKeyAvcencBLVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_w");
    this.mKeyAvcencWLMaxW = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("avc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_h");
    this.mKeyAvcencWLMaxH = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_sdk");
    this.mKeyHevcdecWLMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_version");
    this.mKeyHevcdecWLMinVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("model");
    this.mKeyHevcdecBLModel = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("product");
    this.mKeyHevcdecBLProduct = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("fingerprint");
    this.mKeyHevcdecBLFingerprint = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("sdk");
    this.mKeyHevcdecBLSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("version");
    this.mKeyHevcdecBLVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_w");
    this.mKeyHevcdecWLMaxW = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_decoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_h");
    this.mKeyHevcdecWLMaxH = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_sdk");
    this.mKeyHevcencWLMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("min_version");
    this.mKeyHevcencWLMinVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("model");
    this.mKeyHevcencBLModel = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("product");
    this.mKeyHevcencBLProduct = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("fingerprint");
    this.mKeyHevcencBLFingerprint = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("sdk");
    this.mKeyHevcencBLSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("black_list/");
    paramIConfigParser.append("version");
    this.mKeyHevcencBLVersion = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_w");
    this.mKeyHevcencWLMaxW = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("hevc_encoder/");
    paramIConfigParser.append("white_list/");
    paramIConfigParser.append("max_h");
    this.mKeyHevcencWLMaxH = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("async/");
    paramIConfigParser.append("min_sdk");
    this.mKeyAsyncMinSdk = paramIConfigParser.toString();
    paramIConfigParser = new StringBuilder();
    paramIConfigParser.append(this.mStrRoot);
    paramIConfigParser.append("async/");
    paramIConfigParser.append("codec");
    this.mKeyAsyncCodec = paramIConfigParser.toString();
  }
  
  public boolean isEnableAsyncApi(int paramInt)
  {
    Object localObject = this.mParser;
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = getIntValues((IConfigParser)localObject, this.mKeyAsyncMinSdk);
      if (localObject == null) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (Build.VERSION.SDK_INT < localObject[0]) {
          return false;
        }
        localObject = getIntValues(this.mParser, this.mKeyAsyncCodec);
        if (localObject != null)
        {
          boolean bool = ArrayUtils.contains((int[])localObject, paramInt);
          return bool;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.impl.CodecConfigParserImpl
 * JD-Core Version:    0.7.0.1
 */