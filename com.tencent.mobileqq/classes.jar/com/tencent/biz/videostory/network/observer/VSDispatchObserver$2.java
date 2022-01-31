package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import zab;
import zac;

public class VSDispatchObserver$2
  implements Runnable
{
  public VSDispatchObserver$2(zab paramzab, zac paramzac, long paramLong1, String paramString, VSBaseRequest paramVSBaseRequest, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Zac.a(false, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.b) + " | errorMsg: inform VSBaseRequest finalRsp is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.2
 * JD-Core Version:    0.7.0.1
 */