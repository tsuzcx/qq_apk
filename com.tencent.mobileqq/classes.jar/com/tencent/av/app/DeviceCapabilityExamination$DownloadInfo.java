package com.tencent.av.app;

import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DeviceCapabilityExamination$DownloadInfo
{
  HashMap<String, String> a = new HashMap();
  HashMap<String, Long> b = new HashMap();
  
  void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDownloadFinish, md5[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], suc[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], time[");
    localStringBuilder.append(this.b.get(paramString));
    localStringBuilder.append("]");
    QLog.w("DeviceCapabilityExamination", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901290));
    localStringBuilder.append(paramBoolean);
    AudioHelper.d(localStringBuilder.toString());
    this.a.remove(paramString);
    this.b.remove(paramString);
  }
  
  boolean a()
  {
    return this.a.isEmpty();
  }
  
  boolean a(String paramString1, String paramString2)
  {
    if (this.a.get(paramString1) != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("isDownloading, md5[");
      paramString2.append(paramString1);
      paramString2.append("], time[");
      paramString2.append(this.b.get(paramString1));
      paramString2.append("]");
      QLog.w("DeviceCapabilityExamination", 1, paramString2.toString());
      return true;
    }
    this.a.put(paramString1, paramString2);
    this.b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */