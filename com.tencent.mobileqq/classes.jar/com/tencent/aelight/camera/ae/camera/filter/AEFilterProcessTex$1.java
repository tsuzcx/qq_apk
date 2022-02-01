package com.tencent.aelight.camera.ae.camera.filter;

import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;

class AEFilterProcessTex$1
  implements LightNode.ILightNodeTipsListener
{
  AEFilterProcessTex$1(AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void onHideNormalTip()
  {
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).onHideNormalTip();
    }
  }
  
  public void onHidePagTip()
  {
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).onHidePagTip();
    }
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).onShowNormalTip(paramString1, paramString2, paramInt);
    }
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    if (AEFilterProcessTex.a(this.a) != null) {
      AEFilterProcessTex.a(this.a).onShowPagTip(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.1
 * JD-Core Version:    0.7.0.1
 */