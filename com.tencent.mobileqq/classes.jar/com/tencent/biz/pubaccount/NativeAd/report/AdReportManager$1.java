package com.tencent.biz.pubaccount.NativeAd.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.bean.CommonReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AdReportManager$1
  implements Runnable
{
  AdReportManager$1(AdReportManager paramAdReportManager, AdReportData paramAdReportData) {}
  
  private void a(ReportAction paramReportAction, String paramString, Map<String, IReportObj> paramMap)
  {
    try
    {
      CommonReportObj localCommonReportObj = (CommonReportObj)paramMap.get("common");
      if (localCommonReportObj == null) {
        return;
      }
      localCommonReportObj.a(ActionEntity.Default);
      paramMap = AdReportUtil.a(paramMap);
      AdReportManager.a(this.this$0, paramString, paramMap, paramReportAction);
      return;
    }
    catch (Throwable paramReportAction)
    {
      QLog.d("AdReportManager", 4, paramReportAction, new Object[0]);
    }
  }
  
  public void run()
  {
    String str;
    Map localMap;
    try
    {
      ReportAction localReportAction = AdReportUtil.a(this.a);
      str = AdReportUtil.a(this.a);
      if (TextUtils.isEmpty(str))
      {
        AdReportManager.a(this.this$0, "action:" + localReportAction.getValue() + ",report fail:", "reportUrl is empty");
        return;
      }
      localMap = AdReportUtil.a(this.a);
      if ((localMap == null) || (localMap.size() == 0))
      {
        AdReportManager.a(this.this$0, "action:" + localReportAction.getValue() + ",report fail:", "reportObjs is empty");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("AdReportManager", 4, localThrowable, new Object[0]);
      return;
    }
    ReportData localReportData = AdReportUtil.a(localMap);
    if (localReportData.a())
    {
      AdReportManager.a(this.this$0, "action:" + localThrowable.getValue() + ",report fail:", "reportData is empty");
      return;
    }
    if (AdReportManager.b(this.a))
    {
      AdReportManager.a(this.this$0, "action:" + localThrowable.getValue() + ",report fail:", "judgeAndRecordExpose");
      return;
    }
    AdReportManager.a(this.this$0, str, localReportData, localThrowable);
    if ((localThrowable == ReportAction.EXPOSE) && (this.a.a().intValue() == 2) && (AdReportUtil.a(this.a) == ActionEntity.OutSuperMask))
    {
      this.a.a(ActionEntity.Default);
      a(localThrowable, str, localMap);
      NativeAdUtils.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager.1
 * JD-Core Version:    0.7.0.1
 */