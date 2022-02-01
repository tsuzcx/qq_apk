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
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem;
    int i;
    if ((localObject != null) && (localObject.length > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem.length)
    {
      localStringBuilder.append("\n index:");
      localStringBuilder.append(i);
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[i].toString());
      localStringBuilder.append('\n');
      i += 1;
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\n only have one itemContent:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",prob:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
      localStringBuilder.append(((StringBuilder)localObject).toString());
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalClassInfo
 * JD-Core Version:    0.7.0.1
 */