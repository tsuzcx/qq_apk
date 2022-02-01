package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$ViewHolder
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  HotWordItem jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem;
  TextView b;
  
  protected ComponentContentHotSearch$ViewHolder(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new ActivityURIRequest(this.b.getContext(), "/pubaccount/browser");
    ((ActivityURIRequest)localObject).extra().putString("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem.b);
    QRoute.startUri((URIRequest)localObject, null);
    localObject = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem.a, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).hotWordInfo.a.indexOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem) + 1);
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), (int)ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).mChannelID);
      localObject = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mOperation = 53;
      localReportInfo.mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
      localReportInfo.mHotWord = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem.a;
      ((List)localObject).add(localReportInfo);
      ReadInJoyLogicEngine.a().a((List)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(ComponentContentHotSearch.a, 1, "onClick, e = " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch.ViewHolder
 * JD-Core Version:    0.7.0.1
 */