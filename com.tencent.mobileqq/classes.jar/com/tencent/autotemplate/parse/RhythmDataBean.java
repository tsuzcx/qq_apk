package com.tencent.autotemplate.parse;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RhythmDataBean
{
  @SerializedName("allData")
  public List<RhythmDataBean.PackedEffectPoints> allData;
  
  public List<RhythmDataBean.PackedEffectPoints> getAllData()
  {
    return this.allData;
  }
  
  public void setAllData(List<RhythmDataBean.PackedEffectPoints> paramList)
  {
    this.allData = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.parse.RhythmDataBean
 * JD-Core Version:    0.7.0.1
 */