package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import nol;
import org.json.JSONException;
import org.json.JSONObject;

class KandianMergeManager$6
  implements Runnable
{
  KandianMergeManager$6(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    QLog.d("KandianMergeManager", 1, "isSupportHevc=" + false);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cpu_type", DeviceInfoUtils.getCpuType());
      localJSONObject.put("device_brand", DeviceInfoUtils.getDeviceBrand());
      localJSONObject.put("device_manu", DeviceInfoUtils.getDeviceManufacturer());
      localJSONObject.put("device_model", DeviceInfoUtils.getDeviceModel());
      localJSONObject.put("device_os_version", DeviceInfoUtils.getDeviceOSVersion());
      localJSONObject.put("os_version", DeviceInfoUtils.getOsVersion());
      nol.a(null, "", "0X800A4A1", "0X800A4A1", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("KandianMergeManager", 1, localJSONException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.6
 * JD-Core Version:    0.7.0.1
 */