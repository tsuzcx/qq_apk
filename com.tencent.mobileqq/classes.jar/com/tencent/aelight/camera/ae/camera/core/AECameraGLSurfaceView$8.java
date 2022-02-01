package com.tencent.aelight.camera.ae.camera.core;

import android.util.Log;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AECameraGLSurfaceView$8
  implements LightAssetListener
{
  AECameraGLSurfaceView$8(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnAssetProcessing: ");
    localStringBuilder.append(paramHashMap);
    Log.d("AECameraGLSurfaceView", localStringBuilder.toString());
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onAssetProcessingData(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnLoadAssetError: ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = AECameraGLSurfaceView.access$600(paramInt);
    if (localObject != null) {
      AECameraGLSurfaceView.access$700(this.this$0, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.8
 * JD-Core Version:    0.7.0.1
 */