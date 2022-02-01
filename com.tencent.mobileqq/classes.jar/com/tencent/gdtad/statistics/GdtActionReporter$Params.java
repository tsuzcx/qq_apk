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
    Object localObject = this.jdField_a_of_type_ComTencentAdTangramAd;
    if ((localObject != null) && (!TextUtils.isEmpty(((Ad)localObject).getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAdTangramAd.getTraceId())))
    {
      localObject = this.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData;
      if ((localObject != null) && (((landing_page_collect_data.LandingPageCollectData)localObject).landing_page_action_type.has())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter.Params
 * JD-Core Version:    0.7.0.1
 */