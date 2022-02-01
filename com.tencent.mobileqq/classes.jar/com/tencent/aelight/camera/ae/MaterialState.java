package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/MaterialState;", "", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "type", "", "(Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;I)V", "getMaterial", "()Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "getType", "()I", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class MaterialState
{
  public static final MaterialState.Companion a = new MaterialState.Companion(null);
  @Nullable
  private final AEMaterialMetaData b;
  private final int c;
  
  public MaterialState(@Nullable AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    this.b = paramAEMaterialMetaData;
    this.c = paramInt;
  }
  
  @Nullable
  public final AEMaterialMetaData a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.MaterialState
 * JD-Core Version:    0.7.0.1
 */