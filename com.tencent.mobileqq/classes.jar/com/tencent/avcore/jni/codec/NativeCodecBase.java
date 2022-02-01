package com.tencent.avcore.jni.codec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import java.util.List;

@RequiresApi(api=16)
public class NativeCodecBase
{
  private static NativeCodecBase.AVCCaps gAVCDecoderCaps;
  private static NativeCodecBase.AVCCaps gAVCEncoderCaps;
  private static NativeCodecBase.AVCCaps gHEVCDecoderCaps;
  private static NativeCodecBase.AVCCaps gHEVCEncoderCaps;
  static boolean sUseAsyncAPI = false;
  
  NativeCodecBase()
  {
    sUseAsyncAPI = AndroidCodecAdapterProxy.getInstance().isSupportAsyncAPI();
  }
  
  static int getIntValuesImp(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    label168:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return 0;
                        if (!"supportAsync".equalsIgnoreCase(paramString3)) {
                          break;
                        }
                      } while (!sUseAsyncAPI);
                      return 1;
                      if (!paramString2.equalsIgnoreCase("video/avc")) {
                        break label168;
                      }
                      if (!paramBoolean) {
                        break;
                      }
                      if (gAVCDecoderCaps == null) {
                        initAVCDecoderCaps(paramString1);
                      }
                    } while (gAVCDecoderCaps == null);
                    if (paramString3.equalsIgnoreCase("width")) {
                      return gAVCDecoderCaps.width;
                    }
                    if (paramString3.equalsIgnoreCase("height")) {
                      return gAVCDecoderCaps.height;
                    }
                  } while (!paramString3.equalsIgnoreCase("profile"));
                  return gAVCDecoderCaps.profile;
                  if (gAVCEncoderCaps == null) {
                    initAVCEncoderCaps(paramString1);
                  }
                } while (gAVCEncoderCaps == null);
                if (paramString3.equalsIgnoreCase("width")) {
                  return gAVCEncoderCaps.width;
                }
                if (paramString3.equalsIgnoreCase("height")) {
                  return gAVCEncoderCaps.height;
                }
              } while (!paramString3.equalsIgnoreCase("profile"));
              return gAVCEncoderCaps.profile;
            } while (!paramString2.equalsIgnoreCase("video/hevc"));
            if (!paramBoolean) {
              break;
            }
            if (gHEVCDecoderCaps == null) {
              initHevcDecoderCaps(paramString1);
            }
          } while (gHEVCDecoderCaps == null);
          if (paramString3.equalsIgnoreCase("width")) {
            return gHEVCDecoderCaps.width;
          }
          if (paramString3.equalsIgnoreCase("height")) {
            return gHEVCDecoderCaps.height;
          }
        } while (!paramString3.equalsIgnoreCase("profile"));
        return gHEVCDecoderCaps.profile;
        if (gHEVCEncoderCaps == null) {
          initHevcEncoderCaps();
        }
      } while (gHEVCEncoderCaps == null);
      if (paramString3.equalsIgnoreCase("width")) {
        return gHEVCEncoderCaps.width;
      }
      if (paramString3.equalsIgnoreCase("height")) {
        return gHEVCEncoderCaps.height;
      }
    } while (!paramString3.equalsIgnoreCase("profile"));
    return gHEVCEncoderCaps.profile;
  }
  
  private static void initAVCDecoderCaps(String paramString)
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.d(paramString, "initAVCDecoderCaps");
    }
    Object localObject = AndroidCodecBase.getDecoderInfos("video/avc");
    if (((List)localObject).size() == 0) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(paramString, "initAVCDecoderCaps fail, list.size为0");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), "video/avc");
      } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
      gAVCDecoderCaps = new NativeCodecBase.AVCCaps();
      i = 0;
    } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length);
    switch (localObject.profileLevels[i].profile)
    {
    default: 
      label164:
      switch (localObject.profileLevels[i].level)
      {
      default: 
        if (localObject.profileLevels[i].level < 1) {
          if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
          {
            gAVCDecoderCaps.width = 176;
            gAVCDecoderCaps.height = 144;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break;
      if (gAVCDecoderCaps.profile > 3) {
        break label164;
      }
      gAVCDecoderCaps.profile = 3;
      break label164;
      if (gAVCDecoderCaps.profile > 5) {
        break label164;
      }
      gAVCDecoderCaps.profile = 5;
      break label164;
      if (gAVCDecoderCaps.profile > 5) {
        break label164;
      }
      gAVCDecoderCaps.profile = 5;
      break label164;
      if (gAVCDecoderCaps.profile > 5) {
        break label164;
      }
      gAVCDecoderCaps.profile = 5;
      break label164;
      if (gAVCDecoderCaps.profile > 5) {
        break label164;
      }
      gAVCDecoderCaps.profile = 5;
      break label164;
      if (gAVCDecoderCaps.profile > 5) {
        break label164;
      }
      gAVCDecoderCaps.profile = 5;
      break label164;
      if (gAVCDecoderCaps.profile > 4) {
        break label164;
      }
      gAVCDecoderCaps.profile = 4;
      break label164;
      if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
      {
        gAVCDecoderCaps.width = 176;
        gAVCDecoderCaps.height = 144;
        continue;
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
          continue;
          if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
          {
            gAVCDecoderCaps.width = 352;
            gAVCDecoderCaps.height = 288;
            continue;
            if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
            {
              gAVCDecoderCaps.width = 352;
              gAVCDecoderCaps.height = 288;
              continue;
              if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
              {
                gAVCDecoderCaps.width = 352;
                gAVCDecoderCaps.height = 288;
                continue;
                if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
                {
                  gAVCDecoderCaps.width = 352;
                  gAVCDecoderCaps.height = 288;
                  continue;
                  if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 576))
                  {
                    gAVCDecoderCaps.width = 352;
                    gAVCDecoderCaps.height = 576;
                    continue;
                    if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                    {
                      gAVCDecoderCaps.width = 720;
                      gAVCDecoderCaps.height = 576;
                      continue;
                      if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                      {
                        gAVCDecoderCaps.width = 720;
                        gAVCDecoderCaps.height = 576;
                        continue;
                        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 720))
                        {
                          gAVCDecoderCaps.width = 1280;
                          gAVCDecoderCaps.height = 720;
                          continue;
                          if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 1024))
                          {
                            gAVCDecoderCaps.width = 1280;
                            gAVCDecoderCaps.height = 1024;
                            continue;
                            if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                            {
                              gAVCDecoderCaps.width = 2048;
                              gAVCDecoderCaps.height = 1024;
                              continue;
                              if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                              {
                                gAVCDecoderCaps.width = 2048;
                                gAVCDecoderCaps.height = 1024;
                                continue;
                                if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1088))
                                {
                                  gAVCDecoderCaps.width = 2048;
                                  gAVCDecoderCaps.height = 1088;
                                  continue;
                                  if ((gAVCDecoderCaps.width < 3680) || (gAVCDecoderCaps.height < 1536))
                                  {
                                    gAVCDecoderCaps.width = 3680;
                                    gAVCDecoderCaps.height = 1536;
                                    continue;
                                    if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2048))
                                    {
                                      gAVCDecoderCaps.width = 4096;
                                      gAVCDecoderCaps.height = 2048;
                                      continue;
                                      if (localObject.profileLevels[i].level > 32768)
                                      {
                                        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2160))
                                        {
                                          gAVCDecoderCaps.width = 4096;
                                          gAVCDecoderCaps.height = 2160;
                                        }
                                      }
                                      else {
                                        AVCoreLog.e(paramString, "initAVCDecoder caps.profileLevels[k].level: " + localObject.profileLevels[i].level);
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void initAVCEncoderCaps(String paramString)
  {
    boolean bool = false;
    Object localObject1 = AndroidCodecBase.getDecoderInfos("video/avc");
    if (((List)localObject1).size() == 0) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(paramString, "initAVCEncoderCaps fail, lists.size为0");
      }
    }
    do
    {
      do
      {
        return;
        localObject1 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject1).get(0), "video/avc");
      } while ((localObject1 == null) || (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels == null));
      gAVCEncoderCaps = new NativeCodecBase.AVCCaps();
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length > 0)
      {
        int i = 0;
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length)
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(paramString, "initAVCEncoderCaps, index[" + i + "], profile[" + localObject1.profileLevels[i].profile + "]");
          }
          switch (localObject1.profileLevels[i].profile)
          {
          default: 
            i += 1;
          }
        }
        gAVCEncoderCaps.profile = 3;
        localObject2 = localObject1.profileLevels[i];
        if ((AVCoreLog.isGrayVersion()) || (AVCoreLog.isDebugVersion())) {}
        for (((MediaCodecInfo.CodecProfileLevel)localObject2).level = 8192;; ((MediaCodecInfo.CodecProfileLevel)localObject2).level = 512)
        {
          setLevel((MediaCodecInfo.CodecProfileLevel)localObject2, gAVCEncoderCaps);
          break;
        }
      }
    } while (!AVCoreLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("initAVCEncoderCaps fail, caps[");
    if (localObject1 != null) {
      bool = true;
    }
    AVCoreLog.e(paramString, bool + "]");
  }
  
  private static void initHevcDecoderCaps(String paramString)
  {
    Object localObject = AndroidCodecBase.getDecoderInfos("video/hevc");
    if (((List)localObject).size() == 0) {}
    do
    {
      return;
      localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), "video/hevc");
    } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
    gHEVCDecoderCaps = new NativeCodecBase.AVCCaps();
    if ((((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length == 0) && ((AVCoreLog.isGrayVersion()) || (AVCoreLog.isDebugVersion())) && (Build.HARDWARE != null) && ((Build.HARDWARE.startsWith("hi6250")) || (Build.HARDWARE.startsWith("hi3650"))))
    {
      gHEVCDecoderCaps.profile = 1;
      gHEVCDecoderCaps.width = 1920;
      gHEVCDecoderCaps.height = 1080;
    }
    int i = 0;
    label128:
    if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
    {
      if (localObject.profileLevels[i].profile > 1) {
        break label242;
      }
      if (gHEVCDecoderCaps.profile <= 1) {
        gHEVCDecoderCaps.profile = 1;
      }
      label167:
      if ((localObject.profileLevels[i].level > 1) && (localObject.profileLevels[i].level > 2)) {
        break label308;
      }
      if ((gHEVCDecoderCaps.width < 176) || (gHEVCDecoderCaps.height < 144))
      {
        gHEVCDecoderCaps.width = 176;
        gHEVCDecoderCaps.height = 144;
      }
    }
    for (;;)
    {
      i += 1;
      break label128;
      break;
      label242:
      if (localObject.profileLevels[i].profile == 2)
      {
        if (gHEVCDecoderCaps.profile > 2) {
          break label167;
        }
        gHEVCDecoderCaps.profile = 2;
        break label167;
      }
      if ((localObject.profileLevels[i].profile < 2) || (gHEVCDecoderCaps.profile > 2)) {
        break label167;
      }
      gHEVCDecoderCaps.profile = 2;
      break label167;
      label308:
      if ((localObject.profileLevels[i].level == 4) || (localObject.profileLevels[i].level == 8))
      {
        if ((gHEVCDecoderCaps.width < 352) || (gHEVCDecoderCaps.height < 288))
        {
          gHEVCDecoderCaps.width = 352;
          gHEVCDecoderCaps.height = 288;
        }
      }
      else if ((localObject.profileLevels[i].level == 16) || (localObject.profileLevels[i].level == 32))
      {
        if ((gHEVCDecoderCaps.width < 640) || (gHEVCDecoderCaps.height < 360))
        {
          gHEVCDecoderCaps.width = 640;
          gHEVCDecoderCaps.height = 360;
        }
      }
      else if ((localObject.profileLevels[i].level == 64) || (localObject.profileLevels[i].level == 128))
      {
        if ((gHEVCDecoderCaps.width < 960) || (gHEVCDecoderCaps.height < 540))
        {
          gHEVCDecoderCaps.width = 960;
          gHEVCDecoderCaps.height = 540;
        }
      }
      else if ((localObject.profileLevels[i].level == 256) || (localObject.profileLevels[i].level == 512))
      {
        if ((gHEVCDecoderCaps.width < 1280) || (gHEVCDecoderCaps.height < 720))
        {
          gHEVCDecoderCaps.width = 1280;
          gHEVCDecoderCaps.height = 720;
        }
      }
      else if ((localObject.profileLevels[i].level == 1024) || (localObject.profileLevels[i].level == 2048))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((localObject.profileLevels[i].level == 4096) || (localObject.profileLevels[i].level == 8192))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((localObject.profileLevels[i].level == 16384) || (localObject.profileLevels[i].level == 32768))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 65536) || (localObject.profileLevels[i].level == 131072))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 262144) || (localObject.profileLevels[i].level == 524288))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 1048576) || (localObject.profileLevels[i].level == 2097152))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if ((localObject.profileLevels[i].level == 4194304) || (localObject.profileLevels[i].level == 8388608))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if ((localObject.profileLevels[i].level >= 16777216) || (localObject.profileLevels[i].level >= 33554432))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else {
        AVCoreLog.e(paramString, "initHevcDecoderCaps caps.profileLevels[" + i + "].level = " + localObject.profileLevels[i].level);
      }
    }
  }
  
  private static void initHevcEncoderCaps()
  {
    Object localObject = AndroidCodecBase.getDecoderInfos("video/hevc");
    if (((List)localObject).size() == 0) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("NativieCodec", "initHevcEncoderCaps fail, lists.size为0");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), "video/hevc");
      } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
      gHEVCEncoderCaps = new NativeCodecBase.AVCCaps();
      i = 0;
    } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length);
    switch (localObject.profileLevels[i].profile)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      gHEVCEncoderCaps.profile = 1;
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localObject.profileLevels[i];
      localCodecProfileLevel.level = 16384;
      setHevcLevel(localCodecProfileLevel, gHEVCEncoderCaps);
    }
  }
  
  private static void setHevcLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodecBase.AVCCaps paramAVCCaps)
  {
    if (paramCodecProfileLevel.level == 1) {
      if ((paramAVCCaps.width < 192) || (paramAVCCaps.height < 144))
      {
        paramAVCCaps.width = 192;
        paramAVCCaps.height = 144;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (paramCodecProfileLevel.level != 4) {
                              break;
                            }
                          } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                          paramAVCCaps.width = 352;
                          paramAVCCaps.height = 288;
                          return;
                          if (paramCodecProfileLevel.level != 16) {
                            break;
                          }
                        } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576));
                        paramAVCCaps.width = 352;
                        paramAVCCaps.height = 576;
                        return;
                        if (paramCodecProfileLevel.level != 64) {
                          break;
                        }
                      } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                      paramAVCCaps.width = 720;
                      paramAVCCaps.height = 576;
                      return;
                      if (paramCodecProfileLevel.level != 256) {
                        break;
                      }
                    } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720));
                    paramAVCCaps.width = 1280;
                    paramAVCCaps.height = 720;
                    return;
                    if (paramCodecProfileLevel.level != 1024) {
                      break;
                    }
                  } while ((paramAVCCaps.width >= 1920) && (paramAVCCaps.height >= 1080));
                  paramAVCCaps.width = 1920;
                  paramAVCCaps.height = 1080;
                  return;
                  if (paramCodecProfileLevel.level != 4096) {
                    break;
                  }
                } while ((paramAVCCaps.width >= 1920) && (paramAVCCaps.height >= 1080));
                paramAVCCaps.width = 1920;
                paramAVCCaps.height = 1080;
                return;
                if (paramCodecProfileLevel.level != 16384) {
                  break;
                }
              } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
              paramAVCCaps.width = 4096;
              paramAVCCaps.height = 2048;
              return;
              if (paramCodecProfileLevel.level != 65536) {
                break;
              }
            } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
            paramAVCCaps.width = 4096;
            paramAVCCaps.height = 2048;
            return;
            if (paramCodecProfileLevel.level != 262144) {
              break;
            }
          } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
          paramAVCCaps.width = 4096;
          paramAVCCaps.height = 2048;
          return;
          if (paramCodecProfileLevel.level != 1048576) {
            break;
          }
        } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096));
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 4096;
        return;
        if (paramCodecProfileLevel.level != 4194304) {
          break;
        }
      } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096));
      paramAVCCaps.width = 4096;
      paramAVCCaps.height = 4096;
      return;
      if (paramCodecProfileLevel.level != 16777216) {
        break;
      }
    } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096));
    paramAVCCaps.width = 4096;
    paramAVCCaps.height = 4096;
    return;
    AVCoreLog.e("NativeCodec", "setHevcLevel level.level = " + paramCodecProfileLevel.level);
  }
  
  protected static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodecBase.AVCCaps paramAVCCaps)
  {
    switch (paramCodecProfileLevel.level)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                  } while ((paramAVCCaps.width >= 176) && (paramAVCCaps.height >= 144));
                                  paramAVCCaps.width = 176;
                                  paramAVCCaps.height = 144;
                                  return;
                                } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                                paramAVCCaps.width = 352;
                                paramAVCCaps.height = 288;
                                return;
                              } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                              paramAVCCaps.width = 352;
                              paramAVCCaps.height = 288;
                              return;
                            } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                            paramAVCCaps.width = 352;
                            paramAVCCaps.height = 288;
                            return;
                          } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                          paramAVCCaps.width = 352;
                          paramAVCCaps.height = 288;
                          return;
                        } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                        paramAVCCaps.width = 352;
                        paramAVCCaps.height = 288;
                        return;
                      } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576));
                      paramAVCCaps.width = 352;
                      paramAVCCaps.height = 576;
                      return;
                    } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                    paramAVCCaps.width = 720;
                    paramAVCCaps.height = 576;
                    return;
                  } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                  paramAVCCaps.width = 720;
                  paramAVCCaps.height = 576;
                  return;
                } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720));
                paramAVCCaps.width = 1280;
                paramAVCCaps.height = 720;
                return;
              } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 1024));
              paramAVCCaps.width = 1280;
              paramAVCCaps.height = 1024;
              return;
            } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
            paramAVCCaps.width = 2048;
            paramAVCCaps.height = 1024;
            return;
          } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1024;
          return;
        } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1088));
        paramAVCCaps.width = 2048;
        paramAVCCaps.height = 1088;
        return;
      } while ((paramAVCCaps.width >= 3680) && (paramAVCCaps.height >= 1536));
      paramAVCCaps.width = 3680;
      paramAVCCaps.height = 1536;
      return;
    } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2304));
    paramAVCCaps.width = 4096;
    paramAVCCaps.height = 2304;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.NativeCodecBase
 * JD-Core Version:    0.7.0.1
 */