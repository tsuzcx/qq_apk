package com.tencent.biz.pubaccount.weishi_new;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeStrategyConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.operationh5.WSCommonWebViewFragment;
import com.tencent.biz.pubaccount.weishi_new.operationh5.WSOperationWebViewFragment;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSBaseStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSBasePushBiz;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSPushBizFactory;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WeishiActivityHelper
{
  private static WSRedDotPushMsg a()
  {
    Object localObject = WSConfigManager.a().b();
    if (localObject != null)
    {
      localObject = ((WeSeeConfigBean)localObject).b;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("transformTrendsTabConfigToPushMsg mStrategyConfig=");
        localStringBuilder.append(((WeSeeStrategyConfigInfo)localObject).a);
        WSLog.b("WeishiActivityHelper", localStringBuilder.toString());
        if (!TextUtils.isEmpty(((WeSeeStrategyConfigInfo)localObject).a)) {
          return WSRedDotPushMsg.getInstance(((WeSeeStrategyConfigInfo)localObject).a);
        }
      }
    }
    return null;
  }
  
  private static WSRedDotPushMsg a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TrendsTab RedDot Msg : ");
    Object localObject;
    if (paramAppInfo != null) {
      localObject = paramAppInfo.buffer.get();
    } else {
      localObject = "appInfo is null.";
    }
    localStringBuilder.append((String)localObject);
    WSLog.b("WeishiActivityHelper", localStringBuilder.toString());
    if ((paramAppInfo != null) && (!TextUtils.isEmpty(paramAppInfo.buffer.get()))) {
      try
      {
        localObject = new JSONObject(paramAppInfo.buffer.get());
        paramAppInfo = ((JSONObject)localObject).optString("_show_mission");
        localObject = ((JSONObject)localObject).optJSONObject("msg");
        if ((localObject != null) && (!TextUtils.isEmpty(paramAppInfo)))
        {
          paramAppInfo = ((JSONObject)localObject).optJSONObject(paramAppInfo);
          if (paramAppInfo != null)
          {
            paramAppInfo = paramAppInfo.optString("extinfo");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("TrendsTab RedDot extInfoStr : ");
            ((StringBuilder)localObject).append(paramAppInfo);
            WSLog.b("WeishiActivityHelper", ((StringBuilder)localObject).toString());
            paramAppInfo = WSRedDotPushMsg.getInstance(paramAppInfo);
            return paramAppInfo;
          }
        }
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(paramActivity, "trends", ""));
  }
  
  public static void a(Context paramContext, WSPublicAccLaunchParams paramWSPublicAccLaunchParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("外部跳转微视公众号 from=");
    localStringBuilder.append(paramWSPublicAccLaunchParams.a());
    WSLog.d("WeishiActivityHelper", localStringBuilder.toString());
    WSInitializeHelper.a().h().a();
    if (!a(paramWSPublicAccLaunchParams.a())) {
      WSInitializeHelper.a().d();
    }
    b(paramContext, paramWSPublicAccLaunchParams);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
    localIntent.putExtra("fragmentClass", WSCommonWebViewFragment.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, WSMiniAppHelper.a(paramString), 4006, paramMiniAppLaunchListener);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    WSInitializeHelper.a().d();
    if ("1".equals(WSExpABTestManager.a().r()))
    {
      b(paramContext, new WSPublicAccLaunchParams(paramString, 0, true));
      return;
    }
    a(paramContext, paramBoolean, paramAppInfo, paramIntent);
  }
  
  private static void a(Context paramContext, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    WeishiUtils.a(paramAppInfo, paramBoolean);
    WSInitializeHelper.a().c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTrendsTabClick hasRedDot = ");
    localStringBuilder.append(paramBoolean);
    WSLog.b("WeishiActivityHelper", localStringBuilder.toString());
    if (paramBoolean)
    {
      paramAppInfo = a(paramAppInfo);
      WSReportDc00898.d();
    }
    else
    {
      paramAppInfo = a();
    }
    WSReportDc00898.a(paramAppInfo, paramBoolean);
    WSPublicAccReport.getInstance().enterTrendsTabReport(paramAppInfo, paramBoolean);
    if (a(paramContext, paramAppInfo, 6, paramIntent)) {
      return;
    }
    a((Activity)paramContext, paramIntent, paramAppInfo);
  }
  
  private static boolean a(Context paramContext, WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRedDotClick scene=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", pushMsgData=");
    ((StringBuilder)localObject).append(paramWSRedDotPushMsg);
    WSLog.a("WeishiActivityHelper", ((StringBuilder)localObject).toString());
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      localObject = (WSBaseStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      paramWSRedDotPushMsg = WSPushBizFactory.a(paramWSRedDotPushMsg, paramInt, paramIntent);
      if (paramWSRedDotPushMsg != null) {
        return paramWSRedDotPushMsg.a(paramContext, (WSBaseStrategyInfo)localObject);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, Map<String, String> paramMap)
  {
    WSInitializeHelper.a().b();
    WSInitializeHelper.a().d();
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
    localIntent.putExtra("fragmentClass", WSOperationWebViewFragment.class);
    localIntent.putExtra("url", (String)paramMap.get("h5url"));
    localIntent.putExtra("spid", (String)paramMap.get("spid"));
    localIntent.putExtra("web_test_id", (String)paramMap.get("web_test_id"));
    localIntent.putExtra("web_url", (String)paramMap.get("h5url"));
    localIntent.putExtra("share_scenes_from", (String)paramMap.get("share_scenes_from"));
    RouteUtils.a(paramContext, localIntent, "/base/browser");
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("from_qq_chat".equals(paramString)) || ("from_qq_scheme".equals(paramString)) || ("from_operation_h5".equals(paramString));
  }
  
  private static void b(Context paramContext, WSPublicAccLaunchParams paramWSPublicAccLaunchParams)
  {
    if (paramContext == null)
    {
      WSLog.d("WSPushLog", "WeishiActivityHelper handleJumpTargetVideoFeed, context is null.");
      return;
    }
    WSInitializeHelper.a().b();
    boolean bool = TextUtils.equals(paramWSPublicAccLaunchParams.a(), "from_home_page");
    int i = 1;
    Object localObject;
    if (bool)
    {
      localObject = WeishiUtils.g();
      WSReportDc00898.b((WSRedDotPushMsg)localObject);
      if (a(paramContext, (WSRedDotPushMsg)localObject, 2, null))
      {
        paramContext = WSPublicAccReport.getInstance();
        if (localObject != null) {
          i = ((WSRedDotPushMsg)localObject).mStrategyInfo.getType();
        }
        paramContext.enterPublicAccReport((WSRedDotPushMsg)localObject, i, paramWSPublicAccLaunchParams.a(), null);
        return;
      }
    }
    if (!a(paramWSPublicAccLaunchParams.a()))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("web_url", paramWSPublicAccLaunchParams.d());
      WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, paramWSPublicAccLaunchParams.a(), (Bundle)localObject);
    }
    WSHomeFragment.a(new WSHomeLaunchParams(paramContext, 1, paramWSPublicAccLaunchParams.a()).a(paramWSPublicAccLaunchParams.b()).b(paramWSPublicAccLaunchParams.e()).a(paramWSPublicAccLaunchParams.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper
 * JD-Core Version:    0.7.0.1
 */