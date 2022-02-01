package com.tencent.av.app;

import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.Sample;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class DeviceCapabilityExamination$1
  implements Runnable
{
  DeviceCapabilityExamination$1(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject = AVTestforEncDecConfig.a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.avcore.jni.codec.NativeCodec.printLog = true;
    AVTestforEncDecConfig.Sample localSample = DeviceCapabilityExamination.a((AVTestforEncDecConfig.TestInfo)localObject);
    if (localSample == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, 无样本, codec[" + ((AVTestforEncDecConfig.TestInfo)localObject).b + "]");
      return;
    }
    localObject = DeviceCapabilityExamination.a(localSample.jdField_a_of_type_JavaLangString);
    if (!new File((String)localObject).exists())
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error, filePath[" + (String)localObject, new Throwable("打印调用栈"));
      return;
    }
    localObject = DeviceCapabilityExamination.a(DeviceCapabilityExamination.a(), localSample.jdField_a_of_type_JavaLangString, localSample.jdField_a_of_type_Int, localSample.b);
    localSample.c = localObject[1].intValue();
    localSample.d = localObject[4].intValue();
    DeviceCapabilityExamination.a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, localSample, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.1
 * JD-Core Version:    0.7.0.1
 */