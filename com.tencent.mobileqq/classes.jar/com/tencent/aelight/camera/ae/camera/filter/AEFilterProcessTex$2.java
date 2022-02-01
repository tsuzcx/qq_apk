package com.tencent.aelight.camera.ae.camera.filter;

import android.util.Log;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AEFilterProcessTex$2
  implements LightAssetListener
{
  AEFilterProcessTex$2(AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnAssetProcessing: ");
    localStringBuilder.append(paramHashMap);
    Log.d("AEFilterProcessTex", localStringBuilder.toString());
    if (AEFilterProcessTex.b(this.a) != null) {
      AEFilterProcessTex.b(this.a).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnLoadAssetError: ");
    localStringBuilder.append(paramInt);
    Log.d("AEFilterProcessTex", localStringBuilder.toString());
    if (AEFilterProcessTex.b(this.a) != null) {
      AEFilterProcessTex.b(this.a).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.2
 * JD-Core Version:    0.7.0.1
 */