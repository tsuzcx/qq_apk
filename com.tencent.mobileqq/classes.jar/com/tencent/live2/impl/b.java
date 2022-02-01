package com.tencent.live2.impl;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMixStream;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  public static int a(V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    int i = 0;
    if (paramV2TXLiveBufferType == null) {
      return 0;
    }
    int j = b.1.d[paramV2TXLiveBufferType.ordinal()];
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            return 0;
          }
          return 1;
        }
        return 2;
      }
      i = 3;
    }
    return i;
  }
  
  public static int a(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    int i = 0;
    if (paramV2TXLiveFillMode == null) {
      return 0;
    }
    int j = b.1.b[paramV2TXLiveFillMode.ordinal()];
    if (j != 1)
    {
      if (j != 2) {
        return 0;
      }
      i = 1;
    }
    return i;
  }
  
  public static int a(V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat)
  {
    int i = 0;
    if (paramV2TXLivePixelFormat == null) {
      return 0;
    }
    int j = b.1.c[paramV2TXLivePixelFormat.ordinal()];
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return 0;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  public static int a(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    if (paramV2TXLiveRotation == null) {
      return 0;
    }
    int i = b.1.a[paramV2TXLiveRotation.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 0;
        }
        return 90;
      }
      return 180;
    }
    return 270;
  }
  
  public static int a(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution)
  {
    int j = b.1.f[paramV2TXLiveVideoResolution.ordinal()];
    int i = 1;
    switch (j)
    {
    default: 
      return 1;
    case 12: 
      return 30;
    case 11: 
      return 2;
    case 9: 
      return 0;
    case 8: 
      return 8;
    case 7: 
      return 7;
    case 6: 
      return 13;
    case 5: 
      return 12;
    case 4: 
      return 11;
    case 3: 
      return 17;
    case 2: 
      return 18;
    case 1: 
      i = 19;
    }
    return i;
  }
  
  public static V2TXLiveDef.V2TXLiveMode a(String paramString)
  {
    if ((!paramString.startsWith("trtc://")) && (!paramString.startsWith("room://cloud.tencent.com/rtc")) && (!paramString.startsWith("room://rtc.tencent.com")))
    {
      TXCLog.i("V2TXLiveUtils", "parseLiveMode: rtmp.");
      return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
    }
    TXCLog.i("V2TXLiveUtils", "parseLiveMode: rtc.");
    return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
  }
  
  public static V2TXLiveDef.V2TXLiveVideoFrame a(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    if (paramTRTCVideoFrame == null) {
      return null;
    }
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
    int i = paramTRTCVideoFrame.pixelFormat;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
      }
      else {
        localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
      }
    }
    else {
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatUnknown;
    }
    i = paramTRTCVideoFrame.bufferType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
          }
        }
        else {
          localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
        }
      }
      else {
        localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
      }
    }
    else {
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeUnknown;
    }
    localV2TXLiveVideoFrame.width = paramTRTCVideoFrame.width;
    localV2TXLiveVideoFrame.height = paramTRTCVideoFrame.height;
    localV2TXLiveVideoFrame.rotation = paramTRTCVideoFrame.rotation;
    localV2TXLiveVideoFrame.data = paramTRTCVideoFrame.data;
    localV2TXLiveVideoFrame.buffer = paramTRTCVideoFrame.buffer;
    if (paramTRTCVideoFrame.texture != null)
    {
      localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
      localV2TXLiveVideoFrame.texture.eglContext10 = paramTRTCVideoFrame.texture.eglContext10;
      localV2TXLiveVideoFrame.texture.eglContext14 = paramTRTCVideoFrame.texture.eglContext14;
      localV2TXLiveVideoFrame.texture.textureId = paramTRTCVideoFrame.texture.textureId;
    }
    return localV2TXLiveVideoFrame;
  }
  
  public static b.b a(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    b.b localb = new b.b(544, 960);
    switch (b.1.f[paramV2TXLiveVideoResolution.ordinal()])
    {
    default: 
      return localb;
    case 12: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        paramV2TXLiveVideoResolution = new b.b(1088, 1920);
      } else {
        paramV2TXLiveVideoResolution = new b.b(1920, 1088);
      }
      break;
    case 11: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        paramV2TXLiveVideoResolution = new b.b(720, 1280);
      } else {
        paramV2TXLiveVideoResolution = new b.b(1280, 720);
      }
      break;
    case 10: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        return new b.b(544, 960);
      }
      return new b.b(960, 544);
    case 9: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        return new b.b(368, 640);
      }
      return new b.b(640, 368);
    case 8: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        paramV2TXLiveVideoResolution = new b.b(272, 480);
      } else {
        paramV2TXLiveVideoResolution = new b.b(480, 272);
      }
      break;
    case 7: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        paramV2TXLiveVideoResolution = new b.b(192, 320);
      } else {
        paramV2TXLiveVideoResolution = new b.b(320, 192);
      }
      break;
    case 6: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        return new b.b(480, 640);
      }
      return new b.b(640, 480);
    case 5: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        return new b.b(368, 480);
      }
      return new b.b(480, 368);
    case 4: 
      if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait) {
        paramV2TXLiveVideoResolution = new b.b(240, 320);
      } else {
        paramV2TXLiveVideoResolution = new b.b(320, 240);
      }
      return paramV2TXLiveVideoResolution;
    case 3: 
      return new b.b(480, 480);
    case 2: 
      return new b.b(270, 270);
    }
    return new b.b(160, 160);
  }
  
  public static TRTCCloudDef.TRTCTranscodingConfig a(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    if (paramV2TXLiveTranscodingConfig == null) {
      return null;
    }
    TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
    localTRTCTranscodingConfig.videoWidth = paramV2TXLiveTranscodingConfig.videoWidth;
    localTRTCTranscodingConfig.videoHeight = paramV2TXLiveTranscodingConfig.videoHeight;
    localTRTCTranscodingConfig.videoBitrate = paramV2TXLiveTranscodingConfig.videoBitrate;
    localTRTCTranscodingConfig.videoFramerate = paramV2TXLiveTranscodingConfig.videoFramerate;
    localTRTCTranscodingConfig.videoGOP = paramV2TXLiveTranscodingConfig.videoGOP;
    localTRTCTranscodingConfig.backgroundColor = paramV2TXLiveTranscodingConfig.backgroundColor;
    localTRTCTranscodingConfig.backgroundImage = paramV2TXLiveTranscodingConfig.backgroundImage;
    localTRTCTranscodingConfig.audioSampleRate = paramV2TXLiveTranscodingConfig.audioSampleRate;
    localTRTCTranscodingConfig.audioBitrate = paramV2TXLiveTranscodingConfig.audioBitrate;
    localTRTCTranscodingConfig.audioChannels = paramV2TXLiveTranscodingConfig.audioChannels;
    localTRTCTranscodingConfig.streamId = paramV2TXLiveTranscodingConfig.outputStreamId;
    if (paramV2TXLiveTranscodingConfig.mixStreams != null)
    {
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      paramV2TXLiveTranscodingConfig = paramV2TXLiveTranscodingConfig.mixStreams.iterator();
      while (paramV2TXLiveTranscodingConfig.hasNext())
      {
        V2TXLiveDef.V2TXLiveMixStream localV2TXLiveMixStream = (V2TXLiveDef.V2TXLiveMixStream)paramV2TXLiveTranscodingConfig.next();
        if (localV2TXLiveMixStream != null)
        {
          TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
          localTRTCMixUser.userId = localV2TXLiveMixStream.userId;
          localTRTCMixUser.roomId = localV2TXLiveMixStream.streamId;
          localTRTCMixUser.x = localV2TXLiveMixStream.x;
          localTRTCMixUser.y = localV2TXLiveMixStream.y;
          localTRTCMixUser.width = localV2TXLiveMixStream.width;
          localTRTCMixUser.height = localV2TXLiveMixStream.height;
          localTRTCMixUser.zOrder = localV2TXLiveMixStream.zOrder;
          if (localV2TXLiveMixStream.inputType != null)
          {
            int i = b.1.e[localV2TXLiveMixStream.inputType.ordinal()];
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3) {
                  localTRTCMixUser.inputType = 1;
                } else {
                  localTRTCMixUser.inputType = 3;
                }
              }
              else {
                localTRTCMixUser.inputType = 2;
              }
            }
            else {
              localTRTCMixUser.inputType = 1;
            }
          }
          localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
        }
      }
    }
    return localTRTCTranscodingConfig;
  }
  
  public static TRTCCloudDef.TRTCVideoFrame a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    if (paramV2TXLiveVideoFrame == null) {
      return null;
    }
    TRTCCloudDef.TRTCVideoFrame localTRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
    int i = b.1.c[paramV2TXLiveVideoFrame.pixelFormat.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          localTRTCVideoFrame.pixelFormat = 2;
        }
      }
      else {
        localTRTCVideoFrame.pixelFormat = 1;
      }
    }
    else {
      localTRTCVideoFrame.pixelFormat = 0;
    }
    i = b.1.d[paramV2TXLiveVideoFrame.bufferType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localTRTCVideoFrame.bufferType = 1;
          }
        }
        else {
          localTRTCVideoFrame.bufferType = 2;
        }
      }
      else {
        localTRTCVideoFrame.bufferType = 3;
      }
    }
    else {
      localTRTCVideoFrame.bufferType = 0;
    }
    if (paramV2TXLiveVideoFrame.texture != null)
    {
      localTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
      localTRTCVideoFrame.texture.eglContext10 = paramV2TXLiveVideoFrame.texture.eglContext10;
      localTRTCVideoFrame.texture.eglContext14 = paramV2TXLiveVideoFrame.texture.eglContext14;
      localTRTCVideoFrame.texture.textureId = paramV2TXLiveVideoFrame.texture.textureId;
    }
    localTRTCVideoFrame.data = paramV2TXLiveVideoFrame.data;
    localTRTCVideoFrame.buffer = paramV2TXLiveVideoFrame.buffer;
    localTRTCVideoFrame.width = paramV2TXLiveVideoFrame.width;
    localTRTCVideoFrame.height = paramV2TXLiveVideoFrame.height;
    localTRTCVideoFrame.rotation = paramV2TXLiveVideoFrame.rotation;
    return localTRTCVideoFrame;
  }
  
  public static void a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    int i = b.1.c[paramV2TXLiveVideoFrame.pixelFormat.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramTRTCVideoFrame.pixelFormat = 2;
        }
      }
      else {
        paramTRTCVideoFrame.pixelFormat = 1;
      }
    }
    else {
      paramTRTCVideoFrame.pixelFormat = 0;
    }
    i = b.1.d[paramV2TXLiveVideoFrame.bufferType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            paramTRTCVideoFrame.bufferType = 1;
          }
        }
        else {
          paramTRTCVideoFrame.bufferType = 2;
        }
      }
      else {
        paramTRTCVideoFrame.bufferType = 3;
      }
    }
    else {
      paramTRTCVideoFrame.bufferType = 0;
    }
    if ((paramV2TXLiveVideoFrame.texture != null) && (paramTRTCVideoFrame.texture != null))
    {
      paramTRTCVideoFrame.texture.eglContext10 = paramV2TXLiveVideoFrame.texture.eglContext10;
      paramTRTCVideoFrame.texture.eglContext14 = paramV2TXLiveVideoFrame.texture.eglContext14;
      paramTRTCVideoFrame.texture.textureId = paramV2TXLiveVideoFrame.texture.textureId;
    }
    paramTRTCVideoFrame.data = paramV2TXLiveVideoFrame.data;
    paramTRTCVideoFrame.buffer = paramV2TXLiveVideoFrame.buffer;
    paramTRTCVideoFrame.width = paramV2TXLiveVideoFrame.width;
    paramTRTCVideoFrame.height = paramV2TXLiveVideoFrame.height;
    paramTRTCVideoFrame.rotation = paramV2TXLiveVideoFrame.rotation;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != 30)
    {
      if (paramInt != 31) {}
      switch (paramInt)
      {
      default: 
        return true;
      case 3: 
      case 4: 
      case 5: 
      case 9: 
      case 10: 
      case 14: 
      case 15: 
      case 16: 
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus1, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus2, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    int i = b.1.g[paramV2TXLivePlayStatus1.ordinal()];
    boolean bool2 = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i == 3) && (paramV2TXLivePlayStatus2 == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying))
        {
          bool1 = bool2;
          if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted) {
            break label171;
          }
          if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted)
          {
            bool1 = bool2;
            break label171;
          }
        }
      }
      else
      {
        if ((paramV2TXLivePlayStatus2 == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) && (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd))
        {
          bool1 = bool2;
          break label171;
        }
        if (paramV2TXLivePlayStatus2 == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped)
        {
          bool1 = bool2;
          if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped) {
            break label171;
          }
          if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped)
          {
            bool1 = bool2;
            break label171;
          }
        }
      }
    }
    else
    {
      if ((paramV2TXLivePlayStatus2 == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading) && (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin))
      {
        bool1 = bool2;
        break label171;
      }
      if (paramV2TXLivePlayStatus2 == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped)
      {
        bool1 = bool2;
        if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped) {
          break label171;
        }
        if (paramV2TXLiveStatusChangeReason == V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped)
        {
          bool1 = bool2;
          break label171;
        }
      }
    }
    boolean bool1 = false;
    label171:
    if (!bool1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play state invalid.[current:");
      localStringBuilder.append(paramV2TXLivePlayStatus1);
      localStringBuilder.append("][next:");
      localStringBuilder.append(paramV2TXLivePlayStatus2);
      localStringBuilder.append("][reason:");
      localStringBuilder.append(paramV2TXLiveStatusChangeReason);
      localStringBuilder.append("]");
      TXCLog.e("V2TXLiveUtils", localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static int b(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    int i = 0;
    if (paramV2TXLiveFillMode == null) {
      return 0;
    }
    int j = b.1.b[paramV2TXLiveFillMode.ordinal()];
    if (j != 1)
    {
      if (j != 2) {
        return 0;
      }
      i = 1;
    }
    return i;
  }
  
  public static int b(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    if (paramV2TXLiveRotation == null) {
      return 0;
    }
    int i = b.1.a[paramV2TXLiveRotation.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }
  
  public static b.a b(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution)
  {
    int m = b.1.f[paramV2TXLiveVideoResolution.ordinal()];
    int k = 900;
    int i = 600;
    int j = k;
    switch (m)
    {
    case 10: 
    default: 
      j = 1500;
      i = 800;
      break;
    case 12: 
      i = 2500;
      j = 3000;
      break;
    case 11: 
      i = 1000;
      j = 1800;
      break;
    case 9: 
      i = 500;
      j = k;
      break;
    case 8: 
      j = 550;
      break;
    case 7: 
      j = 400;
      break;
    case 5: 
      j = 600;
      i = 400;
      break;
    case 4: 
      j = 375;
      i = 250;
      break;
    case 3: 
      j = 525;
      i = 350;
      break;
    case 2: 
      i = 200;
      j = 300;
      break;
    case 1: 
      i = 100;
      j = 150;
    }
    return new b.a(i, j);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "roomsig";
      arrayOfString[1] = "privatemapkey";
      arrayOfString[2] = "usersig";
      int i = 0;
      for (;;)
      {
        Object localObject = paramString;
        try
        {
          if (i >= arrayOfString.length) {
            break label173;
          }
          localObject = paramString;
          if (paramString.contains(arrayOfString[i]))
          {
            int j = paramString.indexOf(arrayOfString[i]);
            localObject = paramString;
            if (j != -1)
            {
              int k = paramString.indexOf("&", j);
              if (k == -1)
              {
                localObject = paramString.substring(0, j);
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(paramString.substring(0, j));
                ((StringBuilder)localObject).append(paramString.substring(k));
                localObject = ((StringBuilder)localObject).toString();
              }
            }
          }
          i += 1;
          paramString = (String)localObject;
        }
        catch (Exception localException1) {}
      }
      TXCLog.e("V2TXLiveUtils", "remove url sensitive info failed.", localException2);
    }
    catch (Exception localException2) {}
    String str = paramString;
    label173:
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.b
 * JD-Core Version:    0.7.0.1
 */