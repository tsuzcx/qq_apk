package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

class RecommendBannerEntryItemView$1
  implements View.OnClickListener
{
  RecommendBannerEntryItemView$1(RecommendBannerEntryItemView paramRecommendBannerEntryItemView) {}
  
  public void onClick(View paramView)
  {
    String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a.getContext(), str, 2016, null, null);
    QZoneHelper.prepareForQQPublicAccountPublishPage();
    VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_find", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView.1
 * JD-Core Version:    0.7.0.1
 */