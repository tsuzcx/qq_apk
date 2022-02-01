package com.tencent.aelight.camera.ae.camera.filter;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.Map;

public class AEFilterConfig$Factory
{
  public static AEFilterConfig a()
  {
    AEFilterConfig localAEFilterConfig = new AEFilterConfig(null);
    AEFilterConfig.a(localAEFilterConfig, "defaultBeautyV6.json");
    AEFilterConfig.a(localAEFilterConfig, false);
    AEFilterConfig.b(localAEFilterConfig, false);
    AEFilterConfig.c(localAEFilterConfig, false);
    AEFilterConfig.d(localAEFilterConfig, true);
    AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.EYE_LIGHTEN, Integer.valueOf(35));
    AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.REMOVE_POUNCH, Integer.valueOf(40));
    AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.COLOR_TONE, Integer.valueOf(50));
    return localAEFilterConfig;
  }
  
  public static AEFilterConfig b()
  {
    AEFilterConfig localAEFilterConfig = new AEFilterConfig(null);
    AEFilterConfig.a(localAEFilterConfig, "defaultBeautyV7.json");
    Integer localInteger = Integer.valueOf(0);
    AEFilterConfig.a(localAEFilterConfig, false);
    AEFilterConfig.b(localAEFilterConfig, true);
    AEFilterConfig.c(localAEFilterConfig, true);
    AEFilterConfig.d(localAEFilterConfig, false);
    if (AEOfflineConfig.getPhonePerfLevel() < 3)
    {
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA, localInteger);
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.REMOVE_POUNCH, localInteger);
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK, localInteger);
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.FACE_FEATURE_SOFT, localInteger);
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.TOOTH_WHITEN, localInteger);
      AEFilterConfig.a(localAEFilterConfig).put(BeautyRealConfig.TYPE.REMOVE_WRINKLES2, localInteger);
    }
    localAEFilterConfig.g();
    return localAEFilterConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterConfig.Factory
 * JD-Core Version:    0.7.0.1
 */