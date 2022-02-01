package com.tencent.av.app;

import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.Sample;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class DeviceCapabilityExamination$1
  implements Runnable
{
  DeviceCapabilityExamination$1(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject2 = AVTestforEncDecConfig.b(this.a);
    if (localObject2 == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startEncoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.avcore.jni.codec.NativeCodec.printLog = true;
    Object localObject1 = DeviceCapabilityExamination.a((AVTestforEncDecConfig.TestInfo)localObject2);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startEncoderTest, 无样本, codec[");
      ((StringBuilder)localObject1).append(((AVTestforEncDecConfig.TestInfo)localObject2).b);
      ((StringBuilder)localObject1).append("]");
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = DeviceCapabilityExamination.a(((AVTestforEncDecConfig.Sample)localObject1).a);
    if (!new File((String)localObject2).exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startEncoderTest, error, filePath[");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject1).toString(), new Throwable("打印调用栈"));
      return;
    }
    localObject2 = DeviceCapabilityExamination.b(DeviceCapabilityExamination.c(), ((AVTestforEncDecConfig.Sample)localObject1).a, ((AVTestforEncDecConfig.Sample)localObject1).d, ((AVTestforEncDecConfig.Sample)localObject1).e);
    ((AVTestforEncDecConfig.Sample)localObject1).g = localObject2[1].intValue();
    ((AVTestforEncDecConfig.Sample)localObject1).h = localObject2[4].intValue();
    DeviceCapabilityExamination.a(AudioHelper.c(), this.b, this.a, (AVTestforEncDecConfig.Sample)localObject1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.1
 * JD-Core Version:    0.7.0.1
 */