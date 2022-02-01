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
  public long nativeFaceAlignmentPtr;
  public float pitch;
  public int right_eye_open;
  public float roll;
  public float rotate;
  public int smile = -1;
  public int width;
  public int x;
  public float[] xys;
  public int y;
  public float yaw;
  
  public String toString()
  {
    return "FaceStatus{ pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + ", illumination_score=" + this.illumination_score + ", nativeFaceAlignmentPtr=" + this.nativeFaceAlignmentPtr + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.YTFace.model.FaceStatus
 * JD-Core Version:    0.7.0.1
 */