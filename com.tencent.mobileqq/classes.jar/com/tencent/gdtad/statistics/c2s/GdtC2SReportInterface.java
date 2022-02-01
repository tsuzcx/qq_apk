package com.tencent.gdtad.statistics.c2s;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter.IGdtC2SReportInterface;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public final class GdtC2SReportInterface
  implements GdtC2SReporter.IGdtC2SReportInterface
{
  public int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public int b;
  private List<String> b;
  private List<String> c;
  
  public GdtC2SReportInterface()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  private int a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), this, paramString);
    int j = -1;
    int i = j;
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        i = j;
        ((StringBuilder)localObject).append("index: ");
        i = j;
        ((StringBuilder)localObject).append(paramInt);
        i = j;
        ((StringBuilder)localObject).append(" mOpeType ");
        i = j;
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        i = j;
        GdtLog.a("GdtC2SReporter", ((StringBuilder)localObject).toString());
        i = j;
        localObject = (HttpURLConnection)new URL(paramString).openConnection();
        i = j;
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        i = j;
        ((HttpURLConnection)localObject).setConnectTimeout(10000);
        i = j;
        ((HttpURLConnection)localObject).setReadTimeout(10000);
        i = j;
        ((HttpURLConnection)localObject).setUseCaches(false);
        i = j;
        ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
        i = j;
        ((HttpURLConnection)localObject).connect();
        i = j;
        j = ((HttpURLConnection)localObject).getResponseCode();
        i = j;
        localObject = new StringBuilder();
        i = j;
        ((StringBuilder)localObject).append("rspCode:  ");
        i = j;
        ((StringBuilder)localObject).append(j);
        i = j;
        ((StringBuilder)localObject).append(" index: ");
        i = j;
        ((StringBuilder)localObject).append(paramInt);
        i = j;
        ((StringBuilder)localObject).append(" mOpeType ");
        i = j;
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        i = j;
        ((StringBuilder)localObject).append(" reportUrl =");
        i = j;
        ((StringBuilder)localObject).append(paramString);
        i = j;
        GdtLog.a("GdtC2SReporter", ((StringBuilder)localObject).toString());
        i = j;
        int k = this.jdField_a_of_type_Int;
        if (j != 200) {
          break label400;
        }
        paramInt = 0;
        i = j;
        ReportController.a(null, "dc00898", "", "", "0X8009B97", "0X8009B97", k, paramInt, "", "", this.jdField_a_of_type_JavaLangString, paramString);
        i = j;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("c2sReport excetpion: ");
        localStringBuilder.append(localThrowable.getMessage());
        GdtLog.d("GdtC2SReporter", localStringBuilder.toString());
      }
      GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), this, paramString, i, System.currentTimeMillis() - l);
      return i;
      label400:
      paramInt = 1;
    }
  }
  
  private void a(List<String> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int j = -1;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      int k = i + 1;
      j = a(str, k);
      i = j;
      if (j < 0) {
        i = a(str, k);
      }
      j = i;
      GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), this, str, j);
      i = k;
    }
    ReportController.a(null, "dc00898", "", "", "0X8009EBF", "0X8009EBF", this.jdField_a_of_type_Int, j, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramAdInfo;
    if (paramAdInfo != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.get();
      this.jdField_b_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.get();
      this.c = paramAdInfo.report_info.thirdparty_monitor_urls.video_play_monitor_url.get();
      this.jdField_a_of_type_JavaLangString = Long.toString(paramAdInfo.report_info.trace_info.aid.get());
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        if (paramInt1 == 0)
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            this.jdField_a_of_type_Int = paramInt1;
          }
        }
        if (paramInt1 == 1)
        {
          localObject = this.jdField_b_of_type_JavaUtilList;
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            this.jdField_a_of_type_Int = paramInt1;
          }
        }
        if (paramInt1 == 2)
        {
          localObject = this.c;
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            this.jdField_a_of_type_Int = paramInt1;
          }
        }
        if (this.jdField_a_of_type_Int != -1) {
          break label216;
        }
      }
    }
    GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
    return;
    label216:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportAsync for ADID: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", operationType: ");
    ((StringBuilder)localObject).append(paramInt1);
    GdtLog.a("GdtC2SReporter", ((StringBuilder)localObject).toString());
    GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.executeOnNetWorkThread(new GdtC2SReportInterface.1(this));
    ReportController.a(null, "dc00898", "", "", "0X8009EBC", "0X8009EBC", this.jdField_a_of_type_Int, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface
 * JD-Core Version:    0.7.0.1
 */