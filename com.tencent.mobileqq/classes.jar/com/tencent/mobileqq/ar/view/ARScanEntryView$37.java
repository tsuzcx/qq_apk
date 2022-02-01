package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ButtonClickListener;
import com.tencent.mobileqq.olympic.activity.PromotionRes;

class ARScanEntryView$37
  implements ARTipsManager.ButtonClickListener
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView, ScanEntryResourceDelegate paramScanEntryResourceDelegate, PromotionRes paramPromotionRes) {}
  
  public void a()
  {
    ARScanEntryView.h(this.c, false);
    this.c.d("ClickTips");
    ARScanEntryView.i(this.c, true);
    ARScanEntryView.d(this.c).postDelayed(new ARScanEntryView.37.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */