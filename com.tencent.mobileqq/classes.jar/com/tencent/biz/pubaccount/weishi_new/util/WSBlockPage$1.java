package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

class WSBlockPage$1
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  WSBlockPage$1(WSBlockPage paramWSBlockPage, WSVerticalPageFragment paramWSVerticalPageFragment, String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    WeishiScehmeUtil.a(this.a.getBaseActivity(), "biz_src_jc_gzh_weishi", paramString, 1, WSGlobalConfig.a().d(), 0);
    WSBlockPage.a(this.f, this.b, this.c, this.d, 1000003, 1);
  }
  
  public void b(String paramString, int paramInt)
  {
    WSBlockPage.a(this.f, this.b, this.c, this.d, 1000004, 2);
    WeishiActivityHelper.a(this.a.getBaseActivity(), paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mEventId = 12;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = paramString;
    paramString = UserActionReportPresenter.a();
    paramString.pagetype = 5;
    paramString.optype = 115;
    paramString.upos = (this.e + 1);
    localWSDownloadParams.mStReportItem = paramString;
    WeishiDownloadUtil.a(this.a.getBaseActivity(), localWSDownloadParams, false);
    WSBlockPage.a(this.f, this.b, this.c, this.d, 1000002, 0);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSBlockPage.1
 * JD-Core Version:    0.7.0.1
 */