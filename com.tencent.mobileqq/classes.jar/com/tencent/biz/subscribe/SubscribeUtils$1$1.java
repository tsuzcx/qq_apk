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
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramNetResp.mHttpCode);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      ZipUtils.unZipFile(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramNetResp)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.1.1
 * JD-Core Version:    0.7.0.1
 */