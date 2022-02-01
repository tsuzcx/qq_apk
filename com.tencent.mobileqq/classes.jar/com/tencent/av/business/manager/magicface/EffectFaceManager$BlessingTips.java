package com.tencent.av.business.manager.magicface;

public class EffectFaceManager$BlessingTips
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  
  public EffectFaceManager$BlessingTips()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 30;
    this.jdField_b_of_type_Int = 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], text[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], date[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("->");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("], imageUrl[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], callTimeLen[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], showTimeLen[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.EffectFaceManager.BlessingTips
 * JD-Core Version:    0.7.0.1
 */