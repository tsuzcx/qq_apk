package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import zwz;
import zxa;

public class VSDispatchObserver$2
  implements Runnable
{
  public VSDispatchObserver$2(zwz paramzwz, VSBaseRequest paramVSBaseRequest, zxa paramzxa, long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    zwz.a(this.this$0, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest, this.jdField_a_of_type_Zxa, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, false, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.b) + " | errorMsg: inform VSBaseRequest finalRsp is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.2
 * JD-Core Version:    0.7.0.1
 */