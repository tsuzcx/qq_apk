package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep;

public class SuperMaskPopStepProxy
{
  static RIJADSuperMaskPopupStep a;
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(RIJADSuperMaskPopupStep paramRIJADSuperMaskPopupStep)
  {
    a = paramRIJADSuperMaskPopupStep;
  }
  
  public static boolean a()
  {
    RIJADSuperMaskPopupStep localRIJADSuperMaskPopupStep = a;
    if (localRIJADSuperMaskPopupStep == null) {
      return false;
    }
    return localRIJADSuperMaskPopupStep.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskPopStepProxy
 * JD-Core Version:    0.7.0.1
 */