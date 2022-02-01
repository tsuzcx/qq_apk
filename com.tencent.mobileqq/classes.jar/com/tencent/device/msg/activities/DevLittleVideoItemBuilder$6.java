package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class DevLittleVideoItemBuilder$6
  implements Runnable
{
  DevLittleVideoItemBuilder$6(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    for (;;)
    {
      synchronized (localDeviceMsgHandle.b)
      {
        Iterator localIterator = localDeviceMsgHandle.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localSmartDeviceProxyMgr.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localDeviceMsgHandle.b.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */