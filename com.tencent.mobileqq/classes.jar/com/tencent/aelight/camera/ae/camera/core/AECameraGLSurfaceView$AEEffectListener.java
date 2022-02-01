package com.tencent.aelight.camera.ae.camera.core;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

public abstract interface AECameraGLSurfaceView$AEEffectListener
{
  public abstract void onAssetProcessingData(HashMap<String, String> paramHashMap);
  
  public abstract void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onHideNormalTip();
  
  public abstract void onHidePagTip();
  
  public abstract void onRequestChangeCamera(int paramInt, @NonNull AECameraManager.CameraOpenCallback paramCameraOpenCallback);
  
  public abstract void onSelectFaceEffect(VideoMaterial paramVideoMaterial);
  
  public abstract void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex);
  
  public abstract void onShowNormalTip(String paramString1, String paramString2, int paramInt);
  
  public abstract void onShowPagTip(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
 * JD-Core Version:    0.7.0.1
 */