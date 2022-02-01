package com.tencent.YTFace.model;

import java.io.Serializable;

public class FaceStatus
  implements Serializable
{
  public String cate_id = "";
  public float[] feature;
  public int height;
  public double illumination_score;
  public int left_eye_open;
  public float pitch;
  public int right_eye_open;
  public float roll;
  public float rotate;
  public int smile = -1;
  public int trace_id;
  public int width;
  public int x;
  public float[] xys;
  public int y;
  public float yaw;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceStatus{ pitch=");
    localStringBuilder.append(this.pitch);
    localStringBuilder.append(", yaw=");
    localStringBuilder.append(this.yaw);
    localStringBuilder.append(", roll=");
    localStringBuilder.append(this.roll);
    localStringBuilder.append(", illumination_score=");
    localStringBuilder.append(this.illumination_score);
    localStringBuilder.append(", trace_id=");
    localStringBuilder.append(this.trace_id);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.YTFace.model.FaceStatus
 * JD-Core Version:    0.7.0.1
 */