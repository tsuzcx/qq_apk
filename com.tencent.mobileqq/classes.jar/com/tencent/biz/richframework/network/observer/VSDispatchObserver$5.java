package com.tencent.biz.richframework.network.observer;

import aaau;
import aaav;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

public class VSDispatchObserver$5
  implements Runnable
{
  public VSDispatchObserver$5(aaau paramaaau, VSBaseRequest paramVSBaseRequest, aaav paramaaav, long paramLong) {}
  
  public void run()
  {
    aaau.a(this.this$0, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest, this.jdField_a_of_type_Aaav, -1L, "网络错误", false, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " | errorMsg:VSBaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */