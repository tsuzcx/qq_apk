package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.ae.util.MediaCodecDPC;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;

public class MediaCodecDPCImpl
  implements IMediaCodecDPC
{
  public int getBadCaseReportNumber()
  {
    return MediaCodecDPC.n();
  }
  
  public float getBeatyRate()
  {
    return MediaCodecDPC.e();
  }
  
  public int getCamera2ForceOpenSdkVersion()
  {
    return MediaCodecDPC.w();
  }
  
  public int getCamera2SwitchValue()
  {
    return MediaCodecDPC.x();
  }
  
  public int getCqMaxBitrate()
  {
    return MediaCodecDPC.k();
  }
  
  public int getFollowCaptureGopSize()
  {
    return MediaCodecDPC.v();
  }
  
  public int getQmcfDPCFrameType()
  {
    return MediaCodecDPC.i();
  }
  
  public boolean isARParticleSwtichOpen()
  {
    return MediaCodecDPC.q();
  }
  
  public boolean isBadCaseReport()
  {
    return MediaCodecDPC.m();
  }
  
  public boolean isBeautySwitchOpen()
  {
    return MediaCodecDPC.d();
  }
  
  public boolean isCqBitrateModeSwitchOpen()
  {
    return MediaCodecDPC.j();
  }
  
  public boolean isDanceRankingSwitchOpen()
  {
    return MediaCodecDPC.p();
  }
  
  public boolean isDeNoiseSwitchOpen()
  {
    return MediaCodecDPC.h();
  }
  
  public boolean isFaceDanceSwitchOpen()
  {
    return MediaCodecDPC.l();
  }
  
  public boolean isFollowCaptureSwitchOpen()
  {
    return MediaCodecDPC.u();
  }
  
  public boolean isGestureSwitchOpen()
  {
    return MediaCodecDPC.g();
  }
  
  public boolean isPortraitSwitchOpen()
  {
    return MediaCodecDPC.o();
  }
  
  public boolean isSamSungCameraOpen()
  {
    return DovSVParamManager.a().d();
  }
  
  public boolean isSegmentMediaCodecEncodeSwtichOpen()
  {
    return MediaCodecDPC.r();
  }
  
  public boolean isSvafSwitchOpen()
  {
    return MediaCodecDPC.f();
  }
  
  public boolean isSwitchOpen()
  {
    return MediaCodecDPC.c();
  }
  
  public boolean isTransitionSwtichOpen()
  {
    return MediaCodecDPC.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.MediaCodecDPCImpl
 * JD-Core Version:    0.7.0.1
 */