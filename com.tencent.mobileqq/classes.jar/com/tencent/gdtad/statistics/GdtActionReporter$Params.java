package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtActionReporter$Params
{
  public Ad a;
  public landing_page_collect_data.LandingPageCollectData b = new landing_page_collect_data.LandingPageCollectData();
  
  public boolean a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!TextUtils.isEmpty(((Ad)localObject).getUrlForAction())) && (!TextUtils.isEmpty(this.a.getTraceId())))
    {
      localObject = this.b;
      if ((localObject != null) && (((landing_page_collect_data.LandingPageCollectData)localObject).landing_page_action_type.has())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter.Params
 * JD-Core Version:    0.7.0.1
 */