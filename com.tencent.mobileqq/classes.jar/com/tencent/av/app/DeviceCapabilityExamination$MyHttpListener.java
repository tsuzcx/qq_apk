package com.tencent.av.app;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DeviceCapabilityExamination$MyHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.mReq.getUserData();
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    label228:
    try
    {
      if (DeviceCapabilityExamination.b != null)
      {
        DeviceCapabilityExamination.b.a(str, bool);
        if (DeviceCapabilityExamination.b.a()) {
          DeviceCapabilityExamination.b = null;
        }
      }
      if (!bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DownloadTestResource fail, md5[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("], resp.mResult[");
        ((StringBuilder)localObject).append(paramNetResp.mResult);
        ((StringBuilder)localObject).append("]");
        QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    finally {}
    try
    {
      localObject = DeviceCapabilityExamination.b(str);
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      paramNetResp = new File(DeviceCapabilityExamination.a(str));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DownloadTestResource, suc, md5[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("], exists[");
      ((StringBuilder)localObject).append(paramNetResp.exists());
      ((StringBuilder)localObject).append("]");
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramNetResp)
    {
      break label228;
    }
    paramNetResp = new StringBuilder();
    paramNetResp.append("DownloadTestResource Exception, md5[");
    paramNetResp.append(str);
    paramNetResp.append("]");
    QLog.w("DeviceCapabilityExamination", 1, paramNetResp.toString());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.MyHttpListener
 * JD-Core Version:    0.7.0.1
 */