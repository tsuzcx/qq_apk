package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtDeviceDemoFragment$2
  implements View.OnClickListener
{
  GdtDeviceDemoFragment$2(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdLocation localAdLocation = AdLocationManager.INSTANCE.getLocationCache(this.a.getBaseActivity());
    GdtDeviceDemoFragment.a(this.a, String.format("getLocationCache %s", new Object[] { localAdLocation }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.2
 * JD-Core Version:    0.7.0.1
 */