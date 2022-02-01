package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/MaterialPanelOpenState;", "", "show", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "(ZLcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;)V", "getMaterial", "()Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "getShow", "()Z", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class MaterialPanelOpenState
{
  private final boolean a;
  @Nullable
  private final AEMaterialMetaData b;
  
  public MaterialPanelOpenState(boolean paramBoolean, @Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a = paramBoolean;
    this.b = paramAEMaterialMetaData;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @Nullable
  public final AEMaterialMetaData b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.MaterialPanelOpenState
 * JD-Core Version:    0.7.0.1
 */