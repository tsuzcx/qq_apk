package com.tencent.device.devicemgr;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;
import java.util.Arrays;

class SmartDeviceProxyMgr$1
  implements Handler.Callback
{
  SmartDeviceProxyMgr$1(SmartDeviceProxyMgr paramSmartDeviceProxyMgr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    boolean bool1 = false;
    int i = 0;
    switch (j)
    {
    default: 
      return true;
    }
    try
    {
      if (SmartDeviceProxyMgr.a(this.a) == null) {
        return true;
      }
      paramMessage = new Bundle();
      paramMessage.putString("notify_cmd", "getServerDeviceList");
      paramMessage = SmartDeviceProxyMgr.a(this.a).a(paramMessage);
      if (paramMessage != null)
      {
        paramMessage = paramMessage.getParcelableArray("devicelist");
        if (paramMessage != null)
        {
          Object localObject = new DeviceInfo[paramMessage.length];
          while (i < paramMessage.length)
          {
            localObject[i] = ((DeviceInfo)paramMessage[i]);
            i += 1;
          }
          SmartDeviceProxyMgr.a(this.a, (DeviceInfo[])localObject);
          this.a.notifyUI(1, true, new ArrayList(Arrays.asList((Object[])localObject)));
          return true;
          paramMessage = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          boolean bool2 = SmartDevicePluginLoader.a().a(paramMessage);
          boolean bool3 = NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
          boolean bool4 = DeviceInfoUtil.U();
          if (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F) {
            bool1 = true;
          }
          paramMessage = this.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SmartDeviceProxyMgr check plugin: isInstalled ");
          ((StringBuilder)localObject).append(bool2);
          ((StringBuilder)localObject).append(" isWifiConnected ");
          ((StringBuilder)localObject).append(bool3);
          ((StringBuilder)localObject).append(" lowPhone = ");
          ((StringBuilder)localObject).append(bool4);
          ((StringBuilder)localObject).append(" lowMemory = ");
          ((StringBuilder)localObject).append(bool1);
          SmartDeviceProxyMgr.a(paramMessage, ((StringBuilder)localObject).toString());
          if ((!bool2) && (bool3) && (!bool4) && (!bool1))
          {
            SmartDevicePluginLoader.a().b();
            return true;
            this.a.a();
          }
        }
      }
      return true;
    }
    catch (Exception paramMessage) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr.1
 * JD-Core Version:    0.7.0.1
 */