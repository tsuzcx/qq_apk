package com.tencent.biz.richframework.network.servlet;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.Cache.CacheInputStream;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import ykq;

class VSBaseServlet$1
  implements Runnable
{
  VSBaseServlet$1(VSBaseServlet paramVSBaseServlet, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.val$req.getRequestKey();
      localObject = CacheHelper.fileCache().getStream((String)localObject);
      if ((localObject == null) || (((Cache.CacheInputStream)localObject).getInputStream() == null))
      {
        ykq.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed,CmdName:" + this.val$req.getCmdName() + " Seq:" + this.val$req.getCurrentSeq());
        return;
      }
      localObject = this.val$req.decode(VSBaseServlet.access$000(this.this$0, ((Cache.CacheInputStream)localObject).getInputStream()));
      VSNetworkHelper.getDispatchObserver().sendCacheToTargetCallBack(this.val$req, (MessageMicro)localObject);
      ykq.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l) + ",CmdName:" + this.val$req.getCmdName() + " Seq:" + this.val$req.getCurrentSeq());
      return;
    }
    catch (Exception localException)
    {
      ykq.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */