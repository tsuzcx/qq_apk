package com.tencent.av.app;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ksb;
import ksd;
import kse;

final class DeviceCapabilityExamination$1
  implements Runnable
{
  DeviceCapabilityExamination$1(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject = ksb.a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.av.mediacodec.NativeCodec.printLog = true;
    ksd localksd = DeviceCapabilityExamination.a((kse)localObject);
    if (localksd == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, 无样本, codec[" + ((kse)localObject).b + "]");
      return;
    }
    localObject = DeviceCapabilityExamination.a(localksd.jdField_a_of_type_JavaLangString);
    if (!new File((String)localObject).exists())
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error, filePath[" + (String)localObject, new Throwable("打印调用栈"));
      return;
    }
    localObject = DeviceCapabilityExamination.a(DeviceCapabilityExamination.a(), localksd.jdField_a_of_type_JavaLangString, localksd.jdField_a_of_type_Int, localksd.b);
    localksd.c = localObject[1].intValue();
    localksd.d = localObject[4].intValue();
    DeviceCapabilityExamination.a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, localksd, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.1
 * JD-Core Version:    0.7.0.1
 */