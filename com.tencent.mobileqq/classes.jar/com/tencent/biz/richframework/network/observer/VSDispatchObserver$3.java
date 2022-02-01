package com.tencent.biz.richframework.network.observer;

import aaau;
import aaav;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

public class VSDispatchObserver$3
  implements Runnable
{
  public VSDispatchObserver$3(aaau paramaaau, boolean paramBoolean, long paramLong1, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte, aaav paramaaav, String paramString, MessageMicro paramMessageMicro, long paramLong2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.isEnableCache())) {
      aaau.a(this.this$0, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest, this.jdField_a_of_type_ArrayOfByte);
    }
    aaau.a(this.this$0, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest, this.jdField_a_of_type_Aaav, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro);
    if (VSNetworkHelper.b(this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName())) {
      QLog.d("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | retCode:" + this.jdField_a_of_type_Long + " | retMessage:" + this.jdField_a_of_type_JavaLangString + " | busiBuff size:" + this.jdField_a_of_type_ArrayOfByte.length + " | final dispatch costTime:" + (System.currentTimeMillis() - this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */