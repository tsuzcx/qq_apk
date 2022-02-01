package com.tencent.mobileqq.ar.arengine;

public class ARCloudRecogRspFaceResult$StarInfo
{
  public float a;
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StarInfo{faceID=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pinyin_name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wiki='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wikiTitle='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wikiURL='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", confidence='");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult.StarInfo
 * JD-Core Version:    0.7.0.1
 */