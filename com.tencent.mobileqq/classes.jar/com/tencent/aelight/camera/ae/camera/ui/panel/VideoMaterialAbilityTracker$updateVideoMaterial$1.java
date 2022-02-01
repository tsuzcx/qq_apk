package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.light.LightAsset;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoMaterialAbilityTracker$updateVideoMaterial$1
  implements Runnable
{
  public final void run()
  {
    Object localObject = VideoMaterial.loadLightAsset(this.a.e());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoMaterial");
    localObject = ((VideoMaterial)localObject).getLightAsset();
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      if (((LightAsset)localObject).hasMesh()) {
        j = 2;
      }
      i = j;
      if (((LightAsset)localObject).hasMakeup()) {
        i = j | 0x1;
      }
    }
    this.b.a(i, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.VideoMaterialAbilityTracker.updateVideoMaterial.1
 * JD-Core Version:    0.7.0.1
 */