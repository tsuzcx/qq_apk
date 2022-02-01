package com.tencent.av.app;

import com.tencent.av.utils.upload.FileUpload.UploadCallback;

class DeviceCapabilityExamination$2$1
  implements FileUpload.UploadCallback
{
  DeviceCapabilityExamination$2$1(DeviceCapabilityExamination.2 param2, DeviceCapabilityExamination.ReportData paramReportData, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$ReportData;
    paramString1.j = paramInt;
    paramString1.i = paramString2;
    DeviceCapabilityExamination.a(paramString1, this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$2.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$2.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback != null) {
      this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$2.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.c, String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.2.1
 * JD-Core Version:    0.7.0.1
 */