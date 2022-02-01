package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class ZhituManager$DownloadListener
  implements INetEngineListener
{
  private Handler a;
  
  ZhituManager$DownloadListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject1 = this.a.obtainMessage(8);
    ((Message)localObject1).obj = paramNetResp.mReq;
    this.a.sendMessage((Message)localObject1);
    Bundle localBundle = (Bundle)paramNetResp.mReq.getUserData();
    localObject1 = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" zhitu img download onResp result fileSize = ");
      ((StringBuilder)localObject2).append(paramNetResp.mTotalFileLen);
      ((StringBuilder)localObject2).append(" file.path = ");
      ((StringBuilder)localObject2).append(paramNetResp.mReq.mOutPath);
      ((StringBuilder)localObject2).append(" resp.result = ");
      ((StringBuilder)localObject2).append(paramNetResp.mResult);
      ((StringBuilder)localObject2).append(" take time: ");
      ((StringBuilder)localObject2).append(Long.toString(System.currentTimeMillis() - l));
      QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject1, "onResp", i, ((StringBuilder)localObject2).toString()));
    }
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject1, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      localObject2 = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      ZhituManager.c(paramNetResp.mReq.mOutPath);
      if (localObject2 != null)
      {
        paramNetResp = this.a.obtainMessage(3);
        paramNetResp.obj = localBundle;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject1, "onResp", "download succ but md5 is mismatched"));
        }
        paramNetResp = this.a.obtainMessage(4);
        localBundle.putInt("ErrorCode", 99999);
        paramNetResp.obj = localBundle;
      }
    }
    else
    {
      localObject1 = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramNetResp.mErrCode);
      ((Message)localObject1).obj = localBundle;
      paramNetResp = (NetResp)localObject1;
    }
    this.a.sendMessage(paramNetResp);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.DownloadListener
 * JD-Core Version:    0.7.0.1
 */