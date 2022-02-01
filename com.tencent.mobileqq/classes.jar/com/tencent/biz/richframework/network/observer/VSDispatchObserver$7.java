package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class VSDispatchObserver$7
  implements Runnable
{
  VSDispatchObserver$7(VSDispatchObserver paramVSDispatchObserver, VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro) {}
  
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
          QLog.d("VSNetworkHelper| Protocol Cache", 1, String.format("VSDispatchObserver: onReceive: CmdName:%s Seq:%d CallBack is Null or has Removed", new Object[] { this.val$request.getCmdName(), Integer.valueOf(this.val$request.getCurrentSeq()) }));
          return;
        }
        ((VSDispatchObserver.onVSRspCallBack)localConcurrentHashMap.get(Integer.valueOf(i))).onReceive(this.val$request, true, 0L, "_VSNetworkHelperCache", this.val$finalRsp);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
      return;
    }
    QLog.d("VSNetworkHelper| Protocol Cache", 1, "VSDispatchObserver: onReceive: current context callbacks has all removed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.7
 * JD-Core Version:    0.7.0.1
 */