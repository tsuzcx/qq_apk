package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.jce.wup.UniAttribute;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

class WSServiceExecutor$1
  implements IWSProtocolListener<T, UniAttribute>
{
  WSServiceExecutor$1(WSServiceExecutor paramWSServiceExecutor, ServiceCallback paramServiceCallback) {}
  
  public void a(UniAttribute paramUniAttribute, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    WSServiceExecutor.a(this.b, paramInt, paramString, this.a);
  }
  
  public void a(T paramT, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    WSServiceExecutor.a(this.b, paramT, this.a, paramRspHeaderBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceExecutor.1
 * JD-Core Version:    0.7.0.1
 */