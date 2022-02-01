package com.tencent.avcore.jni.codec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.os.Build;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void initAVCDecoderCaps(String paramString)
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.d(paramString, "initAVCDecoderCaps");
    }
    Object localObject1 = AndroidCodecBase.getDecoderInfos("video/avc");
    if (((List)localObject1).size() == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(paramString, "initAVCDecoderCaps fail, list.size为0");
      }
      return;
    }
    int i = 0;
    localObject1 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject1).get(0), "video/avc");
    if (localObject1 != null)
    {
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels == null) {
        return;
      }
      gAVCDecoderCaps = new NativeCodecBase.AVCCaps();
      while (i < ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length)
      {
        int j = localObject1.profileLevels[i].profile;
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 4)
            {
              if (j != 8)
              {
                if (j != 16)
                {
                  if (j != 32)
                  {
                    if ((j == 64) && (gAVCDecoderCaps.profile <= 5)) {
                      gAVCDecoderCaps.profile = 5;
                    }
                  }
                  else if (gAVCDecoderCaps.profile <= 5) {
                    gAVCDecoderCaps.profile = 5;
                  }
                }
                else if (gAVCDecoderCaps.profile <= 5) {
                  gAVCDecoderCaps.profile = 5;
                }
              }
              else if (gAVCDecoderCaps.profile <= 5) {
                gAVCDecoderCaps.profile = 5;
              }
            }
            else if (gAVCDecoderCaps.profile <= 5) {
              gAVCDecoderCaps.profile = 5;
            }
          }
          else if (gAVCDecoderCaps.profile <= 4) {
            gAVCDecoderCaps.profile = 4;
          }
        }
        else if (gAVCDecoderCaps.profile <= 3) {
          gAVCDecoderCaps.profile = 3;
        }
        j = localObject1.profileLevels[i].level;
        Object localObject2;
        if (j != 1)
        {
          if (j != 2)
          {
            switch (j)
            {
            default: 
              if (localObject1.profileLevels[i].level < 1)
              {
                if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
                {
                  localObject2 = gAVCDecoderCaps;
                  ((NativeCodecBase.AVCCaps)localObject2).width = 176;
                  ((NativeCodecBase.AVCCaps)localObject2).height = 144;
                }
              }
              else if (localObject1.profileLevels[i].level > 32768)
              {
                if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2160))
                {
                  localObject2 = gAVCDecoderCaps;
                  ((NativeCodecBase.AVCCaps)localObject2).width = 4096;
                  ((NativeCodecBase.AVCCaps)localObject2).height = 2160;
                }
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("initAVCDecoder caps.profileLevels[k].level: ");
                ((StringBuilder)localObject2).append(localObject1.profileLevels[i].level);
                AVCoreLog.e(paramString, ((StringBuilder)localObject2).toString());
              }
              break;
            case 32768: 
              if ((gAVCDecoderCaps.width >= 4096) && (gAVCDecoderCaps.height >= 2048)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 4096;
              ((NativeCodecBase.AVCCaps)localObject2).height = 2048;
              break;
            case 16384: 
              if ((gAVCDecoderCaps.width >= 3680) && (gAVCDecoderCaps.height >= 1536)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 3680;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1536;
              break;
            case 8192: 
              if ((gAVCDecoderCaps.width >= 2048) && (gAVCDecoderCaps.height >= 1088)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 2048;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1088;
              break;
            case 4096: 
              if ((gAVCDecoderCaps.width >= 2048) && (gAVCDecoderCaps.height >= 1024)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 2048;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1024;
              break;
            case 2048: 
              if ((gAVCDecoderCaps.width >= 2048) && (gAVCDecoderCaps.height >= 1024)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 2048;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1024;
              break;
            case 1024: 
              if ((gAVCDecoderCaps.width >= 1280) && (gAVCDecoderCaps.height >= 1024)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 1280;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1024;
              break;
            case 512: 
              if ((gAVCDecoderCaps.width >= 1280) && (gAVCDecoderCaps.height >= 720)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 1280;
              ((NativeCodecBase.AVCCaps)localObject2).height = 720;
              break;
            case 256: 
              if ((gAVCDecoderCaps.width >= 720) && (gAVCDecoderCaps.height >= 576)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 720;
              ((NativeCodecBase.AVCCaps)localObject2).height = 576;
              break;
            case 128: 
              if ((gAVCDecoderCaps.width >= 720) && (gAVCDecoderCaps.height >= 576)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 720;
              ((NativeCodecBase.AVCCaps)localObject2).height = 576;
              break;
            case 64: 
              if ((gAVCDecoderCaps.width >= 352) && (gAVCDecoderCaps.height >= 576)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 352;
              ((NativeCodecBase.AVCCaps)localObject2).height = 576;
              break;
            case 32: 
              if ((gAVCDecoderCaps.width >= 352) && (gAVCDecoderCaps.height >= 288)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 352;
              ((NativeCodecBase.AVCCaps)localObject2).height = 288;
              break;
            case 16: 
              if ((gAVCDecoderCaps.width >= 352) && (gAVCDecoderCaps.height >= 288)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 352;
              ((NativeCodecBase.AVCCaps)localObject2).height = 288;
              break;
            case 8: 
              if ((gAVCDecoderCaps.width >= 352) && (gAVCDecoderCaps.height >= 288)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 352;
              ((NativeCodecBase.AVCCaps)localObject2).height = 288;
              break;
            case 4: 
              if ((gAVCDecoderCaps.width >= 352) && (gAVCDecoderCaps.height >= 288)) {
                break;
              }
              localObject2 = gAVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 352;
              ((NativeCodecBase.AVCCaps)localObject2).height = 288;
              break;
            }
          }
          else if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
          {
            localObject2 = gAVCDecoderCaps;
            ((NativeCodecBase.AVCCaps)localObject2).width = 352;
            ((NativeCodecBase.AVCCaps)localObject2).height = 288;
          }
        }
        else if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
        {
          localObject2 = gAVCDecoderCaps;
          ((NativeCodecBase.AVCCaps)localObject2).width = 176;
          ((NativeCodecBase.AVCCaps)localObject2).height = 144;
        }
        i += 1;
      }
    }
  }
  
  private static void initAVCEncoderCaps(String paramString)
  {
    Object localObject1 = AndroidCodecBase.getDecoderInfos("video/avc");
    if (((List)localObject1).size() == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(paramString, "initAVCEncoderCaps fail, lists.size为0");
      }
      return;
    }
    boolean bool = false;
    int i = 0;
    localObject1 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject1).get(0), "video/avc");
    if (localObject1 != null)
    {
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels == null) {
        return;
      }
      gAVCEncoderCaps = new NativeCodecBase.AVCCaps();
      Object localObject2;
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length > 0) {
        while (i < ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length)
        {
          if (AVCoreLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("initAVCEncoderCaps, index[");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("], profile[");
            ((StringBuilder)localObject2).append(localObject1.profileLevels[i].profile);
            ((StringBuilder)localObject2).append("]");
            AVCoreLog.e(paramString, ((StringBuilder)localObject2).toString());
          }
          if (localObject1.profileLevels[i].profile == 1)
          {
            gAVCEncoderCaps.profile = 3;
            localObject2 = localObject1.profileLevels[i];
            if ((!AVCoreLog.isGrayVersion()) && (!AVCoreLog.isDebugVersion())) {
              ((MediaCodecInfo.CodecProfileLevel)localObject2).level = 512;
            } else {
              ((MediaCodecInfo.CodecProfileLevel)localObject2).level = 8192;
            }
            setLevel((MediaCodecInfo.CodecProfileLevel)localObject2, gAVCEncoderCaps);
          }
          i += 1;
        }
      }
      if (AVCoreLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initAVCEncoderCaps fail, caps[");
        if (localObject1 != null) {
          bool = true;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("]");
        AVCoreLog.e(paramString, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private static void initHevcDecoderCaps(String paramString)
  {
    Object localObject1 = AndroidCodecBase.getDecoderInfos("video/hevc");
    if (((List)localObject1).size() == 0) {
      return;
    }
    int j = 0;
    localObject1 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject1).get(0), "video/hevc");
    if (localObject1 != null)
    {
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels == null) {
        return;
      }
      gHEVCDecoderCaps = new NativeCodecBase.AVCCaps();
      int i = j;
      Object localObject2;
      if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length == 0) {
        if (!AVCoreLog.isGrayVersion())
        {
          i = j;
          if (!AVCoreLog.isDebugVersion()) {}
        }
        else
        {
          i = j;
          if (Build.HARDWARE != null) {
            if (!Build.HARDWARE.startsWith("hi6250"))
            {
              i = j;
              if (!Build.HARDWARE.startsWith("hi3650")) {}
            }
            else
            {
              localObject2 = gHEVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).profile = 1;
              ((NativeCodecBase.AVCCaps)localObject2).width = 1920;
              ((NativeCodecBase.AVCCaps)localObject2).height = 1080;
              i = j;
            }
          }
        }
      }
      while (i < ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length)
      {
        if (localObject1.profileLevels[i].profile <= 1)
        {
          if (gHEVCDecoderCaps.profile <= 1) {
            gHEVCDecoderCaps.profile = 1;
          }
        }
        else if (localObject1.profileLevels[i].profile == 2)
        {
          if (gHEVCDecoderCaps.profile <= 2) {
            gHEVCDecoderCaps.profile = 2;
          }
        }
        else if ((localObject1.profileLevels[i].profile >= 2) && (gHEVCDecoderCaps.profile <= 2)) {
          gHEVCDecoderCaps.profile = 2;
        }
        if ((localObject1.profileLevels[i].level > 1) && (localObject1.profileLevels[i].level > 2))
        {
          if ((localObject1.profileLevels[i].level != 4) && (localObject1.profileLevels[i].level != 8))
          {
            if ((localObject1.profileLevels[i].level != 16) && (localObject1.profileLevels[i].level != 32))
            {
              if ((localObject1.profileLevels[i].level != 64) && (localObject1.profileLevels[i].level != 128))
              {
                if ((localObject1.profileLevels[i].level != 256) && (localObject1.profileLevels[i].level != 512))
                {
                  if ((localObject1.profileLevels[i].level != 1024) && (localObject1.profileLevels[i].level != 2048))
                  {
                    if ((localObject1.profileLevels[i].level != 4096) && (localObject1.profileLevels[i].level != 8192))
                    {
                      if ((localObject1.profileLevels[i].level != 16384) && (localObject1.profileLevels[i].level != 32768))
                      {
                        if ((localObject1.profileLevels[i].level != 65536) && (localObject1.profileLevels[i].level != 131072))
                        {
                          if ((localObject1.profileLevels[i].level != 262144) && (localObject1.profileLevels[i].level != 524288))
                          {
                            if ((localObject1.profileLevels[i].level != 1048576) && (localObject1.profileLevels[i].level != 2097152))
                            {
                              if ((localObject1.profileLevels[i].level != 4194304) && (localObject1.profileLevels[i].level != 8388608))
                              {
                                if ((localObject1.profileLevels[i].level < 16777216) && (localObject1.profileLevels[i].level < 33554432))
                                {
                                  localObject2 = new StringBuilder();
                                  ((StringBuilder)localObject2).append("initHevcDecoderCaps caps.profileLevels[");
                                  ((StringBuilder)localObject2).append(i);
                                  ((StringBuilder)localObject2).append("].level = ");
                                  ((StringBuilder)localObject2).append(localObject1.profileLevels[i].level);
                                  AVCoreLog.e(paramString, ((StringBuilder)localObject2).toString());
                                }
                                else if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
                                {
                                  localObject2 = gHEVCDecoderCaps;
                                  ((NativeCodecBase.AVCCaps)localObject2).width = 8192;
                                  ((NativeCodecBase.AVCCaps)localObject2).height = 4320;
                                }
                              }
                              else if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
                              {
                                localObject2 = gHEVCDecoderCaps;
                                ((NativeCodecBase.AVCCaps)localObject2).width = 8192;
                                ((NativeCodecBase.AVCCaps)localObject2).height = 4320;
                              }
                            }
                            else if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
                            {
                              localObject2 = gHEVCDecoderCaps;
                              ((NativeCodecBase.AVCCaps)localObject2).width = 8192;
                              ((NativeCodecBase.AVCCaps)localObject2).height = 4320;
                            }
                          }
                          else if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
                          {
                            localObject2 = gHEVCDecoderCaps;
                            ((NativeCodecBase.AVCCaps)localObject2).width = 4096;
                            ((NativeCodecBase.AVCCaps)localObject2).height = 2160;
                          }
                        }
                        else if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
                        {
                          localObject2 = gHEVCDecoderCaps;
                          ((NativeCodecBase.AVCCaps)localObject2).width = 4096;
                          ((NativeCodecBase.AVCCaps)localObject2).height = 2160;
                        }
                      }
                      else if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
                      {
                        localObject2 = gHEVCDecoderCaps;
                        ((NativeCodecBase.AVCCaps)localObject2).width = 4096;
                        ((NativeCodecBase.AVCCaps)localObject2).height = 2160;
                      }
                    }
                    else if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
                    {
                      localObject2 = gHEVCDecoderCaps;
                      ((NativeCodecBase.AVCCaps)localObject2).width = 2048;
                      ((NativeCodecBase.AVCCaps)localObject2).height = 1080;
                    }
                  }
                  else if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
                  {
                    localObject2 = gHEVCDecoderCaps;
                    ((NativeCodecBase.AVCCaps)localObject2).width = 2048;
                    ((NativeCodecBase.AVCCaps)localObject2).height = 1080;
                  }
                }
                else if ((gHEVCDecoderCaps.width < 1280) || (gHEVCDecoderCaps.height < 720))
                {
                  localObject2 = gHEVCDecoderCaps;
                  ((NativeCodecBase.AVCCaps)localObject2).width = 1280;
                  ((NativeCodecBase.AVCCaps)localObject2).height = 720;
                }
              }
              else if ((gHEVCDecoderCaps.width < 960) || (gHEVCDecoderCaps.height < 540))
              {
                localObject2 = gHEVCDecoderCaps;
                ((NativeCodecBase.AVCCaps)localObject2).width = 960;
                ((NativeCodecBase.AVCCaps)localObject2).height = 540;
              }
            }
            else if ((gHEVCDecoderCaps.width < 640) || (gHEVCDecoderCaps.height < 360))
            {
              localObject2 = gHEVCDecoderCaps;
              ((NativeCodecBase.AVCCaps)localObject2).width = 640;
              ((NativeCodecBase.AVCCaps)localObject2).height = 360;
            }
          }
          else if ((gHEVCDecoderCaps.width < 352) || (gHEVCDecoderCaps.height < 288))
          {
            localObject2 = gHEVCDecoderCaps;
            ((NativeCodecBase.AVCCaps)localObject2).width = 352;
            ((NativeCodecBase.AVCCaps)localObject2).height = 288;
          }
        }
        else if ((gHEVCDecoderCaps.width < 176) || (gHEVCDecoderCaps.height < 144))
        {
          localObject2 = gHEVCDecoderCaps;
          ((NativeCodecBase.AVCCaps)localObject2).width = 176;
          ((NativeCodecBase.AVCCaps)localObject2).height = 144;
        }
        i += 1;
      }
    }
  }
  
  private static void initHevcEncoderCaps()
  {
    Object localObject = AndroidCodecBase.getDecoderInfos("video/hevc");
    if (((List)localObject).size() == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("NativieCodec", "initHevcEncoderCaps fail, lists.size为0");
      }
      return;
    }
    int i = 0;
    localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), "video/hevc");
    if (localObject != null)
    {
      if (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null) {
        return;
      }
      gHEVCEncoderCaps = new NativeCodecBase.AVCCaps();
      while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
      {
        if (localObject.profileLevels[i].profile == 1)
        {
          gHEVCEncoderCaps.profile = 1;
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localObject.profileLevels[i];
          localCodecProfileLevel.level = 16384;
          setHevcLevel(localCodecProfileLevel, gHEVCEncoderCaps);
        }
        i += 1;
      }
    }
  }
  
  private static void setHevcLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodecBase.AVCCaps paramAVCCaps)
  {
    if (paramCodecProfileLevel.level == 1)
    {
      if ((paramAVCCaps.width < 192) || (paramAVCCaps.height < 144))
      {
        paramAVCCaps.width = 192;
        paramAVCCaps.height = 144;
      }
    }
    else if (paramCodecProfileLevel.level == 4)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 16)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 576))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 576;
      }
    }
    else if (paramCodecProfileLevel.level == 64)
    {
      if ((paramAVCCaps.width < 720) || (paramAVCCaps.height < 576))
      {
        paramAVCCaps.width = 720;
        paramAVCCaps.height = 576;
      }
    }
    else if (paramCodecProfileLevel.level == 256)
    {
      if ((paramAVCCaps.width < 1280) || (paramAVCCaps.height < 720))
      {
        paramAVCCaps.width = 1280;
        paramAVCCaps.height = 720;
      }
    }
    else if (paramCodecProfileLevel.level == 1024)
    {
      if ((paramAVCCaps.width < 1920) || (paramAVCCaps.height < 1080))
      {
        paramAVCCaps.width = 1920;
        paramAVCCaps.height = 1080;
      }
    }
    else if (paramCodecProfileLevel.level == 4096)
    {
      if ((paramAVCCaps.width < 1920) || (paramAVCCaps.height < 1080))
      {
        paramAVCCaps.width = 1920;
        paramAVCCaps.height = 1080;
      }
    }
    else if (paramCodecProfileLevel.level == 16384)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 2048))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 2048;
      }
    }
    else if (paramCodecProfileLevel.level == 65536)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 2048))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 2048;
      }
    }
    else if (paramCodecProfileLevel.level == 262144)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 2048))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 2048;
      }
    }
    else if (paramCodecProfileLevel.level == 1048576)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 4096))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 4096;
      }
    }
    else if (paramCodecProfileLevel.level == 4194304)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 4096))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 4096;
      }
    }
    else if (paramCodecProfileLevel.level == 16777216)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 4096))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 4096;
      }
    }
    else
    {
      paramAVCCaps = new StringBuilder();
      paramAVCCaps.append("setHevcLevel level.level = ");
      paramAVCCaps.append(paramCodecProfileLevel.level);
      AVCoreLog.e("NativeCodec", paramAVCCaps.toString());
    }
  }
  
  protected static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodecBase.AVCCaps paramAVCCaps)
  {
    int i = paramCodecProfileLevel.level;
    if (i != 1)
    {
      if (i != 2)
      {
        switch (i)
        {
        default: 
          return;
        case 32768: 
          if ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2304)) {
            break;
          }
          paramAVCCaps.width = 4096;
          paramAVCCaps.height = 2304;
          return;
        case 16384: 
          if ((paramAVCCaps.width >= 3680) && (paramAVCCaps.height >= 1536)) {
            break;
          }
          paramAVCCaps.width = 3680;
          paramAVCCaps.height = 1536;
          return;
        case 8192: 
          if ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1088)) {
            break;
          }
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1088;
          return;
        case 4096: 
          if ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024)) {
            break;
          }
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1024;
          return;
        case 2048: 
          if ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024)) {
            break;
          }
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1024;
          return;
        case 1024: 
          if ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 1024)) {
            break;
          }
          paramAVCCaps.width = 1280;
          paramAVCCaps.height = 1024;
          return;
        case 512: 
          if ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720)) {
            break;
          }
          paramAVCCaps.width = 1280;
          paramAVCCaps.height = 720;
          return;
        case 256: 
          if ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576)) {
            break;
          }
          paramAVCCaps.width = 720;
          paramAVCCaps.height = 576;
          return;
        case 128: 
          if ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576)) {
            break;
          }
          paramAVCCaps.width = 720;
          paramAVCCaps.height = 576;
          return;
        case 64: 
          if ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576)) {
            break;
          }
          paramAVCCaps.width = 352;
          paramAVCCaps.height = 576;
          return;
        case 32: 
          if ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288)) {
            break;
          }
          paramAVCCaps.width = 352;
          paramAVCCaps.height = 288;
          return;
        case 16: 
          if ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288)) {
            break;
          }
          paramAVCCaps.width = 352;
          paramAVCCaps.height = 288;
          return;
        case 8: 
          if ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288)) {
            break;
          }
          paramAVCCaps.width = 352;
          paramAVCCaps.height = 288;
          return;
        case 4: 
          if ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288)) {
            break;
          }
          paramAVCCaps.width = 352;
          paramAVCCaps.height = 288;
          return;
        }
      }
      else if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if ((paramAVCCaps.width < 176) || (paramAVCCaps.height < 144))
    {
      paramAVCCaps.width = 176;
      paramAVCCaps.height = 144;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.NativeCodecBase
 * JD-Core Version:    0.7.0.1
 */