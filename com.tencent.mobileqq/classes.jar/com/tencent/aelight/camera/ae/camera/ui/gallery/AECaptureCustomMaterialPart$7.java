package com.tencent.aelight.camera.ae.camera.ui.gallery;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.light.LightAsset;
import org.light.MaterialConfig;

class AECaptureCustomMaterialPart$7
  implements Runnable
{
  AECaptureCustomMaterialPart$7(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    LightAsset localLightAsset = VideoSDKMaterialParser.parseVideoMaterial(this.a.e(), "params").getLightAsset();
    Object localObject2 = null;
    AECaptureCustomMaterialPart.MaterialConfigWrapper localMaterialConfigWrapper = new AECaptureCustomMaterialPart.MaterialConfigWrapper(null);
    Object localObject1 = localObject2;
    if (localLightAsset != null)
    {
      localObject1 = localObject2;
      if (localLightAsset.materialConfigs() != null)
      {
        localObject1 = localObject2;
        if (localLightAsset.materialConfigs().length > 0) {
          localObject1 = localLightAsset.materialConfigs()[0];
        }
      }
    }
    localMaterialConfigWrapper.a = ((MaterialConfig)localObject1);
    AECaptureCustomMaterialPart.b(this.this$0).put(this.a.m, localMaterialConfigWrapper);
    ThreadManager.getUIHandler().post(new AECaptureCustomMaterialPart.7.1(this, localMaterialConfigWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.7
 * JD-Core Version:    0.7.0.1
 */