package com.tencent.av.app;

import com.tencent.av.ManageConfig.AVTestforEncDecConfig.Sample;
import com.tencent.av.utils.upload.EncFileUpload;

final class DeviceCapabilityExamination$2
  implements DeviceCapability.CodecPlayerCallback
{
  DeviceCapabilityExamination$2(long paramLong1, int paramInt, DeviceCapability.CodecPlayerCallback.CodecTestInfo paramCodecTestInfo, AVTestforEncDecConfig.Sample paramSample, VideoAppInterface paramVideoAppInterface, long paramLong2, DeviceCapability.CodecPlayerCallback paramCodecPlayerCallback) {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    paramString2 = DeviceCapabilityExamination.a(this.jdField_a_of_type_Int, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback$CodecTestInfo.a, paramString1, paramInt2, l1 - l2);
    paramString2.f = this.jdField_a_of_type_ComTencentAvManageConfigAVTestforEncDecConfig$Sample.jdField_a_of_type_Int;
    paramString2.g = this.jdField_a_of_type_ComTencentAvManageConfigAVTestforEncDecConfig$Sample.b;
    paramString2.h = this.jdField_a_of_type_ComTencentAvManageConfigAVTestforEncDecConfig$Sample.c;
    paramString2.i = this.jdField_a_of_type_ComTencentAvManageConfigAVTestforEncDecConfig$Sample.d;
    if ((paramInt1 == 1) && (this.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback$CodecTestInfo.a()) && (this.jdField_a_of_type_ComTencentAvManageConfigAVTestforEncDecConfig$Sample.jdField_a_of_type_Boolean)) {
      new EncFileUpload(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b).a(this.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback$CodecTestInfo.d, new DeviceCapabilityExamination.2.1(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    for (;;)
    {
      com.tencent.avcore.jni.codec.NativeCodec.printLog = false;
      return;
      paramString2.j = -10000;
      DeviceCapabilityExamination.a(paramString2, this.jdField_a_of_type_Int, paramInt1);
      if (this.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback != null) {
        this.jdField_a_of_type_ComTencentAvAppDeviceCapability$CodecPlayerCallback.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.2
 * JD-Core Version:    0.7.0.1
 */