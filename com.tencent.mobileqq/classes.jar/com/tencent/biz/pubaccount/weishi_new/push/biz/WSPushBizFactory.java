package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class WSPushBizFactory
{
  public static WSBasePushBiz a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    if (paramWSRedDotPushMsg == null) {}
    do
    {
      return null;
      int i;
      if (paramWSRedDotPushMsg.mStrategyInfo != null) {
        i = paramWSRedDotPushMsg.mStrategyInfo.getType();
      }
      while (paramInt == 2) {
        if (i == 1)
        {
          return new WSRecommendBiz(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new WSFollowBiz(paramWSRedDotPushMsg);
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
    } while (paramInt != 6);
    return new WSVideoLayerBiz(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSPushBizFactory
 * JD-Core Version:    0.7.0.1
 */