package com.tencent.av.app;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lbl;
import lbn;
import lbo;

final class DeviceCapabilityExamination$1
  implements Runnable
{
  DeviceCapabilityExamination$1(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject = lbl.a(this.jdField_a_of_type_Int);
    if (localObject == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.av.mediacodec.NativeCodec.printLog = true;
    lbn locallbn = DeviceCapabilityExamination.a((lbo)localObject);
    if (locallbn == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, 无样本, codec[" + ((lbo)localObject).b + "]");
      return;
    }
    localObject = DeviceCapabilityExamination.a(locallbn.jdField_a_of_type_JavaLangString);
    if (!new File((String)localObject).exists())
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error, filePath[" + (String)localObject, new Throwable("打印调用栈"));
      return;
    }
    localObject = DeviceCapabilityExamination.a(DeviceCapabilityExamination.a(), locallbn.jdField_a_of_type_JavaLangString, locallbn.jdField_a_of_type_Int, locallbn.b);
    locallbn.c = localObject[1].intValue();
    locallbn.d = localObject[4].intValue();
    DeviceCapabilityExamination.a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, locallbn, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.1
 * JD-Core Version:    0.7.0.1
 */