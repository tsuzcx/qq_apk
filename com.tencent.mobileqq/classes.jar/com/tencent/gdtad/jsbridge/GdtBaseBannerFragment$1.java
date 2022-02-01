package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseBannerFragment$1
  implements View.OnClickListener
{
  GdtBaseBannerFragment$1(GdtBaseBannerFragment paramGdtBaseBannerFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.a.a() != null) {
      bool = this.a.a().load(this.a.getBaseActivity());
    } else {
      bool = false;
    }
    String str;
    if (bool) {
      str = "loading ad data";
    } else {
      str = "load ad data error";
    }
    Toast.makeText(this.a.getBaseActivity().getApplicationContext(), str, 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBaseBannerFragment.1
 * JD-Core Version:    0.7.0.1
 */