package com.tencent.biz.qqstory.network.handler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import slv;
import slz;
import syo;
import tan;
import urk;

public class VidToBasicInfoHandler$1
  implements Runnable
{
  public VidToBasicInfoHandler$1(syo paramsyo) {}
  
  public void run()
  {
    Object localObject;
    if (syo.a(this.this$0))
    {
      localObject = this.this$0.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)syo.a().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          urk.a("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          syo.a().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.a.size() > 0)
    {
      urk.a("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.a);
      localObject = new tan();
      ((tan)localObject).a = this.this$0.a;
      slv.a().a((slz)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */