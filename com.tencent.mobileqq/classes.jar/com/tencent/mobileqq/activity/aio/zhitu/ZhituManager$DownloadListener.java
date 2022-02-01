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
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = paramNetResp.mReq;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)paramNetResp.mReq.getUserData();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramNetResp.mTotalFileLen + " file.path = " + paramNetResp.mReq.mOutPath + " resp.result = " + paramNetResp.mResult + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      ZhituManager.a(paramNetResp.mReq.mOutPath);
      if (localZhituImgResponse != null)
      {
        paramNetResp = this.a.obtainMessage(3);
        paramNetResp.obj = localBundle;
        this.a.sendMessage(paramNetResp);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      paramNetResp = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      paramNetResp.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramNetResp.mErrCode);
      ((Message)localObject).obj = localBundle;
      paramNetResp = (NetResp)localObject;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.DownloadListener
 * JD-Core Version:    0.7.0.1
 */