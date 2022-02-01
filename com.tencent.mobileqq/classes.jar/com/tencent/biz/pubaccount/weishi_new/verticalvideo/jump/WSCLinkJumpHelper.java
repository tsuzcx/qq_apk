package com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/WSCLinkJumpHelper;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/IWSVerticalJumpHelper;", "()V", "getRecommendSubTabId", "", "handle", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "isNeedOpenVerticalForCLink", "isOpenCLinkPush", "wsPushMsgData", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSRedDotPushMsg;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSCLinkJumpHelper
  implements IWSVerticalJumpHelper
{
  public static final WSCLinkJumpHelper.Companion a = new WSCLinkJumpHelper.Companion(null);
  
  private final String a()
  {
    if (!WSComboExpHelper.a.a())
    {
      WSExpABTestManager localWSExpABTestManager = WSExpABTestManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localWSExpABTestManager, "WSExpABTestManager.getInstance()");
      if (localWSExpABTestManager.m()) {
        return "1000";
      }
    }
    return "";
  }
  
  private final boolean a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg != null)
    {
      paramWSRedDotPushMsg = paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg != null)
      {
        paramWSRedDotPushMsg = Integer.valueOf(paramWSRedDotPushMsg.getType());
        break label28;
      }
    }
    paramWSRedDotPushMsg = null;
    label28:
    if (paramWSRedDotPushMsg == null)
    {
      WSLog.d("WSCLinkJumpHelper", "[isOpenCLinkPush]  push is null and can open CLink");
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isOpenCLinkPush] pushType:");
    localStringBuilder.append(paramWSRedDotPushMsg);
    WSLog.d("WSCLinkJumpHelper", localStringBuilder.toString());
    return (paramWSRedDotPushMsg.intValue() != 2) && (paramWSRedDotPushMsg.intValue() != 4) && (paramWSRedDotPushMsg.intValue() != 5) && (paramWSRedDotPushMsg.intValue() != 6) && (paramWSRedDotPushMsg.intValue() != 7) && (paramWSRedDotPushMsg.intValue() != 8);
  }
  
  private final boolean b()
  {
    if ((WSComboExpHelper.a.a()) && (!WSComboExpHelper.a.e()))
    {
      WSLog.d("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is in no combo waterfall!");
      return false;
    }
    Object localObject = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSExpABTestManager.getInstance()");
    if (!((WSExpABTestManager)localObject).g())
    {
      WSLog.d("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is not CLink test!");
      return false;
    }
    localObject = WSPublicAccReport.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSPublicAccReport.getInstance()");
    if ((Intrinsics.areEqual(((WSPublicAccReport)localObject).getEnterPublicAccFrom(), "from_home_page") ^ true))
    {
      WSLog.d("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is not aio open!");
      return false;
    }
    return a(WeishiUtils.g());
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!b()) {
      return false;
    }
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams("aio_enter_c_link", "feeds").a(paramContext).a(a()).a(0).a(false).c(0).c(String.valueOf(System.currentTimeMillis())).e(2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSCLinkJumpHelper
 * JD-Core Version:    0.7.0.1
 */