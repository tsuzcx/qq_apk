package com.tencent.aelight.camera.ae.camera.ui.gallery;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.light.LightAsset;
import org.light.MaterialConfig;

class AECaptureCustomMaterialPart$4
  implements Runnable
{
  AECaptureCustomMaterialPart$4(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    LightAsset localLightAsset = VideoSDKMaterialParser.parseVideoMaterial(this.a.a(), "params").getLightAsset();
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
    AECaptureCustomMaterialPart.a(this.this$0).put(this.a.k, localMaterialConfigWrapper);
    ThreadManager.getUIHandler().post(new AECaptureCustomMaterialPart.4.1(this, localMaterialConfigWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.4
 * JD-Core Version:    0.7.0.1
 */