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
    return "ARCloudReqInfo{sessionId = " + this.jdField_a_of_type_JavaLangString + ", fileInfo = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo + ", longitude = " + this.jdField_a_of_type_Int + ", latitude = " + this.jdField_b_of_type_Int + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.c + ", markerInfo = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqMarkerInfo + ", objectClassifyInfo = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo + ", preOcrInfo = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqPreOcrInfo + ", sceneRecogInfo = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqSceneRecogInfo + ", ocrInfo = " + this.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo + ", appid = " + this.jdField_b_of_type_JavaLangString + ", uin = " + this.jdField_b_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqInfo
 * JD-Core Version:    0.7.0.1
 */