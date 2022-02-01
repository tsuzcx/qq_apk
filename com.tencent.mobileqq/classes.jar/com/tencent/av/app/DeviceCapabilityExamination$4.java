package com.tencent.av.app;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.videoeffect.VideoEffectTest.TestResultCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DeviceCapabilityExamination$4
  implements VideoEffectTest.TestResultCallback
{
  DeviceCapabilityExamination$4(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("testVideoEffectIfNeed onFinish result: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", timeConsuming: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", gpuVendor: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", gpuModel: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("cpu", Build.HARDWARE);
    ((HashMap)localObject).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject).put("manufacturer", Build.MANUFACTURER);
    ((HashMap)localObject).put("model", Build.MODEL);
    ((HashMap)localObject).put("product", Build.PRODUCT);
    ((HashMap)localObject).put("fingerprint", Build.FINGERPRINT);
    ((HashMap)localObject).put("gpu_vendor", paramString1);
    ((HashMap)localObject).put("gpu_model", paramString2);
    ((HashMap)localObject).put("result", String.valueOf(paramInt));
    ((HashMap)localObject).put("time_consuming", String.valueOf(paramLong));
    if (AudioHelper.e())
    {
      paramString1 = new StringBuilder();
      paramString1.append("testVideoEffectIfNeed reportByRoomId ");
      paramString1.append(localObject);
      QLog.d("DeviceCapabilityExamination", 1, paramString1.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.a.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, (HashMap)localObject, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.4
 * JD-Core Version:    0.7.0.1
 */