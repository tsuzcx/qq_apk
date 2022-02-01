package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;

class AECameraGLSurfaceView$7
  implements LightNode.ILightNodeTipsListener
{
  AECameraGLSurfaceView$7(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onHideNormalTip()
  {
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onHideNormalTip();
    }
  }
  
  public void onHidePagTip()
  {
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onHidePagTip();
    }
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onShowNormalTip(paramString1, paramString2, paramInt);
    }
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onShowPagTip(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.7
 * JD-Core Version:    0.7.0.1
 */