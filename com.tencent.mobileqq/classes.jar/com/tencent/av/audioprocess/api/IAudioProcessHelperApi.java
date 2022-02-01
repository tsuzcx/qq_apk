package com.tencent.av.audioprocess.api;

import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAudioProcessHelperApi
  extends QRouteApi
{
  public abstract IAudioProcessApi createInstance(IAVEngineCommon paramIAVEngineCommon, ISetAudioFrameCallback paramISetAudioFrameCallback);
  
  public abstract void destroyInstance();
  
  public abstract IAudioProcessApi getInstance();
  
  public abstract boolean hasInstance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.audioprocess.api.IAudioProcessHelperApi
 * JD-Core Version:    0.7.0.1
 */