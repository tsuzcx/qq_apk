package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import xgw;
import xgx;

public class VSDispatchObserver$3
  implements Runnable
{
  public VSDispatchObserver$3(xgw paramxgw, boolean paramBoolean, long paramLong1, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte, xgx paramxgx, String paramString, MessageMicro paramMessageMicro, long paramLong2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.isEnableCache())) {
      xgw.a(this.this$0, this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest, this.jdField_a_of_type_ArrayOfByte);
    }
    this.jdField_a_of_type_Xgx.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro);
    QLog.d("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCurrentSeq() + " | retCode:" + this.jdField_a_of_type_Long + " | retMessage:" + this.jdField_a_of_type_JavaLangString + " | final dispatch costTime:" + (System.currentTimeMillis() - this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */