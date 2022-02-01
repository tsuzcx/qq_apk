package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import java.util.concurrent.ConcurrentHashMap;

class VSDispatchObserver$7
  implements Runnable
{
  VSDispatchObserver$7(VSDispatchObserver paramVSDispatchObserver, BaseRequest paramBaseRequest, Object paramObject) {}
  
  public void run()
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)VSDispatchObserver.access$300(this.this$0).get(Integer.valueOf(this.val$request.getContextHashCode()));
      int i = this.val$request.getCurrentSeq();
      if (localConcurrentHashMap != null)
      {
        if (localConcurrentHashMap.get(Integer.valueOf(i)) == null)
        {
          RFLog.d("VSNetworkHelper| Protocol Cache", RFLog.USR, String.format("VSDispatchObserver: onReceive:CmdName:%s Seq:%d CallBack is Null or has Removed", new Object[] { this.val$request.getCmdName(), Integer.valueOf(this.val$request.getCurrentSeq()) }));
          return;
        }
        ((VSDispatchObserver.onVSRspCallBack)localConcurrentHashMap.get(Integer.valueOf(i))).onReceive(this.val$request, true, 0L, "_VSNetworkHelperCache", this.val$finalRsp);
        return;
      }
      RFLog.d("VSNetworkHelper| Protocol Cache", RFLog.USR, "VSDispatchObserver: onReceive: current context callbacks has all removed");
      return;
    }
    catch (Exception localException)
    {
      RFLog.w("VSNetworkHelper| Protocol Cache", RFLog.USR, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.7
 * JD-Core Version:    0.7.0.1
 */