package com.tencent.biz.pubaccount.NativeAd.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.bean.CommonReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager;
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
    try
    {
      ReportAction localReportAction = AdReportUtil.a(this.a);
      Object localObject1 = AdReportUtil.d(this.a);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool)
      {
        localObject1 = this.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("action:");
        ((StringBuilder)localObject2).append(localReportAction.getValue());
        ((StringBuilder)localObject2).append(",report fail:");
        AdReportManager.a((AdReportManager)localObject1, ((StringBuilder)localObject2).toString(), "reportUrl is empty");
        return;
      }
      Object localObject2 = AdReportUtil.c(this.a);
      if ((localObject2 != null) && (((Map)localObject2).size() != 0))
      {
        ReportData localReportData = AdReportUtil.a((Map)localObject2);
        if (localReportData.d())
        {
          localObject1 = this.this$0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("action:");
          ((StringBuilder)localObject2).append(localReportAction.getValue());
          ((StringBuilder)localObject2).append(",report fail:");
          AdReportManager.a((AdReportManager)localObject1, ((StringBuilder)localObject2).toString(), "reportData is empty");
          return;
        }
        if (AdReportManager.c(this.a))
        {
          localObject1 = this.this$0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("action:");
          ((StringBuilder)localObject2).append(localReportAction.getValue());
          ((StringBuilder)localObject2).append(",report fail:");
          AdReportManager.a((AdReportManager)localObject1, ((StringBuilder)localObject2).toString(), "judgeAndRecordExpose");
          return;
        }
        AdReportManager.a(this.this$0, (String)localObject1, localReportData, localReportAction);
        if ((localReportAction == ReportAction.EXPOSE) && (this.a.t().intValue() == 2) && (AdReportUtil.b(this.a) == ActionEntity.OutSuperMask))
        {
          this.a.a(ActionEntity.Default);
          a(localReportAction, (String)localObject1, (Map)localObject2);
          RIJAdReportManager.b(this.a);
        }
      }
      else
      {
        localObject1 = this.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("action:");
        ((StringBuilder)localObject2).append(localReportAction.getValue());
        ((StringBuilder)localObject2).append(",report fail:");
        AdReportManager.a((AdReportManager)localObject1, ((StringBuilder)localObject2).toString(), "reportObjs is empty");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("AdReportManager", 4, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager.1
 * JD-Core Version:    0.7.0.1
 */