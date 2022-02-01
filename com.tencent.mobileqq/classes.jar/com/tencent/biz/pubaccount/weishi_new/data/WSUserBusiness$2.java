package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stFollowRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.open.base.ToastUtil;

class WSUserBusiness$2
  implements IWeishiServiceListener
{
  WSUserBusiness$2(WSUserBusiness paramWSUserBusiness, int paramInt, String paramString) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if (!(paramWeishiTask.a instanceof stFollowRsp))
    {
      if (this.jdField_a_of_type_Int == 2) {
        WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 1);
      }
      for (;;)
      {
        WSLog.b("WSUserBusiness", "[getServiceListenerWrapper] data error: " + paramWeishiTask.a);
        return;
        WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 2);
      }
    }
    int i = ((stFollowRsp)paramWeishiTask.a).isFollow;
    WSLog.b("WSUserBusiness", "[getServiceListenerWrapper] isFollow : " + i);
    if (this.jdField_a_of_type_Int == 1)
    {
      if (i == 1)
      {
        ToastUtil.a().a(2131720709);
        return;
      }
      ToastUtil.a().a(2131720707);
      WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 2);
      return;
    }
    if (i == 0)
    {
      ToastUtil.a().a(2131720711);
      return;
    }
    ToastUtil.a().a(2131720712);
    WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness.2
 * JD-Core Version:    0.7.0.1
 */