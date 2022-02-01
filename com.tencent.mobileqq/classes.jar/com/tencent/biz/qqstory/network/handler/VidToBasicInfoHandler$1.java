package com.tencent.biz.qqstory.network.handler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import vqn;
import vqr;
import wdf;
import wfe;
import xvv;

public class VidToBasicInfoHandler$1
  implements Runnable
{
  public VidToBasicInfoHandler$1(wdf paramwdf) {}
  
  public void run()
  {
    Object localObject;
    if (wdf.a(this.this$0))
    {
      localObject = this.this$0.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)wdf.a().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          xvv.a("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          wdf.a().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.a.size() > 0)
    {
      xvv.a("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.a);
      localObject = new wfe();
      ((wfe)localObject).a = this.this$0.a;
      vqn.a().a((vqr)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */