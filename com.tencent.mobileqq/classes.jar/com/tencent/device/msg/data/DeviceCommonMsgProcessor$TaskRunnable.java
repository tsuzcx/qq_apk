package com.tencent.device.msg.data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONArray;
import org.json.JSONObject;

class DeviceCommonMsgProcessor$TaskRunnable
  implements Runnable
{
  public Session a;
  public boolean b;
  
  public DeviceCommonMsgProcessor$TaskRunnable(Session paramSession, boolean paramBoolean)
  {
    this.a = paramSession;
    this.b = paramBoolean;
  }
  
  public void a()
  {
    ThreadManager.post(this, 8, null, false);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    int i;
    if (localObject1 != null)
    {
      if (((Session)localObject1).actionInfo == null) {
        return;
      }
      localObject1 = null;
      try
      {
        JSONArray localJSONArray = new JSONObject(new String(this.a.actionInfo.vServiceInfo)).getJSONArray("datapoint");
        localObject1 = localJSONArray;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (localObject1 == null) {
        return;
      }
      int j = ((JSONArray)localObject1).length();
      if (j <= 0) {
        return;
      }
      i = 0;
      if (i >= j) {}
    }
    for (;;)
    {
      try
      {
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        DataPoint localDataPoint = new DataPoint(((JSONObject)localObject2).optString("apiName"), ((JSONObject)localObject2).optInt("id"), ((JSONObject)localObject2).optString("type"), ((JSONObject)localObject2).optString("value"));
        localDataPoint.mSeq = ((JSONObject)localObject2).optString("seq", "0");
        localDataPoint.mDin = ((JSONObject)localObject2).optLong("din");
        if (((DeviceMsgHandle.d.equalsIgnoreCase(this.a.actionInfo.strServiceName)) || (DeviceMsgHandle.e.equalsIgnoreCase(this.a.actionInfo.strServiceName)) || (DeviceMsgHandle.h.equalsIgnoreCase(this.a.actionInfo.strServiceName))) && (!TextUtils.isEmpty(localDataPoint.mValue)))
        {
          Object localObject3 = new DeviceCommonMsgProcessor.KeyValue();
          ((DeviceCommonMsgProcessor.KeyValue)localObject3).a = "path";
          ((DeviceCommonMsgProcessor.KeyValue)localObject3).b = localDataPoint.mValue;
          DeviceCommonMsgProcessor.KeyValue localKeyValue = new DeviceCommonMsgProcessor.KeyValue();
          localKeyValue.a = "ret";
          if (!this.b) {
            break label372;
          }
          localObject2 = "0";
          localKeyValue.b = ((String)localObject2);
          localDataPoint.mValue = DeviceCommonMsgProcessor.a((DeviceCommonMsgProcessor.KeyValue)localObject3, localKeyValue);
          localObject2 = new Intent();
          ((Intent)localObject2).setAction("SmartDevice_receiveDPMsg");
          localObject3 = new Bundle();
          ((Bundle)localObject3).putParcelable("dataPoint", localDataPoint);
          ((Intent)localObject2).putExtras((Bundle)localObject3);
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2, "com.tencent.smartdevice.permission.broadcast");
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      i += 1;
      break;
      return;
      label372:
      String str = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor.TaskRunnable
 * JD-Core Version:    0.7.0.1
 */