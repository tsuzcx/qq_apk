package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

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
    long l = System.currentTimeMillis();
    this.a.a(paramServiceCallback);
    WSLog.d("nel-log", "start cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService
 * JD-Core Version:    0.7.0.1
 */