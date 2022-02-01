package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtActionReporter$Params
{
  public Ad a;
  public landing_page_collect_data.LandingPageCollectData a;
  
  public GdtActionReporter$Params()
  {
    this.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData = new landing_page_collect_data.LandingPageCollectData();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAdTangramAd != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAdTangramAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAdTangramAd.getTraceId())) && (this.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData != null) && (this.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.has());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter.Params
 * JD-Core Version:    0.7.0.1
 */