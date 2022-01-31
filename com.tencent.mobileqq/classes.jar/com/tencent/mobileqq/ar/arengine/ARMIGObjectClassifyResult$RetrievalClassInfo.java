package com.tencent.mobileqq.ar.arengine;

public class ARMIGObjectClassifyResult$RetrievalClassInfo
{
  public double a;
  public int a;
  public String a;
  public ARMIGObjectClassifyResult.RetrievalItem[] a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i;
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem.length > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem.length)
    {
      localStringBuilder.append("\n index:").append(i).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[i].toString()).append('\n');
      i += 1;
      continue;
      localStringBuilder.append("\n only have one itemContent:" + this.jdField_a_of_type_JavaLangString + ",prob:" + this.jdField_a_of_type_Double).append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalClassInfo
 * JD-Core Version:    0.7.0.1
 */