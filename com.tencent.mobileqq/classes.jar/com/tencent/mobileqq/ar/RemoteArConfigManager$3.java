package com.tencent.mobileqq.ar;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback.Stub;
import com.tencent.qphone.base.util.QLog;

class RemoteArConfigManager$3
  extends IArFaceCallback.Stub
{
  RemoteArConfigManager$3(RemoteArConfigManager paramRemoteArConfigManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download success ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    if (RemoteArConfigManager.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadSuccess error mHandler is null ");
      return;
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 6;
    ((Message)localObject).arg1 = paramInt;
    RemoteArConfigManager.a(this.a).sendMessage((Message)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download process ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    if (RemoteArConfigManager.a(this.a) == null) {
      return;
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 7;
    ((Message)localObject).arg1 = paramInt1;
    ((Message)localObject).arg2 = paramInt2;
    RemoteArConfigManager.a(this.a).sendMessage((Message)localObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download error ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    if (RemoteArConfigManager.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadError error mHandler is null ");
      return;
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 8;
    ((Message)localObject).arg1 = paramInt1;
    ((Message)localObject).arg2 = paramInt2;
    RemoteArConfigManager.a(this.a).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager.3
 * JD-Core Version:    0.7.0.1
 */