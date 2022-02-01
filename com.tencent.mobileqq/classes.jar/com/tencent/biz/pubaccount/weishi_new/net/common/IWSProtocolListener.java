package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

public abstract interface IWSProtocolListener<T, E>
{
  public abstract void a(T paramT, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean);
  
  public abstract void b(E paramE, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.IWSProtocolListener
 * JD-Core Version:    0.7.0.1
 */