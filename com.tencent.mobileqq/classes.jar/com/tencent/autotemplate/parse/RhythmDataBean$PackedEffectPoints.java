package com.tencent.autotemplate.parse;

import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import java.util.List;

public class RhythmDataBean$PackedEffectPoints
{
  @SerializedName("effectPoints")
  public List<TAVEffectPoint> effectPoints;
  @SerializedName("name")
  public String name;
  
  public List<TAVEffectPoint> getEffectPoints()
  {
    return this.effectPoints;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setEffectPoints(List<TAVEffectPoint> paramList)
  {
    this.effectPoints = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.parse.RhythmDataBean.PackedEffectPoints
 * JD-Core Version:    0.7.0.1
 */