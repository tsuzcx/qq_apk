package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import zab;
import zac;

public class VSDispatchObserver$5
  implements Runnable
{
  public VSDispatchObserver$5(zab paramzab, zac paramzac, VSBaseRequest paramVSBaseRequest, long paramLong) {}
  
  public void run()
  {
    this.jdField_a_of_type_Zac.a(false, -1L, "FromMsg Parse Error", null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " | errorMsg:VSBaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */