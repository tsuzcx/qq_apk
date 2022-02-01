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
      } else {
        WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getServiceListenerWrapper] data error: ");
      localStringBuilder.append(paramWeishiTask.a);
      WSLog.b("WSUserBusiness", localStringBuilder.toString());
      return;
    }
    int i = ((stFollowRsp)paramWeishiTask.a).isFollow;
    paramWeishiTask = new StringBuilder();
    paramWeishiTask.append("[getServiceListenerWrapper] isFollow : ");
    paramWeishiTask.append(i);
    WSLog.b("WSUserBusiness", paramWeishiTask.toString());
    if (this.jdField_a_of_type_Int == 1)
    {
      if (i == 1)
      {
        ToastUtil.a().a(2131720433);
        return;
      }
      ToastUtil.a().a(2131720431);
      WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 2);
      return;
    }
    if (i == 0)
    {
      ToastUtil.a().a(2131720435);
      return;
    }
    ToastUtil.a().a(2131720436);
    WSUserBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness.2
 * JD-Core Version:    0.7.0.1
 */