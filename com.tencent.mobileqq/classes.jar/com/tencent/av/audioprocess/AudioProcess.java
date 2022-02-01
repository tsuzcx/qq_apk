package com.tencent.av.audioprocess;

import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.audioprocess.api.IAudioProcessHelperApi;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRoute;

public class AudioProcess
{
  public static IAudioProcessApi a()
  {
    return ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).getInstance();
  }
  
  public static IAudioProcessApi a(IAVEngineCommon paramIAVEngineCommon, ISetAudioFrameCallback paramISetAudioFrameCallback)
  {
    return ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).createInstance(paramIAVEngineCommon, paramISetAudioFrameCallback);
  }
  
  public static void a()
  {
    ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).destroyInstance();
  }
  
  public static void a(byte[] paramArrayOfByte, float paramFloat)
  {
    ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).getInstance().scaleVolumeValue(paramArrayOfByte, paramFloat);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt)
  {
    ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).getInstance().addPCMData(paramArrayOfByte, paramInt);
  }
  
  public static boolean a()
  {
    return ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).hasInstance();
  }
  
  public static boolean a(int paramInt)
  {
    return ((IAudioProcessHelperApi)QRoute.api(IAudioProcessHelperApi.class)).getInstance().startPlay(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.audioprocess.AudioProcess
 * JD-Core Version:    0.7.0.1
 */