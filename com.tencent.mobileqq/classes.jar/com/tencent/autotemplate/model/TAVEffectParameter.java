package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;

public class TAVEffectParameter
{
  @SerializedName("filePath")
  public String filePath;
  @SerializedName("rhythmOffset")
  public long rhythmOffset = 0L;
  @SerializedName("rhythmPosition")
  public long rhythmPosition = 0L;
  @SerializedName("speed")
  public float speed;
  @SerializedName("type")
  public String type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVEffectParameter
 * JD-Core Version:    0.7.0.1
 */