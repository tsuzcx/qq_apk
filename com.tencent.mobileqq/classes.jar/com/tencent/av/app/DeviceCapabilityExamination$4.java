package com.tencent.av.app;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.videoeffect.VideoEffectTest.TestResultCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DeviceCapabilityExamination$4
  implements VideoEffectTest.TestResultCallback
{
  DeviceCapabilityExamination$4(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (AudioHelper.e()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed onFinish result: " + paramInt + ", timeConsuming: " + paramLong + ", gpuVendor: " + paramString1 + ", gpuModel: " + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", Build.HARDWARE);
    localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("product", Build.PRODUCT);
    localHashMap.put("fingerprint", Build.FINGERPRINT);
    localHashMap.put("gpu_vendor", paramString1);
    localHashMap.put("gpu_model", paramString2);
    localHashMap.put("result", String.valueOf(paramInt));
    localHashMap.put("time_consuming", String.valueOf(paramLong));
    if (AudioHelper.e()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed reportByRoomId " + localHashMap);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.a.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.4
 * JD-Core Version:    0.7.0.1
 */