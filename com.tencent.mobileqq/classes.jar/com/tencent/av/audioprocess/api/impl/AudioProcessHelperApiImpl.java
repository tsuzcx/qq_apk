package com.tencent.av.audioprocess.api.impl;

import androidx.annotation.RequiresApi;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.audioprocess.api.IAudioProcessHelperApi;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.log.AVLog;

@RequiresApi(api=16)
public class AudioProcessHelperApiImpl
  implements IAudioProcessHelperApi
{
  private static final String TAG = "AudioProcessHelperImplApi";
  private static volatile IAVEngineCommon sEngineCommon;
  private static volatile IAudioProcessApi sInstance;
  private static volatile ISetAudioFrameCallback sSetAudioFrameCallback;
  
  public IAudioProcessApi createInstance(IAVEngineCommon paramIAVEngineCommon, ISetAudioFrameCallback paramISetAudioFrameCallback)
  {
    if ((hasInstance()) && (sEngineCommon == null))
    {
      AVLog.b("AudioProcessHelperImplApi", "destroyInstance when sEngineCommon == null.");
      destroyInstance();
    }
    try
    {
      sEngineCommon = paramIAVEngineCommon;
      sSetAudioFrameCallback = paramISetAudioFrameCallback;
      paramIAVEngineCommon = new StringBuilder();
      paramIAVEngineCommon.append("createInstance. sEngineCommon = ");
      paramIAVEngineCommon.append(sEngineCommon);
      AVLog.c("AudioProcessHelperImplApi", paramIAVEngineCommon.toString(), new Throwable("打印调用栈"));
      return getInstance();
    }
    finally {}
  }
  
  public void destroyInstance()
  {
    if (sInstance != null) {
      try
      {
        if (sInstance != null) {
          sInstance.unInit();
        }
        sEngineCommon = null;
        sInstance = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroyInstance. sEngineCommon = ");
        localStringBuilder.append(sEngineCommon);
        AVLog.c("AudioProcessHelperImplApi", localStringBuilder.toString(), new Throwable("打印调用栈"));
        return;
      }
      finally {}
    }
  }
  
  public IAudioProcessApi getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null)
        {
          sInstance = (IAudioProcessApi)QRoute.api(IAudioProcessApi.class);
          sInstance.init(sEngineCommon, sSetAudioFrameCallback);
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public boolean hasInstance()
  {
    return sInstance != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.audioprocess.api.impl.AudioProcessHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */