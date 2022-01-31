package com.tencent.biz.qqstory.network.handler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import urp;
import urt;
import vei;
import vgh;
import wxe;

public class VidToBasicInfoHandler$1
  implements Runnable
{
  public VidToBasicInfoHandler$1(vei paramvei) {}
  
  public void run()
  {
    Object localObject;
    if (vei.a(this.this$0))
    {
      localObject = this.this$0.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)vei.a().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          wxe.a("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          vei.a().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.a.size() > 0)
    {
      wxe.a("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.a);
      localObject = new vgh();
      ((vgh)localObject).a = this.this$0.a;
      urp.a().a((urt)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */