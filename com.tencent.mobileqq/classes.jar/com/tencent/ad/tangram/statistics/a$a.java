package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import java.lang.ref.WeakReference;

public class a$a
{
  public Ad ad;
  public WeakReference<Context> context;
  public landing_page_collect_data.LandingPageCollectData data = new landing_page_collect_data.LandingPageCollectData();
  
  public boolean isValid()
  {
    return (this.ad != null) && (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (this.data != null) && (this.data.landing_page_action_type != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.a.a
 * JD-Core Version:    0.7.0.1
 */