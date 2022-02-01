package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class WSDramaPreviewBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  public WSDramaPreviewBiz(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    super(paramWSRedDotPushMsg);
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    paramContext = new WSHomeLaunchParams(paramContext, 1, "from_home_page").b(((WSRedDotPushMsg)this.a).mDramaId);
    if (paramWSPushStrategyInfo.mType == 7) {
      paramContext.c(paramWSPushStrategyInfo.mScheme);
    }
    WSHomeFragment.a(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSDramaPreviewBiz
 * JD-Core Version:    0.7.0.1
 */