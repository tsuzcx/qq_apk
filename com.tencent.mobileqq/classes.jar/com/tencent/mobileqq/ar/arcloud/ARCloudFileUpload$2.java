package com.tencent.mobileqq.ar.arcloud;

import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ARCloudFileUpload$2
  implements ITransactionCallback
{
  ARCloudFileUpload$2(ARCloudFileUpload paramARCloudFileUpload, ARCloudReqInfo paramARCloudReqInfo, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    synchronized (ARCloudFileUpload.b(this.c))
    {
      if (ARCloudFileUpload.c(this.c) != null)
      {
        int i = 0;
        while (i < ARCloudFileUpload.c(this.c).size())
        {
          if (((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).b.a.equals(this.a.a))
          {
            paramArrayOfByte = ((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).d;
            str = ((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).b.a;
            ARCloudFileUpload.c(this.c).remove(i);
            break label147;
          }
          i += 1;
        }
      }
      String str = "";
      paramArrayOfByte = null;
      label147:
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Upload failed. retCode = ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", IP = ");
      ((StringBuilder)???).append((String)paramHashMap.get("ip"));
      ((StringBuilder)???).append(", sessionId = ");
      ((StringBuilder)???).append(str);
      QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)???).toString());
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, str, null);
      }
      return;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    synchronized (ARCloudFileUpload.b(this.c))
    {
      Object localObject1 = ARCloudFileUpload.c(this.c);
      int j = 0;
      int i;
      if (localObject1 != null)
      {
        i = 0;
        while (i < ARCloudFileUpload.c(this.c).size())
        {
          if (((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).b.a.equals(this.a.a))
          {
            localObject1 = ((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).d;
            str = ((ARCloudFileUpload.TaskInfo)ARCloudFileUpload.c(this.c).get(i)).b.a;
            ARCloudFileUpload.c(this.c).remove(i);
            break label148;
          }
          i += 1;
        }
      }
      localObject1 = null;
      String str = "";
      label148:
      paramArrayOfByte = ARCloudFileUpload.a(this.c, paramArrayOfByte, this.a);
      if (paramArrayOfByte == null)
      {
        i = 9058;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("Upload successfully. retCode = ");
        ((StringBuilder)???).append(9058);
        ((StringBuilder)???).append(", IP = ");
        ((StringBuilder)???).append((String)paramHashMap.get("ip"));
        ((StringBuilder)???).append(", sessionId = ");
        ((StringBuilder)???).append(str);
        ((StringBuilder)???).append(". deserialize pb failed.");
        QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)???).toString());
      }
      else
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("Upload successfully. retCode = ");
        ((StringBuilder)???).append(0);
        ((StringBuilder)???).append(", IP = ");
        ((StringBuilder)???).append((String)paramHashMap.get("ip"));
        ((StringBuilder)???).append(", sessionId = ");
        ((StringBuilder)???).append(str);
        QLog.i("AREngine_ARCloudFileUpload", 1, ((StringBuilder)???).toString());
        i = j;
      }
      if (localObject1 != null) {
        ((ARCloudFileUpload.ARCloudFileUploadCallback)localObject1).a(i, str, paramArrayOfByte);
      }
      return;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Upload start. sessionId = ");
    localStringBuilder.append(this.a.a);
    QLog.i("AREngine_ARCloudFileUpload", 1, localStringBuilder.toString());
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateProgress. sessionId = ");
      localStringBuilder.append(this.a.a);
      localStringBuilder.append(". total size = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", transfered size = ");
      localStringBuilder.append(paramInt);
      QLog.d("AREngine_ARCloudFileUpload", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.2
 * JD-Core Version:    0.7.0.1
 */