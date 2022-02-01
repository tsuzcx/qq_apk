package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialManager$saveFavoriteMaterials$1$1
  extends Lambda
  implements Function1<AEMaterialMetaData, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  AEFlashShowMaterialManager$saveFavoriteMaterials$1$1()
  {
    super(1);
  }
  
  public final boolean invoke(AEMaterialMetaData paramAEMaterialMetaData)
  {
    return paramAEMaterialMetaData.Z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager.saveFavoriteMaterials.1.1
 * JD-Core Version:    0.7.0.1
 */