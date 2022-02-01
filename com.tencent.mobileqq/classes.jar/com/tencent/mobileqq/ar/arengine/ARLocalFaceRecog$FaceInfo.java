package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;

public class ARLocalFaceRecog$FaceInfo
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public float f;
  public String g;
  public String h;
  public String i;
  public boolean j;
  public int k;
  public FaceStatus l;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceInfo{name='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tracked=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", lostCount=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", faceType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", faceStatus=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.FaceInfo
 * JD-Core Version:    0.7.0.1
 */