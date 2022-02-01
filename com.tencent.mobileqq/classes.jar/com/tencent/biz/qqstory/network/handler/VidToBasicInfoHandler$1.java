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
      localObject = this.this$0.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)VidToBasicInfoHandler.a().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          SLog.a("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          VidToBasicInfoHandler.a().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.a.size() > 0)
    {
      SLog.a("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.a);
      localObject = new GetVideoFullInfoListRequest();
      ((GetVideoFullInfoListRequest)localObject).a = this.this$0.a;
      CmdTaskManger.a().a((NetworkRequest)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */