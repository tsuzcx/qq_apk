package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import java.lang.ref.WeakReference;

public class b$a
{
  public Ad ad;
  public WeakReference<Context> context;
  public landing_page_collect_data.LandingPageCollectData data = new landing_page_collect_data.LandingPageCollectData();
  
  public boolean isValid()
  {
    if (this.ad != null)
    {
      Object localObject = this.context;
      if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getTraceId())))
      {
        localObject = this.data;
        if ((localObject != null) && (((landing_page_collect_data.LandingPageCollectData)localObject).landing_page_action_type != 0)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.b.a
 * JD-Core Version:    0.7.0.1
 */