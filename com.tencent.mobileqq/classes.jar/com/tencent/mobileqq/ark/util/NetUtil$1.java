package com.tencent.mobileqq.ark.util;

import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class NetUtil$1
  implements INetEngineListener
{
  NetUtil$1(IHTTPDownloadCallback paramIHTTPDownloadCallback, HttpNetReq paramHttpNetReq) {}
  
  public void onResp(NetResp paramNetResp)
  {
    this.a.a(paramNetResp.mErrCode, NetUtil.a(paramNetResp, this.b));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.NetUtil.1
 * JD-Core Version:    0.7.0.1
 */