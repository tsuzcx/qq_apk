package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseBannerFragment$2
  implements View.OnClickListener
{
  GdtBaseBannerFragment$2(GdtBaseBannerFragment paramGdtBaseBannerFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b() == null) {
      Toast.makeText(this.a.getBaseActivity().getApplicationContext(), "error", 0).show();
    } else if (!this.a.b().isLoaded()) {
      Toast.makeText(this.a.getBaseActivity().getApplicationContext(), "ad is not loaded", 0).show();
    } else if (this.a.b().isInvalidated()) {
      Toast.makeText(this.a.getBaseActivity().getApplicationContext(), "ad is invalidated", 0).show();
    } else {
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBaseBannerFragment.2
 * JD-Core Version:    0.7.0.1
 */