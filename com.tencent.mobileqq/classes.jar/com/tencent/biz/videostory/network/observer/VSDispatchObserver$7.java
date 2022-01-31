package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import zab;
import zac;

public class VSDispatchObserver$7
  implements Runnable
{
  public VSDispatchObserver$7(zab paramzab, VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro) {}
  
  public void run()
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)zab.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getContextHashCode()));
      int i = this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq();
      if (localConcurrentHashMap != null)
      {
        if (localConcurrentHashMap.get(Integer.valueOf(i)) == null)
        {
          QLog.d("VSNetworkHelper| Protocol Cache", 1, String.format("VSDispatchObserver: onReceive: CmdName:%s Seq:%d CallBack is Null or has Removed", new Object[] { this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName(), Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq()) }));
          return;
        }
        ((zac)localConcurrentHashMap.get(Integer.valueOf(i))).a(true, 0L, "_VSNetworkHelperCache", this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.7
 * JD-Core Version:    0.7.0.1
 */