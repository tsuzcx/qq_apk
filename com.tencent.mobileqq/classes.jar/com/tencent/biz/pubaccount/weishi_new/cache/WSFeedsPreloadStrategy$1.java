package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSFeedsPreloadStrategy$1
  implements Runnable
{
  WSFeedsPreloadStrategy$1(WSFeedsPreloadStrategy paramWSFeedsPreloadStrategy, String paramString, int paramInt) {}
  
  public void run()
  {
    WSFeedsPreloadStrategy.a(this.this$0, this.a, this.b - 1);
    WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] postDelayed finish: 30s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSFeedsPreloadStrategy.1
 * JD-Core Version:    0.7.0.1
 */