package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import yvm;
import yvn;

public class VSDispatchObserver$4
  implements Runnable
{
  public VSDispatchObserver$4(yvm paramyvm, yvn paramyvn, VSBaseRequest paramVSBaseRequest, long paramLong, Exception paramException) {}
  
  public void run()
  {
    this.jdField_a_of_type_Yvn.a(false, -2L, "rsp Parse Error", null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq() + " | errorMsg: inform VSBaseRequest resultcode fail | final dispatch costTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " | exception:" + this.jdField_a_of_type_JavaLangException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */