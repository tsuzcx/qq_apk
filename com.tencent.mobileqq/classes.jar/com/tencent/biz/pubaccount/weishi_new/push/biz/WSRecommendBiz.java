package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.push.WSBasePushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;

public class WSRecommendBiz
  extends WSBasePushBiz<WSBasePushMsg, WSPushStrategyInfo>
{
  public WSRecommendBiz(WSBasePushMsg paramWSBasePushMsg)
  {
    super(paramWSBasePushMsg);
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    WSHomeFragment.a(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSRecommendBiz
 * JD-Core Version:    0.7.0.1
 */