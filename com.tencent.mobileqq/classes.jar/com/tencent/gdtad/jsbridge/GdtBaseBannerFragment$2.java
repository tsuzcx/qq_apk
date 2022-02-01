package com.tencent.gdtad.jsbridge;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseBannerFragment$2
  implements View.OnClickListener
{
  GdtBaseBannerFragment$2(GdtBaseBannerFragment paramGdtBaseBannerFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() == null) {
      Toast.makeText(this.a.getActivity().getApplicationContext(), "error", 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.a.a().isLoaded()) {
        Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
      } else if (this.a.a().isInvalidated()) {
        Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is invalidated", 0).show();
      } else {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBaseBannerFragment.2
 * JD-Core Version:    0.7.0.1
 */