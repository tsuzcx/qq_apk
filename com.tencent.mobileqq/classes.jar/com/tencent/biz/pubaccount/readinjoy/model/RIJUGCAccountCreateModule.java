package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.ReqBody;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.RspBody;

public class RIJUGCAccountCreateModule
  extends ReadInJoyEngineModule
{
  private RIJUGCAccountCreateModule.UGCAccountCreateCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountCreateCallback;
  private RIJUGCAccountCreateModule.UGCAccountStatusCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountStatusCallback;
  
  public RIJUGCAccountCreateModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong, int paramInt)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    localReqBody.uint32_op_type.set(paramInt);
    return ReadInJoyOidbHelper.a("OidbSvc.0xe71", 3697, paramInt, localReqBody.toByteArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE");
    if (localInteger.intValue() == 1) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (localInteger.intValue() != 2) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreate result = " + i);
    }
    do
    {
      return;
      i = RIJPBFieldUtils.a(paramToServiceMsg.uint32_result, -1);
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreate pbResult = " + i);
    } while ((i < 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountCreateCallback == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountCreateCallback.a(paramToServiceMsg.uint32_result.get());
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountStatus result = " + i);
    }
    do
    {
      return;
      i = RIJPBFieldUtils.a(paramToServiceMsg.account_status);
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountStatus status = " + i);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountStatusCallback == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountStatusCallback.a(i);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountCreateCallback = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountStatusCallback = null;
  }
  
  public void a(long paramLong, RIJUGCAccountCreateModule.UGCAccountCreateCallback paramUGCAccountCreateCallback)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountCreate uin: " + paramLong);
    if (paramUGCAccountCreateCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountCreateCallback = paramUGCAccountCreateCallback;
    }
    paramUGCAccountCreateCallback = a(paramLong, 1);
    paramUGCAccountCreateCallback.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramUGCAccountCreateCallback.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(1));
    a(paramUGCAccountCreateCallback);
  }
  
  public void a(long paramLong, RIJUGCAccountCreateModule.UGCAccountStatusCallback paramUGCAccountStatusCallback)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountStatus uin: " + paramLong);
    if (paramUGCAccountStatusCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUGCAccountCreateModule$UGCAccountStatusCallback = paramUGCAccountStatusCallback;
    }
    paramUGCAccountStatusCallback = a(paramLong, 2);
    paramUGCAccountStatusCallback.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramUGCAccountStatusCallback.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(2));
    a(paramUGCAccountStatusCallback);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUGCAccountCreateModule
 * JD-Core Version:    0.7.0.1
 */