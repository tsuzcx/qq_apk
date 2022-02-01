package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.views.GdtUIUtils;

class GdtBannerFragmentForJS$1
  implements Runnable
{
  GdtBannerFragmentForJS$1(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  public void run()
  {
    try
    {
      int i = GdtUIUtils.a(300.0F, this.this$0.getResources());
      int j = GdtBannerViewBuilder.b(GdtBannerFragmentForJS.a(this.this$0).c, i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
      localLayoutParams.gravity = 1;
      localLayoutParams.topMargin = 100;
      localLayoutParams.bottomMargin = 100;
      GdtBannerFragmentForJS.b(this.this$0).getView().setLayoutParams(localLayoutParams);
      GdtBannerFragmentForJS.b(this.this$0).setSize(i, j);
      this.this$0.a.invalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS.1
 * JD-Core Version:    0.7.0.1
 */