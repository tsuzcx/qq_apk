package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;

public class ARMIGObjectClassifyResult$JDSearchResult
{
  public int a;
  public RectF a;
  public String a;
  ARMIGObjectClassifyResult.JDSearchItem[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public ARMIGObjectClassifyResult$JDSearchResult()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",ssoErrMsg:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",errCode:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",sessionId:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",moreUrl:");
    localStringBuilder.append(this.d);
    int i = 0;
    for (;;)
    {
      ARMIGObjectClassifyResult.JDSearchItem[] arrayOfJDSearchItem = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem;
      if ((arrayOfJDSearchItem == null) || (i >= arrayOfJDSearchItem.length)) {
        break;
      }
      localStringBuilder.append("\n{index=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i].toString());
      localStringBuilder.append("}\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.JDSearchResult
 * JD-Core Version:    0.7.0.1
 */