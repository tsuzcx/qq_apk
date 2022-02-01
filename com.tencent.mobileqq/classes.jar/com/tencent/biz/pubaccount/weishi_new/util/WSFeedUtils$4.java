package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

final class WSFeedUtils$4
  implements OuterInterceptManager.OnInterceptDialogClickListener
{
  WSFeedUtils$4(Activity paramActivity, String paramString1, WSDownloadParams paramWSDownloadParams, String paramString2, int paramInt) {}
  
  public void a()
  {
    WeishiScehmeUtil.a(this.a, "biz_src_jc_gzh_weishi", this.b, this.c.mScene, this.c.mLinkStrategyType, this.c.mEventId);
  }
  
  public void a(Dialog paramDialog)
  {
    paramDialog = WSPublicAccReport.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_");
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    paramDialog.reportCallDialog("gzh_exposure", localStringBuilder.toString(), 0);
  }
  
  public void b()
  {
    WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_");
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    localWSPublicAccReport.reportCallDialog("gzh_click", localStringBuilder.toString(), 1000001);
    WeishiScehmeUtil.a(this.a, "biz_src_jc_gzh_weishi", this.b, this.c.mScene, this.c.mLinkStrategyType, this.c.mEventId);
  }
  
  public void c()
  {
    WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_");
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    localWSPublicAccReport.reportCallDialog("gzh_click", localStringBuilder.toString(), 1000005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils.4
 * JD-Core Version:    0.7.0.1
 */