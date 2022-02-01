package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import zwz;
import zxa;

public class VSDispatchObserver$5
  implements Runnable
{
  public VSDispatchObserver$5(zwz paramzwz, VSBaseRequest paramVSBaseRequest, zxa paramzxa, long paramLong) {}
  
  public void run()
  {
    zwz.a(this.this$0, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest, this.jdField_a_of_type_Zxa, -1L, "网络错误", false, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " | errorMsg:VSBaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */