package com.tencent.aelight.camera.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMediaCodecDPC
  extends QRouteApi
{
  public abstract int getBadCaseReportNumber();
  
  public abstract float getBeatyRate();
  
  public abstract int getCamera2ForceOpenSdkVersion();
  
  public abstract int getCamera2SwitchValue();
  
  public abstract int getCqMaxBitrate();
  
  public abstract int getFollowCaptureGopSize();
  
  public abstract int getQmcfDPCFrameType();
  
  public abstract boolean isARParticleSwtichOpen();
  
  public abstract boolean isBadCaseReport();
  
  public abstract boolean isBeautySwitchOpen();
  
  public abstract boolean isCqBitrateModeSwitchOpen();
  
  public abstract boolean isDanceRankingSwitchOpen();
  
  public abstract boolean isDeNoiseSwitchOpen();
  
  public abstract boolean isFaceDanceSwitchOpen();
  
  public abstract boolean isFollowCaptureSwitchOpen();
  
  public abstract boolean isGestureSwitchOpen();
  
  public abstract boolean isPortraitSwitchOpen();
  
  public abstract boolean isSamSungCameraOpen();
  
  public abstract boolean isSegmentMediaCodecEncodeSwtichOpen();
  
  public abstract boolean isSvafSwitchOpen();
  
  public abstract boolean isSwitchOpen();
  
  public abstract boolean isTransitionSwtichOpen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.IMediaCodecDPC
 * JD-Core Version:    0.7.0.1
 */