package com.tencent.mobileqq.ar;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ar.aidl.IArSoCallback.Stub;
import com.tencent.qphone.base.util.QLog;

class RemoteArConfigManager$4
  extends IArSoCallback.Stub
{
  RemoteArConfigManager$4(RemoteArConfigManager paramRemoteArConfigManager) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadSuccess");
    }
    Message localMessage = RemoteArConfigManager.a(this.a).obtainMessage();
    localMessage.what = 100;
    localMessage.sendToTarget();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onArSoDownloadProcess process=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = RemoteArConfigManager.a(this.a).obtainMessage();
    ((Message)localObject).what = 102;
    ((Message)localObject).arg1 = paramInt;
    ((Message)localObject).sendToTarget();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadFail");
    }
    Message localMessage = RemoteArConfigManager.a(this.a).obtainMessage();
    localMessage.what = 101;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager.4
 * JD-Core Version:    0.7.0.1
 */