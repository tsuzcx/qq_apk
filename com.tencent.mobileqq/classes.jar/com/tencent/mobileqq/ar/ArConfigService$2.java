package com.tencent.mobileqq.ar;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.qphone.base.util.QLog;

class ArConfigService$2
  implements FaceScanDownloadManager.DownloadCallback
{
  ArConfigService$2(ArConfigService paramArConfigService) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ArConfigService.b(this.a) != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = ArConfigService.b(this.a).beginBroadcast();
        i = 0;
        if (i < j) {
          try
          {
            ((IArFaceCallback)ArConfigService.b(this.a).getBroadcastItem(i)).a(paramInt1, paramInt2);
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException.printStackTrace();
          }
        }
        ArConfigService.b(this.a).finishBroadcast();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FaceScanDownloadManager notify onProgress error:");
          localStringBuilder.append(localException.getMessage());
          QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
        }
      }
      return;
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (ArConfigService.b(this.a) != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = ArConfigService.b(this.a).beginBroadcast();
        i = 0;
        if (i < j)
        {
          if (paramBoolean) {}
          try
          {
            ((IArFaceCallback)ArConfigService.b(this.a).getBroadcastItem(i)).a(paramInt);
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException.printStackTrace();
          }
          ((IArFaceCallback)ArConfigService.b(this.a).getBroadcastItem(i)).b(paramInt, 0);
          break label150;
        }
        ArConfigService.b(this.a).finishBroadcast();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FaceScanDownloadManager notify onFinish error:");
          localStringBuilder.append(localException.getMessage());
          QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
        }
      }
      return;
      label150:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.2
 * JD-Core Version:    0.7.0.1
 */