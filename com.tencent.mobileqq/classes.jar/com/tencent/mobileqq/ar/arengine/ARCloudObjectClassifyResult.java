package com.tencent.mobileqq.ar.arengine;

public class ARCloudObjectClassifyResult
  extends ARCloudRecogResultBase
  implements ARCloudObjectClassifyCommonInterface
{
  public int a;
  public String a;
  public ARCloudObjectClassifyResult.ImageTag[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e = 0;
  
  public ARCloudObjectClassifyResult()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public static boolean a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramARCloudObjectClassifyResult != null)
    {
      bool1 = bool2;
      if (paramARCloudObjectClassifyResult.jdField_a_of_type_Int == 0)
      {
        bool1 = bool2;
        if (paramARCloudObjectClassifyResult.jdField_b_of_type_Int == 0)
        {
          bool1 = bool2;
          if (paramARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag != null)
          {
            bool1 = bool2;
            if (paramARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_c_of_type_Int == 0)
            {
              bool1 = bool2;
              if (paramARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].a != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].a;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag != null)
    {
      String str1 = "ImageTags{";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag.length) {
          break;
        }
        str1 = str1 + ", imageTags[" + i + "] = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[i];
        i += 1;
      }
    }
    String str2 = "null";
    return "ARCloudObjectClassifyResult{retCode = " + this.jdField_a_of_type_Int + ", retMsg = " + this.jdField_a_of_type_JavaLangString + ", recogSvrRetCode = " + this.jdField_b_of_type_Int + ", recogSvrRetMsg = " + this.jdField_c_of_type_JavaLangString + ", sessionId = " + this.jdField_d_of_type_JavaLangString + ", imageTags = " + str2 + ", timeLen = " + this.jdField_c_of_type_Int + ", score = " + this.jdField_d_of_type_Int + ", kptNum = " + this.e + super.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */