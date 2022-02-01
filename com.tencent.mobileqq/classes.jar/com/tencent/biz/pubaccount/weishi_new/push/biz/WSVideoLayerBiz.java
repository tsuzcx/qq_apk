package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;

public class WSVideoLayerBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int b;
  private Intent c;
  
  public WSVideoLayerBiz(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.b = paramInt;
    this.c = paramIntent;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = this.b;
    if (i == 2)
    {
      WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(paramContext, "aio_new_msg", "direct"));
      return true;
    }
    if (i == 6)
    {
      WeishiActivityHelper.a((Activity)paramContext, this.c, (WSRedDotPushMsg)this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSVideoLayerBiz
 * JD-Core Version:    0.7.0.1
 */