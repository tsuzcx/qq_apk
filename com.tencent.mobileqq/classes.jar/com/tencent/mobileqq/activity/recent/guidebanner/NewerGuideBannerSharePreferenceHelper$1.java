package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.MobileQQ;

final class NewerGuideBannerSharePreferenceHelper$1
  implements NewerGuideBannerSharePreferenceHelper
{
  public void a(String paramString)
  {
    BaseSharedPreUtil.a(MobileQQ.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(0L));
  }
  
  public void b(String paramString)
  {
    BaseSharedPreUtil.a(MobileQQ.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(System.currentTimeMillis()));
  }
  
  public long c(String paramString)
  {
    return ((Long)BaseSharedPreUtil.b(MobileQQ.getContext(), paramString, "key_newer_guide_banner_close_time", Long.valueOf(0L))).longValue();
  }
  
  public String d(String paramString)
  {
    return (String)BaseSharedPreUtil.b(MobileQQ.getContext(), paramString, "newer_guide_banner_last_preload_time", "");
  }
  
  public void e(String paramString)
  {
    BaseSharedPreUtil.a(MobileQQ.getContext(), paramString, true, "newer_guide_banner_last_preload_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).format(new Date()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerSharePreferenceHelper.1
 * JD-Core Version:    0.7.0.1
 */