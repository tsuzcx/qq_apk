package com.tencent.mobileqq.ar.arengine;

public class ARCloudMarkerRecogResult$ImageTag
{
  public float a;
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public int c = -1;
  
  public ARCloudMarkerRecogResult$ImageTag()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public String toString()
  {
    try
    {
      str = new String(this.jdField_a_of_type_ArrayOfByte, "utf-8");
    }
    catch (Exception localException)
    {
      String str;
      label17:
      StringBuilder localStringBuilder;
      break label17;
    }
    str = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageTag{imageId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", tagName = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", tagConfidence = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", tagConfidence_f = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", need_check_lbs = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", cdbRetCode = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", cdbRes = ");
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult.ImageTag
 * JD-Core Version:    0.7.0.1
 */