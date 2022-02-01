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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnAssetProcessing: ");
    localStringBuilder.append(paramHashMap);
    Log.d("AEFilterManager", localStringBuilder.toString());
    if (AEFilterManager.access$600(this.this$0) != null) {
      AEFilterManager.access$600(this.this$0).OnAssetProcessing(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnLoadAssetError: ");
    localStringBuilder.append(paramInt);
    Log.d("AEFilterManager", localStringBuilder.toString());
    if (AEFilterManager.access$600(this.this$0) != null) {
      AEFilterManager.access$600(this.this$0).OnLoadAssetError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.4
 * JD-Core Version:    0.7.0.1
 */