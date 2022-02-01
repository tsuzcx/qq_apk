package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;

class ARMarkerResourceManager$3
  implements ARResourceManagerTools.ARResourceCallback
{
  ARMarkerResourceManager$3(ARMarkerResourceManager paramARMarkerResourceManager, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo, ARCloudMarkerRecogResult paramARCloudMarkerRecogResult) {}
  
  public void a()
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.d();
    }
  }
  
  public void a(int paramInt)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.a(paramBoolean, paramInt, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_a_of_type_Int = (paramBoolean ^ true);
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.g = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_b_of_type_Int = (paramBoolean ^ true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback;
    if (localObject != null) {
      ((ARMarkerResourceManager.ARMarkerResourceCallback)localObject).a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_b_of_type_Long = System.currentTimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
    ((ARMarkerResourceManager)localObject).jdField_d_of_type_Int = (paramBoolean ^ true);
    ((ARMarkerResourceManager)localObject).e();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_Int != 1) {
        ARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
      }
      ARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.3
 * JD-Core Version:    0.7.0.1
 */