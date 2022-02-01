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
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  static boolean checkEncoderSupportColorFormat(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
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
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
        if (localCodecCapabilities != null) {}
      }
      else
      {
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
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
        if (localCodecCapabilities != null) {}
      }
      else
      {
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
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    return false;
  }
  
  public static boolean isSupportAsyncAPI()
  {
    if (forceSyncAPI()) {}
    CodecConfigParser localCodecConfigParser;
    do
    {
      String str;
      do
      {
        do
        {
          return false;
        } while (Build.VERSION.SDK_INT < 21);
        localCodecConfigParser = new CodecConfigParser();
        str = localCodecConfigParser.getConfig();
      } while (TextUtils.isEmpty(str));
      localCodecConfigParser.setConfig(str);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCheck", 0, "isSupportAsyncAPI sharpConfigPayload:\n" + str);
      }
    } while ((!localCodecConfigParser.getAVCEncoderAbility()) || (!localCodecConfigParser.isEnableAsyncApi(2)) || (!localCodecConfigParser.getAVCDecoderAbility()) || (!localCodecConfigParser.isEnableAsyncApi(1)));
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCheck", 0, "SUPPORT Async API");
    }
    return true;
  }
  
  public void run() {}
  
  public void setDataSource(int paramInt)
  {
    this.mDataSource = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */