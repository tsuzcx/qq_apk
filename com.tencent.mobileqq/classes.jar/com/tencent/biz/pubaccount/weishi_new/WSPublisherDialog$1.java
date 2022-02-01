package com.tencent.biz.pubaccount.weishi_new;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;

class WSPublisherDialog$1
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  WSPublisherDialog$1(WSPublisherDialog paramWSPublisherDialog) {}
  
  public void a(String paramString, int paramInt)
  {
    WeishiScehmeUtil.a(WSPublisherDialog.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, WSGlobalConfig.a().a(), 0);
    WSPublisherDialog.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    WeishiActivityHelper.a(WSPublisherDialog.a(this.a), paramString);
    WSPublisherDialog.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = paramString;
    WeishiDownloadUtil.a((Activity)WSPublisherDialog.a(this.a), localWSDownloadParams, false);
    WSPublisherDialog.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    Context localContext = WSPublisherDialog.a(this.a);
    WSPublisherDialog localWSPublisherDialog = this.a;
    WeishiActivityHelper.a(localContext, paramString, new WSPublisherDialog.MiniAppListener(localWSPublisherDialog, localWSPublisherDialog));
    WSPublisherDialog.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog.1
 * JD-Core Version:    0.7.0.1
 */