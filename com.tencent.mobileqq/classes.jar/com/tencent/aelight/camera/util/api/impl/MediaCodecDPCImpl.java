package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.ae.util.MediaCodecDPC;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;

public class MediaCodecDPCImpl
  implements IMediaCodecDPC
{
  public int getBadCaseReportNumber()
  {
    return MediaCodecDPC.c();
  }
  
  public float getBeatyRate()
  {
    return MediaCodecDPC.a();
  }
  
  public int getCamera2ForceOpenSdkVersion()
  {
    return MediaCodecDPC.e();
  }
  
  public int getCamera2SwitchValue()
  {
    return MediaCodecDPC.f();
  }
  
  public int getCqMaxBitrate()
  {
    return MediaCodecDPC.b();
  }
  
  public int getFollowCaptureGopSize()
  {
    return MediaCodecDPC.d();
  }
  
  public int getQmcfDPCFrameType()
  {
    return MediaCodecDPC.a();
  }
  
  public boolean isARParticleSwtichOpen()
  {
    return MediaCodecDPC.k();
  }
  
  public boolean isBadCaseReport()
  {
    return MediaCodecDPC.h();
  }
  
  public boolean isBeautySwitchOpen()
  {
    return MediaCodecDPC.b();
  }
  
  public boolean isCqBitrateModeSwitchOpen()
  {
    return MediaCodecDPC.f();
  }
  
  public boolean isDanceRankingSwitchOpen()
  {
    return MediaCodecDPC.j();
  }
  
  public boolean isDeNoiseSwitchOpen()
  {
    return MediaCodecDPC.e();
  }
  
  public boolean isFaceDanceSwitchOpen()
  {
    return MediaCodecDPC.g();
  }
  
  public boolean isFollowCaptureSwitchOpen()
  {
    return MediaCodecDPC.o();
  }
  
  public boolean isGestureSwitchOpen()
  {
    return MediaCodecDPC.d();
  }
  
  public boolean isPortraitSwitchOpen()
  {
    return MediaCodecDPC.i();
  }
  
  public boolean isSamSungCameraOpen()
  {
    return DovSVParamManager.a().b();
  }
  
  public boolean isSegmentMediaCodecEncodeSwtichOpen()
  {
    return MediaCodecDPC.l();
  }
  
  public boolean isSvafSwitchOpen()
  {
    return MediaCodecDPC.c();
  }
  
  public boolean isSwitchOpen()
  {
    return MediaCodecDPC.a();
  }
  
  public boolean isTransitionSwtichOpen()
  {
    return MediaCodecDPC.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.MediaCodecDPCImpl
 * JD-Core Version:    0.7.0.1
 */