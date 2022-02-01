package com.tencent.aekit.api.standard.filter;

import android.util.Log;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AEFilterManager$4
  implements LightAssetListener
{
  AEFilterManager$4(AEFilterManager paramAEFilterManager) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    Log.d("AEFilterManager", "OnAssetProcessing: " + paramHashMap);
    if (AEFilterManager.access$500(this.this$0) != null) {
      AEFilterManager.access$500(this.this$0).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    Log.d("AEFilterManager", "OnLoadAssetError: " + paramInt);
    if (AEFilterManager.access$500(this.this$0) != null) {
      AEFilterManager.access$500(this.this$0).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.4
 * JD-Core Version:    0.7.0.1
 */