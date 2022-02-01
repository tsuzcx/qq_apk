package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ReadInJoyAdSettingUtil
{
  public static void a()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "allow_ad_request", "Y");
  }
  
  public static void b()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "allow_ad_request", "N");
  }
  
  public static boolean c()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "allow_ad_request").equalsIgnoreCase("Y");
  }
  
  public static void d()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "super_mask_switch", "Y");
  }
  
  public static void e()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "super_mask_switch", "N");
  }
  
  public static boolean f()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "super_mask_switch").equalsIgnoreCase("Y");
  }
  
  public static void g()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "round_download_style_switch", "Y");
  }
  
  public static void h()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "round_download_style_switch", "N");
  }
  
  public static boolean i()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "round_download_style_switch").equalsIgnoreCase("Y");
  }
  
  public static void j()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "filter_patch_ad_req", "Y");
  }
  
  public static void k()
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "filter_patch_ad_req", "N");
  }
  
  public static boolean l()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "filter_patch_ad_req").equalsIgnoreCase("Y");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSettingUtil
 * JD-Core Version:    0.7.0.1
 */