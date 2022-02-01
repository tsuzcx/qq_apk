package com.tencent.av.app;

import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.Sample;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class DeviceCapabilityExamination$3
  implements Runnable
{
  DeviceCapabilityExamination$3(int paramInt, VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    Object localObject1 = AVTestforEncDecConfig.b(this.a);
    if (localObject1 == null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDecoderTest, error", new Throwable("打印调用栈"));
      return;
    }
    com.tencent.avcore.jni.codec.NativeCodec.printLog = true;
    Object localObject2 = DeviceCapabilityExamination.a((AVTestforEncDecConfig.TestInfo)localObject1);
    if (localObject2 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startDecoderTest, 无样本, codec[");
      ((StringBuilder)localObject2).append(((AVTestforEncDecConfig.TestInfo)localObject1).b);
      ((StringBuilder)localObject2).append("]");
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = DeviceCapabilityExamination.a(((AVTestforEncDecConfig.Sample)localObject2).a);
    if (!new File((String)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startDecoderTest, error, filePath[");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject2).toString(), new Throwable("打印调用栈"));
      return;
    }
    DeviceCapabilityExamination.a(AudioHelper.c(), this.b, this.a, (AVTestforEncDecConfig.Sample)localObject2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.3
 * JD-Core Version:    0.7.0.1
 */