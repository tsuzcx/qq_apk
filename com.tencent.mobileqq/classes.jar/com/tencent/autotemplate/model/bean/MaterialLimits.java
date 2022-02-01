package com.tencent.autotemplate.model.bean;

import com.google.gson.annotations.SerializedName;

public class MaterialLimits
{
  public static final int TYPE_ALL = 2;
  public static final int TYPE_IMAGE = 1;
  public static final int TYPE_VIDEO = 0;
  @SerializedName("material_type")
  public int materialType = 2;
  @SerializedName("max_counts")
  public int maxCounts;
  @SerializedName("min_counts")
  public int minCounts;
  @SerializedName("min_duration_ms")
  public long minDurationMs;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.model.bean.MaterialLimits
 * JD-Core Version:    0.7.0.1
 */