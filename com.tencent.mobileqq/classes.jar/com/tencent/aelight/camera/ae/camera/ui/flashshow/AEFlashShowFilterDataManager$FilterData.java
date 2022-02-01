package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowFilterDataManager$FilterData;", "", "seekBarValue", "", "(I)V", "getSeekBarValue", "()I", "setSeekBarValue", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowFilterDataManager$FilterData
{
  @SerializedName("seek_bar_value")
  private int a;
  
  public AEFlashShowFilterDataManager$FilterData(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FilterData))
      {
        paramObject = (FilterData)paramObject;
        if (this.a == paramObject.a) {}
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
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterData(seekBarValue=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager.FilterData
 * JD-Core Version:    0.7.0.1
 */