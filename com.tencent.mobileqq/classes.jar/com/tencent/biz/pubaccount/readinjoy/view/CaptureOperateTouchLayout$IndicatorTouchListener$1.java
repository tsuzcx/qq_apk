package com.tencent.biz.pubaccount.readinjoy.view;

import android.widget.Scroller;
import rpc;
import rpd;

public class CaptureOperateTouchLayout$IndicatorTouchListener$1
  implements Runnable
{
  public CaptureOperateTouchLayout$IndicatorTouchListener$1(rpd paramrpd) {}
  
  public void run()
  {
    CaptureOperateTouchLayout.a(this.a.a, true);
    CaptureOperateTouchLayout.a(this.a.a).abortAnimation();
    rpd.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout.IndicatorTouchListener.1
 * JD-Core Version:    0.7.0.1
 */