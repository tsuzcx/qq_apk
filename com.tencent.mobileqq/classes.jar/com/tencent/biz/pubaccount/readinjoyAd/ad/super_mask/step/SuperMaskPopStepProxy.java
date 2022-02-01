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
    if (a == null) {
      return false;
    }
    return a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskPopStepProxy
 * JD-Core Version:    0.7.0.1
 */