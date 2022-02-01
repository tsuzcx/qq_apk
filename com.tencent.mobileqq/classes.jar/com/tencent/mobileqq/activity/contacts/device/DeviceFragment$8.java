package com.tencent.mobileqq.activity.contacts.device;

import android.os.Message;
import aqwh;
import bkyc;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceFragment$8
  implements Runnable
{
  DeviceFragment$8(DeviceFragment paramDeviceFragment, aqwh paramaqwh) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.a.a).optInt("smart_device_discovery_config_switch", 1);
      DeviceFragment.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1));
      DeviceFragment.a(this.this$0).obtainMessage(1, i, 0).sendToTarget();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException) {}finally
    {
      DeviceFragment.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1));
      DeviceFragment.a(this.this$0).obtainMessage(1, 1, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.8
 * JD-Core Version:    0.7.0.1
 */