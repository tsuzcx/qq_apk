package com.tencent.autotemplate.model.rhythm;

import com.google.gson.annotations.SerializedName;

public class TAVEffectPoint
{
  @SerializedName("effectId")
  private String effectId;
  @SerializedName("time")
  private double time;
  @SerializedName("type")
  private String type;
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setEffectId(String paramString)
  {
    this.effectId = paramString;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVEffectPoint
 * JD-Core Version:    0.7.0.1
 */