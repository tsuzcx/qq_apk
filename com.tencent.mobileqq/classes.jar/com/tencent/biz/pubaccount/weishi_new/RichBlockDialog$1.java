package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URLDecoder;

class RichBlockDialog$1
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  RichBlockDialog$1(RichBlockDialog paramRichBlockDialog, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    WeishiScehmeUtil.a(RichBlockDialog.a(this.b), "biz_src_jc_gzh_weishi", paramString, 1, RichBlockDialog.b(this.b).link_strategy_type, RichBlockDialog.c(this.b));
    RichBlockDialog.a(this.b, 114, "popup_clk_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.b.a.windowsid, this.b.a.trace_id, RichBlockDialog.d(this.b), RichBlockDialog.e(this.b));
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.a instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(RichBlockDialog.a(this.b), paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("阻断rich弹窗:");
      localStringBuilder.append(paramString);
      WSLog.a("weishi-813", localStringBuilder.toString());
      WSReportDc00898.c(140, this.b.a.type, this.b.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.b.a.windowsid, this.b.a.trace_id, RichBlockDialog.d(this.b), RichBlockDialog.e(this.b));
      return;
    }
    WSLog.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = RichBlockDialog.e(this.b);
    localWSDownloadParams.mLinkStrategyType = RichBlockDialog.b(this.b).link_strategy_type;
    if (!RichBlockDialog.f(this.b)) {
      paramInt = 402;
    } else {
      paramInt = 401;
    }
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = paramString;
    WeishiDownloadUtil.a((Activity)RichBlockDialog.a(this.b), localWSDownloadParams, false);
    RichBlockDialog.a(this.b, 115, "popup_dl_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.b.a.windowsid, this.b.a.trace_id, RichBlockDialog.d(this.b), RichBlockDialog.e(this.b));
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog.1
 * JD-Core Version:    0.7.0.1
 */