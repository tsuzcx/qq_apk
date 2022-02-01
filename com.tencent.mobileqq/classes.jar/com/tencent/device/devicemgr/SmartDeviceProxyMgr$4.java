package com.tencent.device.devicemgr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class SmartDeviceProxyMgr$4
  extends TransProcessorHandler
{
  SmartDeviceProxyMgr$4(SmartDeviceProxyMgr paramSmartDeviceProxyMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if (localObject != null)
    {
      if (((FileMsg)localObject).fileType != 24) {
        return;
      }
      if (((FileMsg)localObject).commandId != 7) {
        return;
      }
      Bundle localBundle;
      switch (paramMessage.what)
      {
      default: 
      case 1005: 
        paramMessage = new Intent();
        paramMessage.setAction("onFaceTransferError");
        localBundle = new Bundle();
        localBundle.putLong("uniseq", ((FileMsg)localObject).uniseq);
        paramMessage.putExtras(localBundle);
        BaseApplicationImpl.getApplication().sendBroadcast(paramMessage, "com.tencent.smartdevice.permission.broadcast");
        return;
      case 1003: 
        paramMessage = new Intent();
        paramMessage.setAction("onFaceTransferComplete");
        localBundle = new Bundle();
        localBundle.putLong("uniseq", ((FileMsg)localObject).uniseq);
        localBundle.putString("fileUrl", ((FileMsg)localObject).fileUrl);
        localObject = ((FileMsg)localObject).fileUrl;
        if (localObject != null)
        {
          localObject = ((String)localObject).split("/");
          localBundle.putString("uuId", localObject[(localObject.length - 2)]);
        }
        paramMessage.putExtras(localBundle);
        BaseApplicationImpl.getApplication().sendBroadcast(paramMessage, "com.tencent.smartdevice.permission.broadcast");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr.4
 * JD-Core Version:    0.7.0.1
 */