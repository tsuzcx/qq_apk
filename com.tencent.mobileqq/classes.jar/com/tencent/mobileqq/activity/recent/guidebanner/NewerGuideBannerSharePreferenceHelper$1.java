package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class NewerGuideBannerSharePreferenceHelper$1
  implements NewerGuideBannerSharePreferenceHelper
{
  public long a(String paramString)
  {
    return ((Long)SharedPreUtils.b(BaseApplicationImpl.getContext(), paramString, "key_newer_guide_banner_close_time", Long.valueOf(0L))).longValue();
  }
  
  public String a(String paramString)
  {
    return (String)SharedPreUtils.b(BaseApplicationImpl.getContext(), paramString, "newer_guide_banner_last_preload_time", "");
  }
  
  public void a(String paramString)
  {
    SharedPreUtils.a(BaseApplicationImpl.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(0L));
  }
  
  public void b(String paramString)
  {
    SharedPreUtils.a(BaseApplicationImpl.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(System.currentTimeMillis()));
  }
  
  public void c(String paramString)
  {
    SharedPreUtils.a(BaseApplicationImpl.getContext(), paramString, true, "newer_guide_banner_last_preload_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).format(new Date()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerSharePreferenceHelper.1
 * JD-Core Version:    0.7.0.1
 */