package com.tencent.gdtad.jsbridge;

import ablu;
import ablv;
import ablw;
import absw;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class GdtBannerFragmentForJS$1
  implements Runnable
{
  GdtBannerFragmentForJS$1(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  public void run()
  {
    int i = absw.a(300.0F, this.this$0.getResources());
    int j = ablw.a(GdtBannerFragmentForJS.a(this.this$0).a, i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    GdtBannerFragmentForJS.a(this.this$0).a().setLayoutParams(localLayoutParams);
    GdtBannerFragmentForJS.a(this.this$0).setSize(i, j);
    this.this$0.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS.1
 * JD-Core Version:    0.7.0.1
 */