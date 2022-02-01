package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;

class ReadInJoyFooterPresenter$3
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$3(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = ReadInJoyRefreshManager.b(ReadInJoyFooterPresenter.a(this.a), 0);
    ReadinjoyReportUtils.a(false);
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.h().b().e().a(ReadInJoyFooterPresenter.a(this.a).e()).f().g().d();
    if ((ReadInJoyFooterPresenter.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localReportR5Builder.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", localReportR5Builder.a(), false);
      if (ReadInJoyFooterPresenter.a(this.a) != null) {
        ReadInJoyFooterPresenter.a(this.a).c();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter.3
 * JD-Core Version:    0.7.0.1
 */