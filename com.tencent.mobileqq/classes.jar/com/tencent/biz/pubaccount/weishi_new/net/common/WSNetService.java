package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.taf.jce.JceStruct;

public class WSNetService<T extends JceStruct>
  implements IBusinessService<T>
{
  private final WSServiceExecutor<T> a = new WSServiceExecutor();
  
  private WSNetService(WSRequest<T> paramWSRequest)
  {
    this.a.a(paramWSRequest);
  }
  
  public static <T extends JceStruct> WSNetService<T> a(WSRequest<T> paramWSRequest)
  {
    return new WSNetService(paramWSRequest);
  }
  
  public <E> void a(ServiceCallback<T, E> paramServiceCallback)
  {
    this.a.a(paramServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService
 * JD-Core Version:    0.7.0.1
 */