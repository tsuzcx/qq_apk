package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtDeviceDemoFragment$3
  implements View.OnClickListener
{
  GdtDeviceDemoFragment$3(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdLocation localAdLocation = GdtDeviceDemoFragment.a(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram"));
    GdtDeviceDemoFragment.a(this.a, String.format("getLocationCacheOnCurrentProcess %s", new Object[] { localAdLocation }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.3
 * JD-Core Version:    0.7.0.1
 */