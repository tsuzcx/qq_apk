package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtDeviceDemoFragment$1
  implements View.OnClickListener
{
  GdtDeviceDemoFragment$1(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdThreadManager.INSTANCE.post(new GdtDeviceDemoFragment.1.1(this), 3);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1
 * JD-Core Version:    0.7.0.1
 */