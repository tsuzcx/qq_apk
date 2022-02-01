package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;

public class WSWeSeeClientBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int b;
  private Intent c;
  
  public WSWeSeeClientBiz(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.b = paramInt;
    this.c = paramIntent;
  }
  
  private void a(String paramString)
  {
    if ((this.b == 2) && (TextUtils.equals(b(paramString), "2020020163")))
    {
      WSReportDc00898.c();
      WSPublicAccReport.getInstance().feedsItemForPushReport("gzh_click", 1000003);
    }
  }
  
  private String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("logsour");
    }
    return null;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool3 = WeishiGuideUtils.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSWeSeeClientBiz strategyInfo.scheme = ");
    localStringBuilder.append(paramWSPushStrategyInfo.mScheme);
    localStringBuilder.append(", isInstallWeishi = ");
    localStringBuilder.append(bool3);
    WSLog.d("WSPushLog", localStringBuilder.toString());
    boolean bool1;
    if (this.b == 2)
    {
      WSHomeFragment.a(new WSHomeLaunchParams(paramContext, 1, "from_home_page"));
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme))
    {
      bool2 = bool1;
      if (bool3)
      {
        WeishiBusinessLooper.a().a(new WSWeSeeClientBiz.1(this, paramContext, paramWSPushStrategyInfo), 200L);
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz
 * JD-Core Version:    0.7.0.1
 */