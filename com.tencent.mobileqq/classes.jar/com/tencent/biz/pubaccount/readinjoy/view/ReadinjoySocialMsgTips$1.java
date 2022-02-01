package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMsgReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class ReadinjoySocialMsgTips$1
  implements View.OnClickListener
{
  ReadinjoySocialMsgTips$1(ReadinjoySocialMsgTips paramReadinjoySocialMsgTips) {}
  
  public void onClick(View paramView)
  {
    if (ReadinjoySocialMsgTips.a(this.a) != null) {
      ReadinjoySocialMsgTips.a(this.a).onClick(paramView);
    }
    Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).h().e().f().b().i().m();
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("message_reddot_style", RIJMsgBoxUtils.b());
    try
    {
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).c(Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0));
      label78:
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a();
      localObject = RIJMsgReport.a.a((String)localObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", (String)localObject, false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips.1
 * JD-Core Version:    0.7.0.1
 */