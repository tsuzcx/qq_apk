package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Build.VERSION;
import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.qphone.base.util.QLog;
import ndn;
import org.json.JSONException;
import org.json.JSONObject;

class KandianMergeManager$5
  implements Runnable
{
  KandianMergeManager$5(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = DeviceCheck.c();; bool = false)
    {
      QLog.d("KandianMergeManager", 1, "isSupportHevc=" + bool);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("cpu_type", DeviceInfoUtils.getCpuType());
        localJSONObject.put("device_brand", DeviceInfoUtils.getDeviceBrand());
        localJSONObject.put("device_manu", DeviceInfoUtils.getDeviceManufacturer());
        localJSONObject.put("device_model", DeviceInfoUtils.getDeviceModel());
        localJSONObject.put("device_os_version", DeviceInfoUtils.getDeviceOSVersion());
        localJSONObject.put("os_version", DeviceInfoUtils.getOsVersion());
        if (bool)
        {
          i = 1;
          ndn.a(null, "", "0X800A4A1", "0X800A4A1", 0, i, "", "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("KandianMergeManager", 1, localJSONException.toString());
          continue;
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.5
 * JD-Core Version:    0.7.0.1
 */