package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;

class ARCloudControl$4
  implements ARCloudPretreatmentManager.ARCloudPretreatmentCallback
{
  ARCloudControl$4(ARCloudControl paramARCloudControl, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, ARCloudReqFileInfo paramARCloudReqFileInfo, long paramLong)
  {
    if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl)) {
      return;
    }
    if (paramInt == ARCloudPretreatmentManager.jdField_a_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
      ((ARCloudControl)localObject).h = paramLong;
      ((ARCloudControl)localObject).i += this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.h;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo;
      ((ARCloudReqInfo)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo = paramARCloudReqFileInfo;
      ((ARCloudReqInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.d;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.e;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.f;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_b_of_type_JavaLangString = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentCommonAppAppInterface.getAppid());
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_c_of_type_Long = System.currentTimeMillis();
      ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo);
      if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) != null) {
        ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).c();
      }
    }
  }
  
  public void a(ARCloudRecogReqFaceInfo paramARCloudRecogReqFaceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqFaceInfo = paramARCloudRecogReqFaceInfo;
  }
  
  public void a(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo = paramARCloudRecogReqObjectClassifyInfo;
  }
  
  public void a(ARCloudRecogReqPreOcrInfo paramARCloudRecogReqPreOcrInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqPreOcrInfo = paramARCloudRecogReqPreOcrInfo;
  }
  
  public void a(ARCloudRecogReqSceneRecogInfo paramARCloudRecogReqSceneRecogInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogReqSceneRecogInfo = paramARCloudRecogReqSceneRecogInfo;
  }
  
  public void a(ARCloudReqMarkerInfo paramARCloudReqMarkerInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqMarkerInfo = paramARCloudReqMarkerInfo;
  }
  
  public void b(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.jdField_b_of_type_ComTencentMobileqqArArengineARCloudRecogReqObjectClassifyInfo = paramARCloudRecogReqObjectClassifyInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.4
 * JD-Core Version:    0.7.0.1
 */