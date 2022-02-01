package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtDeviceDemoFragment$4
  implements View.OnClickListener
{
  GdtDeviceDemoFragment$4(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    GdtDeviceDemoFragment.a(this.a, "LbsManagerService.startLocation start");
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new GdtDeviceDemoFragment.4.1(this, "gdt_tangram", true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.4
 * JD-Core Version:    0.7.0.1
 */