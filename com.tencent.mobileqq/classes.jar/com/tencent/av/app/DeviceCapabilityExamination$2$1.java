package com.tencent.av.app;

import com.tencent.av.utils.upload.FileUpload.UploadCallback;

class DeviceCapabilityExamination$2$1
  implements FileUpload.UploadCallback
{
  DeviceCapabilityExamination$2$1(DeviceCapabilityExamination.2 param2, DeviceCapabilityExamination.ReportData paramReportData, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.a;
    paramString1.s = paramInt;
    paramString1.t = paramString2;
    DeviceCapabilityExamination.a(paramString1, this.f.b, this.b);
    if (this.f.g != null) {
      this.f.g.a(this.b, this.c, this.d, this.e, String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.2.1
 * JD-Core Version:    0.7.0.1
 */