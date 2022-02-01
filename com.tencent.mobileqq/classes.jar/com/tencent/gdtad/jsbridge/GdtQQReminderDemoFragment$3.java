package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtQQReminderDemoFragment$3
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$3(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdAppPreOrderManager.INSTANCE.init(this.a.getActivity().getApplicationContext(), AdUin.INSTANCE.getUIN());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.3
 * JD-Core Version:    0.7.0.1
 */