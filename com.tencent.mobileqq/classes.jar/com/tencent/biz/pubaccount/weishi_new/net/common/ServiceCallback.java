package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

public abstract class ServiceCallback<T extends JceStruct, E>
{
  protected abstract E a(WSRequest<T> paramWSRequest, T paramT, RspHeaderBean paramRspHeaderBean);
  
  protected abstract void a(WSServiceErrorInfo paramWSServiceErrorInfo);
  
  protected void a(E paramE) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback
 * JD-Core Version:    0.7.0.1
 */