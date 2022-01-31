package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import wxw;
import wxx;

public class VSDispatchObserver$7
  implements Runnable
{
  public VSDispatchObserver$7(wxw paramwxw, VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro) {}
  
  public void run()
  {
    int i;
    try
    {
      if (wxw.a(this.this$0) == null) {
        return;
      }
      i = this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName().hashCode();
      if ((wxw.a(this.this$0) != null) && (wxw.a(this.this$0).get(Integer.valueOf(i)) == null))
      {
        QLog.d("VSNetworkHelper| Protocol Cache", 1, "VSDispatchObserver: onReceive: cmdCallback has All Removed");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
      return;
    }
    if (((ConcurrentHashMap)wxw.a(this.this$0).get(Integer.valueOf(i))).get(Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq())) == null)
    {
      QLog.d("VSNetworkHelper| Protocol Cache", 1, "VSDispatchObserver: onReceive: CmdName:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + "Cache CallBack is Null or has Removed");
      return;
    }
    ((wxx)((ConcurrentHashMap)wxw.a(this.this$0).get(Integer.valueOf(i))).get(Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq()))).a(true, 0L, "_VSNetworkHelperCache", this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.7
 * JD-Core Version:    0.7.0.1
 */