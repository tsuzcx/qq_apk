package com.tencent.biz.richframework.network.observer;

import aaau;
import aaav;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class VSDispatchObserver$7
  implements Runnable
{
  public VSDispatchObserver$7(aaau paramaaau, VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro) {}
  
  public void run()
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)aaau.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getContextHashCode()));
      int i = this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq();
      if (localConcurrentHashMap != null)
      {
        if (localConcurrentHashMap.get(Integer.valueOf(i)) == null)
        {
          QLog.d("VSNetworkHelper| Protocol Cache", 1, String.format("VSDispatchObserver: onReceive: CmdName:%s Seq:%d CallBack is Null or has Removed", new Object[] { this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName(), Integer.valueOf(this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq()) }));
          return;
        }
        ((aaav)localConcurrentHashMap.get(Integer.valueOf(i))).onReceive(true, 0L, "_VSNetworkHelperCache", this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro);
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