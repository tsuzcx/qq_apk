package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class RIJChannelReporter
{
  public static void a(int paramInt, String paramString)
  {
    try
    {
      ReadInJoyChannelViewPagerController.a("0X8009B94", "", new RIJTransMergeKanDianReport.ReportR5Builder().a("source", paramString).a(paramInt).f().b("style", 0).a());
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("RIJChannelReporter", 2, "report click channel bar exception, e = ", paramString);
    }
  }
  
  public static void a(BaseReportData paramBaseReportData, int paramInt)
  {
    QLog.d("RIJChannelReporter", 1, new Object[] { "reportChannelExposure = ", paramBaseReportData });
    if (paramBaseReportData != null)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = paramBaseReportData.a;
      if (localTabChannelCoverInfo != null) {
        ThreadManager.executeOnSubThread(new RIJChannelReporter.1(localTabChannelCoverInfo, paramBaseReportData, paramInt));
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("RIJChannelReporter", 1, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter
 * JD-Core Version:    0.7.0.1
 */