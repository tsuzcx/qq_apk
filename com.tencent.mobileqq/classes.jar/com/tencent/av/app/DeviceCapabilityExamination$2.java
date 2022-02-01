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
    long l2 = this.a;
    paramString2 = DeviceCapabilityExamination.a(this.b, paramInt1, paramInt3, this.c.b, paramString1, paramInt2, l1 - l2);
    paramString2.o = this.d.d;
    paramString2.p = this.d.e;
    paramString2.q = this.d.g;
    paramString2.r = this.d.h;
    if ((paramInt1 == 1) && (this.c.c()) && (this.d.f))
    {
      new EncFileUpload(this.e, this.f).a(this.c.g, new DeviceCapabilityExamination.2.1(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    else
    {
      paramString2.s = -10000;
      DeviceCapabilityExamination.a(paramString2, this.b, paramInt1);
      paramString2 = this.g;
      if (paramString2 != null) {
        paramString2.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
    com.tencent.avcore.jni.codec.NativeCodec.printLog = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.2
 * JD-Core Version:    0.7.0.1
 */