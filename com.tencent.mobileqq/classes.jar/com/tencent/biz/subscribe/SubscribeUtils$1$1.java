package com.tencent.biz.subscribe;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class SubscribeUtils$1$1
  implements INetEngineListener
{
  SubscribeUtils$1$1(SubscribeUtils.1 param1) {}
  
  public void onResp(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download  onResp url:  resultcode: ");
    localStringBuilder.append(paramNetResp.mHttpCode);
    QLog.i("DownLoadZipFile", 1, localStringBuilder.toString());
    try
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("start unzip file to folderPath:");
      paramNetResp.append(this.a.a);
      QLog.d("DownLoadZipFile", 4, paramNetResp.toString());
      ZipUtils.unZipFile(this.a.b, this.a.a);
      return;
    }
    catch (Exception paramNetResp)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unzip file failed");
      localStringBuilder.append(paramNetResp);
      QLog.i("DownLoadZipFile", 1, localStringBuilder.toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.1.1
 * JD-Core Version:    0.7.0.1
 */