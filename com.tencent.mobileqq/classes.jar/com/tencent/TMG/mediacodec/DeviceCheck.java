package com.tencent.TMG.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.TMG.mediacodec.config.CodecConfigParser;
import com.tencent.TMG.utils.QLog;
import java.util.List;

@SuppressLint({"NewApi"})
public class DeviceCheck
  implements Runnable
{
  public static final String TAG = "DeviceCheck";
  int mDataSource = -1;
  Resources mRes;
  Thread mThread;
  
  public DeviceCheck(Resources paramResources)
  {
    this.mRes = paramResources;
  }
  
  static boolean checkDecoderSupportColorFormat(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21) || (paramInt == 2130706944) || (paramInt == 2141391876);
  }
  
  static boolean checkEncoderSupportColorFormat(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21);
  }
  
  public static boolean forceSyncAPI()
  {
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean isAVCDecSupportColorformats()
  {
    List localList = AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME);
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
      if (localCodecCapabilities == null) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isAVCDecWhitelistDevices()
  {
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean isAVCEncSupportColorformats()
  {
    List localList = AndroidCodec.getEndoderInfos(AndroidCodec.AVC_CODEC_MIME);
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
      if (localCodecCapabilities == null) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    return false;
  }
  
  public static boolean isSupportAsyncAPI()
  {
    if (forceSyncAPI()) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    CodecConfigParser localCodecConfigParser = new CodecConfigParser();
    String str = localCodecConfigParser.getConfig();
    if (!TextUtils.isEmpty(str))
    {
      localCodecConfigParser.setConfig(str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSupportAsyncAPI sharpConfigPayload:\n");
        localStringBuilder.append(str);
        QLog.d("DeviceCheck", 0, localStringBuilder.toString());
      }
      if ((localCodecConfigParser.getAVCEncoderAbility()) && (localCodecConfigParser.isEnableAsyncApi(2)) && (localCodecConfigParser.getAVCDecoderAbility()) && (localCodecConfigParser.isEnableAsyncApi(1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceCheck", 0, "SUPPORT Async API");
        }
        return true;
      }
    }
    return false;
  }
  
  public void run() {}
  
  public void setDataSource(int paramInt)
  {
    this.mDataSource = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */