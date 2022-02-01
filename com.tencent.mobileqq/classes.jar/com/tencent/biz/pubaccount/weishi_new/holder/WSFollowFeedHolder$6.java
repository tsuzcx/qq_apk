package com.tencent.biz.pubaccount.weishi_new.holder;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;

class WSFollowFeedHolder$6
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  public void a(String paramString, int paramInt)
  {
    WeishiScehmeUtil.a(WSFollowFeedHolder.a(this.a), "biz_src_jc_gzh_weishi", paramString);
    WSFollowFeedHolder.a(this.a, "content", WSReportEvent.ActionId.c);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 700;
    localWSDownloadParams.mTestId = WeishiUtils.a(9);
    localWSDownloadParams.mScheme = paramString;
    WeishiDownloadUtil.a((Activity)WSFollowFeedHolder.b(this.a), localWSDownloadParams, false);
    WSFollowFeedHolder.a(this.a, "content", WSReportEvent.ActionId.b);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.6
 * JD-Core Version:    0.7.0.1
 */