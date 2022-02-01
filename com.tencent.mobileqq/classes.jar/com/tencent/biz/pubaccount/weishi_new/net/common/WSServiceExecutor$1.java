package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.jce.wup.UniAttribute;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

class WSServiceExecutor$1
  implements IWSProtocolListener<T, UniAttribute>
{
  WSServiceExecutor$1(WSServiceExecutor paramWSServiceExecutor, ServiceCallback paramServiceCallback) {}
  
  public void a(UniAttribute paramUniAttribute, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    WSServiceExecutor.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonWSServiceExecutor, paramInt, paramString, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonServiceCallback);
  }
  
  public void a(T paramT, int paramInt, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    WSServiceExecutor.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonWSServiceExecutor, paramT, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonServiceCallback, paramRspHeaderBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceExecutor.1
 * JD-Core Version:    0.7.0.1
 */