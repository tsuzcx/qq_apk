package com.tencent.av.app;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lep;
import ler;
import les;

final class DeviceCapabilityExamination$3
  implements Runnable
{
  DeviceCapabilityExamination$3(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject = lep.a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDecoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.av.mediacodec.NativeCodec.printLog = true;
    ler localler = DeviceCapabilityExamination.a((les)localObject);
    if (localler == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDecoderTest, 无样本, codec[" + ((les)localObject).b + "]");
      return;
    }
    localObject = DeviceCapabilityExamination.a(localler.a);
    if (!new File((String)localObject).exists())
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDecoderTest, error, filePath[" + (String)localObject, new Throwable("打印调用栈"));
      return;
    }
    DeviceCapabilityExamination.a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, localler, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.3
 * JD-Core Version:    0.7.0.1
 */