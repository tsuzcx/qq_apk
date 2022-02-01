package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;

public class ARLocalFaceRecog$FaceInfo
{
  public float a;
  public int a;
  public FaceStatus a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceInfo{name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tracked=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", lostCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", faceType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", faceStatus=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentYTFaceModelFaceStatus);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.FaceInfo
 * JD-Core Version:    0.7.0.1
 */