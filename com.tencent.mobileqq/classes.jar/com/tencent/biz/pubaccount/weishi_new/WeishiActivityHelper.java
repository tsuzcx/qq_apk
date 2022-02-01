package com.tencent.biz.pubaccount.weishi_new;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeStrategyConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSBaseStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSBasePushBiz;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSPushBizFactory;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class WeishiActivityHelper
{
  private static WSRedDotPushMsg a()
  {
    Object localObject = WSConfigManager.a().a();
    if (localObject != null)
    {
      localObject = ((WeSeeConfigBean)localObject).a;
      if (localObject != null)
      {
        WSLog.b("WeishiActivityHelper", "transformTrendsTabConfigToPushMsg mStrategyConfig=" + ((WeSeeStrategyConfigInfo)localObject).a);
        if (!TextUtils.isEmpty(((WeSeeStrategyConfigInfo)localObject).a)) {
          return WSRedDotPushMsg.getInstance(((WeSeeStrategyConfigInfo)localObject).a);
        }
      }
    }
    return null;
  }
  
  private static WSRedDotPushMsg a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TrendsTab RedDot Msg : ");
    if (paramAppInfo != null) {}
    for (Object localObject = paramAppInfo.buffer.get();; localObject = "appInfo is null.")
    {
      WSLog.b("WeishiActivityHelper", (String)localObject);
      if ((paramAppInfo == null) || (TextUtils.isEmpty(paramAppInfo.buffer.get()))) {
        break label154;
      }
      try
      {
        localObject = new JSONObject(paramAppInfo.buffer.get());
        paramAppInfo = ((JSONObject)localObject).optString("_show_mission");
        localObject = ((JSONObject)localObject).optJSONObject("msg");
        if ((localObject == null) || (TextUtils.isEmpty(paramAppInfo))) {
          break label154;
        }
        paramAppInfo = ((JSONObject)localObject).optJSONObject(paramAppInfo);
        if (paramAppInfo == null) {
          break label154;
        }
        paramAppInfo = paramAppInfo.optString("extinfo");
        WSLog.b("WeishiActivityHelper", "TrendsTab RedDot extInfoStr : " + paramAppInfo);
        paramAppInfo = WSRedDotPushMsg.getInstance(paramAppInfo);
        return paramAppInfo;
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    label154:
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSVerticalPageFragment.a(paramActivity, "trends", "", null, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weishi");
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    paramInt = 1;
    WSLog.d("WeishiActivityHelper", "外部跳转微视公众号 from=" + paramString);
    if (paramContext == null)
    {
      WSLog.d("WSPushLog", "WeishiActivityHelper handleJumpTargetVideoFeed, context is null.");
      return;
    }
    a(paramString);
    if (TextUtils.equals(paramString, "from_home_page"))
    {
      WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.a();
      WSReportDc00898.a(localWSRedDotPushMsg);
      if (a(paramContext, localWSRedDotPushMsg, 2, null))
      {
        paramContext = WSPublicAccReport.getInstance();
        if (localWSRedDotPushMsg == null) {}
        for (;;)
        {
          paramContext.enterPublicAccReport(localWSRedDotPushMsg, paramInt, paramString);
          return;
          paramInt = localWSRedDotPushMsg.mStrategyInfo.getType();
        }
      }
    }
    if (!TextUtils.equals(paramString, "from_qq_chat")) {
      WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, paramString);
    }
    WSHomeFragment.a(paramContext, 1, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, WSMiniAppHelper.a(paramString), 4006, paramMiniAppLaunchListener);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    WeishiUtils.a(paramAppInfo, paramBoolean);
    WSInitializeHelper.a().b();
    WSLog.b("WeishiActivityHelper", "handleTrendsTabClick hasRedDot = " + paramBoolean);
    if (paramBoolean)
    {
      paramAppInfo = a(paramAppInfo);
      WSReportDc00898.b();
    }
    for (;;)
    {
      WSReportDc00898.a(paramAppInfo, paramBoolean);
      WSPublicAccReport.getInstance().enterTrendsTabReport(paramAppInfo, paramBoolean);
      if (!a(paramContext, paramAppInfo, 6, paramIntent)) {
        break;
      }
      return;
      paramAppInfo = a();
    }
    a((Activity)paramContext, paramIntent, paramAppInfo);
  }
  
  private static void a(String paramString)
  {
    if (TextUtils.equals(paramString, "from_qq_chat")) {
      return;
    }
    WSInitializeHelper.a().a();
  }
  
  private static boolean a(Context paramContext, WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    WSLog.a("WeishiActivityHelper", "handleRedDotClick scene=" + paramInt + ", pushMsgData=" + paramWSRedDotPushMsg);
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      WSBaseStrategyInfo localWSBaseStrategyInfo = (WSBaseStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      paramWSRedDotPushMsg = WSPushBizFactory.a(paramWSRedDotPushMsg, paramInt, paramIntent);
      if (paramWSRedDotPushMsg != null) {
        return paramWSRedDotPushMsg.a(paramContext, localWSBaseStrategyInfo);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper
 * JD-Core Version:    0.7.0.1
 */