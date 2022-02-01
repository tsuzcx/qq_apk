package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;

class ComponentLastRead$1
  implements View.OnClickListener
{
  ComponentLastRead$1(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyReportUtils.a(false);
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.h().b().e().a(this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = ReadInJoyRefreshManager.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener != null) {
        this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener.a(this.a, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead.1
 * JD-Core Version:    0.7.0.1
 */