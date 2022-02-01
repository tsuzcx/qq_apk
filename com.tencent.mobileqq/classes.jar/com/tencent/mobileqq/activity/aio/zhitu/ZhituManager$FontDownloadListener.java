package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Handler;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class ZhituManager$FontDownloadListener
  implements INetEngineListener
{
  private Handler a;
  
  ZhituManager$FontDownloadListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FontDownloadListener onResp: ");
      localStringBuilder.append(paramNetResp);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    if (paramNetResp.mResult == 3) {
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(ZhituManager.a(paramNetResp.mReq.mOutPath)))
      {
        this.a.sendEmptyMessage(100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "font download but md5 is not matched");
      }
      this.a.sendEmptyMessage(101);
      return;
    }
    this.a.sendEmptyMessage(101);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.FontDownloadListener
 * JD-Core Version:    0.7.0.1
 */