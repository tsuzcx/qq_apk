package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class VidToBasicInfoHandler$1
  implements Runnable
{
  VidToBasicInfoHandler$1(VidToBasicInfoHandler paramVidToBasicInfoHandler) {}
  
  public void run()
  {
    Object localObject;
    if (VidToBasicInfoHandler.a(this.this$0))
    {
      localObject = this.this$0.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)VidToBasicInfoHandler.e().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          SLog.a("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          VidToBasicInfoHandler.e().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.c.size() > 0)
    {
      SLog.a("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.c);
      localObject = new GetVideoFullInfoListRequest();
      ((GetVideoFullInfoListRequest)localObject).e = this.this$0.c;
      CmdTaskManger.a().a((NetworkRequest)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */