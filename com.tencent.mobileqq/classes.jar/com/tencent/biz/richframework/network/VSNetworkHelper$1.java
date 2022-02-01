package com.tencent.biz.richframework.network;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.Cache.CacheInputStream;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;

class VSNetworkHelper$1
  implements Runnable
{
  VSNetworkHelper$1(VSNetworkHelper paramVSNetworkHelper, BaseRequest paramBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.val$req.getRequestKey();
      localObject = CacheHelper.fileCache().getStream((String)localObject);
      if ((localObject != null) && (((Cache.CacheInputStream)localObject).getInputStream() != null))
      {
        localObject = this.val$req.decode(VSNetworkHelper.access$000(this.this$0, ((Cache.CacheInputStream)localObject).getInputStream()));
        VSNetworkHelper.getDispatchObserver().sendCacheToTargetCallBack(this.val$req, localObject);
        i = RFLog.USR;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send Cache Success costTime:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append(",CmdName:");
        ((StringBuilder)localObject).append(this.val$req.getCmdName());
        ((StringBuilder)localObject).append(" Seq:");
        ((StringBuilder)localObject).append(this.val$req.getCurrentSeq());
        RFLog.d("VSNetworkHelper| Protocol Cache", i, ((StringBuilder)localObject).toString());
        return;
      }
      int i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cache not found or bundle deserialized failed,CmdName:");
      ((StringBuilder)localObject).append(this.val$req.getCmdName());
      ((StringBuilder)localObject).append(" Seq:");
      ((StringBuilder)localObject).append(this.val$req.getCurrentSeq());
      RFLog.d("VSNetworkHelper| Protocol Cache", i, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      RFLog.w("VSNetworkHelper| Protocol Cache", RFLog.USR, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper.1
 * JD-Core Version:    0.7.0.1
 */