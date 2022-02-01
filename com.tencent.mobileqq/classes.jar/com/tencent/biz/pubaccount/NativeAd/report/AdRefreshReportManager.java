package com.tencent.biz.pubaccount.NativeAd.report;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.impl.RIJCommonServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdRefreshReportManager
{
  private static volatile AdRefreshReportManager a;
  private int b = 0;
  private int c = 0;
  private final String d = "sp_key_rij_ad_flush_num_day";
  private final String e = "sp_key_rij_ad_flush_num_day_update_date";
  private final int f = 4;
  
  public static AdRefreshReportManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AdRefreshReportManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean c(long paramLong)
  {
    String str1 = (String)new RIJCommonServiceImpl().getReadInJoySpValue("sp_key_rij_ad_flush_num_day_update_date", "");
    String str2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong - 14400000L));
    QLog.d("AdRefreshReportManager", 1, "[updateContentFlushNumDay], lastUpdateDate = $lastUpdateDate, updateDate = $updateDate");
    return TextUtils.equals(str1, str2) ^ true;
  }
  
  private void d(long paramLong)
  {
    RIJCommonServiceImpl localRIJCommonServiceImpl = new RIJCommonServiceImpl();
    boolean bool = c(paramLong);
    Integer localInteger = Integer.valueOf(0);
    if (bool)
    {
      this.c = 0;
      localRIJCommonServiceImpl.updateReadInJoySpValue("sp_key_rij_ad_flush_num_day", localInteger);
    }
    this.c += 1;
    localRIJCommonServiceImpl.updateReadInJoySpValue("sp_key_rij_ad_flush_num_day", Integer.valueOf(((Integer)localRIJCommonServiceImpl.getReadInJoySpValue("sp_key_rij_ad_flush_num_day", localInteger)).intValue() + 1));
    e(paramLong);
    QLog.i("AdRefreshReportManager", 1, "[updateAdFlushNum] timeStamp = ${System.currentTimeMillis()}, adFlushNumProcess = $adFlushNumProcess, , adFlushNumDay = ${RIJSPUtils.getReadInJoySpValue(SP_KEY_CONTENT_FLUSH_NUM_DAY, 0)}");
  }
  
  private void e(long paramLong)
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong - 14400000L));
    new RIJCommonServiceImpl().updateReadInJoySpValue("sp_key_rij_ad_flush_num_day_update_date", str);
  }
  
  public int a(long paramLong)
  {
    if (c(paramLong)) {
      return 0;
    }
    return ((Integer)new RIJCommonServiceImpl().getReadInJoySpValue("sp_key_rij_ad_flush_num_day", Integer.valueOf(0))).intValue();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      d(paramLong);
    }
  }
  
  public int b(long paramLong)
  {
    if (c(paramLong)) {
      return 0;
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdRefreshReportManager
 * JD-Core Version:    0.7.0.1
 */