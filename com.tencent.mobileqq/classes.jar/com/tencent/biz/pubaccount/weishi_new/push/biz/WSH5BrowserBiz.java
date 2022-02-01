package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.WeishiManager;

public class WSH5BrowserBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int b;
  
  public WSH5BrowserBiz(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    super(paramWSRedDotPushMsg);
    this.b = paramInt;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    if (paramWSPushStrategyInfo == null) {
      return false;
    }
    boolean bool = TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme);
    if (!bool)
    {
      WeishiActivityHelper.a(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = WeishiUtils.d();
      if (paramContext != null) {
        paramContext.a(null);
      }
      WeishiUtils.k();
    }
    int j = this.b;
    int i = 2;
    if (j == 2)
    {
      if (!bool) {
        i = 1;
      }
      if (this.a == null) {
        paramContext = "";
      } else {
        paramContext = ((WSRedDotPushMsg)this.a).mFeedIds;
      }
      WSReportDc00898.a(i, 1, paramContext);
    }
    else if (j == 6)
    {
      if (!bool) {
        i = 1;
      }
      WSReportDc00898.c(i);
    }
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSH5BrowserBiz
 * JD-Core Version:    0.7.0.1
 */