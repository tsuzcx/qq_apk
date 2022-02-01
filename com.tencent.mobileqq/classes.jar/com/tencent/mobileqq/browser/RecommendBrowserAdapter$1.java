package com.tencent.mobileqq.browser;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecommendBrowserAdapter$1
  implements View.OnClickListener
{
  RecommendBrowserAdapter$1(RecommendBrowserAdapter paramRecommendBrowserAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = RecommendBrowserAdapter.a(this.b);
    int j = this.a;
    if (i != j)
    {
      RecommendBrowserAdapter.a(this.b, j);
      this.b.notifyDataSetChanged();
    }
    ReportHelperKt.a("0X800ADEB");
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { "[action] bindItemClickListener: invoked. ", " position: ", Integer.valueOf(this.a) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.browser.RecommendBrowserAdapter.1
 * JD-Core Version:    0.7.0.1
 */