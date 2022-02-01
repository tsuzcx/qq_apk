package com.tencent.mobileqq.activity.contacts.device;

import android.os.Message;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.util.MqqWeakReferenceHandler;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceFragment$8
  implements Runnable
{
  DeviceFragment$8(DeviceFragment paramDeviceFragment, CfgProcess.CfgParseResult paramCfgParseResult) {}
  
  public void run()
  {
    try
    {
      try
      {
        int i = new JSONObject(this.a.a).optInt("smart_device_discovery_config_switch", 1);
        DeviceFragment.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1));
        Message localMessage1 = DeviceFragment.a(this.this$0).obtainMessage(1, i, 0);
      }
      finally
      {
        break label97;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Message localMessage2;
        localJSONException.printStackTrace();
      }
      DeviceFragment.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1));
      DeviceFragment.a(this.this$0).obtainMessage(1, 1, 0).sendToTarget();
      for (;;)
      {
        throw localJSONException;
      }
    }
    catch (Exception localException)
    {
      label56:
      label97:
      break label56;
    }
    DeviceFragment.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1));
    localMessage2 = DeviceFragment.a(this.this$0).obtainMessage(1, 1, 0);
    localMessage2.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.8
 * JD-Core Version:    0.7.0.1
 */