package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;

class WSWeSeeClientBiz$1
  implements Runnable
{
  WSWeSeeClientBiz$1(WSWeSeeClientBiz paramWSWeSeeClientBiz, Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo) {}
  
  public void run()
  {
    WeishiScehmeUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), "biz_src_jc_gzh_weishi", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSPushStrategyInfo.mScheme);
    WSWeSeeClientBiz.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSPushStrategyInfo.mScheme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz.1
 * JD-Core Version:    0.7.0.1
 */