package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ocr.ARCloudReqOcrInfo;

public class ARCloudReqInfo
{
  public int a;
  public long a;
  public ARCloudRecogReqFaceInfo a;
  public ARCloudRecogReqObjectClassifyInfo a;
  public ARCloudRecogReqPreOcrInfo a;
  public ARCloudRecogReqSceneRecogInfo a;
  public ARCloudReqFileInfo a;
  public ARCloudReqMarkerInfo a;
  public ARCloudReqTranslateInfo a;
  public ARCloudReqOcrInfo a;
  public String a;
  public int b;
  public long b;
  public ARCloudRecogReqObjectClassifyInfo b;
  public String b;
  public int c = -1;
  public long c;
  
  public ARCloudReqInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudReqInfo{sessionId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", fileInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo);
    localStringBuilder.append(", longitude = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", latitude = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", recogType = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", businessType = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", markerInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqMarkerInfo);
    localStringBuilder.append(", objectClassifyInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo);
    localStringBuilder.append(", preOcrInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqPreOcrInfo);
    localStringBuilder.append(", sceneRecogInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqSceneRecogInfo);
    localStringBuilder.append(", ocrInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo);
    localStringBuilder.append(", appid = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqInfo
 * JD-Core Version:    0.7.0.1
 */