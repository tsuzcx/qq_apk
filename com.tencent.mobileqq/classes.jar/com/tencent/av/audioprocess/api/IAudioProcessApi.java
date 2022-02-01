package com.tencent.av.audioprocess.api;

import com.tencent.av.audioprocess.AudioProcessCallback.OnRecog;
import com.tencent.av.audioprocess.AudioProcessCallback.OnRecord;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IAudioProcessApi
  extends QRouteApi
{
  public abstract void addFile(String paramString, int paramInt1, float paramFloat, int paramInt2);
  
  public abstract void addPCMData(byte[] paramArrayOfByte, int paramInt);
  
  public abstract boolean init(IAVEngineCommon paramIAVEngineCommon, ISetAudioFrameCallback paramISetAudioFrameCallback);
  
  public abstract boolean isPlayStarted();
  
  public abstract boolean isRecogStarted();
  
  public abstract boolean isRecordStarted();
  
  public abstract void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void pausePlay();
  
  public abstract void pauseRecord();
  
  public abstract void removeAllFiles();
  
  public abstract void removeFile(String paramString);
  
  public abstract void resumePlay();
  
  public abstract void resumeRecord();
  
  public abstract void scaleVolumeValue(byte[] paramArrayOfByte, float paramFloat);
  
  public abstract boolean startPlay(int paramInt);
  
  public abstract boolean startRecog(AudioProcessCallback.OnRecog paramOnRecog);
  
  public abstract boolean startRecord(int paramInt, AudioProcessCallback.OnRecord paramOnRecord);
  
  public abstract void stopPlay();
  
  public abstract void stopRecog();
  
  public abstract void stopRecord();
  
  public abstract void unInit();
  
  public abstract void updateRecogTxt(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.audioprocess.api.IAudioProcessApi
 * JD-Core Version:    0.7.0.1
 */