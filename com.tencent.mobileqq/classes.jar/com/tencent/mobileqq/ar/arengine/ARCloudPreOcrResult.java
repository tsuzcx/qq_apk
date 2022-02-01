package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

public class ARCloudPreOcrResult
  extends ARLocalRecogResultBase
{
  public float a;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public ARCloudPreOcrResult()
  {
    this.jdField_b_of_type_Long = 64L;
  }
  
  public static boolean a(ARCloudPreOcrResult paramARCloudPreOcrResult)
  {
    boolean bool;
    if ((paramARCloudPreOcrResult != null) && (paramARCloudPreOcrResult.a()) && (paramARCloudPreOcrResult.b())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramARCloudPreOcrResult = new StringBuilder();
      paramARCloudPreOcrResult.append("isRecogSuccess result = ");
      paramARCloudPreOcrResult.append(bool);
      QLog.d("ARCloudPreOcrResult", 2, paramARCloudPreOcrResult.toString());
    }
    return bool;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudPreOcrResult{recogType = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", recogSvrRetCode = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", recogSvrRetMsg = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", sessionId = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", arWordDetectRetCode = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", arWordDetectRetMsg = ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", wordType = ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", confidence = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult
 * JD-Core Version:    0.7.0.1
 */