package com.tencent.mobileqq.ar.arengine;

public class ARCloudObjectClassifyResult
  extends ARCloudRecogResultBase
  implements ARCloudObjectClassifyCommonInterface
{
  public int a;
  public String a;
  public ARCloudObjectClassifyResult.ImageTag[] a;
  public int b = -1;
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
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public static boolean a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    if ((paramARCloudObjectClassifyResult != null) && (paramARCloudObjectClassifyResult.jdField_a_of_type_Int == 0) && (paramARCloudObjectClassifyResult.b == 0))
    {
      ARCloudObjectClassifyResult.ImageTag[] arrayOfImageTag = paramARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag;
      if ((arrayOfImageTag != null) && (arrayOfImageTag[0].jdField_c_of_type_Int == 0) && (paramARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].a != null)) {
        return true;
      }
    }
    return false;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].a;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag != null)
    {
      int i = 0;
      localObject1 = "ImageTags{";
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag.length) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", imageTags[");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("] = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[i]);
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    Object localObject2 = "null";
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ARCloudObjectClassifyResult{retCode = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append(", retMsg = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", recogSvrRetCode = ");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(", recogSvrRetMsg = ");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", sessionId = ");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", imageTags = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(", timeLen = ");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject1).append(", score = ");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject1).append(", kptNum = ");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append(super.toString());
    ((StringBuilder)localObject1).append('}');
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */