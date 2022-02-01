package com.tencent.aelight.camera.ae.camera.filter;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

class AEFilterProcessTex$3
  implements Runnable
{
  AEFilterProcessTex$3(AEFilterProcessTex paramAEFilterProcessTex, boolean paramBoolean) {}
  
  public void run()
  {
    if (AEFilterProcessTex.a(this.this$0) != null)
    {
      AEFilterProcessTex.a(this.this$0).switchAbilityInLightNode("ai.segmentation.bg.enable", this.a);
      if (this.a)
      {
        AEFilterProcessTex.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
        return;
      }
      AEFilterProcessTex.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.3
 * JD-Core Version:    0.7.0.1
 */