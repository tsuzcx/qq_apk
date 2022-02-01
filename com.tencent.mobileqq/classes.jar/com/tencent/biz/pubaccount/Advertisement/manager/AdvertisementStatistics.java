package com.tencent.biz.pubaccount.Advertisement.manager;

import android.os.SystemClock;
import com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AdvertisementStatistics
{
  private static AdvertisementStatistics jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics = new AdvertisementStatistics();
  private long jdField_a_of_type_Long = 0L;
  private AdvertisementStatistics.Report jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report = new AdvertisementStatistics.Report(null);
  public ImaxadThirdProcessorProxy a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private AdvertisementStatistics()
  {
    this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy = new ImaxadThirdProcessorProxy();
  }
  
  public static AdvertisementStatistics a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics == null) {
        jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics = new AdvertisementStatistics();
      }
      AdvertisementStatistics localAdvertisementStatistics = jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics;
      return localAdvertisementStatistics;
    }
    finally {}
  }
  
  public static void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoId", paramString2);
    localHashMap.put("uin", paramString1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "IMAX_Ad_VIDEO_PRELOADED_RATE", true, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportImaxVideoCoverRate:");
      paramString1.append(paramString2);
      QLog.i("AdvertisementStatistics", 2, paramString1.toString());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_c_of_type_Long == -1L) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.a();
    this.jdField_a_of_type_Long = paramLong;
    long l = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mClickTime:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" sToolShowTime:");
      ((StringBuilder)localObject).append(l);
      QLog.i("AdvertisementStatistics", 2, ((StringBuilder)localObject).toString());
    }
    if ((l != 0L) && (l <= paramLong))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report;
      ((AdvertisementStatistics.Report)localObject).jdField_a_of_type_Int = 1;
      ((AdvertisementStatistics.Report)localObject).jdField_b_of_type_Long = 0L;
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report;
      ((AdvertisementStatistics.Report)localObject).jdField_a_of_type_Int = 0;
      ((AdvertisementStatistics.Report)localObject).jdField_b_of_type_Long = (l - paramLong);
    }
    l = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report;
    ((AdvertisementStatistics.Report)localObject).jdField_a_of_type_Long = (l - paramLong);
    ((AdvertisementStatistics.Report)localObject).jdField_b_of_type_JavaLangString = paramString;
    ((AdvertisementStatistics.Report)localObject).jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_a_of_type_JavaLangString = "IMAX_Ad_videoLoadErr";
    HashMap localHashMap = new HashMap();
    localHashMap.put("adId", paramString1);
    localHashMap.put("vid", paramString2);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "IMAX_Ad_videoLoadErr", true, l1 - l2, 0L, localHashMap, "", false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    AdvertisementStatistics.Report localReport = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report;
    localReport.jdField_a_of_type_JavaLangString = "IMAX_Ad_Remind_Dialog_Click";
    localReport.jdField_b_of_type_JavaLangString = paramString1;
    localReport.jdField_c_of_type_JavaLangString = paramString2;
    paramString1 = localReport.a();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.toString());
      paramString2.append(" ok ");
      paramString2.append(paramBoolean);
      QLog.i("AdvertisementStatistics", 2, paramString2.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_a_of_type_JavaLangString, paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_c_of_type_Long, 0L, paramString1, "", false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.a();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_a_of_type_JavaLangString = "IMAX_Ad_StartCost_ByUsr";
    } else {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_a_of_type_JavaLangString = "IMAX_Ad_StartCost";
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.d, 0L, (HashMap)localObject, "", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remindUsr:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.toString());
      QLog.i("AdvertisementStatistics", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report.d == -1L)
    {
      AdvertisementStatistics.Report localReport = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementStatistics$Report;
      localReport.jdField_c_of_type_JavaLangString = paramString;
      localReport.d = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics
 * JD-Core Version:    0.7.0.1
 */