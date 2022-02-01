package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class WSPushBizFactory
{
  public static WSBasePushBiz a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    WSVideoLayerBiz localWSVideoLayerBiz = null;
    if (paramWSRedDotPushMsg == null) {
      return null;
    }
    int i;
    if (paramWSRedDotPushMsg.mStrategyInfo != null) {
      i = paramWSRedDotPushMsg.mStrategyInfo.getType();
    } else {
      i = 0;
    }
    if (paramInt == 2)
    {
      if (i == 1) {
        return new WSRecommendBiz(paramWSRedDotPushMsg);
      }
      if (i == 5) {
        return new WSFollowBiz(paramWSRedDotPushMsg);
      }
      if ((i == 6) || (i == 7)) {
        return new WSDramaPreviewBiz(paramWSRedDotPushMsg);
      }
    }
    if (i == 2) {
      return new WSVideoLayerBiz(paramWSRedDotPushMsg, paramInt, paramIntent);
    }
    if (i == 3) {
      return new WSWeSeeClientBiz(paramWSRedDotPushMsg, paramInt, paramIntent);
    }
    if (i == 4) {
      return new WSH5BrowserBiz(paramWSRedDotPushMsg, paramInt);
    }
    if (paramInt == 2) {
      return new WSRecommendBiz(paramWSRedDotPushMsg);
    }
    if (paramInt == 6) {
      localWSVideoLayerBiz = new WSVideoLayerBiz(paramWSRedDotPushMsg, paramInt, paramIntent);
    }
    return localWSVideoLayerBiz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSPushBizFactory
 * JD-Core Version:    0.7.0.1
 */