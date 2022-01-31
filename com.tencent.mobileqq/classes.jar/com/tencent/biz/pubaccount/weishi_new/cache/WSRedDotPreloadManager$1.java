package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import tcn;
import tlo;

public class WSRedDotPreloadManager$1
  implements Runnable
{
  public WSRedDotPreloadManager$1(tcn paramtcn, WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt) {}
  
  public void run()
  {
    tcn.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int - 1);
    tlo.b("WSRedDotPreloadManager", "checkSendRequest postDelayed finish: 30s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */