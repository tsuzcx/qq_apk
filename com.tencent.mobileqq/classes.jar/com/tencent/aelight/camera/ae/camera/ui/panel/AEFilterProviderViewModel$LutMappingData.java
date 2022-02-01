package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel$LutMappingData;", "", "k1", "", "k2", "seekThreshold", "", "(FFI)V", "getK1", "()F", "getK2", "getSeekThreshold", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFilterProviderViewModel$LutMappingData
{
  private final float a;
  private final float b;
  private final int c;
  
  public AEFilterProviderViewModel$LutMappingData(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LutMappingData))
      {
        paramObject = (LutMappingData)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (this.c == paramObject.c)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return (Float.floatToIntBits(this.a) * 31 + Float.floatToIntBits(this.b)) * 31 + this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LutMappingData(k1=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", k2=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", seekThreshold=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderViewModel.LutMappingData
 * JD-Core Version:    0.7.0.1
 */